/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.ShimeiKanaTotsugoResultEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable.ShimeiKanaTotsugoResultTempTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

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
        // TODO 氏名カナ突合結果一時テーブルを登録する
        ShimeiKanaTotsugoResultTempTableEntity items = setShimeiKanaTotsugoResultTempTableEntity(entity);

        shimeiKanaTotsugoResultTemp.insert(items);

    }

    private ShimeiKanaTotsugoResultTempTableEntity setShimeiKanaTotsugoResultTempTableEntity(ShimeiKanaTotsugoResultEntity entity) {
        ShimeiKanaTotsugoResultTempTableEntity tempTable = new ShimeiKanaTotsugoResultTempTableEntity();
        if (entity.getDtレコード区分() == null || entity.getDtレコード区分().isEmpty()) {
            tempTable.setDtRekoDoKubunn(RString.EMPTY);
        } else {
            tempTable.setDtRekoDoKubunn(entity.getDtレコード区分());
        }
        if (entity.getDt市町村コード() == null || entity.getDt市町村コード().isEmpty()) {
            tempTable.setDtShichosonCode(RString.EMPTY);
        } else {
            tempTable.setDtShichosonCode(entity.getDt市町村コード());
        }
        if (entity.getDt年金保険者コード() == null || entity.getDt年金保険者コード().isEmpty()) {
            tempTable.setDtNennkinnHokenshaCode(RString.EMPTY);
        } else {
            tempTable.setDtNennkinnHokenshaCode(entity.getDt年金保険者コード());
        }
        if (entity.getDt予備1() == null || entity.getDt予備1().isEmpty()) {
            tempTable.setDtYobi1(RString.EMPTY);
        } else {
            tempTable.setDtYobi1(entity.getDt予備1());
        }
        if (entity.getDt制度コード() == null || entity.getDt制度コード().isEmpty()) {
            tempTable.setDtSeidoCode(RString.EMPTY);
        } else {
            tempTable.setDtSeidoCode(entity.getDt制度コード());
        }
        if (entity.getDt作成年月日() == null || entity.getDt作成年月日().isEmpty()) {
            tempTable.setDtCreateYMD(FlexibleYear.EMPTY);
        } else {
            tempTable.setDtCreateYMD(entity.getDt作成年月日());
        }
        if (entity.getDt基礎年金番号() == null || entity.getDt基礎年金番号().isEmpty()) {
            tempTable.setDtKisoNennkinnNo(RString.EMPTY);
        } else {
            tempTable.setDtKisoNennkinnNo(entity.getDt基礎年金番号());
        }
        if (entity.getDt年金コード() == null || entity.getDt年金コード().isEmpty()) {
            tempTable.setDtNennkinnCode(RString.EMPTY);
        } else {
            tempTable.setDtNennkinnCode(entity.getDt年金コード());
        }
        if (entity.getDt予備2() == null || entity.getDt予備2().isEmpty()) {
            tempTable.setDtYobi2(RString.EMPTY);
        } else {
            tempTable.setDtYobi2(entity.getDt予備2());
        }
        if (entity.getDt生年月日() == null || entity.getDt生年月日().isEmpty()) {
            tempTable.setDtSeinenngappi(FlexibleDate.EMPTY);
        } else {
            tempTable.setDtSeinenngappi(entity.getDt生年月日());
        }
        if (entity.getDt性別() == null || entity.getDt性別().isEmpty()) {
            tempTable.setDtSeibetsu(RString.EMPTY);
        } else {
            tempTable.setDtSeibetsu(entity.getDt性別());
        }
        if (entity.getDtカナ氏名() == null || entity.getDtカナ氏名().isEmpty()) {
            tempTable.setDtKanaShimei(RString.EMPTY);
        } else {
            tempTable.setDtKanaShimei(entity.getDtカナ氏名());
        }
        if (entity.getDtシフトコード1() == null || entity.getDtシフトコード1().isEmpty()) {
            tempTable.setDtShifutoCode1(RString.EMPTY);
        } else {
            tempTable.setDtShifutoCode1(entity.getDtシフトコード1());
        }
        if (entity.getDt漢字氏名() == null || entity.getDt漢字氏名().isEmpty()) {
            tempTable.setDtKanjiShimei(RString.EMPTY);
        } else {
            tempTable.setDtKanjiShimei(entity.getDt漢字氏名());
        }
        if (entity.getDtシフトコード2() == null || entity.getDtシフトコード2().isEmpty()) {
            tempTable.setDtShifutoCode2(RString.EMPTY);
        } else {
            tempTable.setDtShifutoCode2(entity.getDtシフトコード2());
        }
        if (entity.getDt郵便番号() == null || entity.getDt郵便番号().isEmpty()) {
            tempTable.setDtYubinNo(YubinNo.EMPTY);
        } else {
            tempTable.setDtYubinNo(entity.getDt郵便番号());
        }
        if (entity.getDtカナ住所() == null || entity.getDtカナ住所().isEmpty()) {
            tempTable.setDtKanajusyo(RString.EMPTY);
        } else {
            tempTable.setDtKanajusyo(entity.getDtカナ住所());
        }
        if (entity.getDtシフトコード3() == null || entity.getDtシフトコード3().isEmpty()) {
            tempTable.setDtShifutoCode3(RString.EMPTY);
        } else {
            tempTable.setDtShifutoCode3(entity.getDtシフトコード3());
        }
        if (entity.getDt漢字住所() == null || entity.getDt漢字住所().isEmpty()) {
            tempTable.setDtKanjijusyo(RString.EMPTY);
        } else {
            tempTable.setDtKanjijusyo(entity.getDt漢字住所());
        }
        if (entity.getDtシフトコード4() == null || entity.getDtシフトコード4().isEmpty()) {
            tempTable.setDtShifutoCode4(RString.EMPTY);
        } else {
            tempTable.setDtShifutoCode4(entity.getDtシフトコード4());
        }
        if (entity.getDt対象年() == null || entity.getDt対象年().isEmpty()) {
            tempTable.setDtTaisyoYear(RString.EMPTY);
        } else {
            tempTable.setDtTaisyoYear(entity.getDt対象年());
        }
        if (entity.getDt訂正表示() == null || entity.getDt訂正表示().isEmpty()) {
            tempTable.setDtTeiseiHyouji(RString.EMPTY);
        } else {
            tempTable.setDtTeiseiHyouji(entity.getDt訂正表示());
        }
        if (entity.getDt各種区分() == null || entity.getDt各種区分().isEmpty()) {
            tempTable.setDtKakushuKubun(RString.EMPTY);
        } else {
            tempTable.setDtKakushuKubun(entity.getDt各種区分());
        }
        if (entity.getDt処理結果() == null || entity.getDt処理結果().isEmpty()) {
            tempTable.setDtShoriResult(RString.EMPTY);
        } else {
            tempTable.setDtShoriResult(entity.getDt処理結果());
        }
        if (entity.getDt予備3() == null || entity.getDt予備3().isEmpty()) {
            tempTable.setDtYobi3(RString.EMPTY);
        } else {
            tempTable.setDtYobi3(entity.getDt予備3());
        }
        if (entity.getDt予備4() == null || entity.getDt予備4().isEmpty()) {
            tempTable.setDtYobi4(RString.EMPTY);
        } else {
            tempTable.setDtYobi4(entity.getDt予備4());
        }
        if (entity.getDt金額1() == null) {
            tempTable.setDtkinngaku1(Decimal.ZERO);
        } else {
            tempTable.setDtkinngaku1(entity.getDt金額1());
        }
        if (entity.getDt金額予備1() == null) {
            tempTable.setDtKinngakuYobi1(Decimal.ZERO);
        } else {
            tempTable.setDtKinngakuYobi1(entity.getDt金額予備1());
        }
        if (entity.getDt金額予備2() == null) {
            tempTable.setDtKinngakuYobi2(Decimal.ZERO);
        } else {
            tempTable.setDtKinngakuYobi2(entity.getDt金額予備2());
        }
        if (entity.getDt予備5() == null || entity.getDt予備5().isEmpty()) {
            tempTable.setDtYobi5(RString.EMPTY);
        } else {
            tempTable.setDtYobi5(entity.getDt予備5());
        }
        if (entity.getDt共済年金証書記号番号() == null || entity.getDt共済年金証書記号番号().isEmpty()) {
            tempTable.setDtKyousaiNennkinnShoushoKigouNo(RString.EMPTY);
        } else {
            tempTable.setDtKyousaiNennkinnShoushoKigouNo(entity.getDt共済年金証書記号番号());
        }
        if (entity.get被保険者番号() == null || entity.get被保険者番号().isEmpty()) {
            tempTable.setHihokenshaNo(HihokenshaNo.EMPTY);
        } else {
            tempTable.setHihokenshaNo(entity.get被保険者番号());
        }
        if (entity.get識別コード() == null || entity.get識別コード().isEmpty()) {
            tempTable.setShikibetsuCode(ShikibetsuCode.EMPTY);
        } else {
            tempTable.setShikibetsuCode(entity.get識別コード());
        }
        if (entity.get世帯コード() == null || entity.get世帯コード().isEmpty()) {
            tempTable.setShotaiCode(RString.EMPTY);
        } else {
            tempTable.setShotaiCode(entity.get世帯コード());
        }
        if (entity.get宛名カナ氏名() == null || entity.get宛名カナ氏名().isEmpty()) {
            tempTable.setAtenaKanaShimei(RString.EMPTY);
        } else {
            tempTable.setAtenaKanaShimei(entity.get宛名カナ氏名());
        }
        if (entity.get宛名生年月日() == null || entity.get宛名生年月日().isEmpty()) {
            tempTable.setAtenaSeinenngappi(FlexibleDate.EMPTY);
        } else {
            tempTable.setAtenaSeinenngappi(entity.get宛名生年月日());
        }
        if (entity.get宛名性別() == null || entity.get宛名性別().isEmpty()) {
            tempTable.setAtenaSeibetsu(RString.EMPTY);
        } else {
            tempTable.setAtenaSeibetsu(entity.get宛名性別());
        }
        return tempTable;
    }
}
