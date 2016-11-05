/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD301030;

import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.TorokuKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100202.HikazeNenkinTaishoFirProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.HikazeNenkinTaishoFirJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable.HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年金番号突合_非課税年金対象者情報１_登録_process処理クラスです。
 *
 * @reamsid_L DBD-4910-040 x_tongxf
 */
public class HikazeNenkinTaishoFirProcess extends BatchProcessBase<HikazeNenkinTaishoFirJohoEntity> {

    /**
     * 同定結果区分 "1"
     */
    private static final RString 同定結果区分_1 = new RString("1");
    /**
     * 該当事由 "1"
     */
    private static final RString 該当事由_1 = new RString("1");

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hikazenenkintaishoshadoutei."
                    + "INenkinNoTotsugoMapper.get年金番号突合_非課税年金対象者情報");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;
    private HikazeNenkinTaishoFirProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity.class)
                .tempTableName(HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(HikazeNenkinTaishoFirJohoEntity t) {
        tmpTableWriter.insert(create年金番号突合_非課税年金対象者情報(t));
    }

    private HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity create年金番号突合_非課税年金対象者情報(HikazeNenkinTaishoFirJohoEntity t) {
        HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity data = new HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity();
        data.setDouteiResultKubun(同定結果区分_1);
        data.setFuicchiJiyu(RString.EMPTY);
        data.setGaitouJiyu(該当事由_1);
        data.setFuicchiItem(t.get不一致項目());
        data.setKisoNennkinnNoHennkou(RString.EMPTY);
        data.setHihokenshaNo(t.get実績_被保険者番号());
        data.setAtenaKanaShimei(t.get実績_宛名カナ氏名());
        data.setAtenaSeinenngappi(t.get実績_宛名生年月日());
        data.setAtenaSeibetsu(t.get実績_宛名性別());
        data.setShikibetsuCode(t.get実績_識別コード());
        data.setShotaiCode(t.get実績_世帯コード());
        data.setNendo(parameter.get年度());
        data.setShoriKubunn(parameter.get処理区分());
        data.setTaishoMonth(parameter.get対象月());
        data.setKisoNennkinnNo(t.get非課税_DT基礎年金番号());
        data.setGenKisoNennkinnNo(t.get非課税_DT基礎年金番号());
        data.setNennkinnCode(t.get非課税_DT年金コード());
        data.setTourokuKubunn(TorokuKubun.取込.getコード());
        data.setDtRekoDoKubunn(t.get非課税_DTレコード区分());
        data.setDtShichosonCode(t.get非課税_DT市町村コード());
        data.setDtNennkinnHokenshaCode(t.get非課税_DT年金保険者コード());
        data.setDtTsuuchiContentCode(t.get非課税_DT通知内容コード());
        data.setDtYobi1(t.get非課税_DT予備1());
        data.setDtSeidoCode(t.get非課税_DT制度コード());
        data.setDtCreateYMD(t.get非課税_DT作成年月日());
        data.setDtKisoNennkinnNo(t.get非課税_DT基礎年金番号());
        data.setDtNennkinnCode(t.get非課税_DT年金コード());
        data.setDtYobi2(t.get非課税_DT予備2());
        data.setDtSeinenngappi(t.get非課税_DT生年月日());
        data.setDtSeibetsu(t.get非課税_DT性別());
        data.setDtKanaShimei(t.get非課税_DTカナ氏名());
        data.setDtShifutoCode1(t.get非課税_DTシフトコード1());
        data.setDtKanjiShimei(t.get非課税_DT漢字氏名());
        data.setDtShifutoCode2(t.get非課税_DTシフトコード2());
        data.setDtYubinNo(t.get非課税_DT郵便番号());
        data.setDtKanajusyo(t.get非課税_DTカナ住所());
        data.setDtShifutoCode3(t.get非課税_DTシフトコード3());
        data.setDtKanjijusyo(t.get非課税_DT漢字住所());
        data.setDtShifutoCode4(t.get非課税_DTシフトコード4());
        data.setDtTaisyoYear(t.get非課税_DT対象年());
        data.setDtTeiseiHyouji(t.get非課税_DT訂正表示());
        data.setDtKakushuKubun(t.get非課税_DT各種区分());
        data.setDtShoriResult(t.get非課税_DT処理結果());
        data.setDtYobi3(t.get非課税_DT予備3());
        data.setDtYobi4(t.get非課税_DT予備4());
        data.setDtkinngaku1(t.get非課税_DT金額予備1());
        data.setDtKinngakuYobi1(t.get非課税_DT金額予備1());
        data.setDtKinngakuYobi2(t.get非課税_DT金額予備2());
        data.setDtYobi5(t.get非課税_DT予備5());
        data.setDtKyousaiNennkinnShoushoKigouNo(t.get非課税_DT共済年金証書記号番号());
        return data;
    }
}
