/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010100;

import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppohokenkyufukogakugassan.IJigyoHokokuGeppoHokenkyufuKogakuGassanMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 事業状況報告統計元TEMPテーブルを作成します。
 *
 * @reamsid_L DBU-5590-030 zhangzhiming
 */
public class TempJigyouJyoukyouHoukokuGassanProcess extends SimpleBatchProcessBase {

    @Override
    protected void process() {
        getMapper(IJigyoHokokuGeppoHokenkyufuKogakuGassanMapper.class).createTempJigyouJyoukyouHoukokuGassanMotoData();
    }
}
