package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0510001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB0510001のイベント名定義クラスです</br>
 *
 * @reamsid_L DBB-0880-010 wangkanglei
 */
public enum DBB0510001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    現年度異動賦課("現年度異動賦課"),
    現年度異動賦課通知書作成("現年度異動賦課通知書作成");

    private final RString name;

    private DBB0510001TransitionEventName(String name) {
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
