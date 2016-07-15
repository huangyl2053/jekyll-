package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * CareManagementhi のクラスファイル 
 * 
 * @author 自動生成
 */
public class CareManagementhiDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtCareManagementhiJigyoshoKubun")
    private TextBox txtCareManagementhiJigyoshoKubun;
    @JsonProperty("txtCareManagementhiServiceKeikakuSakuseiIraiTodokedeYMD")
    private TextBox txtCareManagementhiServiceKeikakuSakuseiIraiTodokedeYMD;
    @JsonProperty("txtCareManagementhiServiceShurui")
    private TextBox txtCareManagementhiServiceShurui;
    @JsonProperty("txtCareManagementhiServiceKomoku")
    private TextBox txtCareManagementhiServiceKomoku;
    @JsonProperty("txtCareManagementhiServiceCode")
    private TextBox txtCareManagementhiServiceCode;
    @JsonProperty("txtCareManagementhiServiceName")
    private TextBox txtCareManagementhiServiceName;
    @JsonProperty("CareManagementhiEtc")
    private CareManagementhiEtcDiv CareManagementhiEtc;
    @JsonProperty("txtCareManagementhiTekiyo")
    private TextBoxMultiLine txtCareManagementhiTekiyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtCareManagementhiJigyoshoKubun")
    public TextBox getTxtCareManagementhiJigyoshoKubun() {
        return txtCareManagementhiJigyoshoKubun;
    }

    @JsonProperty("txtCareManagementhiJigyoshoKubun")
    public void setTxtCareManagementhiJigyoshoKubun(TextBox txtCareManagementhiJigyoshoKubun) {
        this.txtCareManagementhiJigyoshoKubun=txtCareManagementhiJigyoshoKubun;
    }

    @JsonProperty("txtCareManagementhiServiceKeikakuSakuseiIraiTodokedeYMD")
    public TextBox getTxtCareManagementhiServiceKeikakuSakuseiIraiTodokedeYMD() {
        return txtCareManagementhiServiceKeikakuSakuseiIraiTodokedeYMD;
    }

    @JsonProperty("txtCareManagementhiServiceKeikakuSakuseiIraiTodokedeYMD")
    public void setTxtCareManagementhiServiceKeikakuSakuseiIraiTodokedeYMD(TextBox txtCareManagementhiServiceKeikakuSakuseiIraiTodokedeYMD) {
        this.txtCareManagementhiServiceKeikakuSakuseiIraiTodokedeYMD=txtCareManagementhiServiceKeikakuSakuseiIraiTodokedeYMD;
    }

    @JsonProperty("txtCareManagementhiServiceShurui")
    public TextBox getTxtCareManagementhiServiceShurui() {
        return txtCareManagementhiServiceShurui;
    }

    @JsonProperty("txtCareManagementhiServiceShurui")
    public void setTxtCareManagementhiServiceShurui(TextBox txtCareManagementhiServiceShurui) {
        this.txtCareManagementhiServiceShurui=txtCareManagementhiServiceShurui;
    }

    @JsonProperty("txtCareManagementhiServiceKomoku")
    public TextBox getTxtCareManagementhiServiceKomoku() {
        return txtCareManagementhiServiceKomoku;
    }

    @JsonProperty("txtCareManagementhiServiceKomoku")
    public void setTxtCareManagementhiServiceKomoku(TextBox txtCareManagementhiServiceKomoku) {
        this.txtCareManagementhiServiceKomoku=txtCareManagementhiServiceKomoku;
    }

    @JsonProperty("txtCareManagementhiServiceCode")
    public TextBox getTxtCareManagementhiServiceCode() {
        return txtCareManagementhiServiceCode;
    }

    @JsonProperty("txtCareManagementhiServiceCode")
    public void setTxtCareManagementhiServiceCode(TextBox txtCareManagementhiServiceCode) {
        this.txtCareManagementhiServiceCode=txtCareManagementhiServiceCode;
    }

    @JsonProperty("txtCareManagementhiServiceName")
    public TextBox getTxtCareManagementhiServiceName() {
        return txtCareManagementhiServiceName;
    }

    @JsonProperty("txtCareManagementhiServiceName")
    public void setTxtCareManagementhiServiceName(TextBox txtCareManagementhiServiceName) {
        this.txtCareManagementhiServiceName=txtCareManagementhiServiceName;
    }

    @JsonProperty("CareManagementhiEtc")
    public CareManagementhiEtcDiv getCareManagementhiEtc() {
        return CareManagementhiEtc;
    }

    @JsonProperty("CareManagementhiEtc")
    public void setCareManagementhiEtc(CareManagementhiEtcDiv CareManagementhiEtc) {
        this.CareManagementhiEtc=CareManagementhiEtc;
    }

    @JsonProperty("txtCareManagementhiTekiyo")
    public TextBoxMultiLine getTxtCareManagementhiTekiyo() {
        return txtCareManagementhiTekiyo;
    }

    @JsonProperty("txtCareManagementhiTekiyo")
    public void setTxtCareManagementhiTekiyo(TextBoxMultiLine txtCareManagementhiTekiyo) {
        this.txtCareManagementhiTekiyo=txtCareManagementhiTekiyo;
    }

}
