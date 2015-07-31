package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBA1010011の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBA1010011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    資格取得情報登録("資格取得情報登録"),
    完了("完了"),
    被保履歴入力("被保履歴入力"),
    医療保険入力("医療保険入力"),
    施設入退所入力("施設入退所入力"),
    資格訂正("資格訂正");

    private final RString name;

    private DBA1010011StateName(String name) {
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
