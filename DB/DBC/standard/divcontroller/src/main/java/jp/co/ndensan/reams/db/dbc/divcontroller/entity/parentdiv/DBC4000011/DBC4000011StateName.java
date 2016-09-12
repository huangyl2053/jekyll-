package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4000011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC4000011の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBC4000011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    初期状態("初期状態"),
    検索結果表示状態("検索結果表示状態"),
    追加状態("追加状態"),
    修正状態("修正状態"),
    削除状態("削除状態"),
    完了状態("完了状態");

    private final RString name;

    private DBC4000011StateName(String name) {
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
