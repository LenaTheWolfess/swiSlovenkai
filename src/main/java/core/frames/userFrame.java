/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.frames;

import core.db.HibernateUtil;
import core.db.entity.User;
import core.db.entity.Bank;
import core.db.entity.BankCondition;
import core.db.entity.Condition;
import core.db.impl.BankConditionDaoImpl;
import core.db.impl.BankDaoImpl;
import core.db.impl.ConditionDaoImpl;
import core.db.impl.UserDaoImpl;
import core.db.ints.BankConditionDao;
import core.db.ints.BankDao;
import core.db.ints.ConditionDao;
import core.db.ints.UserDao;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Rastislav, Martin
 */
public class userFrame extends javax.swing.JFrame
{

					private static BankDao bankDao = new BankDaoImpl();
					private BankConditionDao bankConditionDao = new BankConditionDaoImpl();
					private ConditionDao conditionDao = new ConditionDaoImpl();

					private User user;

					public void inicializujTabulku()
					{

					}

					private void vyhladajBanky(int pocetRokov, double suma)
					{
										Map<Bank, Double> result = new HashMap<Bank, Double>();
										List<Bank> banky = bankDao.getAll();
										Long userId = user.getId();

										Session session = HibernateUtil.getSessionFactory().openSession();

										for(Bank banka : banky)
										{
															result.put(banka, banka.getPrimeInterestRate());
															double minusRate = 0.0;
															List<BankCondition> bankConditions = bankConditionDao.getByBankId(banka.getId());
															for(BankCondition bc : bankConditions)
															{
																				Condition condition = conditionDao.getById(bc.getIdC());

																				String expression = condition.getExpression();

																				int mark = bc.getMark().intValue();
																				String markString = "";

																				Query query = null;

																				expression = expression;
																				query = session.createSQLQuery(expression).setParameter(0, userId).setParameter(1, suma);

																				if(query == null)
																				{
																									continue;
																				}
																				System.out.println(query.toString());
																			
																				try
																				{
																										List<Object> answer = query.list();
																								
																									int value = bc.getValue();
																									boolean ok = false;
																									System.out.println();
																									for(Object ans : answer)
																									{
																														if(ans == null)
																														{
																																			continue;
																														}
																														double in = 0;
																														if(ans instanceof BigInteger)
																														{
																																			BigInteger a = (BigInteger) ans;
																																			in = a.doubleValue();
																														}else
																														if(ans instanceof Double)
																														{
																																			in = (double) ans;
																														}else
																														if(ans instanceof Long)
																														{
																																			Long a = (Long) ans;
																																			in = a.doubleValue();
																														}
																														else
																														if(ans instanceof String)
																														{
																																			String ax = (String)ans;
																																			try{
																																			in = Double.parseDouble(ax);
																																			}
																																			catch(NumberFormatException e)
																																			{
																																									System.out.println("STRING -> DOUBLE PARSE ERROR String="+ax);
																																			}
																														}
																														else
																														if(ans instanceof BigDecimal)
																														{
																																		 BigDecimal a = (BigDecimal)ans;
																																			in = a.doubleValue();
																														}
																														else
																														{
																																			System.out.println("ZIADNE PRIRADENIE ");
																																			System.out.println(""+ans.getClass().getName());
																														}
																														
																														System.out.println("ANSWER "+in);
																														
																														switch(mark)
																														{
																																			case 0:
																																								markString = " = ";
																																								if(in == value)
																																													ok = true;
																																								break;
																																			case 1:
																																								markString = " >= ";
																																								if(in > value || in == value)
																																													ok = true;
																																								break;
																																			case 2:
																																								markString = " > ";
																																								if(in > value && in != value)
																																													ok = true;
																																								break;
																																			case -1:
																																								markString = " <= ";
																																								if(in <= value)
																																													ok = true;
																																								break;
																																			case -2:
																																								markString = " < ";
																																								if(in < value && in != value)
																																													ok = true;
																																								break;
																																			default:
																																								break;
																														} // siwtch
																														if(ok)
																														{
																																			minusRate = minusRate + bc.getChangeInterestRate();
																																			System.out.println("User " + this.user.getId() + " Banka " + banka.getId() + banka.getName() + " splnena podmienka " + "result = " + in +" "+markString+" "+value+ " popis " + condition.getDescription() + " minusRate " + minusRate);

																														}
																														else
																														{
																																			System.out.println("User " + this.user.getId() + " Banka " + banka.getId() + " NESPLNENA podmienka " + "result = " + in +" "+markString+" "+value+ " popis " + condition.getDescription() + " minusRate " + minusRate);

																														}
																														break;
																									} // for answer
																				}
																				catch(Exception e)
																				{
																									e.printStackTrace();
																									System.err.println("EXCEPTION User " + this.user.getId() + " Banka " + banka.getId() + " NESPLNENA podmienka " + "result = NULL" + "popis " + condition.getDescription() + " minusRate " + minusRate);

																				}

															} // for bankCondition
															System.out.println("User " + this.user.getId() + " Banka " + banka.getId() + " urok " + (banka.getPrimeInterestRate() + minusRate));
															result.put(banka, (banka.getPrimeInterestRate() + minusRate));
										} // for bank
										System.out.println("RESULTS");
										for(Bank bank : result.keySet())
										{
															System.out.println("Banka " + bank.getName() + " " + result.get(bank).doubleValue());
										}

										session.close();

										DefaultTableModel tableModel = (DefaultTableModel) ponukyTable.getModel();
										ponukyTable.removeAll();
										tableModel.setNumRows(result.size());

										class Result
										{

															private Long idB;
															private String name;
															private double rating;
															private double mesSplatka;

															private BigDecimal zaplatenaSuma;

															public Result(Long idB, String name, double rating)
															{
																				this.idB = idB;
																				this.rating = rating;
																				this.name = name;
																				this.zaplatenaSuma = new BigDecimal(0);
																				this.mesSplatka = 0;
															}

															public void pocitaj(double suma, int pocetRokov)
															{
																				/*mesacna urokova sadzba*/
																				double mus = rating / 100.0;

																				int pocetMesiacov = pocetRokov * 12;

																				/*vyska splatky*/
																				double exp = Math.pow((mus + 1), pocetMesiacov);
																				double splatka = ((suma * mus * (exp)) / (exp - 1));

																				this.mesSplatka = splatka;
																			BigDecimal celkomZaplatene = new BigDecimal(splatka);
																			celkomZaplatene = celkomZaplatene.multiply(new BigDecimal(pocetMesiacov));
																			
																			/*
																				BigDecimal trebaSplatit = new BigDecimal(suma);
																				System.out.println("");
																				System.out.println("Suma = " + suma + " splatka = " + splatka + "pocetRokov = " + pocetRokov+" mus = "+mus);
																				
																				for(int mesiac = 0; mesiac < pocetMesiacov; mesiac++)
																				{
																									BigDecimal pred = trebaSplatit;
																									BigDecimal urok = pred.multiply(new BigDecimal(mus));
																									BigDecimal po = pred.add(urok);
																									BigDecimal spl  = new BigDecimal(splatka);
																									spl = spl.negate();
																									po=po.add(spl);
																									celkomZaplatene = celkomZaplatene.add(new BigDecimal(splatka));
																									trebaSplatit = po;
																									trebaSplatit = trebaSplatit.setScale(2, BigDecimal.ROUND_HALF_EVEN);
																						//			System.out.println("splatka = "+spl.toString());
																						//			System.out.println(" pred = " + pred.toString() + " urok = " + urok.toString() + " po = " + po.toString());
																				}
																				
																				System.out.println(" KONIEC  : trebaZaplatit(chyba poctu)  = " + trebaSplatit.toString() + " zaplatenaSuma = " + celkomZaplatene.toString());
																				*/
																				this.zaplatenaSuma = this.zaplatenaSuma.add(celkomZaplatene);
															}

															public double getMesSplatka()
															{
																				return mesSplatka;
															}

															public Long getIdB()
															{
																				return idB;
															}

															public double getRating()
															{
																				return rating;
															}

															public String getName()
															{
																				return name;
															}

															public BigDecimal getZaplatenaSuma()
															{
																				zaplatenaSuma = zaplatenaSuma.setScale(2, BigDecimal.ROUND_HALF_EVEN);
																				return zaplatenaSuma;
															}
										}
										List<Result> listResults = new ArrayList<>();
										for(Bank bank : result.keySet())
										{
															listResults.add(new Result(bank.getId(), bank.getName(), result.get(bank)));
										}

										for(Result bank : listResults)
										{
															bank.pocitaj(suma, pocetRokov);
										}
										
										listResults.sort(new Comparator<Result>()
										{

															@Override
															public int compare(Result o1, Result o2)
															{
																				return Double.compare(o1.getRating(), o2.getRating());
															}
										});
										
										int i = 0;
										for(Result bank : listResults)
										{

															String meno = bank.getName();
															Double rating = bank.getRating();
															BigDecimal zaplatenaSuma = bank.getZaplatenaSuma();
															Double mesSplatka = bank.getMesSplatka();
															Object[] data =
															{
																				meno, rating, zaplatenaSuma,mesSplatka
															};
															tableModel.setValueAt(meno, i, 0);
															tableModel.setValueAt(rating, i, 1);
															tableModel.setValueAt(zaplatenaSuma, i, 2);
																	tableModel.setValueAt(mesSplatka, i, 3);
															i++;
										}
					}

