/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010050;

import jp.co.ndensan.reams.db.dbu.definition.processprm.ippanshokanketteiym.JigyoHokokuGeppoIppanShokanProcessParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippanshokanketteiym.JyukyushaJohoKonkyoCSVRelateEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippanshokanketteiym.IJigyoHokokuGeppoIppanShokanMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;

/**
 * temp事業報告償還分決定年月統計元データのバッチ処理クラスです。
 *
 * @reamsid_L DBU-5550-030 suguangjun
 *
 */
public class JigyoHokokuKetteiYMTokeiMotoDataProcess extends BatchProcessBase<JyukyushaJohoKonkyoCSVRelateEntity> {

    private JigyoHokokuGeppoIppanShokanProcessParamter processParameter;
    private IJigyoHokokuGeppoIppanShokanMapper mapper;

    @Override
    protected void initialize() {
        mapper = getMapper(IJigyoHokokuGeppoIppanShokanMapper.class);
        mapper.insertShokanServiceData(processParameter.toDataMybitisParamter());
    }

    @Override
    protected IBatchReader createReader() {
        return null;
    }

    @Override
    protected void createWriter() {
    }

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected void process(JyukyushaJohoKonkyoCSVRelateEntity entity) {
    }

    @Override
    protected void afterExecute() {
    }
}
