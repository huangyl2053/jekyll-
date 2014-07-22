/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiService;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiServiceCollection;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * KyufujissekiShuruiDetailEntityをKyufujissekiServiceCollectionに変換するクラスです。
 *
 * @author N3317 塚田 萌
 */
public final class KyufuJissekiServiceMapper {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private KyufuJissekiServiceMapper() {

    }

    /**
     * KyufujissekiShuruiDetailEntityをKyufuJissekiServiceにマッピングします。<br/>
     * 引数にnullが渡された場合は、nullを返します。<br/>
     *
     * @param entity entity
     * @param teikyoYMRange 提供年月期間
     * @return KyufuJissekiService
     */
    public static KyufuJissekiService toKyufuJissekiService(
            DbV3016KyufujissekiShuruiDetailEntity entity, Range<ServiceTeikyoYM> teikyoYMRange) {

        if (entity == null) {
            return null;
        }
        //TODO 様式固定でnewしている。本来は様式を見て入れる値を変える。
        return new KyufuJissekiService(
                entity.getJigyoshoNo(),
                entity.getHokenRiyoshaFutangaku(),
                entity.getAtoHokenTanisuTotal(),
                entity.getAtoHokenSeikyugaku(),
                create給付実績Key(entity, teikyoYMRange));
    }

    /**
     * KyufujissekiShuruiDetailEntityリストをKyufuJissekiServiceCollectionにマッピングします。<br/>
     * 引数にnullや空のリストが渡された場合は、nullを返します。
     *
     * @param entities DbV3016KyufujissekiShuruiDetailEntityリスト
     * @param teikyoYMRange 検索条件の提供年月期間
     * @return KyufuJissekiTotal
     */
    public static KyufuJissekiServiceCollection toKyufuJissekiServiceCollection(
            List<DbV3016KyufujissekiShuruiDetailEntity> entities, Range<ServiceTeikyoYM> teikyoYMRange) {

        if (entities == null || entities.isEmpty()) {
            return new KyufuJissekiServiceCollection(Collections.EMPTY_LIST);
        }
        return new KyufuJissekiServiceCollection(create給付実績ServiceList(entities, teikyoYMRange));
    }

    private static List<KyufuJissekiService> create給付実績ServiceList(
            List<DbV3016KyufujissekiShuruiDetailEntity> entities, Range<ServiceTeikyoYM> teikyoYMRange) {

        List<KyufuJissekiService> list = new ArrayList<>();
        for (DbV3016KyufujissekiShuruiDetailEntity entity : entities) {
            list.add(toKyufuJissekiService(entity, teikyoYMRange));
        }
        return list;
    }

    private static KyufuJissekiKeyInfo create給付実績Key(
            DbV3016KyufujissekiShuruiDetailEntity entity, Range<ServiceTeikyoYM> teikyoYMRange) {
        return new KyufuJissekiKeyInfo(
                entity.getHiHokenshaNo(),
                teikyoYMRange,
                entity.getInputShikibetsuNo(),
                entity.getServiceSyuruiCode(),
                entity.getServiceTeikyoYM());
    }
}
