package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6030001;
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
 * NinteiChosaJissekiShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaJissekiShokaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChosaJisshibi")
    private ChosaJisshibiDiv ChosaJisshibi;
    @JsonProperty("NinteiChosaJisseki")
    private NinteiChosaJissekiDiv NinteiChosaJisseki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChosaJisshibi
     * @return ChosaJisshibi
     */
    @JsonProperty("ChosaJisshibi")
    public ChosaJisshibiDiv getChosaJisshibi() {
        return ChosaJisshibi;
    }

    /*
     * setChosaJisshibi
     * @param ChosaJisshibi ChosaJisshibi
     */
    @JsonProperty("ChosaJisshibi")
    public void setChosaJisshibi(ChosaJisshibiDiv ChosaJisshibi) {
        this.ChosaJisshibi = ChosaJisshibi;
    }

    /*
     * getNinteiChosaJisseki
     * @return NinteiChosaJisseki
     */
    @JsonProperty("NinteiChosaJisseki")
    public NinteiChosaJissekiDiv getNinteiChosaJisseki() {
        return NinteiChosaJisseki;
    }

    /*
     * setNinteiChosaJisseki
     * @param NinteiChosaJisseki NinteiChosaJisseki
     */
    @JsonProperty("NinteiChosaJisseki")
    public void setNinteiChosaJisseki(NinteiChosaJissekiDiv NinteiChosaJisseki) {
        this.NinteiChosaJisseki = NinteiChosaJisseki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtChosaJisshibi() {
        return this.getChosaJisshibi().getTxtChosaJisshibi();
    }

    @JsonIgnore
    public void  setTxtChosaJisshibi(TextBoxDateRange txtChosaJisshibi) {
        this.getChosaJisshibi().setTxtChosaJisshibi(txtChosaJisshibi);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxKensu() {
        return this.getChosaJisshibi().getTxtMaxKensu();
    }

    @JsonIgnore
    public void  setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.getChosaJisshibi().setTxtMaxKensu(txtMaxKensu);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getChosaJisshibi().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getChosaJisshibi().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public Button getBtnKensakuClear() {
        return this.getChosaJisshibi().getBtnKensakuClear();
    }

    @JsonIgnore
    public void  setBtnKensakuClear(Button btnKensakuClear) {
        this.getChosaJisshibi().setBtnKensakuClear(btnKensakuClear);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokensya() {
        return this.getChosaJisshibi().getCcdHokensya();
    }

    @JsonIgnore
    public DataGrid<dgNinteiChosaJisseki_Row> getDgNinteiChosaJisseki() {
        return this.getNinteiChosaJisseki().getDgNinteiChosaJisseki();
    }

    @JsonIgnore
    public void  setDgNinteiChosaJisseki(DataGrid<dgNinteiChosaJisseki_Row> dgNinteiChosaJisseki) {
        this.getNinteiChosaJisseki().setDgNinteiChosaJisseki(dgNinteiChosaJisseki);
    }

    // </editor-fold>
}
