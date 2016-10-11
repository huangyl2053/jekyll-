package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuTesuryoSeikyuShukeiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuTesuryoSeikyuShukeiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRiyushoSakuseiTanka")
    private TextBoxNum txtRiyushoSakuseiTanka;
    @JsonProperty("txtRiyushoSakuseiKensu")
    private TextBoxNum txtRiyushoSakuseiKensu;
    @JsonProperty("txtRiyushoSakuseiSeikyuKingaku")
    private TextBoxNum txtRiyushoSakuseiSeikyuKingaku;
    @JsonProperty("btnShukei")
    private Button btnShukei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtRiyushoSakuseiTanka
     * @return txtRiyushoSakuseiTanka
     */
    @JsonProperty("txtRiyushoSakuseiTanka")
    public TextBoxNum getTxtRiyushoSakuseiTanka() {
        return txtRiyushoSakuseiTanka;
    }

    /*
     * settxtRiyushoSakuseiTanka
     * @param txtRiyushoSakuseiTanka txtRiyushoSakuseiTanka
     */
    @JsonProperty("txtRiyushoSakuseiTanka")
    public void setTxtRiyushoSakuseiTanka(TextBoxNum txtRiyushoSakuseiTanka) {
        this.txtRiyushoSakuseiTanka = txtRiyushoSakuseiTanka;
    }

    /*
     * gettxtRiyushoSakuseiKensu
     * @return txtRiyushoSakuseiKensu
     */
    @JsonProperty("txtRiyushoSakuseiKensu")
    public TextBoxNum getTxtRiyushoSakuseiKensu() {
        return txtRiyushoSakuseiKensu;
    }

    /*
     * settxtRiyushoSakuseiKensu
     * @param txtRiyushoSakuseiKensu txtRiyushoSakuseiKensu
     */
    @JsonProperty("txtRiyushoSakuseiKensu")
    public void setTxtRiyushoSakuseiKensu(TextBoxNum txtRiyushoSakuseiKensu) {
        this.txtRiyushoSakuseiKensu = txtRiyushoSakuseiKensu;
    }

    /*
     * gettxtRiyushoSakuseiSeikyuKingaku
     * @return txtRiyushoSakuseiSeikyuKingaku
     */
    @JsonProperty("txtRiyushoSakuseiSeikyuKingaku")
    public TextBoxNum getTxtRiyushoSakuseiSeikyuKingaku() {
        return txtRiyushoSakuseiSeikyuKingaku;
    }

    /*
     * settxtRiyushoSakuseiSeikyuKingaku
     * @param txtRiyushoSakuseiSeikyuKingaku txtRiyushoSakuseiSeikyuKingaku
     */
    @JsonProperty("txtRiyushoSakuseiSeikyuKingaku")
    public void setTxtRiyushoSakuseiSeikyuKingaku(TextBoxNum txtRiyushoSakuseiSeikyuKingaku) {
        this.txtRiyushoSakuseiSeikyuKingaku = txtRiyushoSakuseiSeikyuKingaku;
    }

    /*
     * getbtnShukei
     * @return btnShukei
     */
    @JsonProperty("btnShukei")
    public Button getBtnShukei() {
        return btnShukei;
    }

    /*
     * setbtnShukei
     * @param btnShukei btnShukei
     */
    @JsonProperty("btnShukei")
    public void setBtnShukei(Button btnShukei) {
        this.btnShukei = btnShukei;
    }

    // </editor-fold>
}
