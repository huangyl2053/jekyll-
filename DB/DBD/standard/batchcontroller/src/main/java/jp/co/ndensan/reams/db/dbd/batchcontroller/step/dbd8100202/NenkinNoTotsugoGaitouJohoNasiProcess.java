/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.NenkinNoTotsugoGaitouJohoNasiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable.NenkinNoTotsugoGaitouJohoNasiTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年金番号突合_該当年金情報なし一時_process処理クラスです。
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
public class NenkinNoTotsugoGaitouJohoNasiProcess extends BatchProcessBase<NenkinNoTotsugoGaitouJohoNasiJohoEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hikazenenkintaishoshadoutei."
                    + "INenkinNoTotsugoMapper.get年金番号突合_該当情報なし");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(NenkinNoTotsugoGaitouJohoNasiTempTableEntity.class)
                .tempTableName(NenkinNoTotsugoGaitouJohoNasiTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(NenkinNoTotsugoGaitouJohoNasiJohoEntity t) {
        tmpTableWriter.insert(createNenkinNoTotsugoGaitouJohoNasiTempTableEntity(t));
    }

    private NenkinNoTotsugoGaitouJohoNasiTempTableEntity createNenkinNoTotsugoGaitouJohoNasiTempTableEntity(
            NenkinNoTotsugoGaitouJohoNasiJohoEntity t) {
        NenkinNoTotsugoGaitouJohoNasiTempTableEntity data = new NenkinNoTotsugoGaitouJohoNasiTempTableEntity();
        data.setDtRekoDoKubunn(t.get取込_DTレコード区分());
        data.setDtShichosonCode(t.get取込_DT市町村コード());
        data.setDtNennkinnHokenshaCode(t.get取込_DT年金保険者コード());
        data.setDtTsuuchiContentCode(t.get取込_DT通知内容コード());
        data.setDtYobi1(t.get取込_DT予備1());
        data.setDtSeidoCode(t.get取込_DT制度コード());
        data.setDtCreateYMD(t.get取込_DT作成年月日());
        data.setDtKisoNennkinnNo(t.get取込_DT基礎年金番号());
        data.setDtNennkinnCode(t.get取込_DT年金コード());
        data.setDtYobi2(t.get取込_DT予備2());
        data.setDtSeinenngappi(t.get取込_DT生年月日());
        data.setDtSeibetsu(t.get取込_DT性別());
        data.setDtKanaShimei(t.get取込_DTカナ氏名());
        data.setDtShifutoCode1(t.get取込_DTシフトコード1());
        data.setDtKanjiShimei(t.get取込_DT漢字氏名());
        data.setDtShifutoCode2(t.get取込_DTシフトコード2());
        data.setDtYubinNo(t.get取込_DT郵便番号());
        data.setDtKanajusyo(t.get取込_DTカナ住所());
        data.setDtShifutoCode3(t.get取込_DTシフトコード3());
        data.setDtKanjijusyo(t.get取込_DT漢字住所());
        data.setDtShifutoCode4(t.get取込_DTシフトコード4());
        data.setDtTaisyoYear(t.get取込_DT対象年());
        data.setDtTeiseiHyouji(t.get取込_DT訂正表示());
        data.setDtKakushuKubun(t.get取込_DT各種区分());
        data.setDtShoriResult(t.get取込_DT処理結果());
        data.setDtYobi3(t.get取込_DT予備3());
        data.setDtYobi4(t.get取込_DT予備4());
        data.setDtkinngaku1(t.get取込_DT金額1());
        data.setDtKinngakuYobi1(t.get取込_DT金額予備1());
        data.setDtKinngakuYobi2(t.get取込_DT金額予備2());
        data.setDtYobi5(t.get取込_DT予備5());
        data.setDtKyousaiNennkinnShoushoKigouNo(t.get取込_DT共済年金証書記号番号());
        return data;
    }
}
