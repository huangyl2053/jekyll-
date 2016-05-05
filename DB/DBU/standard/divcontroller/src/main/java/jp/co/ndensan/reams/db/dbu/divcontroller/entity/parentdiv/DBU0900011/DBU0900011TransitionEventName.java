package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBU0900011のイベント名定義クラスです</br>
 *
 * @reamsid_L DBU-1080-050 lizhuoxuan
 */
public enum DBU0900011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    登録画面に遷移("登録画面に遷移");

    private final RString name;

    private DBU0900011TransitionEventName(String name) {
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
