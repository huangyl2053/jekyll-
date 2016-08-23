package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220013;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0220013の状態名定義クラスです
 *
 * @reamsid_L DBC-2102-010 lihang
 */
public enum DBC0220013StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    登録("登録"),
    完了メッセージ("完了メッセージ");

    private final RString name;

    private DBC0220013StateName(String name) {
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
