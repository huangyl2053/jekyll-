package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0350011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0350011の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBC0350011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    Default("default"),
    受領委任契約事業者一覧表作成("受領委任契約事業者一覧表作成");

    private final RString name;

    private DBC0350011StateName(String name) {
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
