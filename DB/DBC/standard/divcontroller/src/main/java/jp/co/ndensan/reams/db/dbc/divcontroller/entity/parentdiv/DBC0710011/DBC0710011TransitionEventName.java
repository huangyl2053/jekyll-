package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0710011のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-0992-100 yebangqiang
 */
public enum DBC0710011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    to申請登録("to申請登録"),
    検索条件("検索条件"),
    該当者一覧("該当者一覧");

    private final RString name;

    private DBC0710011TransitionEventName(String name) {
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
