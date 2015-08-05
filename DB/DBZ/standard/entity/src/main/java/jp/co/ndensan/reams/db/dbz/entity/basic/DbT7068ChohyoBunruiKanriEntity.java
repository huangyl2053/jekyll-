package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import java.util.Objects;

/**
 * 帳票分類管理テーブルのエンティティクラスです。
 * <br/> 帳票IDに対して帳票種類ID（帳票制御情報の管理単位）を管理します。
 */
public class DbT7068ChohyoBunruiKanriEntity extends DbTableEntityBase<DbT7068ChohyoBunruiKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7068ChohyoBunruiKanri");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private SubGyomuCode subGyomuCode;
    @PrimaryKey
    private ReportId reportID;
    private ReportId chohyoBunruiID;

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
     * サブ業務コードのgetメソッドです。
     *
     * @return サブ業務コード
     */
    public SubGyomuCode getSubGyomuCode() {
        return subGyomuCode;
    }

    /**
     * サブ業務コードのsetメソッドです。
     *
     * @param subGyomuCode サブ業務コード
     */
    public void setSubGyomuCode(SubGyomuCode subGyomuCode) {
        this.subGyomuCode = subGyomuCode;
    }

    /**
     * 帳票IDのgetメソッドです。
     *
     * @return 帳票ID
     */
    public ReportId getReportID() {
        return reportID;
    }

    /**
     * 帳票IDのsetメソッドです。
     *
     * @param reportID 帳票ID
     */
    public void setReportID(ReportId reportID) {
        this.reportID = reportID;
    }

    /**
     * 帳票分類IDのgetメソッドです。
     *
     * @return 帳票分類ID
     */
    public ReportId getChohyoBunruiID() {
        return chohyoBunruiID;
    }

    /**
     * 帳票分類IDのsetメソッドです。
     *
     * @param chohyoBunruiID 帳票分類ID
     */
    public void setChohyoBunruiID(ReportId chohyoBunruiID) {
        this.chohyoBunruiID = chohyoBunruiID;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7068ChohyoBunruiKanriEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7068ChohyoBunruiKanriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7068ChohyoBunruiKanriEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.subGyomuCode, other.subGyomuCode)) {
            return false;
        }
        if (!Objects.equals(this.reportID, other.reportID)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7068ChohyoBunruiKanriEntity entity) {
        this.subGyomuCode = entity.subGyomuCode;
        this.reportID = entity.reportID;
        this.chohyoBunruiID = entity.chohyoBunruiID;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(subGyomuCode, reportID, chohyoBunruiID);
    }

// </editor-fold>
}
