package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.DataOutputInfomation;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DataOutputInfomation のクラスファイル 
 * 
 * @author 自動生成
 */
public class DataOutputInfomationDiv extends Panel implements IDataOutputInfomationDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("icnKanryo")
    private Icon icnKanryo;
    @JsonProperty("lblMessage")
    private Label lblMessage;
    @JsonProperty("btnKakunin")
    private Button btnKakunin;
    @JsonProperty("hdnKanryoMsg")
    private RString hdnKanryoMsg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * geticnKanryo
     * @return icnKanryo
     */
    @JsonProperty("icnKanryo")
    public Icon getIcnKanryo() {
        return icnKanryo;
    }

    /*
     * seticnKanryo
     * @param icnKanryo icnKanryo
     */
    @JsonProperty("icnKanryo")
    public void setIcnKanryo(Icon icnKanryo) {
        this.icnKanryo = icnKanryo;
    }

    /*
     * getlblMessage
     * @return lblMessage
     */
    @JsonProperty("lblMessage")
    public Label getLblMessage() {
        return lblMessage;
    }

    /*
     * setlblMessage
     * @param lblMessage lblMessage
     */
    @JsonProperty("lblMessage")
    public void setLblMessage(Label lblMessage) {
        this.lblMessage = lblMessage;
    }

    /*
     * getbtnKakunin
     * @return btnKakunin
     */
    @JsonProperty("btnKakunin")
    public Button getBtnKakunin() {
        return btnKakunin;
    }

    /*
     * setbtnKakunin
     * @param btnKakunin btnKakunin
     */
    @JsonProperty("btnKakunin")
    public void setBtnKakunin(Button btnKakunin) {
        this.btnKakunin = btnKakunin;
    }

    /*
     * gethdnKanryoMsg
     * @return hdnKanryoMsg
     */
    @JsonProperty("hdnKanryoMsg")
    public RString getHdnKanryoMsg() {
        return hdnKanryoMsg;
    }

    /*
     * sethdnKanryoMsg
     * @param hdnKanryoMsg hdnKanryoMsg
     */
    @JsonProperty("hdnKanryoMsg")
    public void setHdnKanryoMsg(RString hdnKanryoMsg) {
        this.hdnKanryoMsg = hdnKanryoMsg;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
