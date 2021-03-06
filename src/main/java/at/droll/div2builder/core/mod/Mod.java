package at.droll.div2builder.core.mod;

import java.util.HashMap;
import java.util.Map;

import at.droll.div2builder.core.attribute.*;
import at.droll.div2builder.core.item.Buildable;

/**
 * Mod class. Differ between two variants: Equipment and weapon mods
 * @author Marco Droll
 */
public class Mod extends AttributeAbstract implements Buildable {
	
	/**
	 * Holds the required specialization for the mod
	 */
	private String requiredSpecialization;
	
	/**
	 * Holds if the mod is exotic
	 */
	private boolean isExotic = false;

	/**
	 * Holds the slot of the mod
	 */
	private Modslot slot;
	
	/**
	 * Holds the id of the mod
	 */
	private String id;
	
	
	/**
	 * Constructor for weapon mods
	 * 
	 * @param id Id of the mod in the sqlite database
	 * @param slot The kind of mod slot
	 * @param name The name of the item	 *  
	 * @param firstAttribute The first attribute of the mod
	 * @param firstAttributeValue The first attribtue value of the mod
	 * @param secondAttribute The second attribtue of the mod
	 * @param secondAttributeValue The second attribute value of the mod
	 * @param requiredSpecialization Is a specialiaztion requierd
	 * @param exotic Is a exotic item i.e. exotic weapon mod
	 */
	public Mod (
			String id,
			Modslot slot,
			String name,
			Attribute firstAttribute,
			double firstAttributeValue,
			Attribute secondAttribute,
			double secondAttributeValue,
			String requiredSpecialization,
			int exotic
	) {
		try {
			this.setId(id);
			this.setSlot(slot);
			this.setName(name);
			this.setFirst(firstAttribute, firstAttributeValue);
			this.setSecond(secondAttribute, secondAttributeValue);
			this.setRequiredSpecialization(requiredSpecialization);
			this.setExotic(exotic == 1 ? true : false);			
		} catch(AttributeException e) {
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Constructor for equipment mods
	 * 
	 * @param id The id from the sqlite database
	 * @param name The name of the mod
	 * @param attribute The attribute of the mod
	 * @param value The value of the attribute
	 */
	public Mod(String id, String name, Attribute attribute, double value) {
		try {
			switch(attribute) {
				default:
				case CRITICALHITCHANCE:
				case CRITICALHITDAMAGE:
				case HEADSHOTDAMAGE:
					this.setCore(Attribute.WEAPONDAMAGE, 0.0);
					break;				
				case SKILLDAMAGE:
				case SKILLHASTE:
				case REPAIRSKILLS:
					this.setCore(Attribute.SKILLTIER, 0.0);
					break;
				case RESISTANCEBLEED:
				case RESISTANCEBLIND:
				case RESISTANCEDESORIENT:
				case RESISTANCEDISRUPT:
				case RESISTANCEENSNARE:
				case RESISTANCESHOCK:
				case PROTECTIONFROMELITES:
				case ARMORONKILL:
					this.setCore(Attribute.ARMOR, 0);
					break;
			}
			this.setId(id);
			this.setName(name);
			this.setFirst(attribute, value);
			this.setSlot(Modslot.EQUIPMENT);
			
		} catch(AttributeException e) {			
		}
	}

	/**
	 * Returns if a specialiation is required
	 * @return The requiredSpecialization
	 */
	public String getRequiredSpecialization() {
		return requiredSpecialization;
	}

	/**
	 * Sets if a specialization is required
	 * @param requiredSpecialization the requiredSpecialization to set
	 */
	public void setRequiredSpecialization(String requiredSpecialization) {
		this.requiredSpecialization = requiredSpecialization;
	}

	/**
	 * Returns if its a exotic mod
	 * @return the isExotic
	 */
	public boolean isExotic() {
		return isExotic;
	}

	/**
	 * Set if its a exotic mod
	 * @param isExotic the isExotic to set
	 */
	public void setExotic(boolean isExotic) {
		this.isExotic = isExotic;
	}

	/**
	 * Gets the slot
	 * @return the slot
	 */
	public Modslot getSlot() {
		return slot;
	}	

	/**
	 * Setter for the slot
	 * @param slot the slot to set
	 * @see Modslot
	 */
	public void setSlot(Modslot slot) {
		this.slot = slot;
	}
	
	/**
	 * Setter for the id
	 * @param id Id of the mod
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Getter for the id
	 * @return Returns the id
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Return all Attribute and Values of the item as a hash map
	 */
	public Map<Attribute, Double> getAttributesAndValues() {
		Map<Attribute, Double> map = new HashMap<>();
		map.put(getFirstAttribute(), getFirstAttributeValue());
		map.put(getSecondAttribute(), getSecondAttributeValue());		
		return map;
	}
	
	@Override
	public String toString() {
		return "Mod [requiredSpecialization=" + requiredSpecialization + ", isExotic=" + isExotic + ", slot=" + slot
				+ ", id=" + id + ", getCoreAttribute()=" + getCoreAttribute() + ", getFirstAttribute()="
				+ getFirstAttribute() + ", getCoreAttributeValue()=" + getCoreAttributeValue()
				+ ", getFirstAttributeValue()=" + getFirstAttributeValue() + "]";
	}
	
}
