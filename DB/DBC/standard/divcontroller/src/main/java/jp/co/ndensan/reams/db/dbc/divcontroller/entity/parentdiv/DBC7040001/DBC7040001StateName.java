package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7040001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC7040001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBC7040001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    共同処理用受給者情報_基本("共同処理用受給者情報_基本"),
    共同処理用受給者情報_償還("共同処理用受給者情報_償還"),
    共同処理用受給者情報_高額("共同処理用受給者情報_高額"),
    国保連受給者情報("国保連受給者情報");

    private final RString name;

    private DBC7040001StateName(String name) {
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
