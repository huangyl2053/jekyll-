/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hokensha;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;

/**
 * {@link IHokensha IHokensha}を生成します。
 *
 * @author N3327 三浦 凌
 */
public final class HokenshaFactory {

    private HokenshaFactory() {
    }

    /**
     * 引数から{@link IHokensha IHokensha}を生成します。
     *
     * @param hokenshaNo 証記載保険者番号
     * @param jusho 住所
     * @param yubinNo 電話番号
     * @param telNo 電話番号
     * @return {@link IHokensha IHokensha}
     */
    public static IHokensha createInstance(ShoKisaiHokenshaNo hokenshaNo, AtenaJusho jusho, YubinNo yubinNo, TelNo telNo) {
        return new _Hokensha(hokenshaNo, jusho, yubinNo, telNo);
    }
}
