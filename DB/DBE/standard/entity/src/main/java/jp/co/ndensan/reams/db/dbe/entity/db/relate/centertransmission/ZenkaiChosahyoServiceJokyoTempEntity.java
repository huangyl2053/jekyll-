package jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 前回調査票（概況調査）サービスの状況一時テーブルです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
@OnNextSchema("rgdb")
public class ZenkaiChosahyoServiceJokyoTempEntity extends DbTableEntityBase<ZenkaiChosahyoServiceJokyoTempEntity> implements IDbAccessable {

    /**
     * 前回調査票（概況調査）サービスの状況一時テーブル
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("ZenkaiChosahyoServiceJokyoTemp"));
    }
    @TempTableColumnOrder(1)
    private ShinseishoKanriNo shinseishoKanriNo;
    @TempTableColumnOrder(2)
    private Code koroshoIfShikibetsuCode;
    @TempTableColumnOrder(3)
    private int koban1;
    @TempTableColumnOrder(4)
    private int koban2;
    @TempTableColumnOrder(5)
    private int koban3;
    @TempTableColumnOrder(6)
    private int koban4;
    @TempTableColumnOrder(7)
    private int koban5;
    @TempTableColumnOrder(8)
    private int koban6;
    @TempTableColumnOrder(9)
    private int koban7;
    @TempTableColumnOrder(10)
    private int koban8;
    @TempTableColumnOrder(11)
    private int koban9;
    @TempTableColumnOrder(12)
    private int koban10;
    @TempTableColumnOrder(13)
    private int koban11;
    @TempTableColumnOrder(14)
    private int koban12;
    @TempTableColumnOrder(15)
    private int koban13;
    @TempTableColumnOrder(16)
    private int koban14;
    @TempTableColumnOrder(17)
    private int koban15;
    @TempTableColumnOrder(18)
    private int koban16;
    @TempTableColumnOrder(19)
    private int koban17;
    @TempTableColumnOrder(20)
    private int koban18;
    @TempTableColumnOrder(21)
    private int koban19;
    @TempTableColumnOrder(22)
    private int koban20;
    @TempTableColumnOrder(23)
    private ShinseishoKanriNo zenkaiShinseishoKanriNo;

    /**
     * 申請書管理番号のgetメソッドです。
     *
     * @return the nijiHanteiYM
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     *
     * @param shinseishoKanriNo ShinseishoKanriNo
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 前回申請書管理番号のgetメソッドです。
     *
     * @return the zenkaiShinseishoKanriNo
     */
    public ShinseishoKanriNo getZenkaiShinseishoKanriNo() {
        return zenkaiShinseishoKanriNo;
    }

    /**
     * 前回申請書管理番号のsetメソッドです。
     *
     * @param zenkaiShinseishoKanriNo ShinseishoKanriNo
     */
    public void setZenkaiShinseishoKanriNo(ShinseishoKanriNo zenkaiShinseishoKanriNo) {
        this.zenkaiShinseishoKanriNo = zenkaiShinseishoKanriNo;
    }

