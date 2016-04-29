/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.InputShikibetsuNo;
import jp.co.ndensan.reams.db.dbc.business.core.JigyoshaNoListOfServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiDetailKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiJutakuKaishuhi;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiJutakuKaishuhiCollection;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKihonGokei;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKihonGokeiCollection;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKihonHihokensha;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKihonKohi;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKihonKyotakuService;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKihonKyufuritsu;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKihonNyutaisho;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKihonServiceKikan;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKyotakuService;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKyotakuServiceCollection;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiMeisaiCollection;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiShafukuKeigen;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiShafukuKeigenCollection;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiShukei;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiShukeiCollection;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiTokuteiNyushohi;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiTokuteiNyushohiCollection;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiYoguHanbaihiCollection;
import jp.co.ndensan.reams.db.dbc.business.core.ServiceTeikyoYMListOfServiceShurui;
import jp.co.ndensan.reams.db.dbc.definition.core.enumeratedtype.KeikokuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.enumeratedtype.KyufuJissekiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.enumeratedtype.KyufuSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3018KyufujissekiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3025KyufujissekiKyotakuServiceEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3026KyufujissekiFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3027KyufujissekiJutakuKaishuhiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ToshiNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績エンティティを給付実績情報に変換するMapperクラスです。
 *
 * @author N8156 宮本 康
 */
public final class KyufuJissekiMapper {

    private static final int SERVICE_SHURUI_CODE_LENGTH = 2;

    private static final RString 前 = RString.EMPTY;
    private static final RString 後 = new RString("後");
    private static final RString 保険 = new RString("保険");
    private static final RString 公費1 = new RString("公費１");
    private static final RString 公費2 = new RString("公費２");
    private static final RString 公費3 = new RString("公費３");
    private static final RString 明細 = new RString("明細");
    private static final RString 合計 = new RString("合計");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private KyufuJissekiMapper() {
    }

    /**
     * 給付実績種類詳細エンティティから給付実績詳細キー情報を作成して返します。
     *
     * @param entities 給付実績種類詳細エンティティ
     * @param キー情報 給付実績キー情報
     * @return 給付実績詳細キー情報
     */
    public static KyufuJissekiDetailKeyInfo to給付実績詳細キー(List<DbV3016KyufujissekiShuruiDetailEntity> entities, KyufuJissekiKeyInfo キー情報) {
        if (entities == null || entities.isEmpty() || キー情報 == null) {
            return null;
        }

        DbV3016KyufujissekiShuruiDetailEntity entity = new DbV3016KyufujissekiShuruiDetailEntity();
        for (int index = 0; index < entities.size(); index++) {
            entity = entities.get(index);
            if ((キー情報.get被保番号() == null || キー情報.get被保番号().equals(entity.getHiHokenshaNo()))
                    && (キー情報.get入力識別番号() == null
                    || キー情報.get入力識別番号().getInputShikibetsuNoCode().value().equals(entity.getInputShikibetsuNo().value()))
                    && (キー情報.getサービス種類コード() == null || キー情報.getサービス種類コード().equals(getサービス種類コード(entity)))
                    && (キー情報.getサービス提供年月() == null || キー情報.getサービス提供年月().value().equals(entity.getServiceTeikyoYM()))) {
                break;
            }
        }

        return new KyufuJissekiDetailKeyInfo(
                new KokanShikibetsuNo(entity.getKokanShikibetsuNo().getColumnValue()),
                //TODO 名称などはどこから取ってくるのか
                new InputShikibetsuNo(new Code(entity.getInputShikibetsuNo().getColumnValue()), new RString(""), new RString("")),
                new ShoKisaiHokenshaNo(entity.getHokenshaNo().getColumnValue()),
                entity.getHiHokenshaNo(),
                new ServiceTeikyoYM(entity.getServiceTeikyoYM()),
                entity.getJigyoshoNo(),
                new ToshiNo(entity.getToshiNo()),
                to対象サービス種類リスト(entities));
    }

    private static ServiceShuruiCode getサービス種類コード(DbV3016KyufujissekiShuruiDetailEntity entity) {
        ServiceShuruiCode serviceShuruiCode = entity.getServiceSyuruiCode();
        ServiceCode serviceCode = entity.getServiceCode();
        if (serviceShuruiCode != null && !serviceShuruiCode.value().isEmpty()) {
            return serviceShuruiCode;
        } else if (serviceCode != null && SERVICE_SHURUI_CODE_LENGTH <= serviceCode.value().length()) {
            return new ServiceShuruiCode(serviceCode.value().substring(0, SERVICE_SHURUI_CODE_LENGTH));
        } else {
            return null;
        }
    }

