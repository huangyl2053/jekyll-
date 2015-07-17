package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0220011の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBC0220011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    対象者検索("対象者検索"),
    対象者一覧("対象者一覧");

    private final RString name;

    private DBC0220011StateName(String name) {
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