    /**
     * 厚労省IF識別コードのgetメソッドです。
     *
     * @return the koroshoIfShikibetsuCode
     */
    public Code getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    /**
     * 厚労省IF識別コードのsetメソッドです。
     *
     * @param koroshoIfShikibetsuCode Code
     */
    public void setKoroshoIfShikibetsuCode(Code koroshoIfShikibetsuCode) {
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    /**
     * 項番1のgetメソッドです。
     *
     * @return the koban1
     */
    public int getKoban1() {
        return koban1;
    }

    /**
     * 項番1のsetメソッドです。
     *
     * @param koban1 the koban1 to set
     */
    public void setKoban1(int koban1) {
        this.koban1 = koban1;
    }

    /**
     * 項番2のgetメソッドです。
     *
     * @return the koban2
     */
    public int getKoban2() {
        return koban2;
    }

    /**
     * 項番2のsetメソッドです。
     *
     * @param koban2 the koban2 to set
     */
    public void setKoban2(int koban2) {
        this.koban2 = koban2;
    }

    /**
     * 項番3のgetメソッドです。
     *
     * @return the koban3
     */
    public int getKoban3() {
        return koban3;
    }

    /**
     * 項番3のsetメソッドです。
     *
     * @param koban3 the koban3 to set
     */
    public void setKoban3(int koban3) {
        this.koban3 = koban3;
    }

    /**
     * 項番4のgetメソッドです。
     *
     * @return the koban4
     */
    public int getKoban4() {
        return koban4;
    }

    /**
     * 項番4のsetメソッドです。
     *
     * @param koban4 the koban4 to set
     */
    public void setKoban4(int koban4) {
        this.koban4 = koban4;
    }

    /**
     * 項番5のgetメソッドです。
     *
     * @return the koban5
     */
    public int getKoban5() {
        return koban5;
    }

    /**
     * 項番5のsetメソッドです。
     *
     * @param koban5 the koban5 to set
     */
    public void setKoban5(int koban5) {
        this.koban5 = koban5;
    }

    /**
     * 項番6のgetメソッドです。
     *
     * @return the koban6
     */
    public int getKoban6() {
        return koban6;
    }

    /**
     * 項番6のsetメソッドです。
     *
     * @param koban6 the koban6 to set
     */
    public void setKoban6(int koban6) {
        this.koban6 = koban6;
    }

    /**
     * 項番7のgetメソッドです。
     *
     * @return the koban7
     */
    public int getKoban7() {
        return koban7;
    }

    /**
     * 項番7のsetメソッドです。
     *
     * @param koban7 the koban7 to set
     */
    public void setKoban7(int koban7) {
        this.koban7 = koban7;
    }

    /**
     * 項番8のgetメソッドです。
     *
     * @return the koban8
     */
    public int getKoban8() {
        return koban8;
    }

    /**
     * 項番8のsetメソッドです。
     *
     * @param koban8 the koban8 to set
     */
    public void setKoban8(int koban8) {
        this.koban8 = koban8;
    }

    /**
     * 項番9のgetメソッドです。
     *
     * @return the koban9
     */
    public int getKoban9() {
        return koban9;
    }

    /**
     * 項番9のsetメソッドです。
     *
     * @param koban9 the koban9 to set
     */
    public void setKoban9(int koban9) {
        this.koban9 = koban9;
    }

    /**
     * 項番10のgetメソッドです。
     *
     * @return the koban10
     */
    public int getKoban10() {
        return koban10;
    }

    /**
     * 項番10のsetメソッドです。
     *
     * @param koban10 the koban10 to set
     */
    public void setKoban10(int koban10) {
        this.koban10 = koban10;
    }

    /**
     * 項番11のgetメソッドです。
     *
     * @return the koban11
     */
    public int getKoban11() {
        return koban11;
    }

    /**
     * 項番11のsetメソッドです。
     *
     * @param koban11 the koban11 to set
     */
    public void setKoban11(int koban11) {
        this.koban11 = koban11;
    }

    /**
     * 項番12のgetメソッドです。
     *
     * @return the koban12
     */
    public int getKoban12() {
        return koban12;
    }

    /**
     * 項番12のsetメソッドです。
     *
     * @param koban12 the koban12 to set
     */
    public void setKoban12(int koban12) {
        this.koban12 = koban12;
    }

    /**
     * 項番13のgetメソッドです。
     *
     * @return the koban13
     */
    public int getKoban13() {
        return koban13;
    }

    /**
     * 項番13のsetメソッドです。
     *
     * @param koban13 the koban13 to set
     */
    public void setKoban13(int koban13) {
        this.koban13 = koban13;
    }

    /**
     * 項番14のgetメソッドです。
     *
     * @return the koban14
     */
    public int getKoban14() {
        return koban14;
    }

    /**
     * 項番14のsetメソッドです。
     *
     * @param koban14 the koban14 to set
     */
    public void setKoban14(int koban14) {
        this.koban14 = koban14;
    }

    /**
     * 項番15のgetメソッドです。
     *
     * @return the koban15
     */
    public int getKoban15() {
        return koban15;
    }

    /**
     * 項番15のsetメソッドです。
     *
     * @param koban15 the koban15 to set
     */
    public void setKoban15(int koban15) {
        this.koban15 = koban15;
    }

    /**
     * 項番16のgetメソッドです。
     *
     * @return the koban16
     */
    public int getKoban16() {
        return koban16;
    }

    /**
     * 項番16のsetメソッドです。
     *
     * @param koban16 the koban16 to set
     */
    public void setKoban16(int koban16) {
        this.koban16 = koban16;
    }

    /**
     * 項番17のgetメソッドです。
     *
     * @return the koban17
     */
    public int getKoban17() {
        return koban17;
    }

    /**
     * 項番17のsetメソッドです。
     *
     * @param koban17 the koban17 to set
     */
    public void setKoban17(int koban17) {
        this.koban17 = koban17;
    }

    /**
     * 項番18のgetメソッドです。
     *
     * @return the koban18
     */
    public int getKoban18() {
        return koban18;
    }

    /**
     * 項番18のsetメソッドです。
     *
     * @param koban18 the koban18 to set
     */
    public void setKoban18(int koban18) {
        this.koban18 = koban18;
    }

    /**
     * 項番19のgetメソッドです。
     *
     * @return the koban19
     */
    public int getKoban19() {
        return koban19;
    }

    /**
     * 項番19のsetメソッドです。
     *
     * @param koban19 the koban19 to set
     */
    public void setKoban19(int koban19) {
        this.koban19 = koban19;
    }

    /**
     * 項番20のgetメソッドです。
     *
     * @return the koban20
     */
    public int getKoban20() {
        return koban20;
    }

    /**
     * 項番20のsetメソッドです。
     *
     * @param koban20 the koban20 to set
     */
    public void setKoban20(int koban20) {
        this.koban20 = koban20;
    }

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(ZenkaiChosahyoServiceJokyoTempEntity entity) {
        this.setShinseishoKanriNo(entity.getShinseishoKanriNo());
        this.setKoroshoIfShikibetsuCode(entity.getKoroshoIfShikibetsuCode());
        this.setKoban1(entity.getKoban1());
        this.setKoban2(entity.getKoban2());
        this.setKoban3(entity.getKoban3());
        this.setKoban4(entity.getKoban4());
        this.setKoban5(entity.getKoban5());
        this.setKoban6(entity.getKoban6());
        this.setKoban7(entity.getKoban7());
        this.setKoban8(entity.getKoban8());
        this.setKoban9(entity.getKoban9());
        this.setKoban10(entity.getKoban10());
        this.setKoban11(entity.getKoban11());
        this.setKoban12(entity.getKoban12());
        this.setKoban13(entity.getKoban13());
        this.setKoban14(entity.getKoban14());
        this.setKoban15(entity.getKoban15());
        this.setKoban16(entity.getKoban16());
        this.setKoban17(entity.getKoban17());
        this.setKoban18(entity.getKoban18());
        this.setKoban19(entity.getKoban19());
        this.setKoban20(entity.getKoban20());
        this.setZenkaiShinseishoKanriNo(entity.getZenkaiShinseishoKanriNo());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, koroshoIfShikibetsuCode, koban1, koban2, koban3, koban4, koban5, koban6,
                koban7, koban8, koban9, koban10, koban11, koban12, koban13, koban14, koban15, koban16, koban17,
                koban18, koban19, koban20, zenkaiShinseishoKanriNo);
    }
// </editor-fold>
}
