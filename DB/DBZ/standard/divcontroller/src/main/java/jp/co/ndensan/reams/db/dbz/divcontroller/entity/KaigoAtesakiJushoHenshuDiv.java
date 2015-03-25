package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IKaigoAtesakiJushoHenshuDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.JushoHenshu1Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.JushoHenshu2Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KaigoAtesakiJushoHenshu のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoAtesakiJushoHenshuDiv extends Panel implements IKaigoAtesakiJushoHenshuDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JushoHenshu1")
    private JushoHenshu1Div JushoHenshu1;
    @JsonProperty("JushoHenshu2")
    private JushoHenshu2Div JushoHenshu2;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JushoHenshu1")
    public JushoHenshu1Div getJushoHenshu1() {
        return JushoHenshu1;
    }

    @JsonProperty("JushoHenshu1")
    public void setJushoHenshu1(JushoHenshu1Div JushoHenshu1) {
        this.JushoHenshu1=JushoHenshu1;
    }

    @JsonProperty("JushoHenshu2")
    public JushoHenshu2Div getJushoHenshu2() {
        return JushoHenshu2;
    }

    @JsonProperty("JushoHenshu2")
    public void setJushoHenshu2(JushoHenshu2Div JushoHenshu2) {
        this.JushoHenshu2=JushoHenshu2;
    }

    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1=lin1;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose=btnClose;
    }

    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei=btnKakutei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadKenmeiHyojiUmu() {
        return this.getJushoHenshu1().getRadKenmeiHyojiUmu();
    }

    @JsonIgnore
    public void  setRadKenmeiHyojiUmu(RadioButton radKenmeiHyojiUmu) {
        this.getJushoHenshu1().setRadKenmeiHyojiUmu(radKenmeiHyojiUmu);
    }

    @JsonIgnore
    public RadioButton getRadGunmeiHyojiUmu() {
        return this.getJushoHenshu1().getRadGunmeiHyojiUmu();
    }

    @JsonIgnore
    public void  setRadGunmeiHyojiUmu(RadioButton radGunmeiHyojiUmu) {
        this.getJushoHenshu1().setRadGunmeiHyojiUmu(radGunmeiHyojiUmu);
    }

    @JsonIgnore
    public RadioButton getRadCitymeiHyojiUmu() {
        return this.getJushoHenshu1().getRadCitymeiHyojiUmu();
    }

    @JsonIgnore
    public void  setRadCitymeiHyojiUmu(RadioButton radCitymeiHyojiUmu) {
        this.getJushoHenshu1().setRadCitymeiHyojiUmu(radCitymeiHyojiUmu);
    }

    @JsonIgnore
    public DropDownList getDdlJushoHenshu() {
        return this.getJushoHenshu2().getDdlJushoHenshu();
    }

    @JsonIgnore
    public void  setDdlJushoHenshu(DropDownList ddlJushoHenshu) {
        this.getJushoHenshu2().setDdlJushoHenshu(ddlJushoHenshu);
    }

    @JsonIgnore
    public RadioButton getRadKatagakiHyojiUmu() {
        return this.getJushoHenshu2().getRadKatagakiHyojiUmu();
    }

    @JsonIgnore
    public void  setRadKatagakiHyojiUmu(RadioButton radKatagakiHyojiUmu) {
        this.getJushoHenshu2().setRadKatagakiHyojiUmu(radKatagakiHyojiUmu);
    }

    @JsonIgnore
    public Space getSpaceJusho() {
        return this.getJushoHenshu2().getSpaceJusho();
    }

    @JsonIgnore
    public void  setSpaceJusho(Space SpaceJusho) {
        this.getJushoHenshu2().setSpaceJusho(SpaceJusho);
    }

    //--------------- この行より下にコードを追加してください -------------------

}
