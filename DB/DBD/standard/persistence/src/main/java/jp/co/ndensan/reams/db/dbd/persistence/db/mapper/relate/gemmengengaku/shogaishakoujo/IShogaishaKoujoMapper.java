/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.shogaishakoujo;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.shogaishakoujo.ShogaishaKoujoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 障がい書控除のマッパーインタフェースです。
 *
 * @reamsid_L DBD-3840-010 wangjie2
 */
public interface IShogaishaKoujoMapper {

    /**
     * 被保険者番号にすべて障がい書控除申請一覧情報減のリストを取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return ShogaishaKoujoEntityの{@code list}
     */
    List<ShogaishaKoujoEntity> selectすべて障がい書控除申請一覧情報By被保険者番号(HihokenshaNo 被保険者番号);

}
