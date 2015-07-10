package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3076KogakuJuryoininKeiyakuJigyoshaの項目定義クラスです
 *
 */
public class DbT3076KogakuJuryoininKeiyakuJigyoshaEntity extends DbTableEntityBase<DbT3076KogakuJuryoininKeiyakuJigyoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3076KogakuJuryoininKeiyakuJigyosha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private FlexibleDate uketsukeYMD;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private FlexibleDate shinseiYMD;
    private JigyoshaNo jigyoshaNo;
    private FlexibleDate ketteiYMD;
    private RString shoninKekkaKubun;
    private FlexibleDate juryoininKaishiYMD;
    private FlexibleDate juryoininShuryoYMD;
    private RString keiyakuNo;
    private RString fuShoninRiyu;
    private Decimal riyoshaFutanJogenGaku;
    private FlexibleDate shoninKekkaTsuchiSakuseiYMD;
    private RString shoninKekkaTsuchiSaiHakkoKubun;

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
     * getHihokenshaNo
     *
     * @return hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * getShikibetsuCode
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     *
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
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
     * getUketsukeYMD
     *
     * @return uketsukeYMD
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * setUketsukeYMD
     *
     * @param uketsukeYMD uketsukeYMD
     */
    public void setUketsukeYMD(FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
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
     * getShinseiYMD
     *
     * @return shinseiYMD
     */
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * setShinseiYMD
     *
     * @param shinseiYMD shinseiYMD
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * getJigyoshaNo
     *
     * @return jigyoshaNo
     */
    public JigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * setJigyoshaNo
     *
     * @param jigyoshaNo jigyoshaNo
     */
    public void setJigyoshaNo(JigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * getKetteiYMD
     *
     * @return ketteiYMD
     */
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * setKetteiYMD
     *
     * @param ketteiYMD ketteiYMD
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
    }

    /**
     * getShoninKekkaKubun
     *
     * @return shoninKekkaKubun
     */
    public RString getShoninKekkaKubun() {
        return shoninKekkaKubun;
    }

    /**
     * setShoninKekkaKubun
     *
     * @param shoninKekkaKubun shoninKekkaKubun
     */
    public void setShoninKekkaKubun(RString shoninKekkaKubun) {
        this.shoninKekkaKubun = shoninKekkaKubun;
    }

    /**
     * getJuryoininKaishiYMD
     *
     * @return juryoininKaishiYMD
     */
    public FlexibleDate getJuryoininKaishiYMD() {
        return juryoininKaishiYMD;
    }

    /**
     * setJuryoininKaishiYMD
     *
     * @param juryoininKaishiYMD juryoininKaishiYMD
     */
    public void setJuryoininKaishiYMD(FlexibleDate juryoininKaishiYMD) {
        this.juryoininKaishiYMD = juryoininKaishiYMD;
    }

    /**
     * getJuryoininShuryoYMD
     *
     * @return juryoininShuryoYMD
     */
    public FlexibleDate getJuryoininShuryoYMD() {
        return juryoininShuryoYMD;
    }

    /**
     * setJuryoininShuryoYMD
     *
     * @param juryoininShuryoYMD juryoininShuryoYMD
     */
    public void setJuryoininShuryoYMD(FlexibleDate juryoininShuryoYMD) {
        this.juryoininShuryoYMD = juryoininShuryoYMD;
    }

    /**
     * getKeiyakuNo
     *
     * @return keiyakuNo
     */
    public RString getKeiyakuNo() {
        return keiyakuNo;
    }

    /**
     * setKeiyakuNo
     *
     * @param keiyakuNo keiyakuNo
     */
    public void setKeiyakuNo(RString keiyakuNo) {
        this.keiyakuNo = keiyakuNo;
    }

    /**
     * getFuShoninRiyu
     *
     * @return fuShoninRiyu
     */
    public RString getFuShoninRiyu() {
        return fuShoninRiyu;
    }

    /**
     * setFuShoninRiyu
     *
     * @param fuShoninRiyu fuShoninRiyu
     */
    public void setFuShoninRiyu(RString fuShoninRiyu) {
        this.fuShoninRiyu = fuShoninRiyu;
    }

    /**
     * getRiyoshaFutanJogenGaku
     *
     * @return riyoshaFutanJogenGaku
     */
    public Decimal getRiyoshaFutanJogenGaku() {
        return riyoshaFutanJogenGaku;
    }

    /**
     * setRiyoshaFutanJogenGaku
     *
     * @param riyoshaFutanJogenGaku riyoshaFutanJogenGaku
     */
    public void setRiyoshaFutanJogenGaku(Decimal riyoshaFutanJogenGaku) {
        this.riyoshaFutanJogenGaku = riyoshaFutanJogenGaku;
    }

    /**
     * getShoninKekkaTsuchiSakuseiYMD
     *
     * @return shoninKekkaTsuchiSakuseiYMD
     */
    public FlexibleDate getShoninKekkaTsuchiSakuseiYMD() {
        return shoninKekkaTsuchiSakuseiYMD;
    }

    /**
     * setShoninKekkaTsuchiSakuseiYMD
     *
     * @param shoninKekkaTsuchiSakuseiYMD shoninKekkaTsuchiSakuseiYMD
     */
    public void setShoninKekkaTsuchiSakuseiYMD(FlexibleDate shoninKekkaTsuchiSakuseiYMD) {
        this.shoninKekkaTsuchiSakuseiYMD = shoninKekkaTsuchiSakuseiYMD;
    }

    /**
     * getShoninKekkaTsuchiSaiHakkoKubun
     *
     * @return shoninKekkaTsuchiSaiHakkoKubun
     */
    public RString getShoninKekkaTsuchiSaiHakkoKubun() {
        return shoninKekkaTsuchiSaiHakkoKubun;
    }

    /**
     * setShoninKekkaTsuchiSaiHakkoKubun
     *
     * @param shoninKekkaTsuchiSaiHakkoKubun shoninKekkaTsuchiSaiHakkoKubun
     */
    public void setShoninKekkaTsuchiSaiHakkoKubun(RString shoninKekkaTsuchiSaiHakkoKubun) {
        this.shoninKekkaTsuchiSaiHakkoKubun = shoninKekkaTsuchiSaiHakkoKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3076KogakuJuryoininKeiyakuJigyoshaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3076KogakuJuryoininKeiyakuJigyoshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.uketsukeYMD, other.uketsukeYMD)) {
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
    public void shallowCopy(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.shinseiYMD = entity.shinseiYMD;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.ketteiYMD = entity.ketteiYMD;
        this.shoninKekkaKubun = entity.shoninKekkaKubun;
        this.juryoininKaishiYMD = entity.juryoininKaishiYMD;
        this.juryoininShuryoYMD = entity.juryoininShuryoYMD;
        this.keiyakuNo = entity.keiyakuNo;
        this.fuShoninRiyu = entity.fuShoninRiyu;
        this.riyoshaFutanJogenGaku = entity.riyoshaFutanJogenGaku;
        this.shoninKekkaTsuchiSakuseiYMD = entity.shoninKekkaTsuchiSakuseiYMD;
        this.shoninKekkaTsuchiSaiHakkoKubun = entity.shoninKekkaTsuchiSaiHakkoKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, shikibetsuCode, shoKisaiHokenshaNo, uketsukeYMD, shoriTimestamp, shinseiYMD, jigyoshaNo, ketteiYMD, shoninKekkaKubun, juryoininKaishiYMD, juryoininShuryoYMD, keiyakuNo, fuShoninRiyu, riyoshaFutanJogenGaku, shoninKekkaTsuchiSakuseiYMD, shoninKekkaTsuchiSaiHakkoKubun);
    }

// </editor-fold>
}
