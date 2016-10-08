package jp.co.ndensan.reams.db.dbu.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 特定個人情報提供項目テーブルのエンティティクラスです。
 */
public class DbT7303TokuteiKojinJohoTeikyoKomokuEntity extends DbTableEntityBase<DbT7303TokuteiKojinJohoTeikyoKomokuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7303TokuteiKojinJohoTeikyoKomoku");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString tokuteiKojinJohoMeiCode;
    @PrimaryKey
    private RString dataSetNo;
    @PrimaryKey
    private RString hanNo;
    private RString tokuteiKojinJohoKomokuCode;
    private RString tokuteiKojinJohoKomokuKubun;
    private RString teikyoNaiyoKomokuNo;

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
     * 特定個人情報名コードのgetメソッドです。
     *
     * @return 特定個人情報名コード
     */
    public RString getTokuteiKojinJohoMeiCode() {
        return tokuteiKojinJohoMeiCode;
    }

    /**
     * 特定個人情報名コードのsetメソッドです。
     *
     * @param tokuteiKojinJohoMeiCode 特定個人情報名コード
     */
    public void setTokuteiKojinJohoMeiCode(@Nonnull RString tokuteiKojinJohoMeiCode) {
        this.tokuteiKojinJohoMeiCode = tokuteiKojinJohoMeiCode;
    }

    /**
     * データセット番号のgetメソッドです。
     *
     * @return データセット番号
     */
    public RString getDataSetNo() {
        return dataSetNo;
    }

    /**
     * データセット番号のsetメソッドです。
     *
     * @param dataSetNo データセット番号
     */
    public void setDataSetNo(@Nonnull RString dataSetNo) {
        this.dataSetNo = dataSetNo;
    }

    /**
     * 版番号のgetメソッドです。
     *
     * @return 版番号
     */
    public RString getHanNo() {
        return hanNo;
    }

    /**
     * 版番号のsetメソッドです。
     *
     * @param hanNo 版番号
     */
    public void setHanNo(@Nonnull RString hanNo) {
        this.hanNo = hanNo;
    }

    /**
     * 特定個人情報項目コードのgetメソッドです。
     *
     * @return 特定個人情報項目コード
     */
    public RString getTokuteiKojinJohoKomokuCode() {
        return tokuteiKojinJohoKomokuCode;
    }

    /**
     * 特定個人情報項目コードのsetメソッドです。
     *
     * @param tokuteiKojinJohoKomokuCode 特定個人情報項目コード
     */
    public void setTokuteiKojinJohoKomokuCode(@Nonnull RString tokuteiKojinJohoKomokuCode) {
        this.tokuteiKojinJohoKomokuCode = tokuteiKojinJohoKomokuCode;
    }

    /**
     * 特定個人情報項目区分のgetメソッドです。
     *
     * @return 特定個人情報項目区分
     */
    @CheckForNull
    public RString getTokuteiKojinJohoKomokuKubun() {
        return tokuteiKojinJohoKomokuKubun;
    }

    /**
     * 特定個人情報項目区分のsetメソッドです。
     *
     * @param tokuteiKojinJohoKomokuKubun 特定個人情報項目区分
     */
    public void setTokuteiKojinJohoKomokuKubun(RString tokuteiKojinJohoKomokuKubun) {
        this.tokuteiKojinJohoKomokuKubun = tokuteiKojinJohoKomokuKubun;
    }

    /**
     * 提供内容項目番号のgetメソッドです。
     *
     * @return 提供内容項目番号
     */
    @CheckForNull
    public RString getTeikyoNaiyoKomokuNo() {
        return teikyoNaiyoKomokuNo;
    }

    /**
     * 提供内容項目番号のsetメソッドです。
     *
     * @param teikyoNaiyoKomokuNo 提供内容項目番号
     */
    public void setTeikyoNaiyoKomokuNo(RString teikyoNaiyoKomokuNo) {
        this.teikyoNaiyoKomokuNo = teikyoNaiyoKomokuNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7303TokuteiKojinJohoTeikyoKomokuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7303TokuteiKojinJohoTeikyoKomokuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7303TokuteiKojinJohoTeikyoKomokuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.tokuteiKojinJohoMeiCode, other.tokuteiKojinJohoMeiCode)) {
            return false;
        }
        if (!Objects.equals(this.dataSetNo, other.dataSetNo)) {
            return false;
        }
        if (!Objects.equals(this.hanNo, other.hanNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7303TokuteiKojinJohoTeikyoKomokuEntity entity) {
        this.tokuteiKojinJohoMeiCode = entity.tokuteiKojinJohoMeiCode;
        this.dataSetNo = entity.dataSetNo;
        this.hanNo = entity.hanNo;
        this.tokuteiKojinJohoKomokuCode = entity.tokuteiKojinJohoKomokuCode;
        this.tokuteiKojinJohoKomokuKubun = entity.tokuteiKojinJohoKomokuKubun;
        this.teikyoNaiyoKomokuNo = entity.teikyoNaiyoKomokuNo;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(tokuteiKojinJohoMeiCode, dataSetNo, hanNo, tokuteiKojinJohoKomokuCode, tokuteiKojinJohoKomokuKubun, teikyoNaiyoKomokuNo);
    }

// </editor-fold>
}
