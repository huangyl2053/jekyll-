/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.riyojokyotokeihyomeisailistsakusei;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekikubun.KyufuJissekiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekiyoshikikubun.KyufuJissekiYoshikiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyusochisha.KyuSochiNyushoshaTokureiCode;
import jp.co.ndensan.reams.db.dbc.definition.core.kyusochisha.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.nyuryokushikibetsuno.NyuryokuShikibetsuNoTop3Keta;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.RiyojokyoTokeihyo_DataKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.RiyojokyoTokeihyo_RiyoJissekiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.RiyojokyoTokeihyo_ServiceKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.Tokeihyo_CSVEditKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.Tokeihyo_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.Tokeihyo_TaishoNengetsu;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc150010.CreateRiyojokyoIchiranHyoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc150010.RiyojokyoTokeihyoMeisaiListProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3022KyufujissekiShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3025KyufujissekiKyotakuServiceEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1510KyufuJissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1512JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1513RiyoJokyoTokeihyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1514ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.HihokenshaAtenaJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.KyuhuJissekiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoIchiranEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.riyojokyotokeihyomeisailistsakusei.RiyoJokyoIchiranSeqAriEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.riyojokyotokeihyomeisailistsakusei.RiyoJokyoIchiranSeqNashiEUCEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikaku.KyotakuservicekeikakuSakuseikubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.service.core.chohyojushoeditor.ChohyoJushoEditor;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.config.jushoinput.JushoNyuryokuConfigFactory;
import jp.co.ndensan.reams.ur.urz.business.core.gyosekukaku.Chiku;
import jp.co.ndensan.reams.ur.urz.business.core.gyosekukaku.IGyoseiKukaku;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.IJusho;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.banchi.Banchi;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchGyomuException;
import jp.co.ndensan.reams.uz.uza.batch.journal.JournalWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 利用状況統計表（明細リスト）作成サービスクラスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class RiyoJokyoTokeihyoMeisaiListSakuseiService {

    private static final int ZERO = 0;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int SIX = 6;
    private static final int EIGHT = 8;
    private static final int NINE = 9;
    private static final RString 符号 = new RString("/");
    private static final RString 初期金額または日数_0 = new RString("0");
    private static final RString 前ゼロ = new RString("0");
    private static final RString KARA = new RString("～");
    private static final RString PERCENT = new RString("%");
    private static final RString 対象年月 = new RString("【対象年月】:");
    private static final RString 年月範囲 = new RString("【年月範囲】:");
    private static final RString 被保険者番号 = new RString("【被保険者番号】:");
    private static final RString 事業者番号 = new RString("【事業者番号】:");
    private static final RString 利用実績 = new RString("【利用実績】:");
    private static final RString 居宅利用率 = new RString("【居宅利用率】:");
    private static final RString 訪問利用率 = new RString("【訪問利用率】:");
    private static final RString 地区指定 = new RString("【地区指定】:");
    private static final RString 市町村 = new RString("【市町村】:");
    private static final RString 旧市町村 = new RString("【旧市町村】:");
    private static final RString 居宅利用率指定 = new RString("1");
    private static final RString 訪問利用率指定 = new RString("1");
    private static final RString 地区指定_全て = new RString("0");
    private static final RString 地区指定_町域 = new RString("1");
    private static final RString 地区指定_行政区 = new RString("2");
    private static final RString 地区指定_地区1 = new RString("3");
    private static final RString 地区指定_地区2 = new RString("4");
    private static final RString 地区指定_地区3 = new RString("5");
    private static final RString 全て = new RString("全て");
    private static final RString 町域 = new RString("町域");
    private static final RString 行政区 = new RString("行政区");
    private static final RString コロン = new RString(":");
    private static final RString 市町村コード_全て = new RString("000000");
    private static final RString MESSAGE = new RString("構成市町村情報の取得ができませんでした。");
    private static final RString 構成市町村情報の取得 = new RString("構成市町村情報の取得");
    private static final RString FLAG_FALSE = new RString("0");
    private static final RString FLAG_TRUE = new RString("1");
    private final KoseiShichosonMasterDac 構成市町村マスタDac;

    /**
     * コンストラクタです。
     */
    public RiyoJokyoTokeihyoMeisaiListSakuseiService() {
        構成市町村マスタDac = InstanceProvider.create(KoseiShichosonMasterDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link KoseiShichosonMasterDac}
     */
    RiyoJokyoTokeihyoMeisaiListSakuseiService(KoseiShichosonMasterDac 構成市町村マスタDac) {
        this.構成市町村マスタDac = 構成市町村マスタDac;
    }

    /**
     * createInstanceのメソドです。
     *
     * @return 利用状況統計表（明細リスト）作成サービスクラス
     */
    public static RiyoJokyoTokeihyoMeisaiListSakuseiService createInstance() {
        return InstanceProvider.create(RiyoJokyoTokeihyoMeisaiListSakuseiService.class);
    }

    /**
     * 給付実績基本一時Entityを作成します。
     *
     * @param entity 給付実績基本テーブルEntity
     * @return 給付実績基本一時Entity
     */
    public DbWT1510KyufuJissekiKihonEntity create給付実績基本一時Entity(DbT3017KyufujissekiKihonEntity entity) {
        DbWT1510KyufuJissekiKihonEntity 給付実績基本一時Entity = new DbWT1510KyufuJissekiKihonEntity();
        給付実績基本一時Entity.setKokanShikibetsuNo(entity.getKokanShikibetsuNo());
        給付実績基本一時Entity.setInputShikibetsuNo(entity.getInputShikibetsuNo());
        給付実績基本一時Entity.setRecodeShubetsuCode(entity.getRecodeShubetsuCode());
        給付実績基本一時Entity.setShokisaiHokenshaNo(entity.getShokisaiHokenshaNo());
        給付実績基本一時Entity.setHiHokenshaNo(entity.getHiHokenshaNo());
        給付実績基本一時Entity.setServiceTeikyoYM(entity.getServiceTeikyoYM());
        給付実績基本一時Entity.setJigyoshoNo(entity.getJigyoshoNo());
        給付実績基本一時Entity.setKyufuSakuseiKubunCode(entity.getKyufuSakuseiKubunCode());
        給付実績基本一時Entity.setKyufuJissekiKubunCode(entity.getKyufuJissekiKubunCode());
        給付実績基本一時Entity.setToshiNo(entity.getToshiNo());
        給付実績基本一時Entity.setKohi1FutanshaNo(entity.getKohi1FutanshaNo());
        給付実績基本一時Entity.setKohi1JukyushaNo(entity.getKohi1JukyushaNo());
        給付実績基本一時Entity.setKohi2FutanshaNo(entity.getKohi2FutanshaNo());
        給付実績基本一時Entity.setKohi2JukyushaNo(entity.getKohi2JukyushaNo());
        給付実績基本一時Entity.setKohi3FutanshaNo(entity.getKohi3FutanshaNo());
        給付実績基本一時Entity.setKohi3JukyushaNo(entity.getKohi3JukyushaNo());
        給付実績基本一時Entity.setUmareYMD(entity.getUmareYMD());
        給付実績基本一時Entity.setSeibetsuCode(entity.getSeibetsuCode());
        給付実績基本一時Entity.setYoKaigoJotaiKubunCode(entity.getYoKaigoJotaiKubunCode());
        給付実績基本一時Entity.setKyuSochiNyushoshaTokureiCode(entity.getKyuSochiNyushoshaTokureiCode());
        給付実績基本一時Entity.setNinteiYukoKaishiYMD(entity.getNinteiYukoKaishiYMD());
        給付実績基本一時Entity.setNinteiYukoShuryoYMD(entity.getNinteiYukoShuryoYMD());
        給付実績基本一時Entity.setRojinHokenShichosonNo(entity.getRojinHokenShichosonNo());
        給付実績基本一時Entity.setRojinhokenJukyushaNo(entity.getRojinhokenJukyushaNo());
        給付実績基本一時Entity.setKokiHokenshaNo(entity.getKokiHokenshaNo());
        給付実績基本一時Entity.setKokiHiHokenshaNo(entity.getKokiHiHokenshaNo());
        給付実績基本一時Entity.setKokuhoHokenshaNo(entity.getKokuhoHokenshaNo());
        給付実績基本一時Entity.setKokuhoHiHokenshashoNo(entity.getKokuhoHiHokenshashoNo());
        給付実績基本一時Entity.setKokuhoKojinNo(entity.getKokuhoKojinNo());
        給付実績基本一時Entity.setKyotakuServiceSakuseiKubunCode(entity.getKyotakuServiceSakuseiKubunCode());
        給付実績基本一時Entity.setKyotakuKaigoShienJigyoshoNo(entity.getKyotakuKaigoShienJigyoshoNo());
        給付実績基本一時Entity.setKaishiYMD(entity.getKaishiYMD());
        給付実績基本一時Entity.setChushiYMD(entity.getChushiYMD());
        給付実績基本一時Entity.setChushiRiyuNyushomaeJyokyoCode(entity.getChushiRiyuNyushomaeJyokyoCode());
        給付実績基本一時Entity.setNyushoYMD(entity.getNyushoYMD());
        給付実績基本一時Entity.setTaishoYMD(entity.getTaishoYMD());
        給付実績基本一時Entity.setNyushoJitsunissu(entity.getNyushoJitsunissu());
        給付実績基本一時Entity.setGaihakuNissu(entity.getGaihakuNissu());
        給付実績基本一時Entity.setTaishogoJotaiCode(entity.getTaishogoJotaiCode());
        給付実績基本一時Entity.setHokenKyufuritsu(entity.getHokenKyufuritsu());
        給付実績基本一時Entity.setKohi1Kyufuritsu(entity.getKohi1Kyufuritsu());
        給付実績基本一時Entity.setKohi2Kyufuritsu(entity.getKohi2Kyufuritsu());
        給付実績基本一時Entity.setKohi3Kyufuritsu(entity.getKohi3Kyufuritsu());
        給付実績基本一時Entity.setMaeHokenServiceTanisu(entity.getMaeHokenServiceTanisu());
        給付実績基本一時Entity.setMaeHokenSeikyugaku(entity.getMaeHokenSeikyugaku());
        給付実績基本一時Entity.setMaeHokenRiyoshaFutangaku(entity.getMaeHokenRiyoshaFutangaku());
        給付実績基本一時Entity.setMaeHokenKinkyuShisetsuRyoyoSeikyugaku(entity.getMaeHokenKinkyuShisetsuRyoyoSeikyugaku());
        給付実績基本一時Entity.setMaeHokenTokuteiShinryohiSeikyugaku(entity.getMaeHokenTokuteiShinryohiSeikyugaku());
        給付実績基本一時Entity.setMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku());
        給付実績基本一時Entity.setMaeKohi1ServiceTanisu(entity.getMaeKohi1ServiceTanisu());
        給付実績基本一時Entity.setMaeKohi1Seikyugaku(entity.getMaeKohi1Seikyugaku());
        給付実績基本一時Entity.setMaeKohi1RiyoshaFutangaku(entity.getMaeKohi1RiyoshaFutangaku());
        給付実績基本一時Entity.setMaeKohi1KinkyuShisetsuRyoyoSeikyugaku(entity.getMaeKohi1KinkyuShisetsuRyoyoSeikyugaku());
        給付実績基本一時Entity.setMaeKohi1TokuteiShinryohiSeikyugaku(entity.getMaeKohi1TokuteiShinryohiSeikyugaku());
        給付実績基本一時Entity.setMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        給付実績基本一時Entity.setMaeKohi2ServiceTanisu(entity.getMaeKohi2ServiceTanisu());
        給付実績基本一時Entity.setMaeKohi2Seikyugaku(entity.getMaeKohi2Seikyugaku());
        給付実績基本一時Entity.setMaeKohi2RiyoshaFutangaku(entity.getMaeKohi2RiyoshaFutangaku());
        給付実績基本一時Entity.setMaeKohi2KinkyuShisetsuRyoyoSeikyugaku(entity.getMaeKohi2KinkyuShisetsuRyoyoSeikyugaku());
        給付実績基本一時Entity.setMaeKohi2TokuteiShinryohiSeikyugaku(entity.getMaeKohi2TokuteiShinryohiSeikyugaku());
        給付実績基本一時Entity.setMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        給付実績基本一時Entity.setMaeKohi3ServiceTanisu(entity.getMaeKohi3ServiceTanisu());
        給付実績基本一時Entity.setMaeKohi3Seikyugaku(entity.getMaeKohi3Seikyugaku());
        給付実績基本一時Entity.setMaeKohi3RiyoshaFutangaku(entity.getMaeKohi3RiyoshaFutangaku());
        給付実績基本一時Entity.setMaeKohi3KinkyuShisetsuRyoyoSeikyugaku(entity.getMaeKohi3KinkyuShisetsuRyoyoSeikyugaku());
        給付実績基本一時Entity.setMaeKohi3TokuteiShinryohiSeikyugaku(entity.getMaeKohi3TokuteiShinryohiSeikyugaku());
        給付実績基本一時Entity.setMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        給付実績基本一時Entity.setAtoHokenServiceTanisu(entity.getAtoHokenServiceTanisu());
        給付実績基本一時Entity.setAtoHokenSeikyugaku(entity.getAtoHokenSeikyugaku());
        給付実績基本一時Entity.setAtoHokenRiyoshaFutangaku(entity.getAtoHokenRiyoshaFutangaku());
        給付実績基本一時Entity.setAtoHokenKinkyuShisetsuRyoyoSeikyugaku(entity.getAtoHokenKinkyuShisetsuRyoyoSeikyugaku());
        給付実績基本一時Entity.setAtoHokenTokuteiShinryohiSeikyugaku(entity.getAtoHokenTokuteiShinryohiSeikyugaku());
        給付実績基本一時Entity.setAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku());
        給付実績基本一時Entity.setAtoKohi1ServiceTanisu(entity.getAtoKohi1ServiceTanisu());
        給付実績基本一時Entity.setAtoKohi1Seikyugaku(entity.getAtoKohi1Seikyugaku());
        給付実績基本一時Entity.setAtoKohi1RiyoshaFutangaku(entity.getAtoKohi1RiyoshaFutangaku());
        給付実績基本一時Entity.setAtoKohi1KinkyuShisetsuRyoyoSeikyugaku(entity.getAtoKohi1KinkyuShisetsuRyoyoSeikyugaku());
        給付実績基本一時Entity.setAtoKohi1TokuteiShinryohiSeikyugaku(entity.getAtoKohi1TokuteiShinryohiSeikyugaku());
        給付実績基本一時Entity.setAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        給付実績基本一時Entity.setAtoKohi2ServiceTanisu(entity.getAtoKohi2ServiceTanisu());
        給付実績基本一時Entity.setAtoKohi2Seikyugaku(entity.getAtoKohi2Seikyugaku());
        給付実績基本一時Entity.setAtoKohi2RiyoshaFutangaku(entity.getAtoKohi2RiyoshaFutangaku());
        給付実績基本一時Entity.setAtoKohi2KinkyuShisetsuRyoyoSeikyugaku(entity.getAtoKohi2KinkyuShisetsuRyoyoSeikyugaku());
        給付実績基本一時Entity.setAtoKohi2TokuteiShinryohiSeikyugaku(entity.getAtoKohi2TokuteiShinryohiSeikyugaku());
        給付実績基本一時Entity.setAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        給付実績基本一時Entity.setAtoKohi3ServiceTanisu(entity.getAtoKohi3ServiceTanisu());
        給付実績基本一時Entity.setAtoKohi3Seikyugaku(entity.getAtoKohi3Seikyugaku());
        給付実績基本一時Entity.setAtoKohi3RiyoshaFutangaku(entity.getAtoKohi3RiyoshaFutangaku());
        給付実績基本一時Entity.setAtoKohi3KinkyuShisetsuRyoyoSeikyugaku(entity.getAtoKohi3KinkyuShisetsuRyoyoSeikyugaku());
        給付実績基本一時Entity.setAtoKohi3TokuteiShinryohiSeikyugaku(entity.getAtoKohi3TokuteiShinryohiSeikyugaku());
        給付実績基本一時Entity.setAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        給付実績基本一時Entity.setKeikaiKubunCode(entity.getKeikaiKubunCode());
        給付実績基本一時Entity.setShinsaYM(entity.getShinsaYM());
        給付実績基本一時Entity.setSeiriNo(entity.getSeiriNo());
        給付実績基本一時Entity.setSofuYM(entity.getSofuYM());
        給付実績基本一時Entity.setTorikomiYM(entity.getTorikomiYM());
        給付実績基本一時Entity.setDokujiSakuseiKubun(entity.getDokujiSakuseiKubun());
        給付実績基本一時Entity.setHokenshaHoyuKyufujissekiJohoSakujoFlag(entity.getHokenshaHoyuKyufujissekiJohoSakujoFlag());
        給付実績基本一時Entity.setShutsuryokuFlag(false);
        給付実績基本一時Entity.setMeisaiSetteiKubun(RString.EMPTY);
        給付実績基本一時Entity.setShokujiHiyosetteiKubun(RString.EMPTY);
        給付実績基本一時Entity.setKyotakuKeikakuSetteiKubun(RString.EMPTY);
        給付実績基本一時Entity.setFukushiyoguKonyuSetteiKubun(RString.EMPTY);
        給付実績基本一時Entity.setJutakuKaishuSetteiKubun(RString.EMPTY);
        給付実績基本一時Entity.setTokuteiNyushoshaSetteiKubun(RString.EMPTY);
        給付実績基本一時Entity.setShakaiFukushiKeigenSetteiKubun(RString.EMPTY);
        給付実績基本一時Entity.setShukeiSetteiKubun(RString.EMPTY);
        return 給付実績基本一時Entity;
    }

    /**
     * 受給者台帳一時エンティティクラスを作成します。
     *
     * @param entity 受給者台帳テーブルのエンティティクラス
     * @return 受給者台帳一時エンティティクラス
     */
    public DbWT1512JukyushaDaichoEntity create受給者台帳一時Entity(DbT4001JukyushaDaichoEntity entity) {
        DbWT1512JukyushaDaichoEntity 受給者台帳一時Entity = new DbWT1512JukyushaDaichoEntity();
        受給者台帳一時Entity.setHihokenshaNo(entity.getHihokenshaNo());
        受給者台帳一時Entity.setRirekiNo(entity.getRirekiNo());
        受給者台帳一時Entity.setEdaban(entity.getEdaban());
        受給者台帳一時Entity.setYokaigoJotaiKubunCode(entity.getYokaigoJotaiKubunCode());
        受給者台帳一時Entity.setNinteiYukoKikanKaishiYMD(entity.getNinteiYukoKikanKaishiYMD());
        受給者台帳一時Entity.setNinteiYukoKikanShuryoYMD(entity.getNinteiYukoKikanShuryoYMD());
        受給者台帳一時Entity.setShikyuGendoTanisu(entity.getShikyuGendoTanisu());
        受給者台帳一時Entity.setShikyuGendoKaishiYMD(entity.getShikyuGendoKaishiYMD());
        受給者台帳一時Entity.setShikyuGendoShuryoYMD(entity.getShikyuGendoShuryoYMD());
        受給者台帳一時Entity.setKyuSochishaFlag(entity.getKyuSochishaFlag());
        受給者台帳一時Entity.setKyotakuServiceSakuseiKubunCode(RString.EMPTY);
        受給者台帳一時Entity.setKeisakuSakuseiJigyoshaNo(RString.EMPTY);
        受給者台帳一時Entity.setSikibetsuCode(ShikibetsuCode.EMPTY);
        受給者台帳一時Entity.setServiceTeikyoYM(FlexibleYearMonth.EMPTY);
        受給者台帳一時Entity.setShikakuShutokuYMD(FlexibleDate.EMPTY);
        受給者台帳一時Entity.setShikakuSoshitsuYMD(FlexibleDate.EMPTY);
        受給者台帳一時Entity.setShichosonCode(LasdecCode.EMPTY);
        受給者台帳一時Entity.setKoikinaiJushochiTokureiFlag(RString.EMPTY);
        受給者台帳一時Entity.setKoikinaiTokureiSochimotoShichosonCode(RString.EMPTY);
        受給者台帳一時Entity.setKyuShichosonCode(RString.EMPTY);
        FlexibleDate 認定有効期間開始年月日 = entity.getNinteiYukoKikanKaishiYMD();
        if (認定有効期間開始年月日 == null || 認定有効期間開始年月日.isEmpty()) {
            受給者台帳一時Entity.setNinteiYukoKikanKaishiYM(FlexibleYearMonth.MIN);
        } else {
            受給者台帳一時Entity.setNinteiYukoKikanKaishiYM(認定有効期間開始年月日.getYearMonth());
        }
        FlexibleDate 認定有効期間終了年月日 = entity.getNinteiYukoKikanShuryoYMD();
        if (認定有効期間終了年月日 == null || 認定有効期間終了年月日.isEmpty()) {
            受給者台帳一時Entity.setNinteiYukoKikanShuryoYM(FlexibleYearMonth.MAX);
        } else {
            受給者台帳一時Entity.setNinteiYukoKikanShuryoYM(認定有効期間終了年月日.getYearMonth());
        }
        受給者台帳一時Entity.setShutsuryokuFlag(false);
        return 受給者台帳一時Entity;
    }

    /**
     * 処理結果確認リスト一時_マスタ構成不正Entityクラスを作成します。
     *
     * @param entity 給付実績基本一時テーブルEntity
     * @return 処理結果確認リスト一時_マスタ構成不正Entity
     */
    public DbWT1514ShoriKekkaKakuninListEntity createマスタ構成不正Entity(DbWT1510KyufuJissekiKihonEntity entity) {

        DbWT1514ShoriKekkaKakuninListEntity マスタ構成不正Entity = new DbWT1514ShoriKekkaKakuninListEntity();
        マスタ構成不正Entity.setErrorKubun(Tokeihyo_ErrorKubun.マスタ構成不正.getコード());
        マスタ構成不正Entity.setShoKisaiHokenshaNo(entity.getShokisaiHokenshaNo());
        マスタ構成不正Entity.setHihokenshaNo(entity.getHiHokenshaNo());
        マスタ構成不正Entity.setKey1(entity.getServiceTeikyoYM().toDateString());
        マスタ構成不正Entity.setKey2(entity.getJigyoshoNo().value());
        マスタ構成不正Entity.setKey3(entity.getInputShikibetsuNo().value());
        マスタ構成不正Entity.setKey4(entity.getToshiNo());
        マスタ構成不正Entity.setKey5(RString.EMPTY);
        マスタ構成不正Entity.setHihokenshaShimei(RString.EMPTY);
        マスタ構成不正Entity.setBiko(RString.EMPTY);
        return マスタ構成不正Entity;
    }

    /**
     * 給付実績データクラスを作成します。
     *
     * @param entity 給付実績基本一時テーブルEntity
     * @param 計画費 計画費
     * @return 給付実績データ
     */
    public DbWT1513RiyoJokyoTokeihyoEntity create給付実績データ(DbWT1510KyufuJissekiKihonEntity entity, DbT3025KyufujissekiKyotakuServiceEntity 計画費) {

        DbWT1513RiyoJokyoTokeihyoEntity 利用状況統計表一時 = create給付実績データ共通(entity);
        利用状況統計表一時.setServiceKubun(RiyojokyoTokeihyo_ServiceKubun.在宅.getコード());
        ServiceCode サービスコード = 計画費.getServiceCode();
        if (サービスコード != null && !サービスコード.isEmpty() && TWO < サービスコード.value().length()) {
            利用状況統計表一時.setServiceShuruiCode(サービスコード.value().substring(ZERO, TWO));
        }
        利用状況統計表一時.setNissuKaisu(new RString("1"));
        利用状況統計表一時.setTankiNyushoJitsunissu(初期金額または日数_0);
        利用状況統計表一時.setHokenTanisu(decimaltoRString(計画費.getAtoTanisu()));
        利用状況統計表一時.setHokenTanisuTanka(decimaltoRString(計画費.getTanisuTanka()));
        利用状況統計表一時.setHokenSeikyugaku(decimaltoRString(計画費.getSeikyuKingaku()));
        利用状況統計表一時.setHokenRiyoshaFutangaku(初期金額または日数_0);
        利用状況統計表一時.setKohi1Tanisu(初期金額または日数_0);
        利用状況統計表一時.setKohi1Seikyugaku(初期金額または日数_0);
        利用状況統計表一時.setKohi1HonninFutangaku(初期金額または日数_0);
        利用状況統計表一時.setKohi2Tanisu(初期金額または日数_0);
        利用状況統計表一時.setKohi2Seikyugaku(初期金額または日数_0);
        利用状況統計表一時.setKohi2HonninFutangaku(初期金額または日数_0);
        利用状況統計表一時.setKohi3Tanisu(初期金額または日数_0);
        利用状況統計表一時.setKohi3Seikyugaku(初期金額または日数_0);
        利用状況統計表一時.setKohi3HonninFutangaku(初期金額または日数_0);
        利用状況統計表一時.setHokenDekidakaTanisu(初期金額または日数_0);
        利用状況統計表一時.setHokenDekidakaSeikyugaku(初期金額または日数_0);
        利用状況統計表一時.setHokenDekidakaRiyoshaFutangaku(初期金額または日数_0);
        利用状況統計表一時.setKohi1DekidakaTanisu(初期金額または日数_0);
        利用状況統計表一時.setKohi1DekidakaSeikyugaku(初期金額または日数_0);
        利用状況統計表一時.setKohi1DekidakaHonninFutangaku(初期金額または日数_0);
        利用状況統計表一時.setKohi2DekidakaTanisu(初期金額または日数_0);
        利用状況統計表一時.setKohi2DekidakaSeikyugaku(初期金額または日数_0);
        利用状況統計表一時.setKohi2DekidakaHonninFutangaku(初期金額または日数_0);
        利用状況統計表一時.setKohi3DekidakaTanisu(初期金額または日数_0);
        利用状況統計表一時.setKohi3DekidakaSeikyugaku(初期金額または日数_0);
        利用状況統計表一時.setKohi3DekidakaHonninFutangaku(初期金額または日数_0);
        利用状況統計表一時.setShokujiKihonNissu(初期金額または日数_0);
        利用状況統計表一時.setShokujiKihonTanka(初期金額または日数_0);
        利用状況統計表一時.setShokujiTokubetsuNissu(初期金額または日数_0);
        利用状況統計表一時.setShokujiTokubetsuTanka(初期金額または日数_0);
        利用状況統計表一時.setShokujiTeikyohiGokei(初期金額または日数_0);
        利用状況統計表一時.setNichigakuHyojunFutangaku(初期金額または日数_0);
        利用状況統計表一時.setShokujiTeikyohiSeikyugaku(初期金額または日数_0);
        利用状況統計表一時.setGendogakuKanriTaishoTanisu(初期金額または日数_0);
        利用状況統計表一時.setGendogakuKanritaishogaiTanisu(初期金額または日数_0);
        利用状況統計表一時.setSaishinsaKaisu(初期金額または日数_0);
        利用状況統計表一時.setHomonShikyuGendogaku(初期金額または日数_0);
        利用状況統計表一時.setHomonRiyoServiceTanisu(初期金額または日数_0);
        利用状況統計表一時.setTankiShikyuGendogaku(初期金額または日数_0);
        利用状況統計表一時.setTankiRiyoServiceTanisu(初期金額または日数_0);
        利用状況統計表一時.setGaihakuNissu(初期金額または日数_0);
        利用状況統計表一時.setTokuteiNyushoShokuhiNissu(初期金額または日数_0);
        利用状況統計表一時.setTokuteiNyushoShokuhiHiyogaku(初期金額または日数_0);
        利用状況統計表一時.setTokuteiNyushoShokuhiSeikyugaku(初期金額または日数_0);
        利用状況統計表一時.setTokuteiNyushoShokuhiRiyoshaFutangaku(初期金額または日数_0);
        利用状況統計表一時.setTokuteiNyushoKyojuNissu(初期金額または日数_0);
        利用状況統計表一時.setTokuteiNyushoKyojuHiyogaku(初期金額または日数_0);
        利用状況統計表一時.setTokuteiNyushoKyojuSeikyugaku(初期金額または日数_0);
        利用状況統計表一時.setTokuteiNyushoKyojuRiyoshaFutangaku(初期金額または日数_0);
        利用状況統計表一時.setShafukuKeigenritsu(初期金額または日数_0);
        利用状況統計表一時.setShafukuRiyoshaFutangaku(初期金額または日数_0);
        利用状況統計表一時.setShafukuKeigengaku(初期金額または日数_0);
        利用状況統計表一時.setShafukuKeigengoRiyoshaFutangaku(初期金額または日数_0);
        利用状況統計表一時.setMeisaiOutFlag(FLAG_FALSE);
        利用状況統計表一時.setTaishogoJotaiCode(RString.EMPTY);
        return 利用状況統計表一時;
    }

    /**
     * 給付実績データクラスを作成します。
     *
     * @param entity 給付実績基本一時テーブルEntity
     * @param 集計費 集計費
     * @param 福祉件数 福祉件数
     * @param 住宅件数 住宅件数
     * @param 給付実績明細ワーク 給付実績明細ワークList
     * @param 給付実績食事費用ワーク 給付実績食事費用ワークList
     * @param 給付実績特定入所者介護サービス費用ワーク 給付実績特定入所者介護サービス費用ワークList
     * @param 給付実績社会福祉法人軽減額ワーク 給付実績社会福祉法人軽減額ワーク
     * @param 処理結果確認リスト一時TBL 処理結果確認リスト一時TBL
     * @return 給付実績データ
     */
    public DbWT1513RiyoJokyoTokeihyoEntity create給付実績データ集計(DbWT1510KyufuJissekiKihonEntity entity,
            DbT3033KyufujissekiShukeiEntity 集計費, int 福祉件数, int 住宅件数, List<KyuhuJissekiMeisaiEntity> 給付実績明細ワーク,
            List<DbT3022KyufujissekiShokujiHiyoEntity> 給付実績食事費用ワーク,
            List<DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity> 給付実績特定入所者介護サービス費用ワーク,
            List<DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity> 給付実績社会福祉法人軽減額ワーク,
            BatchEntityCreatedTempTableWriter 処理結果確認リスト一時TBL) {

        DbWT1513RiyoJokyoTokeihyoEntity 利用状況統計表一時 = create給付実績データ共通(entity);
        RString 入力識別番号上3桁 = entity.getInputShikibetsuNo().value().substring(ZERO, THREE);
        RString 入力識別番号上4桁 = entity.getInputShikibetsuNo().value().substring(ZERO, FOUR);
        List<RString> 在宅List = new ArrayList<>();
        在宅List.add(NyuryokuShikibetsuNoTop3Keta.現物_居宅介護サービス.getコード());
        在宅List.add(NyuryokuShikibetsuNoTop3Keta.償還_居宅介護サービス.getコード());
        在宅List.add(NyuryokuShikibetsuNoTop3Keta.現物_短期入所生活介護.getコード());
        在宅List.add(NyuryokuShikibetsuNoTop3Keta.償還_短期入所生活介護.getコード());
        在宅List.add(NyuryokuShikibetsuNoTop3Keta.現物_短期入所老健施設.getコード());
        在宅List.add(NyuryokuShikibetsuNoTop3Keta.償還_短期入所老健施設.getコード());
        在宅List.add(NyuryokuShikibetsuNoTop3Keta.現物_短期入所医療施設.getコード());
        在宅List.add(NyuryokuShikibetsuNoTop3Keta.償還_短期入所医療施設.getコード());
        在宅List.add(NyuryokuShikibetsuNoTop3Keta.現物_認知症型共同生活.getコード());
        在宅List.add(NyuryokuShikibetsuNoTop3Keta.償還_認知症型共同生活.getコード());
        List<RString> 施設List = new ArrayList<>();
        施設List.add(NyuryokuShikibetsuNoTop3Keta.現物_福祉施設_地域福祉施設.getコード());
        施設List.add(NyuryokuShikibetsuNoTop3Keta.償還_福祉施設_地域福祉施設.getコード());
        施設List.add(NyuryokuShikibetsuNoTop3Keta.現物_介護老人保健施設.getコード());
        施設List.add(NyuryokuShikibetsuNoTop3Keta.償還_介護老人保健施設.getコード());
        施設List.add(NyuryokuShikibetsuNoTop3Keta.現物_介護療養型医療施設.getコード());
        施設List.add(NyuryokuShikibetsuNoTop3Keta.償還_介護療養型医療施設.getコード());
        if (在宅List.contains(入力識別番号上3桁)) {
            利用状況統計表一時.setServiceKubun(RiyojokyoTokeihyo_ServiceKubun.在宅.getコード());
        } else if (施設List.contains(入力識別番号上3桁)) {
            利用状況統計表一時.setServiceKubun(RiyojokyoTokeihyo_ServiceKubun.施設.getコード());
        } else {
            利用状況統計表一時.setServiceKubun(RiyojokyoTokeihyo_ServiceKubun.その他.getコード());
        }
        RString 集計サービス種類コード = 集計費.getServiceSyuruiCode().value();
        利用状況統計表一時.setServiceShuruiCode(集計サービス種類コード);
        if (NyuryokuShikibetsuNoTop3Keta.償還_福祉用具販売費.getコード().equals(入力識別番号上3桁)) {
            利用状況統計表一時.setNissuKaisu(new RString(String.valueOf(福祉件数)));
        } else if (NyuryokuShikibetsuNoTop3Keta.償還_住宅改修費.getコード().equals(入力識別番号上3桁)) {
            利用状況統計表一時.setNissuKaisu(new RString(String.valueOf(住宅件数)));
        } else if (NyuryokuShikibetsuNoTop3Keta.償還_居宅介護サービス.getコード().equals(入力識別番号上3桁)
                || NyuryokuShikibetsuNoTop3Keta.現物_居宅介護サービス.getコード().equals(入力識別番号上3桁)) {
            利用状況統計表一時.setNissuKaisu(get居宅介護サービス日数回数(集計費, 給付実績明細ワーク));
        } else {
            利用状況統計表一時.setNissuKaisu(get日数回数(集計費.getServiceSyuruiCode().value(), 給付実績明細ワーク));
        }
        List<RString> 入所院実日数対象List = new ArrayList<>();
        入所院実日数対象List.add(KyufuJissekiYoshikiKubun._7171_様式第六.getコード());
        入所院実日数対象List.add(KyufuJissekiYoshikiKubun._7172_様式第六の二.getコード());
        入所院実日数対象List.add(KyufuJissekiYoshikiKubun._7173_様式第六の三.getコード());
        入所院実日数対象List.add(KyufuJissekiYoshikiKubun._7174_様式第六の四.getコード());
        入所院実日数対象List.add(KyufuJissekiYoshikiKubun._2171_様式第六.getコード());
        入所院実日数対象List.add(KyufuJissekiYoshikiKubun._2172_様式第六の二.getコード());
        入所院実日数対象List.add(KyufuJissekiYoshikiKubun._2173_様式第六の三.getコード());
        入所院実日数対象List.add(KyufuJissekiYoshikiKubun._2174_様式第六の四.getコード());
        入所院実日数対象List.add(NyuryokuShikibetsuNoTop3Keta.現物_福祉施設_地域福祉施設.getコード());
        入所院実日数対象List.add(NyuryokuShikibetsuNoTop3Keta.償還_福祉施設_地域福祉施設.getコード());
        入所院実日数対象List.add(NyuryokuShikibetsuNoTop3Keta.現物_介護老人保健施設.getコード());
        入所院実日数対象List.add(NyuryokuShikibetsuNoTop3Keta.償還_介護老人保健施設.getコード());
        入所院実日数対象List.add(NyuryokuShikibetsuNoTop3Keta.現物_介護療養型医療施設.getコード());
        入所院実日数対象List.add(NyuryokuShikibetsuNoTop3Keta.償還_介護療養型医療施設.getコード());

        List<RString> 支給限度額一本化年月対象List = new ArrayList<>();
        支給限度額一本化年月対象List.add(NyuryokuShikibetsuNoTop3Keta.現物_短期入所生活介護.getコード());
        支給限度額一本化年月対象List.add(NyuryokuShikibetsuNoTop3Keta.償還_短期入所生活介護.getコード());
        支給限度額一本化年月対象List.add(NyuryokuShikibetsuNoTop3Keta.現物_短期入所老健施設.getコード());
        支給限度額一本化年月対象List.add(NyuryokuShikibetsuNoTop3Keta.償還_短期入所老健施設.getコード());
        支給限度額一本化年月対象List.add(NyuryokuShikibetsuNoTop3Keta.現物_短期入所医療施設.getコード());
        支給限度額一本化年月対象List.add(NyuryokuShikibetsuNoTop3Keta.償還_短期入所医療施設.getコード());
        支給限度額一本化年月対象List.add(KyufuJissekiYoshikiKubun._7175_様式第六の五.getコード());
        支給限度額一本化年月対象List.add(KyufuJissekiYoshikiKubun._7176_様式第六の六.getコード());
        支給限度額一本化年月対象List.add(KyufuJissekiYoshikiKubun._7177_様式第六の七.getコード());
        支給限度額一本化年月対象List.add(KyufuJissekiYoshikiKubun._2175_様式第六の五.getコード());
        支給限度額一本化年月対象List.add(KyufuJissekiYoshikiKubun._2176_様式第六の六.getコード());
        支給限度額一本化年月対象List.add(KyufuJissekiYoshikiKubun._2177_様式第六の七.getコード());
        if (入所院実日数対象List.contains(入力識別番号上3桁) || 入所院実日数対象List.contains(入力識別番号上4桁)) {
            利用状況統計表一時.setTankiNyushoJitsunissu(new RString(String.valueOf(entity.getNyushoJitsunissu())));
        } else if (支給限度額一本化年月対象List.contains(入力識別番号上3桁) || 支給限度額一本化年月対象List.contains(入力識別番号上4桁)) {
            FlexibleYearMonth 制度改正施行日_支給限度額一本化 = new FlexibleDate(DbBusinessConfig.
                    get(ConfigNameDBU.制度改正施行日_支給限度額一本化, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)).getYearMonth();
            if (entity.getServiceTeikyoYM().isBefore(制度改正施行日_支給限度額一本化)) {
                利用状況統計表一時.setTankiNyushoJitsunissu(new RString(String.valueOf(集計費.getAtoTankiNyushoJitsunissu())));
            } else {
                利用状況統計表一時.setTankiNyushoJitsunissu(new RString(String.valueOf(集計費.getServiceJitsunissu())));
            }
        } else {
            利用状況統計表一時.setTankiNyushoJitsunissu(FLAG_FALSE);
        }
        利用状況統計表一時.setHokenTanisu(decimaltoRString(集計費.getAtoHokenTanisuTotal()));
        利用状況統計表一時.setHokenTanisuTanka(decimaltoRString(集計費.getHokenTanisuTani()));
        利用状況統計表一時.setHokenSeikyugaku(decimaltoRString(集計費.getAtoHokenSeikyugaku()));
        利用状況統計表一時.setHokenRiyoshaFutangaku(decimaltoRString(集計費.getHokenRiyoshaFutangaku()));
        利用状況統計表一時.setKohi1Tanisu(decimaltoRString(集計費.getKohi1TanisuTotal()));
        利用状況統計表一時.setKohi1Seikyugaku(decimaltoRString(集計費.getKohi1Seikyugaku()));
        利用状況統計表一時.setKohi1HonninFutangaku(decimaltoRString(集計費.getKohi1HonninFutangaku()));
        利用状況統計表一時.setKohi2Tanisu(decimaltoRString(集計費.getKohi2TanisuTotal()));
        利用状況統計表一時.setKohi2Seikyugaku(decimaltoRString(集計費.getKohi2Seikyugaku()));
        利用状況統計表一時.setKohi2HonninFutangaku(decimaltoRString(集計費.getKohi2HonninFutangaku()));
        利用状況統計表一時.setKohi3Tanisu(decimaltoRString(集計費.getKohi3TanisuTotal()));
        利用状況統計表一時.setKohi3Seikyugaku(decimaltoRString(集計費.getKohi3Seikyugaku()));
        利用状況統計表一時.setKohi3HonninFutangaku(decimaltoRString(集計費.getKohi3HonninFutangaku()));
        利用状況統計表一時.setHokenDekidakaTanisu(decimaltoRString(集計費.getHokenDekidakaTanisuTotal()));
        利用状況統計表一時.setHokenDekidakaSeikyugaku(decimaltoRString(集計費.getHokenDekidakaSeikyugaku()));
        利用状況統計表一時.setHokenDekidakaRiyoshaFutangaku(decimaltoRString(集計費.getHokenDekidakaIryohiRiyoshaFutangaku()));
        利用状況統計表一時.setKohi1DekidakaTanisu(decimaltoRString(集計費.getKohi1DekidakaTanisuTotal()));
        利用状況統計表一時.setKohi1DekidakaSeikyugaku(decimaltoRString(集計費.getKohi1DekidakaSeikyugaku()));
        利用状況統計表一時.setKohi1DekidakaHonninFutangaku(decimaltoRString(集計費.getKohi1DekidakaIryohiRiyoshaFutangaku()));
        利用状況統計表一時.setKohi2DekidakaTanisu(decimaltoRString(集計費.getKohi2DekidakaTanisuTotal()));
        利用状況統計表一時.setKohi2DekidakaSeikyugaku(decimaltoRString(集計費.getKohi2DekidakaSeikyugaku()));
        利用状況統計表一時.setKohi2DekidakaHonninFutangaku(decimaltoRString(集計費.getKohi2DekidakaIryohiRiyoshaFutangaku()));
        利用状況統計表一時.setKohi3DekidakaTanisu(decimaltoRString(集計費.getKohi3DekidakaTanisuTotal()));
        利用状況統計表一時.setKohi3DekidakaSeikyugaku(decimaltoRString(集計費.getKohi3DekidakaSeikyugaku()));
        利用状況統計表一時.setKohi3DekidakaHonninFutangaku(decimaltoRString(集計費.getKohi3DekidakaIryohiRiyoshaFutangaku()));
        if (入所院実日数対象List.contains(入力識別番号上3桁)) {
            if (給付実績食事費用ワーク.isEmpty()) {
                利用状況統計表一時.setShokujiKihonNissu(初期金額または日数_0);
                利用状況統計表一時.setShokujiKihonTanka(初期金額または日数_0);
                利用状況統計表一時.setShokujiTokubetsuNissu(初期金額または日数_0);
                利用状況統計表一時.setShokujiTokubetsuTanka(初期金額または日数_0);
                利用状況統計表一時.setShokujiTeikyohiGokei(初期金額または日数_0);
                利用状況統計表一時.setNichigakuHyojunFutangaku(初期金額または日数_0);
                利用状況統計表一時.setShokujiTeikyohiSeikyugaku(初期金額または日数_0);
            } else {
                利用状況統計表一時.setShokujiKihonNissu(new RString(給付実績食事費用ワーク.get(0).getKihonTeikyoNissu()));
                利用状況統計表一時.setShokujiKihonTanka(new RString(給付実績食事費用ワーク.get(0).getAtoKihonTeikyoTanka()));
                利用状況統計表一時.setShokujiTokubetsuNissu(new RString(給付実績食事費用ワーク.get(0).getTokubestuTeikyoNissu()));
                利用状況統計表一時.setShokujiTokubetsuTanka(new RString(給付実績食事費用ワーク.get(0).getAtoTokubestuTeikyoTanka()));
                利用状況統計表一時.setShokujiTeikyohiGokei(new RString(給付実績食事費用ワーク.get(0).getSyokujiTeikyohiTotal()));
                利用状況統計表一時.setNichigakuHyojunFutangaku(new RString(給付実績食事費用ワーク.get(0).getNichigakuHyojunFutanGaku()));
                利用状況統計表一時.setShokujiTeikyohiSeikyugaku(new RString(給付実績食事費用ワーク.get(0).getAtoSyokujiTeikyohiSeikyugaku()));
            }
        } else {
            利用状況統計表一時.setShokujiKihonNissu(初期金額または日数_0);
            利用状況統計表一時.setShokujiKihonTanka(初期金額または日数_0);
            利用状況統計表一時.setShokujiTokubetsuNissu(初期金額または日数_0);
            利用状況統計表一時.setShokujiTokubetsuTanka(初期金額または日数_0);
            利用状況統計表一時.setShokujiTeikyohiGokei(初期金額または日数_0);
            利用状況統計表一時.setNichigakuHyojunFutangaku(初期金額または日数_0);
            利用状況統計表一時.setShokujiTeikyohiSeikyugaku(初期金額または日数_0);
        }

        利用状況統計表一時.setGendogakuKanriTaishoTanisu(decimaltoRString(集計費.getGendogakuKanriTaishoTanisu()));
        利用状況統計表一時.setGendogakuKanritaishogaiTanisu(decimaltoRString(集計費.getGendogakuKanritaishogaiTanisu()));
        利用状況統計表一時.setSaishinsaKaisu(integertoRString(集計費.getSaishinsaKaisu()));
        利用状況統計表一時.setKagoKaisu(integertoRString(集計費.getKagoKaisu()));
        利用状況統計表一時.setHomonShikyuGendogaku(初期金額または日数_0);
        create給付実績データ集計_分(利用状況統計表一時, 入力識別番号上3桁, 集計サービス種類コード, 給付実績明細ワーク,
                entity, 処理結果確認リスト一時TBL, 入所院実日数対象List, 支給限度額一本化年月対象List, 入力識別番号上4桁, 集計費,
                給付実績特定入所者介護サービス費用ワーク, 給付実績社会福祉法人軽減額ワーク);
        return 利用状況統計表一時;
    }

    /**
     * 集計データ登録1を作成します。
     *
     * @param 集計データ 集計データ登録1
     * @param entity 利用状況統計表一時entity
     * @return 集計データ登録1
     */
    public DbWT1513RiyoJokyoTokeihyoEntity create集計データ登録1(DbWT1513RiyoJokyoTokeihyoEntity 集計データ,
            DbWT1513RiyoJokyoTokeihyoEntity entity) {
        if (!RString.isNullOrEmpty(entity.getKyotakuServiceJigyoshoNo())
                && !new RString("0000000000").equals(entity.getKyotakuServiceJigyoshoNo())
                && RString.isNullOrEmpty(集計データ.getKyotakuServiceSakuseiKubunCode())) {
            集計データ.setKyotakuServiceSakuseiKubunCode(entity.getKyotakuServiceSakuseiKubunCode());
            集計データ.setKyotakuServiceShuruiCode(entity.getKyotakuServiceShuruiCode());
            集計データ.setKyotakuServiceJigyoshoNo(entity.getKyotakuServiceJigyoshoNo());
        }
        if (entity.getServiceKubun().equals(集計データ.getServiceKubun())
                && !RiyojokyoTokeihyo_ServiceKubun.混在.getコード().equals(集計データ.getServiceKubun())) {
            集計データ.setServiceKubun(entity.getServiceKubun());
        } else {
            集計データ.setServiceKubun(RiyojokyoTokeihyo_ServiceKubun.混在.getコード());
        }
        集計データ.setNissuKaisu(add(集計データ.getNissuKaisu(), entity.getNissuKaisu()));
        集計データ.setTankiNyushoJitsunissu(add(集計データ.getNissuKaisu(), entity.getTankiNyushoJitsunissu()));
        集計データ.setHokenTanisu(add(集計データ.getNissuKaisu(), entity.getHokenTanisu()));
        集計データ.setHokenSeikyugaku(add(集計データ.getNissuKaisu(), entity.getHokenSeikyugaku()));
        集計データ.setHokenRiyoshaFutangaku(add(集計データ.getHokenRiyoshaFutangaku(), entity.getHokenRiyoshaFutangaku()));
        集計データ.setKohi1Tanisu(add(集計データ.getKohi1Tanisu(), entity.getKohi1Tanisu()));
        集計データ.setKohi1Seikyugaku(add(集計データ.getKohi1Seikyugaku(), entity.getKohi1Seikyugaku()));
        集計データ.setKohi1HonninFutangaku(add(集計データ.getKohi1HonninFutangaku(), entity.getKohi1HonninFutangaku()));
        集計データ.setKohi2Tanisu(add(集計データ.getKohi2Tanisu(), entity.getKohi2Tanisu()));
        集計データ.setKohi2Seikyugaku(add(集計データ.getKohi2Seikyugaku(), entity.getKohi2Seikyugaku()));
        集計データ.setKohi2HonninFutangaku(add(集計データ.getKohi2HonninFutangaku(), entity.getKohi2HonninFutangaku()));
        集計データ.setKohi3Tanisu(add(集計データ.getKohi3Tanisu(), entity.getKohi3Tanisu()));
        集計データ.setKohi3Seikyugaku(add(集計データ.getKohi3Seikyugaku(), entity.getKohi3Seikyugaku()));
        集計データ.setKohi3HonninFutangaku(add(集計データ.getKohi3HonninFutangaku(), entity.getKohi3HonninFutangaku()));
        集計データ.setHokenDekidakaTanisu(add(集計データ.getHokenDekidakaTanisu(), entity.getHokenDekidakaTanisu()));
        集計データ.setHokenDekidakaSeikyugaku(add(集計データ.getHokenDekidakaSeikyugaku(), entity.getHokenDekidakaSeikyugaku()));
        集計データ.setHokenDekidakaRiyoshaFutangaku(add(集計データ.getHokenDekidakaRiyoshaFutangaku(), entity.getHokenDekidakaRiyoshaFutangaku()));
        集計データ.setKohi1DekidakaTanisu(add(集計データ.getKohi1DekidakaTanisu(), entity.getKohi1DekidakaTanisu()));
        集計データ.setKohi1DekidakaSeikyugaku(add(集計データ.getKohi1DekidakaSeikyugaku(), entity.getKohi1DekidakaSeikyugaku()));
        集計データ.setKohi1DekidakaHonninFutangaku(add(集計データ.getKohi1DekidakaHonninFutangaku(), entity.getKohi1DekidakaHonninFutangaku()));
        集計データ.setKohi2DekidakaTanisu(add(集計データ.getKohi2DekidakaTanisu(), entity.getKohi2DekidakaTanisu()));
        集計データ.setKohi2DekidakaSeikyugaku(add(集計データ.getKohi2DekidakaSeikyugaku(), entity.getKohi2DekidakaSeikyugaku()));
        集計データ.setKohi2DekidakaHonninFutangaku(add(集計データ.getKohi2DekidakaHonninFutangaku(), entity.getKohi2DekidakaHonninFutangaku()));
        集計データ.setKohi3DekidakaTanisu(add(集計データ.getKohi3DekidakaTanisu(), entity.getKohi3DekidakaTanisu()));
        集計データ.setKohi3DekidakaSeikyugaku(add(集計データ.getKohi3DekidakaSeikyugaku(), entity.getKohi3DekidakaSeikyugaku()));
        集計データ.setKohi3DekidakaHonninFutangaku(add(集計データ.getKohi3DekidakaHonninFutangaku(), entity.getKohi3DekidakaHonninFutangaku()));
        集計データ.setShokujiKihonNissu(add(集計データ.getShokujiKihonNissu(), entity.getShokujiKihonNissu()));

        集計データ.setShokujiTokubetsuNissu(add(集計データ.getShokujiTokubetsuNissu(), entity.getShokujiTokubetsuNissu()));
        集計データ.setShokujiTeikyohiGokei(add(集計データ.getShokujiTeikyohiGokei(), entity.getShokujiTeikyohiGokei()));
        集計データ.setNichigakuHyojunFutangaku(add(集計データ.getNichigakuHyojunFutangaku(), entity.getNichigakuHyojunFutangaku()));
        集計データ.setShokujiTeikyohiSeikyugaku(add(集計データ.getShokujiTeikyohiSeikyugaku(), entity.getShokujiTeikyohiSeikyugaku()));
        集計データ.setGendogakuKanriTaishoTanisu(add(集計データ.getGendogakuKanriTaishoTanisu(), entity.getGendogakuKanriTaishoTanisu()));
        集計データ.setGendogakuKanritaishogaiTanisu(add(集計データ.getGendogakuKanritaishogaiTanisu(), entity.getGendogakuKanritaishogaiTanisu()));
        集計データ.setHomonRiyoServiceTanisu(add(集計データ.getHomonRiyoServiceTanisu(), entity.getHomonRiyoServiceTanisu()));
        集計データ.setTankiRiyoServiceTanisu(add(集計データ.getTankiRiyoServiceTanisu(), entity.getTankiRiyoServiceTanisu()));
        集計データ.setGaihakuNissu(add(集計データ.getGaihakuNissu(), entity.getGaihakuNissu()));
        集計データ.setTokuteiNyushoShokuhiNissu(add(集計データ.getTokuteiNyushoShokuhiNissu(), entity.getTokuteiNyushoShokuhiNissu()));
        集計データ.setTokuteiNyushoShokuhiHiyogaku(add(集計データ.getTokuteiNyushoShokuhiHiyogaku(), entity.getTokuteiNyushoShokuhiHiyogaku()));
        集計データ.setTokuteiNyushoShokuhiSeikyugaku(add(集計データ.getTokuteiNyushoShokuhiSeikyugaku(), entity.getTokuteiNyushoShokuhiSeikyugaku()));
        集計データ.setTokuteiNyushoShokuhiRiyoshaFutangaku(add(集計データ.getTokuteiNyushoShokuhiRiyoshaFutangaku(),
                entity.getTokuteiNyushoShokuhiRiyoshaFutangaku()));
        集計データ.setTokuteiNyushoKyojuNissu(add(集計データ.getTokuteiNyushoKyojuNissu(), entity.getTokuteiNyushoKyojuNissu()));
        集計データ.setTokuteiNyushoKyojuHiyogaku(add(集計データ.getTokuteiNyushoKyojuHiyogaku(), entity.getTokuteiNyushoKyojuHiyogaku()));
        集計データ.setTokuteiNyushoKyojuSeikyugaku(add(集計データ.getTokuteiNyushoKyojuSeikyugaku(), entity.getTokuteiNyushoKyojuSeikyugaku()));
        集計データ.setTokuteiNyushoKyojuRiyoshaFutangaku(add(集計データ.getTokuteiNyushoKyojuRiyoshaFutangaku(),
                entity.getTokuteiNyushoKyojuRiyoshaFutangaku()));
        集計データ.setShafukuRiyoshaFutangaku(add(集計データ.getShafukuRiyoshaFutangaku(), entity.getShafukuRiyoshaFutangaku()));
        集計データ.setShafukuKeigengaku(add(集計データ.getShafukuKeigengaku(), entity.getShafukuKeigengaku()));
        集計データ.setShafukuKeigengoRiyoshaFutangaku(add(集計データ.getShafukuKeigengoRiyoshaFutangaku(), entity.getShafukuKeigengoRiyoshaFutangaku()));
        return 集計データ;
    }

    /**
     * 集計データ登録2情報を作成します。
     *
     * @param entity 受給者台帳一時テーブルEntity
     * @return 集計データ登録2情報
     */
    public DbWT1513RiyoJokyoTokeihyoEntity create集計データ登録2(DbWT1512JukyushaDaichoEntity entity) {
        DbWT1513RiyoJokyoTokeihyoEntity 集計データ = new DbWT1513RiyoJokyoTokeihyoEntity();
        集計データ.setShoriShichosonCode(entity.getKyuShichosonCode());
        集計データ.setServiceKubun(RiyojokyoTokeihyo_ServiceKubun.混在.getコード());
        集計データ.setHihokenshaNo(entity.getHihokenshaNo().value());
        if (entity.getServiceTeikyoYM() != null && !entity.getServiceTeikyoYM().isEmpty()) {
            集計データ.setServiceTeikyoYM(entity.getServiceTeikyoYM().toDateString());
        }
        if (entity.getSikibetsuCode() != null) {
            集計データ.setShikibetsuCode(entity.getSikibetsuCode().value());
        }
        if (entity.getYokaigoJotaiKubunCode() != null) {
            集計データ.setYoKaigoJotaiKubunCode(entity.getYokaigoJotaiKubunCode().value());
        }
        集計データ.setNinteiYukoKaishiYMD(flexibleDateToRString(entity.getNinteiYukoKikanKaishiYMD()));
        集計データ.setNinteiYukoShuryoYMD(flexibleDateToRString(entity.getNinteiYukoKikanShuryoYMD()));
        集計データ.setKyotakuServiceSakuseiKubunCode(entity.getKyotakuServiceSakuseiKubunCode());
        RString 宅サービス計画作成区分コード = entity.getKyotakuServiceSakuseiKubunCode();
        if (KyotakuservicekeikakuSakuseikubunCode.指定居宅介護支援事業者作成.getコード().equals(宅サービス計画作成区分コード)
                || KyotakuservicekeikakuSakuseikubunCode.基準該当居宅介護支援事業者作成.getコード().equals(宅サービス計画作成区分コード)) {
            集計データ.setKyotakuServiceShuruiCode(ServiceCategoryShurui.居宅支援.getコード());
        } else if (KyotakuservicekeikakuSakuseikubunCode.介護予防支援事業者作成.getコード().equals(宅サービス計画作成区分コード)) {
            集計データ.setKyotakuServiceShuruiCode(ServiceCategoryShurui.予防支援.getコード());
        }
        集計データ.setKyotakuServiceJigyoshoNo(entity.getKeisakuSakuseiJigyoshaNo());
        集計データ.setKyuSochishaFlag(booleanToRString(entity.isKyuSochishaFlag()));
        集計データ.setShichosonCode(entity.getShichosonCode().value());
        集計データ.setKoikinaiJushochiTokureiFlag(entity.getKoikinaiJushochiTokureiFlag());
        集計データ.setKoikinaiTokureiSochimotoShichosonCode(entity.getKoikinaiTokureiSochimotoShichosonCode());
        集計データ.setKyuShichosonCode(entity.getKyuShichosonCode());
        集計データ.setRiyoJissekiFlag(RiyojokyoTokeihyo_RiyoJissekiKubun.実績なし.getコード());
        集計データ.setNissuKaisu(初期金額または日数_0);
        集計データ.setTankiNyushoJitsunissu(初期金額または日数_0);
        集計データ.setHokenTanisu(初期金額または日数_0);
        集計データ.setHokenTanisuTanka(初期金額または日数_0);
        集計データ.setHokenSeikyugaku(初期金額または日数_0);
        集計データ.setHokenRiyoshaFutangaku(初期金額または日数_0);
        集計データ.setKohi1Tanisu(初期金額または日数_0);
        集計データ.setKohi1Seikyugaku(初期金額または日数_0);
        集計データ.setKohi1HonninFutangaku(初期金額または日数_0);
        集計データ.setKohi2Tanisu(初期金額または日数_0);
        集計データ.setKohi2Seikyugaku(初期金額または日数_0);
        集計データ.setKohi2HonninFutangaku(初期金額または日数_0);
        集計データ.setKohi3Tanisu(初期金額または日数_0);
        集計データ.setKohi3Seikyugaku(初期金額または日数_0);
        集計データ.setKohi3HonninFutangaku(初期金額または日数_0);
        集計データ.setHokenDekidakaTanisu(初期金額または日数_0);
        集計データ.setHokenDekidakaSeikyugaku(初期金額または日数_0);
        集計データ.setHokenDekidakaRiyoshaFutangaku(初期金額または日数_0);
        集計データ.setKohi1DekidakaTanisu(初期金額または日数_0);
        集計データ.setKohi1DekidakaSeikyugaku(初期金額または日数_0);
        集計データ.setKohi1DekidakaHonninFutangaku(初期金額または日数_0);
        集計データ.setKohi2DekidakaTanisu(初期金額または日数_0);
        集計データ.setKohi2DekidakaSeikyugaku(初期金額または日数_0);
        集計データ.setKohi2DekidakaHonninFutangaku(初期金額または日数_0);
        集計データ.setKohi3DekidakaTanisu(初期金額または日数_0);
        集計データ.setKohi3DekidakaSeikyugaku(初期金額または日数_0);
        集計データ.setKohi3DekidakaHonninFutangaku(初期金額または日数_0);
        集計データ.setShokujiKihonNissu(初期金額または日数_0);
        集計データ.setShokujiKihonTanka(初期金額または日数_0);
        集計データ.setShokujiTokubetsuNissu(初期金額または日数_0);
        集計データ.setShokujiTokubetsuTanka(初期金額または日数_0);
        集計データ.setShokujiTeikyohiGokei(初期金額または日数_0);
        集計データ.setNichigakuHyojunFutangaku(初期金額または日数_0);
        集計データ.setShokujiTeikyohiSeikyugaku(初期金額または日数_0);
        集計データ.setGendogakuKanriTaishoTanisu(初期金額または日数_0);
        集計データ.setGendogakuKanritaishogaiTanisu(初期金額または日数_0);
        集計データ.setSaishinsaKaisu(初期金額または日数_0);
        集計データ.setKagoKaisu(初期金額または日数_0);
        集計データ.setHomonShikyuGendogaku(初期金額または日数_0);
        集計データ.setHomonRiyoServiceTanisu(初期金額または日数_0);
        集計データ.setTankiShikyuGendogaku(初期金額または日数_0);
        集計データ.setTankiRiyoServiceTanisu(初期金額または日数_0);
        集計データ.setGaihakuNissu(初期金額または日数_0);
        集計データ.setTokuteiNyushoShokuhiNissu(初期金額または日数_0);
        集計データ.setTokuteiNyushoShokuhiHiyogaku(初期金額または日数_0);
        集計データ.setTokuteiNyushoShokuhiSeikyugaku(初期金額または日数_0);
        集計データ.setTokuteiNyushoShokuhiRiyoshaFutangaku(初期金額または日数_0);
        集計データ.setTokuteiNyushoKyojuNissu(初期金額または日数_0);
        集計データ.setTokuteiNyushoKyojuHiyogaku(初期金額または日数_0);
        集計データ.setTokuteiNyushoKyojuSeikyugaku(初期金額または日数_0);
        集計データ.setTokuteiNyushoKyojuRiyoshaFutangaku(初期金額または日数_0);
        集計データ.setShafukuKeigenritsu(初期金額または日数_0);
        集計データ.setShafukuRiyoshaFutangaku(初期金額または日数_0);
        集計データ.setShafukuKeigengaku(初期金額または日数_0);
        集計データ.setShafukuKeigengoRiyoshaFutangaku(初期金額または日数_0);
        集計データ.setMeisaiOutFlag(new RString("0"));
        return 集計データ;
    }

    /**
     * 被保険者台帳宛名情報を作成します。
     *
     * @param entity 被保険者台帳・宛名情報のEntityクラス
     * @param 帳票住所編集クラス 帳票住所編集クラス
     * @return 更新用被保険者台帳宛名情報
     */
    public DbWT1513RiyoJokyoTokeihyoEntity create被保険者台帳宛名情報(HihokenshaAtenaJohoEntity entity, ChohyoJushoEditor 帳票住所編集クラス) {
        DbWT1513RiyoJokyoTokeihyoEntity updateEntity = entity.getDbWT1513Entity();
        UaFt200FindShikibetsuTaishoEntity uaFt200Entity = entity.getUaFt200Entity();
        IShikibetsuTaisho 宛名識別対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(uaFt200Entity);
        if (RString.isNullOrEmpty(updateEntity.getShikibetsuCode())) {
            ShikibetsuCode 識別コード = 宛名識別対象.get識別コード();
            if (識別コード != null) {
                updateEntity.setShikibetsuCode(識別コード.value());
            }
        }
        updateEntity = set宛名(updateEntity, 宛名識別対象);
        IJusho 住所 = 宛名識別対象.get住所();
        if (住所 != null && 住所.get町域コード() != null) {
            updateEntity.setChoikiCode(住所.get町域コード().value());
        }
        RString 行政区画名称 = RString.EMPTY;
        IGyoseiKukaku 行政区画 = 宛名識別対象.get行政区画();
        if (行政区画 != null && 行政区画.getGyoseiku() != null && 行政区画.getGyoseiku().getコード() != null) {
            updateEntity.setGyoseikuCode(行政区画.getGyoseiku().getコード().value());
            行政区画名称 = 行政区画.getGyoseiku().get名称();
            updateEntity.setGyoseikuMei(行政区画名称);
        }
        if (住所 != null && 住所.get郵便番号() != null) {
            updateEntity.setYubinNo(住所.get郵便番号().value());
        }
        RString 管内管外区分 = RString.EMPTY;
        RString 住所str = RString.EMPTY;
        RString 番地 = RString.EMPTY;
        RString 方書 = RString.EMPTY;
        if (住所 != null && 住所.get管内管外() != null) {
            管内管外区分 = 住所.get管内管外().code();
            住所str = 住所.get住所();
        }
        if (住所 != null && 住所.get番地() != null) {
            Banchi 住所番地 = 住所.get番地();
            if (住所番地 != null && 住所番地.getBanchi() != null) {
                番地 = 住所番地.getBanchi().value();
            }
        }
        if (住所 != null && 住所.get方書() != null) {
            方書 = 住所.get方書().value();
        }
        DbV1001HihokenshaDaichoEntity 被保険者台帳管理 = entity.getDbV1001Entity();
        LasdecCode 市町村コード;
        if (new RString("1").equals(被保険者台帳管理.getKoikinaiJushochiTokureiFlag())) {
            市町村コード = 被保険者台帳管理.getKoikinaiTokureiSochimotoShichosonCode();
        } else {
            市町村コード = 被保険者台帳管理.getShichosonCode();
        }
        updateEntity.setJusho(帳票住所編集クラス.editJusho(管内管外区分, 住所str, 番地, 方書, 行政区画名称, 市町村コード));

        return set行政区(updateEntity, 行政区画);
    }

    /**
     * 日付(YYMMDD)がNULLかどうかを判断します。
     *
     * @param date 変換前日付
     * @return 判断結果
     */
    public static boolean isEmpty(FlexibleDate date) {
        return date == null || date.isEmpty();
    }

    /**
     * 日付(YYMM)がNULLかどうかを判断します。
     *
     * @param date 日付
     * @return 判断結果
     */
    public static boolean isEmpty(FlexibleYearMonth date) {
        return date == null || date.isEmpty();
    }

    /**
     * DecimalをRStringを変換します。
     *
     * @param decimal 変換前数値
     * @return 変換後数値
     */
    public static RString decimaltoRString(Decimal decimal) {

        if (decimal == null) {
            return 初期金額または日数_0;
        }
        return new RString(decimal.toString());
    }

    private DbWT1513RiyoJokyoTokeihyoEntity set宛名(DbWT1513RiyoJokyoTokeihyoEntity updateEntity, IShikibetsuTaisho 宛名識別対象) {
        IName 名称 = 宛名識別対象.get名称();
        if (名称 != null) {
            if (名称.getKana() != null) {
                updateEntity.setShimeiKana(名称.getKana().value());
                updateEntity.setShimei50onKana(RStringUtil.convertTo清音化(名称.getKana().value()));
            }
            if (名称.getName() != null) {
                updateEntity.setShimei(名称.getName().value());
            }
        }
        if (宛名識別対象.canBe個人()) {
            IKojin 個人 = 宛名識別対象.to個人();
            if (RString.isNullOrEmpty(updateEntity.getSeibetsuCode())) {
                updateEntity.setSeibetsuCode(個人.get性別().getCode());
            }
            if (RString.isNullOrEmpty(updateEntity.getSeinenYMD()) && 個人.get生年月日() != null) {
                updateEntity.setSeinenYMD(new RString(個人.get生年月日().toFlexibleDate().toString()));
            }
        } else {
            updateEntity.setSeibetsuCode(RString.EMPTY);
            updateEntity.setSeinenYMD(RString.EMPTY);
        }
        return updateEntity;
    }

    private DbWT1513RiyoJokyoTokeihyoEntity set行政区(DbWT1513RiyoJokyoTokeihyoEntity updateEntity, IGyoseiKukaku 行政区画) {
        if (行政区画 != null) {
            Chiku 地区1 = 行政区画.getChiku1();
            Chiku 地区2 = 行政区画.getChiku2();
            Chiku 地区3 = 行政区画.getChiku3();
            if (地区1 != null && 地区1.getコード() != null) {
                updateEntity.setChikuCode1(地区1.getコード().value());
                updateEntity.setChikuMei1(地区1.get名称());
            }
            if (地区2 != null && 地区2.getコード() != null) {
                updateEntity.setChikuCode2(地区2.getコード().value());
                updateEntity.setChikuMei2(地区2.get名称());
            }
            if (地区3 != null && 地区3.getコード() != null) {
                updateEntity.setChikuCode3(地区3.getコード().value());
                updateEntity.setChikuMei3(地区3.get名称());
            }
        }
        return updateEntity;
    }

    private RString flexibleDateToRString(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }

    private RString booleanToRString(boolean bol) {
        return bol ? new RString("1") : new RString("0");
    }

    /**
     * IntegerをRStringを変換します。
     *
     * @param intValue 変換前数値
     * @return 変換後数値
     */
    public static RString integertoRString(Integer intValue) {

        if (intValue == null) {
            return 初期金額または日数_0;
        }
        return new RString(intValue.toString());
    }

    private DbWT1513RiyoJokyoTokeihyoEntity create給付実績データ共通(DbWT1510KyufuJissekiKihonEntity entity) {
        DbWT1513RiyoJokyoTokeihyoEntity 利用状況統計表一時 = new DbWT1513RiyoJokyoTokeihyoEntity();
        利用状況統計表一時.setDataKubun(RiyojokyoTokeihyo_DataKubun.明細.getコード());
        if (entity.getHiHokenshaNo() != null) {
            利用状況統計表一時.setHihokenshaNo(entity.getHiHokenshaNo().value());
        }
        if (!isEmpty(entity.getServiceTeikyoYM())) {
            利用状況統計表一時.setServiceTeikyoYM(entity.getServiceTeikyoYM().toDateString());
        }
        if (!isEmpty(entity.getShinsaYM())) {
            利用状況統計表一時.setShinsaYM(entity.getShinsaYM().toDateString());
        }
        if (entity.getShokisaiHokenshaNo() != null) {
            利用状況統計表一時.setShoKisaiHokenshaNo(entity.getShokisaiHokenshaNo().value());
        }
        利用状況統計表一時.setSeibetsuCode(entity.getSeibetsuCode());
        if (!isEmpty(entity.getUmareYMD())) {
            利用状況統計表一時.setSeinenYMD(new RString(entity.getUmareYMD().toString()));
        }
        利用状況統計表一時.setYoKaigoJotaiKubunCode(entity.getYoKaigoJotaiKubunCode());
        if (!isEmpty(entity.getNinteiYukoKaishiYMD())) {
            利用状況統計表一時.setNinteiYukoKaishiYMD(new RString(entity.getNinteiYukoKaishiYMD().toString()));
        }
        if (!isEmpty(entity.getNinteiYukoShuryoYMD())) {
            利用状況統計表一時.setNinteiYukoShuryoYMD(new RString(entity.getNinteiYukoShuryoYMD().toString()));
        }
        利用状況統計表一時.setKyotakuServiceSakuseiKubunCode(entity.getKyotakuServiceSakuseiKubunCode());
        RString 居宅サービス計画作成区分コード = entity.getKyotakuServiceSakuseiKubunCode();
        if (KyotakuservicekeikakuSakuseikubunCode.指定居宅介護支援事業者作成.getコード().equals(居宅サービス計画作成区分コード)
                || KyotakuservicekeikakuSakuseikubunCode.基準該当居宅介護支援事業者作成.getコード().equals(居宅サービス計画作成区分コード)) {
            利用状況統計表一時.setKyotakuServiceShuruiCode(ServiceCategoryShurui.居宅支援.getコード());
        } else if (KyotakuservicekeikakuSakuseikubunCode.介護予防支援事業者作成.getコード().equals(居宅サービス計画作成区分コード)) {
            利用状況統計表一時.setKyotakuServiceShuruiCode(ServiceCategoryShurui.予防支援.getコード());
        } else {
            利用状況統計表一時.setKyotakuServiceShuruiCode(RString.EMPTY);
        }
        利用状況統計表一時.setKyotakuServiceJigyoshoNo(entity.getJigyoshoNo().value());

        if (KyuSochiNyushoshaTokureiCode.有り.getコード().equals(entity.getKyuSochiNyushoshaTokureiCode())) {
            利用状況統計表一時.setKyuSochishaFlag(new RString("1"));
        } else {
            利用状況統計表一時.setKyuSochishaFlag(new RString("0"));
        }
        利用状況統計表一時.setKohi1JukyushaNo(entity.getKohi1JukyushaNo());
        利用状況統計表一時.setKohi2FutanshaNo(entity.getKohi2FutanshaNo());
        利用状況統計表一時.setKohi2JukyushaNo(entity.getKohi2JukyushaNo());
        利用状況統計表一時.setKohi3FutanshaNo(entity.getKohi3FutanshaNo());
        利用状況統計表一時.setKohi3JukyushaNo(entity.getKohi3JukyushaNo());
        利用状況統計表一時.setRojinHokenShichosonNo(entity.getRojinHokenShichosonNo());
        利用状況統計表一時.setRojinhokenJukyushaNo(entity.getRojinhokenJukyushaNo());
        利用状況統計表一時.setKokiHokenshaNo(entity.getKokiHokenshaNo());
        利用状況統計表一時.setKokiHihokenshaNo(entity.getKokiHiHokenshaNo());
        利用状況統計表一時.setKokuhoHokenshaNo(entity.getKokuhoHokenshaNo());
        利用状況統計表一時.setKokuhoHihokenshashoNo(entity.getKokuhoHiHokenshashoNo());
        利用状況統計表一時.setKokuhoKojinNo(entity.getKokuhoKojinNo());
        if (entity.getHokenKyufuritsu() != null) {
            利用状況統計表一時.setHokenKyufuritsu(new RString(entity.getHokenKyufuritsu().value().toString()));
        }
        利用状況統計表一時.setKyufuJissekiKubunCode(entity.getKyufuJissekiKubunCode());
        if (entity.getJigyoshoNo() != null) {
            利用状況統計表一時.setJigyoshoNo(entity.getJigyoshoNo().value());
        }
        return 利用状況統計表一時;
    }

    private RString get日数回数(RString サービス種類コード, List<KyuhuJissekiMeisaiEntity> 給付実績明細ワーク) {

        Integer 日数回数 = ZERO;
        for (KyuhuJissekiMeisaiEntity 明細 : 給付実績明細ワーク) {
            Integer 明細日数回数 = ZERO;
            RString 明細種類コード = RString.EMPTY;
            if (明細.getEntity() != null) {
                明細種類コード = 明細.getEntity().getServiceShuruiCode().value();
                明細日数回数 = 明細.getEntity().getAtoNissuKaisu();
            }
            if (サービス種類コード.equals(明細種類コード)
                    && !((サービス種類コード.equals(ServiceCategoryShurui.訪問介護.getコード())
                    || サービス種類コード.equals(ServiceCategoryShurui.訪問入浴.getコード())
                    || サービス種類コード.equals(ServiceCategoryShurui.予訪介護.getコード())
                    || サービス種類コード.equals(ServiceCategoryShurui.予訪入浴.getコード()))
                    && (EIGHT <= Integer.parseInt(明細.getEntity().getServiceKomokuCode().value().toString())))
                    || ((サービス種類コード.equals(ServiceCategoryShurui.訪問看護.getコード())
                    || サービス種類コード.equals(ServiceCategoryShurui.予訪看護.getコード()))
                    && (THREE <= Integer.parseInt(明細.getEntity().getServiceKomokuCode().value().toString())))) {
                日数回数 = 日数回数 + 明細日数回数;
            }
        }
        return new RString(日数回数.toString());
    }

    private RString get居宅介護サービス日数回数(DbT3033KyufujissekiShukeiEntity 集計費, List<KyuhuJissekiMeisaiEntity> 給付実績明細ワーク) {

        RString サービス種類コード = 集計費.getServiceSyuruiCode().value();
        if (ServiceCategoryShurui.用具貸与.getコード().equals(サービス種類コード)
                || ServiceCategoryShurui.予用貸与.getコード().equals(サービス種類コード)) {
            int count = ZERO;
            for (KyuhuJissekiMeisaiEntity 明細 : 給付実績明細ワーク) {
                RString 明細サービス種類コード = 明細.getEntity().getServiceShuruiCode().value();
                if (明細サービス種類コード.equals(サービス種類コード)) {
                    count++;
                }
                return new RString(String.valueOf(count));
            }
        } else if (ServiceCategoryShurui.通所介護.getコード().equals(サービス種類コード)
                || ServiceCategoryShurui.通所リハ.getコード().equals(サービス種類コード)
                || ServiceCategoryShurui.予通介護.getコード().equals(サービス種類コード)
                || ServiceCategoryShurui.予通リハ.getコード().equals(サービス種類コード)
                || ServiceCategoryShurui.地通所介.getコード().equals(サービス種類コード)
                || ServiceCategoryShurui.地予通所.getコード().equals(サービス種類コード)) {
            return new RString(String.valueOf(集計費.getServiceJitsunissu()));
        }
        return get日数回数(サービス種類コード, 給付実績明細ワーク);
    }

    /**
     * RString型数字加算処理します。
     *
     * @param data1 data1
     * @param data2 data2
     * @return 加算結果
     */
    public static RString add(RString data1, RString data2) {
        Decimal decimal1;
        Decimal decimal2;
        if (RString.isNullOrEmpty(data1)) {
            decimal1 = Decimal.ZERO;
        } else {
            decimal1 = new Decimal(data1.toString());
        }
        if (RString.isNullOrEmpty(data2)) {
            decimal2 = Decimal.ZERO;
        } else {
            decimal2 = new Decimal(data2.toString());
        }
        Decimal result = decimal1.add(decimal2);
        return new RString(result.toString());
    }

    /**
     * 出力条件表を編集します。
     *
     * @param parameter 利用状況統計表（明細リスト）作成のProcessParameter
     * @return 出力条件表
     */
    public List<RString> getOutputJokenhyoParam(RiyojokyoTokeihyoMeisaiListProcessParameter parameter) {
        List<RString> outputJokenhyoList = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(対象年月);
        builder.append(Tokeihyo_TaishoNengetsu.toValue(parameter.get対象年月()).get名称());
        outputJokenhyoList.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(年月範囲);
        if (!parameter.get開始年月().equals(parameter.get終了年月())) {
            builder.append(get和暦年月(parameter.get開始年月()));
            builder.append(KARA);
            builder.append(get和暦年月(parameter.get終了年月()));
        } else {
            builder.append(get和暦年月(parameter.get開始年月()));
        }
        outputJokenhyoList.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(被保険者番号);
        if (parameter.get被保険者番号() != null && !parameter.get被保険者番号().isEmpty()) {
            builder.append(parameter.get被保険者番号().value());
        }
        outputJokenhyoList.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(事業者番号);
        if (parameter.get事業者番号() != null && !parameter.get事業者番号().isEmpty()) {
            builder.append(parameter.get事業者番号().value());
        }
        outputJokenhyoList.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(利用実績);
        builder.append(RiyojokyoTokeihyo_RiyoJissekiKubun.toValue(parameter.get利用実績区分()).get名称());
        outputJokenhyoList.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(居宅利用率);
        if (居宅利用率指定.equals(parameter.get居宅利用率指定())) {
            builder.append(parameter.get開始居宅利用率());
            builder.append(PERCENT);
            builder.append(KARA);
            builder.append(parameter.get終了居宅利用率());
            builder.append(PERCENT);
        }
        outputJokenhyoList.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(訪問利用率);
        if (訪問利用率指定.equals(parameter.get訪問利用率指定())) {
            builder.append(parameter.get開始訪問利用率());
            builder.append(PERCENT);
            builder.append(KARA);
            builder.append(parameter.get終了訪問利用率());
            builder.append(PERCENT);
        }
        outputJokenhyoList.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(地区指定);
        builder.append(get地区指定(parameter.get地区指定()));
        if (!地区指定_全て.equals(parameter.get地区指定())) {
            Set<RString> keyList = parameter.get選択地区リスト().keySet();
            for (RString key : keyList) {
                builder.append(new RString(System.lineSeparator()));
                builder.append(key);
                builder.append(コロン);
                builder.append(parameter.get選択地区リスト().get(key));
            }
        }
        outputJokenhyoList.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(市町村);
        RString 市町村コード = parameter.get市町村コード();
        if (!RString.isNullOrEmpty(市町村コード) && !市町村コード_全て.equals(市町村コード)) {
            builder.append(get保険者情報(parameter.get導入形態コード(), 市町村コード,
                    parameter.get旧市町村コード()).getShichosonMeisho());
        } else if (市町村コード_全て.equals(市町村コード)) {
            builder.append(全て);
        }
        outputJokenhyoList.add(builder.toRString());
        builder = new RStringBuilder();
        RString 旧市町村コード = parameter.get旧市町村コード();
        builder.append(旧市町村);
        if (!RString.isNullOrEmpty(旧市町村コード) && !市町村コード_全て.equals(旧市町村コード)) {
            builder.append(parameter.get旧市町村名称());
        } else if (市町村コード_全て.equals(旧市町村コード)) {
            builder.append(全て);
        }
        outputJokenhyoList.add(builder.toRString());
        return outputJokenhyoList;
    }

    private RString get和暦年月(FlexibleYearMonth 年月) {
        return 年月.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString get地区指定(RString 地区指定Str) {
        RString result = RString.EMPTY;
        if (地区指定_全て.equals(地区指定Str)) {
            result = 全て;
        } else if (地区指定_町域.equals(地区指定Str)) {
            result = 町域;
        } else if (地区指定_行政区.equals(地区指定Str)) {
            result = 行政区;
        } else if (地区指定_地区1.equals(地区指定Str)) {
            result = JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類１);
        } else if (地区指定_地区2.equals(地区指定Str)) {
            result = JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類２);
        } else if (地区指定_地区3.equals(地区指定Str)) {
            result = JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類３);
        }
        return result;
    }

    /**
     * 出力条件表を編集します。
     *
     * @param parameter 利用状況統計表（明細リスト）作成のProcessParameter
     * @return 出力条件表
     */
    public List<RString> getOutputJokenhyoParam(CreateRiyojokyoIchiranHyoProcessParameter parameter) {
        List<RString> outputJokenhyoList = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(対象年月);
        builder.append(Tokeihyo_TaishoNengetsu.toValue(parameter.get対象年月()).get名称());
        outputJokenhyoList.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(年月範囲);
        FlexibleYearMonth 開始年月 = FlexibleYearMonth.EMPTY;
        if (!RString.isNullOrEmpty(parameter.get開始年月())) {
            開始年月 = new FlexibleYearMonth(parameter.get開始年月());
        }
        FlexibleYearMonth 終了年月 = FlexibleYearMonth.EMPTY;
        if (!RString.isNullOrEmpty(parameter.get終了年月())) {
            終了年月 = new FlexibleYearMonth(parameter.get終了年月());
        }
        if (!開始年月.equals(終了年月)) {
            builder.append(get和暦年月(開始年月));
            builder.append(KARA);
            builder.append(get和暦年月(終了年月));
        } else {
            builder.append(get和暦年月(開始年月));
        }
        outputJokenhyoList.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(被保険者番号);
        if (parameter.get被保険者番号() != null && !parameter.get被保険者番号().isEmpty()) {
            builder.append(parameter.get被保険者番号());
        }
        outputJokenhyoList.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(事業者番号);
        if (parameter.get事業者番号() != null && !parameter.get事業者番号().isEmpty()) {
            builder.append(parameter.get事業者番号());
        }
        outputJokenhyoList.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(利用実績);
        builder.append(RiyojokyoTokeihyo_RiyoJissekiKubun.toValue(parameter.get利用実績区分()).get名称());
        outputJokenhyoList.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(居宅利用率);
        if (居宅利用率指定.equals(parameter.get居宅利用率指定())) {
            builder.append(parameter.get開始居宅利用率());
            builder.append(PERCENT);
            builder.append(KARA);
            builder.append(parameter.get終了居宅利用率());
            builder.append(PERCENT);
        }
        outputJokenhyoList.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(訪問利用率);
        if (訪問利用率指定.equals(parameter.get訪問利用率指定())) {
            builder.append(parameter.get開始訪問居宅利用率());
            builder.append(PERCENT);
            builder.append(KARA);
            builder.append(parameter.get終了訪問居宅利用率());
            builder.append(PERCENT);
        }
        outputJokenhyoList.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(地区指定);
        builder.append(get地区指定(parameter.get地区指定()));
        if (!地区指定_全て.equals(parameter.get地区指定())) {
            Set<RString> keyList = parameter.get選択地区リスト().keySet();
            for (RString key : keyList) {
                builder.append(new RString(System.lineSeparator()));
                builder.append(key);
                builder.append(コロン);
                builder.append(parameter.get選択地区リスト().get(key));
            }
        }
        outputJokenhyoList.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(市町村);
        RString 市町村コード = parameter.get市町村コード();
        if (!RString.isNullOrEmpty(市町村コード) && !市町村コード_全て.equals(市町村コード)) {
            builder.append(get保険者情報(parameter.get導入形態コード(), 市町村コード,
                    parameter.get旧市町村コード()).getShichosonMeisho());
        } else if (市町村コード_全て.equals(市町村コード)) {
            builder.append(全て);
        }
        outputJokenhyoList.add(builder.toRString());
        builder = new RStringBuilder();
        RString 旧市町村コード = parameter.get旧市町村コード();
        builder.append(旧市町村);
        if (!RString.isNullOrEmpty(旧市町村コード) && !市町村コード_全て.equals(旧市町村コード)) {
            builder.append(parameter.get旧市町村名称());
        } else if (市町村コード_全て.equals(旧市町村コード)) {
            builder.append(全て);
        }
        outputJokenhyoList.add(builder.toRString());
        return outputJokenhyoList;
    }

    /**
     * 保険者情報等を設定します。
     *
     * @param 導入形態コード 導入形態コード
     * @param 市町村コード 市町村コード
     * @param 旧市町村コード 旧市町村コード
     * @return 保険者情報
     */
    public DbT7051KoseiShichosonMasterEntity get保険者情報(RString 導入形態コード, RString 市町村コード, RString 旧市町村コード) {
        DbT7051KoseiShichosonMasterEntity entity;
        if ((DonyuKeitaiCode.toValue(導入形態コード).is単一() && RString.isNullOrEmpty(市町村コード))
                || (DonyuKeitaiCode.toValue(導入形態コード).is広域() && RString.isNullOrEmpty(旧市町村コード))) {
            entity = new DbT7051KoseiShichosonMasterEntity();
            entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(DbBusinessConfig.get(
                    ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)));
            entity.setShichosonMeisho(DbBusinessConfig.get(
                    ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        } else if (DonyuKeitaiCode.toValue(導入形態コード).is広域() && !RString.isNullOrEmpty(旧市町村コード)
                && !市町村コード_全て.equals(旧市町村コード)) {
            entity = 構成市町村マスタDac.select保険者情報(new LasdecCode(市町村コード));
            if (entity == null) {
                new JournalWriter().writeErrorJournal(RDateTime.now(), MESSAGE);
                throw new BatchGyomuException(UrErrorMessages.実行不可.getMessage().replace(
                        構成市町村情報の取得.toString()));
            }
        } else {
            entity = new DbT7051KoseiShichosonMasterEntity();
            entity.setShoKisaiHokenshaNo(ShoKisaiHokenshaNo.EMPTY);
            entity.setShichosonMeisho(RString.EMPTY);
        }
        return entity;
    }

    /**
     * 利用状況一覧表CSVファイルEntityを作成します。
     *
     * @param 保険者情報 保険者情報
     * @param entity 利用状況統計表（明細リスト）作成のEntityクラス
     * @param parameter 利用状況一覧表作成のProcessParameterのクラス
     * @param 連番 連番
     * @return 利用状況一覧表CSVファイルEntity
     */
    public IRiyoJokyoIchiranEUCEntity createEUCEntity(DbT7051KoseiShichosonMasterEntity 保険者情報,
            DbWT1513RiyoJokyoTokeihyoEntity entity,
            CreateRiyojokyoIchiranHyoProcessParameter parameter, int 連番) {
        if (Tokeihyo_CSVEditKubun.する.getコード().equals(parameter.get連番付加())) {
            RiyoJokyoIchiranSeqAriEUCEntity seqAriEntity = createAriEucEntity(保険者情報, entity, parameter);
            seqAriEntity.setSeq(new RString(String.valueOf(連番)).padLeft(前ゼロ, NINE));
            return seqAriEntity;
        } else {
            return createEucNashiEntity(保険者情報, entity, parameter);
        }
    }

    private DbWT1513RiyoJokyoTokeihyoEntity get短期利用サービス単位数合計(DbWT1513RiyoJokyoTokeihyoEntity 利用状況統計表一時,
            List<KyuhuJissekiMeisaiEntity> 給付実績明細ワーク, Decimal 短期利用サービス単位数合計, DbWT1510KyufuJissekiKihonEntity entity,
            boolean isError, RString 集計サービス種類コード, List<RString> 支給限度額一本化年月対象List,
            RString 入力識別番号上3桁, RString 入力識別番号上4桁, DbT3033KyufujissekiShukeiEntity 集計費,
            BatchEntityCreatedTempTableWriter 処理結果確認リスト一時TBL, List<RString> 入所院実日数対象List) {
        if (支給限度額一本化年月対象List.contains(入力識別番号上3桁) || 支給限度額一本化年月対象List.contains(入力識別番号上4桁)) {
            for (KyuhuJissekiMeisaiEntity 明細 : 給付実績明細ワーク) {
                if (集計サービス種類コード.equals(明細.getEntity().getServiceShuruiCode().value())
                        && FLAG_TRUE.equals(明細.getServiceShuruiFlag()) && FLAG_FALSE.equals(明細.getGendogakuTaishogaiFlag())) {
                    短期利用サービス単位数合計 = 短期利用サービス単位数合計.add(明細.getEntity().getAtoServiceTanisu());
                } else if (集計サービス種類コード.equals(明細.getEntity().getServiceShuruiCode().value())
                        && FLAG_FALSE.equals(明細.getServiceShuruiFlag())) {
                    短期利用サービス単位数合計 = 短期利用サービス単位数合計.add(明細.getEntity().getAtoServiceTanisu());
                    isError = true;
                }
            }
        }
        利用状況統計表一時.setTankiRiyoServiceTanisu(decimaltoRString(短期利用サービス単位数合計));
        if (isError) {
            DbWT1514ShoriKekkaKakuninListEntity サービスコードデータなしEntity = new DbWT1514ShoriKekkaKakuninListEntity();
            サービスコードデータなしEntity.setErrorKubun(Tokeihyo_ErrorKubun.サービスコードデータなし.getコード());
            サービスコードデータなしEntity.setShoKisaiHokenshaNo(集計費.getShokisaiHokenshaNo());
            サービスコードデータなしEntity.setHihokenshaNo(集計費.getHiHokenshaNo());
            サービスコードデータなしEntity.setKey1(集計費.getServiceTeikyoYM().toDateString());
            サービスコードデータなしEntity.setKey2(集計費.getJigyoshoNo().value());
            サービスコードデータなしEntity.setKey3(集計費.getInputShikibetsuNo().value());
            サービスコードデータなしEntity.setKey4(集計費.getToshiNo());
            サービスコードデータなしEntity.setKey5(集計費.getServiceSyuruiCode().value());
            処理結果確認リスト一時TBL.insert(サービスコードデータなしEntity);
        }

        if (入所院実日数対象List.contains(入力識別番号上3桁) || 入所院実日数対象List.contains(入力識別番号上4桁)) {
            利用状況統計表一時.setGaihakuNissu(integertoRString(entity.getGaihakuNissu()));
        } else {
            利用状況統計表一時.setGaihakuNissu(初期金額または日数_0);
        }
        return 利用状況統計表一時;
    }

    private DbWT1513RiyoJokyoTokeihyoEntity is入所院実日数対象List(DbWT1513RiyoJokyoTokeihyoEntity 利用状況統計表一時,
            List<RString> サービス種類コードList, List<RString> 入所院実日数対象List, RString 入力識別番号上3桁,
            List<RString> 支給限度額一本化年月対象List, RString 集計サービス種類コード,
            List<DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity> 給付実績特定入所者介護サービス費用ワーク) {
        Integer 日数食費 = ZERO;
        Decimal 費用額食費 = Decimal.ZERO;
        Decimal 保険分請求額食費 = Decimal.ZERO;
        Decimal 利用者負担額食費 = Decimal.ZERO;
        Integer 日数居住 = ZERO;
        Decimal 費用額居住 = Decimal.ZERO;
        Decimal 保険分請求額居住 = Decimal.ZERO;
        Decimal 利用者負担額居住 = Decimal.ZERO;
        Integer 特定日数食費 = ZERO;
        if ((入所院実日数対象List.contains(入力識別番号上3桁) || 支給限度額一本化年月対象List.contains(入力識別番号上3桁))
                && サービス種類コードList.contains(集計サービス種類コード)) {
            for (DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity 特定 : 給付実績特定入所者介護サービス費用ワーク) {
                RString サービス項目コードの3桁目 = 特定.getServiceKomokuCode().value().substring(TWO, THREE);
                if (特定.getAtoNissu() != null) {
                    特定日数食費 = 特定.getAtoNissu();
                }
                if (new RString("1").equals(サービス項目コードの3桁目)) {
                    日数食費 = 日数食費 + 特定日数食費;
                    費用額食費 = 費用額食費.add(特定.getAtoHiyogaku());
                    保険分請求額食費 = 保険分請求額食費.add(特定.getAtoHokenbunSeikyugaku());
                    利用者負担額食費 = 利用者負担額食費.add(特定.getAtoRiyoshaFutangaku());
                } else if (new RString("2").equals(サービス項目コードの3桁目)) {
                    日数居住 = 日数居住 + 特定日数食費;
                    費用額居住 = 費用額居住.add(特定.getAtoHiyogaku());
                    保険分請求額居住 = 保険分請求額居住.add(特定.getAtoHokenbunSeikyugaku());
                    利用者負担額居住 = 利用者負担額居住.add(特定.getAtoRiyoshaFutangaku());
                }
            }
        }
        利用状況統計表一時.setTokuteiNyushoShokuhiNissu(integertoRString(日数食費));
        利用状況統計表一時.setTokuteiNyushoShokuhiHiyogaku(decimaltoRString(費用額食費));
        利用状況統計表一時.setTokuteiNyushoShokuhiSeikyugaku(decimaltoRString(保険分請求額食費));
        利用状況統計表一時.setTokuteiNyushoShokuhiRiyoshaFutangaku(decimaltoRString(利用者負担額食費));
        利用状況統計表一時.setTokuteiNyushoKyojuNissu(integertoRString(日数居住));
        利用状況統計表一時.setTokuteiNyushoKyojuHiyogaku(decimaltoRString(費用額居住));
        利用状況統計表一時.setTokuteiNyushoKyojuSeikyugaku(decimaltoRString(保険分請求額居住));
        利用状況統計表一時.setTokuteiNyushoKyojuRiyoshaFutangaku(decimaltoRString(利用者負担額居住));
        return 利用状況統計表一時;
    }

    private DbWT1513RiyoJokyoTokeihyoEntity create給付実績データ集計_分(DbWT1513RiyoJokyoTokeihyoEntity 利用状況統計表一時,
            RString 入力識別番号上3桁, RString 集計サービス種類コード, List<KyuhuJissekiMeisaiEntity> 給付実績明細ワーク,
            DbWT1510KyufuJissekiKihonEntity entity, BatchEntityCreatedTempTableWriter 処理結果確認リスト一時TBL, List<RString> 入所院実日数対象List,
            List<RString> 支給限度額一本化年月対象List, RString 入力識別番号上4桁, DbT3033KyufujissekiShukeiEntity 集計費,
            List<DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity> 給付実績特定入所者介護サービス費用ワーク,
            List<DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity> 給付実績社会福祉法人軽減額ワーク) {
        Decimal 訪問利用サービス単位数合計 = Decimal.ZERO;
        boolean isError = false;
        if ((NyuryokuShikibetsuNoTop3Keta.現物_居宅介護サービス.getコード().equals(入力識別番号上3桁)
                || NyuryokuShikibetsuNoTop3Keta.償還_居宅介護サービス.getコード().equals(入力識別番号上3桁))
                && (ServiceCategoryShurui.療養指導.getコード().equals(集計サービス種類コード)
                || ServiceCategoryShurui.予療養指.getコード().equals(集計サービス種類コード))) {
            for (KyuhuJissekiMeisaiEntity 明細 : 給付実績明細ワーク) {
                if (集計サービス種類コード.equals(明細.getEntity().getServiceShuruiCode().value()) && FLAG_TRUE.equals(明細.getServiceShuruiFlag())
                        && FLAG_FALSE.equals(明細.getGendogakuTaishogaiFlag())) {
                    訪問利用サービス単位数合計 = 訪問利用サービス単位数合計.add(明細.getEntity().getAtoServiceTanisu());
                } else if (集計サービス種類コード.equals(明細.getEntity().getServiceShuruiCode().value())
                        && FLAG_FALSE.equals(明細.getServiceShuruiFlag())) {
                    訪問利用サービス単位数合計 = 訪問利用サービス単位数合計.add(明細.getEntity().getAtoServiceTanisu());
                    isError = true;
                }
            }
        }
        利用状況統計表一時.setHomonRiyoServiceTanisu(decimaltoRString(訪問利用サービス単位数合計));
        利用状況統計表一時.setTankiShikyuGendogaku(初期金額または日数_0);
        利用状況統計表一時.setTankiRiyoServiceTanisu(初期金額または日数_0);
        Decimal 短期利用サービス単位数合計 = Decimal.ZERO;
        get短期利用サービス単位数合計(利用状況統計表一時, 給付実績明細ワーク, 短期利用サービス単位数合計, entity,
                isError, 集計サービス種類コード, 支給限度額一本化年月対象List, 入力識別番号上3桁, 入力識別番号上4桁, 集計費,
                処理結果確認リスト一時TBL, 入所院実日数対象List);
        利用状況統計表一時.setTaishogoJotaiCode(entity.getTaishogoJotaiCode());
        List<RString> サービス種類コードList = new ArrayList<>();
        サービス種類コードList.add(ServiceCategoryShurui.短期生活.getコード());
        サービス種類コードList.add(ServiceCategoryShurui.短期老健.getコード());
        サービス種類コードList.add(ServiceCategoryShurui.短期医療.getコード());
        サービス種類コードList.add(ServiceCategoryShurui.予短介護.getコード());
        サービス種類コードList.add(ServiceCategoryShurui.予短老健.getコード());
        サービス種類コードList.add(ServiceCategoryShurui.予短医療.getコード());
        サービス種類コードList.add(ServiceCategoryShurui.福祉施設.getコード());
        サービス種類コードList.add(ServiceCategoryShurui.老健施設.getコード());
        サービス種類コードList.add(ServiceCategoryShurui.医療施設.getコード());
        サービス種類コードList.add(ServiceCategoryShurui.地福祉生.getコード());

        is入所院実日数対象List(利用状況統計表一時, サービス種類コードList, 入所院実日数対象List, 入力識別番号上3桁, 支給限度額一本化年月対象List,
                集計サービス種類コード, 給付実績特定入所者介護サービス費用ワーク);

        List<RString> 社会福祉法人軽減額対象List = new ArrayList<>();
        社会福祉法人軽減額対象List.add(NyuryokuShikibetsuNoTop3Keta.現物_居宅介護サービス.getコード());
        社会福祉法人軽減額対象List.add(NyuryokuShikibetsuNoTop3Keta.償還_居宅介護サービス.getコード());
        社会福祉法人軽減額対象List.add(NyuryokuShikibetsuNoTop3Keta.現物_短期入所生活介護.getコード());
        社会福祉法人軽減額対象List.add(NyuryokuShikibetsuNoTop3Keta.償還_短期入所生活介護.getコード());
        社会福祉法人軽減額対象List.add(NyuryokuShikibetsuNoTop3Keta.現物_福祉施設_地域福祉施設.getコード());
        社会福祉法人軽減額対象List.add(NyuryokuShikibetsuNoTop3Keta.償還_福祉施設_地域福祉施設.getコード());

        List<RString> 社会福祉法人軽減額対象サービス種類コードList = new ArrayList<>();
        社会福祉法人軽減額対象サービス種類コードList.add(ServiceCategoryShurui.訪問介護.getコード());
        社会福祉法人軽減額対象サービス種類コードList.add(ServiceCategoryShurui.通所介護.getコード());
        社会福祉法人軽減額対象サービス種類コードList.add(ServiceCategoryShurui.短期生活.getコード());
        社会福祉法人軽減額対象サービス種類コードList.add(ServiceCategoryShurui.予短介護.getコード());
        社会福祉法人軽減額対象サービス種類コードList.add(ServiceCategoryShurui.福祉施設.getコード());
        社会福祉法人軽減額対象サービス種類コードList.add(ServiceCategoryShurui.地福祉生.getコード());
        社会福祉法人軽減額対象サービス種類コードList.add(ServiceCategoryShurui.予訪介護.getコード());
        社会福祉法人軽減額対象サービス種類コードList.add(ServiceCategoryShurui.予通介護.getコード());
        社会福祉法人軽減額対象サービス種類コードList.add(ServiceCategoryShurui.地夜間訪.getコード());
        社会福祉法人軽減額対象サービス種類コードList.add(ServiceCategoryShurui.地通所介.getコード());
        社会福祉法人軽減額対象サービス種類コードList.add(ServiceCategoryShurui.地小短外.getコード());
        社会福祉法人軽減額対象サービス種類コードList.add(ServiceCategoryShurui.地予通所.getコード());
        社会福祉法人軽減額対象サービス種類コードList.add(ServiceCategoryShurui.地予小外.getコード());
        社会福祉法人軽減額対象サービス種類コードList.add(ServiceCategoryShurui.定期随時.getコード());
        社会福祉法人軽減額対象サービス種類コードList.add(ServiceCategoryShurui.看小短外.getコード());
        boolean flg = false;
        if (社会福祉法人軽減額対象List.contains(入力識別番号上3桁) && 社会福祉法人軽減額対象サービス種類コードList.contains(集計サービス種類コード)) {
            for (DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity 社会福祉 : 給付実績社会福祉法人軽減額ワーク) {
                if (集計サービス種類コード.equals(社会福祉.getServiceSyuruiCode().value())) {
                    利用状況統計表一時.setShafukuKeigenritsu(decimaltoRString(社会福祉.getKeigenritsu()));
                    利用状況統計表一時.setShafukuRiyoshaFutangaku(decimaltoRString(社会福祉.getAtoRiyoshaFutanTotal()));
                    利用状況統計表一時.setShafukuKeigengaku(decimaltoRString(社会福祉.getAtoKeigengaku()));
                    利用状況統計表一時.setShafukuKeigengoRiyoshaFutangaku(decimaltoRString(社会福祉.getAtoKeigengoRiyoshaFutangaku()));
                    flg = true;
                    break;
                }
            }
            if (!flg) {
                利用状況統計表一時.setShafukuKeigenritsu(初期金額または日数_0);
                利用状況統計表一時.setShafukuRiyoshaFutangaku(初期金額または日数_0);
                利用状況統計表一時.setShafukuKeigengaku(初期金額または日数_0);
                利用状況統計表一時.setShafukuKeigengoRiyoshaFutangaku(初期金額または日数_0);
            }
        } else {
            利用状況統計表一時.setShafukuKeigenritsu(初期金額または日数_0);
            利用状況統計表一時.setShafukuRiyoshaFutangaku(初期金額または日数_0);
            利用状況統計表一時.setShafukuKeigengaku(初期金額または日数_0);
            利用状況統計表一時.setShafukuKeigengoRiyoshaFutangaku(初期金額または日数_0);
        }
        利用状況統計表一時.setMeisaiOutFlag(FLAG_FALSE);
        return 利用状況統計表一時;
    }

    private RiyoJokyoIchiranSeqAriEUCEntity createAriEucEntity(DbT7051KoseiShichosonMasterEntity 保険者情報,
            DbWT1513RiyoJokyoTokeihyoEntity entity, CreateRiyojokyoIchiranHyoProcessParameter parameter) {

        RiyoJokyoIchiranSeqAriEUCEntity ariEUCEntity = new RiyoJokyoIchiranSeqAriEUCEntity();
        ariEUCEntity.set保険者番号(保険者情報.getShoKisaiHokenshaNo().value());
        ariEUCEntity.set保険者名(保険者情報.getShichosonMeisho());
        if (RString.isNullOrEmpty(entity.getShoriShichosonCode())) {
            ariEUCEntity.set旧市町村コード(parameter.get旧市町村コード());
            ariEUCEntity.set旧市町村名(parameter.get旧市町村名称());
        } else {
            ariEUCEntity.set旧市町村コード(entity.getShoriShichosonCode());
            ariEUCEntity.set旧市町村名(entity.getShoriShichosonName());
        }
        ariEUCEntity.setデータ区分(entity.getDataKubun());
        ariEUCEntity.set被保険者番号(entity.getHihokenshaNo());
        ariEUCEntity.set証記載保険者番号(entity.getShoKisaiHokenshaNo());
        ariEUCEntity.set識別コード(entity.getShikibetsuCode());
        ariEUCEntity.set氏名カナ(entity.getShimeiKana());
        ariEUCEntity.set氏名漢字(entity.getShimei());
        ariEUCEntity.set性別(entity.getSeibetsuCode());
        ariEUCEntity.set町域コード(entity.getChoikiCode());
        ariEUCEntity.set行政区コード(entity.getGyoseikuCode());
        ariEUCEntity.set行政区名(entity.getGyoseikuMei());
        ariEUCEntity.set郵便番号(entity.getYubinNo());
        ariEUCEntity.set住所(entity.getJusho());
        ariEUCEntity.set地区コード1(entity.getChikuCode1());
        ariEUCEntity.set地区名1(entity.getChikuMei1());
        ariEUCEntity.set地区コード2(entity.getChikuCode2());
        ariEUCEntity.set地区名2(entity.getChikuMei2());
        ariEUCEntity.set地区コード3(entity.getChikuCode3());
        ariEUCEntity.set地区名3(entity.getChikuMei3());
        ariEUCEntity.set世帯コード(entity.getSetaiCode());
        if (!RString.isNullOrEmpty(entity.getYoKaigoJotaiKubunCode()) && !RString.isNullOrEmpty(entity.getServiceTeikyoYM())) {
            ariEUCEntity.set要介護状態区分(YokaigoJotaiKubunSupport.toValue(new FlexibleYearMonth(entity.getServiceTeikyoYM()),
                    entity.getYoKaigoJotaiKubunCode()).getName());
        }
        if (!RString.isNullOrEmpty(entity.getKyotakuServiceSakuseiKubunCode())) {
            ariEUCEntity.set居宅サービス計画作成区分(KyotakuservicekeikakuSakuseikubunCode
                    .toValue(entity.getKyotakuServiceSakuseiKubunCode()).get名称());
        }
        ariEUCEntity.set居宅サービス計画事業所番号(entity.getKyotakuServiceJigyoshoNo());
        ariEUCEntity.set居宅サービス計画事業所名(entity.getKyotakuServiceJigyoshoName());
        if (!RString.isNullOrEmpty(entity.getKyuSochishaFlag())) {
            ariEUCEntity.set旧措置(KyuSochishaKubun.toValue(entity.getKyuSochishaFlag()).get名称());
        }
        if (!RString.isNullOrEmpty(entity.getRiyoJissekiFlag())) {
            ariEUCEntity.set利用実績(RiyojokyoTokeihyo_RiyoJissekiKubun.toValue(entity.getRiyoJissekiFlag()).get名称());
        }
        ariEUCEntity.set公費１負担者番号(entity.getKohi1FutanshaNo());
        ariEUCEntity.set公費１受給者番号(entity.getKohi1JukyushaNo());
        ariEUCEntity.set公費２負担者番号(entity.getKohi2FutanshaNo());
        ariEUCEntity.set公費２受給者番号(entity.getKohi2JukyushaNo());
        ariEUCEntity.set公費３負担者番号(entity.getKohi3FutanshaNo());
        ariEUCEntity.set公費３受給者番号(entity.getKohi3JukyushaNo());
        ariEUCEntity.set老人保健市町村番号(entity.getRojinHokenShichosonNo());
        ariEUCEntity.set老人保健受給者番号(entity.getRojinhokenJukyushaNo());
        ariEUCEntity.set後期保険者番号(entity.getKokiHokenshaNo());
        ariEUCEntity.set後期被保険者番号(entity.getKokiHihokenshaNo());
        ariEUCEntity.set国保保険者番号(entity.getKokuhoHokenshaNo());
        ariEUCEntity.set国保被保険者証番号(entity.getKokuhoHihokenshashoNo());
        ariEUCEntity.set国保個人番号(entity.getKokuhoKojinNo());
        ariEUCEntity.set保険給付率(entity.getHokenKyufuritsu());
        if (!RString.isNullOrEmpty(entity.getKyufuJissekiKubunCode())) {
            ariEUCEntity.set現物償還の別(KyufuJissekiKubun.toValue(entity.getKyufuJissekiKubunCode()).get名称());
        }
        if (!RString.isNullOrEmpty(entity.getKyufuJissekiKubunCode())) {
            ariEUCEntity.setサービスの別(RiyojokyoTokeihyo_ServiceKubun.toValue(entity.getKyufuJissekiKubunCode()).get名称());
        }
        ariEUCEntity.set事業所番号(entity.getJigyoshoNo());
        ariEUCEntity.set事業所名(entity.getJigyoshoName());
        ariEUCEntity.setサービス種類コード(entity.getServiceShuruiCode());
        ariEUCEntity.setサービス種類名(entity.getServiceShuruiMei());
        ariEUCEntity.set日数回数(entity.getNissuKaisu());
        ariEUCEntity.set短期入所実日数(entity.getTankiNyushoJitsunissu());
        ariEUCEntity.set保険単位数(entity.getHokenTanisu());
        ariEUCEntity.set保険単位数単価(entity.getHokenTanisuTanka());
        ariEUCEntity.set保険請求額(entity.getHokenSeikyugaku());
        ariEUCEntity.set保険利用者負担額(entity.getHokenRiyoshaFutangaku());
        ariEUCEntity.set公費１単位数(entity.getKohi1Tanisu());
        ariEUCEntity.set公費１請求額(entity.getKohi1Seikyugaku());
        ariEUCEntity.set公費１本人負担額(entity.getKohi1HonninFutangaku());
        ariEUCEntity.set公費２単位数(entity.getKohi2Tanisu());
        ariEUCEntity.set公費２請求額(entity.getKohi2Seikyugaku());
        ariEUCEntity.set公費２本人負担額(entity.getKohi2HonninFutangaku());
        ariEUCEntity.set公費３単位数(entity.getKohi3Tanisu());
        ariEUCEntity.set公費３請求額(entity.getKohi3Seikyugaku());
        ariEUCEntity.set公費３本人負担額(entity.getKohi3HonninFutangaku());
        ariEUCEntity.set保険出来高単位数(entity.getHokenDekidakaTanisu());
        ariEUCEntity.set保険出来高請求額(entity.getHokenDekidakaSeikyugaku());
        ariEUCEntity.set保険出来高利用者負担額(entity.getHokenDekidakaRiyoshaFutangaku());
        ariEUCEntity.set公費１出来高単位数(entity.getKohi1DekidakaTanisu());
        ariEUCEntity.set公費１出来高請求額(entity.getKohi1DekidakaSeikyugaku());
        ariEUCEntity.set公費１出来高本人負担額(entity.getKohi1DekidakaHonninFutangaku());
        ariEUCEntity.set公費２出来高単位数(entity.getKohi2DekidakaTanisu());
        ariEUCEntity.set公費２出来高請求額(entity.getKohi2DekidakaSeikyugaku());
        ariEUCEntity.set公費２出来高本人負担額(entity.getKohi2DekidakaHonninFutangaku());
        ariEUCEntity.set公費３出来高単位数(entity.getKohi3DekidakaTanisu());
        ariEUCEntity.set公費３出来高請求額(entity.getKohi3DekidakaSeikyugaku());
        ariEUCEntity.set公費３出来高本人負担額(entity.getKohi3DekidakaHonninFutangaku());
        ariEUCEntity.set食事基本日数(entity.getShokujiKihonNissu());
        ariEUCEntity.set食事基本単価(entity.getShokujiKihonTanka());
        ariEUCEntity.set食事特別日数(entity.getShokujiTokubetsuNissu());
        ariEUCEntity.set食事特別単価(entity.getShokujiTokubetsuTanka());
        ariEUCEntity.set食事提供費合計(entity.getShokujiTeikyohiGokei());
        ariEUCEntity.set標準負担額日額(entity.getNichigakuHyojunFutangaku());
        ariEUCEntity.set食事提供費請求額(entity.getShokujiTeikyohiSeikyugaku());
        ariEUCEntity.set限度額管理対象単位数(entity.getShokujiTeikyohiSeikyugaku());
        ariEUCEntity.set限度額管理対象外単位数(entity.getGendogakuKanritaishogaiTanisu());
        ariEUCEntity.set再審査回数(entity.getSaishinsaKaisu());
        ariEUCEntity.set過誤回数(entity.getSaishinsaKaisu());
        ariEUCEntity.set訪問支給限度額(entity.getHomonShikyuGendogaku());
        ariEUCEntity.set訪問利用サービス単位数(entity.getHomonRiyoServiceTanisu());
        ariEUCEntity.set短期支給限度額(entity.getTankiShikyuGendogaku());
        ariEUCEntity.set短期利用サービス単位数(entity.getTankiRiyoServiceTanisu());
        ariEUCEntity.set在宅利用率(entity.getZaitakuRiyoritsu());
        ariEUCEntity.set訪問利用率(entity.getHomonRiyoritsu());
        ariEUCEntity.set短期利用率(entity.getTankiRiyoritsu());
        ariEUCEntity.set外泊日数(entity.getGaihakuNissu());
        if (RString.isNullOrEmpty(entity.getTaishogoJotaiCode())) {
            ariEUCEntity.set退所院後の状況(RString.EMPTY);
        } else {
            ariEUCEntity.set退所院後の状況(CodeMaster.getCodeMeisho(DBCCodeShubetsu.退所_院_後の状態コード.getコード(),
                    new Code(entity.getTaishogoJotaiCode()), FlexibleDate.MAX));
        }
        ariEUCEntity.set特定入所日数食費(entity.getTokuteiNyushoShokuhiNissu());
        ariEUCEntity.set特定入所費用額食費(entity.getTokuteiNyushoShokuhiHiyogaku());
        ariEUCEntity.set特定入所保険分請求額食費(entity.getTokuteiNyushoShokuhiSeikyugaku());
        ariEUCEntity.set特定入所利用者負担額食費(entity.getTokuteiNyushoShokuhiRiyoshaFutangaku());
        ariEUCEntity.set特定入所日数居住(entity.getTokuteiNyushoKyojuNissu());
        ariEUCEntity.set特定入所費用額居住(entity.getTokuteiNyushoKyojuHiyogaku());
        ariEUCEntity.set特定入所保険分請求額居住(entity.getTokuteiNyushoKyojuSeikyugaku());
        ariEUCEntity.set特定入所利用者負担額居住(entity.getTokuteiNyushoKyojuRiyoshaFutangaku());
        ariEUCEntity.set社福軽減率(entity.getShafukuKeigenritsu());
        ariEUCEntity.set社福受領すべき利用者負担額(entity.getShafukuRiyoshaFutangaku());
        ariEUCEntity.set社福軽減額(entity.getShafukuKeigengaku());
        ariEUCEntity.set社福軽減後利用者負担額(entity.getShafukuKeigengoRiyoshaFutangaku());
        return subEUCEntity(parameter.get日付スラッシュ編集(), ariEUCEntity, entity);
    }

    private RiyoJokyoIchiranSeqAriEUCEntity subEUCEntity(RString 日付スラッシュ編集,
            RiyoJokyoIchiranSeqAriEUCEntity ariEUCEntity, DbWT1513RiyoJokyoTokeihyoEntity entity) {
        if (Tokeihyo_CSVEditKubun.する.getコード().equals(日付スラッシュ編集)) {
            ariEUCEntity.setサービス提供年月(formatDate(entity.getServiceTeikyoYM()));
            ariEUCEntity.set審査年月(formatDate(entity.getShinsaYM()));
            ariEUCEntity.set生年月日(formatDate(entity.getSeinenYMD()));
            ariEUCEntity.set認定有効期間開始年月日(formatDate(entity.getNinteiYukoKaishiYMD()));
            ariEUCEntity.set認定有効期間終了年月日(formatDate(entity.getNinteiYukoShuryoYMD()));
            ariEUCEntity.set訪問適用開始日(formatDate(entity.getHomonTekiyoKaishiYMD()));
            ariEUCEntity.set訪問適用終了日(formatDate(entity.getHomonTekiyoShuryoYMD()));
            ariEUCEntity.set短期適用開始日(formatDate(entity.getTankiTekiyoKaishiYMD()));
            ariEUCEntity.set短期適用終了日(formatDate(entity.getTankiTekiyoShuryoYMD()));
        } else {
            ariEUCEntity.setサービス提供年月(entity.getServiceTeikyoYM());
            ariEUCEntity.set審査年月(entity.getShinsaYM());
            ariEUCEntity.set生年月日(entity.getSeinenYMD());
            ariEUCEntity.set認定有効期間開始年月日(entity.getNinteiYukoKaishiYMD());
            ariEUCEntity.set認定有効期間終了年月日(entity.getNinteiYukoShuryoYMD());
            ariEUCEntity.set訪問適用開始日(entity.getHomonTekiyoKaishiYMD());
            ariEUCEntity.set訪問適用終了日(entity.getHomonTekiyoShuryoYMD());
            ariEUCEntity.set短期適用開始日(entity.getTankiTekiyoKaishiYMD());
            ariEUCEntity.set短期適用終了日(entity.getTankiTekiyoShuryoYMD());
        }
        return ariEUCEntity;
    }

    private RString formatDate(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        if (date.length() == EIGHT) {
            RStringBuilder builder = new RStringBuilder();
            builder.append(date.substring(ZERO, FOUR));
            builder.append(符号);
            builder.append(date.substring(FOUR, SIX));
            builder.append(符号);
            builder.append(date.substring(SIX));
            return builder.toRString();
        } else {
            RStringBuilder builder = new RStringBuilder();
            builder.append(date.substring(ZERO, FOUR));
            builder.append(符号);
            builder.append(date.substring(FOUR));
            return builder.toRString();
        }
    }

    private RiyoJokyoIchiranSeqNashiEUCEntity createEucNashiEntity(DbT7051KoseiShichosonMasterEntity 保険者情報,
            DbWT1513RiyoJokyoTokeihyoEntity entity, CreateRiyojokyoIchiranHyoProcessParameter parameter) {
        RiyoJokyoIchiranSeqNashiEUCEntity ariEUCEntity = new RiyoJokyoIchiranSeqNashiEUCEntity();
        ariEUCEntity.set保険者番号(保険者情報.getShoKisaiHokenshaNo().value());
        ariEUCEntity.set保険者名(保険者情報.getShichosonMeisho());
        if (RString.isNullOrEmpty(entity.getShoriShichosonCode())) {
            ariEUCEntity.set旧市町村コード(parameter.get旧市町村コード());
            ariEUCEntity.set旧市町村名(parameter.get旧市町村名称());
        } else {
            ariEUCEntity.set旧市町村コード(entity.getShoriShichosonCode());
            ariEUCEntity.set旧市町村名(entity.getShoriShichosonName());
        }
        ariEUCEntity.setデータ区分(entity.getDataKubun());
        ariEUCEntity.set被保険者番号(entity.getHihokenshaNo());
        ariEUCEntity.set証記載保険者番号(entity.getShoKisaiHokenshaNo());
        ariEUCEntity.set識別コード(entity.getShikibetsuCode());
        ariEUCEntity.set氏名カナ(entity.getShimeiKana());
        ariEUCEntity.set氏名漢字(entity.getShimei());
        ariEUCEntity.set性別(entity.getSeibetsuCode());
        ariEUCEntity.set町域コード(entity.getChoikiCode());
        ariEUCEntity.set行政区コード(entity.getGyoseikuCode());
        ariEUCEntity.set行政区名(entity.getGyoseikuMei());
        ariEUCEntity.set郵便番号(entity.getYubinNo());
        ariEUCEntity.set住所(entity.getJusho());
        ariEUCEntity.set地区コード1(entity.getChikuCode1());
        ariEUCEntity.set地区名1(entity.getChikuMei1());
        ariEUCEntity.set地区コード2(entity.getChikuCode2());
        ariEUCEntity.set地区名2(entity.getChikuMei2());
        ariEUCEntity.set地区コード3(entity.getChikuCode3());
        ariEUCEntity.set地区名3(entity.getChikuMei3());
        ariEUCEntity.set世帯コード(entity.getSetaiCode());
        ariEUCEntity.set要介護状態区分(entity.getYoKaigoJotaiKubunCode());
        ariEUCEntity.set居宅サービス計画作成区分(entity.getKyotakuServiceSakuseiKubunCode());
        ariEUCEntity.set居宅サービス計画事業所番号(entity.getKyotakuServiceJigyoshoNo());
        ariEUCEntity.set居宅サービス計画事業所名(entity.getKyotakuServiceJigyoshoName());
        if (!RString.isNullOrEmpty(entity.getKyuSochishaFlag())) {
            ariEUCEntity.set旧措置(KyuSochishaKubun.toValue(entity.getKyuSochishaFlag()).get名称());
        }
        if (!RString.isNullOrEmpty(entity.getRiyoJissekiFlag())) {
            ariEUCEntity.set利用実績(RiyojokyoTokeihyo_RiyoJissekiKubun.toValue(entity.getRiyoJissekiFlag()).get名称());
        }
        ariEUCEntity.set公費１負担者番号(entity.getKohi1FutanshaNo());
        ariEUCEntity.set公費１受給者番号(entity.getKohi1JukyushaNo());
        ariEUCEntity.set公費２負担者番号(entity.getKohi2FutanshaNo());
        ariEUCEntity.set公費２受給者番号(entity.getKohi2JukyushaNo());
        ariEUCEntity.set公費３負担者番号(entity.getKohi3FutanshaNo());
        ariEUCEntity.set公費３受給者番号(entity.getKohi3JukyushaNo());
        ariEUCEntity.set老人保健市町村番号(entity.getRojinHokenShichosonNo());
        ariEUCEntity.set老人保健受給者番号(entity.getRojinhokenJukyushaNo());
        ariEUCEntity.set後期保険者番号(entity.getKokiHokenshaNo());
        ariEUCEntity.set後期被保険者番号(entity.getKokiHihokenshaNo());
        ariEUCEntity.set国保保険者番号(entity.getKokuhoHokenshaNo());
        ariEUCEntity.set国保被保険者証番号(entity.getKokuhoHihokenshashoNo());
        ariEUCEntity.set国保個人番号(entity.getKokuhoKojinNo());
        ariEUCEntity.set保険給付率(entity.getHokenKyufuritsu());
        if (!RString.isNullOrEmpty(entity.getKyufuJissekiKubunCode())) {
            ariEUCEntity.set現物償還の別(KyufuJissekiKubun.toValue(entity.getKyufuJissekiKubunCode()).get名称());
        }
        if (!RString.isNullOrEmpty(entity.getKyufuJissekiKubunCode())) {
            ariEUCEntity.setサービスの別(RiyojokyoTokeihyo_ServiceKubun.toValue(entity.getKyufuJissekiKubunCode()).get名称());
        }
        ariEUCEntity.set事業所番号(entity.getJigyoshoNo());
        ariEUCEntity.set事業所名(entity.getJigyoshoName());
        ariEUCEntity.setサービス種類コード(entity.getServiceShuruiCode());
        ariEUCEntity.setサービス種類名(entity.getServiceShuruiMei());
        ariEUCEntity.set日数回数(entity.getNissuKaisu());
        ariEUCEntity.set短期入所実日数(entity.getTankiNyushoJitsunissu());
        ariEUCEntity.set保険単位数(entity.getHokenTanisu());
        ariEUCEntity.set保険単位数単価(entity.getHokenTanisuTanka());
        ariEUCEntity.set保険請求額(entity.getHokenSeikyugaku());
        ariEUCEntity.set保険利用者負担額(entity.getHokenRiyoshaFutangaku());
        ariEUCEntity.set公費１単位数(entity.getKohi1Tanisu());
        ariEUCEntity.set公費１請求額(entity.getKohi1Seikyugaku());
        ariEUCEntity.set公費１本人負担額(entity.getKohi1HonninFutangaku());
        ariEUCEntity.set公費２単位数(entity.getKohi2Tanisu());
        ariEUCEntity.set公費２請求額(entity.getKohi2Seikyugaku());
        ariEUCEntity.set公費２本人負担額(entity.getKohi2HonninFutangaku());
        ariEUCEntity.set公費３単位数(entity.getKohi3Tanisu());
        ariEUCEntity.set公費３請求額(entity.getKohi3Seikyugaku());
        ariEUCEntity.set公費３本人負担額(entity.getKohi3HonninFutangaku());
        ariEUCEntity.set保険出来高単位数(entity.getHokenDekidakaTanisu());
        ariEUCEntity.set保険出来高請求額(entity.getHokenDekidakaSeikyugaku());
        ariEUCEntity.set保険出来高利用者負担額(entity.getHokenDekidakaRiyoshaFutangaku());
        ariEUCEntity.set公費１出来高単位数(entity.getKohi1DekidakaTanisu());
        ariEUCEntity.set公費１出来高請求額(entity.getKohi1DekidakaSeikyugaku());
        ariEUCEntity.set公費１出来高本人負担額(entity.getKohi1DekidakaHonninFutangaku());
        ariEUCEntity.set公費２出来高単位数(entity.getKohi2DekidakaTanisu());
        ariEUCEntity.set公費２出来高請求額(entity.getKohi2DekidakaSeikyugaku());
        ariEUCEntity.set公費２出来高本人負担額(entity.getKohi2DekidakaHonninFutangaku());
        ariEUCEntity.set公費３出来高単位数(entity.getKohi3DekidakaTanisu());
        ariEUCEntity.set公費３出来高請求額(entity.getKohi3DekidakaSeikyugaku());
        ariEUCEntity.set公費３出来高本人負担額(entity.getKohi3DekidakaHonninFutangaku());
        ariEUCEntity.set食事基本日数(entity.getShokujiKihonNissu());
        ariEUCEntity.set食事基本単価(entity.getShokujiKihonTanka());
        ariEUCEntity.set食事特別日数(entity.getShokujiTokubetsuNissu());
        ariEUCEntity.set食事特別単価(entity.getShokujiTokubetsuTanka());
        ariEUCEntity.set食事提供費合計(entity.getShokujiTeikyohiGokei());
        ariEUCEntity.set標準負担額日額(entity.getNichigakuHyojunFutangaku());
        ariEUCEntity.set食事提供費請求額(entity.getShokujiTeikyohiSeikyugaku());
        ariEUCEntity.set限度額管理対象単位数(entity.getShokujiTeikyohiSeikyugaku());
        ariEUCEntity.set限度額管理対象外単位数(entity.getGendogakuKanritaishogaiTanisu());
        ariEUCEntity.set再審査回数(entity.getSaishinsaKaisu());
        ariEUCEntity.set過誤回数(entity.getSaishinsaKaisu());
        ariEUCEntity.set訪問支給限度額(entity.getHomonShikyuGendogaku());
        ariEUCEntity.set訪問利用サービス単位数(entity.getHomonRiyoServiceTanisu());
        ariEUCEntity.set短期支給限度額(entity.getTankiShikyuGendogaku());
        ariEUCEntity.set短期利用サービス単位数(entity.getTankiRiyoServiceTanisu());
        ariEUCEntity.set在宅利用率(entity.getZaitakuRiyoritsu());
        ariEUCEntity.set訪問利用率(entity.getHomonRiyoritsu());
        ariEUCEntity.set短期利用率(entity.getTankiRiyoritsu());
        ariEUCEntity.set外泊日数(entity.getGaihakuNissu());
        if (RString.isNullOrEmpty(entity.getTaishogoJotaiCode())) {
            ariEUCEntity.set退所院後の状況(RString.EMPTY);
        } else {
            ariEUCEntity.set退所院後の状況(CodeMaster.getCodeMeisho(DBCCodeShubetsu.退所_院_後の状態コード.getコード(),
                    new Code(entity.getTaishogoJotaiCode()), FlexibleDate.MAX));
        }
        ariEUCEntity.set特定入所日数食費(entity.getTokuteiNyushoShokuhiNissu());
        ariEUCEntity.set特定入所費用額食費(entity.getTokuteiNyushoShokuhiHiyogaku());
        ariEUCEntity.set特定入所保険分請求額食費(entity.getTokuteiNyushoShokuhiSeikyugaku());
        ariEUCEntity.set特定入所利用者負担額食費(entity.getTokuteiNyushoShokuhiRiyoshaFutangaku());
        ariEUCEntity.set特定入所日数居住(entity.getTokuteiNyushoKyojuNissu());
        ariEUCEntity.set特定入所費用額居住(entity.getTokuteiNyushoKyojuHiyogaku());
        ariEUCEntity.set特定入所保険分請求額居住(entity.getTokuteiNyushoKyojuSeikyugaku());
        ariEUCEntity.set特定入所利用者負担額居住(entity.getTokuteiNyushoKyojuRiyoshaFutangaku());
        ariEUCEntity.set社福軽減率(entity.getShafukuKeigenritsu());
        ariEUCEntity.set社福受領すべき利用者負担額(entity.getShafukuRiyoshaFutangaku());
        ariEUCEntity.set社福軽減額(entity.getShafukuKeigengaku());
        ariEUCEntity.set社福軽減後利用者負担額(entity.getShafukuKeigengoRiyoshaFutangaku());
        return subEUCEntity1(parameter.get日付スラッシュ編集(), ariEUCEntity, entity);
    }

    private RiyoJokyoIchiranSeqNashiEUCEntity subEUCEntity1(RString 日付スラッシュ編集,
            RiyoJokyoIchiranSeqNashiEUCEntity ariEUCEntity, DbWT1513RiyoJokyoTokeihyoEntity entity) {
        if (Tokeihyo_CSVEditKubun.する.getコード().equals(日付スラッシュ編集)) {
            ariEUCEntity.setサービス提供年月(formatDate(entity.getServiceTeikyoYM()));
            ariEUCEntity.set審査年月(formatDate(entity.getShinsaYM()));
            ariEUCEntity.set生年月日(formatDate(entity.getSeinenYMD()));
            ariEUCEntity.set認定有効期間開始年月日(formatDate(entity.getNinteiYukoKaishiYMD()));
            ariEUCEntity.set認定有効期間終了年月日(formatDate(entity.getNinteiYukoShuryoYMD()));
            ariEUCEntity.set訪問適用開始日(formatDate(entity.getHomonTekiyoKaishiYMD()));
            ariEUCEntity.set訪問適用終了日(formatDate(entity.getHomonTekiyoShuryoYMD()));
            ariEUCEntity.set短期適用開始日(formatDate(entity.getTankiTekiyoKaishiYMD()));
            ariEUCEntity.set短期適用終了日(formatDate(entity.getTankiTekiyoShuryoYMD()));
        } else {
            ariEUCEntity.setサービス提供年月(entity.getServiceTeikyoYM());
            ariEUCEntity.set審査年月(entity.getShinsaYM());
            ariEUCEntity.set生年月日(entity.getSeinenYMD());
            ariEUCEntity.set認定有効期間開始年月日(entity.getNinteiYukoKaishiYMD());
            ariEUCEntity.set認定有効期間終了年月日(entity.getNinteiYukoShuryoYMD());
            ariEUCEntity.set訪問適用開始日(entity.getHomonTekiyoKaishiYMD());
            ariEUCEntity.set訪問適用終了日(entity.getHomonTekiyoShuryoYMD());
            ariEUCEntity.set短期適用開始日(entity.getTankiTekiyoKaishiYMD());
            ariEUCEntity.set短期適用終了日(entity.getTankiTekiyoShuryoYMD());
        }
        return ariEUCEntity;
    }
}
