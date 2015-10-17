package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 償還受領委任契約者Aliveテーブルのエンティティクラスです。
 */
public class DbV3078ShokanJuryoininKeiyakushaEntity extends DbTableEntityBase<DbV3078ShokanJuryoininKeiyakushaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbV3078ShokanJuryoininKeiyakusha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private HihokenshaNo hihokenshaNo;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private FlexibleDate uketsukeYMD;
    private int rirekiNo;
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
     * hihokenshaNoのgetメソッドです。
     *
     * @return hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * hihokenshaNoのsetメソッドです。
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * shoKisaiHokenshaNoのgetメソッドです。
     *
     * @return shoKisaiHokenshaNo
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * shoKisaiHokenshaNoのsetメソッドです。
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     */
    public void setShoKisaiHokenshaNo(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * uketsukeYMDのgetメソッドです。
     *
     * @return uketsukeYMD
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * uketsukeYMDのsetメソッドです。
     *
     * @param uketsukeYMD uketsukeYMD
     */
    public void setUketsukeYMD(FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
    }

    /**
     * rirekiNoのgetメソッドです。
     *
     * @return rirekiNo
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * rirekiNoのsetメソッドです。
     *
     * @param rirekiNo rirekiNo
     */
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * shinseiYMDのgetメソッドです。
     *
     * @return shinseiYMD
     */
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
     * jigyoshaKeiyakuNoのgetメソッドです。
     *
     * @return jigyoshaKeiyakuNo
     */
    public RString getJigyoshaKeiyakuNo() {
        return jigyoshaKeiyakuNo;
    }

    /**
     * jigyoshaKeiyakuNoのsetメソッドです。
     *
     * @param jigyoshaKeiyakuNo jigyoshaKeiyakuNo
     */
    public void setJigyoshaKeiyakuNo(RString jigyoshaKeiyakuNo) {
        this.jigyoshaKeiyakuNo = jigyoshaKeiyakuNo;
    }

    /**
     * keiyakuServiceShuruiのgetメソッドです。
     *
     * @return keiyakuServiceShurui
     */
    public RString getKeiyakuServiceShurui() {
        return keiyakuServiceShurui;
    }

    /**
     * keiyakuServiceShuruiのsetメソッドです。
     *
     * @param keiyakuServiceShurui keiyakuServiceShurui
     */
    public void setKeiyakuServiceShurui(RString keiyakuServiceShurui) {
        this.keiyakuServiceShurui = keiyakuServiceShurui;
    }

    /**
     * ketteiYMDのgetメソッドです。
     *
     * @return ketteiYMD
     */
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
     * shoninKekkaKubunのgetメソッドです。
     *
     * @return shoninKekkaKubun
     */
    public RString getShoninKekkaKubun() {
        return shoninKekkaKubun;
    }

    /**
     * shoninKekkaKubunのsetメソッドです。
     *
     * @param shoninKekkaKubun shoninKekkaKubun
     */
    public void setShoninKekkaKubun(RString shoninKekkaKubun) {
        this.shoninKekkaKubun = shoninKekkaKubun;
    }

    /**
     * juryoininKaishiYMDのgetメソッドです。
     *
     * @return juryoininKaishiYMD
     */
    public FlexibleDate getJuryoininKaishiYMD() {
        return juryoininKaishiYMD;
    }

    /**
     * juryoininKaishiYMDのsetメソッドです。
     *
     * @param juryoininKaishiYMD juryoininKaishiYMD
     */
    public void setJuryoininKaishiYMD(FlexibleDate juryoininKaishiYMD) {
        this.juryoininKaishiYMD = juryoininKaishiYMD;
    }

    /**
     * juryoininShuryoYMDのgetメソッドです。
     *
     * @return juryoininShuryoYMD
     */
    public FlexibleDate getJuryoininShuryoYMD() {
        return juryoininShuryoYMD;
    }

    /**
     * juryoininShuryoYMDのsetメソッドです。
     *
     * @param juryoininShuryoYMD juryoininShuryoYMD
     */
    public void setJuryoininShuryoYMD(FlexibleDate juryoininShuryoYMD) {
        this.juryoininShuryoYMD = juryoininShuryoYMD;
    }

    /**
     * keiyakuNoのgetメソッドです。
     *
     * @return keiyakuNo
     */
    public RString getKeiyakuNo() {
        return keiyakuNo;
    }

    /**
     * keiyakuNoのsetメソッドです。
     *
     * @param keiyakuNo keiyakuNo
     */
    public void setKeiyakuNo(RString keiyakuNo) {
        this.keiyakuNo = keiyakuNo;
    }

    /**
     * fuShoninRiyuのgetメソッドです。
     *
     * @return fuShoninRiyu
     */
    public RString getFuShoninRiyu() {
        return fuShoninRiyu;
    }

    /**
     * fuShoninRiyuのsetメソッドです。
     *
     * @param fuShoninRiyu fuShoninRiyu
     */
    public void setFuShoninRiyu(RString fuShoninRiyu) {
        this.fuShoninRiyu = fuShoninRiyu;
    }

    /**
     * hiyoGakuGokeiのgetメソッドです。
     *
     * @return hiyoGakuGokei
     */
    public Decimal getHiyoGakuGokei() {
        return hiyoGakuGokei;
    }

    /**
     * hiyoGakuGokeiのsetメソッドです。
     *
     * @param hiyoGakuGokei hiyoGakuGokei
     */
    public void setHiyoGakuGokei(Decimal hiyoGakuGokei) {
        this.hiyoGakuGokei = hiyoGakuGokei;
    }

    /**
     * hokenTaishoHiyoGakuのgetメソッドです。
     *
     * @return hokenTaishoHiyoGaku
     */
    public Decimal getHokenTaishoHiyoGaku() {
        return hokenTaishoHiyoGaku;
    }

    /**
     * hokenTaishoHiyoGakuのsetメソッドです。
     *
     * @param hokenTaishoHiyoGaku hokenTaishoHiyoGaku
     */
    public void setHokenTaishoHiyoGaku(Decimal hokenTaishoHiyoGaku) {
        this.hokenTaishoHiyoGaku = hokenTaishoHiyoGaku;
    }

    /**
     * riyoshaJikoFutanGakuのgetメソッドです。
     *
     * @return riyoshaJikoFutanGaku
     */
    public Decimal getRiyoshaJikoFutanGaku() {
        return riyoshaJikoFutanGaku;
    }

    /**
     * riyoshaJikoFutanGakuのsetメソッドです。
     *
     * @param riyoshaJikoFutanGaku riyoshaJikoFutanGaku
     */
    public void setRiyoshaJikoFutanGaku(Decimal riyoshaJikoFutanGaku) {
        this.riyoshaJikoFutanGaku = riyoshaJikoFutanGaku;
    }

    /**
     * hokenKyufuhiGakuのgetメソッドです。
     *
     * @return hokenKyufuhiGaku
     */
    public Decimal getHokenKyufuhiGaku() {
        return hokenKyufuhiGaku;
    }

    /**
     * hokenKyufuhiGakuのsetメソッドです。
     *
     * @param hokenKyufuhiGaku hokenKyufuhiGaku
     */
    public void setHokenKyufuhiGaku(Decimal hokenKyufuhiGaku) {
        this.hokenKyufuhiGaku = hokenKyufuhiGaku;
    }

    /**
     * shoninKekkaTsuchiSakuseiYMDのgetメソッドです。
     *
     * @return shoninKekkaTsuchiSakuseiYMD
     */
    public FlexibleDate getShoninKekkaTsuchiSakuseiYMD() {
        return shoninKekkaTsuchiSakuseiYMD;
    }

    /**
     * shoninKekkaTsuchiSakuseiYMDのsetメソッドです。
     *
     * @param shoninKekkaTsuchiSakuseiYMD shoninKekkaTsuchiSakuseiYMD
     */
    public void setShoninKekkaTsuchiSakuseiYMD(FlexibleDate shoninKekkaTsuchiSakuseiYMD) {
        this.shoninKekkaTsuchiSakuseiYMD = shoninKekkaTsuchiSakuseiYMD;
    }

    /**
     * shoninKekkaTsuchiSaiHakkoKubunのgetメソッドです。
     *
     * @return shoninKekkaTsuchiSaiHakkoKubun
     */
    public RString getShoninKekkaTsuchiSaiHakkoKubun() {
        return shoninKekkaTsuchiSaiHakkoKubun;
    }

    /**
     * shoninKekkaTsuchiSaiHakkoKubunのsetメソッドです。
     *
     * @param shoninKekkaTsuchiSaiHakkoKubun shoninKekkaTsuchiSaiHakkoKubun
     */
    public void setShoninKekkaTsuchiSaiHakkoKubun(RString shoninKekkaTsuchiSaiHakkoKubun) {
        this.shoninKekkaTsuchiSaiHakkoKubun = shoninKekkaTsuchiSaiHakkoKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV3078ShokanJuryoininKeiyakushaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbV3078ShokanJuryoininKeiyakushaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV3078ShokanJuryoininKeiyakushaEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV3078ShokanJuryoininKeiyakushaEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.rirekiNo = entity.rirekiNo;
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
        return super.toMd5(hihokenshaNo, shoKisaiHokenshaNo, uketsukeYMD, rirekiNo, shinseiYMD, jigyoshaKeiyakuNo, keiyakuServiceShurui, ketteiYMD, shoninKekkaKubun, juryoininKaishiYMD, juryoininShuryoYMD, keiyakuNo, fuShoninRiyu, hiyoGakuGokei, hokenTaishoHiyoGaku, riyoshaJikoFutanGaku, hokenKyufuhiGaku, shoninKekkaTsuchiSakuseiYMD, shoninKekkaTsuchiSaiHakkoKubun);
    }

// </editor-fold>
}
