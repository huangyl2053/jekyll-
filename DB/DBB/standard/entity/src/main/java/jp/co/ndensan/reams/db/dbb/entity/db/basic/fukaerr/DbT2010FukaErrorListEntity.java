package jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT2010FukaErrorListの項目定義クラスです
 *
 */
public class DbT2010FukaErrorListEntity extends DbTableEntityBase<DbT2010FukaErrorListEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT2010FukaErrorList");

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
    private RString internalReportId;
    private RDateTime internalReportCreationDateTime;
    private RString batchId;
    private RDateTime batchStartingDateTime;
    private Code shoriKubunCode;
    @PrimaryKey
    private FlexibleYear fukaNendo;
    @PrimaryKey
    private TsuchishoNo tsuchishoNo;
    private Code errorCode;
    private HihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;

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
     * 内部帳票IDのgetメソッドです。
     *
     * @return 内部帳票ID
     */
    public RString getInternalReportId() {
        return internalReportId;
    }

    /**
     * 内部帳票IDのsetメソッドです。
     *
     * @param internalReportId 内部帳票ID
     */
    public void setInternalReportId(RString internalReportId) {
        this.internalReportId = internalReportId;
    }

    /**
     * 内部帳票作成日時のgetメソッドです。
     *
     * @return 内部帳票作成日時
     */
    public RDateTime getInternalReportCreationDateTime() {
        return internalReportCreationDateTime;
    }

    /**
     * 内部帳票作成日時のsetメソッドです。
     *
     * @param internalReportCreationDateTime 内部帳票作成日時
     */
    public void setInternalReportCreationDateTime(RDateTime internalReportCreationDateTime) {
        this.internalReportCreationDateTime = internalReportCreationDateTime;
    }

    /**
     * バッチIDのgetメソッドです。
     *
     * @return バッチID
     */
    public RString getBatchId() {
        return batchId;
    }

    /**
     * バッチIDのsetメソッドです。
     *
     * @param batchId バッチID
     */
    public void setBatchId(RString batchId) {
        this.batchId = batchId;
    }

    /**
     * バッチ起動日時のgetメソッドです。
     *
     * @return バッチ起動日時
     */
    public RDateTime getBatchStartingDateTime() {
        return batchStartingDateTime;
    }

    /**
     * バッチ起動日時のsetメソッドです。
     *
     * @param batchStartingDateTime バッチ起動日時
     */
    public void setBatchStartingDateTime(RDateTime batchStartingDateTime) {
        this.batchStartingDateTime = batchStartingDateTime;
    }

    /**
     * 処理区分コードのgetメソッドです。
     *
     * @return 処理区分コード
     */
    public Code getShoriKubunCode() {
        return shoriKubunCode;
    }

    /**
     * 処理区分コードのsetメソッドです。
     *
     * @param shoriKubunCode 処理区分コード
     */
    public void setShoriKubunCode(Code shoriKubunCode) {
        this.shoriKubunCode = shoriKubunCode;
    }

    /**
     * 賦課年度のgetメソッドです。
     *
     * @return 賦課年度
     */
    public FlexibleYear getFukaNendo() {
        return fukaNendo;
    }

    /**
     * 賦課年度のsetメソッドです。
     *
     * @param fukaNendo 賦課年度
     */
    public void setFukaNendo(FlexibleYear fukaNendo) {
        this.fukaNendo = fukaNendo;
    }

    /**
     * 通知書番号のgetメソッドです。
     *
     * @return 通知書番号
     */
    public TsuchishoNo getTsuchishoNo() {
        return tsuchishoNo;
    }

    /**
     * 通知書番号のsetメソッドです。
     *
     * @param tsuchishoNo 通知書番号
     */
    public void setTsuchishoNo(TsuchishoNo tsuchishoNo) {
        this.tsuchishoNo = tsuchishoNo;
    }

    /**
     * エラーコードのgetメソッドです。
     *
     * @return エラーコード
     */
    public Code getErrorCode() {
        return errorCode;
    }

    /**
     * エラーコードのsetメソッドです。
     *
     * @param errorCode エラーコード
     */
    public void setErrorCode(Code errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * エラーコードの名称のgetメソッドです。
     *
     * @return エラーコードの名称
     */
    public RString getErrorCodeMeisho() {
        return CodeMaster.getCodeMeisho(CodeShubetsu.EMPTY, errorCode);
    }

    /**
     * エラーコードの略称のgetメソッドです。
     *
     * @return エラーコードの略称
     */
    public RString getErrorCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(CodeShubetsu.EMPTY, errorCode);
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
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2010FukaErrorListEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT2010FukaErrorListEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2010FukaErrorListEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.subGyomuCode, other.subGyomuCode)) {
            return false;
        }
        if (!Objects.equals(this.internalReportId, other.internalReportId)) {
            return false;
        }
        if (!Objects.equals(this.fukaNendo, other.fukaNendo)) {
            return false;
        }
        if (!Objects.equals(this.tsuchishoNo, other.tsuchishoNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT2010FukaErrorListEntity entity) {
        this.subGyomuCode = entity.subGyomuCode;
        this.internalReportId = entity.internalReportId;
        this.internalReportCreationDateTime = entity.internalReportCreationDateTime;
        this.batchId = entity.batchId;
        this.batchStartingDateTime = entity.batchStartingDateTime;
        this.shoriKubunCode = entity.shoriKubunCode;
        this.fukaNendo = entity.fukaNendo;
        this.tsuchishoNo = entity.tsuchishoNo;
        this.errorCode = entity.errorCode;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shikibetsuCode = entity.shikibetsuCode;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(subGyomuCode, internalReportId, internalReportCreationDateTime, batchId, batchStartingDateTime, shoriKubunCode, fukaNendo, tsuchishoNo, errorCode, hihokenshaNo, shikibetsuCode);
    }

// </editor-fold>
}
