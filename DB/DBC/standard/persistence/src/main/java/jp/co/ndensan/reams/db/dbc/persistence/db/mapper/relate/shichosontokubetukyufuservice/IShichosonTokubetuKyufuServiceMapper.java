/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shichosontokubetukyufuservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shichosontokubetukyufuservice.ShichosonTokubetuKyufuServiceEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @reamsid_L DBC-3420-010 tz_chengpeng
 */
public interface IShichosonTokubetuKyufuServiceMapper {

    /**
     * 一覧情報を取得します。
     *
     * @return List<ShichosonTokubetuKyufuServiceEntity>
     */
    List<ShichosonTokubetuKyufuServiceEntity> get一覧情報();

    /**
     * 最大履歴番号の取得。
     *
     * @param serviceCode serviceCode
     * @return 最大履歴番号
     */
    int get最大履歴番号(RString serviceCode);
}
