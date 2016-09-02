/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokenshadaicho;

import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA020010.DBA020010_HihokenshaDaichoIkkatsuParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 画面から入力するデータより、バッチ用パラメータクラスを作成するクラスです。
 *
 * @reamsid_L DBA-0510-020 duanzhanli
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class HihokenshaDaichoIkkatsuSakusei {

    private final boolean 資格喪失者抽出フラグ;
    private final boolean 出力フラグ;
    private final RString 出力順ID;
    private final RString 登録ユーザーID;

    /**
     * コンストラクタです。<br/>
     *
     * @param 資格喪失者抽出フラグ 資格喪失者抽出フラグ
     * @param 出力フラグ 出力フラグ
     * @param 出力順ID 出力順ID
     * @param 登録ユーザーID 登録ユーザーID
     *
     */
    private HihokenshaDaichoIkkatsuSakusei(boolean 資格喪失者抽出フラグ, boolean 出力フラグ, RString 出力順ID, RString 登録ユーザーID) {
        this.資格喪失者抽出フラグ = 資格喪失者抽出フラグ;
        this.出力フラグ = 出力フラグ;
        this.出力順ID = 出力順ID;
        this.登録ユーザーID = 登録ユーザーID;

    }

    /**
     * バッチパラメータの作成です。
     *
     * @param 資格喪失者抽出フラグ 資格喪失者抽出フラグ
     * @param 出力フラグ 出力フラグ
     * @param 出力順ID 出力順ID
     * @param 登録ユーザーID 登録ユーザーID
     * @return DBA020010_HihokenshaDaichoIkkatsuParameter
     */
    public static DBA020010_HihokenshaDaichoIkkatsuParameter createHihokenshaDaichoBatchParameter(boolean 資格喪失者抽出フラグ,
            boolean 出力フラグ,
            Long 出力順ID,
            RString 登録ユーザーID) {
        return new DBA020010_HihokenshaDaichoIkkatsuParameter(資格喪失者抽出フラグ, 出力フラグ, 出力順ID, 登録ユーザーID);
    }
}
