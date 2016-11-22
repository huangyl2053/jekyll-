package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HyojiJoken のクラスファイル
 *
 * @reamsid_L DBE-0120-010 lishengli
 */
public class HyojiJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHyojiKikanFrom")
    private TextBoxDate txtHyojiKikanFrom;
    @JsonProperty("txtHyojiKikanTo")
    private TextBoxDate txtHyojiKikanTo;
    @JsonProperty("txtSaidaiHyojiKensu")
    private TextBoxNum txtSaidaiHyojiKensu;
    @JsonProperty("radHyojiJokenWaritsukeMikanryo")
    private RadioButton radHyojiJokenWaritsukeMikanryo;
    @JsonProperty("radHyojiJokenWaritsukeKanryo")
    private RadioButton radHyojiJokenWaritsukeKanryo;
    @JsonProperty("radHyojiJokenShinsakaiMikanryo")
    private RadioButton radHyojiJokenShinsakaiMikanryo;
    @JsonProperty("radHyojiJokenShinsakaiKanryo")
    private RadioButton radHyojiJokenShinsakaiKanryo;
    @JsonProperty("radDammyShinsakai")
    private RadioButton radDammyShinsakai;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHyojiKikanFrom
     * @return txtHyojiKikanFrom
     */
    @JsonProperty("txtHyojiKikanFrom")
    public TextBoxDate getTxtHyojiKikanFrom() {
        return txtHyojiKikanFrom;
    }

    /*
     * settxtHyojiKikanFrom
     * @param txtHyojiKikanFrom txtHyojiKikanFrom
     */
    @JsonProperty("txtHyojiKikanFrom")
    public void setTxtHyojiKikanFrom(TextBoxDate txtHyojiKikanFrom) {
        this.txtHyojiKikanFrom = txtHyojiKikanFrom;
    }

    /*
     * gettxtHyojiKikanTo
     * @return txtHyojiKikanTo
     */
    @JsonProperty("txtHyojiKikanTo")
    public TextBoxDate getTxtHyojiKikanTo() {
        return txtHyojiKikanTo;
    }

    /*
     * settxtHyojiKikanTo
     * @param txtHyojiKikanTo txtHyojiKikanTo
     */
    @JsonProperty("txtHyojiKikanTo")
    public void setTxtHyojiKikanTo(TextBoxDate txtHyojiKikanTo) {
        this.txtHyojiKikanTo = txtHyojiKikanTo;
    }

    /*
     * gettxtSaidaiHyojiKensu
     * @return txtSaidaiHyojiKensu
     */
    @JsonProperty("txtSaidaiHyojiKensu")
    public TextBoxNum getTxtSaidaiHyojiKensu() {
        return txtSaidaiHyojiKensu;
    }

    /*
     * settxtSaidaiHyojiKensu
     * @param txtSaidaiHyojiKensu txtSaidaiHyojiKensu
     */
    @JsonProperty("txtSaidaiHyojiKensu")
    public void setTxtSaidaiHyojiKensu(TextBoxNum txtSaidaiHyojiKensu) {
        this.txtSaidaiHyojiKensu = txtSaidaiHyojiKensu;
    }

    /*
     * getradHyojiJokenWaritsukeMikanryo
     * @return radHyojiJokenWaritsukeMikanryo
     */
    @JsonProperty("radHyojiJokenWaritsukeMikanryo")
    public RadioButton getRadHyojiJokenWaritsukeMikanryo() {
        return radHyojiJokenWaritsukeMikanryo;
    }

    /*
     * setradHyojiJokenWaritsukeMikanryo
     * @param radHyojiJokenWaritsukeMikanryo radHyojiJokenWaritsukeMikanryo
     */
    @JsonProperty("radHyojiJokenWaritsukeMikanryo")
    public void setRadHyojiJokenWaritsukeMikanryo(RadioButton radHyojiJokenWaritsukeMikanryo) {
        this.radHyojiJokenWaritsukeMikanryo = radHyojiJokenWaritsukeMikanryo;
    }

    /*
     * getradHyojiJokenWaritsukeKanryo
     * @return radHyojiJokenWaritsukeKanryo
     */
    @JsonProperty("radHyojiJokenWaritsukeKanryo")
    public RadioButton getRadHyojiJokenWaritsukeKanryo() {
        return radHyojiJokenWaritsukeKanryo;
    }

    /*
     * setradHyojiJokenWaritsukeKanryo
     * @param radHyojiJokenWaritsukeKanryo radHyojiJokenWaritsukeKanryo
     */
    @JsonProperty("radHyojiJokenWaritsukeKanryo")
    public void setRadHyojiJokenWaritsukeKanryo(RadioButton radHyojiJokenWaritsukeKanryo) {
        this.radHyojiJokenWaritsukeKanryo = radHyojiJokenWaritsukeKanryo;
    }

    /*
     * getradHyojiJokenShinsakaiMikanryo
     * @return radHyojiJokenShinsakaiMikanryo
     */
    @JsonProperty("radHyojiJokenShinsakaiMikanryo")
    public RadioButton getRadHyojiJokenShinsakaiMikanryo() {
        return radHyojiJokenShinsakaiMikanryo;
    }

    /*
     * setradHyojiJokenShinsakaiMikanryo
     * @param radHyojiJokenShinsakaiMikanryo radHyojiJokenShinsakaiMikanryo
     */
    @JsonProperty("radHyojiJokenShinsakaiMikanryo")
    public void setRadHyojiJokenShinsakaiMikanryo(RadioButton radHyojiJokenShinsakaiMikanryo) {
        this.radHyojiJokenShinsakaiMikanryo = radHyojiJokenShinsakaiMikanryo;
    }

    /*
     * getradHyojiJokenShinsakaiKanryo
     * @return radHyojiJokenShinsakaiKanryo
     */
    @JsonProperty("radHyojiJokenShinsakaiKanryo")
    public RadioButton getRadHyojiJokenShinsakaiKanryo() {
        return radHyojiJokenShinsakaiKanryo;
    }

    /*
     * setradHyojiJokenShinsakaiKanryo
     * @param radHyojiJokenShinsakaiKanryo radHyojiJokenShinsakaiKanryo
     */
    @JsonProperty("radHyojiJokenShinsakaiKanryo")
    public void setRadHyojiJokenShinsakaiKanryo(RadioButton radHyojiJokenShinsakaiKanryo) {
        this.radHyojiJokenShinsakaiKanryo = radHyojiJokenShinsakaiKanryo;
    }

    /*
     * getradDammyShinsakai
     * @return radDammyShinsakai
     */
    @JsonProperty("radDammyShinsakai")
    public RadioButton getRadDammyShinsakai() {
        return radDammyShinsakai;
    }

    /*
     * setradDammyShinsakai
     * @param radDammyShinsakai radDammyShinsakai
     */
    @JsonProperty("radDammyShinsakai")
    public void setRadDammyShinsakai(RadioButton radDammyShinsakai) {
        this.radDammyShinsakai = radDammyShinsakai;
    }

    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    // </editor-fold>
}
