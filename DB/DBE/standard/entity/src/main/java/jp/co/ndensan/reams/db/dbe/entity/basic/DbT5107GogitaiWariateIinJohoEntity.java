package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * DbT5107GogitaiWariateIinJohoの項目定義クラスです
 *
 * @author n8178 城間篤人
 */
public class DbT5107GogitaiWariateIinJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5107GogitaiWariateIinJoho");
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private int gogitaiNo;
    @PrimaryKey
    private FlexibleDate gogitaiYukoKikanKaishiYMD;
    private FlexibleDate gogitaiYukoKikanShuryoYMD;
    @PrimaryKey
    private RString shinsakaiIinCode;
    private Code shinsainKubunCode;
    private Code gogitaichoKubunCode;

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
     * getGogitaiNo
     *
     * @return gogitaiNo
     */
    public int getGogitaiNo() {
        return gogitaiNo;
    }

    /**
     * setGogitaiNo
     *
     * @param gogitaiNo gogitaiNo
     */
    public void setGogitaiNo(int gogitaiNo) {
        this.gogitaiNo = gogitaiNo;
    }

    /**
     * getGogitaiYukoKikanKaishiYMD
     *
     * @return gogitaiYukoKikanKaishiYMD
     */
    public FlexibleDate getGogitaiYukoKikanKaishiYMD() {
        return gogitaiYukoKikanKaishiYMD;
    }

    /**
     * setGogitaiYukoKikanKaishiYMD
     *
     * @param gogitaiYukoKikanKaishiYMD gogitaiYukoKikanKaishiYMD
     */
    public void setGogitaiYukoKikanKaishiYMD(FlexibleDate gogitaiYukoKikanKaishiYMD) {
        this.gogitaiYukoKikanKaishiYMD = gogitaiYukoKikanKaishiYMD;
    }

    /**
     * getGogitaiYukoKikanShuryoYMD
     *
     * @return gogitaiYukoKikanShuryoYMD
     */
    public FlexibleDate getGogitaiYukoKikanShuryoYMD() {
        return gogitaiYukoKikanShuryoYMD;
    }

    /**
     * setGogitaiYukoKikanShuryoYMD
     *
     * @param gogitaiYukoKikanShuryoYMD gogitaiYukoKikanShuryoYMD
     */
    public void setGogitaiYukoKikanShuryoYMD(FlexibleDate gogitaiYukoKikanShuryoYMD) {
        this.gogitaiYukoKikanShuryoYMD = gogitaiYukoKikanShuryoYMD;
    }

    /**
     * getShinsakaiIinCode
     *
     * @return shinsakaiIinCode
     */
    public RString getShinsakaiIinCode() {
        return shinsakaiIinCode;
    }

    /**
     * setShinsakaiIinCode
     *
     * @param shinsakaiIinCode shinsakaiIinCode
     */
    public void setShinsakaiIinCode(RString shinsakaiIinCode) {
        this.shinsakaiIinCode = shinsakaiIinCode;
    }

    /**
     * getShinsainKubunCode
     *
     * @return shinsainKubunCode
     */
    public Code getShinsainKubunCode() {
        return shinsainKubunCode;
    }

    /**
     * setShinsainKubunCode
     *
     * @param shinsainKubunCode shinsainKubunCode
     */
    public void setShinsainKubunCode(Code shinsainKubunCode) {
        this.shinsainKubunCode = shinsainKubunCode;
    }

    /**
     * getGogitaichoKubunCode
     *
     * @return gogitaichoKubunCode
     */
    public Code getGogitaichoKubunCode() {
        return gogitaichoKubunCode;
    }

    /**
     * setGogitaichoKubunCode
     *
     * @param gogitaichoKubunCode gogitaichoKubunCode
     */
    public void setGogitaichoKubunCode(Code gogitaichoKubunCode) {
        this.gogitaichoKubunCode = gogitaichoKubunCode;
    }
// </editor-fold>

    /**
     * 審査会区分の名称をコードマスタから取得します。
     *
     * @return 審査会区分の名称
     */
    public RString getShinsainKubunName() {
        //TODO n8178 城間篤人 コードマスタが用意されてから実装予定 2014年3月末
        //return CodeMaster.getCodeMeisho(new RString("db01"), shinsainKubunCode.getColumnValue());
        return new RString("審査員区分");
    }

    /**
     * 合議体長区分の名称をコードマスタから取得します。
     *
     * @return 合議体区分の名称
     */
    public RString getGogitaichoKubunName() {
        //TODO n8178 城間篤人 コードマスタが用意されてから実装予定 2014年3月末
        //return CodeMaster.getCodeMeisho(new RString("db02"), gogitaichoKubunCode.getColumnValue());
        return new RString("合議体長区分");
    }
}
