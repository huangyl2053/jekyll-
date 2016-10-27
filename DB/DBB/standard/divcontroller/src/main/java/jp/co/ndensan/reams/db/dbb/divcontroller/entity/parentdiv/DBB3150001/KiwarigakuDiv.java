package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * Kiwarigaku のクラスファイル
 *
 * @reamsid_L DBB-1680-010 gongliang
 */
public class KiwarigakuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("FuchoTablePanel")
    private FuchoTablePanelDiv FuchoTablePanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getFuchoTablePanel
     * @return FuchoTablePanel
     */
    @JsonProperty("FuchoTablePanel")
    public FuchoTablePanelDiv getFuchoTablePanel() {
        return FuchoTablePanel;
    }

    /*
     * setFuchoTablePanel
     * @param FuchoTablePanel FuchoTablePanel
     */
    @JsonProperty("FuchoTablePanel")
    public void setFuchoTablePanel(FuchoTablePanelDiv FuchoTablePanel) {
        this.FuchoTablePanel = FuchoTablePanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblFucho() {
        return this.getFuchoTablePanel().getLblFucho();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki() {
        return this.getFuchoTablePanel().getLblFuchoTsuki();
    }

    @JsonIgnore
    public Label getLblFuchoKi() {
        return this.getFuchoTablePanel().getLblFuchoKi();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku() {
        return this.getFuchoTablePanel().getLblFuchoNofuGaku();
    }

    @JsonIgnore
    public Label getLblYuyoKikanKaishi() {
        return this.getFuchoTablePanel().getLblYuyoKikanKaishi();
    }

    @JsonIgnore
    public Label getLblYuyoKikanShuryo() {
        return this.getFuchoTablePanel().getLblYuyoKikanShuryo();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki4Gatsu() {
        return this.getFuchoTablePanel().getLblFuchoTsuki4Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi13() {
        return this.getFuchoTablePanel().getLblFuchoKi13();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku13() {
        return this.getFuchoTablePanel().getLblFuchoNofuGaku13();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanKaishi4() {
        return this.getFuchoTablePanel().getTxtYuyoKikanKaishi4();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanShuryo4() {
        return this.getFuchoTablePanel().getTxtYuyoKikanShuryo4();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki5Gatsu() {
        return this.getFuchoTablePanel().getLblFuchoTsuki5Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi14() {
        return this.getFuchoTablePanel().getLblFuchoKi14();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku14() {
        return this.getFuchoTablePanel().getLblFuchoNofuGaku14();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanKaishi5() {
        return this.getFuchoTablePanel().getTxtYuyoKikanKaishi5();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanShuryo5() {
        return this.getFuchoTablePanel().getTxtYuyoKikanShuryo5();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki6Gatsu() {
        return this.getFuchoTablePanel().getLblFuchoTsuki6Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi1() {
        return this.getFuchoTablePanel().getLblFuchoKi1();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku1() {
        return this.getFuchoTablePanel().getLblFuchoNofuGaku1();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanKaishi6() {
        return this.getFuchoTablePanel().getTxtYuyoKikanKaishi6();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanShuryo6() {
        return this.getFuchoTablePanel().getTxtYuyoKikanShuryo6();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki7Gatsu() {
        return this.getFuchoTablePanel().getLblFuchoTsuki7Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi2() {
        return this.getFuchoTablePanel().getLblFuchoKi2();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku2() {
        return this.getFuchoTablePanel().getLblFuchoNofuGaku2();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanKaishi7() {
        return this.getFuchoTablePanel().getTxtYuyoKikanKaishi7();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanShuryo7() {
        return this.getFuchoTablePanel().getTxtYuyoKikanShuryo7();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki8Gatsu() {
        return this.getFuchoTablePanel().getLblFuchoTsuki8Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi3() {
        return this.getFuchoTablePanel().getLblFuchoKi3();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku3() {
        return this.getFuchoTablePanel().getLblFuchoNofuGaku3();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanKaishi8() {
        return this.getFuchoTablePanel().getTxtYuyoKikanKaishi8();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanShuryo8() {
        return this.getFuchoTablePanel().getTxtYuyoKikanShuryo8();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki9Gatsu() {
        return this.getFuchoTablePanel().getLblFuchoTsuki9Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi4() {
        return this.getFuchoTablePanel().getLblFuchoKi4();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku4() {
        return this.getFuchoTablePanel().getLblFuchoNofuGaku4();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanKaishi9() {
        return this.getFuchoTablePanel().getTxtYuyoKikanKaishi9();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanShuryo9() {
        return this.getFuchoTablePanel().getTxtYuyoKikanShuryo9();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki10Gatsu() {
        return this.getFuchoTablePanel().getLblFuchoTsuki10Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi5() {
        return this.getFuchoTablePanel().getLblFuchoKi5();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku5() {
        return this.getFuchoTablePanel().getLblFuchoNofuGaku5();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanKaishi10() {
        return this.getFuchoTablePanel().getTxtYuyoKikanKaishi10();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanShuryo10() {
        return this.getFuchoTablePanel().getTxtYuyoKikanShuryo10();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki11Gatsu() {
        return this.getFuchoTablePanel().getLblFuchoTsuki11Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi6() {
        return this.getFuchoTablePanel().getLblFuchoKi6();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku6() {
        return this.getFuchoTablePanel().getLblFuchoNofuGaku6();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanKaishi11() {
        return this.getFuchoTablePanel().getTxtYuyoKikanKaishi11();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanShuryo11() {
        return this.getFuchoTablePanel().getTxtYuyoKikanShuryo11();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki12Gatsu() {
        return this.getFuchoTablePanel().getLblFuchoTsuki12Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi7() {
        return this.getFuchoTablePanel().getLblFuchoKi7();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku7() {
        return this.getFuchoTablePanel().getLblFuchoNofuGaku7();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanKaishi12() {
        return this.getFuchoTablePanel().getTxtYuyoKikanKaishi12();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanShuryo12() {
        return this.getFuchoTablePanel().getTxtYuyoKikanShuryo12();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki1Gatsu() {
        return this.getFuchoTablePanel().getLblFuchoTsuki1Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi8() {
        return this.getFuchoTablePanel().getLblFuchoKi8();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku8() {
        return this.getFuchoTablePanel().getLblFuchoNofuGaku8();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanKaishi1() {
        return this.getFuchoTablePanel().getTxtYuyoKikanKaishi1();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanShuryo1() {
        return this.getFuchoTablePanel().getTxtYuyoKikanShuryo1();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki2Gatsu() {
        return this.getFuchoTablePanel().getLblFuchoTsuki2Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi9() {
        return this.getFuchoTablePanel().getLblFuchoKi9();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku9() {
        return this.getFuchoTablePanel().getLblFuchoNofuGaku9();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanKaishi2() {
        return this.getFuchoTablePanel().getTxtYuyoKikanKaishi2();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanShuryo2() {
        return this.getFuchoTablePanel().getTxtYuyoKikanShuryo2();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki3Gatsu() {
        return this.getFuchoTablePanel().getLblFuchoTsuki3Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi10() {
        return this.getFuchoTablePanel().getLblFuchoKi10();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku10() {
        return this.getFuchoTablePanel().getLblFuchoNofuGaku10();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanKaishi3() {
        return this.getFuchoTablePanel().getTxtYuyoKikanKaishi3();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanShuryo3() {
        return this.getFuchoTablePanel().getTxtYuyoKikanShuryo3();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki4Gatsu2() {
        return this.getFuchoTablePanel().getLblFuchoTsuki4Gatsu2();
    }

    @JsonIgnore
    public Label getLblFuchoKi11() {
        return this.getFuchoTablePanel().getLblFuchoKi11();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku11() {
        return this.getFuchoTablePanel().getLblFuchoNofuGaku11();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanKaishi13() {
        return this.getFuchoTablePanel().getTxtYuyoKikanKaishi13();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanShuryo13() {
        return this.getFuchoTablePanel().getTxtYuyoKikanShuryo13();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki5Gatsu2() {
        return this.getFuchoTablePanel().getLblFuchoTsuki5Gatsu2();
    }

    @JsonIgnore
    public Label getLblFuchoKi12() {
        return this.getFuchoTablePanel().getLblFuchoKi12();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku12() {
        return this.getFuchoTablePanel().getLblFuchoNofuGaku12();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanKaishi14() {
        return this.getFuchoTablePanel().getTxtYuyoKikanKaishi14();
    }

    @JsonIgnore
    public TextBoxDate getTxtYuyoKikanShuryo14() {
        return this.getFuchoTablePanel().getTxtYuyoKikanShuryo14();
    }

    @JsonIgnore
    public Label getLblFuchoTsukiTotal() {
        return this.getFuchoTablePanel().getLblFuchoTsukiTotal();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGakuTotal() {
        return this.getFuchoTablePanel().getLblFuchoNofuGakuTotal();
    }

    // </editor-fold>
}
