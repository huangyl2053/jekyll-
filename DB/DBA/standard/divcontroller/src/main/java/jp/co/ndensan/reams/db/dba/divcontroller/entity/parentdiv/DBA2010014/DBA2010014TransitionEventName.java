package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010014;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBA2010014のイベント名定義クラスです</br>
 *
 * @reamsid_L DBA-0340-060 dongyabin
 */
public enum DBA2010014TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    基本情報へ("基本情報へ"),
    詳細情報へ("詳細情報へ"),
    保存する("保存する"),
    再検索する("再検索する");

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
