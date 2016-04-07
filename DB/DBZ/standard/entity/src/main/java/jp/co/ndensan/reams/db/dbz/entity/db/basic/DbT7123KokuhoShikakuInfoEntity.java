package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 国保資格情報テーブルのエンティティクラスです。
 */
public class DbT7123KokuhoShikakuInfoEntity extends DbTableEntityBase<DbT7123KokuhoShikakuInfoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7123KokuhoShikakuInfo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private RString rirekiNo;
    private RString kokuhoNo;
    private RString kokuhoHokenshaNo;
    private RString kokuhoHokenshoNo;
    private RString kokuhoKojinNo;
    private RString shikakuShutokuYMD;
    private RString shikakuSoshitsuYMD;
    private RString taishokuGaitoYMD;
    private RString taishokuHigaitoYMD;
    private RString kojinKubunCode;
    private RString torokuKubun;

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
     * 識別コードのgetメソッドです。
     * 
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     * 
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(@Nonnull ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 履歴番号のgetメソッドです。
     * 
     * @return 履歴番号
     */
    public RString getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     * 
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(@Nonnull RString rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 国保番号のgetメソッドです。
     * 
     * @return 国保番号
     */
    @CheckForNull
    public RString getKokuhoNo() {
        return kokuhoNo;
    }

    /**
     * 国保番号のsetメソッドです。
     * 
     * @param kokuhoNo 国保番号
     */
    public void setKokuhoNo(RString kokuhoNo) {
        this.kokuhoNo = kokuhoNo;
    }

    /**
     * 国保保険者番号のgetメソッドです。
     * 
     * @return 国保保険者番号
     */
    @CheckForNull
    public RString getKokuhoHokenshaNo() {
        return kokuhoHokenshaNo;
    }

    /**
     * 国保保険者番号のsetメソッドです。
     * 
     * @param kokuhoHokenshaNo 国保保険者番号
     */
    public void setKokuhoHokenshaNo(RString kokuhoHokenshaNo) {
        this.kokuhoHokenshaNo = kokuhoHokenshaNo;
    }

    /**
     * 国保保険証番号のgetメソッドです。
     * 
     * @return 国保保険証番号
     */
    @CheckForNull
    public RString getKokuhoHokenshoNo() {
        return kokuhoHokenshoNo;
    }

    /**
     * 国保保険証番号のsetメソッドです。
     * 
     * @param kokuhoHokenshoNo 国保保険証番号
     */
    public void setKokuhoHokenshoNo(RString kokuhoHokenshoNo) {
        this.kokuhoHokenshoNo = kokuhoHokenshoNo;
    }

    /**
     * 国保個人番号のgetメソッドです。
     * 
     * @return 国保個人番号
     */
    @CheckForNull
    public RString getKokuhoKojinNo() {
        return kokuhoKojinNo;
    }

    /**
     * 国保個人番号のsetメソッドです。
     * 
     * @param kokuhoKojinNo 国保個人番号
     */
    public void setKokuhoKojinNo(RString kokuhoKojinNo) {
        this.kokuhoKojinNo = kokuhoKojinNo;
    }

    /**
     * 資格取得日のgetメソッドです。
     * 
     * @return 資格取得日
     */
    @CheckForNull
    public RString getShikakuShutokuYMD() {
        return shikakuShutokuYMD;
    }

    /**
     * 資格取得日のsetメソッドです。
     * 
     * @param shikakuShutokuYMD 資格取得日
     */
    public void setShikakuShutokuYMD(RString shikakuShutokuYMD) {
        this.shikakuShutokuYMD = shikakuShutokuYMD;
    }

    /**
     * 資格喪失日のgetメソッドです。
     * 
     * @return 資格喪失日
     */
    @CheckForNull
    public RString getShikakuSoshitsuYMD() {
        return shikakuSoshitsuYMD;
    }

    /**
     * 資格喪失日のsetメソッドです。
     * 
     * @param shikakuSoshitsuYMD 資格喪失日
     */
    public void setShikakuSoshitsuYMD(RString shikakuSoshitsuYMD) {
        this.shikakuSoshitsuYMD = shikakuSoshitsuYMD;
    }

    /**
     * 退職該当日のgetメソッドです。
     * 
     * @return 退職該当日
     */
    @CheckForNull
    public RString getTaishokuGaitoYMD() {
        return taishokuGaitoYMD;
    }

    /**
     * 退職該当日のsetメソッドです。
     * 
     * @param taishokuGaitoYMD 退職該当日
     */
    public void setTaishokuGaitoYMD(RString taishokuGaitoYMD) {
        this.taishokuGaitoYMD = taishokuGaitoYMD;
    }

    /**
     * 退職非該当日のgetメソッドです。
     * 
     * @return 退職非該当日
     */
    @CheckForNull
    public RString getTaishokuHigaitoYMD() {
        return taishokuHigaitoYMD;
    }

    /**
     * 退職非該当日のsetメソッドです。
     * 
     * @param taishokuHigaitoYMD 退職非該当日
     */
    public void setTaishokuHigaitoYMD(RString taishokuHigaitoYMD) {
        this.taishokuHigaitoYMD = taishokuHigaitoYMD;
    }

    /**
     * 個人区分コードのgetメソッドです。
     * <br/>
     * <br/>1:住基、2:外国人、3:住登外
     * 
     * @return 個人区分コード
     */
    @CheckForNull
    public RString getKojinKubunCode() {
        return kojinKubunCode;
    }

    /**
     * 個人区分コードのsetメソッドです。
     * <br/>
     * <br/>1:住基、2:外国人、3:住登外
     * 
     * @param kojinKubunCode 個人区分コード
     */
    public void setKojinKubunCode(RString kojinKubunCode) {
        this.kojinKubunCode = kojinKubunCode;
    }

    /**
     * 登録区分のgetメソッドです。
     * <br/>
     * <br/>1:画面登録、0:データ連携
     * 
     * @return 登録区分
     */
    @CheckForNull
    public RString getTorokuKubun() {
        return torokuKubun;
    }

    /**
     * 登録区分のsetメソッドです。
     * <br/>
     * <br/>1:画面登録、0:データ連携
     * 
     * @param torokuKubun 登録区分
     */
    public void setTorokuKubun(RString torokuKubun) {
        this.torokuKubun = torokuKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7123KokuhoShikakuInfoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7123KokuhoShikakuInfoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7123KokuhoShikakuInfoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.rirekiNo, other.rirekiNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7123KokuhoShikakuInfoEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.rirekiNo = entity.rirekiNo;
        this.kokuhoNo = entity.kokuhoNo;
        this.kokuhoHokenshaNo = entity.kokuhoHokenshaNo;
        this.kokuhoHokenshoNo = entity.kokuhoHokenshoNo;
        this.kokuhoKojinNo = entity.kokuhoKojinNo;
        this.shikakuShutokuYMD = entity.shikakuShutokuYMD;
        this.shikakuSoshitsuYMD = entity.shikakuSoshitsuYMD;
        this.taishokuGaitoYMD = entity.taishokuGaitoYMD;
        this.taishokuHigaitoYMD = entity.taishokuHigaitoYMD;
        this.kojinKubunCode = entity.kojinKubunCode;
        this.torokuKubun = entity.torokuKubun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, rirekiNo, kokuhoNo, kokuhoHokenshaNo, kokuhoHokenshoNo, kokuhoKojinNo, shikakuShutokuYMD, shikakuSoshitsuYMD, taishokuGaitoYMD, taishokuHigaitoYMD, kojinKubunCode, torokuKubun);
    }

// </editor-fold>
}
