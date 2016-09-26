/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.yokaigoninteijohoteikyo.YokaigoBatchProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.NinteichosaRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特記事項テキスト・イメージ区分の作成クラスです。
 *
 * @reamsid_L DBE-0230-030 zhangzhiming
 */
public class NinteichosaProcess extends BatchProcessBase<NinteichosaRelateEntity> {

    /**
     * OUT_DATA_LISTです。
     */
    public static final RString OUT_DATA_LIST;
    private YokaigoBatchProcessParamter processPrm;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo."
            + "IYokaigoNinteiJohoTeikyoMapper.get特記事項区分");

    static {
        OUT_DATA_LIST = new RString("outDataList");
    }
    private OutputParameter<List<RString>> outDataList;
    private List<RString> shinseishoKanriNoList;

    @Override
    protected void initialize() {
        outDataList = new OutputParameter<>();
        shinseishoKanriNoList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processPrm.toYokaigoBatchMybitisParamter());
    }

    @Override
    protected void process(NinteichosaRelateEntity entity) {
        shinseishoKanriNoList.add(entity.get特記事項区分());
    }

    @Override
    protected void afterExecute() {
        outDataList.setValue(shinseishoKanriNoList);
    }
}
