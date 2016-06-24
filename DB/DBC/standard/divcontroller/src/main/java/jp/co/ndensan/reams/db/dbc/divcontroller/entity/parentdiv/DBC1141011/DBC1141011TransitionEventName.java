package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1141011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC1141011のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBC1141011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    自己負担額情報補正一括("自己負担額情報補正一括"),
    完了("完了");

    private final RString name;

    private DBC1141011TransitionEventName(String name) {
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
