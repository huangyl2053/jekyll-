package jp.co.ndensan.reams.db.dbe.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHM;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 要介護認定送信済みマスタテーブルのエンティティクラスです。
 */
public class DbT5190NinteiSoshinzumiMasterEntity extends DbTableEntityBase<DbT5190NinteiSoshinzumiMasterEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5190NinteiSoshinzumiMaster");

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
    private int doitsuRemban;
    private boolean isHikiwatashi;
    private YMDHM hikiwatashiYMDHM;
    private YMDHM hikiwatashiKaijoYMDHM;
    private int hikiwatashiCount;
    private YMDHM torikomiYMDHM;
    private RString saiSofuKubun;
    private RString saiChosaSofuKubun;
    private RString saiIkenshoSofuKubun;

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
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 同一連番のgetメソッドです。
     *
     * @return 同一連番
     */
    public int getDoitsuRemban() {
        return doitsuRemban;
    }

    /**
     * 同一連番のsetメソッドです。
     *
     * @param doitsuRemban 同一連番
     */
    public void setDoitsuRemban(int doitsuRemban) {
        this.doitsuRemban = doitsuRemban;
    }

    /**
     * 引き渡しフラグのgetメソッドです。
     *
     * @return 引き渡しフラグ
     */
    public boolean getIsHikiwatashi() {
        return isHikiwatashi;
    }

    /**
     * 引き渡しフラグのsetメソッドです。
     *
     * @param isHikiwatashi 引き渡しフラグ
     */
    public void setIsHikiwatashi(boolean isHikiwatashi) {
        this.isHikiwatashi = isHikiwatashi;
    }

    /**
     * 引き渡し日時のgetメソッドです。
     *
     * @return 引き渡し日時
     */
    public YMDHM getHikiwatashiYMDHM() {
        return hikiwatashiYMDHM;
    }

    /**
     * 引き渡し日時のsetメソッドです。
     *
     * @param hikiwatashiYMDHM 引き渡し日時
     */
    public void setHikiwatashiYMDHM(YMDHM hikiwatashiYMDHM) {
        this.hikiwatashiYMDHM = hikiwatashiYMDHM;
    }

    /**
     * 引き渡し解除日時のgetメソッドです。
     *
     * @return 引き渡し解除日時
     */
    public YMDHM getHikiwatashiKaijoYMDHM() {
        return hikiwatashiKaijoYMDHM;
    }

    /**
     * 引き渡し解除日時のsetメソッドです。
     *
     * @param hikiwatashiKaijoYMDHM 引き渡し解除日時
     */
    public void setHikiwatashiKaijoYMDHM(YMDHM hikiwatashiKaijoYMDHM) {
        this.hikiwatashiKaijoYMDHM = hikiwatashiKaijoYMDHM;
    }

    /**
     * 引き渡しカウントのgetメソッドです。
     *
     * @return 引き渡しカウント
     */
    public int getHikiwatashiCount() {
        return hikiwatashiCount;
    }

    /**
     * 引き渡しカウントのsetメソッドです。
     *
     * @param hikiwatashiCount 引き渡しカウント
     */
    public void setHikiwatashiCount(int hikiwatashiCount) {
        this.hikiwatashiCount = hikiwatashiCount;
    }

    /**
     * 取り込み日時のgetメソッドです。
     *
     * @return 取り込み日時
     */
    public YMDHM getTorikomiYMDHM() {
        return torikomiYMDHM;
    }

    /**
     * 取り込み日時のsetメソッドです。
     *
     * @param torikomiYMDHM 取り込み日時
     */
    public void setTorikomiYMDHM(YMDHM torikomiYMDHM) {
        this.torikomiYMDHM = torikomiYMDHM;
    }

    /**
     * 再送付区分のgetメソッドです。
     *
     * @return 再送付区分
     */
    public RString getSaiSofuKubun() {
        return saiSofuKubun;
    }

    /**
     * 再送付区分のsetメソッドです。
     *
     * @param saiSofuKubun 再送付区分
     */
    public void setSaiSofuKubun(RString saiSofuKubun) {
        this.saiSofuKubun = saiSofuKubun;
    }

    /**
     * 再調査送付区分のgetメソッドです。
     *
     * @return 再調査送付区分
     */
    public RString getSaiChosaSofuKubun() {
        return saiChosaSofuKubun;
    }

    /**
     * 再調査送付区分のsetメソッドです。
     *
     * @param saiChosaSofuKubun 再調査送付区分
     */
    public void setSaiChosaSofuKubun(RString saiChosaSofuKubun) {
        this.saiChosaSofuKubun = saiChosaSofuKubun;
    }

    /**
     * 再意見書送付区分のgetメソッドです。
     *
     * @return 再意見書送付区分
     */
    public RString getSaiIkenshoSofuKubun() {
        return saiIkenshoSofuKubun;
    }

    /**
     * 再意見書送付区分のsetメソッドです。
     *
     * @param saiIkenshoSofuKubun 再意見書送付区分
     */
    public void setSaiIkenshoSofuKubun(RString saiIkenshoSofuKubun) {
        this.saiIkenshoSofuKubun = saiIkenshoSofuKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5190NinteiSoshinzumiMasterEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5190NinteiSoshinzumiMasterEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5190NinteiSoshinzumiMasterEntity other) {
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
    public void shallowCopy(DbT5190NinteiSoshinzumiMasterEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.doitsuRemban = entity.doitsuRemban;
        this.isHikiwatashi = entity.isHikiwatashi;
        this.hikiwatashiYMDHM = entity.hikiwatashiYMDHM;
        this.hikiwatashiKaijoYMDHM = entity.hikiwatashiKaijoYMDHM;
        this.hikiwatashiCount = entity.hikiwatashiCount;
        this.torikomiYMDHM = entity.torikomiYMDHM;
        this.saiSofuKubun = entity.saiSofuKubun;
        this.saiChosaSofuKubun = entity.saiChosaSofuKubun;
        this.saiIkenshoSofuKubun = entity.saiIkenshoSofuKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, doitsuRemban, isHikiwatashi, hikiwatashiYMDHM, hikiwatashiKaijoYMDHM, hikiwatashiCount, torikomiYMDHM, saiSofuKubun, saiChosaSofuKubun, saiIkenshoSofuKubun);
    }

// </editor-fold>
}
