package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FukaShokaiGrandsonTsuchisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaShokaiGrandsonTsuchishoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo")
    private TextBoxFlexibleYear txtChoteiNendo;
    @JsonProperty("txtFukaNendo")
    private TextBoxFlexibleYear txtFukaNendo;
    @JsonProperty("txtKoseiM")
    private TextBox txtKoseiM;
    @JsonProperty("txtKoseiDateTime")
    private TextBox txtKoseiDateTime;
    @JsonProperty("KobetsuHakkoChoteiJiyu")
    private KobetsuHakkoChoteiJiyuDiv KobetsuHakkoChoteiJiyu;
    @JsonProperty("KobetsuHakkoZengoSentaku")
    private KobetsuHakkoZengoSentakuDiv KobetsuHakkoZengoSentaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChoteiNendo
     * @return txtChoteiNendo
     */
    @JsonProperty("txtChoteiNendo")
    public TextBoxFlexibleYear getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    /*
     * settxtChoteiNendo
     * @param txtChoteiNendo txtChoteiNendo
     */
    @JsonProperty("txtChoteiNendo")
    public void setTxtChoteiNendo(TextBoxFlexibleYear txtChoteiNendo) {
        this.txtChoteiNendo = txtChoteiNendo;
    }

    /*
     * gettxtFukaNendo
     * @return txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public TextBoxFlexibleYear getTxtFukaNendo() {
        return txtFukaNendo;
    }

    /*
     * settxtFukaNendo
     * @param txtFukaNendo txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBoxFlexibleYear txtFukaNendo) {
        this.txtFukaNendo = txtFukaNendo;
    }

    /*
     * gettxtKoseiM
     * @return txtKoseiM
     */
    @JsonProperty("txtKoseiM")
    public TextBox getTxtKoseiM() {
        return txtKoseiM;
    }

    /*
     * settxtKoseiM
     * @param txtKoseiM txtKoseiM
     */
    @JsonProperty("txtKoseiM")
    public void setTxtKoseiM(TextBox txtKoseiM) {
        this.txtKoseiM = txtKoseiM;
    }

    /*
     * gettxtKoseiDateTime
     * @return txtKoseiDateTime
     */
    @JsonProperty("txtKoseiDateTime")
    public TextBox getTxtKoseiDateTime() {
        return txtKoseiDateTime;
    }

    /*
     * settxtKoseiDateTime
     * @param txtKoseiDateTime txtKoseiDateTime
     */
    @JsonProperty("txtKoseiDateTime")
    public void setTxtKoseiDateTime(TextBox txtKoseiDateTime) {
        this.txtKoseiDateTime = txtKoseiDateTime;
    }

    /*
     * getKobetsuHakkoChoteiJiyu
     * @return KobetsuHakkoChoteiJiyu
     */
    @JsonProperty("KobetsuHakkoChoteiJiyu")
    public KobetsuHakkoChoteiJiyuDiv getKobetsuHakkoChoteiJiyu() {
        return KobetsuHakkoChoteiJiyu;
    }

    /*
     * setKobetsuHakkoChoteiJiyu
     * @param KobetsuHakkoChoteiJiyu KobetsuHakkoChoteiJiyu
     */
    @JsonProperty("KobetsuHakkoChoteiJiyu")
    public void setKobetsuHakkoChoteiJiyu(KobetsuHakkoChoteiJiyuDiv KobetsuHakkoChoteiJiyu) {
        this.KobetsuHakkoChoteiJiyu = KobetsuHakkoChoteiJiyu;
    }

    /*
     * getKobetsuHakkoZengoSentaku
     * @return KobetsuHakkoZengoSentaku
     */
    @JsonProperty("KobetsuHakkoZengoSentaku")
    public KobetsuHakkoZengoSentakuDiv getKobetsuHakkoZengoSentaku() {
        return KobetsuHakkoZengoSentaku;
    }

    /*
     * setKobetsuHakkoZengoSentaku
     * @param KobetsuHakkoZengoSentaku KobetsuHakkoZengoSentaku
     */
    @JsonProperty("KobetsuHakkoZengoSentaku")
    public void setKobetsuHakkoZengoSentaku(KobetsuHakkoZengoSentakuDiv KobetsuHakkoZengoSentaku) {
        this.KobetsuHakkoZengoSentaku = KobetsuHakkoZengoSentaku;
    }

    // </editor-fold>
}
