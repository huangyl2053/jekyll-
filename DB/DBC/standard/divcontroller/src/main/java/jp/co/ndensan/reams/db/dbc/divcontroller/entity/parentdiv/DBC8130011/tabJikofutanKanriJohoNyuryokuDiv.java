package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;

/**
 * tabJikofutanKanriJohoNyuryoku のクラスファイル
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class tabJikofutanKanriJohoNyuryokuDiv extends TabContainer {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplJikofutanKanriJoho1")
    private tplJikofutanKanriJoho1Div tplJikofutanKanriJoho1;
    @JsonProperty("tplJikofutanKanriJoho2")
    private tplJikofutanKanriJoho2Div tplJikofutanKanriJoho2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplJikofutanKanriJoho1
     * @return tplJikofutanKanriJoho1
     */
    @JsonProperty("tplJikofutanKanriJoho1")
    public tplJikofutanKanriJoho1Div getTplJikofutanKanriJoho1() {
        return tplJikofutanKanriJoho1;
    }

    /*
     * settplJikofutanKanriJoho1
     * @param tplJikofutanKanriJoho1 tplJikofutanKanriJoho1
     */
    @JsonProperty("tplJikofutanKanriJoho1")
    public void setTplJikofutanKanriJoho1(tplJikofutanKanriJoho1Div tplJikofutanKanriJoho1) {
        this.tplJikofutanKanriJoho1 = tplJikofutanKanriJoho1;
    }

    /*
     * gettplJikofutanKanriJoho2
     * @return tplJikofutanKanriJoho2
     */
    @JsonProperty("tplJikofutanKanriJoho2")
    public tplJikofutanKanriJoho2Div getTplJikofutanKanriJoho2() {
        return tplJikofutanKanriJoho2;
    }

    /*
     * settplJikofutanKanriJoho2
     * @param tplJikofutanKanriJoho2 tplJikofutanKanriJoho2
     */
    @JsonProperty("tplJikofutanKanriJoho2")
    public void setTplJikofutanKanriJoho2(tplJikofutanKanriJoho2Div tplJikofutanKanriJoho2) {
        this.tplJikofutanKanriJoho2 = tplJikofutanKanriJoho2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtIdouKBN() {
        return this.getTplJikofutanKanriJoho1().getTxtIdouKBN();
    }

    @JsonIgnore
    public void setTxtIdouKBN(TextBox txtIdouKBN) {
        this.getTplJikofutanKanriJoho1().setTxtIdouKBN(txtIdouKBN);
    }

    @JsonIgnore
    public DropDownList getDdlShotokuKBN() {
        return this.getTplJikofutanKanriJoho1().getDdlShotokuKBN();
    }

    @JsonIgnore
    public void setDdlShotokuKBN(DropDownList ddlShotokuKBN) {
        this.getTplJikofutanKanriJoho1().setDdlShotokuKBN(ddlShotokuKBN);
    }

    @JsonIgnore
    public DropDownList getDdl70SaiIjouShotokuKBN() {
        return this.getTplJikofutanKanriJoho1().getDdl70SaiIjouShotokuKBN();
    }

    @JsonIgnore
    public void setDdl70SaiIjouShotokuKBN(DropDownList ddl70SaiIjouShotokuKBN) {
        this.getTplJikofutanKanriJoho1().setDdl70SaiIjouShotokuKBN(ddl70SaiIjouShotokuKBN);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaName() {
        return this.getTplJikofutanKanriJoho1().getTxtHihokenshaName();
    }

    @JsonIgnore
    public void setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.getTplJikofutanKanriJoho1().setTxtHihokenshaName(txtHihokenshaName);
    }

    @JsonIgnore
    public JikoFutangakuHoseiTotsugo1Div getJikoFutangakuHoseiTotsugo1() {
        return this.getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1();
    }

    @JsonIgnore
    public void setJikoFutangakuHoseiTotsugo1(JikoFutangakuHoseiTotsugo1Div JikoFutangakuHoseiTotsugo1) {
        this.getTplJikofutanKanriJoho1().setJikoFutangakuHoseiTotsugo1(JikoFutangakuHoseiTotsugo1);
    }

    @JsonIgnore
    public TextBox getTxtKoukiHokenjaNO() {
        return this.getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1().getTxtKoukiHokenjaNO();
    }

    @JsonIgnore
    public void setTxtKoukiHokenjaNO(TextBox txtKoukiHokenjaNO) {
        this.getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1().setTxtKoukiHokenjaNO(txtKoukiHokenjaNO);
    }

    @JsonIgnore
    public TextBox getTxtKoukiHihokenshaNO() {
        return this.getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1().getTxtKoukiHihokenshaNO();
    }

    @JsonIgnore
    public void setTxtKoukiHihokenshaNO(TextBox txtKoukiHihokenshaNO) {
        this.getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1().setTxtKoukiHihokenshaNO(txtKoukiHihokenshaNO);
    }

    @JsonIgnore
    public JikoFutangakuHoseiTotsugo2Div getJikoFutangakuHoseiTotsugo2() {
        return this.getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2();
    }

    @JsonIgnore
    public void setJikoFutangakuHoseiTotsugo2(JikoFutangakuHoseiTotsugo2Div JikoFutangakuHoseiTotsugo2) {
        this.getTplJikofutanKanriJoho1().setJikoFutangakuHoseiTotsugo2(JikoFutangakuHoseiTotsugo2);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHokenjaNO() {
        return this.getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().getTxtKokuhoHokenjaNO();
    }

    @JsonIgnore
    public void setTxtKokuhoHokenjaNO(TextBox txtKokuhoHokenjaNO) {
        this.getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().setTxtKokuhoHokenjaNO(txtKokuhoHokenjaNO);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHihokenshaKojinNO() {
        return this.getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().getTxtKokuhoHihokenshaKojinNO();
    }

    @JsonIgnore
    public void setTxtKokuhoHihokenshaKojinNO(TextBox txtKokuhoHihokenshaKojinNO) {
        this.getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().setTxtKokuhoHihokenshaKojinNO(txtKokuhoHihokenshaKojinNO);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHihokenshashouNO() {
        return this.getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().getTxtKokuhoHihokenshashouNO();
    }

    @JsonIgnore
    public void setTxtKokuhoHihokenshashouNO(TextBox txtKokuhoHihokenshashouNO) {
        this.getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().setTxtKokuhoHihokenshashouNO(txtKokuhoHihokenshashouNO);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getTplJikofutanKanriJoho1().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getTplJikofutanKanriJoho1().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTaishouKeisanKikan() {
        return this.getTplJikofutanKanriJoho1().getTxtTaishouKeisanKikan();
    }

    @JsonIgnore
    public void setTxtTaishouKeisanKikan(TextBoxDateRange txtTaishouKeisanKikan) {
        this.getTplJikofutanKanriJoho1().setTxtTaishouKeisanKikan(txtTaishouKeisanKikan);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtHihokenshaKikan() {
        return this.getTplJikofutanKanriJoho1().getTxtHihokenshaKikan();
    }

    @JsonIgnore
    public void setTxtHihokenshaKikan(TextBoxDateRange txtHihokenshaKikan) {
        this.getTplJikofutanKanriJoho1().setTxtHihokenshaKikan(txtHihokenshaKikan);
    }

    @JsonIgnore
    public JikoFutangakuHoseiAtesakiDiv getJikoFutangakuHoseiAtesaki() {
        return this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki();
    }

    @JsonIgnore
    public void setJikoFutangakuHoseiAtesaki(JikoFutangakuHoseiAtesakiDiv JikoFutangakuHoseiAtesaki) {
        this.getTplJikofutanKanriJoho2().setJikoFutangakuHoseiAtesaki(JikoFutangakuHoseiAtesaki);
    }

    @JsonIgnore
    public TextBox getTxtAtesakiShimei() {
        return this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().getTxtAtesakiShimei();
    }

    @JsonIgnore
    public void setTxtAtesakiShimei(TextBox txtAtesakiShimei) {
        this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().setTxtAtesakiShimei(txtAtesakiShimei);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtAtesakiYubinNO() {
        return this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().getTxtAtesakiYubinNO();
    }

    @JsonIgnore
    public void setTxtAtesakiYubinNO(TextBoxYubinNo txtAtesakiYubinNO) {
        this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().setTxtAtesakiYubinNO(txtAtesakiYubinNO);
    }

    @JsonIgnore
    public TextBox getTxtAtesakiJusho() {
        return this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().getTxtAtesakiJusho();
    }

    @JsonIgnore
    public void setTxtAtesakiJusho(TextBox txtAtesakiJusho) {
        this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().setTxtAtesakiJusho(txtAtesakiJusho);
    }

    @JsonIgnore
    public JikoFutangakuHoseiMadoguchiDiv getJikoFutangakuHoseiMadoguchi() {
        return this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi();
    }

    @JsonIgnore
    public void setJikoFutangakuHoseiMadoguchi(JikoFutangakuHoseiMadoguchiDiv JikoFutangakuHoseiMadoguchi) {
        this.getTplJikofutanKanriJoho2().setJikoFutangakuHoseiMadoguchi(JikoFutangakuHoseiMadoguchi);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiTaishoushaHantei() {
        return this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiTaishoushaHantei();
    }

    @JsonIgnore
    public void setTxtMadoguchiTaishoushaHantei(TextBox txtMadoguchiTaishoushaHantei) {
        this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiTaishoushaHantei(txtMadoguchiTaishoushaHantei);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiShiharaiBasho() {
        return this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShiharaiBasho();
    }

    @JsonIgnore
    public void setTxtMadoguchiShiharaiBasho(TextBox txtMadoguchiShiharaiBasho) {
        this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShiharaiBasho(txtMadoguchiShiharaiBasho);
    }

    @JsonIgnore
    public TextBoxDate getTxtMadoguchiKaishiYMD() {
        return this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiYMD();
    }

    @JsonIgnore
    public void setTxtMadoguchiKaishiYMD(TextBoxDate txtMadoguchiKaishiYMD) {
        this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiYMD(txtMadoguchiKaishiYMD);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiKaishiYoubi() {
        return this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiYoubi();
    }

    @JsonIgnore
    public void setTxtMadoguchiKaishiYoubi(TextBox txtMadoguchiKaishiYoubi) {
        this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiYoubi(txtMadoguchiKaishiYoubi);
    }

    @JsonIgnore
    public TextBoxNum getTxtMadoguchiKaishiJikan() {
        return this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiJikan();
    }

    @JsonIgnore
    public void setTxtMadoguchiKaishiJikan(TextBoxNum txtMadoguchiKaishiJikan) {
        this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiJikan(txtMadoguchiKaishiJikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtMadoguchiKaishiFun() {
        return this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiFun();
    }

    @JsonIgnore
    public void setTxtMadoguchiKaishiFun(TextBoxNum txtMadoguchiKaishiFun) {
        this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiFun(txtMadoguchiKaishiFun);
    }

    @JsonIgnore
    public TextBoxDate getTxtMadoguchiShuryoYMD() {
        return this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoYMD();
    }

    @JsonIgnore
    public void setTxtMadoguchiShuryoYMD(TextBoxDate txtMadoguchiShuryoYMD) {
        this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoYMD(txtMadoguchiShuryoYMD);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiShuryoYoubi() {
        return this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoYoubi();
    }

    @JsonIgnore
    public void setTxtMadoguchiShuryoYoubi(TextBox txtMadoguchiShuryoYoubi) {
        this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoYoubi(txtMadoguchiShuryoYoubi);
    }

    @JsonIgnore
    public TextBoxNum getTxtMadoguchiShuryoJikan() {
        return this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoJikan();
    }

    @JsonIgnore
    public void setTxtMadoguchiShuryoJikan(TextBoxNum txtMadoguchiShuryoJikan) {
        this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoJikan(txtMadoguchiShuryoJikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtMadoguchiShuryoFun() {
        return this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoFun();
    }

    @JsonIgnore
    public void setTxtMadoguchiShuryoFun(TextBoxNum txtMadoguchiShuryoFun) {
        this.getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoFun(txtMadoguchiShuryoFun);
    }

    // </editor-fold>
}
