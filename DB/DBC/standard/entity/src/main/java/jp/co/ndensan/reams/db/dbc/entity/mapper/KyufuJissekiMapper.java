/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KeikokuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3018KyufujissekiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績エンティティを給付実績情報に変換するMapperクラスです。
 *
 * @author N8156 宮本 康
 */
public final class KyufuJissekiMapper {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private KyufuJissekiMapper() {
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

        List<RString> 決定 = new ArrayList<>();
        決定.add(0, RString.EMPTY);
        決定.add(1, new RString("後"));
        List<KyufuJissekiMeisai> 給付実績の明細情報List = new ArrayList<>();

        for (int i = 0; i < entities.size(); i++) {
            for (int j = 0; j < 1; j++) {
                給付実績の明細情報List.add(to給付実績の明細情報(決定.get(i), entities.get(i)));
            }
        }

        return new KyufuJissekiMeisaiCollection(給付実績の明細情報List);

    }

    private static KyufuJissekiMeisai to給付実績の明細情報(RString 決定, DbT3018KyufujissekiMeisaiEntity entity) {

        if (!決定.equals("後")) {
            return new KyufuJissekiMeisai(
                    entity.getServiceShuruiCode().value(),
                    entity.getTekiyo(),
                    決定,
                    new Decimal(entity.getTanisu()),
                    entity.getNissuKaisu(),
                    entity.getKohi1TaishoNissuKaisu(),
                    entity.getKohi2TaishoNissuKaisu(),
                    entity.getKohi3TaishoNissuKaisu(),
                    new Decimal(entity.getServiceTanisu()),
                    entity.getKohi1TaishoServiceTanisu(),
                    entity.getKohi2TaishoServiceTanisu(),
                    entity.getKohi3TaishoServiceTanisu(),
                    entity.getSaishinsaKaisu(),
                    entity.getKagoKaisu(),
                    entity.getShinsaYM());
        } else {
            return new KyufuJissekiMeisai(
                    entity.getServiceShuruiCode().value(),
                    entity.getTekiyo(),
                    決定,
                    new Decimal(entity.getAtoTanisu()),
                    entity.getAtoNissuKaisu(),
                    entity.getAtoKohi1TaishoNissuKaisu(),
                    entity.getAtoKohi2TaishoNissukaisu(),
                    entity.getAtoKohi3TaishoNissuKaisu(),
                    new Decimal(entity.getServiceTanisu()),
                    entity.getAtoKohi1TaishoServiceTanisu(),
                    entity.getAtoKohi2TaishoServiceTanisu(),
                    entity.getAtoKohi3TaishoServiceTanisu(),
                    entity.getSaishinsaKaisu(),
                    entity.getKagoKaisu(),
                    entity.getShinsaYM());
        }

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

        List<RString> 決定 = new ArrayList<>();
        決定.add(0, RString.EMPTY);
        決定.add(1, new RString("後"));

        List<RString> 保険 = new ArrayList<>();
        保険.add(0, new RString("保険"));
        保険.add(1, RString.EMPTY);

        List<RString> 公率1 = new ArrayList<>();
        公率1.add(0, new RString("公率1"));
        公率1.add(1, RString.EMPTY);

        List<RString> 公率2 = new ArrayList<>();
        公率2.add(0, new RString("公率2"));
        公率2.add(1, RString.EMPTY);

        List<RString> 公率3 = new ArrayList<>();
        公率3.add(0, new RString("公率3"));
        公率3.add(1, RString.EMPTY);

        List<KyufuJissekiShukei> 給付実績集計情報List = new ArrayList<>();

        for (int i = 0; i < entities.size(); i++) {
            for (int j = 0; j < 1; j++) {
                給付実績集計情報List.add(to給給付保険実績集計(保険.get(i), 決定.get(i), entities.get(i)));
                給付実績集計情報List.add(to給給付公率1実績集計(公率1.get(i), 決定.get(i), entities.get(i)));
                給付実績集計情報List.add(to給給付公率2実績集計(公率2.get(i), 決定.get(i), entities.get(i)));
                給付実績集計情報List.add(to給給付公率3実績集計(公率3.get(i), 決定.get(i), entities.get(i)));

            }
        }

        return new KyufuJissekiShukeiCollection(給付実績集計情報List);

    }

