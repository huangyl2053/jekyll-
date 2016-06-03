package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB6110001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB6110001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBB6110001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    連帯納付義務者情報一覧("連帯納付義務者情報一覧"),
    連帯納付義務者新規("連帯納付義務者新規"),
    連帯納付義務者修正("連帯納付義務者修正"),
    連帯納付義務者削除("連帯納付義務者削除"),
    連帯納付義務者更新結果確認("連帯納付義務者更新結果確認");

    private final RString name;

    private DBB6110001StateName(String name) {
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
