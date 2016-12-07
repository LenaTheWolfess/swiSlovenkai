/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.db.entity;

/**
 *
 * @author Slavomír
 */
public class DescriptedBankCondition
{
					private BankCondition bankCondition;
					private Condition condition;
					
					public DescriptedBankCondition(BankCondition bankCondition, Condition condition)
					{
										this.bankCondition= bankCondition;
										this.condition = condition;
					}

					public BankCondition getBankCondition()
					{
										return bankCondition;
					}

					public Condition getCondition()
					{
										return condition;
					}
					
					@Override
					public String toString()
					{
										return condition.toString() + bankCondition.toString();
					}					
					
}
