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
 * tbpE のクラスファイル 
 * 
 * @author 自動生成
 */
public class tbpEDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celE11")
    private celE11AttbpE celE11;
    @JsonProperty("celE12")
    private celE12AttbpE celE12;
    @JsonProperty("celE22")
    private celE22AttbpE celE22;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBoxNum getTxtTeishotokushaIKensu() {
        return this.celE12.getTxtTeishotokushaIKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtTeishotokushaIKyufugaku() {
        return this.celE22.getTxtTeishotokushaIKyufugaku();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelE11
     * @return celE11
     */
    @JsonProperty("celE11")
    private celE11AttbpE getCelE11() {
        return celE11;
    }

    /*
     * setcelE11
     * @param celE11 celE11
     */
    @JsonProperty("celE11")
    private void setCelE11(celE11AttbpE celE11) {
        this.celE11 = celE11;
    }

    /*
     * getcelE12
     * @return celE12
     */
    @JsonProperty("celE12")
    private celE12AttbpE getCelE12() {
        return celE12;
    }

    /*
     * setcelE12
     * @param celE12 celE12
     */
    @JsonProperty("celE12")
    private void setCelE12(celE12AttbpE celE12) {
        this.celE12 = celE12;
    }

    /*
     * getcelE22
     * @return celE22
     */
    @JsonProperty("celE22")
    private celE22AttbpE getCelE22() {
        return celE22;
    }

    /*
     * setcelE22
     * @param celE22 celE22
     */
    @JsonProperty("celE22")
    private void setCelE22(celE22AttbpE celE22) {
        this.celE22 = celE22;
    }

    // </editor-fold>
}
/**
 * celE11 のクラスファイル 
 * 
 * @author 自動生成
 */
class celE11AttbpE extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    // </editor-fold>
}
/**
 * celE12 のクラスファイル 
 * 
 * @author 自動生成
 */
class celE12AttbpE extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtTeishotokushaIKensu")
    private TextBoxNum txtTeishotokushaIKensu;

    /*
     * gettxtTeishotokushaIKensu
     * @return txtTeishotokushaIKensu
     */
    @JsonProperty("txtTeishotokushaIKensu")
    public TextBoxNum getTxtTeishotokushaIKensu() {
        return txtTeishotokushaIKensu;
    }

    /*
     * settxtTeishotokushaIKensu
     * @param txtTeishotokushaIKensu txtTeishotokushaIKensu
     */
    @JsonProperty("txtTeishotokushaIKensu")
    public void setTxtTeishotokushaIKensu(TextBoxNum txtTeishotokushaIKensu) {
        this.txtTeishotokushaIKensu = txtTeishotokushaIKensu;
    }

    // </editor-fold>
}
/**
 * celE22 のクラスファイル 
 * 
 * @author 自動生成
 */
class celE22AttbpE extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtTeishotokushaIKyufugaku")
    private TextBoxNum txtTeishotokushaIKyufugaku;

    /*
     * gettxtTeishotokushaIKyufugaku
     * @return txtTeishotokushaIKyufugaku
     */
    @JsonProperty("txtTeishotokushaIKyufugaku")
    public TextBoxNum getTxtTeishotokushaIKyufugaku() {
        return txtTeishotokushaIKyufugaku;
    }

    /*
     * settxtTeishotokushaIKyufugaku
     * @param txtTeishotokushaIKyufugaku txtTeishotokushaIKyufugaku
     */
    @JsonProperty("txtTeishotokushaIKyufugaku")
    public void setTxtTeishotokushaIKyufugaku(TextBoxNum txtTeishotokushaIKyufugaku) {
        this.txtTeishotokushaIKyufugaku = txtTeishotokushaIKyufugaku;
    }

    // </editor-fold>
}
