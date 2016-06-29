/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.yokaigoninteijohoteikyo;

import jp.co.ndensan.reams.db.dbe.definition.processprm.yokaigoninteijohoteikyo.YokaigoBatchProcessParamter;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo.IYokaigoNinteiJohoTeikyoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請情報への更新処理のクラスです。
 *
 * @reamsid_L DBE-0230-030 zhangzhiming
 */
public class UpdateDataProcess extends BatchProcessBase<RString> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.IDbT5301ShujiiIkenshoIraiJohoMapper."
            + "getListForProcess");
    private YokaigoBatchProcessParamter processParameter;
    private IYokaigoNinteiJohoTeikyoMapper mapper;

    @Override
    protected void initialize() {
        mapper = getMapper(IYokaigoNinteiJohoTeikyoMapper.class);
    }

    @Override
    protected void process(RString item) {

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void afterExecute() {
        mapper.update要介護認定申請(processParameter.toYokaigoBatchMybitisParamter());
    }
}
