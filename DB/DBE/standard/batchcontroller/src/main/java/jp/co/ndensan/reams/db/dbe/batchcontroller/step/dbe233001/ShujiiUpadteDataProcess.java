/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe233001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe233001.ShujiiUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.IDbT5301ShujiiIkenshoIraiJohoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書督促状情報テーブルの更新処理のクラスです。
 */
public class ShujiiUpadteDataProcess extends BatchProcessBase<RString> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.IDbT5301ShujiiIkenshoIraiJohoMapper."
            + "getListForProcess");
    private ShujiiUpdateProcessParameter processParameter;
    private IDbT5301ShujiiIkenshoIraiJohoMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IDbT5301ShujiiIkenshoIraiJohoMapper.class);

    }

    @Override
    protected void process(RString item) {

        List<RString> noList = processParameter.get申請書管理番号List();
        for (RString shinseishoKanriNo : noList) {
            mapper.update主治医意見書依頼情報BY申請書管理番号(processParameter.toShujiiUpdateMybatisParameter(shinseishoKanriNo));
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }
}
