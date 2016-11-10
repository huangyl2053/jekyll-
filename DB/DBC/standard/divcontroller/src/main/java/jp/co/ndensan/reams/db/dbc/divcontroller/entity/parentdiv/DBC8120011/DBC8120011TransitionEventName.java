package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8120011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC8120011のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-4790-010 chenyadong
 */
public enum DBC8120011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    完了("完了"),
    実行("実行"),
    対象者検索("対象者検索");

    private final RString name;

    private DBC8120011TransitionEventName(String name) {
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
