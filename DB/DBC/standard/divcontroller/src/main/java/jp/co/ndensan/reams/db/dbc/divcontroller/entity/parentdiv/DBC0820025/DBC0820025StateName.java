package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820025;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0820025の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBC0820025StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    新規修正モード("新規修正モード"),
    削除モード("削除モード");

    private final RString name;

    private DBC0820025StateName(String name) {
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
