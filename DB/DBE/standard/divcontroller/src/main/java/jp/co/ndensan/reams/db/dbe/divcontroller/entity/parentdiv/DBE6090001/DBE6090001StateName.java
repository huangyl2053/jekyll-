package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6090001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE6090001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBE6090001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    初期表示("初期表示"),
    調査員一覧("調査員一覧"),
    調査実績一覧("調査実績一覧"),
    調査実績明細("調査実績明細"),
    完了状態("完了状態"),
    調査実績一覧状態("調査実績一覧状態"),
    調査実績明細状態("調査実績明細状態");

    private final RString name;

    private DBE6090001StateName(String name) {
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
