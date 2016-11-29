package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplJikofutangakuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplJikofutangakuJohoDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblJikofutangaku")
    private Label lblJikofutangaku;
    @JsonProperty("tblJikofutangaku")
    private tblJikofutangakuDiv tblJikofutangaku;
    @JsonProperty("tblJikofutangaku2")
    private tblJikofutangaku2Div tblJikofutangaku2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblJikofutangaku
     * @return lblJikofutangaku
     */
    @JsonProperty("lblJikofutangaku")
    public Label getLblJikofutangaku() {
        return lblJikofutangaku;
    }

    /*
     * setlblJikofutangaku
     * @param lblJikofutangaku lblJikofutangaku
     */
    @JsonProperty("lblJikofutangaku")
    public void setLblJikofutangaku(Label lblJikofutangaku) {
        this.lblJikofutangaku = lblJikofutangaku;
    }

    /*
     * gettblJikofutangaku
     * @return tblJikofutangaku
     */
    @JsonProperty("tblJikofutangaku")
    public tblJikofutangakuDiv getTblJikofutangaku() {
        return tblJikofutangaku;
    }

    /*
     * settblJikofutangaku
     * @param tblJikofutangaku tblJikofutangaku
     */
    @JsonProperty("tblJikofutangaku")
    public void setTblJikofutangaku(tblJikofutangakuDiv tblJikofutangaku) {
        this.tblJikofutangaku = tblJikofutangaku;
    }

    /*
     * gettblJikofutangaku2
     * @return tblJikofutangaku2
     */
    @JsonProperty("tblJikofutangaku2")
    public tblJikofutangaku2Div getTblJikofutangaku2() {
        return tblJikofutangaku2;
    }

    /*
     * settblJikofutangaku2
     * @param tblJikofutangaku2 tblJikofutangaku2
     */
    @JsonProperty("tblJikofutangaku2")
    public void setTblJikofutangaku2(tblJikofutangaku2Div tblJikofutangaku2) {
        this.tblJikofutangaku2 = tblJikofutangaku2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblTsuki1() {
        return this.getTblJikofutangaku().getLblTsuki1();
    }

    @JsonIgnore
    public Label getLblJikofutangaku1() {
        return this.getTblJikofutangaku().getLblJikofutangaku1();
    }

    @JsonIgnore
    public Label getLblUchiFutangaku1() {
        return this.getTblJikofutangaku().getLblUchiFutangaku1();
    }

    @JsonIgnore
    public Label getLbl8Gatsu() {
        return this.getTblJikofutangaku().getLbl8Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku8() {
        return this.getTblJikofutangaku().getTxtJikofutangaku8();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku8() {
        return this.getTblJikofutangaku().getTxtUchiFutangaku8();
    }

    @JsonIgnore
    public Label getLbl9Gatsu() {
        return this.getTblJikofutangaku().getLbl9Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku9() {
        return this.getTblJikofutangaku().getTxtJikofutangaku9();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku9() {
        return this.getTblJikofutangaku().getTxtUchiFutangaku9();
    }

    @JsonIgnore
    public Label getLbl10Gatsu() {
        return this.getTblJikofutangaku().getLbl10Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku10() {
        return this.getTblJikofutangaku().getTxtJikofutangaku10();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku10() {
        return this.getTblJikofutangaku().getTxtUchiFutangaku10();
    }

    @JsonIgnore
    public Label getLbl11Gatsu() {
        return this.getTblJikofutangaku().getLbl11Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku11() {
        return this.getTblJikofutangaku().getTxtJikofutangaku11();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku11() {
        return this.getTblJikofutangaku().getTxtUchiFutangaku11();
    }

    @JsonIgnore
    public Label getLbl12Gatsu() {
        return this.getTblJikofutangaku().getLbl12Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku12() {
        return this.getTblJikofutangaku().getTxtJikofutangaku12();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku12() {
        return this.getTblJikofutangaku().getTxtUchiFutangaku12();
    }

    @JsonIgnore
    public Label getLbl1Gatsu() {
        return this.getTblJikofutangaku().getLbl1Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku1() {
        return this.getTblJikofutangaku().getTxtJikofutangaku1();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku1() {
        return this.getTblJikofutangaku().getTxtUchiFutangaku1();
    }

    @JsonIgnore
    public Label getLblTsuki2() {
        return this.getTblJikofutangaku2().getLblTsuki2();
    }

    @JsonIgnore
    public Label getLblJikofutangaku2() {
        return this.getTblJikofutangaku2().getLblJikofutangaku2();
    }

    @JsonIgnore
    public Label getLblUchiFutangaku2() {
        return this.getTblJikofutangaku2().getLblUchiFutangaku2();
    }

    @JsonIgnore
    public Label getLbl2Gatsu() {
        return this.getTblJikofutangaku2().getLbl2Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku2() {
        return this.getTblJikofutangaku2().getTxtJikofutangaku2();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku2() {
        return this.getTblJikofutangaku2().getTxtUchiFutangaku2();
    }

    @JsonIgnore
    public Label getLbl3Gatsu() {
        return this.getTblJikofutangaku2().getLbl3Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku3() {
        return this.getTblJikofutangaku2().getTxtJikofutangaku3();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku3() {
        return this.getTblJikofutangaku2().getTxtUchiFutangaku3();
    }

    @JsonIgnore
    public Label getLbl4Gatsu() {
        return this.getTblJikofutangaku2().getLbl4Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku4() {
        return this.getTblJikofutangaku2().getTxtJikofutangaku4();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku4() {
        return this.getTblJikofutangaku2().getTxtUchiFutangaku4();
    }

    @JsonIgnore
    public Label getLbl5Gatsu() {
        return this.getTblJikofutangaku2().getLbl5Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku5() {
        return this.getTblJikofutangaku2().getTxtJikofutangaku5();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku5() {
        return this.getTblJikofutangaku2().getTxtUchiFutangaku5();
    }

    @JsonIgnore
    public Label getLbl6Gatsu() {
        return this.getTblJikofutangaku2().getLbl6Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku6() {
        return this.getTblJikofutangaku2().getTxtJikofutangaku6();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku6() {
        return this.getTblJikofutangaku2().getTxtUchiFutangaku6();
    }

    @JsonIgnore
    public Label getLbl7Gatsu() {
        return this.getTblJikofutangaku2().getLbl7Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku7() {
        return this.getTblJikofutangaku2().getTxtJikofutangaku7();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku7() {
        return this.getTblJikofutangaku2().getTxtUchiFutangaku7();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangakuGokei() {
        return this.getTblJikofutangaku2().getTxtJikofutangakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangakuGokei() {
        return this.getTblJikofutangaku2().getTxtUchiFutangakuGokei();
    }

    // </editor-fold>
}
