package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 要介護認定完了情報テーブルのエンティティクラスです。
 */
@OnNextSchema("rgdb")
public class DbT5105NinteiKanryoJohoEntity extends DbTableEntityBase<DbT5105NinteiKanryoJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5105NinteiKanryoJoho");

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
    private FlexibleDate ninteiShinseiJohoTorokuKanryoYMD;
    private FlexibleDate ninteichosaIraiKanryoYMD;
    private FlexibleDate ninteichosaKanryoYMD;
    private FlexibleDate ikenshoSakuseiIraiKanryoYMD;
    private FlexibleDate ikenshoTorokuKanryoYMD;
    private FlexibleDate ichijiHanteiKanryoYMD;
    private FlexibleDate maskingKanryoYMD;
    private FlexibleDate ninteiShinsakaiWariateKanryoYMD;
    private FlexibleDate ninteiShinsakaiKanryoYMD;
    private FlexibleDate centerSoshinYMD;

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
    public void setShinseishoKanriNo(@Nonnull ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 認定申請情報登録完了年月日のgetメソッドです。
     *
     * @return 認定申請情報登録完了年月日
     */
    @CheckForNull
    public FlexibleDate getNinteiShinseiJohoTorokuKanryoYMD() {
        return ninteiShinseiJohoTorokuKanryoYMD;
    }

    /**
     * 認定申請情報登録完了年月日のsetメソッドです。
     *
     * @param ninteiShinseiJohoTorokuKanryoYMD 認定申請情報登録完了年月日
     */
    public void setNinteiShinseiJohoTorokuKanryoYMD(FlexibleDate ninteiShinseiJohoTorokuKanryoYMD) {
        this.ninteiShinseiJohoTorokuKanryoYMD = ninteiShinseiJohoTorokuKanryoYMD;
    }

    /**
     * 認定調査依頼完了年月日のgetメソッドです。
     *
     * @return 認定調査依頼完了年月日
     */
    @CheckForNull
    public FlexibleDate getNinteichosaIraiKanryoYMD() {
        return ninteichosaIraiKanryoYMD;
    }

    /**
     * 認定調査依頼完了年月日のsetメソッドです。
     *
     * @param ninteichosaIraiKanryoYMD 認定調査依頼完了年月日
     */
    public void setNinteichosaIraiKanryoYMD(FlexibleDate ninteichosaIraiKanryoYMD) {
        this.ninteichosaIraiKanryoYMD = ninteichosaIraiKanryoYMD;
    }

    /**
     * 認定調査完了年月日のgetメソッドです。
     *
     * @return 認定調査完了年月日
     */
    @CheckForNull
    public FlexibleDate getNinteichosaKanryoYMD() {
        return ninteichosaKanryoYMD;
    }

    /**
     * 認定調査完了年月日のsetメソッドです。
     *
     * @param ninteichosaKanryoYMD 認定調査完了年月日
     */
    public void setNinteichosaKanryoYMD(FlexibleDate ninteichosaKanryoYMD) {
        this.ninteichosaKanryoYMD = ninteichosaKanryoYMD;
    }

    /**
     * 主治医意見書作成依頼完了年月日のgetメソッドです。
     *
     * @return 主治医意見書作成依頼完了年月日
     */
    @CheckForNull
    public FlexibleDate getIkenshoSakuseiIraiKanryoYMD() {
        return ikenshoSakuseiIraiKanryoYMD;
    }

    /**
     * 主治医意見書作成依頼完了年月日のsetメソッドです。
     *
     * @param ikenshoSakuseiIraiKanryoYMD 主治医意見書作成依頼完了年月日
     */
    public void setIkenshoSakuseiIraiKanryoYMD(FlexibleDate ikenshoSakuseiIraiKanryoYMD) {
        this.ikenshoSakuseiIraiKanryoYMD = ikenshoSakuseiIraiKanryoYMD;
    }

    /**
     * 主治医意見書登録完了年月日のgetメソッドです。
     *
     * @return 主治医意見書登録完了年月日
     */
    @CheckForNull
    public FlexibleDate getIkenshoTorokuKanryoYMD() {
        return ikenshoTorokuKanryoYMD;
    }

    /**
     * 主治医意見書登録完了年月日のsetメソッドです。
     *
     * @param ikenshoTorokuKanryoYMD 主治医意見書登録完了年月日
     */
    public void setIkenshoTorokuKanryoYMD(FlexibleDate ikenshoTorokuKanryoYMD) {
        this.ikenshoTorokuKanryoYMD = ikenshoTorokuKanryoYMD;
    }

    /**
     * 要介護認定一次判定完了年月日のgetメソッドです。
     *
     * @return 要介護認定一次判定完了年月日
     */
    @CheckForNull
    public FlexibleDate getIchijiHanteiKanryoYMD() {
        return ichijiHanteiKanryoYMD;
    }

    /**
     * 要介護認定一次判定完了年月日のsetメソッドです。
     *
     * @param ichijiHanteiKanryoYMD 要介護認定一次判定完了年月日
     */
    public void setIchijiHanteiKanryoYMD(FlexibleDate ichijiHanteiKanryoYMD) {
        this.ichijiHanteiKanryoYMD = ichijiHanteiKanryoYMD;
    }

    /**
     * マスキング完了年月日のgetメソッドです。
     *
     * @return マスキング完了年月日
     */
    @CheckForNull
    public FlexibleDate getMaskingKanryoYMD() {
        return maskingKanryoYMD;
    }

    /**
     * マスキング完了年月日のsetメソッドです。
     *
     * @param maskingKanryoYMD マスキング完了年月日
     */
    public void setMaskingKanryoYMD(FlexibleDate maskingKanryoYMD) {
        this.maskingKanryoYMD = maskingKanryoYMD;
    }

    /**
     * 認定審査会割当完了年月日のgetメソッドです。
     *
     * @return 認定審査会割当完了年月日
     */
    @CheckForNull
    public FlexibleDate getNinteiShinsakaiWariateKanryoYMD() {
        return ninteiShinsakaiWariateKanryoYMD;
    }

    /**
     * 認定審査会割当完了年月日のsetメソッドです。
     *
     * @param ninteiShinsakaiWariateKanryoYMD 認定審査会割当完了年月日
     */
    public void setNinteiShinsakaiWariateKanryoYMD(FlexibleDate ninteiShinsakaiWariateKanryoYMD) {
        this.ninteiShinsakaiWariateKanryoYMD = ninteiShinsakaiWariateKanryoYMD;
    }

    /**
     * 認定審査会完了年月日のgetメソッドです。
     *
     * @return 認定審査会完了年月日
     */
    @CheckForNull
    public FlexibleDate getNinteiShinsakaiKanryoYMD() {
        return ninteiShinsakaiKanryoYMD;
    }

    /**
     * 認定審査会完了年月日のsetメソッドです。
     *
     * @param ninteiShinsakaiKanryoYMD 認定審査会完了年月日
     */
    public void setNinteiShinsakaiKanryoYMD(FlexibleDate ninteiShinsakaiKanryoYMD) {
        this.ninteiShinsakaiKanryoYMD = ninteiShinsakaiKanryoYMD;
    }

    /**
     * センター送信年月日のgetメソッドです。
     *
     * @return センター送信年月日
     */
    @CheckForNull
    public FlexibleDate getCenterSoshinYMD() {
        return centerSoshinYMD;
    }

    /**
     * センター送信年月日のsetメソッドです。
     *
     * @param centerSoshinYMD センター送信年月日
     */
    public void setCenterSoshinYMD(FlexibleDate centerSoshinYMD) {
        this.centerSoshinYMD = centerSoshinYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5105NinteiKanryoJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal DbT5105NinteiKanryoJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5105NinteiKanryoJohoEntity other) {
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
     *
     * @param entity
     */
    @Override
    public void shallowCopy(DbT5105NinteiKanryoJohoEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ninteiShinseiJohoTorokuKanryoYMD = entity.ninteiShinseiJohoTorokuKanryoYMD;
        this.ninteichosaIraiKanryoYMD = entity.ninteichosaIraiKanryoYMD;
        this.ninteichosaKanryoYMD = entity.ninteichosaKanryoYMD;
        this.ikenshoSakuseiIraiKanryoYMD = entity.ikenshoSakuseiIraiKanryoYMD;
        this.ikenshoTorokuKanryoYMD = entity.ikenshoTorokuKanryoYMD;
        this.ichijiHanteiKanryoYMD = entity.ichijiHanteiKanryoYMD;
        this.maskingKanryoYMD = entity.maskingKanryoYMD;
        this.ninteiShinsakaiWariateKanryoYMD = entity.ninteiShinsakaiWariateKanryoYMD;
        this.ninteiShinsakaiKanryoYMD = entity.ninteiShinsakaiKanryoYMD;
        this.centerSoshinYMD = entity.centerSoshinYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ninteiShinseiJohoTorokuKanryoYMD, ninteichosaIraiKanryoYMD, ninteichosaKanryoYMD, ikenshoSakuseiIraiKanryoYMD, ikenshoTorokuKanryoYMD, ichijiHanteiKanryoYMD, maskingKanryoYMD, ninteiShinsakaiWariateKanryoYMD, ninteiShinsakaiKanryoYMD, centerSoshinYMD);
    }

// </editor-fold>
}
