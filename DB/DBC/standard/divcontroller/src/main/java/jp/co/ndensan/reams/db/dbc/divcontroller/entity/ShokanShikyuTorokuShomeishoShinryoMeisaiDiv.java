package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoShinryoMeisaiH1503Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoShinryoMeisaiH1504Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShokanShikyuTorokuShomeishoShinryoMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoShinryoMeisaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoShinryoMeisaiH1503")
    private ShokanShikyuTorokuShomeishoShinryoMeisaiH1503Div ShokanShikyuTorokuShomeishoShinryoMeisaiH1503;
    @JsonProperty("ShokanShikyuTorokuShomeishoShinryoMeisaiH1504")
    private ShokanShikyuTorokuShomeishoShinryoMeisaiH1504Div ShokanShikyuTorokuShomeishoShinryoMeisaiH1504;
    @JsonProperty("btnShinryohiKakutei")
    private Button btnShinryohiKakutei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoShinryoMeisaiH1503")
    public ShokanShikyuTorokuShomeishoShinryoMeisaiH1503Div getShokanShikyuTorokuShomeishoShinryoMeisaiH1503() {
        return ShokanShikyuTorokuShomeishoShinryoMeisaiH1503;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShinryoMeisaiH1503")
    public void setShokanShikyuTorokuShomeishoShinryoMeisaiH1503(ShokanShikyuTorokuShomeishoShinryoMeisaiH1503Div ShokanShikyuTorokuShomeishoShinryoMeisaiH1503) {
        this.ShokanShikyuTorokuShomeishoShinryoMeisaiH1503=ShokanShikyuTorokuShomeishoShinryoMeisaiH1503;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShinryoMeisaiH1504")
    public ShokanShikyuTorokuShomeishoShinryoMeisaiH1504Div getShokanShikyuTorokuShomeishoShinryoMeisaiH1504() {
        return ShokanShikyuTorokuShomeishoShinryoMeisaiH1504;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShinryoMeisaiH1504")
    public void setShokanShikyuTorokuShomeishoShinryoMeisaiH1504(ShokanShikyuTorokuShomeishoShinryoMeisaiH1504Div ShokanShikyuTorokuShomeishoShinryoMeisaiH1504) {
        this.ShokanShikyuTorokuShomeishoShinryoMeisaiH1504=ShokanShikyuTorokuShomeishoShinryoMeisaiH1504;
    }

    @JsonProperty("btnShinryohiKakutei")
    public Button getBtnShinryohiKakutei() {
        return btnShinryohiKakutei;
    }

    @JsonProperty("btnShinryohiKakutei")
    public void setBtnShinryohiKakutei(Button btnShinryohiKakutei) {
        this.btnShinryohiKakutei=btnShinryohiKakutei;
    }

}
