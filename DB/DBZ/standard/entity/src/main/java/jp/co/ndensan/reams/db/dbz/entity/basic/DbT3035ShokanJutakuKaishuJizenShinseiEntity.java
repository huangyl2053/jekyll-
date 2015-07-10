package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3035ShokanJutakuKaishuJizenShinseiの項目定義クラスです
 *
 */
public class DbT3035ShokanJutakuKaishuJizenShinseiEntity extends DbTableEntityBase<DbT3035ShokanJutakuKaishuJizenShinseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3035ShokanJutakuKaishuJizenShinsei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private RString seiriNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private HokenshaNo shoKisaiHokenshaNo;
    private FlexibleDate uketsukeYMD;
    private FlexibleDate shinseiYMD;
    private JigyoshaNo jigyoshaNo;
    private RString jigyoshaNameKanji;
    private RString jigyoshaNameKana;
    private YubinNo jigyoshaYubunNo;
    private RString jigyoshaAddress;
    private RString jigyoshaTelNo;
    private RString jigyoshaFaxNo;
    private RString riyushoSakuseishaKanji;
    private RString riyushoSakuseishaKana;
    private ServiceShuruiCode serviceShuruiCode;
    private FlexibleDate keiyakuKetteiYMD;
    private RString shoninKubun;
    private RString fushoninRiyu;
    private int kyufugakuHiyogakuTotal;
    private int kyufugakuHokenTaishoHiyogaku;
    private int kyufugakuRiyoshaJikofutangaku;
    private int kyufugakuHokenkyufuhigaku;
    private FlexibleDate sekoKanryoYoteiYMD;
    private RString shinseiTorikeshiJiyuCode;
    private RString biko;

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
     * getHiHokenshaNo
     *
     * @return hiHokenshaNo
     */
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * setHiHokenshaNo
     *
     * @param hiHokenshaNo hiHokenshaNo
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * getServiceTeikyoYM
     *
     * @return serviceTeikyoYM
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * setServiceTeikyoYM
     *
     * @param serviceTeikyoYM serviceTeikyoYM
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * getSeiriNo
     *
     * @return seiriNo
     */
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * setSeiriNo
     *
     * @param seiriNo seiriNo
     */
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
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
     * getJigyoshaNameKanji
     *
     * @return jigyoshaNameKanji
     */
    public RString getJigyoshaNameKanji() {
        return jigyoshaNameKanji;
    }

    /**
     * setJigyoshaNameKanji
     *
     * @param jigyoshaNameKanji jigyoshaNameKanji
     */
    public void setJigyoshaNameKanji(RString jigyoshaNameKanji) {
        this.jigyoshaNameKanji = jigyoshaNameKanji;
    }

    /**
     * getJigyoshaNameKana
     *
     * @return jigyoshaNameKana
     */
    public RString getJigyoshaNameKana() {
        return jigyoshaNameKana;
    }

    /**
     * setJigyoshaNameKana
     *
     * @param jigyoshaNameKana jigyoshaNameKana
     */
    public void setJigyoshaNameKana(RString jigyoshaNameKana) {
        this.jigyoshaNameKana = jigyoshaNameKana;
    }

    /**
     * getJigyoshaYubunNo
     *
     * @return jigyoshaYubunNo
     */
    public YubinNo getJigyoshaYubunNo() {
        return jigyoshaYubunNo;
    }

    /**
     * setJigyoshaYubunNo
     *
     * @param jigyoshaYubunNo jigyoshaYubunNo
     */
    public void setJigyoshaYubunNo(YubinNo jigyoshaYubunNo) {
        this.jigyoshaYubunNo = jigyoshaYubunNo;
    }

    /**
     * getJigyoshaAddress
     *
     * @return jigyoshaAddress
     */
    public RString getJigyoshaAddress() {
        return jigyoshaAddress;
    }

    /**
     * setJigyoshaAddress
     *
     * @param jigyoshaAddress jigyoshaAddress
     */
    public void setJigyoshaAddress(RString jigyoshaAddress) {
        this.jigyoshaAddress = jigyoshaAddress;
    }

    /**
     * getJigyoshaTelNo
     *
     * @return jigyoshaTelNo
     */
    public RString getJigyoshaTelNo() {
        return jigyoshaTelNo;
    }

    /**
     * setJigyoshaTelNo
     *
     * @param jigyoshaTelNo jigyoshaTelNo
     */
    public void setJigyoshaTelNo(RString jigyoshaTelNo) {
        this.jigyoshaTelNo = jigyoshaTelNo;
    }

    /**
     * getJigyoshaFaxNo
     *
     * @return jigyoshaFaxNo
     */
    public RString getJigyoshaFaxNo() {
        return jigyoshaFaxNo;
    }

    /**
     * setJigyoshaFaxNo
     *
     * @param jigyoshaFaxNo jigyoshaFaxNo
     */
    public void setJigyoshaFaxNo(RString jigyoshaFaxNo) {
        this.jigyoshaFaxNo = jigyoshaFaxNo;
    }

    /**
     * getRiyushoSakuseishaKanji
     *
     * @return riyushoSakuseishaKanji
     */
    public RString getRiyushoSakuseishaKanji() {
        return riyushoSakuseishaKanji;
    }

    /**
     * setRiyushoSakuseishaKanji
     *
     * @param riyushoSakuseishaKanji riyushoSakuseishaKanji
     */
    public void setRiyushoSakuseishaKanji(RString riyushoSakuseishaKanji) {
        this.riyushoSakuseishaKanji = riyushoSakuseishaKanji;
    }

    /**
     * getRiyushoSakuseishaKana
     *
     * @return riyushoSakuseishaKana
     */
    public RString getRiyushoSakuseishaKana() {
        return riyushoSakuseishaKana;
    }

    /**
     * setRiyushoSakuseishaKana
     *
     * @param riyushoSakuseishaKana riyushoSakuseishaKana
     */
    public void setRiyushoSakuseishaKana(RString riyushoSakuseishaKana) {
        this.riyushoSakuseishaKana = riyushoSakuseishaKana;
    }

    /**
     * getServiceShuruiCode
     *
     * @return serviceShuruiCode
     */
    public ServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * setServiceShuruiCode
     *
     * @param serviceShuruiCode serviceShuruiCode
     */
    public void setServiceShuruiCode(ServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * getKeiyakuKetteiYMD
     *
     * @return keiyakuKetteiYMD
     */
    public FlexibleDate getKeiyakuKetteiYMD() {
        return keiyakuKetteiYMD;
    }

    /**
     * setKeiyakuKetteiYMD
     *
     * @param keiyakuKetteiYMD keiyakuKetteiYMD
     */
    public void setKeiyakuKetteiYMD(FlexibleDate keiyakuKetteiYMD) {
        this.keiyakuKetteiYMD = keiyakuKetteiYMD;
    }

    /**
     * getShoninKubun
     *
     * @return shoninKubun
     */
    public RString getShoninKubun() {
        return shoninKubun;
    }

    /**
     * setShoninKubun
     *
     * @param shoninKubun shoninKubun
     */
    public void setShoninKubun(RString shoninKubun) {
        this.shoninKubun = shoninKubun;
    }

    /**
     * getFushoninRiyu
     *
     * @return fushoninRiyu
     */
    public RString getFushoninRiyu() {
        return fushoninRiyu;
    }

    /**
     * setFushoninRiyu
     *
     * @param fushoninRiyu fushoninRiyu
     */
    public void setFushoninRiyu(RString fushoninRiyu) {
        this.fushoninRiyu = fushoninRiyu;
    }

    /**
     * getKyufugakuHiyogakuTotal
     *
     * @return kyufugakuHiyogakuTotal
     */
    public int getKyufugakuHiyogakuTotal() {
        return kyufugakuHiyogakuTotal;
    }

    /**
     * setKyufugakuHiyogakuTotal
     *
     * @param kyufugakuHiyogakuTotal kyufugakuHiyogakuTotal
     */
    public void setKyufugakuHiyogakuTotal(int kyufugakuHiyogakuTotal) {
        this.kyufugakuHiyogakuTotal = kyufugakuHiyogakuTotal;
    }

    /**
     * getKyufugakuHokenTaishoHiyogaku
     *
     * @return kyufugakuHokenTaishoHiyogaku
     */
    public int getKyufugakuHokenTaishoHiyogaku() {
        return kyufugakuHokenTaishoHiyogaku;
    }

    /**
     * setKyufugakuHokenTaishoHiyogaku
     *
     * @param kyufugakuHokenTaishoHiyogaku kyufugakuHokenTaishoHiyogaku
     */
    public void setKyufugakuHokenTaishoHiyogaku(int kyufugakuHokenTaishoHiyogaku) {
        this.kyufugakuHokenTaishoHiyogaku = kyufugakuHokenTaishoHiyogaku;
    }

    /**
     * getKyufugakuRiyoshaJikofutangaku
     *
     * @return kyufugakuRiyoshaJikofutangaku
     */
    public int getKyufugakuRiyoshaJikofutangaku() {
        return kyufugakuRiyoshaJikofutangaku;
    }

    /**
     * setKyufugakuRiyoshaJikofutangaku
     *
     * @param kyufugakuRiyoshaJikofutangaku kyufugakuRiyoshaJikofutangaku
     */
    public void setKyufugakuRiyoshaJikofutangaku(int kyufugakuRiyoshaJikofutangaku) {
        this.kyufugakuRiyoshaJikofutangaku = kyufugakuRiyoshaJikofutangaku;
    }

    /**
     * getKyufugakuHokenkyufuhigaku
     *
     * @return kyufugakuHokenkyufuhigaku
     */
    public int getKyufugakuHokenkyufuhigaku() {
        return kyufugakuHokenkyufuhigaku;
    }

    /**
     * setKyufugakuHokenkyufuhigaku
     *
     * @param kyufugakuHokenkyufuhigaku kyufugakuHokenkyufuhigaku
     */
    public void setKyufugakuHokenkyufuhigaku(int kyufugakuHokenkyufuhigaku) {
        this.kyufugakuHokenkyufuhigaku = kyufugakuHokenkyufuhigaku;
    }

    /**
     * getSekoKanryoYoteiYMD
     *
     * @return sekoKanryoYoteiYMD
     */
    public FlexibleDate getSekoKanryoYoteiYMD() {
        return sekoKanryoYoteiYMD;
    }

    /**
     * setSekoKanryoYoteiYMD
     *
     * @param sekoKanryoYoteiYMD sekoKanryoYoteiYMD
     */
    public void setSekoKanryoYoteiYMD(FlexibleDate sekoKanryoYoteiYMD) {
        this.sekoKanryoYoteiYMD = sekoKanryoYoteiYMD;
    }

    /**
     * getShinseiTorikeshiJiyuCode
     *
     * @return shinseiTorikeshiJiyuCode
     */
    public RString getShinseiTorikeshiJiyuCode() {
        return shinseiTorikeshiJiyuCode;
    }

    /**
     * setShinseiTorikeshiJiyuCode
     *
     * @param shinseiTorikeshiJiyuCode shinseiTorikeshiJiyuCode
     */
    public void setShinseiTorikeshiJiyuCode(RString shinseiTorikeshiJiyuCode) {
        this.shinseiTorikeshiJiyuCode = shinseiTorikeshiJiyuCode;
    }

    /**
     * getBiko
     *
     * @return biko
     */
    public RString getBiko() {
        return biko;
    }

    /**
     * setBiko
     *
     * @param biko biko
     */
    public void setBiko(RString biko) {
        this.biko = biko;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3035ShokanJutakuKaishuJizenShinseiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3035ShokanJutakuKaishuJizenShinseiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3035ShokanJutakuKaishuJizenShinseiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.seiriNo, other.seiriNo)) {
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
    public void shallowCopy(DbT3035ShokanJutakuKaishuJizenShinseiEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNo = entity.seiriNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.shinseiYMD = entity.shinseiYMD;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.jigyoshaNameKanji = entity.jigyoshaNameKanji;
        this.jigyoshaNameKana = entity.jigyoshaNameKana;
        this.jigyoshaYubunNo = entity.jigyoshaYubunNo;
        this.jigyoshaAddress = entity.jigyoshaAddress;
        this.jigyoshaTelNo = entity.jigyoshaTelNo;
        this.jigyoshaFaxNo = entity.jigyoshaFaxNo;
        this.riyushoSakuseishaKanji = entity.riyushoSakuseishaKanji;
        this.riyushoSakuseishaKana = entity.riyushoSakuseishaKana;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.keiyakuKetteiYMD = entity.keiyakuKetteiYMD;
        this.shoninKubun = entity.shoninKubun;
        this.fushoninRiyu = entity.fushoninRiyu;
        this.kyufugakuHiyogakuTotal = entity.kyufugakuHiyogakuTotal;
        this.kyufugakuHokenTaishoHiyogaku = entity.kyufugakuHokenTaishoHiyogaku;
        this.kyufugakuRiyoshaJikofutangaku = entity.kyufugakuRiyoshaJikofutangaku;
        this.kyufugakuHokenkyufuhigaku = entity.kyufugakuHokenkyufuhigaku;
        this.sekoKanryoYoteiYMD = entity.sekoKanryoYoteiYMD;
        this.shinseiTorikeshiJiyuCode = entity.shinseiTorikeshiJiyuCode;
        this.biko = entity.biko;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, shoriTimestamp, shoKisaiHokenshaNo, uketsukeYMD, shinseiYMD, jigyoshaNo, jigyoshaNameKanji, jigyoshaNameKana, jigyoshaYubunNo, jigyoshaAddress, jigyoshaTelNo, jigyoshaFaxNo, riyushoSakuseishaKanji, riyushoSakuseishaKana, serviceShuruiCode, keiyakuKetteiYMD, shoninKubun, fushoninRiyu, kyufugakuHiyogakuTotal, kyufugakuHokenTaishoHiyogaku, kyufugakuRiyoshaJikofutangaku, kyufugakuHokenkyufuhigaku, sekoKanryoYoteiYMD, shinseiTorikeshiJiyuCode, biko);
    }

// </editor-fold>
}
