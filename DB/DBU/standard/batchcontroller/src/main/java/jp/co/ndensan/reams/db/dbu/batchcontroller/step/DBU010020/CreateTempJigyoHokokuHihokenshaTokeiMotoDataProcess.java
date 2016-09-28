/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020;

import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppoippan.IJigyoHokokuGeppoIppanMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * temp事業報告被保険者統計元データをcreateバッチ処理クラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
public class CreateTempJigyoHokokuHihokenshaTokeiMotoDataProcess extends SimpleBatchProcessBase {

    @Override
    protected void process() {
        IJigyoHokokuGeppoIppanMapper mapper = getMapper(IJigyoHokokuGeppoIppanMapper.class);
        mapper.createTempJigyoHokokuHihokenshaTokeiMotoData();
        mapper.createTempJigyoHokokuNinteiTokeiMotoData();
    }
}
