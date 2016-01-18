package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxKana;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * ShujiiIryoKikanMaster のクラスファイル
 *
 * @author 自動生成
 */
public class ShujiiIryoKikanMasterDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShujiiSearch")
    private ShujiiSearchDiv ShujiiSearch;
    @JsonProperty("ShujiiIchiran")
    private ShujiiIchiranDiv ShujiiIchiran;
    @JsonProperty("ShujiiJohoInput")
    private ShujiiJohoInputDiv ShujiiJohoInput;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShujiiSearch
     * @return ShujiiSearch
     */
    @JsonProperty("ShujiiSearch")
    public ShujiiSearchDiv getShujiiSearch() {
        return ShujiiSearch;
    }

    /*
     * setShujiiSearch
     * @param ShujiiSearch ShujiiSearch
     */
    @JsonProperty("ShujiiSearch")
    public void setShujiiSearch(ShujiiSearchDiv ShujiiSearch) {
        this.ShujiiSearch = ShujiiSearch;
    }

    /*
     * getShujiiIchiran
     * @return ShujiiIchiran
     */
    @JsonProperty("ShujiiIchiran")
    public ShujiiIchiranDiv getShujiiIchiran() {
        return ShujiiIchiran;
    }

    /*
     * setShujiiIchiran
     * @param ShujiiIchiran ShujiiIchiran
     */
    @JsonProperty("ShujiiIchiran")
    public void setShujiiIchiran(ShujiiIchiranDiv ShujiiIchiran) {
        this.ShujiiIchiran = ShujiiIchiran;
    }

    /*
     * getShujiiJohoInput
     * @return ShujiiJohoInput
     */
    @JsonProperty("ShujiiJohoInput")
    public ShujiiJohoInputDiv getShujiiJohoInput() {
        return ShujiiJohoInput;
    }

    /*
     * setShujiiJohoInput
     * @param ShujiiJohoInput ShujiiJohoInput
     */
    @JsonProperty("ShujiiJohoInput")
    public void setShujiiJohoInput(ShujiiJohoInputDiv ShujiiJohoInput) {
        this.ShujiiJohoInput = ShujiiJohoInput;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public KaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadSearchJokyoFlag() {
        return this.getShujiiSearch().getRadSearchJokyoFlag();
    }

    @JsonIgnore
    public void setRadSearchJokyoFlag(RadioButton radSearchJokyoFlag) {
        this.getShujiiSearch().setRadSearchJokyoFlag(radSearchJokyoFlag);
    }

    @JsonIgnore
    public TextBoxCode getTxtSearchShujiiIryokikanCodeFrom() {
        return this.getShujiiSearch().getTxtSearchShujiiIryokikanCodeFrom();
    }

    @JsonIgnore
    public void setTxtSearchShujiiIryokikanCodeFrom(TextBoxCode txtSearchShujiiIryokikanCodeFrom) {
        this.getShujiiSearch().setTxtSearchShujiiIryokikanCodeFrom(txtSearchShujiiIryokikanCodeFrom);
    }

    @JsonIgnore
    public TextBoxCode getTxtSearchShujiiIryokikanCodeTo() {
        return this.getShujiiSearch().getTxtSearchShujiiIryokikanCodeTo();
    }

    @JsonIgnore
    public void setTxtSearchShujiiIryokikanCodeTo(TextBoxCode txtSearchShujiiIryokikanCodeTo) {
        this.getShujiiSearch().setTxtSearchShujiiIryokikanCodeTo(txtSearchShujiiIryokikanCodeTo);
    }

    @JsonIgnore
    public TextBox getTxtSearchShujiiIryokikanMeisho() {
        return this.getShujiiSearch().getTxtSearchShujiiIryokikanMeisho();
    }

    @JsonIgnore
    public void setTxtSearchShujiiIryokikanMeisho(TextBox txtSearchShujiiIryokikanMeisho) {
        this.getShujiiSearch().setTxtSearchShujiiIryokikanMeisho(txtSearchShujiiIryokikanMeisho);
    }

    @JsonIgnore
    public TextBoxKana getTxtSearchShujiiIryokikanKanaMeisho() {
        return this.getShujiiSearch().getTxtSearchShujiiIryokikanKanaMeisho();
    }

    @JsonIgnore
    public void setTxtSearchShujiiIryokikanKanaMeisho(TextBoxKana txtSearchShujiiIryokikanKanaMeisho) {
        this.getShujiiSearch().setTxtSearchShujiiIryokikanKanaMeisho(txtSearchShujiiIryokikanKanaMeisho);
    }

    @JsonIgnore
    public TextBoxNum getTxtSaidaiHyojiKensu() {
        return this.getShujiiSearch().getTxtSaidaiHyojiKensu();
    }

    @JsonIgnore
    public void setTxtSaidaiHyojiKensu(TextBoxNum txtSaidaiHyojiKensu) {
        this.getShujiiSearch().setTxtSaidaiHyojiKensu(txtSaidaiHyojiKensu);
    }

    @JsonIgnore
    public Button getBtnSearchShujii() {
        return this.getShujiiSearch().getBtnSearchShujii();
    }

    @JsonIgnore
    public void setBtnSearchShujii(Button btnSearchShujii) {
        this.getShujiiSearch().setBtnSearchShujii(btnSearchShujii);
    }

    @JsonIgnore
    public Button getBtnClearKensakuJoken() {
        return this.getShujiiSearch().getBtnClearKensakuJoken();
    }

    @JsonIgnore
    public void setBtnClearKensakuJoken(Button btnClearKensakuJoken) {
        this.getShujiiSearch().setBtnClearKensakuJoken(btnClearKensakuJoken);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getShujiiSearch().getCcdHokenshaList();
    }

    @JsonIgnore
    public DataGrid<dgShujiiIchiran_Row> getDgShujiiIchiran() {
        return this.getShujiiIchiran().getPanelShujiiIchiranBatchParameter().getDgShujiiIchiran();
    }

    @JsonIgnore
    public void setDgShujiiIchiran(DataGrid<dgShujiiIchiran_Row> dgShujiiIchiran) {
        this.getShujiiIchiran().getPanelShujiiIchiranBatchParameter().setDgShujiiIchiran(dgShujiiIchiran);
    }

    // </editor-fold>
}
