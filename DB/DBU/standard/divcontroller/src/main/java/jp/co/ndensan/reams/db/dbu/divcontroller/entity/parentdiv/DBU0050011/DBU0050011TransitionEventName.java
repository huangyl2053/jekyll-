package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBU0050011のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBU0050011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    追加("追加"),
    修正("修正"),
    削除("削除"),
    様式４の2("様式４の2"),
    様式4の３("様式4の３");

    private final RString name;

    private DBU0050011TransitionEventName(String name) {
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
