package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishuIdentifier;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * ShoKaishuKirokuKanri のクラスファイル
 *
 * @reamsid_L DBA-1070-010 lizhuoxuan
 */
public class ShoKaishuKirokuKanriDiv extends Panel implements IShoKaishuKirokuKanriDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelKoufuList")
    private panelKoufuListDiv panelKoufuList;
    @JsonProperty("panelInput")
    private panelInputDiv panelInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelKoufuList
     * @return panelKoufuList
     */
    @JsonProperty("panelKoufuList")
    public panelKoufuListDiv getPanelKoufuList() {
        return panelKoufuList;
    }

    /*
     * setpanelKoufuList
     * @param panelKoufuList panelKoufuList
     */
    @JsonProperty("panelKoufuList")
    public void setPanelKoufuList(panelKoufuListDiv panelKoufuList) {
        this.panelKoufuList = panelKoufuList;
    }

    /*
     * getpanelInput
     * @return panelInput
     */
    @JsonProperty("panelInput")
    public panelInputDiv getPanelInput() {
        return panelInput;
    }

    /*
     * setpanelInput
     * @param panelInput panelInput
     */
    @JsonProperty("panelInput")
    public void setPanelInput(panelInputDiv panelInput) {
        this.panelInput = panelInput;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DisplayMode implements ICommonChildDivMode {

        shokai("shokai"),
        shokai_selected("shokai_selected"),
        koshin("koshin"),
        sakujyo("sakujyo");

        private final String name;

        private DisplayMode(final String name) {
            this.name = name;
        }

        public static DisplayMode getEnum(String str) {
            DisplayMode[] enumArray = DisplayMode.values();

            for (DisplayMode enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) {
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public DisplayMode getMode_DisplayMode() {
        return (DisplayMode) _CommonChildDivModeUtil.getMode(this.modes, DisplayMode.class);
    }

    public void setMode_DisplayMode(DisplayMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, DisplayMode.class, value);
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgKoufuKaishu_Row> getDgKoufuKaishu() {
        return this.getPanelKoufuList().getDgKoufuKaishu();
    }

    @JsonIgnore
    public void setDgKoufuKaishu(DataGrid<dgKoufuKaishu_Row> dgKoufuKaishu) {
        this.getPanelKoufuList().setDgKoufuKaishu(dgKoufuKaishu);
    }

    @JsonIgnore
    public TextBox getTxtKoufuType() {
        return this.getPanelInput().getTxtKoufuType();
    }

    @JsonIgnore
    public void setTxtKoufuType(TextBox txtKoufuType) {
        this.getPanelInput().setTxtKoufuType(txtKoufuType);
    }

    @JsonIgnore
    public TextBoxDate getTxtKoufuDate() {
        return this.getPanelInput().getTxtKoufuDate();
    }

    @JsonIgnore
    public void setTxtKoufuDate(TextBoxDate txtKoufuDate) {
        this.getPanelInput().setTxtKoufuDate(txtKoufuDate);
    }

    @JsonIgnore
    public TextBoxDate getTxtYukouKigen() {
        return this.getPanelInput().getTxtYukouKigen();
    }

    @JsonIgnore
    public void setTxtYukouKigen(TextBoxDate txtYukouKigen) {
        this.getPanelInput().setTxtYukouKigen(txtYukouKigen);
    }

    @JsonIgnore
    public DropDownList getDdlKoufuJiyu() {
        return this.getPanelInput().getDdlKoufuJiyu();
    }

    @JsonIgnore
    public void setDdlKoufuJiyu(DropDownList ddlKoufuJiyu) {
        this.getPanelInput().setDdlKoufuJiyu(ddlKoufuJiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxaKoufuRiyu() {
        return this.getPanelInput().getTxaKoufuRiyu();
    }

    @JsonIgnore
    public void setTxaKoufuRiyu(TextBoxMultiLine txaKoufuRiyu) {
        this.getPanelInput().setTxaKoufuRiyu(txaKoufuRiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaisyuDate() {
        return this.getPanelInput().getTxtKaisyuDate();
    }

    @JsonIgnore
    public void setTxtKaisyuDate(TextBoxDate txtKaisyuDate) {
        this.getPanelInput().setTxtKaisyuDate(txtKaisyuDate);
    }

    @JsonIgnore
    public DropDownList getDdlKaisyuJiyu() {
        return this.getPanelInput().getDdlKaisyuJiyu();
    }

    @JsonIgnore
    public void setDdlKaisyuJiyu(DropDownList ddlKaisyuJiyu) {
        this.getPanelInput().setDdlKaisyuJiyu(ddlKaisyuJiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxaKaishuRiyu() {
        return this.getPanelInput().getTxaKaishuRiyu();
    }

    @JsonIgnore
    public void setTxaKaishuRiyu(TextBoxMultiLine txaKaishuRiyu) {
        this.getPanelInput().setTxaKaishuRiyu(txaKaishuRiyu);
    }

    @JsonIgnore
    public Button getBtnConfirm() {
        return this.getPanelInput().getBtnConfirm();
    }

    @JsonIgnore
    public void setBtnConfirm(Button btnConfirm) {
        this.getPanelInput().setBtnConfirm(btnConfirm);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getPanelInput().getBtnCancel();
    }

    @JsonIgnore
    public void setBtnCancel(Button btnCancel) {
        this.getPanelInput().setBtnCancel(btnCancel);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(RString 状態, HihokenshaNo 被保険者番号) {
        new ShoKaishuKirokuKanriHandler(this).initialize(状態, 被保険者番号);
    }

    @Override
    public void initialize(RString 状態, HihokenshaNo 被保険者番号,
            ArrayList<dgKoufuKaishu_Row> dataSource, Models<ShoKofuKaishuIdentifier, ShoKofuKaishu> 証交付回収情報Model) {
        new ShoKaishuKirokuKanriHandler(this).initialize(状態, 被保険者番号, dataSource, 証交付回収情報Model);
    }

    /**
     * 適用情報一覧を取得します。
     *
     * @return 適用情報一覧 適用情報一覧
     */
    @Override
    public List<dgKoufuKaishu_Row> get証交付回収情報一覧() {
        return new ShoKaishuKirokuKanriHandler(this).get証交付回収情報一覧();
    }

    /**
     * 適用情報一覧を取得します。
     *
     */
    @Override
    public void saveShoKaishuKirokuKanri() {
        new ShoKaishuKirokuKanriHandler(this).saveShoKaishuKirokuKanri();
    }

    @Override
    public Models<ShoKofuKaishuIdentifier, ShoKofuKaishu> getSaveData() {
        return new ShoKaishuKirokuKanriHandler(this).getSaveData();
    }
}
