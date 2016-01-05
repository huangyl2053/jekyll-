/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.idochecklist;

import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;

/**
 *
 * 処理日付管理マスタを更新のプロセスグラス
 */
public class UpdaShoriDateKanriProcess extends BatchProcessBase<Object> {

    @Override
    protected IBatchReader createReader() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void process(Object t) {
    }

    @Override
    protected void afterExecute() {
    }

}
