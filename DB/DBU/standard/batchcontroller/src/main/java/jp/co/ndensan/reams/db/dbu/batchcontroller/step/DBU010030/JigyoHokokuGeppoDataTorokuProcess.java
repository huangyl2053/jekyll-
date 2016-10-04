/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030;

import jp.co.ndensan.reams.db.dbu.definition.processprm.ippangenbutsu.JigyoHokokuGeppoIppanGenbutsuProcessParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippangenbutsu.KyufuJissekiKonkyoRelateEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippangenbutsu.IJigyoHokokuGeppoIppanGenbutsuMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業報告統計データ登録のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5540-030 suguangjun
 *
 */
public class JigyoHokokuGeppoDataTorokuProcess extends BatchProcessBase<KyufuJissekiKonkyoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippangenbutsu."
            + "IJigyoHokokuGeppoIppanGenbutsuMapper.getJigyoHokokuTokei12to14");
    private JigyoHokokuGeppoIppanGenbutsuProcessParamter processParameter;
    private IJigyoHokokuGeppoIppanGenbutsuMapper mapper;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7021JigyoHokokuTokeiDataEntity> dbT7021EntityWriter;
    private final int index_4 = 4;

    @Override
    protected void initialize() {
        mapper = getMapper(IJigyoHokokuGeppoIppanGenbutsuMapper.class);
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
    protected void process(KyufuJissekiKonkyoRelateEntity entity) {
        DbT7021JigyoHokokuTokeiDataEntity dbT7021Entity = new DbT7021JigyoHokokuTokeiDataEntity();
        if (processParameter.get報告年月() != null) {
            dbT7021Entity.setHokokuYSeireki(new FlexibleYear(processParameter.get報告年月().substring(0, index_4)));
            dbT7021Entity.setHokokuM(processParameter.get報告年月().substring(index_4));
        }
        if (processParameter.get集計年月() != null) {
            dbT7021Entity.setShukeiTaishoYSeireki(new FlexibleYear(processParameter.get集計年月().substring(0, index_4)));
            dbT7021Entity.setShukeiTaishoM(processParameter.get集計年月().substring(index_4));
        }
//        dbT7021Entity.setToukeiTaishoKubun(processParameter.get統計対象区分());
//        dbT7021Entity.setShichosonCode(new LasdecCode(processParameter.get市町村コード()));
//        if (new RString("1").equals(processParameter.get給付実績区分コード())) {
//            dbT7021Entity.setHyoNo(new Code("01"));
//        } else if (new RString("2").equals(processParameter.get給付実績区分コード())) {
//            dbT7021Entity.setHyoNo(new Code("03"));
//        }
        dbT7021Entity.setShukeiNo(new Code(entity.getShukeiNo()));
        dbT7021Entity.setShukeiTani(new Code("1"));
        dbT7021Entity.setTateNo(rstringToDecimal(entity.getTateNo()));
        dbT7021Entity.setYokoNo(rstringToDecimal(entity.getYokoNo()));
        dbT7021Entity.setShukeiKomokuMeisho(RString.EMPTY);
        dbT7021Entity.setShukeiKekkaAtai(entity.getResult());
        dbT7021Entity.setTateKomokuCode(Code.EMPTY);
        dbT7021Entity.setYokoKomokuCode(Code.EMPTY);
        dbT7021EntityWriter.insert(dbT7021Entity);
    }

    @Override
    protected void afterExecute() {
        mapper.insertShoriDateKanri(processParameter.toInsertDataMybitisParamter());
    }

    private Decimal rstringToDecimal(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return Decimal.ZERO;
        }
        return new Decimal(date.toString());
    }
}
