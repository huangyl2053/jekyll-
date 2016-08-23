package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 外部連携データ抽出情報テーブルのエンティティクラスです。
 */
public class DbT7211GaibuRenkeiDataoutputJohoEntity extends DbTableEntityBase<DbT7211GaibuRenkeiDataoutputJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7211GaibuRenkeiDataoutputJoho");

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
    private FlexibleDate ninteiShinseiJohoChushutsuYMD;
    private FlexibleDate ninteiChosaKekkaJohoChushutsuYMD;
    private FlexibleDate ninteiChosaIkenshoKekkaJohoChushutsuYMD;
    private FlexibleDate ichijihanteiChushutsuYMD;
    private FlexibleDate shinsakaiKekkaJohoChushutsuYMD;
    private FlexibleDate centerSoshinChushutsuYMD;

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
     * 認定申請情報抽出年月日のgetメソッドです。
     *
     * @return 認定申請情報抽出年月日
     */
    @CheckForNull
    public FlexibleDate getNinteiShinseiJohoChushutsuYMD() {
        return ninteiShinseiJohoChushutsuYMD;
    }

    /**
     * 認定申請情報抽出年月日のsetメソッドです。
     *
     * @param ninteiShinseiJohoChushutsuYMD 認定申請情報抽出年月日
     */
    public void setNinteiShinseiJohoChushutsuYMD(FlexibleDate ninteiShinseiJohoChushutsuYMD) {
        this.ninteiShinseiJohoChushutsuYMD = ninteiShinseiJohoChushutsuYMD;
    }

    /**
     * 認定調査結果情報抽出年月日のgetメソッドです。
     *
     * @return 認定調査結果情報抽出年月日
     */
    @CheckForNull
    public FlexibleDate getNinteiChosaKekkaJohoChushutsuYMD() {
        return ninteiChosaKekkaJohoChushutsuYMD;
    }

    /**
     * 認定調査結果情報抽出年月日のsetメソッドです。
     *
     * @param ninteiChosaKekkaJohoChushutsuYMD 認定調査結果情報抽出年月日
     */
    public void setNinteiChosaKekkaJohoChushutsuYMD(FlexibleDate ninteiChosaKekkaJohoChushutsuYMD) {
        this.ninteiChosaKekkaJohoChushutsuYMD = ninteiChosaKekkaJohoChushutsuYMD;
    }

    /**
     * 認定調査・意見書結果情報抽出年月日のgetメソッドです。
     *
     * @return 認定調査・意見書結果情報抽出年月日
     */
    @CheckForNull
    public FlexibleDate getNinteiChosaIkenshoKekkaJohoChushutsuYMD() {
        return ninteiChosaIkenshoKekkaJohoChushutsuYMD;
    }

    /**
     * 認定調査・意見書結果情報抽出年月日のsetメソッドです。
     *
     * @param ninteiChosaIkenshoKekkaJohoChushutsuYMD 認定調査・意見書結果情報抽出年月日
     */
    public void setNinteiChosaIkenshoKekkaJohoChushutsuYMD(FlexibleDate ninteiChosaIkenshoKekkaJohoChushutsuYMD) {
        this.ninteiChosaIkenshoKekkaJohoChushutsuYMD = ninteiChosaIkenshoKekkaJohoChushutsuYMD;
    }

    /**
     * 一次判定情報抽出年月日のgetメソッドです。
     * <br/>
     * <br/>一次判定結果連携時、市町村から広域連合に渡すデータを作成した日付
     *
     * @return 一次判定情報抽出年月日
     */
    @CheckForNull
    public FlexibleDate getIchijihanteiChushutsuYMD() {
        return ichijihanteiChushutsuYMD;
    }

    /**
     * 一次判定情報抽出年月日のsetメソッドです。
     * <br/>
     * <br/>一次判定結果連携時、市町村から広域連合に渡すデータを作成した日付
     *
     * @param ichijihanteiChushutsuYMD 一次判定情報抽出年月日
     */
    public void setIchijihanteiChushutsuYMD(FlexibleDate ichijihanteiChushutsuYMD) {
        this.ichijihanteiChushutsuYMD = ichijihanteiChushutsuYMD;
    }

    /**
     * 審査会結果情報抽出年月日のgetメソッドです。
     *
     * @return 審査会結果情報抽出年月日
     */
    @CheckForNull
    public FlexibleDate getShinsakaiKekkaJohoChushutsuYMD() {
        return shinsakaiKekkaJohoChushutsuYMD;
    }

    /**
     * 審査会結果情報抽出年月日のsetメソッドです。
     *
     * @param shinsakaiKekkaJohoChushutsuYMD 審査会結果情報抽出年月日
     */
    public void setShinsakaiKekkaJohoChushutsuYMD(FlexibleDate shinsakaiKekkaJohoChushutsuYMD) {
        this.shinsakaiKekkaJohoChushutsuYMD = shinsakaiKekkaJohoChushutsuYMD;
    }

    /**
     * センター送信情報抽出年月日のgetメソッドです。
     *
     * @return センター送信情報抽出年月日
     */
    @CheckForNull
    public FlexibleDate getCenterSoshinChushutsuYMD() {
        return centerSoshinChushutsuYMD;
    }

    /**
     * センター送信情報抽出年月日のsetメソッドです。
     *
     * @param centerSoshinChushutsuYMD センター送信情報抽出年月日
     */
    public void setCenterSoshinChushutsuYMD(FlexibleDate centerSoshinChushutsuYMD) {
        this.centerSoshinChushutsuYMD = centerSoshinChushutsuYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7211GaibuRenkeiDataoutputJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal DbT7211GaibuRenkeiDataoutputJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7211GaibuRenkeiDataoutputJohoEntity other) {
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
    public void shallowCopy(DbT7211GaibuRenkeiDataoutputJohoEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ninteiShinseiJohoChushutsuYMD = entity.ninteiShinseiJohoChushutsuYMD;
        this.ninteiChosaKekkaJohoChushutsuYMD = entity.ninteiChosaKekkaJohoChushutsuYMD;
        this.ninteiChosaIkenshoKekkaJohoChushutsuYMD = entity.ninteiChosaIkenshoKekkaJohoChushutsuYMD;
        this.ichijihanteiChushutsuYMD = entity.ichijihanteiChushutsuYMD;
        this.shinsakaiKekkaJohoChushutsuYMD = entity.shinsakaiKekkaJohoChushutsuYMD;
        this.centerSoshinChushutsuYMD = entity.centerSoshinChushutsuYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ninteiShinseiJohoChushutsuYMD, ninteiChosaKekkaJohoChushutsuYMD, ninteiChosaIkenshoKekkaJohoChushutsuYMD, ichijihanteiChushutsuYMD, shinsakaiKekkaJohoChushutsuYMD, centerSoshinChushutsuYMD);
    }

// </editor-fold>
}
