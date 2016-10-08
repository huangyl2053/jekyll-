package jp.co.ndensan.reams.db.dbu.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 特定個人情報版管理テーブルのエンティティクラスです。
 */
public class DbT7301TokuteiKojinJohoHanKanriEntity extends DbTableEntityBase<DbT7301TokuteiKojinJohoHanKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7301TokuteiKojinJohoHanKanri");

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
    private FlexibleDate hanStYMD;
    private FlexibleDate hanEdYMD;
    private RString shokaiTeikyoKubun;

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
     * 版有効開始年月日のgetメソッドです。
     *
     * @return 版有効開始年月日
     */
    @CheckForNull
    public FlexibleDate getHanStYMD() {
        return hanStYMD;
    }

    /**
     * 版有効開始年月日のsetメソッドです。
     *
     * @param hanStYMD 版有効開始年月日
     */
    public void setHanStYMD(FlexibleDate hanStYMD) {
        this.hanStYMD = hanStYMD;
    }

    /**
     * 版有効終了年月日のgetメソッドです。
     *
     * @return 版有効終了年月日
     */
    @CheckForNull
    public FlexibleDate getHanEdYMD() {
        return hanEdYMD;
    }

    /**
     * 版有効終了年月日のsetメソッドです。
     *
     * @param hanEdYMD 版有効終了年月日
     */
    public void setHanEdYMD(FlexibleDate hanEdYMD) {
        this.hanEdYMD = hanEdYMD;
    }

    /**
     * 初回提供区分のgetメソッドです。
     *
     * @return 初回提供区分
     */
    @CheckForNull
    public RString getShokaiTeikyoKubun() {
        return shokaiTeikyoKubun;
    }

    /**
     * 初回提供区分のsetメソッドです。
     *
     * @param shokaiTeikyoKubun 初回提供区分
     */
    public void setShokaiTeikyoKubun(RString shokaiTeikyoKubun) {
        this.shokaiTeikyoKubun = shokaiTeikyoKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7301TokuteiKojinJohoHanKanriEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7301TokuteiKojinJohoHanKanriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7301TokuteiKojinJohoHanKanriEntity other) {
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
    public void shallowCopy(DbT7301TokuteiKojinJohoHanKanriEntity entity) {
        this.tokuteiKojinJohoMeiCode = entity.tokuteiKojinJohoMeiCode;
        this.dataSetNo = entity.dataSetNo;
        this.hanNo = entity.hanNo;
        this.hanStYMD = entity.hanStYMD;
        this.hanEdYMD = entity.hanEdYMD;
        this.shokaiTeikyoKubun = entity.shokaiTeikyoKubun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(tokuteiKojinJohoMeiCode, dataSetNo, hanNo, hanStYMD, hanEdYMD, shokaiTeikyoKubun);
    }

// </editor-fold>
}
