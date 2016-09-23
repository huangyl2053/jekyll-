package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBD9010001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBD9010001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    初期表示("初期表示"),
    主治医意見書確認書("主治医意見書確認書"),
    おむつ使用証明書("おむつ使用証明書"),
    完了("完了");

    private final RString name;

    private DBD9010001StateName(String name) {
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
