package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PanelNote のクラスファイル 
 * 
 * @author 自動生成
 */
public class PanelNoteDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblNote1")
    private Label lblNote1;
    @JsonProperty("lblNote2")
    private Label lblNote2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblNote1
     * @return lblNote1
     */
    @JsonProperty("lblNote1")
    public Label getLblNote1() {
        return lblNote1;
    }

    /*
     * setlblNote1
     * @param lblNote1 lblNote1
     */
    @JsonProperty("lblNote1")
    public void setLblNote1(Label lblNote1) {
        this.lblNote1 = lblNote1;
    }

    /*
     * getlblNote2
     * @return lblNote2
     */
    @JsonProperty("lblNote2")
    public Label getLblNote2() {
        return lblNote2;
    }

    /*
     * setlblNote2
     * @param lblNote2 lblNote2
     */
    @JsonProperty("lblNote2")
    public void setLblNote2(Label lblNote2) {
        this.lblNote2 = lblNote2;
    }

    // </editor-fold>
}
