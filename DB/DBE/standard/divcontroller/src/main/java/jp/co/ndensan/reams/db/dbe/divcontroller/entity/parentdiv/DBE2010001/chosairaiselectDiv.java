package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * chosairaiselect のクラスファイル 
 * 
 * @author 自動生成
 */
public class chosairaiselectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btndataoutput")
    private ButtonDownLoad btndataoutput;
    @JsonProperty("btniraiauto")
    private Button btniraiauto;
    @JsonProperty("btnchosadataoutput")
    private ButtonDownLoad btnchosadataoutput;
    @JsonProperty("btnTaOutput")
    private ButtonDialog btnTaOutput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtndataoutput
     * @return btndataoutput
     */
    @JsonProperty("btndataoutput")
    public ButtonDownLoad getBtndataoutput() {
        return btndataoutput;
    }

    /*
     * setbtndataoutput
     * @param btndataoutput btndataoutput
     */
    @JsonProperty("btndataoutput")
    public void setBtndataoutput(ButtonDownLoad btndataoutput) {
        this.btndataoutput = btndataoutput;
    }

    /*
     * getbtniraiauto
     * @return btniraiauto
     */
    @JsonProperty("btniraiauto")
    public Button getBtniraiauto() {
        return btniraiauto;
    }

    /*
     * setbtniraiauto
     * @param btniraiauto btniraiauto
     */
    @JsonProperty("btniraiauto")
    public void setBtniraiauto(Button btniraiauto) {
        this.btniraiauto = btniraiauto;
    }

    /*
     * getbtnchosadataoutput
     * @return btnchosadataoutput
     */
    @JsonProperty("btnchosadataoutput")
    public ButtonDownLoad getBtnchosadataoutput() {
        return btnchosadataoutput;
    }

    /*
     * setbtnchosadataoutput
     * @param btnchosadataoutput btnchosadataoutput
     */
    @JsonProperty("btnchosadataoutput")
    public void setBtnchosadataoutput(ButtonDownLoad btnchosadataoutput) {
        this.btnchosadataoutput = btnchosadataoutput;
    }

    /*
     * getbtnTaOutput
     * @return btnTaOutput
     */
    @JsonProperty("btnTaOutput")
    public ButtonDialog getBtnTaOutput() {
        return btnTaOutput;
    }

    /*
     * setbtnTaOutput
     * @param btnTaOutput btnTaOutput
     */
    @JsonProperty("btnTaOutput")
    public void setBtnTaOutput(ButtonDialog btnTaOutput) {
        this.btnTaOutput = btnTaOutput;
    }

    // </editor-fold>
}
