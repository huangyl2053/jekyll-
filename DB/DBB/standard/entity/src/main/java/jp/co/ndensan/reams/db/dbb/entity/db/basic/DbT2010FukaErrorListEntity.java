package jp.co.ndensan.reams.db.dbb.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
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
    @PrimaryKey
    private FlexibleYear fukaNendo;
    @PrimaryKey
    private TsuchishoNo tsuchishoNo;
    private RDateTime internalReportCreationDateTime;
    private RString batchId;
    private RDateTime batchStartingDateTime;
    private Code errorCode;
    private HihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private Code shoriKubunCode;
    private FlexibleDate shikakuShutokuYMD;
    private RString shikakuShutokuJiyu;
    private FlexibleDate shikakuSoshitsuYMD;
    private RString shikakuSoshitsuJiyu;

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
    public void setSubGyomuCode(@Nonnull SubGyomuCode subGyomuCode) {
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
    public void setInternalReportId(@Nonnull RString internalReportId) {
        this.internalReportId = internalReportId;
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
    public void setFukaNendo(@Nonnull FlexibleYear fukaNendo) {
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
    public void setTsuchishoNo(@Nonnull TsuchishoNo tsuchishoNo) {
        this.tsuchishoNo = tsuchishoNo;
    }

    /**
     * 内部帳票作成日時のgetメソッドです。
     * 
     * @return 内部帳票作成日時
     */
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
     * エラーコードのgetメソッドです。
     * 
     * @return エラーコード
     */
    @CheckForNull
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
    @CheckForNull
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
     * 処理区分コードのgetメソッドです。
     * 
     * @return 処理区分コード
     */
    @CheckForNull
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
     * 資格取得日のgetメソッドです。
     * 
     * @return 資格取得日
     */
    @CheckForNull
    public FlexibleDate getShikakuShutokuYMD() {
        return shikakuShutokuYMD;
    }

    /**
     * 資格取得日のsetメソッドです。
     * 
     * @param shikakuShutokuYMD 資格取得日
     */
    public void setShikakuShutokuYMD(FlexibleDate shikakuShutokuYMD) {
        this.shikakuShutokuYMD = shikakuShutokuYMD;
    }

    /**
     * 資格取得事由のgetメソッドです。
     * 
     * @return 資格取得事由
     */
    @CheckForNull
    public RString getShikakuShutokuJiyu() {
        return shikakuShutokuJiyu;
    }

    /**
     * 資格取得事由のsetメソッドです。
     * 
     * @param shikakuShutokuJiyu 資格取得事由
     */
    public void setShikakuShutokuJiyu(RString shikakuShutokuJiyu) {
        this.shikakuShutokuJiyu = shikakuShutokuJiyu;
    }

    /**
     * 資格喪失日のgetメソッドです。
     * 
     * @return 資格喪失日
     */
    @CheckForNull
    public FlexibleDate getShikakuSoshitsuYMD() {
        return shikakuSoshitsuYMD;
    }

    /**
     * 資格喪失日のsetメソッドです。
     * 
     * @param shikakuSoshitsuYMD 資格喪失日
     */
    public void setShikakuSoshitsuYMD(FlexibleDate shikakuSoshitsuYMD) {
        this.shikakuSoshitsuYMD = shikakuSoshitsuYMD;
    }

    /**
     * 資格喪失事由のgetメソッドです。
     * 
     * @return 資格喪失事由
     */
    @CheckForNull
    public RString getShikakuSoshitsuJiyu() {
        return shikakuSoshitsuJiyu;
    }

    /**
     * 資格喪失事由のsetメソッドです。
     * 
     * @param shikakuSoshitsuJiyu 資格喪失事由
     */
    public void setShikakuSoshitsuJiyu(RString shikakuSoshitsuJiyu) {
        this.shikakuSoshitsuJiyu = shikakuSoshitsuJiyu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2010FukaErrorListEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT2010FukaErrorListEntity}の場合{@literal true}、それ以外の場合は{@literal false}
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
        this.fukaNendo = entity.fukaNendo;
        this.tsuchishoNo = entity.tsuchishoNo;
        this.internalReportCreationDateTime = entity.internalReportCreationDateTime;
        this.batchId = entity.batchId;
        this.batchStartingDateTime = entity.batchStartingDateTime;
        this.errorCode = entity.errorCode;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.shoriKubunCode = entity.shoriKubunCode;
        this.shikakuShutokuYMD = entity.shikakuShutokuYMD;
        this.shikakuShutokuJiyu = entity.shikakuShutokuJiyu;
        this.shikakuSoshitsuYMD = entity.shikakuSoshitsuYMD;
        this.shikakuSoshitsuJiyu = entity.shikakuSoshitsuJiyu;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(subGyomuCode, internalReportId, fukaNendo, tsuchishoNo, internalReportCreationDateTime, batchId, batchStartingDateTime, errorCode, hihokenshaNo, shikibetsuCode, shoriKubunCode, shikakuShutokuYMD, shikakuShutokuJiyu, shikakuSoshitsuYMD, shikakuSoshitsuJiyu);
    }

// </editor-fold>

}
