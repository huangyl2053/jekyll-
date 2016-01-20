package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshashikakuhakko.HihokenshaShikakuHakko;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * HihokenshaShikakuHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaShikakuHakkoDiv extends Panel implements IHihokenshaShikakuHakkoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("YukoKigenInfo")
    private YukoKigenInfoDiv YukoKigenInfo;
    @JsonProperty("NinteiInfo")
    private NinteiInfoDiv NinteiInfo;
    @JsonProperty("tabHihokenshaShikakuShosai")
    private tabHihokenshaShikakuShosaiDiv tabHihokenshaShikakuShosai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getYukoKigenInfo
     * @return YukoKigenInfo
     */
    @JsonProperty("YukoKigenInfo")
    public YukoKigenInfoDiv getYukoKigenInfo() {
        return YukoKigenInfo;
    }

    /*
     * setYukoKigenInfo
     * @param YukoKigenInfo YukoKigenInfo
     */
    @JsonProperty("YukoKigenInfo")
    public void setYukoKigenInfo(YukoKigenInfoDiv YukoKigenInfo) {
        this.YukoKigenInfo = YukoKigenInfo;
    }

    /*
     * getNinteiInfo
     * @return NinteiInfo
     */
    @JsonProperty("NinteiInfo")
    public NinteiInfoDiv getNinteiInfo() {
        return NinteiInfo;
    }

    /*
     * setNinteiInfo
     * @param NinteiInfo NinteiInfo
     */
    @JsonProperty("NinteiInfo")
    public void setNinteiInfo(NinteiInfoDiv NinteiInfo) {
        this.NinteiInfo = NinteiInfo;
    }

    /*
     * gettabHihokenshaShikakuShosai
     * @return tabHihokenshaShikakuShosai
     */
    @JsonProperty("tabHihokenshaShikakuShosai")
    public tabHihokenshaShikakuShosaiDiv getTabHihokenshaShikakuShosai() {
        return tabHihokenshaShikakuShosai;
    }

    /*
     * settabHihokenshaShikakuShosai
     * @param tabHihokenshaShikakuShosai tabHihokenshaShikakuShosai
     */
    @JsonProperty("tabHihokenshaShikakuShosai")
    public void setTabHihokenshaShikakuShosai(tabHihokenshaShikakuShosaiDiv tabHihokenshaShikakuShosai) {
        this.tabHihokenshaShikakuShosai = tabHihokenshaShikakuShosai;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum 発行証タイプ implements ICommonChildDivMode {

        被保険者証("被保険者証"),
        資格者証("資格者証");

        private final String name;

        private 発行証タイプ(final String name) {
            this.name = name;
        }

        public static 発行証タイプ getEnum(String str) {
            発行証タイプ[] enumArray = 発行証タイプ.values();

            for (発行証タイプ enumStr : enumArray) {
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

    public 発行証タイプ getMode_発行証タイプ() {
        return (発行証タイプ) _CommonChildDivModeUtil.getMode( this.modes, 発行証タイプ.class );
    }

    public void setMode_発行証タイプ( 発行証タイプ value ) {
        _CommonChildDivModeUtil.setMode( this.modes, 発行証タイプ.class , value );
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtYukoKigen() {
        return this.getYukoKigenInfo().getTxtYukoKigen();
    }

    @JsonIgnore
    public void  setTxtYukoKigen(TextBoxDate txtYukoKigen) {
        this.getYukoKigenInfo().setTxtYukoKigen(txtYukoKigen);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKofuDate() {
        return this.getYukoKigenInfo().getTxtKofuDate();
    }

    @JsonIgnore
    public void  setTxtKofuDate(TextBoxFlexibleDate txtKofuDate) {
        this.getYukoKigenInfo().setTxtKofuDate(txtKofuDate);
    }

    @JsonIgnore
    public TextBox getTxtHokensha() {
        return this.getYukoKigenInfo().getTxtHokensha();
    }

    @JsonIgnore
    public void  setTxtHokensha(TextBox txtHokensha) {
        this.getYukoKigenInfo().setTxtHokensha(txtHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlKofuJiyu() {
        return this.getYukoKigenInfo().getDdlKofuJiyu();
    }

    @JsonIgnore
    public void  setDdlKofuJiyu(DropDownList ddlKofuJiyu) {
        this.getYukoKigenInfo().setDdlKofuJiyu(ddlKofuJiyu);
    }

    @JsonIgnore
    public TextBox getTxtYokaigodo() {
        return this.getNinteiInfo().getTxtYokaigodo();
    }

    @JsonIgnore
    public void  setTxtYokaigodo(TextBox txtYokaigodo) {
        this.getNinteiInfo().setTxtYokaigodo(txtYokaigodo);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiYMD() {
        return this.getNinteiInfo().getTxtNinteiYMD();
    }

    @JsonIgnore
    public void  setTxtNinteiYMD(TextBoxDate txtNinteiYMD) {
        this.getNinteiInfo().setTxtNinteiYMD(txtNinteiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiYukoFromYMD() {
        return this.getNinteiInfo().getTxtNinteiYukoFromYMD();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoFromYMD(TextBoxDate txtNinteiYukoFromYMD) {
        this.getNinteiInfo().setTxtNinteiYukoFromYMD(txtNinteiYukoFromYMD);
    }

    @JsonIgnore
    public Label getLblKara1() {
        return this.getNinteiInfo().getLblKara1();
    }

    @JsonIgnore
    public void  setLblKara1(Label lblKara1) {
        this.getNinteiInfo().setLblKara1(lblKara1);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiYukoToYMD() {
        return this.getNinteiInfo().getTxtNinteiYukoToYMD();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoToYMD(TextBoxDate txtNinteiYukoToYMD) {
        this.getNinteiInfo().setTxtNinteiYukoToYMD(txtNinteiYukoToYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return this.getNinteiInfo().getTxtShinseiDate();
    }

    @JsonIgnore
    public void  setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.getNinteiInfo().setTxtShinseiDate(txtShinseiDate);
    }

    @JsonIgnore
    public CheckBoxList getChkSeidoitsuseiShogai() {
        return this.getNinteiInfo().getChkSeidoitsuseiShogai();
    }

    @JsonIgnore
    public void  setChkSeidoitsuseiShogai(CheckBoxList chkSeidoitsuseiShogai) {
        this.getNinteiInfo().setChkSeidoitsuseiShogai(chkSeidoitsuseiShogai);
    }

    @JsonIgnore
    public tplGendoGakuDiv getTplGendoGaku() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku();
    }

    @JsonIgnore
    public void  setTplGendoGaku(tplGendoGakuDiv tplGendoGaku) {
        this.getTabHihokenshaShikakuShosai().setTplGendoGaku(tplGendoGaku);
    }

    @JsonIgnore
    public tblGendoGakuDiv getTblGendoGaku() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku();
    }

    @JsonIgnore
    public void  setTblGendoGaku(tblGendoGakuDiv tblGendoGaku) {
        this.getTabHihokenshaShikakuShosai().getTplGendoGaku().setTblGendoGaku(tblGendoGaku);
    }

    @JsonIgnore
    public KubunGendoGakuDiv getKubunGendoGaku() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getKubunGendoGaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKubunShikyuGendoKijunGaku() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getKubunGendoGaku().getTxtKubunShikyuGendoKijunGaku();
    }

    @JsonIgnore
    public void  setTxtKubunShikyuGendoKijunGaku(TextBoxNum txtKubunShikyuGendoKijunGaku) {
        this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getKubunGendoGaku().setTxtKubunShikyuGendoKijunGaku(txtKubunShikyuGendoKijunGaku);
    }

    @JsonIgnore
    public TextBoxDate getTxtYukoFromYMD() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getKubunGendoGaku().getTxtYukoFromYMD();
    }

    @JsonIgnore
    public void  setTxtYukoFromYMD(TextBoxDate txtYukoFromYMD) {
        this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getKubunGendoGaku().setTxtYukoFromYMD(txtYukoFromYMD);
    }

    @JsonIgnore
    public Label getLblKara() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getKubunGendoGaku().getLblKara();
    }

    @JsonIgnore
    public void  setLblKara(Label lblKara) {
        this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getKubunGendoGaku().setLblKara(lblKara);
    }

    @JsonIgnore
    public TextBoxDate getTxtYukoToYMD() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getKubunGendoGaku().getTxtYukoToYMD();
    }

    @JsonIgnore
    public void  setTxtYukoToYMD(TextBoxDate txtYukoToYMD) {
        this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getKubunGendoGaku().setTxtYukoToYMD(txtYukoToYMD);
    }

    @JsonIgnore
    public ShuruiShikyuGendoKijungakuDiv getShuruiShikyuGendoKijungaku() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getShuruiShikyuGendoKijungaku();
    }

    @JsonIgnore
    public tplShinsakaiIkenDiv getTplShinsakaiIken() {
        return this.getTabHihokenshaShikakuShosai().getTplShinsakaiIken();
    }

    @JsonIgnore
    public void  setTplShinsakaiIken(tplShinsakaiIkenDiv tplShinsakaiIken) {
        this.getTabHihokenshaShikakuShosai().setTplShinsakaiIken(tplShinsakaiIken);
    }

    @JsonIgnore
    public Label getLblShinsakaiIken() {
        return this.getTabHihokenshaShikakuShosai().getTplShinsakaiIken().getLblShinsakaiIken();
    }

    @JsonIgnore
    public void  setLblShinsakaiIken(Label lblShinsakaiIken) {
        this.getTabHihokenshaShikakuShosai().getTplShinsakaiIken().setLblShinsakaiIken(lblShinsakaiIken);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinsakaiIken() {
        return this.getTabHihokenshaShikakuShosai().getTplShinsakaiIken().getTxtShinsakaiIken();
    }

    @JsonIgnore
    public void  setTxtShinsakaiIken(TextBoxMultiLine txtShinsakaiIken) {
        this.getTabHihokenshaShikakuShosai().getTplShinsakaiIken().setTxtShinsakaiIken(txtShinsakaiIken);
    }

    @JsonIgnore
    public tplKyufuSeigenDiv getTplKyufuSeigen() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen();
    }

    @JsonIgnore
    public void  setTplKyufuSeigen(tplKyufuSeigenDiv tplKyufuSeigen) {
        this.getTabHihokenshaShikakuShosai().setTplKyufuSeigen(tplKyufuSeigen);
    }

    @JsonIgnore
    public Label getLblKyufuSeigen() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getLblKyufuSeigen();
    }

    @JsonIgnore
    public void  setLblKyufuSeigen(Label lblKyufuSeigen) {
        this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().setLblKyufuSeigen(lblKyufuSeigen);
    }

    @JsonIgnore
    public tblKyuhuSeigenDiv getTblKyuhuSeigen() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getTblKyuhuSeigen();
    }

    @JsonIgnore
    public void  setTblKyuhuSeigen(tblKyuhuSeigenDiv tblKyuhuSeigen) {
        this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().setTblKyuhuSeigen(tblKyuhuSeigen);
    }

    @JsonIgnore
    public Label getLblKyufuSeigenNaiyo() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getTblKyuhuSeigen().getLblKyufuSeigenNaiyo();
    }

    @JsonIgnore
    public Label getLblKyufuSeigenKikan() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getTblKyuhuSeigen().getLblKyufuSeigenKikan();
    }

    @JsonIgnore
    public TextBox getTxtKyufuSeigenNaiyo1() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenNaiyo1();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyufuSeigenKikan1() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenKikan1();
    }

    @JsonIgnore
    public TextBox getTxtKyufuSeigenNaiyo2() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenNaiyo2();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyufuSeigenKikan2() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenKikan2();
    }

    @JsonIgnore
    public TextBox getTxtKyufuSeigenNaiyo3() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenNaiyo3();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyufuSeigenKikan3() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenKikan3();
    }

    @JsonIgnore
    public tplShienJigyoshaDiv getTplShienJigyosha() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha();
    }

    @JsonIgnore
    public void  setTplShienJigyosha(tplShienJigyoshaDiv tplShienJigyosha) {
        this.getTabHihokenshaShikakuShosai().setTplShienJigyosha(tplShienJigyosha);
    }

    @JsonIgnore
    public Label getLblShienJigyosha() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getLblShienJigyosha();
    }

    @JsonIgnore
    public void  setLblShienJigyosha(Label lblShienJigyosha) {
        this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().setLblShienJigyosha(lblShienJigyosha);
    }

    @JsonIgnore
    public tblJigyoshaDiv getTblJigyosha() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha();
    }

    @JsonIgnore
    public void  setTblJigyosha(tblJigyoshaDiv tblJigyosha) {
        this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().setTblJigyosha(tblJigyosha);
    }

    @JsonIgnore
    public Label getLblJigyosha() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getLblJigyosha();
    }

    @JsonIgnore
    public Label getLblTodokedeDate() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getLblTodokedeDate();
    }

    @JsonIgnore
    public Label getLblTekiyoStYMD() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getLblTekiyoStYMD();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha1() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtJigyosha1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeYMD1() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtTodokedeYMD1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoStYMD1() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtTekiyoStYMD1();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha2() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtJigyosha2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeYMD2() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtTodokedeYMD2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoStYMD2() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtTekiyoStYMD2();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha3() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtJigyosha3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeYMD3() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtTodokedeYMD3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoStYMD3() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtTekiyoStYMD3();
    }

    @JsonIgnore
    public tplShisetsuNyutaishoDiv getTplShisetsuNyutaisho() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho();
    }

    @JsonIgnore
    public void  setTplShisetsuNyutaisho(tplShisetsuNyutaishoDiv tplShisetsuNyutaisho) {
        this.getTabHihokenshaShikakuShosai().setTplShisetsuNyutaisho(tplShisetsuNyutaisho);
    }

    @JsonIgnore
    public Label getLblKaigoHokensha() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getLblKaigoHokensha();
    }

    @JsonIgnore
    public void  setLblKaigoHokensha(Label lblKaigoHokensha) {
        this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().setLblKaigoHokensha(lblKaigoHokensha);
    }

    @JsonIgnore
    public tblShisetsuNyutaishoDiv getTblShisetsuNyutaisho() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho();
    }

    @JsonIgnore
    public void  setTblShisetsuNyutaisho(tblShisetsuNyutaishoDiv tblShisetsuNyutaisho) {
        this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().setTblShisetsuNyutaisho(tblShisetsuNyutaisho);
    }

    @JsonIgnore
    public Label getLblNyushoShisetsu() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getLblNyushoShisetsu();
    }

    @JsonIgnore
    public Label getLblShisetsuNyushoDate() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getLblShisetsuNyushoDate();
    }

    @JsonIgnore
    public Label getLblShisetsuTaishoDate() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getLblShisetsuTaishoDate();
    }

    @JsonIgnore
    public TextBox getTxtNyushoShisetsu1() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtNyushoShisetsu1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate1() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuNyushoDate1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate1() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuTaishoDate1();
    }

    @JsonIgnore
    public TextBox getTxtNyushoShisetsu2() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtNyushoShisetsu2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate2() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuNyushoDate2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate2() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuTaishoDate2();
    }

    @JsonIgnore
    public TextBox getTxtNyushoShisetsu3() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtNyushoShisetsu3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate3() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuNyushoDate3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate3() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuTaishoDate3();
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
