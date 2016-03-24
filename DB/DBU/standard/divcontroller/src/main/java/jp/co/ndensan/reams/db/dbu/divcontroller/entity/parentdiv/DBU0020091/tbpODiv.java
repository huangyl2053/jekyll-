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
 * tbpO のクラスファイル 
 * 
 * @author 自動生成
 */
public class tbpODiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celO11")
    private celO11AttbpO celO11;
    @JsonProperty("celO12")
    private celO12AttbpO celO12;
    @JsonProperty("celO22")
    private celO22AttbpO celO22;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBoxNum getTxtGokeiKensu() {
        return this.celO12.getTxtGokeiKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKyufugaku() {
        return this.celO22.getTxtGokeiKyufugaku();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelO11
     * @return celO11
     */
    @JsonProperty("celO11")
    private celO11AttbpO getCelO11() {
        return celO11;
    }

    /*
     * setcelO11
     * @param celO11 celO11
     */
    @JsonProperty("celO11")
    private void setCelO11(celO11AttbpO celO11) {
        this.celO11 = celO11;
    }

    /*
     * getcelO12
     * @return celO12
     */
    @JsonProperty("celO12")
    private celO12AttbpO getCelO12() {
        return celO12;
    }

    /*
     * setcelO12
     * @param celO12 celO12
     */
    @JsonProperty("celO12")
    private void setCelO12(celO12AttbpO celO12) {
        this.celO12 = celO12;
    }

    /*
     * getcelO22
     * @return celO22
     */
    @JsonProperty("celO22")
    private celO22AttbpO getCelO22() {
        return celO22;
    }

    /*
     * setcelO22
     * @param celO22 celO22
     */
    @JsonProperty("celO22")
    private void setCelO22(celO22AttbpO celO22) {
        this.celO22 = celO22;
    }

    // </editor-fold>
}
/**
 * celO11 のクラスファイル 
 * 
 * @author 自動生成
 */
class celO11AttbpO extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    // </editor-fold>
}
/**
 * celO12 のクラスファイル 
 * 
 * @author 自動生成
 */
class celO12AttbpO extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtGokeiKensu")
    private TextBoxNum txtGokeiKensu;

    /*
     * gettxtGokeiKensu
     * @return txtGokeiKensu
     */
    @JsonProperty("txtGokeiKensu")
    public TextBoxNum getTxtGokeiKensu() {
        return txtGokeiKensu;
    }

    /*
     * settxtGokeiKensu
     * @param txtGokeiKensu txtGokeiKensu
     */
    @JsonProperty("txtGokeiKensu")
    public void setTxtGokeiKensu(TextBoxNum txtGokeiKensu) {
        this.txtGokeiKensu = txtGokeiKensu;
    }

    // </editor-fold>
}
/**
 * celO22 のクラスファイル 
 * 
 * @author 自動生成
 */
class celO22AttbpO extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtGokeiKyufugaku")
    private TextBoxNum txtGokeiKyufugaku;

    /*
     * gettxtGokeiKyufugaku
     * @return txtGokeiKyufugaku
     */
    @JsonProperty("txtGokeiKyufugaku")
    public TextBoxNum getTxtGokeiKyufugaku() {
        return txtGokeiKyufugaku;
    }

    /*
     * settxtGokeiKyufugaku
     * @param txtGokeiKyufugaku txtGokeiKyufugaku
     */
    @JsonProperty("txtGokeiKyufugaku")
    public void setTxtGokeiKyufugaku(TextBoxNum txtGokeiKyufugaku) {
        this.txtGokeiKyufugaku = txtGokeiKyufugaku;
    }

    // </editor-fold>
}
