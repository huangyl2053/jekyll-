package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100012;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC1100012のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBC1100012TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    初期表示("初期表示"),
    完了("完了"),
    変更("変更"),
    取下げ("取下げ");

    private final RString name;

    private DBC1100012TransitionEventName(String name) {
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