    private static List<ServiceTeikyoYMListOfServiceShurui> to対象サービス種類リスト(List<DbV3016KyufujissekiShuruiDetailEntity> entities) {

        List<JigyoshaNo> jigyoshaNoList = new ArrayList<>();
        List<JigyoshaNoListOfServiceTeikyoYM> teikyoYMList = new ArrayList<>();
        List<ServiceTeikyoYMListOfServiceShurui> shuruiCodeList = new ArrayList<>();

        for (int index = 0; index < entities.size(); index++) {

            jigyoshaNoList.add(entities.get(index).getJigyoshoNo());

            boolean last = (index == (entities.size() - 1));

            ServiceTeikyoYM teikyoYM = new ServiceTeikyoYM(entities.get(index).getServiceTeikyoYM());
            ServiceTeikyoYM nextTeikyoYM = new ServiceTeikyoYM(!last ? entities.get(index + 1).getServiceTeikyoYM() : null);
            if (last || !teikyoYM.equals(nextTeikyoYM)) {
                teikyoYMList.add(new JigyoshaNoListOfServiceTeikyoYM(teikyoYM, jigyoshaNoList));
                jigyoshaNoList = new ArrayList<>();
            }

            ServiceShuruiCode shuruiCode = entities.get(index).getServiceSyuruiCode();
            ServiceShuruiCode nextShuruiCode = !last ? entities.get(index + 1).getServiceSyuruiCode() : null;
            if (last || !shuruiCode.equals(nextShuruiCode)) {
                shuruiCodeList.add(new ServiceTeikyoYMListOfServiceShurui(shuruiCode, teikyoYMList));
                jigyoshaNoList = new ArrayList<>();
                teikyoYMList = new ArrayList<>();
            }

        }

        return shuruiCodeList;
    }

    /**
     * 給付実績基本エンティティから給付実績基本情報を作成して返します。
     *
     * @param entity 給付実績基本エンティティ
     * @return 給付実績基本情報
     */
    public static KyufuJissekiKihon to給付実績基本(DbT3017KyufujissekiKihonEntity entity) {
        return entity != null ? new KyufuJissekiKihon(
                entity.getHiHokenshaNo(),
                RString.EMPTY,
                Gender.toValue(entity.getSeibetsuCode()),
                entity.getUmareYMD(),
                new ServiceTeikyoYM(entity.getServiceTeikyoYM()),
                KyufuJissekiKubun.toValue(entity.getKyufuJissekiKubunCode()),
                entity.getSeiriNo(),
                entity.getShokisaiHokenshaNo().value(),
                new InputShikibetsuNo(new Code(entity.getInputShikibetsuNo().getColumnValue()), RString.EMPTY, RString.EMPTY),
                entity.getJigyoshoNo().value(),
                KyufuSakuseiKubun.toValue(entity.getKyufuSakuseiKubunCode()),
                entity.getYoKaigoJotaiKubunCode(),
                new Range<>(entity.getNinteiYukoKaishiYMD(), entity.getNinteiYukoShuryoYMD()),
                entity.getShinsaYM(),
                KeikokuKubun.toValue(entity.getKeikaiKubunCode()),
                to被保険者情報(entity),
                to居宅サービス計画情報(entity),
                toサービス期間情報(entity),
                to施設入退所情報(entity),
                to給付率情報(entity),
                to公費情報(entity),
                to合計情報List(entity)) : null;
    }

    private static KyufuJissekiKihonHihokensha to被保険者情報(DbT3017KyufujissekiKihonEntity entity) {
        return new KyufuJissekiKihonHihokensha(
                entity.getKyuSochiNyushoshaTokureiCode(),
                entity.getRojinHokenShichosonNo(),
                entity.getRojinhokenJukyushaNo(),
                entity.getKokiHokenshaNo(),
                entity.getKokiHiHokenshaNo(),
                entity.getKokuhoHokenshaNo(),
                entity.getKokuhoHiHokenshashoNo(),
                entity.getKokuhoKojinNo());
    }

    private static KyufuJissekiKihonKyotakuService to居宅サービス計画情報(DbT3017KyufujissekiKihonEntity entity) {
        return new KyufuJissekiKihonKyotakuService(
                entity.getKyotakuServiceSakuseiKubunCode(),
                entity.getKyotakuKaigoShienJigyoshoNo(),
                RString.EMPTY);
    }

