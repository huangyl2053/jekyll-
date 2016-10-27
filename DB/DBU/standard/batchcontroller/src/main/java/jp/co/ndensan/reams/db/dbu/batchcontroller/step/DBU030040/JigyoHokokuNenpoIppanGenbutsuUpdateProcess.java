/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030040;

import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokunenpoippangenbutsu.JigyoHokokuNenpoIppanGenbutsuProcessParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoippangenbutsu.GassanJigyouHoukokuTokeiEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokunenpoippangenbutsu.IJigyoHokokuNenpoIppanGenbutsuMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告統計データ登録のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5600-040 lishengli
 */
public class JigyoHokokuNenpoIppanGenbutsuUpdateProcess extends BatchProcessBase<GassanJigyouHoukokuTokeiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokunenpoippangenbutsu."
            + "IJigyoHokokuNenpoIppanGenbutsuMapper.getJigyouHokokuTokeiJyoho");
    private JigyoHokokuNenpoIppanGenbutsuProcessParamter processParameter;
    private IJigyoHokokuNenpoIppanGenbutsuMapper mapper;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7021JigyoHokokuTokeiDataEntity> dbT7021EntityWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IJigyoHokokuNenpoIppanGenbutsuMapper.class);
        mapper.deleteJigyouHokokuTokei(processParameter.toDeleteDataMybitisParamter());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toSelectDataMybitisParamter());
    }

    @Override
    protected void createWriter() {
        dbT7021EntityWriter = new BatchPermanentTableWriter(DbT7021JigyoHokokuTokeiDataEntity.class);
    }

    @Override
    protected void process(GassanJigyouHoukokuTokeiEntity entity) {
        DbT7021JigyoHokokuTokeiDataEntity dbT7021Entity = new DbT7021JigyoHokokuTokeiDataEntity();
        dbT7021Entity.setHokokuYSeireki(new FlexibleYear(processParameter.get報告年度()));
        dbT7021Entity.setHokokuM(new RString("99"));
        dbT7021Entity.setShukeiTaishoYSeireki(new FlexibleYear(processParameter.get集計年度()));
        dbT7021Entity.setShukeiTaishoM(new RString("99"));
        dbT7021Entity.setToukeiTaishoKubun(entity.getToukeiTaishoKubun());
        dbT7021Entity.setShichosonCode(entity.getShichosonCode());
        dbT7021Entity.setHyoNo(entity.getHyoNo());
        dbT7021Entity.setShukeiNo(entity.getSyukeiNo());
        dbT7021Entity.setShukeiTani(entity.getSyukeiTani());
        dbT7021Entity.setTateNo(entity.getTateNo());
        dbT7021Entity.setYokoNo(entity.getYokoNo());
        dbT7021Entity.setShukeiKekkaAtai(entity.getSukeiKekkaAtai());
        dbT7021Entity.setShukeiKomokuMeisho(RString.EMPTY);
        dbT7021Entity.setTateKomokuCode(Code.EMPTY);
        dbT7021Entity.setYokoKomokuCode(Code.EMPTY);
        dbT7021EntityWriter.insert(dbT7021Entity);
    }

    @Override
    protected void afterExecute() {
        mapper.insertShoriDateKanri(processParameter.toInsertDataMybitisParamter());
    }
}
