package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * 個人番号情報送付テーブルのエンティティクラスです。
 */
public class DbT3121KojinBangoJohoSofuEntity extends DbTableEntityBase<DbT3121KojinBangoJohoSofuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3121KojinBangoJohoSofu");

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
    private FlexibleDate idoYMD;
    @PrimaryKey
    private int rirekiNo;
    private ShikibetsuCode shikibetsuCode;
    private RString kojinNo;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private FlexibleYearMonth shoriYM;
    private FlexibleDate teiseiYMD;
    private RString teiseiKubunCode;
    private RString idoJiyu;
    private RString idoKubunCode;

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
    public void setHihokenshaNo(@Nonnull HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 異動年月日のgetメソッドです。
     * <br/>
     * <br/>個人番号情報の登録または変更等が生じた年月日
     * 
     * @return 異動年月日
     */
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * 異動年月日のsetメソッドです。
     * <br/>
     * <br/>個人番号情報の登録または変更等が生じた年月日
     * 
     * @param idoYMD 異動年月日
     */
    public void setIdoYMD(@Nonnull FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
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
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 識別コードのgetメソッドです。
     * 
     * @return 識別コード
     */
    @CheckForNull
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     * 
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 個人番号のgetメソッドです。
     * 
     * @return 個人番号
     */
    @CheckForNull
    public RString getKojinNo() {
        return kojinNo;
    }

    /**
     * 個人番号のsetメソッドです。
     * 
     * @param kojinNo 個人番号
     */
    public void setKojinNo(RString kojinNo) {
        this.kojinNo = kojinNo;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     * <br/>
     * <br/>Not（地方公共団体コード（導入団体）⇒保険者番号）	被保険者証記載の保険者番号　　広域連合の場合は市町村コード
     * 
     * @return 証記載保険者番号
     */
    @CheckForNull
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     * <br/>
     * <br/>Not（地方公共団体コード（導入団体）⇒保険者番号）	被保険者証記載の保険者番号　　広域連合の場合は市町村コード
     * 
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 処理年月のgetメソッドです。
     * 
     * @return 処理年月
     */
    @CheckForNull
    public FlexibleYearMonth getShoriYM() {
        return shoriYM;
    }

    /**
     * 処理年月のsetメソッドです。
     * 
     * @param shoriYM 処理年月
     */
    public void setShoriYM(FlexibleYearMonth shoriYM) {
        this.shoriYM = shoriYM;
    }

    /**
     * 訂正年月日のgetメソッドです。
     * <br/>
     * <br/>個人番号情報に訂正が生じた日
     * 
     * @return 訂正年月日
     */
    @CheckForNull
    public FlexibleDate getTeiseiYMD() {
        return teiseiYMD;
    }

    /**
     * 訂正年月日のsetメソッドです。
     * <br/>
     * <br/>個人番号情報に訂正が生じた日
     * 
     * @param teiseiYMD 訂正年月日
     */
    public void setTeiseiYMD(FlexibleDate teiseiYMD) {
        this.teiseiYMD = teiseiYMD;
    }

    /**
     * 訂正区分のgetメソッドです。
     * <br/>
     * <br/>1：（未使用）　2：修正　3：削除
     * 
     * @return 訂正区分
     */
    @CheckForNull
    public RString getTeiseiKubunCode() {
        return teiseiKubunCode;
    }

    /**
     * 訂正区分のsetメソッドです。
     * <br/>
     * <br/>1：（未使用）　2：修正　3：削除
     * 
     * @param teiseiKubunCode 訂正区分
     */
    public void setTeiseiKubunCode(RString teiseiKubunCode) {
        this.teiseiKubunCode = teiseiKubunCode;
    }

    /**
     * 異動事由のgetメソッドです。
     * <br/>
     * <br/>01：受給者台帳の異動（新規、区間異動等）　02：個人番号の変更による異動
     * 
     * @return 異動事由
     */
    @CheckForNull
    public RString getIdoJiyu() {
        return idoJiyu;
    }

    /**
     * 異動事由のsetメソッドです。
     * <br/>
     * <br/>01：受給者台帳の異動（新規、区間異動等）　02：個人番号の変更による異動
     * 
     * @param idoJiyu 異動事由
     */
    public void setIdoJiyu(RString idoJiyu) {
        this.idoJiyu = idoJiyu;
    }

    /**
     * 異動区分のgetメソッドです。
     * <br/>
     * <br/>1：新規　2：変更　3：終了
     * 
     * @return 異動区分
     */
    @CheckForNull
    public RString getIdoKubunCode() {
        return idoKubunCode;
    }

    /**
     * 異動区分のsetメソッドです。
     * <br/>
     * <br/>1：新規　2：変更　3：終了
     * 
     * @param idoKubunCode 異動区分
     */
    public void setIdoKubunCode(RString idoKubunCode) {
        this.idoKubunCode = idoKubunCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3121KojinBangoJohoSofuEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3121KojinBangoJohoSofuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3121KojinBangoJohoSofuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.idoYMD, other.idoYMD)) {
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
    public void shallowCopy(DbT3121KojinBangoJohoSofuEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.idoYMD = entity.idoYMD;
        this.rirekiNo = entity.rirekiNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.kojinNo = entity.kojinNo;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shoriYM = entity.shoriYM;
        this.teiseiYMD = entity.teiseiYMD;
        this.teiseiKubunCode = entity.teiseiKubunCode;
        this.idoJiyu = entity.idoJiyu;
        this.idoKubunCode = entity.idoKubunCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, idoYMD, rirekiNo, shikibetsuCode, kojinNo, shoKisaiHokenshaNo, shoriYM, teiseiYMD, teiseiKubunCode, idoJiyu, idoKubunCode);
    }

// </editor-fold>
}
