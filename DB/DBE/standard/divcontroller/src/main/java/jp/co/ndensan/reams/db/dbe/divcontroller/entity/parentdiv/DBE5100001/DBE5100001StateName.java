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
    対象者割付("対象者割付"),
    審査会資料("審査会資料"),
    審査結果登録("審査結果登録"),
    事前審査("事前審査"),
    Defalt("Defalt"),
    審査会個人別状況照会("審査会個人別状況照会"),
    データ出力_モバイル("データ出力_モバイル"),
    開催結果登録("開催結果登録"),
    データ取込み_モバイル("データ取込み_モバイル"),
    結果登録_OCR("結果登録_OCR"),
    事前審査結果登録("事前審査結果登録");

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
