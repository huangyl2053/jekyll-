package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 介護認定審査会事前審査結果情報テーブルのエンティティクラスです。
 */
public class DbT5508ShinsakaiJizenKekkaJohoEntity extends DbTableEntityBase<DbT5508ShinsakaiJizenKekkaJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5508ShinsakaiJizenKekkaJoho");

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
    @PrimaryKey
    private int shinsakaiOrder;
    private RString ichijiHanteiHenkoRiyu;
    private Code nijiHanteiKekkaCode;

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
     * 介護認定審査会審査順のgetメソッドです。
     * <br/>
     * <br/>介護認定審査会割当情報
     * 
     * @return 介護認定審査会審査順
     */
    public int getShinsakaiOrder() {
        return shinsakaiOrder;
    }

    /**
     * 介護認定審査会審査順のsetメソッドです。
     * <br/>
     * <br/>介護認定審査会割当情報
     * 
     * @param shinsakaiOrder 介護認定審査会審査順
     */
    public void setShinsakaiOrder(@Nonnull int shinsakaiOrder) {
        this.shinsakaiOrder = shinsakaiOrder;
    }

    /**
     * 一次判定結果変更理由のgetメソッドです。
     * 
     * @return 一次判定結果変更理由
     */
    public RString getIchijiHanteiHenkoRiyu() {
        return ichijiHanteiHenkoRiyu;
    }

    /**
     * 一次判定結果変更理由のsetメソッドです。
     * 
     * @param ichijiHanteiHenkoRiyu 一次判定結果変更理由
     */
    public void setIchijiHanteiHenkoRiyu(@Nonnull RString ichijiHanteiHenkoRiyu) {
        this.ichijiHanteiHenkoRiyu = ichijiHanteiHenkoRiyu;
    }

    /**
     * 二次判定結果コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：要介護状態区分コード（認定ｿﾌﾄ2009））
     * 
     * @return 二次判定結果コード
     */
    public Code getNijiHanteiKekkaCode() {
        return nijiHanteiKekkaCode;
    }

    /**
     * 二次判定結果コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：要介護状態区分コード（認定ｿﾌﾄ2009））
     * 
     * @param nijiHanteiKekkaCode 二次判定結果コード
     */
    public void setNijiHanteiKekkaCode(@Nonnull Code nijiHanteiKekkaCode) {
        this.nijiHanteiKekkaCode = nijiHanteiKekkaCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5508ShinsakaiJizenKekkaJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5508ShinsakaiJizenKekkaJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5508ShinsakaiJizenKekkaJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinsakaiKaisaiNo, other.shinsakaiKaisaiNo)) {
            return false;
        }
        if (!Objects.equals(this.shinsakaiIinCode, other.shinsakaiIinCode)) {
            return false;
        }
        if (this.shinsakaiOrder != other.shinsakaiOrder) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5508ShinsakaiJizenKekkaJohoEntity entity) {
        this.shinsakaiKaisaiNo = entity.shinsakaiKaisaiNo;
        this.shinsakaiIinCode = entity.shinsakaiIinCode;
        this.shinsakaiOrder = entity.shinsakaiOrder;
        this.ichijiHanteiHenkoRiyu = entity.ichijiHanteiHenkoRiyu;
        this.nijiHanteiKekkaCode = entity.nijiHanteiKekkaCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinsakaiKaisaiNo, shinsakaiIinCode, shinsakaiOrder, ichijiHanteiHenkoRiyu, nijiHanteiKekkaCode);
    }

// </editor-fold>


}
