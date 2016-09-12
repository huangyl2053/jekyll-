package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBDHanyoListGuide;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBDHanyoListGuideのイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBDHanyoListGuideTransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    施設入退所("施設入退所"),
    利用者負担額減免("利用者負担額減免"),
    訪問介護利用者負担額減額("訪問介護利用者負担額減額"),
    社会福祉法人軽減("社会福祉法人軽減"),
    特別地域加算減免("特別地域加算減免"),
    負担限度額認定("負担限度額認定"),
    国保("国保"),
    後期高齢者("後期高齢者"),
    事業対象者("事業対象者"),
    利用者負担割合("利用者負担割合");

    private final RString name;

    private DBDHanyoListGuideTransitionEventName(String name) {
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
