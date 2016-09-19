/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010050;

import jp.co.ndensan.reams.db.dbu.definition.processprm.ippanshokanketteiym.JigyoHokokuGeppoIppanShokanProcessParamter;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippanshokanketteiym.IJigyoHokokuGeppoIppanShokanMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * temp事業報告償還分決定年月統計元データのバッチ処理クラスです。
 *
 * @reamsid_L DBU-5550-030 suguangjun
 *
 */
public class JigyoHokokuKetteiYMTokeiMotoDataProcess extends BatchProcessBase<DbT5912ShujiiJohoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippanshokanketteiym."
            + "IJigyoHokokuGeppoIppanShokanMapper.selectShujiiJohoList");
    private JigyoHokokuGeppoIppanShokanProcessParamter processParameter;
    private IJigyoHokokuGeppoIppanShokanMapper mapper;

    @Override
    protected void initialize() {
        mapper = getMapper(IJigyoHokokuGeppoIppanShokanMapper.class);
        mapper.insertShokanServiceData(processParameter.toDataMybitisParamter());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(DbT5912ShujiiJohoEntity entity) {
    }
}
