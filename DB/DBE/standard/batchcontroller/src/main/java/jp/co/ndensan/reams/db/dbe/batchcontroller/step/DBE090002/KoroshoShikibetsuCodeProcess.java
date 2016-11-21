/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.yokaigoninteijohoteikyo.YokaigoBatchProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.YokaigoninteiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 厚労省IF識別コードの作成クラスです。
 *
 * @reamsid_L DBE-0230-030 zhangzhiming
 */
public class KoroshoShikibetsuCodeProcess extends BatchProcessBase<YokaigoninteiEntity> {

    /**
     * OUT_DATA_LISTです。
     */
    public static final RString OUT_DATA_LIST;
    private YokaigoBatchProcessParamter processPrm;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo."
            + "IYokaigoNinteiJohoTeikyoMapper.get要介護認定申請者");

    static {
        OUT_DATA_LIST = new RString("outDataList");
    }
    private OutputParameter<List<RString>> outDataList;
    private List<RString> shinseishoKanriNoList;

    @Override
    protected void initialize() {
        outDataList = new OutputParameter<>();
        shinseishoKanriNoList = new ArrayList<>();
        super.initialize();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processPrm.toYokaigoBatchMybitisParamter());
    }

    @Override
    protected void process(YokaigoninteiEntity entity) {
        shinseishoKanriNoList.add(entity.get厚労省IF識別コード());
    }

    @Override
    protected void afterExecute() {
        outDataList.setValue(shinseishoKanriNoList);
    }
}
