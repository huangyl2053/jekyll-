package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GaikyoTokkiInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class GaikyoTokkiInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-17_21-01-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblGaigyoTokkiComment")
    private Label lblGaigyoTokkiComment;
    @JsonProperty("txtGaikyoTokkiNyuroku")
    private TextBoxMultiLine txtGaikyoTokkiNyuroku;
    @JsonProperty("btnTeikeibun")
    private ButtonDialog btnTeikeibun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblGaigyoTokkiComment
     * @return lblGaigyoTokkiComment
     */
    @JsonProperty("lblGaigyoTokkiComment")
    public Label getLblGaigyoTokkiComment() {
        return lblGaigyoTokkiComment;
    }

    /*
     * setlblGaigyoTokkiComment
     * @param lblGaigyoTokkiComment lblGaigyoTokkiComment
     */
    @JsonProperty("lblGaigyoTokkiComment")
    public void setLblGaigyoTokkiComment(Label lblGaigyoTokkiComment) {
        this.lblGaigyoTokkiComment = lblGaigyoTokkiComment;
    }

    /*
     * gettxtGaikyoTokkiNyuroku
     * @return txtGaikyoTokkiNyuroku
     */
    @JsonProperty("txtGaikyoTokkiNyuroku")
    public TextBoxMultiLine getTxtGaikyoTokkiNyuroku() {
        return txtGaikyoTokkiNyuroku;
    }

    /*
     * settxtGaikyoTokkiNyuroku
     * @param txtGaikyoTokkiNyuroku txtGaikyoTokkiNyuroku
     */
    @JsonProperty("txtGaikyoTokkiNyuroku")
    public void setTxtGaikyoTokkiNyuroku(TextBoxMultiLine txtGaikyoTokkiNyuroku) {
        this.txtGaikyoTokkiNyuroku = txtGaikyoTokkiNyuroku;
    }

    /*
     * getbtnTeikeibun
     * @return btnTeikeibun
     */
    @JsonProperty("btnTeikeibun")
    public ButtonDialog getBtnTeikeibun() {
        return btnTeikeibun;
    }

    /*
     * setbtnTeikeibun
     * @param btnTeikeibun btnTeikeibun
     */
    @JsonProperty("btnTeikeibun")
    public void setBtnTeikeibun(ButtonDialog btnTeikeibun) {
        this.btnTeikeibun = btnTeikeibun;
    }

    // </editor-fold>
}
