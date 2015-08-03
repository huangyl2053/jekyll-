package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;

/**
 * DbT5106ShinsakaiWariateIinJohoの項目定義クラスです
 *
 * @author n8178 城間篤人
 */
public class DbT5106ShinsakaiWariateIinJohoEntity extends DbTableEntityBase<DbT5106ShinsakaiWariateIinJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
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
    private RString shinsakaiIinCode;
    private Code shinsainKubunCode;
    private Code gogitaichoKubunCode;
    private RString shinsakaiIinShinsaKaishiTime;
    private RString shinsakaiIinshinsaShuryoTime;
    private RString shinsakaiIinShukketsuKubun;

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
     * 介護認定審査会開催番号のgetメソッドです。
     * 
     * @return 介護認定審査会開催番号
     */
    public int getShinsakaiKaisaiNo() {
        return shinsakaiKaisaiNo;
    }

    /**
     * 介護認定審査会開催番号のsetメソッドです。
     * 
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     */
    public void setShinsakaiKaisaiNo(int shinsakaiKaisaiNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }

    /**
     * 介護認定審査会委員コードのgetメソッドです。
     * 
     * @return 介護認定審査会委員コード
     */
    public RString getShinsakaiIinCode() {
        return shinsakaiIinCode;
    }

    /**
     * 介護認定審査会委員コードのsetメソッドです。
     * 
     * @param shinsakaiIinCode 介護認定審査会委員コード
     */
    public void setShinsakaiIinCode(RString shinsakaiIinCode) {
        this.shinsakaiIinCode = shinsakaiIinCode;
    }

    /**
     * 認定審査員区分コードのgetメソッドです。
     * 
     * @return 認定審査員区分コード
     */
    public Code getShinsainKubunCode() {
        return shinsainKubunCode;
    }

    /**
     * 認定審査員区分コードのsetメソッドです。
     * 
     * @param shinsainKubunCode 認定審査員区分コード
     */
    public void setShinsainKubunCode(Code shinsainKubunCode) {
        this.shinsainKubunCode = shinsainKubunCode;
    }

    /**
     * 認定審査員区分コードの名称のgetメソッドです。
     * 
     * @return 認定審査員区分コードの名称
     */
    public RString getShinsainKubunCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.認定調査員区分, shinsainKubunCode);
    }

    /**
     * 認定審査員区分コードの略称のgetメソッドです。
     * 
     * @return 認定審査員区分コードの略称
     */
    public RString getShinsainKubunCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.認定調査員区分, shinsainKubunCode);
    }

    /**
     * 合議体長区分コードのgetメソッドです。
     * 
     * @return 合議体長区分コード
     */
    public Code getGogitaichoKubunCode() {
        return gogitaichoKubunCode;
    }

    /**
     * 合議体長区分コードのsetメソッドです。
     * 
     * @param gogitaichoKubunCode 合議体長区分コード
     */
    public void setGogitaichoKubunCode(Code gogitaichoKubunCode) {
        this.gogitaichoKubunCode = gogitaichoKubunCode;
    }

    /**
     * 合議体長区分コードの名称のgetメソッドです。
     * 
     * @return 合議体長区分コードの名称
     */
    public RString getGogitaichoKubunCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.合議体長区分, gogitaichoKubunCode);
    }

    /**
     * 合議体長区分コードの略称のgetメソッドです。
     * 
     * @return 合議体長区分コードの略称
     */
    public RString getGogitaichoKubunCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.合議体長区分, gogitaichoKubunCode);
    }

    /**
     * 介護認定審査会委員審査開始時間のgetメソッドです。
     * 
     * @return 介護認定審査会委員審査開始時間
     */
    public RString getShinsakaiIinShinsaKaishiTime() {
        return shinsakaiIinShinsaKaishiTime;
    }

    /**
     * 介護認定審査会委員審査開始時間のsetメソッドです。
     * 
     * @param shinsakaiIinShinsaKaishiTime 介護認定審査会委員審査開始時間
     */
    public void setShinsakaiIinShinsaKaishiTime(RString shinsakaiIinShinsaKaishiTime) {
        this.shinsakaiIinShinsaKaishiTime = shinsakaiIinShinsaKaishiTime;
    }

    /**
     * 介護認定審査会委員審査終了時間のgetメソッドです。
     * 
     * @return 介護認定審査会委員審査終了時間
     */
    public RString getShinsakaiIinshinsaShuryoTime() {
        return shinsakaiIinshinsaShuryoTime;
    }

    /**
     * 介護認定審査会委員審査終了時間のsetメソッドです。
     * 
     * @param shinsakaiIinshinsaShuryoTime 介護認定審査会委員審査終了時間
     */
    public void setShinsakaiIinshinsaShuryoTime(RString shinsakaiIinshinsaShuryoTime) {
        this.shinsakaiIinshinsaShuryoTime = shinsakaiIinshinsaShuryoTime;
    }

    /**
     * 介護認定審査会委員出欠区分のgetメソッドです。
     * 
     * @return 介護認定審査会委員出欠区分
     */
    public RString getShinsakaiIinShukketsuKubun() {
        return shinsakaiIinShukketsuKubun;
    }

    /**
     * 介護認定審査会委員出欠区分のsetメソッドです。
     * 
     * @param shinsakaiIinShukketsuKubun 介護認定審査会委員出欠区分
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
    @Override
    public boolean equalsPrimaryKeys(DbT5106ShinsakaiWariateIinJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (this.shinsakaiKaisaiNo != other.shinsakaiKaisaiNo) {
            return false;
        }
        if (!Objects.equals(this.shinsakaiIinCode, other.shinsakaiIinCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5106ShinsakaiWariateIinJohoEntity entity) {
        this.shinsakaiKaisaiNo = entity.shinsakaiKaisaiNo;
        this.shinsakaiIinCode = entity.shinsakaiIinCode;
        this.shinsainKubunCode = entity.shinsainKubunCode;
        this.gogitaichoKubunCode = entity.gogitaichoKubunCode;
        this.shinsakaiIinShinsaKaishiTime = entity.shinsakaiIinShinsaKaishiTime;
        this.shinsakaiIinshinsaShuryoTime = entity.shinsakaiIinshinsaShuryoTime;
        this.shinsakaiIinShukketsuKubun = entity.shinsakaiIinShukketsuKubun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinsakaiKaisaiNo, shinsakaiIinCode, shinsainKubunCode, gogitaichoKubunCode, shinsakaiIinShinsaKaishiTime, shinsakaiIinshinsaShuryoTime, shinsakaiIinShukketsuKubun);
    }

// </editor-fold>

}
