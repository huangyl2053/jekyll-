package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * plIryohokenRireki のクラスファイル。
 *
 * @reamsid_L DBA-0230-010 hezhenzhen
 *
 */
public class plIryohokenRirekiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnIryohokenTsuika")
    private Button btnIryohokenTsuika;
    @JsonProperty("dgIryohokenIchiran")
    private DataGrid<dgIryohokenIchiran_Row> dgIryohokenIchiran;
    @JsonProperty("pnlIryohokenJoho")
    private pnlIryohokenJohoDiv pnlIryohokenJoho;
    @JsonProperty("btnIryohokenKakute")
    private Button btnIryohokenKakute;
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnIryohokenTsuika
     * @return btnIryohokenTsuika
     */
    @JsonProperty("btnIryohokenTsuika")
    public Button getBtnIryohokenTsuika() {
        return btnIryohokenTsuika;
    }

    /*
     * setbtnIryohokenTsuika
     * @param btnIryohokenTsuika btnIryohokenTsuika
     */
    @JsonProperty("btnIryohokenTsuika")
    public void setBtnIryohokenTsuika(Button btnIryohokenTsuika) {
        this.btnIryohokenTsuika = btnIryohokenTsuika;
    }

    /*
     * getdgIryohokenIchiran
     * @return dgIryohokenIchiran
     */
    @JsonProperty("dgIryohokenIchiran")
    public DataGrid<dgIryohokenIchiran_Row> getDgIryohokenIchiran() {
        return dgIryohokenIchiran;
    }

    /*
     * setdgIryohokenIchiran
     * @param dgIryohokenIchiran dgIryohokenIchiran
     */
    @JsonProperty("dgIryohokenIchiran")
    public void setDgIryohokenIchiran(DataGrid<dgIryohokenIchiran_Row> dgIryohokenIchiran) {
        this.dgIryohokenIchiran = dgIryohokenIchiran;
    }

    /*
     * getpnlIryohokenJoho
     * @return pnlIryohokenJoho
     */
    @JsonProperty("pnlIryohokenJoho")
    public pnlIryohokenJohoDiv getPnlIryohokenJoho() {
        return pnlIryohokenJoho;
    }

    /*
     * setpnlIryohokenJoho
     * @param pnlIryohokenJoho pnlIryohokenJoho
     */
    @JsonProperty("pnlIryohokenJoho")
    public void setPnlIryohokenJoho(pnlIryohokenJohoDiv pnlIryohokenJoho) {
        this.pnlIryohokenJoho = pnlIryohokenJoho;
    }

    /*
     * getbtnIryohokenKakute
     * @return btnIryohokenKakute
     */
    @JsonProperty("btnIryohokenKakute")
    public Button getBtnIryohokenKakute() {
        return btnIryohokenKakute;
    }

    /*
     * setbtnIryohokenKakute
     * @param btnIryohokenKakute btnIryohokenKakute
     */
    @JsonProperty("btnIryohokenKakute")
    public void setBtnIryohokenKakute(Button btnIryohokenKakute) {
        this.btnIryohokenKakute = btnIryohokenKakute;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

    // </editor-fold>
}
