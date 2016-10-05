/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010090;

import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppohokenkyufukogaku.JigyoHokokuGeppoHokenkyufuKogakuProcessParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppohokenkyufukogaku.IJigyoHokokuGeppoHokenkyufuKogakuMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業状況報告統計元データ作成のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5580-030 zhangzhiming
 */
public class JigyoHokokuDataSakuSeiProcess extends BatchProcessBase<DbT7021JigyoHokokuTokeiDataEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppohokenkyufukogaku."
            + "IJigyoHokokuGeppoHokenkyufuKogakuMapper.selectAll");
    private JigyoHokokuGeppoHokenkyufuKogakuProcessParamter processParameter;
    private IJigyoHokokuGeppoHokenkyufuKogakuMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IJigyoHokokuGeppoHokenkyufuKogakuMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(DbT7021JigyoHokokuTokeiDataEntity t) {
    }

    @Override
    protected void afterExecute() {
        mapper.insertKougakuData(processParameter.toInsertKougakuDataMybitisParamter());
    }
}
