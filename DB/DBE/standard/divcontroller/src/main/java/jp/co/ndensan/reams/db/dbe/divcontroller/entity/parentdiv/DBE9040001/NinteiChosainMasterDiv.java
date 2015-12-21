package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxKana;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * NinteiChosainMaster のクラスファイル
 *
 * @author 自動生成
 */
public class NinteiChosainMasterDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChosainSearch")
    private ChosainSearchDiv ChosainSearch;
    @JsonProperty("ChosainIchiran")
    private ChosainIchiranDiv ChosainIchiran;
    @JsonProperty("ChosainJohoInput")
    private ChosainJohoInputDiv ChosainJohoInput;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChosainSearch
     * @return ChosainSearch
     */
    @JsonProperty("ChosainSearch")
    public ChosainSearchDiv getChosainSearch() {
        return ChosainSearch;
    }

    /*
     * setChosainSearch
     * @param ChosainSearch ChosainSearch
     */
    @JsonProperty("ChosainSearch")
    public void setChosainSearch(ChosainSearchDiv ChosainSearch) {
        this.ChosainSearch = ChosainSearch;
    }

    /*
     * getChosainIchiran
     * @return ChosainIchiran
     */
    @JsonProperty("ChosainIchiran")
    public ChosainIchiranDiv getChosainIchiran() {
        return ChosainIchiran;
    }

    /*
     * setChosainIchiran
     * @param ChosainIchiran ChosainIchiran
     */
    @JsonProperty("ChosainIchiran")
    public void setChosainIchiran(ChosainIchiranDiv ChosainIchiran) {
        this.ChosainIchiran = ChosainIchiran;
    }

    /*
     * getChosainJohoInput
     * @return ChosainJohoInput
     */
    @JsonProperty("ChosainJohoInput")
    public ChosainJohoInputDiv getChosainJohoInput() {
        return ChosainJohoInput;
    }

    /*
     * setChosainJohoInput
     * @param ChosainJohoInput ChosainJohoInput
     */
    @JsonProperty("ChosainJohoInput")
    public void setChosainJohoInput(ChosainJohoInputDiv ChosainJohoInput) {
        this.ChosainJohoInput = ChosainJohoInput;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlSearchShichoson() {
        return this.getChosainSearch().getDdlSearchShichoson();
    }

    @JsonIgnore
    public void setDdlSearchShichoson(DropDownList ddlSearchShichoson) {
        this.getChosainSearch().setDdlSearchShichoson(ddlSearchShichoson);
    }

    @JsonIgnore
    public TextBoxCode getTxtSearchChosaItakusakiCodeFrom() {
        return this.getChosainSearch().getTxtSearchChosaItakusakiCodeFrom();
    }

    @JsonIgnore
    public void setTxtSearchChosaItakusakiCodeFrom(TextBoxCode txtSearchChosaItakusakiCodeFrom) {
        this.getChosainSearch().setTxtSearchChosaItakusakiCodeFrom(txtSearchChosaItakusakiCodeFrom);
    }

    @JsonIgnore
    public TextBoxCode getTxtSearchChosaItakusakiCodeTo() {
        return this.getChosainSearch().getTxtSearchChosaItakusakiCodeTo();
    }

    @JsonIgnore
    public void setTxtSearchChosaItakusakiCodeTo(TextBoxCode txtSearchChosaItakusakiCodeTo) {
        this.getChosainSearch().setTxtSearchChosaItakusakiCodeTo(txtSearchChosaItakusakiCodeTo);
    }

    @JsonIgnore
    public TextBox getTxtSearchChosaItakusakiMeisho() {
        return this.getChosainSearch().getTxtSearchChosaItakusakiMeisho();
    }

    @JsonIgnore
    public void setTxtSearchChosaItakusakiMeisho(TextBox txtSearchChosaItakusakiMeisho) {
        this.getChosainSearch().setTxtSearchChosaItakusakiMeisho(txtSearchChosaItakusakiMeisho);
    }

    @JsonIgnore
    public TextBoxKana getTxtSearchChosaItakusakiKanaMeisho() {
        return this.getChosainSearch().getTxtSearchChosaItakusakiKanaMeisho();
    }

    @JsonIgnore
    public void setTxtSearchChosaItakusakiKanaMeisho(TextBoxKana txtSearchChosaItakusakiKanaMeisho) {
        this.getChosainSearch().setTxtSearchChosaItakusakiKanaMeisho(txtSearchChosaItakusakiKanaMeisho);
    }

    @JsonIgnore
    public TextBoxCode getTxtSearchChosainCodeFrom() {
        return this.getChosainSearch().getTxtSearchChosainCodeFrom();
    }

    @JsonIgnore
    public void setTxtSearchChosainCodeFrom(TextBoxCode txtSearchChosainCodeFrom) {
        this.getChosainSearch().setTxtSearchChosainCodeFrom(txtSearchChosainCodeFrom);
    }

    @JsonIgnore
    public TextBoxCode getTxtSearchChosainCodeTo() {
        return this.getChosainSearch().getTxtSearchChosainCodeTo();
    }

    @JsonIgnore
    public void setTxtSearchChosainCodeTo(TextBoxCode txtSearchChosainCodeTo) {
        this.getChosainSearch().setTxtSearchChosainCodeTo(txtSearchChosainCodeTo);
    }

    @JsonIgnore
    public TextBox getTxtSearchChosainShimei() {
        return this.getChosainSearch().getTxtSearchChosainShimei();
    }

    @JsonIgnore
    public void setTxtSearchChosainShimei(TextBox txtSearchChosainShimei) {
        this.getChosainSearch().setTxtSearchChosainShimei(txtSearchChosainShimei);
    }

    @JsonIgnore
    public TextBoxKana getTxtSearchChosainKanaShimei() {
        return this.getChosainSearch().getTxtSearchChosainKanaShimei();
    }

    @JsonIgnore
    public void setTxtSearchChosainKanaShimei(TextBoxKana txtSearchChosainKanaShimei) {
        this.getChosainSearch().setTxtSearchChosainKanaShimei(txtSearchChosainKanaShimei);
    }

    @JsonIgnore
    public DropDownList getDdlChikuCode() {
        return this.getChosainSearch().getDdlChikuCode();
    }

    @JsonIgnore
    public void setDdlChikuCode(DropDownList ddlChikuCode) {
        this.getChosainSearch().setDdlChikuCode(ddlChikuCode);
    }

    @JsonIgnore
    public RadioButton getRadSearchChosainJokyo() {
        return this.getChosainSearch().getRadSearchChosainJokyo();
    }

    @JsonIgnore
    public void setRadSearchChosainJokyo(RadioButton radSearchChosainJokyo) {
        this.getChosainSearch().setRadSearchChosainJokyo(radSearchChosainJokyo);
    }

    @JsonIgnore
    public TextBoxNum getTxtSaidaiHyojiKensu() {
        return this.getChosainSearch().getTxtSaidaiHyojiKensu();
    }

    @JsonIgnore
    public void setTxtSaidaiHyojiKensu(TextBoxNum txtSaidaiHyojiKensu) {
        this.getChosainSearch().setTxtSaidaiHyojiKensu(txtSaidaiHyojiKensu);
    }

    @JsonIgnore
    public Button getBtnSearchShujii() {
        return this.getChosainSearch().getBtnSearchShujii();
    }

    @JsonIgnore
    public void setBtnSearchShujii(Button btnSearchShujii) {
        this.getChosainSearch().setBtnSearchShujii(btnSearchShujii);
    }

    @JsonIgnore
    public Button getBtnClearKensakuJoken() {
        return this.getChosainSearch().getBtnClearKensakuJoken();
    }

    @JsonIgnore
    public void setBtnClearKensakuJoken(Button btnClearKensakuJoken) {
        this.getChosainSearch().setBtnClearKensakuJoken(btnClearKensakuJoken);
    }

    // </editor-fold>
}
