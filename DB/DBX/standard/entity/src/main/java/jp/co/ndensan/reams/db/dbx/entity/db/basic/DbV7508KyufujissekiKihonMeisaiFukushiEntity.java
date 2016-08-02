package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;

/**
 * 給付実績基本明細・福祉Viewテーブルのエンティティクラスです。
 */
public class DbV7508KyufujissekiKihonMeisaiFukushiEntity extends DbTableEntityBase<DbV7508KyufujissekiKihonMeisaiFukushiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV7508KyufujissekiKihonMeisaiFukushi");

    private KokanShikibetsuNo kokanShikibetsuNo;
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    private RString recodeShubetsuCode;
    private RString kyufuSakuseiKubunCode;
    private HokenshaNo shokisaiHokenshaNo;
    private HihokenshaNo hiHokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private RString kyufuJissekiKubunCode;
    private JigyoshaNo jigyoshoNo;
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
    private RString kyotakuServiceSakuseiKubunCode;
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
    private RString seiriNo;
    private FlexibleYearMonth sofuYM;
    private FlexibleYearMonth torikomiYM;
    private RString dokujiSakuseiKubun;
    private boolean hokenshaHoyuKyufujissekiJohoSakujoFlag;
    private ServiceShuruiCode serviceShuruiCode;
    private ServiceKomokuCode serviceKomokuCode;
    private int tanisu;
    private int nissuKaisu;
    private int kohi1TaishoNissuKaisu;
    private int kohi2TaishoNissuKaisu;
    private int kohi3TaishoNissuKaisu;
    private int serviceTanisu;
    private int kohi1TaishoServiceTanisu;
    private int kohi2TaishoServiceTanisu;
    private int kohi3TaishoServiceTanisu;
    private RString tekiyo;
    private int atoTanisu;
    private int atoNissuKaisu;
    private int atoKohi1TaishoNissuKaisu;
    private int atoKohi2TaishoNissukaisu;
    private int atoKohi3TaishoNissuKaisu;
    private int atoServiceTanisu;
    private int atoKohi1TaishoServiceTanisu;
    private int atoKohi2TaishoServiceTanisu;
    private int atoKohi3TaishoServiceTanisu;
    private int saishinsaKaisu;
    private int kagoKaisu;

    /**
     * kokanShikibetsuNoのgetメソッドです。
     * 
     * @return kokanShikibetsuNo
     */
    @CheckForNull
    public KokanShikibetsuNo getKokanShikibetsuNo() {
        return kokanShikibetsuNo;
    }

    /**
     * kokanShikibetsuNoのsetメソッドです。
     * 
     * @param kokanShikibetsuNo kokanShikibetsuNo
     */
    public void setKokanShikibetsuNo(KokanShikibetsuNo kokanShikibetsuNo) {
        this.kokanShikibetsuNo = kokanShikibetsuNo;
    }

    /**
     * inputShikibetsuNoのgetメソッドです。
     * 
     * @return inputShikibetsuNo
     */
    @CheckForNull
    public NyuryokuShikibetsuNo getInputShikibetsuNo() {
        return inputShikibetsuNo;
    }

    /**
     * inputShikibetsuNoのsetメソッドです。
     * 
     * @param inputShikibetsuNo inputShikibetsuNo
     */
    public void setInputShikibetsuNo(NyuryokuShikibetsuNo inputShikibetsuNo) {
        this.inputShikibetsuNo = inputShikibetsuNo;
    }

    /**
     * recodeShubetsuCodeのgetメソッドです。
     * 
     * @return recodeShubetsuCode
     */
    @CheckForNull
    public RString getRecodeShubetsuCode() {
        return recodeShubetsuCode;
    }

    /**
     * recodeShubetsuCodeのsetメソッドです。
     * 
     * @param recodeShubetsuCode recodeShubetsuCode
     */
    public void setRecodeShubetsuCode(RString recodeShubetsuCode) {
        this.recodeShubetsuCode = recodeShubetsuCode;
    }

    /**
     * kyufuSakuseiKubunCodeのgetメソッドです。
     * 
     * @return kyufuSakuseiKubunCode
     */
    @CheckForNull
    public RString getKyufuSakuseiKubunCode() {
        return kyufuSakuseiKubunCode;
    }

    /**
     * kyufuSakuseiKubunCodeのsetメソッドです。
     * 
     * @param kyufuSakuseiKubunCode kyufuSakuseiKubunCode
     */
    public void setKyufuSakuseiKubunCode(RString kyufuSakuseiKubunCode) {
        this.kyufuSakuseiKubunCode = kyufuSakuseiKubunCode;
    }

    /**
     * shokisaiHokenshaNoのgetメソッドです。
     * 
     * @return shokisaiHokenshaNo
     */
    @CheckForNull
    public HokenshaNo getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    /**
     * shokisaiHokenshaNoのsetメソッドです。
     * 
     * @param shokisaiHokenshaNo shokisaiHokenshaNo
     */
    public void setShokisaiHokenshaNo(HokenshaNo shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
    }

    /**
     * hiHokenshaNoのgetメソッドです。
     * 
     * @return hiHokenshaNo
     */
    @CheckForNull
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * hiHokenshaNoのsetメソッドです。
     * 
     * @param hiHokenshaNo hiHokenshaNo
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * serviceTeikyoYMのgetメソッドです。
     * 
     * @return serviceTeikyoYM
     */
    @CheckForNull
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * serviceTeikyoYMのsetメソッドです。
     * 
     * @param serviceTeikyoYM serviceTeikyoYM
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * kyufuJissekiKubunCodeのgetメソッドです。
     * 
     * @return kyufuJissekiKubunCode
     */
    @CheckForNull
    public RString getKyufuJissekiKubunCode() {
        return kyufuJissekiKubunCode;
    }

    /**
     * kyufuJissekiKubunCodeのsetメソッドです。
     * 
     * @param kyufuJissekiKubunCode kyufuJissekiKubunCode
     */
    public void setKyufuJissekiKubunCode(RString kyufuJissekiKubunCode) {
        this.kyufuJissekiKubunCode = kyufuJissekiKubunCode;
    }

    /**
     * jigyoshoNoのgetメソッドです。
     * 
     * @return jigyoshoNo
     */
    @CheckForNull
    public JigyoshaNo getJigyoshoNo() {
        return jigyoshoNo;
    }

    /**
     * jigyoshoNoのsetメソッドです。
     * 
     * @param jigyoshoNo jigyoshoNo
     */
    public void setJigyoshoNo(JigyoshaNo jigyoshoNo) {
        this.jigyoshoNo = jigyoshoNo;
    }

    /**
     * toshiNoのgetメソッドです。
     * 
     * @return toshiNo
     */
    @CheckForNull
    public RString getToshiNo() {
        return toshiNo;
    }

    /**
     * toshiNoのsetメソッドです。
     * 
     * @param toshiNo toshiNo
     */
    public void setToshiNo(RString toshiNo) {
        this.toshiNo = toshiNo;
    }

    /**
     * kohi1FutanshaNoのgetメソッドです。
     * 
     * @return kohi1FutanshaNo
     */
    @CheckForNull
    public RString getKohi1FutanshaNo() {
        return kohi1FutanshaNo;
    }

    /**
     * kohi1FutanshaNoのsetメソッドです。
     * 
     * @param kohi1FutanshaNo kohi1FutanshaNo
     */
    public void setKohi1FutanshaNo(RString kohi1FutanshaNo) {
        this.kohi1FutanshaNo = kohi1FutanshaNo;
    }

    /**
     * kohi1JukyushaNoのgetメソッドです。
     * 
     * @return kohi1JukyushaNo
     */
    @CheckForNull
    public RString getKohi1JukyushaNo() {
        return kohi1JukyushaNo;
    }

    /**
     * kohi1JukyushaNoのsetメソッドです。
     * 
     * @param kohi1JukyushaNo kohi1JukyushaNo
     */
    public void setKohi1JukyushaNo(RString kohi1JukyushaNo) {
        this.kohi1JukyushaNo = kohi1JukyushaNo;
    }

    /**
     * kohi2FutanshaNoのgetメソッドです。
     * 
     * @return kohi2FutanshaNo
     */
    @CheckForNull
    public RString getKohi2FutanshaNo() {
        return kohi2FutanshaNo;
    }

    /**
     * kohi2FutanshaNoのsetメソッドです。
     * 
     * @param kohi2FutanshaNo kohi2FutanshaNo
     */
    public void setKohi2FutanshaNo(RString kohi2FutanshaNo) {
        this.kohi2FutanshaNo = kohi2FutanshaNo;
    }

    /**
     * kohi2JukyushaNoのgetメソッドです。
     * 
     * @return kohi2JukyushaNo
     */
    @CheckForNull
    public RString getKohi2JukyushaNo() {
        return kohi2JukyushaNo;
    }

    /**
     * kohi2JukyushaNoのsetメソッドです。
     * 
     * @param kohi2JukyushaNo kohi2JukyushaNo
     */
    public void setKohi2JukyushaNo(RString kohi2JukyushaNo) {
        this.kohi2JukyushaNo = kohi2JukyushaNo;
    }

    /**
     * kohi3FutanshaNoのgetメソッドです。
     * 
     * @return kohi3FutanshaNo
     */
    @CheckForNull
    public RString getKohi3FutanshaNo() {
        return kohi3FutanshaNo;
    }

    /**
     * kohi3FutanshaNoのsetメソッドです。
     * 
     * @param kohi3FutanshaNo kohi3FutanshaNo
     */
    public void setKohi3FutanshaNo(RString kohi3FutanshaNo) {
        this.kohi3FutanshaNo = kohi3FutanshaNo;
    }

    /**
     * kohi3JukyushaNoのgetメソッドです。
     * 
     * @return kohi3JukyushaNo
     */
    @CheckForNull
    public RString getKohi3JukyushaNo() {
        return kohi3JukyushaNo;
    }

    /**
     * kohi3JukyushaNoのsetメソッドです。
     * 
     * @param kohi3JukyushaNo kohi3JukyushaNo
     */
    public void setKohi3JukyushaNo(RString kohi3JukyushaNo) {
        this.kohi3JukyushaNo = kohi3JukyushaNo;
    }

    /**
     * umareYMDのgetメソッドです。
     * 
     * @return umareYMD
     */
    @CheckForNull
    public FlexibleDate getUmareYMD() {
        return umareYMD;
    }

    /**
     * umareYMDのsetメソッドです。
     * 
     * @param umareYMD umareYMD
     */
    public void setUmareYMD(FlexibleDate umareYMD) {
        this.umareYMD = umareYMD;
    }

    /**
     * seibetsuCodeのgetメソッドです。
     * 
     * @return seibetsuCode
     */
    @CheckForNull
    public RString getSeibetsuCode() {
        return seibetsuCode;
    }

    /**
     * seibetsuCodeのsetメソッドです。
     * 
     * @param seibetsuCode seibetsuCode
     */
    public void setSeibetsuCode(RString seibetsuCode) {
        this.seibetsuCode = seibetsuCode;
    }

    /**
     * yoKaigoJotaiKubunCodeのgetメソッドです。
     * 
     * @return yoKaigoJotaiKubunCode
     */
    @CheckForNull
    public RString getYoKaigoJotaiKubunCode() {
        return yoKaigoJotaiKubunCode;
    }

    /**
     * yoKaigoJotaiKubunCodeのsetメソッドです。
     * 
     * @param yoKaigoJotaiKubunCode yoKaigoJotaiKubunCode
     */
    public void setYoKaigoJotaiKubunCode(RString yoKaigoJotaiKubunCode) {
        this.yoKaigoJotaiKubunCode = yoKaigoJotaiKubunCode;
    }

    /**
     * kyuSochiNyushoshaTokureiCodeのgetメソッドです。
     * 
     * @return kyuSochiNyushoshaTokureiCode
     */
    @CheckForNull
    public RString getKyuSochiNyushoshaTokureiCode() {
        return kyuSochiNyushoshaTokureiCode;
    }

    /**
     * kyuSochiNyushoshaTokureiCodeのsetメソッドです。
     * 
     * @param kyuSochiNyushoshaTokureiCode kyuSochiNyushoshaTokureiCode
     */
    public void setKyuSochiNyushoshaTokureiCode(RString kyuSochiNyushoshaTokureiCode) {
        this.kyuSochiNyushoshaTokureiCode = kyuSochiNyushoshaTokureiCode;
    }

    /**
     * ninteiYukoKaishiYMDのgetメソッドです。
     * 
     * @return ninteiYukoKaishiYMD
     */
    @CheckForNull
    public FlexibleDate getNinteiYukoKaishiYMD() {
        return ninteiYukoKaishiYMD;
    }

    /**
     * ninteiYukoKaishiYMDのsetメソッドです。
     * 
     * @param ninteiYukoKaishiYMD ninteiYukoKaishiYMD
     */
    public void setNinteiYukoKaishiYMD(FlexibleDate ninteiYukoKaishiYMD) {
        this.ninteiYukoKaishiYMD = ninteiYukoKaishiYMD;
    }

    /**
     * ninteiYukoShuryoYMDのgetメソッドです。
     * 
     * @return ninteiYukoShuryoYMD
     */
    @CheckForNull
    public FlexibleDate getNinteiYukoShuryoYMD() {
        return ninteiYukoShuryoYMD;
    }

    /**
     * ninteiYukoShuryoYMDのsetメソッドです。
     * 
     * @param ninteiYukoShuryoYMD ninteiYukoShuryoYMD
     */
    public void setNinteiYukoShuryoYMD(FlexibleDate ninteiYukoShuryoYMD) {
        this.ninteiYukoShuryoYMD = ninteiYukoShuryoYMD;
    }

    /**
     * rojinHokenShichosonNoのgetメソッドです。
     * 
     * @return rojinHokenShichosonNo
     */
    @CheckForNull
    public RString getRojinHokenShichosonNo() {
        return rojinHokenShichosonNo;
    }

    /**
     * rojinHokenShichosonNoのsetメソッドです。
     * 
     * @param rojinHokenShichosonNo rojinHokenShichosonNo
     */
    public void setRojinHokenShichosonNo(RString rojinHokenShichosonNo) {
        this.rojinHokenShichosonNo = rojinHokenShichosonNo;
    }

    /**
     * rojinhokenJukyushaNoのgetメソッドです。
     * 
     * @return rojinhokenJukyushaNo
     */
    @CheckForNull
    public RString getRojinhokenJukyushaNo() {
        return rojinhokenJukyushaNo;
    }

    /**
     * rojinhokenJukyushaNoのsetメソッドです。
     * 
     * @param rojinhokenJukyushaNo rojinhokenJukyushaNo
     */
    public void setRojinhokenJukyushaNo(RString rojinhokenJukyushaNo) {
        this.rojinhokenJukyushaNo = rojinhokenJukyushaNo;
    }

    /**
     * kokiHokenshaNoのgetメソッドです。
     * 
     * @return kokiHokenshaNo
     */
    @CheckForNull
    public RString getKokiHokenshaNo() {
        return kokiHokenshaNo;
    }

    /**
     * kokiHokenshaNoのsetメソッドです。
     * 
     * @param kokiHokenshaNo kokiHokenshaNo
     */
    public void setKokiHokenshaNo(RString kokiHokenshaNo) {
        this.kokiHokenshaNo = kokiHokenshaNo;
    }

    /**
     * kokiHiHokenshaNoのgetメソッドです。
     * 
     * @return kokiHiHokenshaNo
     */
    @CheckForNull
    public RString getKokiHiHokenshaNo() {
        return kokiHiHokenshaNo;
    }

    /**
     * kokiHiHokenshaNoのsetメソッドです。
     * 
     * @param kokiHiHokenshaNo kokiHiHokenshaNo
     */
    public void setKokiHiHokenshaNo(RString kokiHiHokenshaNo) {
        this.kokiHiHokenshaNo = kokiHiHokenshaNo;
    }

    /**
     * kokuhoHokenshaNoのgetメソッドです。
     * 
     * @return kokuhoHokenshaNo
     */
    @CheckForNull
    public RString getKokuhoHokenshaNo() {
        return kokuhoHokenshaNo;
    }

    /**
     * kokuhoHokenshaNoのsetメソッドです。
     * 
     * @param kokuhoHokenshaNo kokuhoHokenshaNo
     */
    public void setKokuhoHokenshaNo(RString kokuhoHokenshaNo) {
        this.kokuhoHokenshaNo = kokuhoHokenshaNo;
    }

    /**
     * kokuhoHiHokenshashoNoのgetメソッドです。
     * 
     * @return kokuhoHiHokenshashoNo
     */
    @CheckForNull
    public RString getKokuhoHiHokenshashoNo() {
        return kokuhoHiHokenshashoNo;
    }

    /**
     * kokuhoHiHokenshashoNoのsetメソッドです。
     * 
     * @param kokuhoHiHokenshashoNo kokuhoHiHokenshashoNo
     */
    public void setKokuhoHiHokenshashoNo(RString kokuhoHiHokenshashoNo) {
        this.kokuhoHiHokenshashoNo = kokuhoHiHokenshashoNo;
    }

    /**
     * kokuhoKojinNoのgetメソッドです。
     * 
     * @return kokuhoKojinNo
     */
    @CheckForNull
    public RString getKokuhoKojinNo() {
        return kokuhoKojinNo;
    }

    /**
     * kokuhoKojinNoのsetメソッドです。
     * 
     * @param kokuhoKojinNo kokuhoKojinNo
     */
    public void setKokuhoKojinNo(RString kokuhoKojinNo) {
        this.kokuhoKojinNo = kokuhoKojinNo;
    }

    /**
     * kyotakuServiceSakuseiKubunCodeのgetメソッドです。
     * 
     * @return kyotakuServiceSakuseiKubunCode
     */
    @CheckForNull
    public RString getKyotakuServiceSakuseiKubunCode() {
        return kyotakuServiceSakuseiKubunCode;
    }

    /**
     * kyotakuServiceSakuseiKubunCodeのsetメソッドです。
     * 
     * @param kyotakuServiceSakuseiKubunCode kyotakuServiceSakuseiKubunCode
     */
    public void setKyotakuServiceSakuseiKubunCode(RString kyotakuServiceSakuseiKubunCode) {
        this.kyotakuServiceSakuseiKubunCode = kyotakuServiceSakuseiKubunCode;
    }

    /**
     * kyotakuKaigoShienJigyoshoNoのgetメソッドです。
     * 
     * @return kyotakuKaigoShienJigyoshoNo
     */
    @CheckForNull
    public JigyoshaNo getKyotakuKaigoShienJigyoshoNo() {
        return kyotakuKaigoShienJigyoshoNo;
    }

    /**
     * kyotakuKaigoShienJigyoshoNoのsetメソッドです。
     * 
     * @param kyotakuKaigoShienJigyoshoNo kyotakuKaigoShienJigyoshoNo
     */
    public void setKyotakuKaigoShienJigyoshoNo(JigyoshaNo kyotakuKaigoShienJigyoshoNo) {
        this.kyotakuKaigoShienJigyoshoNo = kyotakuKaigoShienJigyoshoNo;
    }

    /**
     * kaishiYMDのgetメソッドです。
     * 
     * @return kaishiYMD
     */
    @CheckForNull
    public FlexibleDate getKaishiYMD() {
        return kaishiYMD;
    }

    /**
     * kaishiYMDのsetメソッドです。
     * 
     * @param kaishiYMD kaishiYMD
     */
    public void setKaishiYMD(FlexibleDate kaishiYMD) {
        this.kaishiYMD = kaishiYMD;
    }

    /**
     * chushiYMDのgetメソッドです。
     * 
     * @return chushiYMD
     */
    @CheckForNull
    public FlexibleDate getChushiYMD() {
        return chushiYMD;
    }

    /**
     * chushiYMDのsetメソッドです。
     * 
     * @param chushiYMD chushiYMD
     */
    public void setChushiYMD(FlexibleDate chushiYMD) {
        this.chushiYMD = chushiYMD;
    }

    /**
     * chushiRiyuNyushomaeJyokyoCodeのgetメソッドです。
     * 
     * @return chushiRiyuNyushomaeJyokyoCode
     */
    @CheckForNull
    public RString getChushiRiyuNyushomaeJyokyoCode() {
        return chushiRiyuNyushomaeJyokyoCode;
    }

    /**
     * chushiRiyuNyushomaeJyokyoCodeのsetメソッドです。
     * 
     * @param chushiRiyuNyushomaeJyokyoCode chushiRiyuNyushomaeJyokyoCode
     */
    public void setChushiRiyuNyushomaeJyokyoCode(RString chushiRiyuNyushomaeJyokyoCode) {
        this.chushiRiyuNyushomaeJyokyoCode = chushiRiyuNyushomaeJyokyoCode;
    }

    /**
     * nyushoYMDのgetメソッドです。
     * 
     * @return nyushoYMD
     */
    @CheckForNull
    public FlexibleDate getNyushoYMD() {
        return nyushoYMD;
    }

    /**
     * nyushoYMDのsetメソッドです。
     * 
     * @param nyushoYMD nyushoYMD
     */
    public void setNyushoYMD(FlexibleDate nyushoYMD) {
        this.nyushoYMD = nyushoYMD;
    }

    /**
     * taishoYMDのgetメソッドです。
     * 
     * @return taishoYMD
     */
    @CheckForNull
    public FlexibleDate getTaishoYMD() {
        return taishoYMD;
    }

    /**
     * taishoYMDのsetメソッドです。
     * 
     * @param taishoYMD taishoYMD
     */
    public void setTaishoYMD(FlexibleDate taishoYMD) {
        this.taishoYMD = taishoYMD;
    }

    /**
     * nyushoJitsunissuのgetメソッドです。
     * 
     * @return nyushoJitsunissu
     */
    @CheckForNull
    public int getNyushoJitsunissu() {
        return nyushoJitsunissu;
    }

    /**
     * nyushoJitsunissuのsetメソッドです。
     * 
     * @param nyushoJitsunissu nyushoJitsunissu
     */
    public void setNyushoJitsunissu(int nyushoJitsunissu) {
        this.nyushoJitsunissu = nyushoJitsunissu;
    }

    /**
     * gaihakuNissuのgetメソッドです。
     * 
     * @return gaihakuNissu
     */
    @CheckForNull
    public int getGaihakuNissu() {
        return gaihakuNissu;
    }

    /**
     * gaihakuNissuのsetメソッドです。
     * 
     * @param gaihakuNissu gaihakuNissu
     */
    public void setGaihakuNissu(int gaihakuNissu) {
        this.gaihakuNissu = gaihakuNissu;
    }

    /**
     * taishogoJotaiCodeのgetメソッドです。
     * 
     * @return taishogoJotaiCode
     */
    @CheckForNull
    public RString getTaishogoJotaiCode() {
        return taishogoJotaiCode;
    }

    /**
     * taishogoJotaiCodeのsetメソッドです。
     * 
     * @param taishogoJotaiCode taishogoJotaiCode
     */
    public void setTaishogoJotaiCode(RString taishogoJotaiCode) {
        this.taishogoJotaiCode = taishogoJotaiCode;
    }

    /**
     * hokenKyufuritsuのgetメソッドです。
     * 
     * @return hokenKyufuritsu
     */
    @CheckForNull
    public HokenKyufuRitsu getHokenKyufuritsu() {
        return hokenKyufuritsu;
    }

    /**
     * hokenKyufuritsuのsetメソッドです。
     * 
     * @param hokenKyufuritsu hokenKyufuritsu
     */
    public void setHokenKyufuritsu(HokenKyufuRitsu hokenKyufuritsu) {
        this.hokenKyufuritsu = hokenKyufuritsu;
    }

    /**
     * kohi1Kyufuritsuのgetメソッドです。
     * 
     * @return kohi1Kyufuritsu
     */
    @CheckForNull
    public HokenKyufuRitsu getKohi1Kyufuritsu() {
        return kohi1Kyufuritsu;
    }

    /**
     * kohi1Kyufuritsuのsetメソッドです。
     * 
     * @param kohi1Kyufuritsu kohi1Kyufuritsu
     */
    public void setKohi1Kyufuritsu(HokenKyufuRitsu kohi1Kyufuritsu) {
        this.kohi1Kyufuritsu = kohi1Kyufuritsu;
    }

    /**
     * kohi2Kyufuritsuのgetメソッドです。
     * 
     * @return kohi2Kyufuritsu
     */
    @CheckForNull
    public HokenKyufuRitsu getKohi2Kyufuritsu() {
        return kohi2Kyufuritsu;
    }

    /**
     * kohi2Kyufuritsuのsetメソッドです。
     * 
     * @param kohi2Kyufuritsu kohi2Kyufuritsu
     */
    public void setKohi2Kyufuritsu(HokenKyufuRitsu kohi2Kyufuritsu) {
        this.kohi2Kyufuritsu = kohi2Kyufuritsu;
    }

    /**
     * kohi3Kyufuritsuのgetメソッドです。
     * 
     * @return kohi3Kyufuritsu
     */
    @CheckForNull
    public HokenKyufuRitsu getKohi3Kyufuritsu() {
        return kohi3Kyufuritsu;
    }

    /**
     * kohi3Kyufuritsuのsetメソッドです。
     * 
     * @param kohi3Kyufuritsu kohi3Kyufuritsu
     */
    public void setKohi3Kyufuritsu(HokenKyufuRitsu kohi3Kyufuritsu) {
        this.kohi3Kyufuritsu = kohi3Kyufuritsu;
    }

    /**
     * maeHokenServiceTanisuのgetメソッドです。
     * 
     * @return maeHokenServiceTanisu
     */
    @CheckForNull
    public int getMaeHokenServiceTanisu() {
        return maeHokenServiceTanisu;
    }

    /**
     * maeHokenServiceTanisuのsetメソッドです。
     * 
     * @param maeHokenServiceTanisu maeHokenServiceTanisu
     */
    public void setMaeHokenServiceTanisu(int maeHokenServiceTanisu) {
        this.maeHokenServiceTanisu = maeHokenServiceTanisu;
    }

    /**
     * maeHokenSeikyugakuのgetメソッドです。
     * 
     * @return maeHokenSeikyugaku
     */
    @CheckForNull
    public Decimal getMaeHokenSeikyugaku() {
        return maeHokenSeikyugaku;
    }

    /**
     * maeHokenSeikyugakuのsetメソッドです。
     * 
     * @param maeHokenSeikyugaku maeHokenSeikyugaku
     */
    public void setMaeHokenSeikyugaku(Decimal maeHokenSeikyugaku) {
        this.maeHokenSeikyugaku = maeHokenSeikyugaku;
    }

    /**
     * maeHokenRiyoshaFutangakuのgetメソッドです。
     * 
     * @return maeHokenRiyoshaFutangaku
     */
    @CheckForNull
    public int getMaeHokenRiyoshaFutangaku() {
        return maeHokenRiyoshaFutangaku;
    }

    /**
     * maeHokenRiyoshaFutangakuのsetメソッドです。
     * 
     * @param maeHokenRiyoshaFutangaku maeHokenRiyoshaFutangaku
     */
    public void setMaeHokenRiyoshaFutangaku(int maeHokenRiyoshaFutangaku) {
        this.maeHokenRiyoshaFutangaku = maeHokenRiyoshaFutangaku;
    }

    /**
     * maeHokenKinkyuShisetsuRyoyoSeikyugakuのgetメソッドです。
     * 
     * @return maeHokenKinkyuShisetsuRyoyoSeikyugaku
     */
    @CheckForNull
    public Decimal getMaeHokenKinkyuShisetsuRyoyoSeikyugaku() {
        return maeHokenKinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * maeHokenKinkyuShisetsuRyoyoSeikyugakuのsetメソッドです。
     * 
     * @param maeHokenKinkyuShisetsuRyoyoSeikyugaku maeHokenKinkyuShisetsuRyoyoSeikyugaku
     */
    public void setMaeHokenKinkyuShisetsuRyoyoSeikyugaku(Decimal maeHokenKinkyuShisetsuRyoyoSeikyugaku) {
        this.maeHokenKinkyuShisetsuRyoyoSeikyugaku = maeHokenKinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * maeHokenTokuteiShinryohiSeikyugakuのgetメソッドです。
     * 
     * @return maeHokenTokuteiShinryohiSeikyugaku
     */
    @CheckForNull
    public Decimal getMaeHokenTokuteiShinryohiSeikyugaku() {
        return maeHokenTokuteiShinryohiSeikyugaku;
    }

    /**
     * maeHokenTokuteiShinryohiSeikyugakuのsetメソッドです。
     * 
     * @param maeHokenTokuteiShinryohiSeikyugaku maeHokenTokuteiShinryohiSeikyugaku
     */
    public void setMaeHokenTokuteiShinryohiSeikyugaku(Decimal maeHokenTokuteiShinryohiSeikyugaku) {
        this.maeHokenTokuteiShinryohiSeikyugaku = maeHokenTokuteiShinryohiSeikyugaku;
    }

    /**
     * maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugakuのgetメソッドです。
     * 
     * @return maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    @CheckForNull
    public int getMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugakuのsetメソッドです。
     * 
     * @param maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public void setMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(int maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku = maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * maeKohi1ServiceTanisuのgetメソッドです。
     * 
     * @return maeKohi1ServiceTanisu
     */
    @CheckForNull
    public int getMaeKohi1ServiceTanisu() {
        return maeKohi1ServiceTanisu;
    }

    /**
     * maeKohi1ServiceTanisuのsetメソッドです。
     * 
     * @param maeKohi1ServiceTanisu maeKohi1ServiceTanisu
     */
    public void setMaeKohi1ServiceTanisu(int maeKohi1ServiceTanisu) {
        this.maeKohi1ServiceTanisu = maeKohi1ServiceTanisu;
    }

    /**
     * maeKohi1Seikyugakuのgetメソッドです。
     * 
     * @return maeKohi1Seikyugaku
     */
    @CheckForNull
    public int getMaeKohi1Seikyugaku() {
        return maeKohi1Seikyugaku;
    }

    /**
     * maeKohi1Seikyugakuのsetメソッドです。
     * 
     * @param maeKohi1Seikyugaku maeKohi1Seikyugaku
     */
    public void setMaeKohi1Seikyugaku(int maeKohi1Seikyugaku) {
        this.maeKohi1Seikyugaku = maeKohi1Seikyugaku;
    }

    /**
     * maeKohi1RiyoshaFutangakuのgetメソッドです。
     * 
     * @return maeKohi1RiyoshaFutangaku
     */
    @CheckForNull
    public int getMaeKohi1RiyoshaFutangaku() {
        return maeKohi1RiyoshaFutangaku;
    }

    /**
     * maeKohi1RiyoshaFutangakuのsetメソッドです。
     * 
     * @param maeKohi1RiyoshaFutangaku maeKohi1RiyoshaFutangaku
     */
    public void setMaeKohi1RiyoshaFutangaku(int maeKohi1RiyoshaFutangaku) {
        this.maeKohi1RiyoshaFutangaku = maeKohi1RiyoshaFutangaku;
    }

    /**
     * maeKohi1KinkyuShisetsuRyoyoSeikyugakuのgetメソッドです。
     * 
     * @return maeKohi1KinkyuShisetsuRyoyoSeikyugaku
     */
    @CheckForNull
    public int getMaeKohi1KinkyuShisetsuRyoyoSeikyugaku() {
        return maeKohi1KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * maeKohi1KinkyuShisetsuRyoyoSeikyugakuのsetメソッドです。
     * 
     * @param maeKohi1KinkyuShisetsuRyoyoSeikyugaku maeKohi1KinkyuShisetsuRyoyoSeikyugaku
     */
    public void setMaeKohi1KinkyuShisetsuRyoyoSeikyugaku(int maeKohi1KinkyuShisetsuRyoyoSeikyugaku) {
        this.maeKohi1KinkyuShisetsuRyoyoSeikyugaku = maeKohi1KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * maeKohi1TokuteiShinryohiSeikyugakuのgetメソッドです。
     * 
     * @return maeKohi1TokuteiShinryohiSeikyugaku
     */
    @CheckForNull
    public int getMaeKohi1TokuteiShinryohiSeikyugaku() {
        return maeKohi1TokuteiShinryohiSeikyugaku;
    }

    /**
     * maeKohi1TokuteiShinryohiSeikyugakuのsetメソッドです。
     * 
     * @param maeKohi1TokuteiShinryohiSeikyugaku maeKohi1TokuteiShinryohiSeikyugaku
     */
    public void setMaeKohi1TokuteiShinryohiSeikyugaku(int maeKohi1TokuteiShinryohiSeikyugaku) {
        this.maeKohi1TokuteiShinryohiSeikyugaku = maeKohi1TokuteiShinryohiSeikyugaku;
    }

    /**
     * maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugakuのgetメソッドです。
     * 
     * @return maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    @CheckForNull
    public int getMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugakuのsetメソッドです。
     * 
     * @param maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public void setMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(int maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku = maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * maeKohi2ServiceTanisuのgetメソッドです。
     * 
     * @return maeKohi2ServiceTanisu
     */
    @CheckForNull
    public int getMaeKohi2ServiceTanisu() {
        return maeKohi2ServiceTanisu;
    }

    /**
     * maeKohi2ServiceTanisuのsetメソッドです。
     * 
     * @param maeKohi2ServiceTanisu maeKohi2ServiceTanisu
     */
    public void setMaeKohi2ServiceTanisu(int maeKohi2ServiceTanisu) {
        this.maeKohi2ServiceTanisu = maeKohi2ServiceTanisu;
    }

    /**
     * maeKohi2Seikyugakuのgetメソッドです。
     * 
     * @return maeKohi2Seikyugaku
     */
    @CheckForNull
    public int getMaeKohi2Seikyugaku() {
        return maeKohi2Seikyugaku;
    }

    /**
     * maeKohi2Seikyugakuのsetメソッドです。
     * 
     * @param maeKohi2Seikyugaku maeKohi2Seikyugaku
     */
    public void setMaeKohi2Seikyugaku(int maeKohi2Seikyugaku) {
        this.maeKohi2Seikyugaku = maeKohi2Seikyugaku;
    }

    /**
     * maeKohi2RiyoshaFutangakuのgetメソッドです。
     * 
     * @return maeKohi2RiyoshaFutangaku
     */
    @CheckForNull
    public int getMaeKohi2RiyoshaFutangaku() {
        return maeKohi2RiyoshaFutangaku;
    }

    /**
     * maeKohi2RiyoshaFutangakuのsetメソッドです。
     * 
     * @param maeKohi2RiyoshaFutangaku maeKohi2RiyoshaFutangaku
     */
    public void setMaeKohi2RiyoshaFutangaku(int maeKohi2RiyoshaFutangaku) {
        this.maeKohi2RiyoshaFutangaku = maeKohi2RiyoshaFutangaku;
    }

    /**
     * maeKohi2KinkyuShisetsuRyoyoSeikyugakuのgetメソッドです。
     * 
     * @return maeKohi2KinkyuShisetsuRyoyoSeikyugaku
     */
    @CheckForNull
    public int getMaeKohi2KinkyuShisetsuRyoyoSeikyugaku() {
        return maeKohi2KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * maeKohi2KinkyuShisetsuRyoyoSeikyugakuのsetメソッドです。
     * 
     * @param maeKohi2KinkyuShisetsuRyoyoSeikyugaku maeKohi2KinkyuShisetsuRyoyoSeikyugaku
     */
    public void setMaeKohi2KinkyuShisetsuRyoyoSeikyugaku(int maeKohi2KinkyuShisetsuRyoyoSeikyugaku) {
        this.maeKohi2KinkyuShisetsuRyoyoSeikyugaku = maeKohi2KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * maeKohi2TokuteiShinryohiSeikyugakuのgetメソッドです。
     * 
     * @return maeKohi2TokuteiShinryohiSeikyugaku
     */
    @CheckForNull
    public int getMaeKohi2TokuteiShinryohiSeikyugaku() {
        return maeKohi2TokuteiShinryohiSeikyugaku;
    }

    /**
     * maeKohi2TokuteiShinryohiSeikyugakuのsetメソッドです。
     * 
     * @param maeKohi2TokuteiShinryohiSeikyugaku maeKohi2TokuteiShinryohiSeikyugaku
     */
    public void setMaeKohi2TokuteiShinryohiSeikyugaku(int maeKohi2TokuteiShinryohiSeikyugaku) {
        this.maeKohi2TokuteiShinryohiSeikyugaku = maeKohi2TokuteiShinryohiSeikyugaku;
    }

    /**
     * maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugakuのgetメソッドです。
     * 
     * @return maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    @CheckForNull
    public int getMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugakuのsetメソッドです。
     * 
     * @param maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public void setMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(int maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku = maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * maeKohi3ServiceTanisuのgetメソッドです。
     * 
     * @return maeKohi3ServiceTanisu
     */
    @CheckForNull
    public int getMaeKohi3ServiceTanisu() {
        return maeKohi3ServiceTanisu;
    }

    /**
     * maeKohi3ServiceTanisuのsetメソッドです。
     * 
     * @param maeKohi3ServiceTanisu maeKohi3ServiceTanisu
     */
    public void setMaeKohi3ServiceTanisu(int maeKohi3ServiceTanisu) {
        this.maeKohi3ServiceTanisu = maeKohi3ServiceTanisu;
    }

    /**
     * maeKohi3Seikyugakuのgetメソッドです。
     * 
     * @return maeKohi3Seikyugaku
     */
    @CheckForNull
    public int getMaeKohi3Seikyugaku() {
        return maeKohi3Seikyugaku;
    }

    /**
     * maeKohi3Seikyugakuのsetメソッドです。
     * 
     * @param maeKohi3Seikyugaku maeKohi3Seikyugaku
     */
    public void setMaeKohi3Seikyugaku(int maeKohi3Seikyugaku) {
        this.maeKohi3Seikyugaku = maeKohi3Seikyugaku;
    }

    /**
     * maeKohi3RiyoshaFutangakuのgetメソッドです。
     * 
     * @return maeKohi3RiyoshaFutangaku
     */
    @CheckForNull
    public int getMaeKohi3RiyoshaFutangaku() {
        return maeKohi3RiyoshaFutangaku;
    }

    /**
     * maeKohi3RiyoshaFutangakuのsetメソッドです。
     * 
     * @param maeKohi3RiyoshaFutangaku maeKohi3RiyoshaFutangaku
     */
    public void setMaeKohi3RiyoshaFutangaku(int maeKohi3RiyoshaFutangaku) {
        this.maeKohi3RiyoshaFutangaku = maeKohi3RiyoshaFutangaku;
    }

    /**
     * maeKohi3KinkyuShisetsuRyoyoSeikyugakuのgetメソッドです。
     * 
     * @return maeKohi3KinkyuShisetsuRyoyoSeikyugaku
     */
    @CheckForNull
    public int getMaeKohi3KinkyuShisetsuRyoyoSeikyugaku() {
        return maeKohi3KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * maeKohi3KinkyuShisetsuRyoyoSeikyugakuのsetメソッドです。
     * 
     * @param maeKohi3KinkyuShisetsuRyoyoSeikyugaku maeKohi3KinkyuShisetsuRyoyoSeikyugaku
     */
    public void setMaeKohi3KinkyuShisetsuRyoyoSeikyugaku(int maeKohi3KinkyuShisetsuRyoyoSeikyugaku) {
        this.maeKohi3KinkyuShisetsuRyoyoSeikyugaku = maeKohi3KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * maeKohi3TokuteiShinryohiSeikyugakuのgetメソッドです。
     * 
     * @return maeKohi3TokuteiShinryohiSeikyugaku
     */
    @CheckForNull
    public int getMaeKohi3TokuteiShinryohiSeikyugaku() {
        return maeKohi3TokuteiShinryohiSeikyugaku;
    }

    /**
     * maeKohi3TokuteiShinryohiSeikyugakuのsetメソッドです。
     * 
     * @param maeKohi3TokuteiShinryohiSeikyugaku maeKohi3TokuteiShinryohiSeikyugaku
     */
    public void setMaeKohi3TokuteiShinryohiSeikyugaku(int maeKohi3TokuteiShinryohiSeikyugaku) {
        this.maeKohi3TokuteiShinryohiSeikyugaku = maeKohi3TokuteiShinryohiSeikyugaku;
    }

    /**
     * maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugakuのgetメソッドです。
     * 
     * @return maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    @CheckForNull
    public int getMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugakuのsetメソッドです。
     * 
     * @param maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public void setMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(int maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku = maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * atoHokenServiceTanisuのgetメソッドです。
     * 
     * @return atoHokenServiceTanisu
     */
    @CheckForNull
    public int getAtoHokenServiceTanisu() {
        return atoHokenServiceTanisu;
    }

    /**
     * atoHokenServiceTanisuのsetメソッドです。
     * 
     * @param atoHokenServiceTanisu atoHokenServiceTanisu
     */
    public void setAtoHokenServiceTanisu(int atoHokenServiceTanisu) {
        this.atoHokenServiceTanisu = atoHokenServiceTanisu;
    }

    /**
     * atoHokenSeikyugakuのgetメソッドです。
     * 
     * @return atoHokenSeikyugaku
     */
    @CheckForNull
    public Decimal getAtoHokenSeikyugaku() {
        return atoHokenSeikyugaku;
    }

    /**
     * atoHokenSeikyugakuのsetメソッドです。
     * 
     * @param atoHokenSeikyugaku atoHokenSeikyugaku
     */
    public void setAtoHokenSeikyugaku(Decimal atoHokenSeikyugaku) {
        this.atoHokenSeikyugaku = atoHokenSeikyugaku;
    }

    /**
     * atoHokenRiyoshaFutangakuのgetメソッドです。
     * 
     * @return atoHokenRiyoshaFutangaku
     */
    @CheckForNull
    public int getAtoHokenRiyoshaFutangaku() {
        return atoHokenRiyoshaFutangaku;
    }

    /**
     * atoHokenRiyoshaFutangakuのsetメソッドです。
     * 
     * @param atoHokenRiyoshaFutangaku atoHokenRiyoshaFutangaku
     */
    public void setAtoHokenRiyoshaFutangaku(int atoHokenRiyoshaFutangaku) {
        this.atoHokenRiyoshaFutangaku = atoHokenRiyoshaFutangaku;
    }

    /**
     * atoHokenKinkyuShisetsuRyoyoSeikyugakuのgetメソッドです。
     * 
     * @return atoHokenKinkyuShisetsuRyoyoSeikyugaku
     */
    @CheckForNull
    public Decimal getAtoHokenKinkyuShisetsuRyoyoSeikyugaku() {
        return atoHokenKinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * atoHokenKinkyuShisetsuRyoyoSeikyugakuのsetメソッドです。
     * 
     * @param atoHokenKinkyuShisetsuRyoyoSeikyugaku atoHokenKinkyuShisetsuRyoyoSeikyugaku
     */
    public void setAtoHokenKinkyuShisetsuRyoyoSeikyugaku(Decimal atoHokenKinkyuShisetsuRyoyoSeikyugaku) {
        this.atoHokenKinkyuShisetsuRyoyoSeikyugaku = atoHokenKinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * atoHokenTokuteiShinryohiSeikyugakuのgetメソッドです。
     * 
     * @return atoHokenTokuteiShinryohiSeikyugaku
     */
    @CheckForNull
    public Decimal getAtoHokenTokuteiShinryohiSeikyugaku() {
        return atoHokenTokuteiShinryohiSeikyugaku;
    }

    /**
     * atoHokenTokuteiShinryohiSeikyugakuのsetメソッドです。
     * 
     * @param atoHokenTokuteiShinryohiSeikyugaku atoHokenTokuteiShinryohiSeikyugaku
     */
    public void setAtoHokenTokuteiShinryohiSeikyugaku(Decimal atoHokenTokuteiShinryohiSeikyugaku) {
        this.atoHokenTokuteiShinryohiSeikyugaku = atoHokenTokuteiShinryohiSeikyugaku;
    }

    /**
     * atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugakuのgetメソッドです。
     * 
     * @return atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    @CheckForNull
    public int getAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugakuのsetメソッドです。
     * 
     * @param atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public void setAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(int atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku = atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * atoKohi1ServiceTanisuのgetメソッドです。
     * 
     * @return atoKohi1ServiceTanisu
     */
    @CheckForNull
    public int getAtoKohi1ServiceTanisu() {
        return atoKohi1ServiceTanisu;
    }

    /**
     * atoKohi1ServiceTanisuのsetメソッドです。
     * 
     * @param atoKohi1ServiceTanisu atoKohi1ServiceTanisu
     */
    public void setAtoKohi1ServiceTanisu(int atoKohi1ServiceTanisu) {
        this.atoKohi1ServiceTanisu = atoKohi1ServiceTanisu;
    }

    /**
     * atoKohi1Seikyugakuのgetメソッドです。
     * 
     * @return atoKohi1Seikyugaku
     */
    @CheckForNull
    public int getAtoKohi1Seikyugaku() {
        return atoKohi1Seikyugaku;
    }

    /**
     * atoKohi1Seikyugakuのsetメソッドです。
     * 
     * @param atoKohi1Seikyugaku atoKohi1Seikyugaku
     */
    public void setAtoKohi1Seikyugaku(int atoKohi1Seikyugaku) {
        this.atoKohi1Seikyugaku = atoKohi1Seikyugaku;
    }

    /**
     * atoKohi1RiyoshaFutangakuのgetメソッドです。
     * 
     * @return atoKohi1RiyoshaFutangaku
     */
    @CheckForNull
    public int getAtoKohi1RiyoshaFutangaku() {
        return atoKohi1RiyoshaFutangaku;
    }

    /**
     * atoKohi1RiyoshaFutangakuのsetメソッドです。
     * 
     * @param atoKohi1RiyoshaFutangaku atoKohi1RiyoshaFutangaku
     */
    public void setAtoKohi1RiyoshaFutangaku(int atoKohi1RiyoshaFutangaku) {
        this.atoKohi1RiyoshaFutangaku = atoKohi1RiyoshaFutangaku;
    }

    /**
     * atoKohi1KinkyuShisetsuRyoyoSeikyugakuのgetメソッドです。
     * 
     * @return atoKohi1KinkyuShisetsuRyoyoSeikyugaku
     */
    @CheckForNull
    public int getAtoKohi1KinkyuShisetsuRyoyoSeikyugaku() {
        return atoKohi1KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * atoKohi1KinkyuShisetsuRyoyoSeikyugakuのsetメソッドです。
     * 
     * @param atoKohi1KinkyuShisetsuRyoyoSeikyugaku atoKohi1KinkyuShisetsuRyoyoSeikyugaku
     */
    public void setAtoKohi1KinkyuShisetsuRyoyoSeikyugaku(int atoKohi1KinkyuShisetsuRyoyoSeikyugaku) {
        this.atoKohi1KinkyuShisetsuRyoyoSeikyugaku = atoKohi1KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * atoKohi1TokuteiShinryohiSeikyugakuのgetメソッドです。
     * 
     * @return atoKohi1TokuteiShinryohiSeikyugaku
     */
    @CheckForNull
    public int getAtoKohi1TokuteiShinryohiSeikyugaku() {
        return atoKohi1TokuteiShinryohiSeikyugaku;
    }

    /**
     * atoKohi1TokuteiShinryohiSeikyugakuのsetメソッドです。
     * 
     * @param atoKohi1TokuteiShinryohiSeikyugaku atoKohi1TokuteiShinryohiSeikyugaku
     */
    public void setAtoKohi1TokuteiShinryohiSeikyugaku(int atoKohi1TokuteiShinryohiSeikyugaku) {
        this.atoKohi1TokuteiShinryohiSeikyugaku = atoKohi1TokuteiShinryohiSeikyugaku;
    }

    /**
     * atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugakuのgetメソッドです。
     * 
     * @return atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    @CheckForNull
    public int getAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugakuのsetメソッドです。
     * 
     * @param atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public void setAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(int atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku = atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * atoKohi2ServiceTanisuのgetメソッドです。
     * 
     * @return atoKohi2ServiceTanisu
     */
    @CheckForNull
    public int getAtoKohi2ServiceTanisu() {
        return atoKohi2ServiceTanisu;
    }

    /**
     * atoKohi2ServiceTanisuのsetメソッドです。
     * 
     * @param atoKohi2ServiceTanisu atoKohi2ServiceTanisu
     */
    public void setAtoKohi2ServiceTanisu(int atoKohi2ServiceTanisu) {
        this.atoKohi2ServiceTanisu = atoKohi2ServiceTanisu;
    }

    /**
     * atoKohi2Seikyugakuのgetメソッドです。
     * 
     * @return atoKohi2Seikyugaku
     */
    @CheckForNull
    public int getAtoKohi2Seikyugaku() {
        return atoKohi2Seikyugaku;
    }

    /**
     * atoKohi2Seikyugakuのsetメソッドです。
     * 
     * @param atoKohi2Seikyugaku atoKohi2Seikyugaku
     */
    public void setAtoKohi2Seikyugaku(int atoKohi2Seikyugaku) {
        this.atoKohi2Seikyugaku = atoKohi2Seikyugaku;
    }

    /**
     * atoKohi2RiyoshaFutangakuのgetメソッドです。
     * 
     * @return atoKohi2RiyoshaFutangaku
     */
    @CheckForNull
    public int getAtoKohi2RiyoshaFutangaku() {
        return atoKohi2RiyoshaFutangaku;
    }

    /**
     * atoKohi2RiyoshaFutangakuのsetメソッドです。
     * 
     * @param atoKohi2RiyoshaFutangaku atoKohi2RiyoshaFutangaku
     */
    public void setAtoKohi2RiyoshaFutangaku(int atoKohi2RiyoshaFutangaku) {
        this.atoKohi2RiyoshaFutangaku = atoKohi2RiyoshaFutangaku;
    }

    /**
     * atoKohi2KinkyuShisetsuRyoyoSeikyugakuのgetメソッドです。
     * 
     * @return atoKohi2KinkyuShisetsuRyoyoSeikyugaku
     */
    @CheckForNull
    public int getAtoKohi2KinkyuShisetsuRyoyoSeikyugaku() {
        return atoKohi2KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * atoKohi2KinkyuShisetsuRyoyoSeikyugakuのsetメソッドです。
     * 
     * @param atoKohi2KinkyuShisetsuRyoyoSeikyugaku atoKohi2KinkyuShisetsuRyoyoSeikyugaku
     */
    public void setAtoKohi2KinkyuShisetsuRyoyoSeikyugaku(int atoKohi2KinkyuShisetsuRyoyoSeikyugaku) {
        this.atoKohi2KinkyuShisetsuRyoyoSeikyugaku = atoKohi2KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * atoKohi2TokuteiShinryohiSeikyugakuのgetメソッドです。
     * 
     * @return atoKohi2TokuteiShinryohiSeikyugaku
     */
    @CheckForNull
    public int getAtoKohi2TokuteiShinryohiSeikyugaku() {
        return atoKohi2TokuteiShinryohiSeikyugaku;
    }

    /**
     * atoKohi2TokuteiShinryohiSeikyugakuのsetメソッドです。
     * 
     * @param atoKohi2TokuteiShinryohiSeikyugaku atoKohi2TokuteiShinryohiSeikyugaku
     */
    public void setAtoKohi2TokuteiShinryohiSeikyugaku(int atoKohi2TokuteiShinryohiSeikyugaku) {
        this.atoKohi2TokuteiShinryohiSeikyugaku = atoKohi2TokuteiShinryohiSeikyugaku;
    }

    /**
     * atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugakuのgetメソッドです。
     * 
     * @return atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    @CheckForNull
    public int getAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugakuのsetメソッドです。
     * 
     * @param atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public void setAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(int atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku = atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * atoKohi3ServiceTanisuのgetメソッドです。
     * 
     * @return atoKohi3ServiceTanisu
     */
    @CheckForNull
    public int getAtoKohi3ServiceTanisu() {
        return atoKohi3ServiceTanisu;
    }

    /**
     * atoKohi3ServiceTanisuのsetメソッドです。
     * 
     * @param atoKohi3ServiceTanisu atoKohi3ServiceTanisu
     */
    public void setAtoKohi3ServiceTanisu(int atoKohi3ServiceTanisu) {
        this.atoKohi3ServiceTanisu = atoKohi3ServiceTanisu;
    }

    /**
     * atoKohi3Seikyugakuのgetメソッドです。
     * 
     * @return atoKohi3Seikyugaku
     */
    @CheckForNull
    public int getAtoKohi3Seikyugaku() {
        return atoKohi3Seikyugaku;
    }

    /**
     * atoKohi3Seikyugakuのsetメソッドです。
     * 
     * @param atoKohi3Seikyugaku atoKohi3Seikyugaku
     */
    public void setAtoKohi3Seikyugaku(int atoKohi3Seikyugaku) {
        this.atoKohi3Seikyugaku = atoKohi3Seikyugaku;
    }

    /**
     * atoKohi3RiyoshaFutangakuのgetメソッドです。
     * 
     * @return atoKohi3RiyoshaFutangaku
     */
    @CheckForNull
    public int getAtoKohi3RiyoshaFutangaku() {
        return atoKohi3RiyoshaFutangaku;
    }

    /**
     * atoKohi3RiyoshaFutangakuのsetメソッドです。
     * 
     * @param atoKohi3RiyoshaFutangaku atoKohi3RiyoshaFutangaku
     */
    public void setAtoKohi3RiyoshaFutangaku(int atoKohi3RiyoshaFutangaku) {
        this.atoKohi3RiyoshaFutangaku = atoKohi3RiyoshaFutangaku;
    }

    /**
     * atoKohi3KinkyuShisetsuRyoyoSeikyugakuのgetメソッドです。
     * 
     * @return atoKohi3KinkyuShisetsuRyoyoSeikyugaku
     */
    @CheckForNull
    public int getAtoKohi3KinkyuShisetsuRyoyoSeikyugaku() {
        return atoKohi3KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * atoKohi3KinkyuShisetsuRyoyoSeikyugakuのsetメソッドです。
     * 
     * @param atoKohi3KinkyuShisetsuRyoyoSeikyugaku atoKohi3KinkyuShisetsuRyoyoSeikyugaku
     */
    public void setAtoKohi3KinkyuShisetsuRyoyoSeikyugaku(int atoKohi3KinkyuShisetsuRyoyoSeikyugaku) {
        this.atoKohi3KinkyuShisetsuRyoyoSeikyugaku = atoKohi3KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * atoKohi3TokuteiShinryohiSeikyugakuのgetメソッドです。
     * 
     * @return atoKohi3TokuteiShinryohiSeikyugaku
     */
    @CheckForNull
    public int getAtoKohi3TokuteiShinryohiSeikyugaku() {
        return atoKohi3TokuteiShinryohiSeikyugaku;
    }

    /**
     * atoKohi3TokuteiShinryohiSeikyugakuのsetメソッドです。
     * 
     * @param atoKohi3TokuteiShinryohiSeikyugaku atoKohi3TokuteiShinryohiSeikyugaku
     */
    public void setAtoKohi3TokuteiShinryohiSeikyugaku(int atoKohi3TokuteiShinryohiSeikyugaku) {
        this.atoKohi3TokuteiShinryohiSeikyugaku = atoKohi3TokuteiShinryohiSeikyugaku;
    }

    /**
     * atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugakuのgetメソッドです。
     * 
     * @return atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    @CheckForNull
    public int getAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugakuのsetメソッドです。
     * 
     * @param atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    public void setAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(int atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku = atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * keikaiKubunCodeのgetメソッドです。
     * 
     * @return keikaiKubunCode
     */
    @CheckForNull
    public RString getKeikaiKubunCode() {
        return keikaiKubunCode;
    }

    /**
     * keikaiKubunCodeのsetメソッドです。
     * 
     * @param keikaiKubunCode keikaiKubunCode
     */
    public void setKeikaiKubunCode(RString keikaiKubunCode) {
        this.keikaiKubunCode = keikaiKubunCode;
    }

    /**
     * shinsaYMのgetメソッドです。
     * 
     * @return shinsaYM
     */
    @CheckForNull
    public FlexibleYearMonth getShinsaYM() {
        return shinsaYM;
    }

    /**
     * shinsaYMのsetメソッドです。
     * 
     * @param shinsaYM shinsaYM
     */
    public void setShinsaYM(FlexibleYearMonth shinsaYM) {
        this.shinsaYM = shinsaYM;
    }

    /**
     * seiriNoのgetメソッドです。
     * 
     * @return seiriNo
     */
    @CheckForNull
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * seiriNoのsetメソッドです。
     * 
     * @param seiriNo seiriNo
     */
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
    }

    /**
     * sofuYMのgetメソッドです。
     * 
     * @return sofuYM
     */
    @CheckForNull
    public FlexibleYearMonth getSofuYM() {
        return sofuYM;
    }

    /**
     * sofuYMのsetメソッドです。
     * 
     * @param sofuYM sofuYM
     */
    public void setSofuYM(FlexibleYearMonth sofuYM) {
        this.sofuYM = sofuYM;
    }

    /**
     * torikomiYMのgetメソッドです。
     * 
     * @return torikomiYM
     */
    @CheckForNull
    public FlexibleYearMonth getTorikomiYM() {
        return torikomiYM;
    }

    /**
     * torikomiYMのsetメソッドです。
     * 
     * @param torikomiYM torikomiYM
     */
    public void setTorikomiYM(FlexibleYearMonth torikomiYM) {
        this.torikomiYM = torikomiYM;
    }

    /**
     * dokujiSakuseiKubunのgetメソッドです。
     * 
     * @return dokujiSakuseiKubun
     */
    @CheckForNull
    public RString getDokujiSakuseiKubun() {
        return dokujiSakuseiKubun;
    }

    /**
     * dokujiSakuseiKubunのsetメソッドです。
     * 
     * @param dokujiSakuseiKubun dokujiSakuseiKubun
     */
    public void setDokujiSakuseiKubun(RString dokujiSakuseiKubun) {
        this.dokujiSakuseiKubun = dokujiSakuseiKubun;
    }

    /**
     * hokenshaHoyuKyufujissekiJohoSakujoFlagのgetメソッドです。
     * 
     * @return hokenshaHoyuKyufujissekiJohoSakujoFlag
     */
    @CheckForNull
    public boolean getHokenshaHoyuKyufujissekiJohoSakujoFlag() {
        return hokenshaHoyuKyufujissekiJohoSakujoFlag;
    }

    /**
     * hokenshaHoyuKyufujissekiJohoSakujoFlagのsetメソッドです。
     * 
     * @param hokenshaHoyuKyufujissekiJohoSakujoFlag hokenshaHoyuKyufujissekiJohoSakujoFlag
     */
    public void setHokenshaHoyuKyufujissekiJohoSakujoFlag(boolean hokenshaHoyuKyufujissekiJohoSakujoFlag) {
        this.hokenshaHoyuKyufujissekiJohoSakujoFlag = hokenshaHoyuKyufujissekiJohoSakujoFlag;
    }

    /**
     * serviceShuruiCodeのgetメソッドです。
     * 
     * @return serviceShuruiCode
     */
    @CheckForNull
    public ServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * serviceShuruiCodeのsetメソッドです。
     * 
     * @param serviceShuruiCode serviceShuruiCode
     */
    public void setServiceShuruiCode(ServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * serviceKomokuCodeのgetメソッドです。
     * 
     * @return serviceKomokuCode
     */
    @CheckForNull
    public ServiceKomokuCode getServiceKomokuCode() {
        return serviceKomokuCode;
    }

    /**
     * serviceKomokuCodeのsetメソッドです。
     * 
     * @param serviceKomokuCode serviceKomokuCode
     */
    public void setServiceKomokuCode(ServiceKomokuCode serviceKomokuCode) {
        this.serviceKomokuCode = serviceKomokuCode;
    }

    /**
     * tanisuのgetメソッドです。
     * 
     * @return tanisu
     */
    @CheckForNull
    public int getTanisu() {
        return tanisu;
    }

    /**
     * tanisuのsetメソッドです。
     * 
     * @param tanisu tanisu
     */
    public void setTanisu(int tanisu) {
        this.tanisu = tanisu;
    }

    /**
     * nissuKaisuのgetメソッドです。
     * 
     * @return nissuKaisu
     */
    @CheckForNull
    public int getNissuKaisu() {
        return nissuKaisu;
    }

    /**
     * nissuKaisuのsetメソッドです。
     * 
     * @param nissuKaisu nissuKaisu
     */
    public void setNissuKaisu(int nissuKaisu) {
        this.nissuKaisu = nissuKaisu;
    }

    /**
     * kohi1TaishoNissuKaisuのgetメソッドです。
     * 
     * @return kohi1TaishoNissuKaisu
     */
    @CheckForNull
    public int getKohi1TaishoNissuKaisu() {
        return kohi1TaishoNissuKaisu;
    }

    /**
     * kohi1TaishoNissuKaisuのsetメソッドです。
     * 
     * @param kohi1TaishoNissuKaisu kohi1TaishoNissuKaisu
     */
    public void setKohi1TaishoNissuKaisu(int kohi1TaishoNissuKaisu) {
        this.kohi1TaishoNissuKaisu = kohi1TaishoNissuKaisu;
    }

    /**
     * kohi2TaishoNissuKaisuのgetメソッドです。
     * 
     * @return kohi2TaishoNissuKaisu
     */
    @CheckForNull
    public int getKohi2TaishoNissuKaisu() {
        return kohi2TaishoNissuKaisu;
    }

    /**
     * kohi2TaishoNissuKaisuのsetメソッドです。
     * 
     * @param kohi2TaishoNissuKaisu kohi2TaishoNissuKaisu
     */
    public void setKohi2TaishoNissuKaisu(int kohi2TaishoNissuKaisu) {
        this.kohi2TaishoNissuKaisu = kohi2TaishoNissuKaisu;
    }

    /**
     * kohi3TaishoNissuKaisuのgetメソッドです。
     * 
     * @return kohi3TaishoNissuKaisu
     */
    @CheckForNull
    public int getKohi3TaishoNissuKaisu() {
        return kohi3TaishoNissuKaisu;
    }

    /**
     * kohi3TaishoNissuKaisuのsetメソッドです。
     * 
     * @param kohi3TaishoNissuKaisu kohi3TaishoNissuKaisu
     */
    public void setKohi3TaishoNissuKaisu(int kohi3TaishoNissuKaisu) {
        this.kohi3TaishoNissuKaisu = kohi3TaishoNissuKaisu;
    }

    /**
     * serviceTanisuのgetメソッドです。
     * 
     * @return serviceTanisu
     */
    @CheckForNull
    public int getServiceTanisu() {
        return serviceTanisu;
    }

    /**
     * serviceTanisuのsetメソッドです。
     * 
     * @param serviceTanisu serviceTanisu
     */
    public void setServiceTanisu(int serviceTanisu) {
        this.serviceTanisu = serviceTanisu;
    }

    /**
     * kohi1TaishoServiceTanisuのgetメソッドです。
     * 
     * @return kohi1TaishoServiceTanisu
     */
    @CheckForNull
    public int getKohi1TaishoServiceTanisu() {
        return kohi1TaishoServiceTanisu;
    }

    /**
     * kohi1TaishoServiceTanisuのsetメソッドです。
     * 
     * @param kohi1TaishoServiceTanisu kohi1TaishoServiceTanisu
     */
    public void setKohi1TaishoServiceTanisu(int kohi1TaishoServiceTanisu) {
        this.kohi1TaishoServiceTanisu = kohi1TaishoServiceTanisu;
    }

    /**
     * kohi2TaishoServiceTanisuのgetメソッドです。
     * 
     * @return kohi2TaishoServiceTanisu
     */
    @CheckForNull
    public int getKohi2TaishoServiceTanisu() {
        return kohi2TaishoServiceTanisu;
    }

    /**
     * kohi2TaishoServiceTanisuのsetメソッドです。
     * 
     * @param kohi2TaishoServiceTanisu kohi2TaishoServiceTanisu
     */
    public void setKohi2TaishoServiceTanisu(int kohi2TaishoServiceTanisu) {
        this.kohi2TaishoServiceTanisu = kohi2TaishoServiceTanisu;
    }

    /**
     * kohi3TaishoServiceTanisuのgetメソッドです。
     * 
     * @return kohi3TaishoServiceTanisu
     */
    @CheckForNull
    public int getKohi3TaishoServiceTanisu() {
        return kohi3TaishoServiceTanisu;
    }

    /**
     * kohi3TaishoServiceTanisuのsetメソッドです。
     * 
     * @param kohi3TaishoServiceTanisu kohi3TaishoServiceTanisu
     */
    public void setKohi3TaishoServiceTanisu(int kohi3TaishoServiceTanisu) {
        this.kohi3TaishoServiceTanisu = kohi3TaishoServiceTanisu;
    }

    /**
     * tekiyoのgetメソッドです。
     * 
     * @return tekiyo
     */
    @CheckForNull
    public RString getTekiyo() {
        return tekiyo;
    }

    /**
     * tekiyoのsetメソッドです。
     * 
     * @param tekiyo tekiyo
     */
    public void setTekiyo(RString tekiyo) {
        this.tekiyo = tekiyo;
    }

    /**
     * atoTanisuのgetメソッドです。
     * 
     * @return atoTanisu
     */
    @CheckForNull
    public int getAtoTanisu() {
        return atoTanisu;
    }

    /**
     * atoTanisuのsetメソッドです。
     * 
     * @param atoTanisu atoTanisu
     */
    public void setAtoTanisu(int atoTanisu) {
        this.atoTanisu = atoTanisu;
    }

    /**
     * atoNissuKaisuのgetメソッドです。
     * 
     * @return atoNissuKaisu
     */
    @CheckForNull
    public int getAtoNissuKaisu() {
        return atoNissuKaisu;
    }

    /**
     * atoNissuKaisuのsetメソッドです。
     * 
     * @param atoNissuKaisu atoNissuKaisu
     */
    public void setAtoNissuKaisu(int atoNissuKaisu) {
        this.atoNissuKaisu = atoNissuKaisu;
    }

    /**
     * atoKohi1TaishoNissuKaisuのgetメソッドです。
     * 
     * @return atoKohi1TaishoNissuKaisu
     */
    @CheckForNull
    public int getAtoKohi1TaishoNissuKaisu() {
        return atoKohi1TaishoNissuKaisu;
    }

    /**
     * atoKohi1TaishoNissuKaisuのsetメソッドです。
     * 
     * @param atoKohi1TaishoNissuKaisu atoKohi1TaishoNissuKaisu
     */
    public void setAtoKohi1TaishoNissuKaisu(int atoKohi1TaishoNissuKaisu) {
        this.atoKohi1TaishoNissuKaisu = atoKohi1TaishoNissuKaisu;
    }

    /**
     * atoKohi2TaishoNissukaisuのgetメソッドです。
     * 
     * @return atoKohi2TaishoNissukaisu
     */
    @CheckForNull
    public int getAtoKohi2TaishoNissukaisu() {
        return atoKohi2TaishoNissukaisu;
    }

    /**
     * atoKohi2TaishoNissukaisuのsetメソッドです。
     * 
     * @param atoKohi2TaishoNissukaisu atoKohi2TaishoNissukaisu
     */
    public void setAtoKohi2TaishoNissukaisu(int atoKohi2TaishoNissukaisu) {
        this.atoKohi2TaishoNissukaisu = atoKohi2TaishoNissukaisu;
    }

    /**
     * atoKohi3TaishoNissuKaisuのgetメソッドです。
     * 
     * @return atoKohi3TaishoNissuKaisu
     */
    @CheckForNull
    public int getAtoKohi3TaishoNissuKaisu() {
        return atoKohi3TaishoNissuKaisu;
    }

    /**
     * atoKohi3TaishoNissuKaisuのsetメソッドです。
     * 
     * @param atoKohi3TaishoNissuKaisu atoKohi3TaishoNissuKaisu
     */
    public void setAtoKohi3TaishoNissuKaisu(int atoKohi3TaishoNissuKaisu) {
        this.atoKohi3TaishoNissuKaisu = atoKohi3TaishoNissuKaisu;
    }

    /**
     * atoServiceTanisuのgetメソッドです。
     * 
     * @return atoServiceTanisu
     */
    @CheckForNull
    public int getAtoServiceTanisu() {
        return atoServiceTanisu;
    }

    /**
     * atoServiceTanisuのsetメソッドです。
     * 
     * @param atoServiceTanisu atoServiceTanisu
     */
    public void setAtoServiceTanisu(int atoServiceTanisu) {
        this.atoServiceTanisu = atoServiceTanisu;
    }

    /**
     * atoKohi1TaishoServiceTanisuのgetメソッドです。
     * 
     * @return atoKohi1TaishoServiceTanisu
     */
    @CheckForNull
    public int getAtoKohi1TaishoServiceTanisu() {
        return atoKohi1TaishoServiceTanisu;
    }

    /**
     * atoKohi1TaishoServiceTanisuのsetメソッドです。
     * 
     * @param atoKohi1TaishoServiceTanisu atoKohi1TaishoServiceTanisu
     */
    public void setAtoKohi1TaishoServiceTanisu(int atoKohi1TaishoServiceTanisu) {
        this.atoKohi1TaishoServiceTanisu = atoKohi1TaishoServiceTanisu;
    }

    /**
     * atoKohi2TaishoServiceTanisuのgetメソッドです。
     * 
     * @return atoKohi2TaishoServiceTanisu
     */
    @CheckForNull
    public int getAtoKohi2TaishoServiceTanisu() {
        return atoKohi2TaishoServiceTanisu;
    }

    /**
     * atoKohi2TaishoServiceTanisuのsetメソッドです。
     * 
     * @param atoKohi2TaishoServiceTanisu atoKohi2TaishoServiceTanisu
     */
    public void setAtoKohi2TaishoServiceTanisu(int atoKohi2TaishoServiceTanisu) {
        this.atoKohi2TaishoServiceTanisu = atoKohi2TaishoServiceTanisu;
    }

    /**
     * atoKohi3TaishoServiceTanisuのgetメソッドです。
     * 
     * @return atoKohi3TaishoServiceTanisu
     */
    @CheckForNull
    public int getAtoKohi3TaishoServiceTanisu() {
        return atoKohi3TaishoServiceTanisu;
    }

    /**
     * atoKohi3TaishoServiceTanisuのsetメソッドです。
     * 
     * @param atoKohi3TaishoServiceTanisu atoKohi3TaishoServiceTanisu
     */
    public void setAtoKohi3TaishoServiceTanisu(int atoKohi3TaishoServiceTanisu) {
        this.atoKohi3TaishoServiceTanisu = atoKohi3TaishoServiceTanisu;
    }

    /**
     * saishinsaKaisuのgetメソッドです。
     * 
     * @return saishinsaKaisu
     */
    @CheckForNull
    public int getSaishinsaKaisu() {
        return saishinsaKaisu;
    }

    /**
     * saishinsaKaisuのsetメソッドです。
     * 
     * @param saishinsaKaisu saishinsaKaisu
     */
    public void setSaishinsaKaisu(int saishinsaKaisu) {
        this.saishinsaKaisu = saishinsaKaisu;
    }

    /**
     * kagoKaisuのgetメソッドです。
     * 
     * @return kagoKaisu
     */
    @CheckForNull
    public int getKagoKaisu() {
        return kagoKaisu;
    }

    /**
     * kagoKaisuのsetメソッドです。
     * 
     * @param kagoKaisu kagoKaisu
     */
    public void setKagoKaisu(int kagoKaisu) {
        this.kagoKaisu = kagoKaisu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV7508KyufujissekiKihonMeisaiFukushiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV7508KyufujissekiKihonMeisaiFukushiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV7508KyufujissekiKihonMeisaiFukushiEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV7508KyufujissekiKihonMeisaiFukushiEntity entity) {
        this.kokanShikibetsuNo = entity.kokanShikibetsuNo;
        this.inputShikibetsuNo = entity.inputShikibetsuNo;
        this.recodeShubetsuCode = entity.recodeShubetsuCode;
        this.kyufuSakuseiKubunCode = entity.kyufuSakuseiKubunCode;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.kyufuJissekiKubunCode = entity.kyufuJissekiKubunCode;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.toshiNo = entity.toshiNo;
        this.kohi1FutanshaNo = entity.kohi1FutanshaNo;
        this.kohi1JukyushaNo = entity.kohi1JukyushaNo;
        this.kohi2FutanshaNo = entity.kohi2FutanshaNo;
        this.kohi2JukyushaNo = entity.kohi2JukyushaNo;
        this.kohi3FutanshaNo = entity.kohi3FutanshaNo;
        this.kohi3JukyushaNo = entity.kohi3JukyushaNo;
        this.umareYMD = entity.umareYMD;
        this.seibetsuCode = entity.seibetsuCode;
        this.yoKaigoJotaiKubunCode = entity.yoKaigoJotaiKubunCode;
        this.kyuSochiNyushoshaTokureiCode = entity.kyuSochiNyushoshaTokureiCode;
        this.ninteiYukoKaishiYMD = entity.ninteiYukoKaishiYMD;
        this.ninteiYukoShuryoYMD = entity.ninteiYukoShuryoYMD;
        this.rojinHokenShichosonNo = entity.rojinHokenShichosonNo;
        this.rojinhokenJukyushaNo = entity.rojinhokenJukyushaNo;
        this.kokiHokenshaNo = entity.kokiHokenshaNo;
        this.kokiHiHokenshaNo = entity.kokiHiHokenshaNo;
        this.kokuhoHokenshaNo = entity.kokuhoHokenshaNo;
        this.kokuhoHiHokenshashoNo = entity.kokuhoHiHokenshashoNo;
        this.kokuhoKojinNo = entity.kokuhoKojinNo;
        this.kyotakuServiceSakuseiKubunCode = entity.kyotakuServiceSakuseiKubunCode;
        this.kyotakuKaigoShienJigyoshoNo = entity.kyotakuKaigoShienJigyoshoNo;
        this.kaishiYMD = entity.kaishiYMD;
        this.chushiYMD = entity.chushiYMD;
        this.chushiRiyuNyushomaeJyokyoCode = entity.chushiRiyuNyushomaeJyokyoCode;
        this.nyushoYMD = entity.nyushoYMD;
        this.taishoYMD = entity.taishoYMD;
        this.nyushoJitsunissu = entity.nyushoJitsunissu;
        this.gaihakuNissu = entity.gaihakuNissu;
        this.taishogoJotaiCode = entity.taishogoJotaiCode;
        this.hokenKyufuritsu = entity.hokenKyufuritsu;
        this.kohi1Kyufuritsu = entity.kohi1Kyufuritsu;
        this.kohi2Kyufuritsu = entity.kohi2Kyufuritsu;
        this.kohi3Kyufuritsu = entity.kohi3Kyufuritsu;
        this.maeHokenServiceTanisu = entity.maeHokenServiceTanisu;
        this.maeHokenSeikyugaku = entity.maeHokenSeikyugaku;
        this.maeHokenRiyoshaFutangaku = entity.maeHokenRiyoshaFutangaku;
        this.maeHokenKinkyuShisetsuRyoyoSeikyugaku = entity.maeHokenKinkyuShisetsuRyoyoSeikyugaku;
        this.maeHokenTokuteiShinryohiSeikyugaku = entity.maeHokenTokuteiShinryohiSeikyugaku;
        this.maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku = entity.maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
        this.maeKohi1ServiceTanisu = entity.maeKohi1ServiceTanisu;
        this.maeKohi1Seikyugaku = entity.maeKohi1Seikyugaku;
        this.maeKohi1RiyoshaFutangaku = entity.maeKohi1RiyoshaFutangaku;
        this.maeKohi1KinkyuShisetsuRyoyoSeikyugaku = entity.maeKohi1KinkyuShisetsuRyoyoSeikyugaku;
        this.maeKohi1TokuteiShinryohiSeikyugaku = entity.maeKohi1TokuteiShinryohiSeikyugaku;
        this.maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku = entity.maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
        this.maeKohi2ServiceTanisu = entity.maeKohi2ServiceTanisu;
        this.maeKohi2Seikyugaku = entity.maeKohi2Seikyugaku;
        this.maeKohi2RiyoshaFutangaku = entity.maeKohi2RiyoshaFutangaku;
        this.maeKohi2KinkyuShisetsuRyoyoSeikyugaku = entity.maeKohi2KinkyuShisetsuRyoyoSeikyugaku;
        this.maeKohi2TokuteiShinryohiSeikyugaku = entity.maeKohi2TokuteiShinryohiSeikyugaku;
        this.maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku = entity.maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
        this.maeKohi3ServiceTanisu = entity.maeKohi3ServiceTanisu;
        this.maeKohi3Seikyugaku = entity.maeKohi3Seikyugaku;
        this.maeKohi3RiyoshaFutangaku = entity.maeKohi3RiyoshaFutangaku;
        this.maeKohi3KinkyuShisetsuRyoyoSeikyugaku = entity.maeKohi3KinkyuShisetsuRyoyoSeikyugaku;
        this.maeKohi3TokuteiShinryohiSeikyugaku = entity.maeKohi3TokuteiShinryohiSeikyugaku;
        this.maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku = entity.maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
        this.atoHokenServiceTanisu = entity.atoHokenServiceTanisu;
        this.atoHokenSeikyugaku = entity.atoHokenSeikyugaku;
        this.atoHokenRiyoshaFutangaku = entity.atoHokenRiyoshaFutangaku;
        this.atoHokenKinkyuShisetsuRyoyoSeikyugaku = entity.atoHokenKinkyuShisetsuRyoyoSeikyugaku;
        this.atoHokenTokuteiShinryohiSeikyugaku = entity.atoHokenTokuteiShinryohiSeikyugaku;
        this.atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku = entity.atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
        this.atoKohi1ServiceTanisu = entity.atoKohi1ServiceTanisu;
        this.atoKohi1Seikyugaku = entity.atoKohi1Seikyugaku;
        this.atoKohi1RiyoshaFutangaku = entity.atoKohi1RiyoshaFutangaku;
        this.atoKohi1KinkyuShisetsuRyoyoSeikyugaku = entity.atoKohi1KinkyuShisetsuRyoyoSeikyugaku;
        this.atoKohi1TokuteiShinryohiSeikyugaku = entity.atoKohi1TokuteiShinryohiSeikyugaku;
        this.atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku = entity.atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
        this.atoKohi2ServiceTanisu = entity.atoKohi2ServiceTanisu;
        this.atoKohi2Seikyugaku = entity.atoKohi2Seikyugaku;
        this.atoKohi2RiyoshaFutangaku = entity.atoKohi2RiyoshaFutangaku;
        this.atoKohi2KinkyuShisetsuRyoyoSeikyugaku = entity.atoKohi2KinkyuShisetsuRyoyoSeikyugaku;
        this.atoKohi2TokuteiShinryohiSeikyugaku = entity.atoKohi2TokuteiShinryohiSeikyugaku;
        this.atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku = entity.atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
        this.atoKohi3ServiceTanisu = entity.atoKohi3ServiceTanisu;
        this.atoKohi3Seikyugaku = entity.atoKohi3Seikyugaku;
        this.atoKohi3RiyoshaFutangaku = entity.atoKohi3RiyoshaFutangaku;
        this.atoKohi3KinkyuShisetsuRyoyoSeikyugaku = entity.atoKohi3KinkyuShisetsuRyoyoSeikyugaku;
        this.atoKohi3TokuteiShinryohiSeikyugaku = entity.atoKohi3TokuteiShinryohiSeikyugaku;
        this.atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku = entity.atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
        this.keikaiKubunCode = entity.keikaiKubunCode;
        this.shinsaYM = entity.shinsaYM;
        this.seiriNo = entity.seiriNo;
        this.sofuYM = entity.sofuYM;
        this.torikomiYM = entity.torikomiYM;
        this.dokujiSakuseiKubun = entity.dokujiSakuseiKubun;
        this.hokenshaHoyuKyufujissekiJohoSakujoFlag = entity.hokenshaHoyuKyufujissekiJohoSakujoFlag;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.serviceKomokuCode = entity.serviceKomokuCode;
        this.tanisu = entity.tanisu;
        this.nissuKaisu = entity.nissuKaisu;
        this.kohi1TaishoNissuKaisu = entity.kohi1TaishoNissuKaisu;
        this.kohi2TaishoNissuKaisu = entity.kohi2TaishoNissuKaisu;
        this.kohi3TaishoNissuKaisu = entity.kohi3TaishoNissuKaisu;
        this.serviceTanisu = entity.serviceTanisu;
        this.kohi1TaishoServiceTanisu = entity.kohi1TaishoServiceTanisu;
        this.kohi2TaishoServiceTanisu = entity.kohi2TaishoServiceTanisu;
        this.kohi3TaishoServiceTanisu = entity.kohi3TaishoServiceTanisu;
        this.tekiyo = entity.tekiyo;
        this.atoTanisu = entity.atoTanisu;
        this.atoNissuKaisu = entity.atoNissuKaisu;
        this.atoKohi1TaishoNissuKaisu = entity.atoKohi1TaishoNissuKaisu;
        this.atoKohi2TaishoNissukaisu = entity.atoKohi2TaishoNissukaisu;
        this.atoKohi3TaishoNissuKaisu = entity.atoKohi3TaishoNissuKaisu;
        this.atoServiceTanisu = entity.atoServiceTanisu;
        this.atoKohi1TaishoServiceTanisu = entity.atoKohi1TaishoServiceTanisu;
        this.atoKohi2TaishoServiceTanisu = entity.atoKohi2TaishoServiceTanisu;
        this.atoKohi3TaishoServiceTanisu = entity.atoKohi3TaishoServiceTanisu;
        this.saishinsaKaisu = entity.saishinsaKaisu;
        this.kagoKaisu = entity.kagoKaisu;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kokanShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, kyufuSakuseiKubunCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, kyufuJissekiKubunCode, jigyoshoNo, toshiNo, kohi1FutanshaNo, kohi1JukyushaNo, kohi2FutanshaNo, kohi2JukyushaNo, kohi3FutanshaNo, kohi3JukyushaNo, umareYMD, seibetsuCode, yoKaigoJotaiKubunCode, kyuSochiNyushoshaTokureiCode, ninteiYukoKaishiYMD, ninteiYukoShuryoYMD, rojinHokenShichosonNo, rojinhokenJukyushaNo, kokiHokenshaNo, kokiHiHokenshaNo, kokuhoHokenshaNo, kokuhoHiHokenshashoNo, kokuhoKojinNo, kyotakuServiceSakuseiKubunCode, kyotakuKaigoShienJigyoshoNo, kaishiYMD, chushiYMD, chushiRiyuNyushomaeJyokyoCode, nyushoYMD, taishoYMD, nyushoJitsunissu, gaihakuNissu, taishogoJotaiCode, hokenKyufuritsu, kohi1Kyufuritsu, kohi2Kyufuritsu, kohi3Kyufuritsu, maeHokenServiceTanisu, maeHokenSeikyugaku, maeHokenRiyoshaFutangaku, maeHokenKinkyuShisetsuRyoyoSeikyugaku, maeHokenTokuteiShinryohiSeikyugaku, maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku, maeKohi1ServiceTanisu, maeKohi1Seikyugaku, maeKohi1RiyoshaFutangaku, maeKohi1KinkyuShisetsuRyoyoSeikyugaku, maeKohi1TokuteiShinryohiSeikyugaku, maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku, maeKohi2ServiceTanisu, maeKohi2Seikyugaku, maeKohi2RiyoshaFutangaku, maeKohi2KinkyuShisetsuRyoyoSeikyugaku, maeKohi2TokuteiShinryohiSeikyugaku, maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku, maeKohi3ServiceTanisu, maeKohi3Seikyugaku, maeKohi3RiyoshaFutangaku, maeKohi3KinkyuShisetsuRyoyoSeikyugaku, maeKohi3TokuteiShinryohiSeikyugaku, maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku, atoHokenServiceTanisu, atoHokenSeikyugaku, atoHokenRiyoshaFutangaku, atoHokenKinkyuShisetsuRyoyoSeikyugaku, atoHokenTokuteiShinryohiSeikyugaku, atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku, atoKohi1ServiceTanisu, atoKohi1Seikyugaku, atoKohi1RiyoshaFutangaku, atoKohi1KinkyuShisetsuRyoyoSeikyugaku, atoKohi1TokuteiShinryohiSeikyugaku, atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku, atoKohi2ServiceTanisu, atoKohi2Seikyugaku, atoKohi2RiyoshaFutangaku, atoKohi2KinkyuShisetsuRyoyoSeikyugaku, atoKohi2TokuteiShinryohiSeikyugaku, atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku, atoKohi3ServiceTanisu, atoKohi3Seikyugaku, atoKohi3RiyoshaFutangaku, atoKohi3KinkyuShisetsuRyoyoSeikyugaku, atoKohi3TokuteiShinryohiSeikyugaku, atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku, keikaiKubunCode, shinsaYM, seiriNo, sofuYM, torikomiYM, dokujiSakuseiKubun, hokenshaHoyuKyufujissekiJohoSakujoFlag, serviceShuruiCode, serviceKomokuCode, tanisu, nissuKaisu, kohi1TaishoNissuKaisu, kohi2TaishoNissuKaisu, kohi3TaishoNissuKaisu, serviceTanisu, kohi1TaishoServiceTanisu, kohi2TaishoServiceTanisu, kohi3TaishoServiceTanisu, tekiyo, atoTanisu, atoNissuKaisu, atoKohi1TaishoNissuKaisu, atoKohi2TaishoNissukaisu, atoKohi3TaishoNissuKaisu, atoServiceTanisu, atoKohi1TaishoServiceTanisu, atoKohi2TaishoServiceTanisu, atoKohi3TaishoServiceTanisu, saishinsaKaisu, kagoKaisu);
    }

// </editor-fold>
}
