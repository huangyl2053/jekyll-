package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0110011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0110011の状態名定義クラスです
 *
 * @reamsid_L DBC-1920-010 tianshuai
 */
public enum DBC0110011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    履歴一覧("履歴一覧"),
    追加状態("追加状態"),
    完了状態("完了状態");

    private final RString name;

    private DBC0110011StateName(String name) {
        this.name = new RString(name);
    }

    /**
     * getName
     *
     * @return 名前
     */
    @Override
    public RString getName() {
        return name;
    }
// </editor-fold>
}
