package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ServiceCodeCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ServiceCodeCommonChildDiv のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceCodeCommonChildDivDiv extends Panel implements IServiceCodeCommonChildDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtServiceCode")
    private TextBoxCode txtServiceCode;
    @JsonProperty("txtKijunYM")
    private TextBoxDate txtKijunYM;
    @JsonProperty("dgCodeIchiran")
    private DataGrid<dgCodeIchiran_Row> dgCodeIchiran;
    @JsonProperty("btnServiceCodeKensaku")
    private Button btnServiceCodeKensaku;
    @JsonProperty("btnYameru")
    private Button btnYameru;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("ServiceCodeModel")
    private RString ServiceCodeModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtServiceCode
     * @return txtServiceCode
     */
    @JsonProperty("txtServiceCode")
    public TextBoxCode getTxtServiceCode() {
        return txtServiceCode;
    }

    /*
     * settxtServiceCode
     * @param txtServiceCode txtServiceCode
     */
    @JsonProperty("txtServiceCode")
    public void setTxtServiceCode(TextBoxCode txtServiceCode) {
        this.txtServiceCode = txtServiceCode;
    }

    /*
     * gettxtKijunYM
     * @return txtKijunYM
     */
    @JsonProperty("txtKijunYM")
    public TextBoxDate getTxtKijunYM() {
        return txtKijunYM;
    }

    /*
     * settxtKijunYM
     * @param txtKijunYM txtKijunYM
     */
    @JsonProperty("txtKijunYM")
    public void setTxtKijunYM(TextBoxDate txtKijunYM) {
        this.txtKijunYM = txtKijunYM;
    }

    /*
     * getdgCodeIchiran
     * @return dgCodeIchiran
     */
    @JsonProperty("dgCodeIchiran")
    public DataGrid<dgCodeIchiran_Row> getDgCodeIchiran() {
        return dgCodeIchiran;
    }

    /*
     * setdgCodeIchiran
     * @param dgCodeIchiran dgCodeIchiran
     */
    @JsonProperty("dgCodeIchiran")
    public void setDgCodeIchiran(DataGrid<dgCodeIchiran_Row> dgCodeIchiran) {
        this.dgCodeIchiran = dgCodeIchiran;
    }

    /*
     * getbtnServiceCodeKensaku
     * @return btnServiceCodeKensaku
     */
    @JsonProperty("btnServiceCodeKensaku")
    public Button getBtnServiceCodeKensaku() {
        return btnServiceCodeKensaku;
    }

    /*
     * setbtnServiceCodeKensaku
     * @param btnServiceCodeKensaku btnServiceCodeKensaku
     */
    @JsonProperty("btnServiceCodeKensaku")
    public void setBtnServiceCodeKensaku(Button btnServiceCodeKensaku) {
        this.btnServiceCodeKensaku = btnServiceCodeKensaku;
    }

    /*
     * getbtnYameru
     * @return btnYameru
     */
    @JsonProperty("btnYameru")
    public Button getBtnYameru() {
        return btnYameru;
    }

    /*
     * setbtnYameru
     * @param btnYameru btnYameru
     */
    @JsonProperty("btnYameru")
    public void setBtnYameru(Button btnYameru) {
        this.btnYameru = btnYameru;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * getServiceCodeModel
     * @return ServiceCodeModel
     */
    @JsonProperty("ServiceCodeModel")
    public RString getServiceCodeModel() {
        return ServiceCodeModel;
    }

    /*
     * setServiceCodeModel
     * @param ServiceCodeModel ServiceCodeModel
     */
    @JsonProperty("ServiceCodeModel")
    public void setServiceCodeModel(RString ServiceCodeModel) {
        this.ServiceCodeModel = ServiceCodeModel;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
