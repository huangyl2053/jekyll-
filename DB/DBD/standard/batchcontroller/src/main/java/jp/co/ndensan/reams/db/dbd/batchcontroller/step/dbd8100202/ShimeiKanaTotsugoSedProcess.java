/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100202.ShimeiKanaTotsugoSedProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.ShimeiKanaTotsugoSedJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable.HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 氏名カナ突合_非課税年金対象者情報２_登録_process処理クラスです。
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
public class ShimeiKanaTotsugoSedProcess extends BatchProcessBase<ShimeiKanaTotsugoSedJohoEntity> {

    private static final RString 一 = new RString("1");
    private static final RString 二 = new RString("2");
    private static final RString 空 = new RString("");
    private static final RString ASTERISK = new RString("*");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hikazenenkintaishoshadoutei."
            + "IShimeiKanaTotsugoMapper.get非課税年金対象者情報");

    private ShimeiKanaTotsugoSedProcessParameter parameter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);

    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(
                HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity.class)
                .tempTableName(HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(ShimeiKanaTotsugoSedJohoEntity t) {
        HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity tempTableEntity
                = createTempTableEntity(t);
        tmpTableWriter.insert(tempTableEntity);

    }

    private HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity createTempTableEntity(ShimeiKanaTotsugoSedJohoEntity entity) {
        HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity data = new HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity();
        data.setDouteiResultKubun(一);
        data.setFuicchiJiyu(空);
        data.setGaitouJiyu(二);
        data.setFuicchiItem(空);
        if (entity != null) {
            data.setHihokenshaNo(entity.get被保険者番号());
            data.setAtenaKanaShimei(entity.get宛名カナ氏名());
            data.setAtenaSeinenngappi(entity.get宛名生年月日());
            data.setAtenaSeibetsu(entity.get宛名性別());
            data.setShikibetsuCode(entity.get識別コード());
            data.setShotaiCode(entity.get世帯コード());
            data.setNendo(parameter.get年度());
            data.setShoriKubunn(parameter.get処理区分());
            data.setTaishoMonth(parameter.get対象月());
            data.setKisoNennkinnNo(entity.get氏名カナ_DT基礎年金番号());
            data.setGenKisoNennkinnNo(entity.get氏名カナ_DT基礎年金番号());
            data.setNennkinnCode(entity.get氏名カナ_DT年金コード());
            data.setTourokuKubunn(一);
            data.setDtRekoDoKubunn(entity.get氏名カナ_DTレコード区分());
            data.setDtShichosonCode(entity.get氏名カナ_DT市町村コード());
            data.setDtNennkinnHokenshaCode(entity.get氏名カナ_DT年金保険者コード());
            data.setDtTsuuchiContentCode(entity.get氏名カナ_DT通知内容コード());
            data.setDtYobi1(entity.get氏名カナ_DT予備1());
            data.setDtSeidoCode(entity.get氏名カナ_DT制度コード());
            data.setDtCreateYMD(entity.get氏名カナ_DT作成年月日());
            data.setDtKisoNennkinnNo(entity.get氏名カナ_DT基礎年金番号());
            data.setDtNennkinnCode(entity.get氏名カナ_DT年金コード());
            data.setDtYobi2(entity.get氏名カナ_DT予備2());
            data.setDtSeinenngappi(entity.get氏名カナ_DT生年月日());
            data.setDtSeibetsu(entity.get氏名カナ_DT性別());
            data.setDtKanaShimei(entity.get氏名カナ_DTカナ氏名());
            data.setDtShifutoCode1(entity.get氏名カナ_DTシフトコード1());
            data.setDtKanjiShimei(entity.get氏名カナ_DT漢字氏名());
            data.setDtShifutoCode2(entity.get氏名カナ_DTシフトコード2());
            data.setDtYubinNo(entity.get氏名カナ_DT郵便番号());
            data.setDtKanajusyo(entity.get氏名カナ_DTカナ住所());
            data.setDtShifutoCode3(entity.get氏名カナ_DTシフトコード3());
            data.setDtKanjijusyo(entity.get氏名カナ_DT漢字住所());
            data.setDtShifutoCode4(entity.get氏名カナ_DTシフトコード4());
            data.setDtTaisyoYear(entity.get氏名カナ_DT対象年());
            data.setDtTeiseiHyouji(entity.get氏名カナ_DT訂正表示());
            data.setDtKakushuKubun(entity.get氏名カナ_DT各種区分());
            data.setDtShoriResult(entity.get氏名カナ_DT処理結果());
            data.setDtYobi3(entity.get氏名カナ_DT予備3());
            data.setDtYobi4(entity.get氏名カナ_DT予備4());
            data.setDtkinngaku1(entity.get氏名カナ_DT金額1());
            data.setDtKinngakuYobi1(entity.get氏名カナ_DT金額予備1());
            data.setDtKinngakuYobi2(entity.get氏名カナ_DT金額予備2());
            data.setDtYobi5(entity.get氏名カナ_DT予備5());
            data.setDtKyousaiNennkinnShoushoKigouNo(entity.get氏名カナ_DT共済年金証書記号番号());
        }
        if (entity != null && 一.equals(entity.get氏名カナ_DT訂正表示())) {
            data.setKisoNennkinnNoHennkou(ASTERISK);
        } else {
            data.setKisoNennkinnNoHennkou(空);
        }
        return data;
    }
}
