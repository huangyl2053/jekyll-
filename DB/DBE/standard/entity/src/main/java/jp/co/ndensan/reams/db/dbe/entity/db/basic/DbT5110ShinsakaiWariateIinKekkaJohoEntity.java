package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;

/**
 * 介護認定審査会割当委員結果情報テーブルのエンティティクラスです。
 */
public class DbT5110ShinsakaiWariateIinKekkaJohoEntity extends DbTableEntityBase<DbT5110ShinsakaiWariateIinKekkaJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5110ShinsakaiWariateIinKekkaJoho");

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
    private FlexibleDate shinsakaiKaisaiYMD;
    private Code shinsainKubunCode;
    private Code gogitaichoKubunCode;
    private boolean isShusseki;
    private boolean isChikokuUmu;
    private RString shussekiTime;
    private boolean isSotaiUmu;
    private RString taisekiTime;

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
     * 介護認定審査会開催年月日のgetメソッドです。
     * 
     * @return 介護認定審査会開催年月日
     */
    public FlexibleDate getShinsakaiKaisaiYMD() {
        return shinsakaiKaisaiYMD;
    }

    /**
     * 介護認定審査会開催年月日のsetメソッドです。
     * 
     * @param shinsakaiKaisaiYMD 介護認定審査会開催年月日
     */
    public void setShinsakaiKaisaiYMD(FlexibleDate shinsakaiKaisaiYMD) {
        this.shinsakaiKaisaiYMD = shinsakaiKaisaiYMD;
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
     * 委員出席のgetメソッドです。
     * 
     * @return 委員出席
     */
    public boolean getIsShusseki() {
        return isShusseki;
    }

    /**
     * 委員出席のsetメソッドです。
     * 
     * @param isShusseki 委員出席
     */
    public void setIsShusseki(boolean isShusseki) {
        this.isShusseki = isShusseki;
    }

    /**
     * 委員遅刻有無のgetメソッドです。
     * 
     * @return 委員遅刻有無
     */
    public boolean getIsChikokuUmu() {
        return isChikokuUmu;
    }

    /**
     * 委員遅刻有無のsetメソッドです。
     * 
     * @param isChikokuUmu 委員遅刻有無
     */
    public void setIsChikokuUmu(boolean isChikokuUmu) {
        this.isChikokuUmu = isChikokuUmu;
    }

    /**
     * 委員出席時間のgetメソッドです。
     * 
     * @return 委員出席時間
     */
    public RString getShussekiTime() {
        return shussekiTime;
    }

    /**
     * 委員出席時間のsetメソッドです。
     * 
     * @param shussekiTime 委員出席時間
     */
    public void setShussekiTime(RString shussekiTime) {
        this.shussekiTime = shussekiTime;
    }

    /**
     * 委員早退有無のgetメソッドです。
     * 
     * @return 委員早退有無
     */
    public boolean getIsSotaiUmu() {
        return isSotaiUmu;
    }

    /**
     * 委員早退有無のsetメソッドです。
     * 
     * @param isSotaiUmu 委員早退有無
     */
    public void setIsSotaiUmu(boolean isSotaiUmu) {
        this.isSotaiUmu = isSotaiUmu;
    }

    /**
     * 委員退席時間のgetメソッドです。
     * 
     * @return 委員退席時間
     */
    public RString getTaisekiTime() {
        return taisekiTime;
    }

    /**
     * 委員退席時間のsetメソッドです。
     * 
     * @param taisekiTime 委員退席時間
     */
    public void setTaisekiTime(RString taisekiTime) {
        this.taisekiTime = taisekiTime;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5110ShinsakaiWariateIinKekkaJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5110ShinsakaiWariateIinKekkaJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5110ShinsakaiWariateIinKekkaJohoEntity other) {
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
    public void shallowCopy(DbT5110ShinsakaiWariateIinKekkaJohoEntity entity) {
        this.shinsakaiKaisaiNo = entity.shinsakaiKaisaiNo;
        this.shinsakaiIinCode = entity.shinsakaiIinCode;
        this.shinsakaiKaisaiYMD = entity.shinsakaiKaisaiYMD;
        this.shinsainKubunCode = entity.shinsainKubunCode;
        this.gogitaichoKubunCode = entity.gogitaichoKubunCode;
        this.isShusseki = entity.isShusseki;
        this.isChikokuUmu = entity.isChikokuUmu;
        this.shussekiTime = entity.shussekiTime;
        this.isSotaiUmu = entity.isSotaiUmu;
        this.taisekiTime = entity.taisekiTime;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinsakaiKaisaiNo, shinsakaiIinCode, shinsakaiKaisaiYMD, shinsainKubunCode, gogitaichoKubunCode, isShusseki, isChikokuUmu, shussekiTime, isSotaiUmu, taisekiTime);
    }

// </editor-fold>
}
