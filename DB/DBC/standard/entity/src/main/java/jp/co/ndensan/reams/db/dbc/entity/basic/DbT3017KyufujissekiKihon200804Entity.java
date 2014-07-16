package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.InputShikibetsuNoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;

/**
 * DbT3017KyufujissekiKihon200804の項目定義クラスです
 *
 */
public class DbT3017KyufujissekiKihon200804Entity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3017KyufujissekiKihon200804");

    private RString insertDantaiCd;
    @PrimaryKey
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private KokanShikibetsuNo kokanShikibetsuNo;
    @PrimaryKey
    private InputShikibetsuNoCode inputShikibetsuNo;
    @PrimaryKey
    private RString recodeShubetsuCode;
    @PrimaryKey
    private RString kyufuSakuseiKubunCode;
    @PrimaryKey
    private ShoKisaiHokenshaNo hokenshaNo;
    @PrimaryKey
    private KaigoHihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private RString kyufuJissekiKubunCode;
    @PrimaryKey
    private JigyoshaNo jigyoshoNo;
    @PrimaryKey
    private RString toshiNo;
    private RString kohi1FutanshaNo;
    private RString kohi1JukyushaNo;
    private RString kohi2FutanshaNo;
    private RString kohi2JukyushaNo;
    private RString kohi3FutanshaNo;
    private RString kohi3JukyushaNo;
    private FlexibleDate umareYMD;
    private RString seibetsuCode;
    private RString yoKaigoJotaiKubunCode;
    private RString kyuSochiNyushoshaTokureiCode;
    private FlexibleDate ninteiYukoKaishiYMD;
    private FlexibleDate ninteiYukoShuryoYMD;
    private RString rojinHokenShichosonNo;
    private RString rojinhokenJukyushaNo;
    private RString kokiHokenshaNo;
    private RString kokiHiHokenshaNo;
    private RString kokuhoHokenshaNo;
    private RString kokuhoHiHokenshashoNo;
    private RString kokuhoKojinNo;
    private RString kyotakuServicePlanSakuseiKubunCode;
    private JigyoshaNo kyotakuKaigoShienJigyoshoNo;
    private FlexibleDate kaishiYMD;
    private FlexibleDate chushiYMD;
    private RString chushiRiyuNyushomaeJyokyoCode;
    private FlexibleDate nyushoYMD;
    private FlexibleDate taishoYMD;
    private int nyushoJitsunissu;
    private int gaihakuNissu;
    private RString taishogoJotaiCode;
    private HokenKyufuRitsu hokenKyufuritsu;
    private HokenKyufuRitsu kohi1Kyufuritsu;
    private HokenKyufuRitsu kohi2Kyufuritsu;
    private HokenKyufuRitsu kohi3Kyufuritsu;
    private int maeHokenServiceTanisu;
    private Decimal maeHokenSeikyugaku;
    private int maeHokenRiyoshaFutangaku;
    private Decimal maeHokenKinkyuShisetsuRyoyoSeikyugaku;
    private Decimal maeHokenTokuteiShinryohiSeikyugaku;
    private int maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int maeKohi1ServiceTanisu;
    private int maeKohi1Seikyugaku;
    private int maeKohi1RiyoshaFutangaku;
    private int maeKohi1KinkyuShisetsuRyoyoSeikyugaku;
    private int maeKohi1TokuteiShinryohiSeikyugaku;
    private int maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int maeKohi2ServiceTanisu;
    private int maeKohi2Seikyugaku;
    private int maeKohi2RiyoshaFutangaku;
    private int maeKohi2KinkyuShisetsuRyoyoSeikyugaku;
    private int maeKohi2TokuteiShinryohiSeikyugaku;
    private int maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int maeKohi3ServiceTanisu;
    private int maeKohi3Seikyugaku;
    private int maeKohi3RiyoshaFutangaku;
    private int maeKohi3KinkyuShisetsuRyoyoSeikyugaku;
    private int maeKohi3TokuteiShinryohiSeikyugaku;
    private int maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int atoHokenServiceTanisu;
    private Decimal atoHokenSeikyugaku;
    private int atoHokenRiyoshaFutangaku;
    private Decimal atoHokenKinkyuShisetsuRyoyoSeikyugaku;
    private Decimal atoHokenTokuteiShinryohiSeikyugaku;
    private int atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int atoKohi1ServiceTanisu;
    private int atoKohi1Seikyugaku;
    private int atoKohi1RiyoshaFutangaku;
    private int atoKohi1KinkyuShisetsuRyoyoSeikyugaku;
    private int atoKohi1TokuteiShinryohiSeikyugaku;
    private int atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int atoKohi2ServiceTanisu;
    private int atoKohi2Seikyugaku;
    private int atoKohi2RiyoshaFutangaku;
    private int atoKohi2KinkyuShisetsuRyoyoSeikyugaku;
    private int atoKohi2TokuteiShinryohiSeikyugaku;
    private int atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int atoKohi3ServiceTanisu;
    private int atoKohi3Seikyugaku;
    private int atoKohi3RiyoshaFutangaku;
    private int atoKohi3KinkyuShisetsuRyoyoSeikyugaku;
    private int atoKohi3TokuteiShinryohiSeikyugaku;
    private int atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private RString keikaiKubunCode;
    private FlexibleYearMonth shinsaYM;
    private FlexibleYearMonth sofuYM;
    private FlexibleYearMonth torikomiYM;
    private RString seiriNo;
    private RString dokujiSakuseiKubun;
    private boolean hokenshaHoyuKyufujissekiJohoSakujoFlag;

    /**
     * getInsertDantaiCd
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * setLastUpdateReamsLoginId
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getKokanShikibetsuNo
     * @return kokanShikibetsuNo
     */
    public KokanShikibetsuNo getKokanShikibetsuNo() {
        return kokanShikibetsuNo;
    }

    /**
     * setKokanShikibetsuNo
     * @param kokanShikibetsuNo kokanShikibetsuNo
     */
    public void setKokanShikibetsuNo(KokanShikibetsuNo kokanShikibetsuNo) {
        this.kokanShikibetsuNo = kokanShikibetsuNo;
    }

    /**
     * getInputShikibetsuNo
     * @return inputShikibetsuNo
     */
    public InputShikibetsuNoCode getInputShikibetsuNo() {
        return inputShikibetsuNo;
    }

    /**
     * setInputShikibetsuNo
     * @param inputShikibetsuNo inputShikibetsuNo
     */
    public void setInputShikibetsuNo(InputShikibetsuNoCode inputShikibetsuNo) {
        this.inputShikibetsuNo = inputShikibetsuNo;
    }

    /**
     * getRecodeShubetsuCode
     * @return recodeShubetsuCode
     */
    public RString getRecodeShubetsuCode() {
        return recodeShubetsuCode;
    }

    /**
     * setRecodeShubetsuCode
     * @param recodeShubetsuCode recodeShubetsuCode
     */
    public void setRecodeShubetsuCode(RString recodeShubetsuCode) {
        this.recodeShubetsuCode = recodeShubetsuCode;
    }

    /**
     * getKyufuSakuseiKubunCode
     * @return kyufuSakuseiKubunCode
     */
    public RString getKyufuSakuseiKubunCode() {
        return kyufuSakuseiKubunCode;
    }

    /**
     * setKyufuSakuseiKubunCode
     * @param kyufuSakuseiKubunCode kyufuSakuseiKubunCode
     */
    public void setKyufuSakuseiKubunCode(RString kyufuSakuseiKubunCode) {
        this.kyufuSakuseiKubunCode = kyufuSakuseiKubunCode;
    }

    /**
     * getHokenshaNo
     * @return hokenshaNo
     */
    public ShoKisaiHokenshaNo getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * setHokenshaNo
     * @param hokenshaNo hokenshaNo
     */
    public void setHokenshaNo(ShoKisaiHokenshaNo hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
    }

    /**
     * getHiHokenshaNo
     * @return hiHokenshaNo
     */
    public KaigoHihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * setHiHokenshaNo
     * @param hiHokenshaNo hiHokenshaNo
     */
    public void setHiHokenshaNo(KaigoHihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * getServiceTeikyoYM
     * @return serviceTeikyoYM
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * setServiceTeikyoYM
     * @param serviceTeikyoYM serviceTeikyoYM
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * getKyufuJissekiKubunCode
     * @return kyufuJissekiKubunCode
     */
    public RString getKyufuJissekiKubunCode() {
        return kyufuJissekiKubunCode;
    }

    /**
     * setKyufuJissekiKubunCode
     * @param kyufuJissekiKubunCode kyufuJissekiKubunCode
     */
    public void setKyufuJissekiKubunCode(RString kyufuJissekiKubunCode) {
        this.kyufuJissekiKubunCode = kyufuJissekiKubunCode;
    }

    /**
     * getJigyoshoNo
     * @return jigyoshoNo
     */
    public JigyoshaNo getJigyoshoNo() {
        return jigyoshoNo;
    }

    /**
     * setJigyoshoNo
     * @param jigyoshoNo jigyoshoNo
     */
    public void setJigyoshoNo(JigyoshaNo jigyoshoNo) {
        this.jigyoshoNo = jigyoshoNo;
    }

    /**
     * getToshiNo
     * @return toshiNo
     */
    public RString getToshiNo() {
        return toshiNo;
    }

    /**
     * setToshiNo
     * @param toshiNo toshiNo
     */
    public void setToshiNo(RString toshiNo) {
        this.toshiNo = toshiNo;
    }

    /**
     * getKohi1FutanshaNo
     * @return kohi1FutanshaNo
     */
    public RString getKohi1FutanshaNo() {
        return kohi1FutanshaNo;
    }

    /**
     * setKohi1FutanshaNo
     * @param kohi1FutanshaNo kohi1FutanshaNo
     */
    public void setKohi1FutanshaNo(RString kohi1FutanshaNo) {
        this.kohi1FutanshaNo = kohi1FutanshaNo;
    }

    /**
     * getKohi1JukyushaNo
     * @return kohi1JukyushaNo
     */
    public RString getKohi1JukyushaNo() {
        return kohi1JukyushaNo;
    }

    /**
     * setKohi1JukyushaNo
     * @param kohi1JukyushaNo kohi1JukyushaNo
     */
    public void setKohi1JukyushaNo(RString kohi1JukyushaNo) {
        this.kohi1JukyushaNo = kohi1JukyushaNo;
    }

    /**
     * getKohi2FutanshaNo
     * @return kohi2FutanshaNo
     */
    public RString getKohi2FutanshaNo() {
        return kohi2FutanshaNo;
    }

    /**
     * setKohi2FutanshaNo
     * @param kohi2FutanshaNo kohi2FutanshaNo
     */
    public void setKohi2FutanshaNo(RString kohi2FutanshaNo) {
        this.kohi2FutanshaNo = kohi2FutanshaNo;
    }

    /**
     * getKohi2JukyushaNo
     * @return kohi2JukyushaNo
     */
    public RString getKohi2JukyushaNo() {
        return kohi2JukyushaNo;
    }

    /**
     * setKohi2JukyushaNo
     * @param kohi2JukyushaNo kohi2JukyushaNo
     */
    public void setKohi2JukyushaNo(RString kohi2JukyushaNo) {
        this.kohi2JukyushaNo = kohi2JukyushaNo;
    }

    /**
     * getKohi3FutanshaNo
     * @return kohi3FutanshaNo
     */
    public RString getKohi3FutanshaNo() {
        return kohi3FutanshaNo;
    }

    /**
     * setKohi3FutanshaNo
     * @param kohi3FutanshaNo kohi3FutanshaNo
     */
    public void setKohi3FutanshaNo(RString kohi3FutanshaNo) {
        this.kohi3FutanshaNo = kohi3FutanshaNo;
    }

    /**
     * getKohi3JukyushaNo
     * @return kohi3JukyushaNo
     */
    public RString getKohi3JukyushaNo() {
        return kohi3JukyushaNo;
    }

    /**
     * setKohi3JukyushaNo
     * @param kohi3JukyushaNo kohi3JukyushaNo
     */
    public void setKohi3JukyushaNo(RString kohi3JukyushaNo) {
        this.kohi3JukyushaNo = kohi3JukyushaNo;
    }

    /**
     * getUmareYMD
     * @return umareYMD
     */
    public FlexibleDate getUmareYMD() {
        return umareYMD;
    }

    /**
     * setUmareYMD
     * @param umareYMD umareYMD
     */
    public void setUmareYMD(FlexibleDate umareYMD) {
        this.umareYMD = umareYMD;
    }

    /**
     * getSeibetsuCode
     * @return seibetsuCode
     */
    public RString getSeibetsuCode() {
        return seibetsuCode;
    }

    /**
     * setSeibetsuCode
     * @param seibetsuCode seibetsuCode
     */
    public void setSeibetsuCode(RString seibetsuCode) {
        this.seibetsuCode = seibetsuCode;
    }

    /**
     * getYoKaigoJotaiKubunCode
     * @return yoKaigoJotaiKubunCode
     */
    public RString getYoKaigoJotaiKubunCode() {
        return yoKaigoJotaiKubunCode;
    }

    /**
     * setYoKaigoJotaiKubunCode
     * @param yoKaigoJotaiKubunCode yoKaigoJotaiKubunCode
     */
    public void setYoKaigoJotaiKubunCode(RString yoKaigoJotaiKubunCode) {
        this.yoKaigoJotaiKubunCode = yoKaigoJotaiKubunCode;
    }

    /**
     * getKyuSochiNyushoshaTokureiCode
     * @return kyuSochiNyushoshaTokureiCode
     */
    public RString getKyuSochiNyushoshaTokureiCode() {
        return kyuSochiNyushoshaTokureiCode;
    }

    /**
     * setKyuSochiNyushoshaTokureiCode
     * @param kyuSochiNyushoshaTokureiCode kyuSochiNyushoshaTokureiCode
     */
    public void setKyuSochiNyushoshaTokureiCode(RString kyuSochiNyushoshaTokureiCode) {
        this.kyuSochiNyushoshaTokureiCode = kyuSochiNyushoshaTokureiCode;
    }

    /**
     * getNinteiYukoKaishiYMD
     * @return ninteiYukoKaishiYMD
     */
    public FlexibleDate getNinteiYukoKaishiYMD() {
        return ninteiYukoKaishiYMD;
    }

    /**
     * setNinteiYukoKaishiYMD
     * @param ninteiYukoKaishiYMD ninteiYukoKaishiYMD
     */
    public void setNinteiYukoKaishiYMD(FlexibleDate ninteiYukoKaishiYMD) {
        this.ninteiYukoKaishiYMD = ninteiYukoKaishiYMD;
    }

    /**
     * getNinteiYukoShuryoYMD
     * @return ninteiYukoShuryoYMD
     */
    public FlexibleDate getNinteiYukoShuryoYMD() {
        return ninteiYukoShuryoYMD;
    }

    /**
     * setNinteiYukoShuryoYMD
     * @param ninteiYukoShuryoYMD ninteiYukoShuryoYMD
     */
    public void setNinteiYukoShuryoYMD(FlexibleDate ninteiYukoShuryoYMD) {
        this.ninteiYukoShuryoYMD = ninteiYukoShuryoYMD;
    }

    /**
     * getRojinHokenShichosonNo
     * @return rojinHokenShichosonNo
     */
    public RString getRojinHokenShichosonNo() {
        return rojinHokenShichosonNo;
    }

    /**
     * setRojinHokenShichosonNo
     * @param rojinHokenShichosonNo rojinHokenShichosonNo
     */
    public void setRojinHokenShichosonNo(RString rojinHokenShichosonNo) {
        this.rojinHokenShichosonNo = rojinHokenShichosonNo;
    }

    /**
     * getRojinhokenJukyushaNo
     * @return rojinhokenJukyushaNo
     */
    public RString getRojinhokenJukyushaNo() {
        return rojinhokenJukyushaNo;
    }

    /**
     * setRojinhokenJukyushaNo
     * @param rojinhokenJukyushaNo rojinhokenJukyushaNo
     */
    public void setRojinhokenJukyushaNo(RString rojinhokenJukyushaNo) {
        this.rojinhokenJukyushaNo = rojinhokenJukyushaNo;
    }

    /**
     * getKokiHokenshaNo
     * @return kokiHokenshaNo
     */
    public RString getKokiHokenshaNo() {
        return kokiHokenshaNo;
    }

    /**
     * setKokiHokenshaNo
     * @param kokiHokenshaNo kokiHokenshaNo
     */
    public void setKokiHokenshaNo(RString kokiHokenshaNo) {
        this.kokiHokenshaNo = kokiHokenshaNo;
    }

    /**
     * getKokiHiHokenshaNo
     * @return kokiHiHokenshaNo
     */
    public RString getKokiHiHokenshaNo() {
        return kokiHiHokenshaNo;
    }

    /**
     * setKokiHiHokenshaNo
     * @param kokiHiHokenshaNo kokiHiHokenshaNo
     */
    public void setKokiHiHokenshaNo(RString kokiHiHokenshaNo) {
        this.kokiHiHokenshaNo = kokiHiHokenshaNo;
    }

    /**
     * getKokuhoHokenshaNo
     * @return kokuhoHokenshaNo
     */
    public RString getKokuhoHokenshaNo() {
        return kokuhoHokenshaNo;
    }

    /**
     * setKokuhoHokenshaNo
     * @param kokuhoHokenshaNo kokuhoHokenshaNo
     */
    public void setKokuhoHokenshaNo(RString kokuhoHokenshaNo) {
        this.kokuhoHokenshaNo = kokuhoHokenshaNo;
    }

    /**
     * getKokuhoHiHokenshashoNo
     * @return kokuhoHiHokenshashoNo
     */
    public RString getKokuhoHiHokenshashoNo() {
        return kokuhoHiHokenshashoNo;
    }

    /**
     * setKokuhoHiHokenshashoNo
     * @param kokuhoHiHokenshashoNo kokuhoHiHokenshashoNo
     */
    public void setKokuhoHiHokenshashoNo(RString kokuhoHiHokenshashoNo) {
        this.kokuhoHiHokenshashoNo = kokuhoHiHokenshashoNo;
    }

    /**
     * getKokuhoKojinNo
     * @return kokuhoKojinNo
     */
    public RString getKokuhoKojinNo() {
        return kokuhoKojinNo;
    }

    /**
     * setKokuhoKojinNo
     * @param kokuhoKojinNo kokuhoKojinNo
     */
    public void setKokuhoKojinNo(RString kokuhoKojinNo) {
        this.kokuhoKojinNo = kokuhoKojinNo;
    }

    /**
     * getKyotakuServicePlanSakuseiKubunCode
     * @return kyotakuServicePlanSakuseiKubunCode
     */
    public RString getKyotakuServicePlanSakuseiKubunCode() {
        return kyotakuServicePlanSakuseiKubunCode;
    }

    /**
     * setKyotakuServicePlanSakuseiKubunCode
     * @param kyotakuServicePlanSakuseiKubunCode kyotakuServicePlanSakuseiKubunCode
     */
    public void setKyotakuServicePlanSakuseiKubunCode(RString kyotakuServicePlanSakuseiKubunCode) {
        this.kyotakuServicePlanSakuseiKubunCode = kyotakuServicePlanSakuseiKubunCode;
    }

    /**
     * getKyotakuKaigoShienJigyoshoNo
     * @return kyotakuKaigoShienJigyoshoNo
     */
    public JigyoshaNo getKyotakuKaigoShienJigyoshoNo() {
        return kyotakuKaigoShienJigyoshoNo;
    }

    /**
     * setKyotakuKaigoShienJigyoshoNo
     * @param kyotakuKaigoShienJigyoshoNo kyotakuKaigoShienJigyoshoNo
     */
    public void setKyotakuKaigoShienJigyoshoNo(JigyoshaNo kyotakuKaigoShienJigyoshoNo) {
        this.kyotakuKaigoShienJigyoshoNo = kyotakuKaigoShienJigyoshoNo;
    }

    /**
     * getKaishiYMD
     * @return kaishiYMD
     */
    public FlexibleDate getKaishiYMD() {
        return kaishiYMD;
    }

    /**
     * setKaishiYMD
     * @param kaishiYMD kaishiYMD
     */
    public void setKaishiYMD(FlexibleDate kaishiYMD) {
        this.kaishiYMD = kaishiYMD;
    }

    /**
     * getChushiYMD
     * @return chushiYMD
     */
    public FlexibleDate getChushiYMD() {
        return chushiYMD;
    }

    /**
     * setChushiYMD
     * @param chushiYMD chushiYMD
     */
    public void setChushiYMD(FlexibleDate chushiYMD) {
        this.chushiYMD = chushiYMD;
    }

    /**
     * getChushiRiyuNyushomaeJyokyoCode
     * @return chushiRiyuNyushomaeJyokyoCode
     */
    public RString getChushiRiyuNyushomaeJyokyoCode() {
        return chushiRiyuNyushomaeJyokyoCode;
    }

    /**
     * setChushiRiyuNyushomaeJyokyoCode
     * @param chushiRiyuNyushomaeJyokyoCode chushiRiyuNyushomaeJyokyoCode
     */
    public void setChushiRiyuNyushomaeJyokyoCode(RString chushiRiyuNyushomaeJyokyoCode) {
        this.chushiRiyuNyushomaeJyokyoCode = chushiRiyuNyushomaeJyokyoCode;
    }

    /**
     * getNyushoYMD
     * @return nyushoYMD
     */
    public FlexibleDate getNyushoYMD() {
        return nyushoYMD;
    }

    /**
     * setNyushoYMD
     * @param nyushoYMD nyushoYMD
     */
    public void setNyushoYMD(FlexibleDate nyushoYMD) {
        this.nyushoYMD = nyushoYMD;
    }

    /**
     * getTaishoYMD
     * @return taishoYMD
     */
    public FlexibleDate getTaishoYMD() {
        return taishoYMD;
    }

    /**
     * setTaishoYMD
     * @param taishoYMD taishoYMD
     */
    public void setTaishoYMD(FlexibleDate taishoYMD) {
        this.taishoYMD = taishoYMD;
    }

    /**
     * getNyushoJitsunissu
     * @return nyushoJitsunissu
     */
    public int getNyushoJitsunissu() {
        return nyushoJitsunissu;
    }

    /**
     * setNyushoJitsunissu
     * @param nyushoJitsunissu nyushoJitsunissu
     */
    public void setNyushoJitsunissu(int nyushoJitsunissu) {
        this.nyushoJitsunissu = nyushoJitsunissu;
    }

    /**
     * getGaihakuNissu
     * @return gaihakuNissu
     */
    public int getGaihakuNissu() {
        return gaihakuNissu;
    }

    /**
     * setGaihakuNissu
     * @param gaihakuNissu gaihakuNissu
     */
    public void setGaihakuNissu(int gaihakuNissu) {
        this.gaihakuNissu = gaihakuNissu;
    }

    /**
     * getTaishogoJotaiCode
     * @return taishogoJotaiCode
     */
    public RString getTaishogoJotaiCode() {
        return taishogoJotaiCode;
    }

    /**
     * setTaishogoJotaiCode
     * @param taishogoJotaiCode taishogoJotaiCode
     */
    public void setTaishogoJotaiCode(RString taishogoJotaiCode) {
        this.taishogoJotaiCode = taishogoJotaiCode;
    }

    /**
     * getHokenKyufuritsu
     * @return hokenKyufuritsu
     */
    public HokenKyufuRitsu getHokenKyufuritsu() {
        return hokenKyufuritsu;
    }

    /**
     * setHokenKyufuritsu
     * @param hokenKyufuritsu hokenKyufuritsu
     */
    public void setHokenKyufuritsu(HokenKyufuRitsu hokenKyufuritsu) {
        this.hokenKyufuritsu = hokenKyufuritsu;
    }

    /**
     * getKohi1Kyufuritsu
     * @return kohi1Kyufuritsu
     */
    public HokenKyufuRitsu getKohi1Kyufuritsu() {
        return kohi1Kyufuritsu;
    }

    /**
     * setKohi1Kyufuritsu
     * @param kohi1Kyufuritsu kohi1Kyufuritsu
     */
    public void setKohi1Kyufuritsu(HokenKyufuRitsu kohi1Kyufuritsu) {
        this.kohi1Kyufuritsu = kohi1Kyufuritsu;
    }

    /**
     * getKohi2Kyufuritsu
     * @return kohi2Kyufuritsu
     */
    public HokenKyufuRitsu getKohi2Kyufuritsu() {
        return kohi2Kyufuritsu;
    }

    /**
     * setKohi2Kyufuritsu
     * @param kohi2Kyufuritsu kohi2Kyufuritsu
     */
    public void setKohi2Kyufuritsu(HokenKyufuRitsu kohi2Kyufuritsu) {
        this.kohi2Kyufuritsu = kohi2Kyufuritsu;
    }

    /**
     * getKohi3Kyufuritsu
     * @return kohi3Kyufuritsu
     */
    public HokenKyufuRitsu getKohi3Kyufuritsu() {
        return kohi3Kyufuritsu;
    }

    /**
     * setKohi3Kyufuritsu
     * @param kohi3Kyufuritsu kohi3Kyufuritsu
     */
    public void setKohi3Kyufuritsu(HokenKyufuRitsu kohi3Kyufuritsu) {
        this.kohi3Kyufuritsu = kohi3Kyufuritsu;
    }

    /**
     * getMaeHokenServiceTanisu
     * @return maeHokenServiceTanisu
     */
    public int getMaeHokenServiceTanisu() {
        return maeHokenServiceTanisu;
    }

    /**
     * setMaeHokenServiceTanisu
     * @param maeHokenServiceTanisu maeHokenServiceTanisu
     */
    public void setMaeHokenServiceTanisu(int maeHokenServiceTanisu) {
        this.maeHokenServiceTanisu = maeHokenServiceTanisu;
    }

    /**
     * getMaeHokenSeikyugaku
     * @return maeHokenSeikyugaku
     */
    public Decimal getMaeHokenSeikyugaku() {
        return maeHokenSeikyugaku;
    }

    /**
     * setMaeHokenSeikyugaku
     * @param maeHokenSeikyugaku maeHokenSeikyugaku
     */
    public void setMaeHokenSeikyugaku(Decimal maeHokenSeikyugaku) {
        this.maeHokenSeikyugaku = maeHokenSeikyugaku;
    }

    /**
     * getMaeHokenRiyoshaFutangaku
     * @return maeHokenRiyoshaFutangaku
     */
    public int getMaeHokenRiyoshaFutangaku() {
        return maeHokenRiyoshaFutangaku;
    }

    /**
     * setMaeHokenRiyoshaFutangaku
     * @param maeHokenRiyoshaFutangaku maeHokenRiyoshaFutangaku
     */
    public void setMaeHokenRiyoshaFutangaku(int maeHokenRiyoshaFutangaku) {
        this.maeHokenRiyoshaFutangaku = maeHokenRiyoshaFutangaku;
    }

    /**
     * getMaeHokenKinkyuShisetsuRyoyoSeikyugaku
     * @return maeHokenKinkyuShisetsuRyoyoSeikyugaku
     */
    public Decimal getMaeHokenKinkyuShisetsuRyoyoSeikyugaku() {
        return maeHokenKinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * setMaeHokenKinkyuShisetsuRyoyoSeikyugaku
     * @param maeHokenKinkyuShisetsuRyoyoSeikyugaku maeHokenKinkyuShisetsuRyoyoSeikyugaku
     */
    public void setMaeHokenKinkyuShisetsuRyoyoSeikyugaku(Decimal maeHokenKinkyuShisetsuRyoyoSeikyugaku) {
        this.maeHokenKinkyuShisetsuRyoyoSeikyugaku = maeHokenKinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * getMaeHokenTokuteiShinryohiSeikyugaku
     * @return maeHokenTokuteiShinryohiSeikyugaku
     */
    public Decimal getMaeHokenTokuteiShinryohiSeikyugaku() {
        return maeHokenTokuteiShinryohiSeikyugaku;
    }

    /**
     * setMaeHokenTokuteiShinryohiSeikyugaku
     * @param maeHokenTokuteiShinryohiSeikyugaku maeHokenTokuteiShinryohiSeikyugaku
     */
    public void setMaeHokenTokuteiShinryohiSeikyugaku(Decimal maeHokenTokuteiShinryohiSeikyugaku) {
        this.maeHokenTokuteiShinryohiSeikyugaku = maeHokenTokuteiShinryohiSeikyugaku;
    }

    /**
     * getMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku
     * @return maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public int getMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * setMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku
     * @param maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public void setMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(int maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku = maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * getMaeKohi1ServiceTanisu
     * @return maeKohi1ServiceTanisu
     */
    public int getMaeKohi1ServiceTanisu() {
        return maeKohi1ServiceTanisu;
    }

    /**
     * setMaeKohi1ServiceTanisu
     * @param maeKohi1ServiceTanisu maeKohi1ServiceTanisu
     */
    public void setMaeKohi1ServiceTanisu(int maeKohi1ServiceTanisu) {
        this.maeKohi1ServiceTanisu = maeKohi1ServiceTanisu;
    }

    /**
     * getMaeKohi1Seikyugaku
     * @return maeKohi1Seikyugaku
     */
    public int getMaeKohi1Seikyugaku() {
        return maeKohi1Seikyugaku;
    }

    /**
     * setMaeKohi1Seikyugaku
     * @param maeKohi1Seikyugaku maeKohi1Seikyugaku
     */
    public void setMaeKohi1Seikyugaku(int maeKohi1Seikyugaku) {
        this.maeKohi1Seikyugaku = maeKohi1Seikyugaku;
    }

    /**
     * getMaeKohi1RiyoshaFutangaku
     * @return maeKohi1RiyoshaFutangaku
     */
    public int getMaeKohi1RiyoshaFutangaku() {
        return maeKohi1RiyoshaFutangaku;
    }

    /**
     * setMaeKohi1RiyoshaFutangaku
     * @param maeKohi1RiyoshaFutangaku maeKohi1RiyoshaFutangaku
     */
    public void setMaeKohi1RiyoshaFutangaku(int maeKohi1RiyoshaFutangaku) {
        this.maeKohi1RiyoshaFutangaku = maeKohi1RiyoshaFutangaku;
    }

    /**
     * getMaeKohi1KinkyuShisetsuRyoyoSeikyugaku
     * @return maeKohi1KinkyuShisetsuRyoyoSeikyugaku
     */
    public int getMaeKohi1KinkyuShisetsuRyoyoSeikyugaku() {
        return maeKohi1KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * setMaeKohi1KinkyuShisetsuRyoyoSeikyugaku
     * @param maeKohi1KinkyuShisetsuRyoyoSeikyugaku maeKohi1KinkyuShisetsuRyoyoSeikyugaku
     */
    public void setMaeKohi1KinkyuShisetsuRyoyoSeikyugaku(int maeKohi1KinkyuShisetsuRyoyoSeikyugaku) {
        this.maeKohi1KinkyuShisetsuRyoyoSeikyugaku = maeKohi1KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * getMaeKohi1TokuteiShinryohiSeikyugaku
     * @return maeKohi1TokuteiShinryohiSeikyugaku
     */
    public int getMaeKohi1TokuteiShinryohiSeikyugaku() {
        return maeKohi1TokuteiShinryohiSeikyugaku;
    }

    /**
     * setMaeKohi1TokuteiShinryohiSeikyugaku
     * @param maeKohi1TokuteiShinryohiSeikyugaku maeKohi1TokuteiShinryohiSeikyugaku
     */
    public void setMaeKohi1TokuteiShinryohiSeikyugaku(int maeKohi1TokuteiShinryohiSeikyugaku) {
        this.maeKohi1TokuteiShinryohiSeikyugaku = maeKohi1TokuteiShinryohiSeikyugaku;
    }

    /**
     * getMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku
     * @return maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public int getMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * setMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku
     * @param maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public void setMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(int maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku = maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * getMaeKohi2ServiceTanisu
     * @return maeKohi2ServiceTanisu
     */
    public int getMaeKohi2ServiceTanisu() {
        return maeKohi2ServiceTanisu;
    }

    /**
     * setMaeKohi2ServiceTanisu
     * @param maeKohi2ServiceTanisu maeKohi2ServiceTanisu
     */
    public void setMaeKohi2ServiceTanisu(int maeKohi2ServiceTanisu) {
        this.maeKohi2ServiceTanisu = maeKohi2ServiceTanisu;
    }

    /**
     * getMaeKohi2Seikyugaku
     * @return maeKohi2Seikyugaku
     */
    public int getMaeKohi2Seikyugaku() {
        return maeKohi2Seikyugaku;
    }

    /**
     * setMaeKohi2Seikyugaku
     * @param maeKohi2Seikyugaku maeKohi2Seikyugaku
     */
    public void setMaeKohi2Seikyugaku(int maeKohi2Seikyugaku) {
        this.maeKohi2Seikyugaku = maeKohi2Seikyugaku;
    }

    /**
     * getMaeKohi2RiyoshaFutangaku
     * @return maeKohi2RiyoshaFutangaku
     */
    public int getMaeKohi2RiyoshaFutangaku() {
        return maeKohi2RiyoshaFutangaku;
    }

    /**
     * setMaeKohi2RiyoshaFutangaku
     * @param maeKohi2RiyoshaFutangaku maeKohi2RiyoshaFutangaku
     */
    public void setMaeKohi2RiyoshaFutangaku(int maeKohi2RiyoshaFutangaku) {
        this.maeKohi2RiyoshaFutangaku = maeKohi2RiyoshaFutangaku;
    }

    /**
     * getMaeKohi2KinkyuShisetsuRyoyoSeikyugaku
     * @return maeKohi2KinkyuShisetsuRyoyoSeikyugaku
     */
    public int getMaeKohi2KinkyuShisetsuRyoyoSeikyugaku() {
        return maeKohi2KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * setMaeKohi2KinkyuShisetsuRyoyoSeikyugaku
     * @param maeKohi2KinkyuShisetsuRyoyoSeikyugaku maeKohi2KinkyuShisetsuRyoyoSeikyugaku
     */
    public void setMaeKohi2KinkyuShisetsuRyoyoSeikyugaku(int maeKohi2KinkyuShisetsuRyoyoSeikyugaku) {
        this.maeKohi2KinkyuShisetsuRyoyoSeikyugaku = maeKohi2KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * getMaeKohi2TokuteiShinryohiSeikyugaku
     * @return maeKohi2TokuteiShinryohiSeikyugaku
     */
    public int getMaeKohi2TokuteiShinryohiSeikyugaku() {
        return maeKohi2TokuteiShinryohiSeikyugaku;
    }

    /**
     * setMaeKohi2TokuteiShinryohiSeikyugaku
     * @param maeKohi2TokuteiShinryohiSeikyugaku maeKohi2TokuteiShinryohiSeikyugaku
     */
    public void setMaeKohi2TokuteiShinryohiSeikyugaku(int maeKohi2TokuteiShinryohiSeikyugaku) {
        this.maeKohi2TokuteiShinryohiSeikyugaku = maeKohi2TokuteiShinryohiSeikyugaku;
    }

    /**
     * getMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku
     * @return maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public int getMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * setMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku
     * @param maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public void setMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(int maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku = maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * getMaeKohi3ServiceTanisu
     * @return maeKohi3ServiceTanisu
     */
    public int getMaeKohi3ServiceTanisu() {
        return maeKohi3ServiceTanisu;
    }

    /**
     * setMaeKohi3ServiceTanisu
     * @param maeKohi3ServiceTanisu maeKohi3ServiceTanisu
     */
    public void setMaeKohi3ServiceTanisu(int maeKohi3ServiceTanisu) {
        this.maeKohi3ServiceTanisu = maeKohi3ServiceTanisu;
    }

    /**
     * getMaeKohi3Seikyugaku
     * @return maeKohi3Seikyugaku
     */
    public int getMaeKohi3Seikyugaku() {
        return maeKohi3Seikyugaku;
    }

    /**
     * setMaeKohi3Seikyugaku
     * @param maeKohi3Seikyugaku maeKohi3Seikyugaku
     */
    public void setMaeKohi3Seikyugaku(int maeKohi3Seikyugaku) {
        this.maeKohi3Seikyugaku = maeKohi3Seikyugaku;
    }

    /**
     * getMaeKohi3RiyoshaFutangaku
     * @return maeKohi3RiyoshaFutangaku
     */
    public int getMaeKohi3RiyoshaFutangaku() {
        return maeKohi3RiyoshaFutangaku;
    }

    /**
     * setMaeKohi3RiyoshaFutangaku
     * @param maeKohi3RiyoshaFutangaku maeKohi3RiyoshaFutangaku
     */
    public void setMaeKohi3RiyoshaFutangaku(int maeKohi3RiyoshaFutangaku) {
        this.maeKohi3RiyoshaFutangaku = maeKohi3RiyoshaFutangaku;
    }

    /**
     * getMaeKohi3KinkyuShisetsuRyoyoSeikyugaku
     * @return maeKohi3KinkyuShisetsuRyoyoSeikyugaku
     */
    public int getMaeKohi3KinkyuShisetsuRyoyoSeikyugaku() {
        return maeKohi3KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * setMaeKohi3KinkyuShisetsuRyoyoSeikyugaku
     * @param maeKohi3KinkyuShisetsuRyoyoSeikyugaku maeKohi3KinkyuShisetsuRyoyoSeikyugaku
     */
    public void setMaeKohi3KinkyuShisetsuRyoyoSeikyugaku(int maeKohi3KinkyuShisetsuRyoyoSeikyugaku) {
        this.maeKohi3KinkyuShisetsuRyoyoSeikyugaku = maeKohi3KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * getMaeKohi3TokuteiShinryohiSeikyugaku
     * @return maeKohi3TokuteiShinryohiSeikyugaku
     */
    public int getMaeKohi3TokuteiShinryohiSeikyugaku() {
        return maeKohi3TokuteiShinryohiSeikyugaku;
    }

    /**
     * setMaeKohi3TokuteiShinryohiSeikyugaku
     * @param maeKohi3TokuteiShinryohiSeikyugaku maeKohi3TokuteiShinryohiSeikyugaku
     */
    public void setMaeKohi3TokuteiShinryohiSeikyugaku(int maeKohi3TokuteiShinryohiSeikyugaku) {
        this.maeKohi3TokuteiShinryohiSeikyugaku = maeKohi3TokuteiShinryohiSeikyugaku;
    }

    /**
     * getMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku
     * @return maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public int getMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * setMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku
     * @param maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public void setMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(int maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku = maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * getAtoHokenServiceTanisu
     * @return atoHokenServiceTanisu
     */
    public int getAtoHokenServiceTanisu() {
        return atoHokenServiceTanisu;
    }

    /**
     * setAtoHokenServiceTanisu
     * @param atoHokenServiceTanisu atoHokenServiceTanisu
     */
    public void setAtoHokenServiceTanisu(int atoHokenServiceTanisu) {
        this.atoHokenServiceTanisu = atoHokenServiceTanisu;
    }

    /**
     * getAtoHokenSeikyugaku
     * @return atoHokenSeikyugaku
     */
    public Decimal getAtoHokenSeikyugaku() {
        return atoHokenSeikyugaku;
    }

    /**
     * setAtoHokenSeikyugaku
     * @param atoHokenSeikyugaku atoHokenSeikyugaku
     */
    public void setAtoHokenSeikyugaku(Decimal atoHokenSeikyugaku) {
        this.atoHokenSeikyugaku = atoHokenSeikyugaku;
    }

    /**
     * getAtoHokenRiyoshaFutangaku
     * @return atoHokenRiyoshaFutangaku
     */
    public int getAtoHokenRiyoshaFutangaku() {
        return atoHokenRiyoshaFutangaku;
    }

    /**
     * setAtoHokenRiyoshaFutangaku
     * @param atoHokenRiyoshaFutangaku atoHokenRiyoshaFutangaku
     */
    public void setAtoHokenRiyoshaFutangaku(int atoHokenRiyoshaFutangaku) {
        this.atoHokenRiyoshaFutangaku = atoHokenRiyoshaFutangaku;
    }

    /**
     * getAtoHokenKinkyuShisetsuRyoyoSeikyugaku
     * @return atoHokenKinkyuShisetsuRyoyoSeikyugaku
     */
    public Decimal getAtoHokenKinkyuShisetsuRyoyoSeikyugaku() {
        return atoHokenKinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * setAtoHokenKinkyuShisetsuRyoyoSeikyugaku
     * @param atoHokenKinkyuShisetsuRyoyoSeikyugaku atoHokenKinkyuShisetsuRyoyoSeikyugaku
     */
    public void setAtoHokenKinkyuShisetsuRyoyoSeikyugaku(Decimal atoHokenKinkyuShisetsuRyoyoSeikyugaku) {
        this.atoHokenKinkyuShisetsuRyoyoSeikyugaku = atoHokenKinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * getAtoHokenTokuteiShinryohiSeikyugaku
     * @return atoHokenTokuteiShinryohiSeikyugaku
     */
    public Decimal getAtoHokenTokuteiShinryohiSeikyugaku() {
        return atoHokenTokuteiShinryohiSeikyugaku;
    }

    /**
     * setAtoHokenTokuteiShinryohiSeikyugaku
     * @param atoHokenTokuteiShinryohiSeikyugaku atoHokenTokuteiShinryohiSeikyugaku
     */
    public void setAtoHokenTokuteiShinryohiSeikyugaku(Decimal atoHokenTokuteiShinryohiSeikyugaku) {
        this.atoHokenTokuteiShinryohiSeikyugaku = atoHokenTokuteiShinryohiSeikyugaku;
    }

    /**
     * getAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku
     * @return atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public int getAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * setAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku
     * @param atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public void setAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(int atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku = atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * getAtoKohi1ServiceTanisu
     * @return atoKohi1ServiceTanisu
     */
    public int getAtoKohi1ServiceTanisu() {
        return atoKohi1ServiceTanisu;
    }

    /**
     * setAtoKohi1ServiceTanisu
     * @param atoKohi1ServiceTanisu atoKohi1ServiceTanisu
     */
    public void setAtoKohi1ServiceTanisu(int atoKohi1ServiceTanisu) {
        this.atoKohi1ServiceTanisu = atoKohi1ServiceTanisu;
    }

    /**
     * getAtoKohi1Seikyugaku
     * @return atoKohi1Seikyugaku
     */
    public int getAtoKohi1Seikyugaku() {
        return atoKohi1Seikyugaku;
    }

    /**
     * setAtoKohi1Seikyugaku
     * @param atoKohi1Seikyugaku atoKohi1Seikyugaku
     */
    public void setAtoKohi1Seikyugaku(int atoKohi1Seikyugaku) {
        this.atoKohi1Seikyugaku = atoKohi1Seikyugaku;
    }

    /**
     * getAtoKohi1RiyoshaFutangaku
     * @return atoKohi1RiyoshaFutangaku
     */
    public int getAtoKohi1RiyoshaFutangaku() {
        return atoKohi1RiyoshaFutangaku;
    }

    /**
     * setAtoKohi1RiyoshaFutangaku
     * @param atoKohi1RiyoshaFutangaku atoKohi1RiyoshaFutangaku
     */
    public void setAtoKohi1RiyoshaFutangaku(int atoKohi1RiyoshaFutangaku) {
        this.atoKohi1RiyoshaFutangaku = atoKohi1RiyoshaFutangaku;
    }

    /**
     * getAtoKohi1KinkyuShisetsuRyoyoSeikyugaku
     * @return atoKohi1KinkyuShisetsuRyoyoSeikyugaku
     */
    public int getAtoKohi1KinkyuShisetsuRyoyoSeikyugaku() {
        return atoKohi1KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * setAtoKohi1KinkyuShisetsuRyoyoSeikyugaku
     * @param atoKohi1KinkyuShisetsuRyoyoSeikyugaku atoKohi1KinkyuShisetsuRyoyoSeikyugaku
     */
    public void setAtoKohi1KinkyuShisetsuRyoyoSeikyugaku(int atoKohi1KinkyuShisetsuRyoyoSeikyugaku) {
        this.atoKohi1KinkyuShisetsuRyoyoSeikyugaku = atoKohi1KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * getAtoKohi1TokuteiShinryohiSeikyugaku
     * @return atoKohi1TokuteiShinryohiSeikyugaku
     */
    public int getAtoKohi1TokuteiShinryohiSeikyugaku() {
        return atoKohi1TokuteiShinryohiSeikyugaku;
    }

    /**
     * setAtoKohi1TokuteiShinryohiSeikyugaku
     * @param atoKohi1TokuteiShinryohiSeikyugaku atoKohi1TokuteiShinryohiSeikyugaku
     */
    public void setAtoKohi1TokuteiShinryohiSeikyugaku(int atoKohi1TokuteiShinryohiSeikyugaku) {
        this.atoKohi1TokuteiShinryohiSeikyugaku = atoKohi1TokuteiShinryohiSeikyugaku;
    }

    /**
     * getAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku
     * @return atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public int getAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * setAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku
     * @param atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public void setAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(int atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku = atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * getAtoKohi2ServiceTanisu
     * @return atoKohi2ServiceTanisu
     */
    public int getAtoKohi2ServiceTanisu() {
        return atoKohi2ServiceTanisu;
    }

    /**
     * setAtoKohi2ServiceTanisu
     * @param atoKohi2ServiceTanisu atoKohi2ServiceTanisu
     */
    public void setAtoKohi2ServiceTanisu(int atoKohi2ServiceTanisu) {
        this.atoKohi2ServiceTanisu = atoKohi2ServiceTanisu;
    }

    /**
     * getAtoKohi2Seikyugaku
     * @return atoKohi2Seikyugaku
     */
    public int getAtoKohi2Seikyugaku() {
        return atoKohi2Seikyugaku;
    }

    /**
     * setAtoKohi2Seikyugaku
     * @param atoKohi2Seikyugaku atoKohi2Seikyugaku
     */
    public void setAtoKohi2Seikyugaku(int atoKohi2Seikyugaku) {
        this.atoKohi2Seikyugaku = atoKohi2Seikyugaku;
    }

    /**
     * getAtoKohi2RiyoshaFutangaku
     * @return atoKohi2RiyoshaFutangaku
     */
    public int getAtoKohi2RiyoshaFutangaku() {
        return atoKohi2RiyoshaFutangaku;
    }

    /**
     * setAtoKohi2RiyoshaFutangaku
     * @param atoKohi2RiyoshaFutangaku atoKohi2RiyoshaFutangaku
     */
    public void setAtoKohi2RiyoshaFutangaku(int atoKohi2RiyoshaFutangaku) {
        this.atoKohi2RiyoshaFutangaku = atoKohi2RiyoshaFutangaku;
    }

    /**
     * getAtoKohi2KinkyuShisetsuRyoyoSeikyugaku
     * @return atoKohi2KinkyuShisetsuRyoyoSeikyugaku
     */
    public int getAtoKohi2KinkyuShisetsuRyoyoSeikyugaku() {
        return atoKohi2KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * setAtoKohi2KinkyuShisetsuRyoyoSeikyugaku
     * @param atoKohi2KinkyuShisetsuRyoyoSeikyugaku atoKohi2KinkyuShisetsuRyoyoSeikyugaku
     */
    public void setAtoKohi2KinkyuShisetsuRyoyoSeikyugaku(int atoKohi2KinkyuShisetsuRyoyoSeikyugaku) {
        this.atoKohi2KinkyuShisetsuRyoyoSeikyugaku = atoKohi2KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * getAtoKohi2TokuteiShinryohiSeikyugaku
     * @return atoKohi2TokuteiShinryohiSeikyugaku
     */
    public int getAtoKohi2TokuteiShinryohiSeikyugaku() {
        return atoKohi2TokuteiShinryohiSeikyugaku;
    }

    /**
     * setAtoKohi2TokuteiShinryohiSeikyugaku
     * @param atoKohi2TokuteiShinryohiSeikyugaku atoKohi2TokuteiShinryohiSeikyugaku
     */
    public void setAtoKohi2TokuteiShinryohiSeikyugaku(int atoKohi2TokuteiShinryohiSeikyugaku) {
        this.atoKohi2TokuteiShinryohiSeikyugaku = atoKohi2TokuteiShinryohiSeikyugaku;
    }

    /**
     * getAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku
     * @return atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public int getAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * setAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku
     * @param atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public void setAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(int atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku = atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * getAtoKohi3ServiceTanisu
     * @return atoKohi3ServiceTanisu
     */
    public int getAtoKohi3ServiceTanisu() {
        return atoKohi3ServiceTanisu;
    }

    /**
     * setAtoKohi3ServiceTanisu
     * @param atoKohi3ServiceTanisu atoKohi3ServiceTanisu
     */
    public void setAtoKohi3ServiceTanisu(int atoKohi3ServiceTanisu) {
        this.atoKohi3ServiceTanisu = atoKohi3ServiceTanisu;
    }

    /**
     * getAtoKohi3Seikyugaku
     * @return atoKohi3Seikyugaku
     */
    public int getAtoKohi3Seikyugaku() {
        return atoKohi3Seikyugaku;
    }

    /**
     * setAtoKohi3Seikyugaku
     * @param atoKohi3Seikyugaku atoKohi3Seikyugaku
     */
    public void setAtoKohi3Seikyugaku(int atoKohi3Seikyugaku) {
        this.atoKohi3Seikyugaku = atoKohi3Seikyugaku;
    }

    /**
     * getAtoKohi3RiyoshaFutangaku
     * @return atoKohi3RiyoshaFutangaku
     */
    public int getAtoKohi3RiyoshaFutangaku() {
        return atoKohi3RiyoshaFutangaku;
    }

    /**
     * setAtoKohi3RiyoshaFutangaku
     * @param atoKohi3RiyoshaFutangaku atoKohi3RiyoshaFutangaku
     */
    public void setAtoKohi3RiyoshaFutangaku(int atoKohi3RiyoshaFutangaku) {
        this.atoKohi3RiyoshaFutangaku = atoKohi3RiyoshaFutangaku;
    }

    /**
     * getAtoKohi3KinkyuShisetsuRyoyoSeikyugaku
     * @return atoKohi3KinkyuShisetsuRyoyoSeikyugaku
     */
    public int getAtoKohi3KinkyuShisetsuRyoyoSeikyugaku() {
        return atoKohi3KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * setAtoKohi3KinkyuShisetsuRyoyoSeikyugaku
     * @param atoKohi3KinkyuShisetsuRyoyoSeikyugaku atoKohi3KinkyuShisetsuRyoyoSeikyugaku
     */
    public void setAtoKohi3KinkyuShisetsuRyoyoSeikyugaku(int atoKohi3KinkyuShisetsuRyoyoSeikyugaku) {
        this.atoKohi3KinkyuShisetsuRyoyoSeikyugaku = atoKohi3KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * getAtoKohi3TokuteiShinryohiSeikyugaku
     * @return atoKohi3TokuteiShinryohiSeikyugaku
     */
    public int getAtoKohi3TokuteiShinryohiSeikyugaku() {
        return atoKohi3TokuteiShinryohiSeikyugaku;
    }

    /**
     * setAtoKohi3TokuteiShinryohiSeikyugaku
     * @param atoKohi3TokuteiShinryohiSeikyugaku atoKohi3TokuteiShinryohiSeikyugaku
     */
    public void setAtoKohi3TokuteiShinryohiSeikyugaku(int atoKohi3TokuteiShinryohiSeikyugaku) {
        this.atoKohi3TokuteiShinryohiSeikyugaku = atoKohi3TokuteiShinryohiSeikyugaku;
    }

    /**
     * getAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku
     * @return atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public int getAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * setAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku
     * @param atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public void setAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(int atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku = atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * getKeikaiKubunCode
     * @return keikaiKubunCode
     */
    public RString getKeikaiKubunCode() {
        return keikaiKubunCode;
    }

    /**
     * setKeikaiKubunCode
     * @param keikaiKubunCode keikaiKubunCode
     */
    public void setKeikaiKubunCode(RString keikaiKubunCode) {
        this.keikaiKubunCode = keikaiKubunCode;
    }

    /**
     * getShinsaYM
     * @return shinsaYM
     */
    public FlexibleYearMonth getShinsaYM() {
        return shinsaYM;
    }

    /**
     * setShinsaYM
     * @param shinsaYM shinsaYM
     */
    public void setShinsaYM(FlexibleYearMonth shinsaYM) {
        this.shinsaYM = shinsaYM;
    }

    /**
     * getSofuYM
     * @return sofuYM
     */
    public FlexibleYearMonth getSofuYM() {
        return sofuYM;
    }

    /**
     * setSofuYM
     * @param sofuYM sofuYM
     */
    public void setSofuYM(FlexibleYearMonth sofuYM) {
        this.sofuYM = sofuYM;
    }

    /**
     * getTorikomiYM
     * @return torikomiYM
     */
    public FlexibleYearMonth getTorikomiYM() {
        return torikomiYM;
    }

    /**
     * setTorikomiYM
     * @param torikomiYM torikomiYM
     */
    public void setTorikomiYM(FlexibleYearMonth torikomiYM) {
        this.torikomiYM = torikomiYM;
    }

    /**
     * getSeiriNo
     * @return seiriNo
     */
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * setSeiriNo
     * @param seiriNo seiriNo
     */
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
    }

    /**
     * getDokujiSakuseiKubun
     * @return dokujiSakuseiKubun
     */
    public RString getDokujiSakuseiKubun() {
        return dokujiSakuseiKubun;
    }

    /**
     * setDokujiSakuseiKubun
     * @param dokujiSakuseiKubun dokujiSakuseiKubun
     */
    public void setDokujiSakuseiKubun(RString dokujiSakuseiKubun) {
        this.dokujiSakuseiKubun = dokujiSakuseiKubun;
    }

    /**
     * getHokenshaHoyuKyufujissekiJohoSakujoFlag
     * @return hokenshaHoyuKyufujissekiJohoSakujoFlag
     */
    public boolean getHokenshaHoyuKyufujissekiJohoSakujoFlag() {
        return hokenshaHoyuKyufujissekiJohoSakujoFlag;
    }

    /**
     * setHokenshaHoyuKyufujissekiJohoSakujoFlag
     * @param hokenshaHoyuKyufujissekiJohoSakujoFlag hokenshaHoyuKyufujissekiJohoSakujoFlag
     */
    public void setHokenshaHoyuKyufujissekiJohoSakujoFlag(boolean hokenshaHoyuKyufujissekiJohoSakujoFlag) {
        this.hokenshaHoyuKyufujissekiJohoSakujoFlag = hokenshaHoyuKyufujissekiJohoSakujoFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3017KyufujissekiKihon200804Entity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3017KyufujissekiKihon200804Entity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT3017KyufujissekiKihon200804Entity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.insertTimestamp, other.insertTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.kokanShikibetsuNo, other.kokanShikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.inputShikibetsuNo, other.inputShikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.recodeShubetsuCode, other.recodeShubetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.kyufuSakuseiKubunCode, other.kyufuSakuseiKubunCode)) {
            return false;
        }
        if (!Objects.equals(this.hokenshaNo, other.hokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.kyufuJissekiKubunCode, other.kyufuJissekiKubunCode)) {
            return false;
        }
        if (!Objects.equals(this.jigyoshoNo, other.jigyoshoNo)) {
            return false;
        }
        if (!Objects.equals(this.toshiNo, other.toshiNo)) {
            return false;
        }
        return true;
    }

// </editor-fold>


}