					/**
					 * Creates new form userFrame
					 */
					public userFrame(User user)
					{
										initComponents();
										this.user = user;
										//inicializujTabulku();
					}

					/**
					 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
					 */
					@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents()
     {

          pocetRokovLabel = new javax.swing.JLabel();
          jScrollPane1 = new javax.swing.JScrollPane();
          ponukyTable = new javax.swing.JTable();
          sumaLabel = new javax.swing.JLabel();
          userSumaText = new javax.swing.JTextField();
          vyhladajButton = new javax.swing.JButton();
          userPocetRokov = new javax.swing.JTextField();

          pocetRokovLabel.setText("Počet rokov");

          ponukyTable.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][]
               {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
               },
               new String []
               {
                    "Banka", "Urok","Zaplatena suma","splatka"
               }
          )
          {
               Class[] types = new Class []
               {
                    java.lang.Integer.class, java.lang.String.class, java.math.BigDecimal.class,java.lang.Double.class
               };

               public Class getColumnClass(int columnIndex)
               {
                    return types [columnIndex];
               }
          });
          jScrollPane1.setViewportView(ponukyTable);

          sumaLabel.setText("Suma");

          vyhladajButton.setText("Vyhľadať");
          vyhladajButton.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    vyhladajButtonActionPerformed(evt);
               }
          });

          userPocetRokov.setText("1");

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                         .addComponent(vyhladajButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
                         .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(pocetRokovLabel)
                                   .addComponent(sumaLabel))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(userSumaText)
                                   .addComponent(userPocetRokov))))
                    .addContainerGap())
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(pocetRokovLabel)
                         .addComponent(userPocetRokov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(userSumaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(sumaLabel))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(vyhladajButton)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

    private void vyhladajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vyhladajButtonActionPerformed
									String pocetRokovText = userPocetRokov.getText();
									String sumaText = userSumaText.getText();

									if(pocetRokovText == null || sumaText == null)
									{
														return;
									}
									if(pocetRokovText.trim().isEmpty() || sumaText.trim().isEmpty())
									{
														return;
									}
									try
									{
														int pocetRokov = Integer.parseInt(pocetRokovText);
														double suma = Double.parseDouble(sumaText);
														vyhladajBanky(pocetRokov, suma);
									}
									catch(NumberFormatException e)
									{
														return;
									}

    }//GEN-LAST:event_vyhladajButtonActionPerformed


     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JLabel pocetRokovLabel;
     private javax.swing.JTable ponukyTable;
     private javax.swing.JLabel sumaLabel;
     private javax.swing.JTextField userPocetRokov;
     private javax.swing.JTextField userSumaText;
     private javax.swing.JButton vyhladajButton;
     // End of variables declaration//GEN-END:variables
}
