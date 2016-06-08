/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako;

import jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunka6gatsutsuchishoikkatsuhakko.TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 「賦課情報取得」処理の「仮算定額変更情報一時テーブルの更新」です。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
public class KarisanteigakuTempTblUpdateProcess extends SimpleBatchProcessBase {

    @Override
    protected void process() {
        TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko service = TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko.createInstance();
        service.update前年度特徴期別金額06();
        service.update継続の被保険者区分();
        service.update4月開始の被保険者区分();
        service.update6月開始の被保険者区分();
    }

}
