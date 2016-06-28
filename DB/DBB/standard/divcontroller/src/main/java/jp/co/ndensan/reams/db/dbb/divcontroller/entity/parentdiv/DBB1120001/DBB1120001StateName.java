package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB1120001の状態名定義クラスです
 *
 * @reamsid_L DBB-1690-010 sunhui
 */
public enum DBB1120001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    所得情報抽出連携広域用("所得情報抽出連携広域用");

    private final RString name;

    private DBB1120001StateName(String name) {
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
