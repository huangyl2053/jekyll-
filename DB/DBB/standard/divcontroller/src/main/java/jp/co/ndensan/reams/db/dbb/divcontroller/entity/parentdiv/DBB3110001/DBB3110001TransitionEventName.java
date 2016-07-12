package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB3110001のイベント名定義クラスです</br>
 *
 * @reamsid_L DBB-1660-010 gongliang
 */
public enum DBB3110001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    介護保険料減免("介護保険料減免"),
    更新結果確認("更新結果確認"),
    完了("完了");

    private final RString name;

    private DBB3110001TransitionEventName(String name) {
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
