package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000023;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RiyoshaFutanWariaiKoushiConf のクラスファイル 
 * 
 * @author 自動生成
 */
public class RiyoshaFutanWariaiKoushiConfDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblNote")
    private Label lblNote;
    @JsonProperty("ccdKaigoKanryoMessage")
    private KaigoKanryoMessageDiv ccdKaigoKanryoMessage;
    @JsonProperty("PanelHakko")
    private PanelHakkoDiv PanelHakko;
    @JsonProperty("PanelShutsuryokuNaiyo")
    private PanelShutsuryokuNaiyoDiv PanelShutsuryokuNaiyo;
    @JsonProperty("lbl2wariKaishiYmdValue")
    private RString lbl2wariKaishiYmdValue;
    @JsonProperty("lbl2wariShuryoYmdValue")
    private RString lbl2wariShuryoYmdValue;
    @JsonProperty("lbl1wariKaishiYmdValue")
    private RString lbl1wariKaishiYmdValue;
    @JsonProperty("lbl1wariShuryoYmdValue")
    private RString lbl1wariShuryoYmdValue;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblNote
     * @return lblNote
     */
    @JsonProperty("lblNote")
    public Label getLblNote() {
        return lblNote;
    }

    /*
     * setlblNote
     * @param lblNote lblNote
     */
    @JsonProperty("lblNote")
    public void setLblNote(Label lblNote) {
        this.lblNote = lblNote;
    }

    /*
     * getccdKaigoKanryoMessage
     * @return ccdKaigoKanryoMessage
     */
    @JsonProperty("ccdKaigoKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKaigoKanryoMessage() {
        return ccdKaigoKanryoMessage;
    }

    /*
     * getPanelHakko
     * @return PanelHakko
     */
    @JsonProperty("PanelHakko")
    public PanelHakkoDiv getPanelHakko() {
        return PanelHakko;
    }

    /*
     * setPanelHakko
     * @param PanelHakko PanelHakko
     */
    @JsonProperty("PanelHakko")
    public void setPanelHakko(PanelHakkoDiv PanelHakko) {
        this.PanelHakko = PanelHakko;
    }

    /*
     * getPanelShutsuryokuNaiyo
     * @return PanelShutsuryokuNaiyo
     */
    @JsonProperty("PanelShutsuryokuNaiyo")
    public PanelShutsuryokuNaiyoDiv getPanelShutsuryokuNaiyo() {
        return PanelShutsuryokuNaiyo;
    }

    /*
     * setPanelShutsuryokuNaiyo
     * @param PanelShutsuryokuNaiyo PanelShutsuryokuNaiyo
     */
    @JsonProperty("PanelShutsuryokuNaiyo")
    public void setPanelShutsuryokuNaiyo(PanelShutsuryokuNaiyoDiv PanelShutsuryokuNaiyo) {
        this.PanelShutsuryokuNaiyo = PanelShutsuryokuNaiyo;
    }

    /*
     * getlbl2wariKaishiYmdValue
     * @return lbl2wariKaishiYmdValue
     */
    @JsonProperty("lbl2wariKaishiYmdValue")
    public RString getLbl2wariKaishiYmdValue() {
        return lbl2wariKaishiYmdValue;
    }

    /*
     * setlbl2wariKaishiYmdValue
     * @param lbl2wariKaishiYmdValue lbl2wariKaishiYmdValue
     */
    @JsonProperty("lbl2wariKaishiYmdValue")
    public void setLbl2wariKaishiYmdValue(RString lbl2wariKaishiYmdValue) {
        this.lbl2wariKaishiYmdValue = lbl2wariKaishiYmdValue;
    }

    /*
     * getlbl2wariShuryoYmdValue
     * @return lbl2wariShuryoYmdValue
     */
    @JsonProperty("lbl2wariShuryoYmdValue")
    public RString getLbl2wariShuryoYmdValue() {
        return lbl2wariShuryoYmdValue;
    }

    /*
     * setlbl2wariShuryoYmdValue
     * @param lbl2wariShuryoYmdValue lbl2wariShuryoYmdValue
     */
    @JsonProperty("lbl2wariShuryoYmdValue")
    public void setLbl2wariShuryoYmdValue(RString lbl2wariShuryoYmdValue) {
        this.lbl2wariShuryoYmdValue = lbl2wariShuryoYmdValue;
    }

    /*
     * getlbl1wariKaishiYmdValue
     * @return lbl1wariKaishiYmdValue
     */
    @JsonProperty("lbl1wariKaishiYmdValue")
    public RString getLbl1wariKaishiYmdValue() {
        return lbl1wariKaishiYmdValue;
    }

    /*
     * setlbl1wariKaishiYmdValue
     * @param lbl1wariKaishiYmdValue lbl1wariKaishiYmdValue
     */
    @JsonProperty("lbl1wariKaishiYmdValue")
    public void setLbl1wariKaishiYmdValue(RString lbl1wariKaishiYmdValue) {
        this.lbl1wariKaishiYmdValue = lbl1wariKaishiYmdValue;
    }

    /*
     * getlbl1wariShuryoYmdValue
     * @return lbl1wariShuryoYmdValue
     */
    @JsonProperty("lbl1wariShuryoYmdValue")
    public RString getLbl1wariShuryoYmdValue() {
        return lbl1wariShuryoYmdValue;
    }

    /*
     * setlbl1wariShuryoYmdValue
     * @param lbl1wariShuryoYmdValue lbl1wariShuryoYmdValue
     */
    @JsonProperty("lbl1wariShuryoYmdValue")
    public void setLbl1wariShuryoYmdValue(RString lbl1wariShuryoYmdValue) {
        this.lbl1wariShuryoYmdValue = lbl1wariShuryoYmdValue;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtHakkobi() {
        return this.getPanelHakko().getTxtHakkobi();
    }

    @JsonIgnore
    public void  setTxtHakkobi(TextBoxDate txtHakkobi) {
        this.getPanelHakko().setTxtHakkobi(txtHakkobi);
    }

    @JsonIgnore
    public TextBoxDate getTxtKofubi() {
        return this.getPanelHakko().getTxtKofubi();
    }

    @JsonIgnore
    public void  setTxtKofubi(TextBoxDate txtKofubi) {
        this.getPanelHakko().setTxtKofubi(txtKofubi);
    }

    @JsonIgnore
    public DropDownList getDdlKofuJiyu() {
        return this.getPanelHakko().getDdlKofuJiyu();
    }

    @JsonIgnore
    public void  setDdlKofuJiyu(DropDownList ddlKofuJiyu) {
        this.getPanelHakko().setDdlKofuJiyu(ddlKofuJiyu);
    }

    @JsonIgnore
    public tblShutsuryokuNaiyoDiv getTblShutsuryokuNaiyo() {
        return this.getPanelShutsuryokuNaiyo().getTblShutsuryokuNaiyo();
    }

    @JsonIgnore
    public void  setTblShutsuryokuNaiyo(tblShutsuryokuNaiyoDiv tblShutsuryokuNaiyo) {
        this.getPanelShutsuryokuNaiyo().setTblShutsuryokuNaiyo(tblShutsuryokuNaiyo);
    }

    @JsonIgnore
    public Label getLblFutanWariai() {
        return this.getPanelShutsuryokuNaiyo().getTblShutsuryokuNaiyo().getLblFutanWariai();
    }

    @JsonIgnore
    public Label getLblTekiyoKikan() {
        return this.getPanelShutsuryokuNaiyo().getTblShutsuryokuNaiyo().getLblTekiyoKikan();
    }

    @JsonIgnore
    public Label getLbl2wari() {
        return this.getPanelShutsuryokuNaiyo().getTblShutsuryokuNaiyo().getLbl2wari();
    }

    @JsonIgnore
    public Label getLbl2wariKaishibi() {
        return this.getPanelShutsuryokuNaiyo().getTblShutsuryokuNaiyo().getLbl2wariKaishibi();
    }

    @JsonIgnore
    public Label getLbl2wariKaishiYmd() {
        return this.getPanelShutsuryokuNaiyo().getTblShutsuryokuNaiyo().getLbl2wariKaishiYmd();
    }

    @JsonIgnore
    public Label getLbl2wariShuryobi() {
        return this.getPanelShutsuryokuNaiyo().getTblShutsuryokuNaiyo().getLbl2wariShuryobi();
    }

    @JsonIgnore
    public Label getLbl2wariShuryoYmd() {
        return this.getPanelShutsuryokuNaiyo().getTblShutsuryokuNaiyo().getLbl2wariShuryoYmd();
    }

    @JsonIgnore
    public Label getLbl1wari() {
        return this.getPanelShutsuryokuNaiyo().getTblShutsuryokuNaiyo().getLbl1wari();
    }

    @JsonIgnore
    public Label getLbl1wariKaishibi() {
        return this.getPanelShutsuryokuNaiyo().getTblShutsuryokuNaiyo().getLbl1wariKaishibi();
    }

    @JsonIgnore
    public Label getLbl1wariKaishiYmd() {
        return this.getPanelShutsuryokuNaiyo().getTblShutsuryokuNaiyo().getLbl1wariKaishiYmd();
    }

    @JsonIgnore
    public Label getLbl1wariShuryobi() {
        return this.getPanelShutsuryokuNaiyo().getTblShutsuryokuNaiyo().getLbl1wariShuryobi();
    }

    @JsonIgnore
    public Label getLbl1wariShuryoYmd() {
        return this.getPanelShutsuryokuNaiyo().getTblShutsuryokuNaiyo().getLbl1wariShuryoYmd();
    }

    // </editor-fold>
}
