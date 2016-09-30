package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200025;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0200025の状態名定義クラスです
 *
 * @reamsid_L DBC-2530-010 chenyadong
 */
public enum DBC0200025StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    総合事業費過誤申立書情報("総合事業費過誤申立書情報");

    private final RString name;

    private DBC0200025StateName(String name) {
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
