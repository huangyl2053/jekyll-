/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futanngenndogakuninntei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902.ShakaiFukushiHoujinnKeigenListMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.FutanGenndoGakuNinnteiListEntity;

/**
 * 負担限度額認定の認定証発行のMapperクラスです。
 *
 * @reamsid_L DBD-3981-050 x_lilh
 */
public interface IFutanGenndoGakuNinnteiShouMapper {

    /**
     * 負担額認定証決定通知書発行一覧表発行情報を取得します．
     *
     * @param parameter パラメター
     * @return 負担額認定証決定通知書発行一覧表発行情報
     */
    List<FutanGenndoGakuNinnteiListEntity> get負担額認定証決定通知書発行一覧表発行情報(ShakaiFukushiHoujinnKeigenListMybatisParameter parameter);
}
