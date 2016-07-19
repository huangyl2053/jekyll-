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
 * 認定調査票基本調査調査項目一時テーブルProcessクラスです。
 *
 * @reamsid_L DBE-1500-020 wanghui
 */
public class NinteichosahyoChosaItemSkuseyiProcess extends BatchProcessBase<NinteichosahyoServiceJokyoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinchokudataoutput."
            + "IShinchokuDataOutputMapper.getNinteichosahyoChosa");
    private static final RString 調査調査項目 = new RString("ChosaItemJohoTemp");
    private static final RString 申請書管理番号 = new RString("申請書管理番号");
    private static final RString 厚労省IF識別コード = new RString("厚労省IF識別コード");
    private ShinchokuDataOutputProcessParamter paramter;
    private List<ChosaItemJohoTempTableEntity> 調査調査項目リスト;
    private ChosaItemJohoTempTableEntity temoTableEntity;
    private ShinchokuDataOutputBusiness business;
    private Map<String, RString> map;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 認定調査票基本調査調査項目TempTable;

    @Override
    protected void beforeExecute() {
        調査調査項目リスト = new ArrayList<>();
        business = new ShinchokuDataOutputBusiness();
        map = new HashMap<>();
        map.put(申請書管理番号.toString(), RString.EMPTY);
        map.put(厚労省IF識別コード.toString(), RString.EMPTY);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toShinchokuDataOutputMybitisParamter());
    }

    @Override
    protected void createWriter() {
        認定調査票基本調査調査項目TempTable = new BatchEntityCreatedTempTableWriter(調査調査項目,
                ChosaItemJohoTempTableEntity.class);
    }

    @Override
    protected void process(NinteichosahyoServiceJokyoRelateEntity entity) {
        temoTableEntity = business.get認定調査票基本調査(entity, temoTableEntity, map, 調査調査項目リスト);
    }

    @Override
    protected void afterExecute() {
        for (ChosaItemJohoTempTableEntity entity : 調査調査項目リスト) {
            認定調査票基本調査調査項目TempTable.insert(entity);
        }
    }
}
