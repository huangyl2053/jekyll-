package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6080001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE6080001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBE6080001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    検索状態("検索状態"),
    主治医状態("主治医状態"),
    実績一覧状態("実績一覧状態"),
    実績明細状態("実績明細状態"),
    完了状態("完了状態"),
    実績一覧ボタンなし状態("実績一覧ボタンなし状態");

    private final RString name;

    private DBE6080001StateName(String name) {
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
