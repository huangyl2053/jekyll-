/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kyufuseigentaishoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd210010.DBD210010MybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010.TainouJokyoEntity;

/**
 * 給付制限対象者一覧CSVの中間ファイル情報取得のMapperです。
 *
 * @reamsid_L DBD-4300-030 liuwei2
 */
public interface IShiharaiHohoHenkoMapper {

    /**
     * 支払方法管理情報を取得します。
     *
     * @param parameter DBD2020005MybatisParameter
     * @return List<ShiharaiHohoHenkoEntity>
     */
    List<ShiharaiHohoHenkoEntity> get支払方法管理情報(DBD210010MybatisParameter parameter);

    /**
     * 滞納状況情報を取得します。
     *
     * @return List<TainouJokyoEntity>
     */
    List<TainouJokyoEntity> get滞納状況情報();
}
