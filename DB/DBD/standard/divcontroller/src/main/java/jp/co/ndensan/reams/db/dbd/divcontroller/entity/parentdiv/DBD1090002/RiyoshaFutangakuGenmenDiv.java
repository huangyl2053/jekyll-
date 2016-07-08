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
 * RiyoshaFutangakuGenmen のクラスファイル 
 * 
 * @author 自動生成
 */
public class RiyoshaFutangakuGenmenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RiyoshaFutanGenmenInfo")
    private RiyoshaFutanGenmenInfoDiv RiyoshaFutanGenmenInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getRiyoshaFutanGenmenInfo
     * @return RiyoshaFutanGenmenInfo
     */
    @JsonProperty("RiyoshaFutanGenmenInfo")
    public RiyoshaFutanGenmenInfoDiv getRiyoshaFutanGenmenInfo() {
        return RiyoshaFutanGenmenInfo;
    }

    /*
     * setRiyoshaFutanGenmenInfo
     * @param RiyoshaFutanGenmenInfo RiyoshaFutanGenmenInfo
     */
    @JsonProperty("RiyoshaFutanGenmenInfo")
    public void setRiyoshaFutanGenmenInfo(RiyoshaFutanGenmenInfoDiv RiyoshaFutanGenmenInfo) {
        this.RiyoshaFutanGenmenInfo = RiyoshaFutanGenmenInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtRiyoshaFutanGendogakuKetteiKubun() {
        return this.getRiyoshaFutanGenmenInfo().getTxtRiyoshaFutanGendogakuKetteiKubun();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanGendogakuKetteiKubun(TextBox txtRiyoshaFutanGendogakuKetteiKubun) {
        this.getRiyoshaFutanGenmenInfo().setTxtRiyoshaFutanGendogakuKetteiKubun(txtRiyoshaFutanGendogakuKetteiKubun);
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaFutanGendogakuKyufuRitsu() {
        return this.getRiyoshaFutanGenmenInfo().getTxtRiyoshaFutanGendogakuKyufuRitsu();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanGendogakuKyufuRitsu(TextBox txtRiyoshaFutanGendogakuKyufuRitsu) {
        this.getRiyoshaFutanGenmenInfo().setTxtRiyoshaFutanGendogakuKyufuRitsu(txtRiyoshaFutanGendogakuKyufuRitsu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtRiyoshaFutanGendogakuShinseibi() {
        return this.getRiyoshaFutanGenmenInfo().getTxtRiyoshaFutanGendogakuShinseibi();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanGendogakuShinseibi(TextBoxFlexibleDate txtRiyoshaFutanGendogakuShinseibi) {
        this.getRiyoshaFutanGenmenInfo().setTxtRiyoshaFutanGendogakuShinseibi(txtRiyoshaFutanGendogakuShinseibi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtRiyoshaFutanGendogakuKetteibi() {
        return this.getRiyoshaFutanGenmenInfo().getTxtRiyoshaFutanGendogakuKetteibi();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanGendogakuKetteibi(TextBoxFlexibleDate txtRiyoshaFutanGendogakuKetteibi) {
        this.getRiyoshaFutanGenmenInfo().setTxtRiyoshaFutanGendogakuKetteibi(txtRiyoshaFutanGendogakuKetteibi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtRiyoshaFutanGendogakuTekiyobi() {
        return this.getRiyoshaFutanGenmenInfo().getTxtRiyoshaFutanGendogakuTekiyobi();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanGendogakuTekiyobi(TextBoxFlexibleDate txtRiyoshaFutanGendogakuTekiyobi) {
        this.getRiyoshaFutanGenmenInfo().setTxtRiyoshaFutanGendogakuTekiyobi(txtRiyoshaFutanGendogakuTekiyobi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtRiyoshaFutanGendogakuYukoKigen() {
        return this.getRiyoshaFutanGenmenInfo().getTxtRiyoshaFutanGendogakuYukoKigen();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanGendogakuYukoKigen(TextBoxFlexibleDate txtRiyoshaFutanGendogakuYukoKigen) {
        this.getRiyoshaFutanGenmenInfo().setTxtRiyoshaFutanGendogakuYukoKigen(txtRiyoshaFutanGendogakuYukoKigen);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtRiyoshaFutanGendogakuShoninShinaiRiyu() {
        return this.getRiyoshaFutanGenmenInfo().getTxtRiyoshaFutanGendogakuShoninShinaiRiyu();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanGendogakuShoninShinaiRiyu(TextBoxMultiLine txtRiyoshaFutanGendogakuShoninShinaiRiyu) {
        this.getRiyoshaFutanGenmenInfo().setTxtRiyoshaFutanGendogakuShoninShinaiRiyu(txtRiyoshaFutanGendogakuShoninShinaiRiyu);
    }

    // </editor-fold>
}
