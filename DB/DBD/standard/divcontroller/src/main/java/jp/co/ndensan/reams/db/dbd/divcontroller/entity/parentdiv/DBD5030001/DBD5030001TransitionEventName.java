package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5030001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBD5030001のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBD5030001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    通知書発行("通知書発行"),
    完了("完了");

    private final RString name;

    private DBD5030001TransitionEventName(String name) {
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
