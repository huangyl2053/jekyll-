package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0020011のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBC0020011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    完了("完了"),
    再検索("再検索"),
    検索結果一覧("検索結果一覧"),
    総合照会給付情報("総合照会給付情報");

    private final RString name;

    private DBC0020011TransitionEventName(String name) {
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
