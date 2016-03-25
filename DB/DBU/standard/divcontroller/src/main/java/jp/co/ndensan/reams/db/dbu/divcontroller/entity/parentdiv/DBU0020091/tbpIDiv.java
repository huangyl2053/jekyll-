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
 * tbpI のクラスファイル 
 * 
 * @author 自動生成
 */
public class tbpIDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celI11")
    private celI11AttbpI celI11;
    @JsonProperty("celI12")
    private celI12AttbpI celI12;
    @JsonProperty("celI22")
    private celI22AttbpI celI22;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBoxNum getTxtIppanKensu() {
        return this.celI12.getTxtIppanKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtIppanKyufugaku() {
        return this.celI22.getTxtIppanKyufugaku();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelI11
     * @return celI11
     */
    @JsonProperty("celI11")
    private celI11AttbpI getCelI11() {
        return celI11;
    }

    /*
     * setcelI11
     * @param celI11 celI11
     */
    @JsonProperty("celI11")
    private void setCelI11(celI11AttbpI celI11) {
        this.celI11 = celI11;
    }

    /*
     * getcelI12
     * @return celI12
     */
    @JsonProperty("celI12")
    private celI12AttbpI getCelI12() {
        return celI12;
    }

    /*
     * setcelI12
     * @param celI12 celI12
     */
    @JsonProperty("celI12")
    private void setCelI12(celI12AttbpI celI12) {
        this.celI12 = celI12;
    }

    /*
     * getcelI22
     * @return celI22
     */
    @JsonProperty("celI22")
    private celI22AttbpI getCelI22() {
        return celI22;
    }

    /*
     * setcelI22
     * @param celI22 celI22
     */
    @JsonProperty("celI22")
    private void setCelI22(celI22AttbpI celI22) {
        this.celI22 = celI22;
    }

    // </editor-fold>
}
/**
 * celI11 のクラスファイル 
 * 
 * @author 自動生成
 */
class celI11AttbpI extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    // </editor-fold>
}
/**
 * celI12 のクラスファイル 
 * 
 * @author 自動生成
 */
class celI12AttbpI extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtIppanKensu")
    private TextBoxNum txtIppanKensu;

    /*
     * gettxtIppanKensu
     * @return txtIppanKensu
     */
    @JsonProperty("txtIppanKensu")
    public TextBoxNum getTxtIppanKensu() {
        return txtIppanKensu;
    }

    /*
     * settxtIppanKensu
     * @param txtIppanKensu txtIppanKensu
     */
    @JsonProperty("txtIppanKensu")
    public void setTxtIppanKensu(TextBoxNum txtIppanKensu) {
        this.txtIppanKensu = txtIppanKensu;
    }

    // </editor-fold>
}
/**
 * celI22 のクラスファイル 
 * 
 * @author 自動生成
 */
class celI22AttbpI extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtIppanKyufugaku")
    private TextBoxNum txtIppanKyufugaku;

    /*
     * gettxtIppanKyufugaku
     * @return txtIppanKyufugaku
     */
    @JsonProperty("txtIppanKyufugaku")
    public TextBoxNum getTxtIppanKyufugaku() {
        return txtIppanKyufugaku;
    }

    /*
     * settxtIppanKyufugaku
     * @param txtIppanKyufugaku txtIppanKyufugaku
     */
    @JsonProperty("txtIppanKyufugaku")
    public void setTxtIppanKyufugaku(TextBoxNum txtIppanKyufugaku) {
        this.txtIppanKyufugaku = txtIppanKyufugaku;
    }

    // </editor-fold>
}
