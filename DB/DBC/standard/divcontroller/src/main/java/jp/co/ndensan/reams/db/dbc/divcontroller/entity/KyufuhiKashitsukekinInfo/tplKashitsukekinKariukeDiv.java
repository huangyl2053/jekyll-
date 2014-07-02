package jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukekinKariukeHoshoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukekinKariukeninDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplKashitsukekinKariuke のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplKashitsukekinKariukeDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKariukeYMD")
    private TextBoxDate txtKariukeYMD;
    @JsonProperty("KashitsukekinKariukenin")
    private KashitsukekinKariukeninDiv KashitsukekinKariukenin;
    @JsonProperty("KashitsukekinKariukeHosho")
    private KashitsukekinKariukeHoshoDiv KashitsukekinKariukeHosho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKariukeYMD")
    public TextBoxDate getTxtKariukeYMD() {
        return txtKariukeYMD;
    }

    @JsonProperty("txtKariukeYMD")
    public void setTxtKariukeYMD(TextBoxDate txtKariukeYMD) {
        this.txtKariukeYMD=txtKariukeYMD;
    }

    @JsonProperty("KashitsukekinKariukenin")
    public KashitsukekinKariukeninDiv getKashitsukekinKariukenin() {
        return KashitsukekinKariukenin;
    }

    @JsonProperty("KashitsukekinKariukenin")
    public void setKashitsukekinKariukenin(KashitsukekinKariukeninDiv KashitsukekinKariukenin) {
        this.KashitsukekinKariukenin=KashitsukekinKariukenin;
    }

    @JsonProperty("KashitsukekinKariukeHosho")
    public KashitsukekinKariukeHoshoDiv getKashitsukekinKariukeHosho() {
        return KashitsukekinKariukeHosho;
    }

    @JsonProperty("KashitsukekinKariukeHosho")
    public void setKashitsukekinKariukeHosho(KashitsukekinKariukeHoshoDiv KashitsukekinKariukeHosho) {
        this.KashitsukekinKariukeHosho=KashitsukekinKariukeHosho;
    }

}
