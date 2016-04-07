package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5100001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE5100001のイベント名定義クラスです</br>
 *
 * @reamsid_L DBE-1350-010 zuotao
 */
public enum DBE5100001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    審査会選択("審査会選択"),
    処理完了("処理完了");

    private final RString name;

    private DBE5100001TransitionEventName(String name) {
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
