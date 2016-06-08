package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020071;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * pnlMain のクラスファイル
 *
 * @reamsid_L DBU-1100-090 lijunjun
 */
public class pnlMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbdHokokuNengetsu")
    private TextBoxDate tbdHokokuNengetsu;
    @JsonProperty("tbdShukeiNengetsu")
    private TextBoxDate tbdShukeiNengetsu;
    @JsonProperty("pnlYosikiHosei")
    private TextBox pnlYosikiHosei;
    @JsonProperty("tbHokensyaName")
    private TextBox tbHokensyaName;
    @JsonProperty("tcMain")
    private tcMainDiv tcMain;
    @JsonProperty("予防給付")
    private RString 予防給付;
    @JsonProperty("介護給付")
    private RString 介護給付;
    @JsonProperty("合計")
    private RString 合計;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbdHokokuNengetsu
     * @return tbdHokokuNengetsu
     */
    @JsonProperty("tbdHokokuNengetsu")
    public TextBoxDate getTbdHokokuNengetsu() {
        return tbdHokokuNengetsu;
    }

    /*
     * settbdHokokuNengetsu
     * @param tbdHokokuNengetsu tbdHokokuNengetsu
     */
    @JsonProperty("tbdHokokuNengetsu")
    public void setTbdHokokuNengetsu(TextBoxDate tbdHokokuNengetsu) {
        this.tbdHokokuNengetsu = tbdHokokuNengetsu;
    }

    /*
     * gettbdShukeiNengetsu
     * @return tbdShukeiNengetsu
     */
    @JsonProperty("tbdShukeiNengetsu")
    public TextBoxDate getTbdShukeiNengetsu() {
        return tbdShukeiNengetsu;
    }

    /*
     * settbdShukeiNengetsu
     * @param tbdShukeiNengetsu tbdShukeiNengetsu
     */
    @JsonProperty("tbdShukeiNengetsu")
    public void setTbdShukeiNengetsu(TextBoxDate tbdShukeiNengetsu) {
        this.tbdShukeiNengetsu = tbdShukeiNengetsu;
    }

    /*
     * getpnlYosikiHosei
     * @return pnlYosikiHosei
     */
    @JsonProperty("pnlYosikiHosei")
    public TextBox getPnlYosikiHosei() {
        return pnlYosikiHosei;
    }

    /*
     * setpnlYosikiHosei
     * @param pnlYosikiHosei pnlYosikiHosei
     */
    @JsonProperty("pnlYosikiHosei")
    public void setPnlYosikiHosei(TextBox pnlYosikiHosei) {
        this.pnlYosikiHosei = pnlYosikiHosei;
    }

    /*
     * gettbHokensyaName
     * @return tbHokensyaName
     */
    @JsonProperty("tbHokensyaName")
    public TextBox getTbHokensyaName() {
        return tbHokensyaName;
    }

    /*
     * settbHokensyaName
     * @param tbHokensyaName tbHokensyaName
     */
    @JsonProperty("tbHokensyaName")
    public void setTbHokensyaName(TextBox tbHokensyaName) {
        this.tbHokensyaName = tbHokensyaName;
    }

    /*
     * gettcMain
     * @return tcMain
     */
    @JsonProperty("tcMain")
    public tcMainDiv getTcMain() {
        return tcMain;
    }

    /*
     * settcMain
     * @param tcMain tcMain
     */
    @JsonProperty("tcMain")
    public void setTcMain(tcMainDiv tcMain) {
        this.tcMain = tcMain;
    }

    /*
     * get予防給付
     * @return 予防給付
     */
    @JsonProperty("予防給付")
    public RString get予防給付() {
        return 予防給付;
    }

    /*
     * set予防給付
     * @param 予防給付 予防給付
     */
    @JsonProperty("予防給付")
    public void set予防給付(RString 予防給付) {
        this.予防給付 = 予防給付;
    }

    /*
     * get介護給付
     * @return 介護給付
     */
    @JsonProperty("介護給付")
    public RString get介護給付() {
        return 介護給付;
    }

    /*
     * set介護給付
     * @param 介護給付 介護給付
     */
    @JsonProperty("介護給付")
    public void set介護給付(RString 介護給付) {
        this.介護給付 = 介護給付;
    }

    /*
     * get合計
     * @return 合計
     */
    @JsonProperty("合計")
    public RString get合計() {
        return 合計;
    }

    /*
     * set合計
     * @param 合計 合計
     */
    @JsonProperty("合計")
    public void set合計(RString 合計) {
        this.合計 = 合計;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tpl1Div getTpl1() {
        return this.getTcMain().getTpl1();
    }

    @JsonIgnore
    public void setTpl1(tpl1Div tpl1) {
        this.getTcMain().setTpl1(tpl1);
    }

    @JsonIgnore
    public tbl1Div getTbl1() {
        return this.getTcMain().getTpl1().getTbl1();
    }

    @JsonIgnore
    public void setTbl1(tbl1Div tbl1) {
        this.getTcMain().getTpl1().setTbl1(tbl1);
    }

    @JsonIgnore
    public TextBox getTextBox1() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox1();
    }

    @JsonIgnore
    public TextBox getTextBox2() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox2();
    }

    @JsonIgnore
    public TextBox getTextBox3() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox3();
    }

    @JsonIgnore
    public TextBox getTextBox4() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox4();
    }

    @JsonIgnore
    public TextBox getTextBox5() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox5();
    }

    @JsonIgnore
    public TextBox getTextBox6() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox6();
    }

    @JsonIgnore
    public TextBox getTextBox7() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox7();
    }

    @JsonIgnore
    public TextBox getTextBox8() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox8();
    }

    @JsonIgnore
    public TextBox getTextBox9() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox9();
    }

    @JsonIgnore
    public TextBox getTextBox10() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox10();
    }

    @JsonIgnore
    public TextBox getTextBox11() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox11();
    }

    @JsonIgnore
    public TextBox getTextBox12() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox12();
    }

    @JsonIgnore
    public TextBox getTextBox13() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox13();
    }

    @JsonIgnore
    public TextBox getTextBox14() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox14();
    }

    @JsonIgnore
    public TextBox getTextBox15() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox15();
    }

    @JsonIgnore
    public TextBox getTextBox16() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox16();
    }

    @JsonIgnore
    public TextBox getTextBox17() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox17();
    }

    @JsonIgnore
    public TextBox getTextBox18() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox18();
    }

    @JsonIgnore
    public TextBox getTextBox19() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox19();
    }

    @JsonIgnore
    public TextBox getTextBox20() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox20();
    }

    @JsonIgnore
    public TextBox getTextBox21() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox21();
    }

    @JsonIgnore
    public TextBox getTextBox22() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox22();
    }

    @JsonIgnore
    public TextBox getTextBox23() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox23();
    }

    @JsonIgnore
    public TextBox getTextBox24() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox24();
    }

    @JsonIgnore
    public TextBox getTextBox25() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox25();
    }

    @JsonIgnore
    public TextBox getTextBox26() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox26();
    }

    @JsonIgnore
    public TextBox getTextBox27() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox27();
    }

    @JsonIgnore
    public TextBox getTextBox28() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox28();
    }

    @JsonIgnore
    public TextBox getTextBox29() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox29();
    }

    @JsonIgnore
    public TextBox getTextBox30() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox30();
    }

    @JsonIgnore
    public TextBox getTextBox31() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox31();
    }

    @JsonIgnore
    public TextBox getTextBox32() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox32();
    }

    @JsonIgnore
    public TextBox getTextBox33() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox33();
    }

    @JsonIgnore
    public TextBox getTextBox35() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox35();
    }

    @JsonIgnore
    public TextBox getTextBox36() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox36();
    }

    @JsonIgnore
    public TextBox getTextBox37() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox37();
    }

    @JsonIgnore
    public TextBox getTextBox38() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox38();
    }

    @JsonIgnore
    public TextBox getTextBox39() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox39();
    }

    @JsonIgnore
    public TextBox getTextBox40() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox40();
    }

    @JsonIgnore
    public TextBox getTextBox41() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox41();
    }

    @JsonIgnore
    public TextBox getTextBox42() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox42();
    }

    @JsonIgnore
    public TextBox getTextBox43() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox43();
    }

    @JsonIgnore
    public TextBox getTextBox44() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox44();
    }

    @JsonIgnore
    public TextBox getTextBox34() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox34();
    }

    @JsonIgnore
    public TextBox getTextBox45() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox45();
    }

    @JsonIgnore
    public TextBox getTextBox46() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox46();
    }

    @JsonIgnore
    public TextBox getTextBox47() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox47();
    }

    @JsonIgnore
    public TextBox getTextBox48() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox48();
    }

    @JsonIgnore
    public TextBox getTextBox49() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox49();
    }

    @JsonIgnore
    public TextBox getTextBox50() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox50();
    }

    @JsonIgnore
    public TextBox getTextBox51() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox51();
    }

    @JsonIgnore
    public TextBox getTextBox52() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox52();
    }

    @JsonIgnore
    public TextBox getTextBox53() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox53();
    }

    @JsonIgnore
    public TextBox getTextBox54() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox54();
    }

    @JsonIgnore
    public TextBox getTextBox55() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox55();
    }

    @JsonIgnore
    public TextBox getTextBox56() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox56();
    }

    @JsonIgnore
    public TextBox getTextBox57() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox57();
    }

    @JsonIgnore
    public TextBox getTextBox58() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox58();
    }

    @JsonIgnore
    public TextBox getTextBox59() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox59();
    }

    @JsonIgnore
    public TextBox getTextBox60() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox60();
    }

    @JsonIgnore
    public TextBox getTextBox61() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox61();
    }

    @JsonIgnore
    public TextBox getTextBox62() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox62();
    }

    @JsonIgnore
    public TextBox getTextBox63() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox63();
    }

    @JsonIgnore
    public TextBox getTextBox64() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox64();
    }

    @JsonIgnore
    public TextBox getTextBox65() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox65();
    }

    @JsonIgnore
    public TextBox getTextBox66() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox66();
    }

    @JsonIgnore
    public TextBox getTextBox67() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox67();
    }

    @JsonIgnore
    public TextBox getTextBox68() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox68();
    }

    @JsonIgnore
    public TextBox getTextBox69() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox69();
    }

    @JsonIgnore
    public TextBox getTextBox70() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox70();
    }

    @JsonIgnore
    public TextBox getTextBox71() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox71();
    }

    @JsonIgnore
    public TextBox getTextBox72() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox72();
    }

    @JsonIgnore
    public TextBox getTextBox73() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox73();
    }

    @JsonIgnore
    public TextBox getTextBox74() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox74();
    }

    @JsonIgnore
    public TextBox getTextBox75() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox75();
    }

    @JsonIgnore
    public TextBox getTextBox76() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox76();
    }

    @JsonIgnore
    public TextBox getTextBox77() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox77();
    }

    @JsonIgnore
    public TextBox getTextBox78() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox78();
    }

    @JsonIgnore
    public TextBox getTextBox79() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox79();
    }

    @JsonIgnore
    public TextBox getTextBox80() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox80();
    }

    @JsonIgnore
    public TextBox getTextBox81() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox81();
    }

    @JsonIgnore
    public TextBox getTextBox82() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox82();
    }

    @JsonIgnore
    public TextBox getTextBox83() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox83();
    }

    @JsonIgnore
    public TextBox getTextBox84() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox84();
    }

    @JsonIgnore
    public TextBox getTextBox85() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox85();
    }

    @JsonIgnore
    public TextBox getTextBox86() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox86();
    }

    @JsonIgnore
    public TextBox getTextBox87() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox87();
    }

    @JsonIgnore
    public TextBox getTextBox88() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox88();
    }

    @JsonIgnore
    public TextBox getTextBox89() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox89();
    }

    @JsonIgnore
    public TextBox getTextBox90() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox90();
    }

    @JsonIgnore
    public TextBox getTextBox91() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox91();
    }

    @JsonIgnore
    public TextBox getTextBox92() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox92();
    }

    @JsonIgnore
    public TextBox getTextBox93() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox93();
    }

    @JsonIgnore
    public TextBox getTextBox94() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox94();
    }

    @JsonIgnore
    public TextBox getTextBox95() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox95();
    }

    @JsonIgnore
    public TextBox getTextBox96() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox96();
    }

    @JsonIgnore
    public TextBox getTextBox97() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox97();
    }

    @JsonIgnore
    public TextBox getTextBox98() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox98();
    }

    @JsonIgnore
    public TextBox getTextBox99() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox99();
    }

    @JsonIgnore
    public TextBox getTextBox100() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox100();
    }

    @JsonIgnore
    public TextBox getTextBox101() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox101();
    }

    @JsonIgnore
    public TextBox getTextBox102() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox102();
    }

    @JsonIgnore
    public TextBox getTextBox103() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox103();
    }

    @JsonIgnore
    public TextBox getTextBox104() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox104();
    }

    @JsonIgnore
    public TextBox getTextBox105() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox105();
    }

    @JsonIgnore
    public TextBox getTextBox106() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox106();
    }

    @JsonIgnore
    public TextBox getTextBox107() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox107();
    }

    @JsonIgnore
    public TextBox getTextBox108() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox108();
    }

    @JsonIgnore
    public TextBox getTextBox109() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox109();
    }

    @JsonIgnore
    public TextBox getTextBox110() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox110();
    }

    @JsonIgnore
    public TextBox getTextBox111() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox111();
    }

    @JsonIgnore
    public TextBox getTextBox112() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox112();
    }

    @JsonIgnore
    public TextBox getTextBox113() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox113();
    }

    @JsonIgnore
    public TextBox getTextBox114() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox114();
    }

    @JsonIgnore
    public TextBox getTextBox115() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox115();
    }

    @JsonIgnore
    public TextBox getTextBox116() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox116();
    }

    @JsonIgnore
    public TextBox getTextBox117() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox117();
    }

    @JsonIgnore
    public TextBox getTextBox118() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox118();
    }

    @JsonIgnore
    public TextBox getTextBox119() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox119();
    }

    @JsonIgnore
    public TextBox getTextBox120() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox120();
    }

    @JsonIgnore
    public TextBox getTextBox121() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox121();
    }

    @JsonIgnore
    public TextBox getTextBox122() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox122();
    }

    @JsonIgnore
    public TextBox getTextBox123() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox123();
    }

    @JsonIgnore
    public TextBox getTextBox124() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox124();
    }

    @JsonIgnore
    public TextBox getTextBox125() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox125();
    }

    @JsonIgnore
    public TextBox getTextBox126() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox126();
    }

    @JsonIgnore
    public TextBox getTextBox127() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox127();
    }

    @JsonIgnore
    public TextBox getTextBox128() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox128();
    }

    @JsonIgnore
    public TextBox getTextBox129() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox129();
    }

    @JsonIgnore
    public TextBox getTextBox130() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox130();
    }

    @JsonIgnore
    public TextBox getTextBox131() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox131();
    }

    @JsonIgnore
    public TextBox getTextBox132() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox132();
    }

    @JsonIgnore
    public TextBox getTextBox133() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox133();
    }

    @JsonIgnore
    public TextBox getTextBox134() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox134();
    }

    @JsonIgnore
    public TextBox getTextBox135() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox135();
    }

    @JsonIgnore
    public TextBox getTextBox136() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox136();
    }

    @JsonIgnore
    public TextBox getTextBox137() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox137();
    }

    @JsonIgnore
    public TextBox getTextBox138() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox138();
    }

    @JsonIgnore
    public TextBox getTextBox139() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox139();
    }

    @JsonIgnore
    public TextBox getTextBox140() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox140();
    }

    @JsonIgnore
    public TextBox getTextBox141() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox141();
    }

    @JsonIgnore
    public TextBox getTextBox142() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox142();
    }

    @JsonIgnore
    public TextBox getTextBox143() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox143();
    }

    @JsonIgnore
    public TextBox getTextBox144() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox144();
    }

    @JsonIgnore
    public TextBox getTextBox145() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox145();
    }

    @JsonIgnore
    public TextBox getTextBox146() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox146();
    }

    @JsonIgnore
    public TextBox getTextBox147() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox147();
    }

    @JsonIgnore
    public TextBox getTextBox148() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox148();
    }

    @JsonIgnore
    public TextBox getTextBox149() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox149();
    }

    @JsonIgnore
    public TextBox getTextBox150() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox150();
    }

    @JsonIgnore
    public TextBox getTextBox151() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox151();
    }

    @JsonIgnore
    public TextBox getTextBox152() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox152();
    }

    @JsonIgnore
    public TextBox getTextBox153() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox153();
    }

    @JsonIgnore
    public TextBox getTextBox154() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox154();
    }

    @JsonIgnore
    public TextBox getTextBox155() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox155();
    }

    @JsonIgnore
    public TextBox getTextBox156() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox156();
    }

    @JsonIgnore
    public TextBox getTextBox157() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox157();
    }

    @JsonIgnore
    public TextBox getTextBox158() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox158();
    }

    @JsonIgnore
    public TextBox getTextBox159() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox159();
    }

    @JsonIgnore
    public TextBox getTextBox160() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox160();
    }

    @JsonIgnore
    public TextBox getTextBox161() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox161();
    }

    @JsonIgnore
    public TextBox getTextBox162() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox162();
    }

    @JsonIgnore
    public TextBox getTextBox163() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox163();
    }

    @JsonIgnore
    public TextBox getTextBox164() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox164();
    }

    @JsonIgnore
    public TextBox getTextBox165() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox165();
    }

    @JsonIgnore
    public TextBox getTextBox166() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox166();
    }

    @JsonIgnore
    public TextBox getTextBox167() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox167();
    }

    @JsonIgnore
    public TextBox getTextBox168() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox168();
    }

    @JsonIgnore
    public TextBox getTextBox169() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox169();
    }

    @JsonIgnore
    public TextBox getTextBox170() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox170();
    }

    @JsonIgnore
    public TextBox getTextBox171() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox171();
    }

    @JsonIgnore
    public TextBox getTextBox172() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox172();
    }

    @JsonIgnore
    public TextBox getTextBox173() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox173();
    }

    @JsonIgnore
    public TextBox getTextBox174() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox174();
    }

    @JsonIgnore
    public TextBox getTextBox175() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox175();
    }

    @JsonIgnore
    public TextBox getTextBox176() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox176();
    }

    @JsonIgnore
    public TextBox getTextBox177() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox177();
    }

    @JsonIgnore
    public TextBox getTextBox178() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox178();
    }

    @JsonIgnore
    public TextBox getTextBox179() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox179();
    }

    @JsonIgnore
    public TextBox getTextBox180() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox180();
    }

    @JsonIgnore
    public TextBox getTextBox181() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox181();
    }

    @JsonIgnore
    public TextBox getTextBox182() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox182();
    }

    @JsonIgnore
    public TextBox getTextBox183() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox183();
    }

    @JsonIgnore
    public TextBox getTextBox184() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox184();
    }

    @JsonIgnore
    public TextBox getTextBox185() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox185();
    }

    @JsonIgnore
    public TextBox getTextBox186() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox186();
    }

    @JsonIgnore
    public TextBox getTextBox187() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox187();
    }

    @JsonIgnore
    public TextBox getTextBox188() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox188();
    }

    @JsonIgnore
    public TextBox getTextBox189() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox189();
    }

    @JsonIgnore
    public TextBox getTextBox190() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox190();
    }

    @JsonIgnore
    public TextBox getTextBox191() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox191();
    }

    @JsonIgnore
    public TextBox getTextBox192() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox192();
    }

    @JsonIgnore
    public TextBox getTextBox193() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox193();
    }

    @JsonIgnore
    public TextBox getTextBox194() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox194();
    }

    @JsonIgnore
    public TextBox getTextBox195() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox195();
    }

    @JsonIgnore
    public TextBox getTextBox196() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox196();
    }

    @JsonIgnore
    public TextBox getTextBox197() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox197();
    }

    @JsonIgnore
    public TextBox getTextBox198() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox198();
    }

    @JsonIgnore
    public TextBox getTextBox199() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox199();
    }

    @JsonIgnore
    public TextBox getTextBox200() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox200();
    }

    @JsonIgnore
    public TextBox getTextBox201() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox201();
    }

    @JsonIgnore
    public TextBox getTextBox202() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox202();
    }

    @JsonIgnore
    public TextBox getTextBox203() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox203();
    }

    @JsonIgnore
    public TextBox getTextBox204() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox204();
    }

    @JsonIgnore
    public TextBox getTextBox205() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox205();
    }

    @JsonIgnore
    public TextBox getTextBox206() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox206();
    }

    @JsonIgnore
    public TextBox getTextBox207() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox207();
    }

    @JsonIgnore
    public TextBox getTextBox208() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox208();
    }

    @JsonIgnore
    public TextBox getTextBox209() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox209();
    }

    @JsonIgnore
    public TextBox getTextBox210() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox210();
    }

    @JsonIgnore
    public TextBox getTextBox211() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox211();
    }

    @JsonIgnore
    public TextBox getTextBox212() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox212();
    }

    @JsonIgnore
    public TextBox getTextBox213() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox213();
    }

    @JsonIgnore
    public TextBox getTextBox214() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox214();
    }

    @JsonIgnore
    public TextBox getTextBox215() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox215();
    }

    @JsonIgnore
    public TextBox getTextBox216() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox216();
    }

    @JsonIgnore
    public TextBox getTextBox217() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox217();
    }

    @JsonIgnore
    public TextBox getTextBox218() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox218();
    }

    @JsonIgnore
    public TextBox getTextBox219() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox219();
    }

    @JsonIgnore
    public TextBox getTextBox220() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox220();
    }

    @JsonIgnore
    public TextBox getTextBox221() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox221();
    }

    @JsonIgnore
    public TextBox getTextBox222() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox222();
    }

    @JsonIgnore
    public TextBox getTextBox223() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox223();
    }

    @JsonIgnore
    public TextBox getTextBox224() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox224();
    }

    @JsonIgnore
    public TextBox getTextBox225() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox225();
    }

    @JsonIgnore
    public TextBox getTextBox226() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox226();
    }

    @JsonIgnore
    public TextBox getTextBox227() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox227();
    }

    @JsonIgnore
    public TextBox getTextBox228() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox228();
    }

    @JsonIgnore
    public TextBox getTextBox229() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox229();
    }

    @JsonIgnore
    public TextBox getTextBox230() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox230();
    }

    @JsonIgnore
    public TextBox getTextBox231() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox231();
    }

    @JsonIgnore
    public TextBox getTextBox232() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox232();
    }

    @JsonIgnore
    public TextBox getTextBox233() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox233();
    }

    @JsonIgnore
    public TextBox getTextBox234() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox234();
    }

    @JsonIgnore
    public TextBox getTextBox235() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox235();
    }

    @JsonIgnore
    public TextBox getTextBox236() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox236();
    }

    @JsonIgnore
    public TextBox getTextBox237() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox237();
    }

    @JsonIgnore
    public TextBox getTextBox238() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox238();
    }

    @JsonIgnore
    public TextBox getTextBox239() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox239();
    }

    @JsonIgnore
    public TextBox getTextBox240() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox240();
    }

    @JsonIgnore
    public TextBox getTextBox241() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox241();
    }

    @JsonIgnore
    public TextBox getTextBox242() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox242();
    }

    @JsonIgnore
    public TextBox getTextBox243() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox243();
    }

    @JsonIgnore
    public TextBox getTextBox244() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox244();
    }

    @JsonIgnore
    public TextBox getTextBox245() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox245();
    }

    @JsonIgnore
    public TextBox getTextBox246() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox246();
    }

    @JsonIgnore
    public TextBox getTextBox247() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox247();
    }

    @JsonIgnore
    public TextBox getTextBox248() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox248();
    }

    @JsonIgnore
    public TextBox getTextBox249() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox249();
    }

    @JsonIgnore
    public TextBox getTextBox250() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox250();
    }

    @JsonIgnore
    public TextBox getTextBox251() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox251();
    }

    @JsonIgnore
    public TextBox getTextBox252() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox252();
    }

    @JsonIgnore
    public TextBox getTextBox253() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox253();
    }

    @JsonIgnore
    public TextBox getTextBox254() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox254();
    }

    @JsonIgnore
    public TextBox getTextBox255() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox255();
    }

    @JsonIgnore
    public TextBox getTextBox256() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox256();
    }

    @JsonIgnore
    public TextBox getTextBox257() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox257();
    }

    @JsonIgnore
    public TextBox getTextBox258() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox258();
    }

    @JsonIgnore
    public TextBox getTextBox259() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox259();
    }

    @JsonIgnore
    public TextBox getTextBox260() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox260();
    }

    @JsonIgnore
    public TextBox getTextBox261() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox261();
    }

    @JsonIgnore
    public TextBox getTextBox262() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox262();
    }

    @JsonIgnore
    public TextBox getTextBox263() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox263();
    }

    @JsonIgnore
    public TextBox getTextBox264() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox264();
    }

    @JsonIgnore
    public TextBox getTextBox265() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox265();
    }

    @JsonIgnore
    public TextBox getTextBox266() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox266();
    }

    @JsonIgnore
    public TextBox getTextBox267() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox267();
    }

    @JsonIgnore
    public TextBox getTextBox268() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox268();
    }

    @JsonIgnore
    public TextBox getTextBox269() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox269();
    }

    @JsonIgnore
    public TextBox getTextBox270() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox270();
    }

    @JsonIgnore
    public TextBox getTextBox271() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox271();
    }

    @JsonIgnore
    public TextBox getTextBox272() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox272();
    }

    @JsonIgnore
    public TextBox getTextBox273() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox273();
    }

    @JsonIgnore
    public TextBox getTextBox274() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox274();
    }

    @JsonIgnore
    public TextBox getTextBox275() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox275();
    }

    @JsonIgnore
    public TextBox getTextBox276() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox276();
    }

    @JsonIgnore
    public TextBox getTextBox277() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox277();
    }

    @JsonIgnore
    public TextBox getTextBox278() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox278();
    }

    @JsonIgnore
    public TextBox getTextBox279() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox279();
    }

    @JsonIgnore
    public TextBox getTextBox280() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox280();
    }

    @JsonIgnore
    public TextBox getTextBox281() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox281();
    }

    @JsonIgnore
    public TextBox getTextBox282() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox282();
    }

    @JsonIgnore
    public TextBox getTextBox283() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox283();
    }

    @JsonIgnore
    public TextBox getTextBox284() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox284();
    }

    @JsonIgnore
    public TextBox getTextBox285() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox285();
    }

    @JsonIgnore
    public TextBox getTextBox286() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox286();
    }

    @JsonIgnore
    public TextBox getTextBox287() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox287();
    }

    @JsonIgnore
    public TextBox getTextBox288() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox288();
    }

    @JsonIgnore
    public TextBox getTextBox289() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox289();
    }

    @JsonIgnore
    public TextBox getTextBox290() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox290();
    }

    @JsonIgnore
    public TextBox getTextBox291() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox291();
    }

    @JsonIgnore
    public TextBox getTextBox292() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox292();
    }

    @JsonIgnore
    public TextBox getTextBox293() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox293();
    }

    @JsonIgnore
    public TextBox getTextBox294() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox294();
    }

    @JsonIgnore
    public TextBox getTextBox295() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox295();
    }

    @JsonIgnore
    public TextBox getTextBox296() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox296();
    }

    @JsonIgnore
    public TextBox getTextBox297() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox297();
    }

    @JsonIgnore
    public TextBox getTextBox298() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox298();
    }

    @JsonIgnore
    public TextBox getTextBox299() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox299();
    }

    @JsonIgnore
    public TextBox getTextBox300() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox300();
    }

    @JsonIgnore
    public TextBox getTextBox301() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox301();
    }

    @JsonIgnore
    public TextBox getTextBox302() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox302();
    }

    @JsonIgnore
    public TextBox getTextBox303() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox303();
    }

    @JsonIgnore
    public TextBox getTextBox304() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox304();
    }

    @JsonIgnore
    public TextBox getTextBox305() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox305();
    }

    @JsonIgnore
    public TextBox getTextBox306() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox306();
    }

    @JsonIgnore
    public TextBox getTextBox307() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox307();
    }

    @JsonIgnore
    public TextBox getTextBox308() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox308();
    }

    @JsonIgnore
    public TextBox getTextBox309() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox309();
    }

    @JsonIgnore
    public TextBox getTextBox310() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox310();
    }

    @JsonIgnore
    public TextBox getTextBox311() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox311();
    }

    @JsonIgnore
    public TextBox getTextBox312() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox312();
    }

    @JsonIgnore
    public TextBox getTextBox313() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox313();
    }

    @JsonIgnore
    public TextBox getTextBox314() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox314();
    }

    @JsonIgnore
    public TextBox getTextBox315() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox315();
    }

    @JsonIgnore
    public TextBox getTextBox316() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox316();
    }

    @JsonIgnore
    public TextBox getTextBox317() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox317();
    }

    @JsonIgnore
    public TextBox getTextBox318() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox318();
    }

    @JsonIgnore
    public TextBox getTextBox319() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox319();
    }

    @JsonIgnore
    public TextBox getTextBox320() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox320();
    }

    @JsonIgnore
    public TextBox getTextBox321() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox321();
    }

    @JsonIgnore
    public TextBox getTextBox322() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox322();
    }

    @JsonIgnore
    public TextBox getTextBox323() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox323();
    }

    @JsonIgnore
    public TextBox getTextBox324() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox324();
    }

    @JsonIgnore
    public TextBox getTextBox325() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox325();
    }

    @JsonIgnore
    public TextBox getTextBox326() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox326();
    }

    @JsonIgnore
    public TextBox getTextBox327() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox327();
    }

    @JsonIgnore
    public TextBox getTextBox328() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox328();
    }

    @JsonIgnore
    public TextBox getTextBox329() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox329();
    }

    @JsonIgnore
    public TextBox getTextBox330() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox330();
    }

    @JsonIgnore
    public TextBox getTextBox331() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox331();
    }

    @JsonIgnore
    public TextBox getTextBox332() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox332();
    }

    @JsonIgnore
    public TextBox getTextBox333() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox333();
    }

    @JsonIgnore
    public TextBox getTextBox334() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox334();
    }

    @JsonIgnore
    public TextBox getTextBox335() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox335();
    }

    @JsonIgnore
    public TextBox getTextBox336() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox336();
    }

    @JsonIgnore
    public TextBox getTextBox337() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox337();
    }

    @JsonIgnore
    public TextBox getTextBox338() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox338();
    }

    @JsonIgnore
    public TextBox getTextBox339() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox339();
    }

    @JsonIgnore
    public TextBox getTextBox340() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox340();
    }

    @JsonIgnore
    public TextBox getTextBox341() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox341();
    }

    @JsonIgnore
    public TextBox getTextBox342() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox342();
    }

    @JsonIgnore
    public TextBox getTextBox343() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox343();
    }

    @JsonIgnore
    public TextBox getTextBox344() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox344();
    }

    @JsonIgnore
    public TextBox getTextBox345() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox345();
    }

    @JsonIgnore
    public TextBox getTextBox346() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox346();
    }

    @JsonIgnore
    public TextBox getTextBox347() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox347();
    }

    @JsonIgnore
    public TextBox getTextBox348() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox348();
    }

    @JsonIgnore
    public TextBox getTextBox349() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox349();
    }

    @JsonIgnore
    public TextBox getTextBox350() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox350();
    }

    @JsonIgnore
    public TextBox getTextBox351() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox351();
    }

    @JsonIgnore
    public TextBox getTextBox352() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox352();
    }

    @JsonIgnore
    public TextBox getTextBox353() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox353();
    }

    @JsonIgnore
    public TextBox getTextBox354() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox354();
    }

    @JsonIgnore
    public TextBox getTextBox355() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox355();
    }

    @JsonIgnore
    public TextBox getTextBox356() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox356();
    }

    @JsonIgnore
    public TextBox getTextBox357() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox357();
    }

    @JsonIgnore
    public TextBox getTextBox358() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox358();
    }

    @JsonIgnore
    public TextBox getTextBox359() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox359();
    }

    @JsonIgnore
    public TextBox getTextBox360() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox360();
    }

    @JsonIgnore
    public TextBox getTextBox361() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox361();
    }

    @JsonIgnore
    public TextBox getTextBox362() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox362();
    }

    @JsonIgnore
    public TextBox getTextBox363() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox363();
    }

    @JsonIgnore
    public TextBox getTextBox364() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox364();
    }

    @JsonIgnore
    public TextBox getTextBox365() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox365();
    }

    @JsonIgnore
    public TextBox getTextBox366() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox366();
    }

    @JsonIgnore
    public TextBox getTextBox367() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox367();
    }

    @JsonIgnore
    public TextBox getTextBox368() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox368();
    }

    @JsonIgnore
    public TextBox getTextBox369() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox369();
    }

    @JsonIgnore
    public TextBox getTextBox370() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox370();
    }

    @JsonIgnore
    public TextBox getTextBox371() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox371();
    }

    @JsonIgnore
    public TextBox getTextBox372() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox372();
    }

    @JsonIgnore
    public TextBox getTextBox373() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox373();
    }

    @JsonIgnore
    public TextBox getTextBox374() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox374();
    }

    @JsonIgnore
    public TextBox getTextBox375() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox375();
    }

    @JsonIgnore
    public TextBox getTextBox376() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox376();
    }

    @JsonIgnore
    public TextBox getTextBox377() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox377();
    }

    @JsonIgnore
    public TextBox getTextBox378() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox378();
    }

    @JsonIgnore
    public TextBox getTextBox379() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox379();
    }

    @JsonIgnore
    public TextBox getTextBox380() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox380();
    }

    @JsonIgnore
    public TextBox getTextBox381() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox381();
    }

    @JsonIgnore
    public TextBox getTextBox382() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox382();
    }

    @JsonIgnore
    public TextBox getTextBox383() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox383();
    }

    @JsonIgnore
    public TextBox getTextBox384() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox384();
    }

    @JsonIgnore
    public TextBox getTextBox385() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox385();
    }

    @JsonIgnore
    public TextBox getTextBox386() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox386();
    }

    @JsonIgnore
    public TextBox getTextBox387() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox387();
    }

    @JsonIgnore
    public TextBox getTextBox388() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox388();
    }

    @JsonIgnore
    public TextBox getTextBox389() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox389();
    }

    @JsonIgnore
    public TextBox getTextBox390() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox390();
    }

    @JsonIgnore
    public TextBox getTextBox391() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox391();
    }

    @JsonIgnore
    public TextBox getTextBox392() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox392();
    }

    @JsonIgnore
    public TextBox getTextBox393() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox393();
    }

    @JsonIgnore
    public TextBox getTextBox394() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox394();
    }

    @JsonIgnore
    public TextBox getTextBox395() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox395();
    }

    @JsonIgnore
    public TextBox getTextBox396() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox396();
    }

    @JsonIgnore
    public TextBox getTextBox397() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox397();
    }

    @JsonIgnore
    public TextBox getTextBox398() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox398();
    }

    @JsonIgnore
    public TextBox getTextBox399() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox399();
    }

    @JsonIgnore
    public TextBox getTextBox400() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox400();
    }

    @JsonIgnore
    public TextBox getTextBox401() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox401();
    }

    @JsonIgnore
    public TextBox getTextBox402() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox402();
    }

    @JsonIgnore
    public TextBox getTextBox403() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox403();
    }

    @JsonIgnore
    public TextBox getTextBox404() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox404();
    }

    @JsonIgnore
    public TextBox getTextBox405() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox405();
    }

    @JsonIgnore
    public TextBox getTextBox406() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox406();
    }

    @JsonIgnore
    public TextBox getTextBox407() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox407();
    }

    @JsonIgnore
    public TextBox getTextBox408() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox408();
    }

    @JsonIgnore
    public TextBox getTextBox409() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox409();
    }

    @JsonIgnore
    public tpl2Div getTpl2() {
        return this.getTcMain().getTpl2();
    }

    @JsonIgnore
    public void setTpl2(tpl2Div tpl2) {
        this.getTcMain().setTpl2(tpl2);
    }

    @JsonIgnore
    public tbl2Div getTbl2() {
        return this.getTcMain().getTpl2().getTbl2();
    }

    @JsonIgnore
    public void setTbl2(tbl2Div tbl2) {
        this.getTcMain().getTpl2().setTbl2(tbl2);
    }

    @JsonIgnore
    public TextBox getTextBox410() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox410();
    }

    @JsonIgnore
    public TextBox getTextBox411() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox411();
    }

    @JsonIgnore
    public TextBox getTextBox412() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox412();
    }

    @JsonIgnore
    public TextBox getTextBox413() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox413();
    }

    @JsonIgnore
    public TextBox getTextBox414() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox414();
    }

    @JsonIgnore
    public TextBox getTextBox415() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox415();
    }

    @JsonIgnore
    public TextBox getTextBox416() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox416();
    }

    @JsonIgnore
    public TextBox getTextBox417() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox417();
    }

    @JsonIgnore
    public TextBox getTextBox418() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox418();
    }

    @JsonIgnore
    public TextBox getTextBox419() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox419();
    }

    @JsonIgnore
    public TextBox getTextBox420() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox420();
    }

    @JsonIgnore
    public TextBox getTextBox421() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox421();
    }

    @JsonIgnore
    public TextBox getTextBox422() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox422();
    }

    @JsonIgnore
    public TextBox getTextBox423() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox423();
    }

    @JsonIgnore
    public TextBox getTextBox424() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox424();
    }

    @JsonIgnore
    public TextBox getTextBox425() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox425();
    }

    @JsonIgnore
    public TextBox getTextBox426() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox426();
    }

    @JsonIgnore
    public TextBox getTextBox427() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox427();
    }

    @JsonIgnore
    public TextBox getTextBox428() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox428();
    }

    @JsonIgnore
    public TextBox getTextBox429() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox429();
    }

    @JsonIgnore
    public TextBox getTextBox430() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox430();
    }

    @JsonIgnore
    public TextBox getTextBox431() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox431();
    }

    @JsonIgnore
    public TextBox getTextBox432() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox432();
    }

    @JsonIgnore
    public TextBox getTextBox433() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox433();
    }

    @JsonIgnore
    public TextBox getTextBox434() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox434();
    }

    @JsonIgnore
    public TextBox getTextBox435() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox435();
    }

    @JsonIgnore
    public TextBox getTextBox436() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox436();
    }

    @JsonIgnore
    public TextBox getTextBox437() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox437();
    }

    @JsonIgnore
    public TextBox getTextBox438() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox438();
    }

    @JsonIgnore
    public TextBox getTextBox439() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox439();
    }

    @JsonIgnore
    public TextBox getTextBox440() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox440();
    }

    @JsonIgnore
    public TextBox getTextBox441() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox441();
    }

    @JsonIgnore
    public TextBox getTextBox442() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox442();
    }

    @JsonIgnore
    public TextBox getTextBox443() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox443();
    }

    @JsonIgnore
    public TextBox getTextBox444() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox444();
    }

    @JsonIgnore
    public TextBox getTextBox445() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox445();
    }

    @JsonIgnore
    public TextBox getTextBox446() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox446();
    }

    @JsonIgnore
    public TextBox getTextBox447() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox447();
    }

    @JsonIgnore
    public TextBox getTextBox448() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox448();
    }

    @JsonIgnore
    public TextBox getTextBox449() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox449();
    }

    @JsonIgnore
    public TextBox getTextBox450() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox450();
    }

    @JsonIgnore
    public TextBox getTextBox451() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox451();
    }

    @JsonIgnore
    public TextBox getTextBox452() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox452();
    }

    @JsonIgnore
    public TextBox getTextBox453() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox453();
    }

    @JsonIgnore
    public TextBox getTextBox454() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox454();
    }

    @JsonIgnore
    public TextBox getTextBox455() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox455();
    }

    @JsonIgnore
    public TextBox getTextBox456() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox456();
    }

    @JsonIgnore
    public TextBox getTextBox457() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox457();
    }

    @JsonIgnore
    public TextBox getTextBox458() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox458();
    }

    @JsonIgnore
    public TextBox getTextBox459() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox459();
    }

    @JsonIgnore
    public TextBox getTextBox460() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox460();
    }

    @JsonIgnore
    public TextBox getTextBox461() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox461();
    }

    @JsonIgnore
    public TextBox getTextBox462() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox462();
    }

    @JsonIgnore
    public TextBox getTextBox463() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox463();
    }

    @JsonIgnore
    public TextBox getTextBox464() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox464();
    }

    @JsonIgnore
    public TextBox getTextBox465() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox465();
    }

    @JsonIgnore
    public TextBox getTextBox466() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox466();
    }

    @JsonIgnore
    public TextBox getTextBox467() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox467();
    }

    @JsonIgnore
    public TextBox getTextBox468() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox468();
    }

    @JsonIgnore
    public TextBox getTextBox469() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox469();
    }

    @JsonIgnore
    public TextBox getTextBox470() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox470();
    }

    @JsonIgnore
    public TextBox getTextBox471() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox471();
    }

    @JsonIgnore
    public TextBox getTextBox472() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox472();
    }

    @JsonIgnore
    public TextBox getTextBox473() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox473();
    }

    @JsonIgnore
    public TextBox getTextBox474() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox474();
    }

    @JsonIgnore
    public TextBox getTextBox475() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox475();
    }

    @JsonIgnore
    public TextBox getTextBox476() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox476();
    }

    @JsonIgnore
    public TextBox getTextBox477() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox477();
    }

    @JsonIgnore
    public TextBox getTextBox478() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox478();
    }

    @JsonIgnore
    public TextBox getTextBox479() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox479();
    }

    @JsonIgnore
    public TextBox getTextBox480() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox480();
    }

    @JsonIgnore
    public TextBox getTextBox481() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox481();
    }

    @JsonIgnore
    public TextBox getTextBox482() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox482();
    }

    @JsonIgnore
    public TextBox getTextBox483() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox483();
    }

    @JsonIgnore
    public TextBox getTextBox484() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox484();
    }

    @JsonIgnore
    public TextBox getTextBox485() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox485();
    }

    @JsonIgnore
    public TextBox getTextBox486() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox486();
    }

    @JsonIgnore
    public TextBox getTextBox487() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox487();
    }

    @JsonIgnore
    public TextBox getTextBox488() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox488();
    }

    @JsonIgnore
    public TextBox getTextBox489() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox489();
    }

    @JsonIgnore
    public TextBox getTextBox490() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox490();
    }

    @JsonIgnore
    public TextBox getTextBox491() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox491();
    }

    @JsonIgnore
    public TextBox getTextBox492() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox492();
    }

    @JsonIgnore
    public TextBox getTextBox493() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox493();
    }

    @JsonIgnore
    public TextBox getTextBox494() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox494();
    }

    @JsonIgnore
    public TextBox getTextBox495() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox495();
    }

    @JsonIgnore
    public TextBox getTextBox496() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox496();
    }

    @JsonIgnore
    public TextBox getTextBox497() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox497();
    }

    @JsonIgnore
    public TextBox getTextBox498() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox498();
    }

    @JsonIgnore
    public TextBox getTextBox499() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox499();
    }

    @JsonIgnore
    public TextBox getTextBox500() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox500();
    }

    @JsonIgnore
    public TextBox getTextBox501() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox501();
    }

    @JsonIgnore
    public TextBox getTextBox502() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox502();
    }

    @JsonIgnore
    public TextBox getTextBox503() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox503();
    }

    @JsonIgnore
    public TextBox getTextBox504() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox504();
    }

    @JsonIgnore
    public TextBox getTextBox505() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox505();
    }

    @JsonIgnore
    public TextBox getTextBox506() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox506();
    }

    @JsonIgnore
    public TextBox getTextBox507() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox507();
    }

    @JsonIgnore
    public TextBox getTextBox508() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox508();
    }

    @JsonIgnore
    public TextBox getTextBox509() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox509();
    }

    @JsonIgnore
    public TextBox getTextBox510() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox510();
    }

    @JsonIgnore
    public TextBox getTextBox511() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox511();
    }

    @JsonIgnore
    public TextBox getTextBox512() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox512();
    }

    @JsonIgnore
    public TextBox getTextBox513() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox513();
    }

    @JsonIgnore
    public TextBox getTextBox514() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox514();
    }

    @JsonIgnore
    public TextBox getTextBox515() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox515();
    }

    @JsonIgnore
    public TextBox getTextBox516() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox516();
    }

    @JsonIgnore
    public TextBox getTextBox517() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox517();
    }

    @JsonIgnore
    public TextBox getTextBox518() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox518();
    }

    @JsonIgnore
    public TextBox getTextBox519() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox519();
    }

    @JsonIgnore
    public TextBox getTextBox520() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox520();
    }

    @JsonIgnore
    public TextBox getTextBox521() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox521();
    }

    @JsonIgnore
    public TextBox getTextBox522() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox522();
    }

    @JsonIgnore
    public TextBox getTextBox523() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox523();
    }

    @JsonIgnore
    public TextBox getTextBox524() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox524();
    }

    @JsonIgnore
    public TextBox getTextBox525() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox525();
    }

    @JsonIgnore
    public TextBox getTextBox526() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox526();
    }

    @JsonIgnore
    public TextBox getTextBox527() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox527();
    }

    @JsonIgnore
    public TextBox getTextBox528() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox528();
    }

    @JsonIgnore
    public TextBox getTextBox529() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox529();
    }

    @JsonIgnore
    public TextBox getTextBox530() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox530();
    }

    @JsonIgnore
    public TextBox getTextBox531() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox531();
    }

    @JsonIgnore
    public TextBox getTextBox532() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox532();
    }

    @JsonIgnore
    public TextBox getTextBox533() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox533();
    }

    @JsonIgnore
    public TextBox getTextBox534() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox534();
    }

    @JsonIgnore
    public TextBox getTextBox535() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox535();
    }

    @JsonIgnore
    public TextBox getTextBox536() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox536();
    }

    @JsonIgnore
    public TextBox getTextBox537() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox537();
    }

    @JsonIgnore
    public TextBox getTextBox538() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox538();
    }

    @JsonIgnore
    public TextBox getTextBox539() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox539();
    }

    @JsonIgnore
    public TextBox getTextBox540() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox540();
    }

    @JsonIgnore
    public TextBox getTextBox541() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox541();
    }

    @JsonIgnore
    public TextBox getTextBox542() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox542();
    }

    @JsonIgnore
    public TextBox getTextBox543() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox543();
    }

    @JsonIgnore
    public TextBox getTextBox544() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox544();
    }

    @JsonIgnore
    public TextBox getTextBox545() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox545();
    }

    @JsonIgnore
    public TextBox getTextBox546() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox546();
    }

    @JsonIgnore
    public TextBox getTextBox547() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox547();
    }

    @JsonIgnore
    public TextBox getTextBox548() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox548();
    }

    @JsonIgnore
    public TextBox getTextBox549() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox549();
    }

    @JsonIgnore
    public TextBox getTextBox550() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox550();
    }

    @JsonIgnore
    public TextBox getTextBox551() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox551();
    }

    @JsonIgnore
    public TextBox getTextBox552() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox552();
    }

    @JsonIgnore
    public TextBox getTextBox553() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox553();
    }

    @JsonIgnore
    public TextBox getTextBox554() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox554();
    }

    @JsonIgnore
    public TextBox getTextBox555() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox555();
    }

    @JsonIgnore
    public TextBox getTextBox556() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox556();
    }

    @JsonIgnore
    public TextBox getTextBox557() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox557();
    }

    @JsonIgnore
    public TextBox getTextBox558() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox558();
    }

    @JsonIgnore
    public TextBox getTextBox559() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox559();
    }

    @JsonIgnore
    public TextBox getTextBox560() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox560();
    }

    @JsonIgnore
    public TextBox getTextBox561() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox561();
    }

    @JsonIgnore
    public TextBox getTextBox562() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox562();
    }

    @JsonIgnore
    public TextBox getTextBox563() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox563();
    }

    @JsonIgnore
    public TextBox getTextBox564() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox564();
    }

    @JsonIgnore
    public TextBox getTextBox565() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox565();
    }

    @JsonIgnore
    public TextBox getTextBox566() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox566();
    }

    @JsonIgnore
    public TextBox getTextBox567() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox567();
    }

    @JsonIgnore
    public TextBox getTextBox568() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox568();
    }

    @JsonIgnore
    public TextBox getTextBox569() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox569();
    }

    @JsonIgnore
    public TextBox getTextBox570() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox570();
    }

    @JsonIgnore
    public TextBox getTextBox571() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox571();
    }

    @JsonIgnore
    public TextBox getTextBox572() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox572();
    }

    @JsonIgnore
    public TextBox getTextBox573() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox573();
    }

    @JsonIgnore
    public TextBox getTextBox574() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox574();
    }

    @JsonIgnore
    public TextBox getTextBox575() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox575();
    }

    @JsonIgnore
    public TextBox getTextBox576() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox576();
    }

    @JsonIgnore
    public TextBox getTextBox577() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox577();
    }

    @JsonIgnore
    public TextBox getTextBox578() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox578();
    }

    @JsonIgnore
    public TextBox getTextBox579() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox579();
    }

    @JsonIgnore
    public TextBox getTextBox580() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox580();
    }

    @JsonIgnore
    public TextBox getTextBox581() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox581();
    }

    @JsonIgnore
    public TextBox getTextBox582() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox582();
    }

    @JsonIgnore
    public TextBox getTextBox583() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox583();
    }

    @JsonIgnore
    public TextBox getTextBox584() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox584();
    }

    @JsonIgnore
    public TextBox getTextBox585() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox585();
    }

    @JsonIgnore
    public TextBox getTextBox608() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox608();
    }

    @JsonIgnore
    public TextBox getTextBox609() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox609();
    }

    @JsonIgnore
    public TextBox getTextBox610() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox610();
    }

    @JsonIgnore
    public TextBox getTextBox611() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox611();
    }

    @JsonIgnore
    public TextBox getTextBox612() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox612();
    }

    @JsonIgnore
    public TextBox getTextBox613() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox613();
    }

    @JsonIgnore
    public TextBox getTextBox614() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox614();
    }

    @JsonIgnore
    public TextBox getTextBox615() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox615();
    }

    @JsonIgnore
    public TextBox getTextBox616() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox616();
    }

    @JsonIgnore
    public TextBox getTextBox617() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox617();
    }

    @JsonIgnore
    public TextBox getTextBox618() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox618();
    }

    @JsonIgnore
    public TextBox getTextBox619() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox619();
    }

    @JsonIgnore
    public TextBox getTextBox620() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox620();
    }

    @JsonIgnore
    public TextBox getTextBox621() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox621();
    }

    @JsonIgnore
    public TextBox getTextBox622() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox622();
    }

    @JsonIgnore
    public TextBox getTextBox623() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox623();
    }

    @JsonIgnore
    public TextBox getTextBox624() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox624();
    }

    @JsonIgnore
    public TextBox getTextBox625() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox625();
    }

    @JsonIgnore
    public TextBox getTextBox626() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox626();
    }

    @JsonIgnore
    public TextBox getTextBox627() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox627();
    }

    @JsonIgnore
    public TextBox getTextBox628() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox628();
    }

    @JsonIgnore
    public TextBox getTextBox629() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox629();
    }

    @JsonIgnore
    public TextBox getTextBox630() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox630();
    }

    @JsonIgnore
    public TextBox getTextBox631() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox631();
    }

    @JsonIgnore
    public TextBox getTextBox632() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox632();
    }

    @JsonIgnore
    public TextBox getTextBox633() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox633();
    }

    @JsonIgnore
    public TextBox getTextBox634() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox634();
    }

    @JsonIgnore
    public TextBox getTextBox635() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox635();
    }

    @JsonIgnore
    public TextBox getTextBox636() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox636();
    }

    @JsonIgnore
    public TextBox getTextBox637() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox637();
    }

    @JsonIgnore
    public TextBox getTextBox638() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox638();
    }

    @JsonIgnore
    public TextBox getTextBox639() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox639();
    }

    @JsonIgnore
    public TextBox getTextBox640() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox640();
    }

    @JsonIgnore
    public TextBox getTextBox641() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox641();
    }

    @JsonIgnore
    public TextBox getTextBox642() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox642();
    }

    @JsonIgnore
    public TextBox getTextBox643() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox643();
    }

    @JsonIgnore
    public TextBox getTextBox644() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox644();
    }

    @JsonIgnore
    public TextBox getTextBox645() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox645();
    }

    @JsonIgnore
    public TextBox getTextBox646() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox646();
    }

    @JsonIgnore
    public TextBox getTextBox647() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox647();
    }

    @JsonIgnore
    public TextBox getTextBox648() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox648();
    }

    @JsonIgnore
    public TextBox getTextBox649() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox649();
    }

    @JsonIgnore
    public TextBox getTextBox650() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox650();
    }

    @JsonIgnore
    public TextBox getTextBox651() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox651();
    }

    @JsonIgnore
    public TextBox getTextBox652() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox652();
    }

    @JsonIgnore
    public TextBox getTextBox653() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox653();
    }

    @JsonIgnore
    public TextBox getTextBox654() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox654();
    }

    @JsonIgnore
    public TextBox getTextBox655() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox655();
    }

    @JsonIgnore
    public TextBox getTextBox656() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox656();
    }

    @JsonIgnore
    public TextBox getTextBox657() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox657();
    }

    @JsonIgnore
    public TextBox getTextBox658() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox658();
    }

    @JsonIgnore
    public TextBox getTextBox659() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox659();
    }

    @JsonIgnore
    public TextBox getTextBox660() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox660();
    }

    @JsonIgnore
    public TextBox getTextBox661() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox661();
    }

    @JsonIgnore
    public TextBox getTextBox662() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox662();
    }

    @JsonIgnore
    public TextBox getTextBox663() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox663();
    }

    @JsonIgnore
    public TextBox getTextBox664() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox664();
    }

    @JsonIgnore
    public TextBox getTextBox665() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox665();
    }

    @JsonIgnore
    public TextBox getTextBox666() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox666();
    }

    @JsonIgnore
    public TextBox getTextBox667() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox667();
    }

    @JsonIgnore
    public TextBox getTextBox668() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox668();
    }

    @JsonIgnore
    public TextBox getTextBox669() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox669();
    }

    @JsonIgnore
    public TextBox getTextBox670() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox670();
    }

    @JsonIgnore
    public TextBox getTextBox671() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox671();
    }

    @JsonIgnore
    public TextBox getTextBox672() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox672();
    }

    @JsonIgnore
    public TextBox getTextBox673() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox673();
    }

    @JsonIgnore
    public TextBox getTextBox674() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox674();
    }

    @JsonIgnore
    public TextBox getTextBox675() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox675();
    }

    @JsonIgnore
    public TextBox getTextBox676() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox676();
    }

    @JsonIgnore
    public TextBox getTextBox677() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox677();
    }

    @JsonIgnore
    public TextBox getTextBox678() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox678();
    }

    @JsonIgnore
    public TextBox getTextBox679() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox679();
    }

    @JsonIgnore
    public TextBox getTextBox680() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox680();
    }

    @JsonIgnore
    public TextBox getTextBox681() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox681();
    }

    @JsonIgnore
    public TextBox getTextBox682() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox682();
    }

    @JsonIgnore
    public TextBox getTextBox683() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox683();
    }

    @JsonIgnore
    public TextBox getTextBox684() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox684();
    }

    @JsonIgnore
    public TextBox getTextBox685() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox685();
    }

    @JsonIgnore
    public TextBox getTextBox686() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox686();
    }

    @JsonIgnore
    public TextBox getTextBox687() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox687();
    }

    @JsonIgnore
    public TextBox getTextBox688() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox688();
    }

    @JsonIgnore
    public TextBox getTextBox689() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox689();
    }

    @JsonIgnore
    public TextBox getTextBox690() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox690();
    }

    @JsonIgnore
    public TextBox getTextBox691() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox691();
    }

    @JsonIgnore
    public TextBox getTextBox692() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox692();
    }

    @JsonIgnore
    public TextBox getTextBox693() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox693();
    }

    @JsonIgnore
    public TextBox getTextBox694() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox694();
    }

    @JsonIgnore
    public TextBox getTextBox695() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox695();
    }

    @JsonIgnore
    public TextBox getTextBox696() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox696();
    }

    @JsonIgnore
    public TextBox getTextBox697() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox697();
    }

    @JsonIgnore
    public TextBox getTextBox698() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox698();
    }

    @JsonIgnore
    public TextBox getTextBox699() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox699();
    }

    @JsonIgnore
    public TextBox getTextBox700() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox700();
    }

    @JsonIgnore
    public TextBox getTextBox701() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox701();
    }

    @JsonIgnore
    public TextBox getTextBox702() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox702();
    }

    @JsonIgnore
    public TextBox getTextBox703() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox703();
    }

    @JsonIgnore
    public TextBox getTextBox704() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox704();
    }

    @JsonIgnore
    public TextBox getTextBox705() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox705();
    }

    @JsonIgnore
    public TextBox getTextBox706() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox706();
    }

    @JsonIgnore
    public TextBox getTextBox707() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox707();
    }

    @JsonIgnore
    public TextBox getTextBox708() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox708();
    }

    @JsonIgnore
    public TextBox getTextBox709() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox709();
    }

    @JsonIgnore
    public TextBox getTextBox710() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox710();
    }

    @JsonIgnore
    public TextBox getTextBox711() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox711();
    }

    @JsonIgnore
    public TextBox getTextBox712() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox712();
    }

    @JsonIgnore
    public TextBox getTextBox713() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox713();
    }

    @JsonIgnore
    public TextBox getTextBox714() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox714();
    }

    @JsonIgnore
    public TextBox getTextBox715() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox715();
    }

    @JsonIgnore
    public TextBox getTextBox716() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox716();
    }

    @JsonIgnore
    public TextBox getTextBox717() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox717();
    }

    @JsonIgnore
    public TextBox getTextBox718() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox718();
    }

    @JsonIgnore
    public TextBox getTextBox719() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox719();
    }

    @JsonIgnore
    public TextBox getTextBox720() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox720();
    }

    @JsonIgnore
    public TextBox getTextBox721() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox721();
    }

    @JsonIgnore
    public TextBox getTextBox722() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox722();
    }

    @JsonIgnore
    public TextBox getTextBox723() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox723();
    }

    @JsonIgnore
    public TextBox getTextBox724() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox724();
    }

    @JsonIgnore
    public TextBox getTextBox725() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox725();
    }

    @JsonIgnore
    public TextBox getTextBox726() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox726();
    }

    @JsonIgnore
    public TextBox getTextBox727() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox727();
    }

    @JsonIgnore
    public TextBox getTextBox728() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox728();
    }

    @JsonIgnore
    public TextBox getTextBox729() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox729();
    }

    @JsonIgnore
    public TextBox getTextBox730() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox730();
    }

    @JsonIgnore
    public TextBox getTextBox731() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox731();
    }

    @JsonIgnore
    public TextBox getTextBox732() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox732();
    }

    @JsonIgnore
    public TextBox getTextBox733() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox733();
    }

    @JsonIgnore
    public TextBox getTextBox734() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox734();
    }

    @JsonIgnore
    public TextBox getTextBox735() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox735();
    }

    @JsonIgnore
    public TextBox getTextBox736() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox736();
    }

    @JsonIgnore
    public TextBox getTextBox737() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox737();
    }

    @JsonIgnore
    public TextBox getTextBox738() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox738();
    }

    @JsonIgnore
    public TextBox getTextBox739() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox739();
    }

    @JsonIgnore
    public TextBox getTextBox740() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox740();
    }

    @JsonIgnore
    public TextBox getTextBox741() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox741();
    }

    @JsonIgnore
    public TextBox getTextBox742() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox742();
    }

    @JsonIgnore
    public TextBox getTextBox743() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox743();
    }

    @JsonIgnore
    public TextBox getTextBox744() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox744();
    }

    @JsonIgnore
    public TextBox getTextBox745() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox745();
    }

    @JsonIgnore
    public TextBox getTextBox746() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox746();
    }

    @JsonIgnore
    public TextBox getTextBox747() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox747();
    }

    @JsonIgnore
    public TextBox getTextBox748() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox748();
    }

    @JsonIgnore
    public TextBox getTextBox749() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox749();
    }

    @JsonIgnore
    public TextBox getTextBox750() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox750();
    }

    @JsonIgnore
    public TextBox getTextBox751() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox751();
    }

    @JsonIgnore
    public TextBox getTextBox752() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox752();
    }

    @JsonIgnore
    public TextBox getTextBox753() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox753();
    }

    @JsonIgnore
    public TextBox getTextBox754() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox754();
    }

    @JsonIgnore
    public TextBox getTextBox755() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox755();
    }

    @JsonIgnore
    public TextBox getTextBox756() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox756();
    }

    @JsonIgnore
    public TextBox getTextBox757() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox757();
    }

    @JsonIgnore
    public TextBox getTextBox758() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox758();
    }

    @JsonIgnore
    public TextBox getTextBox759() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox759();
    }

    @JsonIgnore
    public TextBox getTextBox760() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox760();
    }

    @JsonIgnore
    public TextBox getTextBox761() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox761();
    }

    @JsonIgnore
    public TextBox getTextBox762() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox762();
    }

    @JsonIgnore
    public TextBox getTextBox763() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox763();
    }

    @JsonIgnore
    public TextBox getTextBox764() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox764();
    }

    @JsonIgnore
    public TextBox getTextBox765() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox765();
    }

    @JsonIgnore
    public TextBox getTextBox766() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox766();
    }

    @JsonIgnore
    public TextBox getTextBox767() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox767();
    }

    @JsonIgnore
    public TextBox getTextBox768() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox768();
    }

    @JsonIgnore
    public TextBox getTextBox769() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox769();
    }

    @JsonIgnore
    public TextBox getTextBox770() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox770();
    }

    @JsonIgnore
    public TextBox getTextBox771() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox771();
    }

    @JsonIgnore
    public TextBox getTextBox772() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox772();
    }

    @JsonIgnore
    public TextBox getTextBox773() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox773();
    }

    @JsonIgnore
    public TextBox getTextBox774() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox774();
    }

    @JsonIgnore
    public TextBox getTextBox775() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox775();
    }

    @JsonIgnore
    public TextBox getTextBox776() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox776();
    }

    @JsonIgnore
    public TextBox getTextBox777() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox777();
    }

    @JsonIgnore
    public TextBox getTextBox778() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox778();
    }

    @JsonIgnore
    public TextBox getTextBox779() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox779();
    }

    @JsonIgnore
    public TextBox getTextBox780() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox780();
    }

    @JsonIgnore
    public TextBox getTextBox781() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox781();
    }

    @JsonIgnore
    public TextBox getTextBox782() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox782();
    }

    @JsonIgnore
    public TextBox getTextBox783() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox783();
    }

    @JsonIgnore
    public TextBox getTextBox784() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox784();
    }

    @JsonIgnore
    public TextBox getTextBox785() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox785();
    }

    @JsonIgnore
    public TextBox getTextBox786() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox786();
    }

    @JsonIgnore
    public TextBox getTextBox787() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox787();
    }

    @JsonIgnore
    public TextBox getTextBox788() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox788();
    }

    @JsonIgnore
    public TextBox getTextBox789() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox789();
    }

    @JsonIgnore
    public TextBox getTextBox790() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox790();
    }

    @JsonIgnore
    public TextBox getTextBox791() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox791();
    }

    @JsonIgnore
    public TextBox getTextBox792() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox792();
    }

    @JsonIgnore
    public TextBox getTextBox793() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox793();
    }

    @JsonIgnore
    public TextBox getTextBox794() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox794();
    }

    @JsonIgnore
    public TextBox getTextBox795() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox795();
    }

    @JsonIgnore
    public TextBox getTextBox796() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox796();
    }

    @JsonIgnore
    public TextBox getTextBox797() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox797();
    }

    @JsonIgnore
    public TextBox getTextBox798() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox798();
    }

    @JsonIgnore
    public TextBox getTextBox799() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox799();
    }

    @JsonIgnore
    public TextBox getTextBox800() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox800();
    }

    @JsonIgnore
    public TextBox getTextBox801() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox801();
    }

    @JsonIgnore
    public TextBox getTextBox802() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox802();
    }

    @JsonIgnore
    public TextBox getTextBox803() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox803();
    }

    @JsonIgnore
    public TextBox getTextBox804() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox804();
    }

    @JsonIgnore
    public TextBox getTextBox805() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox805();
    }

    @JsonIgnore
    public TextBox getTextBox806() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox806();
    }

    @JsonIgnore
    public TextBox getTextBox807() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox807();
    }

    @JsonIgnore
    public TextBox getTextBox808() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox808();
    }

    @JsonIgnore
    public TextBox getTextBox809() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox809();
    }

    @JsonIgnore
    public TextBox getTextBox810() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox810();
    }

    @JsonIgnore
    public TextBox getTextBox811() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox811();
    }

    @JsonIgnore
    public TextBox getTextBox812() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox812();
    }

    @JsonIgnore
    public TextBox getTextBox813() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox813();
    }

    @JsonIgnore
    public TextBox getTextBox814() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox814();
    }

    @JsonIgnore
    public TextBox getTextBox815() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox815();
    }

    @JsonIgnore
    public TextBox getTextBox816() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox816();
    }

    @JsonIgnore
    public TextBox getTextBox817() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox817();
    }

    @JsonIgnore
    public TextBox getTextBox818() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox818();
    }

    @JsonIgnore
    public tpl3Div getTpl3() {
        return this.getTcMain().getTpl3();
    }

    @JsonIgnore
    public void setTpl3(tpl3Div tpl3) {
        this.getTcMain().setTpl3(tpl3);
    }

    @JsonIgnore
    public tbl3Div getTbl3() {
        return this.getTcMain().getTpl3().getTbl3();
    }

    @JsonIgnore
    public void setTbl3(tbl3Div tbl3) {
        this.getTcMain().getTpl3().setTbl3(tbl3);
    }

    @JsonIgnore
    public TextBox getTextBox586() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox586();
    }

    @JsonIgnore
    public TextBox getTextBox587() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox587();
    }

    @JsonIgnore
    public TextBox getTextBox588() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox588();
    }

    @JsonIgnore
    public TextBox getTextBox589() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox589();
    }

    @JsonIgnore
    public TextBox getTextBox590() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox590();
    }

    @JsonIgnore
    public TextBox getTextBox591() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox591();
    }

    @JsonIgnore
    public TextBox getTextBox592() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox592();
    }

    @JsonIgnore
    public TextBox getTextBox593() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox593();
    }

    @JsonIgnore
    public TextBox getTextBox594() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox594();
    }

    @JsonIgnore
    public TextBox getTextBox595() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox595();
    }

    @JsonIgnore
    public TextBox getTextBox596() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox596();
    }

    @JsonIgnore
    public TextBox getTextBox597() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox597();
    }

    @JsonIgnore
    public TextBox getTextBox598() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox598();
    }

    @JsonIgnore
    public TextBox getTextBox599() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox599();
    }

    @JsonIgnore
    public TextBox getTextBox600() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox600();
    }

    @JsonIgnore
    public TextBox getTextBox601() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox601();
    }

    @JsonIgnore
    public TextBox getTextBox602() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox602();
    }

    @JsonIgnore
    public TextBox getTextBox603() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox603();
    }

    @JsonIgnore
    public TextBox getTextBox604() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox604();
    }

    @JsonIgnore
    public TextBox getTextBox605() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox605();
    }

    @JsonIgnore
    public TextBox getTextBox606() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox606();
    }

    @JsonIgnore
    public TextBox getTextBox607() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox607();
    }

    @JsonIgnore
    public TextBox getTextBox819() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox819();
    }

    @JsonIgnore
    public TextBox getTextBox820() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox820();
    }

    @JsonIgnore
    public TextBox getTextBox821() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox821();
    }

    @JsonIgnore
    public TextBox getTextBox822() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox822();
    }

    @JsonIgnore
    public TextBox getTextBox823() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox823();
    }

    @JsonIgnore
    public TextBox getTextBox824() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox824();
    }

    @JsonIgnore
    public TextBox getTextBox825() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox825();
    }

    @JsonIgnore
    public TextBox getTextBox826() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox826();
    }

    @JsonIgnore
    public TextBox getTextBox827() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox827();
    }

    @JsonIgnore
    public TextBox getTextBox828() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox828();
    }

    @JsonIgnore
    public TextBox getTextBox829() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox829();
    }

    @JsonIgnore
    public TextBox getTextBox830() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox830();
    }

    @JsonIgnore
    public TextBox getTextBox831() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox831();
    }

    @JsonIgnore
    public TextBox getTextBox832() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox832();
    }

    @JsonIgnore
    public TextBox getTextBox833() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox833();
    }

    @JsonIgnore
    public TextBox getTextBox834() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox834();
    }

    @JsonIgnore
    public TextBox getTextBox835() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox835();
    }

    @JsonIgnore
    public TextBox getTextBox836() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox836();
    }

    @JsonIgnore
    public TextBox getTextBox837() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox837();
    }

    @JsonIgnore
    public TextBox getTextBox838() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox838();
    }

    @JsonIgnore
    public TextBox getTextBox839() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox839();
    }

    @JsonIgnore
    public TextBox getTextBox840() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox840();
    }

    @JsonIgnore
    public TextBox getTextBox841() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox841();
    }

    @JsonIgnore
    public TextBox getTextBox842() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox842();
    }

    @JsonIgnore
    public TextBox getTextBox843() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox843();
    }

    @JsonIgnore
    public TextBox getTextBox844() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox844();
    }

    @JsonIgnore
    public TextBox getTextBox845() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox845();
    }

    @JsonIgnore
    public TextBox getTextBox846() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox846();
    }

    @JsonIgnore
    public TextBox getTextBox847() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox847();
    }

    @JsonIgnore
    public TextBox getTextBox848() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox848();
    }

    @JsonIgnore
    public TextBox getTextBox849() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox849();
    }

    @JsonIgnore
    public TextBox getTextBox850() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox850();
    }

    @JsonIgnore
    public TextBox getTextBox851() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox851();
    }

    @JsonIgnore
    public TextBox getTextBox852() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox852();
    }

    @JsonIgnore
    public TextBox getTextBox853() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox853();
    }

    @JsonIgnore
    public TextBox getTextBox854() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox854();
    }

    @JsonIgnore
    public TextBox getTextBox855() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox855();
    }

    @JsonIgnore
    public TextBox getTextBox856() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox856();
    }

    @JsonIgnore
    public TextBox getTextBox857() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox857();
    }

    @JsonIgnore
    public TextBox getTextBox858() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox858();
    }

    @JsonIgnore
    public TextBox getTextBox859() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox859();
    }

    @JsonIgnore
    public TextBox getTextBox860() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox860();
    }

    @JsonIgnore
    public TextBox getTextBox861() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox861();
    }

    @JsonIgnore
    public TextBox getTextBox862() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox862();
    }

    @JsonIgnore
    public TextBox getTextBox863() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox863();
    }

    @JsonIgnore
    public TextBox getTextBox864() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox864();
    }

    @JsonIgnore
    public TextBox getTextBox865() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox865();
    }

    @JsonIgnore
    public TextBox getTextBox866() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox866();
    }

    @JsonIgnore
    public TextBox getTextBox867() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox867();
    }

    @JsonIgnore
    public TextBox getTextBox868() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox868();
    }

    @JsonIgnore
    public TextBox getTextBox869() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox869();
    }

    @JsonIgnore
    public TextBox getTextBox870() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox870();
    }

    @JsonIgnore
    public TextBox getTextBox871() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox871();
    }

    @JsonIgnore
    public TextBox getTextBox872() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox872();
    }

    @JsonIgnore
    public TextBox getTextBox873() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox873();
    }

    @JsonIgnore
    public TextBox getTextBox874() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox874();
    }

    @JsonIgnore
    public TextBox getTextBox875() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox875();
    }

    @JsonIgnore
    public TextBox getTextBox876() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox876();
    }

    @JsonIgnore
    public TextBox getTextBox877() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox877();
    }

    @JsonIgnore
    public TextBox getTextBox878() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox878();
    }

    @JsonIgnore
    public TextBox getTextBox879() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox879();
    }

    @JsonIgnore
    public TextBox getTextBox880() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox880();
    }

    @JsonIgnore
    public TextBox getTextBox881() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox881();
    }

    @JsonIgnore
    public TextBox getTextBox882() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox882();
    }

    @JsonIgnore
    public TextBox getTextBox883() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox883();
    }

    @JsonIgnore
    public TextBox getTextBox884() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox884();
    }

    @JsonIgnore
    public TextBox getTextBox885() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox885();
    }

    @JsonIgnore
    public TextBox getTextBox886() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox886();
    }

    @JsonIgnore
    public TextBox getTextBox887() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox887();
    }

    @JsonIgnore
    public TextBox getTextBox888() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox888();
    }

    @JsonIgnore
    public TextBox getTextBox889() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox889();
    }

    @JsonIgnore
    public TextBox getTextBox890() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox890();
    }

    @JsonIgnore
    public TextBox getTextBox891() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox891();
    }

    @JsonIgnore
    public TextBox getTextBox892() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox892();
    }

    @JsonIgnore
    public TextBox getTextBox893() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox893();
    }

    @JsonIgnore
    public TextBox getTextBox894() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox894();
    }

    @JsonIgnore
    public TextBox getTextBox895() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox895();
    }

    @JsonIgnore
    public TextBox getTextBox896() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox896();
    }

    @JsonIgnore
    public TextBox getTextBox897() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox897();
    }

    @JsonIgnore
    public TextBox getTextBox898() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox898();
    }

    @JsonIgnore
    public TextBox getTextBox899() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox899();
    }

    @JsonIgnore
    public TextBox getTextBox900() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox900();
    }

    @JsonIgnore
    public TextBox getTextBox901() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox901();
    }

    @JsonIgnore
    public TextBox getTextBox902() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox902();
    }

    @JsonIgnore
    public TextBox getTextBox903() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox903();
    }

    @JsonIgnore
    public TextBox getTextBox904() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox904();
    }

    @JsonIgnore
    public TextBox getTextBox905() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox905();
    }

    @JsonIgnore
    public TextBox getTextBox906() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox906();
    }

    @JsonIgnore
    public TextBox getTextBox907() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox907();
    }

    @JsonIgnore
    public TextBox getTextBox908() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox908();
    }

    @JsonIgnore
    public TextBox getTextBox909() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox909();
    }

    @JsonIgnore
    public TextBox getTextBox910() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox910();
    }

    @JsonIgnore
    public TextBox getTextBox911() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox911();
    }

    @JsonIgnore
    public TextBox getTextBox912() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox912();
    }

    @JsonIgnore
    public TextBox getTextBox913() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox913();
    }

    @JsonIgnore
    public TextBox getTextBox914() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox914();
    }

    @JsonIgnore
    public TextBox getTextBox915() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox915();
    }

    @JsonIgnore
    public TextBox getTextBox916() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox916();
    }

    @JsonIgnore
    public TextBox getTextBox917() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox917();
    }

    @JsonIgnore
    public TextBox getTextBox918() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox918();
    }

    @JsonIgnore
    public TextBox getTextBox919() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox919();
    }

    @JsonIgnore
    public TextBox getTextBox920() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox920();
    }

    @JsonIgnore
    public TextBox getTextBox921() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox921();
    }

    @JsonIgnore
    public TextBox getTextBox922() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox922();
    }

    @JsonIgnore
    public TextBox getTextBox923() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox923();
    }

    @JsonIgnore
    public TextBox getTextBox924() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox924();
    }

    @JsonIgnore
    public TextBox getTextBox925() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox925();
    }

    @JsonIgnore
    public TextBox getTextBox926() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox926();
    }

    @JsonIgnore
    public TextBox getTextBox927() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox927();
    }

    @JsonIgnore
    public TextBox getTextBox928() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox928();
    }

    @JsonIgnore
    public TextBox getTextBox929() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox929();
    }

    @JsonIgnore
    public TextBox getTextBox930() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox930();
    }

    @JsonIgnore
    public TextBox getTextBox931() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox931();
    }

    @JsonIgnore
    public TextBox getTextBox932() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox932();
    }

    @JsonIgnore
    public TextBox getTextBox933() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox933();
    }

    @JsonIgnore
    public TextBox getTextBox934() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox934();
    }

    @JsonIgnore
    public TextBox getTextBox935() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox935();
    }

    @JsonIgnore
    public TextBox getTextBox936() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox936();
    }

    @JsonIgnore
    public TextBox getTextBox937() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox937();
    }

    @JsonIgnore
    public TextBox getTextBox938() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox938();
    }

    @JsonIgnore
    public TextBox getTextBox939() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox939();
    }

    @JsonIgnore
    public TextBox getTextBox940() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox940();
    }

    @JsonIgnore
    public TextBox getTextBox941() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox941();
    }

    @JsonIgnore
    public TextBox getTextBox942() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox942();
    }

    @JsonIgnore
    public TextBox getTextBox943() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox943();
    }

    @JsonIgnore
    public TextBox getTextBox944() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox944();
    }

    @JsonIgnore
    public TextBox getTextBox945() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox945();
    }

    @JsonIgnore
    public TextBox getTextBox946() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox946();
    }

    @JsonIgnore
    public TextBox getTextBox947() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox947();
    }

    @JsonIgnore
    public TextBox getTextBox948() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox948();
    }

    @JsonIgnore
    public TextBox getTextBox949() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox949();
    }

    @JsonIgnore
    public TextBox getTextBox950() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox950();
    }

    @JsonIgnore
    public TextBox getTextBox951() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox951();
    }

    @JsonIgnore
    public TextBox getTextBox952() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox952();
    }

    @JsonIgnore
    public TextBox getTextBox953() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox953();
    }

    @JsonIgnore
    public TextBox getTextBox954() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox954();
    }

    @JsonIgnore
    public TextBox getTextBox955() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox955();
    }

    @JsonIgnore
    public TextBox getTextBox956() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox956();
    }

    @JsonIgnore
    public TextBox getTextBox957() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox957();
    }

    @JsonIgnore
    public TextBox getTextBox958() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox958();
    }

    @JsonIgnore
    public TextBox getTextBox959() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox959();
    }

    @JsonIgnore
    public TextBox getTextBox960() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox960();
    }

    @JsonIgnore
    public TextBox getTextBox961() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox961();
    }

    @JsonIgnore
    public TextBox getTextBox962() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox962();
    }

    @JsonIgnore
    public TextBox getTextBox963() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox963();
    }

    @JsonIgnore
    public TextBox getTextBox964() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox964();
    }

    @JsonIgnore
    public TextBox getTextBox965() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox965();
    }

    @JsonIgnore
    public TextBox getTextBox966() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox966();
    }

    @JsonIgnore
    public TextBox getTextBox967() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox967();
    }

    @JsonIgnore
    public TextBox getTextBox968() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox968();
    }

    @JsonIgnore
    public TextBox getTextBox969() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox969();
    }

    @JsonIgnore
    public TextBox getTextBox970() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox970();
    }

    @JsonIgnore
    public TextBox getTextBox971() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox971();
    }

    @JsonIgnore
    public TextBox getTextBox972() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox972();
    }

    @JsonIgnore
    public TextBox getTextBox973() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox973();
    }

    @JsonIgnore
    public TextBox getTextBox974() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox974();
    }

    @JsonIgnore
    public TextBox getTextBox975() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox975();
    }

    @JsonIgnore
    public TextBox getTextBox976() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox976();
    }

    @JsonIgnore
    public TextBox getTextBox977() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox977();
    }

    @JsonIgnore
    public TextBox getTextBox978() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox978();
    }

    @JsonIgnore
    public TextBox getTextBox979() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox979();
    }

    @JsonIgnore
    public TextBox getTextBox980() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox980();
    }

    @JsonIgnore
    public TextBox getTextBox981() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox981();
    }

    @JsonIgnore
    public TextBox getTextBox982() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox982();
    }

    @JsonIgnore
    public TextBox getTextBox983() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox983();
    }

    @JsonIgnore
    public TextBox getTextBox984() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox984();
    }

    @JsonIgnore
    public TextBox getTextBox985() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox985();
    }

    @JsonIgnore
    public TextBox getTextBox986() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox986();
    }

    @JsonIgnore
    public TextBox getTextBox987() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox987();
    }

    @JsonIgnore
    public TextBox getTextBox988() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox988();
    }

    @JsonIgnore
    public TextBox getTextBox989() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox989();
    }

    @JsonIgnore
    public TextBox getTextBox990() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox990();
    }

    @JsonIgnore
    public TextBox getTextBox991() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox991();
    }

    @JsonIgnore
    public TextBox getTextBox992() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox992();
    }

    @JsonIgnore
    public TextBox getTextBox993() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox993();
    }

    @JsonIgnore
    public TextBox getTextBox994() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox994();
    }

    @JsonIgnore
    public TextBox getTextBox995() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox995();
    }

    @JsonIgnore
    public TextBox getTextBox996() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox996();
    }

    @JsonIgnore
    public TextBox getTextBox997() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox997();
    }

    @JsonIgnore
    public TextBox getTextBox998() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox998();
    }

    @JsonIgnore
    public TextBox getTextBox999() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox999();
    }

    @JsonIgnore
    public TextBox getTextBox1000() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1000();
    }

    @JsonIgnore
    public TextBox getTextBox1001() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1001();
    }

    @JsonIgnore
    public TextBox getTextBox1002() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1002();
    }

    @JsonIgnore
    public TextBox getTextBox1003() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1003();
    }

    @JsonIgnore
    public TextBox getTextBox1004() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1004();
    }

    @JsonIgnore
    public TextBox getTextBox1005() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1005();
    }

    @JsonIgnore
    public TextBox getTextBox1006() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1006();
    }

    @JsonIgnore
    public TextBox getTextBox1007() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1007();
    }

    @JsonIgnore
    public TextBox getTextBox1008() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1008();
    }

    @JsonIgnore
    public TextBox getTextBox1009() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1009();
    }

    @JsonIgnore
    public TextBox getTextBox1010() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1010();
    }

    @JsonIgnore
    public TextBox getTextBox1011() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1011();
    }

    @JsonIgnore
    public TextBox getTextBox1012() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1012();
    }

    @JsonIgnore
    public TextBox getTextBox1013() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1013();
    }

    @JsonIgnore
    public TextBox getTextBox1014() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1014();
    }

    @JsonIgnore
    public TextBox getTextBox1015() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1015();
    }

    @JsonIgnore
    public TextBox getTextBox1016() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1016();
    }

    @JsonIgnore
    public TextBox getTextBox1017() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1017();
    }

    @JsonIgnore
    public TextBox getTextBox1018() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1018();
    }

    @JsonIgnore
    public TextBox getTextBox1019() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1019();
    }

    @JsonIgnore
    public TextBox getTextBox1020() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1020();
    }

    @JsonIgnore
    public TextBox getTextBox1021() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1021();
    }

    @JsonIgnore
    public TextBox getTextBox1022() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1022();
    }

    @JsonIgnore
    public TextBox getTextBox1023() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1023();
    }

    @JsonIgnore
    public TextBox getTextBox1024() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1024();
    }

    @JsonIgnore
    public TextBox getTextBox1025() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1025();
    }

    @JsonIgnore
    public TextBox getTextBox1026() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1026();
    }

    @JsonIgnore
    public TextBox getTextBox1027() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1027();
    }

    @JsonIgnore
    public TextBox getTextBox1028() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1028();
    }

    @JsonIgnore
    public TextBox getTextBox1029() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1029();
    }

    @JsonIgnore
    public TextBox getTextBox1030() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1030();
    }

    @JsonIgnore
    public TextBox getTextBox1031() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1031();
    }

    @JsonIgnore
    public TextBox getTextBox1032() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1032();
    }

    @JsonIgnore
    public TextBox getTextBox1033() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1033();
    }

    @JsonIgnore
    public TextBox getTextBox1034() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1034();
    }

    @JsonIgnore
    public TextBox getTextBox1035() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1035();
    }

    @JsonIgnore
    public TextBox getTextBox1036() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1036();
    }

    @JsonIgnore
    public TextBox getTextBox1037() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1037();
    }

    @JsonIgnore
    public TextBox getTextBox1038() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1038();
    }

    @JsonIgnore
    public TextBox getTextBox1039() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1039();
    }

    @JsonIgnore
    public TextBox getTextBox1040() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1040();
    }

    @JsonIgnore
    public TextBox getTextBox1041() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1041();
    }

    @JsonIgnore
    public TextBox getTextBox1042() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1042();
    }

    @JsonIgnore
    public TextBox getTextBox1043() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1043();
    }

    @JsonIgnore
    public TextBox getTextBox1044() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1044();
    }

    @JsonIgnore
    public TextBox getTextBox1045() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1045();
    }

    @JsonIgnore
    public TextBox getTextBox1046() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1046();
    }

    @JsonIgnore
    public TextBox getTextBox1047() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1047();
    }

    @JsonIgnore
    public TextBox getTextBox1048() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1048();
    }

    @JsonIgnore
    public TextBox getTextBox1049() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1049();
    }

    @JsonIgnore
    public TextBox getTextBox1050() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1050();
    }

    @JsonIgnore
    public TextBox getTextBox1051() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1051();
    }

    @JsonIgnore
    public TextBox getTextBox1052() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1052();
    }

    @JsonIgnore
    public TextBox getTextBox1053() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1053();
    }

    @JsonIgnore
    public TextBox getTextBox1054() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1054();
    }

    @JsonIgnore
    public TextBox getTextBox1055() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1055();
    }

    @JsonIgnore
    public TextBox getTextBox1056() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1056();
    }

    @JsonIgnore
    public TextBox getTextBox1057() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1057();
    }

    @JsonIgnore
    public TextBox getTextBox1058() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1058();
    }

    @JsonIgnore
    public TextBox getTextBox1059() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1059();
    }

    @JsonIgnore
    public TextBox getTextBox1060() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1060();
    }

    @JsonIgnore
    public TextBox getTextBox1061() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1061();
    }

    @JsonIgnore
    public TextBox getTextBox1062() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1062();
    }

    @JsonIgnore
    public TextBox getTextBox1063() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1063();
    }

    @JsonIgnore
    public TextBox getTextBox1064() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1064();
    }

    @JsonIgnore
    public TextBox getTextBox1065() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1065();
    }

    @JsonIgnore
    public TextBox getTextBox1066() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1066();
    }

    @JsonIgnore
    public TextBox getTextBox1067() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1067();
    }

    @JsonIgnore
    public TextBox getTextBox1068() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1068();
    }

    @JsonIgnore
    public TextBox getTextBox1069() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1069();
    }

    @JsonIgnore
    public TextBox getTextBox1070() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1070();
    }

    @JsonIgnore
    public TextBox getTextBox1071() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1071();
    }

    @JsonIgnore
    public TextBox getTextBox1072() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1072();
    }

    @JsonIgnore
    public TextBox getTextBox1073() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1073();
    }

    @JsonIgnore
    public TextBox getTextBox1074() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1074();
    }

    @JsonIgnore
    public TextBox getTextBox1075() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1075();
    }

    @JsonIgnore
    public TextBox getTextBox1076() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1076();
    }

    @JsonIgnore
    public TextBox getTextBox1077() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1077();
    }

    @JsonIgnore
    public TextBox getTextBox1078() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1078();
    }

    @JsonIgnore
    public TextBox getTextBox1079() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1079();
    }

    @JsonIgnore
    public TextBox getTextBox1080() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1080();
    }

    @JsonIgnore
    public TextBox getTextBox1081() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1081();
    }

    @JsonIgnore
    public TextBox getTextBox1082() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1082();
    }

    @JsonIgnore
    public TextBox getTextBox1083() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1083();
    }

    @JsonIgnore
    public TextBox getTextBox1084() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1084();
    }

    @JsonIgnore
    public TextBox getTextBox1085() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1085();
    }

    @JsonIgnore
    public TextBox getTextBox1086() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1086();
    }

    @JsonIgnore
    public TextBox getTextBox1087() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1087();
    }

    @JsonIgnore
    public TextBox getTextBox1088() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1088();
    }

    @JsonIgnore
    public TextBox getTextBox1089() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1089();
    }

    @JsonIgnore
    public TextBox getTextBox1090() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1090();
    }

    @JsonIgnore
    public TextBox getTextBox1091() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1091();
    }

    @JsonIgnore
    public TextBox getTextBox1092() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1092();
    }

    @JsonIgnore
    public TextBox getTextBox1093() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1093();
    }

    @JsonIgnore
    public TextBox getTextBox1094() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1094();
    }

    @JsonIgnore
    public TextBox getTextBox1095() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1095();
    }

    @JsonIgnore
    public TextBox getTextBox1096() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1096();
    }

    @JsonIgnore
    public TextBox getTextBox1097() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1097();
    }

    @JsonIgnore
    public TextBox getTextBox1098() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1098();
    }

    @JsonIgnore
    public TextBox getTextBox1099() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1099();
    }

    @JsonIgnore
    public TextBox getTextBox1100() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1100();
    }

    @JsonIgnore
    public TextBox getTextBox1101() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1101();
    }

    @JsonIgnore
    public TextBox getTextBox1102() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1102();
    }

    @JsonIgnore
    public TextBox getTextBox1103() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1103();
    }

    @JsonIgnore
    public TextBox getTextBox1104() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1104();
    }

    @JsonIgnore
    public TextBox getTextBox1105() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1105();
    }

    @JsonIgnore
    public TextBox getTextBox1106() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1106();
    }

    @JsonIgnore
    public TextBox getTextBox1107() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1107();
    }

    @JsonIgnore
    public TextBox getTextBox1108() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1108();
    }

    @JsonIgnore
    public TextBox getTextBox1109() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1109();
    }

    @JsonIgnore
    public TextBox getTextBox1110() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1110();
    }

    @JsonIgnore
    public TextBox getTextBox1111() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1111();
    }

    @JsonIgnore
    public TextBox getTextBox1112() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1112();
    }

    @JsonIgnore
    public TextBox getTextBox1113() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1113();
    }

    @JsonIgnore
    public TextBox getTextBox1114() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1114();
    }

    @JsonIgnore
    public TextBox getTextBox1115() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1115();
    }

    @JsonIgnore
    public TextBox getTextBox1116() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1116();
    }

    @JsonIgnore
    public TextBox getTextBox1117() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1117();
    }

    @JsonIgnore
    public TextBox getTextBox1118() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1118();
    }

    @JsonIgnore
    public TextBox getTextBox1119() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1119();
    }

    @JsonIgnore
    public TextBox getTextBox1120() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1120();
    }

    @JsonIgnore
    public TextBox getTextBox1121() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1121();
    }

    @JsonIgnore
    public TextBox getTextBox1122() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1122();
    }

    @JsonIgnore
    public TextBox getTextBox1123() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1123();
    }

    @JsonIgnore
    public TextBox getTextBox1124() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1124();
    }

    @JsonIgnore
    public TextBox getTextBox1125() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1125();
    }

    @JsonIgnore
    public TextBox getTextBox1126() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1126();
    }

    @JsonIgnore
    public TextBox getTextBox1127() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1127();
    }

    @JsonIgnore
    public TextBox getTextBox1128() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1128();
    }

    @JsonIgnore
    public TextBox getTextBox1129() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1129();
    }

    @JsonIgnore
    public TextBox getTextBox1130() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1130();
    }

    @JsonIgnore
    public TextBox getTextBox1131() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1131();
    }

    @JsonIgnore
    public TextBox getTextBox1132() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1132();
    }

    @JsonIgnore
    public TextBox getTextBox1133() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1133();
    }

    @JsonIgnore
    public TextBox getTextBox1134() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1134();
    }

    @JsonIgnore
    public TextBox getTextBox1135() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1135();
    }

    @JsonIgnore
    public TextBox getTextBox1136() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1136();
    }

    @JsonIgnore
    public TextBox getTextBox1137() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1137();
    }

    @JsonIgnore
    public TextBox getTextBox1138() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1138();
    }

    @JsonIgnore
    public TextBox getTextBox1139() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1139();
    }

    @JsonIgnore
    public TextBox getTextBox1140() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1140();
    }

    @JsonIgnore
    public TextBox getTextBox1141() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1141();
    }

    @JsonIgnore
    public TextBox getTextBox1142() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1142();
    }

    @JsonIgnore
    public TextBox getTextBox1143() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1143();
    }

    @JsonIgnore
    public TextBox getTextBox1144() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1144();
    }

    @JsonIgnore
    public TextBox getTextBox1145() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1145();
    }

    @JsonIgnore
    public TextBox getTextBox1146() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1146();
    }

    @JsonIgnore
    public TextBox getTextBox1147() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1147();
    }

    @JsonIgnore
    public TextBox getTextBox1148() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1148();
    }

    @JsonIgnore
    public TextBox getTextBox1149() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1149();
    }

    @JsonIgnore
    public TextBox getTextBox1150() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1150();
    }

    @JsonIgnore
    public TextBox getTextBox1151() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1151();
    }

    @JsonIgnore
    public TextBox getTextBox1152() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1152();
    }

    @JsonIgnore
    public TextBox getTextBox1153() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1153();
    }

    @JsonIgnore
    public TextBox getTextBox1154() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1154();
    }

    @JsonIgnore
    public TextBox getTextBox1155() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1155();
    }

    @JsonIgnore
    public TextBox getTextBox1156() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1156();
    }

    @JsonIgnore
    public TextBox getTextBox1157() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1157();
    }

    @JsonIgnore
    public TextBox getTextBox1158() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1158();
    }

    @JsonIgnore
    public TextBox getTextBox1159() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1159();
    }

    @JsonIgnore
    public TextBox getTextBox1160() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1160();
    }

    @JsonIgnore
    public TextBox getTextBox1161() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1161();
    }

    @JsonIgnore
    public TextBox getTextBox1162() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1162();
    }

    @JsonIgnore
    public TextBox getTextBox1163() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1163();
    }

    @JsonIgnore
    public TextBox getTextBox1164() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1164();
    }

    @JsonIgnore
    public TextBox getTextBox1165() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1165();
    }

    @JsonIgnore
    public TextBox getTextBox1166() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1166();
    }

    @JsonIgnore
    public TextBox getTextBox1167() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1167();
    }

    @JsonIgnore
    public TextBox getTextBox1168() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1168();
    }

    @JsonIgnore
    public TextBox getTextBox1169() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1169();
    }

    @JsonIgnore
    public TextBox getTextBox1170() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1170();
    }

    @JsonIgnore
    public TextBox getTextBox1171() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1171();
    }

    @JsonIgnore
    public TextBox getTextBox1172() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1172();
    }

    @JsonIgnore
    public TextBox getTextBox1173() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1173();
    }

    @JsonIgnore
    public TextBox getTextBox1174() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1174();
    }

    @JsonIgnore
    public TextBox getTextBox1175() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1175();
    }

    @JsonIgnore
    public TextBox getTextBox1176() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1176();
    }

    @JsonIgnore
    public TextBox getTextBox1177() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1177();
    }

    @JsonIgnore
    public TextBox getTextBox1178() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1178();
    }

    @JsonIgnore
    public TextBox getTextBox1179() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1179();
    }

    @JsonIgnore
    public TextBox getTextBox1180() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1180();
    }

    @JsonIgnore
    public TextBox getTextBox1181() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1181();
    }

    @JsonIgnore
    public TextBox getTextBox1182() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1182();
    }

    @JsonIgnore
    public TextBox getTextBox1183() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1183();
    }

    @JsonIgnore
    public TextBox getTextBox1184() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1184();
    }

    @JsonIgnore
    public TextBox getTextBox1185() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1185();
    }

    @JsonIgnore
    public TextBox getTextBox1186() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1186();
    }

    @JsonIgnore
    public TextBox getTextBox1187() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1187();
    }

    @JsonIgnore
    public TextBox getTextBox1188() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1188();
    }

    @JsonIgnore
    public TextBox getTextBox1189() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1189();
    }

    @JsonIgnore
    public TextBox getTextBox1190() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1190();
    }

    @JsonIgnore
    public TextBox getTextBox1191() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1191();
    }

    @JsonIgnore
    public TextBox getTextBox1192() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1192();
    }

    @JsonIgnore
    public TextBox getTextBox1193() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1193();
    }

    @JsonIgnore
    public TextBox getTextBox1194() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1194();
    }

    @JsonIgnore
    public TextBox getTextBox1195() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1195();
    }

    @JsonIgnore
    public TextBox getTextBox1196() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1196();
    }

    @JsonIgnore
    public TextBox getTextBox1197() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1197();
    }

    @JsonIgnore
    public TextBox getTextBox1198() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1198();
    }

    @JsonIgnore
    public TextBox getTextBox1199() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1199();
    }

    @JsonIgnore
    public TextBox getTextBox1200() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1200();
    }

    @JsonIgnore
    public TextBox getTextBox1201() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1201();
    }

    @JsonIgnore
    public TextBox getTextBox1202() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1202();
    }

    @JsonIgnore
    public TextBox getTextBox1203() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1203();
    }

    @JsonIgnore
    public TextBox getTextBox1204() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1204();
    }

    @JsonIgnore
    public TextBox getTextBox1205() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1205();
    }

    @JsonIgnore
    public tpl4Div getTpl4() {
        return this.getTcMain().getTpl4();
    }

    @JsonIgnore
    public void setTpl4(tpl4Div tpl4) {
        this.getTcMain().setTpl4(tpl4);
    }

    @JsonIgnore
    public tbl4Div getTbl4() {
        return this.getTcMain().getTpl4().getTbl4();
    }

    @JsonIgnore
    public void setTbl4(tbl4Div tbl4) {
        this.getTcMain().getTpl4().setTbl4(tbl4);
    }

    @JsonIgnore
    public TextBox getTextBox1206() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1206();
    }

    @JsonIgnore
    public TextBox getTextBox1207() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1207();
    }

    @JsonIgnore
    public TextBox getTextBox1208() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1208();
    }

    @JsonIgnore
    public TextBox getTextBox1209() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1209();
    }

    @JsonIgnore
    public TextBox getTextBox1210() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1210();
    }

    @JsonIgnore
    public TextBox getTextBox1211() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1211();
    }

    @JsonIgnore
    public TextBox getTextBox1212() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1212();
    }

    @JsonIgnore
    public TextBox getTextBox1213() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1213();
    }

    @JsonIgnore
    public TextBox getTextBox1214() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1214();
    }

    @JsonIgnore
    public TextBox getTextBox1215() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1215();
    }

    @JsonIgnore
    public TextBox getTextBox1216() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1216();
    }

    @JsonIgnore
    public TextBox getTextBox1217() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1217();
    }

    @JsonIgnore
    public TextBox getTextBox1218() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1218();
    }

    @JsonIgnore
    public TextBox getTextBox1219() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1219();
    }

    @JsonIgnore
    public TextBox getTextBox1220() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1220();
    }

    @JsonIgnore
    public TextBox getTextBox1221() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1221();
    }

    @JsonIgnore
    public TextBox getTextBox1222() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1222();
    }

    @JsonIgnore
    public TextBox getTextBox1223() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1223();
    }

    @JsonIgnore
    public TextBox getTextBox1224() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1224();
    }

    @JsonIgnore
    public TextBox getTextBox1225() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1225();
    }

    @JsonIgnore
    public TextBox getTextBox1226() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1226();
    }

    @JsonIgnore
    public TextBox getTextBox1227() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1227();
    }

    @JsonIgnore
    public TextBox getTextBox1228() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1228();
    }

    @JsonIgnore
    public TextBox getTextBox1229() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1229();
    }

    @JsonIgnore
    public TextBox getTextBox1230() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1230();
    }

    @JsonIgnore
    public TextBox getTextBox1231() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1231();
    }

    @JsonIgnore
    public TextBox getTextBox1232() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1232();
    }

    @JsonIgnore
    public TextBox getTextBox1233() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1233();
    }

    @JsonIgnore
    public TextBox getTextBox1234() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1234();
    }

    @JsonIgnore
    public TextBox getTextBox1235() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1235();
    }

    @JsonIgnore
    public TextBox getTextBox1236() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1236();
    }

    @JsonIgnore
    public TextBox getTextBox1237() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1237();
    }

    @JsonIgnore
    public TextBox getTextBox1238() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1238();
    }

    @JsonIgnore
    public TextBox getTextBox1239() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1239();
    }

    @JsonIgnore
    public TextBox getTextBox1240() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1240();
    }

    @JsonIgnore
    public TextBox getTextBox1241() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1241();
    }

    @JsonIgnore
    public TextBox getTextBox1242() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1242();
    }

    @JsonIgnore
    public TextBox getTextBox1243() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1243();
    }

    @JsonIgnore
    public TextBox getTextBox1244() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1244();
    }

    @JsonIgnore
    public TextBox getTextBox1245() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1245();
    }

    @JsonIgnore
    public TextBox getTextBox1246() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1246();
    }

    @JsonIgnore
    public TextBox getTextBox1247() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1247();
    }

    @JsonIgnore
    public TextBox getTextBox1248() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1248();
    }

    @JsonIgnore
    public TextBox getTextBox1249() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1249();
    }

    @JsonIgnore
    public TextBox getTextBox1250() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1250();
    }

    @JsonIgnore
    public TextBox getTextBox1251() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1251();
    }

    @JsonIgnore
    public TextBox getTextBox1252() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1252();
    }

    @JsonIgnore
    public TextBox getTextBox1253() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1253();
    }

    @JsonIgnore
    public TextBox getTextBox1254() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1254();
    }

    @JsonIgnore
    public TextBox getTextBox1255() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1255();
    }

    @JsonIgnore
    public TextBox getTextBox1256() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1256();
    }

    @JsonIgnore
    public TextBox getTextBox1257() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1257();
    }

    @JsonIgnore
    public TextBox getTextBox1258() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1258();
    }

    @JsonIgnore
    public TextBox getTextBox1259() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1259();
    }

    @JsonIgnore
    public TextBox getTextBox1260() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1260();
    }

    @JsonIgnore
    public TextBox getTextBox1261() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1261();
    }

    @JsonIgnore
    public TextBox getTextBox1262() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1262();
    }

    @JsonIgnore
    public TextBox getTextBox1263() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1263();
    }

    @JsonIgnore
    public TextBox getTextBox1264() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1264();
    }

    @JsonIgnore
    public TextBox getTextBox1265() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1265();
    }

    @JsonIgnore
    public TextBox getTextBox1266() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1266();
    }

    @JsonIgnore
    public TextBox getTextBox1267() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1267();
    }

    @JsonIgnore
    public TextBox getTextBox1268() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1268();
    }

    @JsonIgnore
    public TextBox getTextBox1269() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1269();
    }

    @JsonIgnore
    public TextBox getTextBox1270() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1270();
    }

    @JsonIgnore
    public TextBox getTextBox1271() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1271();
    }

    @JsonIgnore
    public TextBox getTextBox1272() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1272();
    }

    @JsonIgnore
    public TextBox getTextBox1273() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1273();
    }

    @JsonIgnore
    public TextBox getTextBox1274() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1274();
    }

    @JsonIgnore
    public TextBox getTextBox1275() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1275();
    }

    @JsonIgnore
    public TextBox getTextBox1276() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1276();
    }

    @JsonIgnore
    public TextBox getTextBox1277() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1277();
    }

    @JsonIgnore
    public TextBox getTextBox1278() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1278();
    }

    @JsonIgnore
    public TextBox getTextBox1279() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1279();
    }

    @JsonIgnore
    public TextBox getTextBox1280() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1280();
    }

    @JsonIgnore
    public TextBox getTextBox1281() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1281();
    }

    @JsonIgnore
    public TextBox getTextBox1282() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1282();
    }

    @JsonIgnore
    public TextBox getTextBox1283() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1283();
    }

    @JsonIgnore
    public TextBox getTextBox1284() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1284();
    }

    @JsonIgnore
    public TextBox getTextBox1285() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1285();
    }

    @JsonIgnore
    public TextBox getTextBox1286() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1286();
    }

    @JsonIgnore
    public TextBox getTextBox1287() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1287();
    }

    @JsonIgnore
    public TextBox getTextBox1288() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1288();
    }

    @JsonIgnore
    public TextBox getTextBox1289() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1289();
    }

    @JsonIgnore
    public TextBox getTextBox1290() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1290();
    }

    @JsonIgnore
    public TextBox getTextBox1291() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1291();
    }

    @JsonIgnore
    public TextBox getTextBox1292() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1292();
    }

    @JsonIgnore
    public TextBox getTextBox1293() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1293();
    }

    @JsonIgnore
    public TextBox getTextBox1294() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1294();
    }

    @JsonIgnore
    public TextBox getTextBox1295() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1295();
    }

    @JsonIgnore
    public TextBox getTextBox1296() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1296();
    }

    @JsonIgnore
    public TextBox getTextBox1297() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1297();
    }

    @JsonIgnore
    public TextBox getTextBox1298() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1298();
    }

    @JsonIgnore
    public TextBox getTextBox1299() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1299();
    }

    @JsonIgnore
    public TextBox getTextBox1300() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1300();
    }

    @JsonIgnore
    public TextBox getTextBox1301() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1301();
    }

    @JsonIgnore
    public TextBox getTextBox1302() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1302();
    }

    @JsonIgnore
    public TextBox getTextBox1303() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1303();
    }

    @JsonIgnore
    public TextBox getTextBox1304() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1304();
    }

    @JsonIgnore
    public TextBox getTextBox1305() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1305();
    }

    @JsonIgnore
    public TextBox getTextBox1306() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1306();
    }

    @JsonIgnore
    public TextBox getTextBox1307() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1307();
    }

    @JsonIgnore
    public TextBox getTextBox1308() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1308();
    }

    @JsonIgnore
    public TextBox getTextBox1309() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1309();
    }

    @JsonIgnore
    public TextBox getTextBox1310() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1310();
    }

    @JsonIgnore
    public TextBox getTextBox1311() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1311();
    }

    @JsonIgnore
    public TextBox getTextBox1312() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1312();
    }

    @JsonIgnore
    public TextBox getTextBox1313() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1313();
    }

    @JsonIgnore
    public TextBox getTextBox1314() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1314();
    }

    @JsonIgnore
    public TextBox getTextBox1315() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1315();
    }

    @JsonIgnore
    public TextBox getTextBox1316() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1316();
    }

    @JsonIgnore
    public TextBox getTextBox1317() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1317();
    }

    @JsonIgnore
    public TextBox getTextBox1318() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1318();
    }

    @JsonIgnore
    public TextBox getTextBox1319() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1319();
    }

    @JsonIgnore
    public TextBox getTextBox1320() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1320();
    }

    @JsonIgnore
    public TextBox getTextBox1321() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1321();
    }

    @JsonIgnore
    public TextBox getTextBox1322() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1322();
    }

    @JsonIgnore
    public TextBox getTextBox1323() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1323();
    }

    @JsonIgnore
    public TextBox getTextBox1324() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1324();
    }

    @JsonIgnore
    public TextBox getTextBox1325() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1325();
    }

    @JsonIgnore
    public TextBox getTextBox1326() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1326();
    }

    @JsonIgnore
    public TextBox getTextBox1327() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1327();
    }

    @JsonIgnore
    public TextBox getTextBox1328() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1328();
    }

    @JsonIgnore
    public TextBox getTextBox1329() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1329();
    }

    @JsonIgnore
    public TextBox getTextBox1330() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1330();
    }

    @JsonIgnore
    public TextBox getTextBox1331() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1331();
    }

    @JsonIgnore
    public TextBox getTextBox1332() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1332();
    }

    @JsonIgnore
    public TextBox getTextBox1333() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1333();
    }

    @JsonIgnore
    public TextBox getTextBox1334() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1334();
    }

    @JsonIgnore
    public TextBox getTextBox1335() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1335();
    }

    @JsonIgnore
    public TextBox getTextBox1336() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1336();
    }

    @JsonIgnore
    public TextBox getTextBox1337() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1337();
    }

    @JsonIgnore
    public TextBox getTextBox1338() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1338();
    }

    @JsonIgnore
    public TextBox getTextBox1339() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1339();
    }

    @JsonIgnore
    public TextBox getTextBox1340() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1340();
    }

    @JsonIgnore
    public TextBox getTextBox1341() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1341();
    }

    @JsonIgnore
    public TextBox getTextBox1342() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1342();
    }

    @JsonIgnore
    public TextBox getTextBox1343() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1343();
    }

    @JsonIgnore
    public TextBox getTextBox1344() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1344();
    }

    @JsonIgnore
    public TextBox getTextBox1345() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1345();
    }

    @JsonIgnore
    public TextBox getTextBox1346() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1346();
    }

    @JsonIgnore
    public TextBox getTextBox1347() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1347();
    }

    @JsonIgnore
    public TextBox getTextBox1348() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1348();
    }

    @JsonIgnore
    public TextBox getTextBox1349() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1349();
    }

    @JsonIgnore
    public TextBox getTextBox1350() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1350();
    }

    @JsonIgnore
    public TextBox getTextBox1351() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1351();
    }

    @JsonIgnore
    public TextBox getTextBox1352() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1352();
    }

    @JsonIgnore
    public TextBox getTextBox1353() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1353();
    }

    @JsonIgnore
    public TextBox getTextBox1354() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1354();
    }

    @JsonIgnore
    public TextBox getTextBox1355() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1355();
    }

    @JsonIgnore
    public TextBox getTextBox1356() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1356();
    }

    @JsonIgnore
    public TextBox getTextBox1357() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1357();
    }

    @JsonIgnore
    public TextBox getTextBox1358() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1358();
    }

    @JsonIgnore
    public TextBox getTextBox1359() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1359();
    }

    @JsonIgnore
    public TextBox getTextBox1360() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1360();
    }

    @JsonIgnore
    public TextBox getTextBox1361() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1361();
    }

    @JsonIgnore
    public TextBox getTextBox1362() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1362();
    }

    @JsonIgnore
    public TextBox getTextBox1363() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1363();
    }

    @JsonIgnore
    public TextBox getTextBox1364() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1364();
    }

    @JsonIgnore
    public TextBox getTextBox1365() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1365();
    }

    @JsonIgnore
    public TextBox getTextBox1366() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1366();
    }

    @JsonIgnore
    public TextBox getTextBox1367() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1367();
    }

    @JsonIgnore
    public TextBox getTextBox1368() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1368();
    }

    @JsonIgnore
    public TextBox getTextBox1369() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1369();
    }

    @JsonIgnore
    public TextBox getTextBox1370() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1370();
    }

    @JsonIgnore
    public TextBox getTextBox1371() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1371();
    }

    @JsonIgnore
    public TextBox getTextBox1372() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1372();
    }

    @JsonIgnore
    public TextBox getTextBox1373() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1373();
    }

    @JsonIgnore
    public TextBox getTextBox1374() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1374();
    }

    @JsonIgnore
    public TextBox getTextBox1375() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1375();
    }

    @JsonIgnore
    public TextBox getTextBox1376() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1376();
    }

    @JsonIgnore
    public TextBox getTextBox1377() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1377();
    }

    @JsonIgnore
    public TextBox getTextBox1378() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1378();
    }

    @JsonIgnore
    public TextBox getTextBox1379() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1379();
    }

    @JsonIgnore
    public TextBox getTextBox1380() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1380();
    }

    @JsonIgnore
    public TextBox getTextBox1381() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1381();
    }

    @JsonIgnore
    public TextBox getTextBox1382() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1382();
    }

    @JsonIgnore
    public TextBox getTextBox1383() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1383();
    }

    @JsonIgnore
    public TextBox getTextBox1384() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1384();
    }

    @JsonIgnore
    public TextBox getTextBox1385() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1385();
    }

    @JsonIgnore
    public TextBox getTextBox1386() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1386();
    }

    @JsonIgnore
    public TextBox getTextBox1387() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1387();
    }

    @JsonIgnore
    public TextBox getTextBox1388() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1388();
    }

    @JsonIgnore
    public TextBox getTextBox1389() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1389();
    }

    @JsonIgnore
    public TextBox getTextBox1390() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1390();
    }

    @JsonIgnore
    public TextBox getTextBox1391() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1391();
    }

    @JsonIgnore
    public TextBox getTextBox1392() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1392();
    }

    @JsonIgnore
    public TextBox getTextBox1393() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1393();
    }

    @JsonIgnore
    public TextBox getTextBox1394() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1394();
    }

    @JsonIgnore
    public TextBox getTextBox1395() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1395();
    }

    @JsonIgnore
    public TextBox getTextBox1396() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1396();
    }

    @JsonIgnore
    public TextBox getTextBox1397() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1397();
    }

    @JsonIgnore
    public TextBox getTextBox1398() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1398();
    }

    @JsonIgnore
    public TextBox getTextBox1399() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1399();
    }

    @JsonIgnore
    public TextBox getTextBox1400() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1400();
    }

    @JsonIgnore
    public TextBox getTextBox1401() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1401();
    }

    @JsonIgnore
    public TextBox getTextBox1402() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1402();
    }

    @JsonIgnore
    public TextBox getTextBox1403() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1403();
    }

    @JsonIgnore
    public TextBox getTextBox1404() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1404();
    }

    @JsonIgnore
    public TextBox getTextBox1405() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1405();
    }

    @JsonIgnore
    public TextBox getTextBox1406() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1406();
    }

    @JsonIgnore
    public TextBox getTextBox1407() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1407();
    }

    @JsonIgnore
    public TextBox getTextBox1408() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1408();
    }

    @JsonIgnore
    public TextBox getTextBox1409() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1409();
    }

    @JsonIgnore
    public TextBox getTextBox1410() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1410();
    }

    @JsonIgnore
    public TextBox getTextBox1411() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1411();
    }

    @JsonIgnore
    public TextBox getTextBox1412() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1412();
    }

    @JsonIgnore
    public TextBox getTextBox1413() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1413();
    }

    @JsonIgnore
    public TextBox getTextBox1414() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1414();
    }

    @JsonIgnore
    public TextBox getTextBox1415() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1415();
    }

    @JsonIgnore
    public TextBox getTextBox1416() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1416();
    }

    @JsonIgnore
    public TextBox getTextBox1417() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1417();
    }

    @JsonIgnore
    public TextBox getTextBox1418() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1418();
    }

    @JsonIgnore
    public TextBox getTextBox1419() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1419();
    }

    @JsonIgnore
    public TextBox getTextBox1420() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1420();
    }

    @JsonIgnore
    public TextBox getTextBox1421() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1421();
    }

    @JsonIgnore
    public TextBox getTextBox1422() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1422();
    }

    @JsonIgnore
    public TextBox getTextBox1423() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1423();
    }

    @JsonIgnore
    public TextBox getTextBox1424() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1424();
    }

    @JsonIgnore
    public TextBox getTextBox1425() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1425();
    }

    @JsonIgnore
    public TextBox getTextBox1426() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1426();
    }

    @JsonIgnore
    public TextBox getTextBox1427() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1427();
    }

    @JsonIgnore
    public TextBox getTextBox1428() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1428();
    }

    @JsonIgnore
    public TextBox getTextBox1429() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1429();
    }

    @JsonIgnore
    public TextBox getTextBox1430() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1430();
    }

    @JsonIgnore
    public TextBox getTextBox1431() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1431();
    }

    @JsonIgnore
    public TextBox getTextBox1432() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1432();
    }

    @JsonIgnore
    public TextBox getTextBox1433() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1433();
    }

    @JsonIgnore
    public TextBox getTextBox1434() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1434();
    }

    @JsonIgnore
    public TextBox getTextBox1435() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1435();
    }

    @JsonIgnore
    public TextBox getTextBox1436() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1436();
    }

    @JsonIgnore
    public TextBox getTextBox1437() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1437();
    }

    @JsonIgnore
    public TextBox getTextBox1438() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1438();
    }

    @JsonIgnore
    public TextBox getTextBox1439() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1439();
    }

    @JsonIgnore
    public TextBox getTextBox1440() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1440();
    }

    @JsonIgnore
    public TextBox getTextBox1441() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1441();
    }

    @JsonIgnore
    public TextBox getTextBox1442() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1442();
    }

    @JsonIgnore
    public TextBox getTextBox1443() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1443();
    }

    @JsonIgnore
    public TextBox getTextBox1444() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1444();
    }

    @JsonIgnore
    public TextBox getTextBox1445() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1445();
    }

    @JsonIgnore
    public TextBox getTextBox1446() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1446();
    }

    @JsonIgnore
    public TextBox getTextBox1447() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1447();
    }

    @JsonIgnore
    public TextBox getTextBox1448() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1448();
    }

    @JsonIgnore
    public TextBox getTextBox1449() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1449();
    }

    @JsonIgnore
    public TextBox getTextBox1450() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1450();
    }

    @JsonIgnore
    public TextBox getTextBox1451() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1451();
    }

    @JsonIgnore
    public TextBox getTextBox1452() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1452();
    }

    @JsonIgnore
    public TextBox getTextBox1453() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1453();
    }

    @JsonIgnore
    public TextBox getTextBox1454() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1454();
    }

    @JsonIgnore
    public TextBox getTextBox1455() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1455();
    }

    @JsonIgnore
    public TextBox getTextBox1456() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1456();
    }

    @JsonIgnore
    public TextBox getTextBox1457() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1457();
    }

    @JsonIgnore
    public TextBox getTextBox1458() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1458();
    }

    @JsonIgnore
    public TextBox getTextBox1459() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1459();
    }

    @JsonIgnore
    public TextBox getTextBox1460() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1460();
    }

    @JsonIgnore
    public TextBox getTextBox1461() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1461();
    }

    @JsonIgnore
    public TextBox getTextBox1462() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1462();
    }

    @JsonIgnore
    public TextBox getTextBox1463() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1463();
    }

    @JsonIgnore
    public TextBox getTextBox1464() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1464();
    }

    @JsonIgnore
    public TextBox getTextBox1465() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1465();
    }

    @JsonIgnore
    public TextBox getTextBox1466() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1466();
    }

    @JsonIgnore
    public TextBox getTextBox1467() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1467();
    }

    @JsonIgnore
    public TextBox getTextBox1468() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1468();
    }

    @JsonIgnore
    public TextBox getTextBox1469() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1469();
    }

    @JsonIgnore
    public TextBox getTextBox1470() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1470();
    }

    @JsonIgnore
    public TextBox getTextBox1471() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1471();
    }

    @JsonIgnore
    public TextBox getTextBox1472() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1472();
    }

    @JsonIgnore
    public TextBox getTextBox1473() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1473();
    }

    @JsonIgnore
    public TextBox getTextBox1474() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1474();
    }

    @JsonIgnore
    public TextBox getTextBox1475() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1475();
    }

    @JsonIgnore
    public TextBox getTextBox1476() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1476();
    }

    @JsonIgnore
    public TextBox getTextBox1477() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1477();
    }

    @JsonIgnore
    public TextBox getTextBox1478() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1478();
    }

    @JsonIgnore
    public TextBox getTextBox1479() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1479();
    }

    @JsonIgnore
    public TextBox getTextBox1480() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1480();
    }

    @JsonIgnore
    public TextBox getTextBox1481() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1481();
    }

    @JsonIgnore
    public TextBox getTextBox1482() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1482();
    }

    @JsonIgnore
    public TextBox getTextBox1483() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1483();
    }

    @JsonIgnore
    public TextBox getTextBox1484() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1484();
    }

    @JsonIgnore
    public TextBox getTextBox1485() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1485();
    }

    @JsonIgnore
    public TextBox getTextBox1486() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1486();
    }

    @JsonIgnore
    public TextBox getTextBox1487() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1487();
    }

    @JsonIgnore
    public TextBox getTextBox1488() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1488();
    }

    @JsonIgnore
    public TextBox getTextBox1489() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1489();
    }

    @JsonIgnore
    public TextBox getTextBox1490() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1490();
    }

    @JsonIgnore
    public TextBox getTextBox1491() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1491();
    }

    @JsonIgnore
    public TextBox getTextBox1492() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1492();
    }

    @JsonIgnore
    public TextBox getTextBox1493() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1493();
    }

    @JsonIgnore
    public TextBox getTextBox1494() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1494();
    }

    @JsonIgnore
    public TextBox getTextBox1495() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1495();
    }

    @JsonIgnore
    public TextBox getTextBox1496() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1496();
    }

    @JsonIgnore
    public TextBox getTextBox1497() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1497();
    }

    @JsonIgnore
    public TextBox getTextBox1498() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1498();
    }

    @JsonIgnore
    public TextBox getTextBox1499() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1499();
    }

    @JsonIgnore
    public TextBox getTextBox1500() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1500();
    }

    @JsonIgnore
    public TextBox getTextBox1501() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1501();
    }

    @JsonIgnore
    public TextBox getTextBox1502() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1502();
    }

    @JsonIgnore
    public TextBox getTextBox1503() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1503();
    }

    @JsonIgnore
    public TextBox getTextBox1504() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1504();
    }

    @JsonIgnore
    public TextBox getTextBox1505() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1505();
    }

    @JsonIgnore
    public TextBox getTextBox1506() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1506();
    }

    @JsonIgnore
    public TextBox getTextBox1507() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1507();
    }

    @JsonIgnore
    public TextBox getTextBox1508() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1508();
    }

    @JsonIgnore
    public TextBox getTextBox1509() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1509();
    }

    @JsonIgnore
    public TextBox getTextBox1510() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1510();
    }

    @JsonIgnore
    public TextBox getTextBox1511() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1511();
    }

    @JsonIgnore
    public TextBox getTextBox1512() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1512();
    }

    @JsonIgnore
    public TextBox getTextBox1513() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1513();
    }

    @JsonIgnore
    public TextBox getTextBox1514() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1514();
    }

    @JsonIgnore
    public TextBox getTextBox1515() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1515();
    }

    @JsonIgnore
    public TextBox getTextBox1516() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1516();
    }

    @JsonIgnore
    public TextBox getTextBox1517() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1517();
    }

    @JsonIgnore
    public TextBox getTextBox1518() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1518();
    }

    @JsonIgnore
    public TextBox getTextBox1519() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1519();
    }

    @JsonIgnore
    public TextBox getTextBox1520() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1520();
    }

    @JsonIgnore
    public TextBox getTextBox1521() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1521();
    }

    @JsonIgnore
    public TextBox getTextBox1522() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1522();
    }

    @JsonIgnore
    public TextBox getTextBox1523() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1523();
    }

    @JsonIgnore
    public TextBox getTextBox1524() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1524();
    }

    @JsonIgnore
    public TextBox getTextBox1525() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1525();
    }

    @JsonIgnore
    public TextBox getTextBox1526() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1526();
    }

    @JsonIgnore
    public TextBox getTextBox1527() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1527();
    }

    @JsonIgnore
    public TextBox getTextBox1528() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1528();
    }

    @JsonIgnore
    public TextBox getTextBox1529() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1529();
    }

    @JsonIgnore
    public TextBox getTextBox1530() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1530();
    }

    @JsonIgnore
    public TextBox getTextBox1531() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1531();
    }

    @JsonIgnore
    public TextBox getTextBox1532() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1532();
    }

    @JsonIgnore
    public TextBox getTextBox1533() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1533();
    }

    @JsonIgnore
    public TextBox getTextBox1534() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1534();
    }

    @JsonIgnore
    public TextBox getTextBox1535() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1535();
    }

    @JsonIgnore
    public TextBox getTextBox1536() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1536();
    }

    @JsonIgnore
    public TextBox getTextBox1537() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1537();
    }

    @JsonIgnore
    public TextBox getTextBox1538() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1538();
    }

    @JsonIgnore
    public TextBox getTextBox1539() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1539();
    }

    @JsonIgnore
    public TextBox getTextBox1540() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1540();
    }

    @JsonIgnore
    public TextBox getTextBox1541() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1541();
    }

    @JsonIgnore
    public TextBox getTextBox1542() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1542();
    }

    @JsonIgnore
    public TextBox getTextBox1543() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1543();
    }

    @JsonIgnore
    public TextBox getTextBox1544() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1544();
    }

    @JsonIgnore
    public TextBox getTextBox1545() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1545();
    }

    @JsonIgnore
    public TextBox getTextBox1546() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1546();
    }

    @JsonIgnore
    public TextBox getTextBox1547() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1547();
    }

    @JsonIgnore
    public TextBox getTextBox1548() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1548();
    }

    @JsonIgnore
    public TextBox getTextBox1549() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1549();
    }

    @JsonIgnore
    public TextBox getTextBox1550() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1550();
    }

    @JsonIgnore
    public TextBox getTextBox1551() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1551();
    }

    @JsonIgnore
    public TextBox getTextBox1552() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1552();
    }

    @JsonIgnore
    public TextBox getTextBox1553() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1553();
    }

    @JsonIgnore
    public TextBox getTextBox1554() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1554();
    }

    @JsonIgnore
    public TextBox getTextBox1555() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1555();
    }

    @JsonIgnore
    public TextBox getTextBox1556() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1556();
    }

    @JsonIgnore
    public TextBox getTextBox1557() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1557();
    }

    @JsonIgnore
    public TextBox getTextBox1558() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1558();
    }

    @JsonIgnore
    public TextBox getTextBox1559() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1559();
    }

    @JsonIgnore
    public TextBox getTextBox1560() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1560();
    }

    @JsonIgnore
    public TextBox getTextBox1561() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1561();
    }

    @JsonIgnore
    public TextBox getTextBox1562() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1562();
    }

    @JsonIgnore
    public TextBox getTextBox1563() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1563();
    }

    @JsonIgnore
    public TextBox getTextBox1564() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1564();
    }

    @JsonIgnore
    public TextBox getTextBox1565() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1565();
    }

    @JsonIgnore
    public TextBox getTextBox1566() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1566();
    }

    @JsonIgnore
    public TextBox getTextBox1567() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1567();
    }

    @JsonIgnore
    public TextBox getTextBox1568() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1568();
    }

    @JsonIgnore
    public TextBox getTextBox1569() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1569();
    }

    @JsonIgnore
    public TextBox getTextBox1570() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1570();
    }

    @JsonIgnore
    public TextBox getTextBox1571() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1571();
    }

    @JsonIgnore
    public TextBox getTextBox1572() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1572();
    }

    @JsonIgnore
    public TextBox getTextBox1573() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1573();
    }

    @JsonIgnore
    public TextBox getTextBox1574() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1574();
    }

    @JsonIgnore
    public TextBox getTextBox1575() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1575();
    }

    @JsonIgnore
    public TextBox getTextBox1576() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1576();
    }

    @JsonIgnore
    public TextBox getTextBox1577() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1577();
    }

    @JsonIgnore
    public TextBox getTextBox1578() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1578();
    }

    @JsonIgnore
    public TextBox getTextBox1579() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1579();
    }

    @JsonIgnore
    public TextBox getTextBox1580() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1580();
    }

    @JsonIgnore
    public TextBox getTextBox1581() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1581();
    }

    @JsonIgnore
    public TextBox getTextBox1582() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1582();
    }

    @JsonIgnore
    public TextBox getTextBox1583() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1583();
    }

    @JsonIgnore
    public TextBox getTextBox1584() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1584();
    }

    @JsonIgnore
    public TextBox getTextBox1585() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1585();
    }

    @JsonIgnore
    public TextBox getTextBox1586() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1586();
    }

    @JsonIgnore
    public TextBox getTextBox1587() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1587();
    }

    @JsonIgnore
    public TextBox getTextBox1588() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1588();
    }

    @JsonIgnore
    public TextBox getTextBox1589() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1589();
    }

    @JsonIgnore
    public TextBox getTextBox1590() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1590();
    }

    @JsonIgnore
    public TextBox getTextBox1591() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1591();
    }

    @JsonIgnore
    public TextBox getTextBox1592() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1592();
    }

    @JsonIgnore
    public TextBox getTextBox1593() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1593();
    }

    @JsonIgnore
    public TextBox getTextBox1594() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1594();
    }

    @JsonIgnore
    public TextBox getTextBox1595() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1595();
    }

    @JsonIgnore
    public TextBox getTextBox1596() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1596();
    }

    @JsonIgnore
    public TextBox getTextBox1597() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1597();
    }

    @JsonIgnore
    public TextBox getTextBox1598() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1598();
    }

    @JsonIgnore
    public TextBox getTextBox1599() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1599();
    }

    @JsonIgnore
    public TextBox getTextBox1600() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1600();
    }

    @JsonIgnore
    public TextBox getTextBox1601() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1601();
    }

    @JsonIgnore
    public TextBox getTextBox1602() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1602();
    }

    @JsonIgnore
    public TextBox getTextBox1603() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1603();
    }

    @JsonIgnore
    public TextBox getTextBox1604() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1604();
    }

    @JsonIgnore
    public TextBox getTextBox1605() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1605();
    }

    @JsonIgnore
    public TextBox getTextBox1606() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1606();
    }

    @JsonIgnore
    public TextBox getTextBox1607() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1607();
    }

    @JsonIgnore
    public TextBox getTextBox1608() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1608();
    }

    @JsonIgnore
    public TextBox getTextBox1609() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1609();
    }

    @JsonIgnore
    public TextBox getTextBox1610() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1610();
    }

    @JsonIgnore
    public TextBox getTextBox1611() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1611();
    }

    @JsonIgnore
    public TextBox getTextBox1612() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1612();
    }

    @JsonIgnore
    public TextBox getTextBox1613() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1613();
    }

    @JsonIgnore
    public TextBox getTextBox1614() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1614();
    }

    // </editor-fold>
}
