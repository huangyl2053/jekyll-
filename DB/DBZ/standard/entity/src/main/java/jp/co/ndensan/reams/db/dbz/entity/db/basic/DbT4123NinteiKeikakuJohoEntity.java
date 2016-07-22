package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 要介護認定計画情報テーブルのエンティティクラスです。
 */
public class DbT4123NinteiKeikakuJohoEntity extends DbTableEntityBase<DbT4123NinteiKeikakuJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT4123NinteiKeikakuJoho");

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
    private FlexibleDate ninteichosaIraiYoteiYMD;
    private FlexibleDate ninteichosaYoteiYMD;
    private FlexibleDate ikenshoSakuseiIraiYoteiYMD;
    private FlexibleDate ikenshoTorokuYoteiYMD;
    private FlexibleDate ichijiHanteiYoteiYMD;
    private FlexibleDate ninteiShinsakaiWariateYoteiYMD;
    private FlexibleDate ninteiShinsakaiYoteiYMD;
    private FlexibleDate centerSoshinYoteiYMD;

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
     * 認定調査依頼予定年月日のgetメソッドです。
     *
     * @return 認定調査依頼予定年月日
     */
    public FlexibleDate getNinteichosaIraiYoteiYMD() {
        return ninteichosaIraiYoteiYMD;
    }

    /**
     * 認定調査依頼予定年月日のsetメソッドです。
     *
     * @param ninteichosaIraiYoteiYMD 認定調査依頼予定年月日
     */
    public void setNinteichosaIraiYoteiYMD(FlexibleDate ninteichosaIraiYoteiYMD) {
        this.ninteichosaIraiYoteiYMD = ninteichosaIraiYoteiYMD;
    }

    /**
     * 認定調査予定年月日のgetメソッドです。
     *
     * @return 認定調査予定年月日
     */
    public FlexibleDate getNinteichosaYoteiYMD() {
        return ninteichosaYoteiYMD;
    }

    /**
     * 認定調査予定年月日のsetメソッドです。
     *
     * @param ninteichosaYoteiYMD 認定調査予定年月日
     */
    public void setNinteichosaYoteiYMD(FlexibleDate ninteichosaYoteiYMD) {
        this.ninteichosaYoteiYMD = ninteichosaYoteiYMD;
    }

    /**
     * 主治医意見書作成依頼予定年月日のgetメソッドです。
     *
     * @return 主治医意見書作成依頼予定年月日
     */
    public FlexibleDate getIkenshoSakuseiIraiYoteiYMD() {
        return ikenshoSakuseiIraiYoteiYMD;
    }

    /**
     * 主治医意見書作成依頼予定年月日のsetメソッドです。
     *
     * @param ikenshoSakuseiIraiYoteiYMD 主治医意見書作成依頼予定年月日
     */
    public void setIkenshoSakuseiIraiYoteiYMD(FlexibleDate ikenshoSakuseiIraiYoteiYMD) {
        this.ikenshoSakuseiIraiYoteiYMD = ikenshoSakuseiIraiYoteiYMD;
    }

    /**
     * 主治医意見書登録予定年月日のgetメソッドです。
     *
     * @return 主治医意見書登録予定年月日
     */
    public FlexibleDate getIkenshoTorokuYoteiYMD() {
        return ikenshoTorokuYoteiYMD;
    }

    /**
     * 主治医意見書登録予定年月日のsetメソッドです。
     *
     * @param ikenshoTorokuYoteiYMD 主治医意見書登録予定年月日
     */
    public void setIkenshoTorokuYoteiYMD(FlexibleDate ikenshoTorokuYoteiYMD) {
        this.ikenshoTorokuYoteiYMD = ikenshoTorokuYoteiYMD;
    }

    /**
     * 要介護認定一次判定予定年月日のgetメソッドです。
     *
     * @return 要介護認定一次判定予定年月日
     */
    public FlexibleDate getIchijiHanteiYoteiYMD() {
        return ichijiHanteiYoteiYMD;
    }

    /**
     * 要介護認定一次判定予定年月日のsetメソッドです。
     *
     * @param ichijiHanteiYoteiYMD 要介護認定一次判定予定年月日
     */
    public void setIchijiHanteiYoteiYMD(FlexibleDate ichijiHanteiYoteiYMD) {
        this.ichijiHanteiYoteiYMD = ichijiHanteiYoteiYMD;
    }

    /**
     * 認定審査会割当予定年月日のgetメソッドです。
     *
     * @return 認定審査会割当予定年月日
     */
    public FlexibleDate getNinteiShinsakaiWariateYoteiYMD() {
        return ninteiShinsakaiWariateYoteiYMD;
    }

    /**
     * 認定審査会割当予定年月日のsetメソッドです。
     *
     * @param ninteiShinsakaiWariateYoteiYMD 認定審査会割当予定年月日
     */
    public void setNinteiShinsakaiWariateYoteiYMD(FlexibleDate ninteiShinsakaiWariateYoteiYMD) {
        this.ninteiShinsakaiWariateYoteiYMD = ninteiShinsakaiWariateYoteiYMD;
    }

    /**
     * 認定審査会予定年月日のgetメソッドです。
     *
     * @return 認定審査会予定年月日
     */
    public FlexibleDate getNinteiShinsakaiYoteiYMD() {
        return ninteiShinsakaiYoteiYMD;
    }

    /**
     * 認定審査会予定年月日のsetメソッドです。
     *
     * @param ninteiShinsakaiYoteiYMD 認定審査会予定年月日
     */
    public void setNinteiShinsakaiYoteiYMD(FlexibleDate ninteiShinsakaiYoteiYMD) {
        this.ninteiShinsakaiYoteiYMD = ninteiShinsakaiYoteiYMD;
    }

    /**
     * センター送信予定年月日のgetメソッドです。
     *
     * @return センター送信予定年月日
     */
    public FlexibleDate getCenterSoshinYoteiYMD() {
        return centerSoshinYoteiYMD;
    }

    /**
     * センター送信予定年月日のsetメソッドです。
     *
     * @param centerSoshinYoteiYMD センター送信予定年月日
     */
    public void setCenterSoshinYoteiYMD(FlexibleDate centerSoshinYoteiYMD) {
        this.centerSoshinYoteiYMD = centerSoshinYoteiYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4123NinteiKeikakuJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT4123NinteiKeikakuJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4123NinteiKeikakuJohoEntity other) {
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
    public void shallowCopy(DbT4123NinteiKeikakuJohoEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ninteichosaIraiYoteiYMD = entity.ninteichosaIraiYoteiYMD;
        this.ninteichosaYoteiYMD = entity.ninteichosaYoteiYMD;
        this.ikenshoSakuseiIraiYoteiYMD = entity.ikenshoSakuseiIraiYoteiYMD;
        this.ikenshoTorokuYoteiYMD = entity.ikenshoTorokuYoteiYMD;
        this.ichijiHanteiYoteiYMD = entity.ichijiHanteiYoteiYMD;
        this.ninteiShinsakaiWariateYoteiYMD = entity.ninteiShinsakaiWariateYoteiYMD;
        this.ninteiShinsakaiYoteiYMD = entity.ninteiShinsakaiYoteiYMD;
        this.centerSoshinYoteiYMD = entity.centerSoshinYoteiYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ninteichosaIraiYoteiYMD, ninteichosaYoteiYMD, ikenshoSakuseiIraiYoteiYMD, ikenshoTorokuYoteiYMD, ichijiHanteiYoteiYMD, ninteiShinsakaiWariateYoteiYMD, ninteiShinsakaiYoteiYMD, centerSoshinYoteiYMD);
    }

// </editor-fold>
}
