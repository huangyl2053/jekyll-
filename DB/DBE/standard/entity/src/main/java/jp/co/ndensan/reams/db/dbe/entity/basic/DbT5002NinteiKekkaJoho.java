package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定結果情報を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum DbT5002NinteiKekkaJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shinseishoKanriNo(10, 0),
    shoKisaiHokenshaNo(6, 0),
    hihokenshaNo(10, 0),
    youkaigodoNinteiYMD(2147483647, 0),
    youkaigoJotaiKubunCode(2147483647, 0),
    ninteiYukoKikan(5, 0),
    ninteiYukoKaishiYMD(2147483647, 0),
    ninteiYukoShuryoYMD(2147483647, 0),
    tokuteiShippeiCode(2147483647, 0),
    shisetsuNyushoFlag(1, 0),
    shinsakaiKaisaiNo(5, 0),
    shinsakaiIken(2147483647, 0),
    ichijiHnateiKekkaHenkoRiyu(2147483647, 0),
    yokaigoJotaizoReiCode(2147483647, 0),
    ninteishinsakaiIkenShurui(1, 0),
    kaigoServiceShurui01(2, 0),
    kaigoServiceShurui02(2, 0),
    kaigoServiceShurui03(2, 0),
    kaigoServiceShurui04(2, 0),
    kaigoServiceShurui05(2, 0),
    kaigoServiceShurui06(2, 0),
    kaigoServiceShurui07(2, 0),
    kaigoServiceShurui08(2, 0),
    kaigoServiceShurui09(2, 0),
    kaigoServiceShurui10(2, 0),
    kaigoServiceShurui11(2, 0),
    kaigoServiceShurui12(2, 0),
    kaigoServiceShurui13(2, 0),
    kaigoServiceShurui14(2, 0),
    kaigoServiceShurui15(2, 0),
    kaigoServiceShurui16(2, 0),
    kaigoServiceShurui17(2, 0),
    kaigoServiceShurui18(2, 0),
    kaigoServiceShurui19(2, 0),
    kaigoServiceShurui20(2, 0),
    kaigoServiceShurui21(2, 0),
    kaigoServiceShurui22(2, 0),
    kaigoServiceShurui23(2, 0),
    kaigoServiceShurui24(2, 0),
    kaigoServiceShurui25(2, 0),
    kaigoServiceShurui26(2, 0),
    kaigoServiceShurui27(2, 0),
    kaigoServiceShurui28(2, 0),
    kaigoServiceShurui29(2, 0),
    kaigoServiceShurui30(2, 0),
    ninteiKekkaIdoJiyu(1, 0),
    ninteiKekkaIdoYMD(2147483647, 0),
    ninteiTorikeshiRiyu(2147483647, 0),
    ninteiTorikeshiYMD(2147483647, 0),
    tuchiKubun(2, 0),
    ninteiRiyu(2147483647, 0),
    shinsakaiMemo(2147483647, 0);
    private final int maxLength;
    private final int scale;

    private DbT5002NinteiKekkaJoho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     *
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     *
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }
// </editor-fold>
}
