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
 * 標準負担額減免テーブルのエンティティクラスです。
 */
public class DbT4012HyojunFutangakuGemmenEntity extends DbTableEntityBase<DbT4012HyojunFutangakuGemmenEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT4012HyojunFutangakuGemmen");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private FlexibleDate shinseiYMD;
    private FlexibleDate ketteiYMD;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private RString ketteiKubun;
    private RString hiShoninRiyu;
    @PrimaryKey
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private int rirekiNo;
    private RString shinseiJiyu;
    private RString gengakuKubun;
    private Decimal gengakugoKingaku;
    private RString hyojunFutanKubun;

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
     * shinseiYMDのgetメソッドです。
     *
     * @return shinseiYMD
     */
    @CheckForNull
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * shinseiYMDのsetメソッドです。
     *
     * @param shinseiYMD shinseiYMD
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * ketteiYMDのgetメソッドです。
     *
     * @return ketteiYMD
     */
    @CheckForNull
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * ketteiYMDのsetメソッドです。
     *
     * @param ketteiYMD ketteiYMD
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
    }

    /**
     * tekiyoKaishiYMDのgetメソッドです。
     *
     * @return tekiyoKaishiYMD
     */
    @CheckForNull
    public FlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    /**
     * tekiyoKaishiYMDのsetメソッドです。
     *
     * @param tekiyoKaishiYMD tekiyoKaishiYMD
     */
    public void setTekiyoKaishiYMD(FlexibleDate tekiyoKaishiYMD) {
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    /**
     * tekiyoShuryoYMDのgetメソッドです。
     *
     * @return tekiyoShuryoYMD
     */
    @CheckForNull
    public FlexibleDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    /**
     * tekiyoShuryoYMDのsetメソッドです。
     *
     * @param tekiyoShuryoYMD tekiyoShuryoYMD
     */
    public void setTekiyoShuryoYMD(FlexibleDate tekiyoShuryoYMD) {
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    /**
     * ketteiKubunのgetメソッドです。
     *
     * @return ketteiKubun
     */
    @CheckForNull
    public RString getKetteiKubun() {
        return ketteiKubun;
    }

    /**
     * ketteiKubunのsetメソッドです。
     *
     * @param ketteiKubun ketteiKubun
     */
    public void setKetteiKubun(RString ketteiKubun) {
        this.ketteiKubun = ketteiKubun;
    }

    /**
     * hiShoninRiyuのgetメソッドです。
     *
     * @return hiShoninRiyu
     */
    @CheckForNull
    public RString getHiShoninRiyu() {
        return hiShoninRiyu;
    }

    /**
     * hiShoninRiyuのsetメソッドです。
     *
     * @param hiShoninRiyu hiShoninRiyu
     */
    public void setHiShoninRiyu(RString hiShoninRiyu) {
        this.hiShoninRiyu = hiShoninRiyu;
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
     * 履歴番号のgetメソッドです。
     * <br/>
     * <br/>新規履歴：0, 以降の申請・決定：最大履歴番号+1
     *
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     * <br/>
     * <br/>新規履歴：0, 以降の申請・決定：最大履歴番号+1
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 申請事由のgetメソッドです。
     *
     * @return 申請事由
     */
    @CheckForNull
    public RString getShinseiJiyu() {
        return shinseiJiyu;
    }

    /**
     * 申請事由のsetメソッドです。
     *
     * @param shinseiJiyu 申請事由
     */
    public void setShinseiJiyu(RString shinseiJiyu) {
        this.shinseiJiyu = shinseiJiyu;
    }

    /**
     * 減額区分のgetメソッドです。
     * <br/>
     * <br/>DBDEnum.減額区分
     *
     * <br/>・市町村民税非課税
     *
     * <br/>・老齢福祉年金受給
     *
     * <br/>・その他
     *
     * @return 減額区分
     */
    @CheckForNull
    public RString getGengakuKubun() {
        return gengakuKubun;
    }

    /**
     * 減額区分のsetメソッドです。
     * <br/>
     * <br/>DBDEnum.減額区分
     *
     * <br/>・市町村民税非課税
     *
     * <br/>・老齢福祉年金受給
     *
     * <br/>・その他
     *
     * @param gengakuKubun 減額区分
     */
    public void setGengakuKubun(RString gengakuKubun) {
        this.gengakuKubun = gengakuKubun;
    }

    /**
     * 減額後金額のgetメソッドです。
     *
     * @return 減額後金額
     */
    @CheckForNull
    public Decimal getGengakugoKingaku() {
        return gengakugoKingaku;
    }

    /**
     * 減額後金額のsetメソッドです。
     *
     * @param gengakugoKingaku 減額後金額
     */
    public void setGengakugoKingaku(Decimal gengakugoKingaku) {
        this.gengakugoKingaku = gengakugoKingaku;
    }

    /**
     * 標準負担区分のgetメソッドです。
     * <br/>
     * <br/>DBDEnum.標準負担区分
     *
     * <br/>1:標準負担
     *
     * <br/>2:特定標準負担
     *
     * @return 標準負担区分
     */
    @CheckForNull
    public RString getHyojunFutanKubun() {
        return hyojunFutanKubun;
    }

    /**
     * 標準負担区分のsetメソッドです。
     * <br/>
     * <br/>DBDEnum.標準負担区分
     *
     * <br/>1:標準負担
     *
     * <br/>2:特定標準負担
     *
     * @param hyojunFutanKubun 標準負担区分
     */
    public void setHyojunFutanKubun(RString hyojunFutanKubun) {
        this.hyojunFutanKubun = hyojunFutanKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4012HyojunFutangakuGemmenEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal DbT4012HyojunFutangakuGemmenEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4012HyojunFutangakuGemmenEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
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
    public void shallowCopy(DbT4012HyojunFutangakuGemmenEntity entity) {
        this.shinseiYMD = entity.shinseiYMD;
        this.ketteiYMD = entity.ketteiYMD;
        this.tekiyoKaishiYMD = entity.tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = entity.tekiyoShuryoYMD;
        this.ketteiKubun = entity.ketteiKubun;
        this.hiShoninRiyu = entity.hiShoninRiyu;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.shinseiJiyu = entity.shinseiJiyu;
        this.gengakuKubun = entity.gengakuKubun;
        this.gengakugoKingaku = entity.gengakugoKingaku;
        this.hyojunFutanKubun = entity.hyojunFutanKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseiYMD, ketteiYMD, tekiyoKaishiYMD, tekiyoShuryoYMD, ketteiKubun, hiShoninRiyu, shoKisaiHokenshaNo, hihokenshaNo, rirekiNo, shinseiJiyu, gengakuKubun, gengakugoKingaku, hyojunFutanKubun);
    }

// </editor-fold>
}
