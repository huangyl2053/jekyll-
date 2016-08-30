/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc710080;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc710090.HanyoListKagoMoshitateMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710080.HanyoListKyufuKanriHyoEntity;

/**
 * 汎用リスト(給付管理票)CSVデータのバッチのDB操作です。
 *
 * @reamsid_L DBC-3096-020 pengxingyi
 */
public interface IHanyoListKyufuKanriHyoMapper {

    /**
     * 給付管理票データを取得する。
     *
     * @param param param
     * @return {@link List<HanyoListKyufuKanriHyoEntity>}
     */
    List<HanyoListKyufuKanriHyoEntity> select給付管理票(HanyoListKagoMoshitateMybatisParameter param);
}
