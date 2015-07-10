package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoの項目定義クラスです
 *
 */
public class DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity extends DbTableEntityBase<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo");

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
    private JigyoshaNo jigyoshaNo;
    @PrimaryKey
    private RString yoshikiNo;
    @PrimaryKey
    private RString junjiNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private ServiceShuruiCode serviceShuruiCode;
    private ServiceKomokuCode serviceKomokuCode;
    private int hiyoTanka;
    private int futanGendogaku;
    private int nissu;
    private int hiyogaku;
    private int hokenbunSeikyugaku;
    private int riyoshaFutangaku;
    private int hiyogakuTotal;
    private int hokenbunSeikyugakuTotal;
    private int riyoshaFutangakuTotal;
    private RString shikyuKubunCode;
    private int tensuKingaku;
    private int shikyuKingaku;
    private int zougenten;
    private int sagakuKingaku;

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
     * getYoshikiNo
     *
     * @return yoshikiNo
     */
    public RString getYoshikiNo() {
        return yoshikiNo;
    }

    /**
     * setYoshikiNo
     *
     * @param yoshikiNo yoshikiNo
     */
    public void setYoshikiNo(RString yoshikiNo) {
        this.yoshikiNo = yoshikiNo;
    }

    /**
     * getJunjiNo
     *
     * @return junjiNo
     */
    public RString getJunjiNo() {
        return junjiNo;
    }

    /**
     * setJunjiNo
     *
     * @param junjiNo junjiNo
     */
    public void setJunjiNo(RString junjiNo) {
        this.junjiNo = junjiNo;
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
     * getServiceKomokuCode
     *
     * @return serviceKomokuCode
     */
    public ServiceKomokuCode getServiceKomokuCode() {
        return serviceKomokuCode;
    }

    /**
     * setServiceKomokuCode
     *
     * @param serviceKomokuCode serviceKomokuCode
     */
    public void setServiceKomokuCode(ServiceKomokuCode serviceKomokuCode) {
        this.serviceKomokuCode = serviceKomokuCode;
    }

    /**
     * getHiyoTanka
     *
     * @return hiyoTanka
     */
    public int getHiyoTanka() {
        return hiyoTanka;
    }

    /**
     * setHiyoTanka
     *
     * @param hiyoTanka hiyoTanka
     */
    public void setHiyoTanka(int hiyoTanka) {
        this.hiyoTanka = hiyoTanka;
    }

    /**
     * getFutanGendogaku
     *
     * @return futanGendogaku
     */
    public int getFutanGendogaku() {
        return futanGendogaku;
    }

    /**
     * setFutanGendogaku
     *
     * @param futanGendogaku futanGendogaku
     */
    public void setFutanGendogaku(int futanGendogaku) {
        this.futanGendogaku = futanGendogaku;
    }

    /**
     * getNissu
     *
     * @return nissu
     */
    public int getNissu() {
        return nissu;
    }

    /**
     * setNissu
     *
     * @param nissu nissu
     */
    public void setNissu(int nissu) {
        this.nissu = nissu;
    }

    /**
     * getHiyogaku
     *
     * @return hiyogaku
     */
    public int getHiyogaku() {
        return hiyogaku;
    }

    /**
     * setHiyogaku
     *
     * @param hiyogaku hiyogaku
     */
    public void setHiyogaku(int hiyogaku) {
        this.hiyogaku = hiyogaku;
    }

    /**
     * getHokenbunSeikyugaku
     *
     * @return hokenbunSeikyugaku
     */
    public int getHokenbunSeikyugaku() {
        return hokenbunSeikyugaku;
    }

    /**
     * setHokenbunSeikyugaku
     *
     * @param hokenbunSeikyugaku hokenbunSeikyugaku
     */
    public void setHokenbunSeikyugaku(int hokenbunSeikyugaku) {
        this.hokenbunSeikyugaku = hokenbunSeikyugaku;
    }

    /**
     * getRiyoshaFutangaku
     *
     * @return riyoshaFutangaku
     */
    public int getRiyoshaFutangaku() {
        return riyoshaFutangaku;
    }

    /**
     * setRiyoshaFutangaku
     *
     * @param riyoshaFutangaku riyoshaFutangaku
     */
    public void setRiyoshaFutangaku(int riyoshaFutangaku) {
        this.riyoshaFutangaku = riyoshaFutangaku;
    }

    /**
     * getHiyogakuTotal
     *
     * @return hiyogakuTotal
     */
    public int getHiyogakuTotal() {
        return hiyogakuTotal;
    }

    /**
     * setHiyogakuTotal
     *
     * @param hiyogakuTotal hiyogakuTotal
     */
    public void setHiyogakuTotal(int hiyogakuTotal) {
        this.hiyogakuTotal = hiyogakuTotal;
    }

    /**
     * getHokenbunSeikyugakuTotal
     *
     * @return hokenbunSeikyugakuTotal
     */
    public int getHokenbunSeikyugakuTotal() {
        return hokenbunSeikyugakuTotal;
    }

    /**
     * setHokenbunSeikyugakuTotal
     *
     * @param hokenbunSeikyugakuTotal hokenbunSeikyugakuTotal
     */
    public void setHokenbunSeikyugakuTotal(int hokenbunSeikyugakuTotal) {
        this.hokenbunSeikyugakuTotal = hokenbunSeikyugakuTotal;
    }

    /**
     * getRiyoshaFutangakuTotal
     *
     * @return riyoshaFutangakuTotal
     */
    public int getRiyoshaFutangakuTotal() {
        return riyoshaFutangakuTotal;
    }

    /**
     * setRiyoshaFutangakuTotal
     *
     * @param riyoshaFutangakuTotal riyoshaFutangakuTotal
     */
    public void setRiyoshaFutangakuTotal(int riyoshaFutangakuTotal) {
        this.riyoshaFutangakuTotal = riyoshaFutangakuTotal;
    }

    /**
     * getShikyuKubunCode
     *
     * @return shikyuKubunCode
     */
    public RString getShikyuKubunCode() {
        return shikyuKubunCode;
    }

    /**
     * setShikyuKubunCode
     *
     * @param shikyuKubunCode shikyuKubunCode
     */
    public void setShikyuKubunCode(RString shikyuKubunCode) {
        this.shikyuKubunCode = shikyuKubunCode;
    }

    /**
     * getTensuKingaku
     *
     * @return tensuKingaku
     */
    public int getTensuKingaku() {
        return tensuKingaku;
    }

    /**
     * setTensuKingaku
     *
     * @param tensuKingaku tensuKingaku
     */
    public void setTensuKingaku(int tensuKingaku) {
        this.tensuKingaku = tensuKingaku;
    }

    /**
     * getShikyuKingaku
     *
     * @return shikyuKingaku
     */
    public int getShikyuKingaku() {
        return shikyuKingaku;
    }

    /**
     * setShikyuKingaku
     *
     * @param shikyuKingaku shikyuKingaku
     */
    public void setShikyuKingaku(int shikyuKingaku) {
        this.shikyuKingaku = shikyuKingaku;
    }

    /**
     * getZougenten
     *
     * @return zougenten
     */
    public int getZougenten() {
        return zougenten;
    }

    /**
     * setZougenten
     *
     * @param zougenten zougenten
     */
    public void setZougenten(int zougenten) {
        this.zougenten = zougenten;
    }

    /**
     * getSagakuKingaku
     *
     * @return sagakuKingaku
     */
    public int getSagakuKingaku() {
        return sagakuKingaku;
    }

    /**
     * setSagakuKingaku
     *
     * @param sagakuKingaku sagakuKingaku
     */
    public void setSagakuKingaku(int sagakuKingaku) {
        this.sagakuKingaku = sagakuKingaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity other) {
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
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.yoshikiNo, other.yoshikiNo)) {
            return false;
        }
        if (!Objects.equals(this.junjiNo, other.junjiNo)) {
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
    public void shallowCopy(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNo = entity.seiriNo;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yoshikiNo = entity.yoshikiNo;
        this.junjiNo = entity.junjiNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.serviceKomokuCode = entity.serviceKomokuCode;
        this.hiyoTanka = entity.hiyoTanka;
        this.futanGendogaku = entity.futanGendogaku;
        this.nissu = entity.nissu;
        this.hiyogaku = entity.hiyogaku;
        this.hokenbunSeikyugaku = entity.hokenbunSeikyugaku;
        this.riyoshaFutangaku = entity.riyoshaFutangaku;
        this.hiyogakuTotal = entity.hiyogakuTotal;
        this.hokenbunSeikyugakuTotal = entity.hokenbunSeikyugakuTotal;
        this.riyoshaFutangakuTotal = entity.riyoshaFutangakuTotal;
        this.shikyuKubunCode = entity.shikyuKubunCode;
        this.tensuKingaku = entity.tensuKingaku;
        this.shikyuKingaku = entity.shikyuKingaku;
        this.zougenten = entity.zougenten;
        this.sagakuKingaku = entity.sagakuKingaku;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, jigyoshaNo, yoshikiNo, junjiNo, shoriTimestamp, serviceShuruiCode, serviceKomokuCode, hiyoTanka, futanGendogaku, nissu, hiyogaku, hokenbunSeikyugaku, riyoshaFutangaku, hiyogakuTotal, hokenbunSeikyugakuTotal, riyoshaFutangakuTotal, shikyuKubunCode, tensuKingaku, shikyuKingaku, zougenten, sagakuKingaku);
    }

// </editor-fold>
}
