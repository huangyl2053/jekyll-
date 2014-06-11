package jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukeShinseiHoshoninDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukeShinseiServiceDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukeShinseiTeishutsuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukeShinseishaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplKashitsukekinShinsei のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplKashitsukekinShinseiDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiYMD")
    private TextBoxDate txtShinseiYMD;
    @JsonProperty("txtRiyoKikan")
    private TextBoxDateRange txtRiyoKikan;
    @JsonProperty("txtSeikyugaku")
    private TextBoxNum txtSeikyugaku;
    @JsonProperty("txtShinseiKingaku")
    private TextBoxNum txtShinseiKingaku;
    @JsonProperty("KashitsukeShinseiService")
    private KashitsukeShinseiServiceDiv KashitsukeShinseiService;
    @JsonProperty("KashitsukeShinseisha")
    private KashitsukeShinseishaDiv KashitsukeShinseisha;
    @JsonProperty("KashitsukeShinseiHoshonin")
    private KashitsukeShinseiHoshoninDiv KashitsukeShinseiHoshonin;
    @JsonProperty("KashitsukeShinseiTeishutsu")
    private KashitsukeShinseiTeishutsuDiv KashitsukeShinseiTeishutsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseiYMD")
    public TextBoxDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.txtShinseiYMD=txtShinseiYMD;
    }

    @JsonProperty("txtRiyoKikan")
    public TextBoxDateRange getTxtRiyoKikan() {
        return txtRiyoKikan;
    }

    @JsonProperty("txtRiyoKikan")
    public void setTxtRiyoKikan(TextBoxDateRange txtRiyoKikan) {
        this.txtRiyoKikan=txtRiyoKikan;
    }

    @JsonProperty("txtSeikyugaku")
    public TextBoxNum getTxtSeikyugaku() {
        return txtSeikyugaku;
    }

    @JsonProperty("txtSeikyugaku")
    public void setTxtSeikyugaku(TextBoxNum txtSeikyugaku) {
        this.txtSeikyugaku=txtSeikyugaku;
    }

    @JsonProperty("txtShinseiKingaku")
    public TextBoxNum getTxtShinseiKingaku() {
        return txtShinseiKingaku;
    }

    @JsonProperty("txtShinseiKingaku")
    public void setTxtShinseiKingaku(TextBoxNum txtShinseiKingaku) {
        this.txtShinseiKingaku=txtShinseiKingaku;
    }

    @JsonProperty("KashitsukeShinseiService")
    public KashitsukeShinseiServiceDiv getKashitsukeShinseiService() {
        return KashitsukeShinseiService;
    }

    @JsonProperty("KashitsukeShinseiService")
    public void setKashitsukeShinseiService(KashitsukeShinseiServiceDiv KashitsukeShinseiService) {
        this.KashitsukeShinseiService=KashitsukeShinseiService;
    }

    @JsonProperty("KashitsukeShinseisha")
    public KashitsukeShinseishaDiv getKashitsukeShinseisha() {
        return KashitsukeShinseisha;
    }

    @JsonProperty("KashitsukeShinseisha")
    public void setKashitsukeShinseisha(KashitsukeShinseishaDiv KashitsukeShinseisha) {
        this.KashitsukeShinseisha=KashitsukeShinseisha;
    }

    @JsonProperty("KashitsukeShinseiHoshonin")
    public KashitsukeShinseiHoshoninDiv getKashitsukeShinseiHoshonin() {
        return KashitsukeShinseiHoshonin;
    }

    @JsonProperty("KashitsukeShinseiHoshonin")
    public void setKashitsukeShinseiHoshonin(KashitsukeShinseiHoshoninDiv KashitsukeShinseiHoshonin) {
        this.KashitsukeShinseiHoshonin=KashitsukeShinseiHoshonin;
    }

    @JsonProperty("KashitsukeShinseiTeishutsu")
    public KashitsukeShinseiTeishutsuDiv getKashitsukeShinseiTeishutsu() {
        return KashitsukeShinseiTeishutsu;
    }

    @JsonProperty("KashitsukeShinseiTeishutsu")
    public void setKashitsukeShinseiTeishutsu(KashitsukeShinseiTeishutsuDiv KashitsukeShinseiTeishutsu) {
        this.KashitsukeShinseiTeishutsu=KashitsukeShinseiTeishutsu;
    }

}
