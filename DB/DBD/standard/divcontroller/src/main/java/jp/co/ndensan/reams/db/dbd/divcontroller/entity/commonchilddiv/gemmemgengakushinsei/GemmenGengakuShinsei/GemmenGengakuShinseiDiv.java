package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.ShinseiJoho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.StaticImage;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxKana;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxAtenaMeisho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxJusho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;

/**
 * GemmenGengakuShinsei のクラスファイル
 *
 * @author 自動生成
 */
public class GemmenGengakuShinseiDiv extends Panel implements IGemmenGengakuShinseiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShinseiDaikoKubun")
    private DropDownList ddlShinseiDaikoKubun;
    @JsonProperty("Shinseisha")
    private ShinseishaDiv Shinseisha;
    @JsonProperty("ShinseiDaikoJigyosha")
    private ShinseiDaikoJigyoshaDiv ShinseiDaikoJigyosha;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;
    @JsonProperty("shikibetsuCode")
    private RString shikibetsuCode;
    @JsonProperty("jigyoshaCode")
    private RString jigyoshaCode;
    @JsonProperty("jigyoshaMeisho")
    private RString jigyoshaMeisho;
    @JsonProperty("jigyoshaCodeMeisho")
    private RString jigyoshaCodeMeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShinseiDaikoKubun
     * @return ddlShinseiDaikoKubun
     */
    @JsonProperty("ddlShinseiDaikoKubun")
    public DropDownList getDdlShinseiDaikoKubun() {
        return ddlShinseiDaikoKubun;
    }

    /*
     * setddlShinseiDaikoKubun
     * @param ddlShinseiDaikoKubun ddlShinseiDaikoKubun
     */
    @JsonProperty("ddlShinseiDaikoKubun")
    public void setDdlShinseiDaikoKubun(DropDownList ddlShinseiDaikoKubun) {
        this.ddlShinseiDaikoKubun = ddlShinseiDaikoKubun;
    }

    /*
     * getShinseisha
     * @return Shinseisha
     */
    @JsonProperty("Shinseisha")
    public ShinseishaDiv getShinseisha() {
        return Shinseisha;
    }

    /*
     * setShinseisha
     * @param Shinseisha Shinseisha
     */
    @JsonProperty("Shinseisha")
    public void setShinseisha(ShinseishaDiv Shinseisha) {
        this.Shinseisha = Shinseisha;
    }

    /*
     * getShinseiDaikoJigyosha
     * @return ShinseiDaikoJigyosha
     */
    @JsonProperty("ShinseiDaikoJigyosha")
    public ShinseiDaikoJigyoshaDiv getShinseiDaikoJigyosha() {
        return ShinseiDaikoJigyosha;
    }

    /*
     * setShinseiDaikoJigyosha
     * @param ShinseiDaikoJigyosha ShinseiDaikoJigyosha
     */
    @JsonProperty("ShinseiDaikoJigyosha")
    public void setShinseiDaikoJigyosha(ShinseiDaikoJigyoshaDiv ShinseiDaikoJigyosha) {
        this.ShinseiDaikoJigyosha = ShinseiDaikoJigyosha;
    }

    /*
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /*
     * getshikibetsuCode
     * @return shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    /*
     * setshikibetsuCode
     * @param shikibetsuCode shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public void setShikibetsuCode(RString shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /*
     * getjigyoshaCode
     * @return jigyoshaCode
     */
    @JsonProperty("jigyoshaCode")
    public RString getJigyoshaCode() {
        return jigyoshaCode;
    }

    /*
     * setjigyoshaCode
     * @param jigyoshaCode jigyoshaCode
     */
    @JsonProperty("jigyoshaCode")
    public void setJigyoshaCode(RString jigyoshaCode) {
        this.jigyoshaCode = jigyoshaCode;
    }

    /*
     * getjigyoshaMeisho
     * @return jigyoshaMeisho
     */
    @JsonProperty("jigyoshaMeisho")
    public RString getJigyoshaMeisho() {
        return jigyoshaMeisho;
    }

    /*
     * setjigyoshaMeisho
     * @param jigyoshaMeisho jigyoshaMeisho
     */
    @JsonProperty("jigyoshaMeisho")
    public void setJigyoshaMeisho(RString jigyoshaMeisho) {
        this.jigyoshaMeisho = jigyoshaMeisho;
    }

    /*
     * getjigyoshaCodeMeisho
     * @return jigyoshaCodeMeisho
     */
    @JsonProperty("jigyoshaCodeMeisho")
    public RString getJigyoshaCodeMeisho() {
        return jigyoshaCodeMeisho;
    }

    /*
     * setjigyoshaCodeMeisho
     * @param jigyoshaCodeMeisho jigyoshaCodeMeisho
     */
    @JsonProperty("jigyoshaCodeMeisho")
    public void setJigyoshaCodeMeisho(RString jigyoshaCodeMeisho) {
        this.jigyoshaCodeMeisho = jigyoshaCodeMeisho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxKana getTxtShinseishaShimeiKana() {
        return this.getShinseisha().getTxtShinseishaShimeiKana();
    }

    @JsonIgnore
    public void  setTxtShinseishaShimeiKana(TextBoxKana txtShinseishaShimeiKana) {
        this.getShinseisha().setTxtShinseishaShimeiKana(txtShinseishaShimeiKana);
    }

    @JsonIgnore
    public Button getTxtCopyHonnin() {
        return this.getShinseisha().getTxtCopyHonnin();
    }

    @JsonIgnore
    public void  setTxtCopyHonnin(Button txtCopyHonnin) {
        this.getShinseisha().setTxtCopyHonnin(txtCopyHonnin);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtShinseishaShimei() {
        return this.getShinseisha().getTxtShinseishaShimei();
    }

    @JsonIgnore
    public void  setTxtShinseishaShimei(TextBoxAtenaMeisho txtShinseishaShimei) {
        this.getShinseisha().setTxtShinseishaShimei(txtShinseishaShimei);
    }

    @JsonIgnore
    public TextBox getTxtShinseishaTsuzukigara() {
        return this.getShinseisha().getTxtShinseishaTsuzukigara();
    }

    @JsonIgnore
    public void  setTxtShinseishaTsuzukigara(TextBox txtShinseishaTsuzukigara) {
        this.getShinseisha().setTxtShinseishaTsuzukigara(txtShinseishaTsuzukigara);
    }

    @JsonIgnore
    public StaticImage getImgYubinNoLabel() {
        return this.getShinseisha().getImgYubinNoLabel();
    }

    @JsonIgnore
    public void  setImgYubinNoLabel(StaticImage imgYubinNoLabel) {
        this.getShinseisha().setImgYubinNoLabel(imgYubinNoLabel);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtShinseishaYubinNo() {
        return this.getShinseisha().getTxtShinseishaYubinNo();
    }

    @JsonIgnore
    public void  setTxtShinseishaYubinNo(TextBoxYubinNo txtShinseishaYubinNo) {
        this.getShinseisha().setTxtShinseishaYubinNo(txtShinseishaYubinNo);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtShinseishaTelNo() {
        return this.getShinseisha().getTxtShinseishaTelNo();
    }

    @JsonIgnore
    public void  setTxtShinseishaTelNo(TextBoxTelNo txtShinseishaTelNo) {
        this.getShinseisha().setTxtShinseishaTelNo(txtShinseishaTelNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtShinseishaJusho() {
        return this.getShinseisha().getTxtShinseishaJusho();
    }

    @JsonIgnore
    public void  setTxtShinseishaJusho(TextBoxJusho txtShinseishaJusho) {
        this.getShinseisha().setTxtShinseishaJusho(txtShinseishaJusho);
    }

    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdShisetsuJoho() {
        return this.getShinseiDaikoJigyosha().getCcdShisetsuJoho();
    }

    @JsonIgnore
    public DropDownList getDdlJigyoshaKubun() {
        return this.getShinseiDaikoJigyosha().getDdlJigyoshaKubun();
    }

    @JsonIgnore
    public void  setDdlJigyoshaKubun(DropDownList ddlJigyoshaKubun) {
        this.getShinseiDaikoJigyosha().setDdlJigyoshaKubun(ddlJigyoshaKubun);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(ShikibetsuCode 本人識別コード) {
        getHandler(this).onLoad(本人識別コード);
    }

    @Override
    public ShikibetsuCode get本人識別コード() {
        return getHandler(this).get本人識別コード();
    }

    @Override
    public void set減免減額申請情報(ShinseiJoho 減免減額申請情報, FlexibleDate 申請日) {
        getHandler(this).set減免減額申請情報(減免減額申請情報, 申請日);
    }

    @Override
    public ShinseiJoho get減免減額申請情報() {
        return getHandler(this).get減免減額申請情報();
    }

    private GemmenGengakuShinseiHandler getHandler(GemmenGengakuShinseiDiv div) {
        return new GemmenGengakuShinseiHandler(div);
    }

}
