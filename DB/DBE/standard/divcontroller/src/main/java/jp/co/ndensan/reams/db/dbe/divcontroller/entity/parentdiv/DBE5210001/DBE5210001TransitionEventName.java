package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE5210001のイベント名定義クラスです</br>
 *
 * @reamsid_L DBE-0160-010 wangxiaodong
 */
public enum DBE5210001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    審査会一覧に戻る("審査会一覧に戻る");

    private final RString name;

    private DBE5210001TransitionEventName(String name) {
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
