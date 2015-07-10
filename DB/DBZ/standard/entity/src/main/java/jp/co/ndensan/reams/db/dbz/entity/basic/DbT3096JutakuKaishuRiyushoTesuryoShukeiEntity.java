package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3096JutakuKaishuRiyushoTesuryoShukeiの項目定義クラスです
 *
 */
public class DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity extends DbTableEntityBase<DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

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
    private YMDHMS shoriTimestamp;
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
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getShoKisaiHokenshaNo
     *
     * @return shoKisaiHokenshaNo
     */
    public HokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * setShoKisaiHokenshaNo
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     */
    public void setShoKisaiHokenshaNo(HokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * getShukeiKaishiYM
     *
     * @return shukeiKaishiYM
     */
    public FlexibleYearMonth getShukeiKaishiYM() {
        return shukeiKaishiYM;
    }

    /**
     * setShukeiKaishiYM
     *
     * @param shukeiKaishiYM shukeiKaishiYM
     */
    public void setShukeiKaishiYM(FlexibleYearMonth shukeiKaishiYM) {
        this.shukeiKaishiYM = shukeiKaishiYM;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getShukeiShuryoYM
     *
     * @return shukeiShuryoYM
     */
    public FlexibleYearMonth getShukeiShuryoYM() {
        return shukeiShuryoYM;
    }

    /**
     * setShukeiShuryoYM
     *
     * @param shukeiShuryoYM shukeiShuryoYM
     */
    public void setShukeiShuryoYM(FlexibleYearMonth shukeiShuryoYM) {
        this.shukeiShuryoYM = shukeiShuryoYM;
    }

    /**
     * getRiyushoSakuseiJigyoshaNo
     *
     * @return riyushoSakuseiJigyoshaNo
     */
    public JigyoshaNo getRiyushoSakuseiJigyoshaNo() {
        return riyushoSakuseiJigyoshaNo;
    }

    /**
     * setRiyushoSakuseiJigyoshaNo
     *
     * @param riyushoSakuseiJigyoshaNo riyushoSakuseiJigyoshaNo
     */
    public void setRiyushoSakuseiJigyoshaNo(JigyoshaNo riyushoSakuseiJigyoshaNo) {
        this.riyushoSakuseiJigyoshaNo = riyushoSakuseiJigyoshaNo;
    }

    /**
     * getRiyushoSakuseiKensu
     *
     * @return riyushoSakuseiKensu
     */
    public Decimal getRiyushoSakuseiKensu() {
        return riyushoSakuseiKensu;
    }

    /**
     * setRiyushoSakuseiKensu
     *
     * @param riyushoSakuseiKensu riyushoSakuseiKensu
     */
    public void setRiyushoSakuseiKensu(Decimal riyushoSakuseiKensu) {
        this.riyushoSakuseiKensu = riyushoSakuseiKensu;
    }

    /**
     * getRiyushoSakuseiTanka
     *
     * @return riyushoSakuseiTanka
     */
    public Decimal getRiyushoSakuseiTanka() {
        return riyushoSakuseiTanka;
    }

    /**
     * setRiyushoSakuseiTanka
     *
     * @param riyushoSakuseiTanka riyushoSakuseiTanka
     */
    public void setRiyushoSakuseiTanka(Decimal riyushoSakuseiTanka) {
        this.riyushoSakuseiTanka = riyushoSakuseiTanka;
    }

    /**
     * getRiyushoSakuseiSeikyuKingaku
     *
     * @return riyushoSakuseiSeikyuKingaku
     */
    public Decimal getRiyushoSakuseiSeikyuKingaku() {
        return riyushoSakuseiSeikyuKingaku;
    }

    /**
     * setRiyushoSakuseiSeikyuKingaku
     *
     * @param riyushoSakuseiSeikyuKingaku riyushoSakuseiSeikyuKingaku
     */
    public void setRiyushoSakuseiSeikyuKingaku(Decimal riyushoSakuseiSeikyuKingaku) {
        this.riyushoSakuseiSeikyuKingaku = riyushoSakuseiSeikyuKingaku;
    }

    /**
     * getRiyushoSakuseiShinseiYMD
     *
     * @return riyushoSakuseiShinseiYMD
     */
    public FlexibleDate getRiyushoSakuseiShinseiYMD() {
        return riyushoSakuseiShinseiYMD;
    }

    /**
     * setRiyushoSakuseiShinseiYMD
     *
     * @param riyushoSakuseiShinseiYMD riyushoSakuseiShinseiYMD
     */
    public void setRiyushoSakuseiShinseiYMD(FlexibleDate riyushoSakuseiShinseiYMD) {
        this.riyushoSakuseiShinseiYMD = riyushoSakuseiShinseiYMD;
    }

    /**
     * getRiyushoSakuseiUketsukeYMD
     *
     * @return riyushoSakuseiUketsukeYMD
     */
    public FlexibleDate getRiyushoSakuseiUketsukeYMD() {
        return riyushoSakuseiUketsukeYMD;
    }

    /**
     * setRiyushoSakuseiUketsukeYMD
     *
     * @param riyushoSakuseiUketsukeYMD riyushoSakuseiUketsukeYMD
     */
    public void setRiyushoSakuseiUketsukeYMD(FlexibleDate riyushoSakuseiUketsukeYMD) {
        this.riyushoSakuseiUketsukeYMD = riyushoSakuseiUketsukeYMD;
    }

    /**
     * getShiharaiHohoKubun
     *
     * @return shiharaiHohoKubun
     */
    public RString getShiharaiHohoKubun() {
        return shiharaiHohoKubun;
    }

    /**
     * setShiharaiHohoKubun
     *
     * @param shiharaiHohoKubun shiharaiHohoKubun
     */
    public void setShiharaiHohoKubun(RString shiharaiHohoKubun) {
        this.shiharaiHohoKubun = shiharaiHohoKubun;
    }

    /**
     * getShikibetsuNo
     *
     * @return shikibetsuNo
     */
    public ShikibetsuCode getShikibetsuNo() {
        return shikibetsuNo;
    }

    /**
     * setShikibetsuNo
     *
     * @param shikibetsuNo shikibetsuNo
     */
    public void setShikibetsuNo(ShikibetsuCode shikibetsuNo) {
        this.shikibetsuNo = shikibetsuNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
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
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
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
        this.shoriTimestamp = entity.shoriTimestamp;
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
        return super.toMd5(shoKisaiHokenshaNo, shukeiKaishiYM, shoriTimestamp, shukeiShuryoYM, riyushoSakuseiJigyoshaNo, riyushoSakuseiKensu, riyushoSakuseiTanka, riyushoSakuseiSeikyuKingaku, riyushoSakuseiShinseiYMD, riyushoSakuseiUketsukeYMD, shiharaiHohoKubun, shikibetsuNo);
    }

// </editor-fold>
}