    private static KyufuJissekiShukei to給給付保険実績集計(RString 保険, RString 決定, DbT3033KyufujissekiShukeiEntity entity) {

        if (!保険.equals("保険")) {
            return new KyufuJissekiShukei(
                    entity.getServiceSyuruiCode().value(),
                    entity.getServiceJitsunissu(),
                    new Decimal(entity.getPlanTanisu()),
                    new Decimal(entity.getGendogakuKanriTaishoTanisu()),
                    new Decimal(entity.getGendogakuKanritaishogaiTanisu()),
                    entity.getTankiNyushoPlanNissu(),
                    保険,
                    決定,
                    entity.getAtoTankiNyushoJitsunissu(),
                    new Decimal(entity.getAtoHokenTanisuTotal()),
                    new Decimal(0), //entity.getAtoHokenTanisuTani(),
                    new Decimal(entity.getAtoHokenSeikyugaku().toString()),
                    new Decimal(0), //new Decimal(entity.getAtoHokenRiyoshaFutangaku()),
                    new Decimal(entity.getAtoHokenDekidakaTanisuTotal()),
                    new Decimal(entity.getAtoHokenDekidakaSeikyugaku().toString()),
                    new Decimal(entity.getHokenDekidakaIryohiRiyoshaFutangaku()),
                    entity.getSaishinsaKaisu(),
                    entity.getKagoKaisu(),
                    entity.getShinsaYM()
            );
        } else {
            return new KyufuJissekiShukei(
                    entity.getServiceSyuruiCode().value(),
                    entity.getServiceJitsunissu(),
                    new Decimal(entity.getPlanTanisu()),
                    new Decimal(entity.getGendogakuKanriTaishoTanisu()),
                    new Decimal(entity.getGendogakuKanritaishogaiTanisu()),
                    entity.getTankiNyushoPlanNissu(),
                    保険,
                    決定,
                    entity.getTankiNyushoJitsunissu(),
                    new Decimal(entity.getHokenTanisuTotal()),
                    entity.getHokenTanisuTani(),
                    new Decimal(entity.getHokenSeikyugaku().toString()),
                    new Decimal(entity.getHokenRiyoshaFutangaku()),
                    new Decimal(entity.getHokenDekidakaTanisuTotal()),
                    new Decimal(entity.getHokenDekidakaSeikyugaku().toString()),
                    new Decimal(entity.getHokenDekidakaIryohiRiyoshaFutangaku()),
                    entity.getSaishinsaKaisu(),
                    entity.getKagoKaisu(),
                    entity.getShinsaYM()
            );
        }

    }

    private static KyufuJissekiShukei to給給付公率1実績集計(RString 公率1, RString 決定, DbT3033KyufujissekiShukeiEntity entity) {

        if (!公率1.equals("公率1")) {
            return new KyufuJissekiShukei(
                    entity.getServiceSyuruiCode().value(),
                    entity.getServiceJitsunissu(),
                    new Decimal(entity.getPlanTanisu()),
                    new Decimal(entity.getGendogakuKanriTaishoTanisu()),
                    new Decimal(entity.getGendogakuKanritaishogaiTanisu()),
                    entity.getTankiNyushoPlanNissu(),
                    公率1,
                    決定,
                    entity.getAtoTankiNyushoJitsunissu(),
                    new Decimal(entity.getAtoKohi1TanisuTotal()),
                    new Decimal(0), //entity.getAtoKohi1TanisuTani(),
                    new Decimal(entity.getAtoKohi1Seikyugaku().toString()),
                    new Decimal(0), //new Decimal(entity.getAtoKohi1HonninFutangaku()),
                    new Decimal(entity.getAtoKohi1DekidakaTanisuTotal()),
                    new Decimal(entity.getAtoKohi1DekidakaSeikyugaku().toString()),
                    new Decimal(0),//new Decimal(entity.getAtokohi1DekidakaIryohiRiyoshaFutangaku()),
                    entity.getSaishinsaKaisu(),
                    entity.getKagoKaisu(),
                    entity.getShinsaYM()
            );
        } else {
            return new KyufuJissekiShukei(
                    entity.getServiceSyuruiCode().value(),
                    entity.getServiceJitsunissu(),
                    new Decimal(entity.getPlanTanisu()),
                    new Decimal(entity.getGendogakuKanriTaishoTanisu()),
                    new Decimal(entity.getGendogakuKanritaishogaiTanisu()),
                    entity.getTankiNyushoPlanNissu(),
                    公率1,
                    決定,
                    entity.getTankiNyushoJitsunissu(),
                    new Decimal(entity.getKohi1TanisuTotal()),
                    new Decimal(0), //entity.getKohi1TanisuTani(),
                    new Decimal(entity.getKohi1Seikyugaku().toString()),
                    new Decimal(entity.getKohi1HonninFutangaku()),
                    new Decimal(entity.getKohi1DekidakaTanisuTotal()),
                    new Decimal(entity.getKohi1DekidakaSeikyugaku().toString()),
                    new Decimal(entity.getKohi1DekidakaIryohiRiyoshaFutangaku()),
                    entity.getSaishinsaKaisu(),
                    entity.getKagoKaisu(),
                    entity.getShinsaYM()
            );
        }
    }

