/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hanyolistfutangendogakunintei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyolistfutangendogakunintei.FutanGendoGakuNinteiMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyolistfutangendogakunintei.FutanGendoGakuNinteiEntity;

/**
 *
 * 汎用リスト出力(負担限度額認定)のマッパーインタフェースです。
 *
 * @reamsid_L DBD-3930-030 panxiaobo
 */
public interface IHanyoListFutanGendoGakuNinteiMapper {

    /**
     * 汎用リスト情報を取得します。
     *
     * @param parameter パラメータク
     * @return List<FutanGendoGakuNinteiEntity>
     */
    List<FutanGendoGakuNinteiEntity> get汎用リスト(FutanGendoGakuNinteiMybatisParameter parameter);
}
