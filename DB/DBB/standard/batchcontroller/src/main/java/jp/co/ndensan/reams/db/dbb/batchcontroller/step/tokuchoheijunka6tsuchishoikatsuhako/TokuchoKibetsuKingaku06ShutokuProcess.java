/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako;

import jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunka6gatsutsuchishoikkatsuhakko.TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「賦課情報取得」処理の「前年度特徴期別金額06を取得」です。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
public class TokuchoKibetsuKingaku06ShutokuProcess extends SimpleBatchProcessBase {

    /**
     * OutputParameter用キー systemTime
     */
    public static final RString TOKUCHOKIBETSU_KINGAKU06;

    private OutputParameter<RString> tokuchoKibetsuKingaku06;
    RString 前年度特徴期別金額06;

    static {
        TOKUCHOKIBETSU_KINGAKU06 = new RString("tokuchoKibetsuKingaku06");
    }

    @Override
    protected void beforeExecute() {
        tokuchoKibetsuKingaku06 = new OutputParameter<>();
    }

    @Override
    protected void process() {
        TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko service = TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko.createInstance();
        前年度特徴期別金額06 = service.get前年度特徴期別金額06();
    }

    @Override
    protected void afterExecute() {
        tokuchoKibetsuKingaku06.setValue(前年度特徴期別金額06);
    }

}
