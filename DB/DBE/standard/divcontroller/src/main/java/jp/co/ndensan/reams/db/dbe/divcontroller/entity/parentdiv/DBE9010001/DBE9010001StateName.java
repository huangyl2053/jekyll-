package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE9010001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBE9010001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    検索("検索"),
    医療機関一覧("医療機関一覧"),
    医療機関詳細("医療機関詳細"),
    完了("完了"),
    一覧_主治医マスタから遷移("一覧_主治医マスタから遷移"),
    詳細_主治医マスタから遷移("詳細_主治医マスタから遷移"),
    完了_主治医マスタから遷移("完了_主治医マスタから遷移");

    private final RString name;

    private DBE9010001StateName(String name) {
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
