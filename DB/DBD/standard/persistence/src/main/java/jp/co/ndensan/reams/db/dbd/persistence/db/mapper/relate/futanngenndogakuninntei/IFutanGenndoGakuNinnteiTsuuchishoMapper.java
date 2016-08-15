/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futanngenndogakuninntei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902.FutanGenndoGakuNinnteiTsuuchishoMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.FutanGenndoGakuNinnteiTsuuchishoEntity;

/**
 * 負担限度額認定の通知書発行のMapperクラスです。
 *
 * @reamsid_L DBD-3981-050 x_lilh
 */
public interface IFutanGenndoGakuNinnteiTsuuchishoMapper {

    /**
     * 負担限度額認定の通知書発行情報を取得します．
     *
     * @param parameter パラメター
     * @return 負担限度額認定の通知書発行情報
     */
    List<FutanGenndoGakuNinnteiTsuuchishoEntity> get負担限度額認定の通知書発行情報(FutanGenndoGakuNinnteiTsuuchishoMybatisParameter parameter);
}