    private static KyufuJissekiKihonServiceKikan toサービス期間情報(DbT3017KyufujissekiKihonEntity entity) {
        return new KyufuJissekiKihonServiceKikan(
                entity.getKaishiYMD(),
                entity.getChushiYMD(),
                entity.getChushiRiyuNyushomaeJyokyoCode());
    }

    private static KyufuJissekiKihonNyutaisho to施設入退所情報(DbT3017KyufujissekiKihonEntity entity) {
        return new KyufuJissekiKihonNyutaisho(
                entity.getNyushoYMD(),
                entity.getTaishoYMD(),
                entity.getNyushoJitsunissu(),
                entity.getGaihakuNissu(),
                entity.getChushiRiyuNyushomaeJyokyoCode(),
                entity.getTaishogoJotaiCode());
    }

    private static KyufuJissekiKihonKyufuritsu to給付率情報(DbT3017KyufujissekiKihonEntity entity) {
        return new KyufuJissekiKihonKyufuritsu(
                entity.getHokenKyufuritsu(),
                entity.getKohi1Kyufuritsu(),
                entity.getKohi2Kyufuritsu(),
                entity.getKohi3Kyufuritsu());
    }

    private static KyufuJissekiKihonKohi to公費情報(DbT3017KyufujissekiKihonEntity entity) {
        return new KyufuJissekiKihonKohi(
                entity.getKohi1FutanshaNo(),
                entity.getKohi1JukyushaNo(),
                entity.getKohi2FutanshaNo(),
                entity.getKohi2JukyushaNo(),
                entity.getKohi3FutanshaNo(),
                entity.getKohi3JukyushaNo());
    }

    private static KyufuJissekiKihonGokeiCollection to合計情報List(DbT3017KyufujissekiKihonEntity entity) {
        List<KyufuJissekiKihonGokei> list = new ArrayList<>();
        list.add(new KyufuJissekiKihonGokei(
                保険, 前,
                new Decimal(entity.getMaeHokenServiceTanisu()),
                entity.getMaeHokenSeikyugaku(),
                new Decimal(entity.getMaeHokenRiyoshaFutangaku()),
                entity.getMaeHokenKinkyuShisetsuRyoyoSeikyugaku(),
                entity.getMaeHokenTokuteiShinryohiSeikyugaku(),
                new Decimal(entity.getMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku())));
        list.add(new KyufuJissekiKihonGokei(
                RString.EMPTY, 後,
                new Decimal(entity.getAtoHokenServiceTanisu()),
                entity.getAtoHokenSeikyugaku(),
                new Decimal(entity.getAtoHokenRiyoshaFutangaku()),
                entity.getAtoHokenKinkyuShisetsuRyoyoSeikyugaku(),
                entity.getAtoHokenTokuteiShinryohiSeikyugaku(),
                new Decimal(entity.getAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku())));
        list.add(new KyufuJissekiKihonGokei(
                公費1, 前,
                new Decimal(entity.getMaeKohi1ServiceTanisu()),
                new Decimal(entity.getMaeKohi1Seikyugaku()),
                new Decimal(entity.getMaeKohi1RiyoshaFutangaku()),
                new Decimal(entity.getMaeKohi1KinkyuShisetsuRyoyoSeikyugaku()),
                new Decimal(entity.getMaeKohi1TokuteiShinryohiSeikyugaku()),
                new Decimal(entity.getMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku())));
        list.add(new KyufuJissekiKihonGokei(
                RString.EMPTY, 後,
                new Decimal(entity.getAtoKohi1ServiceTanisu()),
                new Decimal(entity.getAtoKohi1Seikyugaku()),
                new Decimal(entity.getAtoKohi1RiyoshaFutangaku()),
                new Decimal(entity.getAtoKohi1KinkyuShisetsuRyoyoSeikyugaku()),
                new Decimal(entity.getAtoKohi1TokuteiShinryohiSeikyugaku()),
                new Decimal(entity.getAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku())));
        list.add(new KyufuJissekiKihonGokei(
                公費2, 前,
                new Decimal(entity.getMaeKohi2ServiceTanisu()),
                new Decimal(entity.getMaeKohi2Seikyugaku()),
                new Decimal(entity.getMaeKohi2RiyoshaFutangaku()),
                new Decimal(entity.getMaeKohi2KinkyuShisetsuRyoyoSeikyugaku()),
                new Decimal(entity.getMaeKohi2TokuteiShinryohiSeikyugaku()),
                new Decimal(entity.getMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku())));
        list.add(new KyufuJissekiKihonGokei(
                RString.EMPTY, 後,
                new Decimal(entity.getAtoKohi2ServiceTanisu()),
                new Decimal(entity.getAtoKohi2Seikyugaku()),
                new Decimal(entity.getAtoKohi2RiyoshaFutangaku()),
                new Decimal(entity.getAtoKohi2KinkyuShisetsuRyoyoSeikyugaku()),
                new Decimal(entity.getAtoKohi2TokuteiShinryohiSeikyugaku()),
                new Decimal(entity.getAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku())));
        list.add(new KyufuJissekiKihonGokei(
                公費3, 前,
                new Decimal(entity.getMaeKohi3ServiceTanisu()),
                new Decimal(entity.getMaeKohi3Seikyugaku()),
                new Decimal(entity.getMaeKohi3RiyoshaFutangaku()),
                new Decimal(entity.getMaeKohi3KinkyuShisetsuRyoyoSeikyugaku()),
                new Decimal(entity.getMaeKohi3TokuteiShinryohiSeikyugaku()),
                new Decimal(entity.getMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku())));
        list.add(new KyufuJissekiKihonGokei(
                RString.EMPTY, 後,
                new Decimal(entity.getAtoKohi3ServiceTanisu()),
                new Decimal(entity.getAtoKohi3Seikyugaku()),
                new Decimal(entity.getAtoKohi3RiyoshaFutangaku()),
                new Decimal(entity.getAtoKohi3KinkyuShisetsuRyoyoSeikyugaku()),
                new Decimal(entity.getAtoKohi3TokuteiShinryohiSeikyugaku()),
                new Decimal(entity.getAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku())));

        return new KyufuJissekiKihonGokeiCollection(list);
    }

