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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.definition.DbeShubetsuKey;

/**
 * DbT5106ShinsakaiWariateIinJohoの項目定義クラスです
 *
 * @author n8178 城間篤人
 */
public class DbT5106ShinsakaiWariateIinJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5106ShinsakaiWariateIinJoho");
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private int shinsakaiKaisaiNo;
    @PrimaryKey
    private FlexibleDate shinsakaiKaisaiYMD;
    @PrimaryKey
    private RString shinsakaiIinCode;
    private Code shinsainKubunCode;
    private Code gogitaichoKubunCode;
    private RString shinsakaiIinShinsaKaishiTime;
    private RString shinsakaiIinshinsaShuryoTime;
    private RString shinsakaiIinShukketsuKubun;

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
     * getShinsakaiKaisaiNo
     *
     * @return shinsakaiKaisaiNo
     */
    public int getShinsakaiKaisaiNo() {
        return shinsakaiKaisaiNo;
    }

    /**
     * setShinsakaiKaisaiNo
     *
     * @param shinsakaiKaisaiNo shinsakaiKaisaiNo
     */
    public void setShinsakaiKaisaiNo(int shinsakaiKaisaiNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }

    /**
     * getShinsakaiKaisaiYMD
     *
     * @return shinsakaiKaisaiYMD
     */
    public FlexibleDate getShinsakaiKaisaiYMD() {
        return shinsakaiKaisaiYMD;
    }

    /**
     * setShinsakaiKaisaiYMD
     *
     * @param shinsakaiKaisaiYMD shinsakaiKaisaiYMD
     */
    public void setShinsakaiKaisaiYMD(FlexibleDate shinsakaiKaisaiYMD) {
        this.shinsakaiKaisaiYMD = shinsakaiKaisaiYMD;
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
     * getShinsainKubunCodeMeisho
     *
     * @return Meisho
     */
    public RString getShinsainKubunCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.認定審査員区分, shinsainKubunCode);
    }

    /**
     * getShinsainKubunCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getShinsainKubunCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.認定審査員区分, shinsainKubunCode);
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

    /**
     * getGogitaichoKubunCodeMeisho
     *
     * @return Meisho
     */
    public RString getGogitaichoKubunCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.合議体長区分, gogitaichoKubunCode);
    }

    /**
     * getGogitaichoKubunCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getGogitaichoKubunCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.合議体長区分, gogitaichoKubunCode);
    }

    /**
     * getShinsakaiIinShinsaKaishiTime
     *
     * @return shinsakaiIinShinsaKaishiTime
     */
    public RString getShinsakaiIinShinsaKaishiTime() {
        return shinsakaiIinShinsaKaishiTime;
    }

    /**
     * setShinsakaiIinShinsaKaishiTime
     *
     * @param shinsakaiIinShinsaKaishiTime shinsakaiIinShinsaKaishiTime
     */
    public void setShinsakaiIinShinsaKaishiTime(RString shinsakaiIinShinsaKaishiTime) {
        this.shinsakaiIinShinsaKaishiTime = shinsakaiIinShinsaKaishiTime;
    }

    /**
     * getShinsakaiIinshinsaShuryoTime
     *
     * @return shinsakaiIinshinsaShuryoTime
     */
    public RString getShinsakaiIinshinsaShuryoTime() {
        return shinsakaiIinshinsaShuryoTime;
    }

    /**
     * setShinsakaiIinshinsaShuryoTime
     *
     * @param shinsakaiIinshinsaShuryoTime shinsakaiIinshinsaShuryoTime
     */
    public void setShinsakaiIinshinsaShuryoTime(RString shinsakaiIinshinsaShuryoTime) {
        this.shinsakaiIinshinsaShuryoTime = shinsakaiIinshinsaShuryoTime;
    }

    /**
     * getShinsakaiIinShukketsuKubun
     *
     * @return shinsakaiIinShukketsuKubun
     */
    public RString getShinsakaiIinShukketsuKubun() {
        return shinsakaiIinShukketsuKubun;
    }

    /**
     * setShinsakaiIinShukketsuKubun
     *
     * @param shinsakaiIinShukketsuKubun shinsakaiIinShukketsuKubun
     */
    public void setShinsakaiIinShukketsuKubun(RString shinsakaiIinShukketsuKubun) {
        this.shinsakaiIinShukketsuKubun = shinsakaiIinShukketsuKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5106ShinsakaiWariateIinJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5106ShinsakaiWariateIinJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT5106ShinsakaiWariateIinJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (this.shinsakaiKaisaiNo != other.shinsakaiKaisaiNo) {
            return false;
        }
        if (!Objects.equals(this.shinsakaiKaisaiYMD, other.shinsakaiKaisaiYMD)) {
            return false;
        }
        if (!Objects.equals(this.shinsakaiIinCode, other.shinsakaiIinCode)) {
            return false;
        }
        return true;
    }
// </editor-fold>
}
