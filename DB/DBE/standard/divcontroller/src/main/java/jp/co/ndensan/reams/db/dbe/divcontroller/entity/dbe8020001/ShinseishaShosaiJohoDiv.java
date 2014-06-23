package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinseishaShosaiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseishaShosaiJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshaKana")
    private TextBox txtHihokenshaKana;
    @JsonProperty("txtSeibetsu")
    private TextBox txtSeibetsu;
    @JsonProperty("txtTel")
    private TextBox txtTel;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBox txtJusho;
    @JsonProperty("txtTokuteiShippei")
    private TextBox txtTokuteiShippei;
    @JsonProperty("txtIryoHokenShubetsu")
    private TextBox txtIryoHokenShubetsu;
    @JsonProperty("txtIryoHokenNo")
    private TextBoxCode txtIryoHokenNo;
    @JsonProperty("txtIryoHokenshaMei")
    private TextBox txtIryoHokenshaMei;
    @JsonProperty("txtKigoBango")
    private TextBox txtKigoBango;
    @JsonProperty("txtShinseiDaikoKbn")
    private TextBox txtShinseiDaikoKbn;
    @JsonProperty("txtShinseiDaikoJigyosha")
    private TextBox txtShinseiDaikoJigyosha;
    @JsonProperty("txtJigyoshaKbn")
    private TextBox txtJigyoshaKbn;
    @JsonProperty("txtShinseishaYubinNo")
    private TextBoxYubinNo txtShinseishaYubinNo;
    @JsonProperty("txtShinseishaJusho")
    private TextBox txtShinseishaJusho;
    @JsonProperty("txtShinseishaTel")
    private TextBox txtShinseishaTel;
    @JsonProperty("txtShinseiRiyu")
    private TextBox txtShinseiRiyu;
    @JsonProperty("txtJohoTeikyoDoi")
    private TextBox txtJohoTeikyoDoi;
    @JsonProperty("txtEnkiTsuchiHakkoDoi")
    private TextBox txtEnkiTsuchiHakkoDoi;
    @JsonProperty("txtShisetsuNyushoUmu")
    private TextBox txtShisetsuNyushoUmu;
    @JsonProperty("txtShisetsuNyusho")
    private TextBox txtShisetsuNyusho;
    @JsonProperty("txtShisetsuNyushobi")
    private TextBoxDate txtShisetsuNyushobi;
    @JsonProperty("txtShisetsuTaishobi")
    private TextBoxDate txtShisetsuTaishobi;
    @JsonProperty("txtShichosonRenrakuJiko")
    private TextBox txtShichosonRenrakuJiko;
    @JsonProperty("txtIchijiHanteiJohoChushutsubi")
    private TextBoxDate txtIchijiHanteiJohoChushutsubi;
    @JsonProperty("txtIraiJohoDataSoshinbi")
    private TextBoxDate txtIraiJohoDataSoshinbi;
    @JsonProperty("txtCenterSoshinbi")
    private TextBoxDate txtCenterSoshinbi;
    @JsonProperty("txtMemo")
    private TextBox txtMemo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHihokenshaKana")
    public TextBox getTxtHihokenshaKana() {
        return txtHihokenshaKana;
    }

    @JsonProperty("txtHihokenshaKana")
    public void setTxtHihokenshaKana(TextBox txtHihokenshaKana) {
        this.txtHihokenshaKana=txtHihokenshaKana;
    }

    @JsonProperty("txtSeibetsu")
    public TextBox getTxtSeibetsu() {
        return txtSeibetsu;
    }

    @JsonProperty("txtSeibetsu")
    public void setTxtSeibetsu(TextBox txtSeibetsu) {
        this.txtSeibetsu=txtSeibetsu;
    }

    @JsonProperty("txtTel")
    public TextBox getTxtTel() {
        return txtTel;
    }

    @JsonProperty("txtTel")
    public void setTxtTel(TextBox txtTel) {
        this.txtTel=txtTel;
    }

    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo=txtYubinNo;
    }

    @JsonProperty("txtJusho")
    public TextBox getTxtJusho() {
        return txtJusho;
    }

    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBox txtJusho) {
        this.txtJusho=txtJusho;
    }

    @JsonProperty("txtTokuteiShippei")
    public TextBox getTxtTokuteiShippei() {
        return txtTokuteiShippei;
    }

    @JsonProperty("txtTokuteiShippei")
    public void setTxtTokuteiShippei(TextBox txtTokuteiShippei) {
        this.txtTokuteiShippei=txtTokuteiShippei;
    }

    @JsonProperty("txtIryoHokenShubetsu")
    public TextBox getTxtIryoHokenShubetsu() {
        return txtIryoHokenShubetsu;
    }

    @JsonProperty("txtIryoHokenShubetsu")
    public void setTxtIryoHokenShubetsu(TextBox txtIryoHokenShubetsu) {
        this.txtIryoHokenShubetsu=txtIryoHokenShubetsu;
    }

    @JsonProperty("txtIryoHokenNo")
    public TextBoxCode getTxtIryoHokenNo() {
        return txtIryoHokenNo;
    }

    @JsonProperty("txtIryoHokenNo")
    public void setTxtIryoHokenNo(TextBoxCode txtIryoHokenNo) {
        this.txtIryoHokenNo=txtIryoHokenNo;
    }

    @JsonProperty("txtIryoHokenshaMei")
    public TextBox getTxtIryoHokenshaMei() {
        return txtIryoHokenshaMei;
    }

    @JsonProperty("txtIryoHokenshaMei")
    public void setTxtIryoHokenshaMei(TextBox txtIryoHokenshaMei) {
        this.txtIryoHokenshaMei=txtIryoHokenshaMei;
    }

    @JsonProperty("txtKigoBango")
    public TextBox getTxtKigoBango() {
        return txtKigoBango;
    }

    @JsonProperty("txtKigoBango")
    public void setTxtKigoBango(TextBox txtKigoBango) {
        this.txtKigoBango=txtKigoBango;
    }

    @JsonProperty("txtShinseiDaikoKbn")
    public TextBox getTxtShinseiDaikoKbn() {
        return txtShinseiDaikoKbn;
    }

    @JsonProperty("txtShinseiDaikoKbn")
    public void setTxtShinseiDaikoKbn(TextBox txtShinseiDaikoKbn) {
        this.txtShinseiDaikoKbn=txtShinseiDaikoKbn;
    }

    @JsonProperty("txtShinseiDaikoJigyosha")
    public TextBox getTxtShinseiDaikoJigyosha() {
        return txtShinseiDaikoJigyosha;
    }

    @JsonProperty("txtShinseiDaikoJigyosha")
    public void setTxtShinseiDaikoJigyosha(TextBox txtShinseiDaikoJigyosha) {
        this.txtShinseiDaikoJigyosha=txtShinseiDaikoJigyosha;
    }

    @JsonProperty("txtJigyoshaKbn")
    public TextBox getTxtJigyoshaKbn() {
        return txtJigyoshaKbn;
    }

    @JsonProperty("txtJigyoshaKbn")
    public void setTxtJigyoshaKbn(TextBox txtJigyoshaKbn) {
        this.txtJigyoshaKbn=txtJigyoshaKbn;
    }

    @JsonProperty("txtShinseishaYubinNo")
    public TextBoxYubinNo getTxtShinseishaYubinNo() {
        return txtShinseishaYubinNo;
    }

    @JsonProperty("txtShinseishaYubinNo")
    public void setTxtShinseishaYubinNo(TextBoxYubinNo txtShinseishaYubinNo) {
        this.txtShinseishaYubinNo=txtShinseishaYubinNo;
    }

    @JsonProperty("txtShinseishaJusho")
    public TextBox getTxtShinseishaJusho() {
        return txtShinseishaJusho;
    }

    @JsonProperty("txtShinseishaJusho")
    public void setTxtShinseishaJusho(TextBox txtShinseishaJusho) {
        this.txtShinseishaJusho=txtShinseishaJusho;
    }

    @JsonProperty("txtShinseishaTel")
    public TextBox getTxtShinseishaTel() {
        return txtShinseishaTel;
    }

    @JsonProperty("txtShinseishaTel")
    public void setTxtShinseishaTel(TextBox txtShinseishaTel) {
        this.txtShinseishaTel=txtShinseishaTel;
    }

    @JsonProperty("txtShinseiRiyu")
    public TextBox getTxtShinseiRiyu() {
        return txtShinseiRiyu;
    }

    @JsonProperty("txtShinseiRiyu")
    public void setTxtShinseiRiyu(TextBox txtShinseiRiyu) {
        this.txtShinseiRiyu=txtShinseiRiyu;
    }

    @JsonProperty("txtJohoTeikyoDoi")
    public TextBox getTxtJohoTeikyoDoi() {
        return txtJohoTeikyoDoi;
    }

    @JsonProperty("txtJohoTeikyoDoi")
    public void setTxtJohoTeikyoDoi(TextBox txtJohoTeikyoDoi) {
        this.txtJohoTeikyoDoi=txtJohoTeikyoDoi;
    }

    @JsonProperty("txtEnkiTsuchiHakkoDoi")
    public TextBox getTxtEnkiTsuchiHakkoDoi() {
        return txtEnkiTsuchiHakkoDoi;
    }

    @JsonProperty("txtEnkiTsuchiHakkoDoi")
    public void setTxtEnkiTsuchiHakkoDoi(TextBox txtEnkiTsuchiHakkoDoi) {
        this.txtEnkiTsuchiHakkoDoi=txtEnkiTsuchiHakkoDoi;
    }

    @JsonProperty("txtShisetsuNyushoUmu")
    public TextBox getTxtShisetsuNyushoUmu() {
        return txtShisetsuNyushoUmu;
    }

    @JsonProperty("txtShisetsuNyushoUmu")
    public void setTxtShisetsuNyushoUmu(TextBox txtShisetsuNyushoUmu) {
        this.txtShisetsuNyushoUmu=txtShisetsuNyushoUmu;
    }

    @JsonProperty("txtShisetsuNyusho")
    public TextBox getTxtShisetsuNyusho() {
        return txtShisetsuNyusho;
    }

    @JsonProperty("txtShisetsuNyusho")
    public void setTxtShisetsuNyusho(TextBox txtShisetsuNyusho) {
        this.txtShisetsuNyusho=txtShisetsuNyusho;
    }

    @JsonProperty("txtShisetsuNyushobi")
    public TextBoxDate getTxtShisetsuNyushobi() {
        return txtShisetsuNyushobi;
    }

    @JsonProperty("txtShisetsuNyushobi")
    public void setTxtShisetsuNyushobi(TextBoxDate txtShisetsuNyushobi) {
        this.txtShisetsuNyushobi=txtShisetsuNyushobi;
    }

    @JsonProperty("txtShisetsuTaishobi")
    public TextBoxDate getTxtShisetsuTaishobi() {
        return txtShisetsuTaishobi;
    }

    @JsonProperty("txtShisetsuTaishobi")
    public void setTxtShisetsuTaishobi(TextBoxDate txtShisetsuTaishobi) {
        this.txtShisetsuTaishobi=txtShisetsuTaishobi;
    }

    @JsonProperty("txtShichosonRenrakuJiko")
    public TextBox getTxtShichosonRenrakuJiko() {
        return txtShichosonRenrakuJiko;
    }

    @JsonProperty("txtShichosonRenrakuJiko")
    public void setTxtShichosonRenrakuJiko(TextBox txtShichosonRenrakuJiko) {
        this.txtShichosonRenrakuJiko=txtShichosonRenrakuJiko;
    }

    @JsonProperty("txtIchijiHanteiJohoChushutsubi")
    public TextBoxDate getTxtIchijiHanteiJohoChushutsubi() {
        return txtIchijiHanteiJohoChushutsubi;
    }

    @JsonProperty("txtIchijiHanteiJohoChushutsubi")
    public void setTxtIchijiHanteiJohoChushutsubi(TextBoxDate txtIchijiHanteiJohoChushutsubi) {
        this.txtIchijiHanteiJohoChushutsubi=txtIchijiHanteiJohoChushutsubi;
    }

    @JsonProperty("txtIraiJohoDataSoshinbi")
    public TextBoxDate getTxtIraiJohoDataSoshinbi() {
        return txtIraiJohoDataSoshinbi;
    }

    @JsonProperty("txtIraiJohoDataSoshinbi")
    public void setTxtIraiJohoDataSoshinbi(TextBoxDate txtIraiJohoDataSoshinbi) {
        this.txtIraiJohoDataSoshinbi=txtIraiJohoDataSoshinbi;
    }

    @JsonProperty("txtCenterSoshinbi")
    public TextBoxDate getTxtCenterSoshinbi() {
        return txtCenterSoshinbi;
    }

    @JsonProperty("txtCenterSoshinbi")
    public void setTxtCenterSoshinbi(TextBoxDate txtCenterSoshinbi) {
        this.txtCenterSoshinbi=txtCenterSoshinbi;
    }

    @JsonProperty("txtMemo")
    public TextBox getTxtMemo() {
        return txtMemo;
    }

    @JsonProperty("txtMemo")
    public void setTxtMemo(TextBox txtMemo) {
        this.txtMemo=txtMemo;
    }

}
