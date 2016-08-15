package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiKyakkaTshuchi のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiKyakkaTshuchiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radNinteiKyakkaRireki")
    private RadioButton radNinteiKyakkaRireki;
    @JsonProperty("txtNinteiKyakkaTsuchi")
    private TextBoxFlexibleDate txtNinteiKyakkaTsuchi;
    @JsonProperty("txtKyakkaDay")
    private TextBoxFlexibleDate txtKyakkaDay;
    @JsonProperty("txtIdoJiyu")
    private TextBox txtIdoJiyu;
    @JsonProperty("btnCopyJiyuToRiyu")
    private Button btnCopyJiyuToRiyu;
    @JsonProperty("txtKyakkaRiyu")
    private TextBoxMultiLine txtKyakkaRiyu;
    @JsonProperty("ccdKobetsuNinteiKyakkaBunshoBango")
    private BunshoBangoInputDiv ccdKobetsuNinteiKyakkaBunshoBango;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradNinteiKyakkaRireki
     * @return radNinteiKyakkaRireki
     */
    @JsonProperty("radNinteiKyakkaRireki")
    public RadioButton getRadNinteiKyakkaRireki() {
        return radNinteiKyakkaRireki;
    }

    /*
     * setradNinteiKyakkaRireki
     * @param radNinteiKyakkaRireki radNinteiKyakkaRireki
     */
    @JsonProperty("radNinteiKyakkaRireki")
    public void setRadNinteiKyakkaRireki(RadioButton radNinteiKyakkaRireki) {
        this.radNinteiKyakkaRireki = radNinteiKyakkaRireki;
    }

    /*
     * gettxtNinteiKyakkaTsuchi
     * @return txtNinteiKyakkaTsuchi
     */
    @JsonProperty("txtNinteiKyakkaTsuchi")
    public TextBoxFlexibleDate getTxtNinteiKyakkaTsuchi() {
        return txtNinteiKyakkaTsuchi;
    }

    /*
     * settxtNinteiKyakkaTsuchi
     * @param txtNinteiKyakkaTsuchi txtNinteiKyakkaTsuchi
     */
    @JsonProperty("txtNinteiKyakkaTsuchi")
    public void setTxtNinteiKyakkaTsuchi(TextBoxFlexibleDate txtNinteiKyakkaTsuchi) {
        this.txtNinteiKyakkaTsuchi = txtNinteiKyakkaTsuchi;
    }

    /*
     * gettxtKyakkaDay
     * @return txtKyakkaDay
     */
    @JsonProperty("txtKyakkaDay")
    public TextBoxFlexibleDate getTxtKyakkaDay() {
        return txtKyakkaDay;
    }

    /*
     * settxtKyakkaDay
     * @param txtKyakkaDay txtKyakkaDay
     */
    @JsonProperty("txtKyakkaDay")
    public void setTxtKyakkaDay(TextBoxFlexibleDate txtKyakkaDay) {
        this.txtKyakkaDay = txtKyakkaDay;
    }

    /*
     * gettxtIdoJiyu
     * @return txtIdoJiyu
     */
    @JsonProperty("txtIdoJiyu")
    public TextBox getTxtIdoJiyu() {
        return txtIdoJiyu;
    }

    /*
     * settxtIdoJiyu
     * @param txtIdoJiyu txtIdoJiyu
     */
    @JsonProperty("txtIdoJiyu")
    public void setTxtIdoJiyu(TextBox txtIdoJiyu) {
        this.txtIdoJiyu = txtIdoJiyu;
    }

    /*
     * getbtnCopyJiyuToRiyu
     * @return btnCopyJiyuToRiyu
     */
    @JsonProperty("btnCopyJiyuToRiyu")
    public Button getBtnCopyJiyuToRiyu() {
        return btnCopyJiyuToRiyu;
    }

    /*
     * setbtnCopyJiyuToRiyu
     * @param btnCopyJiyuToRiyu btnCopyJiyuToRiyu
     */
    @JsonProperty("btnCopyJiyuToRiyu")
    public void setBtnCopyJiyuToRiyu(Button btnCopyJiyuToRiyu) {
        this.btnCopyJiyuToRiyu = btnCopyJiyuToRiyu;
    }

    /*
     * gettxtKyakkaRiyu
     * @return txtKyakkaRiyu
     */
    @JsonProperty("txtKyakkaRiyu")
    public TextBoxMultiLine getTxtKyakkaRiyu() {
        return txtKyakkaRiyu;
    }

    /*
     * settxtKyakkaRiyu
     * @param txtKyakkaRiyu txtKyakkaRiyu
     */
    @JsonProperty("txtKyakkaRiyu")
    public void setTxtKyakkaRiyu(TextBoxMultiLine txtKyakkaRiyu) {
        this.txtKyakkaRiyu = txtKyakkaRiyu;
    }

    /*
     * getccdKobetsuNinteiKyakkaBunshoBango
     * @return ccdKobetsuNinteiKyakkaBunshoBango
     */
    @JsonProperty("ccdKobetsuNinteiKyakkaBunshoBango")
    public IBunshoBangoInputDiv getCcdKobetsuNinteiKyakkaBunshoBango() {
        return ccdKobetsuNinteiKyakkaBunshoBango;
    }

    // </editor-fold>
}
