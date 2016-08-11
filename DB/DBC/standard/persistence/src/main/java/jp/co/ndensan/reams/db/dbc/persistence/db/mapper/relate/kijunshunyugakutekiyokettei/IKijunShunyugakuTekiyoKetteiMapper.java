/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunshunyugakutekiyokettei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kijunshunyugakutekiyokettei.KijunShunyugakuTekiyoKetteiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kijunshunyugakutekiyokettei.KijunShunyugakuTekiyoKetteiEntity;

/**
 * 基準収入額決定通知書発行mapperクラスです。
 *
 * @reamsid_L DBC-4610-030 xuhao
 */
public interface IKijunShunyugakuTekiyoKetteiMapper {

    /**
     * 基準収入額適用管理の取得
     *
     * @param parameter KijunShunyugakuTekiyoKetteiMybatisParameter
     * @return 基準収入額適用管理data
     */
    List<KijunShunyugakuTekiyoKetteiEntity> select基準収入額適用管理(KijunShunyugakuTekiyoKetteiMybatisParameter parameter);

}
