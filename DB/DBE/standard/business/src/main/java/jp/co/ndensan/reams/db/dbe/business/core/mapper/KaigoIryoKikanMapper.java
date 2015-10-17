/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.mapper;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.KaigoIryoKikan.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.KaigoIryoKikanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 介護医療機関エンティティを介護医療機関クラスにマッピングします。
 *
 * @author n8178 城間篤人
 */
public final class KaigoIryoKikanMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private KaigoIryoKikanMapper() {
    }

    /**
     * 引数から受け取った介護医療機関Entityと口座リストの情報を元に、介護医療機関クラスを作成して返します。
     *
     * @param entity 介護医療機関Entity
     * @param 口座List 口座List
     * @return 介護医療機関クラス
     * @throws NullPointerException 引数にNULLが渡された場合
     */
    public static KaigoIryoKikan toKaigoIryoKikan(KaigoIryoKikanEntity entity) throws NullPointerException {
        requireNonNull(entity, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("介護医療機関エンティティ", "介護医療機関"));

        // TODO ビルドエラー回避のために暫定対応
//        return new KaigoIryoKikan(new IryoKikan(entity.getIryoKikanEntity(), null),
//                ShujiiIryoKikanMapper.toShujiiIryoKikan(entity.getDbT7011ShujiiIryoKikanJohoEntity()));
        return null;
    }
}
