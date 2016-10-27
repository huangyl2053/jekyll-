package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5710001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TaishouSha のクラスファイル 
 * 
 * @author 自動生成
 */
public class TaishouShaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblhihokenshano")
    private Label lblhihokenshano;
    @JsonProperty("hihokenshanoFrom")
    private TextBoxCode hihokenshanoFrom;
    @JsonProperty("lblhihokenshaKara")
    private Label lblhihokenshaKara;
    @JsonProperty("hihokenshanoTo")
    private TextBoxCode hihokenshanoTo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblhihokenshano
     * @return lblhihokenshano
     */
    @JsonProperty("lblhihokenshano")
    public Label getLblhihokenshano() {
        return lblhihokenshano;
    }

    /*
     * setlblhihokenshano
     * @param lblhihokenshano lblhihokenshano
     */
    @JsonProperty("lblhihokenshano")
    public void setLblhihokenshano(Label lblhihokenshano) {
        this.lblhihokenshano = lblhihokenshano;
    }

    /*
     * gethihokenshanoFrom
     * @return hihokenshanoFrom
     */
    @JsonProperty("hihokenshanoFrom")
    public TextBoxCode getHihokenshanoFrom() {
        return hihokenshanoFrom;
    }

    /*
     * sethihokenshanoFrom
     * @param hihokenshanoFrom hihokenshanoFrom
     */
    @JsonProperty("hihokenshanoFrom")
    public void setHihokenshanoFrom(TextBoxCode hihokenshanoFrom) {
        this.hihokenshanoFrom = hihokenshanoFrom;
    }

    /*
     * getlblhihokenshaKara
     * @return lblhihokenshaKara
     */
    @JsonProperty("lblhihokenshaKara")
    public Label getLblhihokenshaKara() {
        return lblhihokenshaKara;
    }

    /*
     * setlblhihokenshaKara
     * @param lblhihokenshaKara lblhihokenshaKara
     */
    @JsonProperty("lblhihokenshaKara")
    public void setLblhihokenshaKara(Label lblhihokenshaKara) {
        this.lblhihokenshaKara = lblhihokenshaKara;
    }

    /*
     * gethihokenshanoTo
     * @return hihokenshanoTo
     */
    @JsonProperty("hihokenshanoTo")
    public TextBoxCode getHihokenshanoTo() {
        return hihokenshanoTo;
    }

    /*
     * sethihokenshanoTo
     * @param hihokenshanoTo hihokenshanoTo
     */
    @JsonProperty("hihokenshanoTo")
    public void setHihokenshanoTo(TextBoxCode hihokenshanoTo) {
        this.hihokenshanoTo = hihokenshanoTo;
    }

    // </editor-fold>
}
