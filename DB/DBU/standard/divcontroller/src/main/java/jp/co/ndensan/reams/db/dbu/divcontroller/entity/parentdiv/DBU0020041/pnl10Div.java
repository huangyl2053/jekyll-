package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020041;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * pnl10 のクラスファイル
 *
 * @reamsid_L DBU-1100-040 yebangqiang
 */
public class pnl10Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbp10")
    private tbp10Div tbp10;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbp10
     * @return tbp10
     */
    @JsonProperty("tbp10")
    public tbp10Div getTbp10() {
        return tbp10;
    }

    /*
     * settbp10
     * @param tbp10 tbp10
     */
    @JsonProperty("tbp10")
    public void setTbp10(tbp10Div tbp10) {
        this.tbp10 = tbp10;
    }

    // </editor-fold>
}
