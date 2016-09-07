/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kaigojuminhyokobetsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojuminhyokobetsu.KaigojuminhyokobetsuEntity;

/**
 * 広域運用抽出期間情報を取得クラスです。
 *
 * @reamsid_L DBU-0550-040 zhangzhiming
 */
public interface IKaigoJuminhyoKobetsuMapper {

    /**
     * 広域運用抽出期間情報を取得します。
     *
     * @return 広域運用抽出期間情報リストです
     */
    List<KaigojuminhyokobetsuEntity> selectList();
}
