/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd492001;

import jp.co.ndensan.reams.db.dbd.business.core.dbd492001.NinteiKekkaRenkeiDataTorikomi;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.OutFile;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.OutFilekekka;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 出力ファイルのデータの編集クラスです．
 *
 * @reamsid_L DBD-1510-030 x_xuliang
 */
public class NinteiKekkaRenkeiDataTorikomiManager {

    /**
     * NinteiKekkaRenkeiDataTorikomiManagerのインスタンス化
     *
     * @return NinteiKekkaRenkeiDataTorikomiManager
     */
    public static NinteiKekkaRenkeiDataTorikomiManager createInstance() {
        return InstanceProvider.create(NinteiKekkaRenkeiDataTorikomiManager.class);
    }

    /**
     * 項目設定
     *
     * @param t t
     * @param out out
     */
    public void 項目設定(OutFile t, OutFilekekka out) {
        NinteiKekkaRenkeiDataTorikomi but = new NinteiKekkaRenkeiDataTorikomi();
        but.ninteiKekkaRenkeiDataTorikomiBusiness(t, out);
    }

}
