package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SonotaJoho のクラスファイル
 *
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public class SonotaJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtGeninShikkanCode")
    private TextBoxCode txtGeninShikkanCode;
    @JsonProperty("btnGeninShikkanGuide")
    private ButtonDialog btnGeninShikkanGuide;
    @JsonProperty("txtGeninShikkanName")
    private TextBox txtGeninShikkanName;
    @JsonProperty("txtShinseiKeikaNissu")
    private TextBoxNumRange txtShinseiKeikaNissu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtGeninShikkanCode
     * @return txtGeninShikkanCode
     */
    @JsonProperty("txtGeninShikkanCode")
    public TextBoxCode getTxtGeninShikkanCode() {
        return txtGeninShikkanCode;
    }

    /*
     * settxtGeninShikkanCode
     * @param txtGeninShikkanCode txtGeninShikkanCode
     */
    @JsonProperty("txtGeninShikkanCode")
    public void setTxtGeninShikkanCode(TextBoxCode txtGeninShikkanCode) {
        this.txtGeninShikkanCode = txtGeninShikkanCode;
    }

    /*
     * getbtnGeninShikkanGuide
     * @return btnGeninShikkanGuide
     */
    @JsonProperty("btnGeninShikkanGuide")
    public ButtonDialog getBtnGeninShikkanGuide() {
        return btnGeninShikkanGuide;
    }

    /*
     * setbtnGeninShikkanGuide
     * @param btnGeninShikkanGuide btnGeninShikkanGuide
     */
    @JsonProperty("btnGeninShikkanGuide")
    public void setBtnGeninShikkanGuide(ButtonDialog btnGeninShikkanGuide) {
        this.btnGeninShikkanGuide = btnGeninShikkanGuide;
    }

    /*
     * gettxtGeninShikkanName
     * @return txtGeninShikkanName
     */
    @JsonProperty("txtGeninShikkanName")
    public TextBox getTxtGeninShikkanName() {
        return txtGeninShikkanName;
    }

    /*
     * settxtGeninShikkanName
     * @param txtGeninShikkanName txtGeninShikkanName
     */
    @JsonProperty("txtGeninShikkanName")
    public void setTxtGeninShikkanName(TextBox txtGeninShikkanName) {
        this.txtGeninShikkanName = txtGeninShikkanName;
    }

    /*
     * gettxtShinseiKeikaNissu
     * @return txtShinseiKeikaNissu
     */
    @JsonProperty("txtShinseiKeikaNissu")
    public TextBoxNumRange getTxtShinseiKeikaNissu() {
        return txtShinseiKeikaNissu;
    }

    /*
     * settxtShinseiKeikaNissu
     * @param txtShinseiKeikaNissu txtShinseiKeikaNissu
     */
    @JsonProperty("txtShinseiKeikaNissu")
    public void setTxtShinseiKeikaNissu(TextBoxNumRange txtShinseiKeikaNissu) {
        this.txtShinseiKeikaNissu = txtShinseiKeikaNissu;
    }

    // </editor-fold>
}
