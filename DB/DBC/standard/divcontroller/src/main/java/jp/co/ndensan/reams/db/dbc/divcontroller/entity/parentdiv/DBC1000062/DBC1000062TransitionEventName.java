package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC1000062のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-4620-010 wangkanglei
 */
public enum DBC1000062TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    再検索("再検索"),
    完了("完了"),
    明細を追加("明細を追加"),
    明細を修正("明細を修正"),
    検索結果一覧("検索結果一覧");

    private final RString name;

    private DBC1000062TransitionEventName(String name) {
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