    /**
     * 給付実績明細エンティティから給付実績明細情報を作成して返す。
     *
     * @param entities 給付実績明細エンティティList
     * @return 給付実績明細情報List
     */
    public static KyufuJissekiMeisaiCollection to給付実績明細List(List<DbT3018KyufujissekiMeisaiEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return new KyufuJissekiMeisaiCollection(Collections.EMPTY_LIST);
        }

        List<KyufuJissekiMeisai> list = new ArrayList<>();
        for (DbT3018KyufujissekiMeisaiEntity entity : entities) {
            list.add(new KyufuJissekiMeisai(
                    entity.getServiceShuruiCode().value(),
                    entity.getTekiyo(),
                    前,
                    entity.getTanisu(),
                    entity.getNissuKaisu(),
                    entity.getKohi1TaishoNissuKaisu(),
                    entity.getKohi2TaishoNissuKaisu(),
                    entity.getKohi3TaishoNissuKaisu(),
                    entity.getServiceTanisu(),
                    entity.getKohi1TaishoServiceTanisu(), entity.getKohi2TaishoServiceTanisu(),
                    entity.getKohi3TaishoServiceTanisu(),
                    entity.getSaishinsaKaisu(),
                    entity.getKagoKaisu(),
                    entity.getShinsaYM()));
            list.add(new KyufuJissekiMeisai(
                    entity.getServiceShuruiCode().value(),
                    RString.EMPTY,
                    後,
                    entity.getAtoTanisu(),
                    entity.getAtoNissuKaisu(),
                    entity.getAtoKohi1TaishoNissuKaisu(),
                    entity.getAtoKohi2TaishoNissukaisu(),
                    entity.getAtoKohi3TaishoNissuKaisu(),
                    entity.getServiceTanisu(),
                    entity.getAtoKohi1TaishoServiceTanisu(), entity.getAtoKohi2TaishoServiceTanisu(), entity.getAtoKohi3TaishoServiceTanisu(),
                    entity.getSaishinsaKaisu(),
                    entity.getKagoKaisu(),
                    entity.getShinsaYM()));
        }

