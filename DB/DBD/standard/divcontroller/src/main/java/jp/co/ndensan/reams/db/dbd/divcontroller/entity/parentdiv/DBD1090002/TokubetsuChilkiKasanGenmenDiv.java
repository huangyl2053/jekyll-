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
 * TokubetsuChilkiKasanGenmen のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuChilkiKasanGenmenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TokubetsuChilkiKasanGenmenInfo")
    private TokubetsuChilkiKasanGenmenInfoDiv TokubetsuChilkiKasanGenmenInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTokubetsuChilkiKasanGenmenInfo
     * @return TokubetsuChilkiKasanGenmenInfo
     */
    @JsonProperty("TokubetsuChilkiKasanGenmenInfo")
    public TokubetsuChilkiKasanGenmenInfoDiv getTokubetsuChilkiKasanGenmenInfo() {
        return TokubetsuChilkiKasanGenmenInfo;
    }

    /*
     * setTokubetsuChilkiKasanGenmenInfo
     * @param TokubetsuChilkiKasanGenmenInfo TokubetsuChilkiKasanGenmenInfo
     */
    @JsonProperty("TokubetsuChilkiKasanGenmenInfo")
    public void setTokubetsuChilkiKasanGenmenInfo(TokubetsuChilkiKasanGenmenInfoDiv TokubetsuChilkiKasanGenmenInfo) {
        this.TokubetsuChilkiKasanGenmenInfo = TokubetsuChilkiKasanGenmenInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtTokubetsuChilkiKasanGenmenKetteiKubun() {
        return this.getTokubetsuChilkiKasanGenmenInfo().getTxtTokubetsuChilkiKasanGenmenKetteiKubun();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChilkiKasanGenmenKetteiKubun(TextBox txtTokubetsuChilkiKasanGenmenKetteiKubun) {
        this.getTokubetsuChilkiKasanGenmenInfo().setTxtTokubetsuChilkiKasanGenmenKetteiKubun(txtTokubetsuChilkiKasanGenmenKetteiKubun);
    }

    @JsonIgnore
    public TextBox getTxtTokubetsuChilkiKasanGenmenKeigenritsu() {
        return this.getTokubetsuChilkiKasanGenmenInfo().getTxtTokubetsuChilkiKasanGenmenKeigenritsu();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChilkiKasanGenmenKeigenritsu(TextBox txtTokubetsuChilkiKasanGenmenKeigenritsu) {
        this.getTokubetsuChilkiKasanGenmenInfo().setTxtTokubetsuChilkiKasanGenmenKeigenritsu(txtTokubetsuChilkiKasanGenmenKeigenritsu);
    }

    @JsonIgnore
    public TextBoxCode getTxtTokubetsuChilkiKasanGenmenKakuninNo() {
        return this.getTokubetsuChilkiKasanGenmenInfo().getTxtTokubetsuChilkiKasanGenmenKakuninNo();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChilkiKasanGenmenKakuninNo(TextBoxCode txtTokubetsuChilkiKasanGenmenKakuninNo) {
        this.getTokubetsuChilkiKasanGenmenInfo().setTxtTokubetsuChilkiKasanGenmenKakuninNo(txtTokubetsuChilkiKasanGenmenKakuninNo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTokubetsuChilkiKasanGenmenShinseibi() {
        return this.getTokubetsuChilkiKasanGenmenInfo().getTxtTokubetsuChilkiKasanGenmenShinseibi();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChilkiKasanGenmenShinseibi(TextBoxFlexibleDate txtTokubetsuChilkiKasanGenmenShinseibi) {
        this.getTokubetsuChilkiKasanGenmenInfo().setTxtTokubetsuChilkiKasanGenmenShinseibi(txtTokubetsuChilkiKasanGenmenShinseibi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTokubetsuChilkiKasanGenmenKetteibi() {
        return this.getTokubetsuChilkiKasanGenmenInfo().getTxtTokubetsuChilkiKasanGenmenKetteibi();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChilkiKasanGenmenKetteibi(TextBoxFlexibleDate txtTokubetsuChilkiKasanGenmenKetteibi) {
        this.getTokubetsuChilkiKasanGenmenInfo().setTxtTokubetsuChilkiKasanGenmenKetteibi(txtTokubetsuChilkiKasanGenmenKetteibi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTokubetsuChilkiKasanGenmenTekiyobi() {
        return this.getTokubetsuChilkiKasanGenmenInfo().getTxtTokubetsuChilkiKasanGenmenTekiyobi();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChilkiKasanGenmenTekiyobi(TextBoxFlexibleDate txtTokubetsuChilkiKasanGenmenTekiyobi) {
        this.getTokubetsuChilkiKasanGenmenInfo().setTxtTokubetsuChilkiKasanGenmenTekiyobi(txtTokubetsuChilkiKasanGenmenTekiyobi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTokubetsuChilkiKasanGenmenYukoKigen() {
        return this.getTokubetsuChilkiKasanGenmenInfo().getTxtTokubetsuChilkiKasanGenmenYukoKigen();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChilkiKasanGenmenYukoKigen(TextBoxFlexibleDate txtTokubetsuChilkiKasanGenmenYukoKigen) {
        this.getTokubetsuChilkiKasanGenmenInfo().setTxtTokubetsuChilkiKasanGenmenYukoKigen(txtTokubetsuChilkiKasanGenmenYukoKigen);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTokubetsuChilkiKasanGenmenShoninShinaiRiyu() {
        return this.getTokubetsuChilkiKasanGenmenInfo().getTxtTokubetsuChilkiKasanGenmenShoninShinaiRiyu();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChilkiKasanGenmenShoninShinaiRiyu(TextBoxMultiLine txtTokubetsuChilkiKasanGenmenShoninShinaiRiyu) {
        this.getTokubetsuChilkiKasanGenmenInfo().setTxtTokubetsuChilkiKasanGenmenShoninShinaiRiyu(txtTokubetsuChilkiKasanGenmenShoninShinaiRiyu);
    }

    // </editor-fold>
}
