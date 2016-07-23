/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb051001;

import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「システム日時の取得」処理クラスです。
 *
 * @reamsid_L DBB-0930-010 yuanzhenxia
 */
public class SystemTimeGennendoIdoFukaProcess extends SimpleBatchProcessBase {

    /**
     * OutputParameter用キー systemTime
     */
    public static final RString SYSTEM_TIME;

    static {
        SYSTEM_TIME = new RString("systemTime");
    }
    private OutputParameter<YMDHMS> systemTime;
    YMDHMS バッチ起動時処理日時_年月日時分秒;

    @Override
    protected void beforeExecute() {
        systemTime = new OutputParameter<>();
    }

    @Override
    protected void process() {
        バッチ起動時処理日時_年月日時分秒 = YMDHMS.now();
    }

    @Override
    protected void afterExecute() {
        systemTime.setValue(バッチ起動時処理日時_年月日時分秒);
    }
}
