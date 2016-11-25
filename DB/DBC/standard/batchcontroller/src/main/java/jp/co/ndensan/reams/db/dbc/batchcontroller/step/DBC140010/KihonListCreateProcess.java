/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.keikoku.KeikokuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekikubun.KyufuJissekiKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakyufujissekidaicho.JukyushaKyufujissekiDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KihonRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 受給者給付実績台帳のList基本のセットクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 *
 */
public class KihonListCreateProcess extends BatchProcessBase<KihonRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho.IJukyushaKyufujissekiDaichoMapper."
            + "get基本");
    private static final RString チルダ = new RString("～");
    private static final RString 居住サービス計画作成区分コード_1 = new RString("1");
    private static final RString 居住サービス計画作成区分コード_2 = new RString("2");
    private static final RString 居住サービス計画作成区分コード_3 = new RString("3");
    private static final RString 居住サービス計画作成区分コード_4 = new RString("4");
    private static final RString 入力識別番号_7171 = new RString("7171");
    private static final RString 入力識別番号_7172 = new RString("7172");
    private static final RString 入力識別番号_7173 = new RString("7173");
    private static final RString 入力識別番号_7174 = new RString("7174");
    private static final RString 入力識別番号_2171 = new RString("2171");
    private static final RString 入力識別番号_2172 = new RString("2172");
    private static final RString 入力識別番号_2173 = new RString("2173");
    private static final RString 入力識別番号_2174 = new RString("2174");
    private static final RString 入力識別番号_7181 = new RString("7181");
    private static final RString 入力識別番号_7182 = new RString("7182");
    private static final RString 入力識別番号_7183 = new RString("7183");
    private static final RString 入力識別番号_2181 = new RString("2181");
    private static final RString 入力識別番号_2182 = new RString("2182");
    private static final RString 入力識別番号_2183 = new RString("2183");
    private static final RString 入力識別番号_7191 = new RString("7191");
    private static final RString 入力識別番号_7192 = new RString("7192");
    private static final RString 入力識別番号_7193 = new RString("7193");
    private static final RString 入力識別番号_7194 = new RString("7194");
    private static final RString 入力識別番号_7195 = new RString("7195");
    private static final RString 入力識別番号_2191 = new RString("2191");
    private static final RString 入力識別番号_2192 = new RString("2192");
    private static final RString 入力識別番号_2193 = new RString("2193");
    private static final RString 入力識別番号_2194 = new RString("2194");
    private static final RString 入力識別番号_2195 = new RString("2195");
    private static final RString 入力識別番号_71A1 = new RString("71A1");
    private static final RString 入力識別番号_71A2 = new RString("71A2");
    private static final RString 入力識別番号_71A3 = new RString("71A3");
    private static final RString 入力識別番号_21A1 = new RString("21A1");
    private static final RString 入力識別番号_21A2 = new RString("21A2");
    private static final RString 入力識別番号_21A3 = new RString("21A3");
    private static final RString 入力識別番号_715X = new RString("715X");
    private static final RString 入力識別番号_215X = new RString("215X");
    private static final RString 入力識別番号_719X = new RString("719X");
    private static final RString 入力識別番号_219X = new RString("219X");
    private static final RString 入力識別番号_716X = new RString("716X");
    private static final RString 入力識別番号_216X = new RString("216X");
    private static final RString 入力識別番号_71AX = new RString("71AX");
    private static final RString 入力識別番号_21AX = new RString("21AX");
    private static final RString 入力識別番号_2155 = new RString("2155");
    private static final RString 入力識別番号_2156 = new RString("2156");
    private static final RString 入力識別番号_7155 = new RString("7155");
    private static final RString 入力識別番号_7156 = new RString("7156");
    private static final RString サービス提供年月_200510 = new RString("200510");
    private static final RString 入所_院_前 = new RString("201104");
    private static final RString 区分_基本 = new RString("1");
    private static final RString 広域内住所地特例フラグ = new RString("1");

    private static final int 居住サービス計画事業者名_LENGTH = 20;
    private static final int 居住サービス計画事業者名_LENGTH_40 = 40;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 基本List;
    private JukyushaKyufujissekiDaichoProcessParameter parameter;

    @Override
    protected void initialize() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先));
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        parameter.setPsmShikibetsuTaisho(new RString(uaFt200Psm.getParameterMap().
                get("psmShikibetsuTaisho").toString()));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toJukyushaKyufujissekiDaichoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        基本List = new BatchEntityCreatedTempTableWriter(KihonEntity.TABLE_NAME,
                KihonEntity.class);
    }

    @Override
    protected void process(KihonRelateEntity entity) {
        基本List.insert(set基本List(entity));
    }

    private KihonEntity set基本List(KihonRelateEntity entity) {
        KihonEntity 基本entity = new KihonEntity();
        RString 入力識別番号 = entity.getDbT3017_inputShikibetsuNo();
        RString サービス提供年月 = entity.getDbT3017_serviceTeikyoYM();
        基本entity.set入力識別番号(入力識別番号);
        基本entity.set被保険者番号(entity.getDbT3017_hiHokenshaNo());
        基本entity.setサービス提供年月(サービス提供年月);
        基本entity.set給付実績区分コード(KyufuJissekiKubun.toValue(entity.getDbT3017_kyufuJissekiKubunCode()).get名称());
        基本entity.set事業所番号(entity.getDbT3017_jigyoshoNo());
        基本entity.set通し番号(entity.getDbT3017_toshiNo());
        基本entity.set生年月日(entity.getDbT3017_umareYMD());
        基本entity.set性別コード(entity.getDbT3017_seibetsuCode());
        基本entity.set要介護度(RString.EMPTY);
        if (!RString.isNullOrEmpty(entity.getDbT3017_yoKaigoJotaiKubunCode())) {
            基本entity.set要介護度(YokaigoJotaiKubun.toValue(entity.getDbT3017_yoKaigoJotaiKubunCode()).get名称());
        }
        基本entity.set認定有効期間(get期間(entity.getDbT3017_ninteiYukoKaishiYMD(), entity.getDbT3017_ninteiYukoShuryoYMD()));
        基本entity.set証記載保険者番号(entity.getDbT3017_shokisaiHokenshaNo());
        基本entity.set老人保険市町村番号(entity.getDbT3017_rojinHokenShichosonNo());
        基本entity.set老人保険受給者番号(entity.getDbT3017_rojinhokenJukyushaNo());
        基本entity.set旧措置入所者特例コード(entity.getDbT3017_kyuSochiNyushoshaTokureiCode());
        基本entity.set警告区分コード(KeikokuKubun.toValue(entity.getDbT3017_keikaiKubunCode()).get名称());
        基本entity.set審査年月(entity.getDbT3017_shinsaYM());
        基本entity.set保険者番号後期(entity.getDbT3017_kokiHokenshaNo());
        基本entity.set被保険者番号後期(entity.getDbT3017_kokiHiHokenshaNo());
        基本entity.set保険者番号国保(entity.getDbT3017_kokuhoHokenshaNo());
        基本entity.set被保険者証番号国保(entity.getDbT3017_kokuhoHiHokenshashoNo());
        基本entity.set個人番号国保(entity.getDbT3017_kokuhoKojinNo());
        基本entity.set整理番号(entity.getDbT3017_seiriNo());
        基本entity.set居住サービス計画作成区分コード(entity.getDbT3017_kyotakuServiceSakuseiKubunCode());
        基本entity.set居住サービス計画作成区分名１(get居住サービス計画作成区分名(entity.getDbT3017_kyotakuServiceSakuseiKubunCode()).get(0));
        基本entity.set居住サービス計画作成区分名２(get居住サービス計画作成区分名(entity.getDbT3017_kyotakuServiceSakuseiKubunCode()).get(1));
        基本entity.set居住サービス計画事業者番号(entity.getDbT3017_kyotakuKaigoShienJigyoshoNo());
        基本entity.set居住サービス計画事業者名１(get居住サービス計画事業者名(entity.getDbT7060_jigyoshaName()).get(0));
        基本entity.set居住サービス計画事業者名２(get居住サービス計画事業者名(entity.getDbT7060_jigyoshaName()).get(1));
        基本entity.set入所院期間(get期間(entity.getDbT3017_nyushoYMD(), entity.getDbT3017_taishoYMD()));
        基本entity.set入所院実日数(entity.getDbT3017_nyushoJitsunissu());
        基本entity.set外泊日数(entity.getDbT3017_gaihakuNissu());
        基本entity.set出力様式(entity.getDbT3118_ryakusho());
        RString 名称 = RString.EMPTY;
        if (!RString.isNullOrEmpty(名称)) {
            名称 = entity.getDbT3118_meisho();
        }
        if (名称.length() <= 居住サービス計画事業者名_LENGTH) {
            基本entity.set出力様式１(名称);
            基本entity.set出力様式２(RString.EMPTY);
        } else if (名称.length() <= 居住サービス計画事業者名_LENGTH_40) {
            基本entity.set出力様式１(名称.substring(0, 居住サービス計画事業者名_LENGTH));
            基本entity.set出力様式２(名称.substring(居住サービス計画事業者名_LENGTH));
        } else {
            基本entity.set出力様式１(名称.substring(0, 居住サービス計画事業者名_LENGTH));
            基本entity.set出力様式２(名称.substring(居住サービス計画事業者名_LENGTH, 居住サービス計画事業者名_LENGTH_40));
        }
        基本entity.setサービス事業者番号(entity.getDbT3017_jigyoshoNo());
        基本entity.setサービス事業者名(entity.getDbT7060_jigyoshaName());
        基本entity.set退所院の状態(entity.getDbT3017_taishogoJotaiCode());
        基本entity.setサービス期間(get期間(entity.getDbT3017_kaishiYMD(), entity.getDbT3017_chushiYMD()));
        基本entity.set中止理由タイトル(get中止理由タイトル(入力識別番号, サービス提供年月));
        基本entity.set中止理由コード(entity.getDbT3017_chushiRiyuNyushomaeJyokyoCode());
        基本entity.set保険給付率(entity.getDbT3017_hokenKyufuritsu());
        基本entity.set前サービス単位数(entity.getDbT3017_maeHokenServiceTanisu());
        基本entity.set後サービス単位数(entity.getDbT3017_atoHokenServiceTanisu());
        基本entity.set前保険請求額(entity.getDbT3017_maeHokenSeikyugaku());
        基本entity.set後保険請求額(entity.getDbT3017_atoHokenSeikyugaku());
        基本entity.set前利用者負担額(entity.getDbT3017_maeHokenRiyoshaFutangaku());
        基本entity.set後利用者負担額(entity.getDbT3017_atoHokenRiyoshaFutangaku());
        if (入力識別番号_715X.equals(入力識別番号) || 入力識別番号_215X.equals(入力識別番号)
                || 入力識別番号_719X.equals(入力識別番号)
                || 入力識別番号_219X.equals(入力識別番号)) {
            基本entity.set前緊急時施設療養費請求額(entity.getDbT3017_maeHokenKinkyuShisetsuRyoyoSeikyugaku());
            基本entity.set後緊急時施設療養費請求額(entity.getDbT3017_atoHokenKinkyuShisetsuRyoyoSeikyugaku());
            基本entity.set前公費１緊急時施設療養費請求額(entity.getDbT3017_maeKohi1KinkyuShisetsuRyoyoSeikyugaku());
            基本entity.set後公費１緊急時施設療養費請求額(entity.getDbT3017_atoKohi1KinkyuShisetsuRyoyoSeikyugaku());
            基本entity.set前公費２緊急時施設療養費請求額(entity.getDbT3017_maeKohi2KinkyuShisetsuRyoyoSeikyugaku());
            基本entity.set後公費２緊急時施設療養費請求額(entity.getDbT3017_atoKohi2KinkyuShisetsuRyoyoSeikyugaku());
            基本entity.set前公費３緊急時施設療養費請求額(entity.getDbT3017_maeKohi3KinkyuShisetsuRyoyoSeikyugaku());
            基本entity.set後公費３緊急時施設療養費請求額(entity.getDbT3017_atoKohi3KinkyuShisetsuRyoyoSeikyugaku());
        }
        List<RString> 入力識別番号List = get入力識別番号List();
        基本entity.set基本ヘッダー１(get基本ヘッダー(入力識別番号, サービス提供年月, 入力識別番号List));
        基本entity.set基本ヘッダー２(new RString("請求額"));
        if (入力識別番号List.contains(入力識別番号)
                && new FlexibleYearMonth(サービス提供年月_200510).isBeforeOrEquals(new FlexibleYearMonth(サービス提供年月))) {
            基本entity.set前特定診療費請求額(entity.getDbT3017_maeHokenTokuteiShinryohiSeikyugaku());
            基本entity.set後特定診療費請求額(entity.getDbT3017_atoHokenTokuteiShinryohiSeikyugaku());
        }
        基本entity.set基本ヘッダー3(new RString("特定入所者介"));
        基本entity.set基本ヘッダー４(new RString("護費等請求額"));
        基本entity.set前特定入所者介護サービス等等請求額(entity.getDbT3017_maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku());
        基本entity.set後特定入所者介護サービス等等請求額(entity.getDbT3017_atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku());
        基本entity.set公費１負担者番号(entity.getDbT3017_kohi1FutanshaNo());
        基本entity.set公費１受給者番号(entity.getDbT3017_kohi1JukyushaNo());
        基本entity.set公費１給付率(entity.getDbT3017_kohi1Kyufuritsu());
        基本entity.set前公費１サービス単位数(entity.getDbT3017_maeHokenServiceTanisu());
        基本entity.set後公費１サービス単位数(entity.getDbT3017_atoHokenServiceTanisu());
        基本entity.set前公費１保険請求額(entity.getDbT3017_maeHokenSeikyugaku());
        基本entity.set後公費１保険請求額(entity.getDbT3017_atoHokenSeikyugaku());
        基本entity.set前公費１利用者負担額(entity.getDbT3017_maeKohi1RiyoshaFutangaku());
        基本entity.set後公費１利用者負担額(entity.getDbT3017_atoKohi1RiyoshaFutangaku());
        if (入力識別番号List.contains(入力識別番号)
                && new FlexibleYearMonth(サービス提供年月_200510).isBeforeOrEquals(new FlexibleYearMonth(サービス提供年月))) {
            基本entity.set前公費１特定診療費請求額(entity.getDbT3017_maeKohi1TokuteiShinryohiSeikyugaku());
            基本entity.set後公費１特定診療費請求額(entity.getDbT3017_atoKohi1TokuteiShinryohiSeikyugaku());
        }
        基本entity.set前公費１特定入所者介護サービス費等請求額(entity.getDbT3017_maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        基本entity.set後公費１特定入所者介護サービス費等請求額(entity.getDbT3017_atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        基本entity.set公費２負担者番号(entity.getDbT3017_kohi2FutanshaNo());
        基本entity.set公費２受給者番号(entity.getDbT3017_kohi2JukyushaNo());
        基本entity.set公費２給付率(entity.getDbT3017_kohi2Kyufuritsu());
        基本entity.set前公費２サービス単位数(entity.getDbT3017_maeHokenServiceTanisu());
        基本entity.set後公費２サービス単位数(entity.getDbT3017_atoHokenServiceTanisu());
        基本entity.set前公費２保険請求額(entity.getDbT3017_maeHokenSeikyugaku());
        基本entity.set後公費２保険請求額(entity.getDbT3017_atoHokenSeikyugaku());
        基本entity.set前公費２利用者負担額(entity.getDbT3017_maeKohi2RiyoshaFutangaku());
        基本entity.set後公費２利用者負担額(entity.getDbT3017_atoKohi2RiyoshaFutangaku());
        if (入力識別番号List.contains(入力識別番号)
                && new FlexibleYearMonth(サービス提供年月_200510).isBeforeOrEquals(new FlexibleYearMonth(サービス提供年月))) {
            基本entity.set前公費２特定診療費請求額(entity.getDbT3017_maeKohi2TokuteiShinryohiSeikyugaku());
            基本entity.set後公費２特定診療費請求額(entity.getDbT3017_atoKohi2TokuteiShinryohiSeikyugaku());
        }
        基本entity.set前公費２特定入所者介護サービス費等請求額(entity.getDbT3017_maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        基本entity.set後公費２特定入所者介護サービス費等請求額(entity.getDbT3017_atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        基本entity.set公費２負担者番号(entity.getDbT3017_kohi3FutanshaNo());
        基本entity.set公費２受給者番号(entity.getDbT3017_kohi3JukyushaNo());
        基本entity.set公費２給付率(entity.getDbT3017_kohi3Kyufuritsu());
        基本entity.set前公費２サービス単位数(entity.getDbT3017_maeHokenServiceTanisu());
        基本entity.set後公費２サービス単位数(entity.getDbT3017_atoHokenServiceTanisu());
        基本entity.set前公費２保険請求額(entity.getDbT3017_maeHokenSeikyugaku());
        基本entity.set後公費２保険請求額(entity.getDbT3017_atoHokenSeikyugaku());
        基本entity.set前公費２利用者負担額(entity.getDbT3017_maeKohi3RiyoshaFutangaku());
        基本entity.set後公費２利用者負担額(entity.getDbT3017_atoKohi3RiyoshaFutangaku());
        if (入力識別番号List.contains(入力識別番号)
                && new FlexibleYearMonth(サービス提供年月_200510).isBeforeOrEquals(new FlexibleYearMonth(サービス提供年月))) {
            基本entity.set前公費２特定診療費請求額(entity.getDbT3017_maeKohi3TokuteiShinryohiSeikyugaku());
            基本entity.set後公費２特定診療費請求額(entity.getDbT3017_atoKohi3TokuteiShinryohiSeikyugaku());
        }
        基本entity.set前公費２特定入所者介護サービス費等請求額(entity.getDbT3017_maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        基本entity.set後公費２特定入所者介護サービス費等請求額(entity.getDbT3017_atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        基本entity.set被保険者氏名カナ(entity.getPsm_tmp2_kanaMeisho());
        基本entity.set被保険者氏名(entity.getPsm_tmp2_meisho());
        基本entity.set世帯コード(entity.getPsm_tmp2_setaiCode());
        基本entity.set住所コード(entity.getPsm_tmp2_zenkokuJushoCode());
        基本entity.set住所(entity.getPsm_tmp2_jusho());
        基本entity.set行政区コード(entity.getPsm_tmp2_gyoseikuCode());
        基本entity.set行政区(entity.getPsm_tmp2_gyoseikuName());
        基本entity.set住民コード(entity.getDbT1001_tmp2_shikibetsuCode());
        基本entity.set区分(区分_基本);
        基本entity.set市町村コード(get市町村コード(entity));
        return 基本entity;
    }

    private RString get市町村コード(KihonRelateEntity entity) {
        if (!広域内住所地特例フラグ.equals(entity.getDbT1001_tmp2_koikinaiJushochiTokureiFlag())) {
            return entity.getDbT1001_tmp2_shichosonCode();
        } else {
            return entity.getDbT1001_tmp2_koikinaiTokureiSochimotoShichosonCode();
        }
    }

    private RString get期間(RString 開始, RString 終了) {
        RStringBuilder 認定有効期間sb = new RStringBuilder();
        if (!RString.isNullOrEmpty(開始)) {
            RString 開始_F = new RDate(開始.toString()).wareki().fillType(FillType.NONE).toDateString();
            認定有効期間sb.append(開始_F);
            認定有効期間sb.append(チルダ);
        }
        if (!RString.isNullOrEmpty(終了)) {
            RString 終了_F = new RDate(終了.toString()).wareki().fillType(FillType.NONE).toDateString();
            認定有効期間sb.append(終了_F);
        }
        return 認定有効期間sb.toRString();
    }

    private List<RString> get居住サービス計画作成区分名(RString 居住サービス計画作成区分) {
        List<RString> 居住サービス計画作成区分名 = new ArrayList<>();
        if (居住サービス計画作成区分コード_1.equals(居住サービス計画作成区分)) {
            居住サービス計画作成区分名.add(new RString("居宅介護支"));
            居住サービス計画作成区分名.add(new RString("援事業所"));
        } else if (居住サービス計画作成区分コード_2.equals(居住サービス計画作成区分)) {
            居住サービス計画作成区分名.add(new RString("基準該当事"));
            居住サービス計画作成区分名.add(new RString("業所"));
        } else if (居住サービス計画作成区分コード_3.equals(居住サービス計画作成区分)) {
            居住サービス計画作成区分名.add(new RString("自己作成"));
            居住サービス計画作成区分名.add(RString.EMPTY);
        } else if (居住サービス計画作成区分コード_4.equals(居住サービス計画作成区分)) {
            居住サービス計画作成区分名.add(new RString("介護予防支"));
            居住サービス計画作成区分名.add(new RString("援事業所"));
        } else {
            居住サービス計画作成区分名.add(RString.EMPTY);
            居住サービス計画作成区分名.add(RString.EMPTY);
        }
        return 居住サービス計画作成区分名;
    }

    private List<RString> get居住サービス計画事業者名(RString 事業者名称) {
        List<RString> 住サービス計画事業者名 = new ArrayList<>();
        if (RString.isNullOrEmpty(事業者名称)) {
            住サービス計画事業者名.add(RString.EMPTY);
            住サービス計画事業者名.add(RString.EMPTY);
        } else {
            if (事業者名称.length() <= 居住サービス計画事業者名_LENGTH) {
                住サービス計画事業者名.add(事業者名称);
                住サービス計画事業者名.add(RString.EMPTY);
            } else if (事業者名称.length() <= 居住サービス計画事業者名_LENGTH_40) {
                住サービス計画事業者名.add(事業者名称.substring(0, 居住サービス計画事業者名_LENGTH));
                住サービス計画事業者名.add(事業者名称.substring(居住サービス計画事業者名_LENGTH));
            } else {
                住サービス計画事業者名.add(事業者名称.substring(0, 居住サービス計画事業者名_LENGTH));
                住サービス計画事業者名.add(事業者名称.substring(居住サービス計画事業者名_LENGTH, 居住サービス計画事業者名_LENGTH_40));
            }
        }
        return 住サービス計画事業者名;
    }

    private RString get中止理由タイトル(RString 入力識別番号, RString サービス提供年月) {
        List<RString> 入力識別番号List = new ArrayList<>();
        入力識別番号List.add(入力識別番号_7171);
        入力識別番号List.add(入力識別番号_7172);
        入力識別番号List.add(入力識別番号_7173);
        入力識別番号List.add(入力識別番号_7174);
        入力識別番号List.add(入力識別番号_2171);
        入力識別番号List.add(入力識別番号_2172);
        入力識別番号List.add(入力識別番号_2173);
        入力識別番号List.add(入力識別番号_2174);
        入力識別番号List.add(入力識別番号_7181);
        入力識別番号List.add(入力識別番号_7182);
        入力識別番号List.add(入力識別番号_7183);
        入力識別番号List.add(入力識別番号_2181);
        入力識別番号List.add(入力識別番号_2182);
        入力識別番号List.add(入力識別番号_2183);
        入力識別番号List.add(入力識別番号_7191);
        入力識別番号List.add(入力識別番号_7192);
        入力識別番号List.add(入力識別番号_7193);
        入力識別番号List.add(入力識別番号_7194);
        入力識別番号List.add(入力識別番号_7195);
        入力識別番号List.add(入力識別番号_2191);
        入力識別番号List.add(入力識別番号_2192);
        入力識別番号List.add(入力識別番号_2193);
        入力識別番号List.add(入力識別番号_2194);
        入力識別番号List.add(入力識別番号_2195);
        入力識別番号List.add(入力識別番号_71A1);
        入力識別番号List.add(入力識別番号_71A2);
        入力識別番号List.add(入力識別番号_71A3);
        入力識別番号List.add(入力識別番号_21A1);
        入力識別番号List.add(入力識別番号_21A2);
        入力識別番号List.add(入力識別番号_21A3);
        if (入力識別番号List.contains(入力識別番号)
                && new FlexibleYearMonth(入所_院_前).isBeforeOrEquals(new FlexibleYearMonth(サービス提供年月))) {
            return new RString("入所（院）前の状況");
        } else {
            return new RString("中止理由");
        }
    }

    private RString get基本ヘッダー(RString 入力識別番号, RString サービス提供年月, List<RString> 入力識別番号List) {
        if (入力識別番号List.contains(入力識別番号)
                && new FlexibleYearMonth(サービス提供年月_200510).isBeforeOrEquals(new FlexibleYearMonth(サービス提供年月))) {
            return new RString("特別療養費");
        } else {
            return new RString("食事提供費");
        }
    }

    private List<RString> get入力識別番号List() {
        List<RString> 入力識別番号List = new ArrayList<>();
        入力識別番号List.add(入力識別番号_716X);
        入力識別番号List.add(入力識別番号_216X);
        入力識別番号List.add(入力識別番号_71AX);
        入力識別番号List.add(入力識別番号_21AX);
        入力識別番号List.add(入力識別番号_2155);
        入力識別番号List.add(入力識別番号_2156);
        入力識別番号List.add(入力識別番号_2194);
        入力識別番号List.add(入力識別番号_7155);
        入力識別番号List.add(入力識別番号_7156);
        入力識別番号List.add(入力識別番号_7194);
        return 入力識別番号List;
    }
}
