/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010090;

import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppohokenkyufukogaku.IJigyoHokokuGeppoHokenkyufuKogakuMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 事業状況報告統計元TEMPテーブルを作成します。
 *
 * @reamsid_L DBU-5580-030 zhangzhiming
 */
public class TempJigyouJyoukyouHoukokuKougakuProcess extends SimpleBatchProcessBase {

    @Override
    protected void process() {
        getMapper(IJigyoHokokuGeppoHokenkyufuKogakuMapper.class).createTempJigyouJyoukyouHoukokuKougakuMotoData();
    }
}
