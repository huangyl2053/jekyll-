/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futanngenndogakuninntei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902.FutanGenndoGakuNinnteiListMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902.ShakaiFukushiHoujinnKeigenParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.FutanGenndoGakuNinnteiListEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.temptable.FutanGenndoGakuNinnteiTempTableEntity;

/**
 * 負担額認定証・決定通知書発行一覧表発行のMapperクラスです。
 *
 * @reamsid_L DBD-3981-050 x_lilh
 */
public interface IFutanGenndoGakuNinnteiListMapper {

    /**
     * 負担額認定証・決定通知書発行一覧表発行情報を取得します．
     *
     * @param parameter パラメター
     * @return 負担額認定証・決定通知書発行一覧表発行情報
     */
    List<FutanGenndoGakuNinnteiListEntity> get負担額認定証_決定通知書発行一覧表発行情報(FutanGenndoGakuNinnteiListMybatisParameter parameter);

    /**
     *
     * @param parameter ShakaiFukushiHoujinnKeigenParameter
     * @return FutanGenndoGakuNinnteiTempTableEntity
     */
    FutanGenndoGakuNinnteiTempTableEntity get負担限度額認定の認定証発行一時テーブル(ShakaiFukushiHoujinnKeigenParameter parameter);
}
