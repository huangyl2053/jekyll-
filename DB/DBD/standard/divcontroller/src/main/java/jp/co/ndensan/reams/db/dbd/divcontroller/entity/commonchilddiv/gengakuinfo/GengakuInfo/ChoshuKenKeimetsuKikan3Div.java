package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gengakuinfo.GengakuInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChoshuKenKeimetsuKikan3 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChoshuKenKeimetsuKikan3Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblChoShushometsu2")
    private Label lblChoShushometsu2;
    @JsonProperty("txtChoShushometsu2")
    private TextBoxNum txtChoShushometsu2;
    @JsonProperty("lblLine")
    private Label lblLine;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblChoShushometsu2
     * @return lblChoShushometsu2
     */
    @JsonProperty("lblChoShushometsu2")
    public Label getLblChoShushometsu2() {
        return lblChoShushometsu2;
    }

    /*
     * setlblChoShushometsu2
     * @param lblChoShushometsu2 lblChoShushometsu2
     */
    @JsonProperty("lblChoShushometsu2")
    public void setLblChoShushometsu2(Label lblChoShushometsu2) {
        this.lblChoShushometsu2 = lblChoShushometsu2;
    }

    /*
     * gettxtChoShushometsu2
     * @return txtChoShushometsu2
     */
    @JsonProperty("txtChoShushometsu2")
    public TextBoxNum getTxtChoShushometsu2() {
        return txtChoShushometsu2;
    }

    /*
     * settxtChoShushometsu2
     * @param txtChoShushometsu2 txtChoShushometsu2
     */
    @JsonProperty("txtChoShushometsu2")
    public void setTxtChoShushometsu2(TextBoxNum txtChoShushometsu2) {
        this.txtChoShushometsu2 = txtChoShushometsu2;
    }

    /*
     * getlblLine
     * @return lblLine
     */
    @JsonProperty("lblLine")
    public Label getLblLine() {
        return lblLine;
    }

    /*
     * setlblLine
     * @param lblLine lblLine
     */
    @JsonProperty("lblLine")
    public void setLblLine(Label lblLine) {
        this.lblLine = lblLine;
    }

    // </editor-fold>
}
