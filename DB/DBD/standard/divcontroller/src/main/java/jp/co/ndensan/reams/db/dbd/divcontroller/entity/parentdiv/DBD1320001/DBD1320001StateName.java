package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1320001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBD1320001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBD1320001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    施設入退所("施設入退所"),
    負担限度額認定("負担限度額認定"),
    利用者負担額減免("利用者負担額減免"),
    国保("国保"),
    事業対象者("事業対象者"),
    利用者負担割合("利用者負担割合"),
    後期高齢者("後期高齢者"),
    訪問介護減免("訪問介護減免"),
    社福軽減("社福軽減"),
    特別地域加算減免("特別地域加算減免");

    private final RString name;

    private DBD1320001StateName(String name) {
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
