package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigochohyoseigyokyotsu.KaigoChohyoSeigyoKyotsu;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ConfigInfo2 のクラスファイル
 *
 * @reamsid_L DBB-1770-070 yebangqiang
 */
public class ConfigInfo2Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radSetaiNushiHyoji")
    private RadioButton radSetaiNushiHyoji;
    @JsonProperty("radDainoninHyoji")
    private RadioButton radDainoninHyoji;
    @JsonProperty("radKozaMask")
    private RadioButton radKozaMask;
    @JsonProperty("radKozaMeigininKana")
    private RadioButton radKozaMeigininKana;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradSetaiNushiHyoji
     * @return radSetaiNushiHyoji
     */
    @JsonProperty("radSetaiNushiHyoji")
    public RadioButton getRadSetaiNushiHyoji() {
        return radSetaiNushiHyoji;
    }

    /*
     * setradSetaiNushiHyoji
     * @param radSetaiNushiHyoji radSetaiNushiHyoji
     */
    @JsonProperty("radSetaiNushiHyoji")
    public void setRadSetaiNushiHyoji(RadioButton radSetaiNushiHyoji) {
        this.radSetaiNushiHyoji = radSetaiNushiHyoji;
    }

    /*
     * getradDainoninHyoji
     * @return radDainoninHyoji
     */
    @JsonProperty("radDainoninHyoji")
    public RadioButton getRadDainoninHyoji() {
        return radDainoninHyoji;
    }

    /*
     * setradDainoninHyoji
     * @param radDainoninHyoji radDainoninHyoji
     */
    @JsonProperty("radDainoninHyoji")
    public void setRadDainoninHyoji(RadioButton radDainoninHyoji) {
        this.radDainoninHyoji = radDainoninHyoji;
    }

    /*
     * getradKozaMask
     * @return radKozaMask
     */
    @JsonProperty("radKozaMask")
    public RadioButton getRadKozaMask() {
        return radKozaMask;
    }

    /*
     * setradKozaMask
     * @param radKozaMask radKozaMask
     */
    @JsonProperty("radKozaMask")
    public void setRadKozaMask(RadioButton radKozaMask) {
        this.radKozaMask = radKozaMask;
    }

    /*
     * getradKozaMeigininKana
     * @return radKozaMeigininKana
     */
    @JsonProperty("radKozaMeigininKana")
    public RadioButton getRadKozaMeigininKana() {
        return radKozaMeigininKana;
    }

    /*
     * setradKozaMeigininKana
     * @param radKozaMeigininKana radKozaMeigininKana
     */
    @JsonProperty("radKozaMeigininKana")
    public void setRadKozaMeigininKana(RadioButton radKozaMeigininKana) {
        this.radKozaMeigininKana = radKozaMeigininKana;
    }

    // </editor-fold>
}
