/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufutsuchigenmenhosei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufutsuchigenmenhosei.KyufuTsuchiGenmenHoseiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufutsuchigenmenhosei.KyufuTsuchiGenmenHoseiEntity;

/**
 * 給付費通知減免補正一覧表作成のMapperクラスです。
 *
 * @reamsid_L DBC-2270-030 lijia
 */
public interface IKyufuTsuchiGenmenHoseiMapper {

    /**
     * 給付費通知減免補正一覧取得。
     *
     * @param parameter KyufuTsuchiGenmenHoseiMapperParameter
     * @return List<KyufuTsuchiGenmenHoseiEntity>
     */
    List<KyufuTsuchiGenmenHoseiEntity> get給付費通知減免補正一覧(KyufuTsuchiGenmenHoseiMapperParameter parameter);
}
