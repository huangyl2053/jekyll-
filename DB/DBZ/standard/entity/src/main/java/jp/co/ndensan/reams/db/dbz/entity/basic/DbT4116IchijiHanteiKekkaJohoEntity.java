package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 要介護認定一次判定結果情報テーブルのエンティティクラスです。
 */
public class DbT4116IchijiHanteiKekkaJohoEntity extends DbTableEntityBase<DbT4116IchijiHanteiKekkaJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT4116IchijiHanteiKekkaJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    private boolean kariIchijiHanteiKubun;
    private FlexibleDate ichijiHanteiYMD;
    private Code ichijiHanteiKekkaCode;
    private Code ichijiHanteiKekkaNinchishoKasanCode;

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
     * 申請書管理番号のgetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     *
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 仮一次判定区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：仮一次判定区分）
     *
     * @return 仮一次判定区分
     */
    public boolean getKariIchijiHanteiKubun() {
        return kariIchijiHanteiKubun;
    }

    /**
     * 仮一次判定区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：仮一次判定区分）
     *
     * @param kariIchijiHanteiKubun 仮一次判定区分
     */
    public void setKariIchijiHanteiKubun(boolean kariIchijiHanteiKubun) {
        this.kariIchijiHanteiKubun = kariIchijiHanteiKubun;
    }

    /**
     * 要介護認定一次判定年月日のgetメソッドです。
     *
     * @return 要介護認定一次判定年月日
     */
    public FlexibleDate getIchijiHanteiYMD() {
        return ichijiHanteiYMD;
    }

    /**
     * 要介護認定一次判定年月日のsetメソッドです。
     *
     * @param ichijiHanteiYMD 要介護認定一次判定年月日
     */
    public void setIchijiHanteiYMD(FlexibleDate ichijiHanteiYMD) {
        this.ichijiHanteiYMD = ichijiHanteiYMD;
    }

    /**
     * 要介護認定一次判定結果コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：要介護認定一次判定結果コード09）
     *
     * @return 要介護認定一次判定結果コード
     */
    public Code getIchijiHanteiKekkaCode() {
        return ichijiHanteiKekkaCode;
    }

    /**
     * 要介護認定一次判定結果コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：要介護認定一次判定結果コード09）
     *
     * @param ichijiHanteiKekkaCode 要介護認定一次判定結果コード
     */
    public void setIchijiHanteiKekkaCode(Code ichijiHanteiKekkaCode) {
        this.ichijiHanteiKekkaCode = ichijiHanteiKekkaCode;
    }

    /**
     * 要介護認定一次判定結果コード（認知症加算）のgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：要介護認定一次判定結果コード09（認知症加算））要介護認定一次判定結果コード（重み）
     *
     * @return 要介護認定一次判定結果コード（認知症加算）
     */
    public Code getIchijiHanteiKekkaNinchishoKasanCode() {
        return ichijiHanteiKekkaNinchishoKasanCode;
    }

    /**
     * 要介護認定一次判定結果コード（認知症加算）のsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：要介護認定一次判定結果コード09（認知症加算））要介護認定一次判定結果コード（重み）
     *
     * @param ichijiHanteiKekkaNinchishoKasanCode 要介護認定一次判定結果コード（認知症加算）
     */
    public void setIchijiHanteiKekkaNinchishoKasanCode(Code ichijiHanteiKekkaNinchishoKasanCode) {
        this.ichijiHanteiKekkaNinchishoKasanCode = ichijiHanteiKekkaNinchishoKasanCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4116IchijiHanteiKekkaJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4116IchijiHanteiKekkaJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4116IchijiHanteiKekkaJohoEntity other) {
        if (other == null) {
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
    public void shallowCopy(DbT4116IchijiHanteiKekkaJohoEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.kariIchijiHanteiKubun = entity.kariIchijiHanteiKubun;
        this.ichijiHanteiYMD = entity.ichijiHanteiYMD;
        this.ichijiHanteiKekkaCode = entity.ichijiHanteiKekkaCode;
        this.ichijiHanteiKekkaNinchishoKasanCode = entity.ichijiHanteiKekkaNinchishoKasanCode;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, kariIchijiHanteiKubun, ichijiHanteiYMD, ichijiHanteiKekkaCode, ichijiHanteiKekkaNinchishoKasanCode);
    }

// </editor-fold>
}
