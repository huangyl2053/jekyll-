/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako;

import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako.TokuchoHeijunka6gatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunka6gatsutsuchishoikkatsuhakko.TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「賦課情報取得」処理の「前年度・特徴期別金額06を更新する」処理です。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
public class TokuchoKibetsuKingaku06UpdateProcess extends SimpleBatchProcessBase {

    @Override
    protected void process() {
        TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko service = TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko.createInstance();
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        IKozaSearchKey key = builder.build();
        RString 徴収方法 = ChoshuHohoKibetsu.特別徴収.getコード();
        service.update前年度特徴期別金額06(new TokuchoHeijunka6gatsuMyBatisParameter(
                false, null, null, null, null, 徴収方法, null, null, null, key));
    }

}
