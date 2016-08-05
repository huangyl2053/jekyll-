package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;

/**
 * tplJikofutanKanriJoho2 のクラスファイル
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class tplJikofutanKanriJoho2Div extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JikoFutangakuHoseiAtesaki")
    private JikoFutangakuHoseiAtesakiDiv JikoFutangakuHoseiAtesaki;
    @JsonProperty("JikoFutangakuHoseiMadoguchi")
    private JikoFutangakuHoseiMadoguchiDiv JikoFutangakuHoseiMadoguchi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJikoFutangakuHoseiAtesaki
     * @return JikoFutangakuHoseiAtesaki
     */
    @JsonProperty("JikoFutangakuHoseiAtesaki")
    public JikoFutangakuHoseiAtesakiDiv getJikoFutangakuHoseiAtesaki() {
        return JikoFutangakuHoseiAtesaki;
    }

    /*
     * setJikoFutangakuHoseiAtesaki
     * @param JikoFutangakuHoseiAtesaki JikoFutangakuHoseiAtesaki
     */
    @JsonProperty("JikoFutangakuHoseiAtesaki")
    public void setJikoFutangakuHoseiAtesaki(JikoFutangakuHoseiAtesakiDiv JikoFutangakuHoseiAtesaki) {
        this.JikoFutangakuHoseiAtesaki = JikoFutangakuHoseiAtesaki;
    }

    /*
     * getJikoFutangakuHoseiMadoguchi
     * @return JikoFutangakuHoseiMadoguchi
     */
    @JsonProperty("JikoFutangakuHoseiMadoguchi")
    public JikoFutangakuHoseiMadoguchiDiv getJikoFutangakuHoseiMadoguchi() {
        return JikoFutangakuHoseiMadoguchi;
    }

    /*
     * setJikoFutangakuHoseiMadoguchi
     * @param JikoFutangakuHoseiMadoguchi JikoFutangakuHoseiMadoguchi
     */
    @JsonProperty("JikoFutangakuHoseiMadoguchi")
    public void setJikoFutangakuHoseiMadoguchi(JikoFutangakuHoseiMadoguchiDiv JikoFutangakuHoseiMadoguchi) {
        this.JikoFutangakuHoseiMadoguchi = JikoFutangakuHoseiMadoguchi;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtAtesakiShimei() {
        return this.getJikoFutangakuHoseiAtesaki().getTxtAtesakiShimei();
    }

    @JsonIgnore
    public void setTxtAtesakiShimei(TextBox txtAtesakiShimei) {
        this.getJikoFutangakuHoseiAtesaki().setTxtAtesakiShimei(txtAtesakiShimei);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtAtesakiYubinNO() {
        return this.getJikoFutangakuHoseiAtesaki().getTxtAtesakiYubinNO();
    }

    @JsonIgnore
    public void setTxtAtesakiYubinNO(TextBoxYubinNo txtAtesakiYubinNO) {
        this.getJikoFutangakuHoseiAtesaki().setTxtAtesakiYubinNO(txtAtesakiYubinNO);
    }

    @JsonIgnore
    public TextBox getTxtAtesakiJusho() {
        return this.getJikoFutangakuHoseiAtesaki().getTxtAtesakiJusho();
    }

    @JsonIgnore
    public void setTxtAtesakiJusho(TextBox txtAtesakiJusho) {
        this.getJikoFutangakuHoseiAtesaki().setTxtAtesakiJusho(txtAtesakiJusho);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiTaishoushaHantei() {
        return this.getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiTaishoushaHantei();
    }

    @JsonIgnore
    public void setTxtMadoguchiTaishoushaHantei(TextBox txtMadoguchiTaishoushaHantei) {
        this.getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiTaishoushaHantei(txtMadoguchiTaishoushaHantei);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiShiharaiBasho() {
        return this.getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShiharaiBasho();
    }

    @JsonIgnore
    public void setTxtMadoguchiShiharaiBasho(TextBox txtMadoguchiShiharaiBasho) {
        this.getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShiharaiBasho(txtMadoguchiShiharaiBasho);
    }

    @JsonIgnore
    public TextBoxDate getTxtMadoguchiKaishiYMD() {
        return this.getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiYMD();
    }

    @JsonIgnore
    public void setTxtMadoguchiKaishiYMD(TextBoxDate txtMadoguchiKaishiYMD) {
        this.getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiYMD(txtMadoguchiKaishiYMD);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiKaishiYoubi() {
        return this.getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiYoubi();
    }

    @JsonIgnore
    public void setTxtMadoguchiKaishiYoubi(TextBox txtMadoguchiKaishiYoubi) {
        this.getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiYoubi(txtMadoguchiKaishiYoubi);
    }

    @JsonIgnore
    public TextBoxNum getTxtMadoguchiKaishiJikan() {
        return this.getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiJikan();
    }

    @JsonIgnore
    public void setTxtMadoguchiKaishiJikan(TextBoxNum txtMadoguchiKaishiJikan) {
        this.getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiJikan(txtMadoguchiKaishiJikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtMadoguchiKaishiFun() {
        return this.getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiFun();
    }

    @JsonIgnore
    public void setTxtMadoguchiKaishiFun(TextBoxNum txtMadoguchiKaishiFun) {
        this.getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiFun(txtMadoguchiKaishiFun);
    }

    @JsonIgnore
    public TextBoxDate getTxtMadoguchiShuryoYMD() {
        return this.getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoYMD();
    }

    @JsonIgnore
    public void setTxtMadoguchiShuryoYMD(TextBoxDate txtMadoguchiShuryoYMD) {
        this.getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoYMD(txtMadoguchiShuryoYMD);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiShuryoYoubi() {
        return this.getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoYoubi();
    }

    @JsonIgnore
    public void setTxtMadoguchiShuryoYoubi(TextBox txtMadoguchiShuryoYoubi) {
        this.getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoYoubi(txtMadoguchiShuryoYoubi);
    }

    @JsonIgnore
    public TextBoxNum getTxtMadoguchiShuryoJikan() {
        return this.getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoJikan();
    }

    @JsonIgnore
    public void setTxtMadoguchiShuryoJikan(TextBoxNum txtMadoguchiShuryoJikan) {
        this.getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoJikan(txtMadoguchiShuryoJikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtMadoguchiShuryoFun() {
        return this.getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoFun();
    }

    @JsonIgnore
    public void setTxtMadoguchiShuryoFun(TextBoxNum txtMadoguchiShuryoFun) {
        this.getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoFun(txtMadoguchiShuryoFun);
    }

    // </editor-fold>
}
