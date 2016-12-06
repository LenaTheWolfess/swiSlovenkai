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
public class Mark
{
								private Long id;
								private String text;
								private String popis;

					public Mark(Long id, String text)
					{
										this.id = id;
										this.text = text;
										this.popis = popis;
					}

					public Long getId()
					{
										return id;
					}

					public String getText()
					{
										return text;
					}

					@Override
					public String toString()
					{
										return text;
					}
							
						
}
