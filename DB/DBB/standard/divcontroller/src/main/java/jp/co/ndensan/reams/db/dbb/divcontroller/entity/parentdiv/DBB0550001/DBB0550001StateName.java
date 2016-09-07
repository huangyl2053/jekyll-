package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB0550001の状態名定義クラスです
 *
 * @reamsid_L DBB-0920-010 quxiaodong
 */
public enum DBB0550001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    Default("default"),
    過年度通知書一括発行("過年度通知書一括発行");

    private final RString name;

    private DBB0550001StateName(String name) {
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
