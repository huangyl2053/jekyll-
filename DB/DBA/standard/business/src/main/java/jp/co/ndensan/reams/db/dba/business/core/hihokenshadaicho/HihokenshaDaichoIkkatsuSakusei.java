/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokenshadaicho;

import jp.co.ndensan.reams.db.dba.definition.batchprm.hihokenshadaicho.IkkatsuSakuseiBatchParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 画面から入力するデータより、バッチ用パラメータクラスを作成するクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class HihokenshaDaichoIkkatsuSakusei {

    private final boolean 資格喪失者抽出フラグ;
    private final boolean 出力フラグ;
    private final RString 出力順ID;

    /**
     * コンストラクタです。<br/>
     *
     * @param 資格喪失者抽出フラグ 資格喪失者抽出フラグ
     * @param 出力フラグ 出力フラグ
     * @param 出力順ID 出力順ID
     *
     */
    private HihokenshaDaichoIkkatsuSakusei(boolean 資格喪失者抽出フラグ, boolean 出力フラグ, RString 出力順ID) {
        this.資格喪失者抽出フラグ = 資格喪失者抽出フラグ;
        this.出力フラグ = 出力フラグ;
        this.出力順ID = 出力順ID;

    }

    /**
     * バッチパラメータの作成です。
     *
     * @param 資格喪失者抽出フラグ 資格喪失者抽出フラグ
     * @param 出力フラグ 出力フラグ
     * @param 出力順ID 出力順ID
     *
     * @return IkkatsuSakuseiBatchParameter
     */
    public static IkkatsuSakuseiBatchParameter createHihokenshaDaichoBatchParameter(boolean 資格喪失者抽出フラグ,
            boolean 出力フラグ,
            RString 出力順ID) {
        return new IkkatsuSakuseiBatchParameter(資格喪失者抽出フラグ, 出力フラグ, 出力順ID);
    }
}
