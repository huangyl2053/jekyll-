package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0520011;
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
 * KyokaisouKanriMasterListPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyokaisouKanriMasterListPanelDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyokaisoKariParam")
    private KyokaisoKariParamDiv KyokaisoKariParam;
    @JsonProperty("ShiteiNaiyoKubun")
    private ShiteiNaiyoKubunDiv ShiteiNaiyoKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKyokaisoKariParam
     * @return KyokaisoKariParam
     */
    @JsonProperty("KyokaisoKariParam")
    public KyokaisoKariParamDiv getKyokaisoKariParam() {
        return KyokaisoKariParam;
    }

    /*
     * setKyokaisoKariParam
     * @param KyokaisoKariParam KyokaisoKariParam
     */
    @JsonProperty("KyokaisoKariParam")
    public void setKyokaisoKariParam(KyokaisoKariParamDiv KyokaisoKariParam) {
        this.KyokaisoKariParam = KyokaisoKariParam;
    }

    /*
     * getShiteiNaiyoKubun
     * @return ShiteiNaiyoKubun
     */
    @JsonProperty("ShiteiNaiyoKubun")
    public ShiteiNaiyoKubunDiv getShiteiNaiyoKubun() {
        return ShiteiNaiyoKubun;
    }

    /*
     * setShiteiNaiyoKubun
     * @param ShiteiNaiyoKubun ShiteiNaiyoKubun
     */
    @JsonProperty("ShiteiNaiyoKubun")
    public void setShiteiNaiyoKubun(ShiteiNaiyoKubunDiv ShiteiNaiyoKubun) {
        this.ShiteiNaiyoKubun = ShiteiNaiyoKubun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblShiteiNaiyoKubun() {
        return this.getShiteiNaiyoKubun().getLblShiteiNaiyoKubun();
    }

    @JsonIgnore
    public void  setLblShiteiNaiyoKubun(Label lblShiteiNaiyoKubun) {
        this.getShiteiNaiyoKubun().setLblShiteiNaiyoKubun(lblShiteiNaiyoKubun);
    }

    @JsonIgnore
    public CheckBoxList getChkShiteiNaiyoKubun() {
        return this.getShiteiNaiyoKubun().getChkShiteiNaiyoKubun();
    }

    @JsonIgnore
    public void  setChkShiteiNaiyoKubun(CheckBoxList chkShiteiNaiyoKubun) {
        this.getShiteiNaiyoKubun().setChkShiteiNaiyoKubun(chkShiteiNaiyoKubun);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getShiteiNaiyoKubun().getCcdChohyoShutsuryokujun();
    }

    // </editor-fold>
}
