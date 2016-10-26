package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC2410011の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBC2410011StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    Default("default"),
    情報修正登録検索("情報修正登録検索"),
    審査結果登録検索("審査結果登録検索"),
    情報修正登録("情報修正登録"),
    審査結果登録("審査結果登録"),
    確認用請求情報明細詳細1("確認用請求情報明細詳細1"),
    確認用請求情報明細詳細2("確認用請求情報明細詳細2"),
    処理完了("処理完了");

    private final RString name;

    private DBC2410011StateName(String name) {
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
