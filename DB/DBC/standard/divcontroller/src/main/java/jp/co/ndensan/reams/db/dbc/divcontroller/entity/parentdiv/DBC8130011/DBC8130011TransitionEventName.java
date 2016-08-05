package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC8130011のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBC8130011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    自己負担額一覧("自己負担額一覧"),
    自己負担額管理情報入力("自己負担額管理情報入力"),
    完了("完了"),
    自己負担額入力へ("自己負担額入力へ"),
    再検索("再検索"),
    検索結果一覧("検索結果一覧");

    private final RString name;

    private DBC8130011TransitionEventName(String name) {
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
