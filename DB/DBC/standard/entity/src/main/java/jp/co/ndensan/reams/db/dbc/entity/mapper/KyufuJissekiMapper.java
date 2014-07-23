/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.JigyoshaNoListOfServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiDetailKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihonHihokensha;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihonKohi;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihonKyotakuService;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihonKyufuritsu;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihonNyutaisho;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihonServiceKikan;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiMeisai;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiMeisaiCollection;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiShafukuKeigen;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiShafukuKeigenCollection;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiShukei;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiShukeiCollection;
import jp.co.ndensan.reams.db.dbc.business.ServiceTeikyoYMListOfServiceShurui;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KeikokuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3018KyufujissekiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績エンティティを給付実績情報に変換するMapperクラスです。
 *
 * @author N8156 宮本 康
 */
public final class KyufuJissekiMapper {

    private static final RString ATO = new RString("後");
    private static final RString HOKEN = new RString("保険");
    private static final RString KORITSU1 = new RString("公率1");
    private static final RString KORITSU2 = new RString("公率2");
    private static final RString KORITSU3 = new RString("公率3");

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
                    && (キー情報.get入力識別番号() == null || キー情報.get入力識別番号().equals(entity.getInputShikibetsuNo()))
                    && (キー情報.getサービス種類コード() == null || キー情報.getサービス種類コード().equals(entity.getServiceSyuruiCode()))
                    && (キー情報.getサービス提供年月() == null || キー情報.getサービス提供年月().equals(entity.getServiceTeikyoYM()))) {
                break;
            }
        }

        return new KyufuJissekiDetailKeyInfo(
                entity.getKokanShikibetsuNo(),
                entity.getInputShikibetsuNo(),
                entity.getRecodeShubetsuCode(),
                entity.getHokenshaNo(),
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getJigyoshoNo(),
                entity.getToshiNo(),
                to対象サービス種類リスト(entities));
    }

    private static List<ServiceTeikyoYMListOfServiceShurui> to対象サービス種類リスト(List<DbV3016KyufujissekiShuruiDetailEntity> entities) {

        List<JigyoshaNo> jigyoshaNoList = new ArrayList<>();
        List<JigyoshaNoListOfServiceTeikyoYM> teikyoYMList = new ArrayList<>();
        List<ServiceTeikyoYMListOfServiceShurui> shuruiCodeList = new ArrayList<>();

        for (int index = 0; index < entities.size(); index++) {

            jigyoshaNoList.add(entities.get(index).getJigyoshoNo());

            boolean last = (index == (entities.size() - 1));

            ServiceTeikyoYM teikyoYM = entities.get(index).getServiceTeikyoYM();
            ServiceTeikyoYM nextTeikyoYM = !last ? entities.get(index + 1).getServiceTeikyoYM() : null;
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
                to公費情報(entity)) : null;
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

    /**
     * 給付実績明細エンティティから給付実績明細情報を作成して返す。
     *
     * @param entities 給付実績明細エンティティList
     * @return businessの実績明細情報リストクラス
     */
    public static KyufuJissekiMeisaiCollection to給付実績明細List(List<DbT3018KyufujissekiMeisaiEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return new KyufuJissekiMeisaiCollection(Collections.EMPTY_LIST);
        }

        List<RString> 決定 = create前後List(RString.EMPTY, ATO);
        List<KyufuJissekiMeisai> 給付実績の明細情報List = new ArrayList<>();
        for (int i = 0; i < entities.size(); i++) {
            for (int j = 0; j < 決定.size(); j++) {
                給付実績の明細情報List.add(to給付実績の明細情報(決定.get(j), entities.get(i)));
            }
        }

        return new KyufuJissekiMeisaiCollection(給付実績の明細情報List);
    }

    private static KyufuJissekiMeisai to給付実績の明細情報(RString 決定, DbT3018KyufujissekiMeisaiEntity entity) {
        boolean flg = !ATO.equals(決定);
        return new KyufuJissekiMeisai(
                entity.getServiceShuruiCode().value(),
                entity.getTekiyo(),
                決定,
                new Decimal(flg ? entity.getTanisu() : entity.getAtoTanisu()),
                flg ? entity.getNissuKaisu() : entity.getAtoNissuKaisu(),
                flg ? entity.getKohi1TaishoNissuKaisu() : entity.getAtoKohi1TaishoNissuKaisu(),
                flg ? entity.getKohi2TaishoNissuKaisu() : entity.getAtoKohi2TaishoNissukaisu(),
                flg ? entity.getKohi3TaishoNissuKaisu() : entity.getAtoKohi3TaishoNissuKaisu(),
                new Decimal(entity.getServiceTanisu()),
                flg ? entity.getKohi1TaishoServiceTanisu() : entity.getAtoKohi1TaishoServiceTanisu(),
                flg ? entity.getKohi2TaishoServiceTanisu() : entity.getAtoKohi2TaishoServiceTanisu(),
                flg ? entity.getKohi3TaishoServiceTanisu() : entity.getAtoKohi3TaishoServiceTanisu(),
                entity.getSaishinsaKaisu(),
                entity.getKagoKaisu(),
                entity.getShinsaYM());
    }

    /**
     * 給付実績集計エンティティから給付実績集計情報を作成して返す。
     *
     * @param entities 給付実績集計エンティティList
     * @return businessの給付実績集計情報リストクラス
     */
    public static KyufuJissekiShukeiCollection to給付実績集計List(List<DbT3033KyufujissekiShukeiEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return new KyufuJissekiShukeiCollection(Collections.EMPTY_LIST);
        }

        List<RString> 決定 = create前後List(RString.EMPTY, ATO);
        List<RString> 保険 = create前後List(HOKEN, RString.EMPTY);
        List<RString> 公率1 = create前後List(KORITSU1, RString.EMPTY);
        List<RString> 公率2 = create前後List(KORITSU2, RString.EMPTY);
        List<RString> 公率3 = create前後List(KORITSU3, RString.EMPTY);
        List<KyufuJissekiShukei> 給付実績集計情報List = new ArrayList<>();
        for (int i = 0; i < entities.size(); i++) {
            for (int j = 0; j < 決定.size(); j++) {
                給付実績集計情報List.add(to給付保険実績集計(保険.get(j), 決定.get(j), entities.get(i)));
            }
            for (int j = 0; j < 決定.size(); j++) {
                給付実績集計情報List.add(to給付公率1実績集計(公率1.get(j), 決定.get(j), entities.get(i)));
            }
            for (int j = 0; j < 決定.size(); j++) {
                給付実績集計情報List.add(to給付公率2実績集計(公率2.get(j), 決定.get(j), entities.get(i)));
            }
            for (int j = 0; j < 決定.size(); j++) {
                給付実績集計情報List.add(to給付公率3実績集計(公率3.get(j), 決定.get(j), entities.get(i)));
            }
        }

        return new KyufuJissekiShukeiCollection(給付実績集計情報List);
    }

    private static KyufuJissekiShukei to給付保険実績集計(RString 保険, RString 決定, DbT3033KyufujissekiShukeiEntity entity) {
        boolean flg = !ATO.equals(決定);
        return new KyufuJissekiShukei(
                entity.getServiceSyuruiCode().value(),
                entity.getServiceJitsunissu(),
                new Decimal(entity.getPlanTanisu()),
                new Decimal(entity.getGendogakuKanriTaishoTanisu()),
                new Decimal(entity.getGendogakuKanritaishogaiTanisu()),
                entity.getTankiNyushoPlanNissu(),
                保険,
                決定,
                flg ? entity.getTankiNyushoJitsunissu() : entity.getAtoTankiNyushoJitsunissu(),
                new Decimal(flg ? entity.getHokenTanisuTotal() : entity.getAtoHokenTanisuTotal()),
                flg ? entity.getHokenTanisuTani() : new Decimal(0),
                new Decimal(flg ? entity.getHokenSeikyugaku().toString() : entity.getAtoHokenSeikyugaku().toString()),
                new Decimal(flg ? entity.getHokenRiyoshaFutangaku() : 0),
                new Decimal(flg ? entity.getHokenDekidakaTanisuTotal() : entity.getAtoHokenDekidakaTanisuTotal()),
                new Decimal(flg ? entity.getHokenDekidakaSeikyugaku().toString() : entity.getAtoHokenDekidakaSeikyugaku().toString()),
                new Decimal(entity.getHokenDekidakaIryohiRiyoshaFutangaku()),
                entity.getSaishinsaKaisu(),
                entity.getKagoKaisu(),
                entity.getShinsaYM());
    }

    private static KyufuJissekiShukei to給付公率1実績集計(RString 公率1, RString 決定, DbT3033KyufujissekiShukeiEntity entity) {
        boolean flg = !ATO.equals(決定);
        return new KyufuJissekiShukei(
                entity.getServiceSyuruiCode().value(),
                entity.getServiceJitsunissu(),
                new Decimal(entity.getPlanTanisu()),
                new Decimal(entity.getGendogakuKanriTaishoTanisu()),
                new Decimal(entity.getGendogakuKanritaishogaiTanisu()),
                entity.getTankiNyushoPlanNissu(),
                公率1,
                決定,
                flg ? entity.getTankiNyushoJitsunissu() : entity.getAtoTankiNyushoJitsunissu(),
                new Decimal(flg ? entity.getKohi1TanisuTotal() : entity.getAtoKohi1TanisuTotal()),
                new Decimal(0), //entity.getKohi1TanisuTani(),
                new Decimal(flg ? entity.getKohi1Seikyugaku().toString() : entity.getAtoKohi1Seikyugaku().toString()),
                new Decimal(flg ? entity.getKohi1HonninFutangaku() : 0),
                new Decimal(flg ? entity.getKohi1DekidakaTanisuTotal() : entity.getAtoKohi1DekidakaTanisuTotal()),
                new Decimal(flg ? entity.getKohi1DekidakaSeikyugaku().toString() : entity.getAtoKohi1DekidakaSeikyugaku().toString()),
                new Decimal(flg ? entity.getKohi1DekidakaIryohiRiyoshaFutangaku() : 0),
                entity.getSaishinsaKaisu(),
                entity.getKagoKaisu(),
                entity.getShinsaYM());
    }

    private static KyufuJissekiShukei to給付公率2実績集計(RString 公率2, RString 決定, DbT3033KyufujissekiShukeiEntity entity) {
        boolean flg = !ATO.equals(決定);
        return new KyufuJissekiShukei(
                entity.getServiceSyuruiCode().value(),
                entity.getServiceJitsunissu(),
                new Decimal(entity.getPlanTanisu()),
                new Decimal(entity.getGendogakuKanriTaishoTanisu()),
                new Decimal(entity.getGendogakuKanritaishogaiTanisu()),
                entity.getTankiNyushoPlanNissu(),
                公率2,
                決定,
                flg ? entity.getTankiNyushoJitsunissu() : entity.getAtoTankiNyushoJitsunissu(),
                new Decimal(flg ? entity.getKohi2TanisuTotal() : entity.getAtoKohi2TanisuTotal()),
                new Decimal(0), //entity.getKohi2TanisuTani(),
                new Decimal(flg ? entity.getKohi2Seikyugaku().toString() : entity.getAtoKohi2Seikyugaku().toString()),
                new Decimal(flg ? entity.getKohi2HonninFutangaku() : 0),
                new Decimal(flg ? entity.getKohi2DekidakaTanisuTotal() : entity.getAtoKohi2DekidakaTanisuTotal()),
                new Decimal(flg ? entity.getKohi2DekidakaSeikyugaku().toString() : entity.getAtoKohi2DekidakaSeikyugaku().toString()),
                new Decimal(flg ? entity.getKohi2DekidakaIryohiRiyoshaFutangaku() : 0),
                entity.getSaishinsaKaisu(),
                entity.getKagoKaisu(),
                entity.getShinsaYM());
    }

    private static KyufuJissekiShukei to給付公率3実績集計(RString 公率3, RString 決定, DbT3033KyufujissekiShukeiEntity entity) {
        boolean flg = !ATO.equals(決定);
        return new KyufuJissekiShukei(
                entity.getServiceSyuruiCode().value(),
                entity.getServiceJitsunissu(),
                new Decimal(entity.getPlanTanisu()),
                new Decimal(entity.getGendogakuKanriTaishoTanisu()),
                new Decimal(entity.getGendogakuKanritaishogaiTanisu()),
                entity.getTankiNyushoPlanNissu(),
                公率3,
                決定,
                flg ? entity.getTankiNyushoJitsunissu() : entity.getAtoTankiNyushoJitsunissu(),
                new Decimal(flg ? entity.getKohi3TanisuTotal() : entity.getAtoKohi3TanisuTotal()),
                new Decimal(0), //entity.getKohi3TanisuTani(),
                new Decimal(flg ? entity.getKohi3Seikyugaku().toString() : entity.getAtoKohi3Seikyugaku().toString()),
                new Decimal(flg ? entity.getKohi3HonninFutangaku() : 0),
                new Decimal(flg ? entity.getKohi3DekidakaTanisuTotal() : entity.getAtoKohi3DekidakaTanisuTotal()),
                new Decimal(flg ? entity.getKohi3DekidakaSeikyugaku().toString() : entity.getAtoKohi3DekidakaSeikyugaku().toString()),
                new Decimal(flg ? entity.getKohi3DekidakaIryohiRiyoshaFutangaku() : 0),
                entity.getSaishinsaKaisu(),
                entity.getKagoKaisu(),
                entity.getShinsaYM());
    }

    /**
     * 給付実績社会福祉法人軽減額エンティティから給付実績社会福祉法人軽減額情報を作成して返す。
     *
     * @param entities 給付実績社会福祉法人軽減額エンティティList
     * @return businessの給付実績社会福祉法人軽減額リストクラス
     */
    public static KyufuJissekiShafukuKeigenCollection to給付実績社会福祉法人軽減額List(
            List<DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return new KyufuJissekiShafukuKeigenCollection(Collections.EMPTY_LIST);
        }

        List<RString> 前後 = create前後List(RString.EMPTY, ATO);
        List<KyufuJissekiShafukuKeigen> 給付実績社会福祉法人軽減額情報List = new ArrayList<>();
        for (int i = 0; i < entities.size(); i++) {
            for (int j = 0; j < 1; j++) {
                給付実績社会福祉法人軽減額情報List.add(to給付実績社会福祉法人軽減額情報(前後.get(i), entities.get(i)));
            }
        }

        return new KyufuJissekiShafukuKeigenCollection(給付実績社会福祉法人軽減額情報List);
    }

    private static KyufuJissekiShafukuKeigen to給付実績社会福祉法人軽減額情報(
            RString 前後, DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity entity) {
        boolean flg = !ATO.equals(前後);
        return new KyufuJissekiShafukuKeigen(
                new RString(entity.getKeigenritsu().toString()),
                entity.getServiceSyuruiCode().value(),
                前後,
                new Decimal(flg ? entity.getRiyoshaFutanTotal() : entity.getAtoRiyoshaFutanTotal()),
                new Decimal(flg ? entity.getKeigengaku() : entity.getAtoKeigengaku()),
                new Decimal(flg ? entity.getKeigengoRiyoshaFutangaku() : entity.getAtoKeigengoRiyoshaFutangaku()),
                entity.getBiko(),
                entity.getSaishinsaKaisu(),
                entity.getKagoKaisu(),
                entity.getShinsaYM());
    }

    private static List<RString> create前後List(RString mae, RString ato) {
        List<RString> list = new ArrayList<>();
        list.add(mae);
        list.add(ato);
        return list;
    }
}
