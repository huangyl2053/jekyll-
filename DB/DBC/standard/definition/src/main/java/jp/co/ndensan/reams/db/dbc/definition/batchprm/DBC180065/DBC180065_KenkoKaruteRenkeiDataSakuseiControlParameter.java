/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180065;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 健康かるて連携データ作成のバッチParameterクラスです。
 *
 * @reamsid_L DBC-5020-030 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC180065_KenkoKaruteRenkeiDataSakuseiControlParameter extends BatchParameterBase {

    private static final String DUMMY = "Dummy";

    @BatchParameter(key = DUMMY, name = "Dummy")
    private RString dummy;

    /**
     * コンストラクタです。
     */
    public DBC180065_KenkoKaruteRenkeiDataSakuseiControlParameter() {
        dummy = RString.EMPTY;
    }
}
