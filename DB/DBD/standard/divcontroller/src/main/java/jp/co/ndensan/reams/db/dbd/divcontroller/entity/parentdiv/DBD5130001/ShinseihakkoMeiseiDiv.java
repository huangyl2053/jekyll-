package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinseihakkoMeisei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseihakkoMeiseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKanryoMessage")
    private KanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("Ninteishinseihakko")
    private NinteishinseihakkoDiv Ninteishinseihakko;
    @JsonProperty("ShinseihakkoMeisei2")
    private ShinseihakkoMeisei2Div ShinseihakkoMeisei2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * getNinteishinseihakko
     * @return Ninteishinseihakko
     */
    @JsonProperty("Ninteishinseihakko")
    public NinteishinseihakkoDiv getNinteishinseihakko() {
        return Ninteishinseihakko;
    }

    /*
     * setNinteishinseihakko
     * @param Ninteishinseihakko Ninteishinseihakko
     */
    @JsonProperty("Ninteishinseihakko")
    public void setNinteishinseihakko(NinteishinseihakkoDiv Ninteishinseihakko) {
        this.Ninteishinseihakko = Ninteishinseihakko;
    }

    /*
     * getShinseihakkoMeisei2
     * @return ShinseihakkoMeisei2
     */
    @JsonProperty("ShinseihakkoMeisei2")
    public ShinseihakkoMeisei2Div getShinseihakkoMeisei2() {
        return ShinseihakkoMeisei2;
    }

    /*
     * setShinseihakkoMeisei2
     * @param ShinseihakkoMeisei2 ShinseihakkoMeisei2
     */
    @JsonProperty("ShinseihakkoMeisei2")
    public void setShinseihakkoMeisei2(ShinseihakkoMeisei2Div ShinseihakkoMeisei2) {
        this.ShinseihakkoMeisei2 = ShinseihakkoMeisei2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadShinseishaKubun() {
        return this.getShinseihakkoMeisei2().getPrintSelect().getRadShinseishaKubun();
    }

    @JsonIgnore
    public void  setRadShinseishaKubun(RadioButton radShinseishaKubun) {
        this.getShinseihakkoMeisei2().getPrintSelect().setRadShinseishaKubun(radShinseishaKubun);
    }

    @JsonIgnore
    public RadioButton getRadShinseiKubun() {
        return this.getShinseihakkoMeisei2().getPrintSelect().getRadShinseiKubun();
    }

    @JsonIgnore
    public void  setRadShinseiKubun(RadioButton radShinseiKubun) {
        this.getShinseihakkoMeisei2().getPrintSelect().setRadShinseiKubun(radShinseiKubun);
    }

    @JsonIgnore
    public RadioButton getRadPrintMeeisaiInfo() {
        return this.getShinseihakkoMeisei2().getPrintSelect().getRadPrintMeeisaiInfo();
    }

    @JsonIgnore
    public void  setRadPrintMeeisaiInfo(RadioButton radPrintMeeisaiInfo) {
        this.getShinseihakkoMeisei2().getPrintSelect().setRadPrintMeeisaiInfo(radPrintMeeisaiInfo);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiShinseiDate() {
        return this.getShinseihakkoMeisei2().getZenkaiShinseiNaiyo().getTxtZenkaiShinseiDate();
    }

    @JsonIgnore
    public void  setTxtZenkaiShinseiDate(TextBoxDate txtZenkaiShinseiDate) {
        this.getShinseihakkoMeisei2().getZenkaiShinseiNaiyo().setTxtZenkaiShinseiDate(txtZenkaiShinseiDate);
    }

    @JsonIgnore
    public TextBox getTxtShinseiKubunShinseiji() {
        return this.getShinseihakkoMeisei2().getZenkaiShinseiNaiyo().getTxtShinseiKubunShinseiji();
    }

    @JsonIgnore
    public void  setTxtShinseiKubunShinseiji(TextBox txtShinseiKubunShinseiji) {
        this.getShinseihakkoMeisei2().getZenkaiShinseiNaiyo().setTxtShinseiKubunShinseiji(txtShinseiKubunShinseiji);
    }

    @JsonIgnore
    public TextBox getTxtShinseiKubunHorei() {
        return this.getShinseihakkoMeisei2().getZenkaiShinseiNaiyo().getTxtShinseiKubunHorei();
    }

    @JsonIgnore
    public void  setTxtShinseiKubunHorei(TextBox txtShinseiKubunHorei) {
        this.getShinseihakkoMeisei2().getZenkaiShinseiNaiyo().setTxtShinseiKubunHorei(txtShinseiKubunHorei);
    }

    // </editor-fold>
}
