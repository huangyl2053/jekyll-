package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.HikazeiNenkinKensaku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HikazeiNenkinKensaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class HikazeiNenkinKensakuDiv extends Panel implements IHikazeiNenkinKensakuDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshano")
    private TextBox txtHihokenshano;
    @JsonProperty("txtTaishom")
    private TextBox txtTaishom;
    @JsonProperty("dgHikazeNenkinKensaku")
    private DataGrid<dgHikazeNenkinKensaku_Row> dgHikazeNenkinKensaku;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHihokenshano
     * @return txtHihokenshano
     */
    @JsonProperty("txtHihokenshano")
    public TextBox getTxtHihokenshano() {
        return txtHihokenshano;
    }

    /*
     * settxtHihokenshano
     * @param txtHihokenshano txtHihokenshano
     */
    @JsonProperty("txtHihokenshano")
    public void setTxtHihokenshano(TextBox txtHihokenshano) {
        this.txtHihokenshano = txtHihokenshano;
    }

    /*
     * gettxtTaishom
     * @return txtTaishom
     */
    @JsonProperty("txtTaishom")
    public TextBox getTxtTaishom() {
        return txtTaishom;
    }

    /*
     * settxtTaishom
     * @param txtTaishom txtTaishom
     */
    @JsonProperty("txtTaishom")
    public void setTxtTaishom(TextBox txtTaishom) {
        this.txtTaishom = txtTaishom;
    }

    /*
     * getdgHikazeNenkinKensaku
     * @return dgHikazeNenkinKensaku
     */
    @JsonProperty("dgHikazeNenkinKensaku")
    public DataGrid<dgHikazeNenkinKensaku_Row> getDgHikazeNenkinKensaku() {
        return dgHikazeNenkinKensaku;
    }

    /*
     * setdgHikazeNenkinKensaku
     * @param dgHikazeNenkinKensaku dgHikazeNenkinKensaku
     */
    @JsonProperty("dgHikazeNenkinKensaku")
    public void setDgHikazeNenkinKensaku(DataGrid<dgHikazeNenkinKensaku_Row> dgHikazeNenkinKensaku) {
        this.dgHikazeNenkinKensaku = dgHikazeNenkinKensaku;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
