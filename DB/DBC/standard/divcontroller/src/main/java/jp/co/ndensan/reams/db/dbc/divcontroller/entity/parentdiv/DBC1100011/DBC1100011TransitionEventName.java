package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC1100011のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBC1100011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    新規("新規"),
    完了("完了"),
    変更取下げ("変更取下げ"),
    該当者検索("該当者検索");

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
