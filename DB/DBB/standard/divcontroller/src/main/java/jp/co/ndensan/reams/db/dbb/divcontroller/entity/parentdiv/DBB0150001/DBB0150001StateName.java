package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB0150001の状態名定義クラスです
 *
 * @reamsid_L DBB-0890-010 wangkanglei
 */
public enum DBB0150001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    仮算定異動賦課("仮算定異動賦課"),
    通知書一括発行("通知書一括発行");

    private final RString name;

    private DBB0150001StateName(String name) {
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
