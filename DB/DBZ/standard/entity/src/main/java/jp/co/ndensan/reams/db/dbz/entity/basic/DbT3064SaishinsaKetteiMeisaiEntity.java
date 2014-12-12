package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3064SaishinsaKetteiMeisaiの項目定義クラスです
 *
 */
public class DbT3064SaishinsaKetteiMeisaiEntity extends DbTableEntityBase<DbT3064SaishinsaKetteiMeisaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3064SaishinsaKetteiMeisai");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYearMonth toriatsukaiYM;
    @PrimaryKey
    private RString hokenshaKubun;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private JigyoshaNo jigyoshoNo;
    private RString jigyoshoName;
    private HihokenshaNo hiHokenshaNo;
    private RString kohiJukyushaNo;
    private HokenshaNo shokisaiHokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private ServiceShuruiCode serviceShuruiCode;
    private RString serviceShuruiName;
    private RString moushitateJiyuCode;
    private RString moushitateJiyu;
    private RString saishinsaResultCode;
    private Decimal toshoSeikyuTanisu;
    private Decimal genshinSeikyuTanisu;
    private Decimal moushitateTanisu;
    private Decimal ketteiTanisu;
    private Decimal choseiTanisu;
    private Decimal hokenshaFutangaku;
    private FlexibleYearMonth torikomiYM;

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
     * getToriatsukaiYM
     *
     * @return toriatsukaiYM
     */
    public FlexibleYearMonth getToriatsukaiYM() {
        return toriatsukaiYM;
    }

    /**
     * setToriatsukaiYM
     *
     * @param toriatsukaiYM toriatsukaiYM
     */
    public void setToriatsukaiYM(FlexibleYearMonth toriatsukaiYM) {
        this.toriatsukaiYM = toriatsukaiYM;
    }

    /**
     * getHokenshaKubun
     *
     * @return hokenshaKubun
     */
    public RString getHokenshaKubun() {
        return hokenshaKubun;
    }

    /**
     * setHokenshaKubun
     *
     * @param hokenshaKubun hokenshaKubun
     */
    public void setHokenshaKubun(RString hokenshaKubun) {
        this.hokenshaKubun = hokenshaKubun;
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
     * getJigyoshoNo
     *
     * @return jigyoshoNo
     */
    public JigyoshaNo getJigyoshoNo() {
        return jigyoshoNo;
    }

    /**
     * setJigyoshoNo
     *
     * @param jigyoshoNo jigyoshoNo
     */
    public void setJigyoshoNo(JigyoshaNo jigyoshoNo) {
        this.jigyoshoNo = jigyoshoNo;
    }

    /**
     * getJigyoshoName
     *
     * @return jigyoshoName
     */
    public RString getJigyoshoName() {
        return jigyoshoName;
    }

    /**
     * setJigyoshoName
     *
     * @param jigyoshoName jigyoshoName
     */
    public void setJigyoshoName(RString jigyoshoName) {
        this.jigyoshoName = jigyoshoName;
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
     * getKohiJukyushaNo
     *
     * @return kohiJukyushaNo
     */
    public RString getKohiJukyushaNo() {
        return kohiJukyushaNo;
    }

    /**
     * setKohiJukyushaNo
     *
     * @param kohiJukyushaNo kohiJukyushaNo
     */
    public void setKohiJukyushaNo(RString kohiJukyushaNo) {
        this.kohiJukyushaNo = kohiJukyushaNo;
    }

    /**
     * getShokisaiHokenshaNo
     *
     * @return shokisaiHokenshaNo
     */
    public HokenshaNo getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    /**
     * setShokisaiHokenshaNo
     *
     * @param shokisaiHokenshaNo shokisaiHokenshaNo
     */
    public void setShokisaiHokenshaNo(HokenshaNo shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
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
     * getServiceShuruiName
     *
     * @return serviceShuruiName
     */
    public RString getServiceShuruiName() {
        return serviceShuruiName;
    }

    /**
     * setServiceShuruiName
     *
     * @param serviceShuruiName serviceShuruiName
     */
    public void setServiceShuruiName(RString serviceShuruiName) {
        this.serviceShuruiName = serviceShuruiName;
    }

    /**
     * getMoushitateJiyuCode
     *
     * @return moushitateJiyuCode
     */
    public RString getMoushitateJiyuCode() {
        return moushitateJiyuCode;
    }

    /**
     * setMoushitateJiyuCode
     *
     * @param moushitateJiyuCode moushitateJiyuCode
     */
    public void setMoushitateJiyuCode(RString moushitateJiyuCode) {
        this.moushitateJiyuCode = moushitateJiyuCode;
    }

    /**
     * getMoushitateJiyu
     *
     * @return moushitateJiyu
     */
    public RString getMoushitateJiyu() {
        return moushitateJiyu;
    }

    /**
     * setMoushitateJiyu
     *
     * @param moushitateJiyu moushitateJiyu
     */
    public void setMoushitateJiyu(RString moushitateJiyu) {
        this.moushitateJiyu = moushitateJiyu;
    }

    /**
     * getSaishinsaResultCode
     *
     * @return saishinsaResultCode
     */
    public RString getSaishinsaResultCode() {
        return saishinsaResultCode;
    }

    /**
     * setSaishinsaResultCode
     *
     * @param saishinsaResultCode saishinsaResultCode
     */
    public void setSaishinsaResultCode(RString saishinsaResultCode) {
        this.saishinsaResultCode = saishinsaResultCode;
    }

    /**
     * getToshoSeikyuTanisu
     *
     * @return toshoSeikyuTanisu
     */
    public Decimal getToshoSeikyuTanisu() {
        return toshoSeikyuTanisu;
    }

    /**
     * setToshoSeikyuTanisu
     *
     * @param toshoSeikyuTanisu toshoSeikyuTanisu
     */
    public void setToshoSeikyuTanisu(Decimal toshoSeikyuTanisu) {
        this.toshoSeikyuTanisu = toshoSeikyuTanisu;
    }

    /**
     * getGenshinSeikyuTanisu
     *
     * @return genshinSeikyuTanisu
     */
    public Decimal getGenshinSeikyuTanisu() {
        return genshinSeikyuTanisu;
    }

    /**
     * setGenshinSeikyuTanisu
     *
     * @param genshinSeikyuTanisu genshinSeikyuTanisu
     */
    public void setGenshinSeikyuTanisu(Decimal genshinSeikyuTanisu) {
        this.genshinSeikyuTanisu = genshinSeikyuTanisu;
    }

    /**
     * getMoushitateTanisu
     *
     * @return moushitateTanisu
     */
    public Decimal getMoushitateTanisu() {
        return moushitateTanisu;
    }

    /**
     * setMoushitateTanisu
     *
     * @param moushitateTanisu moushitateTanisu
     */
    public void setMoushitateTanisu(Decimal moushitateTanisu) {
        this.moushitateTanisu = moushitateTanisu;
    }

    /**
     * getKetteiTanisu
     *
     * @return ketteiTanisu
     */
    public Decimal getKetteiTanisu() {
        return ketteiTanisu;
    }

    /**
     * setKetteiTanisu
     *
     * @param ketteiTanisu ketteiTanisu
     */
    public void setKetteiTanisu(Decimal ketteiTanisu) {
        this.ketteiTanisu = ketteiTanisu;
    }

    /**
     * getChoseiTanisu
     *
     * @return choseiTanisu
     */
    public Decimal getChoseiTanisu() {
        return choseiTanisu;
    }

    /**
     * setChoseiTanisu
     *
     * @param choseiTanisu choseiTanisu
     */
    public void setChoseiTanisu(Decimal choseiTanisu) {
        this.choseiTanisu = choseiTanisu;
    }

    /**
     * getHokenshaFutangaku
     *
     * @return hokenshaFutangaku
     */
    public Decimal getHokenshaFutangaku() {
        return hokenshaFutangaku;
    }

    /**
     * setHokenshaFutangaku
     *
     * @param hokenshaFutangaku hokenshaFutangaku
     */
    public void setHokenshaFutangaku(Decimal hokenshaFutangaku) {
        this.hokenshaFutangaku = hokenshaFutangaku;
    }

    /**
     * getTorikomiYM
     *
     * @return torikomiYM
     */
    public FlexibleYearMonth getTorikomiYM() {
        return torikomiYM;
    }

    /**
     * setTorikomiYM
     *
     * @param torikomiYM torikomiYM
     */
    public void setTorikomiYM(FlexibleYearMonth torikomiYM) {
        this.torikomiYM = torikomiYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3064SaishinsaKetteiMeisaiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3064SaishinsaKetteiMeisaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3064SaishinsaKetteiMeisaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.toriatsukaiYM, other.toriatsukaiYM)) {
            return false;
        }
        if (!Objects.equals(this.hokenshaKubun, other.hokenshaKubun)) {
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
    public void shallowCopy(DbT3064SaishinsaKetteiMeisaiEntity entity) {
        this.toriatsukaiYM = entity.toriatsukaiYM;
        this.hokenshaKubun = entity.hokenshaKubun;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.jigyoshoName = entity.jigyoshoName;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.kohiJukyushaNo = entity.kohiJukyushaNo;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.serviceShuruiName = entity.serviceShuruiName;
        this.moushitateJiyuCode = entity.moushitateJiyuCode;
        this.moushitateJiyu = entity.moushitateJiyu;
        this.saishinsaResultCode = entity.saishinsaResultCode;
        this.toshoSeikyuTanisu = entity.toshoSeikyuTanisu;
        this.genshinSeikyuTanisu = entity.genshinSeikyuTanisu;
        this.moushitateTanisu = entity.moushitateTanisu;
        this.ketteiTanisu = entity.ketteiTanisu;
        this.choseiTanisu = entity.choseiTanisu;
        this.hokenshaFutangaku = entity.hokenshaFutangaku;
        this.torikomiYM = entity.torikomiYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(toriatsukaiYM, hokenshaKubun, shoriTimestamp, jigyoshoNo, jigyoshoName, hiHokenshaNo, kohiJukyushaNo, shokisaiHokenshaNo, serviceTeikyoYM, serviceShuruiCode, serviceShuruiName, moushitateJiyuCode, moushitateJiyu, saishinsaResultCode, toshoSeikyuTanisu, genshinSeikyuTanisu, moushitateTanisu, ketteiTanisu, choseiTanisu, hokenshaFutangaku, torikomiYM);
    }

// </editor-fold>
}
