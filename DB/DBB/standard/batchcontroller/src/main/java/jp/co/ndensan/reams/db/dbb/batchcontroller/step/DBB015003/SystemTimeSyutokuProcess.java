/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB015003;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt36002.KarisanteiIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.karisanteiidotsuchisho.KarisanteiIdoTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「システム日時の取得」処理クラスです。
 *
 * @reamsid_L DBB-0890-030 xicongwang
 */
public class SystemTimeSyutokuProcess extends SimpleBatchProcessBase {

    private KarisanteiIdoFukaProcessParameter parameter;
    /**
     * OutputParameter用キー systemTime
     */
    public static final RString SYSTEM_TIME;
    /**
     * OutputParameter用キー kijunTime
     */
    public static final RString KIJUN_TIME;

    static {
        SYSTEM_TIME = new RString("systemTime");
        KIJUN_TIME = new RString("kijunTime");
    }

    private OutputParameter<YMDHMS> systemTime;
    private OutputParameter<RString> kijunTime;
    YMDHMS バッチ起動時処理日時_年月日時分秒;
    RString 最新調定日時;

    @Override
    protected void beforeExecute() {
        systemTime = new OutputParameter<>();
        kijunTime = new OutputParameter<>();
    }

    @Override
    protected void process() {
        KarisanteiIdoTsuchishoIkkatsuHakko manager = KarisanteiIdoTsuchishoIkkatsuHakko.createInstance();
        YMDHMS tmp調定日時 = manager.get最新調定日時(parameter.get調定年度());
        最新調定日時 = tmp調定日時 == null ? RString.EMPTY : new RString(tmp調定日時.toString());
        バッチ起動時処理日時_年月日時分秒 = YMDHMS.now();
    }

    @Override
    protected void afterExecute() {
        systemTime.setValue(バッチ起動時処理日時_年月日時分秒);
        kijunTime.setValue(最新調定日時);
    }
}
