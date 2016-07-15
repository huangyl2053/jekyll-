package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140002;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE5140002のイベント名定義クラスです</br>
 *
 * @reamsid_L DBE-0130-020 xuyannan
 */
public enum DBE5140002TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    開催予定登録に戻る("開催予定登録に戻る");

    private final RString name;

    private DBE5140002TransitionEventName(String name) {
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
