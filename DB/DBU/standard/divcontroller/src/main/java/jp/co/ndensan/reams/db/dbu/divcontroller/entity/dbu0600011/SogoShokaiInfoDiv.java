package jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0600011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0600011.SogoShokaiFukaDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0600011.SogoShokaiJukyuDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0600011.SogoShokaiJuminDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0600011.SogoShokaiKyufuDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0600011.SogoShokaiShikakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SogoShokaiInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShikakuInfo")
    private Button btnShikakuInfo;
    @JsonProperty("btnJukyuInfo")
    private Button btnJukyuInfo;
    @JsonProperty("btnKyufuInfo")
    private Button btnKyufuInfo;
    @JsonProperty("btnFukaInfo")
    private Button btnFukaInfo;
    @JsonProperty("btnJuminInfo")
    private Button btnJuminInfo;
    @JsonProperty("SogoShokaiShikaku")
    private SogoShokaiShikakuDiv SogoShokaiShikaku;
    @JsonProperty("SogoShokaiJukyu")
    private SogoShokaiJukyuDiv SogoShokaiJukyu;
    @JsonProperty("SogoShokaiKyufu")
    private SogoShokaiKyufuDiv SogoShokaiKyufu;
    @JsonProperty("SogoShokaiFuka")
    private SogoShokaiFukaDiv SogoShokaiFuka;
    @JsonProperty("SogoShokaiJumin")
    private SogoShokaiJuminDiv SogoShokaiJumin;
    @JsonProperty("btnGaitoshaReturn")
    private Button btnGaitoshaReturn;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnShikakuInfo")
    public Button getBtnShikakuInfo() {
        return btnShikakuInfo;
    }

    @JsonProperty("btnShikakuInfo")
    public void setBtnShikakuInfo(Button btnShikakuInfo) {
        this.btnShikakuInfo=btnShikakuInfo;
    }

    @JsonProperty("btnJukyuInfo")
    public Button getBtnJukyuInfo() {
        return btnJukyuInfo;
    }

    @JsonProperty("btnJukyuInfo")
    public void setBtnJukyuInfo(Button btnJukyuInfo) {
        this.btnJukyuInfo=btnJukyuInfo;
    }

    @JsonProperty("btnKyufuInfo")
    public Button getBtnKyufuInfo() {
        return btnKyufuInfo;
    }

    @JsonProperty("btnKyufuInfo")
    public void setBtnKyufuInfo(Button btnKyufuInfo) {
        this.btnKyufuInfo=btnKyufuInfo;
    }

    @JsonProperty("btnFukaInfo")
    public Button getBtnFukaInfo() {
        return btnFukaInfo;
    }

    @JsonProperty("btnFukaInfo")
    public void setBtnFukaInfo(Button btnFukaInfo) {
        this.btnFukaInfo=btnFukaInfo;
    }

    @JsonProperty("btnJuminInfo")
    public Button getBtnJuminInfo() {
        return btnJuminInfo;
    }

    @JsonProperty("btnJuminInfo")
    public void setBtnJuminInfo(Button btnJuminInfo) {
        this.btnJuminInfo=btnJuminInfo;
    }

    @JsonProperty("SogoShokaiShikaku")
    public SogoShokaiShikakuDiv getSogoShokaiShikaku() {
        return SogoShokaiShikaku;
    }

    @JsonProperty("SogoShokaiShikaku")
    public void setSogoShokaiShikaku(SogoShokaiShikakuDiv SogoShokaiShikaku) {
        this.SogoShokaiShikaku=SogoShokaiShikaku;
    }

    @JsonProperty("SogoShokaiJukyu")
    public SogoShokaiJukyuDiv getSogoShokaiJukyu() {
        return SogoShokaiJukyu;
    }

    @JsonProperty("SogoShokaiJukyu")
    public void setSogoShokaiJukyu(SogoShokaiJukyuDiv SogoShokaiJukyu) {
        this.SogoShokaiJukyu=SogoShokaiJukyu;
    }

    @JsonProperty("SogoShokaiKyufu")
    public SogoShokaiKyufuDiv getSogoShokaiKyufu() {
        return SogoShokaiKyufu;
    }

    @JsonProperty("SogoShokaiKyufu")
    public void setSogoShokaiKyufu(SogoShokaiKyufuDiv SogoShokaiKyufu) {
        this.SogoShokaiKyufu=SogoShokaiKyufu;
    }

    @JsonProperty("SogoShokaiFuka")
    public SogoShokaiFukaDiv getSogoShokaiFuka() {
        return SogoShokaiFuka;
    }

    @JsonProperty("SogoShokaiFuka")
    public void setSogoShokaiFuka(SogoShokaiFukaDiv SogoShokaiFuka) {
        this.SogoShokaiFuka=SogoShokaiFuka;
    }

    @JsonProperty("SogoShokaiJumin")
    public SogoShokaiJuminDiv getSogoShokaiJumin() {
        return SogoShokaiJumin;
    }

    @JsonProperty("SogoShokaiJumin")
    public void setSogoShokaiJumin(SogoShokaiJuminDiv SogoShokaiJumin) {
        this.SogoShokaiJumin=SogoShokaiJumin;
    }

    @JsonProperty("btnGaitoshaReturn")
    public Button getBtnGaitoshaReturn() {
        return btnGaitoshaReturn;
    }

    @JsonProperty("btnGaitoshaReturn")
    public void setBtnGaitoshaReturn(Button btnGaitoshaReturn) {
        this.btnGaitoshaReturn=btnGaitoshaReturn;
    }

}
