package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC1740011のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-2400-010 yuqingzhang
 */
public enum DBC1740011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    完了("完了"),
    再検索("再検索"),
    検索結果一覧("検索結果一覧");

    private final RString name;

    private DBC1740011TransitionEventName(String name) {
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
