package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.IServiceRiyohyoInfoDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoGokeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoRiyoNissuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgServiceRiyohyoList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tabServiceRiyohyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ServiceRiyohyoInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceRiyohyoInfoDiv extends Panel implements IServiceRiyohyoInfoDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTodokedeYMD")
    private TextBoxDate txtTodokedeYMD;
    @JsonProperty("txtTekiyoKikan")
    private TextBoxDateRange txtTekiyoKikan;
    @JsonProperty("txtKeikakuJigyoshaCode")
    private TextBoxCode txtKeikakuJigyoshaCode;
    @JsonProperty("txtKeikakuJigyoshaName")
    private TextBox txtKeikakuJigyoshaName;
    @JsonProperty("txtTaishoYM")
    private TextBoxDate txtTaishoYM;
    @JsonProperty("txtRiyohyoSakuseiYMD")
    private TextBoxDate txtRiyohyoSakuseiYMD;
    @JsonProperty("txtRiyohyoTodokedeYMD")
    private TextBoxDate txtRiyohyoTodokedeYMD;
    @JsonProperty("txtKubunShikyuGendogaku")
    private TextBox txtKubunShikyuGendogaku;
    @JsonProperty("txtRiyohyoSakuseisha")
    private TextBox txtRiyohyoSakuseisha;
    @JsonProperty("txtGendoKanriKikan")
    private TextBoxDateRange txtGendoKanriKikan;
    @JsonProperty("btnZengetsuCopy")
    private Button btnZengetsuCopy;
    @JsonProperty("tabServiceRiyohyo")
    private tabServiceRiyohyoDiv tabServiceRiyohyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtTodokedeYMD")
    public TextBoxDate getTxtTodokedeYMD() {
        return txtTodokedeYMD;
    }

    @JsonProperty("txtTodokedeYMD")
    public void setTxtTodokedeYMD(TextBoxDate txtTodokedeYMD) {
        this.txtTodokedeYMD=txtTodokedeYMD;
    }

    @JsonProperty("txtTekiyoKikan")
    public TextBoxDateRange getTxtTekiyoKikan() {
        return txtTekiyoKikan;
    }

    @JsonProperty("txtTekiyoKikan")
    public void setTxtTekiyoKikan(TextBoxDateRange txtTekiyoKikan) {
        this.txtTekiyoKikan=txtTekiyoKikan;
    }

    @JsonProperty("txtKeikakuJigyoshaCode")
    public TextBoxCode getTxtKeikakuJigyoshaCode() {
        return txtKeikakuJigyoshaCode;
    }

    @JsonProperty("txtKeikakuJigyoshaCode")
    public void setTxtKeikakuJigyoshaCode(TextBoxCode txtKeikakuJigyoshaCode) {
        this.txtKeikakuJigyoshaCode=txtKeikakuJigyoshaCode;
    }

    @JsonProperty("txtKeikakuJigyoshaName")
    public TextBox getTxtKeikakuJigyoshaName() {
        return txtKeikakuJigyoshaName;
    }

    @JsonProperty("txtKeikakuJigyoshaName")
    public void setTxtKeikakuJigyoshaName(TextBox txtKeikakuJigyoshaName) {
        this.txtKeikakuJigyoshaName=txtKeikakuJigyoshaName;
    }

    @JsonProperty("txtTaishoYM")
    public TextBoxDate getTxtTaishoYM() {
        return txtTaishoYM;
    }

    @JsonProperty("txtTaishoYM")
    public void setTxtTaishoYM(TextBoxDate txtTaishoYM) {
        this.txtTaishoYM=txtTaishoYM;
    }

    @JsonProperty("txtRiyohyoSakuseiYMD")
    public TextBoxDate getTxtRiyohyoSakuseiYMD() {
        return txtRiyohyoSakuseiYMD;
    }

    @JsonProperty("txtRiyohyoSakuseiYMD")
    public void setTxtRiyohyoSakuseiYMD(TextBoxDate txtRiyohyoSakuseiYMD) {
        this.txtRiyohyoSakuseiYMD=txtRiyohyoSakuseiYMD;
    }

    @JsonProperty("txtRiyohyoTodokedeYMD")
    public TextBoxDate getTxtRiyohyoTodokedeYMD() {
        return txtRiyohyoTodokedeYMD;
    }

    @JsonProperty("txtRiyohyoTodokedeYMD")
    public void setTxtRiyohyoTodokedeYMD(TextBoxDate txtRiyohyoTodokedeYMD) {
        this.txtRiyohyoTodokedeYMD=txtRiyohyoTodokedeYMD;
    }

    @JsonProperty("txtKubunShikyuGendogaku")
    public TextBox getTxtKubunShikyuGendogaku() {
        return txtKubunShikyuGendogaku;
    }

    @JsonProperty("txtKubunShikyuGendogaku")
    public void setTxtKubunShikyuGendogaku(TextBox txtKubunShikyuGendogaku) {
        this.txtKubunShikyuGendogaku=txtKubunShikyuGendogaku;
    }

    @JsonProperty("txtRiyohyoSakuseisha")
    public TextBox getTxtRiyohyoSakuseisha() {
        return txtRiyohyoSakuseisha;
    }

    @JsonProperty("txtRiyohyoSakuseisha")
    public void setTxtRiyohyoSakuseisha(TextBox txtRiyohyoSakuseisha) {
        this.txtRiyohyoSakuseisha=txtRiyohyoSakuseisha;
    }

    @JsonProperty("txtGendoKanriKikan")
    public TextBoxDateRange getTxtGendoKanriKikan() {
        return txtGendoKanriKikan;
    }

    @JsonProperty("txtGendoKanriKikan")
    public void setTxtGendoKanriKikan(TextBoxDateRange txtGendoKanriKikan) {
        this.txtGendoKanriKikan=txtGendoKanriKikan;
    }

    @JsonProperty("btnZengetsuCopy")
    public Button getBtnZengetsuCopy() {
        return btnZengetsuCopy;
    }

    @JsonProperty("btnZengetsuCopy")
    public void setBtnZengetsuCopy(Button btnZengetsuCopy) {
        this.btnZengetsuCopy=btnZengetsuCopy;
    }

    @JsonProperty("tabServiceRiyohyo")
    public tabServiceRiyohyoDiv getTabServiceRiyohyo() {
        return tabServiceRiyohyo;
    }

    @JsonProperty("tabServiceRiyohyo")
    public void setTabServiceRiyohyo(tabServiceRiyohyoDiv tabServiceRiyohyo) {
        this.tabServiceRiyohyo=tabServiceRiyohyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ServiceRiyohyoDiv getServiceRiyohyo() {
        return this.getTabServiceRiyohyo().getServiceRiyohyo();
    }

    @JsonIgnore
    public void  setServiceRiyohyo(ServiceRiyohyoDiv ServiceRiyohyo) {
        this.getTabServiceRiyohyo().setServiceRiyohyo(ServiceRiyohyo);
    }

    @JsonIgnore
    public Label getLblServiceRiyohyoList() {
        return this.getTabServiceRiyohyo().getServiceRiyohyo().getLblServiceRiyohyoList();
    }

    @JsonIgnore
    public void  setLblServiceRiyohyoList(Label lblServiceRiyohyoList) {
        this.getTabServiceRiyohyo().getServiceRiyohyo().setLblServiceRiyohyoList(lblServiceRiyohyoList);
    }

    @JsonIgnore
    public Button getBtnRiyohyoMeisaiAdd() {
        return this.getTabServiceRiyohyo().getServiceRiyohyo().getBtnRiyohyoMeisaiAdd();
    }

    @JsonIgnore
    public void  setBtnRiyohyoMeisaiAdd(Button btnRiyohyoMeisaiAdd) {
        this.getTabServiceRiyohyo().getServiceRiyohyo().setBtnRiyohyoMeisaiAdd(btnRiyohyoMeisaiAdd);
    }

    @JsonIgnore
    public DataGrid<dgServiceRiyohyoList_Row> getDgServiceRiyohyoList() {
        return this.getTabServiceRiyohyo().getServiceRiyohyo().getDgServiceRiyohyoList();
    }

    @JsonIgnore
    public void  setDgServiceRiyohyoList(DataGrid<dgServiceRiyohyoList_Row> dgServiceRiyohyoList) {
        this.getTabServiceRiyohyo().getServiceRiyohyo().setDgServiceRiyohyoList(dgServiceRiyohyoList);
    }

    @JsonIgnore
    public ServiceRiyohyoBeppyoDiv getServiceRiyohyoBeppyo() {
        return this.getTabServiceRiyohyo().getServiceRiyohyoBeppyo();
    }

    @JsonIgnore
    public void  setServiceRiyohyoBeppyo(ServiceRiyohyoBeppyoDiv ServiceRiyohyoBeppyo) {
        this.getTabServiceRiyohyo().setServiceRiyohyoBeppyo(ServiceRiyohyoBeppyo);
    }

    @JsonIgnore
    public ServiceRiyohyoBeppyoRiyoNissuDiv getServiceRiyohyoBeppyoRiyoNissu() {
        return this.getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoRiyoNissu();
    }

    @JsonIgnore
    public void  setServiceRiyohyoBeppyoRiyoNissu(ServiceRiyohyoBeppyoRiyoNissuDiv ServiceRiyohyoBeppyoRiyoNissu) {
        this.getTabServiceRiyohyo().getServiceRiyohyoBeppyo().setServiceRiyohyoBeppyoRiyoNissu(ServiceRiyohyoBeppyoRiyoNissu);
    }

    @JsonIgnore
    public ServiceRiyohyoBeppyoListDiv getServiceRiyohyoBeppyoList() {
        return this.getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoList();
    }

    @JsonIgnore
    public void  setServiceRiyohyoBeppyoList(ServiceRiyohyoBeppyoListDiv ServiceRiyohyoBeppyoList) {
        this.getTabServiceRiyohyo().getServiceRiyohyoBeppyo().setServiceRiyohyoBeppyoList(ServiceRiyohyoBeppyoList);
    }

    @JsonIgnore
    public ServiceRiyohyoBeppyoMeisaiDiv getServiceRiyohyoBeppyoMeisai() {
        return this.getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoMeisai();
    }

    @JsonIgnore
    public void  setServiceRiyohyoBeppyoMeisai(ServiceRiyohyoBeppyoMeisaiDiv ServiceRiyohyoBeppyoMeisai) {
        this.getTabServiceRiyohyo().getServiceRiyohyoBeppyo().setServiceRiyohyoBeppyoMeisai(ServiceRiyohyoBeppyoMeisai);
    }

    @JsonIgnore
    public ServiceRiyohyoBeppyoGokeiDiv getServiceRiyohyoBeppyoGokei() {
        return this.getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoGokei();
    }

    @JsonIgnore
    public void  setServiceRiyohyoBeppyoGokei(ServiceRiyohyoBeppyoGokeiDiv ServiceRiyohyoBeppyoGokei) {
        this.getTabServiceRiyohyo().getServiceRiyohyoBeppyo().setServiceRiyohyoBeppyoGokei(ServiceRiyohyoBeppyoGokei);
    }

    //--------------- この行より下にコードを追加してください -------------------

}
