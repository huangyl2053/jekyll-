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
 * ChosainhoshuTankaNyuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosainhoshuTankaNyuryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoKaishiYM")
    private TextBoxFlexibleYearMonth txtChoKaishiYM;
    @JsonProperty("txtChoShuryoYM")
    private TextBoxFlexibleYearMonth txtChoShuryoYM;
    @JsonProperty("ddlKaigoNinteiShinsaIinShubetsu")
    private DropDownList ddlKaigoNinteiShinsaIinShubetsu;
    @JsonProperty("txtChoTanka")
    private TextBoxNum txtChoTanka;
    @JsonProperty("btnChoKousin")
    private Button btnChoKousin;
    @JsonProperty("btnChoTorikesu")
    private Button btnChoTorikesu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChoKaishiYM
     * @return txtChoKaishiYM
     */
    @JsonProperty("txtChoKaishiYM")
    public TextBoxFlexibleYearMonth getTxtChoKaishiYM() {
        return txtChoKaishiYM;
    }

    /*
     * settxtChoKaishiYM
     * @param txtChoKaishiYM txtChoKaishiYM
     */
    @JsonProperty("txtChoKaishiYM")
    public void setTxtChoKaishiYM(TextBoxFlexibleYearMonth txtChoKaishiYM) {
        this.txtChoKaishiYM = txtChoKaishiYM;
    }

    /*
     * gettxtChoShuryoYM
     * @return txtChoShuryoYM
     */
    @JsonProperty("txtChoShuryoYM")
    public TextBoxFlexibleYearMonth getTxtChoShuryoYM() {
        return txtChoShuryoYM;
    }

    /*
     * settxtChoShuryoYM
     * @param txtChoShuryoYM txtChoShuryoYM
     */
    @JsonProperty("txtChoShuryoYM")
    public void setTxtChoShuryoYM(TextBoxFlexibleYearMonth txtChoShuryoYM) {
        this.txtChoShuryoYM = txtChoShuryoYM;
    }

    /*
     * getddlKaigoNinteiShinsaIinShubetsu
     * @return ddlKaigoNinteiShinsaIinShubetsu
     */
    @JsonProperty("ddlKaigoNinteiShinsaIinShubetsu")
    public DropDownList getDdlKaigoNinteiShinsaIinShubetsu() {
        return ddlKaigoNinteiShinsaIinShubetsu;
    }

    /*
     * setddlKaigoNinteiShinsaIinShubetsu
     * @param ddlKaigoNinteiShinsaIinShubetsu ddlKaigoNinteiShinsaIinShubetsu
     */
    @JsonProperty("ddlKaigoNinteiShinsaIinShubetsu")
    public void setDdlKaigoNinteiShinsaIinShubetsu(DropDownList ddlKaigoNinteiShinsaIinShubetsu) {
        this.ddlKaigoNinteiShinsaIinShubetsu = ddlKaigoNinteiShinsaIinShubetsu;
    }

    /*
     * gettxtChoTanka
     * @return txtChoTanka
     */
    @JsonProperty("txtChoTanka")
    public TextBoxNum getTxtChoTanka() {
        return txtChoTanka;
    }

    /*
     * settxtChoTanka
     * @param txtChoTanka txtChoTanka
     */
    @JsonProperty("txtChoTanka")
    public void setTxtChoTanka(TextBoxNum txtChoTanka) {
        this.txtChoTanka = txtChoTanka;
    }

    /*
     * getbtnChoKousin
     * @return btnChoKousin
     */
    @JsonProperty("btnChoKousin")
    public Button getBtnChoKousin() {
        return btnChoKousin;
    }

    /*
     * setbtnChoKousin
     * @param btnChoKousin btnChoKousin
     */
    @JsonProperty("btnChoKousin")
    public void setBtnChoKousin(Button btnChoKousin) {
        this.btnChoKousin = btnChoKousin;
    }

    /*
     * getbtnChoTorikesu
     * @return btnChoTorikesu
     */
    @JsonProperty("btnChoTorikesu")
    public Button getBtnChoTorikesu() {
        return btnChoTorikesu;
    }

    /*
     * setbtnChoTorikesu
     * @param btnChoTorikesu btnChoTorikesu
     */
    @JsonProperty("btnChoTorikesu")
    public void setBtnChoTorikesu(Button btnChoTorikesu) {
        this.btnChoTorikesu = btnChoTorikesu;
    }

    // </editor-fold>
}
