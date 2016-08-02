package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 通知書発行情報テーブルのエンティティクラスです。
 */
public class DbT4122TsuchishoHakkoJohoEntity extends DbTableEntityBase<DbT4122TsuchishoHakkoJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4122TsuchishoHakkoJoho");

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
    private Code tsuchiKubun;
    private RString tsuchiRiyu;
    private FlexibleDate tsuchiYMD;
    private FlexibleDate tsuchiKaishiYMD;
    private FlexibleDate tsuchiShuryoYMD;
    private FlexibleDate tsuchiKubunKigenYMD;
    private FlexibleDate tsuchiKanryoYMD;

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
     * 通知区分のgetメソッドです。
     * <br/>
     * <br/>00:認定、01:変更、02:サ変、03:却下、04:取消、05:延期、06:区却
     * 
     * @return 通知区分
     */
    @CheckForNull
    public Code getTsuchiKubun() {
        return tsuchiKubun;
    }

    /**
     * 通知区分のsetメソッドです。
     * <br/>
     * <br/>00:認定、01:変更、02:サ変、03:却下、04:取消、05:延期、06:区却
     * 
     * @param tsuchiKubun 通知区分
     */
    public void setTsuchiKubun(Code tsuchiKubun) {
        this.tsuchiKubun = tsuchiKubun;
    }

    /**
     * 通知理由のgetメソッドです。
     * 
     * @return 通知理由
     */
    @CheckForNull
    public RString getTsuchiRiyu() {
        return tsuchiRiyu;
    }

    /**
     * 通知理由のsetメソッドです。
     * 
     * @param tsuchiRiyu 通知理由
     */
    public void setTsuchiRiyu(RString tsuchiRiyu) {
        this.tsuchiRiyu = tsuchiRiyu;
    }

    /**
     * 通知年月日のgetメソッドです。
     * 
     * @return 通知年月日
     */
    @CheckForNull
    public FlexibleDate getTsuchiYMD() {
        return tsuchiYMD;
    }

    /**
     * 通知年月日のsetメソッドです。
     * 
     * @param tsuchiYMD 通知年月日
     */
    public void setTsuchiYMD(FlexibleDate tsuchiYMD) {
        this.tsuchiYMD = tsuchiYMD;
    }

    /**
     * 通知開始年月日のgetメソッドです。
     * 
     * @return 通知開始年月日
     */
    @CheckForNull
    public FlexibleDate getTsuchiKaishiYMD() {
        return tsuchiKaishiYMD;
    }

    /**
     * 通知開始年月日のsetメソッドです。
     * 
     * @param tsuchiKaishiYMD 通知開始年月日
     */
    public void setTsuchiKaishiYMD(FlexibleDate tsuchiKaishiYMD) {
        this.tsuchiKaishiYMD = tsuchiKaishiYMD;
    }

    /**
     * 通知終了年月日のgetメソッドです。
     * 
     * @return 通知終了年月日
     */
    @CheckForNull
    public FlexibleDate getTsuchiShuryoYMD() {
        return tsuchiShuryoYMD;
    }

    /**
     * 通知終了年月日のsetメソッドです。
     * 
     * @param tsuchiShuryoYMD 通知終了年月日
     */
    public void setTsuchiShuryoYMD(FlexibleDate tsuchiShuryoYMD) {
        this.tsuchiShuryoYMD = tsuchiShuryoYMD;
    }

    /**
     * 通知区分期限のgetメソッドです。
     * 
     * @return 通知区分期限
     */
    @CheckForNull
    public FlexibleDate getTsuchiKubunKigenYMD() {
        return tsuchiKubunKigenYMD;
    }

    /**
     * 通知区分期限のsetメソッドです。
     * 
     * @param tsuchiKubunKigenYMD 通知区分期限
     */
    public void setTsuchiKubunKigenYMD(FlexibleDate tsuchiKubunKigenYMD) {
        this.tsuchiKubunKigenYMD = tsuchiKubunKigenYMD;
    }

    /**
     * 通知完了年月日のgetメソッドです。
     * 
     * @return 通知完了年月日
     */
    @CheckForNull
    public FlexibleDate getTsuchiKanryoYMD() {
        return tsuchiKanryoYMD;
    }

    /**
     * 通知完了年月日のsetメソッドです。
     * 
     * @param tsuchiKanryoYMD 通知完了年月日
     */
    public void setTsuchiKanryoYMD(FlexibleDate tsuchiKanryoYMD) {
        this.tsuchiKanryoYMD = tsuchiKanryoYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4122TsuchishoHakkoJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4122TsuchishoHakkoJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4122TsuchishoHakkoJohoEntity other) {
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
    public void shallowCopy(DbT4122TsuchishoHakkoJohoEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.tsuchiKubun = entity.tsuchiKubun;
        this.tsuchiRiyu = entity.tsuchiRiyu;
        this.tsuchiYMD = entity.tsuchiYMD;
        this.tsuchiKaishiYMD = entity.tsuchiKaishiYMD;
        this.tsuchiShuryoYMD = entity.tsuchiShuryoYMD;
        this.tsuchiKubunKigenYMD = entity.tsuchiKubunKigenYMD;
        this.tsuchiKanryoYMD = entity.tsuchiKanryoYMD;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, tsuchiKubun, tsuchiRiyu, tsuchiYMD, tsuchiKaishiYMD, tsuchiShuryoYMD, tsuchiKubunKigenYMD, tsuchiKanryoYMD);
    }

// </editor-fold>
}
