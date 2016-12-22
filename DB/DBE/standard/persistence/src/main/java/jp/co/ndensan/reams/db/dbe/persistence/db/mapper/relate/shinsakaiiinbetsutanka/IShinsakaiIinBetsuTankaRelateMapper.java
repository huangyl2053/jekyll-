/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaiiinbetsutanka;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinbetsutankasearchresult.ShinsakaiIinBetsuTankaRelateEntity;

/**
 * 介護認定審査会委員別単価Relateのマッパーインタフェースです。
 */
public interface IShinsakaiIinBetsuTankaRelateMapper {

    /**
     * 介護認定審査会委員別単価全件（氏名付き）を取得します。
     *
     * @return ShinsakaiIinBetsuTankaRelateEntity
     * 検索結果の{@link ShinsakaiIinBetsuTankaRelateEntity}
     */
    List<ShinsakaiIinBetsuTankaRelateEntity> select介護認定審査会委員別単価全件();
}
