/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaTokkijiko;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaTokkijikoCollection;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5010NinteichosaTokkijikoEntity;

/**
 * 認定調査特記事項のMappingを行うクラスです。
 *
 * @author n8178 城間篤人
 */
public final class NinteichosaTokkijikoMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private NinteichosaTokkijikoMapper() {
    }

    /**
     * 認定調査特記事項Entityを、businessの認定調査特記事項クラスにマッピングします。<br/>
     * 引数にnullが渡されたときは、nullを返します。
     *
     * @param entity 認定調査特記事項Entity
     * @return 認定調査特記事項
     */
    public static NinteichosaTokkijiko to認定調査特記事項(DbT5010NinteichosaTokkijikoEntity entity) {
        if (entity == null) {
            return null;
        }
        return new NinteichosaTokkijiko(entity.getShinseishoKanriNo(), entity.getNinteichosaRirekiNo(),
                entity.getNinteichosaTokkijikoNo(), entity.getNinteichosaTokkijiko());
    }

    /**
     * 認定調査特記事項Entityのリストを受け取り、認定調査特記事項Collectionを返します。<br/>
     * 引数にnullや空のリストが渡された場合は、空のコレクションを返します。
     *
     * @param entities 認定調査特記事項Entityのリスト
     * @return 認定調査特記事項Collection
     */
    public static NinteichosaTokkijikoCollection to認定調査特記事項Collection(List<DbT5010NinteichosaTokkijikoEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return new NinteichosaTokkijikoCollection(Collections.EMPTY_LIST);
        }

        List<NinteichosaTokkijiko> 認定調査特記事項List = new ArrayList<>();
        for (DbT5010NinteichosaTokkijikoEntity entity : entities) {
            認定調査特記事項List.add(to認定調査特記事項(entity));
        }
        return new NinteichosaTokkijikoCollection(認定調査特記事項List);

    }

    /**
     * 認定調査特記事項クラスを、認定調査特記事項Entityにマッピングします。<br/>
     * 引数にnullが渡されたときは、nullを返します。
     *
     * @param 認定調査特記事項 認定調査特記事項
     * @return 認定調査特記事項Entity
     */
    public static DbT5010NinteichosaTokkijikoEntity to認定調査特記事項Entity(NinteichosaTokkijiko 認定調査特記事項) {
        if (認定調査特記事項 == null) {
            return null;
        }
        DbT5010NinteichosaTokkijikoEntity entity = new DbT5010NinteichosaTokkijikoEntity();
        entity.setShinseishoKanriNo(認定調査特記事項.get申請書管理番号());
        entity.setNinteichosaRirekiNo(認定調査特記事項.get認定調査依頼履歴番号());
        entity.setNinteichosaTokkijikoNo(認定調査特記事項.get認定調査特記事項番号());
        entity.setNinteichosaTokkijiko(認定調査特記事項.get特記事項());
        return entity;
    }
}
