/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako.TokuchoHeijunka6gatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.FukaJohoShutokuProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheijunka6tsuchishoikatsuhako.ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「システム日時の取得」処理です。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
public class SystemTimeShutokuProcess extends SimpleBatchProcessBase {

    /**
     * OutputParameter用キー systemTime
     */
    public static final RString SYSTEM_TIME;
    /**
     * OutputParameter用キー kijunTime
     */
    public static final RString KIJUN_TIME;

    FukaJohoShutokuProcessParameter parameter;

    static {
        SYSTEM_TIME = new RString("systemTime");
        KIJUN_TIME = new RString("kijunTime");
    }
    private ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper mapper;
    private OutputParameter<RDateTime> systemTime;
    private OutputParameter<RString> kijunTime;
    RDateTime バッチ起動時処理日時_年月日時分秒;
    RString 基準日時;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper.class);
        systemTime = new OutputParameter<>();
        kijunTime = new OutputParameter<>();
    }

    @Override
    protected void process() {
        バッチ起動時処理日時_年月日時分秒 = RDate.getNowDateTime();
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        IKozaSearchKey key = builder.build();
        基準日時 = mapper.get基準日時(new TokuchoHeijunka6gatsuMyBatisParameter(
                false, parameter.get調定年度(), null, null, ShoriName.特徴平準化計算_6月分.get名称(), null, null, null, null, key));
    }

    @Override
    protected void afterExecute() {
        systemTime.setValue(バッチ起動時処理日時_年月日時分秒);
        kijunTime.setValue(基準日時);
    }

}
