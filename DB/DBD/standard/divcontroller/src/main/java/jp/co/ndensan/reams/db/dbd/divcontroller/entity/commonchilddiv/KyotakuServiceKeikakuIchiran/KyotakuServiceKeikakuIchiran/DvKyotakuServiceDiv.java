package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.KyotakuServiceKeikakuIchiran.KyotakuServiceKeikakuIchiran;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DvKyotakuService のクラスファイル 
 * 
 * @author 自動生成
 */
public class DvKyotakuServiceDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShikyuGendoGaku")
    private TextBoxNum txtShikyuGendoGaku;
    @JsonProperty("txtGendoKanriKikan")
    private TextBoxDateRange txtGendoKanriKikan;
    @JsonProperty("tankiNyushoRiyoNissu")
    private tankiNyushoRiyoNissuDiv tankiNyushoRiyoNissu;
    @JsonProperty("btnShuruiGendoGakuKakunin")
    private Button btnShuruiGendoGakuKakunin;
    @JsonProperty("dgKyotakuService")
    private DataGrid<dgKyotakuService_Row> dgKyotakuService;
    @JsonProperty("btnKyotakuServiceClose")
    private Button btnKyotakuServiceClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShikyuGendoGaku
     * @return txtShikyuGendoGaku
     */
    @JsonProperty("txtShikyuGendoGaku")
    public TextBoxNum getTxtShikyuGendoGaku() {
        return txtShikyuGendoGaku;
    }

    /*
     * settxtShikyuGendoGaku
     * @param txtShikyuGendoGaku txtShikyuGendoGaku
     */
    @JsonProperty("txtShikyuGendoGaku")
    public void setTxtShikyuGendoGaku(TextBoxNum txtShikyuGendoGaku) {
        this.txtShikyuGendoGaku = txtShikyuGendoGaku;
    }

    /*
     * gettxtGendoKanriKikan
     * @return txtGendoKanriKikan
     */
    @JsonProperty("txtGendoKanriKikan")
    public TextBoxDateRange getTxtGendoKanriKikan() {
        return txtGendoKanriKikan;
    }

    /*
     * settxtGendoKanriKikan
     * @param txtGendoKanriKikan txtGendoKanriKikan
     */
    @JsonProperty("txtGendoKanriKikan")
    public void setTxtGendoKanriKikan(TextBoxDateRange txtGendoKanriKikan) {
        this.txtGendoKanriKikan = txtGendoKanriKikan;
    }

    /*
     * gettankiNyushoRiyoNissu
     * @return tankiNyushoRiyoNissu
     */
    @JsonProperty("tankiNyushoRiyoNissu")
    public tankiNyushoRiyoNissuDiv getTankiNyushoRiyoNissu() {
        return tankiNyushoRiyoNissu;
    }

    /*
     * settankiNyushoRiyoNissu
     * @param tankiNyushoRiyoNissu tankiNyushoRiyoNissu
     */
    @JsonProperty("tankiNyushoRiyoNissu")
    public void setTankiNyushoRiyoNissu(tankiNyushoRiyoNissuDiv tankiNyushoRiyoNissu) {
        this.tankiNyushoRiyoNissu = tankiNyushoRiyoNissu;
    }

    /*
     * getbtnShuruiGendoGakuKakunin
     * @return btnShuruiGendoGakuKakunin
     */
    @JsonProperty("btnShuruiGendoGakuKakunin")
    public Button getBtnShuruiGendoGakuKakunin() {
        return btnShuruiGendoGakuKakunin;
    }

    /*
     * setbtnShuruiGendoGakuKakunin
     * @param btnShuruiGendoGakuKakunin btnShuruiGendoGakuKakunin
     */
    @JsonProperty("btnShuruiGendoGakuKakunin")
    public void setBtnShuruiGendoGakuKakunin(Button btnShuruiGendoGakuKakunin) {
        this.btnShuruiGendoGakuKakunin = btnShuruiGendoGakuKakunin;
    }

    /*
     * getdgKyotakuService
     * @return dgKyotakuService
     */
    @JsonProperty("dgKyotakuService")
    public DataGrid<dgKyotakuService_Row> getDgKyotakuService() {
        return dgKyotakuService;
    }

    /*
     * setdgKyotakuService
     * @param dgKyotakuService dgKyotakuService
     */
    @JsonProperty("dgKyotakuService")
    public void setDgKyotakuService(DataGrid<dgKyotakuService_Row> dgKyotakuService) {
        this.dgKyotakuService = dgKyotakuService;
    }

    /*
     * getbtnKyotakuServiceClose
     * @return btnKyotakuServiceClose
     */
    @JsonProperty("btnKyotakuServiceClose")
    public Button getBtnKyotakuServiceClose() {
        return btnKyotakuServiceClose;
    }

    /*
     * setbtnKyotakuServiceClose
     * @param btnKyotakuServiceClose btnKyotakuServiceClose
     */
    @JsonProperty("btnKyotakuServiceClose")
    public void setBtnKyotakuServiceClose(Button btnKyotakuServiceClose) {
        this.btnKyotakuServiceClose = btnKyotakuServiceClose;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNum getTxtZengetsuMadeRiyoNissu() {
        return this.getTankiNyushoRiyoNissu().getTxtZengetsuMadeRiyoNissu();
    }

    @JsonIgnore
    public void  setTxtZengetsuMadeRiyoNissu(TextBoxNum txtZengetsuMadeRiyoNissu) {
        this.getTankiNyushoRiyoNissu().setTxtZengetsuMadeRiyoNissu(txtZengetsuMadeRiyoNissu);
    }

    @JsonIgnore
    public TextBoxNum getTxtTogetsuKeikakuRiyoNissu() {
        return this.getTankiNyushoRiyoNissu().getTxtTogetsuKeikakuRiyoNissu();
    }

    @JsonIgnore
    public void  setTxtTogetsuKeikakuRiyoNissu(TextBoxNum txtTogetsuKeikakuRiyoNissu) {
        this.getTankiNyushoRiyoNissu().setTxtTogetsuKeikakuRiyoNissu(txtTogetsuKeikakuRiyoNissu);
    }

    @JsonIgnore
    public TextBoxNum getTxtRuisekiRiyoNissu() {
        return this.getTankiNyushoRiyoNissu().getTxtRuisekiRiyoNissu();
    }

    @JsonIgnore
    public void  setTxtRuisekiRiyoNissu(TextBoxNum txtRuisekiRiyoNissu) {
        this.getTankiNyushoRiyoNissu().setTxtRuisekiRiyoNissu(txtRuisekiRiyoNissu);
    }

    // </editor-fold>
}
