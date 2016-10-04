package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC1000062の状態名定義クラスです
 *
 * @reamsid_L DBC-4620-010 wangkanglei
 */
public enum DBC1000062StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    一覧("一覧"),
    明細追加("明細追加"),
    明細修正("明細修正"),
    完了状態("完了状態");

    private final RString name;

    private DBC1000062StateName(String name) {
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
