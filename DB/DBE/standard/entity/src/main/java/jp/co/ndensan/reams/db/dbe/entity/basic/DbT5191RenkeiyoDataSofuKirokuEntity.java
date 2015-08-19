package jp.co.ndensan.reams.db.dbe.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 連携用データ送付記録テーブルのエンティティクラスです。
 */
public class DbT5191RenkeiyoDataSofuKirokuEntity extends DbTableEntityBase<DbT5191RenkeiyoDataSofuKirokuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5191RenkeiyoDataSofuKiroku");

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
    @PrimaryKey
    private FlexibleDate shiryoSakuseiYMD;
    private RString hikiwatashiKubun;
    private YMDHMS hikiwatashiTimeStamp;
    private RString saiSoufuKubun;
    private RString saiChousaSofuKubun;
    private RString saiIkenshoSofuKubun;
    private RString saiImageSofuKubun;
    private FlexibleDate saiSoshinYMD;

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
     * 資料作成日のgetメソッドです。
     *
     * @return 資料作成日
     */
    public FlexibleDate getShiryoSakuseiYMD() {
        return shiryoSakuseiYMD;
    }

    /**
     * 資料作成日のsetメソッドです。
     *
     * @param shiryoSakuseiYMD 資料作成日
     */
    public void setShiryoSakuseiYMD(FlexibleDate shiryoSakuseiYMD) {
        this.shiryoSakuseiYMD = shiryoSakuseiYMD;
    }

    /**
     * 引渡し区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：引渡し区分）0：引渡し未済、1：引渡し済
     *
     * @return 引渡し区分
     */
    public RString getHikiwatashiKubun() {
        return hikiwatashiKubun;
    }

    /**
     * 引渡し区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：引渡し区分）0：引渡し未済、1：引渡し済
     *
     * @param hikiwatashiKubun 引渡し区分
     */
    public void setHikiwatashiKubun(RString hikiwatashiKubun) {
        this.hikiwatashiKubun = hikiwatashiKubun;
    }

    /**
     * 引渡日時のgetメソッドです。
     *
     * @return 引渡日時
     */
    public YMDHMS getHikiwatashiTimeStamp() {
        return hikiwatashiTimeStamp;
    }

    /**
     * 引渡日時のsetメソッドです。
     *
     * @param hikiwatashiTimeStamp 引渡日時
     */
    public void setHikiwatashiTimeStamp(YMDHMS hikiwatashiTimeStamp) {
        this.hikiwatashiTimeStamp = hikiwatashiTimeStamp;
    }

    /**
     * 再送付区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：再送付区分）01：再送信、02：再送信済
     *
     * @return 再送付区分
     */
    public RString getSaiSoufuKubun() {
        return saiSoufuKubun;
    }

    /**
     * 再送付区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：再送付区分）01：再送信、02：再送信済
     *
     * @param saiSoufuKubun 再送付区分
     */
    public void setSaiSoufuKubun(RString saiSoufuKubun) {
        this.saiSoufuKubun = saiSoufuKubun;
    }

    /**
     * 再調査送付区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：再調査送付区分）0：未使用、1：再送信、2：再調査、3：再調査送付済　[松本広域でのみ使用：現行]
     *
     * @return 再調査送付区分
     */
    public RString getSaiChousaSofuKubun() {
        return saiChousaSofuKubun;
    }

    /**
     * 再調査送付区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：再調査送付区分）0：未使用、1：再送信、2：再調査、3：再調査送付済　[松本広域でのみ使用：現行]
     *
     * @param saiChousaSofuKubun 再調査送付区分
     */
    public void setSaiChousaSofuKubun(RString saiChousaSofuKubun) {
        this.saiChousaSofuKubun = saiChousaSofuKubun;
    }

    /**
     * 再意見書送付区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：再意見書送付区分）0：未使用、1：再送信、2：再意見書、3：再意見書送付済　[松本広域でのみ使用：Always]
     *
     * @return 再意見書送付区分
     */
    public RString getSaiIkenshoSofuKubun() {
        return saiIkenshoSofuKubun;
    }

    /**
     * 再意見書送付区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：再意見書送付区分）0：未使用、1：再送信、2：再意見書、3：再意見書送付済　[松本広域でのみ使用：Always]
     *
     * @param saiIkenshoSofuKubun 再意見書送付区分
     */
    public void setSaiIkenshoSofuKubun(RString saiIkenshoSofuKubun) {
        this.saiIkenshoSofuKubun = saiIkenshoSofuKubun;
    }

    /**
     * 再イメージ送付区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：再イメージ送付区分）0：未使用、1：再送信、2：再イメージ、3：再イメージ送信済
     *
     * @return 再イメージ送付区分
     */
    public RString getSaiImageSofuKubun() {
        return saiImageSofuKubun;
    }

    /**
     * 再イメージ送付区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：再イメージ送付区分）0：未使用、1：再送信、2：再イメージ、3：再イメージ送信済
     *
     * @param saiImageSofuKubun 再イメージ送付区分
     */
    public void setSaiImageSofuKubun(RString saiImageSofuKubun) {
        this.saiImageSofuKubun = saiImageSofuKubun;
    }

    /**
     * 再送信年月日のgetメソッドです。
     *
     * @return 再送信年月日
     */
    public FlexibleDate getSaiSoshinYMD() {
        return saiSoshinYMD;
    }

    /**
     * 再送信年月日のsetメソッドです。
     *
     * @param saiSoshinYMD 再送信年月日
     */
    public void setSaiSoshinYMD(FlexibleDate saiSoshinYMD) {
        this.saiSoshinYMD = saiSoshinYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5191RenkeiyoDataSofuKirokuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5191RenkeiyoDataSofuKirokuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5191RenkeiyoDataSofuKirokuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (!Objects.equals(this.shiryoSakuseiYMD, other.shiryoSakuseiYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5191RenkeiyoDataSofuKirokuEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.shiryoSakuseiYMD = entity.shiryoSakuseiYMD;
        this.hikiwatashiKubun = entity.hikiwatashiKubun;
        this.hikiwatashiTimeStamp = entity.hikiwatashiTimeStamp;
        this.saiSoufuKubun = entity.saiSoufuKubun;
        this.saiChousaSofuKubun = entity.saiChousaSofuKubun;
        this.saiIkenshoSofuKubun = entity.saiIkenshoSofuKubun;
        this.saiImageSofuKubun = entity.saiImageSofuKubun;
        this.saiSoshinYMD = entity.saiSoshinYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, shiryoSakuseiYMD, hikiwatashiKubun, hikiwatashiTimeStamp, saiSoufuKubun, saiChousaSofuKubun, saiIkenshoSofuKubun, saiImageSofuKubun, saiSoshinYMD);
    }

// </editor-fold>
}
