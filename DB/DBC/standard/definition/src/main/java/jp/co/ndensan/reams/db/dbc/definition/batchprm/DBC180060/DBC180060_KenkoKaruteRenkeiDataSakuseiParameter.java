/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180060;

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
public class DBC180060_KenkoKaruteRenkeiDataSakuseiParameter extends BatchParameterBase {

    private static final String BATCHID = "KenkoKaruteRenkeiDataSakusei";

    @BatchParameter(key = BATCHID, name = "バッチID")
    private RString batchID;

    /**
     * コンストラクタです。
     */
    public DBC180060_KenkoKaruteRenkeiDataSakuseiParameter() {
        batchID = new RString("DBC180060_KenkoKaruteRenkeiDataSakusei");
    }
}
