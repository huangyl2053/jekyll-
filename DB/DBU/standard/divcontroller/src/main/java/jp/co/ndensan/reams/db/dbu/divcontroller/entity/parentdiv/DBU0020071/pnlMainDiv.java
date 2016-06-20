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
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * pnlMain のクラスファイル
 *
 * @reamsid_L DBU-1100-090 lijunjun
 */
public class pnlMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    public TextBoxNum getTextBox1() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox1();
    }

    @JsonIgnore
    public TextBoxNum getTextBox2() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox2();
    }

    @JsonIgnore
    public TextBoxNum getTextBox3() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox3();
    }

    @JsonIgnore
    public TextBoxNum getTextBox4() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox4();
    }

    @JsonIgnore
    public TextBoxNum getTextBox5() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox5();
    }

    @JsonIgnore
    public TextBoxNum getTextBox6() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox6();
    }

    @JsonIgnore
    public TextBoxNum getTextBox7() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox7();
    }

    @JsonIgnore
    public TextBoxNum getTextBox8() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox8();
    }

    @JsonIgnore
    public TextBoxNum getTextBox9() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox9();
    }

    @JsonIgnore
    public TextBoxNum getTextBox10() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox10();
    }

    @JsonIgnore
    public TextBoxNum getTextBox11() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox11();
    }

    @JsonIgnore
    public TextBoxNum getTextBox12() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox12();
    }

    @JsonIgnore
    public TextBoxNum getTextBox13() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox13();
    }

    @JsonIgnore
    public TextBoxNum getTextBox14() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox14();
    }

    @JsonIgnore
    public TextBoxNum getTextBox15() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox15();
    }

    @JsonIgnore
    public TextBoxNum getTextBox16() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox16();
    }

    @JsonIgnore
    public TextBoxNum getTextBox17() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox17();
    }

    @JsonIgnore
    public TextBoxNum getTextBox18() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox18();
    }

    @JsonIgnore
    public TextBoxNum getTextBox19() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox19();
    }

    @JsonIgnore
    public TextBoxNum getTextBox20() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox20();
    }

    @JsonIgnore
    public TextBoxNum getTextBox21() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox21();
    }

    @JsonIgnore
    public TextBoxNum getTextBox22() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox22();
    }

    @JsonIgnore
    public TextBoxNum getTextBox23() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox23();
    }

    @JsonIgnore
    public TextBoxNum getTextBox24() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox24();
    }

    @JsonIgnore
    public TextBoxNum getTextBox25() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox25();
    }

    @JsonIgnore
    public TextBoxNum getTextBox26() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox26();
    }

    @JsonIgnore
    public TextBoxNum getTextBox27() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox27();
    }

    @JsonIgnore
    public TextBoxNum getTextBox28() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox28();
    }

    @JsonIgnore
    public TextBoxNum getTextBox29() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox29();
    }

    @JsonIgnore
    public TextBoxNum getTextBox30() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox30();
    }

    @JsonIgnore
    public TextBoxNum getTextBox31() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox31();
    }

    @JsonIgnore
    public TextBoxNum getTextBox32() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox32();
    }

    @JsonIgnore
    public TextBoxNum getTextBox33() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox33();
    }

    @JsonIgnore
    public TextBoxNum getTextBox35() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox35();
    }

    @JsonIgnore
    public TextBoxNum getTextBox36() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox36();
    }

    @JsonIgnore
    public TextBoxNum getTextBox37() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox37();
    }

    @JsonIgnore
    public TextBoxNum getTextBox38() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox38();
    }

    @JsonIgnore
    public TextBoxNum getTextBox39() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox39();
    }

    @JsonIgnore
    public TextBoxNum getTextBox40() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox40();
    }

    @JsonIgnore
    public TextBoxNum getTextBox41() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox41();
    }

    @JsonIgnore
    public TextBoxNum getTextBox42() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox42();
    }

    @JsonIgnore
    public TextBoxNum getTextBox43() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox43();
    }

    @JsonIgnore
    public TextBoxNum getTextBox44() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox44();
    }

    @JsonIgnore
    public TextBoxNum getTextBox34() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox34();
    }

    @JsonIgnore
    public TextBoxNum getTextBox45() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox45();
    }

    @JsonIgnore
    public TextBoxNum getTextBox46() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox46();
    }

    @JsonIgnore
    public TextBoxNum getTextBox47() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox47();
    }

    @JsonIgnore
    public TextBoxNum getTextBox48() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox48();
    }

    @JsonIgnore
    public TextBoxNum getTextBox49() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox49();
    }

    @JsonIgnore
    public TextBoxNum getTextBox50() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox50();
    }

    @JsonIgnore
    public TextBoxNum getTextBox51() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox51();
    }

    @JsonIgnore
    public TextBoxNum getTextBox52() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox52();
    }

    @JsonIgnore
    public TextBoxNum getTextBox53() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox53();
    }

    @JsonIgnore
    public TextBoxNum getTextBox54() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox54();
    }

    @JsonIgnore
    public TextBoxNum getTextBox55() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox55();
    }

    @JsonIgnore
    public TextBoxNum getTextBox56() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox56();
    }

    @JsonIgnore
    public TextBoxNum getTextBox57() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox57();
    }

    @JsonIgnore
    public TextBoxNum getTextBox58() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox58();
    }

    @JsonIgnore
    public TextBoxNum getTextBox59() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox59();
    }

    @JsonIgnore
    public TextBoxNum getTextBox60() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox60();
    }

    @JsonIgnore
    public TextBoxNum getTextBox61() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox61();
    }

    @JsonIgnore
    public TextBoxNum getTextBox62() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox62();
    }

    @JsonIgnore
    public TextBoxNum getTextBox63() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox63();
    }

    @JsonIgnore
    public TextBoxNum getTextBox64() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox64();
    }

    @JsonIgnore
    public TextBoxNum getTextBox65() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox65();
    }

    @JsonIgnore
    public TextBoxNum getTextBox66() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox66();
    }

    @JsonIgnore
    public TextBoxNum getTextBox67() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox67();
    }

    @JsonIgnore
    public TextBoxNum getTextBox68() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox68();
    }

    @JsonIgnore
    public TextBoxNum getTextBox69() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox69();
    }

    @JsonIgnore
    public TextBoxNum getTextBox70() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox70();
    }

    @JsonIgnore
    public TextBoxNum getTextBox71() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox71();
    }

    @JsonIgnore
    public TextBoxNum getTextBox72() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox72();
    }

    @JsonIgnore
    public TextBoxNum getTextBox73() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox73();
    }

    @JsonIgnore
    public TextBoxNum getTextBox74() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox74();
    }

    @JsonIgnore
    public TextBoxNum getTextBox75() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox75();
    }

    @JsonIgnore
    public TextBoxNum getTextBox76() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox76();
    }

    @JsonIgnore
    public TextBoxNum getTextBox77() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox77();
    }

    @JsonIgnore
    public TextBoxNum getTextBox78() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox78();
    }

    @JsonIgnore
    public TextBoxNum getTextBox79() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox79();
    }

    @JsonIgnore
    public TextBoxNum getTextBox80() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox80();
    }

    @JsonIgnore
    public TextBoxNum getTextBox81() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox81();
    }

    @JsonIgnore
    public TextBoxNum getTextBox82() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox82();
    }

    @JsonIgnore
    public TextBoxNum getTextBox83() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox83();
    }

    @JsonIgnore
    public TextBoxNum getTextBox84() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox84();
    }

    @JsonIgnore
    public TextBoxNum getTextBox85() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox85();
    }

    @JsonIgnore
    public TextBoxNum getTextBox86() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox86();
    }

    @JsonIgnore
    public TextBoxNum getTextBox87() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox87();
    }

    @JsonIgnore
    public TextBoxNum getTextBox88() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox88();
    }

    @JsonIgnore
    public TextBoxNum getTextBox89() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox89();
    }

    @JsonIgnore
    public TextBoxNum getTextBox90() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox90();
    }

    @JsonIgnore
    public TextBoxNum getTextBox91() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox91();
    }

    @JsonIgnore
    public TextBoxNum getTextBox92() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox92();
    }

    @JsonIgnore
    public TextBoxNum getTextBox93() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox93();
    }

    @JsonIgnore
    public TextBoxNum getTextBox94() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox94();
    }

    @JsonIgnore
    public TextBoxNum getTextBox95() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox95();
    }

    @JsonIgnore
    public TextBoxNum getTextBox96() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox96();
    }

    @JsonIgnore
    public TextBoxNum getTextBox97() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox97();
    }

    @JsonIgnore
    public TextBoxNum getTextBox98() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox98();
    }

    @JsonIgnore
    public TextBoxNum getTextBox99() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox99();
    }

    @JsonIgnore
    public TextBoxNum getTextBox100() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox100();
    }

    @JsonIgnore
    public TextBoxNum getTextBox101() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox101();
    }

    @JsonIgnore
    public TextBoxNum getTextBox102() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox102();
    }

    @JsonIgnore
    public TextBoxNum getTextBox103() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox103();
    }

    @JsonIgnore
    public TextBoxNum getTextBox104() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox104();
    }

    @JsonIgnore
    public TextBoxNum getTextBox105() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox105();
    }

    @JsonIgnore
    public TextBoxNum getTextBox106() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox106();
    }

    @JsonIgnore
    public TextBoxNum getTextBox107() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox107();
    }

    @JsonIgnore
    public TextBoxNum getTextBox108() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox108();
    }

    @JsonIgnore
    public TextBoxNum getTextBox109() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox109();
    }

    @JsonIgnore
    public TextBoxNum getTextBox110() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox110();
    }

    @JsonIgnore
    public TextBoxNum getTextBox111() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox111();
    }

    @JsonIgnore
    public TextBoxNum getTextBox112() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox112();
    }

    @JsonIgnore
    public TextBoxNum getTextBox113() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox113();
    }

    @JsonIgnore
    public TextBoxNum getTextBox114() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox114();
    }

    @JsonIgnore
    public TextBoxNum getTextBox115() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox115();
    }

    @JsonIgnore
    public TextBoxNum getTextBox116() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox116();
    }

    @JsonIgnore
    public TextBoxNum getTextBox117() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox117();
    }

    @JsonIgnore
    public TextBoxNum getTextBox118() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox118();
    }

    @JsonIgnore
    public TextBoxNum getTextBox119() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox119();
    }

    @JsonIgnore
    public TextBoxNum getTextBox120() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox120();
    }

    @JsonIgnore
    public TextBoxNum getTextBox121() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox121();
    }

    @JsonIgnore
    public TextBoxNum getTextBox122() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox122();
    }

    @JsonIgnore
    public TextBoxNum getTextBox123() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox123();
    }

    @JsonIgnore
    public TextBoxNum getTextBox124() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox124();
    }

    @JsonIgnore
    public TextBoxNum getTextBox125() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox125();
    }

    @JsonIgnore
    public TextBoxNum getTextBox126() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox126();
    }

    @JsonIgnore
    public TextBoxNum getTextBox127() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox127();
    }

    @JsonIgnore
    public TextBoxNum getTextBox128() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox128();
    }

    @JsonIgnore
    public TextBoxNum getTextBox129() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox129();
    }

    @JsonIgnore
    public TextBoxNum getTextBox130() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox130();
    }

    @JsonIgnore
    public TextBoxNum getTextBox131() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox131();
    }

    @JsonIgnore
    public TextBoxNum getTextBox132() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox132();
    }

    @JsonIgnore
    public TextBoxNum getTextBox133() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox133();
    }

    @JsonIgnore
    public TextBoxNum getTextBox134() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox134();
    }

    @JsonIgnore
    public TextBoxNum getTextBox135() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox135();
    }

    @JsonIgnore
    public TextBoxNum getTextBox136() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox136();
    }

    @JsonIgnore
    public TextBoxNum getTextBox137() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox137();
    }

    @JsonIgnore
    public TextBoxNum getTextBox138() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox138();
    }

    @JsonIgnore
    public TextBoxNum getTextBox139() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox139();
    }

    @JsonIgnore
    public TextBoxNum getTextBox140() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox140();
    }

    @JsonIgnore
    public TextBoxNum getTextBox141() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox141();
    }

    @JsonIgnore
    public TextBoxNum getTextBox142() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox142();
    }

    @JsonIgnore
    public TextBoxNum getTextBox143() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox143();
    }

    @JsonIgnore
    public TextBoxNum getTextBox144() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox144();
    }

    @JsonIgnore
    public TextBoxNum getTextBox145() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox145();
    }

    @JsonIgnore
    public TextBoxNum getTextBox146() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox146();
    }

    @JsonIgnore
    public TextBoxNum getTextBox147() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox147();
    }

    @JsonIgnore
    public TextBoxNum getTextBox148() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox148();
    }

    @JsonIgnore
    public TextBoxNum getTextBox149() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox149();
    }

    @JsonIgnore
    public TextBoxNum getTextBox150() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox150();
    }

    @JsonIgnore
    public TextBoxNum getTextBox151() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox151();
    }

    @JsonIgnore
    public TextBoxNum getTextBox152() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox152();
    }

    @JsonIgnore
    public TextBoxNum getTextBox153() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox153();
    }

    @JsonIgnore
    public TextBoxNum getTextBox154() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox154();
    }

    @JsonIgnore
    public TextBoxNum getTextBox155() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox155();
    }

    @JsonIgnore
    public TextBoxNum getTextBox156() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox156();
    }

    @JsonIgnore
    public TextBoxNum getTextBox157() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox157();
    }

    @JsonIgnore
    public TextBoxNum getTextBox158() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox158();
    }

    @JsonIgnore
    public TextBoxNum getTextBox159() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox159();
    }

    @JsonIgnore
    public TextBoxNum getTextBox160() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox160();
    }

    @JsonIgnore
    public TextBoxNum getTextBox161() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox161();
    }

    @JsonIgnore
    public TextBoxNum getTextBox162() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox162();
    }

    @JsonIgnore
    public TextBoxNum getTextBox163() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox163();
    }

    @JsonIgnore
    public TextBoxNum getTextBox164() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox164();
    }

    @JsonIgnore
    public TextBoxNum getTextBox165() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox165();
    }

    @JsonIgnore
    public TextBoxNum getTextBox166() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox166();
    }

    @JsonIgnore
    public TextBoxNum getTextBox167() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox167();
    }

    @JsonIgnore
    public TextBoxNum getTextBox168() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox168();
    }

    @JsonIgnore
    public TextBoxNum getTextBox169() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox169();
    }

    @JsonIgnore
    public TextBoxNum getTextBox170() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox170();
    }

    @JsonIgnore
    public TextBoxNum getTextBox171() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox171();
    }

    @JsonIgnore
    public TextBoxNum getTextBox172() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox172();
    }

    @JsonIgnore
    public TextBoxNum getTextBox173() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox173();
    }

    @JsonIgnore
    public TextBoxNum getTextBox174() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox174();
    }

    @JsonIgnore
    public TextBoxNum getTextBox175() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox175();
    }

    @JsonIgnore
    public TextBoxNum getTextBox176() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox176();
    }

    @JsonIgnore
    public TextBoxNum getTextBox177() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox177();
    }

    @JsonIgnore
    public TextBoxNum getTextBox178() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox178();
    }

    @JsonIgnore
    public TextBoxNum getTextBox179() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox179();
    }

    @JsonIgnore
    public TextBoxNum getTextBox180() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox180();
    }

    @JsonIgnore
    public TextBoxNum getTextBox181() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox181();
    }

    @JsonIgnore
    public TextBoxNum getTextBox182() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox182();
    }

    @JsonIgnore
    public TextBoxNum getTextBox183() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox183();
    }

    @JsonIgnore
    public TextBoxNum getTextBox184() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox184();
    }

    @JsonIgnore
    public TextBoxNum getTextBox185() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox185();
    }

    @JsonIgnore
    public TextBoxNum getTextBox186() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox186();
    }

    @JsonIgnore
    public TextBoxNum getTextBox187() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox187();
    }

    @JsonIgnore
    public TextBoxNum getTextBox188() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox188();
    }

    @JsonIgnore
    public TextBoxNum getTextBox189() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox189();
    }

    @JsonIgnore
    public TextBoxNum getTextBox190() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox190();
    }

    @JsonIgnore
    public TextBoxNum getTextBox191() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox191();
    }

    @JsonIgnore
    public TextBoxNum getTextBox192() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox192();
    }

    @JsonIgnore
    public TextBoxNum getTextBox193() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox193();
    }

    @JsonIgnore
    public TextBoxNum getTextBox194() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox194();
    }

    @JsonIgnore
    public TextBoxNum getTextBox195() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox195();
    }

    @JsonIgnore
    public TextBoxNum getTextBox196() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox196();
    }

    @JsonIgnore
    public TextBoxNum getTextBox197() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox197();
    }

    @JsonIgnore
    public TextBoxNum getTextBox198() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox198();
    }

    @JsonIgnore
    public TextBoxNum getTextBox199() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox199();
    }

    @JsonIgnore
    public TextBoxNum getTextBox200() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox200();
    }

    @JsonIgnore
    public TextBoxNum getTextBox201() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox201();
    }

    @JsonIgnore
    public TextBoxNum getTextBox202() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox202();
    }

    @JsonIgnore
    public TextBoxNum getTextBox203() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox203();
    }

    @JsonIgnore
    public TextBoxNum getTextBox204() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox204();
    }

    @JsonIgnore
    public TextBoxNum getTextBox205() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox205();
    }

    @JsonIgnore
    public TextBoxNum getTextBox206() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox206();
    }

    @JsonIgnore
    public TextBoxNum getTextBox207() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox207();
    }

    @JsonIgnore
    public TextBoxNum getTextBox208() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox208();
    }

    @JsonIgnore
    public TextBoxNum getTextBox209() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox209();
    }

    @JsonIgnore
    public TextBoxNum getTextBox210() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox210();
    }

    @JsonIgnore
    public TextBoxNum getTextBox211() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox211();
    }

    @JsonIgnore
    public TextBoxNum getTextBox212() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox212();
    }

    @JsonIgnore
    public TextBoxNum getTextBox213() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox213();
    }

    @JsonIgnore
    public TextBoxNum getTextBox214() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox214();
    }

    @JsonIgnore
    public TextBoxNum getTextBox215() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox215();
    }

    @JsonIgnore
    public TextBoxNum getTextBox216() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox216();
    }

    @JsonIgnore
    public TextBoxNum getTextBox217() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox217();
    }

    @JsonIgnore
    public TextBoxNum getTextBox218() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox218();
    }

    @JsonIgnore
    public TextBoxNum getTextBox219() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox219();
    }

    @JsonIgnore
    public TextBoxNum getTextBox220() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox220();
    }

    @JsonIgnore
    public TextBoxNum getTextBox221() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox221();
    }

    @JsonIgnore
    public TextBoxNum getTextBox222() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox222();
    }

    @JsonIgnore
    public TextBoxNum getTextBox223() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox223();
    }

    @JsonIgnore
    public TextBoxNum getTextBox224() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox224();
    }

    @JsonIgnore
    public TextBoxNum getTextBox225() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox225();
    }

    @JsonIgnore
    public TextBoxNum getTextBox226() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox226();
    }

    @JsonIgnore
    public TextBoxNum getTextBox227() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox227();
    }

    @JsonIgnore
    public TextBoxNum getTextBox228() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox228();
    }

    @JsonIgnore
    public TextBoxNum getTextBox229() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox229();
    }

    @JsonIgnore
    public TextBoxNum getTextBox230() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox230();
    }

    @JsonIgnore
    public TextBoxNum getTextBox231() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox231();
    }

    @JsonIgnore
    public TextBoxNum getTextBox232() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox232();
    }

    @JsonIgnore
    public TextBoxNum getTextBox233() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox233();
    }

    @JsonIgnore
    public TextBoxNum getTextBox234() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox234();
    }

    @JsonIgnore
    public TextBoxNum getTextBox235() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox235();
    }

    @JsonIgnore
    public TextBoxNum getTextBox236() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox236();
    }

    @JsonIgnore
    public TextBoxNum getTextBox237() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox237();
    }

    @JsonIgnore
    public TextBoxNum getTextBox238() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox238();
    }

    @JsonIgnore
    public TextBoxNum getTextBox239() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox239();
    }

    @JsonIgnore
    public TextBoxNum getTextBox240() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox240();
    }

    @JsonIgnore
    public TextBoxNum getTextBox241() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox241();
    }

    @JsonIgnore
    public TextBoxNum getTextBox242() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox242();
    }

    @JsonIgnore
    public TextBoxNum getTextBox243() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox243();
    }

    @JsonIgnore
    public TextBoxNum getTextBox244() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox244();
    }

    @JsonIgnore
    public TextBoxNum getTextBox245() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox245();
    }

    @JsonIgnore
    public TextBoxNum getTextBox246() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox246();
    }

    @JsonIgnore
    public TextBoxNum getTextBox247() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox247();
    }

    @JsonIgnore
    public TextBoxNum getTextBox248() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox248();
    }

    @JsonIgnore
    public TextBoxNum getTextBox249() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox249();
    }

    @JsonIgnore
    public TextBoxNum getTextBox250() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox250();
    }

    @JsonIgnore
    public TextBoxNum getTextBox251() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox251();
    }

    @JsonIgnore
    public TextBoxNum getTextBox252() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox252();
    }

    @JsonIgnore
    public TextBoxNum getTextBox253() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox253();
    }

    @JsonIgnore
    public TextBoxNum getTextBox254() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox254();
    }

    @JsonIgnore
    public TextBoxNum getTextBox255() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox255();
    }

    @JsonIgnore
    public TextBoxNum getTextBox256() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox256();
    }

    @JsonIgnore
    public TextBoxNum getTextBox257() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox257();
    }

    @JsonIgnore
    public TextBoxNum getTextBox258() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox258();
    }

    @JsonIgnore
    public TextBoxNum getTextBox259() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox259();
    }

    @JsonIgnore
    public TextBoxNum getTextBox260() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox260();
    }

    @JsonIgnore
    public TextBoxNum getTextBox261() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox261();
    }

    @JsonIgnore
    public TextBoxNum getTextBox262() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox262();
    }

    @JsonIgnore
    public TextBoxNum getTextBox263() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox263();
    }

    @JsonIgnore
    public TextBoxNum getTextBox264() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox264();
    }

    @JsonIgnore
    public TextBoxNum getTextBox265() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox265();
    }

    @JsonIgnore
    public TextBoxNum getTextBox266() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox266();
    }

    @JsonIgnore
    public TextBoxNum getTextBox267() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox267();
    }

    @JsonIgnore
    public TextBoxNum getTextBox268() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox268();
    }

    @JsonIgnore
    public TextBoxNum getTextBox269() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox269();
    }

    @JsonIgnore
    public TextBoxNum getTextBox270() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox270();
    }

    @JsonIgnore
    public TextBoxNum getTextBox271() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox271();
    }

    @JsonIgnore
    public TextBoxNum getTextBox272() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox272();
    }

    @JsonIgnore
    public TextBoxNum getTextBox273() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox273();
    }

    @JsonIgnore
    public TextBoxNum getTextBox274() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox274();
    }

    @JsonIgnore
    public TextBoxNum getTextBox275() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox275();
    }

    @JsonIgnore
    public TextBoxNum getTextBox276() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox276();
    }

    @JsonIgnore
    public TextBoxNum getTextBox277() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox277();
    }

    @JsonIgnore
    public TextBoxNum getTextBox278() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox278();
    }

    @JsonIgnore
    public TextBoxNum getTextBox279() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox279();
    }

    @JsonIgnore
    public TextBoxNum getTextBox280() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox280();
    }

    @JsonIgnore
    public TextBoxNum getTextBox281() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox281();
    }

    @JsonIgnore
    public TextBoxNum getTextBox282() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox282();
    }

    @JsonIgnore
    public TextBoxNum getTextBox283() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox283();
    }

    @JsonIgnore
    public TextBoxNum getTextBox284() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox284();
    }

    @JsonIgnore
    public TextBoxNum getTextBox285() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox285();
    }

    @JsonIgnore
    public TextBoxNum getTextBox286() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox286();
    }

    @JsonIgnore
    public TextBoxNum getTextBox287() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox287();
    }

    @JsonIgnore
    public TextBoxNum getTextBox288() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox288();
    }

    @JsonIgnore
    public TextBoxNum getTextBox289() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox289();
    }

    @JsonIgnore
    public TextBoxNum getTextBox290() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox290();
    }

    @JsonIgnore
    public TextBoxNum getTextBox291() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox291();
    }

    @JsonIgnore
    public TextBoxNum getTextBox292() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox292();
    }

    @JsonIgnore
    public TextBoxNum getTextBox293() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox293();
    }

    @JsonIgnore
    public TextBoxNum getTextBox294() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox294();
    }

    @JsonIgnore
    public TextBoxNum getTextBox295() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox295();
    }

    @JsonIgnore
    public TextBoxNum getTextBox296() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox296();
    }

    @JsonIgnore
    public TextBoxNum getTextBox297() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox297();
    }

    @JsonIgnore
    public TextBoxNum getTextBox298() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox298();
    }

    @JsonIgnore
    public TextBoxNum getTextBox299() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox299();
    }

    @JsonIgnore
    public TextBoxNum getTextBox300() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox300();
    }

    @JsonIgnore
    public TextBoxNum getTextBox301() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox301();
    }

    @JsonIgnore
    public TextBoxNum getTextBox302() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox302();
    }

    @JsonIgnore
    public TextBoxNum getTextBox303() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox303();
    }

    @JsonIgnore
    public TextBoxNum getTextBox304() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox304();
    }

    @JsonIgnore
    public TextBoxNum getTextBox305() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox305();
    }

    @JsonIgnore
    public TextBoxNum getTextBox306() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox306();
    }

    @JsonIgnore
    public TextBoxNum getTextBox307() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox307();
    }

    @JsonIgnore
    public TextBoxNum getTextBox308() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox308();
    }

    @JsonIgnore
    public TextBoxNum getTextBox309() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox309();
    }

    @JsonIgnore
    public TextBoxNum getTextBox310() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox310();
    }

    @JsonIgnore
    public TextBoxNum getTextBox311() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox311();
    }

    @JsonIgnore
    public TextBoxNum getTextBox312() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox312();
    }

    @JsonIgnore
    public TextBoxNum getTextBox313() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox313();
    }

    @JsonIgnore
    public TextBoxNum getTextBox314() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox314();
    }

    @JsonIgnore
    public TextBoxNum getTextBox315() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox315();
    }

    @JsonIgnore
    public TextBoxNum getTextBox316() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox316();
    }

    @JsonIgnore
    public TextBoxNum getTextBox317() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox317();
    }

    @JsonIgnore
    public TextBoxNum getTextBox318() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox318();
    }

    @JsonIgnore
    public TextBoxNum getTextBox319() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox319();
    }

    @JsonIgnore
    public TextBoxNum getTextBox320() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox320();
    }

    @JsonIgnore
    public TextBoxNum getTextBox321() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox321();
    }

    @JsonIgnore
    public TextBoxNum getTextBox322() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox322();
    }

    @JsonIgnore
    public TextBoxNum getTextBox323() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox323();
    }

    @JsonIgnore
    public TextBoxNum getTextBox324() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox324();
    }

    @JsonIgnore
    public TextBoxNum getTextBox325() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox325();
    }

    @JsonIgnore
    public TextBoxNum getTextBox326() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox326();
    }

    @JsonIgnore
    public TextBoxNum getTextBox327() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox327();
    }

    @JsonIgnore
    public TextBoxNum getTextBox328() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox328();
    }

    @JsonIgnore
    public TextBoxNum getTextBox329() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox329();
    }

    @JsonIgnore
    public TextBoxNum getTextBox330() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox330();
    }

    @JsonIgnore
    public TextBoxNum getTextBox331() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox331();
    }

    @JsonIgnore
    public TextBoxNum getTextBox332() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox332();
    }

    @JsonIgnore
    public TextBoxNum getTextBox333() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox333();
    }

    @JsonIgnore
    public TextBoxNum getTextBox334() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox334();
    }

    @JsonIgnore
    public TextBoxNum getTextBox335() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox335();
    }

    @JsonIgnore
    public TextBoxNum getTextBox336() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox336();
    }

    @JsonIgnore
    public TextBoxNum getTextBox337() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox337();
    }

    @JsonIgnore
    public TextBoxNum getTextBox338() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox338();
    }

    @JsonIgnore
    public TextBoxNum getTextBox339() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox339();
    }

    @JsonIgnore
    public TextBoxNum getTextBox340() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox340();
    }

    @JsonIgnore
    public TextBoxNum getTextBox341() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox341();
    }

    @JsonIgnore
    public TextBoxNum getTextBox342() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox342();
    }

    @JsonIgnore
    public TextBoxNum getTextBox343() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox343();
    }

    @JsonIgnore
    public TextBoxNum getTextBox344() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox344();
    }

    @JsonIgnore
    public TextBoxNum getTextBox345() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox345();
    }

    @JsonIgnore
    public TextBoxNum getTextBox346() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox346();
    }

    @JsonIgnore
    public TextBoxNum getTextBox347() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox347();
    }

    @JsonIgnore
    public TextBoxNum getTextBox348() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox348();
    }

    @JsonIgnore
    public TextBoxNum getTextBox349() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox349();
    }

    @JsonIgnore
    public TextBoxNum getTextBox350() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox350();
    }

    @JsonIgnore
    public TextBoxNum getTextBox351() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox351();
    }

    @JsonIgnore
    public TextBoxNum getTextBox352() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox352();
    }

    @JsonIgnore
    public TextBoxNum getTextBox353() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox353();
    }

    @JsonIgnore
    public TextBoxNum getTextBox354() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox354();
    }

    @JsonIgnore
    public TextBoxNum getTextBox355() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox355();
    }

    @JsonIgnore
    public TextBoxNum getTextBox356() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox356();
    }

    @JsonIgnore
    public TextBoxNum getTextBox357() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox357();
    }

    @JsonIgnore
    public TextBoxNum getTextBox358() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox358();
    }

    @JsonIgnore
    public TextBoxNum getTextBox359() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox359();
    }

    @JsonIgnore
    public TextBoxNum getTextBox360() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox360();
    }

    @JsonIgnore
    public TextBoxNum getTextBox361() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox361();
    }

    @JsonIgnore
    public TextBoxNum getTextBox362() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox362();
    }

    @JsonIgnore
    public TextBoxNum getTextBox363() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox363();
    }

    @JsonIgnore
    public TextBoxNum getTextBox364() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox364();
    }

    @JsonIgnore
    public TextBoxNum getTextBox365() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox365();
    }

    @JsonIgnore
    public TextBoxNum getTextBox366() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox366();
    }

    @JsonIgnore
    public TextBoxNum getTextBox367() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox367();
    }

    @JsonIgnore
    public TextBoxNum getTextBox368() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox368();
    }

    @JsonIgnore
    public TextBoxNum getTextBox369() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox369();
    }

    @JsonIgnore
    public TextBoxNum getTextBox370() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox370();
    }

    @JsonIgnore
    public TextBoxNum getTextBox371() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox371();
    }

    @JsonIgnore
    public TextBoxNum getTextBox372() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox372();
    }

    @JsonIgnore
    public TextBoxNum getTextBox373() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox373();
    }

    @JsonIgnore
    public TextBoxNum getTextBox374() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox374();
    }

    @JsonIgnore
    public TextBoxNum getTextBox375() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox375();
    }

    @JsonIgnore
    public TextBoxNum getTextBox376() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox376();
    }

    @JsonIgnore
    public TextBoxNum getTextBox377() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox377();
    }

    @JsonIgnore
    public TextBoxNum getTextBox378() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox378();
    }

    @JsonIgnore
    public TextBoxNum getTextBox379() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox379();
    }

    @JsonIgnore
    public TextBoxNum getTextBox380() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox380();
    }

    @JsonIgnore
    public TextBoxNum getTextBox381() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox381();
    }

    @JsonIgnore
    public TextBoxNum getTextBox382() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox382();
    }

    @JsonIgnore
    public TextBoxNum getTextBox383() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox383();
    }

    @JsonIgnore
    public TextBoxNum getTextBox384() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox384();
    }

    @JsonIgnore
    public TextBoxNum getTextBox385() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox385();
    }

    @JsonIgnore
    public TextBoxNum getTextBox386() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox386();
    }

    @JsonIgnore
    public TextBoxNum getTextBox387() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox387();
    }

    @JsonIgnore
    public TextBoxNum getTextBox388() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox388();
    }

    @JsonIgnore
    public TextBoxNum getTextBox389() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox389();
    }

    @JsonIgnore
    public TextBoxNum getTextBox390() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox390();
    }

    @JsonIgnore
    public TextBoxNum getTextBox391() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox391();
    }

    @JsonIgnore
    public TextBoxNum getTextBox392() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox392();
    }

    @JsonIgnore
    public TextBoxNum getTextBox393() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox393();
    }

    @JsonIgnore
    public TextBoxNum getTextBox394() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox394();
    }

    @JsonIgnore
    public TextBoxNum getTextBox395() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox395();
    }

    @JsonIgnore
    public TextBoxNum getTextBox396() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox396();
    }

    @JsonIgnore
    public TextBoxNum getTextBox397() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox397();
    }

    @JsonIgnore
    public TextBoxNum getTextBox398() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox398();
    }

    @JsonIgnore
    public TextBoxNum getTextBox399() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox399();
    }

    @JsonIgnore
    public TextBoxNum getTextBox400() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox400();
    }

    @JsonIgnore
    public TextBoxNum getTextBox401() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox401();
    }

    @JsonIgnore
    public TextBoxNum getTextBox402() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox402();
    }

    @JsonIgnore
    public TextBoxNum getTextBox403() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox403();
    }

    @JsonIgnore
    public TextBoxNum getTextBox404() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox404();
    }

    @JsonIgnore
    public TextBoxNum getTextBox405() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox405();
    }

    @JsonIgnore
    public TextBoxNum getTextBox406() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox406();
    }

    @JsonIgnore
    public TextBoxNum getTextBox407() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox407();
    }

    @JsonIgnore
    public TextBoxNum getTextBox408() {
        return this.getTcMain().getTpl1().getTbl1().getTextBox408();
    }

    @JsonIgnore
    public TextBoxNum getTextBox409() {
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
    public TextBoxNum getTextBox410() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox410();
    }

    @JsonIgnore
    public TextBoxNum getTextBox411() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox411();
    }

    @JsonIgnore
    public TextBoxNum getTextBox412() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox412();
    }

    @JsonIgnore
    public TextBoxNum getTextBox413() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox413();
    }

    @JsonIgnore
    public TextBoxNum getTextBox414() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox414();
    }

    @JsonIgnore
    public TextBoxNum getTextBox415() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox415();
    }

    @JsonIgnore
    public TextBoxNum getTextBox416() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox416();
    }

    @JsonIgnore
    public TextBoxNum getTextBox417() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox417();
    }

    @JsonIgnore
    public TextBoxNum getTextBox418() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox418();
    }

    @JsonIgnore
    public TextBoxNum getTextBox419() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox419();
    }

    @JsonIgnore
    public TextBoxNum getTextBox420() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox420();
    }

    @JsonIgnore
    public TextBoxNum getTextBox421() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox421();
    }

    @JsonIgnore
    public TextBoxNum getTextBox422() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox422();
    }

    @JsonIgnore
    public TextBoxNum getTextBox423() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox423();
    }

    @JsonIgnore
    public TextBoxNum getTextBox424() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox424();
    }

    @JsonIgnore
    public TextBoxNum getTextBox425() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox425();
    }

    @JsonIgnore
    public TextBoxNum getTextBox426() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox426();
    }

    @JsonIgnore
    public TextBoxNum getTextBox427() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox427();
    }

    @JsonIgnore
    public TextBoxNum getTextBox428() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox428();
    }

    @JsonIgnore
    public TextBoxNum getTextBox429() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox429();
    }

    @JsonIgnore
    public TextBoxNum getTextBox430() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox430();
    }

    @JsonIgnore
    public TextBoxNum getTextBox431() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox431();
    }

    @JsonIgnore
    public TextBoxNum getTextBox432() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox432();
    }

    @JsonIgnore
    public TextBoxNum getTextBox433() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox433();
    }

    @JsonIgnore
    public TextBoxNum getTextBox434() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox434();
    }

    @JsonIgnore
    public TextBoxNum getTextBox435() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox435();
    }

    @JsonIgnore
    public TextBoxNum getTextBox436() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox436();
    }

    @JsonIgnore
    public TextBoxNum getTextBox437() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox437();
    }

    @JsonIgnore
    public TextBoxNum getTextBox438() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox438();
    }

    @JsonIgnore
    public TextBoxNum getTextBox439() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox439();
    }

    @JsonIgnore
    public TextBoxNum getTextBox440() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox440();
    }

    @JsonIgnore
    public TextBoxNum getTextBox441() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox441();
    }

    @JsonIgnore
    public TextBoxNum getTextBox442() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox442();
    }

    @JsonIgnore
    public TextBoxNum getTextBox443() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox443();
    }

    @JsonIgnore
    public TextBoxNum getTextBox444() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox444();
    }

    @JsonIgnore
    public TextBoxNum getTextBox445() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox445();
    }

    @JsonIgnore
    public TextBoxNum getTextBox446() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox446();
    }

    @JsonIgnore
    public TextBoxNum getTextBox447() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox447();
    }

    @JsonIgnore
    public TextBoxNum getTextBox448() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox448();
    }

    @JsonIgnore
    public TextBoxNum getTextBox449() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox449();
    }

    @JsonIgnore
    public TextBoxNum getTextBox450() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox450();
    }

    @JsonIgnore
    public TextBoxNum getTextBox451() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox451();
    }

    @JsonIgnore
    public TextBoxNum getTextBox452() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox452();
    }

    @JsonIgnore
    public TextBoxNum getTextBox453() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox453();
    }

    @JsonIgnore
    public TextBoxNum getTextBox454() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox454();
    }

    @JsonIgnore
    public TextBoxNum getTextBox455() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox455();
    }

    @JsonIgnore
    public TextBoxNum getTextBox456() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox456();
    }

    @JsonIgnore
    public TextBoxNum getTextBox457() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox457();
    }

    @JsonIgnore
    public TextBoxNum getTextBox458() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox458();
    }

    @JsonIgnore
    public TextBoxNum getTextBox459() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox459();
    }

    @JsonIgnore
    public TextBoxNum getTextBox460() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox460();
    }

    @JsonIgnore
    public TextBoxNum getTextBox461() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox461();
    }

    @JsonIgnore
    public TextBoxNum getTextBox462() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox462();
    }

    @JsonIgnore
    public TextBoxNum getTextBox463() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox463();
    }

    @JsonIgnore
    public TextBoxNum getTextBox464() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox464();
    }

    @JsonIgnore
    public TextBoxNum getTextBox465() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox465();
    }

    @JsonIgnore
    public TextBoxNum getTextBox466() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox466();
    }

    @JsonIgnore
    public TextBoxNum getTextBox467() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox467();
    }

    @JsonIgnore
    public TextBoxNum getTextBox468() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox468();
    }

    @JsonIgnore
    public TextBoxNum getTextBox469() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox469();
    }

    @JsonIgnore
    public TextBoxNum getTextBox470() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox470();
    }

    @JsonIgnore
    public TextBoxNum getTextBox471() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox471();
    }

    @JsonIgnore
    public TextBoxNum getTextBox472() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox472();
    }

    @JsonIgnore
    public TextBoxNum getTextBox473() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox473();
    }

    @JsonIgnore
    public TextBoxNum getTextBox474() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox474();
    }

    @JsonIgnore
    public TextBoxNum getTextBox475() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox475();
    }

    @JsonIgnore
    public TextBoxNum getTextBox476() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox476();
    }

    @JsonIgnore
    public TextBoxNum getTextBox477() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox477();
    }

    @JsonIgnore
    public TextBoxNum getTextBox478() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox478();
    }

    @JsonIgnore
    public TextBoxNum getTextBox479() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox479();
    }

    @JsonIgnore
    public TextBoxNum getTextBox480() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox480();
    }

    @JsonIgnore
    public TextBoxNum getTextBox481() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox481();
    }

    @JsonIgnore
    public TextBoxNum getTextBox482() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox482();
    }

    @JsonIgnore
    public TextBoxNum getTextBox483() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox483();
    }

    @JsonIgnore
    public TextBoxNum getTextBox484() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox484();
    }

    @JsonIgnore
    public TextBoxNum getTextBox485() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox485();
    }

    @JsonIgnore
    public TextBoxNum getTextBox486() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox486();
    }

    @JsonIgnore
    public TextBoxNum getTextBox487() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox487();
    }

    @JsonIgnore
    public TextBoxNum getTextBox488() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox488();
    }

    @JsonIgnore
    public TextBoxNum getTextBox489() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox489();
    }

    @JsonIgnore
    public TextBoxNum getTextBox490() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox490();
    }

    @JsonIgnore
    public TextBoxNum getTextBox491() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox491();
    }

    @JsonIgnore
    public TextBoxNum getTextBox492() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox492();
    }

    @JsonIgnore
    public TextBoxNum getTextBox493() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox493();
    }

    @JsonIgnore
    public TextBoxNum getTextBox494() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox494();
    }

    @JsonIgnore
    public TextBoxNum getTextBox495() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox495();
    }

    @JsonIgnore
    public TextBoxNum getTextBox496() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox496();
    }

    @JsonIgnore
    public TextBoxNum getTextBox497() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox497();
    }

    @JsonIgnore
    public TextBoxNum getTextBox498() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox498();
    }

    @JsonIgnore
    public TextBoxNum getTextBox499() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox499();
    }

    @JsonIgnore
    public TextBoxNum getTextBox500() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox500();
    }

    @JsonIgnore
    public TextBoxNum getTextBox501() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox501();
    }

    @JsonIgnore
    public TextBoxNum getTextBox502() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox502();
    }

    @JsonIgnore
    public TextBoxNum getTextBox503() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox503();
    }

    @JsonIgnore
    public TextBoxNum getTextBox504() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox504();
    }

    @JsonIgnore
    public TextBoxNum getTextBox505() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox505();
    }

    @JsonIgnore
    public TextBoxNum getTextBox506() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox506();
    }

    @JsonIgnore
    public TextBoxNum getTextBox507() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox507();
    }

    @JsonIgnore
    public TextBoxNum getTextBox508() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox508();
    }

    @JsonIgnore
    public TextBoxNum getTextBox509() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox509();
    }

    @JsonIgnore
    public TextBoxNum getTextBox510() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox510();
    }

    @JsonIgnore
    public TextBoxNum getTextBox511() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox511();
    }

    @JsonIgnore
    public TextBoxNum getTextBox512() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox512();
    }

    @JsonIgnore
    public TextBoxNum getTextBox513() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox513();
    }

    @JsonIgnore
    public TextBoxNum getTextBox514() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox514();
    }

    @JsonIgnore
    public TextBoxNum getTextBox515() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox515();
    }

    @JsonIgnore
    public TextBoxNum getTextBox516() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox516();
    }

    @JsonIgnore
    public TextBoxNum getTextBox517() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox517();
    }

    @JsonIgnore
    public TextBoxNum getTextBox518() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox518();
    }

    @JsonIgnore
    public TextBoxNum getTextBox519() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox519();
    }

    @JsonIgnore
    public TextBoxNum getTextBox520() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox520();
    }

    @JsonIgnore
    public TextBoxNum getTextBox521() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox521();
    }

    @JsonIgnore
    public TextBoxNum getTextBox522() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox522();
    }

    @JsonIgnore
    public TextBoxNum getTextBox523() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox523();
    }

    @JsonIgnore
    public TextBoxNum getTextBox524() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox524();
    }

    @JsonIgnore
    public TextBoxNum getTextBox525() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox525();
    }

    @JsonIgnore
    public TextBoxNum getTextBox526() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox526();
    }

    @JsonIgnore
    public TextBoxNum getTextBox527() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox527();
    }

    @JsonIgnore
    public TextBoxNum getTextBox528() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox528();
    }

    @JsonIgnore
    public TextBoxNum getTextBox529() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox529();
    }

    @JsonIgnore
    public TextBoxNum getTextBox530() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox530();
    }

    @JsonIgnore
    public TextBoxNum getTextBox531() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox531();
    }

    @JsonIgnore
    public TextBoxNum getTextBox532() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox532();
    }

    @JsonIgnore
    public TextBoxNum getTextBox533() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox533();
    }

    @JsonIgnore
    public TextBoxNum getTextBox534() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox534();
    }

    @JsonIgnore
    public TextBoxNum getTextBox535() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox535();
    }

    @JsonIgnore
    public TextBoxNum getTextBox536() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox536();
    }

    @JsonIgnore
    public TextBoxNum getTextBox537() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox537();
    }

    @JsonIgnore
    public TextBoxNum getTextBox538() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox538();
    }

    @JsonIgnore
    public TextBoxNum getTextBox539() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox539();
    }

    @JsonIgnore
    public TextBoxNum getTextBox540() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox540();
    }

    @JsonIgnore
    public TextBoxNum getTextBox541() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox541();
    }

    @JsonIgnore
    public TextBoxNum getTextBox542() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox542();
    }

    @JsonIgnore
    public TextBoxNum getTextBox543() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox543();
    }

    @JsonIgnore
    public TextBoxNum getTextBox544() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox544();
    }

    @JsonIgnore
    public TextBoxNum getTextBox545() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox545();
    }

    @JsonIgnore
    public TextBoxNum getTextBox546() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox546();
    }

    @JsonIgnore
    public TextBoxNum getTextBox547() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox547();
    }

    @JsonIgnore
    public TextBoxNum getTextBox548() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox548();
    }

    @JsonIgnore
    public TextBoxNum getTextBox549() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox549();
    }

    @JsonIgnore
    public TextBoxNum getTextBox550() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox550();
    }

    @JsonIgnore
    public TextBoxNum getTextBox551() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox551();
    }

    @JsonIgnore
    public TextBoxNum getTextBox552() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox552();
    }

    @JsonIgnore
    public TextBoxNum getTextBox553() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox553();
    }

    @JsonIgnore
    public TextBoxNum getTextBox554() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox554();
    }

    @JsonIgnore
    public TextBoxNum getTextBox555() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox555();
    }

    @JsonIgnore
    public TextBoxNum getTextBox556() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox556();
    }

    @JsonIgnore
    public TextBoxNum getTextBox557() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox557();
    }

    @JsonIgnore
    public TextBoxNum getTextBox558() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox558();
    }

    @JsonIgnore
    public TextBoxNum getTextBox559() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox559();
    }

    @JsonIgnore
    public TextBoxNum getTextBox560() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox560();
    }

    @JsonIgnore
    public TextBoxNum getTextBox561() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox561();
    }

    @JsonIgnore
    public TextBoxNum getTextBox562() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox562();
    }

    @JsonIgnore
    public TextBoxNum getTextBox563() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox563();
    }

    @JsonIgnore
    public TextBoxNum getTextBox564() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox564();
    }

    @JsonIgnore
    public TextBoxNum getTextBox565() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox565();
    }

    @JsonIgnore
    public TextBoxNum getTextBox566() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox566();
    }

    @JsonIgnore
    public TextBoxNum getTextBox567() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox567();
    }

    @JsonIgnore
    public TextBoxNum getTextBox568() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox568();
    }

    @JsonIgnore
    public TextBoxNum getTextBox569() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox569();
    }

    @JsonIgnore
    public TextBoxNum getTextBox570() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox570();
    }

    @JsonIgnore
    public TextBoxNum getTextBox571() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox571();
    }

    @JsonIgnore
    public TextBoxNum getTextBox572() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox572();
    }

    @JsonIgnore
    public TextBoxNum getTextBox573() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox573();
    }

    @JsonIgnore
    public TextBoxNum getTextBox574() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox574();
    }

    @JsonIgnore
    public TextBoxNum getTextBox575() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox575();
    }

    @JsonIgnore
    public TextBoxNum getTextBox576() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox576();
    }

    @JsonIgnore
    public TextBoxNum getTextBox577() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox577();
    }

    @JsonIgnore
    public TextBoxNum getTextBox578() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox578();
    }

    @JsonIgnore
    public TextBoxNum getTextBox579() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox579();
    }

    @JsonIgnore
    public TextBoxNum getTextBox580() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox580();
    }

    @JsonIgnore
    public TextBoxNum getTextBox581() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox581();
    }

    @JsonIgnore
    public TextBoxNum getTextBox582() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox582();
    }

    @JsonIgnore
    public TextBoxNum getTextBox583() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox583();
    }

    @JsonIgnore
    public TextBoxNum getTextBox584() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox584();
    }

    @JsonIgnore
    public TextBoxNum getTextBox585() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox585();
    }

    @JsonIgnore
    public TextBoxNum getTextBox608() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox608();
    }

    @JsonIgnore
    public TextBoxNum getTextBox609() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox609();
    }

    @JsonIgnore
    public TextBoxNum getTextBox610() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox610();
    }

    @JsonIgnore
    public TextBoxNum getTextBox611() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox611();
    }

    @JsonIgnore
    public TextBoxNum getTextBox612() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox612();
    }

    @JsonIgnore
    public TextBoxNum getTextBox613() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox613();
    }

    @JsonIgnore
    public TextBoxNum getTextBox614() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox614();
    }

    @JsonIgnore
    public TextBoxNum getTextBox615() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox615();
    }

    @JsonIgnore
    public TextBoxNum getTextBox616() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox616();
    }

    @JsonIgnore
    public TextBoxNum getTextBox617() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox617();
    }

    @JsonIgnore
    public TextBoxNum getTextBox618() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox618();
    }

    @JsonIgnore
    public TextBoxNum getTextBox619() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox619();
    }

    @JsonIgnore
    public TextBoxNum getTextBox620() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox620();
    }

    @JsonIgnore
    public TextBoxNum getTextBox621() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox621();
    }

    @JsonIgnore
    public TextBoxNum getTextBox622() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox622();
    }

    @JsonIgnore
    public TextBoxNum getTextBox623() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox623();
    }

    @JsonIgnore
    public TextBoxNum getTextBox624() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox624();
    }

    @JsonIgnore
    public TextBoxNum getTextBox625() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox625();
    }

    @JsonIgnore
    public TextBoxNum getTextBox626() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox626();
    }

    @JsonIgnore
    public TextBoxNum getTextBox627() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox627();
    }

    @JsonIgnore
    public TextBoxNum getTextBox628() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox628();
    }

    @JsonIgnore
    public TextBoxNum getTextBox629() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox629();
    }

    @JsonIgnore
    public TextBoxNum getTextBox630() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox630();
    }

    @JsonIgnore
    public TextBoxNum getTextBox631() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox631();
    }

    @JsonIgnore
    public TextBoxNum getTextBox632() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox632();
    }

    @JsonIgnore
    public TextBoxNum getTextBox633() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox633();
    }

    @JsonIgnore
    public TextBoxNum getTextBox634() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox634();
    }

    @JsonIgnore
    public TextBoxNum getTextBox635() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox635();
    }

    @JsonIgnore
    public TextBoxNum getTextBox636() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox636();
    }

    @JsonIgnore
    public TextBoxNum getTextBox637() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox637();
    }

    @JsonIgnore
    public TextBoxNum getTextBox638() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox638();
    }

    @JsonIgnore
    public TextBoxNum getTextBox639() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox639();
    }

    @JsonIgnore
    public TextBoxNum getTextBox640() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox640();
    }

    @JsonIgnore
    public TextBoxNum getTextBox641() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox641();
    }

    @JsonIgnore
    public TextBoxNum getTextBox642() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox642();
    }

    @JsonIgnore
    public TextBoxNum getTextBox643() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox643();
    }

    @JsonIgnore
    public TextBoxNum getTextBox644() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox644();
    }

    @JsonIgnore
    public TextBoxNum getTextBox645() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox645();
    }

    @JsonIgnore
    public TextBoxNum getTextBox646() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox646();
    }

    @JsonIgnore
    public TextBoxNum getTextBox647() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox647();
    }

    @JsonIgnore
    public TextBoxNum getTextBox648() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox648();
    }

    @JsonIgnore
    public TextBoxNum getTextBox649() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox649();
    }

    @JsonIgnore
    public TextBoxNum getTextBox650() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox650();
    }

    @JsonIgnore
    public TextBoxNum getTextBox651() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox651();
    }

    @JsonIgnore
    public TextBoxNum getTextBox652() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox652();
    }

    @JsonIgnore
    public TextBoxNum getTextBox653() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox653();
    }

    @JsonIgnore
    public TextBoxNum getTextBox654() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox654();
    }

    @JsonIgnore
    public TextBoxNum getTextBox655() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox655();
    }

    @JsonIgnore
    public TextBoxNum getTextBox656() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox656();
    }

    @JsonIgnore
    public TextBoxNum getTextBox657() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox657();
    }

    @JsonIgnore
    public TextBoxNum getTextBox658() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox658();
    }

    @JsonIgnore
    public TextBoxNum getTextBox659() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox659();
    }

    @JsonIgnore
    public TextBoxNum getTextBox660() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox660();
    }

    @JsonIgnore
    public TextBoxNum getTextBox661() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox661();
    }

    @JsonIgnore
    public TextBoxNum getTextBox662() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox662();
    }

    @JsonIgnore
    public TextBoxNum getTextBox663() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox663();
    }

    @JsonIgnore
    public TextBoxNum getTextBox664() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox664();
    }

    @JsonIgnore
    public TextBoxNum getTextBox665() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox665();
    }

    @JsonIgnore
    public TextBoxNum getTextBox666() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox666();
    }

    @JsonIgnore
    public TextBoxNum getTextBox667() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox667();
    }

    @JsonIgnore
    public TextBoxNum getTextBox668() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox668();
    }

    @JsonIgnore
    public TextBoxNum getTextBox669() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox669();
    }

    @JsonIgnore
    public TextBoxNum getTextBox670() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox670();
    }

    @JsonIgnore
    public TextBoxNum getTextBox671() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox671();
    }

    @JsonIgnore
    public TextBoxNum getTextBox672() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox672();
    }

    @JsonIgnore
    public TextBoxNum getTextBox673() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox673();
    }

    @JsonIgnore
    public TextBoxNum getTextBox674() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox674();
    }

    @JsonIgnore
    public TextBoxNum getTextBox675() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox675();
    }

    @JsonIgnore
    public TextBoxNum getTextBox676() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox676();
    }

    @JsonIgnore
    public TextBoxNum getTextBox677() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox677();
    }

    @JsonIgnore
    public TextBoxNum getTextBox678() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox678();
    }

    @JsonIgnore
    public TextBoxNum getTextBox679() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox679();
    }

    @JsonIgnore
    public TextBoxNum getTextBox680() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox680();
    }

    @JsonIgnore
    public TextBoxNum getTextBox681() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox681();
    }

    @JsonIgnore
    public TextBoxNum getTextBox682() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox682();
    }

    @JsonIgnore
    public TextBoxNum getTextBox683() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox683();
    }

    @JsonIgnore
    public TextBoxNum getTextBox684() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox684();
    }

    @JsonIgnore
    public TextBoxNum getTextBox685() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox685();
    }

    @JsonIgnore
    public TextBoxNum getTextBox686() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox686();
    }

    @JsonIgnore
    public TextBoxNum getTextBox687() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox687();
    }

    @JsonIgnore
    public TextBoxNum getTextBox688() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox688();
    }

    @JsonIgnore
    public TextBoxNum getTextBox689() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox689();
    }

    @JsonIgnore
    public TextBoxNum getTextBox690() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox690();
    }

    @JsonIgnore
    public TextBoxNum getTextBox691() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox691();
    }

    @JsonIgnore
    public TextBoxNum getTextBox692() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox692();
    }

    @JsonIgnore
    public TextBoxNum getTextBox693() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox693();
    }

    @JsonIgnore
    public TextBoxNum getTextBox694() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox694();
    }

    @JsonIgnore
    public TextBoxNum getTextBox695() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox695();
    }

    @JsonIgnore
    public TextBoxNum getTextBox696() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox696();
    }

    @JsonIgnore
    public TextBoxNum getTextBox697() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox697();
    }

    @JsonIgnore
    public TextBoxNum getTextBox698() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox698();
    }

    @JsonIgnore
    public TextBoxNum getTextBox699() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox699();
    }

    @JsonIgnore
    public TextBoxNum getTextBox700() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox700();
    }

    @JsonIgnore
    public TextBoxNum getTextBox701() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox701();
    }

    @JsonIgnore
    public TextBoxNum getTextBox702() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox702();
    }

    @JsonIgnore
    public TextBoxNum getTextBox703() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox703();
    }

    @JsonIgnore
    public TextBoxNum getTextBox704() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox704();
    }

    @JsonIgnore
    public TextBoxNum getTextBox705() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox705();
    }

    @JsonIgnore
    public TextBoxNum getTextBox706() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox706();
    }

    @JsonIgnore
    public TextBoxNum getTextBox707() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox707();
    }

    @JsonIgnore
    public TextBoxNum getTextBox708() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox708();
    }

    @JsonIgnore
    public TextBoxNum getTextBox709() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox709();
    }

    @JsonIgnore
    public TextBoxNum getTextBox710() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox710();
    }

    @JsonIgnore
    public TextBoxNum getTextBox711() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox711();
    }

    @JsonIgnore
    public TextBoxNum getTextBox712() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox712();
    }

    @JsonIgnore
    public TextBoxNum getTextBox713() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox713();
    }

    @JsonIgnore
    public TextBoxNum getTextBox714() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox714();
    }

    @JsonIgnore
    public TextBoxNum getTextBox715() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox715();
    }

    @JsonIgnore
    public TextBoxNum getTextBox716() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox716();
    }

    @JsonIgnore
    public TextBoxNum getTextBox717() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox717();
    }

    @JsonIgnore
    public TextBoxNum getTextBox718() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox718();
    }

    @JsonIgnore
    public TextBoxNum getTextBox719() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox719();
    }

    @JsonIgnore
    public TextBoxNum getTextBox720() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox720();
    }

    @JsonIgnore
    public TextBoxNum getTextBox721() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox721();
    }

    @JsonIgnore
    public TextBoxNum getTextBox722() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox722();
    }

    @JsonIgnore
    public TextBoxNum getTextBox723() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox723();
    }

    @JsonIgnore
    public TextBoxNum getTextBox724() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox724();
    }

    @JsonIgnore
    public TextBoxNum getTextBox725() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox725();
    }

    @JsonIgnore
    public TextBoxNum getTextBox726() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox726();
    }

    @JsonIgnore
    public TextBoxNum getTextBox727() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox727();
    }

    @JsonIgnore
    public TextBoxNum getTextBox728() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox728();
    }

    @JsonIgnore
    public TextBoxNum getTextBox729() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox729();
    }

    @JsonIgnore
    public TextBoxNum getTextBox730() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox730();
    }

    @JsonIgnore
    public TextBoxNum getTextBox731() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox731();
    }

    @JsonIgnore
    public TextBoxNum getTextBox732() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox732();
    }

    @JsonIgnore
    public TextBoxNum getTextBox733() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox733();
    }

    @JsonIgnore
    public TextBoxNum getTextBox734() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox734();
    }

    @JsonIgnore
    public TextBoxNum getTextBox735() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox735();
    }

    @JsonIgnore
    public TextBoxNum getTextBox736() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox736();
    }

    @JsonIgnore
    public TextBoxNum getTextBox737() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox737();
    }

    @JsonIgnore
    public TextBoxNum getTextBox738() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox738();
    }

    @JsonIgnore
    public TextBoxNum getTextBox739() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox739();
    }

    @JsonIgnore
    public TextBoxNum getTextBox740() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox740();
    }

    @JsonIgnore
    public TextBoxNum getTextBox741() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox741();
    }

    @JsonIgnore
    public TextBoxNum getTextBox742() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox742();
    }

    @JsonIgnore
    public TextBoxNum getTextBox743() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox743();
    }

    @JsonIgnore
    public TextBoxNum getTextBox744() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox744();
    }

    @JsonIgnore
    public TextBoxNum getTextBox745() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox745();
    }

    @JsonIgnore
    public TextBoxNum getTextBox746() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox746();
    }

    @JsonIgnore
    public TextBoxNum getTextBox747() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox747();
    }

    @JsonIgnore
    public TextBoxNum getTextBox748() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox748();
    }

    @JsonIgnore
    public TextBoxNum getTextBox749() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox749();
    }

    @JsonIgnore
    public TextBoxNum getTextBox750() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox750();
    }

    @JsonIgnore
    public TextBoxNum getTextBox751() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox751();
    }

    @JsonIgnore
    public TextBoxNum getTextBox752() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox752();
    }

    @JsonIgnore
    public TextBoxNum getTextBox753() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox753();
    }

    @JsonIgnore
    public TextBoxNum getTextBox754() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox754();
    }

    @JsonIgnore
    public TextBoxNum getTextBox755() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox755();
    }

    @JsonIgnore
    public TextBoxNum getTextBox756() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox756();
    }

    @JsonIgnore
    public TextBoxNum getTextBox757() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox757();
    }

    @JsonIgnore
    public TextBoxNum getTextBox758() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox758();
    }

    @JsonIgnore
    public TextBoxNum getTextBox759() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox759();
    }

    @JsonIgnore
    public TextBoxNum getTextBox760() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox760();
    }

    @JsonIgnore
    public TextBoxNum getTextBox761() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox761();
    }

    @JsonIgnore
    public TextBoxNum getTextBox762() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox762();
    }

    @JsonIgnore
    public TextBoxNum getTextBox763() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox763();
    }

    @JsonIgnore
    public TextBoxNum getTextBox764() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox764();
    }

    @JsonIgnore
    public TextBoxNum getTextBox765() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox765();
    }

    @JsonIgnore
    public TextBoxNum getTextBox766() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox766();
    }

    @JsonIgnore
    public TextBoxNum getTextBox767() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox767();
    }

    @JsonIgnore
    public TextBoxNum getTextBox768() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox768();
    }

    @JsonIgnore
    public TextBoxNum getTextBox769() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox769();
    }

    @JsonIgnore
    public TextBoxNum getTextBox770() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox770();
    }

    @JsonIgnore
    public TextBoxNum getTextBox771() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox771();
    }

    @JsonIgnore
    public TextBoxNum getTextBox772() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox772();
    }

    @JsonIgnore
    public TextBoxNum getTextBox773() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox773();
    }

    @JsonIgnore
    public TextBoxNum getTextBox774() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox774();
    }

    @JsonIgnore
    public TextBoxNum getTextBox775() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox775();
    }

    @JsonIgnore
    public TextBoxNum getTextBox776() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox776();
    }

    @JsonIgnore
    public TextBoxNum getTextBox777() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox777();
    }

    @JsonIgnore
    public TextBoxNum getTextBox778() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox778();
    }

    @JsonIgnore
    public TextBoxNum getTextBox779() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox779();
    }

    @JsonIgnore
    public TextBoxNum getTextBox780() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox780();
    }

    @JsonIgnore
    public TextBoxNum getTextBox781() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox781();
    }

    @JsonIgnore
    public TextBoxNum getTextBox782() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox782();
    }

    @JsonIgnore
    public TextBoxNum getTextBox783() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox783();
    }

    @JsonIgnore
    public TextBoxNum getTextBox784() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox784();
    }

    @JsonIgnore
    public TextBoxNum getTextBox785() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox785();
    }

    @JsonIgnore
    public TextBoxNum getTextBox786() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox786();
    }

    @JsonIgnore
    public TextBoxNum getTextBox787() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox787();
    }

    @JsonIgnore
    public TextBoxNum getTextBox788() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox788();
    }

    @JsonIgnore
    public TextBoxNum getTextBox789() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox789();
    }

    @JsonIgnore
    public TextBoxNum getTextBox790() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox790();
    }

    @JsonIgnore
    public TextBoxNum getTextBox791() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox791();
    }

    @JsonIgnore
    public TextBoxNum getTextBox792() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox792();
    }

    @JsonIgnore
    public TextBoxNum getTextBox793() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox793();
    }

    @JsonIgnore
    public TextBoxNum getTextBox794() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox794();
    }

    @JsonIgnore
    public TextBoxNum getTextBox795() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox795();
    }

    @JsonIgnore
    public TextBoxNum getTextBox796() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox796();
    }

    @JsonIgnore
    public TextBoxNum getTextBox797() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox797();
    }

    @JsonIgnore
    public TextBoxNum getTextBox798() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox798();
    }

    @JsonIgnore
    public TextBoxNum getTextBox799() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox799();
    }

    @JsonIgnore
    public TextBoxNum getTextBox800() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox800();
    }

    @JsonIgnore
    public TextBoxNum getTextBox801() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox801();
    }

    @JsonIgnore
    public TextBoxNum getTextBox802() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox802();
    }

    @JsonIgnore
    public TextBoxNum getTextBox803() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox803();
    }

    @JsonIgnore
    public TextBoxNum getTextBox804() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox804();
    }

    @JsonIgnore
    public TextBoxNum getTextBox805() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox805();
    }

    @JsonIgnore
    public TextBoxNum getTextBox806() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox806();
    }

    @JsonIgnore
    public TextBoxNum getTextBox807() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox807();
    }

    @JsonIgnore
    public TextBoxNum getTextBox808() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox808();
    }

    @JsonIgnore
    public TextBoxNum getTextBox809() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox809();
    }

    @JsonIgnore
    public TextBoxNum getTextBox810() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox810();
    }

    @JsonIgnore
    public TextBoxNum getTextBox811() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox811();
    }

    @JsonIgnore
    public TextBoxNum getTextBox812() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox812();
    }

    @JsonIgnore
    public TextBoxNum getTextBox813() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox813();
    }

    @JsonIgnore
    public TextBoxNum getTextBox814() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox814();
    }

    @JsonIgnore
    public TextBoxNum getTextBox815() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox815();
    }

    @JsonIgnore
    public TextBoxNum getTextBox816() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox816();
    }

    @JsonIgnore
    public TextBoxNum getTextBox817() {
        return this.getTcMain().getTpl2().getTbl2().getTextBox817();
    }

    @JsonIgnore
    public TextBoxNum getTextBox818() {
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
    public TextBoxNum getTextBox586() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox586();
    }

    @JsonIgnore
    public TextBoxNum getTextBox587() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox587();
    }

    @JsonIgnore
    public TextBoxNum getTextBox588() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox588();
    }

    @JsonIgnore
    public TextBoxNum getTextBox589() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox589();
    }

    @JsonIgnore
    public TextBoxNum getTextBox590() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox590();
    }

    @JsonIgnore
    public TextBoxNum getTextBox591() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox591();
    }

    @JsonIgnore
    public TextBoxNum getTextBox592() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox592();
    }

    @JsonIgnore
    public TextBoxNum getTextBox593() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox593();
    }

    @JsonIgnore
    public TextBoxNum getTextBox594() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox594();
    }

    @JsonIgnore
    public TextBoxNum getTextBox595() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox595();
    }

    @JsonIgnore
    public TextBoxNum getTextBox596() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox596();
    }

    @JsonIgnore
    public TextBoxNum getTextBox597() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox597();
    }

    @JsonIgnore
    public TextBoxNum getTextBox598() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox598();
    }

    @JsonIgnore
    public TextBoxNum getTextBox599() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox599();
    }

    @JsonIgnore
    public TextBoxNum getTextBox600() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox600();
    }

    @JsonIgnore
    public TextBoxNum getTextBox601() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox601();
    }

    @JsonIgnore
    public TextBoxNum getTextBox602() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox602();
    }

    @JsonIgnore
    public TextBoxNum getTextBox603() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox603();
    }

    @JsonIgnore
    public TextBoxNum getTextBox604() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox604();
    }

    @JsonIgnore
    public TextBoxNum getTextBox605() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox605();
    }

    @JsonIgnore
    public TextBoxNum getTextBox606() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox606();
    }

    @JsonIgnore
    public TextBoxNum getTextBox607() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox607();
    }

    @JsonIgnore
    public TextBoxNum getTextBox819() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox819();
    }

    @JsonIgnore
    public TextBoxNum getTextBox820() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox820();
    }

    @JsonIgnore
    public TextBoxNum getTextBox821() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox821();
    }

    @JsonIgnore
    public TextBoxNum getTextBox822() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox822();
    }

    @JsonIgnore
    public TextBoxNum getTextBox823() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox823();
    }

    @JsonIgnore
    public TextBoxNum getTextBox824() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox824();
    }

    @JsonIgnore
    public TextBoxNum getTextBox825() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox825();
    }

    @JsonIgnore
    public TextBoxNum getTextBox826() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox826();
    }

    @JsonIgnore
    public TextBoxNum getTextBox827() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox827();
    }

    @JsonIgnore
    public TextBoxNum getTextBox828() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox828();
    }

    @JsonIgnore
    public TextBoxNum getTextBox829() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox829();
    }

    @JsonIgnore
    public TextBoxNum getTextBox830() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox830();
    }

    @JsonIgnore
    public TextBoxNum getTextBox831() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox831();
    }

    @JsonIgnore
    public TextBoxNum getTextBox832() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox832();
    }

    @JsonIgnore
    public TextBoxNum getTextBox833() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox833();
    }

    @JsonIgnore
    public TextBoxNum getTextBox834() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox834();
    }

    @JsonIgnore
    public TextBoxNum getTextBox835() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox835();
    }

    @JsonIgnore
    public TextBoxNum getTextBox836() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox836();
    }

    @JsonIgnore
    public TextBoxNum getTextBox837() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox837();
    }

    @JsonIgnore
    public TextBoxNum getTextBox838() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox838();
    }

    @JsonIgnore
    public TextBoxNum getTextBox839() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox839();
    }

    @JsonIgnore
    public TextBoxNum getTextBox840() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox840();
    }

    @JsonIgnore
    public TextBoxNum getTextBox841() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox841();
    }

    @JsonIgnore
    public TextBoxNum getTextBox842() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox842();
    }

    @JsonIgnore
    public TextBoxNum getTextBox843() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox843();
    }

    @JsonIgnore
    public TextBoxNum getTextBox844() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox844();
    }

    @JsonIgnore
    public TextBoxNum getTextBox845() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox845();
    }

    @JsonIgnore
    public TextBoxNum getTextBox846() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox846();
    }

    @JsonIgnore
    public TextBoxNum getTextBox847() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox847();
    }

    @JsonIgnore
    public TextBoxNum getTextBox848() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox848();
    }

    @JsonIgnore
    public TextBoxNum getTextBox849() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox849();
    }

    @JsonIgnore
    public TextBoxNum getTextBox850() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox850();
    }

    @JsonIgnore
    public TextBoxNum getTextBox851() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox851();
    }

    @JsonIgnore
    public TextBoxNum getTextBox852() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox852();
    }

    @JsonIgnore
    public TextBoxNum getTextBox853() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox853();
    }

    @JsonIgnore
    public TextBoxNum getTextBox854() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox854();
    }

    @JsonIgnore
    public TextBoxNum getTextBox855() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox855();
    }

    @JsonIgnore
    public TextBoxNum getTextBox856() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox856();
    }

    @JsonIgnore
    public TextBoxNum getTextBox857() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox857();
    }

    @JsonIgnore
    public TextBoxNum getTextBox858() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox858();
    }

    @JsonIgnore
    public TextBoxNum getTextBox859() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox859();
    }

    @JsonIgnore
    public TextBoxNum getTextBox860() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox860();
    }

    @JsonIgnore
    public TextBoxNum getTextBox861() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox861();
    }

    @JsonIgnore
    public TextBoxNum getTextBox862() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox862();
    }

    @JsonIgnore
    public TextBoxNum getTextBox863() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox863();
    }

    @JsonIgnore
    public TextBoxNum getTextBox864() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox864();
    }

    @JsonIgnore
    public TextBoxNum getTextBox865() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox865();
    }

    @JsonIgnore
    public TextBoxNum getTextBox866() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox866();
    }

    @JsonIgnore
    public TextBoxNum getTextBox867() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox867();
    }

    @JsonIgnore
    public TextBoxNum getTextBox868() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox868();
    }

    @JsonIgnore
    public TextBoxNum getTextBox869() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox869();
    }

    @JsonIgnore
    public TextBoxNum getTextBox870() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox870();
    }

    @JsonIgnore
    public TextBoxNum getTextBox871() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox871();
    }

    @JsonIgnore
    public TextBoxNum getTextBox872() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox872();
    }

    @JsonIgnore
    public TextBoxNum getTextBox873() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox873();
    }

    @JsonIgnore
    public TextBoxNum getTextBox874() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox874();
    }

    @JsonIgnore
    public TextBoxNum getTextBox875() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox875();
    }

    @JsonIgnore
    public TextBoxNum getTextBox876() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox876();
    }

    @JsonIgnore
    public TextBoxNum getTextBox877() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox877();
    }

    @JsonIgnore
    public TextBoxNum getTextBox878() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox878();
    }

    @JsonIgnore
    public TextBoxNum getTextBox879() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox879();
    }

    @JsonIgnore
    public TextBoxNum getTextBox880() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox880();
    }

    @JsonIgnore
    public TextBoxNum getTextBox881() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox881();
    }

    @JsonIgnore
    public TextBoxNum getTextBox882() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox882();
    }

    @JsonIgnore
    public TextBoxNum getTextBox883() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox883();
    }

    @JsonIgnore
    public TextBoxNum getTextBox884() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox884();
    }

    @JsonIgnore
    public TextBoxNum getTextBox885() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox885();
    }

    @JsonIgnore
    public TextBoxNum getTextBox886() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox886();
    }

    @JsonIgnore
    public TextBoxNum getTextBox887() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox887();
    }

    @JsonIgnore
    public TextBoxNum getTextBox888() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox888();
    }

    @JsonIgnore
    public TextBoxNum getTextBox889() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox889();
    }

    @JsonIgnore
    public TextBoxNum getTextBox890() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox890();
    }

    @JsonIgnore
    public TextBoxNum getTextBox891() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox891();
    }

    @JsonIgnore
    public TextBoxNum getTextBox892() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox892();
    }

    @JsonIgnore
    public TextBoxNum getTextBox893() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox893();
    }

    @JsonIgnore
    public TextBoxNum getTextBox894() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox894();
    }

    @JsonIgnore
    public TextBoxNum getTextBox895() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox895();
    }

    @JsonIgnore
    public TextBoxNum getTextBox896() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox896();
    }

    @JsonIgnore
    public TextBoxNum getTextBox897() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox897();
    }

    @JsonIgnore
    public TextBoxNum getTextBox898() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox898();
    }

    @JsonIgnore
    public TextBoxNum getTextBox899() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox899();
    }

    @JsonIgnore
    public TextBoxNum getTextBox900() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox900();
    }

    @JsonIgnore
    public TextBoxNum getTextBox901() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox901();
    }

    @JsonIgnore
    public TextBoxNum getTextBox902() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox902();
    }

    @JsonIgnore
    public TextBoxNum getTextBox903() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox903();
    }

    @JsonIgnore
    public TextBoxNum getTextBox904() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox904();
    }

    @JsonIgnore
    public TextBoxNum getTextBox905() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox905();
    }

    @JsonIgnore
    public TextBoxNum getTextBox906() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox906();
    }

    @JsonIgnore
    public TextBoxNum getTextBox907() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox907();
    }

    @JsonIgnore
    public TextBoxNum getTextBox908() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox908();
    }

    @JsonIgnore
    public TextBoxNum getTextBox909() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox909();
    }

    @JsonIgnore
    public TextBoxNum getTextBox910() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox910();
    }

    @JsonIgnore
    public TextBoxNum getTextBox911() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox911();
    }

    @JsonIgnore
    public TextBoxNum getTextBox912() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox912();
    }

    @JsonIgnore
    public TextBoxNum getTextBox913() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox913();
    }

    @JsonIgnore
    public TextBoxNum getTextBox914() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox914();
    }

    @JsonIgnore
    public TextBoxNum getTextBox915() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox915();
    }

    @JsonIgnore
    public TextBoxNum getTextBox916() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox916();
    }

    @JsonIgnore
    public TextBoxNum getTextBox917() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox917();
    }

    @JsonIgnore
    public TextBoxNum getTextBox918() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox918();
    }

    @JsonIgnore
    public TextBoxNum getTextBox919() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox919();
    }

    @JsonIgnore
    public TextBoxNum getTextBox920() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox920();
    }

    @JsonIgnore
    public TextBoxNum getTextBox921() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox921();
    }

    @JsonIgnore
    public TextBoxNum getTextBox922() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox922();
    }

    @JsonIgnore
    public TextBoxNum getTextBox923() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox923();
    }

    @JsonIgnore
    public TextBoxNum getTextBox924() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox924();
    }

    @JsonIgnore
    public TextBoxNum getTextBox925() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox925();
    }

    @JsonIgnore
    public TextBoxNum getTextBox926() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox926();
    }

    @JsonIgnore
    public TextBoxNum getTextBox927() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox927();
    }

    @JsonIgnore
    public TextBoxNum getTextBox928() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox928();
    }

    @JsonIgnore
    public TextBoxNum getTextBox929() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox929();
    }

    @JsonIgnore
    public TextBoxNum getTextBox930() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox930();
    }

    @JsonIgnore
    public TextBoxNum getTextBox931() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox931();
    }

    @JsonIgnore
    public TextBoxNum getTextBox932() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox932();
    }

    @JsonIgnore
    public TextBoxNum getTextBox933() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox933();
    }

    @JsonIgnore
    public TextBoxNum getTextBox934() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox934();
    }

    @JsonIgnore
    public TextBoxNum getTextBox935() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox935();
    }

    @JsonIgnore
    public TextBoxNum getTextBox936() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox936();
    }

    @JsonIgnore
    public TextBoxNum getTextBox937() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox937();
    }

    @JsonIgnore
    public TextBoxNum getTextBox938() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox938();
    }

    @JsonIgnore
    public TextBoxNum getTextBox939() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox939();
    }

    @JsonIgnore
    public TextBoxNum getTextBox940() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox940();
    }

    @JsonIgnore
    public TextBoxNum getTextBox941() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox941();
    }

    @JsonIgnore
    public TextBoxNum getTextBox942() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox942();
    }

    @JsonIgnore
    public TextBoxNum getTextBox943() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox943();
    }

    @JsonIgnore
    public TextBoxNum getTextBox944() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox944();
    }

    @JsonIgnore
    public TextBoxNum getTextBox945() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox945();
    }

    @JsonIgnore
    public TextBoxNum getTextBox946() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox946();
    }

    @JsonIgnore
    public TextBoxNum getTextBox947() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox947();
    }

    @JsonIgnore
    public TextBoxNum getTextBox948() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox948();
    }

    @JsonIgnore
    public TextBoxNum getTextBox949() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox949();
    }

    @JsonIgnore
    public TextBoxNum getTextBox950() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox950();
    }

    @JsonIgnore
    public TextBoxNum getTextBox951() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox951();
    }

    @JsonIgnore
    public TextBoxNum getTextBox952() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox952();
    }

    @JsonIgnore
    public TextBoxNum getTextBox953() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox953();
    }

    @JsonIgnore
    public TextBoxNum getTextBox954() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox954();
    }

    @JsonIgnore
    public TextBoxNum getTextBox955() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox955();
    }

    @JsonIgnore
    public TextBoxNum getTextBox956() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox956();
    }

    @JsonIgnore
    public TextBoxNum getTextBox957() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox957();
    }

    @JsonIgnore
    public TextBoxNum getTextBox958() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox958();
    }

    @JsonIgnore
    public TextBoxNum getTextBox959() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox959();
    }

    @JsonIgnore
    public TextBoxNum getTextBox960() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox960();
    }

    @JsonIgnore
    public TextBoxNum getTextBox961() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox961();
    }

    @JsonIgnore
    public TextBoxNum getTextBox962() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox962();
    }

    @JsonIgnore
    public TextBoxNum getTextBox963() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox963();
    }

    @JsonIgnore
    public TextBoxNum getTextBox964() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox964();
    }

    @JsonIgnore
    public TextBoxNum getTextBox965() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox965();
    }

    @JsonIgnore
    public TextBoxNum getTextBox966() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox966();
    }

    @JsonIgnore
    public TextBoxNum getTextBox967() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox967();
    }

    @JsonIgnore
    public TextBoxNum getTextBox968() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox968();
    }

    @JsonIgnore
    public TextBoxNum getTextBox969() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox969();
    }

    @JsonIgnore
    public TextBoxNum getTextBox970() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox970();
    }

    @JsonIgnore
    public TextBoxNum getTextBox971() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox971();
    }

    @JsonIgnore
    public TextBoxNum getTextBox972() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox972();
    }

    @JsonIgnore
    public TextBoxNum getTextBox973() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox973();
    }

    @JsonIgnore
    public TextBoxNum getTextBox974() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox974();
    }

    @JsonIgnore
    public TextBoxNum getTextBox975() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox975();
    }

    @JsonIgnore
    public TextBoxNum getTextBox976() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox976();
    }

    @JsonIgnore
    public TextBoxNum getTextBox977() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox977();
    }

    @JsonIgnore
    public TextBoxNum getTextBox978() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox978();
    }

    @JsonIgnore
    public TextBoxNum getTextBox979() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox979();
    }

    @JsonIgnore
    public TextBoxNum getTextBox980() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox980();
    }

    @JsonIgnore
    public TextBoxNum getTextBox981() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox981();
    }

    @JsonIgnore
    public TextBoxNum getTextBox982() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox982();
    }

    @JsonIgnore
    public TextBoxNum getTextBox983() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox983();
    }

    @JsonIgnore
    public TextBoxNum getTextBox984() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox984();
    }

    @JsonIgnore
    public TextBoxNum getTextBox985() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox985();
    }

    @JsonIgnore
    public TextBoxNum getTextBox986() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox986();
    }

    @JsonIgnore
    public TextBoxNum getTextBox987() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox987();
    }

    @JsonIgnore
    public TextBoxNum getTextBox988() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox988();
    }

    @JsonIgnore
    public TextBoxNum getTextBox989() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox989();
    }

    @JsonIgnore
    public TextBoxNum getTextBox990() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox990();
    }

    @JsonIgnore
    public TextBoxNum getTextBox991() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox991();
    }

    @JsonIgnore
    public TextBoxNum getTextBox992() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox992();
    }

    @JsonIgnore
    public TextBoxNum getTextBox993() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox993();
    }

    @JsonIgnore
    public TextBoxNum getTextBox994() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox994();
    }

    @JsonIgnore
    public TextBoxNum getTextBox995() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox995();
    }

    @JsonIgnore
    public TextBoxNum getTextBox996() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox996();
    }

    @JsonIgnore
    public TextBoxNum getTextBox997() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox997();
    }

    @JsonIgnore
    public TextBoxNum getTextBox998() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox998();
    }

    @JsonIgnore
    public TextBoxNum getTextBox999() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox999();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1000() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1000();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1001() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1001();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1002() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1002();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1003() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1003();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1004() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1004();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1005() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1005();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1006() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1006();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1007() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1007();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1008() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1008();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1009() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1009();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1010() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1010();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1011() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1011();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1012() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1012();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1013() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1013();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1014() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1014();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1015() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1015();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1016() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1016();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1017() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1017();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1018() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1018();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1019() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1019();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1020() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1020();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1021() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1021();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1022() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1022();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1023() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1023();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1024() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1024();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1025() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1025();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1026() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1026();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1027() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1027();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1028() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1028();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1029() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1029();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1030() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1030();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1031() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1031();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1032() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1032();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1033() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1033();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1034() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1034();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1035() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1035();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1036() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1036();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1037() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1037();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1038() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1038();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1039() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1039();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1040() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1040();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1041() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1041();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1042() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1042();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1043() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1043();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1044() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1044();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1045() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1045();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1046() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1046();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1047() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1047();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1048() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1048();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1049() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1049();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1050() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1050();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1051() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1051();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1052() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1052();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1053() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1053();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1054() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1054();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1055() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1055();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1056() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1056();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1057() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1057();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1058() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1058();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1059() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1059();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1060() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1060();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1061() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1061();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1062() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1062();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1063() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1063();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1064() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1064();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1065() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1065();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1066() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1066();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1067() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1067();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1068() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1068();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1069() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1069();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1070() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1070();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1071() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1071();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1072() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1072();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1073() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1073();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1074() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1074();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1075() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1075();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1076() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1076();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1077() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1077();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1078() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1078();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1079() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1079();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1080() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1080();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1081() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1081();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1082() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1082();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1083() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1083();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1084() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1084();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1085() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1085();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1086() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1086();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1087() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1087();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1088() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1088();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1089() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1089();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1090() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1090();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1091() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1091();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1092() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1092();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1093() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1093();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1094() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1094();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1095() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1095();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1096() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1096();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1097() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1097();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1098() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1098();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1099() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1099();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1100() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1100();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1101() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1101();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1102() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1102();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1103() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1103();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1104() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1104();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1105() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1105();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1106() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1106();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1107() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1107();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1108() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1108();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1109() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1109();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1110() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1110();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1111() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1111();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1112() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1112();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1113() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1113();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1114() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1114();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1115() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1115();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1116() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1116();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1117() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1117();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1118() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1118();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1119() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1119();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1120() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1120();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1121() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1121();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1122() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1122();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1123() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1123();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1124() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1124();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1125() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1125();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1126() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1126();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1127() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1127();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1128() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1128();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1129() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1129();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1130() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1130();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1131() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1131();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1132() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1132();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1133() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1133();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1134() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1134();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1135() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1135();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1136() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1136();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1137() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1137();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1138() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1138();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1139() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1139();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1140() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1140();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1141() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1141();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1142() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1142();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1143() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1143();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1144() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1144();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1145() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1145();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1146() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1146();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1147() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1147();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1148() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1148();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1149() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1149();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1150() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1150();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1151() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1151();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1152() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1152();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1153() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1153();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1154() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1154();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1155() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1155();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1156() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1156();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1157() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1157();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1158() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1158();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1159() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1159();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1160() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1160();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1161() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1161();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1162() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1162();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1163() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1163();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1164() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1164();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1165() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1165();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1166() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1166();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1167() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1167();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1168() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1168();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1169() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1169();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1170() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1170();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1171() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1171();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1172() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1172();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1173() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1173();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1174() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1174();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1175() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1175();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1176() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1176();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1177() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1177();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1178() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1178();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1179() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1179();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1180() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1180();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1181() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1181();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1182() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1182();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1183() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1183();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1184() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1184();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1185() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1185();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1186() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1186();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1187() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1187();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1188() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1188();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1189() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1189();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1190() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1190();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1191() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1191();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1192() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1192();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1193() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1193();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1194() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1194();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1195() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1195();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1196() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1196();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1197() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1197();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1198() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1198();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1199() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1199();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1200() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1200();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1201() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1201();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1202() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1202();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1203() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1203();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1204() {
        return this.getTcMain().getTpl3().getTbl3().getTextBox1204();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1205() {
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
    public TextBoxNum getTextBox1206() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1206();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1207() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1207();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1208() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1208();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1209() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1209();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1210() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1210();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1211() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1211();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1212() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1212();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1213() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1213();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1214() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1214();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1215() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1215();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1216() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1216();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1217() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1217();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1218() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1218();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1219() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1219();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1220() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1220();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1221() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1221();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1222() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1222();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1223() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1223();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1224() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1224();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1225() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1225();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1226() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1226();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1227() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1227();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1228() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1228();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1229() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1229();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1230() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1230();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1231() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1231();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1232() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1232();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1233() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1233();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1234() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1234();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1235() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1235();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1236() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1236();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1237() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1237();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1238() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1238();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1239() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1239();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1240() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1240();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1241() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1241();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1242() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1242();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1243() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1243();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1244() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1244();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1245() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1245();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1246() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1246();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1247() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1247();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1248() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1248();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1249() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1249();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1250() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1250();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1251() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1251();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1252() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1252();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1253() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1253();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1254() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1254();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1255() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1255();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1256() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1256();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1257() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1257();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1258() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1258();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1259() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1259();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1260() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1260();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1261() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1261();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1262() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1262();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1263() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1263();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1264() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1264();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1265() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1265();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1266() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1266();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1267() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1267();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1268() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1268();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1269() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1269();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1270() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1270();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1271() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1271();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1272() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1272();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1273() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1273();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1274() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1274();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1275() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1275();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1276() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1276();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1277() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1277();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1278() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1278();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1279() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1279();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1280() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1280();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1281() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1281();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1282() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1282();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1283() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1283();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1284() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1284();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1285() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1285();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1286() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1286();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1287() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1287();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1288() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1288();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1289() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1289();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1290() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1290();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1291() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1291();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1292() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1292();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1293() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1293();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1294() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1294();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1295() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1295();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1296() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1296();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1297() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1297();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1298() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1298();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1299() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1299();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1300() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1300();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1301() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1301();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1302() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1302();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1303() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1303();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1304() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1304();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1305() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1305();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1306() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1306();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1307() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1307();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1308() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1308();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1309() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1309();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1310() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1310();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1311() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1311();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1312() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1312();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1313() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1313();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1314() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1314();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1315() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1315();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1316() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1316();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1317() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1317();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1318() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1318();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1319() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1319();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1320() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1320();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1321() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1321();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1322() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1322();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1323() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1323();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1324() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1324();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1325() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1325();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1326() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1326();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1327() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1327();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1328() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1328();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1329() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1329();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1330() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1330();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1331() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1331();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1332() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1332();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1333() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1333();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1334() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1334();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1335() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1335();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1336() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1336();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1337() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1337();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1338() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1338();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1339() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1339();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1340() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1340();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1341() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1341();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1342() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1342();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1343() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1343();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1344() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1344();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1345() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1345();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1346() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1346();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1347() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1347();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1348() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1348();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1349() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1349();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1350() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1350();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1351() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1351();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1352() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1352();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1353() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1353();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1354() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1354();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1355() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1355();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1356() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1356();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1357() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1357();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1358() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1358();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1359() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1359();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1360() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1360();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1361() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1361();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1362() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1362();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1363() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1363();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1364() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1364();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1365() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1365();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1366() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1366();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1367() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1367();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1368() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1368();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1369() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1369();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1370() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1370();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1371() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1371();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1372() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1372();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1373() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1373();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1374() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1374();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1375() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1375();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1376() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1376();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1377() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1377();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1378() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1378();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1379() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1379();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1380() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1380();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1381() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1381();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1382() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1382();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1383() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1383();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1384() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1384();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1385() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1385();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1386() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1386();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1387() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1387();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1388() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1388();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1389() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1389();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1390() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1390();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1391() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1391();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1392() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1392();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1393() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1393();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1394() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1394();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1395() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1395();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1396() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1396();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1397() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1397();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1398() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1398();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1399() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1399();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1400() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1400();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1401() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1401();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1402() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1402();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1403() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1403();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1404() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1404();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1405() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1405();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1406() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1406();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1407() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1407();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1408() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1408();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1409() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1409();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1410() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1410();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1411() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1411();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1412() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1412();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1413() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1413();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1414() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1414();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1415() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1415();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1416() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1416();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1417() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1417();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1418() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1418();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1419() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1419();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1420() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1420();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1421() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1421();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1422() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1422();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1423() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1423();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1424() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1424();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1425() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1425();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1426() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1426();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1427() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1427();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1428() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1428();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1429() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1429();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1430() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1430();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1431() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1431();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1432() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1432();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1433() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1433();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1434() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1434();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1435() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1435();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1436() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1436();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1437() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1437();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1438() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1438();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1439() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1439();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1440() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1440();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1441() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1441();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1442() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1442();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1443() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1443();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1444() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1444();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1445() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1445();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1446() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1446();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1447() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1447();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1448() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1448();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1449() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1449();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1450() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1450();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1451() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1451();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1452() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1452();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1453() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1453();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1454() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1454();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1455() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1455();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1456() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1456();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1457() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1457();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1458() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1458();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1459() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1459();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1460() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1460();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1461() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1461();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1462() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1462();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1463() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1463();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1464() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1464();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1465() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1465();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1466() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1466();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1467() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1467();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1468() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1468();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1469() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1469();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1470() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1470();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1471() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1471();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1472() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1472();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1473() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1473();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1474() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1474();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1475() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1475();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1476() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1476();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1477() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1477();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1478() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1478();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1479() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1479();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1480() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1480();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1481() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1481();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1482() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1482();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1483() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1483();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1484() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1484();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1485() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1485();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1486() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1486();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1487() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1487();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1488() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1488();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1489() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1489();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1490() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1490();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1491() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1491();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1492() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1492();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1493() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1493();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1494() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1494();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1495() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1495();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1496() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1496();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1497() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1497();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1498() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1498();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1499() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1499();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1500() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1500();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1501() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1501();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1502() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1502();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1503() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1503();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1504() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1504();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1505() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1505();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1506() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1506();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1507() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1507();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1508() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1508();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1509() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1509();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1510() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1510();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1511() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1511();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1512() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1512();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1513() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1513();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1514() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1514();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1515() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1515();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1516() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1516();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1517() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1517();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1518() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1518();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1519() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1519();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1520() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1520();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1521() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1521();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1522() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1522();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1523() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1523();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1524() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1524();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1525() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1525();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1526() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1526();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1527() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1527();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1528() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1528();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1529() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1529();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1530() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1530();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1531() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1531();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1532() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1532();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1533() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1533();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1534() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1534();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1535() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1535();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1536() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1536();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1537() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1537();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1538() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1538();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1539() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1539();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1540() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1540();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1541() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1541();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1542() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1542();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1543() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1543();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1544() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1544();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1545() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1545();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1546() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1546();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1547() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1547();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1548() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1548();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1549() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1549();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1550() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1550();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1551() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1551();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1552() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1552();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1553() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1553();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1554() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1554();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1555() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1555();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1556() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1556();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1557() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1557();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1558() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1558();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1559() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1559();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1560() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1560();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1561() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1561();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1562() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1562();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1563() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1563();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1564() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1564();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1565() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1565();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1566() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1566();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1567() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1567();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1568() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1568();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1569() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1569();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1570() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1570();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1571() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1571();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1572() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1572();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1573() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1573();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1574() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1574();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1575() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1575();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1576() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1576();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1577() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1577();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1578() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1578();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1579() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1579();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1580() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1580();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1581() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1581();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1582() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1582();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1583() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1583();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1584() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1584();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1585() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1585();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1586() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1586();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1587() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1587();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1588() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1588();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1589() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1589();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1590() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1590();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1591() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1591();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1592() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1592();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1593() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1593();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1594() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1594();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1595() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1595();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1596() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1596();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1597() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1597();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1598() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1598();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1599() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1599();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1600() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1600();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1601() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1601();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1602() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1602();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1603() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1603();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1604() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1604();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1605() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1605();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1606() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1606();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1607() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1607();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1608() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1608();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1609() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1609();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1610() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1610();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1611() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1611();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1612() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1612();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1613() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1613();
    }

    @JsonIgnore
    public TextBoxNum getTextBox1614() {
        return this.getTcMain().getTpl4().getTbl4().getTextBox1614();
    }

    // </editor-fold>
}
