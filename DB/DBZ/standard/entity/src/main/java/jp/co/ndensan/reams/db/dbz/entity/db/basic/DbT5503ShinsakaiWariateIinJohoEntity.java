package jp.co.ndensan.reams.db.dbz.entity.db.basic;

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
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 介護認定審査会割当委員情報テーブルのエンティティクラスです。
 */
public class DbT5503ShinsakaiWariateIinJohoEntity extends DbTableEntityBase<DbT5503ShinsakaiWariateIinJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5503ShinsakaiWariateIinJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString shinsakaiKaisaiNo;
    @PrimaryKey
    private RString shinsakaiIinCode;
    private FlexibleDate shinsakaiKaisaiYMD;
    private Code kaigoninteiShinsakaiGichoKubunCode;
    private boolean shussekiFlag;
    private boolean existChikokuFlag;
    private RString shussekiTime;
    private boolean existSotaiFlag;
    private RString taisekiTime;

    /**
     * コンストラクタです。
     */
    public DbT5503ShinsakaiWariateIinJohoEntity() {
        shinsakaiKaisaiNo = RString.EMPTY;
        shinsakaiIinCode = RString.EMPTY;
        shinsakaiKaisaiYMD = FlexibleDate.EMPTY;
        kaigoninteiShinsakaiGichoKubunCode = Code.EMPTY;
        shussekiFlag = false;
        existChikokuFlag = false;
        shussekiTime = RString.EMPTY;
        existSotaiFlag = false;
        taisekiTime = RString.EMPTY;
    }

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
     * <br/>
     * <br/>介護認定審査会開催予定情報
     *
     * @return 介護認定審査会開催番号
     */
    public RString getShinsakaiKaisaiNo() {
        return shinsakaiKaisaiNo;
    }

    /**
     * 介護認定審査会開催番号のsetメソッドです。
     * <br/>
     * <br/>介護認定審査会開催予定情報
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     */
    public void setShinsakaiKaisaiNo(@Nonnull RString shinsakaiKaisaiNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }

    /**
     * 介護認定審査会委員コードのgetメソッドです。
     * <br/>
     * <br/>介護認定審査会委員情報
     *
     * @return 介護認定審査会委員コード
     */
    public RString getShinsakaiIinCode() {
        return shinsakaiIinCode;
    }

    /**
     * 介護認定審査会委員コードのsetメソッドです。
     * <br/>
     * <br/>介護認定審査会委員情報
     *
     * @param shinsakaiIinCode 介護認定審査会委員コード
     */
    public void setShinsakaiIinCode(@Nonnull RString shinsakaiIinCode) {
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
    public void setShinsakaiKaisaiYMD(@Nonnull FlexibleDate shinsakaiKaisaiYMD) {
        this.shinsakaiKaisaiYMD = shinsakaiKaisaiYMD;
    }

    /**
     * 介護認定審査会議長区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：介護認定審査会議長区分コード）0：委員、1：議長
     *
     * @return 介護認定審査会議長区分コード
     */
    public Code getKaigoninteiShinsakaiGichoKubunCode() {
        return kaigoninteiShinsakaiGichoKubunCode;
    }

    /**
     * 介護認定審査会議長区分コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：介護認定審査会議長区分コード）0：委員、1：議長
     *
     * @param kaigoninteiShinsakaiGichoKubunCode 介護認定審査会議長区分コード
     */
    public void setKaigoninteiShinsakaiGichoKubunCode(@Nonnull Code kaigoninteiShinsakaiGichoKubunCode) {
        this.kaigoninteiShinsakaiGichoKubunCode = kaigoninteiShinsakaiGichoKubunCode;
    }

    /**
     * 委員出席のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：委員出席）
     *
     * @return 委員出席
     */
    public boolean getShussekiFlag() {
        return shussekiFlag;
    }

    /**
     * 委員出席のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：委員出席）
     *
     * @param shussekiFlag 委員出席
     */
    public void setShussekiFlag(@Nonnull boolean shussekiFlag) {
        this.shussekiFlag = shussekiFlag;
    }

    /**
     * 委員遅刻有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：委員遅刻有無）
     *
     * @return 委員遅刻有無
     */
    public boolean getExistChikokuFlag() {
        return existChikokuFlag;
    }

    /**
     * 委員遅刻有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：委員遅刻有無）
     *
     * @param existChikokuFlag 委員遅刻有無
     */
    public void setExistChikokuFlag(@Nonnull boolean existChikokuFlag) {
        this.existChikokuFlag = existChikokuFlag;
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
    public void setShussekiTime(@Nonnull RString shussekiTime) {
        this.shussekiTime = shussekiTime;
    }

    /**
     * 委員早退有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：委員早退有無）
     *
     * @return 委員早退有無
     */
    public boolean getExistSotaiFlag() {
        return existSotaiFlag;
    }

    /**
     * 委員早退有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：委員早退有無）
     *
     * @param existSotaiFlag 委員早退有無
     */
    public void setExistSotaiFlag(@Nonnull boolean existSotaiFlag) {
        this.existSotaiFlag = existSotaiFlag;
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
    public void setTaisekiTime(@Nonnull RString taisekiTime) {
        this.taisekiTime = taisekiTime;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5503ShinsakaiWariateIinJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal DbT5503ShinsakaiWariateIinJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5503ShinsakaiWariateIinJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinsakaiKaisaiNo, other.shinsakaiKaisaiNo)) {
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
    public void shallowCopy(DbT5503ShinsakaiWariateIinJohoEntity entity) {
        this.shinsakaiKaisaiNo = entity.shinsakaiKaisaiNo;
        this.shinsakaiIinCode = entity.shinsakaiIinCode;
        this.shinsakaiKaisaiYMD = entity.shinsakaiKaisaiYMD;
        this.kaigoninteiShinsakaiGichoKubunCode = entity.kaigoninteiShinsakaiGichoKubunCode;
        this.shussekiFlag = entity.shussekiFlag;
        this.existChikokuFlag = entity.existChikokuFlag;
        this.shussekiTime = entity.shussekiTime;
        this.existSotaiFlag = entity.existSotaiFlag;
        this.taisekiTime = entity.taisekiTime;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinsakaiKaisaiNo, shinsakaiIinCode, shinsakaiKaisaiYMD, kaigoninteiShinsakaiGichoKubunCode, shussekiFlag, existChikokuFlag, shussekiTime, existSotaiFlag, taisekiTime);
    }

// </editor-fold>
}
