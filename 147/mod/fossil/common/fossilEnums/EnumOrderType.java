package mod.fossil.common.fossilEnums;

import mod.fossil.common.Fossil;
public enum EnumOrderType
{
    Stay,
    Follow,
    FreeMove;

    public final EnumOrderType Next()
    {
        switch (this.ordinal())
        {
            case 1:return Follow;
            case 2:return FreeMove;
            case 3:return Stay;
            default:return FreeMove;
        }
    }
    /*public final String GetOrderString()
    {
        return Fossil.GetLangTextByKey("Order." + this.toString());
    }*/
}
