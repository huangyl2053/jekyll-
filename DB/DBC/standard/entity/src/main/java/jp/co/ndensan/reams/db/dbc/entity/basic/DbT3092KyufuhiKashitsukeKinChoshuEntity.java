package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * 給付費貸付金徴収テーブルのエンティティクラスです。
 */
public class DbT3092KyufuhiKashitsukeKinChoshuEntity extends DbTableEntityBase<DbT3092KyufuhiKashitsukeKinChoshuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3092KyufuhiKashitsukeKinChoshu");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RString kashitsukeKanriNo;
    @PrimaryKey
    private int rirekiNo;
    private RString henkanChoshuHoho;
    private FlexibleDate HenkanChoshuYMD;
    private Decimal henkanChoshuKingaku;
    private RString kabusokuHanteiKekkaKubun;

    /**
     * insertDantaiCdのgetメソッドです。
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * insertDantaiCdのsetメソッドです。
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * isDeletedのgetメソッドです。
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedのsetメソッドです。
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 貸付管理番号のgetメソッドです。
     *
     * @return 貸付管理番号
     */
    public RString getKashitsukeKanriNo() {
        return kashitsukeKanriNo;
    }

    /**
     * 貸付管理番号のsetメソッドです。
     *
     * @param kashitsukeKanriNo 貸付管理番号
     */
    public void setKashitsukeKanriNo(RString kashitsukeKanriNo) {
        this.kashitsukeKanriNo = kashitsukeKanriNo;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 貸付金返還徴収方法のgetメソッドです。
     *
     * @return 貸付金返還徴収方法
     */
    public RString getHenkanChoshuHoho() {
        return henkanChoshuHoho;
    }

    /**
     * 貸付金返還徴収方法のsetメソッドです。
     *
     * @param henkanChoshuHoho 貸付金返還徴収方法
     */
    public void setHenkanChoshuHoho(RString henkanChoshuHoho) {
        this.henkanChoshuHoho = henkanChoshuHoho;
    }

    /**
     * 貸付金返還徴収年月日のgetメソッドです。
     *
     * @return 貸付金返還徴収年月日
     */
    public FlexibleDate getHenkanChoshuYMD() {
        return HenkanChoshuYMD;
    }

    /**
     * 貸付金返還徴収年月日のsetメソッドです。
     *
     * @param HenkanChoshuYMD 貸付金返還徴収年月日
     */
    public void setHenkanChoshuYMD(FlexibleDate HenkanChoshuYMD) {
        this.HenkanChoshuYMD = HenkanChoshuYMD;
    }

    /**
     * 貸付金返還徴収金額のgetメソッドです。
     *
     * @return 貸付金返還徴収金額
     */
    public Decimal getHenkanChoshuKingaku() {
        return henkanChoshuKingaku;
    }

    /**
     * 貸付金返還徴収金額のsetメソッドです。
     *
     * @param henkanChoshuKingaku 貸付金返還徴収金額
     */
    public void setHenkanChoshuKingaku(Decimal henkanChoshuKingaku) {
        this.henkanChoshuKingaku = henkanChoshuKingaku;
    }

    /**
     * 過不足判定結果区分のgetメソッドです。
     *
     * @return 過不足判定結果区分
     */
    public RString getKabusokuHanteiKekkaKubun() {
        return kabusokuHanteiKekkaKubun;
    }

    /**
     * 過不足判定結果区分のsetメソッドです。
     *
     * @param kabusokuHanteiKekkaKubun 過不足判定結果区分
     */
    public void setKabusokuHanteiKekkaKubun(RString kabusokuHanteiKekkaKubun) {
        this.kabusokuHanteiKekkaKubun = kabusokuHanteiKekkaKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3092KyufuhiKashitsukeKinChoshuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3092KyufuhiKashitsukeKinChoshuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3092KyufuhiKashitsukeKinChoshuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.kashitsukeKanriNo, other.kashitsukeKanriNo)) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3092KyufuhiKashitsukeKinChoshuEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kashitsukeKanriNo = entity.kashitsukeKanriNo;
        this.rirekiNo = entity.rirekiNo;
        this.henkanChoshuHoho = entity.henkanChoshuHoho;
        this.HenkanChoshuYMD = entity.HenkanChoshuYMD;
        this.henkanChoshuKingaku = entity.henkanChoshuKingaku;
        this.kabusokuHanteiKekkaKubun = entity.kabusokuHanteiKekkaKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, kashitsukeKanriNo, rirekiNo, henkanChoshuHoho, HenkanChoshuYMD, henkanChoshuKingaku, kabusokuHanteiKekkaKubun);
    }

// </editor-fold>
}