    private static KyufuJissekiShukei to給給付公率2実績集計(RString 公率2, RString 決定, DbT3033KyufujissekiShukeiEntity entity) {

        if (!公率2.equals("公率2")) {
            return new KyufuJissekiShukei(
                    entity.getServiceSyuruiCode().value(),
                    entity.getServiceJitsunissu(),
                    new Decimal(entity.getPlanTanisu()),
                    new Decimal(entity.getGendogakuKanriTaishoTanisu()),
                    new Decimal(entity.getGendogakuKanritaishogaiTanisu()),
                    entity.getTankiNyushoPlanNissu(),
                    公率2,
                    決定,
                    entity.getAtoTankiNyushoJitsunissu(),
                    new Decimal(entity.getAtoKohi2TanisuTotal()),
                    new Decimal(0), //entity.getAtoKohi2TanisuTani(),
                    new Decimal(entity.getAtoKohi2Seikyugaku().toString()),
                    new Decimal(0), //new Decimal(entity.getAtoKohi2HonninFutangaku()),
                    new Decimal(entity.getAtoKohi2DekidakaTanisuTotal()),
                    new Decimal(entity.getAtoKohi2DekidakaSeikyugaku().toString()),
                    new Decimal(0),//new Decimal(entity.getAtokohi2DekidakaIryohiRiyoshaFutangaku()),
                    entity.getSaishinsaKaisu(),
                    entity.getKagoKaisu(),
                    entity.getShinsaYM()
            );
        } else {
            return new KyufuJissekiShukei(
                    entity.getServiceSyuruiCode().value(),
                    entity.getServiceJitsunissu(),
                    new Decimal(entity.getPlanTanisu()),
                    new Decimal(entity.getGendogakuKanriTaishoTanisu()),
                    new Decimal(entity.getGendogakuKanritaishogaiTanisu()),
                    entity.getTankiNyushoPlanNissu(),
                    公率2,
                    決定,
                    entity.getTankiNyushoJitsunissu(),
                    new Decimal(entity.getKohi2TanisuTotal()),
                    new Decimal(0), //entity.getKohi2TanisuTani(),
                    new Decimal(entity.getKohi2Seikyugaku().toString()),
                    new Decimal(entity.getKohi2HonninFutangaku()),
                    new Decimal(entity.getKohi2DekidakaTanisuTotal()),
                    new Decimal(entity.getKohi2DekidakaSeikyugaku().toString()),
                    new Decimal(entity.getKohi2DekidakaIryohiRiyoshaFutangaku()),
                    entity.getSaishinsaKaisu(),
                    entity.getKagoKaisu(),
                    entity.getShinsaYM()
            );
        }

    }

