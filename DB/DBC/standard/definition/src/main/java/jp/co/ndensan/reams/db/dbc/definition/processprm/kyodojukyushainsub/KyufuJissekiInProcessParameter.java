/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kyodojukyushainsub;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * CreateTmptableProcessパラメータです。
 *
 * @reamsid_L DBC-2780-011 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiInProcessParameter implements IBatchProcessParameter {

    private final RString 保存先フォルダ;
    private final RString csvファイル名;

    /**
     * コンストラクタです。
     *
     * @param 保存先フォルダ 保存先フォルダ
     * @param csvファイル名 csvファイル名
     */
    public KyufuJissekiInProcessParameter(RString 保存先フォルダ,
            RString csvファイル名) {
        this.保存先フォルダ = 保存先フォルダ;
        this.csvファイル名 = csvファイル名;
    }
}
