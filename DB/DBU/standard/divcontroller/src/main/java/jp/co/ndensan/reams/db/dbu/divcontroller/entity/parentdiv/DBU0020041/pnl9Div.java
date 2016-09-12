package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020041;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * pnl9 のクラスファイル
 *
 * @reamsid_L DBU-1100-040 yebangqiang
 */
public class pnl9Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbp9")
    private tbp9Div tbp9;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbp9
     * @return tbp9
     */
    @JsonProperty("tbp9")
    public tbp9Div getTbp9() {
        return tbp9;
    }

    /*
     * settbp9
     * @param tbp9 tbp9
     */
    @JsonProperty("tbp9")
    public void setTbp9(tbp9Div tbp9) {
        this.tbp9 = tbp9;
    }

    // </editor-fold>
}
