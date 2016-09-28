/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc710090;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc710090.HanyoListKagoMoshitateMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710090.HanyoListKagoMoshitateEntity;

/**
 * 汎用リスト(過誤申立情報)CSVデータのバッチのDB操作です。
 *
 * @reamsid_L DBC-3095-020 pengxingyi
 */
public interface IHanyoListKagoMoshitateMapper {

    /**
     * 過誤申立情報データを取得する。
     *
     * @param param param
     * @return {@link List<HanyoListKagoMoshitateEntity>}
     */
    List<HanyoListKagoMoshitateEntity> select過誤申立情報(HanyoListKagoMoshitateMybatisParameter param);
}
