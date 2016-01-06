/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe223001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe223001.UpdateProcessParameter;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.IDbT5201NinteichosaIraiJohoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査依頼情報テーブルの更新処理のクラスです。
 */
public class UpadteDataProcess extends SimpleBatchProcessBase {

    private UpdateProcessParameter processParameter;
    private IDbT5201NinteichosaIraiJohoMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IDbT5201NinteichosaIraiJohoMapper.class);

    }

    @Override
    protected void process() {

        List<RString> noList = processParameter.get申請書管理番号List();
        for (RString shinseishoKanriNo : noList) {
            mapper.update認定調査依頼情報BY申請書管理番号(processParameter.toNinteiChosaTokusokujoMybatisParameter(shinseishoKanriNo));
        }
    }

}
