package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KensakuJokenHihokensha のクラスファイル 
 * 
 * @author 自動生成
 */
public class KensakuJokenHihokenshaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshaNo")
    private TextBoxCode txtHihokenshaNo;
    @JsonProperty("btnHihokenshaGuide")
    private ButtonDialog btnHihokenshaGuide;
    @JsonProperty("btnhihokensha")
    private Button btnhihokensha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBoxCode getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * getbtnHihokenshaGuide
     * @return btnHihokenshaGuide
     */
    @JsonProperty("btnHihokenshaGuide")
    public ButtonDialog getBtnHihokenshaGuide() {
        return btnHihokenshaGuide;
    }

    /*
     * setbtnHihokenshaGuide
     * @param btnHihokenshaGuide btnHihokenshaGuide
     */
    @JsonProperty("btnHihokenshaGuide")
    public void setBtnHihokenshaGuide(ButtonDialog btnHihokenshaGuide) {
        this.btnHihokenshaGuide = btnHihokenshaGuide;
    }

    /*
     * getbtnhihokensha
     * @return btnhihokensha
     */
    @JsonProperty("btnhihokensha")
    public Button getBtnhihokensha() {
        return btnhihokensha;
    }

    /*
     * setbtnhihokensha
     * @param btnhihokensha btnhihokensha
     */
    @JsonProperty("btnhihokensha")
    public void setBtnhihokensha(Button btnhihokensha) {
        this.btnhihokensha = btnhihokensha;
    }

    // </editor-fold>
}
