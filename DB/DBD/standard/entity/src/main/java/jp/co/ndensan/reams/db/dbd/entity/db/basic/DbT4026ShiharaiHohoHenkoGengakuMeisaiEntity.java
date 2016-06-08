package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 支払方法変更減額明細テーブルのエンティティクラスです。
 */
public class DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity extends DbTableEntityBase<DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4026ShiharaiHohoHenkoGengakuMeisai");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RString kanriKubun;
    @PrimaryKey
    private int rirekiNo;
    @PrimaryKey
    private FlexibleYear taishoNendo;
    private Decimal mino_JikoShometsuGengaku;
    private Decimal nofugaku;
    private Decimal nenFukagaku;

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
     * 証記載保険者番号のgetメソッドです。
     * 
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     * 
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(@Nonnull ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 被保険者番号のgetメソッドです。
     * 
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * 
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(@Nonnull HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 管理区分のgetメソッドです。
     * 
     * @return 管理区分
     */
    public RString getKanriKubun() {
        return kanriKubun;
    }

    /**
     * 管理区分のsetメソッドです。
     * 
     * @param kanriKubun 管理区分
     */
    public void setKanriKubun(@Nonnull RString kanriKubun) {
        this.kanriKubun = kanriKubun;
    }

    /**
     * 履歴番号のgetメソッドです。
     * 
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     * 
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 対象年度のgetメソッドです。
     * 
     * @return 対象年度
     */
    public FlexibleYear getTaishoNendo() {
        return taishoNendo;
    }

    /**
     * 対象年度のsetメソッドです。
     * 
     * @param taishoNendo 対象年度
     */
    public void setTaishoNendo(@Nonnull FlexibleYear taishoNendo) {
        this.taishoNendo = taishoNendo;
    }

    /**
     * 未納・時効消滅減額のgetメソッドです。
     * 
     * @return 未納・時効消滅減額
     */
    @CheckForNull
    public Decimal getMino_JikoShometsuGengaku() {
        return mino_JikoShometsuGengaku;
    }

    /**
     * 未納・時効消滅減額のsetメソッドです。
     * 
     * @param mino_JikoShometsuGengaku 未納・時効消滅減額
     */
    public void setMino_JikoShometsuGengaku(Decimal mino_JikoShometsuGengaku) {
        this.mino_JikoShometsuGengaku = mino_JikoShometsuGengaku;
    }

    /**
     * 納付額のgetメソッドです。
     * 
     * @return 納付額
     */
    @CheckForNull
    public Decimal getNofugaku() {
        return nofugaku;
    }

    /**
     * 納付額のsetメソッドです。
     * 
     * @param nofugaku 納付額
     */
    public void setNofugaku(Decimal nofugaku) {
        this.nofugaku = nofugaku;
    }

    /**
     * 年賦課額のgetメソッドです。
     * 
     * @return 年賦課額
     */
    @CheckForNull
    public Decimal getNenFukagaku() {
        return nenFukagaku;
    }

    /**
     * 年賦課額のsetメソッドです。
     * 
     * @param nenFukagaku 年賦課額
     */
    public void setNenFukagaku(Decimal nenFukagaku) {
        this.nenFukagaku = nenFukagaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.kanriKubun, other.kanriKubun)) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        if (!Objects.equals(this.taishoNendo, other.taishoNendo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kanriKubun = entity.kanriKubun;
        this.rirekiNo = entity.rirekiNo;
        this.taishoNendo = entity.taishoNendo;
        this.mino_JikoShometsuGengaku = entity.mino_JikoShometsuGengaku;
        this.nofugaku = entity.nofugaku;
        this.nenFukagaku = entity.nenFukagaku;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, hihokenshaNo, kanriKubun, rirekiNo, taishoNendo, mino_JikoShometsuGengaku, nofugaku, nenFukagaku);
    }

// </editor-fold>

}
