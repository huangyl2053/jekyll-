/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010050;

import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippanshokanketteiym.IJigyoHokokuGeppoIppanShokanMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * temp事業報告被保険者統計元データをcreateバッチ処理クラスです。
 *
 * @reamsid_L DBU-5550-030 suguangjun
 */
public class CreateTempJigyoHokokuShokanbunTokeiMotoDataProcess extends SimpleBatchProcessBase {

    @Override
    protected void process() {
        getMapper(IJigyoHokokuGeppoIppanShokanMapper.class).createtempJigyoHokokuShokanbunKetteiYMTokeiMotoData();
    }
}
