package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020005;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * KyufuSeigenTaishoshaIchiranPanelBatchParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PanelHanteikijun")
    private PanelHanteikijunDiv PanelHanteikijun;
    @JsonProperty("PanelChuushutujouken")
    private PanelChuushutujoukenDiv PanelChuushutujouken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getPanelHanteikijun
     * @return PanelHanteikijun
     */
    @JsonProperty("PanelHanteikijun")
    public PanelHanteikijunDiv getPanelHanteikijun() {
        return PanelHanteikijun;
    }

    /*
     * setPanelHanteikijun
     * @param PanelHanteikijun PanelHanteikijun
     */
    @JsonProperty("PanelHanteikijun")
    public void setPanelHanteikijun(PanelHanteikijunDiv PanelHanteikijun) {
        this.PanelHanteikijun = PanelHanteikijun;
    }

    /*
     * getPanelChuushutujouken
     * @return PanelChuushutujouken
     */
    @JsonProperty("PanelChuushutujouken")
    public PanelChuushutujoukenDiv getPanelChuushutujouken() {
        return PanelChuushutujouken;
    }

    /*
     * setPanelChuushutujouken
     * @param PanelChuushutujouken PanelChuushutujouken
     */
    @JsonProperty("PanelChuushutujouken")
    public void setPanelChuushutujouken(PanelChuushutujoukenDiv PanelChuushutujouken) {
        this.PanelChuushutujouken = PanelChuushutujouken;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtKijunbi() {
        return this.getPanelHanteikijun().getTxtKijunbi();
    }

    @JsonIgnore
    public void  setTxtKijunbi(TextBoxDate txtKijunbi) {
        this.getPanelHanteikijun().setTxtKijunbi(txtKijunbi);
    }

    @JsonIgnore
    public RadioButton getRadKyuuhuSeigenShubetu() {
        return this.getPanelChuushutujouken().getRadKyuuhuSeigenShubetu();
    }

    @JsonIgnore
    public void  setRadKyuuhuSeigenShubetu(RadioButton radKyuuhuSeigenShubetu) {
        this.getPanelChuushutujouken().setRadKyuuhuSeigenShubetu(radKyuuhuSeigenShubetu);
    }

    @JsonIgnore
    public RadioButton getRadKyuuhuSeigenJoutai() {
        return this.getPanelChuushutujouken().getRadKyuuhuSeigenJoutai();
    }

    @JsonIgnore
    public void  setRadKyuuhuSeigenJoutai(RadioButton radKyuuhuSeigenJoutai) {
        this.getPanelChuushutujouken().setRadKyuuhuSeigenJoutai(radKyuuhuSeigenJoutai);
    }

    @JsonIgnore
    public CheckBoxList getChkKobetushitei() {
        return this.getPanelChuushutujouken().getChkKobetushitei();
    }

    @JsonIgnore
    public void  setChkKobetushitei(CheckBoxList chkKobetushitei) {
        this.getPanelChuushutujouken().setChkKobetushitei(chkKobetushitei);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdShuturyokujun() {
        return this.getPanelChuushutujouken().getCcdShuturyokujun();
    }

    // </editor-fold>
}
