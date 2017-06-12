package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChoisaItakusakiKensaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChoisaItakusakiKensakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-06-01_23-02-42">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChosaItakusaki")
    private TextBoxCode txtChosaItakusaki;
    @JsonProperty("txtSaidaiHyojiKensu")
    private TextBoxNum txtSaidaiHyojiKensu;
    @JsonProperty("btnKensakuJokenClear")
    private Button btnKensakuJokenClear;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChosaItakusaki
     * @return txtChosaItakusaki
     */
    @JsonProperty("txtChosaItakusaki")
    public TextBoxCode getTxtChosaItakusaki() {
        return txtChosaItakusaki;
    }

    /*
     * settxtChosaItakusaki
     * @param txtChosaItakusaki txtChosaItakusaki
     */
    @JsonProperty("txtChosaItakusaki")
    public void setTxtChosaItakusaki(TextBoxCode txtChosaItakusaki) {
        this.txtChosaItakusaki = txtChosaItakusaki;
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
     * getbtnKensakuJokenClear
     * @return btnKensakuJokenClear
     */
    @JsonProperty("btnKensakuJokenClear")
    public Button getBtnKensakuJokenClear() {
        return btnKensakuJokenClear;
    }

    /*
     * setbtnKensakuJokenClear
     * @param btnKensakuJokenClear btnKensakuJokenClear
     */
    @JsonProperty("btnKensakuJokenClear")
    public void setBtnKensakuJokenClear(Button btnKensakuJokenClear) {
        this.btnKensakuJokenClear = btnKensakuJokenClear;
    }

    /*
     * getbtnSearch
     * @return btnSearch
     */
    @JsonProperty("btnSearch")
    public Button getBtnSearch() {
        return btnSearch;
    }

    /*
     * setbtnSearch
     * @param btnSearch btnSearch
     */
    @JsonProperty("btnSearch")
    public void setBtnSearch(Button btnSearch) {
        this.btnSearch = btnSearch;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    // </editor-fold>
}
