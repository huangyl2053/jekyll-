package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShafukuHojinToRiyushaFutanKeigen のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShafukuHojinToRiyushaFutanKeigenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShafukuHojinToRiyushaFutanKeigenInfo")
    private ShafukuHojinToRiyushaFutanKeigenInfoDiv ShafukuHojinToRiyushaFutanKeigenInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShafukuHojinToRiyushaFutanKeigenInfo
     * @return ShafukuHojinToRiyushaFutanKeigenInfo
     */
    @JsonProperty("ShafukuHojinToRiyushaFutanKeigenInfo")
    public ShafukuHojinToRiyushaFutanKeigenInfoDiv getShafukuHojinToRiyushaFutanKeigenInfo() {
        return ShafukuHojinToRiyushaFutanKeigenInfo;
    }

    /*
     * setShafukuHojinToRiyushaFutanKeigenInfo
     * @param ShafukuHojinToRiyushaFutanKeigenInfo ShafukuHojinToRiyushaFutanKeigenInfo
     */
    @JsonProperty("ShafukuHojinToRiyushaFutanKeigenInfo")
    public void setShafukuHojinToRiyushaFutanKeigenInfo(ShafukuHojinToRiyushaFutanKeigenInfoDiv ShafukuHojinToRiyushaFutanKeigenInfo) {
        this.ShafukuHojinToRiyushaFutanKeigenInfo = ShafukuHojinToRiyushaFutanKeigenInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtShafukuHojinToRiyushaFutanKeigenKetteiKubun() {
        return this.getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenKetteiKubun();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenKetteiKubun(TextBox txtShafukuHojinToRiyushaFutanKeigenKetteiKubun) {
        this.getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenKetteiKubun(txtShafukuHojinToRiyushaFutanKeigenKetteiKubun);
    }

    @JsonIgnore
    public TextBox getTxtShafukuHojinToRiyushaFutanKeigenKeigenJiyu() {
        return this.getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenKeigenJiyu();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenKeigenJiyu(TextBox txtShafukuHojinToRiyushaFutanKeigenKeigenJiyu) {
        this.getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenKeigenJiyu(txtShafukuHojinToRiyushaFutanKeigenKeigenJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShafukuHojinToRiyushaFutanKeigenShinseibi() {
        return this.getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenShinseibi();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenShinseibi(TextBoxFlexibleDate txtShafukuHojinToRiyushaFutanKeigenShinseibi) {
        this.getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenShinseibi(txtShafukuHojinToRiyushaFutanKeigenShinseibi);
    }

    @JsonIgnore
    public TextBox getTxtShafukuHojinToRiyushaFutanKeigenKeigenritsu() {
        return this.getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenKeigenritsu();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenKeigenritsu(TextBox txtShafukuHojinToRiyushaFutanKeigenKeigenritsu) {
        this.getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenKeigenritsu(txtShafukuHojinToRiyushaFutanKeigenKeigenritsu);
    }

    @JsonIgnore
    public TextBoxCode getTxtShafukuHojinToRiyushaFutanKeigenKakuninNo() {
        return this.getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenKakuninNo();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenKakuninNo(TextBoxCode txtShafukuHojinToRiyushaFutanKeigenKakuninNo) {
        this.getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenKakuninNo(txtShafukuHojinToRiyushaFutanKeigenKakuninNo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShafukuHojinToRiyushaFutanKeigenKetteibi() {
        return this.getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenKetteibi();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenKetteibi(TextBoxFlexibleDate txtShafukuHojinToRiyushaFutanKeigenKetteibi) {
        this.getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenKetteibi(txtShafukuHojinToRiyushaFutanKeigenKetteibi);
    }

    @JsonIgnore
    public TextBox getTxtShafukuHojinToRiyushaFutanKeigenKyotakuServiceGentei() {
        return this.getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenKyotakuServiceGentei();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenKyotakuServiceGentei(TextBox txtShafukuHojinToRiyushaFutanKeigenKyotakuServiceGentei) {
        this.getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenKyotakuServiceGentei(txtShafukuHojinToRiyushaFutanKeigenKyotakuServiceGentei);
    }

    @JsonIgnore
    public TextBox getTxtShafukuHojinToRiyushaFutanKeigenKyojuhiShokuhiGentei() {
        return this.getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenKyojuhiShokuhiGentei();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenKyojuhiShokuhiGentei(TextBox txtShafukuHojinToRiyushaFutanKeigenKyojuhiShokuhiGentei) {
        this.getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenKyojuhiShokuhiGentei(txtShafukuHojinToRiyushaFutanKeigenKyojuhiShokuhiGentei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShafukuHojinToRiyushaFutanKeigenTekiyobi() {
        return this.getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenTekiyobi();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenTekiyobi(TextBoxFlexibleDate txtShafukuHojinToRiyushaFutanKeigenTekiyobi) {
        this.getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenTekiyobi(txtShafukuHojinToRiyushaFutanKeigenTekiyobi);
    }

    @JsonIgnore
    public TextBox getTxtShafukuHojinToRiyushaFutanKeigenKyuSothishaUnitgataKoshitsuGentei() {
        return this.getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenKyuSothishaUnitgataKoshitsuGentei();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenKyuSothishaUnitgataKoshitsuGentei(TextBox txtShafukuHojinToRiyushaFutanKeigenKyuSothishaUnitgataKoshitsuGentei) {
        this.getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenKyuSothishaUnitgataKoshitsuGentei(txtShafukuHojinToRiyushaFutanKeigenKyuSothishaUnitgataKoshitsuGentei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShafukuHojinToRiyushaFutanKeigenYukoKigen() {
        return this.getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenYukoKigen();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenYukoKigen(TextBoxFlexibleDate txtShafukuHojinToRiyushaFutanKeigenYukoKigen) {
        this.getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenYukoKigen(txtShafukuHojinToRiyushaFutanKeigenYukoKigen);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShafukuHojinToRiyushaFutanKeigenShoninShinaiRiyu() {
        return this.getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenShoninShinaiRiyu();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenShoninShinaiRiyu(TextBoxMultiLine txtShafukuHojinToRiyushaFutanKeigenShoninShinaiRiyu) {
        this.getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenShoninShinaiRiyu(txtShafukuHojinToRiyushaFutanKeigenShoninShinaiRiyu);
    }

    // </editor-fold>
}
