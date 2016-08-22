package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShoriSetteiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShoriSetteiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShoriSetteiNendo")
    private TextBox txtShoriSetteiNendo;
    @JsonProperty("txtShichosonshitei")
    private TextBox txtShichosonshitei;
    @JsonProperty("dgShoriSettei")
    private DataGrid<dgShoriSettei_Row> dgShoriSettei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShoriSetteiNendo
     * @return txtShoriSetteiNendo
     */
    @JsonProperty("txtShoriSetteiNendo")
    public TextBox getTxtShoriSetteiNendo() {
        return txtShoriSetteiNendo;
    }

    /*
     * settxtShoriSetteiNendo
     * @param txtShoriSetteiNendo txtShoriSetteiNendo
     */
    @JsonProperty("txtShoriSetteiNendo")
    public void setTxtShoriSetteiNendo(TextBox txtShoriSetteiNendo) {
        this.txtShoriSetteiNendo = txtShoriSetteiNendo;
    }

    /*
     * gettxtShichosonshitei
     * @return txtShichosonshitei
     */
    @JsonProperty("txtShichosonshitei")
    public TextBox getTxtShichosonshitei() {
        return txtShichosonshitei;
    }

    /*
     * settxtShichosonshitei
     * @param txtShichosonshitei txtShichosonshitei
     */
    @JsonProperty("txtShichosonshitei")
    public void setTxtShichosonshitei(TextBox txtShichosonshitei) {
        this.txtShichosonshitei = txtShichosonshitei;
    }

    /*
     * getdgShoriSettei
     * @return dgShoriSettei
     */
    @JsonProperty("dgShoriSettei")
    public DataGrid<dgShoriSettei_Row> getDgShoriSettei() {
        return dgShoriSettei;
    }

    /*
     * setdgShoriSettei
     * @param dgShoriSettei dgShoriSettei
     */
    @JsonProperty("dgShoriSettei")
    public void setDgShoriSettei(DataGrid<dgShoriSettei_Row> dgShoriSettei) {
        this.dgShoriSettei = dgShoriSettei;
    }

    // </editor-fold>
}
