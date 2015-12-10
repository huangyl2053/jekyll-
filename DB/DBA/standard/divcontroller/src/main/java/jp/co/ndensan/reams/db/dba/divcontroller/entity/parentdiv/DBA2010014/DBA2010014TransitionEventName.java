package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010014;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBA2010014のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBA2010014TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    基本情報へ("基本情報へ"),
    詳細情報へ("詳細情報へ");

    private final RString name;

    private DBA2010014TransitionEventName(String name) {
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
