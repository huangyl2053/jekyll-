package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE2200001の状態名定義クラスです
 *
 */
public enum DBE2200001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    初期表示("初期表示"),
    委託先選択後("委託先選択後"),
    調査員選択後("調査員選択後"),
    保存完了("保存完了");

    private final RString name;

    private DBE2200001StateName(String name) {
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
