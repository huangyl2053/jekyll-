package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE4050001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBE4050001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    初期表示("初期表示"),
    検索結果表示("検索結果表示"),
    イメージ情報表示("イメージ情報表示");

    private final RString name;

    private DBE4050001StateName(String name) {
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
