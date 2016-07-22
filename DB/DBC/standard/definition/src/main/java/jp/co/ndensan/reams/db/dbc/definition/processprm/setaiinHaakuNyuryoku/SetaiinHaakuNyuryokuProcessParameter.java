/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.setaiinHaakuNyuryoku;

import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員把握（バッチ）のパラメータです。
 *
 * @reamsid_L DBC-2010-050 tianshuai
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class SetaiinHaakuNyuryokuProcessParameter implements IBatchProcessParameter {

    private SetaiinHaakuKanriShikibetsuKubun 管理識別区分;
    private RString メニューID;

    /**
     * コンストラクタ
     *
     * @param 管理識別区分 管理識別区分
     * @param メニューID メニューID
     */
    public SetaiinHaakuNyuryokuProcessParameter(SetaiinHaakuKanriShikibetsuKubun 管理識別区分, RString メニューID) {
        this.管理識別区分 = 管理識別区分;
        this.メニューID = メニューID;
    }
}
