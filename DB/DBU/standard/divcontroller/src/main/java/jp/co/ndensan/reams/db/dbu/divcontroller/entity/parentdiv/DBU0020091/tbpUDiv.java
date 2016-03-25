package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020091;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

/**
 * tbpU のクラスファイル 
 * 
 * @author 自動生成
 */
public class tbpUDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celU11")
    private celU11AttbpU celU11;
    @JsonProperty("celU12")
    private celU12AttbpU celU12;
    @JsonProperty("celU22")
    private celU22AttbpU celU22;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBoxNum getTxtTeishotokushaIIKensu() {
        return this.celU12.getTxtTeishotokushaIIKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtTeishotokushaIIKyufugaku() {
        return this.celU22.getTxtTeishotokushaIIKyufugaku();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelU11
     * @return celU11
     */
    @JsonProperty("celU11")
    private celU11AttbpU getCelU11() {
        return celU11;
    }

    /*
     * setcelU11
     * @param celU11 celU11
     */
    @JsonProperty("celU11")
    private void setCelU11(celU11AttbpU celU11) {
        this.celU11 = celU11;
    }

    /*
     * getcelU12
     * @return celU12
     */
    @JsonProperty("celU12")
    private celU12AttbpU getCelU12() {
        return celU12;
    }

    /*
     * setcelU12
     * @param celU12 celU12
     */
    @JsonProperty("celU12")
    private void setCelU12(celU12AttbpU celU12) {
        this.celU12 = celU12;
    }

    /*
     * getcelU22
     * @return celU22
     */
    @JsonProperty("celU22")
    private celU22AttbpU getCelU22() {
        return celU22;
    }

    /*
     * setcelU22
     * @param celU22 celU22
     */
    @JsonProperty("celU22")
    private void setCelU22(celU22AttbpU celU22) {
        this.celU22 = celU22;
    }

    // </editor-fold>
}
/**
 * celU11 のクラスファイル 
 * 
 * @author 自動生成
 */
class celU11AttbpU extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    // </editor-fold>
}
/**
 * celU12 のクラスファイル 
 * 
 * @author 自動生成
 */
class celU12AttbpU extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtTeishotokushaIIKensu")
    private TextBoxNum txtTeishotokushaIIKensu;

    /*
     * gettxtTeishotokushaIIKensu
     * @return txtTeishotokushaIIKensu
     */
    @JsonProperty("txtTeishotokushaIIKensu")
    public TextBoxNum getTxtTeishotokushaIIKensu() {
        return txtTeishotokushaIIKensu;
    }

    /*
     * settxtTeishotokushaIIKensu
     * @param txtTeishotokushaIIKensu txtTeishotokushaIIKensu
     */
    @JsonProperty("txtTeishotokushaIIKensu")
    public void setTxtTeishotokushaIIKensu(TextBoxNum txtTeishotokushaIIKensu) {
        this.txtTeishotokushaIIKensu = txtTeishotokushaIIKensu;
    }

    // </editor-fold>
}
/**
 * celU22 のクラスファイル 
 * 
 * @author 自動生成
 */
class celU22AttbpU extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtTeishotokushaIIKyufugaku")
    private TextBoxNum txtTeishotokushaIIKyufugaku;

    /*
     * gettxtTeishotokushaIIKyufugaku
     * @return txtTeishotokushaIIKyufugaku
     */
    @JsonProperty("txtTeishotokushaIIKyufugaku")
    public TextBoxNum getTxtTeishotokushaIIKyufugaku() {
        return txtTeishotokushaIIKyufugaku;
    }

    /*
     * settxtTeishotokushaIIKyufugaku
     * @param txtTeishotokushaIIKyufugaku txtTeishotokushaIIKyufugaku
     */
    @JsonProperty("txtTeishotokushaIIKyufugaku")
    public void setTxtTeishotokushaIIKyufugaku(TextBoxNum txtTeishotokushaIIKyufugaku) {
        this.txtTeishotokushaIIKyufugaku = txtTeishotokushaIIKyufugaku;
    }

    // </editor-fold>
}
