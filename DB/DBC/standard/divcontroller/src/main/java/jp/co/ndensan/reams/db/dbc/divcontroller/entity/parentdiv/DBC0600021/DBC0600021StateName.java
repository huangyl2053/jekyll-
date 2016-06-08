package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0600021の状態名定義クラスです
 *
 * @reamsid_L DBC-1020-030 quxiaodong
 */
public enum DBC0600021StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    touroku("touroku"),
    successSaved("successSaved");

    private final RString name;

    private DBC0600021StateName(String name) {
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
