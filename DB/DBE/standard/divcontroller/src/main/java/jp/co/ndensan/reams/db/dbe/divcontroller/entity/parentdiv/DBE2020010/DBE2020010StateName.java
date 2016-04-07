package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020010;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE2020010の状態名定義クラスです
 *
 * @reamsid_L DBE-0020-060 lishengli
 */
public enum DBE2020010StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    更新("更新"),
    照会("照会"),
    未定者("未定者"),
    完了("完了");

    private final RString name;

    private DBE2020010StateName(String name) {
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
