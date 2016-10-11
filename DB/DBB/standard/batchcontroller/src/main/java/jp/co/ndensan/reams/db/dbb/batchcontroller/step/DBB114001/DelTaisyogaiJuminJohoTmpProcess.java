/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001;

import jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo.ShotokuNendoParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shotokushokaihyohakko.ShotokuShokaihyoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.shotokushokaihyo.IShotokushokaihyoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 対象外の住民情報を更新のクラスです。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class DelTaisyogaiJuminJohoTmpProcess extends SimpleBatchProcessBase {

    private static final int INT_1 = 1;
    private ShotokuShokaihyoHakkoProcessParameter processParameter;
    private ShotokuNendoParameter myBaticParameter;
    private IShotokushokaihyoMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IShotokushokaihyoMapper.class);
        myBaticParameter = creatParameter(processParameter);
    }

    @Override
    protected void process() {
        mapper.delete所得照会候補者1(myBaticParameter);
        mapper.delete所得照会候補者(processParameter.get処理年度());
    }

    private ShotokuNendoParameter creatParameter(ShotokuShokaihyoHakkoProcessParameter processParameter) {
        ShotokuNendoParameter parameter = new ShotokuNendoParameter();
        parameter.set処理年度_0101(new FlexibleDate(processParameter.get処理年度().getYearValue(), INT_1, INT_1));
        return parameter;
    }

}
