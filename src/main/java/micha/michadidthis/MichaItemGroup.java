package micha.michadidthis;

import micha.michadidthis.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MichaItemGroup extends ItemGroup{
	public MichaItemGroup() 
	{
		super("groupReference");
	}
	
	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemList.bloody_sword);
	}
}
