package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200023;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0200023の状態名定義クラスです
 *
 * @reamsid_L DBC-3300-160 wangxingpeng
 */
public enum DBC0200023StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    受給者異動連絡票情報("受給者異動連絡票情報");

    private final RString name;

    private DBC0200023StateName(String name) {
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
