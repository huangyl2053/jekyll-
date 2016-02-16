/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt35003;

import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * システム日時の取得クラスです。
 */
public class SystemTimeShutokuProcess extends SimpleBatchProcessBase {
    
    /**
     * OutputParameter用キー systemTime
     */
    public static final RString SYSTEM_TIME;
    
   static {
        SYSTEM_TIME = new RString("systemTime");
    }
   private OutputParameter<RDateTime> systemTime;
   RDateTime バッチ起動時処理日時_年月日時分秒;
   
    @Override
    protected void beforeExecute() {
        systemTime = new OutputParameter<>();
    }

    @Override
    protected void process() {
        バッチ起動時処理日時_年月日時分秒 = RDate.getNowDateTime();
    }

    @Override
    protected void afterExecute() {
        systemTime.setValue(バッチ起動時処理日時_年月日時分秒);
    }

}
