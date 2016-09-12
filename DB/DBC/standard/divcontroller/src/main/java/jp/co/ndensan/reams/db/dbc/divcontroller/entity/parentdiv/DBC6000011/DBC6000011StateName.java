package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6000011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC6000011の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBC6000011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    メニューからの遷移("メニューからの遷移"),
    送付取込画面からの遷移("送付取込画面からの遷移");

    private final RString name;

    private DBC6000011StateName(String name) {
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
