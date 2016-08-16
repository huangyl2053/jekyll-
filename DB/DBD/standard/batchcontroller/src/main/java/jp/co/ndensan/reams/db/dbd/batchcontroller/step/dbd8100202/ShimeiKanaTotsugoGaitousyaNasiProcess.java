/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100202.ShimeiKanaTotsugoGaitousyaNasiProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.ShimeiKanaTotsugoGaitousyaNasiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable.HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 氏名カナ突合_該当者なし情報_登録_process処理クラスです。
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
public class ShimeiKanaTotsugoGaitousyaNasiProcess extends BatchProcessBase<ShimeiKanaTotsugoGaitousyaNasiJohoEntity> {

    private static final RString 一 = new RString("1");
    private static final RString 二 = new RString("2");
    private static final RString 空 = new RString("");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hikazenenkintaishoshadoutei."
            + "IShimeiKanaTotsugoMapper.get該当者なし情報");

    private ShimeiKanaTotsugoGaitousyaNasiProcessParameter parameter;

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
    protected void process(ShimeiKanaTotsugoGaitousyaNasiJohoEntity t) {

        HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity tempTableEntity
                = createTempTableEntity(t);
        tmpTableWriter.insert(tempTableEntity);
    }

    private HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity createTempTableEntity(ShimeiKanaTotsugoGaitousyaNasiJohoEntity entity) {

        HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity data = new HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity();

        data.setDouteiResultKubun(二);
        data.setFuicchiJiyu(二);
        data.setGaitouJiyu(空);
        data.setFuicchiItem(空);
        data.setKisoNennkinnNoHennkou(空);
        data.setHihokenshaNo(null);
        data.setAtenaKanaShimei(空);
        data.setAtenaSeinenngappi(null);
        data.setAtenaSeibetsu(空);
        data.setShikibetsuCode(null);
        data.setShotaiCode(空);
        data.setNendo(parameter.get年度());
        data.setShoriKubunn(parameter.get処理区分());
        data.setTaishoMonth(parameter.get対象月());
        if (entity != null) {
            data.setKisoNennkinnNo(entity.getDT基礎年金番号());
            data.setGenKisoNennkinnNo(空);
            data.setNennkinnCode(entity.getDT年金コード());
            data.setTourokuKubunn(一);
            data.setDtRekoDoKubunn(entity.getDTレコード区分());
            data.setDtShichosonCode(entity.getDT市町村コード());
            data.setDtNennkinnHokenshaCode(entity.getDT年金保険者コード());
            data.setDtTsuuchiContentCode(entity.getDT通知内容コード());
            data.setDtYobi1(entity.getDT予備1());
            data.setDtSeidoCode(entity.getDT制度コード());
            data.setDtCreateYMD(entity.getDT作成年月日());
            data.setDtKisoNennkinnNo(entity.getDT基礎年金番号());
            data.setDtNennkinnCode(entity.getDT年金コード());
            data.setDtYobi2(entity.getDT予備2());
            data.setDtSeinenngappi(entity.getDT生年月日());
            data.setDtSeibetsu(entity.getDT性別());
            data.setDtKanaShimei(entity.getDTカナ氏名());
            data.setDtShifutoCode1(entity.getDTシフトコード1());
            data.setDtKanjiShimei(entity.getDT漢字氏名());
            data.setDtShifutoCode2(entity.getDTシフトコード2());
            data.setDtYubinNo(entity.getDT郵便番号());
            data.setDtKanajusyo(entity.getDTカナ住所());
            data.setDtShifutoCode3(entity.getDTシフトコード3());
            data.setDtKanjijusyo(entity.getDT漢字住所());
            data.setDtShifutoCode4(entity.getDTシフトコード4());
            data.setDtTaisyoYear(entity.getDT対象年());
            data.setDtTeiseiHyouji(entity.getDT訂正表示());
            data.setDtKakushuKubun(entity.getDT各種区分());
            data.setDtShoriResult(entity.getDT処理結果());
            data.setDtYobi3(entity.getDT予備3());
            data.setDtYobi4(entity.getDT予備4());
            data.setDtkinngaku1(entity.getDT金額1());
            data.setDtKinngakuYobi1(entity.getDT金額予備1());
            data.setDtKinngakuYobi2(entity.getDT金額予備2());
            data.setDtYobi5(entity.getDT予備5());
            data.setDtKyousaiNennkinnShoushoKigouNo(entity.getDT共済年金証書記号番号());
        }
        return data;
    }
}
