/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120040;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kyodojukyushainsub.KyufuJissekiInProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計書_DBCMNF2002-5C3、5D3、5E3_共同処理用受給者情報更新結果情報取込Parameterクラスです。
 *
 * @reamsid_L DBC-2780-011 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC120040_KyodoJukyushaKoshinKekkaInParameter extends BatchParameterBase {

    private static final String SYORINENGETU = "syorinengetu";
    private static final String SAYISYORIKUBUN = "sayisyorikubun";
    private static final String OUTPUTORDERID = "outputorderid";

    @BatchParameter(key = SYORINENGETU, name = "処理年月")
    private FlexibleYearMonth 処理年月;
    @BatchParameter(key = SAYISYORIKUBUN, name = "再処理区分")
    private RString 再処理区分;
    @BatchParameter(key = OUTPUTORDERID, name = "出力順ID")
    private RString 出力順ID;

    @BatchParameter(key = "loginUserId", name = "loginUserId")
    private RString loginUserId;

    /**
     * CreateTmptableProcessパラメータの取得です。
     *
     * @param 保存先フォルダ 保存先フォルダ
     * @param csvファイル名 csvファイル名
     * @return CreateTmptableProcessパラメータ
     */
    public KyufuJissekiInProcessParameter toKyufuJissekiInProcessParameter(RString 保存先フォルダ, RString csvファイル名) {
        return new KyufuJissekiInProcessParameter(保存先フォルダ, csvファイル名, 出力順ID);
    }
}
