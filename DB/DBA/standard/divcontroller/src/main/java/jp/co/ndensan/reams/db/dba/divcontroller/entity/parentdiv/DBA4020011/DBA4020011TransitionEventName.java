package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA4020011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBA4020011のイベント名定義クラスです</br>
 *
 */
public enum DBA4020011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    検索条件("検索条件"),
    完了("完了"),
    該当者一覧("該当者一覧");

    private final RString name;

    private DBA4020011TransitionEventName(String name) {
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
