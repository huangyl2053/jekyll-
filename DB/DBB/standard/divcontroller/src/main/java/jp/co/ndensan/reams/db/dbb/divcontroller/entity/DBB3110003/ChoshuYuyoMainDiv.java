package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110003;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110003.KetteiJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110003.KiwarigakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110003.ShinseiJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110003.TablePanel2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110003.TorikeshiJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110003.tblChoshuYuyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ChoshuYuyoMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChoshuYuyoMainDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiJokyo")
    private TextBox txtShinseiJokyo;
    @JsonProperty("btnTeisei")
    private Button btnTeisei;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("tblChoshuYuyo")
    private tblChoshuYuyoDiv tblChoshuYuyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseiJokyo")
    public TextBox getTxtShinseiJokyo() {
        return txtShinseiJokyo;
    }

    @JsonProperty("txtShinseiJokyo")
    public void setTxtShinseiJokyo(TextBox txtShinseiJokyo) {
        this.txtShinseiJokyo=txtShinseiJokyo;
    }

    @JsonProperty("btnTeisei")
    public Button getBtnTeisei() {
        return btnTeisei;
    }

    @JsonProperty("btnTeisei")
    public void setBtnTeisei(Button btnTeisei) {
        this.btnTeisei=btnTeisei;
    }

    @JsonProperty("btnTorikeshi")
    public Button getBtnTorikeshi() {
        return btnTorikeshi;
    }

    @JsonProperty("btnTorikeshi")
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.btnTorikeshi=btnTorikeshi;
    }

    @JsonProperty("tblChoshuYuyo")
    public tblChoshuYuyoDiv getTblChoshuYuyo() {
        return tblChoshuYuyo;
    }

    @JsonProperty("tblChoshuYuyo")
    public void setTblChoshuYuyo(tblChoshuYuyoDiv tblChoshuYuyo) {
        this.tblChoshuYuyo=tblChoshuYuyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TorikeshiJohoDiv getTorikeshiJoho() {
        return this.getTblChoshuYuyo().getTorikeshiJoho();
    }

    @JsonIgnore
    public TextBoxDate getTxtTorikeshiYMD() {
        return this.getTblChoshuYuyo().getTorikeshiJoho().getTxtTorikeshiYMD();
    }

    @JsonIgnore
    public void  setTxtTorikeshiYMD(TextBoxDate txtTorikeshiYMD) {
        this.getTblChoshuYuyo().getTorikeshiJoho().setTxtTorikeshiYMD(txtTorikeshiYMD);
    }

    @JsonIgnore
    public Button getBtnTorikeshiShurui() {
        return this.getTblChoshuYuyo().getTorikeshiJoho().getBtnTorikeshiShurui();
    }

    @JsonIgnore
    public void  setBtnTorikeshiShurui(Button btnTorikeshiShurui) {
        this.getTblChoshuYuyo().getTorikeshiJoho().setBtnTorikeshiShurui(btnTorikeshiShurui);
    }

    @JsonIgnore
    public TextBox getTxtTorikeshiShurui() {
        return this.getTblChoshuYuyo().getTorikeshiJoho().getTxtTorikeshiShurui();
    }

    @JsonIgnore
    public void  setTxtTorikeshiShurui(TextBox txtTorikeshiShurui) {
        this.getTblChoshuYuyo().getTorikeshiJoho().setTxtTorikeshiShurui(txtTorikeshiShurui);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTorikeshiRiyu() {
        return this.getTblChoshuYuyo().getTorikeshiJoho().getTxtTorikeshiRiyu();
    }

    @JsonIgnore
    public void  setTxtTorikeshiRiyu(TextBoxMultiLine txtTorikeshiRiyu) {
        this.getTblChoshuYuyo().getTorikeshiJoho().setTxtTorikeshiRiyu(txtTorikeshiRiyu);
    }

    @JsonIgnore
    public ShinseiJohoDiv getShinseiJoho() {
        return this.getTblChoshuYuyo().getShinseiJoho();
    }

    @JsonIgnore
    public TextBox getTxtChoteiNendo() {
        return this.getTblChoshuYuyo().getShinseiJoho().getTxtChoteiNendo();
    }

    @JsonIgnore
    public void  setTxtChoteiNendo(TextBox txtChoteiNendo) {
        this.getTblChoshuYuyo().getShinseiJoho().setTxtChoteiNendo(txtChoteiNendo);
    }

    @JsonIgnore
    public TextBox getTxtFukaNendo() {
        return this.getTblChoshuYuyo().getShinseiJoho().getTxtFukaNendo();
    }

    @JsonIgnore
    public void  setTxtFukaNendo(TextBox txtFukaNendo) {
        this.getTblChoshuYuyo().getShinseiJoho().setTxtFukaNendo(txtFukaNendo);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getTblChoshuYuyo().getShinseiJoho().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getTblChoshuYuyo().getShinseiJoho().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public Button getBtnYuyoShurui() {
        return this.getTblChoshuYuyo().getShinseiJoho().getBtnYuyoShurui();
    }

    @JsonIgnore
    public void  setBtnYuyoShurui(Button btnYuyoShurui) {
        this.getTblChoshuYuyo().getShinseiJoho().setBtnYuyoShurui(btnYuyoShurui);
    }

    @JsonIgnore
    public TextBox getTxtYuyoShurui() {
        return this.getTblChoshuYuyo().getShinseiJoho().getTxtYuyoShurui();
    }

    @JsonIgnore
    public void  setTxtYuyoShurui(TextBox txtYuyoShurui) {
        this.getTblChoshuYuyo().getShinseiJoho().setTxtYuyoShurui(txtYuyoShurui);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getTblChoshuYuyo().getShinseiJoho().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void  setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getTblChoshuYuyo().getShinseiJoho().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public KetteiJohoDiv getKetteiJoho() {
        return this.getTblChoshuYuyo().getKetteiJoho();
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiYMD() {
        return this.getTblChoshuYuyo().getKetteiJoho().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.getTblChoshuYuyo().getKetteiJoho().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public RadioButton getRadKetteiKubun() {
        return this.getTblChoshuYuyo().getKetteiJoho().getRadKetteiKubun();
    }

    @JsonIgnore
    public void  setRadKetteiKubun(RadioButton radKetteiKubun) {
        this.getTblChoshuYuyo().getKetteiJoho().setRadKetteiKubun(radKetteiKubun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKetteiRiyu() {
        return this.getTblChoshuYuyo().getKetteiJoho().getTxtKetteiRiyu();
    }

    @JsonIgnore
    public void  setTxtKetteiRiyu(TextBoxMultiLine txtKetteiRiyu) {
        this.getTblChoshuYuyo().getKetteiJoho().setTxtKetteiRiyu(txtKetteiRiyu);
    }

    @JsonIgnore
    public KiwarigakuDiv getKiwarigaku() {
        return this.getTblChoshuYuyo().getKiwarigaku();
    }

    @JsonIgnore
    public TablePanel2Div getTablePanel2() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2();
    }

    @JsonIgnore
    public void  setTablePanel2(TablePanel2Div TablePanel2) {
        this.getTblChoshuYuyo().getKiwarigaku().setTablePanel2(TablePanel2);
    }

    @JsonIgnore
    public Label getLabel8() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel8();
    }

    @JsonIgnore
    public Label getLabel1() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel1();
    }

    @JsonIgnore
    public Label getLabel3() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel3();
    }

    @JsonIgnore
    public Label getLabel4() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel4();
    }

    @JsonIgnore
    public Label getLabel6() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel6();
    }

    @JsonIgnore
    public Label getLabel7() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel7();
    }

    @JsonIgnore
    public Label getLabel5() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel5();
    }

    @JsonIgnore
    public Label getLabel9() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel9();
    }

    @JsonIgnore
    public Label getLabel10() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel10();
    }

    @JsonIgnore
    public Label getLabel11() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel11();
    }

    @JsonIgnore
    public Label getLabel12() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel12();
    }

    @JsonIgnore
    public Label getLabel13() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel13();
    }

    @JsonIgnore
    public Label getLabel14() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel14();
    }

    @JsonIgnore
    public Label getLabel16() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel16();
    }

    @JsonIgnore
    public Label getLabel17() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel17();
    }

    @JsonIgnore
    public Label getLabel18() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel18();
    }

    @JsonIgnore
    public Label getLabel19() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel19();
    }

    @JsonIgnore
    public Label getLabel20() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel20();
    }

    @JsonIgnore
    public Label getLabel21() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel21();
    }

    @JsonIgnore
    public Label getLabel22() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel22();
    }

    @JsonIgnore
    public Label getLabel23() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel23();
    }

    @JsonIgnore
    public Label getLabel24() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel24();
    }

    @JsonIgnore
    public Label getLabel25() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel25();
    }

    @JsonIgnore
    public Label getLabel26() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel26();
    }

    @JsonIgnore
    public Label getLabel27() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel27();
    }

    @JsonIgnore
    public Label getLabel28() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel28();
    }

    @JsonIgnore
    public Label getLabel29() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel29();
    }

    @JsonIgnore
    public Label getLabel30() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel30();
    }

    @JsonIgnore
    public Label getLabel32() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel32();
    }

    @JsonIgnore
    public Label getLabel33() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel33();
    }

    @JsonIgnore
    public Label getLabel34() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel34();
    }

    @JsonIgnore
    public Label getLabel35() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel35();
    }

    @JsonIgnore
    public Label getLabel36() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel36();
    }

    @JsonIgnore
    public Label getLabel37() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel37();
    }

    @JsonIgnore
    public Label getLabel38() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel38();
    }

    @JsonIgnore
    public Label getLabel39() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel39();
    }

    @JsonIgnore
    public Label getLabel40() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel40();
    }

    @JsonIgnore
    public Label getLabel42() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel42();
    }

    @JsonIgnore
    public Label getLabel43() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel43();
    }

    @JsonIgnore
    public Label getLabel45() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel45();
    }

    @JsonIgnore
    public Label getLabel46() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel46();
    }

    @JsonIgnore
    public Label getLabel47() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel47();
    }

    @JsonIgnore
    public Label getLabel48() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel48();
    }

    @JsonIgnore
    public Label getLabel49() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel49();
    }

    @JsonIgnore
    public Label getLabel50() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel50();
    }

    @JsonIgnore
    public Label getLabel51() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel51();
    }

    @JsonIgnore
    public Label getLabel52() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel52();
    }

    @JsonIgnore
    public Label getLabel53() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel53();
    }

    @JsonIgnore
    public Label getLabel54() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel54();
    }

    @JsonIgnore
    public Label getLabel55() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel55();
    }

    @JsonIgnore
    public Label getLabel56() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel56();
    }

    @JsonIgnore
    public Label getLabel57() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel57();
    }

    @JsonIgnore
    public Label getLabel58() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel58();
    }

    @JsonIgnore
    public Label getLabel59() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel59();
    }

    @JsonIgnore
    public Label getLabel60() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel60();
    }

    @JsonIgnore
    public Label getLabel61() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel61();
    }

    @JsonIgnore
    public Label getLabel62() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel62();
    }

    @JsonIgnore
    public Label getLabel63() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel63();
    }

    @JsonIgnore
    public Label getLabel64() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel64();
    }

    @JsonIgnore
    public Label getLabel65() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel65();
    }

    @JsonIgnore
    public Label getLabel66() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel66();
    }

    @JsonIgnore
    public Label getLabel67() {
        return this.getTblChoshuYuyo().getKiwarigaku().getTablePanel2().getLabel67();
    }

}
