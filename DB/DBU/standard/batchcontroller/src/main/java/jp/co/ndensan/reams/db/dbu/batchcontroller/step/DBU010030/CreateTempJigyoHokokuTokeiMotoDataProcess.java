/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030;

import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippangenbutsu.IJigyoHokokuGeppoIppanGenbutsuMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * temp事業報告被保険者統計元データをcreateバッチ処理クラスです。
 *
 * @reamsid_L DBU-5540-030 suguangjun
 */
public class CreateTempJigyoHokokuTokeiMotoDataProcess extends SimpleBatchProcessBase {

    @Override
    protected void process() {
        getMapper(IJigyoHokokuGeppoIppanGenbutsuMapper.class).createtempJigyoHokokuTokeiMotoData();
    }
}
