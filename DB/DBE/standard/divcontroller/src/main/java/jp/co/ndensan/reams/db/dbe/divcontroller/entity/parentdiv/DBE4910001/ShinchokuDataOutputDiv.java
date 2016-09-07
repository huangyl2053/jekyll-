package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4910001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinchokuDataOutput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinchokuDataOutputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("pnlKensaku")
    private pnlKensakuDiv pnlKensaku;
    @JsonProperty("pnlIchiran")
    private pnlIchiranDiv pnlIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpnlKensaku
     * @return pnlKensaku
     */
    @JsonProperty("pnlKensaku")
    public pnlKensakuDiv getPnlKensaku() {
        return pnlKensaku;
    }

    /*
     * setpnlKensaku
     * @param pnlKensaku pnlKensaku
     */
    @JsonProperty("pnlKensaku")
    public void setPnlKensaku(pnlKensakuDiv pnlKensaku) {
        this.pnlKensaku = pnlKensaku;
    }

    /*
     * getpnlIchiran
     * @return pnlIchiran
     */
    @JsonProperty("pnlIchiran")
    public pnlIchiranDiv getPnlIchiran() {
        return pnlIchiran;
    }

    /*
     * setpnlIchiran
     * @param pnlIchiran pnlIchiran
     */
    @JsonProperty("pnlIchiran")
    public void setPnlIchiran(pnlIchiranDiv pnlIchiran) {
        this.pnlIchiran = pnlIchiran;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadKubun() {
        return this.getPnlKensaku().getRadKubun();
    }

    @JsonIgnore
    public void  setRadKubun(RadioButton radKubun) {
        this.getPnlKensaku().setRadKubun(radKubun);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtChuishutsuRange() {
        return this.getPnlKensaku().getTxtChuishutsuRange();
    }

    @JsonIgnore
    public void  setTxtChuishutsuRange(TextBoxDateRange txtChuishutsuRange) {
        this.getPnlKensaku().setTxtChuishutsuRange(txtChuishutsuRange);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihokenshaCode() {
        return this.getPnlKensaku().getTxtHihokenshaCode();
    }

    @JsonIgnore
    public void  setTxtHihokenshaCode(TextBoxCode txtHihokenshaCode) {
        this.getPnlKensaku().setTxtHihokenshaCode(txtHihokenshaCode);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxKensu() {
        return this.getPnlKensaku().getTxtMaxKensu();
    }

    @JsonIgnore
    public void  setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.getPnlKensaku().setTxtMaxKensu(txtMaxKensu);
    }

    @JsonIgnore
    public Button getBtnHihokensha() {
        return this.getPnlKensaku().getBtnHihokensha();
    }

    @JsonIgnore
    public void  setBtnHihokensha(Button btnHihokensha) {
        this.getPnlKensaku().setBtnHihokensha(btnHihokensha);
    }

    @JsonIgnore
    public Button getBtnJokenClear() {
        return this.getPnlKensaku().getBtnJokenClear();
    }

    @JsonIgnore
    public void  setBtnJokenClear(Button btnJokenClear) {
        this.getPnlKensaku().setBtnJokenClear(btnJokenClear);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getPnlKensaku().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getPnlKensaku().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getPnlKensaku().getCcdHokenshaList();
    }

    @JsonIgnore
    public DataGrid<dgShinchokuIchiran_Row> getDgShinchokuIchiran() {
        return this.getPnlIchiran().getDgShinchokuIchiran();
    }

    @JsonIgnore
    public void  setDgShinchokuIchiran(DataGrid<dgShinchokuIchiran_Row> dgShinchokuIchiran) {
        this.getPnlIchiran().setDgShinchokuIchiran(dgShinchokuIchiran);
    }

    // </editor-fold>
}
