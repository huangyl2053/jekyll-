package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZA010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuFuseigoIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuFuseigoIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlDaichoShubetsu")
    private DropDownList ddlDaichoShubetsu;
    @JsonProperty("txtShoriDateTime")
    private TextBox txtShoriDateTime;
    @JsonProperty("chkTaishoGaiHyoji")
    private CheckBoxList chkTaishoGaiHyoji;
    @JsonProperty("dgShikakuFuseigoIchiran")
    private DataGrid<dgShikakuFuseigoIchiran_Row> dgShikakuFuseigoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlDaichoShubetsu
     * @return ddlDaichoShubetsu
     */
    @JsonProperty("ddlDaichoShubetsu")
    public DropDownList getDdlDaichoShubetsu() {
        return ddlDaichoShubetsu;
    }

    /*
     * setddlDaichoShubetsu
     * @param ddlDaichoShubetsu ddlDaichoShubetsu
     */
    @JsonProperty("ddlDaichoShubetsu")
    public void setDdlDaichoShubetsu(DropDownList ddlDaichoShubetsu) {
        this.ddlDaichoShubetsu = ddlDaichoShubetsu;
    }

    /*
     * gettxtShoriDateTime
     * @return txtShoriDateTime
     */
    @JsonProperty("txtShoriDateTime")
    public TextBox getTxtShoriDateTime() {
        return txtShoriDateTime;
    }

    /*
     * settxtShoriDateTime
     * @param txtShoriDateTime txtShoriDateTime
     */
    @JsonProperty("txtShoriDateTime")
    public void setTxtShoriDateTime(TextBox txtShoriDateTime) {
        this.txtShoriDateTime = txtShoriDateTime;
    }

    /*
     * getchkTaishoGaiHyoji
     * @return chkTaishoGaiHyoji
     */
    @JsonProperty("chkTaishoGaiHyoji")
    public CheckBoxList getChkTaishoGaiHyoji() {
        return chkTaishoGaiHyoji;
    }

    /*
     * setchkTaishoGaiHyoji
     * @param chkTaishoGaiHyoji chkTaishoGaiHyoji
     */
    @JsonProperty("chkTaishoGaiHyoji")
    public void setChkTaishoGaiHyoji(CheckBoxList chkTaishoGaiHyoji) {
        this.chkTaishoGaiHyoji = chkTaishoGaiHyoji;
    }

    /*
     * getdgShikakuFuseigoIchiran
     * @return dgShikakuFuseigoIchiran
     */
    @JsonProperty("dgShikakuFuseigoIchiran")
    public DataGrid<dgShikakuFuseigoIchiran_Row> getDgShikakuFuseigoIchiran() {
        return dgShikakuFuseigoIchiran;
    }

    /*
     * setdgShikakuFuseigoIchiran
     * @param dgShikakuFuseigoIchiran dgShikakuFuseigoIchiran
     */
    @JsonProperty("dgShikakuFuseigoIchiran")
    public void setDgShikakuFuseigoIchiran(DataGrid<dgShikakuFuseigoIchiran_Row> dgShikakuFuseigoIchiran) {
        this.dgShikakuFuseigoIchiran = dgShikakuFuseigoIchiran;
    }

    // </editor-fold>
}
