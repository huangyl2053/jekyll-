package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2270001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * NinteiChosaDataOutput のクラスファイル
 *
 * @author 自動生成
 */
public class NinteiChosaDataOutputDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteiKensakuJyoken")
    private NinteiKensakuJyokenDiv NinteiKensakuJyoken;
    @JsonProperty("NinteiIchiran")
    private NinteiIchiranDiv NinteiIchiran;
    @JsonProperty("btnExcuteFlag")
    private RString btnExcuteFlag;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNinteiKensakuJyoken
     * @return NinteiKensakuJyoken
     */
    @JsonProperty("NinteiKensakuJyoken")
    public NinteiKensakuJyokenDiv getNinteiKensakuJyoken() {
        return NinteiKensakuJyoken;
    }

    /*
     * setNinteiKensakuJyoken
     * @param NinteiKensakuJyoken NinteiKensakuJyoken
     */
    @JsonProperty("NinteiKensakuJyoken")
    public void setNinteiKensakuJyoken(NinteiKensakuJyokenDiv NinteiKensakuJyoken) {
        this.NinteiKensakuJyoken = NinteiKensakuJyoken;
    }

    /*
     * getNinteiIchiran
     * @return NinteiIchiran
     */
    @JsonProperty("NinteiIchiran")
    public NinteiIchiranDiv getNinteiIchiran() {
        return NinteiIchiran;
    }

    /*
     * setNinteiIchiran
     * @param NinteiIchiran NinteiIchiran
     */
    @JsonProperty("NinteiIchiran")
    public void setNinteiIchiran(NinteiIchiranDiv NinteiIchiran) {
        this.NinteiIchiran = NinteiIchiran;
    }

    /*
     * getbtnExcuteFlag
     * @return btnExcuteFlag
     */
    @JsonProperty("btnExcuteFlag")
    public RString getBtnExcuteFlag() {
        return btnExcuteFlag;
    }

    /*
     * setbtnExcuteFlag
     * @param btnExcuteFlag btnExcuteFlag
     */
    @JsonProperty("btnExcuteFlag")
    public void setBtnExcuteFlag(RString btnExcuteFlag) {
        this.btnExcuteFlag = btnExcuteFlag;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IHokenshaListDiv getCcdHokensha() {
        return this.getNinteiKensakuJyoken().getCcdHokensha();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxCount() {
        return this.getNinteiKensakuJyoken().getTxtMaxCount();
    }

    @JsonIgnore
    public void setTxtMaxCount(TextBoxNum txtMaxCount) {
        this.getNinteiKensakuJyoken().setTxtMaxCount(txtMaxCount);
    }

    @JsonIgnore
    public Button getBtnKyufuJissekiSearchClear() {
        return this.getNinteiKensakuJyoken().getBtnKyufuJissekiSearchClear();
    }

    @JsonIgnore
    public void setBtnKyufuJissekiSearchClear(Button btnKyufuJissekiSearchClear) {
        this.getNinteiKensakuJyoken().setBtnKyufuJissekiSearchClear(btnKyufuJissekiSearchClear);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getNinteiKensakuJyoken().getBtnKensaku();
    }

    @JsonIgnore
    public void setBtnKensaku(Button btnKensaku) {
        this.getNinteiKensakuJyoken().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public IChosaItakusakiAndChosainInputDiv getCcdChosaltakusakiAndChosainInput() {
        return this.getNinteiKensakuJyoken().getCcdChosaltakusakiAndChosainInput();
    }

    @JsonIgnore
    public DataGrid<dgNinteiChosaData_Row> getDgNinteiChosaData() {
        return this.getNinteiIchiran().getDgNinteiChosaData();
    }

    @JsonIgnore
    public void setDgNinteiChosaData(DataGrid<dgNinteiChosaData_Row> dgNinteiChosaData) {
        this.getNinteiIchiran().setDgNinteiChosaData(dgNinteiChosaData);
    }

    // </editor-fold>
}
