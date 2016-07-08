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
 * HomonKaigoRiyoshaFutangakuGengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class HomonKaigoRiyoshaFutangakuGengakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HomonKaigoRiyoshaFutangakuGengakuInfo")
    private HomonKaigoRiyoshaFutangakuGengakuInfoDiv HomonKaigoRiyoshaFutangakuGengakuInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHomonKaigoRiyoshaFutangakuGengakuInfo
     * @return HomonKaigoRiyoshaFutangakuGengakuInfo
     */
    @JsonProperty("HomonKaigoRiyoshaFutangakuGengakuInfo")
    public HomonKaigoRiyoshaFutangakuGengakuInfoDiv getHomonKaigoRiyoshaFutangakuGengakuInfo() {
        return HomonKaigoRiyoshaFutangakuGengakuInfo;
    }

    /*
     * setHomonKaigoRiyoshaFutangakuGengakuInfo
     * @param HomonKaigoRiyoshaFutangakuGengakuInfo HomonKaigoRiyoshaFutangakuGengakuInfo
     */
    @JsonProperty("HomonKaigoRiyoshaFutangakuGengakuInfo")
    public void setHomonKaigoRiyoshaFutangakuGengakuInfo(HomonKaigoRiyoshaFutangakuGengakuInfoDiv HomonKaigoRiyoshaFutangakuGengakuInfo) {
        this.HomonKaigoRiyoshaFutangakuGengakuInfo = HomonKaigoRiyoshaFutangakuGengakuInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtHomonKaigoRiyoshaFutangakuGengakuKetteiKubun() {
        return this.getHomonKaigoRiyoshaFutangakuGengakuInfo().getTxtHomonKaigoRiyoshaFutangakuGengakuKetteiKubun();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoRiyoshaFutangakuGengakuKetteiKubun(TextBox txtHomonKaigoRiyoshaFutangakuGengakuKetteiKubun) {
        this.getHomonKaigoRiyoshaFutangakuGengakuInfo().setTxtHomonKaigoRiyoshaFutangakuGengakuKetteiKubun(txtHomonKaigoRiyoshaFutangakuGengakuKetteiKubun);
    }

    @JsonIgnore
    public TextBox getTxtHomonKaigoRiyoshaFutangakuGengakuHobetsuKubun() {
        return this.getHomonKaigoRiyoshaFutangakuGengakuInfo().getTxtHomonKaigoRiyoshaFutangakuGengakuHobetsuKubun();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoRiyoshaFutangakuGengakuHobetsuKubun(TextBox txtHomonKaigoRiyoshaFutangakuGengakuHobetsuKubun) {
        this.getHomonKaigoRiyoshaFutangakuGengakuInfo().setTxtHomonKaigoRiyoshaFutangakuGengakuHobetsuKubun(txtHomonKaigoRiyoshaFutangakuGengakuHobetsuKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHomonKaigoRiyoshaFutangakuGengakuShinseibi() {
        return this.getHomonKaigoRiyoshaFutangakuGengakuInfo().getTxtHomonKaigoRiyoshaFutangakuGengakuShinseibi();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoRiyoshaFutangakuGengakuShinseibi(TextBoxFlexibleDate txtHomonKaigoRiyoshaFutangakuGengakuShinseibi) {
        this.getHomonKaigoRiyoshaFutangakuGengakuInfo().setTxtHomonKaigoRiyoshaFutangakuGengakuShinseibi(txtHomonKaigoRiyoshaFutangakuGengakuShinseibi);
    }

    @JsonIgnore
    public TextBox getTxtHomonKaigoRiyoshaFutangakuGengakuKyufuritsu() {
        return this.getHomonKaigoRiyoshaFutangakuGengakuInfo().getTxtHomonKaigoRiyoshaFutangakuGengakuKyufuritsu();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoRiyoshaFutangakuGengakuKyufuritsu(TextBox txtHomonKaigoRiyoshaFutangakuGengakuKyufuritsu) {
        this.getHomonKaigoRiyoshaFutangakuGengakuInfo().setTxtHomonKaigoRiyoshaFutangakuGengakuKyufuritsu(txtHomonKaigoRiyoshaFutangakuGengakuKyufuritsu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHomonKaigoRiyoshaFutangakuGengakuKetteibi() {
        return this.getHomonKaigoRiyoshaFutangakuGengakuInfo().getTxtHomonKaigoRiyoshaFutangakuGengakuKetteibi();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoRiyoshaFutangakuGengakuKetteibi(TextBoxFlexibleDate txtHomonKaigoRiyoshaFutangakuGengakuKetteibi) {
        this.getHomonKaigoRiyoshaFutangakuGengakuInfo().setTxtHomonKaigoRiyoshaFutangakuGengakuKetteibi(txtHomonKaigoRiyoshaFutangakuGengakuKetteibi);
    }

    @JsonIgnore
    public TextBoxCode getTxtHomonKaigoRiyoshaFutangakuGengakuKohiJukyushaNo() {
        return this.getHomonKaigoRiyoshaFutangakuGengakuInfo().getTxtHomonKaigoRiyoshaFutangakuGengakuKohiJukyushaNo();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoRiyoshaFutangakuGengakuKohiJukyushaNo(TextBoxCode txtHomonKaigoRiyoshaFutangakuGengakuKohiJukyushaNo) {
        this.getHomonKaigoRiyoshaFutangakuGengakuInfo().setTxtHomonKaigoRiyoshaFutangakuGengakuKohiJukyushaNo(txtHomonKaigoRiyoshaFutangakuGengakuKohiJukyushaNo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHomonKaigoRiyoshaFutangakuGengakuTekiyobi() {
        return this.getHomonKaigoRiyoshaFutangakuGengakuInfo().getTxtHomonKaigoRiyoshaFutangakuGengakuTekiyobi();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoRiyoshaFutangakuGengakuTekiyobi(TextBoxFlexibleDate txtHomonKaigoRiyoshaFutangakuGengakuTekiyobi) {
        this.getHomonKaigoRiyoshaFutangakuGengakuInfo().setTxtHomonKaigoRiyoshaFutangakuGengakuTekiyobi(txtHomonKaigoRiyoshaFutangakuGengakuTekiyobi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHomonKaigoRiyoshaFutangakuGengakuYukoKigen() {
        return this.getHomonKaigoRiyoshaFutangakuGengakuInfo().getTxtHomonKaigoRiyoshaFutangakuGengakuYukoKigen();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoRiyoshaFutangakuGengakuYukoKigen(TextBoxFlexibleDate txtHomonKaigoRiyoshaFutangakuGengakuYukoKigen) {
        this.getHomonKaigoRiyoshaFutangakuGengakuInfo().setTxtHomonKaigoRiyoshaFutangakuGengakuYukoKigen(txtHomonKaigoRiyoshaFutangakuGengakuYukoKigen);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHomonKaigoRiyoshaFutangakuGengakuShoninShinaiRiyu() {
        return this.getHomonKaigoRiyoshaFutangakuGengakuInfo().getTxtHomonKaigoRiyoshaFutangakuGengakuShoninShinaiRiyu();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoRiyoshaFutangakuGengakuShoninShinaiRiyu(TextBoxMultiLine txtHomonKaigoRiyoshaFutangakuGengakuShoninShinaiRiyu) {
        this.getHomonKaigoRiyoshaFutangakuGengakuInfo().setTxtHomonKaigoRiyoshaFutangakuGengakuShoninShinaiRiyu(txtHomonKaigoRiyoshaFutangakuGengakuShoninShinaiRiyu);
    }

    // </editor-fold>
}
