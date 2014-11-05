package jp.co.ndensan.reams.db.dbb.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;

/**
 * DbT2010FukaErrorListの項目定義クラスです
 *
 */
public class DbT2010FukaErrorListEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

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
    private KaigoHihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;

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
     * getSubGyomuCode
     *
     * @return subGyomuCode
     */
    public SubGyomuCode getSubGyomuCode() {
        return subGyomuCode;
    }

    /**
     * setSubGyomuCode
     *
     * @param subGyomuCode subGyomuCode
     */
    public void setSubGyomuCode(SubGyomuCode subGyomuCode) {
        this.subGyomuCode = subGyomuCode;
    }

    /**
     * getInternalReportId
     *
     * @return internalReportId
     */
    public RString getInternalReportId() {
        return internalReportId;
    }

    /**
     * setInternalReportId
     *
     * @param internalReportId internalReportId
     */
    public void setInternalReportId(RString internalReportId) {
        this.internalReportId = internalReportId;
    }

    /**
     * getInternalReportCreationDateTime
     *
     * @return internalReportCreationDateTime
     */
    public RDateTime getInternalReportCreationDateTime() {
        return internalReportCreationDateTime;
    }

    /**
     * setInternalReportCreationDateTime
     *
     * @param internalReportCreationDateTime internalReportCreationDateTime
     */
    public void setInternalReportCreationDateTime(RDateTime internalReportCreationDateTime) {
        this.internalReportCreationDateTime = internalReportCreationDateTime;
    }

    /**
     * getBatchId
     *
     * @return batchId
     */
    public RString getBatchId() {
        return batchId;
    }

    /**
     * setBatchId
     *
     * @param batchId batchId
     */
    public void setBatchId(RString batchId) {
        this.batchId = batchId;
    }

    /**
     * getBatchStartingDateTime
     *
     * @return batchStartingDateTime
     */
    public RDateTime getBatchStartingDateTime() {
        return batchStartingDateTime;
    }

    /**
     * setBatchStartingDateTime
     *
     * @param batchStartingDateTime batchStartingDateTime
     */
    public void setBatchStartingDateTime(RDateTime batchStartingDateTime) {
        this.batchStartingDateTime = batchStartingDateTime;
    }

    /**
     * getShoriKubunCode
     *
     * @return shoriKubunCode
     */
    public Code getShoriKubunCode() {
        return shoriKubunCode;
    }

    /**
     * setShoriKubunCode
     *
     * @param shoriKubunCode shoriKubunCode
     */
    public void setShoriKubunCode(Code shoriKubunCode) {
        this.shoriKubunCode = shoriKubunCode;
    }

    /**
     * getFukaNendo
     *
     * @return fukaNendo
     */
    public FlexibleYear getFukaNendo() {
        return fukaNendo;
    }

    /**
     * setFukaNendo
     *
     * @param fukaNendo fukaNendo
     */
    public void setFukaNendo(FlexibleYear fukaNendo) {
        this.fukaNendo = fukaNendo;
    }

    /**
     * getTsuchishoNo
     *
     * @return tsuchishoNo
     */
    public TsuchishoNo getTsuchishoNo() {
        return tsuchishoNo;
    }

    /**
     * setTsuchishoNo
     *
     * @param tsuchishoNo tsuchishoNo
     */
    public void setTsuchishoNo(TsuchishoNo tsuchishoNo) {
        this.tsuchishoNo = tsuchishoNo;
    }

    /**
     * getErrorCode
     *
     * @return errorCode
     */
    public Code getErrorCode() {
        return errorCode;
    }

    /**
     * setErrorCode
     *
     * @param errorCode errorCode
     */
    public void setErrorCode(Code errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * getErrorCodeMeisho
     *
     * @return Meisho
     */
    public RString getErrorCodeMeisho() {
        //TODO n8178 城間篤人 コードマスタに割り当てられた後に置き換え予定 2014年10月2日
//        return CodeMaster.getCodeMeisho(1, 1, errorCode);
        RString errorMeisho = RString.EMPTY;
        switch (this.errorCode.value().toString()) {
            case "01":
                errorMeisho = new RString("更正対象の賦課データに減免情報が登録されています。");
                break;
            case "02":
                errorMeisho = new RString("資格期間と住基情報に不整合があります。");
                break;
        }
        return errorMeisho;
    }

    /**
     * getErrorCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getErrorCodeRyakusho() {
        //TODO n8178 城間篤人 コードマスタに割り当てられた後に置き換え予定 2014年10月2日
//        return CodeMaster.getCodeRyakusho(1, 1, errorCode);
        RString errorRyakusho = RString.EMPTY;
        switch (this.errorCode.value().toString()) {
            case "01":
                errorRyakusho = new RString("更正対象に減免情報が登録");
                break;
            case "02":
                errorRyakusho = new RString("資格期間と住基情報に不整合");
                break;
        }
        return errorRyakusho;
    }

    /**
     * getHihokenshaNo
     *
     * @return hihokenshaNo
     */
    public KaigoHihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(KaigoHihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * getShikibetsuCode
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     *
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2010FukaErrorListEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT2010FukaErrorListEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
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

// </editor-fold>
}
