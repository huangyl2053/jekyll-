package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 介護認定審査会割当情報テーブルのエンティティクラスです。
 */
public class DbT5502ShinsakaiWariateJohoEntity extends DbTableEntityBase<DbT5502ShinsakaiWariateJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5502ShinsakaiWariateJoho");

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
    private ShinseishoKanriNo shinseishoKanriNo;
    private FlexibleDate shinsakaiKaisaiYMD;
    private FlexibleDate shinsakaiWariateYMD;
    private int shinsakaiOrder;
    private boolean shinsakaiOrderKakuteiFlag;
    private boolean shinsakaiJidoWaritsukeFlag;
    private FlexibleDate shinsakaiShiryoSakuseiYMD;
    private FlexibleDate shinsakaiShiryoSofuYMD;
    private Code hanteiKekkaCode;

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
     * 申請書管理番号のgetメソッドです。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     *
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(@Nonnull ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
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
     * 介護認定審査会割当年月日のgetメソッドです。
     *
     * @return 介護認定審査会割当年月日
     */
    public FlexibleDate getShinsakaiWariateYMD() {
        return shinsakaiWariateYMD;
    }

    /**
     * 介護認定審査会割当年月日のsetメソッドです。
     *
     * @param shinsakaiWariateYMD 介護認定審査会割当年月日
     */
    public void setShinsakaiWariateYMD(@Nonnull FlexibleDate shinsakaiWariateYMD) {
        this.shinsakaiWariateYMD = shinsakaiWariateYMD;
    }

    /**
     * 介護認定審査会審査順のgetメソッドです。
     *
     * @return 介護認定審査会審査順
     */
    public int getShinsakaiOrder() {
        return shinsakaiOrder;
    }

    /**
     * 介護認定審査会審査順のsetメソッドです。
     *
     * @param shinsakaiOrder 介護認定審査会審査順
     */
    public void setShinsakaiOrder(@Nonnull int shinsakaiOrder) {
        this.shinsakaiOrder = shinsakaiOrder;
    }

    /**
     * 介護認定審査会審査順確定フラグのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：介護認定審査会審査順確定フラグ）
     *
     * @return 介護認定審査会審査順確定フラグ
     */
    public boolean getShinsakaiOrderKakuteiFlag() {
        return shinsakaiOrderKakuteiFlag;
    }

    /**
     * 介護認定審査会審査順確定フラグのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：介護認定審査会審査順確定フラグ）
     *
     * @param shinsakaiOrderKakuteiFlag 介護認定審査会審査順確定フラグ
     */
    public void setShinsakaiOrderKakuteiFlag(@Nonnull boolean shinsakaiOrderKakuteiFlag) {
        this.shinsakaiOrderKakuteiFlag = shinsakaiOrderKakuteiFlag;
    }

    /**
     * 審査会自動割付フラグのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：審査会自動割付フラグ）
     *
     * @return 審査会自動割付フラグ
     */
    public boolean getShinsakaiJidoWaritsukeFlag() {
        return shinsakaiJidoWaritsukeFlag;
    }

    /**
     * 審査会自動割付フラグのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：審査会自動割付フラグ）
     *
     * @param shinsakaiJidoWaritsukeFlag 審査会自動割付フラグ
     */
    public void setShinsakaiJidoWaritsukeFlag(@Nonnull boolean shinsakaiJidoWaritsukeFlag) {
        this.shinsakaiJidoWaritsukeFlag = shinsakaiJidoWaritsukeFlag;
    }

    /**
     * 審査会資料作成年月日のgetメソッドです。
     *
     * @return 審査会資料作成年月日
     */
    @CheckForNull
    public FlexibleDate getShinsakaiShiryoSakuseiYMD() {
        return shinsakaiShiryoSakuseiYMD;
    }

    /**
     * 審査会資料作成年月日のsetメソッドです。
     *
     * @param shinsakaiShiryoSakuseiYMD 審査会資料作成年月日
     */
    public void setShinsakaiShiryoSakuseiYMD(FlexibleDate shinsakaiShiryoSakuseiYMD) {
        this.shinsakaiShiryoSakuseiYMD = shinsakaiShiryoSakuseiYMD;
    }

    /**
     * 審査会資料送付年月日のgetメソッドです。
     *
     * @return 審査会資料送付年月日
     */
    @CheckForNull
    public FlexibleDate getShinsakaiShiryoSofuYMD() {
        return shinsakaiShiryoSofuYMD;
    }

    /**
     * 審査会資料送付年月日のsetメソッドです。
     *
     * @param shinsakaiShiryoSofuYMD 審査会資料送付年月日
     */
    public void setShinsakaiShiryoSofuYMD(FlexibleDate shinsakaiShiryoSofuYMD) {
        this.shinsakaiShiryoSofuYMD = shinsakaiShiryoSofuYMD;
    }

    /**
     * 判定結果コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：判定結果コード）01：認定、11：未審査、21：再審査、31：再調査（調査票・意見書）、32：再調査（調査のみ）、33：再調査（意見書のみ）
     *
     * @return 判定結果コード
     */
    @CheckForNull
    public Code getHanteiKekkaCode() {
        return hanteiKekkaCode;
    }

    /**
     * 判定結果コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：判定結果コード）01：認定、11：未審査、21：再審査、31：再調査（調査票・意見書）、32：再調査（調査のみ）、33：再調査（意見書のみ）
     *
     * @param hanteiKekkaCode 判定結果コード
     */
    public void setHanteiKekkaCode(Code hanteiKekkaCode) {
        this.hanteiKekkaCode = hanteiKekkaCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5502ShinsakaiWariateJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5502ShinsakaiWariateJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5502ShinsakaiWariateJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinsakaiKaisaiNo, other.shinsakaiKaisaiNo)) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5502ShinsakaiWariateJohoEntity entity) {
        this.shinsakaiKaisaiNo = entity.shinsakaiKaisaiNo;
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.shinsakaiKaisaiYMD = entity.shinsakaiKaisaiYMD;
        this.shinsakaiWariateYMD = entity.shinsakaiWariateYMD;
        this.shinsakaiOrder = entity.shinsakaiOrder;
        this.shinsakaiOrderKakuteiFlag = entity.shinsakaiOrderKakuteiFlag;
        this.shinsakaiJidoWaritsukeFlag = entity.shinsakaiJidoWaritsukeFlag;
        this.shinsakaiShiryoSakuseiYMD = entity.shinsakaiShiryoSakuseiYMD;
        this.shinsakaiShiryoSofuYMD = entity.shinsakaiShiryoSofuYMD;
        this.hanteiKekkaCode = entity.hanteiKekkaCode;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinsakaiKaisaiNo, shinseishoKanriNo, shinsakaiKaisaiYMD, shinsakaiWariateYMD, shinsakaiOrder, shinsakaiOrderKakuteiFlag, shinsakaiJidoWaritsukeFlag, shinsakaiShiryoSakuseiYMD, shinsakaiShiryoSofuYMD, hanteiKekkaCode);
    }

// </editor-fold>
}
