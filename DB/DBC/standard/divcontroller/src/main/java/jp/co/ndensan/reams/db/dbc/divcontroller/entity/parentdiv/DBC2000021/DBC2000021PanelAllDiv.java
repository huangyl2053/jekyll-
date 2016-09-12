package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * DBC2000021PanelAll のクラスファイル
 *
 * @reamsid_L DBC-5010-010 lihang
 */
public class DBC2000021PanelAllDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("ddlNendo")
    private DropDownList ddlNendo;
    @JsonProperty("txtKijunbi")
    private TextBoxDate txtKijunbi;
    @JsonProperty("PanelNote")
    private PanelNoteDiv PanelNote;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("ccdKaigoAtenaInfo")
    private KaigoAtenaInfoDiv ccdKaigoAtenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getddlNendo
     * @return ddlNendo
     */
    @JsonProperty("ddlNendo")
    public DropDownList getDdlNendo() {
        return ddlNendo;
    }

    /*
     * setddlNendo
     * @param ddlNendo ddlNendo
     */
    @JsonProperty("ddlNendo")
    public void setDdlNendo(DropDownList ddlNendo) {
        this.ddlNendo = ddlNendo;
    }

    /*
     * gettxtKijunbi
     * @return txtKijunbi
     */
    @JsonProperty("txtKijunbi")
    public TextBoxDate getTxtKijunbi() {
        return txtKijunbi;
    }

    /*
     * settxtKijunbi
     * @param txtKijunbi txtKijunbi
     */
    @JsonProperty("txtKijunbi")
    public void setTxtKijunbi(TextBoxDate txtKijunbi) {
        this.txtKijunbi = txtKijunbi;
    }

    /*
     * getPanelNote
     * @return PanelNote
     */
    @JsonProperty("PanelNote")
    public PanelNoteDiv getPanelNote() {
        return PanelNote;
    }

    /*
     * setPanelNote
     * @param PanelNote PanelNote
     */
    @JsonProperty("PanelNote")
    public void setPanelNote(PanelNoteDiv PanelNote) {
        this.PanelNote = PanelNote;
    }

    /*
     * getccdKaigoShikakuKihon
     * @return ccdKaigoShikakuKihon
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
    }

    /*
     * getccdKaigoAtenaInfo
     * @return ccdKaigoAtenaInfo
     */
    @JsonProperty("ccdKaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return ccdKaigoAtenaInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblNote1() {
        return this.getPanelNote().getLblNote1();
    }

    @JsonIgnore
    public void setLblNote1(Label lblNote1) {
        this.getPanelNote().setLblNote1(lblNote1);
    }

    @JsonIgnore
    public Label getLblNote2() {
        return this.getPanelNote().getLblNote2();
    }

    @JsonIgnore
    public void setLblNote2(Label lblNote2) {
        this.getPanelNote().setLblNote2(lblNote2);
    }

    // </editor-fold>
}
