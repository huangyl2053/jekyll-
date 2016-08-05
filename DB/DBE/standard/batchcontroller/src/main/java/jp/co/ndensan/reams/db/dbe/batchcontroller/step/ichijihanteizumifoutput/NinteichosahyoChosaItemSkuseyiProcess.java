/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ichijihanteizumifoutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteizumifoutput.ichijihanteizumi.IchijiHanteizumIfOutputBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.itizihanteishori.ItziHanteiShoriProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niinteichosajoho.NinteichosahyoServiceJokyoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niinteichosajoho.ZenKaiChosaItemJohoTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査票基本調査調査項目一時テーブルProcessクラスです。
 *
 * @reamsid_L DBE-1470-021 wanghui
 */
public class NinteichosahyoChosaItemSkuseyiProcess extends BatchProcessBase<NinteichosahyoServiceJokyoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ichijihanteizumifoutput."
            + "IchijiHanteizumIfOutputMapper.getNinteichosahyoChosa");
    private static final RString 調査調査項目 = new RString("ChosaItemJohoTemp");
    private static final RString 申請書管理番号 = new RString("申請書管理番号");
    private static final RString 厚労省IF識別コード = new RString("厚労省IF識別コード");
    private ItziHanteiShoriProcessParamter paramter;
    private List<ZenKaiChosaItemJohoTempTableEntity> 調査調査項目リスト;
    private ZenKaiChosaItemJohoTempTableEntity temoTableEntity;
    private IchijiHanteizumIfOutputBusiness business;
    private Map<RString, RString> map;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 認定調査票基本調査調査項目TempTable;

    @Override
    protected void beforeExecute() {
        調査調査項目リスト = new ArrayList<>();
        business = new IchijiHanteizumIfOutputBusiness();
        map = new HashMap<>();
        map.put(申請書管理番号, RString.EMPTY);
        map.put(厚労省IF識別コード, RString.EMPTY);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toItziHanteiShoriMybitisParamter());
    }

    @Override
    protected void createWriter() {
        認定調査票基本調査調査項目TempTable = new BatchEntityCreatedTempTableWriter(調査調査項目,
                ZenKaiChosaItemJohoTempTableEntity.class);
    }

    @Override
    protected void process(NinteichosahyoServiceJokyoRelateEntity entity) {
        temoTableEntity = business.get前回認定調査票基本調査(entity, temoTableEntity, map, 調査調査項目リスト);
    }

    @Override
    protected void afterExecute() {
        for (ZenKaiChosaItemJohoTempTableEntity entity : 調査調査項目リスト) {
            認定調査票基本調査調査項目TempTable.insert(entity);
        }
    }
}
