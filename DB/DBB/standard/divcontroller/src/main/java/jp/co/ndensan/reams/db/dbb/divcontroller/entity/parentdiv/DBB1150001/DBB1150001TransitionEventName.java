package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB1150001のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBB1150001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    初期状態("初期状態"),
    完了("完了"),
    所得照会票印字内容修正("所得照会票印字内容修正"),
    所得照会票発行("所得照会票発行");

    private final RString name;

    private DBB1150001TransitionEventName(String name) {
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
