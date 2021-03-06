package at.droll.div2builder.core.inventory;

import at.droll.div2builder.core.Manufacturer;
import at.droll.div2builder.core.Talent;
import at.droll.div2builder.core.TalentWeapon;
import at.droll.div2builder.core.World;
import at.droll.div2builder.core.attribute.Attribute;
import at.droll.div2builder.core.attribute.AttributeException;
import at.droll.div2builder.core.item.ItemAbstract;
import at.droll.div2builder.core.item.equipment.Equipment;
import at.droll.div2builder.core.item.weapon.Weapon;
import at.droll.div2builder.core.mod.Mod;
import at.droll.div2builder.core.mod.ModException;
import javafx.scene.control.Spinner;
import javafx.scene.control.Label;

/**
 * Represents the inventory
 * 
 * @author Marco Droll
 */
public class Inventory implements Equipmentable {
	
	/**
	 * 
	 */
	public final static String[] slotList = {"ARMOR", "BACKPACK", "GLOVE", "MASK", "HOLSTER", "KNEEPAD",
											 "PRIMARY", "SECONDARY", "PISTOL"
	};
	
	/**
	 * Holds the primary weapon
	 */
	private ItemAbstract primary;
	
	/**
	 * Holds the secondary weapon
	 */
	private ItemAbstract secondary;
	
	/**
	 * Holds the pistol
	 */
	private ItemAbstract pistol;
	
	/**
	 * Holds the mask equipment
	 */
	private ItemAbstract mask;
	
	/**
	 * Holds the body equipment
	 */
	private ItemAbstract body;
	
	/**
	 * Holds the armor equipment
	 */
	private ItemAbstract armor;
	
	/**
	 * Holds the backpack equipment
	 */
	private ItemAbstract backpack;
	
	/**
	 * Holds the kneepad equipment
	 */
	private ItemAbstract kneepad;
	
	/**
	 * Holds the glove equipment
	 */
	private ItemAbstract glove;
	
	/**
	 * Holds the holser equipemnt
	 */
	private ItemAbstract holster;

	/**
	 * Return the appropirates equipment to the specific slot
	 * @param slot Give the enum InventorySlot to return the specific equipment
	 * @return AttributeAbstract
	 */
	public ItemAbstract getEquipment(InventorySlot slot) {
		switch(slot) {
			case ARMOR:
				return this.armor;			
			case BACKPACK:
				return this.backpack;			
			case MASK:
				return this.mask;			
			case GLOVE:
				return this.glove;			
			case HOLSTER:
				return this.holster;			
			case KNEEPAD:
				return this.kneepad;			
			case PRIMARY:
				return this.primary;			
			case SECONDARY:
				return this.secondary;			
			case PISTOL:
				return this.pistol;
			default:
				return null;
		}
	}
		
	
	/**
	 * Add to the specific slot the specific item
	 * @param slot The slot where something should be add
	 * @param item The item itself
	 * @return Inventory
	 * @see InventorySlot
	 * @see ItemAbstract
	 */
	@Override
	public Inventory addEquipment(InventorySlot slot, ItemAbstract item) {
		
		switch(slot) {
			case ARMOR:
				this.armor = item;
				break;
			case BACKPACK:
				this.backpack = item;
				break;
			case MASK:
				this.mask = item;
				break;
			case GLOVE:
				this.glove = item;
				break;
			case HOLSTER:
				this.holster = item;
				break;
			case KNEEPAD:
				this.kneepad = item;
				break;
			case PRIMARY:
				this.primary = item;
				break;
			case SECONDARY:
				this.secondary = item;
				break;
			case PISTOL:
				this.pistol = item;
				break;
		}		
		
		return this;
	}
	
