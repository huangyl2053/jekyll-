/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoIryoKikanEntity;
import jp.co.ndensan.reams.ur.urz.business.IKoza;
import jp.co.ndensan.reams.ur.urz.entity.mapper.IryoKikanMapper;

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
     */
    public static KaigoIryoKikan toKaigoIryoKikan(KaigoIryoKikanEntity entity, List<IKoza> 口座List) {
        return new KaigoIryoKikan(IryoKikanMapper.to医療機関(entity.getIryoKikanEntity(), 口座List),
                ShujiiIryoKikanMapper.toShujiiIryoKikan(entity.getDbT7011ShujiiIryoKikanJohoEntity()));
    }
}
