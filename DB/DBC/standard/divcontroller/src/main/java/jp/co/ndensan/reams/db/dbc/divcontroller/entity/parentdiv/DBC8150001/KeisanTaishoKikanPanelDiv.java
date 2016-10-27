package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KeisanTaishoKikanPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KeisanTaishoKikanPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTitle05")
    private Label lblTitle05;
    @JsonProperty("lblTitle06")
    private Label lblTitle06;
    @JsonProperty("txtKeisanTaishoKikanYM")
    private TextBoxDateRange txtKeisanTaishoKikanYM;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblTitle05
     * @return lblTitle05
     */
    @JsonProperty("lblTitle05")
    public Label getLblTitle05() {
        return lblTitle05;
    }

    /*
     * setlblTitle05
     * @param lblTitle05 lblTitle05
     */
    @JsonProperty("lblTitle05")
    public void setLblTitle05(Label lblTitle05) {
        this.lblTitle05 = lblTitle05;
    }

    /*
     * getlblTitle06
     * @return lblTitle06
     */
    @JsonProperty("lblTitle06")
    public Label getLblTitle06() {
        return lblTitle06;
    }

    /*
     * setlblTitle06
     * @param lblTitle06 lblTitle06
     */
    @JsonProperty("lblTitle06")
    public void setLblTitle06(Label lblTitle06) {
        this.lblTitle06 = lblTitle06;
    }

    /*
     * gettxtKeisanTaishoKikanYM
     * @return txtKeisanTaishoKikanYM
     */
    @JsonProperty("txtKeisanTaishoKikanYM")
    public TextBoxDateRange getTxtKeisanTaishoKikanYM() {
        return txtKeisanTaishoKikanYM;
    }

    /*
     * settxtKeisanTaishoKikanYM
     * @param txtKeisanTaishoKikanYM txtKeisanTaishoKikanYM
     */
    @JsonProperty("txtKeisanTaishoKikanYM")
    public void setTxtKeisanTaishoKikanYM(TextBoxDateRange txtKeisanTaishoKikanYM) {
        this.txtKeisanTaishoKikanYM = txtKeisanTaishoKikanYM;
    }

    // </editor-fold>
}
