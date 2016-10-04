/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc710100;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc710100.HanyoListKagoKekkaMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710100.HanyoListKagoKekkaEntity;

/**
 * 汎用リスト(過誤結果情報)CSVデータのバッチのDB操作です。
 *
 * @reamsid_L DBC-3094-020 qinzhen
 */
public interface IHanyoListKagoKekkaMapper {

    /**
     * 過誤結果情報データを取得する。
     *
     * @param param param
     * @return {@link List<HanyoListKagoKekkaEntity>}
     */
    List<HanyoListKagoKekkaEntity> select過誤結果情報(HanyoListKagoKekkaMybatisParameter param);
}
