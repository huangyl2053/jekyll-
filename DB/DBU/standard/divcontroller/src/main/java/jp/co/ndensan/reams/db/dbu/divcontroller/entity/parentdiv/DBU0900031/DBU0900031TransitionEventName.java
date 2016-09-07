package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900031;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBU0900031のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBU0900031TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    弁明登録一覧画面に遷移("弁明登録一覧画面に遷移"),
    完了("完了");

    private final RString name;

    private DBU0900031TransitionEventName(String name) {
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
