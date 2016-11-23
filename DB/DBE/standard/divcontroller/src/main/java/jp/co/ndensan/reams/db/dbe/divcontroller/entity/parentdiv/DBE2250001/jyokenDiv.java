package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * jyoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class jyokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNinteishinseibi")
    private TextBoxDateRange txtNinteishinseibi;
    @JsonProperty("txtiraibi")
    private TextBoxDateRange txtiraibi;
    @JsonProperty("txtMaxKensu")
    private TextBoxNum txtMaxKensu;
    @JsonProperty("btnKensakuClear")
    private Button btnKensakuClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNinteishinseibi
     * @return txtNinteishinseibi
     */
    @JsonProperty("txtNinteishinseibi")
    public TextBoxDateRange getTxtNinteishinseibi() {
        return txtNinteishinseibi;
    }

    /*
     * settxtNinteishinseibi
     * @param txtNinteishinseibi txtNinteishinseibi
     */
    @JsonProperty("txtNinteishinseibi")
    public void setTxtNinteishinseibi(TextBoxDateRange txtNinteishinseibi) {
        this.txtNinteishinseibi = txtNinteishinseibi;
    }

    /*
     * gettxtiraibi
     * @return txtiraibi
     */
    @JsonProperty("txtiraibi")
    public TextBoxDateRange getTxtiraibi() {
        return txtiraibi;
    }

    /*
     * settxtiraibi
     * @param txtiraibi txtiraibi
     */
    @JsonProperty("txtiraibi")
    public void setTxtiraibi(TextBoxDateRange txtiraibi) {
        this.txtiraibi = txtiraibi;
    }

    /*
     * gettxtMaxKensu
     * @return txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public TextBoxNum getTxtMaxKensu() {
        return txtMaxKensu;
    }

    /*
     * settxtMaxKensu
     * @param txtMaxKensu txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public void setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.txtMaxKensu = txtMaxKensu;
    }

    /*
     * getbtnKensakuClear
     * @return btnKensakuClear
     */
    @JsonProperty("btnKensakuClear")
    public Button getBtnKensakuClear() {
        return btnKensakuClear;
    }

    /*
     * setbtnKensakuClear
     * @param btnKensakuClear btnKensakuClear
     */
    @JsonProperty("btnKensakuClear")
    public void setBtnKensakuClear(Button btnKensakuClear) {
        this.btnKensakuClear = btnKensakuClear;
    }

    // </editor-fold>
}
