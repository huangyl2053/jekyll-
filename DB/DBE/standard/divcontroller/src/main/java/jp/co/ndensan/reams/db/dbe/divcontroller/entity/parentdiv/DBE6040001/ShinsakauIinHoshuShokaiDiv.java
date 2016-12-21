package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6040001;
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
 * ShinsakauIinHoshuShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakauIinHoshuShokaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinsakaiKaisaibi")
    private ShinsakaiKaisaibiDiv ShinsakaiKaisaibi;
    @JsonProperty("ShinsakaiIinHoshu")
    private ShinsakaiIinHoshuDiv ShinsakaiIinHoshu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinsakaiKaisaibi
     * @return ShinsakaiKaisaibi
     */
    @JsonProperty("ShinsakaiKaisaibi")
    public ShinsakaiKaisaibiDiv getShinsakaiKaisaibi() {
        return ShinsakaiKaisaibi;
    }

    /*
     * setShinsakaiKaisaibi
     * @param ShinsakaiKaisaibi ShinsakaiKaisaibi
     */
    @JsonProperty("ShinsakaiKaisaibi")
    public void setShinsakaiKaisaibi(ShinsakaiKaisaibiDiv ShinsakaiKaisaibi) {
        this.ShinsakaiKaisaibi = ShinsakaiKaisaibi;
    }

    /*
     * getShinsakaiIinHoshu
     * @return ShinsakaiIinHoshu
     */
    @JsonProperty("ShinsakaiIinHoshu")
    public ShinsakaiIinHoshuDiv getShinsakaiIinHoshu() {
        return ShinsakaiIinHoshu;
    }

    /*
     * setShinsakaiIinHoshu
     * @param ShinsakaiIinHoshu ShinsakaiIinHoshu
     */
    @JsonProperty("ShinsakaiIinHoshu")
    public void setShinsakaiIinHoshu(ShinsakaiIinHoshuDiv ShinsakaiIinHoshu) {
        this.ShinsakaiIinHoshu = ShinsakaiIinHoshu;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtShinsakaiKaisaiYMView() {
        return this.getShinsakaiIinHoshu().getTxtShinsakaiKaisaiYMView();
    }

    @JsonIgnore
    public void  setTxtShinsakaiKaisaiYMView(TextBoxDate txtShinsakaiKaisaiYMView) {
        this.getShinsakaiIinHoshu().setTxtShinsakaiKaisaiYMView(txtShinsakaiKaisaiYMView);
    }

    @JsonIgnore
    public DataGrid<dgShinsakaiIinHoshu_Row> getDgShinsakaiIinHoshu() {
        return this.getShinsakaiIinHoshu().getDgShinsakaiIinHoshu();
    }

    @JsonIgnore
    public void  setDgShinsakaiIinHoshu(DataGrid<dgShinsakaiIinHoshu_Row> dgShinsakaiIinHoshu) {
        this.getShinsakaiIinHoshu().setDgShinsakaiIinHoshu(dgShinsakaiIinHoshu);
    }

    @JsonIgnore
    public Label getLblLegend() {
        return this.getShinsakaiIinHoshu().getLblLegend();
    }

    @JsonIgnore
    public void  setLblLegend(Label lblLegend) {
        this.getShinsakaiIinHoshu().setLblLegend(lblLegend);
    }

    @JsonIgnore
    public TextBoxNum getTxtTotalCount() {
        return this.getShinsakaiIinHoshu().getTxtTotalCount();
    }

    @JsonIgnore
    public void  setTxtTotalCount(TextBoxNum txtTotalCount) {
        this.getShinsakaiIinHoshu().setTxtTotalCount(txtTotalCount);
    }

    @JsonIgnore
    public TextBoxNum getTxtShinsaKaisu() {
        return this.getShinsakaiIinHoshu().getTxtShinsaKaisu();
    }

    @JsonIgnore
    public void  setTxtShinsaKaisu(TextBoxNum txtShinsaKaisu) {
        this.getShinsakaiIinHoshu().setTxtShinsaKaisu(txtShinsaKaisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHoshuSogaku() {
        return this.getShinsakaiIinHoshu().getTxtHoshuSogaku();
    }

    @JsonIgnore
    public void  setTxtHoshuSogaku(TextBoxNum txtHoshuSogaku) {
        this.getShinsakaiIinHoshu().setTxtHoshuSogaku(txtHoshuSogaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaHiyo() {
        return this.getShinsakaiIinHoshu().getTxtSonotaHiyo();
    }

    @JsonIgnore
    public void  setTxtSonotaHiyo(TextBoxNum txtSonotaHiyo) {
        this.getShinsakaiIinHoshu().setTxtSonotaHiyo(txtSonotaHiyo);
    }

    @JsonIgnore
    public TextBoxNum getTxtZeiKojoGaku() {
        return this.getShinsakaiIinHoshu().getTxtZeiKojoGaku();
    }

    @JsonIgnore
    public void  setTxtZeiKojoGaku(TextBoxNum txtZeiKojoGaku) {
        this.getShinsakaiIinHoshu().setTxtZeiKojoGaku(txtZeiKojoGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtHoshuGokei() {
        return this.getShinsakaiIinHoshu().getTxtHoshuGokei();
    }

    @JsonIgnore
    public void  setTxtHoshuGokei(TextBoxNum txtHoshuGokei) {
        this.getShinsakaiIinHoshu().setTxtHoshuGokei(txtHoshuGokei);
    }

    // </editor-fold>
}
