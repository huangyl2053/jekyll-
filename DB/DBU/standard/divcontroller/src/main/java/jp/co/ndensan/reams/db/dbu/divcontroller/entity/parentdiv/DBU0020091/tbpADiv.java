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
 * tbpA のクラスファイル 
 * 
 * @author 自動生成
 */
public class tbpADiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celA11")
    private celA11AttbpA celA11;
    @JsonProperty("celA12")
    private celA12AttbpA celA12;
    @JsonProperty("celA22")
    private celA22AttbpA celA22;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBoxNum getTxtGenekiKensu() {
        return this.celA12.getTxtGenekiKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGenekiKyufugaku() {
        return this.celA22.getTxtGenekiKyufugaku();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelA11
     * @return celA11
     */
    @JsonProperty("celA11")
    private celA11AttbpA getCelA11() {
        return celA11;
    }

    /*
     * setcelA11
     * @param celA11 celA11
     */
    @JsonProperty("celA11")
    private void setCelA11(celA11AttbpA celA11) {
        this.celA11 = celA11;
    }

    /*
     * getcelA12
     * @return celA12
     */
    @JsonProperty("celA12")
    private celA12AttbpA getCelA12() {
        return celA12;
    }

    /*
     * setcelA12
     * @param celA12 celA12
     */
    @JsonProperty("celA12")
    private void setCelA12(celA12AttbpA celA12) {
        this.celA12 = celA12;
    }

    /*
     * getcelA22
     * @return celA22
     */
    @JsonProperty("celA22")
    private celA22AttbpA getCelA22() {
        return celA22;
    }

    /*
     * setcelA22
     * @param celA22 celA22
     */
    @JsonProperty("celA22")
    private void setCelA22(celA22AttbpA celA22) {
        this.celA22 = celA22;
    }

    // </editor-fold>
}
/**
 * celA11 のクラスファイル 
 * 
 * @author 自動生成
 */
class celA11AttbpA extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    // </editor-fold>
}
/**
 * celA12 のクラスファイル 
 * 
 * @author 自動生成
 */
class celA12AttbpA extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtGenekiKensu")
    private TextBoxNum txtGenekiKensu;

    /*
     * gettxtGenekiKensu
     * @return txtGenekiKensu
     */
    @JsonProperty("txtGenekiKensu")
    public TextBoxNum getTxtGenekiKensu() {
        return txtGenekiKensu;
    }

    /*
     * settxtGenekiKensu
     * @param txtGenekiKensu txtGenekiKensu
     */
    @JsonProperty("txtGenekiKensu")
    public void setTxtGenekiKensu(TextBoxNum txtGenekiKensu) {
        this.txtGenekiKensu = txtGenekiKensu;
    }

    // </editor-fold>
}
/**
 * celA22 のクラスファイル 
 * 
 * @author 自動生成
 */
class celA22AttbpA extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtGenekiKyufugaku")
    private TextBoxNum txtGenekiKyufugaku;

    /*
     * gettxtGenekiKyufugaku
     * @return txtGenekiKyufugaku
     */
    @JsonProperty("txtGenekiKyufugaku")
    public TextBoxNum getTxtGenekiKyufugaku() {
        return txtGenekiKyufugaku;
    }

    /*
     * settxtGenekiKyufugaku
     * @param txtGenekiKyufugaku txtGenekiKyufugaku
     */
    @JsonProperty("txtGenekiKyufugaku")
    public void setTxtGenekiKyufugaku(TextBoxNum txtGenekiKyufugaku) {
        this.txtGenekiKyufugaku = txtGenekiKyufugaku;
    }

    // </editor-fold>
}
