/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.ShimeiKanaTotsugoResultEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable.ShimeiKanaTotsugoResultTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 氏名カナ突合結果一時_process処理クラスです。
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
public class ShimeiKanaTotsugoResultProcess extends BatchProcessBase<ShimeiKanaTotsugoResultEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper."
            + "relate.hikazenenkintaishoshadoutei.IShimeiKanaTotsugoMapper.get氏名カナ突合結果一時");

    @BatchWriter
    BatchEntityCreatedTempTableWriter shimeiKanaTotsugoResultTemp;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        shimeiKanaTotsugoResultTemp = new BatchEntityCreatedTempTableWriter(ShimeiKanaTotsugoResultTempTableEntity.TABLE_NAME,
                ShimeiKanaTotsugoResultTempTableEntity.class);

    }

    @Override
    protected void process(ShimeiKanaTotsugoResultEntity entity) {
        ShimeiKanaTotsugoResultTempTableEntity items = setShimeiKanaTotsugoResultTempTableEntity(entity);
        shimeiKanaTotsugoResultTemp.insert(items);
    }

    private ShimeiKanaTotsugoResultTempTableEntity setShimeiKanaTotsugoResultTempTableEntity(ShimeiKanaTotsugoResultEntity entity) {
        ShimeiKanaTotsugoResultTempTableEntity tempTable = new ShimeiKanaTotsugoResultTempTableEntity();
        tempTable.setDtTsuuchiContentCode(entity.getDt通知内容コード());
        tempTable.setDtRekoDoKubunn(entity.getDtレコード区分());
        tempTable.setDtShichosonCode(entity.getDt市町村コード());
        tempTable.setDtNennkinnHokenshaCode(entity.getDt年金保険者コード());
        tempTable.setDtYobi1(entity.getDt予備1());
        tempTable.setDtSeidoCode(entity.getDt制度コード());
        tempTable.setDtCreateYMD(entity.getDt作成年月日());
        tempTable.setDtKisoNennkinnNo(entity.getDt基礎年金番号());
        tempTable.setDtNennkinnCode(entity.getDt年金コード());
        tempTable.setDtYobi2(entity.getDt予備2());
        tempTable.setDtSeinenngappi(entity.getDt生年月日());
        tempTable.setDtSeibetsu(entity.getDt性別());
        tempTable.setDtKanaShimei(entity.getDtカナ氏名());
        tempTable.setDtShifutoCode1(entity.getDtシフトコード1());
        tempTable.setDtKanjiShimei(entity.getDt漢字氏名());
        tempTable.setDtShifutoCode2(entity.getDtシフトコード2());
        tempTable.setDtYubinNo(entity.getDt郵便番号());
        tempTable.setDtKanajusyo(entity.getDtカナ住所());
        tempTable.setDtShifutoCode3(entity.getDtシフトコード3());
        tempTable.setDtKanjijusyo(entity.getDt漢字住所());
        tempTable.setDtShifutoCode4(entity.getDtシフトコード4());
        tempTable.setDtTaisyoYear(entity.getDt対象年());
        tempTable.setDtTeiseiHyouji(entity.getDt訂正表示());
        tempTable.setDtKakushuKubun(entity.getDt各種区分());
        tempTable.setDtShoriResult(entity.getDt処理結果());
        tempTable.setDtYobi3(entity.getDt予備3());
        tempTable.setDtYobi4(entity.getDt予備4());
        tempTable.setDtkinngaku1(entity.getDt金額1());
        tempTable.setDtKinngakuYobi1(entity.getDt金額予備1());
        tempTable.setDtKinngakuYobi2(entity.getDt金額予備2());
        tempTable.setDtYobi5(entity.getDt予備5());
        tempTable.setDtKyousaiNennkinnShoushoKigouNo(entity.getDt共済年金証書記号番号());
        tempTable.setHihokenshaNo(entity.get被保険者番号());
        tempTable.setShikibetsuCode(entity.get識別コード());
        tempTable.setShotaiCode(entity.get世帯コード());
        tempTable.setAtenaKanaShimei(entity.get宛名カナ氏名());
        tempTable.setAtenaSeinenngappi(entity.get宛名生年月日());
        tempTable.setAtenaSeibetsu(entity.get宛名性別());
        return tempTable;
    }
}
