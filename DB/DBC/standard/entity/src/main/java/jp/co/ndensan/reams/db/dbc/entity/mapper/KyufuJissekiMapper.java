/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.mapper;

import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihonHihokensha;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihonKohi;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihonKyotakuService;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihonKyufuritsu;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihonNyutaisho;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihonServiceKikan;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KeikokuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

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
        return new KyufuJissekiKihon(
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
                to公費情報(entity));
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
}
