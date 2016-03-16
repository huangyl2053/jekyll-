package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.dbu0500011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBU0500011のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBU0500011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    検索条件("検索条件"),
    完了する("完了する"),
    該当者一覧("該当者一覧");

    private final RString name;

    private DBU0500011TransitionEventName(String name) {
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
