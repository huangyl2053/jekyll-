package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0100001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE0100001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBE0100001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    Default("default"),
    申請検索("申請検索"),
    個人照会("個人照会"),
    情報提供("情報提供"),
    完了("完了"),
    条件指定("条件指定"),
    検索結果一覧("検索結果一覧"),
    審査受付("審査受付");

    private final RString name;

    private DBE0100001StateName(String name) {
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
