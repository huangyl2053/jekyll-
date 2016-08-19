package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060012;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KagoMoshitatePanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KagoMoshitatePanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("hl")
    private HorizontalLine hl;
    @JsonProperty("Label1")
    private Label Label1;
    @JsonProperty("HorizontalLine2")
    private HorizontalLine HorizontalLine2;
    @JsonProperty("Service")
    private ServiceDiv Service;
    @JsonProperty("CommonKaigoshikakuKihonChildDiv2")
    private KaigoShikakuKihonDiv CommonKaigoshikakuKihonChildDiv2;
    @JsonProperty("CommonKaigpAtenainfoChildDiv1")
    private KaigoAtenaInfoDiv CommonKaigpAtenainfoChildDiv1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gethl
     * @return hl
     */
    @JsonProperty("hl")
    public HorizontalLine getHl() {
        return hl;
    }

    /*
     * sethl
     * @param hl hl
     */
    @JsonProperty("hl")
    public void setHl(HorizontalLine hl) {
        this.hl = hl;
    }

    /*
     * getLabel1
     * @return Label1
     */
    @JsonProperty("Label1")
    public Label getLabel1() {
        return Label1;
    }

    /*
     * setLabel1
     * @param Label1 Label1
     */
    @JsonProperty("Label1")
    public void setLabel1(Label Label1) {
        this.Label1 = Label1;
    }

    /*
     * getHorizontalLine2
     * @return HorizontalLine2
     */
    @JsonProperty("HorizontalLine2")
    public HorizontalLine getHorizontalLine2() {
        return HorizontalLine2;
    }

    /*
     * setHorizontalLine2
     * @param HorizontalLine2 HorizontalLine2
     */
    @JsonProperty("HorizontalLine2")
    public void setHorizontalLine2(HorizontalLine HorizontalLine2) {
        this.HorizontalLine2 = HorizontalLine2;
    }

    /*
     * getService
     * @return Service
     */
    @JsonProperty("Service")
    public ServiceDiv getService() {
        return Service;
    }

    /*
     * setService
     * @param Service Service
     */
    @JsonProperty("Service")
    public void setService(ServiceDiv Service) {
        this.Service = Service;
    }

    /*
     * getCommonKaigoshikakuKihonChildDiv2
     * @return CommonKaigoshikakuKihonChildDiv2
     */
    @JsonProperty("CommonKaigoshikakuKihonChildDiv2")
    public IKaigoShikakuKihonDiv getCommonKaigoshikakuKihonChildDiv2() {
        return CommonKaigoshikakuKihonChildDiv2;
    }

    /*
     * getCommonKaigpAtenainfoChildDiv1
     * @return CommonKaigpAtenainfoChildDiv1
     */
    @JsonProperty("CommonKaigpAtenainfoChildDiv1")
    public IKaigoAtenaInfoDiv getCommonKaigpAtenainfoChildDiv1() {
        return CommonKaigpAtenainfoChildDiv1;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxt1() {
        return this.getService().getTxt1();
    }

    @JsonIgnore
    public void  setTxt1(TextBox txt1) {
        this.getService().setTxt1(txt1);
    }

    @JsonIgnore
    public TextBox getTxt2() {
        return this.getService().getTxt2();
    }

    @JsonIgnore
    public void  setTxt2(TextBox txt2) {
        this.getService().setTxt2(txt2);
    }

    @JsonIgnore
    public TextBox getTxt4() {
        return this.getService().getTxt4();
    }

    @JsonIgnore
    public void  setTxt4(TextBox txt4) {
        this.getService().setTxt4(txt4);
    }

    @JsonIgnore
    public TextBox getTxt5() {
        return this.getService().getTxt5();
    }

    @JsonIgnore
    public void  setTxt5(TextBox txt5) {
        this.getService().setTxt5(txt5);
    }

    @JsonIgnore
    public TextBox getTxt8() {
        return this.getService().getTxt8();
    }

    @JsonIgnore
    public void  setTxt8(TextBox txt8) {
        this.getService().setTxt8(txt8);
    }

    @JsonIgnore
    public TextBoxDateRange getTxt9() {
        return this.getService().getTxt9();
    }

    @JsonIgnore
    public void  setTxt9(TextBoxDateRange txt9) {
        this.getService().setTxt9(txt9);
    }

    @JsonIgnore
    public HorizontalLine getLine1() {
        return this.getService().getLine1();
    }

    @JsonIgnore
    public void  setLine1(HorizontalLine line1) {
        this.getService().setLine1(line1);
    }

    @JsonIgnore
    public DataGrid<dgServive_Row> getDgServive() {
        return this.getService().getDgServive();
    }

    @JsonIgnore
    public void  setDgServive(DataGrid<dgServive_Row> dgServive) {
        this.getService().setDgServive(dgServive);
    }

    @JsonIgnore
    public TextBox getTxt11() {
        return this.getService().getTxt11();
    }

    @JsonIgnore
    public void  setTxt11(TextBox txt11) {
        this.getService().setTxt11(txt11);
    }

    @JsonIgnore
    public TextBox getTxt13() {
        return this.getService().getTxt13();
    }

    @JsonIgnore
    public void  setTxt13(TextBox txt13) {
        this.getService().setTxt13(txt13);
    }

    @JsonIgnore
    public TextBox getTxt12() {
        return this.getService().getTxt12();
    }

    @JsonIgnore
    public void  setTxt12(TextBox txt12) {
        this.getService().setTxt12(txt12);
    }

    @JsonIgnore
    public TextBox getTxt15() {
        return this.getService().getTxt15();
    }

    @JsonIgnore
    public void  setTxt15(TextBox txt15) {
        this.getService().setTxt15(txt15);
    }

    @JsonIgnore
    public TextBox getTxt17() {
        return this.getService().getTxt17();
    }

    @JsonIgnore
    public void  setTxt17(TextBox txt17) {
        this.getService().setTxt17(txt17);
    }

    @JsonIgnore
    public TextBox getTxt18() {
        return this.getService().getTxt18();
    }

    @JsonIgnore
    public void  setTxt18(TextBox txt18) {
        this.getService().setTxt18(txt18);
    }

    // </editor-fold>
}
