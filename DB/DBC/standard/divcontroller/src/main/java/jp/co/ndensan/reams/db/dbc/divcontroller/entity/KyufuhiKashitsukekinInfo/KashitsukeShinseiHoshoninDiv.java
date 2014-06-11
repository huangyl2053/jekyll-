package jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukeShinseiHoshoninKinmuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KashitsukeShinseiHoshonin のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukeShinseiHoshoninDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHoshoninName")
    private TextBox txtHoshoninName;
    @JsonProperty("txtHoshoninSeiYMD")
    private TextBoxDate txtHoshoninSeiYMD;
    @JsonProperty("txtHoshoninSeibetsu")
    private TextBox txtHoshoninSeibetsu;
    @JsonProperty("txtHoshoninKana")
    private TextBoxKana txtHoshoninKana;
    @JsonProperty("txtHoshoninKankei")
    private TextBox txtHoshoninKankei;
    @JsonProperty("txtHoshoninYubinNo")
    private TextBoxYubinNo txtHoshoninYubinNo;
    @JsonProperty("txtHoshoninJusho")
    private TextBox txtHoshoninJusho;
    @JsonProperty("txtHoshoninTelNo")
    private TextBox txtHoshoninTelNo;
    @JsonProperty("KashitsukeShinseiHoshoninKinmu")
    private KashitsukeShinseiHoshoninKinmuDiv KashitsukeShinseiHoshoninKinmu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHoshoninName")
    public TextBox getTxtHoshoninName() {
        return txtHoshoninName;
    }

    @JsonProperty("txtHoshoninName")
    public void setTxtHoshoninName(TextBox txtHoshoninName) {
        this.txtHoshoninName=txtHoshoninName;
    }

    @JsonProperty("txtHoshoninSeiYMD")
    public TextBoxDate getTxtHoshoninSeiYMD() {
        return txtHoshoninSeiYMD;
    }

    @JsonProperty("txtHoshoninSeiYMD")
    public void setTxtHoshoninSeiYMD(TextBoxDate txtHoshoninSeiYMD) {
        this.txtHoshoninSeiYMD=txtHoshoninSeiYMD;
    }

    @JsonProperty("txtHoshoninSeibetsu")
    public TextBox getTxtHoshoninSeibetsu() {
        return txtHoshoninSeibetsu;
    }

    @JsonProperty("txtHoshoninSeibetsu")
    public void setTxtHoshoninSeibetsu(TextBox txtHoshoninSeibetsu) {
        this.txtHoshoninSeibetsu=txtHoshoninSeibetsu;
    }

    @JsonProperty("txtHoshoninKana")
    public TextBoxKana getTxtHoshoninKana() {
        return txtHoshoninKana;
    }

    @JsonProperty("txtHoshoninKana")
    public void setTxtHoshoninKana(TextBoxKana txtHoshoninKana) {
        this.txtHoshoninKana=txtHoshoninKana;
    }

    @JsonProperty("txtHoshoninKankei")
    public TextBox getTxtHoshoninKankei() {
        return txtHoshoninKankei;
    }

    @JsonProperty("txtHoshoninKankei")
    public void setTxtHoshoninKankei(TextBox txtHoshoninKankei) {
        this.txtHoshoninKankei=txtHoshoninKankei;
    }

    @JsonProperty("txtHoshoninYubinNo")
    public TextBoxYubinNo getTxtHoshoninYubinNo() {
        return txtHoshoninYubinNo;
    }

    @JsonProperty("txtHoshoninYubinNo")
    public void setTxtHoshoninYubinNo(TextBoxYubinNo txtHoshoninYubinNo) {
        this.txtHoshoninYubinNo=txtHoshoninYubinNo;
    }

    @JsonProperty("txtHoshoninJusho")
    public TextBox getTxtHoshoninJusho() {
        return txtHoshoninJusho;
    }

    @JsonProperty("txtHoshoninJusho")
    public void setTxtHoshoninJusho(TextBox txtHoshoninJusho) {
        this.txtHoshoninJusho=txtHoshoninJusho;
    }

    @JsonProperty("txtHoshoninTelNo")
    public TextBox getTxtHoshoninTelNo() {
        return txtHoshoninTelNo;
    }

    @JsonProperty("txtHoshoninTelNo")
    public void setTxtHoshoninTelNo(TextBox txtHoshoninTelNo) {
        this.txtHoshoninTelNo=txtHoshoninTelNo;
    }

    @JsonProperty("KashitsukeShinseiHoshoninKinmu")
    public KashitsukeShinseiHoshoninKinmuDiv getKashitsukeShinseiHoshoninKinmu() {
        return KashitsukeShinseiHoshoninKinmu;
    }

    @JsonProperty("KashitsukeShinseiHoshoninKinmu")
    public void setKashitsukeShinseiHoshoninKinmu(KashitsukeShinseiHoshoninKinmuDiv KashitsukeShinseiHoshoninKinmu) {
        this.KashitsukeShinseiHoshoninKinmu=KashitsukeShinseiHoshoninKinmu;
    }

}