        return new KyufuJissekiMeisaiCollection(list);
    }

    /**
     * 給付実績集計エンティティから給付実績集計情報を作成して返す。
     *
     * @param entities 給付実績集計エンティティList
     * @return 給付実績集計情報List
     */
    public static KyufuJissekiShukeiCollection to給付実績集計List(List<DbT3033KyufujissekiShukeiEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return new KyufuJissekiShukeiCollection(Collections.EMPTY_LIST);
        }

        List<KyufuJissekiShukei> list = new ArrayList<>();
        for (DbT3033KyufujissekiShukeiEntity entity : entities) {
            list.add(new KyufuJissekiShukei(
                    entity.getServiceSyuruiCode().value(), entity.getServiceJitsunissu(), entity.getPlanTanisu(),
                    entity.getGendogakuKanriTaishoTanisu(),
                    entity.getGendogakuKanritaishogaiTanisu(),
                    entity.getTankiNyushoPlanNissu(),
                    保険, 前,
                    entity.getTankiNyushoJitsunissu(),
                    entity.getHokenTanisuTotal(),
                    entity.getHokenTanisuTani(),
                    entity.getHokenSeikyugaku(),
                    entity.getHokenRiyoshaFutangaku(),
                    entity.getHokenDekidakaTanisuTotal(),
                    entity.getHokenDekidakaSeikyugaku(),
                    entity.getHokenDekidakaIryohiRiyoshaFutangaku(),
                    entity.getSaishinsaKaisu(), entity.getKagoKaisu(), entity.getShinsaYM()));
            list.add(new KyufuJissekiShukei(
                    entity.getServiceSyuruiCode().value(), entity.getServiceJitsunissu(), entity.getPlanTanisu(),
                    entity.getGendogakuKanriTaishoTanisu(), entity.getGendogakuKanritaishogaiTanisu(), entity.getTankiNyushoPlanNissu(),
                    RString.EMPTY, 後,
                    entity.getAtoTankiNyushoJitsunissu(),
                    entity.getAtoHokenTanisuTotal(),
                    null,
                    entity.getAtoHokenSeikyugaku(),
                    null,
                    entity.getAtoHokenDekidakaTanisuTotal(),
                    entity.getAtoHokenDekidakaSeikyugaku(),
                    null,
                    entity.getSaishinsaKaisu(), entity.getKagoKaisu(), entity.getShinsaYM()));
            list.add(new KyufuJissekiShukei(
                    entity.getServiceSyuruiCode().value(), entity.getServiceJitsunissu(), entity.getPlanTanisu(),
                    entity.getGendogakuKanriTaishoTanisu(), entity.getGendogakuKanritaishogaiTanisu(), entity.getTankiNyushoPlanNissu(),
                    公費1, 前,
                    entity.getTankiNyushoJitsunissu(),
                    entity.getKohi1TanisuTotal(),
                    null,
                    entity.getKohi1Seikyugaku(),
                    entity.getKohi1HonninFutangaku(),
                    entity.getKohi1DekidakaTanisuTotal(),
                    entity.getKohi1DekidakaSeikyugaku(),
                    entity.getKohi1DekidakaIryohiRiyoshaFutangaku(),
                    entity.getSaishinsaKaisu(), entity.getKagoKaisu(), entity.getShinsaYM()));
            list.add(new KyufuJissekiShukei(
                    entity.getServiceSyuruiCode().value(), entity.getServiceJitsunissu(), entity.getPlanTanisu(),
                    entity.getGendogakuKanriTaishoTanisu(), entity.getGendogakuKanritaishogaiTanisu(), entity.getTankiNyushoPlanNissu(),
                    RString.EMPTY, 後,
                    entity.getAtoTankiNyushoJitsunissu(),
                    entity.getAtoKohi1TanisuTotal(),
                    null,
                    entity.getAtoKohi1Seikyugaku(),
                    null,
                    entity.getAtoKohi1DekidakaTanisuTotal(),
                    entity.getAtoKohi1DekidakaSeikyugaku(),
                    null,
                    entity.getSaishinsaKaisu(), entity.getKagoKaisu(), entity.getShinsaYM()));
            list.add(new KyufuJissekiShukei(
                    entity.getServiceSyuruiCode().value(), entity.getServiceJitsunissu(), entity.getPlanTanisu(),
                    entity.getGendogakuKanriTaishoTanisu(), entity.getGendogakuKanritaishogaiTanisu(), entity.getTankiNyushoPlanNissu(),
                    公費2, 前,
                    entity.getTankiNyushoJitsunissu(),
                    entity.getKohi2TanisuTotal(),
                    null,
                    entity.getKohi2Seikyugaku(),
                    entity.getKohi2HonninFutangaku(),
                    entity.getKohi2DekidakaTanisuTotal(),
                    entity.getKohi2DekidakaSeikyugaku(),
                    entity.getKohi2DekidakaIryohiRiyoshaFutangaku(),
                    entity.getSaishinsaKaisu(), entity.getKagoKaisu(), entity.getShinsaYM()));
            list.add(new KyufuJissekiShukei(
                    entity.getServiceSyuruiCode().value(), entity.getServiceJitsunissu(), entity.getPlanTanisu(),
                    entity.getGendogakuKanriTaishoTanisu(), entity.getGendogakuKanritaishogaiTanisu(), entity.getTankiNyushoPlanNissu(),
                    RString.EMPTY, 後,
                    entity.getAtoTankiNyushoJitsunissu(),
                    entity.getAtoKohi2TanisuTotal(),
                    null,
                    entity.getAtoKohi2Seikyugaku(),
                    null,
                    entity.getAtoKohi2DekidakaTanisuTotal(),
                    entity.getAtoKohi2DekidakaSeikyugaku(),
                    null,
                    entity.getSaishinsaKaisu(), entity.getKagoKaisu(), entity.getShinsaYM()));
            list.add(new KyufuJissekiShukei(
                    entity.getServiceSyuruiCode().value(), entity.getServiceJitsunissu(), entity.getPlanTanisu(),
                    entity.getGendogakuKanriTaishoTanisu(), entity.getGendogakuKanritaishogaiTanisu(), entity.getTankiNyushoPlanNissu(),
                    公費3, 前,
                    entity.getTankiNyushoJitsunissu(),
                    entity.getKohi3TanisuTotal(),
                    null,
                    entity.getKohi3Seikyugaku(),
                    entity.getKohi3HonninFutangaku(),
                    entity.getKohi3DekidakaTanisuTotal(),
                    entity.getKohi3DekidakaSeikyugaku(),
                    entity.getKohi3DekidakaIryohiRiyoshaFutangaku(),
                    entity.getSaishinsaKaisu(), entity.getKagoKaisu(), entity.getShinsaYM()));
            list.add(new KyufuJissekiShukei(
                    entity.getServiceSyuruiCode().value(), entity.getServiceJitsunissu(), entity.getPlanTanisu(),
                    entity.getGendogakuKanriTaishoTanisu(), entity.getGendogakuKanritaishogaiTanisu(), entity.getTankiNyushoPlanNissu(),
                    RString.EMPTY, 後,
                    entity.getAtoTankiNyushoJitsunissu(),
                    entity.getAtoKohi3TanisuTotal(),
                    null,
                    entity.getAtoKohi3Seikyugaku(),
                    null,
                    entity.getAtoKohi3DekidakaTanisuTotal(),
                    entity.getAtoKohi3DekidakaSeikyugaku(),
                    null,
                    entity.getSaishinsaKaisu(), entity.getKagoKaisu(), entity.getShinsaYM()));
        }

        return new KyufuJissekiShukeiCollection(list);
    }

    /**
     * 給付実績社会福祉法人軽減額エンティティから給付実績社会福祉法人軽減額情報を作成して返す。
     *
     * @param entities 給付実績社会福祉法人軽減額エンティティList
     * @return 給付実績社会福祉法人軽減額情報List
     */
    public static KyufuJissekiShafukuKeigenCollection to給付実績社会福祉法人軽減額List(
            List<DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return new KyufuJissekiShafukuKeigenCollection(Collections.EMPTY_LIST);
        }

        List<KyufuJissekiShafukuKeigen> list = new ArrayList<>();
        for (DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity entity : entities) {
            Decimal keigenritsu = entity.getKeigenritsu();
            RString keigenritsuR = keigenritsu == null ? RString.EMPTY : new RString(keigenritsu.toString());
            list.add(new KyufuJissekiShafukuKeigen(
                    keigenritsuR,
                    entity.getServiceSyuruiCode().value(),
                    前,
                    entity.getRiyoshaFutanTotal(),
                    entity.getKeigengaku(),
                    entity.getKeigengoRiyoshaFutangaku(),
                    entity.getBiko(),
                    entity.getSaishinsaKaisu(),
                    entity.getKagoKaisu(),
                    entity.getShinsaYM()));
            list.add(new KyufuJissekiShafukuKeigen(
                    keigenritsuR,
                    entity.getServiceSyuruiCode().value(),
                    後,
                    entity.getAtoRiyoshaFutanTotal(),
                    entity.getAtoKeigengaku(),
                    entity.getAtoKeigengoRiyoshaFutangaku(),
                    entity.getBiko(),
                    entity.getSaishinsaKaisu(),
                    entity.getKagoKaisu(),
                    entity.getShinsaYM()));
        }

        return new KyufuJissekiShafukuKeigenCollection(list);
    }

    /**
     * 給付実績サービス計画費エンティティから給付実績サービス計画費情報を作成して返す。
     *
     * @param entities 給付実績サービス計画費エンティティList
     * @return 給付実績サービス計画費情報List
     */
    public static KyufuJissekiKyotakuServiceCollection to給付実績サービス計画費List(List<DbT3025KyufujissekiKyotakuServiceEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return new KyufuJissekiKyotakuServiceCollection(Collections.EMPTY_LIST);
        }

        List<KyufuJissekiKyotakuService> maeList = new ArrayList<>();
        List<KyufuJissekiKyotakuService> atoList = new ArrayList<>();

        for (DbT3025KyufujissekiKyotakuServiceEntity entity : entities) {
            ServiceCode serviceCode = entity.getServiceCode();
            RString serviceCodeR = serviceCode == null ? RString.EMPTY : serviceCode.value();
            maeList.add(new KyufuJissekiKyotakuService(
                    entity.getShiteiKijunGaitoJigyoshaKubunCode(),
                    entity.getKyotakuServiceSakuseiIraiYMD(),
                    serviceCodeR,
                    entity.getTanisuTanka(),
                    前, 明細,
                    entity.getTanisu(), entity.getKaisu(), entity.getServiceTanisu(), null,
                    entity.getTantouKaigoShienSemmoninNo(),
                    entity.getSaishinsaKaisu(), entity.getKagoKaisu(), entity.getShinsaYM(), entity.getTekiyo()));
            atoList.add(new KyufuJissekiKyotakuService(
                    entity.getShiteiKijunGaitoJigyoshaKubunCode(),
                    entity.getKyotakuServiceSakuseiIraiYMD(),
                    serviceCodeR,
                    entity.getTanisuTanka(),
                    後, 明細,
                    entity.getAtoTanisu(), entity.getAtoKaisu(), entity.getAtoServiceTanisu(), null,
                    entity.getTantouKaigoShienSemmoninNo(),
                    entity.getSaishinsaKaisu(), entity.getKagoKaisu(), entity.getShinsaYM(), entity.getTekiyo()));
        }

        DbT3025KyufujissekiKyotakuServiceEntity entity = entities.get(entities.size() - 1);
        maeList.add(new KyufuJissekiKyotakuService(
                null, null, null, null,
                前, 合計, null, null,
                entity.getServiceTanisuTotal(), entity.getSeikyuKingaku(), null, null, null, null, null));
        atoList.add(new KyufuJissekiKyotakuService(
                null, null, null, null,
                後, 合計, null, null,
                entity.getAtoServiceTanisuTotal(), entity.getAtoSeikyuKingaku(), null, null, null, null, null));

        maeList.addAll(atoList);

        return new KyufuJissekiKyotakuServiceCollection(maeList);
    }

    /**
     * 給付実績福祉用具購入費エンティティから給付実績福祉用具購入費情報を作成して返す。
     *
     * @param entities 給付実績福祉用具購入費エンティティList
     * @return 給付実績福祉用具購入費情報List
     */
    public static KyufuJissekiYoguHanbaihiCollection to給付実績福祉用具購入費List(
            List<DbT3026KyufujissekiFukushiYoguHanbaihiEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return new KyufuJissekiYoguHanbaihiCollection(Collections.EMPTY_LIST);
        }

        List<KyufuJissekiYoguHanbaihi> list = new ArrayList<>();
        for (DbT3026KyufujissekiFukushiYoguHanbaihiEntity entity : entities) {
            list.add(new KyufuJissekiYoguHanbaihi(
                    entity.getServiceCode().value(),
                    entity.getFukushiyoguHanbaiYMD(),
                    entity.getFukushiyoguShohinName(),
                    entity.getFukushiyoguSyumokuCode(),
                    entity.getFukushiyoguSeizoJigyoshaName(),
                    entity.getFukushiyoguHanbaiJigyoshaName(),
                    entity.getHanbaiKingaku(),
                    entity.getShinsaYM(),
                    entity.getTekiyo()));
        }

        return new KyufuJissekiYoguHanbaihiCollection(list);
    }

    /**
     * 給付実績住宅改修費エンティティから給付実績住宅改修費情報を作成して返す。
     *
     * @param entities 給付実績住宅改修費エンティティList
     * @return 給付実績住宅改修費情報List
     */
    public static KyufuJissekiJutakuKaishuhiCollection to給付実績住宅改修費List(
            List<DbT3027KyufujissekiJutakuKaishuhiEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return new KyufuJissekiJutakuKaishuhiCollection(Collections.EMPTY_LIST);
        }

        List<KyufuJissekiJutakuKaishuhi> list = new ArrayList<>();
        for (DbT3027KyufujissekiJutakuKaishuhiEntity entity : entities) {
            list.add(new KyufuJissekiJutakuKaishuhi(
                    entity.getServiceCode().value(),
                    entity.getJutakuKaishuchakkoYMD(),
                    entity.getJutakuKaishuJigyoshaName(),
                    entity.getJuutakukaishuJyutakuAdress(),
                    entity.getKaishuKingaku(),
                    entity.getShinsaYM()));
        }

        return new KyufuJissekiJutakuKaishuhiCollection(list);
    }

    /**
     * 給付実績の特定入所者エンティティから給付実績の特定入所者情報を作成して返す。
     *
     * @param entities 給付実績の特定入所者エンティティList
     * @return 給付実績の特定入所者List
     */
    public static KyufuJissekiTokuteiNyushohiCollection to給付実績特定入所者費用List(
            List<DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return new KyufuJissekiTokuteiNyushohiCollection(Collections.EMPTY_LIST);
        }

        List<KyufuJissekiTokuteiNyushohi> maeList = new ArrayList<>();
        List<KyufuJissekiTokuteiNyushohi> atoList = new ArrayList<>();

        for (DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity entity : entities) {
            RStringBuilder sb = new RStringBuilder();
            sb.append(entity.getServiceSyuruiCode().value()).append(entity.getServiceKomokuCode().value());
            maeList.add(new KyufuJissekiTokuteiNyushohi(
                    sb.toRString(), entity.getFutanGendogaku(),
                    前, 明細,
                    entity.getHiyoTanka(), entity.getNissu(),
                    entity.getHiyogaku(), entity.getHokenbunSeikyugaku(), entity.getRiyoshaFutangaku(),
                    entity.getKohi1Nissu(), entity.getKohi1Futangaku(), null, null,
                    entity.getKohi2Nissu(), entity.getKohi2Futangaku(), null, null,
                    entity.getKohi3Nissu(), entity.getKohi3Futangaku(), null, null,
                    entity.getSaishinsaKaisu(), entity.getKagoKaisu(), entity.getShinsaYM()));
            atoList.add(new KyufuJissekiTokuteiNyushohi(
                    sb.toRString(), entity.getFutanGendogaku(),
                    後, 明細,
                    entity.getAtoHiyoTanka(), entity.getAtoNissu(),
                    entity.getAtoHiyogaku(), entity.getAtoHokenbunSeikyugaku(), entity.getAtoRiyoshaFutangaku(),
                    entity.getAtoKohi1Nissu(), entity.getAtoKohi1Futangaku(), null, null,
                    entity.getAtoKohi2Nissu(), entity.getAtoKohi2Futangaku(), null, null,
                    entity.getAtoKohi3Nissu(), entity.getAtoKohi3Futangaku(), null, null,
                    entity.getSaishinsaKaisu(), entity.getKagoKaisu(), entity.getShinsaYM()));
        }

        DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity entity = entities.get(entities.size() - 1);
        maeList.add(new KyufuJissekiTokuteiNyushohi(
                null, null,
                前, 合計, null, null,
                entity.getHiyogakuTotal(), entity.getHokenbunSeikyugakuTotal(), entity.getRiyoshaFutangakuTotal(), null,
                entity.getKohi1FutangakuTotal(), entity.getKohi1Seikyugaku(), entity.getKohi1HonninFutanGetsugaku(), null,
                entity.getKohi2FutangakuTotal(), entity.getKohi2Seikyugaku(), entity.getKohi2HonninFutanGetsugaku(), null,
                entity.getKohi3FutangakuTotal(), entity.getKohi3Seikyugaku(), entity.getKohi3HonninFutanGetsugaku(), null, null, null));
        atoList.add(new KyufuJissekiTokuteiNyushohi(
                null, null,
                後, 合計, null, null,
                entity.getAtoHiyogakuTotal(), entity.getAtoHokenbunSeikyugakuTotal(), entity.getAtoRiyoshaFutangakuTotal(), null,
                entity.getAtoKohi1FutangakuTotal(), entity.getAtoKohi1Seikyugaku(), entity.getAtoKohi1HonninFutanGetsugaku(), null,
                entity.getAtoKohi2FutangakuTotal(), entity.getAtoKohi2Seikyugaku(), entity.getAtoKohi2HonninFutanGetsugaku(), null,
                entity.getAtoKohi3FutangakuTotal(), entity.getAtoKohi3Seikyugaku(), entity.getAtoKohi3HonninFutanGetsugaku(), null, null, null));

        maeList.addAll(atoList);

        return new KyufuJissekiTokuteiNyushohiCollection(maeList);
    }
}
