package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE5130001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBE5130001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    検索("検索"),
    審査会一覧("審査会一覧"),
    審査会登録("審査会登録"),
    完了("完了"),
    審査会一覧_保存ボタン非活性("審査会一覧_保存ボタン非活性");

    private final RString name;

    private DBE5130001StateName(String name) {
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
