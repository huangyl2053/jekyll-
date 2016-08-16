/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100202.NenkinNoCheckListProcessParmeter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable.JissekiDataIchijiSakuseiTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable.NenkinNoCheckListTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年金番号チェックリスト一時_process処理クラスです。
 *
 * @reamsid_L DBD-4910-040 x_tongxf
 */
public class NenkinNoCheckListProcess extends BatchProcessBase<JissekiDataIchijiSakuseiTempTableEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hikazenenkintaishoshadoutei."
                    + "INenkinNoTotsugoMapper.get年金番号突合_年金番号チェックリスト情報");

    private NenkinNoCheckListProcessParmeter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toNenkinNoCheckListMybatisprmParamter());
    }
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(NenkinNoCheckListTempTableEntity.class)
                .tempTableName(NenkinNoCheckListTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(JissekiDataIchijiSakuseiTempTableEntity t) {
        tmpTableWriter.insert(createNenkinNoCheckListTempTableEntity(t));
    }

    private NenkinNoCheckListTempTableEntity createNenkinNoCheckListTempTableEntity(JissekiDataIchijiSakuseiTempTableEntity t) {
        NenkinNoCheckListTempTableEntity data = new NenkinNoCheckListTempTableEntity();
        data.setDtRekoDoKubunn(t.getDtRekoDoKubunn());
        data.setDtShichosonCode(t.getDtShichosonCode());
        data.setDtNennkinnHokenshaCode(t.getDtNennkinnHokenshaCode());
        data.setDtTsuuchiContentCode(t.getDtTsuuchiContentCode());
        data.setDtYobi1(t.getDtYobi1());
        data.setDtSeidoCode(t.getDtSeidoCode());
        data.setDtCreateYMD(t.getDtCreateYMD());
        data.setDtKisoNennkinnNo(t.getDtKisoNennkinnNo());
        data.setDtNennkinnCode(t.getDtNennkinnCode());
        data.setDtYobi2(t.getDtYobi2());
        data.setDtSeinenngappi(t.getDtSeinenngappi());
        data.setDtSeibetsu(t.getDtSeibetsu());
        data.setDtKanaShimei(t.getDtKanaShimei());
        data.setDtShifutoCode1(t.getDtShifutoCode1());
        data.setDtKanjiShimei(t.getDtKanjiShimei());
        data.setDtShifutoCode2(t.getDtShifutoCode2());
        data.setDtYubinNo(t.getDtYubinNo());
        data.setDtKanajusyo(t.getDtKanajusyo());
        data.setDtShifutoCode3(t.getDtShifutoCode3());
        data.setDtKanjijusyo(t.getDtKanjijusyo());
        data.setDtShifutoCode4(t.getDtShifutoCode4());
        data.setDtTaisyoYear(t.getDtTaisyoYear());
        data.setDtTeiseiHyouji(t.getDtTeiseiHyouji());
        data.setDtKakushuKubun(t.getDtKakushuKubun());
        data.setDtShoriResult(t.getDtShoriResult());
        data.setDtYobi3(t.getDtYobi3());
        data.setDtYobi4(t.getDtYobi4());
        data.setDtkinngaku1(t.getAtenaKanaShimei());
        data.setDtKinngakuYobi1(t.getDtKinngakuYobi1());
        data.setDtKinngakuYobi2(t.getDtKinngakuYobi2());
        data.setDtYobi5(t.getDtYobi5());
        data.setDtKyousaiNennkinnShoushoKigouNo(t.getDtKyousaiNennkinnShoushoKigouNo());
        return data;
    }
}
