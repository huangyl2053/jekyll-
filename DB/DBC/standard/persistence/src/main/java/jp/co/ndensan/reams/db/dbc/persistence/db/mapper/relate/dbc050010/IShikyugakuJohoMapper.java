/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010.ShikyugakuJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.ShikyugakuJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.YoshikiNoJohoEntity;

/**
 * 様式番号別支給金額情報取得
 *
 * @reamsid_L DBC-2180-030 tianyh
 */
public interface IShikyugakuJohoMapper {

    /**
     * 様式番号別支給金額情報データ取得です。
     *
     * @param parameter ShikyugakuJohoMybatisParameter
     * @return ShikyugakuJohoEntity
     */
    List<ShikyugakuJohoEntity> select様式番号別支給金額情報(ShikyugakuJohoMybatisParameter parameter);

    /**
     * 様式番号名称データ取得です。
     *
     * @return YoshikiNoJohoEntity
     */
    List<YoshikiNoJohoEntity> select様式番号名称();

}
