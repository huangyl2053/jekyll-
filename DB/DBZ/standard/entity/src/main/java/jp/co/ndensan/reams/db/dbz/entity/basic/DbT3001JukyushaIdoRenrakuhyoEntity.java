package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3001JukyushaIdoRenrakuhyoの項目定義クラスです
 *
 */
public class DbT3001JukyushaIdoRenrakuhyoEntity extends DbTableEntityBase<DbT3001JukyushaIdoRenrakuhyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3001JukyushaIdoRenrakuhyo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleDate idoYMD;
    @PrimaryKey
    private RString idoKubunCode;
    @PrimaryKey
    private RString jukyushaIdoJiyu;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private RString hiHokenshaNameKana;
    private FlexibleDate umareYMD;
    private RString seibetsuCode;
    private FlexibleDate shikakuShutokuYMD;
    private FlexibleDate shikakuSoshitsuYMD;
    private RString rojinHokenShichosonNo;
    private RString rojinHokenJukyushaNo;
    private RString kohiFutanshaNo;
    private HokenshaNo koikiRengoHokenshaNo;
    private RString shinseiShubetsuCode;
    private RString henkoShinseichuKubunCode;
    private FlexibleDate shinseiYMD;
    private RString minashiYokaigoJotaiKubunCode;
    private RString yokaigoJotaiKubunCode;
    private FlexibleDate ninteiYukoKikankaishiYMD;
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    private RString kyotakuServiceSakuseiKubunCode;
    private JigyoshaNo kyotakuKaigoShienJigyoshoNo;
    private FlexibleDate kyotakuServiceTekiyoKaishiYMD;
    private FlexibleDate kyotakuServiceTekiyoShuryoYMD;
    private int homonTsushoServiceShikyuGendoKijungaku;
    private FlexibleDate homonTsushoServiceJogenKanriTekiyoKaishiYMD;
    private FlexibleDate homonTsushoServiceJogenKanriTekiyoShuryoYMD;
    private int tankiNyushoServiceShikyuGendoKijungaku;
    private FlexibleDate tankinyushoServiceJogenKanriTekiyoKaishiYMD;
    private FlexibleDate tankinyushoServiceJogenKanriTekiyoShuryoYMD;
    private boolean kohiFutanJogenGengakuAriFlag;
    private FlexibleDate shokanbaraikaKaishiYMD;
    private FlexibleDate shokanbaraikaShuryoYMD;
    private FlexibleDate kyufuritsuHikisageKaishiYMD;
    private FlexibleDate kyufuritsuHikisageShuryoYMD;
    private RString gemmenShinseichuKubunCode;
    private RString riyoshaFutanKubunCode;
    private HokenKyufuRitsu kyufuritsu;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private RString hyojunFutanKubunCode;
    private int futangaku;
    private FlexibleDate futangakuTekiyoKaishiYMD;
    private FlexibleDate futangakuTekiyoShuryoYMD;
    private RString tokuteiNyushoshaNinteiShinseichuKubunCode;
    private RString tokuteiNyushoshaKaigoServiceKubunCode;
    private boolean kaizeisoTokureiGengakuSochiTaishoFlag;
    private int shokuhiFutanGendogaku;
    private int kyojuhiUnitGataKoshitsuFutanGendogaku;
    private int kyojuhiUnitGataJunKoshitsuFutanGendogaku;
    private int kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku;
    private int kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku;
    private int kyujuhiTashoshitsuFutanGendogaku;
    private FlexibleDate futanGendogakuTekiyoKaishiYMD;
    private FlexibleDate futanGendogakuTekiyoShuryoYMD;
    private int keigenritsu;
    private FlexibleDate keigenritsuTekiyoKaishiYMD;
    private FlexibleDate keigenritsuTekiyoShuryoYMD;
    private boolean shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag;
    private RString kokiKoureiIryoHokenshaNo;
    private RString kokikoureiIryoHiHokenshaNo;
    private RString kokuhoHokenshaNo;
    private RString kokuhoHiHokenshaNo;
    private RString kokuhoKojinNo;
    private RString nijiyoboJigyoKubunCode;
    private FlexibleDate nijiyoboJigyoYukoKikanKaishiYMD;
    private FlexibleDate nijiyoboJigyoYukoKikanShuryoYMD;
    private boolean teiseiRenrakuhyoFlag;
    private FlexibleYearMonth sofuYM;

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
     * getIdoKubunCode
     *
     * @return idoKubunCode
     */
    public RString getIdoKubunCode() {
        return idoKubunCode;
    }

    /**
     * setIdoKubunCode
     *
     * @param idoKubunCode idoKubunCode
     */
    public void setIdoKubunCode(RString idoKubunCode) {
        this.idoKubunCode = idoKubunCode;
    }

    /**
     * getJukyushaIdoJiyu
     *
     * @return jukyushaIdoJiyu
     */
    public RString getJukyushaIdoJiyu() {
        return jukyushaIdoJiyu;
    }

    /**
     * setJukyushaIdoJiyu
     *
     * @param jukyushaIdoJiyu jukyushaIdoJiyu
     */
    public void setJukyushaIdoJiyu(RString jukyushaIdoJiyu) {
        this.jukyushaIdoJiyu = jukyushaIdoJiyu;
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
     * getHiHokenshaNameKana
     *
     * @return hiHokenshaNameKana
     */
    public RString getHiHokenshaNameKana() {
        return hiHokenshaNameKana;
    }

    /**
     * setHiHokenshaNameKana
     *
     * @param hiHokenshaNameKana hiHokenshaNameKana
     */
    public void setHiHokenshaNameKana(RString hiHokenshaNameKana) {
        this.hiHokenshaNameKana = hiHokenshaNameKana;
    }

    /**
     * getUmareYMD
     *
     * @return umareYMD
     */
    public FlexibleDate getUmareYMD() {
        return umareYMD;
    }

    /**
     * setUmareYMD
     *
     * @param umareYMD umareYMD
     */
    public void setUmareYMD(FlexibleDate umareYMD) {
        this.umareYMD = umareYMD;
    }

    /**
     * getSeibetsuCode
     *
     * @return seibetsuCode
     */
    public RString getSeibetsuCode() {
        return seibetsuCode;
    }

    /**
     * setSeibetsuCode
     *
     * @param seibetsuCode seibetsuCode
     */
    public void setSeibetsuCode(RString seibetsuCode) {
        this.seibetsuCode = seibetsuCode;
    }

    /**
     * getShikakuShutokuYMD
     *
     * @return shikakuShutokuYMD
     */
    public FlexibleDate getShikakuShutokuYMD() {
        return shikakuShutokuYMD;
    }

    /**
     * setShikakuShutokuYMD
     *
     * @param shikakuShutokuYMD shikakuShutokuYMD
     */
    public void setShikakuShutokuYMD(FlexibleDate shikakuShutokuYMD) {
        this.shikakuShutokuYMD = shikakuShutokuYMD;
    }

    /**
     * getShikakuSoshitsuYMD
     *
     * @return shikakuSoshitsuYMD
     */
    public FlexibleDate getShikakuSoshitsuYMD() {
        return shikakuSoshitsuYMD;
    }

    /**
     * setShikakuSoshitsuYMD
     *
     * @param shikakuSoshitsuYMD shikakuSoshitsuYMD
     */
    public void setShikakuSoshitsuYMD(FlexibleDate shikakuSoshitsuYMD) {
        this.shikakuSoshitsuYMD = shikakuSoshitsuYMD;
    }

    /**
     * getRojinHokenShichosonNo
     *
     * @return rojinHokenShichosonNo
     */
    public RString getRojinHokenShichosonNo() {
        return rojinHokenShichosonNo;
    }

    /**
     * setRojinHokenShichosonNo
     *
     * @param rojinHokenShichosonNo rojinHokenShichosonNo
     */
    public void setRojinHokenShichosonNo(RString rojinHokenShichosonNo) {
        this.rojinHokenShichosonNo = rojinHokenShichosonNo;
    }

    /**
     * getRojinHokenJukyushaNo
     *
     * @return rojinHokenJukyushaNo
     */
    public RString getRojinHokenJukyushaNo() {
        return rojinHokenJukyushaNo;
    }

    /**
     * setRojinHokenJukyushaNo
     *
     * @param rojinHokenJukyushaNo rojinHokenJukyushaNo
     */
    public void setRojinHokenJukyushaNo(RString rojinHokenJukyushaNo) {
        this.rojinHokenJukyushaNo = rojinHokenJukyushaNo;
    }

    /**
     * getKohiFutanshaNo
     *
     * @return kohiFutanshaNo
     */
    public RString getKohiFutanshaNo() {
        return kohiFutanshaNo;
    }

    /**
     * setKohiFutanshaNo
     *
     * @param kohiFutanshaNo kohiFutanshaNo
     */
    public void setKohiFutanshaNo(RString kohiFutanshaNo) {
        this.kohiFutanshaNo = kohiFutanshaNo;
    }

    /**
     * getKoikiRengoHokenshaNo
     *
     * @return koikiRengoHokenshaNo
     */
    public HokenshaNo getKoikiRengoHokenshaNo() {
        return koikiRengoHokenshaNo;
    }

    /**
     * setKoikiRengoHokenshaNo
     *
     * @param koikiRengoHokenshaNo koikiRengoHokenshaNo
     */
    public void setKoikiRengoHokenshaNo(HokenshaNo koikiRengoHokenshaNo) {
        this.koikiRengoHokenshaNo = koikiRengoHokenshaNo;
    }

    /**
     * getShinseiShubetsuCode
     *
     * @return shinseiShubetsuCode
     */
    public RString getShinseiShubetsuCode() {
        return shinseiShubetsuCode;
    }

    /**
     * setShinseiShubetsuCode
     *
     * @param shinseiShubetsuCode shinseiShubetsuCode
     */
    public void setShinseiShubetsuCode(RString shinseiShubetsuCode) {
        this.shinseiShubetsuCode = shinseiShubetsuCode;
    }

    /**
     * getHenkoShinseichuKubunCode
     *
     * @return henkoShinseichuKubunCode
     */
    public RString getHenkoShinseichuKubunCode() {
        return henkoShinseichuKubunCode;
    }

    /**
     * setHenkoShinseichuKubunCode
     *
     * @param henkoShinseichuKubunCode henkoShinseichuKubunCode
     */
    public void setHenkoShinseichuKubunCode(RString henkoShinseichuKubunCode) {
        this.henkoShinseichuKubunCode = henkoShinseichuKubunCode;
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
     * getMinashiYokaigoJotaiKubunCode
     *
     * @return minashiYokaigoJotaiKubunCode
     */
    public RString getMinashiYokaigoJotaiKubunCode() {
        return minashiYokaigoJotaiKubunCode;
    }

    /**
     * setMinashiYokaigoJotaiKubunCode
     *
     * @param minashiYokaigoJotaiKubunCode minashiYokaigoJotaiKubunCode
     */
    public void setMinashiYokaigoJotaiKubunCode(RString minashiYokaigoJotaiKubunCode) {
        this.minashiYokaigoJotaiKubunCode = minashiYokaigoJotaiKubunCode;
    }

    /**
     * getYokaigoJotaiKubunCode
     *
     * @return yokaigoJotaiKubunCode
     */
    public RString getYokaigoJotaiKubunCode() {
        return yokaigoJotaiKubunCode;
    }

    /**
     * setYokaigoJotaiKubunCode
     *
     * @param yokaigoJotaiKubunCode yokaigoJotaiKubunCode
     */
    public void setYokaigoJotaiKubunCode(RString yokaigoJotaiKubunCode) {
        this.yokaigoJotaiKubunCode = yokaigoJotaiKubunCode;
    }

    /**
     * getNinteiYukoKikankaishiYMD
     *
     * @return ninteiYukoKikankaishiYMD
     */
    public FlexibleDate getNinteiYukoKikankaishiYMD() {
        return ninteiYukoKikankaishiYMD;
    }

    /**
     * setNinteiYukoKikankaishiYMD
     *
     * @param ninteiYukoKikankaishiYMD ninteiYukoKikankaishiYMD
     */
    public void setNinteiYukoKikankaishiYMD(FlexibleDate ninteiYukoKikankaishiYMD) {
        this.ninteiYukoKikankaishiYMD = ninteiYukoKikankaishiYMD;
    }

    /**
     * getNinteiYukoKikanShuryoYMD
     *
     * @return ninteiYukoKikanShuryoYMD
     */
    public FlexibleDate getNinteiYukoKikanShuryoYMD() {
        return ninteiYukoKikanShuryoYMD;
    }

    /**
     * setNinteiYukoKikanShuryoYMD
     *
     * @param ninteiYukoKikanShuryoYMD ninteiYukoKikanShuryoYMD
     */
    public void setNinteiYukoKikanShuryoYMD(FlexibleDate ninteiYukoKikanShuryoYMD) {
        this.ninteiYukoKikanShuryoYMD = ninteiYukoKikanShuryoYMD;
    }

    /**
     * getKyotakuServiceSakuseiKubunCode
     *
     * @return kyotakuServiceSakuseiKubunCode
     */
    public RString getKyotakuServiceSakuseiKubunCode() {
        return kyotakuServiceSakuseiKubunCode;
    }

    /**
     * setKyotakuServiceSakuseiKubunCode
     *
     * @param kyotakuServiceSakuseiKubunCode kyotakuServiceSakuseiKubunCode
     */
    public void setKyotakuServiceSakuseiKubunCode(RString kyotakuServiceSakuseiKubunCode) {
        this.kyotakuServiceSakuseiKubunCode = kyotakuServiceSakuseiKubunCode;
    }

    /**
     * getKyotakuKaigoShienJigyoshoNo
     *
     * @return kyotakuKaigoShienJigyoshoNo
     */
    public JigyoshaNo getKyotakuKaigoShienJigyoshoNo() {
        return kyotakuKaigoShienJigyoshoNo;
    }

    /**
     * setKyotakuKaigoShienJigyoshoNo
     *
     * @param kyotakuKaigoShienJigyoshoNo kyotakuKaigoShienJigyoshoNo
     */
    public void setKyotakuKaigoShienJigyoshoNo(JigyoshaNo kyotakuKaigoShienJigyoshoNo) {
        this.kyotakuKaigoShienJigyoshoNo = kyotakuKaigoShienJigyoshoNo;
    }

    /**
     * getKyotakuServiceTekiyoKaishiYMD
     *
     * @return kyotakuServiceTekiyoKaishiYMD
     */
    public FlexibleDate getKyotakuServiceTekiyoKaishiYMD() {
        return kyotakuServiceTekiyoKaishiYMD;
    }

    /**
     * setKyotakuServiceTekiyoKaishiYMD
     *
     * @param kyotakuServiceTekiyoKaishiYMD kyotakuServiceTekiyoKaishiYMD
     */
    public void setKyotakuServiceTekiyoKaishiYMD(FlexibleDate kyotakuServiceTekiyoKaishiYMD) {
        this.kyotakuServiceTekiyoKaishiYMD = kyotakuServiceTekiyoKaishiYMD;
    }

    /**
     * getKyotakuServiceTekiyoShuryoYMD
     *
     * @return kyotakuServiceTekiyoShuryoYMD
     */
    public FlexibleDate getKyotakuServiceTekiyoShuryoYMD() {
        return kyotakuServiceTekiyoShuryoYMD;
    }

    /**
     * setKyotakuServiceTekiyoShuryoYMD
     *
     * @param kyotakuServiceTekiyoShuryoYMD kyotakuServiceTekiyoShuryoYMD
     */
    public void setKyotakuServiceTekiyoShuryoYMD(FlexibleDate kyotakuServiceTekiyoShuryoYMD) {
        this.kyotakuServiceTekiyoShuryoYMD = kyotakuServiceTekiyoShuryoYMD;
    }

    /**
     * getHomonTsushoServiceShikyuGendoKijungaku
     *
     * @return homonTsushoServiceShikyuGendoKijungaku
     */
    public int getHomonTsushoServiceShikyuGendoKijungaku() {
        return homonTsushoServiceShikyuGendoKijungaku;
    }

    /**
     * setHomonTsushoServiceShikyuGendoKijungaku
     *
     * @param homonTsushoServiceShikyuGendoKijungaku homonTsushoServiceShikyuGendoKijungaku
     */
    public void setHomonTsushoServiceShikyuGendoKijungaku(int homonTsushoServiceShikyuGendoKijungaku) {
        this.homonTsushoServiceShikyuGendoKijungaku = homonTsushoServiceShikyuGendoKijungaku;
    }

    /**
     * getHomonTsushoServiceJogenKanriTekiyoKaishiYMD
     *
     * @return homonTsushoServiceJogenKanriTekiyoKaishiYMD
     */
    public FlexibleDate getHomonTsushoServiceJogenKanriTekiyoKaishiYMD() {
        return homonTsushoServiceJogenKanriTekiyoKaishiYMD;
    }

    /**
     * setHomonTsushoServiceJogenKanriTekiyoKaishiYMD
     *
     * @param homonTsushoServiceJogenKanriTekiyoKaishiYMD homonTsushoServiceJogenKanriTekiyoKaishiYMD
     */
    public void setHomonTsushoServiceJogenKanriTekiyoKaishiYMD(FlexibleDate homonTsushoServiceJogenKanriTekiyoKaishiYMD) {
        this.homonTsushoServiceJogenKanriTekiyoKaishiYMD = homonTsushoServiceJogenKanriTekiyoKaishiYMD;
    }

    /**
     * getHomonTsushoServiceJogenKanriTekiyoShuryoYMD
     *
     * @return homonTsushoServiceJogenKanriTekiyoShuryoYMD
     */
    public FlexibleDate getHomonTsushoServiceJogenKanriTekiyoShuryoYMD() {
        return homonTsushoServiceJogenKanriTekiyoShuryoYMD;
    }

    /**
     * setHomonTsushoServiceJogenKanriTekiyoShuryoYMD
     *
     * @param homonTsushoServiceJogenKanriTekiyoShuryoYMD homonTsushoServiceJogenKanriTekiyoShuryoYMD
     */
    public void setHomonTsushoServiceJogenKanriTekiyoShuryoYMD(FlexibleDate homonTsushoServiceJogenKanriTekiyoShuryoYMD) {
        this.homonTsushoServiceJogenKanriTekiyoShuryoYMD = homonTsushoServiceJogenKanriTekiyoShuryoYMD;
    }

    /**
     * getTankiNyushoServiceShikyuGendoKijungaku
     *
     * @return tankiNyushoServiceShikyuGendoKijungaku
     */
    public int getTankiNyushoServiceShikyuGendoKijungaku() {
        return tankiNyushoServiceShikyuGendoKijungaku;
    }

    /**
     * setTankiNyushoServiceShikyuGendoKijungaku
     *
     * @param tankiNyushoServiceShikyuGendoKijungaku tankiNyushoServiceShikyuGendoKijungaku
     */
    public void setTankiNyushoServiceShikyuGendoKijungaku(int tankiNyushoServiceShikyuGendoKijungaku) {
        this.tankiNyushoServiceShikyuGendoKijungaku = tankiNyushoServiceShikyuGendoKijungaku;
    }

    /**
     * getTankinyushoServiceJogenKanriTekiyoKaishiYMD
     *
     * @return tankinyushoServiceJogenKanriTekiyoKaishiYMD
     */
    public FlexibleDate getTankinyushoServiceJogenKanriTekiyoKaishiYMD() {
        return tankinyushoServiceJogenKanriTekiyoKaishiYMD;
    }

    /**
     * setTankinyushoServiceJogenKanriTekiyoKaishiYMD
     *
     * @param tankinyushoServiceJogenKanriTekiyoKaishiYMD tankinyushoServiceJogenKanriTekiyoKaishiYMD
     */
    public void setTankinyushoServiceJogenKanriTekiyoKaishiYMD(FlexibleDate tankinyushoServiceJogenKanriTekiyoKaishiYMD) {
        this.tankinyushoServiceJogenKanriTekiyoKaishiYMD = tankinyushoServiceJogenKanriTekiyoKaishiYMD;
    }

    /**
     * getTankinyushoServiceJogenKanriTekiyoShuryoYMD
     *
     * @return tankinyushoServiceJogenKanriTekiyoShuryoYMD
     */
    public FlexibleDate getTankinyushoServiceJogenKanriTekiyoShuryoYMD() {
        return tankinyushoServiceJogenKanriTekiyoShuryoYMD;
    }

    /**
     * setTankinyushoServiceJogenKanriTekiyoShuryoYMD
     *
     * @param tankinyushoServiceJogenKanriTekiyoShuryoYMD tankinyushoServiceJogenKanriTekiyoShuryoYMD
     */
    public void setTankinyushoServiceJogenKanriTekiyoShuryoYMD(FlexibleDate tankinyushoServiceJogenKanriTekiyoShuryoYMD) {
        this.tankinyushoServiceJogenKanriTekiyoShuryoYMD = tankinyushoServiceJogenKanriTekiyoShuryoYMD;
    }

    /**
     * getKohiFutanJogenGengakuAriFlag
     *
     * @return kohiFutanJogenGengakuAriFlag
     */
    public boolean getKohiFutanJogenGengakuAriFlag() {
        return kohiFutanJogenGengakuAriFlag;
    }

    /**
     * setKohiFutanJogenGengakuAriFlag
     *
     * @param kohiFutanJogenGengakuAriFlag kohiFutanJogenGengakuAriFlag
     */
    public void setKohiFutanJogenGengakuAriFlag(boolean kohiFutanJogenGengakuAriFlag) {
        this.kohiFutanJogenGengakuAriFlag = kohiFutanJogenGengakuAriFlag;
    }

    /**
     * getShokanbaraikaKaishiYMD
     *
     * @return shokanbaraikaKaishiYMD
     */
    public FlexibleDate getShokanbaraikaKaishiYMD() {
        return shokanbaraikaKaishiYMD;
    }

    /**
     * setShokanbaraikaKaishiYMD
     *
     * @param shokanbaraikaKaishiYMD shokanbaraikaKaishiYMD
     */
    public void setShokanbaraikaKaishiYMD(FlexibleDate shokanbaraikaKaishiYMD) {
        this.shokanbaraikaKaishiYMD = shokanbaraikaKaishiYMD;
    }

    /**
     * getShokanbaraikaShuryoYMD
     *
     * @return shokanbaraikaShuryoYMD
     */
    public FlexibleDate getShokanbaraikaShuryoYMD() {
        return shokanbaraikaShuryoYMD;
    }

    /**
     * setShokanbaraikaShuryoYMD
     *
     * @param shokanbaraikaShuryoYMD shokanbaraikaShuryoYMD
     */
    public void setShokanbaraikaShuryoYMD(FlexibleDate shokanbaraikaShuryoYMD) {
        this.shokanbaraikaShuryoYMD = shokanbaraikaShuryoYMD;
    }

    /**
     * getKyufuritsuHikisageKaishiYMD
     *
     * @return kyufuritsuHikisageKaishiYMD
     */
    public FlexibleDate getKyufuritsuHikisageKaishiYMD() {
        return kyufuritsuHikisageKaishiYMD;
    }

    /**
     * setKyufuritsuHikisageKaishiYMD
     *
     * @param kyufuritsuHikisageKaishiYMD kyufuritsuHikisageKaishiYMD
     */
    public void setKyufuritsuHikisageKaishiYMD(FlexibleDate kyufuritsuHikisageKaishiYMD) {
        this.kyufuritsuHikisageKaishiYMD = kyufuritsuHikisageKaishiYMD;
    }

    /**
     * getKyufuritsuHikisageShuryoYMD
     *
     * @return kyufuritsuHikisageShuryoYMD
     */
    public FlexibleDate getKyufuritsuHikisageShuryoYMD() {
        return kyufuritsuHikisageShuryoYMD;
    }

    /**
     * setKyufuritsuHikisageShuryoYMD
     *
     * @param kyufuritsuHikisageShuryoYMD kyufuritsuHikisageShuryoYMD
     */
    public void setKyufuritsuHikisageShuryoYMD(FlexibleDate kyufuritsuHikisageShuryoYMD) {
        this.kyufuritsuHikisageShuryoYMD = kyufuritsuHikisageShuryoYMD;
    }

    /**
     * getGemmenShinseichuKubunCode
     *
     * @return gemmenShinseichuKubunCode
     */
    public RString getGemmenShinseichuKubunCode() {
        return gemmenShinseichuKubunCode;
    }

    /**
     * setGemmenShinseichuKubunCode
     *
     * @param gemmenShinseichuKubunCode gemmenShinseichuKubunCode
     */
    public void setGemmenShinseichuKubunCode(RString gemmenShinseichuKubunCode) {
        this.gemmenShinseichuKubunCode = gemmenShinseichuKubunCode;
    }

    /**
     * getRiyoshaFutanKubunCode
     *
     * @return riyoshaFutanKubunCode
     */
    public RString getRiyoshaFutanKubunCode() {
        return riyoshaFutanKubunCode;
    }

    /**
     * setRiyoshaFutanKubunCode
     *
     * @param riyoshaFutanKubunCode riyoshaFutanKubunCode
     */
    public void setRiyoshaFutanKubunCode(RString riyoshaFutanKubunCode) {
        this.riyoshaFutanKubunCode = riyoshaFutanKubunCode;
    }

    /**
     * getKyufuritsu
     *
     * @return kyufuritsu
     */
    public HokenKyufuRitsu getKyufuritsu() {
        return kyufuritsu;
    }

    /**
     * setKyufuritsu
     *
     * @param kyufuritsu kyufuritsu
     */
    public void setKyufuritsu(HokenKyufuRitsu kyufuritsu) {
        this.kyufuritsu = kyufuritsu;
    }

    /**
     * getTekiyoKaishiYMD
     *
     * @return tekiyoKaishiYMD
     */
    public FlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    /**
     * setTekiyoKaishiYMD
     *
     * @param tekiyoKaishiYMD tekiyoKaishiYMD
     */
    public void setTekiyoKaishiYMD(FlexibleDate tekiyoKaishiYMD) {
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    /**
     * getTekiyoShuryoYMD
     *
     * @return tekiyoShuryoYMD
     */
    public FlexibleDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    /**
     * setTekiyoShuryoYMD
     *
     * @param tekiyoShuryoYMD tekiyoShuryoYMD
     */
    public void setTekiyoShuryoYMD(FlexibleDate tekiyoShuryoYMD) {
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    /**
     * getHyojunFutanKubunCode
     *
     * @return hyojunFutanKubunCode
     */
    public RString getHyojunFutanKubunCode() {
        return hyojunFutanKubunCode;
    }

    /**
     * setHyojunFutanKubunCode
     *
     * @param hyojunFutanKubunCode hyojunFutanKubunCode
     */
    public void setHyojunFutanKubunCode(RString hyojunFutanKubunCode) {
        this.hyojunFutanKubunCode = hyojunFutanKubunCode;
    }

    /**
     * getFutangaku
     *
     * @return futangaku
     */
    public int getFutangaku() {
        return futangaku;
    }

    /**
     * setFutangaku
     *
     * @param futangaku futangaku
     */
    public void setFutangaku(int futangaku) {
        this.futangaku = futangaku;
    }

    /**
     * getFutangakuTekiyoKaishiYMD
     *
     * @return futangakuTekiyoKaishiYMD
     */
    public FlexibleDate getFutangakuTekiyoKaishiYMD() {
        return futangakuTekiyoKaishiYMD;
    }

    /**
     * setFutangakuTekiyoKaishiYMD
     *
     * @param futangakuTekiyoKaishiYMD futangakuTekiyoKaishiYMD
     */
    public void setFutangakuTekiyoKaishiYMD(FlexibleDate futangakuTekiyoKaishiYMD) {
        this.futangakuTekiyoKaishiYMD = futangakuTekiyoKaishiYMD;
    }

    /**
     * getFutangakuTekiyoShuryoYMD
     *
     * @return futangakuTekiyoShuryoYMD
     */
    public FlexibleDate getFutangakuTekiyoShuryoYMD() {
        return futangakuTekiyoShuryoYMD;
    }

    /**
     * setFutangakuTekiyoShuryoYMD
     *
     * @param futangakuTekiyoShuryoYMD futangakuTekiyoShuryoYMD
     */
    public void setFutangakuTekiyoShuryoYMD(FlexibleDate futangakuTekiyoShuryoYMD) {
        this.futangakuTekiyoShuryoYMD = futangakuTekiyoShuryoYMD;
    }

    /**
     * getTokuteiNyushoshaNinteiShinseichuKubunCode
     *
     * @return tokuteiNyushoshaNinteiShinseichuKubunCode
     */
    public RString getTokuteiNyushoshaNinteiShinseichuKubunCode() {
        return tokuteiNyushoshaNinteiShinseichuKubunCode;
    }

    /**
     * setTokuteiNyushoshaNinteiShinseichuKubunCode
     *
     * @param tokuteiNyushoshaNinteiShinseichuKubunCode tokuteiNyushoshaNinteiShinseichuKubunCode
     */
    public void setTokuteiNyushoshaNinteiShinseichuKubunCode(RString tokuteiNyushoshaNinteiShinseichuKubunCode) {
        this.tokuteiNyushoshaNinteiShinseichuKubunCode = tokuteiNyushoshaNinteiShinseichuKubunCode;
    }

    /**
     * getTokuteiNyushoshaKaigoServiceKubunCode
     *
     * @return tokuteiNyushoshaKaigoServiceKubunCode
     */
    public RString getTokuteiNyushoshaKaigoServiceKubunCode() {
        return tokuteiNyushoshaKaigoServiceKubunCode;
    }

    /**
     * setTokuteiNyushoshaKaigoServiceKubunCode
     *
     * @param tokuteiNyushoshaKaigoServiceKubunCode tokuteiNyushoshaKaigoServiceKubunCode
     */
    public void setTokuteiNyushoshaKaigoServiceKubunCode(RString tokuteiNyushoshaKaigoServiceKubunCode) {
        this.tokuteiNyushoshaKaigoServiceKubunCode = tokuteiNyushoshaKaigoServiceKubunCode;
    }

    /**
     * getKaizeisoTokureiGengakuSochiTaishoFlag
     *
     * @return kaizeisoTokureiGengakuSochiTaishoFlag
     */
    public boolean getKaizeisoTokureiGengakuSochiTaishoFlag() {
        return kaizeisoTokureiGengakuSochiTaishoFlag;
    }

    /**
     * setKaizeisoTokureiGengakuSochiTaishoFlag
     *
     * @param kaizeisoTokureiGengakuSochiTaishoFlag kaizeisoTokureiGengakuSochiTaishoFlag
     */
    public void setKaizeisoTokureiGengakuSochiTaishoFlag(boolean kaizeisoTokureiGengakuSochiTaishoFlag) {
        this.kaizeisoTokureiGengakuSochiTaishoFlag = kaizeisoTokureiGengakuSochiTaishoFlag;
    }

    /**
     * getShokuhiFutanGendogaku
     *
     * @return shokuhiFutanGendogaku
     */
    public int getShokuhiFutanGendogaku() {
        return shokuhiFutanGendogaku;
    }

    /**
     * setShokuhiFutanGendogaku
     *
     * @param shokuhiFutanGendogaku shokuhiFutanGendogaku
     */
    public void setShokuhiFutanGendogaku(int shokuhiFutanGendogaku) {
        this.shokuhiFutanGendogaku = shokuhiFutanGendogaku;
    }

    /**
     * getKyojuhiUnitGataKoshitsuFutanGendogaku
     *
     * @return kyojuhiUnitGataKoshitsuFutanGendogaku
     */
    public int getKyojuhiUnitGataKoshitsuFutanGendogaku() {
        return kyojuhiUnitGataKoshitsuFutanGendogaku;
    }

    /**
     * setKyojuhiUnitGataKoshitsuFutanGendogaku
     *
     * @param kyojuhiUnitGataKoshitsuFutanGendogaku kyojuhiUnitGataKoshitsuFutanGendogaku
     */
    public void setKyojuhiUnitGataKoshitsuFutanGendogaku(int kyojuhiUnitGataKoshitsuFutanGendogaku) {
        this.kyojuhiUnitGataKoshitsuFutanGendogaku = kyojuhiUnitGataKoshitsuFutanGendogaku;
    }

    /**
     * getKyojuhiUnitGataJunKoshitsuFutanGendogaku
     *
     * @return kyojuhiUnitGataJunKoshitsuFutanGendogaku
     */
    public int getKyojuhiUnitGataJunKoshitsuFutanGendogaku() {
        return kyojuhiUnitGataJunKoshitsuFutanGendogaku;
    }

    /**
     * setKyojuhiUnitGataJunKoshitsuFutanGendogaku
     *
     * @param kyojuhiUnitGataJunKoshitsuFutanGendogaku kyojuhiUnitGataJunKoshitsuFutanGendogaku
     */
    public void setKyojuhiUnitGataJunKoshitsuFutanGendogaku(int kyojuhiUnitGataJunKoshitsuFutanGendogaku) {
        this.kyojuhiUnitGataJunKoshitsuFutanGendogaku = kyojuhiUnitGataJunKoshitsuFutanGendogaku;
    }

    /**
     * getKyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku
     *
     * @return kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku
     */
    public int getKyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku() {
        return kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku;
    }

    /**
     * setKyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku
     *
     * @param kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku
     */
    public void setKyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku(int kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku) {
        this.kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku = kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku;
    }

    /**
     * getKyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku
     *
     * @return kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku
     */
    public int getKyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku() {
        return kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku;
    }

    /**
     * setKyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku
     *
     * @param kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku
     */
    public void setKyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku(int kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku) {
        this.kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku = kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku;
    }

    /**
     * getKyujuhiTashoshitsuFutanGendogaku
     *
     * @return kyujuhiTashoshitsuFutanGendogaku
     */
    public int getKyujuhiTashoshitsuFutanGendogaku() {
        return kyujuhiTashoshitsuFutanGendogaku;
    }

    /**
     * setKyujuhiTashoshitsuFutanGendogaku
     *
     * @param kyujuhiTashoshitsuFutanGendogaku kyujuhiTashoshitsuFutanGendogaku
     */
    public void setKyujuhiTashoshitsuFutanGendogaku(int kyujuhiTashoshitsuFutanGendogaku) {
        this.kyujuhiTashoshitsuFutanGendogaku = kyujuhiTashoshitsuFutanGendogaku;
    }

    /**
     * getFutanGendogakuTekiyoKaishiYMD
     *
     * @return futanGendogakuTekiyoKaishiYMD
     */
    public FlexibleDate getFutanGendogakuTekiyoKaishiYMD() {
        return futanGendogakuTekiyoKaishiYMD;
    }

    /**
     * setFutanGendogakuTekiyoKaishiYMD
     *
     * @param futanGendogakuTekiyoKaishiYMD futanGendogakuTekiyoKaishiYMD
     */
    public void setFutanGendogakuTekiyoKaishiYMD(FlexibleDate futanGendogakuTekiyoKaishiYMD) {
        this.futanGendogakuTekiyoKaishiYMD = futanGendogakuTekiyoKaishiYMD;
    }

    /**
     * getFutanGendogakuTekiyoShuryoYMD
     *
     * @return futanGendogakuTekiyoShuryoYMD
     */
    public FlexibleDate getFutanGendogakuTekiyoShuryoYMD() {
        return futanGendogakuTekiyoShuryoYMD;
    }

    /**
     * setFutanGendogakuTekiyoShuryoYMD
     *
     * @param futanGendogakuTekiyoShuryoYMD futanGendogakuTekiyoShuryoYMD
     */
    public void setFutanGendogakuTekiyoShuryoYMD(FlexibleDate futanGendogakuTekiyoShuryoYMD) {
        this.futanGendogakuTekiyoShuryoYMD = futanGendogakuTekiyoShuryoYMD;
    }

    /**
     * getKeigenritsu
     *
     * @return keigenritsu
     */
    public int getKeigenritsu() {
        return keigenritsu;
    }

    /**
     * setKeigenritsu
     *
     * @param keigenritsu keigenritsu
     */
    public void setKeigenritsu(int keigenritsu) {
        this.keigenritsu = keigenritsu;
    }

    /**
     * getKeigenritsuTekiyoKaishiYMD
     *
     * @return keigenritsuTekiyoKaishiYMD
     */
    public FlexibleDate getKeigenritsuTekiyoKaishiYMD() {
        return keigenritsuTekiyoKaishiYMD;
    }

    /**
     * setKeigenritsuTekiyoKaishiYMD
     *
     * @param keigenritsuTekiyoKaishiYMD keigenritsuTekiyoKaishiYMD
     */
    public void setKeigenritsuTekiyoKaishiYMD(FlexibleDate keigenritsuTekiyoKaishiYMD) {
        this.keigenritsuTekiyoKaishiYMD = keigenritsuTekiyoKaishiYMD;
    }

    /**
     * getKeigenritsuTekiyoShuryoYMD
     *
     * @return keigenritsuTekiyoShuryoYMD
     */
    public FlexibleDate getKeigenritsuTekiyoShuryoYMD() {
        return keigenritsuTekiyoShuryoYMD;
    }

    /**
     * setKeigenritsuTekiyoShuryoYMD
     *
     * @param keigenritsuTekiyoShuryoYMD keigenritsuTekiyoShuryoYMD
     */
    public void setKeigenritsuTekiyoShuryoYMD(FlexibleDate keigenritsuTekiyoShuryoYMD) {
        this.keigenritsuTekiyoShuryoYMD = keigenritsuTekiyoShuryoYMD;
    }

    /**
     * getShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag
     *
     * @return shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag
     */
    public boolean getShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag() {
        return shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag;
    }

    /**
     * setShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag
     *
     * @param shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag
     */
    public void setShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag(boolean shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag) {
        this.shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag = shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag;
    }

    /**
     * getKokiKoureiIryoHokenshaNo
     *
     * @return kokiKoureiIryoHokenshaNo
     */
    public RString getKokiKoureiIryoHokenshaNo() {
        return kokiKoureiIryoHokenshaNo;
    }

    /**
     * setKokiKoureiIryoHokenshaNo
     *
     * @param kokiKoureiIryoHokenshaNo kokiKoureiIryoHokenshaNo
     */
    public void setKokiKoureiIryoHokenshaNo(RString kokiKoureiIryoHokenshaNo) {
        this.kokiKoureiIryoHokenshaNo = kokiKoureiIryoHokenshaNo;
    }

    /**
     * getKokikoureiIryoHiHokenshaNo
     *
     * @return kokikoureiIryoHiHokenshaNo
     */
    public RString getKokikoureiIryoHiHokenshaNo() {
        return kokikoureiIryoHiHokenshaNo;
    }

    /**
     * setKokikoureiIryoHiHokenshaNo
     *
     * @param kokikoureiIryoHiHokenshaNo kokikoureiIryoHiHokenshaNo
     */
    public void setKokikoureiIryoHiHokenshaNo(RString kokikoureiIryoHiHokenshaNo) {
        this.kokikoureiIryoHiHokenshaNo = kokikoureiIryoHiHokenshaNo;
    }

    /**
     * getKokuhoHokenshaNo
     *
     * @return kokuhoHokenshaNo
     */
    public RString getKokuhoHokenshaNo() {
        return kokuhoHokenshaNo;
    }

    /**
     * setKokuhoHokenshaNo
     *
     * @param kokuhoHokenshaNo kokuhoHokenshaNo
     */
    public void setKokuhoHokenshaNo(RString kokuhoHokenshaNo) {
        this.kokuhoHokenshaNo = kokuhoHokenshaNo;
    }

    /**
     * getKokuhoHiHokenshaNo
     *
     * @return kokuhoHiHokenshaNo
     */
    public RString getKokuhoHiHokenshaNo() {
        return kokuhoHiHokenshaNo;
    }

    /**
     * setKokuhoHiHokenshaNo
     *
     * @param kokuhoHiHokenshaNo kokuhoHiHokenshaNo
     */
    public void setKokuhoHiHokenshaNo(RString kokuhoHiHokenshaNo) {
        this.kokuhoHiHokenshaNo = kokuhoHiHokenshaNo;
    }

    /**
     * getKokuhoKojinNo
     *
     * @return kokuhoKojinNo
     */
    public RString getKokuhoKojinNo() {
        return kokuhoKojinNo;
    }

    /**
     * setKokuhoKojinNo
     *
     * @param kokuhoKojinNo kokuhoKojinNo
     */
    public void setKokuhoKojinNo(RString kokuhoKojinNo) {
        this.kokuhoKojinNo = kokuhoKojinNo;
    }

    /**
     * getNijiyoboJigyoKubunCode
     *
     * @return nijiyoboJigyoKubunCode
     */
    public RString getNijiyoboJigyoKubunCode() {
        return nijiyoboJigyoKubunCode;
    }

    /**
     * setNijiyoboJigyoKubunCode
     *
     * @param nijiyoboJigyoKubunCode nijiyoboJigyoKubunCode
     */
    public void setNijiyoboJigyoKubunCode(RString nijiyoboJigyoKubunCode) {
        this.nijiyoboJigyoKubunCode = nijiyoboJigyoKubunCode;
    }

    /**
     * getNijiyoboJigyoYukoKikanKaishiYMD
     *
     * @return nijiyoboJigyoYukoKikanKaishiYMD
     */
    public FlexibleDate getNijiyoboJigyoYukoKikanKaishiYMD() {
        return nijiyoboJigyoYukoKikanKaishiYMD;
    }

    /**
     * setNijiyoboJigyoYukoKikanKaishiYMD
     *
     * @param nijiyoboJigyoYukoKikanKaishiYMD nijiyoboJigyoYukoKikanKaishiYMD
     */
    public void setNijiyoboJigyoYukoKikanKaishiYMD(FlexibleDate nijiyoboJigyoYukoKikanKaishiYMD) {
        this.nijiyoboJigyoYukoKikanKaishiYMD = nijiyoboJigyoYukoKikanKaishiYMD;
    }

    /**
     * getNijiyoboJigyoYukoKikanShuryoYMD
     *
     * @return nijiyoboJigyoYukoKikanShuryoYMD
     */
    public FlexibleDate getNijiyoboJigyoYukoKikanShuryoYMD() {
        return nijiyoboJigyoYukoKikanShuryoYMD;
    }

    /**
     * setNijiyoboJigyoYukoKikanShuryoYMD
     *
     * @param nijiyoboJigyoYukoKikanShuryoYMD nijiyoboJigyoYukoKikanShuryoYMD
     */
    public void setNijiyoboJigyoYukoKikanShuryoYMD(FlexibleDate nijiyoboJigyoYukoKikanShuryoYMD) {
        this.nijiyoboJigyoYukoKikanShuryoYMD = nijiyoboJigyoYukoKikanShuryoYMD;
    }

    /**
     * getTeiseiRenrakuhyoFlag
     *
     * @return teiseiRenrakuhyoFlag
     */
    public boolean getTeiseiRenrakuhyoFlag() {
        return teiseiRenrakuhyoFlag;
    }

    /**
     * setTeiseiRenrakuhyoFlag
     *
     * @param teiseiRenrakuhyoFlag teiseiRenrakuhyoFlag
     */
    public void setTeiseiRenrakuhyoFlag(boolean teiseiRenrakuhyoFlag) {
        this.teiseiRenrakuhyoFlag = teiseiRenrakuhyoFlag;
    }

    /**
     * getSofuYM
     *
     * @return sofuYM
     */
    public FlexibleYearMonth getSofuYM() {
        return sofuYM;
    }

    /**
     * setSofuYM
     *
     * @param sofuYM sofuYM
     */
    public void setSofuYM(FlexibleYearMonth sofuYM) {
        this.sofuYM = sofuYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3001JukyushaIdoRenrakuhyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3001JukyushaIdoRenrakuhyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3001JukyushaIdoRenrakuhyoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.idoYMD, other.idoYMD)) {
            return false;
        }
        if (!Objects.equals(this.idoKubunCode, other.idoKubunCode)) {
            return false;
        }
        if (!Objects.equals(this.jukyushaIdoJiyu, other.jukyushaIdoJiyu)) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
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
    public void shallowCopy(DbT3001JukyushaIdoRenrakuhyoEntity entity) {
        this.idoYMD = entity.idoYMD;
        this.idoKubunCode = entity.idoKubunCode;
        this.jukyushaIdoJiyu = entity.jukyushaIdoJiyu;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.hiHokenshaNameKana = entity.hiHokenshaNameKana;
        this.umareYMD = entity.umareYMD;
        this.seibetsuCode = entity.seibetsuCode;
        this.shikakuShutokuYMD = entity.shikakuShutokuYMD;
        this.shikakuSoshitsuYMD = entity.shikakuSoshitsuYMD;
        this.rojinHokenShichosonNo = entity.rojinHokenShichosonNo;
        this.rojinHokenJukyushaNo = entity.rojinHokenJukyushaNo;
        this.kohiFutanshaNo = entity.kohiFutanshaNo;
        this.koikiRengoHokenshaNo = entity.koikiRengoHokenshaNo;
        this.shinseiShubetsuCode = entity.shinseiShubetsuCode;
        this.henkoShinseichuKubunCode = entity.henkoShinseichuKubunCode;
        this.shinseiYMD = entity.shinseiYMD;
        this.minashiYokaigoJotaiKubunCode = entity.minashiYokaigoJotaiKubunCode;
        this.yokaigoJotaiKubunCode = entity.yokaigoJotaiKubunCode;
        this.ninteiYukoKikankaishiYMD = entity.ninteiYukoKikankaishiYMD;
        this.ninteiYukoKikanShuryoYMD = entity.ninteiYukoKikanShuryoYMD;
        this.kyotakuServiceSakuseiKubunCode = entity.kyotakuServiceSakuseiKubunCode;
        this.kyotakuKaigoShienJigyoshoNo = entity.kyotakuKaigoShienJigyoshoNo;
        this.kyotakuServiceTekiyoKaishiYMD = entity.kyotakuServiceTekiyoKaishiYMD;
        this.kyotakuServiceTekiyoShuryoYMD = entity.kyotakuServiceTekiyoShuryoYMD;
        this.homonTsushoServiceShikyuGendoKijungaku = entity.homonTsushoServiceShikyuGendoKijungaku;
        this.homonTsushoServiceJogenKanriTekiyoKaishiYMD = entity.homonTsushoServiceJogenKanriTekiyoKaishiYMD;
        this.homonTsushoServiceJogenKanriTekiyoShuryoYMD = entity.homonTsushoServiceJogenKanriTekiyoShuryoYMD;
        this.tankiNyushoServiceShikyuGendoKijungaku = entity.tankiNyushoServiceShikyuGendoKijungaku;
        this.tankinyushoServiceJogenKanriTekiyoKaishiYMD = entity.tankinyushoServiceJogenKanriTekiyoKaishiYMD;
        this.tankinyushoServiceJogenKanriTekiyoShuryoYMD = entity.tankinyushoServiceJogenKanriTekiyoShuryoYMD;
        this.kohiFutanJogenGengakuAriFlag = entity.kohiFutanJogenGengakuAriFlag;
        this.shokanbaraikaKaishiYMD = entity.shokanbaraikaKaishiYMD;
        this.shokanbaraikaShuryoYMD = entity.shokanbaraikaShuryoYMD;
        this.kyufuritsuHikisageKaishiYMD = entity.kyufuritsuHikisageKaishiYMD;
        this.kyufuritsuHikisageShuryoYMD = entity.kyufuritsuHikisageShuryoYMD;
        this.gemmenShinseichuKubunCode = entity.gemmenShinseichuKubunCode;
        this.riyoshaFutanKubunCode = entity.riyoshaFutanKubunCode;
        this.kyufuritsu = entity.kyufuritsu;
        this.tekiyoKaishiYMD = entity.tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = entity.tekiyoShuryoYMD;
        this.hyojunFutanKubunCode = entity.hyojunFutanKubunCode;
        this.futangaku = entity.futangaku;
        this.futangakuTekiyoKaishiYMD = entity.futangakuTekiyoKaishiYMD;
        this.futangakuTekiyoShuryoYMD = entity.futangakuTekiyoShuryoYMD;
        this.tokuteiNyushoshaNinteiShinseichuKubunCode = entity.tokuteiNyushoshaNinteiShinseichuKubunCode;
        this.tokuteiNyushoshaKaigoServiceKubunCode = entity.tokuteiNyushoshaKaigoServiceKubunCode;
        this.kaizeisoTokureiGengakuSochiTaishoFlag = entity.kaizeisoTokureiGengakuSochiTaishoFlag;
        this.shokuhiFutanGendogaku = entity.shokuhiFutanGendogaku;
        this.kyojuhiUnitGataKoshitsuFutanGendogaku = entity.kyojuhiUnitGataKoshitsuFutanGendogaku;
        this.kyojuhiUnitGataJunKoshitsuFutanGendogaku = entity.kyojuhiUnitGataJunKoshitsuFutanGendogaku;
        this.kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku = entity.kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku;
        this.kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku = entity.kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku;
        this.kyujuhiTashoshitsuFutanGendogaku = entity.kyujuhiTashoshitsuFutanGendogaku;
        this.futanGendogakuTekiyoKaishiYMD = entity.futanGendogakuTekiyoKaishiYMD;
        this.futanGendogakuTekiyoShuryoYMD = entity.futanGendogakuTekiyoShuryoYMD;
        this.keigenritsu = entity.keigenritsu;
        this.keigenritsuTekiyoKaishiYMD = entity.keigenritsuTekiyoKaishiYMD;
        this.keigenritsuTekiyoShuryoYMD = entity.keigenritsuTekiyoShuryoYMD;
        this.shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag = entity.shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag;
        this.kokiKoureiIryoHokenshaNo = entity.kokiKoureiIryoHokenshaNo;
        this.kokikoureiIryoHiHokenshaNo = entity.kokikoureiIryoHiHokenshaNo;
        this.kokuhoHokenshaNo = entity.kokuhoHokenshaNo;
        this.kokuhoHiHokenshaNo = entity.kokuhoHiHokenshaNo;
        this.kokuhoKojinNo = entity.kokuhoKojinNo;
        this.nijiyoboJigyoKubunCode = entity.nijiyoboJigyoKubunCode;
        this.nijiyoboJigyoYukoKikanKaishiYMD = entity.nijiyoboJigyoYukoKikanKaishiYMD;
        this.nijiyoboJigyoYukoKikanShuryoYMD = entity.nijiyoboJigyoYukoKikanShuryoYMD;
        this.teiseiRenrakuhyoFlag = entity.teiseiRenrakuhyoFlag;
        this.sofuYM = entity.sofuYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(idoYMD, idoKubunCode, jukyushaIdoJiyu, shoKisaiHokenshaNo, hiHokenshaNo, shoriTimestamp, hiHokenshaNameKana, umareYMD, seibetsuCode, shikakuShutokuYMD, shikakuSoshitsuYMD, rojinHokenShichosonNo, rojinHokenJukyushaNo, kohiFutanshaNo, koikiRengoHokenshaNo, shinseiShubetsuCode, henkoShinseichuKubunCode, shinseiYMD, minashiYokaigoJotaiKubunCode, yokaigoJotaiKubunCode, ninteiYukoKikankaishiYMD, ninteiYukoKikanShuryoYMD, kyotakuServiceSakuseiKubunCode, kyotakuKaigoShienJigyoshoNo, kyotakuServiceTekiyoKaishiYMD, kyotakuServiceTekiyoShuryoYMD, homonTsushoServiceShikyuGendoKijungaku, homonTsushoServiceJogenKanriTekiyoKaishiYMD, homonTsushoServiceJogenKanriTekiyoShuryoYMD, tankiNyushoServiceShikyuGendoKijungaku, tankinyushoServiceJogenKanriTekiyoKaishiYMD, tankinyushoServiceJogenKanriTekiyoShuryoYMD, kohiFutanJogenGengakuAriFlag, shokanbaraikaKaishiYMD, shokanbaraikaShuryoYMD, kyufuritsuHikisageKaishiYMD, kyufuritsuHikisageShuryoYMD, gemmenShinseichuKubunCode, riyoshaFutanKubunCode, kyufuritsu, tekiyoKaishiYMD, tekiyoShuryoYMD, hyojunFutanKubunCode, futangaku, futangakuTekiyoKaishiYMD, futangakuTekiyoShuryoYMD, tokuteiNyushoshaNinteiShinseichuKubunCode, tokuteiNyushoshaKaigoServiceKubunCode, kaizeisoTokureiGengakuSochiTaishoFlag, shokuhiFutanGendogaku, kyojuhiUnitGataKoshitsuFutanGendogaku, kyojuhiUnitGataJunKoshitsuFutanGendogaku, kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku, kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku, kyujuhiTashoshitsuFutanGendogaku, futanGendogakuTekiyoKaishiYMD, futanGendogakuTekiyoShuryoYMD, keigenritsu, keigenritsuTekiyoKaishiYMD, keigenritsuTekiyoShuryoYMD, shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag, kokiKoureiIryoHokenshaNo, kokikoureiIryoHiHokenshaNo, kokuhoHokenshaNo, kokuhoHiHokenshaNo, kokuhoKojinNo, nijiyoboJigyoKubunCode, nijiyoboJigyoYukoKikanKaishiYMD, nijiyoboJigyoYukoKikanShuryoYMD, teiseiRenrakuhyoFlag, sofuYM);
    }

// </editor-fold>
}
