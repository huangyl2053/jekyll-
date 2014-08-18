/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.NyushoShisetsu;
import jp.co.ndensan.reams.db.dbz.business.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.ShisetsuNyutaishoList;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 施設入退所のマッパークラスです。
 *
 * @author N3317 塚田 萌
 */
public final class ShisetsuNyutaishoMapper {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private ShisetsuNyutaishoMapper() {
    }

    /**
     * 施設入退所entityと入所施設情報から施設入退所インスタンスを生成します。<br/>
     * 施設入退所entityがnullの時はnullを返します。
     *
     * @param entity 施設入退所entity
     * @param 入所施設 入所施設
     * @return 施設入退所のインスタンス
     */
    public static ShisetsuNyutaisho to施設入退所(
            DbT1004ShisetsuNyutaishoEntity entity, NyushoShisetsu 入所施設) {

        if (entity == null) {
            return null;
        }

        return new ShisetsuNyutaisho(
                entity.getShichosonCode(),
                entity.getShikibetsuCode(),
                entity.getShoriTimestamp(),
                DaichoType.toValue(entity.getDaichoShubetsu()),
                create入所期間(entity),
                入所施設,
                entity.getNyushoShoriYMD(),
                entity.getTaishoShoriYMD());
    }

    /**
     * 施設入退所entityのリストと、入所施設情報のListから施設入退所Listインスタンスを生成します。<br/>
     * 施設入退所entityのリスト、または入所施設Listがnullか空のリストの時はCollections.EMPTY_LISTを返します。
     *
     * @param entities 施設入退所entity
     * @param 入所施設List 入所施設List
     * @return 施設入退所Listのインスタンス
     */
    public static ShisetsuNyutaishoList to施設入退所List(List<DbT1004ShisetsuNyutaishoEntity> entities,
            List<NyushoShisetsu> 入所施設List) {

        if (entities == null || entities.isEmpty()) {
            return new ShisetsuNyutaishoList(Collections.EMPTY_LIST);
        }

        if (入所施設List == null || 入所施設List.isEmpty()) {
            return new ShisetsuNyutaishoList(Collections.EMPTY_LIST);
        }

        List<ShisetsuNyutaisho> 施設入退所List = new ArrayList<>();

        for (int i = 0; i < entities.size(); i++) {
            施設入退所List.add(to施設入退所(entities.get(i), 入所施設List.get(i)));
        }
        return new ShisetsuNyutaishoList(施設入退所List);
    }

    /**
     * 施設入退所インスタンスから施設入退所Entityのインスタンスを生成します。<br/>
     * 施設入退所インスタンスがnullの時はnullを返します。
     *
     * @param 施設入退所 施設入退所インスタンス
     * @return 施設入退所Entityのインスタンス
     */
    public static DbT1004ShisetsuNyutaishoEntity to施設入退所Entity(ShisetsuNyutaisho 施設入退所) {

        if (施設入退所 == null) {
            return null;
        }
        DbT1004ShisetsuNyutaishoEntity entity = new DbT1004ShisetsuNyutaishoEntity();
        entity.setShichosonCode(施設入退所.get市町村コード());
        entity.setShikibetsuCode(施設入退所.get個人識別コード());
        entity.setShoriTimestamp(施設入退所.get処理日時());
        entity.setDaichoShubetsu(施設入退所.get台帳種別().getCode());
        entity.setNyushoShisetsuShurui(施設入退所.get入所施設().get施設種類().getCode());
        entity.setNyushoShisetsuCode(施設入退所.get入所施設().get施設コード().value());
        entity.setNyushoShoriYMD(施設入退所.get入所処理年月日());
        entity.setNyushoYMD(施設入退所.get入所期間().getFrom());
        entity.setTaishoShoriYMD(施設入退所.get退所処理年月日());
        entity.setTaishoYMD(施設入退所.get入所期間().getTo());

        return entity;
    }

    private static Range<FlexibleDate> create入所期間(DbT1004ShisetsuNyutaishoEntity entity) {
        return new Range(entity.getNyushoYMD(), entity.getTaishoYMD());
    }
}
