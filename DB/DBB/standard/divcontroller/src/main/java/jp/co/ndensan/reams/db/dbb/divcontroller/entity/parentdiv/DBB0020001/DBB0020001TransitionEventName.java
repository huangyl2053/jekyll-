package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB0020001のイベント名定義クラスです</br>
 *
 * @reamsid_L DBB-0690-010 xuhao
 */
public enum DBB0020001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    終了する("終了する"),
    即時更生へ("即時更生へ"),
    各種通知書作成へ("各種通知書作成へ");

    private final RString name;

    private DBB0020001TransitionEventName(String name) {
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