	/**
	 * Remove from the specific slot the item
	 * @param slot Inventory slot to remove the item from
	 * @return Returns true if the item could be removed
	 */
	@Override
	public boolean removeEquipment(InventorySlot slot) {
		switch(slot) {
			case ARMOR:
				this.armor = null;
				break;
			case BACKPACK:
				this.backpack = null;
				break;
			case MASK:
				this.mask = null;
				break;
			case GLOVE:
				this.glove = null;
				break;
			case HOLSTER:
				this.holster = null;
				break;
			case KNEEPAD:
				this.kneepad = null;
				break;
			case PRIMARY:
				this.primary = null;
				break;
			case SECONDARY:
				this.secondary = null;
				break;
			case PISTOL:
				this.pistol = null;
				break;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "Inventory [primary=" + primary + ", secondary=" + secondary + ", pistol=" + pistol + ", mask=" + mask
				+ ", body=" + body + ", armor=" + armor + ", backpack=" + backpack + ", kneepad=" + kneepad + ", glove="
				+ glove + ", holster=" + holster + "]";
	}
	
	/**
	 * Create a mockup inventory to testing the statistic data in the first implementation test and inside the
	 * unit tests
	 * @return inventory
	 */
	public Inventory createMockupInventory() {
		try {			
			Equipment mask = (Equipment) new Equipment.Builder().setManufacturer(Manufacturer.CESKA)
												                .setSlot(InventorySlot.MASK)
												                .setCore(Attribute.WEAPONDAMAGE, 15.0)
												                .setFirst(Attribute.CRITICALHITCHANCE, 6.0)
												                .setSecond(Attribute.CRITICALHITDAMAGE, 12.0)
												                .addMod((Mod)World.Registry.get("mod", "CRITICALHITDAMAGE"))
												                .build()
		    ;			
			
			Equipment armor = (Equipment) World.Registry.get("equipment", Equipment.THESACRIFICE)
														.setCore(Attribute.WEAPONDAMAGE, 15.0)
														.setFirst(Attribute.CRITICALHITCHANCE, 6.0)											
														.setSecond(Attribute.CRITICALHITDAMAGE, 12.0)
														.addMod((Mod)World.Registry.get("mod", "CRITICALHITDAMAGE"))
			;

			Equipment backpack = (Equipment) new Equipment.Builder().setManufacturer(Manufacturer.PROVIDENCE)
														   .setSlot(InventorySlot.BACKPACK)
														   .setCore(Attribute.WEAPONDAMAGE, 15.0)
														   .setFirst(Attribute.CRITICALHITCHANCE, 6.0)
														   .setSecond(Attribute.CRITICALHITDAMAGE, 12.0)
														   .setTalent(Talent.VIGILIANCE)
														   .addMod((Mod)World.Registry.get("mod", "CRITICALHITDAMAGE"))
			;
					
			Equipment kneepad = (Equipment) World.Registry.get("equipment", Equipment.FOXSPRAYER)
														  .setCore(Attribute.WEAPONDAMAGE, 15.0)
														  .setSecond(Attribute.CRITICALHITDAMAGE, 12.0);
			
			Equipment glove = (Equipment) new Equipment.Builder()
													   .setImprovisedItem(true)
										               .setSlot(InventorySlot.GLOVE)
										               .setCore(Attribute.WEAPONDAMAGE, 15.0)
										               .setFirst(Attribute.CRITICALHITCHANCE, 6.0)
										               .setSecond(Attribute.CRITICALHITDAMAGE, 12.0)
										               .addMod((Mod)World.Registry.get("mod", "CRITICALHITDAMAGE"))										               
										               .build();		
						
			Equipment holster = (Equipment) new Equipment.Builder().setManufacturer(Manufacturer.GRUPO)
													               .setSlot(InventorySlot.HOLSTER)
													               .setCore(Attribute.WEAPONDAMAGE, 15.0)
													               .setFirst(Attribute.CRITICALHITCHANCE, 6.0)
													               .setSecond(Attribute.CRITICALHITDAMAGE, 12.0)
													               .build();
			
			Weapon primary = (Weapon) World.Registry.get("weapon", "Classic M1A")
													 .setCore(Attribute.RIFLEDAMAGE, 15.0)
													 .setFirst(Attribute.CRITICALHITDAMAGE, 17.0)
													 .setSecond(Attribute.DAMAGETOTARGETOUTOFCOVER, 10.0)
													 .setTalent(TalentWeapon.RIFLEMEN)
													 .setModGrip((Mod) World.Registry.get("mod", "20"))
													 .setModMag((Mod) World.Registry.get("mod", "42"))
													 .setModOptics((Mod) World.Registry.get("mod", "1"))
			;		
			
			Weapon secondary = (Weapon) World.Registry.get("weapon", "Police M4")
													  .setCore(Attribute.ASSAULTRIFLEDAMAGE, 15.0)
													  .setFirst(Attribute.DAMAGETOHEALTH, 21.0)
													  .setSecond(Attribute.DAMAGETOTARGETOUTOFCOVER, 10)
													  .setTalent(TalentWeapon.FASTHANDS)
													  .setModMag((Mod) World.Registry.get("mod", "28"))
													  .setModGrip((Mod) World.Registry.get("mod", "20"))
													  .setModOptics((Mod) World.Registry.get("mod", "1"))
													  .setModMuzzle((Mod) World.Registry.get("mod", "14"))
			;
			
			Weapon pistol = (Weapon) World.Registry.get("weapon", "Orbit")
												   .setCore(Attribute.PISTOLDAMAGE, 15.0)
												   .setFirst(Attribute.NULL, 0.0)
												   .setSecond(Attribute.DAMAGETOARMOR, 6.0)
												   .setTalent(TalentWeapon.FINISHER)
												   .setModOptics((Mod) World.Registry.get("mod", "1"))
												   .setModMag((Mod) World.Registry.get("mod", "38"))
			;			
			
			return this.addEquipment(InventorySlot.MASK, mask)
					   .addEquipment(InventorySlot.ARMOR, armor)
					   .addEquipment(InventorySlot.BACKPACK, backpack)
					   .addEquipment(InventorySlot.KNEEPAD, kneepad)
					   .addEquipment(InventorySlot.GLOVE, glove)
					   .addEquipment(InventorySlot.HOLSTER, holster)
					   .addEquipment(InventorySlot.PRIMARY, primary)
					   .addEquipment(InventorySlot.SECONDARY, secondary)
					   .addEquipment(InventorySlot.PISTOL, pistol)
			;

		} catch(InventoryException | AttributeException | ModException e) {
			e.printStackTrace();	
		} return null;
	}
	
	/**
	 * Update inventory / proxy to setYIELD Method
	 * 
	 * @param spinner Spinner object
	 * @param attribute Attribute to update
	 * @param newValue New Value
	 * @return If success it returns true otherwise false
	 */
	public boolean update(Spinner<Number> spinner, String attribute, Number newValue) {
		
		Equipment equipment = null;
		Weapon weapon = null;
		
		if (spinner.getId().contains("mask")) {
			equipment = (Equipment) mask;
		} else if(spinner.getId().contains("backpack")) {
			equipment = (Equipment) backpack;
		} else if (spinner.getId().contains("armor")) {
			equipment = (Equipment) armor;
		} else if (spinner.getId().contains("glove")) {
			equipment = (Equipment) glove;
		} else if (spinner.getId().contains("holster")) {
			equipment = (Equipment) holster;
		} else if (spinner.getId().contains("primary")) {
			weapon = (Weapon) primary;
		} else if (spinner.getId().contains("secondary")) {
			weapon = (Weapon) secondary; 
		} else if (spinner.getId().contains("primary")) {
			weapon = (Weapon) pistol;
		} else {
			equipment = (Equipment)kneepad;
		}
		
		try {
			
			if (equipment != null) {
			
				if (spinner.getId().contains("Core")) {				
					equipment.setCore(Attribute.valueOf(attribute), newValue.doubleValue());
				} else if(spinner.getId().contains("First")) {
					equipment.setFirst(Attribute.valueOf(attribute), newValue.doubleValue());
				} else if(spinner.getId().contains("Second")) {
					equipment.setSecond(Attribute.valueOf(attribute), newValue.doubleValue());
				} else if(spinner.getId().contains("Third")) {
					equipment.setThird(Attribute.valueOf(attribute), newValue.doubleValue());
				} else {
					equipment.getMod().setFirstAttributeValue(newValue.doubleValue());
				}

			} else if (weapon != null) {
				
				if (spinner.getId().contains("Core")) {				
					weapon.setCore(Attribute.valueOf(attribute), newValue.doubleValue());					
				} else if(spinner.getId().contains("First")) {
					weapon.setFirst(Attribute.valueOf(attribute), newValue.doubleValue());
				} else if(spinner.getId().contains("Second")) {
					weapon.setSecond(Attribute.valueOf(attribute), newValue.doubleValue());
				} else {
				}
			}
				
			return true;
			
		} catch(AttributeException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Updating inventory / Proxy to talent
	 * 
	 * @param comboBoxId fx:id Of the combobox to determine the equipment
	 * @param newValue Label with the selected attribute from the combobox
	 * @return If success it returns true otherwise false
	 */	
	public boolean update(String comboBoxId, Label newValue) {
		
		Equipment equipment = null;
		Weapon weapon = null;
		
		if (comboBoxId.contains("backpack")) {
			equipment = (Equipment) backpack;
		} else if (comboBoxId.contains("armor")) {
			equipment = (Equipment) armor;
		} else if (comboBoxId.contains("primary")) {
			weapon = (Weapon) primary;
		} else if (comboBoxId.contains("secondary")) {
			weapon = (Weapon) secondary;
		} else if (comboBoxId.contains("pistol")) {
			weapon = (Weapon) pistol;
		} 
		
		try {
			if (equipment != null) {
				Talent talent = Talent.valueOf(newValue.getText());
				equipment.setTalent(talent);
			} else if (weapon != null) {
				TalentWeapon talent = TalentWeapon.valueOf(newValue.getText());
				weapon.setTalent(talent);
			}			
			return true;
		} catch (InventoryException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
		return false;
	}
	

	/**
	 * Updating inventory / Proxy to talent
	 * 
	 * @param comboBoxId fx:id Of the combobox to determine the equipment
	 * @param attribute Attribute as String
	 * @param newValue Label with the selected attribute from the combobox
	 * @return If success it returns true otherwise false
	 */	
	public boolean update(String comboBoxId, String attribute, Label newValue) {
		
		Equipment item;
		
		if (comboBoxId.contains("mask")) {
			item = (Equipment) mask;
		} else if(comboBoxId.contains("backpack")) {
			item = (Equipment) backpack;
		} else if (comboBoxId.contains("armor")) {
			item = (Equipment) armor;
		} else if (comboBoxId.contains("glove")) {
			item = (Equipment) glove;
		} else if (comboBoxId.contains("holster")) {
			item = (Equipment) holster;
		} else  {
			item = (Equipment)kneepad;
		}
		
		Mod mod = (Mod) World.Registry.get("mod", attribute);		
		Double max = Attribute.getModAttributes().get(Attribute.valueOf(attribute)).doubleValue();
		
		try {
			mod.setFirstAttributeValue(max);
			item.addMod(mod);
			return true;
		} catch (NumberFormatException | AttributeException | ModException e) {
			e.getMessage();
			e.printStackTrace();	
		}
				
		return false;
	}
}
