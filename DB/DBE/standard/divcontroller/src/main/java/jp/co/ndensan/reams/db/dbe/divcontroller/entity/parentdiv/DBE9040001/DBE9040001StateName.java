package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE9040001の状態名定義クラスです
 *
 */
public enum DBE9040001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    検索("検索"),
    一覧("一覧"),
    詳細("詳細"),
    完了("完了"),
    一覧_認定調査委託先マスタから遷移("一覧_認定調査委託先マスタから遷移"),
    詳細_認定調査委託先マスタから遷移("詳細_認定調査委託先マスタから遷移"),
    完了_認定調査委託先マスタから遷移("完了_認定調査委託先マスタから遷移");

    private final RString name;

    private DBE9040001StateName(String name) {
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
