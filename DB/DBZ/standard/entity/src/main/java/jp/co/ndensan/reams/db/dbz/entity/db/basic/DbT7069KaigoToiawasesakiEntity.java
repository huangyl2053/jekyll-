package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 介護問合せ先テーブルのエンティティクラスです。
 */
public class DbT7069KaigoToiawasesakiEntity extends DbTableEntityBase<DbT7069KaigoToiawasesakiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7069KaigoToiawasesaki");

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
    private ReportId chohyoBunruiID;
    private YubinNo yubinNo;
    private RString shozaichi;
    private RString choshaName;
    private TelNo telNo;
    private RString naisenNo;
    private RString bushoName;
    private RString tantoshaName;

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
     * 帳票分類IDのgetメソッドです。
     * <br/>
     * <br/>共通としての管理時は「000000000」
     * 
     * @return 帳票分類ID
     */
    public ReportId getChohyoBunruiID() {
        return chohyoBunruiID;
    }

    /**
     * 帳票分類IDのsetメソッドです。
     * <br/>
     * <br/>共通としての管理時は「000000000」
     * 
     * @param chohyoBunruiID 帳票分類ID
     */
    public void setChohyoBunruiID(@Nonnull ReportId chohyoBunruiID) {
        this.chohyoBunruiID = chohyoBunruiID;
    }

    /**
     * 郵便番号のgetメソッドです。
     * 
     * @return 郵便番号
     */
    @CheckForNull
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * 郵便番号のsetメソッドです。
     * 
     * @param yubinNo 郵便番号
     */
    public void setYubinNo(YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * 所在地のgetメソッドです。
     * 
     * @return 所在地
     */
    @CheckForNull
    public RString getShozaichi() {
        return shozaichi;
    }

    /**
     * 所在地のsetメソッドです。
     * 
     * @param shozaichi 所在地
     */
    public void setShozaichi(RString shozaichi) {
        this.shozaichi = shozaichi;
    }

    /**
     * 庁舎名のgetメソッドです。
     * 
     * @return 庁舎名
     */
    @CheckForNull
    public RString getChoshaName() {
        return choshaName;
    }

    /**
     * 庁舎名のsetメソッドです。
     * 
     * @param choshaName 庁舎名
     */
    public void setChoshaName(RString choshaName) {
        this.choshaName = choshaName;
    }

    /**
     * 電話番号のgetメソッドです。
     * 
     * @return 電話番号
     */
    @CheckForNull
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * 電話番号のsetメソッドです。
     * 
     * @param telNo 電話番号
     */
    public void setTelNo(TelNo telNo) {
        this.telNo = telNo;
    }

    /**
     * 内線番号のgetメソッドです。
     * 
     * @return 内線番号
     */
    @CheckForNull
    public RString getNaisenNo() {
        return naisenNo;
    }

    /**
     * 内線番号のsetメソッドです。
     * 
     * @param naisenNo 内線番号
     */
    public void setNaisenNo(RString naisenNo) {
        this.naisenNo = naisenNo;
    }

    /**
     * 部署名のgetメソッドです。
     * 
     * @return 部署名
     */
    @CheckForNull
    public RString getBushoName() {
        return bushoName;
    }

    /**
     * 部署名のsetメソッドです。
     * 
     * @param bushoName 部署名
     */
    public void setBushoName(RString bushoName) {
        this.bushoName = bushoName;
    }

    /**
     * 担当者名のgetメソッドです。
     * 
     * @return 担当者名
     */
    @CheckForNull
    public RString getTantoshaName() {
        return tantoshaName;
    }

    /**
     * 担当者名のsetメソッドです。
     * 
     * @param tantoshaName 担当者名
     */
    public void setTantoshaName(RString tantoshaName) {
        this.tantoshaName = tantoshaName;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7069KaigoToiawasesakiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7069KaigoToiawasesakiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7069KaigoToiawasesakiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.subGyomuCode, other.subGyomuCode)) {
            return false;
        }
        if (!Objects.equals(this.chohyoBunruiID, other.chohyoBunruiID)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7069KaigoToiawasesakiEntity entity) {
        this.subGyomuCode = entity.subGyomuCode;
        this.chohyoBunruiID = entity.chohyoBunruiID;
        this.yubinNo = entity.yubinNo;
        this.shozaichi = entity.shozaichi;
        this.choshaName = entity.choshaName;
        this.telNo = entity.telNo;
        this.naisenNo = entity.naisenNo;
        this.bushoName = entity.bushoName;
        this.tantoshaName = entity.tantoshaName;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(subGyomuCode, chohyoBunruiID, yubinNo, shozaichi, choshaName, telNo, naisenNo, bushoName, tantoshaName);
    }

// </editor-fold>

}
