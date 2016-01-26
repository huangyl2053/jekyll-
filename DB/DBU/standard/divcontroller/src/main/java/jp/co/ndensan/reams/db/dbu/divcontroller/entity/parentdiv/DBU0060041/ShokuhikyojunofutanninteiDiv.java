package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060041;
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
 * Shokuhikyojunofutannintei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokuhikyojunofutanninteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabShokuhikyojunofutannintei")
    private tabShokuhikyojunofutanninteiDiv tabShokuhikyojunofutannintei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabShokuhikyojunofutannintei
     * @return tabShokuhikyojunofutannintei
     */
    @JsonProperty("tabShokuhikyojunofutannintei")
    public tabShokuhikyojunofutanninteiDiv getTabShokuhikyojunofutannintei() {
        return tabShokuhikyojunofutannintei;
    }

    /*
     * settabShokuhikyojunofutannintei
     * @param tabShokuhikyojunofutannintei tabShokuhikyojunofutannintei
     */
    @JsonProperty("tabShokuhikyojunofutannintei")
    public void setTabShokuhikyojunofutannintei(tabShokuhikyojunofutanninteiDiv tabShokuhikyojunofutannintei) {
        this.tabShokuhikyojunofutannintei = tabShokuhikyojunofutannintei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tblhokenryoshunojokyoDiv getTblhokenryoshunojokyo() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo();
    }

    @JsonIgnore
    public void  setTblhokenryoshunojokyo(tblhokenryoshunojokyoDiv tblhokenryoshunojokyo) {
        this.getTabShokuhikyojunofutannintei().setTblhokenryoshunojokyo(tblhokenryoshunojokyo);
    }

    @JsonIgnore
    public tblhokenryoshunoDiv getTblhokenryoshuno() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno();
    }

    @JsonIgnore
    public void  setTblhokenryoshuno(tblhokenryoshunoDiv tblhokenryoshuno) {
        this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().setTblhokenryoshuno(tblhokenryoshuno);
    }

    @JsonIgnore
    public Label getLblkubun() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getLblkubun();
    }

    @JsonIgnore
    public Label getLblchotei() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getLblchotei();
    }

    @JsonIgnore
    public Label getLblshuno() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getLblshuno();
    }

    @JsonIgnore
    public Label getLblkampu() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getLblkampu();
    }

    @JsonIgnore
    public Label getLblfuno() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getLblfuno();
    }

    @JsonIgnore
    public Label getLblmino() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getLblmino();
    }

    @JsonIgnore
    public Label getLblgemmengaku() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getLblgemmengaku();
    }

    @JsonIgnore
    public Label getLblgennendo() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getLblgennendo();
    }

    @JsonIgnore
    public Label getLbltokubetsuchoshu() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getLbltokubetsuchoshu();
    }

    @JsonIgnore
    public TextBoxNum getTxtchotei1() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtchotei1();
    }

    @JsonIgnore
    public TextBoxNum getTxtShuno1() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtShuno1();
    }

    @JsonIgnore
    public TextBoxNum getTxtKampu1() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtKampu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtgemmengaku1() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtgemmengaku1();
    }

    @JsonIgnore
    public Label getLblfutsuchoshu() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getLblfutsuchoshu();
    }

    @JsonIgnore
    public TextBoxNum getTxtchotei2() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtchotei2();
    }

    @JsonIgnore
    public TextBoxNum getTxtShuno2() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtShuno2();
    }

    @JsonIgnore
    public TextBoxNum getTxtKampu2() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtKampu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtfuno2() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtfuno2();
    }

    @JsonIgnore
    public TextBoxNum getTxtmino2() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtmino2();
    }

    @JsonIgnore
    public TextBoxNum getTxtgemmengaku2() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtgemmengaku2();
    }

    @JsonIgnore
    public Label getLblkei() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getLblkei();
    }

    @JsonIgnore
    public TextBoxNum getTxtchotei3() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtchotei3();
    }

    @JsonIgnore
    public TextBoxNum getTxtShuno3() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtShuno3();
    }

    @JsonIgnore
    public TextBoxNum getTxtKampu3() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtKampu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtfuno3() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtfuno3();
    }

    @JsonIgnore
    public TextBoxNum getTxtmino3() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtmino3();
    }

    @JsonIgnore
    public TextBoxNum getTxtgemmengaku3() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtgemmengaku3();
    }

    @JsonIgnore
    public Label getLbltaino() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getLbltaino();
    }

    @JsonIgnore
    public Label getLbltatokubetsuchoshu() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getLbltatokubetsuchoshu();
    }

    @JsonIgnore
    public TextBoxNum getTxtchotei4() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtchotei4();
    }

    @JsonIgnore
    public TextBoxNum getTxtShuno4() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtShuno4();
    }

    @JsonIgnore
    public TextBoxNum getTxtKampu4() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtKampu4();
    }

    @JsonIgnore
    public TextBoxNum getTxtfuno4() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtfuno4();
    }

    @JsonIgnore
    public TextBoxNum getTxtmino4() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtmino4();
    }

    @JsonIgnore
    public TextBoxNum getTxtgemmengaku4() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtgemmengaku4();
    }

    @JsonIgnore
    public Label getLblgokei() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getLblgokei();
    }

    @JsonIgnore
    public Label getLbltokute() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getLbltokute();
    }

    @JsonIgnore
    public TextBoxNum getTxtchotei5() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtchotei5();
    }

    @JsonIgnore
    public TextBoxNum getTxtShuno5() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtShuno5();
    }

    @JsonIgnore
    public TextBoxNum getTxtKampu5() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtKampu5();
    }

    @JsonIgnore
    public TextBoxNum getTxtgemmengaku5() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtgemmengaku5();
    }

    @JsonIgnore
    public Label getLblgokeifutsuchoshu() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getLblgokeifutsuchoshu();
    }

    @JsonIgnore
    public TextBoxNum getTxtchotei6() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtchotei6();
    }

    @JsonIgnore
    public TextBoxNum getTxtShuno6() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtShuno6();
    }

    @JsonIgnore
    public TextBoxNum getTxtxtKampu6() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtxtKampu6();
    }

    @JsonIgnore
    public TextBoxNum getTxtfuno5() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtfuno5();
    }

    @JsonIgnore
    public TextBoxNum getTxtmino6() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtmino6();
    }

    @JsonIgnore
    public TextBoxNum getTxtgemmengaku6() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtgemmengaku6();
    }

    @JsonIgnore
    public Label getLblgokeii() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getLblgokeii();
    }

    @JsonIgnore
    public TextBoxNum getTxtchotei7() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtchotei7();
    }

    @JsonIgnore
    public TextBoxNum getTxtShuno7() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtShuno7();
    }

    @JsonIgnore
    public TextBoxNum getTxtKampu7() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtKampu7();
    }

    @JsonIgnore
    public TextBoxNum getTxtfuno6() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtfuno6();
    }

    @JsonIgnore
    public TextBoxNum getTxtmino7() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtmino7();
    }

    @JsonIgnore
    public TextBoxNum getTxtgemmengaku7() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenryoshunojokyo().getTblhokenryoshuno().getTxtgemmengaku7();
    }

    @JsonIgnore
    public tblhokenkyufushiharaiDiv getTblhokenkyufushiharai() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai();
    }

    @JsonIgnore
    public void  setTblhokenkyufushiharai(tblhokenkyufushiharaiDiv tblhokenkyufushiharai) {
        this.getTabShokuhikyojunofutannintei().setTblhokenkyufushiharai(tblhokenkyufushiharai);
    }

    @JsonIgnore
    public tblhokenkyufushiharaijokyoDiv getTblhokenkyufushiharaijokyo() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo();
    }

    @JsonIgnore
    public void  setTblhokenkyufushiharaijokyo(tblhokenkyufushiharaijokyoDiv tblhokenkyufushiharaijokyo) {
        this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().setTblhokenkyufushiharaijokyo(tblhokenkyufushiharaijokyo);
    }

    @JsonIgnore
    public Label getLblgubun() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getLblgubun();
    }

    @JsonIgnore
    public Label getLblShiharaigi() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getLblShiharaigi();
    }

    @JsonIgnore
    public Label getLblShiharaizu() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getLblShiharaizu();
    }

    @JsonIgnore
    public Label getLblchoshu() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getLblchoshu();
    }

    @JsonIgnore
    public Label getLblreinyu() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getLblreinyu();
    }

    @JsonIgnore
    public Label getLblmishiharaigaku() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getLblmishiharaigaku();
    }

    @JsonIgnore
    public Label getLblkaigoSer() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getLblkaigoSer();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi1() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtShiharaigi1();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu1() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtShiharaizu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu1() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtChoshu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu1() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtReinyu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku1() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtlmishiharaigaku1();
    }

    @JsonIgnore
    public Label getLblkaigoyoboSer() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getLblkaigoyoboSer();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi2() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtShiharaigi2();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu2() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtShiharaizu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu2() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtChoshu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu2() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtReinyu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku2() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtlmishiharaigaku2();
    }

    @JsonIgnore
    public Label getLblkogakukaigoSer() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getLblkogakukaigoSer();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi3() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtShiharaigi3();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu3() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtShiharaizu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu3() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtChoshu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu3() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtReinyu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku3() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtlmishiharaigaku3();
    }

    @JsonIgnore
    public Label getLblkogakuiryo() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getLblkogakuiryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi4() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtShiharaigi4();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu4() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtShiharaizu4();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu4() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtChoshu4();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu4() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtReinyu4();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku4() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtlmishiharaigaku4();
    }

    @JsonIgnore
    public Label getLbltokuteinyusho() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getLbltokuteinyusho();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi5() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtShiharaigi5();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu5() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtShiharaizu5();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu5() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtChoshu5();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu5() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtReinyu5();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku5() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtlmishiharaigaku5();
    }

    @JsonIgnore
    public Label getLblsonota() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getLblsonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi6() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtShiharaigi6();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu6() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtShiharaizu6();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu6() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtChoshu6();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu6() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtReinyu6();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku6() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtlmishiharaigaku6();
    }

    @JsonIgnore
    public Label getLblkeii() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getLblkeii();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi7() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtShiharaigi7();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu7() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtShiharaizu7();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu7() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtChoshu7();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu7() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtReinyu7();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku7() {
        return this.getTabShokuhikyojunofutannintei().getTblhokenkyufushiharai().getTblhokenkyufushiharaijokyo().getTxtlmishiharaigaku7();
    }

    // </editor-fold>
}