    private static KyufuJissekiShukei to給給付公率3実績集計(RString 公率3, RString 決定, DbT3033KyufujissekiShukeiEntity entity) {

        if (!公率3.equals("公率3")) {
            return new KyufuJissekiShukei(
                    entity.getServiceSyuruiCode().value(),
                    entity.getServiceJitsunissu(),
                    new Decimal(entity.getPlanTanisu()),
                    new Decimal(entity.getGendogakuKanriTaishoTanisu()),
                    new Decimal(entity.getGendogakuKanritaishogaiTanisu()),
                    entity.getTankiNyushoPlanNissu(),
                    公率3,
                    決定,
                    entity.getAtoTankiNyushoJitsunissu(),
                    new Decimal(entity.getAtoKohi3TanisuTotal()),
                    new Decimal(0), //entity.getAtoKohi3TanisuTani(),
                    new Decimal(entity.getAtoKohi3Seikyugaku().toString()),
                    new Decimal(0), //new Decimal(entity.getAtoKohi3HonninFutangaku()),
                    new Decimal(entity.getAtoKohi3DekidakaTanisuTotal()),
                    new Decimal(entity.getAtoKohi3DekidakaSeikyugaku().toString()),
                    new Decimal(0),//new Decimal(entity.getAtokohi3DekidakaIryohiRiyoshaFutangaku()),
                    entity.getSaishinsaKaisu(),
                    entity.getKagoKaisu(),
                    entity.getShinsaYM()
            );
        } else {
            return new KyufuJissekiShukei(
                    entity.getServiceSyuruiCode().value(),
                    entity.getServiceJitsunissu(),
                    new Decimal(entity.getPlanTanisu()),
                    new Decimal(entity.getGendogakuKanriTaishoTanisu()),
                    new Decimal(entity.getGendogakuKanritaishogaiTanisu()),
                    entity.getTankiNyushoPlanNissu(),
                    公率3,
                    決定,
                    entity.getTankiNyushoJitsunissu(),
                    new Decimal(entity.getKohi3TanisuTotal()),
                    new Decimal(0), //entity.getKohi3TanisuTani(),
                    new Decimal(entity.getKohi3Seikyugaku().toString()),
                    new Decimal(entity.getKohi3HonninFutangaku()),
                    new Decimal(entity.getKohi3DekidakaTanisuTotal()),
                    new Decimal(entity.getKohi3DekidakaSeikyugaku().toString()),
                    new Decimal(entity.getKohi3DekidakaIryohiRiyoshaFutangaku()),
                    entity.getSaishinsaKaisu(),
                    entity.getKagoKaisu(),
                    entity.getShinsaYM()
            );
        }

    }

    /**
     * 給付実績社会福祉法人軽減額エンティティから給付実績社会福祉法人軽減額情報を作成して返す。
     *
     * @param entities 給付実績社会福祉法人軽減額エンティティList
     * @return businessの給付実績社会福祉法人軽減額リストクラス
     */
    public static KyufuJissekiShafukuKeigenCollection to給付実績社会福祉法人軽減額List(List<DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity> entities) {

        if (entities == null || entities.isEmpty()) {
            return new KyufuJissekiShafukuKeigenCollection(Collections.EMPTY_LIST);
        }

        List<RString> 前後 = new ArrayList<>();
        前後.add(0, RString.EMPTY);
        前後.add(1, new RString("後"));
        List<KyufuJissekiShafukuKeigen> 給付実績社会福祉法人軽減額情報List = new ArrayList<>();

        for (int i = 0; i < entities.size(); i++) {
            for (int j = 0; j < 1; j++) {
                給付実績社会福祉法人軽減額情報List.add(to給付実績社会福祉法人軽減額情報(前後.get(i), entities.get(i)));
            }
        }

        return new KyufuJissekiShafukuKeigenCollection(給付実績社会福祉法人軽減額情報List);

    }

    private static KyufuJissekiShafukuKeigen to給付実績社会福祉法人軽減額情報(RString 前後, DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity entity) {

        if (!前後.equals("後")) {
            return new KyufuJissekiShafukuKeigen(
                    new RString(entity.getKeigenritsu().toString()),
                    entity.getServiceSyuruiCode().value(),
                    前後,
                    new Decimal(entity.getRiyoshaFutanTotal()),
                    new Decimal(entity.getKeigengaku()),
                    new Decimal(entity.getKeigengoRiyoshaFutangaku()),
                    entity.getBiko(),
                    entity.getSaishinsaKaisu(),
                    entity.getKagoKaisu(),
                    entity.getShinsaYM());
        } else {
            return new KyufuJissekiShafukuKeigen(
                    new RString(entity.getKeigenritsu().toString()),
                    entity.getServiceSyuruiCode().value(),
                    前後,
                    new Decimal(entity.getAtoRiyoshaFutanTotal()),
                    new Decimal(entity.getAtoKeigengaku()),
                    new Decimal(entity.getAtoKeigengoRiyoshaFutangaku()),
                    entity.getBiko(),
                    entity.getSaishinsaKaisu(),
                    entity.getKagoKaisu(),
                    entity.getShinsaYM());
        }
    }

}
