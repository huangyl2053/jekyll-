package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * PnlSummary のクラスファイル
 *
 * @reamsid_L DBC-1020-030 quxiaodong
 */
public class PnlSummaryDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tpSummary")
    private tpSummaryDiv tpSummary;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettpSummary
     * @return tpSummary
     */
    @JsonProperty("tpSummary")
    public tpSummaryDiv getTpSummary() {
        return tpSummary;
    }

    /*
     * settpSummary
     * @param tpSummary tpSummary
     */
    @JsonProperty("tpSummary")
    public void setTpSummary(tpSummaryDiv tpSummary) {
        this.tpSummary = tpSummary;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblShukei() {
        return this.getTpSummary().getLblShukei();
    }

    @JsonIgnore
    public Label getLblHiyogakuGokei() {
        return this.getTpSummary().getLblHiyogakuGokei();
    }

    @JsonIgnore
    public Label getLblHokenTaishoHiyogakuGokei() {
        return this.getTpSummary().getLblHokenTaishoHiyogakuGokei();
    }

    @JsonIgnore
    public Label getLblHokenkyufugakuGokei() {
        return this.getTpSummary().getLblHokenkyufugakuGokei();
    }

    @JsonIgnore
    public Label getLblRiyoshaFutangakuGokei() {
        return this.getTpSummary().getLblRiyoshaFutangakuGokei();
    }

    @JsonIgnore
    public Label getLblZenkaimadeshiharaikeka() {
        return this.getTpSummary().getLblZenkaimadeshiharaikeka();
    }

    @JsonIgnore
    public TextBoxNum getTxtZenkaiHiyogakuGokei() {
        return this.getTpSummary().getTxtZenkaiHiyogakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtZenkaiHokenTaishoHiyogakuGokei() {
        return this.getTpSummary().getTxtZenkaiHokenTaishoHiyogakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtZenkaiHokenkyufugakuGokei() {
        return this.getTpSummary().getTxtZenkaiHokenkyufugakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtZenkaiRiyoshaFutangakuGokei() {
        return this.getTpSummary().getTxtZenkaiRiyoshaFutangakuGokei();
    }

    @JsonIgnore
    public Button getBtnKakoFukushiyogukonyuhiKakutei() {
        return this.getTpSummary().getBtnKakoFukushiyogukonyuhiKakutei();
    }

    @JsonIgnore
    public Label getLblKonkaiShiharaiJyokyo() {
        return this.getTpSummary().getLblKonkaiShiharaiJyokyo();
    }

    @JsonIgnore
    public TextBoxNum getTxtKonkaiHiyogakuGokei() {
        return this.getTpSummary().getTxtKonkaiHiyogakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtKonkaiHokenTaishoHiyogakuGokei() {
        return this.getTpSummary().getTxtKonkaiHokenTaishoHiyogakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtKonkaiHokenkyufugakuGokei() {
        return this.getTpSummary().getTxtKonkaiHokenkyufugakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtKonkaiRiyoshaFutangakuGokei() {
        return this.getTpSummary().getTxtKonkaiRiyoshaFutangakuGokei();
    }

    @JsonIgnore
    public Button getBtnGendogakuCheck() {
        return this.getTpSummary().getBtnGendogakuCheck();
    }

    // </editor-fold>
}
