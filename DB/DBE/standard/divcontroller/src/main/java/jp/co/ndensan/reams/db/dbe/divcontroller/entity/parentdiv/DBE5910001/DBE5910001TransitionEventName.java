package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5910001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE5910001のイベント名定義クラスです</br>
 *
 * @reamsid_L DBE-0260-010 zuotao
 */
public enum DBE5910001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    処理終了("処理終了");

    private final RString name;

    private DBE5910001TransitionEventName(String name) {
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
