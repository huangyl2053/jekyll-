/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010100;

import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppohokenkyufukogakugassan.JigyoHokokuGeppoHokenkyufuKogakuGassanProcessParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohokenkyufukogakugassan.JigyoJoukyouHoukokuDataRelateEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppohokenkyufukogakugassan.IJigyoHokokuGeppoHokenkyufuKogakuGassanMapper;
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
 * @reamsid_L DBU-5590-030 zhangzhiming
 */
public class JigyoHokokuDataTorokuProcess extends BatchProcessBase<JigyoJoukyouHoukokuDataRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppohokenkyufukogakugassan."
            + "IJigyoHokokuGeppoHokenkyufuKogakuGassanMapper.getJigyoHokokuDataToroku");
    private JigyoHokokuGeppoHokenkyufuKogakuGassanProcessParamter processParameter;
    private IJigyoHokokuGeppoHokenkyufuKogakuGassanMapper mapper;
    private static final RString 区分_1 = new RString("1");
    private static final RString 年報月 = new RString("99");
    private static final int 連番_4 = 4;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7021JigyoHokokuTokeiDataEntity> dbT7021EntityWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IJigyoHokokuGeppoHokenkyufuKogakuGassanMapper.class);
        mapper.deleteJigyoHokokuDataToroku(processParameter.toDeleteDataMybitisParamter());
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
    protected void process(JigyoJoukyouHoukokuDataRelateEntity entity) {
        DbT7021JigyoHokokuTokeiDataEntity dbT7021Entity = new DbT7021JigyoHokokuTokeiDataEntity();
        if (区分_1.equals(processParameter.get報告区分())) {
            dbT7021Entity.setHokokuYSeireki(new FlexibleYear(processParameter.get報告年月().substring(0, 連番_4)));
            dbT7021Entity.setHokokuM(processParameter.get報告年月().substring(連番_4));
            dbT7021Entity.setShukeiTaishoYSeireki(new FlexibleYear(processParameter.get年度().substring(0, 連番_4)));
            dbT7021Entity.setShukeiTaishoM(processParameter.get決定年月().substring(連番_4));
        } else {
            dbT7021Entity.setHokokuYSeireki(new FlexibleYear(processParameter.get報告年度().substring(0, 連番_4)));
            dbT7021Entity.setHokokuM(年報月);
            dbT7021Entity.setShukeiTaishoYSeireki(new FlexibleYear(processParameter.get集計年度().substring(0, 連番_4)));
            dbT7021Entity.setShukeiTaishoM(年報月);
        }
        dbT7021Entity.setToukeiTaishoKubun(entity.getToukeiTaishoKubun());
        dbT7021Entity.setShichosonCode(entity.getShichosonCode());
        dbT7021Entity.setHyoNo(entity.getHyoNo());
        dbT7021Entity.setShukeiNo(entity.getSyukeiNo());
        dbT7021Entity.setShukeiTani(entity.getSyukeiTani());
        dbT7021Entity.setTateNo(entity.getTateNo());
        dbT7021Entity.setYokoNo(entity.getYokoNo());
        dbT7021Entity.setShukeiKekkaAtai(entity.getSukeiKekkaAtai() == null ? Decimal.ZERO : entity.getSukeiKekkaAtai());
        dbT7021Entity.setShukeiKomokuMeisho(RString.EMPTY);
        dbT7021Entity.setTateKomokuCode(Code.EMPTY);
        dbT7021Entity.setYokoKomokuCode(Code.EMPTY);
        dbT7021EntityWriter.insert(dbT7021Entity);
    }

    @Override
    protected void afterExecute() {
        mapper.insertShoriDateKanri(processParameter.toInsertShoriDataMybitisParamter());
    }
}
