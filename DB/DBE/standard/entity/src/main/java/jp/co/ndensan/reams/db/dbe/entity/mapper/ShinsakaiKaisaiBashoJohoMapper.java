/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoChikuCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
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
        if (entity == null) {
            return null;
        }

        ShinsakaiKaisaiBashoJokyo 審査会開催場所状況 = ShinsakaiKaisaiBashoJokyo.toValue(entity.getShinsakaiKaisaiBashoJokyo());
        ShinsakaiKaisaiBashoCode 審査会開催場所コード = new ShinsakaiKaisaiBashoCode(entity.getShinsakaiKaisaiBashoCode().value());
        ShinsakaiKaisaiBashoChikuCode 審査会開催場所地区コード = new ShinsakaiKaisaiBashoChikuCode(entity.getShinsakaiKaisaiChikuCode().value());

        return new ShinsakaiKaisaiBasho(審査会開催場所コード, entity.getShinsakaiKaisaiBashoMei(),
                審査会開催場所地区コード, entity.getShinsakaiKaisaiBashoJusho(),
                entity.getShinsakaiKaisaiBashoTelNo(), 審査会開催場所状況);
    }

    /**
     * 審査会開催場所情報エンティティを編集します。
     *
     * @param shinsakaiKaisaiBasho 審査会開催場所情報
     * @return 審査会開催場所情報エンティティ
     */
    public static DbT5104ShinsakaiKaisaiBashoJohoEntity toDbT5104ShinsakaiKaisaiBashoJohoEntity(ShinsakaiKaisaiBasho shinsakaiKaisaiBasho) {
        DbT5104ShinsakaiKaisaiBashoJohoEntity entity = new DbT5104ShinsakaiKaisaiBashoJohoEntity();
        entity.setShinsakaiKaisaiBashoCode(shinsakaiKaisaiBasho.get開催場所コード());
        entity.setShinsakaiKaisaiBashoMei(shinsakaiKaisaiBasho.get開催場所名称());
        entity.setShinsakaiKaisaiChikuCode(shinsakaiKaisaiBasho.get開催場所地区コード());
        entity.setShinsakaiKaisaiBashoJusho(shinsakaiKaisaiBasho.get開催場所住所());
        entity.setShinsakaiKaisaiBashoTelNo(shinsakaiKaisaiBasho.get開催場所電話番号());
        entity.setShinsakaiKaisaiBashoJokyo(shinsakaiKaisaiBasho.get開催場所状況().is有効());
        return entity;
    }
}
