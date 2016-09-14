/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010050;

import jp.co.ndensan.reams.db.dbu.definition.processprm.ippanshokanketteiym.JigyoHokokuGeppoIppanShokanProcessParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippanshokanketteiym.JigyouHoukokuTokeiRelateEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippanshokanketteiym.IJigyoHokokuGeppoIppanShokanMapper;
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
 * @reamsid_L DBU-5550-030 suguangjun
 *
 */
public class JigyoHokokuGeppoIppanShokanTorokuProcess extends BatchProcessBase<JigyouHoukokuTokeiRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyojokyohokokushiryonemposakuseiiti."
            + "IJigyoHokokuGeppoIppanShokanMapper.getJyukyushaJigyouHoukokuTokei");
    private JigyoHokokuGeppoIppanShokanProcessParamter processParameter;
    private IJigyoHokokuGeppoIppanShokanMapper mapper;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7021JigyoHokokuTokeiDataEntity> dbT7021EntityWriter;
    private static final int INDEX_4 = 4;
    private static final int INDEX_6 = 6;

    @Override
    protected void initialize() {
        mapper = getMapper(IJigyoHokokuGeppoIppanShokanMapper.class);
        mapper.deleteJigyouHoukokuTokei(processParameter.tocreateDelete事業報告統計データParam());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.tocreateSelect事業報告統計データParam());
    }

    @Override
    protected void createWriter() {
        dbT7021EntityWriter = new BatchPermanentTableWriter(DbT7021JigyoHokokuTokeiDataEntity.class);
    }

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected void process(JigyouHoukokuTokeiRelateEntity entity) {
        DbT7021JigyoHokokuTokeiDataEntity dbT7021Entity = new DbT7021JigyoHokokuTokeiDataEntity();
        dbT7021Entity.setHokokuYSeireki(new FlexibleYear(processParameter.get報告年月().substring(0, INDEX_4)));
        dbT7021Entity.setHokokuM(processParameter.get報告年月().substring(INDEX_4, INDEX_6));
        dbT7021Entity.setShukeiTaishoYSeireki(new FlexibleYear(processParameter.get年度()));
        dbT7021Entity.setShukeiTaishoM(processParameter.get決定年月().substring(INDEX_4, INDEX_6));
        dbT7021Entity.setToukeiTaishoKubun(entity.getToukeiTaishoKubun());
        dbT7021Entity.setShichosonCode(entity.getShichosonCode());
        dbT7021Entity.setHyoNo(entity.getHyoNo());
        dbT7021Entity.setShukeiNo(entity.getShukeiNo());
        dbT7021Entity.setShukeiTani(entity.getShukeiTani());
        dbT7021Entity.setTateNo(entity.getTateNo());
        dbT7021Entity.setYokoNo(entity.getYokoNo());
        dbT7021Entity.setShukeiKekkaAtai(entity.getShukeiKekkaAtai());
        dbT7021Entity.setTateKomokuCode(Code.EMPTY);
        dbT7021Entity.setYokoKomokuCode(Code.EMPTY);
        dbT7021EntityWriter.insert(dbT7021Entity);
    }

    @Override
    protected void afterExecute() {
        mapper.updateShoriDateKanri(processParameter.tocreate処理日付管理マスタParam());
    }
}
