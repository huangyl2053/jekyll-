/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5104ShinsakaiKaisaiBashoJohoEntity;

/**
 * 審査会開催場所情報Entityを審査会開催場所クラスに変換するためのMapperです。
 *
 * @author N1013 松本直樹
 */
public final class ShinsakaiKaisaiBashoJohoMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private ShinsakaiKaisaiBashoJohoMapper() {
    }

    /**
     * 審査会開催場所情報Entityを審査会開催場所クラスに変換します。
     *
     * @param entity 審査会開催場所情報Entity
     * @return 審査会開催場所クラス
     */
    public static ShinsakaiKaisaiBasho to審査会開催場所(DbT5104ShinsakaiKaisaiBashoJohoEntity entity) {
        ShinsakaiKaisaiBashoJokyo 審査会開催場所状況 = ShinsakaiKaisaiBashoJokyo.toValue(entity.getShinsakaiKaisaiBashoJokyo());

        return new ShinsakaiKaisaiBasho(entity.getShinsakaiKaisaiBashoCode(), entity.getShinsakaiKaisaiBashoMei(),
                entity.getShinsakaiKaisaiChikuCode(), entity.getShinsakaiKaisaiBashoJusho(),
                entity.getShinsakaiKaisaiBashoTelNo(), 審査会開催場所状況);
    }
}
