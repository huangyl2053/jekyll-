package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210051;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB0210051のイベント名定義クラスです</br>
 *
 * reamsid_L DBB-5660-010 wangxingpeng
 */
public enum DBB0210051TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    finish("finish");

    private final RString name;

    private DBB0210051TransitionEventName(String name) {
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
