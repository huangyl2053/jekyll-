package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020008;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE2020008の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBE2020008StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    完了("完了"),
    調査地区グループ一覧("調査地区グループ一覧"),
    調査地区グループ調査地区一覧("調査地区グループ調査地区一覧"),
    調査地区グループ調査地区情報登録("調査地区グループ調査地区情報登録");

    private final RString name;

    private DBE2020008StateName(String name) {
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
