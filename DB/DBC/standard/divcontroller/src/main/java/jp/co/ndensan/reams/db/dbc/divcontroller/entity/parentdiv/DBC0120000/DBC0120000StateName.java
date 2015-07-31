package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120000;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0120000の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBC0120000StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    履歴一覧("履歴一覧"),
    利用票登録("利用票登録"),
    更新完了("更新完了");

    private final RString name;

    private DBC0120000StateName(String name) {
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
