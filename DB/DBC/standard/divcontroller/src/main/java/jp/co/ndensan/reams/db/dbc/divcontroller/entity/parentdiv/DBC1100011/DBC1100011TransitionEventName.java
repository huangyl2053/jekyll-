package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC1100011のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public enum DBC1100011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    対象者検索("対象者検索"),
    完了("完了"),
    戻る("戻る");

    private final RString name;

    private DBC1100011TransitionEventName(String name) {
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
