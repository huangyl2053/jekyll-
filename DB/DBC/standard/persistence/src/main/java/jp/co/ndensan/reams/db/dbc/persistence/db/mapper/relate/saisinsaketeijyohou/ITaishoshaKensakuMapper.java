/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.saisinsaketeijyohou;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saisinsaketeijyohou.TaishoshaKensakuParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saisinsaketeijyohou.TaishoshaKensakuRelateEntity;

/**
 * 高額介護サービス費照会のマッパーインタフェースです。
 *
 * @reamsid_L DBC-3040-010 zhangzhiming
 */
public interface ITaishoshaKensakuMapper {

    /**
     * 再審査決定情報取得します。
     *
     * @param 再審査決定検索条件 再審査決定検索条件
     * @return List<TaishoshaKensakuRelateEntity>
     */
    List<TaishoshaKensakuRelateEntity> select再審査決定情報(TaishoshaKensakuParameter 再審査決定検索条件);

    /**
     * 履歴番号情報取得します。
     *
     * @param 履歴番号検索条件 履歴番号検索条件
     * @return List<TaishoshaKensakuRelateEntity>
     */
    List<TaishoshaKensakuRelateEntity> select履歴番号情報(TaishoshaKensakuParameter 履歴番号検索条件);
}
