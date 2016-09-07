package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1120011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JikoFutangakuKeisanChushutsuJokenPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JikoFutangakuKeisanChushutsuJokenPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZenkaiTaishoYMD")
    private TextBoxDateRange txtZenkaiTaishoYMD;
    @JsonProperty("txtShinseiTaishoYMD")
    private TextBoxDateRange txtShinseiTaishoYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtZenkaiTaishoYMD
     * @return txtZenkaiTaishoYMD
     */
    @JsonProperty("txtZenkaiTaishoYMD")
    public TextBoxDateRange getTxtZenkaiTaishoYMD() {
        return txtZenkaiTaishoYMD;
    }

    /*
     * settxtZenkaiTaishoYMD
     * @param txtZenkaiTaishoYMD txtZenkaiTaishoYMD
     */
    @JsonProperty("txtZenkaiTaishoYMD")
    public void setTxtZenkaiTaishoYMD(TextBoxDateRange txtZenkaiTaishoYMD) {
        this.txtZenkaiTaishoYMD = txtZenkaiTaishoYMD;
    }

    /*
     * gettxtShinseiTaishoYMD
     * @return txtShinseiTaishoYMD
     */
    @JsonProperty("txtShinseiTaishoYMD")
    public TextBoxDateRange getTxtShinseiTaishoYMD() {
        return txtShinseiTaishoYMD;
    }

    /*
     * settxtShinseiTaishoYMD
     * @param txtShinseiTaishoYMD txtShinseiTaishoYMD
     */
    @JsonProperty("txtShinseiTaishoYMD")
    public void setTxtShinseiTaishoYMD(TextBoxDateRange txtShinseiTaishoYMD) {
        this.txtShinseiTaishoYMD = txtShinseiTaishoYMD;
    }

    // </editor-fold>
}
