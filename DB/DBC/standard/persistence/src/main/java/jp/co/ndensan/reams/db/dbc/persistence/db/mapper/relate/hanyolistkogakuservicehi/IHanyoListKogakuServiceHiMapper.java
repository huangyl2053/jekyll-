/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hanyolistkogakuservicehi;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyourisutosyuturyoku.HanyoListKogakuKaigoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyourisutosyuturyoku.HanyouRisutoSyuturyokuEntity;

/**
 * 汎用リスト出力(高額介護サービス費状況)のマッパーインタフェースです。
 *
 * @reamsid_L DBC-3092-020 sunhui
 */
public interface IHanyoListKogakuServiceHiMapper {

    /**
     * データの取得
     *
     * @param parameter HanyouRisutoSyuturyokuMybatisParameter
     * @return HanyouRisutoSyuturyokuEntity
     */
    List<HanyouRisutoSyuturyokuEntity> selectAllデータ(HanyoListKogakuKaigoMybatisParameter parameter);

}
