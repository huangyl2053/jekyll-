package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.IPrintContentsSettingDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * pritPublish2 のクラスファイル
 *
 * @reamsid_L DBB-1680-010 gongliang
 */
public class pritPublish2Div extends PanelPublish {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtBunshoBango1")
    private TextBox txtBunshoBango1;
    @JsonProperty("txtBunshoBango2")
    private TextBox txtBunshoBango2;
    @JsonProperty("txtBunshoBango3")
    private TextBox txtBunshoBango3;
    @JsonProperty("txtBunshoBango4")
    private TextBox txtBunshoBango4;
    @JsonProperty("btnBunshoBangoShutoku")
    private Button btnBunshoBangoShutoku;
    @JsonProperty("comdiv1")
    private PrintContentsSettingDiv comdiv1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtBunshoBango1
     * @return txtBunshoBango1
     */
    @JsonProperty("txtBunshoBango1")
    public TextBox getTxtBunshoBango1() {
        return txtBunshoBango1;
    }

    /*
     * settxtBunshoBango1
     * @param txtBunshoBango1 txtBunshoBango1
     */
    @JsonProperty("txtBunshoBango1")
    public void setTxtBunshoBango1(TextBox txtBunshoBango1) {
        this.txtBunshoBango1 = txtBunshoBango1;
    }

    /*
     * gettxtBunshoBango2
     * @return txtBunshoBango2
     */
    @JsonProperty("txtBunshoBango2")
    public TextBox getTxtBunshoBango2() {
        return txtBunshoBango2;
    }

    /*
     * settxtBunshoBango2
     * @param txtBunshoBango2 txtBunshoBango2
     */
    @JsonProperty("txtBunshoBango2")
    public void setTxtBunshoBango2(TextBox txtBunshoBango2) {
        this.txtBunshoBango2 = txtBunshoBango2;
    }

    /*
     * gettxtBunshoBango3
     * @return txtBunshoBango3
     */
    @JsonProperty("txtBunshoBango3")
    public TextBox getTxtBunshoBango3() {
        return txtBunshoBango3;
    }

    /*
     * settxtBunshoBango3
     * @param txtBunshoBango3 txtBunshoBango3
     */
    @JsonProperty("txtBunshoBango3")
    public void setTxtBunshoBango3(TextBox txtBunshoBango3) {
        this.txtBunshoBango3 = txtBunshoBango3;
    }

    /*
     * gettxtBunshoBango4
     * @return txtBunshoBango4
     */
    @JsonProperty("txtBunshoBango4")
    public TextBox getTxtBunshoBango4() {
        return txtBunshoBango4;
    }

    /*
     * settxtBunshoBango4
     * @param txtBunshoBango4 txtBunshoBango4
     */
    @JsonProperty("txtBunshoBango4")
    public void setTxtBunshoBango4(TextBox txtBunshoBango4) {
        this.txtBunshoBango4 = txtBunshoBango4;
    }

    /*
     * getbtnBunshoBangoShutoku
     * @return btnBunshoBangoShutoku
     */
    @JsonProperty("btnBunshoBangoShutoku")
    public Button getBtnBunshoBangoShutoku() {
        return btnBunshoBangoShutoku;
    }

    /*
     * setbtnBunshoBangoShutoku
     * @param btnBunshoBangoShutoku btnBunshoBangoShutoku
     */
    @JsonProperty("btnBunshoBangoShutoku")
    public void setBtnBunshoBangoShutoku(Button btnBunshoBangoShutoku) {
        this.btnBunshoBangoShutoku = btnBunshoBangoShutoku;
    }

    /*
     * getcomdiv1
     * @return comdiv1
     */
    @JsonProperty("comdiv1")
    public IPrintContentsSettingDiv getComdiv1() {
        return comdiv1;
    }

    // </editor-fold>
}
