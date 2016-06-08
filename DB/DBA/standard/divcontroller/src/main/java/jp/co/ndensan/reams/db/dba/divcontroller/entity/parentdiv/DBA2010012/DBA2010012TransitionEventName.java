package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010012;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBA2010012のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBA2010012TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    保存("保存"),
    完了("完了"),
    再検索("再検索");

    private final RString name;

    private DBA2010012TransitionEventName(String name) {
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
