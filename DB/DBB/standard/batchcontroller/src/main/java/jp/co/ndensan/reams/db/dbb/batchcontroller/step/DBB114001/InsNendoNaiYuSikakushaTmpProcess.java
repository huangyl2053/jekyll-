/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001;

import jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo.ShotokuNendoParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shotokushokaihyohakko.ShotokuShokaihyoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.NendoNaiyuSikakuMonoTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年度内有資格者Tempテーブルに登録のクラスです。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class InsNendoNaiYuSikakushaTmpProcess extends BatchProcessBase<NendoNaiyuSikakuMonoTempEntity> {

    private static final int INT_1 = 1;
    private static final int INT_4 = 4;
    private static final int INT_64 = 64;
    private static final RString SELECTPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db"
            + ".mapper.relate.shotokushokaihyo.IShotokushokaihyoMapper.select年度内有資格者抽出");

    private static final RString 年度内有資格者TEMP = new RString("NendoNaiyuSikakuMonoTemp");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 年度内有資格者writer;
    private ShotokuShokaihyoHakkoProcessParameter processParameter;
    private ShotokuNendoParameter myBatisParameter;
    private ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;
    private NendoNaiyuSikakuMonoTempEntity 年度内有資格者Entity;

    @Override
    protected void createWriter() {
        年度内有資格者Entity = null;
        年度内有資格者writer = new BatchEntityCreatedTempTableWriter(年度内有資格者TEMP, NendoNaiyuSikakuMonoTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        myBatisParameter = creatParameter();
        return new BatchDbReader(SELECTPATH, myBatisParameter);
    }

    @Override
    protected void process(NendoNaiyuSikakuMonoTempEntity t) {
        if (null == 年度内有資格者Entity) {
            年度内有資格者Entity = t;
            識別コード = t.getShikibetsuCode();
        } else if (識別コード.equals(t.getShikibetsuCode())) {
            if (t.getHihokenshaNo() == null) {
                年度内有資格者writer.insert(年度内有資格者Entity);
            } else {
                年度内有資格者writer.insert(t);
            }
            年度内有資格者Entity = null;
        } else {
            年度内有資格者writer.insert(年度内有資格者Entity);
            識別コード = t.getShikibetsuCode();
            年度内有資格者Entity = t;
        }
    }

    @Override
    protected void afterExecute() {
        if(null != 年度内有資格者Entity){
            年度内有資格者writer.insert(年度内有資格者Entity);
        }
    }

    private ShotokuNendoParameter creatParameter() {
        ShotokuNendoParameter param = new ShotokuNendoParameter();
        FlexibleYear 処理年度 = processParameter.get処理年度();
        param.setシステム日付(FlexibleDate.getNowDate());
        param.set処理年度_0401(new FlexibleDate(処理年度.getYearValue(), INT_4, INT_1));
        param.set処理年度_plus1_0401(new FlexibleDate(処理年度.getYearValue() + INT_1, INT_4, INT_1));
        param.set処理年度_minus64_0401(new FlexibleDate(処理年度.getYearValue() - INT_64, INT_4, INT_1));
        return param;
    }

}
