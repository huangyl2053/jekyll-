package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7210001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC7210001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBC7210001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    事業分高額合算支給決定情報("事業分高額合算支給決定情報");

    private final RString name;

    private DBC7210001StateName(String name) {
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
