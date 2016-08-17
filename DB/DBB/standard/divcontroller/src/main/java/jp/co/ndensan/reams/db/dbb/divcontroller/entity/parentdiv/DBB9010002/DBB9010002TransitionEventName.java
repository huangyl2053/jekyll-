package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9010002;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB9010002のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBB9010002TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    完了状態("完了状態");

    private final RString name;

    private DBB9010002TransitionEventName(String name) {
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
