/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.ippangenbutsu.JigyoHokokuIppanGenbutsuBusiness;
import jp.co.ndensan.reams.db.dbu.definition.processprm.ippangenbutsu.JigyoHokokuGeppoIppanGenbutsuProcessParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippangenbutsu.JigyouHoukokuTokeiRelateEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippangenbutsu.IJigyoHokokuGeppoIppanGenbutsuMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告統計データ登録のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5540-030 suguangjun
 *
 */
public class JigyoHokokuGeppoDataTorokuProcess extends BatchProcessBase<JigyouHoukokuTokeiRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippangenbutsu."
            + "IJigyoHokokuGeppoIppanGenbutsuMapper.getJigyoHokokuTokei12to14");
    private JigyoHokokuGeppoIppanGenbutsuProcessParamter processParameter;
    private IJigyoHokokuGeppoIppanGenbutsuMapper mapper;
    private JigyoHokokuIppanGenbutsuBusiness business;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7021JigyoHokokuTokeiDataEntity> dbT7021EntityWriter;
    private List<DbT7021JigyoHokokuTokeiDataEntity> dbT7021EntityList;

    @Override
    protected void initialize() {
        business = new JigyoHokokuIppanGenbutsuBusiness(processParameter);
        mapper = getMapper(IJigyoHokokuGeppoIppanGenbutsuMapper.class);
        dbT7021EntityList = mapper.getDbT7021JigyoHokokuTokeiDataEntity(processParameter.to事業報告統計データMybitisParamter());
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
    protected void process(JigyouHoukokuTokeiRelateEntity entity) {
        boolean flg = false;
        boolean flag = false;
        for (DbT7021JigyoHokokuTokeiDataEntity dbT7021Entity : dbT7021EntityList) {
            flg = codeToRString(dbT7021Entity.getShukeiNo()).equals(entity.getShukeiNum())
                    && dbT7021Entity.getTateNo().equals(entity.getTateNo())
                    && dbT7021Entity.getYokoNo().equals(entity.getYokoNo());
            if (flg) {
                dbT7021Entity = business.set事業報告統計データEntity(entity);
                dbT7021EntityWriter.update(dbT7021Entity);
                flag = true;
            }
        }
        if (!flg && !flag) {
            DbT7021JigyoHokokuTokeiDataEntity dbT7021Entity = business.set事業報告統計データEntity(entity);
            dbT7021Entity.setShukeiTani(new Code("1"));
            dbT7021Entity.setShukeiKomokuMeisho(RString.EMPTY);
            dbT7021Entity.setTateKomokuCode(Code.EMPTY);
            dbT7021Entity.setYokoKomokuCode(Code.EMPTY);
            dbT7021EntityWriter.insert(dbT7021Entity);
        }
    }

    @Override
    protected void afterExecute() {
        mapper.insertShoriDateKanri(processParameter.toInsertDataMybitisParamter());
    }

    private RString codeToRString(Code date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.value();
    }
}
