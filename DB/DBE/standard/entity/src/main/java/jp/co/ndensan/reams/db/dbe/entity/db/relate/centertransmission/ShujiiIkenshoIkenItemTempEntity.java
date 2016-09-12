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
 * 要介護認定主治医意見書意見項目一時テーブルです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
@OnNextSchema("rgdb")
public class ShujiiIkenshoIkenItemTempEntity extends DbTableEntityBase<ShujiiIkenshoIkenItemTempEntity> implements IDbAccessable {

    /**
     * 要介護認定主治医意見書意見項目一時テーブル
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("ShujiiIkenshoIkenItemTemp"));
    }
    @TempTableColumnOrder(1)
    private ShinseishoKanriNo shinseishoKanriNo;
    @TempTableColumnOrder(2)
    private Code koroshoIfShikibetsuCode;
    @TempTableColumnOrder(3)
    private RString koban14;
    @TempTableColumnOrder(4)
    private RString koban15;
    @TempTableColumnOrder(5)
    private RString koban16;
    @TempTableColumnOrder(6)
    private RString koban17;
    @TempTableColumnOrder(7)
    private RString koban18;
    @TempTableColumnOrder(8)
    private RString koban19;
    @TempTableColumnOrder(9)
    private RString koban69;

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
     * 項番14のgetメソッドです。
     *
     * @return the koban14
     */
    public RString getKoban14() {
        return koban14;
    }

    /**
     * 項番14のsetメソッドです。
     *
     * @param koban14 the koban14 to set
     */
    public void setKoban14(RString koban14) {
        this.koban14 = koban14;
    }

    /**
     * 項番15のgetメソッドです。
     *
     * @return the koban15
     */
    public RString getKoban15() {
        return koban15;
    }

    /**
     * 項番15のsetメソッドです。
     *
     * @param koban15 the koban15 to set
     */
    public void setKoban15(RString koban15) {
        this.koban15 = koban15;
    }

    /**
     * 項番16のgetメソッドです。
     *
     * @return the koban16
     */
    public RString getKoban16() {
        return koban16;
    }

    /**
     * 項番16のsetメソッドです。
     *
     * @param koban16 the koban16 to set
     */
    public void setKoban16(RString koban16) {
        this.koban16 = koban16;
    }

    /**
     * 項番17のgetメソッドです。
     *
     * @return the koban17
     */
    public RString getKoban17() {
        return koban17;
    }

    /**
     * 項番17のsetメソッドです。
     *
     * @param koban17 the koban17 to set
     */
    public void setKoban17(RString koban17) {
        this.koban17 = koban17;
    }

    /**
     * 項番18のgetメソッドです。
     *
     * @return the koban18
     */
    public RString getKoban18() {
        return koban18;
    }

    /**
     * 項番18のsetメソッドです。
     *
     * @param koban18 the koban18 to set
     */
    public void setKoban18(RString koban18) {
        this.koban18 = koban18;
    }

    /**
     * 項番19のgetメソッドです。
     *
     * @return the koban19
     */
    public RString getKoban19() {
        return koban19;
    }

    /**
     * 項番19のsetメソッドです。
     *
     * @param koban19 the koban19 to set
     */
    public void setKoban19(RString koban19) {
        this.koban19 = koban19;
    }

    /**
     * @return the koban69
     */
    public RString getKoban69() {
        return koban69;
    }

    /**
     * @param koban69 the koban69 to set
     */
    public void setKoban69(RString koban69) {
        this.koban69 = koban69;
    }

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(ShujiiIkenshoIkenItemTempEntity entity) {
        this.setShinseishoKanriNo(entity.getShinseishoKanriNo());
        this.setKoroshoIfShikibetsuCode(entity.getKoroshoIfShikibetsuCode());
        this.setKoban14(entity.getKoban14());
        this.setKoban15(entity.getKoban15());
        this.setKoban16(entity.getKoban16());
        this.setKoban17(entity.getKoban17());
        this.setKoban18(entity.getKoban18());
        this.setKoban19(entity.getKoban19());
        this.setKoban69(entity.getKoban69());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, koroshoIfShikibetsuCode, koban14,
                koban15, koban16, koban17, koban18, koban19, koban69);
    }
// </editor-fold>
}
