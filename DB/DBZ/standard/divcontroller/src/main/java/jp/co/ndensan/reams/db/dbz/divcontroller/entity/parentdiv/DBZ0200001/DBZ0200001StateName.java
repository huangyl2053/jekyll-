package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0200001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBZ0200001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBZ0200001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    検索条件("検索条件"),
    該当者一覧("該当者一覧"),
    検索("検索");

    private final RString name;

    private DBZ0200001StateName(String name) {
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
