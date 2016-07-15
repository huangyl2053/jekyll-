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
 * ChoshuKenKeimetsuKikan4 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChoshuKenKeimetsuKikan4Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblChoShushometsu3")
    private Label lblChoShushometsu3;
    @JsonProperty("txtChoShushometsu3")
    private TextBoxNum txtChoShushometsu3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblChoShushometsu3
     * @return lblChoShushometsu3
     */
    @JsonProperty("lblChoShushometsu3")
    public Label getLblChoShushometsu3() {
        return lblChoShushometsu3;
    }

    /*
     * setlblChoShushometsu3
     * @param lblChoShushometsu3 lblChoShushometsu3
     */
    @JsonProperty("lblChoShushometsu3")
    public void setLblChoShushometsu3(Label lblChoShushometsu3) {
        this.lblChoShushometsu3 = lblChoShushometsu3;
    }

    /*
     * gettxtChoShushometsu3
     * @return txtChoShushometsu3
     */
    @JsonProperty("txtChoShushometsu3")
    public TextBoxNum getTxtChoShushometsu3() {
        return txtChoShushometsu3;
    }

    /*
     * settxtChoShushometsu3
     * @param txtChoShushometsu3 txtChoShushometsu3
     */
    @JsonProperty("txtChoShushometsu3")
    public void setTxtChoShushometsu3(TextBoxNum txtChoShushometsu3) {
        this.txtChoShushometsu3 = txtChoShushometsu3;
    }

    // </editor-fold>
}
