package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBU0050001のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBU0050001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    完了する("完了する"),
    検索条件("検索条件"),
    該当者一覧("該当者一覧");

    private final RString name;

    private DBU0050001TransitionEventName(String name) {
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
