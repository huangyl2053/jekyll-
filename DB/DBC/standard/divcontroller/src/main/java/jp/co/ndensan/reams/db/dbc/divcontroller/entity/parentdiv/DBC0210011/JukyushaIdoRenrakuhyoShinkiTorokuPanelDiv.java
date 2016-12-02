package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0210011;

/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo.IJukyushaIdoRenrakuhyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo.JukyushaIdoRenrakuhyoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;

/**
 * JukyushaIdoRenrakuhyoShinkiTorokuPanel のクラスファイル
 *
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyo")
    private JukyushaIdoRenrakuhyoDiv JukyushaIdoRenrakuhyo;
    @JsonProperty("OutputJukyushaIdoRenrakuhyo")
    private OutputJukyushaIdoRenrakuhyoDiv OutputJukyushaIdoRenrakuhyo;
    @JsonProperty("hdnFlag")
    private TextBox hdnFlag;
    @JsonProperty("hdnFlg")
    private RString hdnFlg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
 /*
     * getJukyushaIdoRenrakuhyo
     * @return JukyushaIdoRenrakuhyo
     */
    @JsonProperty("JukyushaIdoRenrakuhyo")
    public IJukyushaIdoRenrakuhyoDiv getJukyushaIdoRenrakuhyo() {
        return JukyushaIdoRenrakuhyo;
    }

    /*
     * getOutputJukyushaIdoRenrakuhyo
     * @return OutputJukyushaIdoRenrakuhyo
     */
    @JsonProperty("OutputJukyushaIdoRenrakuhyo")
    public OutputJukyushaIdoRenrakuhyoDiv getOutputJukyushaIdoRenrakuhyo() {
        return OutputJukyushaIdoRenrakuhyo;
    }

    /*
     * setOutputJukyushaIdoRenrakuhyo
     * @param OutputJukyushaIdoRenrakuhyo OutputJukyushaIdoRenrakuhyo
     */
    @JsonProperty("OutputJukyushaIdoRenrakuhyo")
    public void setOutputJukyushaIdoRenrakuhyo(OutputJukyushaIdoRenrakuhyoDiv OutputJukyushaIdoRenrakuhyo) {
        this.OutputJukyushaIdoRenrakuhyo = OutputJukyushaIdoRenrakuhyo;
    }

    /*
     * gethdnFlag
     * @return hdnFlag
     */
    @JsonProperty("hdnFlag")
    public TextBox getHdnFlag() {
        return hdnFlag;
    }

    /*
     * sethdnFlag
     * @param hdnFlag hdnFlag
     */
    @JsonProperty("hdnFlag")
    public void setHdnFlag(TextBox hdnFlag) {
        this.hdnFlag = hdnFlag;
    }

    /*
     * gethdnFlg
     * @return hdnFlg
     */
    @JsonProperty("hdnFlg")
    public RString getHdnFlg() {
        return hdnFlg;
    }

    /*
     * sethdnFlg
     * @param hdnFlg hdnFlg
     */
    @JsonProperty("hdnFlg")
    public void setHdnFlg(RString hdnFlg) {
        this.hdnFlg = hdnFlg;
    }

    // </editor-fold>
}
