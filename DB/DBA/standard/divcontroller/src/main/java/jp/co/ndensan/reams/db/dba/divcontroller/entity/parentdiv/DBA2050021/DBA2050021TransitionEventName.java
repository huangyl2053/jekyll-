package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2050021;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBA2050021のイベント名定義クラスです</br>
 *
 * @reamsid_L DBA-0411-050 lizhuoxuan
 */
public enum DBA2050021TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    再検索する("再検索する"),
    終了する("終了する");

    private final RString name;

    private DBA2050021TransitionEventName(String name) {
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
