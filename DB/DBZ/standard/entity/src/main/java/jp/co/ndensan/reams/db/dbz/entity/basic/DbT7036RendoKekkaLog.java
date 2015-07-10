package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7036RendoKekkaLogの項目定義クラスです
 *
 */
public enum DbT7036RendoKekkaLog implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shoriNo(18, 0),
    shubetsu(2, 0),
    shoriID(9, 0),
    motoShichosonCode(2147483647, 0),
    sakiShichosonCode(2147483647, 0),
    kekkaKubun(1, 0),
    kakuninKubun(1, 0),
    ShoriKaishiTimestamp(2147483647, 0),
    shoriShuryoTimestamp(2147483647, 0),
    logFileMei(64, 0),
    hyojiJoken(120, 0),
    messeage(200, 0),
    rendoKeitai(2, 0),
    upLoad_JushinKekkaKubun(1, 0),
    upLoad_MojiCodeHenkanKekkaKubun(1, 0),
    upLoad_Shori1KekkaKubun(1, 0),
    upLoad_Shori2kekkaKubun(1, 0),
    upLoad_Shori3KekkaKubun(1, 0),
    downLoad_Shori1KekkaKubun(1, 0),
    downLoad_CodeHenkanKekkaKubun(1, 0),
    downLoad_MojiCodeHenkanKekkaKubun(1, 0),
    downLoad_Soshin1KekkaKubun(1, 0),
    downLoad_shori2KekkaKubun(1, 0),
    downLoad_Jushon1KekkaKubun(1, 0),
    shoriMessage1(100, 0),
    shoriMessage2(100, 0);

    private final int maxLength;
    private final int scale;

    private DbT7036RendoKekkaLog(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
