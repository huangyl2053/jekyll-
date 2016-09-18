package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBDHanyoList;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBDHanyoListの状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBDHanyoListStateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    汎用リスト_施設入退所("汎用リスト_施設入退所"),
    汎用リスト_利用者負担額減免("汎用リスト_利用者負担額減免"),
    汎用リスト_訪問介護利用者負担額減額("汎用リスト_訪問介護利用者負担額減額"),
    汎用リスト_社会福祉法人軽減("汎用リスト_社会福祉法人軽減"),
    汎用リスト_特別地域加算減免("汎用リスト_特別地域加算減免"),
    汎用リスト_負担限度額認定("汎用リスト_負担限度額認定"),
    汎用リスト_国保("汎用リスト_国保"),
    汎用リスト_後期高齢者("汎用リスト_後期高齢者"),
    汎用リスト_事業対象者("汎用リスト_事業対象者"),
    汎用リスト_利用者負担割合("汎用リスト_利用者負担割合");

    private final RString name;

    private DBDHanyoListStateName(String name) {
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
