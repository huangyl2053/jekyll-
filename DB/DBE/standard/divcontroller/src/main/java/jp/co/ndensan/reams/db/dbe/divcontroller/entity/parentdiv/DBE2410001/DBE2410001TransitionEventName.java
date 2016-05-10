package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE2410001のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBE2410001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    調査依頼完了("調査依頼完了"),
    意見書依頼完了("意見書依頼完了");

    private final RString name;

    private DBE2410001TransitionEventName(String name) {
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
