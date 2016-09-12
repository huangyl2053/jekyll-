/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenkohaakuichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd207010.ShiharaiHohoHenkoHaakuMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoHaakuResultEntity;

/**
 * 支払方法変更滞納者把握リスト情報クラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
public interface IShiharaiHohoHenkoHaakuMapper {

    /**
     * 支払方法変更滞納者情報を取得します．
     *
     * @param parameter parameter パラメター
     * @return 支払方法変更滞納者情報リスト
     */
    List<ShiharaiHohoHenkoHaakuResultEntity> find支払方法変更滞納者情報(ShiharaiHohoHenkoHaakuMybatisParameter parameter);
}
