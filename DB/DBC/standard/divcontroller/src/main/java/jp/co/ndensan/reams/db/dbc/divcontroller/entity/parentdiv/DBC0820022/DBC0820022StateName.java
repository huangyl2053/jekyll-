package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820022;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0820022の状態名定義クラスです
 *
 * @reamsid_L DBC-1030-040 quxiaodong
 */
public enum DBC0820022StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    新規修正モード("新規修正モード"),
    削除モード("削除モード");

    private final RString name;

    private DBC0820022StateName(String name) {
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
