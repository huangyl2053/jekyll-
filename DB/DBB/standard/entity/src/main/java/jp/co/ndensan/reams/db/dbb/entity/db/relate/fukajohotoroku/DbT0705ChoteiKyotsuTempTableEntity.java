package jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * DbT0705ChoteiKyotsuTempTableEntity項目定義クラスです。
 *
 * @reamsid_L DBB-9040-070 wangxiaodong
 */
@OnNextSchema("rgdb")
public class DbT0705ChoteiKyotsuTempTableEntity extends DbTableEntityBase<DbT0705ChoteiKyotsuTempTableEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    /**
     * 調定共通（一時テーブル）
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = new RString("DbT0705ChoteiKyotsuTemp");
    }

    @TempTableColumnOrder(1)
    private long choteiId;
    @TempTableColumnOrder(2)
    private long shunoId;
    @TempTableColumnOrder(3)
    private FlexibleYear kaikeiNendo;
    @TempTableColumnOrder(4)
    private FlexibleYear shoriNendo;
    @TempTableColumnOrder(5)
    private int shoriNo;
    @TempTableColumnOrder(6)
    private int koseiKaisu;
    @TempTableColumnOrder(7)
    private RString choteiJiyuCode;
    @TempTableColumnOrder(8)
    private FlexibleDate choteiYMD;
    @TempTableColumnOrder(9)
    private Decimal choteigaku;
    @TempTableColumnOrder(10)
    private Decimal shohizei;
    @TempTableColumnOrder(11)
    private RDate nokigenYMD;
    @TempTableColumnOrder(12)
    private FlexibleDate hoteiNokigenToYMD;
    @TempTableColumnOrder(13)
    private boolean fukaShoriJokyo;

    /**
     * 調定IDのgetメソッドです。
     *
     * @return the choteiId
     */
    public long getChoteiId() {
        return choteiId;
    }

    /**
     * 調定IDのsetメソッドです。
     *
     * @param choteiId the choteiId to set
     */
    public void setChoteiId(long choteiId) {
        this.choteiId = choteiId;
    }

    /**
     * 収納IDのgetメソッドです。
     *
     * @return the shunoId
     */
    public long getShunoId() {
        return shunoId;
    }

    /**
     * 収納IDのsetメソッドです。
     *
     * @param shunoId the shunoId to set
     */
    public void setShunoId(long shunoId) {
        this.shunoId = shunoId;
    }

    /**
     * 会計年度のgetメソッドです。
     *
     * @return the kaikeiNendo
     */
    public FlexibleYear getKaikeiNendo() {
        return kaikeiNendo;
    }

    /**
     * 会計年度のsetメソッドです。
     *
     * @param kaikeiNendo the kaikeiNendo to set
     */
    public void setKaikeiNendo(FlexibleYear kaikeiNendo) {
        this.kaikeiNendo = kaikeiNendo;
    }

    /**
     * 処理年度のgetメソッドです。
     *
     * @return the shoriNendo
     */
    public FlexibleYear getShoriNendo() {
        return shoriNendo;
    }

    /**
     * 処理年度のsetメソッドです。
     *
     * @param shoriNendo the shoriNendo to set
     */
    public void setShoriNendo(FlexibleYear shoriNendo) {
        this.shoriNendo = shoriNendo;
    }

    /**
     * 処理番号のgetメソッドです。
     *
     * @return the shoriNo
     */
    public int getShoriNo() {
        return shoriNo;
    }

    /**
     * 処理番号のsetメソッドです。
     *
     * @param shoriNo the shoriNo to set
     */
    public void setShoriNo(int shoriNo) {
        this.shoriNo = shoriNo;
    }

    /**
     * 更正回数のgetメソッドです。
     *
     * @return the koseiKaisu
     */
    public int getKoseiKaisu() {
        return koseiKaisu;
    }

    /**
     * 更正回数のsetメソッドです。
     *
     * @param koseiKaisu the koseiKaisu to set
     */
    public void setKoseiKaisu(int koseiKaisu) {
        this.koseiKaisu = koseiKaisu;
    }

    /**
     * 調定事由コードのgetメソッドです。
     *
     * @return the choteiJiyuCode
     */
    public RString getChoteiJiyuCode() {
        return choteiJiyuCode;
    }

    /**
     * 調定事由コードのsetメソッドです。
     *
     * @param choteiJiyuCode the choteiJiyuCode to set
     */
    public void setChoteiJiyuCode(RString choteiJiyuCode) {
        this.choteiJiyuCode = choteiJiyuCode;
    }

    /**
     * 調定年月日のgetメソッドです。
     *
     * @return the choteiYMD
     */
    public FlexibleDate getChoteiYMD() {
        return choteiYMD;
    }

    /**
     * 調定年月日のsetメソッドです。
     *
     * @param choteiYMD the choteiYMD to set
     */
    public void setChoteiYMD(FlexibleDate choteiYMD) {
        this.choteiYMD = choteiYMD;
    }

    /**
     * 調定額のgetメソッドです。
     *
     * @return the choteigaku
     */
    public Decimal getChoteigaku() {
        return choteigaku;
    }

    /**
     * 調定額のsetメソッドです。
     *
     * @param choteigaku the choteigaku to set
     */
    public void setChoteigaku(Decimal choteigaku) {
        this.choteigaku = choteigaku;
    }

    /**
     * 消費税額のgetメソッドです。
     *
     * @return the shohizei
     */
    public Decimal getShohizei() {
        return shohizei;
    }

    /**
     * 消費税額のsetメソッドです。
     *
     * @param shohizei the shohizei to set
     */
    public void setShohizei(Decimal shohizei) {
        this.shohizei = shohizei;
    }

    /**
     * 納期限のgetメソッドです。
     *
     * @return the nokigenYMD
     */
    public RDate getNokigenYMD() {
        return nokigenYMD;
    }

    /**
     * 納期限のsetメソッドです。
     *
     * @param nokigenYMD the nokigenYMD to set
     */
    public void setNokigenYMD(RDate nokigenYMD) {
        this.nokigenYMD = nokigenYMD;
    }

    /**
     * 法定納期限等のgetメソッドです。
     *
     * @return the hoteiNokigenToYMD
     */
    public FlexibleDate getHoteiNokigenToYMD() {
        return hoteiNokigenToYMD;
    }

    /**
     * 法定納期限等のsetメソッドです。
     *
     * @param hoteiNokigenToYMD the hoteiNokigenToYMD to set
     */
    public void setHoteiNokigenToYMD(FlexibleDate hoteiNokigenToYMD) {
        this.hoteiNokigenToYMD = hoteiNokigenToYMD;
    }

    /**
     * 賦課処理状況のgetメソッドです。
     *
     * @return the fukaShoriJokyo
     */
    public boolean isFukaShoriJokyo() {
        return fukaShoriJokyo;
    }

    /**
     * 賦課処理状況のsetメソッドです。
     *
     * @param fukaShoriJokyo the fukaShoriJokyo to set
     */
    public void setFukaShoriJokyo(boolean fukaShoriJokyo) {
        this.fukaShoriJokyo = fukaShoriJokyo;
    }

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(DbT0705ChoteiKyotsuTempTableEntity entity) {
        this.choteiId = entity.choteiId;
        this.shunoId = entity.shunoId;
        this.kaikeiNendo = entity.kaikeiNendo;
        this.shoriNendo = entity.shoriNendo;
        this.shoriNo = entity.shoriNo;
        this.koseiKaisu = entity.koseiKaisu;
        this.choteiJiyuCode = entity.choteiJiyuCode;
        this.choteiYMD = entity.choteiYMD;
        this.choteigaku = entity.choteigaku;
        this.shohizei = entity.shohizei;
        this.nokigenYMD = entity.nokigenYMD;
        this.hoteiNokigenToYMD = entity.hoteiNokigenToYMD;
        this.fukaShoriJokyo = entity.fukaShoriJokyo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(choteiId, shunoId, kaikeiNendo, shoriNendo, shoriNo, koseiKaisu,
                choteiJiyuCode, choteiYMD, choteigaku, shohizei, nokigenYMD, hoteiNokigenToYMD, fukaShoriJokyo);
    }

// </editor-fold>
}
