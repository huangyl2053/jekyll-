package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZA010001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBZA010001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBZA010001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    不整合一覧("不整合一覧"),
    資格修正("資格修正"),
    資格修正後("資格修正後"),
    資格修正_2回目("資格修正_2回目");

    private final RString name;

    private DBZA010001StateName(String name) {
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
