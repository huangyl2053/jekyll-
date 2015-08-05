package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import java.util.Objects;

/**
 * 住宅改修理由書作成手数料請求集計テーブルのエンティティクラスです。
 */
public class DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity extends DbTableEntityBase<DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3096JutakuKaishuRiyushoTesuryoShukei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth shukeiKaishiYM;
    @PrimaryKey
    private int rirekiNo;
    private FlexibleYearMonth shukeiShuryoYM;
    private JigyoshaNo riyushoSakuseiJigyoshaNo;
    private Decimal riyushoSakuseiKensu;
    private Decimal riyushoSakuseiTanka;
    private Decimal riyushoSakuseiSeikyuKingaku;
    private FlexibleDate riyushoSakuseiShinseiYMD;
    private FlexibleDate riyushoSakuseiUketsukeYMD;
    private RString shiharaiHohoKubun;
    private ShikibetsuCode shikibetsuNo;

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
    public HokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(HokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 集計開始年月のgetメソッドです。
     *
     * @return 集計開始年月
     */
    public FlexibleYearMonth getShukeiKaishiYM() {
        return shukeiKaishiYM;
    }

    /**
     * 集計開始年月のsetメソッドです。
     *
     * @param shukeiKaishiYM 集計開始年月
     */
    public void setShukeiKaishiYM(FlexibleYearMonth shukeiKaishiYM) {
        this.shukeiKaishiYM = shukeiKaishiYM;
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
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 集計終了年月のgetメソッドです。
     *
     * @return 集計終了年月
     */
    public FlexibleYearMonth getShukeiShuryoYM() {
        return shukeiShuryoYM;
    }

    /**
     * 集計終了年月のsetメソッドです。
     *
     * @param shukeiShuryoYM 集計終了年月
     */
    public void setShukeiShuryoYM(FlexibleYearMonth shukeiShuryoYM) {
        this.shukeiShuryoYM = shukeiShuryoYM;
    }

    /**
     * 介護住宅改修理由書作成事業者番号のgetメソッドです。
     *
     * @return 介護住宅改修理由書作成事業者番号
     */
    public JigyoshaNo getRiyushoSakuseiJigyoshaNo() {
        return riyushoSakuseiJigyoshaNo;
    }

    /**
     * 介護住宅改修理由書作成事業者番号のsetメソッドです。
     *
     * @param riyushoSakuseiJigyoshaNo 介護住宅改修理由書作成事業者番号
     */
    public void setRiyushoSakuseiJigyoshaNo(JigyoshaNo riyushoSakuseiJigyoshaNo) {
        this.riyushoSakuseiJigyoshaNo = riyushoSakuseiJigyoshaNo;
    }

    /**
     * 介護住宅改修理由書作成件数のgetメソッドです。
     *
     * @return 介護住宅改修理由書作成件数
     */
    public Decimal getRiyushoSakuseiKensu() {
        return riyushoSakuseiKensu;
    }

    /**
     * 介護住宅改修理由書作成件数のsetメソッドです。
     *
     * @param riyushoSakuseiKensu 介護住宅改修理由書作成件数
     */
    public void setRiyushoSakuseiKensu(Decimal riyushoSakuseiKensu) {
        this.riyushoSakuseiKensu = riyushoSakuseiKensu;
    }

    /**
     * 介護住宅改修理由書作成単価のgetメソッドです。
     *
     * @return 介護住宅改修理由書作成単価
     */
    public Decimal getRiyushoSakuseiTanka() {
        return riyushoSakuseiTanka;
    }

    /**
     * 介護住宅改修理由書作成単価のsetメソッドです。
     *
     * @param riyushoSakuseiTanka 介護住宅改修理由書作成単価
     */
    public void setRiyushoSakuseiTanka(Decimal riyushoSakuseiTanka) {
        this.riyushoSakuseiTanka = riyushoSakuseiTanka;
    }

    /**
     * 介護住宅改修理由書作成請求金額のgetメソッドです。
     *
     * @return 介護住宅改修理由書作成請求金額
     */
    public Decimal getRiyushoSakuseiSeikyuKingaku() {
        return riyushoSakuseiSeikyuKingaku;
    }

    /**
     * 介護住宅改修理由書作成請求金額のsetメソッドです。
     *
     * @param riyushoSakuseiSeikyuKingaku 介護住宅改修理由書作成請求金額
     */
    public void setRiyushoSakuseiSeikyuKingaku(Decimal riyushoSakuseiSeikyuKingaku) {
        this.riyushoSakuseiSeikyuKingaku = riyushoSakuseiSeikyuKingaku;
    }

    /**
     * 介護住宅改修理由書作成申請年月日のgetメソッドです。
     *
     * @return 介護住宅改修理由書作成申請年月日
     */
    public FlexibleDate getRiyushoSakuseiShinseiYMD() {
        return riyushoSakuseiShinseiYMD;
    }

    /**
     * 介護住宅改修理由書作成申請年月日のsetメソッドです。
     *
     * @param riyushoSakuseiShinseiYMD 介護住宅改修理由書作成申請年月日
     */
    public void setRiyushoSakuseiShinseiYMD(FlexibleDate riyushoSakuseiShinseiYMD) {
        this.riyushoSakuseiShinseiYMD = riyushoSakuseiShinseiYMD;
    }

    /**
     * 介護住宅改修理由書作成受付年月日のgetメソッドです。
     *
     * @return 介護住宅改修理由書作成受付年月日
     */
    public FlexibleDate getRiyushoSakuseiUketsukeYMD() {
        return riyushoSakuseiUketsukeYMD;
    }

    /**
     * 介護住宅改修理由書作成受付年月日のsetメソッドです。
     *
     * @param riyushoSakuseiUketsukeYMD 介護住宅改修理由書作成受付年月日
     */
    public void setRiyushoSakuseiUketsukeYMD(FlexibleDate riyushoSakuseiUketsukeYMD) {
        this.riyushoSakuseiUketsukeYMD = riyushoSakuseiUketsukeYMD;
    }

    /**
     * 介護支払方法区分のgetメソッドです。
     *
     * @return 介護支払方法区分
     */
    public RString getShiharaiHohoKubun() {
        return shiharaiHohoKubun;
    }

    /**
     * 介護支払方法区分のsetメソッドです。
     *
     * @param shiharaiHohoKubun 介護支払方法区分
     */
    public void setShiharaiHohoKubun(RString shiharaiHohoKubun) {
        this.shiharaiHohoKubun = shiharaiHohoKubun;
    }

    /**
     * 識別コードのgetメソッドです。
     * <br/>
     * <br/>住宅改修理由書作成事業者の法人口座取得用
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuNo() {
        return shikibetsuNo;
    }

    /**
     * 識別コードのsetメソッドです。
     * <br/>
     * <br/>住宅改修理由書作成事業者の法人口座取得用
     *
     * @param shikibetsuNo 識別コード
     */
    public void setShikibetsuNo(ShikibetsuCode shikibetsuNo) {
        this.shikibetsuNo = shikibetsuNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shukeiKaishiYM, other.shukeiKaishiYM)) {
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
    public void shallowCopy(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shukeiKaishiYM = entity.shukeiKaishiYM;
        this.rirekiNo = entity.rirekiNo;
        this.shukeiShuryoYM = entity.shukeiShuryoYM;
        this.riyushoSakuseiJigyoshaNo = entity.riyushoSakuseiJigyoshaNo;
        this.riyushoSakuseiKensu = entity.riyushoSakuseiKensu;
        this.riyushoSakuseiTanka = entity.riyushoSakuseiTanka;
        this.riyushoSakuseiSeikyuKingaku = entity.riyushoSakuseiSeikyuKingaku;
        this.riyushoSakuseiShinseiYMD = entity.riyushoSakuseiShinseiYMD;
        this.riyushoSakuseiUketsukeYMD = entity.riyushoSakuseiUketsukeYMD;
        this.shiharaiHohoKubun = entity.shiharaiHohoKubun;
        this.shikibetsuNo = entity.shikibetsuNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, shukeiKaishiYM, rirekiNo, shukeiShuryoYM, riyushoSakuseiJigyoshaNo, riyushoSakuseiKensu, riyushoSakuseiTanka, riyushoSakuseiSeikyuKingaku, riyushoSakuseiShinseiYMD, riyushoSakuseiUketsukeYMD, shiharaiHohoKubun, shikibetsuNo);
    }

// </editor-fold>
}
