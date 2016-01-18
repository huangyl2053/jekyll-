package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBU0510011のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBU0510011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    research("research"),
    insert("insert"),
    delete("delete"),
    対象者検索に戻る("対象者検索に戻る"),
    stop("stop");

    private final RString name;

    private DBU0510011TransitionEventName(String name) {
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
