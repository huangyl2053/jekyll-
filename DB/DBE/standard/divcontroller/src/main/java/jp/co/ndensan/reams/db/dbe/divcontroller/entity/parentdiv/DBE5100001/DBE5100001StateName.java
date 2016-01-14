package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5100001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE5100001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBE5100001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    開催予定登録("開催予定登録"),
    対象者割当("対象者割当"),
    審査会資料("審査会資料"),
    審査結果登録("審査結果登録"),
    事前結果登録("事前結果登録"),
    データ出力("データ出力"),
    判定結果("判定結果"),
    Defalt("Defalt");

    private final RString name;

    private DBE5100001StateName(String name) {
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
