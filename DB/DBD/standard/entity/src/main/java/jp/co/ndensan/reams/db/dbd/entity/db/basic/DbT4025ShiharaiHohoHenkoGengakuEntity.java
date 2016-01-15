package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 支払方法変更減額テーブルのエンティティクラスです。
 */
public class DbT4025ShiharaiHohoHenkoGengakuEntity extends DbTableEntityBase<DbT4025ShiharaiHohoHenkoGengakuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4025ShiharaiHohoHenkoGengaku");

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
    private FlexibleDate tainoHanteiYMD;
    private FlexibleDate hanteiKijunYMD;
    private Decimal choshukenShometsuKikan;
    private Decimal nofusumiKikan;
    private Decimal nofusumiGengakuKikan;
    private FlexibleDate kakutei_GengakuKaishiYMD;
    private FlexibleDate kakutei_GengakuShuryoYMD;
    private boolean logicalDeletedFlag;

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
     * <br/>
     * <br/>1：２号差止,2：１号償還払化,3：１号給付額減額
     * 
     * @return 管理区分
     */
    public RString getKanriKubun() {
        return kanriKubun;
    }

    /**
     * 管理区分のsetメソッドです。
     * <br/>
     * <br/>1：２号差止,2：１号償還払化,3：１号給付額減額
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
     * 滞納判定年月日のgetメソッドです。
     * 
     * @return 滞納判定年月日
     */
    public FlexibleDate getTainoHanteiYMD() {
        return tainoHanteiYMD;
    }

    /**
     * 滞納判定年月日のsetメソッドです。
     * 
     * @param tainoHanteiYMD 滞納判定年月日
     */
    public void setTainoHanteiYMD(@Nonnull FlexibleDate tainoHanteiYMD) {
        this.tainoHanteiYMD = tainoHanteiYMD;
    }

    /**
     * 判定基準年月日のgetメソッドです。
     * 
     * @return 判定基準年月日
     */
    public FlexibleDate getHanteiKijunYMD() {
        return hanteiKijunYMD;
    }

    /**
     * 判定基準年月日のsetメソッドです。
     * 
     * @param hanteiKijunYMD 判定基準年月日
     */
    public void setHanteiKijunYMD(@Nonnull FlexibleDate hanteiKijunYMD) {
        this.hanteiKijunYMD = hanteiKijunYMD;
    }

    /**
     * 徴収権消滅期間のgetメソッドです。
     * <br/>
     * <br/>年数で管理（1.511等と格納）
     * 
     * @return 徴収権消滅期間
     */
    @CheckForNull
    public Decimal getChoshukenShometsuKikan() {
        return choshukenShometsuKikan;
    }

    /**
     * 徴収権消滅期間のsetメソッドです。
     * <br/>
     * <br/>年数で管理（1.511等と格納）
     * 
     * @param choshukenShometsuKikan 徴収権消滅期間
     */
    public void setChoshukenShometsuKikan(Decimal choshukenShometsuKikan) {
        this.choshukenShometsuKikan = choshukenShometsuKikan;
    }

    /**
     * 納付済期間のgetメソッドです。
     * <br/>
     * <br/>年数で管理（3.738等と格納）
     * 
     * @return 納付済期間
     */
    @CheckForNull
    public Decimal getNofusumiKikan() {
        return nofusumiKikan;
    }

    /**
     * 納付済期間のsetメソッドです。
     * <br/>
     * <br/>年数で管理（3.738等と格納）
     * 
     * @param nofusumiKikan 納付済期間
     */
    public void setNofusumiKikan(Decimal nofusumiKikan) {
        this.nofusumiKikan = nofusumiKikan;
    }

    /**
     * 納付済減額期間のgetメソッドです。
     * <br/>
     * <br/>月数で管理（2 等と格納）
     * 
     * @return 納付済減額期間
     */
    @CheckForNull
    public Decimal getNofusumiGengakuKikan() {
        return nofusumiGengakuKikan;
    }

    /**
     * 納付済減額期間のsetメソッドです。
     * <br/>
     * <br/>月数で管理（2 等と格納）
     * 
     * @param nofusumiGengakuKikan 納付済減額期間
     */
    public void setNofusumiGengakuKikan(Decimal nofusumiGengakuKikan) {
        this.nofusumiGengakuKikan = nofusumiGengakuKikan;
    }

    /**
     * 確定減額期間開始年月日のgetメソッドです。
     * 
     * @return 確定減額期間開始年月日
     */
    @CheckForNull
    public FlexibleDate getKakutei_GengakuKaishiYMD() {
        return kakutei_GengakuKaishiYMD;
    }

    /**
     * 確定減額期間開始年月日のsetメソッドです。
     * 
     * @param kakutei_GengakuKaishiYMD 確定減額期間開始年月日
     */
    public void setKakutei_GengakuKaishiYMD(FlexibleDate kakutei_GengakuKaishiYMD) {
        this.kakutei_GengakuKaishiYMD = kakutei_GengakuKaishiYMD;
    }

    /**
     * 確定減額期間終了年月日のgetメソッドです。
     * 
     * @return 確定減額期間終了年月日
     */
    @CheckForNull
    public FlexibleDate getKakutei_GengakuShuryoYMD() {
        return kakutei_GengakuShuryoYMD;
    }

    /**
     * 確定減額期間終了年月日のsetメソッドです。
     * 
     * @param kakutei_GengakuShuryoYMD 確定減額期間終了年月日
     */
    public void setKakutei_GengakuShuryoYMD(FlexibleDate kakutei_GengakuShuryoYMD) {
        this.kakutei_GengakuShuryoYMD = kakutei_GengakuShuryoYMD;
    }

    /**
     * 論理削除フラグのgetメソッドです。
     * 
     * @return 論理削除フラグ
     */
    @CheckForNull
    public boolean getLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    /**
     * 論理削除フラグのsetメソッドです。
     * 
     * @param logicalDeletedFlag 論理削除フラグ
     */
    public void setLogicalDeletedFlag(boolean logicalDeletedFlag) {
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4025ShiharaiHohoHenkoGengakuEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4025ShiharaiHohoHenkoGengakuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4025ShiharaiHohoHenkoGengakuEntity other) {
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
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT4025ShiharaiHohoHenkoGengakuEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kanriKubun = entity.kanriKubun;
        this.rirekiNo = entity.rirekiNo;
        this.tainoHanteiYMD = entity.tainoHanteiYMD;
        this.hanteiKijunYMD = entity.hanteiKijunYMD;
        this.choshukenShometsuKikan = entity.choshukenShometsuKikan;
        this.nofusumiKikan = entity.nofusumiKikan;
        this.nofusumiGengakuKikan = entity.nofusumiGengakuKikan;
        this.kakutei_GengakuKaishiYMD = entity.kakutei_GengakuKaishiYMD;
        this.kakutei_GengakuShuryoYMD = entity.kakutei_GengakuShuryoYMD;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, hihokenshaNo, kanriKubun, rirekiNo, tainoHanteiYMD, hanteiKijunYMD, choshukenShometsuKikan, nofusumiKikan, nofusumiGengakuKikan, kakutei_GengakuKaishiYMD, kakutei_GengakuShuryoYMD, logicalDeletedFlag);
    }

// </editor-fold>

}
