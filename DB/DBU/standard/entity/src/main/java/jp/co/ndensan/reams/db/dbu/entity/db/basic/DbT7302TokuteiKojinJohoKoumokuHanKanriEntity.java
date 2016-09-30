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
 * 特定個人情報項目版管理テーブルのエンティティクラスです。
 */
public class DbT7302TokuteiKojinJohoKoumokuHanKanriEntity extends DbTableEntityBase<DbT7302TokuteiKojinJohoKoumokuHanKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7302TokuteiKojinJohoKoumokuHanKanri");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private RString koban;
    @PrimaryKey
    private RString tokuteiKojinJohoKomokuCode;
    @PrimaryKey
    private RString tokuteiKojinJohoMeiCode;
    @PrimaryKey
    private RString codeRenban;
    @PrimaryKey
    private RString versionJoho;
    private RString mukokaFlag;
    private RDateTime yukoStNichiji;
    private RDateTime yukoEdNichiji;
    private RString tokuteiKojinJohoKomokuMei;

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
     * 項番のgetメソッドです。
     *
     * @return 項番
     */
    @CheckForNull
    public RString getKoban() {
        return koban;
    }

    /**
     * 項番のsetメソッドです。
     *
     * @param koban 項番
     */
    public void setKoban(RString koban) {
        this.koban = koban;
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
     * コード連番のgetメソッドです。
     *
     * @return コード連番
     */
    public RString getCodeRenban() {
        return codeRenban;
    }

    /**
     * コード連番のsetメソッドです。
     *
     * @param codeRenban コード連番
     */
    public void setCodeRenban(@Nonnull RString codeRenban) {
        this.codeRenban = codeRenban;
    }

    /**
     * バージョン情報のgetメソッドです。
     *
     * @return バージョン情報
     */
    public RString getVersionJoho() {
        return versionJoho;
    }

    /**
     * バージョン情報のsetメソッドです。
     *
     * @param versionJoho バージョン情報
     */
    public void setVersionJoho(@Nonnull RString versionJoho) {
        this.versionJoho = versionJoho;
    }

    /**
     * 無効化フラグのgetメソッドです。
     *
     * @return 無効化フラグ
     */
    @CheckForNull
    public RString getMukokaFlag() {
        return mukokaFlag;
    }

    /**
     * 無効化フラグのsetメソッドです。
     *
     * @param mukokaFlag 無効化フラグ
     */
    public void setMukokaFlag(RString mukokaFlag) {
        this.mukokaFlag = mukokaFlag;
    }

    /**
     * 有効開始日時のgetメソッドです。
     *
     * @return 有効開始日時
     */
    @CheckForNull
    public RDateTime getYukoStNichiji() {
        return yukoStNichiji;
    }

    /**
     * 有効開始日時のsetメソッドです。
     *
     * @param yukoStNichiji 有効開始日時
     */
    public void setYukoStNichiji(RDateTime yukoStNichiji) {
        this.yukoStNichiji = yukoStNichiji;
    }

    /**
     * 有効終了日時のgetメソッドです。
     *
     * @return 有効終了日時
     */
    @CheckForNull
    public RDateTime getYukoEdNichiji() {
        return yukoEdNichiji;
    }

    /**
     * 有効終了日時のsetメソッドです。
     *
     * @param yukoEdNichiji 有効終了日時
     */
    public void setYukoEdNichiji(RDateTime yukoEdNichiji) {
        this.yukoEdNichiji = yukoEdNichiji;
    }

    /**
     * 特定個人情報の項目名のgetメソッドです。
     *
     * @return 特定個人情報の項目名
     */
    @CheckForNull
    public RString getTokuteiKojinJohoKomokuMei() {
        return tokuteiKojinJohoKomokuMei;
    }

    /**
     * 特定個人情報の項目名のsetメソッドです。
     *
     * @param tokuteiKojinJohoKomokuMei 特定個人情報の項目名
     */
    public void setTokuteiKojinJohoKomokuMei(RString tokuteiKojinJohoKomokuMei) {
        this.tokuteiKojinJohoKomokuMei = tokuteiKojinJohoKomokuMei;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7302TokuteiKojinJohoKoumokuHanKanriEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7302TokuteiKojinJohoKoumokuHanKanriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7302TokuteiKojinJohoKoumokuHanKanriEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.tokuteiKojinJohoKomokuCode, other.tokuteiKojinJohoKomokuCode)) {
            return false;
        }
        if (!Objects.equals(this.tokuteiKojinJohoMeiCode, other.tokuteiKojinJohoMeiCode)) {
            return false;
        }
        if (!Objects.equals(this.codeRenban, other.codeRenban)) {
            return false;
        }
        if (!Objects.equals(this.versionJoho, other.versionJoho)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7302TokuteiKojinJohoKoumokuHanKanriEntity entity) {
        this.koban = entity.koban;
        this.tokuteiKojinJohoKomokuCode = entity.tokuteiKojinJohoKomokuCode;
        this.tokuteiKojinJohoMeiCode = entity.tokuteiKojinJohoMeiCode;
        this.codeRenban = entity.codeRenban;
        this.versionJoho = entity.versionJoho;
        this.mukokaFlag = entity.mukokaFlag;
        this.yukoStNichiji = entity.yukoStNichiji;
        this.yukoEdNichiji = entity.yukoEdNichiji;
        this.tokuteiKojinJohoKomokuMei = entity.tokuteiKojinJohoKomokuMei;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(koban, tokuteiKojinJohoKomokuCode, tokuteiKojinJohoMeiCode, codeRenban, versionJoho, mukokaFlag, yukoStNichiji, yukoEdNichiji, tokuteiKojinJohoKomokuMei);
    }

// </editor-fold>
}
