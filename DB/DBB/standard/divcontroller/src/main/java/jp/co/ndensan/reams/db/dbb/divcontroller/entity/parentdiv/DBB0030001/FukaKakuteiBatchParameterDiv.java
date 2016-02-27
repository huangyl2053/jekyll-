package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * FukaKakuteiBatchParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaKakuteiBatchParameterDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblFukaKeisanKakuteiMsg")
    private Label lblFukaKeisanKakuteiMsg;
    @JsonProperty("FukaKeisanShoriNaiyo")
    private FukaKeisanShoriNaiyoDiv FukaKeisanShoriNaiyo;
    @JsonProperty("処理名")
    private RString 処理名;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblFukaKeisanKakuteiMsg
     * @return lblFukaKeisanKakuteiMsg
     */
    @JsonProperty("lblFukaKeisanKakuteiMsg")
    public Label getLblFukaKeisanKakuteiMsg() {
        return lblFukaKeisanKakuteiMsg;
    }

    /*
     * setlblFukaKeisanKakuteiMsg
     * @param lblFukaKeisanKakuteiMsg lblFukaKeisanKakuteiMsg
     */
    @JsonProperty("lblFukaKeisanKakuteiMsg")
    public void setLblFukaKeisanKakuteiMsg(Label lblFukaKeisanKakuteiMsg) {
        this.lblFukaKeisanKakuteiMsg = lblFukaKeisanKakuteiMsg;
    }

    /*
     * getFukaKeisanShoriNaiyo
     * @return FukaKeisanShoriNaiyo
     */
    @JsonProperty("FukaKeisanShoriNaiyo")
    public FukaKeisanShoriNaiyoDiv getFukaKeisanShoriNaiyo() {
        return FukaKeisanShoriNaiyo;
    }

    /*
     * setFukaKeisanShoriNaiyo
     * @param FukaKeisanShoriNaiyo FukaKeisanShoriNaiyo
     */
    @JsonProperty("FukaKeisanShoriNaiyo")
    public void setFukaKeisanShoriNaiyo(FukaKeisanShoriNaiyoDiv FukaKeisanShoriNaiyo) {
        this.FukaKeisanShoriNaiyo = FukaKeisanShoriNaiyo;
    }

    /*
     * get処理名
     * @return 処理名
     */
    @JsonProperty("処理名")
    public RString get処理名() {
        return 処理名;
    }

    /*
     * set処理名
     * @param 処理名 処理名
     */
    @JsonProperty("処理名")
    public void set処理名(RString 処理名) {
        this.処理名 = 処理名;
    }

    // </editor-fold>
}
