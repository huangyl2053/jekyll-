package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * UrT0705ChoteiKyotsuの項目定義クラスです
 *
 */
public class UrT0705ChoteiKyotsuEntity extends DbTableEntityBase<UrT0705ChoteiKyotsuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">

    @TableName
    public static final RString TABLE_NAME = new RString("UrT0705ChoteiKyotsu");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private Long choteiId;
    private int rirekiNo;
    private Long shunoId;
    private RYear kaikeiNendo;
    private RYear shoriNendo;
    private int shoriNo;
    private int koseiKaisu;
    private RString choteiJiyuCode;
    private RDate choteiYMD;
    private Decimal choteigaku;
    private Decimal shohizei;
    private RDate nokigenYMD;
    private RDate hoteiNokigenToYMD;
    private boolean fukaShoriJokyo;

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getChoteiId
     *
     * @return choteiId
     */
    public Long getChoteiId() {
        return choteiId;
    }

    /**
     * setChoteiId
     *
     * @param choteiId choteiId
     */
    public void setChoteiId(Long choteiId) {
        this.choteiId = choteiId;
    }

    /**
     * getRirekiNo
     *
     * @return rirekiNo
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * setRirekiNo
     *
     * @param rirekiNo rirekiNo
     */
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * getShunoId
     *
     * @return shunoId
     */
    public Long getShunoId() {
        return shunoId;
    }

    /**
     * setShunoId
     *
     * @param shunoId shunoId
     */
    public void setShunoId(Long shunoId) {
        this.shunoId = shunoId;
    }

    /**
     * getKaikeiNendo
     *
     * @return kaikeiNendo
     */
    public RYear getKaikeiNendo() {
        return kaikeiNendo;
    }

    /**
     * setKaikeiNendo
     *
     * @param kaikeiNendo kaikeiNendo
     */
    public void setKaikeiNendo(RYear kaikeiNendo) {
        this.kaikeiNendo = kaikeiNendo;
    }

    /**
     * getShoriNendo
     *
     * @return shoriNendo
     */
    public RYear getShoriNendo() {
        return shoriNendo;
    }

    /**
     * setShoriNendo
     *
     * @param shoriNendo shoriNendo
     */
    public void setShoriNendo(RYear shoriNendo) {
        this.shoriNendo = shoriNendo;
    }

    /**
     * getShoriNo
     *
     * @return shoriNo
     */
    public int getShoriNo() {
        return shoriNo;
    }

    /**
     * setShoriNo
     *
     * @param shoriNo shoriNo
     */
    public void setShoriNo(int shoriNo) {
        this.shoriNo = shoriNo;
    }

    /**
     * getKoseiKaisu
     *
     * @return koseiKaisu
     */
    public int getKoseiKaisu() {
        return koseiKaisu;
    }

    /**
     * setKoseiKaisu
     *
     * @param koseiKaisu koseiKaisu
     */
    public void setKoseiKaisu(int koseiKaisu) {
        this.koseiKaisu = koseiKaisu;
    }

    /**
     * getChoteiJiyuCode
     *
     * @return choteiJiyuCode
     */
    public RString getChoteiJiyuCode() {
        return choteiJiyuCode;
    }

    /**
     * setChoteiJiyuCode
     *
     * @param choteiJiyuCode choteiJiyuCode
     */
    public void setChoteiJiyuCode(RString choteiJiyuCode) {
        this.choteiJiyuCode = choteiJiyuCode;
    }

    /**
     * getChoteiYMD
     *
     * @return choteiYMD
     */
    public RDate getChoteiYMD() {
        return choteiYMD;
    }

    /**
     * setChoteiYMD
     *
     * @param choteiYMD choteiYMD
     */
    public void setChoteiYMD(RDate choteiYMD) {
        this.choteiYMD = choteiYMD;
    }

    /**
     * getChoteigaku
     *
     * @return choteigaku
     */
    public Decimal getChoteigaku() {
        return choteigaku;
    }

    /**
     * setChoteigaku
     *
     * @param choteigaku choteigaku
     */
    public void setChoteigaku(Decimal choteigaku) {
        this.choteigaku = choteigaku;
    }

    /**
     * getShohizei
     *
     * @return shohizei
     */
    public Decimal getShohizei() {
        return shohizei;
    }

    /**
     * setShohizei
     *
     * @param shohizei shohizei
     */
    public void setShohizei(Decimal shohizei) {
        this.shohizei = shohizei;
    }

    /**
     * getNokigenYMD
     *
     * @return nokigenYMD
     */
    public RDate getNokigenYMD() {
        return nokigenYMD;
    }

    /**
     * setNokigenYMD
     *
     * @param nokigenYMD nokigenYMD
     */
    public void setNokigenYMD(RDate nokigenYMD) {
        this.nokigenYMD = nokigenYMD;
    }

    /**
     * getHoteiNokigenToYMD
     *
     * @return hoteiNokigenToYMD
     */
    public RDate getHoteiNokigenToYMD() {
        return hoteiNokigenToYMD;
    }

    /**
     * setHoteiNokigenToYMD
     *
     * @param hoteiNokigenToYMD hoteiNokigenToYMD
     */
    public void setHoteiNokigenToYMD(RDate hoteiNokigenToYMD) {
        this.hoteiNokigenToYMD = hoteiNokigenToYMD;
    }

    /**
     * getFukaShoriJokyo
     *
     * @return fukaShoriJokyo
     */
    public boolean getFukaShoriJokyo() {
        return fukaShoriJokyo;
    }

    /**
     * setFukaShoriJokyo
     *
     * @param fukaShoriJokyo fukaShoriJokyo
     */
    public void setFukaShoriJokyo(boolean fukaShoriJokyo) {
        this.fukaShoriJokyo = fukaShoriJokyo;
    }

    /**
     * このエンティティの主キーが他の{@literal UrT0705ChoteiKyotsuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal UrT0705ChoteiKyotsuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(UrT0705ChoteiKyotsuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.choteiId, other.choteiId)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(UrT0705ChoteiKyotsuEntity entity) {
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
        return super.toMd5(choteiId, shunoId, kaikeiNendo, shoriNendo, shoriNo, koseiKaisu, choteiJiyuCode, choteiYMD, choteigaku, shohizei, nokigenYMD, hoteiNokigenToYMD, fukaShoriJokyo);
    }

// </editor-fold>
}
