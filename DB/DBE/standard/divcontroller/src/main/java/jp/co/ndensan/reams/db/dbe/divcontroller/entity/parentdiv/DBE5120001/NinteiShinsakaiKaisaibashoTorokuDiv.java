package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteiShinsakaiKaisaibashoToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiShinsakaiKaisaibashoTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinsakaiKaisaibashokensaku")
    private ShinsakaiKaisaibashokensakuDiv ShinsakaiKaisaibashokensaku;
    @JsonProperty("ShinsakaiKaisaibashoIchiran")
    private ShinsakaiKaisaibashoIchiranDiv ShinsakaiKaisaibashoIchiran;
    @JsonProperty("ShinakaiKaisaIbashoShosai")
    private ShinakaiKaisaIbashoShosaiDiv ShinakaiKaisaIbashoShosai;
    @JsonProperty("ccdKanryoMsg")
    private KanryoMessageDiv ccdKanryoMsg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinsakaiKaisaibashokensaku
     * @return ShinsakaiKaisaibashokensaku
     */
    @JsonProperty("ShinsakaiKaisaibashokensaku")
    public ShinsakaiKaisaibashokensakuDiv getShinsakaiKaisaibashokensaku() {
        return ShinsakaiKaisaibashokensaku;
    }

    /*
     * setShinsakaiKaisaibashokensaku
     * @param ShinsakaiKaisaibashokensaku ShinsakaiKaisaibashokensaku
     */
    @JsonProperty("ShinsakaiKaisaibashokensaku")
    public void setShinsakaiKaisaibashokensaku(ShinsakaiKaisaibashokensakuDiv ShinsakaiKaisaibashokensaku) {
        this.ShinsakaiKaisaibashokensaku = ShinsakaiKaisaibashokensaku;
    }

    /*
     * getShinsakaiKaisaibashoIchiran
     * @return ShinsakaiKaisaibashoIchiran
     */
    @JsonProperty("ShinsakaiKaisaibashoIchiran")
    public ShinsakaiKaisaibashoIchiranDiv getShinsakaiKaisaibashoIchiran() {
        return ShinsakaiKaisaibashoIchiran;
    }

    /*
     * setShinsakaiKaisaibashoIchiran
     * @param ShinsakaiKaisaibashoIchiran ShinsakaiKaisaibashoIchiran
     */
    @JsonProperty("ShinsakaiKaisaibashoIchiran")
    public void setShinsakaiKaisaibashoIchiran(ShinsakaiKaisaibashoIchiranDiv ShinsakaiKaisaibashoIchiran) {
        this.ShinsakaiKaisaibashoIchiran = ShinsakaiKaisaibashoIchiran;
    }

    /*
     * getShinakaiKaisaIbashoShosai
     * @return ShinakaiKaisaIbashoShosai
     */
    @JsonProperty("ShinakaiKaisaIbashoShosai")
    public ShinakaiKaisaIbashoShosaiDiv getShinakaiKaisaIbashoShosai() {
        return ShinakaiKaisaIbashoShosai;
    }

    /*
     * setShinakaiKaisaIbashoShosai
     * @param ShinakaiKaisaIbashoShosai ShinakaiKaisaIbashoShosai
     */
    @JsonProperty("ShinakaiKaisaIbashoShosai")
    public void setShinakaiKaisaIbashoShosai(ShinakaiKaisaIbashoShosaiDiv ShinakaiKaisaIbashoShosai) {
        this.ShinakaiKaisaIbashoShosai = ShinakaiKaisaIbashoShosai;
    }

    /*
     * getccdKanryoMsg
     * @return ccdKanryoMsg
     */
    @JsonProperty("ccdKanryoMsg")
    public IKanryoMessageDiv getCcdKanryoMsg() {
        return ccdKanryoMsg;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadHyojiJoken() {
        return this.getShinsakaiKaisaibashokensaku().getRadHyojiJoken();
    }

    @JsonIgnore
    public void  setRadHyojiJoken(RadioButton radHyojiJoken) {
        this.getShinsakaiKaisaibashokensaku().setRadHyojiJoken(radHyojiJoken);
    }

    @JsonIgnore
    public TextBoxNum getTxtDispMax() {
        return this.getShinsakaiKaisaibashokensaku().getTxtDispMax();
    }

    @JsonIgnore
    public void  setTxtDispMax(TextBoxNum txtDispMax) {
        this.getShinsakaiKaisaibashokensaku().setTxtDispMax(txtDispMax);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getShinsakaiKaisaibashokensaku().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getShinsakaiKaisaibashokensaku().setBtnClear(btnClear);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getShinsakaiKaisaibashokensaku().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getShinsakaiKaisaibashokensaku().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public Button getBtnTsuika() {
        return this.getShinsakaiKaisaibashoIchiran().getBtnTsuika();
    }

    @JsonIgnore
    public void  setBtnTsuika(Button btnTsuika) {
        this.getShinsakaiKaisaibashoIchiran().setBtnTsuika(btnTsuika);
    }

    @JsonIgnore
    public DataGrid<dgKaisaibashoIchiran_Row> getDgKaisaibashoIchiran() {
        return this.getShinsakaiKaisaibashoIchiran().getDgKaisaibashoIchiran();
    }

    @JsonIgnore
    public void  setDgKaisaibashoIchiran(DataGrid<dgKaisaibashoIchiran_Row> dgKaisaibashoIchiran) {
        this.getShinsakaiKaisaibashoIchiran().setDgKaisaibashoIchiran(dgKaisaibashoIchiran);
    }

    @JsonIgnore
    public TextBoxCode getTxtKaisaibashoCode() {
        return this.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoCode();
    }

    @JsonIgnore
    public void  setTxtKaisaibashoCode(TextBoxCode txtKaisaibashoCode) {
        this.getShinakaiKaisaIbashoShosai().setTxtKaisaibashoCode(txtKaisaibashoCode);
    }

    @JsonIgnore
    public TextBox getTxtKaisaibashoMeisho() {
        return this.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoMeisho();
    }

    @JsonIgnore
    public void  setTxtKaisaibashoMeisho(TextBox txtKaisaibashoMeisho) {
        this.getShinakaiKaisaIbashoShosai().setTxtKaisaibashoMeisho(txtKaisaibashoMeisho);
    }

    @JsonIgnore
    public TextBox getTxtKaisaibashoJusho() {
        return this.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoJusho();
    }

    @JsonIgnore
    public void  setTxtKaisaibashoJusho(TextBox txtKaisaibashoJusho) {
        this.getShinakaiKaisaIbashoShosai().setTxtKaisaibashoJusho(txtKaisaibashoJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNumber() {
        return this.getShinakaiKaisaIbashoShosai().getTxtTelNumber();
    }

    @JsonIgnore
    public void  setTxtTelNumber(TextBoxTelNo txtTelNumber) {
        this.getShinakaiKaisaIbashoShosai().setTxtTelNumber(txtTelNumber);
    }

    @JsonIgnore
    public DropDownList getDdlKaisaiBashoJokyo() {
        return this.getShinakaiKaisaIbashoShosai().getDdlKaisaiBashoJokyo();
    }

    @JsonIgnore
    public void  setDdlKaisaiBashoJokyo(DropDownList ddlKaisaiBashoJokyo) {
        this.getShinakaiKaisaIbashoShosai().setDdlKaisaiBashoJokyo(ddlKaisaiBashoJokyo);
    }

    @JsonIgnore
    public Button getBtnupdate() {
        return this.getShinakaiKaisaIbashoShosai().getBtnupdate();
    }

    @JsonIgnore
    public void  setBtnupdate(Button btnupdate) {
        this.getShinakaiKaisaIbashoShosai().setBtnupdate(btnupdate);
    }

    @JsonIgnore
    public Button getBtnback() {
        return this.getShinakaiKaisaIbashoShosai().getBtnback();
    }

    @JsonIgnore
    public void  setBtnback(Button btnback) {
        this.getShinakaiKaisaIbashoShosai().setBtnback(btnback);
    }

    @JsonIgnore
    public ICodeInputDiv getCcdKaisaiChikuCode() {
        return this.getShinakaiKaisaIbashoShosai().getCcdKaisaiChikuCode();
    }

    // </editor-fold>
}
