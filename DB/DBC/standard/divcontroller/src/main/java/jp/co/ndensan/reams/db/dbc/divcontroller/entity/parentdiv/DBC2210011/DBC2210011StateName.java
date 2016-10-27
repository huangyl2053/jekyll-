package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC2210011の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBC2210011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    検索初期("検索初期"),
    一覧("一覧"),
    詳細情報("詳細情報");

    private final RString name;

    private DBC2210011StateName(String name) {
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
