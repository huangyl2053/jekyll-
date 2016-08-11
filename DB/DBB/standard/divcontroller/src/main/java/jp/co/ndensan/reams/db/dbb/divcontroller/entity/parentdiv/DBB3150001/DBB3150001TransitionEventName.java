package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB3150001のイベント名定義クラスです</br>
 *
 * @reamsid_L DBB-1680-010 gongliang
 */
public enum DBB3150001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    完了("完了"),
    猶予種類選択("猶予種類選択"),
    取消種類選択("取消種類選択"),
    発行("発行");

    private final RString name;

    private DBB3150001TransitionEventName(String name) {
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
