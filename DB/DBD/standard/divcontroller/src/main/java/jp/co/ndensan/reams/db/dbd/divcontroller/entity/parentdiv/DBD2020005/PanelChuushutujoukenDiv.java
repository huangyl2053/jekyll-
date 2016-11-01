package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020005;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PanelChuushutujouken のクラスファイル 
 * 
 * @author 自動生成
 */
public class PanelChuushutujoukenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKyuuhuSeigenShubetu")
    private RadioButton radKyuuhuSeigenShubetu;
    @JsonProperty("radKyuuhuSeigenJoutai")
    private RadioButton radKyuuhuSeigenJoutai;
    @JsonProperty("chkKobetushitei")
    private CheckBoxList chkKobetushitei;
    @JsonProperty("ccdShuturyokujun")
    private ChohyoShutsuryokujunDiv ccdShuturyokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradKyuuhuSeigenShubetu
     * @return radKyuuhuSeigenShubetu
     */
    @JsonProperty("radKyuuhuSeigenShubetu")
    public RadioButton getRadKyuuhuSeigenShubetu() {
        return radKyuuhuSeigenShubetu;
    }

    /*
     * setradKyuuhuSeigenShubetu
     * @param radKyuuhuSeigenShubetu radKyuuhuSeigenShubetu
     */
    @JsonProperty("radKyuuhuSeigenShubetu")
    public void setRadKyuuhuSeigenShubetu(RadioButton radKyuuhuSeigenShubetu) {
        this.radKyuuhuSeigenShubetu = radKyuuhuSeigenShubetu;
    }

    /*
     * getradKyuuhuSeigenJoutai
     * @return radKyuuhuSeigenJoutai
     */
    @JsonProperty("radKyuuhuSeigenJoutai")
    public RadioButton getRadKyuuhuSeigenJoutai() {
        return radKyuuhuSeigenJoutai;
    }

    /*
     * setradKyuuhuSeigenJoutai
     * @param radKyuuhuSeigenJoutai radKyuuhuSeigenJoutai
     */
    @JsonProperty("radKyuuhuSeigenJoutai")
    public void setRadKyuuhuSeigenJoutai(RadioButton radKyuuhuSeigenJoutai) {
        this.radKyuuhuSeigenJoutai = radKyuuhuSeigenJoutai;
    }

    /*
     * getchkKobetushitei
     * @return chkKobetushitei
     */
    @JsonProperty("chkKobetushitei")
    public CheckBoxList getChkKobetushitei() {
        return chkKobetushitei;
    }

    /*
     * setchkKobetushitei
     * @param chkKobetushitei chkKobetushitei
     */
    @JsonProperty("chkKobetushitei")
    public void setChkKobetushitei(CheckBoxList chkKobetushitei) {
        this.chkKobetushitei = chkKobetushitei;
    }

    /*
     * getccdShuturyokujun
     * @return ccdShuturyokujun
     */
    @JsonProperty("ccdShuturyokujun")
    public IChohyoShutsuryokujunDiv getCcdShuturyokujun() {
        return ccdShuturyokujun;
    }

    // </editor-fold>
}
