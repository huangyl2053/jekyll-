/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyotakuserviceriyohyomain;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakuserviceriyohyomain.KyotakuServiceRirekiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakuserviceriyohyomain.TaishoshaichiranEntity;

/**
 * 受領委任契約事業者登録・追加・修正・照会
 *
 * @reamsid_L DBC-1930-030 huzongcheng
 */
public interface IKyotakuServiceRiyohyoMainMapper {

    /**
     * 居宅サービス履歴一覧取得。
     *
     * @param parameter parameter
     * @return List<KyotakuServiceRirekiEntity>
     */
    List<KyotakuServiceRirekiEntity> get居宅サービス履歴一覧(Map<String, Object> parameter);

    /**
     * 対象情報一覧取得。
     *
     * @param parameter parameter
     * @return List<TaishoshaichiranEntity>
     */
    List<TaishoshaichiranEntity> get対象情報一覧(Map<String, Object> parameter);

}
