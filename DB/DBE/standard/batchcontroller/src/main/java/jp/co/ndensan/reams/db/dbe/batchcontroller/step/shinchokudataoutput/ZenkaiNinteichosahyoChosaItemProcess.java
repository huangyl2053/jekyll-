/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinchokudataoutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.shinchokudataoutput.shickdateoutput.ShinchokuDataOutputBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinchokudataoutput.ShinchokuDataOutputProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niinteichosajoho.ChosaItemJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niinteichosajoho.NinteichosahyoServiceJokyoRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 前回認定調査票（基本調査）調査項目一時テーブルProcessクラスです。
 *
 * @reamsid_L DBE-1500-020 wanghui
 */
public class ZenkaiNinteichosahyoChosaItemProcess extends BatchProcessBase<NinteichosahyoServiceJokyoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinchokudataoutput."
            + "IShinchokuDataOutputMapper.get前回認定調査票基本調査調査項目");
    private static final RString 前回認定調査票 = new RString("ZenkaiChosaItemJohoTemp");
    private ShinchokuDataOutputProcessParamter paramter;
    private List<ChosaItemJohoTempTableEntity> サービスの状況一時リスト;
    private ChosaItemJohoTempTableEntity temoTableEntity;
    private ShinchokuDataOutputBusiness business;
    private Map<String, RString> map;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 前回調査票概況調査調査調査項目TempTable;

    @Override
    protected void beforeExecute() {
        サービスの状況一時リスト = new ArrayList<>();
        business = new ShinchokuDataOutputBusiness();
        map = new HashMap<>();
        map.put("申請書管理番号", RString.EMPTY);
        map.put("厚労省IF識別コード", RString.EMPTY);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toShinchokuDataOutputMybitisParamter());
    }

    @Override
    protected void createWriter() {
        前回調査票概況調査調査調査項目TempTable = new BatchEntityCreatedTempTableWriter(前回認定調査票,
                ChosaItemJohoTempTableEntity.class);
    }

    @Override
    protected void process(NinteichosahyoServiceJokyoRelateEntity entity) {
        temoTableEntity = business.get認定調査票基本調査(entity, temoTableEntity, map, サービスの状況一時リスト);
    }

    @Override
    protected void afterExecute() {
        for (ChosaItemJohoTempTableEntity entity : サービスの状況一時リスト) {
            前回調査票概況調査調査調査項目TempTable.insert(entity);
        }
    }
}
