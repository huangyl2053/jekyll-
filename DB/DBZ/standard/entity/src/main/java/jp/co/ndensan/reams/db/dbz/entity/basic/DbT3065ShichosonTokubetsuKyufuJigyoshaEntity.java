package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3065ShichosonTokubetsuKyufuJigyoshaの項目定義クラスです
 *
 */
public class DbT3065ShichosonTokubetsuKyufuJigyoshaEntity extends DbTableEntityBase<DbT3065ShichosonTokubetsuKyufuJigyoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3065ShichosonTokubetsuKyufuJigyosha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private JigyoshaNo jigyoshaNo;
    @PrimaryKey
    private ServiceCode serviceCode;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private RString idoKubun;
    private FlexibleDate idoYMD;
    private RString teiseiKubun;
    private FlexibleDate teiseiYMD;
    private RString hojinShubetsu;
    private RString shinseishaNameKanji;
    private RString shinseishaNameKana;
    private YubinNo shinseishaYubinNo;
    private RString shinseishaAddressKanji;
    private RString shinseishaAddressKana;
    private RString shinseishaTelNo;
    private RString shinseishaFaxNo;
    private RString jigyoshoDaihyoshaYakushoku;
    private RString jigyoshoDaihyoshaNameKanji;
    private RString jigyoshoDaihyoshaNameKana;
    private YubinNo jigyoshoDaihyoshaYubinNo;
    private RString jigyoshoDaihyoshaAddressKanji;
    private RString jigyoshoDaihyoshaAddressKana;
    private RString jigyoshoKanrishaNameKanji;
    private RString jigyoshoKanrishaNameKana;
    private YubinNo jigyoshoKanrishaYubinNo;
    private RString jigyoshoKanrishaAddressKanji;
    private RString jigyoshoKanrishaAddressKana;
    private RString serviceJigyoshoNameKanji;
    private RString serviceJigyoshoNameKana;
    private YubinNo serviceJigyoshoYubinNo;
    private RString serviceJigyoshoAddressKanji;
    private RString serviceJigyoshoAddressKana;
    private RString serviceJigyoshoTelNo;
    private RString serviceJigyoshoFaxNo;
    private FlexibleDate serviceJigyoshoJigyoKaisiYMD;
    private FlexibleDate serviceJigyoshoJigyoKyushiYMD;
    private FlexibleDate serviceJigyoshoJigyoHaishiYMD;
    private FlexibleDate serviceJigyoshoJigyoSaikaiYMD;
    private HokenshaNo shokisaiHokenshaNo;
    private RString juryoIninKubu;
    private FlexibleDate torokuKaishiYMD;
    private FlexibleDate torokuShuryoYMD;
    private boolean seikatsuhogoShiteiFlag;
    private LasdecCode shichosonCode;
    private RString chiikiKubun;

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
     * getServiceCode
     *
     * @return serviceCode
     */
    public ServiceCode getServiceCode() {
        return serviceCode;
    }

    /**
     * setServiceCode
     *
     * @param serviceCode serviceCode
     */
    public void setServiceCode(ServiceCode serviceCode) {
        this.serviceCode = serviceCode;
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
     * getIdoKubun
     *
     * @return idoKubun
     */
    public RString getIdoKubun() {
        return idoKubun;
    }

    /**
     * setIdoKubun
     *
     * @param idoKubun idoKubun
     */
    public void setIdoKubun(RString idoKubun) {
        this.idoKubun = idoKubun;
    }

    /**
     * getIdoYMD
     *
     * @return idoYMD
     */
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * setIdoYMD
     *
     * @param idoYMD idoYMD
     */
    public void setIdoYMD(FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * getTeiseiKubun
     *
     * @return teiseiKubun
     */
    public RString getTeiseiKubun() {
        return teiseiKubun;
    }

    /**
     * setTeiseiKubun
     *
     * @param teiseiKubun teiseiKubun
     */
    public void setTeiseiKubun(RString teiseiKubun) {
        this.teiseiKubun = teiseiKubun;
    }

    /**
     * getTeiseiYMD
     *
     * @return teiseiYMD
     */
    public FlexibleDate getTeiseiYMD() {
        return teiseiYMD;
    }

    /**
     * setTeiseiYMD
     *
     * @param teiseiYMD teiseiYMD
     */
    public void setTeiseiYMD(FlexibleDate teiseiYMD) {
        this.teiseiYMD = teiseiYMD;
    }

    /**
     * getHojinShubetsu
     *
     * @return hojinShubetsu
     */
    public RString getHojinShubetsu() {
        return hojinShubetsu;
    }

    /**
     * setHojinShubetsu
     *
     * @param hojinShubetsu hojinShubetsu
     */
    public void setHojinShubetsu(RString hojinShubetsu) {
        this.hojinShubetsu = hojinShubetsu;
    }

    /**
     * getShinseishaNameKanji
     *
     * @return shinseishaNameKanji
     */
    public RString getShinseishaNameKanji() {
        return shinseishaNameKanji;
    }

    /**
     * setShinseishaNameKanji
     *
     * @param shinseishaNameKanji shinseishaNameKanji
     */
    public void setShinseishaNameKanji(RString shinseishaNameKanji) {
        this.shinseishaNameKanji = shinseishaNameKanji;
    }

    /**
     * getShinseishaNameKana
     *
     * @return shinseishaNameKana
     */
    public RString getShinseishaNameKana() {
        return shinseishaNameKana;
    }

    /**
     * setShinseishaNameKana
     *
     * @param shinseishaNameKana shinseishaNameKana
     */
    public void setShinseishaNameKana(RString shinseishaNameKana) {
        this.shinseishaNameKana = shinseishaNameKana;
    }

    /**
     * getShinseishaYubinNo
     *
     * @return shinseishaYubinNo
     */
    public YubinNo getShinseishaYubinNo() {
        return shinseishaYubinNo;
    }

    /**
     * setShinseishaYubinNo
     *
     * @param shinseishaYubinNo shinseishaYubinNo
     */
    public void setShinseishaYubinNo(YubinNo shinseishaYubinNo) {
        this.shinseishaYubinNo = shinseishaYubinNo;
    }

    /**
     * getShinseishaAddressKanji
     *
     * @return shinseishaAddressKanji
     */
    public RString getShinseishaAddressKanji() {
        return shinseishaAddressKanji;
    }

    /**
     * setShinseishaAddressKanji
     *
     * @param shinseishaAddressKanji shinseishaAddressKanji
     */
    public void setShinseishaAddressKanji(RString shinseishaAddressKanji) {
        this.shinseishaAddressKanji = shinseishaAddressKanji;
    }

    /**
     * getShinseishaAddressKana
     *
     * @return shinseishaAddressKana
     */
    public RString getShinseishaAddressKana() {
        return shinseishaAddressKana;
    }

    /**
     * setShinseishaAddressKana
     *
     * @param shinseishaAddressKana shinseishaAddressKana
     */
    public void setShinseishaAddressKana(RString shinseishaAddressKana) {
        this.shinseishaAddressKana = shinseishaAddressKana;
    }

    /**
     * getShinseishaTelNo
     *
     * @return shinseishaTelNo
     */
    public RString getShinseishaTelNo() {
        return shinseishaTelNo;
    }

    /**
     * setShinseishaTelNo
     *
     * @param shinseishaTelNo shinseishaTelNo
     */
    public void setShinseishaTelNo(RString shinseishaTelNo) {
        this.shinseishaTelNo = shinseishaTelNo;
    }

    /**
     * getShinseishaFaxNo
     *
     * @return shinseishaFaxNo
     */
    public RString getShinseishaFaxNo() {
        return shinseishaFaxNo;
    }

    /**
     * setShinseishaFaxNo
     *
     * @param shinseishaFaxNo shinseishaFaxNo
     */
    public void setShinseishaFaxNo(RString shinseishaFaxNo) {
        this.shinseishaFaxNo = shinseishaFaxNo;
    }

    /**
     * getJigyoshoDaihyoshaYakushoku
     *
     * @return jigyoshoDaihyoshaYakushoku
     */
    public RString getJigyoshoDaihyoshaYakushoku() {
        return jigyoshoDaihyoshaYakushoku;
    }

    /**
     * setJigyoshoDaihyoshaYakushoku
     *
     * @param jigyoshoDaihyoshaYakushoku jigyoshoDaihyoshaYakushoku
     */
    public void setJigyoshoDaihyoshaYakushoku(RString jigyoshoDaihyoshaYakushoku) {
        this.jigyoshoDaihyoshaYakushoku = jigyoshoDaihyoshaYakushoku;
    }

    /**
     * getJigyoshoDaihyoshaNameKanji
     *
     * @return jigyoshoDaihyoshaNameKanji
     */
    public RString getJigyoshoDaihyoshaNameKanji() {
        return jigyoshoDaihyoshaNameKanji;
    }

    /**
     * setJigyoshoDaihyoshaNameKanji
     *
     * @param jigyoshoDaihyoshaNameKanji jigyoshoDaihyoshaNameKanji
     */
    public void setJigyoshoDaihyoshaNameKanji(RString jigyoshoDaihyoshaNameKanji) {
        this.jigyoshoDaihyoshaNameKanji = jigyoshoDaihyoshaNameKanji;
    }

    /**
     * getJigyoshoDaihyoshaNameKana
     *
     * @return jigyoshoDaihyoshaNameKana
     */
    public RString getJigyoshoDaihyoshaNameKana() {
        return jigyoshoDaihyoshaNameKana;
    }

    /**
     * setJigyoshoDaihyoshaNameKana
     *
     * @param jigyoshoDaihyoshaNameKana jigyoshoDaihyoshaNameKana
     */
    public void setJigyoshoDaihyoshaNameKana(RString jigyoshoDaihyoshaNameKana) {
        this.jigyoshoDaihyoshaNameKana = jigyoshoDaihyoshaNameKana;
    }

    /**
     * getJigyoshoDaihyoshaYubinNo
     *
     * @return jigyoshoDaihyoshaYubinNo
     */
    public YubinNo getJigyoshoDaihyoshaYubinNo() {
        return jigyoshoDaihyoshaYubinNo;
    }

    /**
     * setJigyoshoDaihyoshaYubinNo
     *
     * @param jigyoshoDaihyoshaYubinNo jigyoshoDaihyoshaYubinNo
     */
    public void setJigyoshoDaihyoshaYubinNo(YubinNo jigyoshoDaihyoshaYubinNo) {
        this.jigyoshoDaihyoshaYubinNo = jigyoshoDaihyoshaYubinNo;
    }

    /**
     * getJigyoshoDaihyoshaAddressKanji
     *
     * @return jigyoshoDaihyoshaAddressKanji
     */
    public RString getJigyoshoDaihyoshaAddressKanji() {
        return jigyoshoDaihyoshaAddressKanji;
    }

    /**
     * setJigyoshoDaihyoshaAddressKanji
     *
     * @param jigyoshoDaihyoshaAddressKanji jigyoshoDaihyoshaAddressKanji
     */
    public void setJigyoshoDaihyoshaAddressKanji(RString jigyoshoDaihyoshaAddressKanji) {
        this.jigyoshoDaihyoshaAddressKanji = jigyoshoDaihyoshaAddressKanji;
    }

    /**
     * getJigyoshoDaihyoshaAddressKana
     *
     * @return jigyoshoDaihyoshaAddressKana
     */
    public RString getJigyoshoDaihyoshaAddressKana() {
        return jigyoshoDaihyoshaAddressKana;
    }

    /**
     * setJigyoshoDaihyoshaAddressKana
     *
     * @param jigyoshoDaihyoshaAddressKana jigyoshoDaihyoshaAddressKana
     */
    public void setJigyoshoDaihyoshaAddressKana(RString jigyoshoDaihyoshaAddressKana) {
        this.jigyoshoDaihyoshaAddressKana = jigyoshoDaihyoshaAddressKana;
    }

    /**
     * getJigyoshoKanrishaNameKanji
     *
     * @return jigyoshoKanrishaNameKanji
     */
    public RString getJigyoshoKanrishaNameKanji() {
        return jigyoshoKanrishaNameKanji;
    }

    /**
     * setJigyoshoKanrishaNameKanji
     *
     * @param jigyoshoKanrishaNameKanji jigyoshoKanrishaNameKanji
     */
    public void setJigyoshoKanrishaNameKanji(RString jigyoshoKanrishaNameKanji) {
        this.jigyoshoKanrishaNameKanji = jigyoshoKanrishaNameKanji;
    }

    /**
     * getJigyoshoKanrishaNameKana
     *
     * @return jigyoshoKanrishaNameKana
     */
    public RString getJigyoshoKanrishaNameKana() {
        return jigyoshoKanrishaNameKana;
    }

    /**
     * setJigyoshoKanrishaNameKana
     *
     * @param jigyoshoKanrishaNameKana jigyoshoKanrishaNameKana
     */
    public void setJigyoshoKanrishaNameKana(RString jigyoshoKanrishaNameKana) {
        this.jigyoshoKanrishaNameKana = jigyoshoKanrishaNameKana;
    }

    /**
     * getJigyoshoKanrishaYubinNo
     *
     * @return jigyoshoKanrishaYubinNo
     */
    public YubinNo getJigyoshoKanrishaYubinNo() {
        return jigyoshoKanrishaYubinNo;
    }

    /**
     * setJigyoshoKanrishaYubinNo
     *
     * @param jigyoshoKanrishaYubinNo jigyoshoKanrishaYubinNo
     */
    public void setJigyoshoKanrishaYubinNo(YubinNo jigyoshoKanrishaYubinNo) {
        this.jigyoshoKanrishaYubinNo = jigyoshoKanrishaYubinNo;
    }

    /**
     * getJigyoshoKanrishaAddressKanji
     *
     * @return jigyoshoKanrishaAddressKanji
     */
    public RString getJigyoshoKanrishaAddressKanji() {
        return jigyoshoKanrishaAddressKanji;
    }

    /**
     * setJigyoshoKanrishaAddressKanji
     *
     * @param jigyoshoKanrishaAddressKanji jigyoshoKanrishaAddressKanji
     */
    public void setJigyoshoKanrishaAddressKanji(RString jigyoshoKanrishaAddressKanji) {
        this.jigyoshoKanrishaAddressKanji = jigyoshoKanrishaAddressKanji;
    }

    /**
     * getJigyoshoKanrishaAddressKana
     *
     * @return jigyoshoKanrishaAddressKana
     */
    public RString getJigyoshoKanrishaAddressKana() {
        return jigyoshoKanrishaAddressKana;
    }

    /**
     * setJigyoshoKanrishaAddressKana
     *
     * @param jigyoshoKanrishaAddressKana jigyoshoKanrishaAddressKana
     */
    public void setJigyoshoKanrishaAddressKana(RString jigyoshoKanrishaAddressKana) {
        this.jigyoshoKanrishaAddressKana = jigyoshoKanrishaAddressKana;
    }

    /**
     * getServiceJigyoshoNameKanji
     *
     * @return serviceJigyoshoNameKanji
     */
    public RString getServiceJigyoshoNameKanji() {
        return serviceJigyoshoNameKanji;
    }

    /**
     * setServiceJigyoshoNameKanji
     *
     * @param serviceJigyoshoNameKanji serviceJigyoshoNameKanji
     */
    public void setServiceJigyoshoNameKanji(RString serviceJigyoshoNameKanji) {
        this.serviceJigyoshoNameKanji = serviceJigyoshoNameKanji;
    }

    /**
     * getServiceJigyoshoNameKana
     *
     * @return serviceJigyoshoNameKana
     */
    public RString getServiceJigyoshoNameKana() {
        return serviceJigyoshoNameKana;
    }

    /**
     * setServiceJigyoshoNameKana
     *
     * @param serviceJigyoshoNameKana serviceJigyoshoNameKana
     */
    public void setServiceJigyoshoNameKana(RString serviceJigyoshoNameKana) {
        this.serviceJigyoshoNameKana = serviceJigyoshoNameKana;
    }

    /**
     * getServiceJigyoshoYubinNo
     *
     * @return serviceJigyoshoYubinNo
     */
    public YubinNo getServiceJigyoshoYubinNo() {
        return serviceJigyoshoYubinNo;
    }

    /**
     * setServiceJigyoshoYubinNo
     *
     * @param serviceJigyoshoYubinNo serviceJigyoshoYubinNo
     */
    public void setServiceJigyoshoYubinNo(YubinNo serviceJigyoshoYubinNo) {
        this.serviceJigyoshoYubinNo = serviceJigyoshoYubinNo;
    }

    /**
     * getServiceJigyoshoAddressKanji
     *
     * @return serviceJigyoshoAddressKanji
     */
    public RString getServiceJigyoshoAddressKanji() {
        return serviceJigyoshoAddressKanji;
    }

    /**
     * setServiceJigyoshoAddressKanji
     *
     * @param serviceJigyoshoAddressKanji serviceJigyoshoAddressKanji
     */
    public void setServiceJigyoshoAddressKanji(RString serviceJigyoshoAddressKanji) {
        this.serviceJigyoshoAddressKanji = serviceJigyoshoAddressKanji;
    }

    /**
     * getServiceJigyoshoAddressKana
     *
     * @return serviceJigyoshoAddressKana
     */
    public RString getServiceJigyoshoAddressKana() {
        return serviceJigyoshoAddressKana;
    }

    /**
     * setServiceJigyoshoAddressKana
     *
     * @param serviceJigyoshoAddressKana serviceJigyoshoAddressKana
     */
    public void setServiceJigyoshoAddressKana(RString serviceJigyoshoAddressKana) {
        this.serviceJigyoshoAddressKana = serviceJigyoshoAddressKana;
    }

    /**
     * getServiceJigyoshoTelNo
     *
     * @return serviceJigyoshoTelNo
     */
    public RString getServiceJigyoshoTelNo() {
        return serviceJigyoshoTelNo;
    }

    /**
     * setServiceJigyoshoTelNo
     *
     * @param serviceJigyoshoTelNo serviceJigyoshoTelNo
     */
    public void setServiceJigyoshoTelNo(RString serviceJigyoshoTelNo) {
        this.serviceJigyoshoTelNo = serviceJigyoshoTelNo;
    }

    /**
     * getServiceJigyoshoFaxNo
     *
     * @return serviceJigyoshoFaxNo
     */
    public RString getServiceJigyoshoFaxNo() {
        return serviceJigyoshoFaxNo;
    }

    /**
     * setServiceJigyoshoFaxNo
     *
     * @param serviceJigyoshoFaxNo serviceJigyoshoFaxNo
     */
    public void setServiceJigyoshoFaxNo(RString serviceJigyoshoFaxNo) {
        this.serviceJigyoshoFaxNo = serviceJigyoshoFaxNo;
    }

    /**
     * getServiceJigyoshoJigyoKaisiYMD
     *
     * @return serviceJigyoshoJigyoKaisiYMD
     */
    public FlexibleDate getServiceJigyoshoJigyoKaisiYMD() {
        return serviceJigyoshoJigyoKaisiYMD;
    }

    /**
     * setServiceJigyoshoJigyoKaisiYMD
     *
     * @param serviceJigyoshoJigyoKaisiYMD serviceJigyoshoJigyoKaisiYMD
     */
    public void setServiceJigyoshoJigyoKaisiYMD(FlexibleDate serviceJigyoshoJigyoKaisiYMD) {
        this.serviceJigyoshoJigyoKaisiYMD = serviceJigyoshoJigyoKaisiYMD;
    }

    /**
     * getServiceJigyoshoJigyoKyushiYMD
     *
     * @return serviceJigyoshoJigyoKyushiYMD
     */
    public FlexibleDate getServiceJigyoshoJigyoKyushiYMD() {
        return serviceJigyoshoJigyoKyushiYMD;
    }

    /**
     * setServiceJigyoshoJigyoKyushiYMD
     *
     * @param serviceJigyoshoJigyoKyushiYMD serviceJigyoshoJigyoKyushiYMD
     */
    public void setServiceJigyoshoJigyoKyushiYMD(FlexibleDate serviceJigyoshoJigyoKyushiYMD) {
        this.serviceJigyoshoJigyoKyushiYMD = serviceJigyoshoJigyoKyushiYMD;
    }

    /**
     * getServiceJigyoshoJigyoHaishiYMD
     *
     * @return serviceJigyoshoJigyoHaishiYMD
     */
    public FlexibleDate getServiceJigyoshoJigyoHaishiYMD() {
        return serviceJigyoshoJigyoHaishiYMD;
    }

    /**
     * setServiceJigyoshoJigyoHaishiYMD
     *
     * @param serviceJigyoshoJigyoHaishiYMD serviceJigyoshoJigyoHaishiYMD
     */
    public void setServiceJigyoshoJigyoHaishiYMD(FlexibleDate serviceJigyoshoJigyoHaishiYMD) {
        this.serviceJigyoshoJigyoHaishiYMD = serviceJigyoshoJigyoHaishiYMD;
    }

    /**
     * getServiceJigyoshoJigyoSaikaiYMD
     *
     * @return serviceJigyoshoJigyoSaikaiYMD
     */
    public FlexibleDate getServiceJigyoshoJigyoSaikaiYMD() {
        return serviceJigyoshoJigyoSaikaiYMD;
    }

    /**
     * setServiceJigyoshoJigyoSaikaiYMD
     *
     * @param serviceJigyoshoJigyoSaikaiYMD serviceJigyoshoJigyoSaikaiYMD
     */
    public void setServiceJigyoshoJigyoSaikaiYMD(FlexibleDate serviceJigyoshoJigyoSaikaiYMD) {
        this.serviceJigyoshoJigyoSaikaiYMD = serviceJigyoshoJigyoSaikaiYMD;
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
     * getJuryoIninKubu
     *
     * @return juryoIninKubu
     */
    public RString getJuryoIninKubu() {
        return juryoIninKubu;
    }

    /**
     * setJuryoIninKubu
     *
     * @param juryoIninKubu juryoIninKubu
     */
    public void setJuryoIninKubu(RString juryoIninKubu) {
        this.juryoIninKubu = juryoIninKubu;
    }

    /**
     * getTorokuKaishiYMD
     *
     * @return torokuKaishiYMD
     */
    public FlexibleDate getTorokuKaishiYMD() {
        return torokuKaishiYMD;
    }

    /**
     * setTorokuKaishiYMD
     *
     * @param torokuKaishiYMD torokuKaishiYMD
     */
    public void setTorokuKaishiYMD(FlexibleDate torokuKaishiYMD) {
        this.torokuKaishiYMD = torokuKaishiYMD;
    }

    /**
     * getTorokuShuryoYMD
     *
     * @return torokuShuryoYMD
     */
    public FlexibleDate getTorokuShuryoYMD() {
        return torokuShuryoYMD;
    }

    /**
     * setTorokuShuryoYMD
     *
     * @param torokuShuryoYMD torokuShuryoYMD
     */
    public void setTorokuShuryoYMD(FlexibleDate torokuShuryoYMD) {
        this.torokuShuryoYMD = torokuShuryoYMD;
    }

    /**
     * getSeikatsuhogoShiteiFlag
     *
     * @return seikatsuhogoShiteiFlag
     */
    public boolean getSeikatsuhogoShiteiFlag() {
        return seikatsuhogoShiteiFlag;
    }

    /**
     * setSeikatsuhogoShiteiFlag
     *
     * @param seikatsuhogoShiteiFlag seikatsuhogoShiteiFlag
     */
    public void setSeikatsuhogoShiteiFlag(boolean seikatsuhogoShiteiFlag) {
        this.seikatsuhogoShiteiFlag = seikatsuhogoShiteiFlag;
    }

    /**
     * getShichosonCode
     *
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     *
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * getChiikiKubun
     *
     * @return chiikiKubun
     */
    public RString getChiikiKubun() {
        return chiikiKubun;
    }

    /**
     * setChiikiKubun
     *
     * @param chiikiKubun chiikiKubun
     */
    public void setChiikiKubun(RString chiikiKubun) {
        this.chiikiKubun = chiikiKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3065ShichosonTokubetsuKyufuJigyoshaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3065ShichosonTokubetsuKyufuJigyoshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceCode, other.serviceCode)) {
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
    public void shallowCopy(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity) {
        this.jigyoshaNo = entity.jigyoshaNo;
        this.serviceCode = entity.serviceCode;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.idoKubun = entity.idoKubun;
        this.idoYMD = entity.idoYMD;
        this.teiseiKubun = entity.teiseiKubun;
        this.teiseiYMD = entity.teiseiYMD;
        this.hojinShubetsu = entity.hojinShubetsu;
        this.shinseishaNameKanji = entity.shinseishaNameKanji;
        this.shinseishaNameKana = entity.shinseishaNameKana;
        this.shinseishaYubinNo = entity.shinseishaYubinNo;
        this.shinseishaAddressKanji = entity.shinseishaAddressKanji;
        this.shinseishaAddressKana = entity.shinseishaAddressKana;
        this.shinseishaTelNo = entity.shinseishaTelNo;
        this.shinseishaFaxNo = entity.shinseishaFaxNo;
        this.jigyoshoDaihyoshaYakushoku = entity.jigyoshoDaihyoshaYakushoku;
        this.jigyoshoDaihyoshaNameKanji = entity.jigyoshoDaihyoshaNameKanji;
        this.jigyoshoDaihyoshaNameKana = entity.jigyoshoDaihyoshaNameKana;
        this.jigyoshoDaihyoshaYubinNo = entity.jigyoshoDaihyoshaYubinNo;
        this.jigyoshoDaihyoshaAddressKanji = entity.jigyoshoDaihyoshaAddressKanji;
        this.jigyoshoDaihyoshaAddressKana = entity.jigyoshoDaihyoshaAddressKana;
        this.jigyoshoKanrishaNameKanji = entity.jigyoshoKanrishaNameKanji;
        this.jigyoshoKanrishaNameKana = entity.jigyoshoKanrishaNameKana;
        this.jigyoshoKanrishaYubinNo = entity.jigyoshoKanrishaYubinNo;
        this.jigyoshoKanrishaAddressKanji = entity.jigyoshoKanrishaAddressKanji;
        this.jigyoshoKanrishaAddressKana = entity.jigyoshoKanrishaAddressKana;
        this.serviceJigyoshoNameKanji = entity.serviceJigyoshoNameKanji;
        this.serviceJigyoshoNameKana = entity.serviceJigyoshoNameKana;
        this.serviceJigyoshoYubinNo = entity.serviceJigyoshoYubinNo;
        this.serviceJigyoshoAddressKanji = entity.serviceJigyoshoAddressKanji;
        this.serviceJigyoshoAddressKana = entity.serviceJigyoshoAddressKana;
        this.serviceJigyoshoTelNo = entity.serviceJigyoshoTelNo;
        this.serviceJigyoshoFaxNo = entity.serviceJigyoshoFaxNo;
        this.serviceJigyoshoJigyoKaisiYMD = entity.serviceJigyoshoJigyoKaisiYMD;
        this.serviceJigyoshoJigyoKyushiYMD = entity.serviceJigyoshoJigyoKyushiYMD;
        this.serviceJigyoshoJigyoHaishiYMD = entity.serviceJigyoshoJigyoHaishiYMD;
        this.serviceJigyoshoJigyoSaikaiYMD = entity.serviceJigyoshoJigyoSaikaiYMD;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.juryoIninKubu = entity.juryoIninKubu;
        this.torokuKaishiYMD = entity.torokuKaishiYMD;
        this.torokuShuryoYMD = entity.torokuShuryoYMD;
        this.seikatsuhogoShiteiFlag = entity.seikatsuhogoShiteiFlag;
        this.shichosonCode = entity.shichosonCode;
        this.chiikiKubun = entity.chiikiKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(jigyoshaNo, serviceCode, shoriTimestamp, idoKubun, idoYMD, teiseiKubun, teiseiYMD, hojinShubetsu, shinseishaNameKanji, shinseishaNameKana, shinseishaYubinNo, shinseishaAddressKanji, shinseishaAddressKana, shinseishaTelNo, shinseishaFaxNo, jigyoshoDaihyoshaYakushoku, jigyoshoDaihyoshaNameKanji, jigyoshoDaihyoshaNameKana, jigyoshoDaihyoshaYubinNo, jigyoshoDaihyoshaAddressKanji, jigyoshoDaihyoshaAddressKana, jigyoshoKanrishaNameKanji, jigyoshoKanrishaNameKana, jigyoshoKanrishaYubinNo, jigyoshoKanrishaAddressKanji, jigyoshoKanrishaAddressKana, serviceJigyoshoNameKanji, serviceJigyoshoNameKana, serviceJigyoshoYubinNo, serviceJigyoshoAddressKanji, serviceJigyoshoAddressKana, serviceJigyoshoTelNo, serviceJigyoshoFaxNo, serviceJigyoshoJigyoKaisiYMD, serviceJigyoshoJigyoKyushiYMD, serviceJigyoshoJigyoHaishiYMD, serviceJigyoshoJigyoSaikaiYMD, shokisaiHokenshaNo, juryoIninKubu, torokuKaishiYMD, torokuShuryoYMD, seikatsuhogoShiteiFlag, shichosonCode, chiikiKubun);
    }

// </editor-fold>
}
