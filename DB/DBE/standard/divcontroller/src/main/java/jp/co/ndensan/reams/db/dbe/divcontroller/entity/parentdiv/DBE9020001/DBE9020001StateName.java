package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE9020001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBE9020001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    検索("検索"),
    主治医一覧("主治医一覧"),
    主治医登録("主治医登録"),
    主治医登録_医療機関登録から遷移("主治医登録_医療機関登録から遷移"),
    完了("完了"),
    完了_医療機関登録から遷移("完了_医療機関登録から遷移"),
    主治医一覧_医療機関登録から遷移("主治医一覧_医療機関登録から遷移"),
    主治医一覧_保存ボタン非活性("主治医一覧_保存ボタン非活性");

    private final RString name;

    private DBE9020001StateName(String name) {
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
