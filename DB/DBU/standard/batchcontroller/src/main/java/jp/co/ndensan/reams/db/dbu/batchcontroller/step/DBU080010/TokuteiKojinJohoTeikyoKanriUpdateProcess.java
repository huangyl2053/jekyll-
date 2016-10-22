/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010;

import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoKanriUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbu.service.core.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoManager;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定個人情報版管理の更新バッチ処理です。
 *
 * @reamsid_L DBU-4880-090 wangxiaodong
 */
public class TokuteiKojinJohoTeikyoKanriUpdateProcess extends SimpleBatchProcessBase {

    private static final RString 転義符 = new RString("\"");
    private TokuteiKojinJohoTeikyoKanriUpdateProcessParameter processParameter;

    @Override
    protected void process() {
        TokuteiKojinJohoTeikyoManager.createInstance().update特定個人情報提供(
                転義符.concat(processParameter.get中間テーブル名()).concat(転義符),
                processParameter.get新規異動区分(),
                processParameter.get特定個人情報名コード(),
                processParameter.getデータセット番号(),
                processParameter.get版番号());
    }
}
