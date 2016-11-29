package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8110001;
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
 * KobetsuHakkoZengoSentaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KobetsuHakkoZengoSentakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlInjiKouseiMae")
    private DropDownList ddlInjiKouseiMae;
    @JsonProperty("ddlInjiKouseiAto")
    private DropDownList ddlInjiKouseiAto;
    @JsonProperty("tblKobetsuHakkoFukakonkyo")
    private tblKobetsuHakkoFukakonkyoDiv tblKobetsuHakkoFukakonkyo;
    @JsonProperty("tblKobetsuHakkoKiwariGaku")
    private tblKobetsuHakkoKiwariGakuDiv tblKobetsuHakkoKiwariGaku;
    @JsonProperty("tblSaishutsuKampu")
    private tblSaishutsuKampuDiv tblSaishutsuKampu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlInjiKouseiMae
     * @return ddlInjiKouseiMae
     */
    @JsonProperty("ddlInjiKouseiMae")
    public DropDownList getDdlInjiKouseiMae() {
        return ddlInjiKouseiMae;
    }

    /*
     * setddlInjiKouseiMae
     * @param ddlInjiKouseiMae ddlInjiKouseiMae
     */
    @JsonProperty("ddlInjiKouseiMae")
    public void setDdlInjiKouseiMae(DropDownList ddlInjiKouseiMae) {
        this.ddlInjiKouseiMae = ddlInjiKouseiMae;
    }

    /*
     * getddlInjiKouseiAto
     * @return ddlInjiKouseiAto
     */
    @JsonProperty("ddlInjiKouseiAto")
    public DropDownList getDdlInjiKouseiAto() {
        return ddlInjiKouseiAto;
    }

    /*
     * setddlInjiKouseiAto
     * @param ddlInjiKouseiAto ddlInjiKouseiAto
     */
    @JsonProperty("ddlInjiKouseiAto")
    public void setDdlInjiKouseiAto(DropDownList ddlInjiKouseiAto) {
        this.ddlInjiKouseiAto = ddlInjiKouseiAto;
    }

    /*
     * gettblKobetsuHakkoFukakonkyo
     * @return tblKobetsuHakkoFukakonkyo
     */
    @JsonProperty("tblKobetsuHakkoFukakonkyo")
    public tblKobetsuHakkoFukakonkyoDiv getTblKobetsuHakkoFukakonkyo() {
        return tblKobetsuHakkoFukakonkyo;
    }

    /*
     * settblKobetsuHakkoFukakonkyo
     * @param tblKobetsuHakkoFukakonkyo tblKobetsuHakkoFukakonkyo
     */
    @JsonProperty("tblKobetsuHakkoFukakonkyo")
    public void setTblKobetsuHakkoFukakonkyo(tblKobetsuHakkoFukakonkyoDiv tblKobetsuHakkoFukakonkyo) {
        this.tblKobetsuHakkoFukakonkyo = tblKobetsuHakkoFukakonkyo;
    }

    /*
     * gettblKobetsuHakkoKiwariGaku
     * @return tblKobetsuHakkoKiwariGaku
     */
    @JsonProperty("tblKobetsuHakkoKiwariGaku")
    public tblKobetsuHakkoKiwariGakuDiv getTblKobetsuHakkoKiwariGaku() {
        return tblKobetsuHakkoKiwariGaku;
    }

    /*
     * settblKobetsuHakkoKiwariGaku
     * @param tblKobetsuHakkoKiwariGaku tblKobetsuHakkoKiwariGaku
     */
    @JsonProperty("tblKobetsuHakkoKiwariGaku")
    public void setTblKobetsuHakkoKiwariGaku(tblKobetsuHakkoKiwariGakuDiv tblKobetsuHakkoKiwariGaku) {
        this.tblKobetsuHakkoKiwariGaku = tblKobetsuHakkoKiwariGaku;
    }

    /*
     * gettblSaishutsuKampu
     * @return tblSaishutsuKampu
     */
    @JsonProperty("tblSaishutsuKampu")
    public tblSaishutsuKampuDiv getTblSaishutsuKampu() {
        return tblSaishutsuKampu;
    }

    /*
     * settblSaishutsuKampu
     * @param tblSaishutsuKampu tblSaishutsuKampu
     */
    @JsonProperty("tblSaishutsuKampu")
    public void setTblSaishutsuKampu(tblSaishutsuKampuDiv tblSaishutsuKampu) {
        this.tblSaishutsuKampu = tblSaishutsuKampu;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblFukankonkyoZengo() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoZengo();
    }

    @JsonIgnore
    public Label getLblFukankonkyoMae() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoMae();
    }

    @JsonIgnore
    public Label getLblFukankonkyoAto() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoAto();
    }

    @JsonIgnore
    public Label getLblFukankonkyoZengo1() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoZengo1();
    }

    @JsonIgnore
    public Label getLblFukankonkyoMae1() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoMae1();
    }

    @JsonIgnore
    public Label getLblFukankonkyoAto1() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoAto1();
    }

    @JsonIgnore
    public Label getLblFukankonkyoZengo2() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoZengo2();
    }

    @JsonIgnore
    public Label getLblFukankonkyoMae2() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoMae2();
    }

    @JsonIgnore
    public Label getLblFukankonkyoAto2() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoAto2();
    }

    @JsonIgnore
    public Label getLblFukankonkyoZengo3() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoZengo3();
    }

    @JsonIgnore
    public Label getLblFukankonkyoMae3() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoMae3();
    }

    @JsonIgnore
    public Label getLblFukankonkyoAto3() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoAto3();
    }

    @JsonIgnore
    public Label getLblFukankonkyoZengo4() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoZengo4();
    }

    @JsonIgnore
    public Label getLblFukankonkyoMae4() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoMae4();
    }

    @JsonIgnore
    public Label getLblFukankonkyoAto4() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoAto4();
    }

    @JsonIgnore
    public Label getLblFukankonkyoZengo5() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoZengo5();
    }

    @JsonIgnore
    public Label getLblFukankonkyoMae5() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoMae5();
    }

    @JsonIgnore
    public Label getLblFukankonkyoAto5() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoAto5();
    }

    @JsonIgnore
    public Label getLblFukankonkyoZengo6() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoZengo6();
    }

    @JsonIgnore
    public Label getLblFukankonkyoMae6() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoMae6();
    }

    @JsonIgnore
    public Label getLblFukankonkyoAto6() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoAto6();
    }

    @JsonIgnore
    public Label getLblFukankonkyoZengo7() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoZengo7();
    }

    @JsonIgnore
    public Label getLblFukankonkyoMae7() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoMae7();
    }

    @JsonIgnore
    public Label getLblFukankonkyoAto7() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoAto7();
    }

    @JsonIgnore
    public Label getLblFukankonkyoZengo8() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoZengo8();
    }

    @JsonIgnore
    public Label getLblFukankonkyoMae8() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoMae8();
    }

    @JsonIgnore
    public Label getLblFukankonkyoAto8() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoAto8();
    }

    @JsonIgnore
    public Label getLblFukankonkyoZengo9() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoZengo9();
    }

    @JsonIgnore
    public Label getLblFukankonkyoMae9() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoMae9();
    }

    @JsonIgnore
    public Label getLblFukankonkyoAto9() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoAto9();
    }

    @JsonIgnore
    public Label getLblFukankonkyoZengo10() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoZengo10();
    }

    @JsonIgnore
    public Label getLblFukankonkyoMae10() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoMae10();
    }

    @JsonIgnore
    public Label getLblFukankonkyoAto10() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoAto10();
    }

    @JsonIgnore
    public Label getLblFukankonkyoZengo11() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoZengo11();
    }

    @JsonIgnore
    public Label getLblFukankonkyoMae11() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoMae11();
    }

    @JsonIgnore
    public Label getLblFukankonkyoAto11() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoAto11();
    }

    @JsonIgnore
    public Label getLblFukankonkyoZengo12() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoZengo12();
    }

    @JsonIgnore
    public Label getLblFukankonkyoMae12() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoMae12();
    }

    @JsonIgnore
    public Label getLblFukankonkyoAto12() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoAto12();
    }

    @JsonIgnore
    public Label getLblFukankonkyoZengo13() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoZengo13();
    }

    @JsonIgnore
    public Label getLblFukankonkyoMae13() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoMae13();
    }

    @JsonIgnore
    public Label getLblFukankonkyoAto13() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoAto13();
    }

    @JsonIgnore
    public Label getLblFukankonkyoZengo14() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoZengo14();
    }

    @JsonIgnore
    public Label getLblFukankonkyoMae14() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoMae14();
    }

    @JsonIgnore
    public Label getLblFukankonkyoAto14() {
        return this.getTblKobetsuHakkoFukakonkyo().getLblFukankonkyoAto14();
    }

    @JsonIgnore
    public Label getLblKobetsuHakkoZengoTokucho() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblKobetsuHakkoZengoTokucho();
    }

    @JsonIgnore
    public Label getLblKobetsuHakkoZengoFucho() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblKobetsuHakkoZengoFucho();
    }

    @JsonIgnore
    public Label getLblTsuki() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblTsuki();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoKi() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoKi();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoMae() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoMae();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoAto() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoAto();
    }

    @JsonIgnore
    public Label getLblZengoFuchoKi() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoKi();
    }

    @JsonIgnore
    public Label getLblZengoFuchoMae() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoMae();
    }

    @JsonIgnore
    public Label getLblZengoFuchoAto() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoAto();
    }

    @JsonIgnore
    public Label getLblZengoNokigen() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoNokigen();
    }

    @JsonIgnore
    public Label getLblTsuki1() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblTsuki1();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoKi1() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoKi1();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoMae1() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoMae1();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoAto1() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoAto1();
    }

    @JsonIgnore
    public Label getLblZengoFuchoKi1() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoKi1();
    }

    @JsonIgnore
    public Label getLblZengoFuchoMae1() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoMae1();
    }

    @JsonIgnore
    public Label getLblZengoFuchoAto1() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoAto1();
    }

    @JsonIgnore
    public Label getLblZengoNokigen1() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoNokigen1();
    }

    @JsonIgnore
    public Label getLblTsuki2() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblTsuki2();
    }

    @JsonIgnore
    public Label getLblZengoFuchoKi2() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoKi2();
    }

    @JsonIgnore
    public Label getLblZengoFuchoMae2() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoMae2();
    }

    @JsonIgnore
    public Label getLblZengoFuchoAto2() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoAto2();
    }

    @JsonIgnore
    public Label getLblZengoNokigen2() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoNokigen2();
    }

    @JsonIgnore
    public Label getLblTsuki3() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblTsuki3();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoKi2() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoKi2();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoMae2() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoMae2();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoAto2() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoAto2();
    }

    @JsonIgnore
    public Label getLblZengoFuchoKi3() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoKi3();
    }

    @JsonIgnore
    public Label getLblZengoFuchoMae3() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoMae3();
    }

    @JsonIgnore
    public Label getLblZengoFuchoAto3() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoAto3();
    }

    @JsonIgnore
    public Label getLblZengoNokigen3() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoNokigen3();
    }

    @JsonIgnore
    public Label getLblTsuki4() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblTsuki4();
    }

    @JsonIgnore
    public Label getLblZengoFuchoKi4() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoKi4();
    }

    @JsonIgnore
    public Label getLblZengoFuchoMae4() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoMae4();
    }

    @JsonIgnore
    public Label getLblZengoFuchoAto4() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoAto4();
    }

    @JsonIgnore
    public Label getLblZengoNokigen4() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoNokigen4();
    }

    @JsonIgnore
    public Label getLblTsuki5() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblTsuki5();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoKi3() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoKi3();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoMae3() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoMae3();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoAto3() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoAto3();
    }

    @JsonIgnore
    public Label getLblZengoFuchoKi5() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoKi5();
    }

    @JsonIgnore
    public Label getLblZengoFuchoMae5() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoMae5();
    }

    @JsonIgnore
    public Label getLblZengoFuchoAto5() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoAto5();
    }

    @JsonIgnore
    public Label getLblZengoNokigen5() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoNokigen5();
    }

    @JsonIgnore
    public Label getLblTsuki6() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblTsuki6();
    }

    @JsonIgnore
    public Label getLblZengoFuchoKi6() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoKi6();
    }

    @JsonIgnore
    public Label getLblZengoFuchoMae6() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoMae6();
    }

    @JsonIgnore
    public Label getLblZengoFuchoAto6() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoAto6();
    }

    @JsonIgnore
    public Label getLblZengoNokigen6() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoNokigen6();
    }

    @JsonIgnore
    public Label getLblTsuki7() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblTsuki7();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoKi4() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoKi4();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoMae4() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoMae4();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoAto4() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoAto4();
    }

    @JsonIgnore
    public Label getLblZengoFuchoKi7() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoKi7();
    }

    @JsonIgnore
    public Label getLblZengoFuchoMae7() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoMae7();
    }

    @JsonIgnore
    public Label getLblZengoFuchoAto7() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoAto7();
    }

    @JsonIgnore
    public Label getLblZengoNokigen7() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoNokigen7();
    }

    @JsonIgnore
    public Label getLblTsuki8() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblTsuki8();
    }

    @JsonIgnore
    public Label getLblZengoFuchoKi8() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoKi8();
    }

    @JsonIgnore
    public Label getLblZengoFuchoMae8() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoMae8();
    }

    @JsonIgnore
    public Label getLblZengoFuchoAto8() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoAto8();
    }

    @JsonIgnore
    public Label getLblZengoNokigen8() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoNokigen8();
    }

    @JsonIgnore
    public Label getLblTsuki9() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblTsuki9();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoKi5() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoKi5();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoMae5() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoMae5();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoAto5() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoAto5();
    }

    @JsonIgnore
    public Label getLblZengoFuchoKi9() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoKi9();
    }

    @JsonIgnore
    public Label getLblZengoFuchoMae9() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoMae9();
    }

    @JsonIgnore
    public Label getLblZengoFuchoAto9() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoAto9();
    }

    @JsonIgnore
    public Label getLblZengoNokigen9() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoNokigen9();
    }

    @JsonIgnore
    public Label getLblTsuki10() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblTsuki10();
    }

    @JsonIgnore
    public Label getLblZengoFuchoKi10() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoKi10();
    }

    @JsonIgnore
    public Label getLblZengoFuchoMae10() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoMae10();
    }

    @JsonIgnore
    public Label getLblZengoFuchoAto10() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoAto10();
    }

    @JsonIgnore
    public Label getLblZengoNokigen10() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoNokigen10();
    }

    @JsonIgnore
    public Label getLblTsuki11() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblTsuki11();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoKi6() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoKi6();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoMae6() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoMae6();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoAto6() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoAto6();
    }

    @JsonIgnore
    public Label getLblZengoFuchoKi11() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoKi11();
    }

    @JsonIgnore
    public Label getLblZengoFuchoMae11() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoMae11();
    }

    @JsonIgnore
    public Label getLblZengoFuchoAto11() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoAto11();
    }

    @JsonIgnore
    public Label getLblZengoNokigen11() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoNokigen11();
    }

    @JsonIgnore
    public Label getLblTsuki12() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblTsuki12();
    }

    @JsonIgnore
    public Label getLblZengoFuchoKi12() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoKi12();
    }

    @JsonIgnore
    public Label getLblZengoFuchoMae12() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoMae12();
    }

    @JsonIgnore
    public Label getLblZengoFuchoAto12() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoAto12();
    }

    @JsonIgnore
    public Label getLblZengoNokigen12() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoNokigen12();
    }

    @JsonIgnore
    public Label getLblTsuki13() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblTsuki13();
    }

    @JsonIgnore
    public Label getLblZengoFuchoKi13() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoKi13();
    }

    @JsonIgnore
    public Label getLblZengoFuchoMae13() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoMae13();
    }

    @JsonIgnore
    public Label getLblZengoFuchoAto13() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoAto13();
    }

    @JsonIgnore
    public Label getLblZengoNokigen13() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoNokigen13();
    }

    @JsonIgnore
    public Label getLblTsuki14() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblTsuki14();
    }

    @JsonIgnore
    public Label getLblZengoFuchoKi14() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoKi14();
    }

    @JsonIgnore
    public Label getLblZengoFuchoMae14() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoMae14();
    }

    @JsonIgnore
    public Label getLblZengoFuchoAto14() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoAto14();
    }

    @JsonIgnore
    public Label getLblZengoNokigen14() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoNokigen14();
    }

    @JsonIgnore
    public Label getLblGoukei() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblGoukei();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoMaeKei() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoMaeKei();
    }

    @JsonIgnore
    public Label getLblZengoTokuchoAtoKei() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoTokuchoAtoKei();
    }

    @JsonIgnore
    public Label getLblZengoFuchoMaeKei() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoMaeKei();
    }

    @JsonIgnore
    public Label getLblZengoFuchoAtoKei() {
        return this.getTblKobetsuHakkoKiwariGaku().getLblZengoFuchoAtoKei();
    }

    @JsonIgnore
    public Label getLblSaishutsuKampuGaku() {
        return this.getTblSaishutsuKampu().getLblSaishutsuKampuGaku();
    }

    @JsonIgnore
    public Label getLblSaishutsuKampuTokucho() {
        return this.getTblSaishutsuKampu().getLblSaishutsuKampuTokucho();
    }

    @JsonIgnore
    public Label getLblSaishutsuKampuFucho() {
        return this.getTblSaishutsuKampu().getLblSaishutsuKampuFucho();
    }

    @JsonIgnore
    public Label getLblSaishutsuKampu() {
        return this.getTblSaishutsuKampu().getLblSaishutsuKampu();
    }

    @JsonIgnore
    public Label getLblTokuchoSaishutsuKampuGaku() {
        return this.getTblSaishutsuKampu().getLblTokuchoSaishutsuKampuGaku();
    }

    @JsonIgnore
    public Label getLblFuchoSaishutsuKampuGaku() {
        return this.getTblSaishutsuKampu().getLblFuchoSaishutsuKampuGaku();
    }

    // </editor-fold>
}
