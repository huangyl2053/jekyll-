package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護賦課・福祉Viewテーブルの項目定義クラスです。
 */
public enum DbV7506FukaFukushi implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    /**
     * choteiNendo
     */
    choteiNendo(2147483647, 0),
    /**
     * fukaNendo
     */
    fukaNendo(2147483647, 0),
    /**
     * tsuchishoNo
     */
    tsuchishoNo(2147483647, 0),
    /**
     * rirekiNo
     */
    rirekiNo(5, 0),
    /**
     * hihokenshaNo
     */
    hihokenshaNo(2147483647, 0),
    /**
     * shikibetsuCode
     */
    shikibetsuCode(2147483647, 0),
    /**
     * setaiCode
     */
    setaiCode(2147483647, 0),
    /**
     * setaiInsu
     */
    setaiInsu(5, 0),
    /**
     * shikakuShutokuYMD
     */
    shikakuShutokuYMD(2147483647, 0),
    /**
     * shikakuShutokuJiyu
     */
    shikakuShutokuJiyu(2, 0),
    /**
     * shikakuSoshitsuYMD
     */
    shikakuSoshitsuYMD(2147483647, 0),
    /**
     * shikakuSoshitsuJiyu
     */
    shikakuSoshitsuJiyu(2, 0),
    /**
     * seihofujoShurui
     */
    seihofujoShurui(2, 0),
    /**
     * seihoKaishiYMD
     */
    seihoKaishiYMD(2147483647, 0),
    /**
     * seihoHaishiYMD
     */
    seihoHaishiYMD(2147483647, 0),
    /**
     * ronenKaishiYMD
     */
    ronenKaishiYMD(2147483647, 0),
    /**
     * ronenHaishiYMD
     */
    ronenHaishiYMD(2147483647, 0),
    /**
     * fukaYMD
     */
    fukaYMD(2147483647, 0),
    /**
     * kazeiKubun
     */
    kazeiKubun(1, 0),
    /**
     * setaikazeiKubun
     */
    setaikazeiKubun(1, 0),
    /**
     * gokeiShotokuGaku
     */
    gokeiShotokuGaku(12, 0),
    /**
     * nenkinShunyuGaku
     */
    nenkinShunyuGaku(12, 0),
    /**
     * hokenryoDankai
     */
    hokenryoDankai(3, 0),
    /**
     * hokenryoDankai1
     */
    hokenryoDankai1(3, 0),
    /**
     * nengakuHokenryo1
     */
    nengakuHokenryo1(7, 0),
    /**
     * tsukiwariStartYM1
     */
    tsukiwariStartYM1(2147483647, 0),
    /**
     * tsukiwariEndYM1
     */
    tsukiwariEndYM1(2147483647, 0),
    /**
     * hokenryoDankai2
     */
    hokenryoDankai2(3, 0),
    /**
     * nengakuHokenryo2
     */
    nengakuHokenryo2(7, 0),
    /**
     * tsukiwariStartYM2
     */
    tsukiwariStartYM2(2147483647, 0),
    /**
     * tsukiwariEndYM2
     */
    tsukiwariEndYM2(2147483647, 0),
    /**
     * choteiNichiji
     */
    choteiNichiji(2147483647, 0),
    /**
     * choteiJiyu1
     */
    choteiJiyu1(2, 0),
    /**
     * choteiJiyu2
     */
    choteiJiyu2(2, 0),
    /**
     * choteiJiyu3
     */
    choteiJiyu3(2, 0),
    /**
     * choteiJiyu4
     */
    choteiJiyu4(2, 0),
    /**
     * koseiM
     */
    koseiM(2, 0),
    /**
     * gemmenMaeHokenryo
     */
    gemmenMaeHokenryo(7, 0),
    /**
     * gemmenGaku
     */
    gemmenGaku(7, 0),
    /**
     * kakuteiHokenryo
     */
    kakuteiHokenryo(7, 0),
    /**
     * hokenryoDankaiKarisanntei
     */
    hokenryoDankaiKarisanntei(3, 0),
    /**
     * choshuHohoRirekiNo
     */
    choshuHohoRirekiNo(5, 0),
    /**
     * idoKijunNichiji
     */
    idoKijunNichiji(2147483647, 0),
    /**
     * kozaKubun
     */
    kozaKubun(1, 0),
    /**
     * kyokaisoKubun
     */
    kyokaisoKubun(1, 0),
    /**
     * shokkenKubun
     */
    shokkenKubun(1, 0),
    /**
     * fukaShichosonCode
     */
    fukaShichosonCode(2147483647, 0),
    /**
     * tkSaishutsuKampuGaku
     */
    tkSaishutsuKampuGaku(7, 0),
    /**
     * fuSaishutsuKampuGaku
     */
    fuSaishutsuKampuGaku(7, 0);

    private final int maxLength;
    private final int scale;

    private DbV7506FukaFukushi(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * 項目の最大長のgetメソッドです。
     * 
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 小数点以下の桁数のgetメソッドです。
     * 
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
