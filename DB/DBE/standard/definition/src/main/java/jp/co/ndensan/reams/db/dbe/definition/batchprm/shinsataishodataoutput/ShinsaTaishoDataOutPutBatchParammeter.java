/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.shinsataishodataoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsataishodataoutput.ShinsaTaishoDataOutPutProcessParammeter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定審査依頼IF作成（モバイル）ですためのバッチ用パラメータクラスです。
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShinsaTaishoDataOutPutBatchParammeter extends BatchParameterBase {

    private static final String KEY_KAISAIBANGOU = "kaisaiBangou";

    @BatchParameter(key = KEY_KAISAIBANGOU, name = "開催番号")
    private RString kaisaiBangou;

    /**
     * バーチのパラメータを作成します。
     *
     * @return ShinsaTaishoDataOutProcessParammeter
     */
    public ShinsaTaishoDataOutPutProcessParammeter toShinsaTaishoDataOutProcessParammeter() {
        return new ShinsaTaishoDataOutPutProcessParammeter(kaisaiBangou);
    }
}
