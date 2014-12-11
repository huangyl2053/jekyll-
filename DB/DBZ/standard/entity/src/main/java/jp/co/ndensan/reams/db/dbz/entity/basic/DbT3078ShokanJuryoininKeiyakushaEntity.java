package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
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
 * DbT3078ShokanJuryoininKeiyakushaの項目定義クラスです
 *
 */
public class DbT3078ShokanJuryoininKeiyakushaEntity extends DbTableEntityBase<DbT3078ShokanJuryoininKeiyakushaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3078ShokanJuryoininKeiyakusha");

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
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private FlexibleDate uketsukeYMD;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private FlexibleDate shinseiYMD;
    private RString jigyoshaKeiyakuNo;
    private RString keiyakuServiceShurui;
    private FlexibleDate ketteiYMD;
    private RString shoninKekkaKubun;
    private FlexibleDate juryoininKaishiYMD;
    private FlexibleDate juryoininShuryoYMD;
    private RString keiyakuNo;
    private RString fuShoninRiyu;
    private Decimal hiyoGakuGokei;
    private Decimal hokenTaishoHiyoGaku;
    private Decimal riyoshaJikoFutanGaku;
    private Decimal hokenKyufuhiGaku;
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
     * getShoKisaiHokenshaNo
     *
     * @return shoKisaiHokenshaNo
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * setShoKisaiHokenshaNo
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     */
    public void setShoKisaiHokenshaNo(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
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
     * getJigyoshaKeiyakuNo
     *
     * @return jigyoshaKeiyakuNo
     */
    public RString getJigyoshaKeiyakuNo() {
        return jigyoshaKeiyakuNo;
    }

    /**
     * setJigyoshaKeiyakuNo
     *
     * @param jigyoshaKeiyakuNo jigyoshaKeiyakuNo
     */
    public void setJigyoshaKeiyakuNo(RString jigyoshaKeiyakuNo) {
        this.jigyoshaKeiyakuNo = jigyoshaKeiyakuNo;
    }

    /**
     * getKeiyakuServiceShurui
     *
     * @return keiyakuServiceShurui
     */
    public RString getKeiyakuServiceShurui() {
        return keiyakuServiceShurui;
    }

    /**
     * setKeiyakuServiceShurui
     *
     * @param keiyakuServiceShurui keiyakuServiceShurui
     */
    public void setKeiyakuServiceShurui(RString keiyakuServiceShurui) {
        this.keiyakuServiceShurui = keiyakuServiceShurui;
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
     * getHiyoGakuGokei
     *
     * @return hiyoGakuGokei
     */
    public Decimal getHiyoGakuGokei() {
        return hiyoGakuGokei;
    }

    /**
     * setHiyoGakuGokei
     *
     * @param hiyoGakuGokei hiyoGakuGokei
     */
    public void setHiyoGakuGokei(Decimal hiyoGakuGokei) {
        this.hiyoGakuGokei = hiyoGakuGokei;
    }

    /**
     * getHokenTaishoHiyoGaku
     *
     * @return hokenTaishoHiyoGaku
     */
    public Decimal getHokenTaishoHiyoGaku() {
        return hokenTaishoHiyoGaku;
    }

    /**
     * setHokenTaishoHiyoGaku
     *
     * @param hokenTaishoHiyoGaku hokenTaishoHiyoGaku
     */
    public void setHokenTaishoHiyoGaku(Decimal hokenTaishoHiyoGaku) {
        this.hokenTaishoHiyoGaku = hokenTaishoHiyoGaku;
    }

    /**
     * getRiyoshaJikoFutanGaku
     *
     * @return riyoshaJikoFutanGaku
     */
    public Decimal getRiyoshaJikoFutanGaku() {
        return riyoshaJikoFutanGaku;
    }

    /**
     * setRiyoshaJikoFutanGaku
     *
     * @param riyoshaJikoFutanGaku riyoshaJikoFutanGaku
     */
    public void setRiyoshaJikoFutanGaku(Decimal riyoshaJikoFutanGaku) {
        this.riyoshaJikoFutanGaku = riyoshaJikoFutanGaku;
    }

    /**
     * getHokenKyufuhiGaku
     *
     * @return hokenKyufuhiGaku
     */
    public Decimal getHokenKyufuhiGaku() {
        return hokenKyufuhiGaku;
    }

    /**
     * setHokenKyufuhiGaku
     *
     * @param hokenKyufuhiGaku hokenKyufuhiGaku
     */
    public void setHokenKyufuhiGaku(Decimal hokenKyufuhiGaku) {
        this.hokenKyufuhiGaku = hokenKyufuhiGaku;
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
     * このエンティティの主キーが他の{@literal DbT3078ShokanJuryoininKeiyakushaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3078ShokanJuryoininKeiyakushaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3078ShokanJuryoininKeiyakushaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
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
    public void shallowCopy(DbT3078ShokanJuryoininKeiyakushaEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.shinseiYMD = entity.shinseiYMD;
        this.jigyoshaKeiyakuNo = entity.jigyoshaKeiyakuNo;
        this.keiyakuServiceShurui = entity.keiyakuServiceShurui;
        this.ketteiYMD = entity.ketteiYMD;
        this.shoninKekkaKubun = entity.shoninKekkaKubun;
        this.juryoininKaishiYMD = entity.juryoininKaishiYMD;
        this.juryoininShuryoYMD = entity.juryoininShuryoYMD;
        this.keiyakuNo = entity.keiyakuNo;
        this.fuShoninRiyu = entity.fuShoninRiyu;
        this.hiyoGakuGokei = entity.hiyoGakuGokei;
        this.hokenTaishoHiyoGaku = entity.hokenTaishoHiyoGaku;
        this.riyoshaJikoFutanGaku = entity.riyoshaJikoFutanGaku;
        this.hokenKyufuhiGaku = entity.hokenKyufuhiGaku;
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
        return super.toMd5(hihokenshaNo, shoKisaiHokenshaNo, uketsukeYMD, shoriTimestamp, shinseiYMD, jigyoshaKeiyakuNo, keiyakuServiceShurui, ketteiYMD, shoninKekkaKubun, juryoininKaishiYMD, juryoininShuryoYMD, keiyakuNo, fuShoninRiyu, hiyoGakuGokei, hokenTaishoHiyoGaku, riyoshaJikoFutanGaku, hokenKyufuhiGaku, shoninKekkaTsuchiSakuseiYMD, shoninKekkaTsuchiSaiHakkoKubun);
    }

// </editor-fold>
}
