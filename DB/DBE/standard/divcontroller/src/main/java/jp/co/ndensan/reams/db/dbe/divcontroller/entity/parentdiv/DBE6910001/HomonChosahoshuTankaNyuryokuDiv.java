package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001;
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
 * HomonChosahoshuTankaNyuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class HomonChosahoshuTankaNyuryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHomkaishiYM")
    private TextBoxFlexibleYearMonth txtHomkaishiYM;
    @JsonProperty("txtHomshuryoYM")
    private TextBoxFlexibleYearMonth txtHomshuryoYM;
    @JsonProperty("ddlChosaKubun")
    private DropDownList ddlChosaKubun;
    @JsonProperty("ddlHomonShubetsu")
    private DropDownList ddlHomonShubetsu;
    @JsonProperty("txtHomtanka")
    private TextBoxNum txtHomtanka;
    @JsonProperty("btnHomKousin")
    private Button btnHomKousin;
    @JsonProperty("btnHomTorikesu")
    private Button btnHomTorikesu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHomkaishiYM
     * @return txtHomkaishiYM
     */
    @JsonProperty("txtHomkaishiYM")
    public TextBoxFlexibleYearMonth getTxtHomkaishiYM() {
        return txtHomkaishiYM;
    }

    /*
     * settxtHomkaishiYM
     * @param txtHomkaishiYM txtHomkaishiYM
     */
    @JsonProperty("txtHomkaishiYM")
    public void setTxtHomkaishiYM(TextBoxFlexibleYearMonth txtHomkaishiYM) {
        this.txtHomkaishiYM = txtHomkaishiYM;
    }

    /*
     * gettxtHomshuryoYM
     * @return txtHomshuryoYM
     */
    @JsonProperty("txtHomshuryoYM")
    public TextBoxFlexibleYearMonth getTxtHomshuryoYM() {
        return txtHomshuryoYM;
    }

    /*
     * settxtHomshuryoYM
     * @param txtHomshuryoYM txtHomshuryoYM
     */
    @JsonProperty("txtHomshuryoYM")
    public void setTxtHomshuryoYM(TextBoxFlexibleYearMonth txtHomshuryoYM) {
        this.txtHomshuryoYM = txtHomshuryoYM;
    }

    /*
     * getddlChosaKubun
     * @return ddlChosaKubun
     */
    @JsonProperty("ddlChosaKubun")
    public DropDownList getDdlChosaKubun() {
        return ddlChosaKubun;
    }

    /*
     * setddlChosaKubun
     * @param ddlChosaKubun ddlChosaKubun
     */
    @JsonProperty("ddlChosaKubun")
    public void setDdlChosaKubun(DropDownList ddlChosaKubun) {
        this.ddlChosaKubun = ddlChosaKubun;
    }

    /*
     * getddlHomonShubetsu
     * @return ddlHomonShubetsu
     */
    @JsonProperty("ddlHomonShubetsu")
    public DropDownList getDdlHomonShubetsu() {
        return ddlHomonShubetsu;
    }

    /*
     * setddlHomonShubetsu
     * @param ddlHomonShubetsu ddlHomonShubetsu
     */
    @JsonProperty("ddlHomonShubetsu")
    public void setDdlHomonShubetsu(DropDownList ddlHomonShubetsu) {
        this.ddlHomonShubetsu = ddlHomonShubetsu;
    }

    /*
     * gettxtHomtanka
     * @return txtHomtanka
     */
    @JsonProperty("txtHomtanka")
    public TextBoxNum getTxtHomtanka() {
        return txtHomtanka;
    }

    /*
     * settxtHomtanka
     * @param txtHomtanka txtHomtanka
     */
    @JsonProperty("txtHomtanka")
    public void setTxtHomtanka(TextBoxNum txtHomtanka) {
        this.txtHomtanka = txtHomtanka;
    }

    /*
     * getbtnHomKousin
     * @return btnHomKousin
     */
    @JsonProperty("btnHomKousin")
    public Button getBtnHomKousin() {
        return btnHomKousin;
    }

    /*
     * setbtnHomKousin
     * @param btnHomKousin btnHomKousin
     */
    @JsonProperty("btnHomKousin")
    public void setBtnHomKousin(Button btnHomKousin) {
        this.btnHomKousin = btnHomKousin;
    }

    /*
     * getbtnHomTorikesu
     * @return btnHomTorikesu
     */
    @JsonProperty("btnHomTorikesu")
    public Button getBtnHomTorikesu() {
        return btnHomTorikesu;
    }

    /*
     * setbtnHomTorikesu
     * @param btnHomTorikesu btnHomTorikesu
     */
    @JsonProperty("btnHomTorikesu")
    public void setBtnHomTorikesu(Button btnHomTorikesu) {
        this.btnHomTorikesu = btnHomTorikesu;
    }

    // </editor-fold>
}
