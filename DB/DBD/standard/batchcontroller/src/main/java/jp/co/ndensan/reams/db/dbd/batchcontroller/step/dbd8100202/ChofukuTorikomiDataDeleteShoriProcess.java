/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202;

import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.TorokuKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100202.ChofukuTorikomiDataDeleteShoriProcessParmeter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.ChofukuTorikomiDataDeleteShoriJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable.HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hikazenenkintaishoshadoutei.IChofukuTorikomiDataDeleteShoriMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 重複取込データ除外処理_process処理クラスです。
 *
 * @reamsid_L DBD-4910-040 x_miaocl
 */
public class ChofukuTorikomiDataDeleteShoriProcess extends BatchProcessBase<ChofukuTorikomiDataDeleteShoriJohoEntity> {

    /**
     * 同定結果区分 "2"
     */
    private static final RString 同定結果区分_2 = new RString("2");
    /**
     * 不一致事由 "1"
     */
    private static final RString 不一致事由_1 = new RString("1");
    private ChofukuTorikomiDataDeleteShoriProcessParmeter parmeter;

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hikazenenkintaishoshadoutei."
                    + "IChofukuTorikomiDataDeleteShoriMapper.get重複取込データ除外処理");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

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
    protected void process(ChofukuTorikomiDataDeleteShoriJohoEntity t) {
        tmpTableWriter.insert(create重複処理(t));
    }

    @Override
    protected void afterExecute() {
        getMapper(IChofukuTorikomiDataDeleteShoriMapper.class).deleteデータを削除処理();
    }

    private HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity create重複処理(ChofukuTorikomiDataDeleteShoriJohoEntity t) {
        HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity data = new HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity();
        data.setDouteiResultKubun(同定結果区分_2);
        data.setFuicchiJiyu(不一致事由_1);
        data.setGaitouJiyu(RString.EMPTY);
        data.setFuicchiItem(RString.EMPTY);
        data.setKisoNennkinnNoHennkou(RString.EMPTY);
        data.setHihokenshaNo(HihokenshaNo.EMPTY);
        data.setAtenaKanaShimei(RString.EMPTY);
        data.setAtenaSeinenngappi(RString.EMPTY);
        data.setAtenaSeibetsu(RString.EMPTY);
        data.setShikibetsuCode(ShikibetsuCode.EMPTY);
        data.setShotaiCode(RString.EMPTY);
        data.setNendo(parmeter.get処理年度());
        data.setShoriKubunn(parmeter.get処理区分());
        data.setTaishoMonth(parmeter.get対象月());
        data.setKisoNennkinnNo(t.get取込_DT基礎年金番号());
        data.setGenKisoNennkinnNo(RString.EMPTY);
        data.setNennkinnCode(t.get取込_DT年金コード());
        data.setTourokuKubunn(TorokuKubun.取込.getコード());
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
