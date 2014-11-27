package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.HenkoHokenshaJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.HenkoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.JutokuInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.JutokuKaijoHokenshaJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.JutokuKaijoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.JutokuTekiyoHokenshaJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.JutokuTekiyoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.TabPanel1Div;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.dgHenko_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.dgJutoku_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.tabShisakuShosaiRirekiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.tblDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.tplHenkoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.tplJutokuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.IShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShikakuShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuShosaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbl")
    private tblDiv tbl;
    @JsonProperty("tabShisakuShosaiRireki")
    private tabShisakuShosaiRirekiDiv tabShisakuShosaiRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tbl")
    public tblDiv getTbl() {
        return tbl;
    }

    @JsonProperty("tbl")
    public void setTbl(tblDiv tbl) {
        this.tbl=tbl;
    }

    @JsonProperty("tabShisakuShosaiRireki")
    public tabShisakuShosaiRirekiDiv getTabShisakuShosaiRireki() {
        return tabShisakuShosaiRireki;
    }

    @JsonProperty("tabShisakuShosaiRireki")
    public void setTabShisakuShosaiRireki(tabShisakuShosaiRirekiDiv tabShisakuShosaiRireki) {
        this.tabShisakuShosaiRireki=tabShisakuShosaiRireki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblShutokuDate() {
        return this.getTbl().getLblShutokuDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShutokuDate() {
        return this.getTbl().getTxtShutokuDate();
    }

    @JsonIgnore
    public Label getLblShutokuTodokedeDate() {
        return this.getTbl().getLblShutokuTodokedeDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTextBoxFlexibleDate3() {
        return this.getTbl().getTextBoxFlexibleDate3();
    }

    @JsonIgnore
    public Label getLblShutokuJiyu() {
        return this.getTbl().getLblShutokuJiyu();
    }

    @JsonIgnore
    public DropDownList getDropDownList5() {
        return this.getTbl().getDropDownList5();
    }

    @JsonIgnore
    public Label getLblHihokenshaKubun() {
        return this.getTbl().getLblHihokenshaKubun();
    }

    @JsonIgnore
    public DropDownList getDropDownList4() {
        return this.getTbl().getDropDownList4();
    }

    @JsonIgnore
    public Label getLblShutokuShozaiHokensha() {
        return this.getTbl().getLblShutokuShozaiHokensha();
    }

    @JsonIgnore
    public DropDownList getDropDownList3() {
        return this.getTbl().getDropDownList3();
    }

    @JsonIgnore
    public Label getLblShutokuSochimotoHokensha() {
        return this.getTbl().getLblShutokuSochimotoHokensha();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuSochimotoHokensha() {
        return this.getTbl().getDdlShutokuSochimotoHokensha();
    }

    @JsonIgnore
    public Label getLblKyuHokensha() {
        return this.getTbl().getLblKyuHokensha();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuKyuHokensha() {
        return this.getTbl().getDdlShutokuKyuHokensha();
    }

    @JsonIgnore
    public Label getLblShoriDate() {
        return this.getTbl().getLblShoriDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTextBoxFlexibleDate2() {
        return this.getTbl().getTextBoxFlexibleDate2();
    }

    @JsonIgnore
    public Label getLabel5() {
        return this.getTbl().getLabel5();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTextBoxFlexibleDate4() {
        return this.getTbl().getTextBoxFlexibleDate4();
    }

    @JsonIgnore
    public Label getLabel6() {
        return this.getTbl().getLabel6();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTextBoxFlexibleDate5() {
        return this.getTbl().getTextBoxFlexibleDate5();
    }

    @JsonIgnore
    public Label getLabel7() {
        return this.getTbl().getLabel7();
    }

    @JsonIgnore
    public DropDownList getDropDownList2() {
        return this.getTbl().getDropDownList2();
    }

    @JsonIgnore
    public Label getLabel8() {
        return this.getTbl().getLabel8();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTextBoxFlexibleDate6() {
        return this.getTbl().getTextBoxFlexibleDate6();
    }

    @JsonIgnore
    public tplJutokuDiv getTplJutoku() {
        return this.getTabShisakuShosaiRireki().getTplJutoku();
    }

    @JsonIgnore
    public void  setTplJutoku(tplJutokuDiv tplJutoku) {
        this.getTabShisakuShosaiRireki().setTplJutoku(tplJutoku);
    }

    @JsonIgnore
    public DataGrid<dgJutoku_Row> getDgJutoku() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getDgJutoku();
    }

    @JsonIgnore
    public void  setDgJutoku(DataGrid<dgJutoku_Row> dgJutoku) {
        this.getTabShisakuShosaiRireki().getTplJutoku().setDgJutoku(dgJutoku);
    }

    @JsonIgnore
    public JutokuInputDiv getJutokuInput() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput();
    }

    @JsonIgnore
    public void  setJutokuInput(JutokuInputDiv JutokuInput) {
        this.getTabShisakuShosaiRireki().getTplJutoku().setJutokuInput(JutokuInput);
    }

    @JsonIgnore
    public JutokuTekiyoInputDiv getJutokuTekiyoInput() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuTekiyoInput();
    }

    @JsonIgnore
    public void  setJutokuTekiyoInput(JutokuTekiyoInputDiv JutokuTekiyoInput) {
        this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().setJutokuTekiyoInput(JutokuTekiyoInput);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoDate() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getTxtTekiyoDate();
    }

    @JsonIgnore
    public void  setTxtTekiyoDate(TextBoxFlexibleDate txtTekiyoDate) {
        this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuTekiyoInput().setTxtTekiyoDate(txtTekiyoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekyoTodokedeDate() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getTxtTekyoTodokedeDate();
    }

    @JsonIgnore
    public void  setTxtTekyoTodokedeDate(TextBoxFlexibleDate txtTekyoTodokedeDate) {
        this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuTekiyoInput().setTxtTekyoTodokedeDate(txtTekyoTodokedeDate);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoJiyu() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getDdlTekiyoJiyu();
    }

    @JsonIgnore
    public void  setDdlTekiyoJiyu(DropDownList ddlTekiyoJiyu) {
        this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuTekiyoInput().setDdlTekiyoJiyu(ddlTekiyoJiyu);
    }

    @JsonIgnore
    public JutokuTekiyoHokenshaJohoDiv getJutokuTekiyoHokenshaJoho() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho();
    }

    @JsonIgnore
    public void  setJutokuTekiyoHokenshaJoho(JutokuTekiyoHokenshaJohoDiv JutokuTekiyoHokenshaJoho) {
        this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuTekiyoInput().setJutokuTekiyoHokenshaJoho(JutokuTekiyoHokenshaJoho);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoShozaiHokensha() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().getDdlTekiyoShozaiHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyoShozaiHokensha(DropDownList ddlTekiyoShozaiHokensha) {
        this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().setDdlTekiyoShozaiHokensha(ddlTekiyoShozaiHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoSochimotoHokensha() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().getDdlTekiyoSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyoSochimotoHokensha(DropDownList ddlTekiyoSochimotoHokensha) {
        this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().setDdlTekiyoSochimotoHokensha(ddlTekiyoSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoKyuHokensha() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().getDdlTekiyoKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyoKyuHokensha(DropDownList ddlTekiyoKyuHokensha) {
        this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().setDdlTekiyoKyuHokensha(ddlTekiyoKyuHokensha);
    }

    @JsonIgnore
    public JutokuKaijoInputDiv getJutokuKaijoInput() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuKaijoInput();
    }

    @JsonIgnore
    public void  setJutokuKaijoInput(JutokuKaijoInputDiv JutokuKaijoInput) {
        this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().setJutokuKaijoInput(JutokuKaijoInput);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaijoDate() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuKaijoInput().getTxtKaijoDate();
    }

    @JsonIgnore
    public void  setTxtKaijoDate(TextBoxFlexibleDate txtKaijoDate) {
        this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuKaijoInput().setTxtKaijoDate(txtKaijoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaijoTodokedeDate() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuKaijoInput().getTxtKaijoTodokedeDate();
    }

    @JsonIgnore
    public void  setTxtKaijoTodokedeDate(TextBoxFlexibleDate txtKaijoTodokedeDate) {
        this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuKaijoInput().setTxtKaijoTodokedeDate(txtKaijoTodokedeDate);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoJIyu() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuKaijoInput().getDdlKaijoJIyu();
    }

    @JsonIgnore
    public void  setDdlKaijoJIyu(DropDownList ddlKaijoJIyu) {
        this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuKaijoInput().setDdlKaijoJIyu(ddlKaijoJIyu);
    }

    @JsonIgnore
    public JutokuKaijoHokenshaJohoDiv getJutokuKaijoHokenshaJoho() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho();
    }

    @JsonIgnore
    public void  setJutokuKaijoHokenshaJoho(JutokuKaijoHokenshaJohoDiv JutokuKaijoHokenshaJoho) {
        this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuKaijoInput().setJutokuKaijoHokenshaJoho(JutokuKaijoHokenshaJoho);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoShozaiHokensha() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().getDdlKaijoShozaiHokensha();
    }

    @JsonIgnore
    public void  setDdlKaijoShozaiHokensha(DropDownList ddlKaijoShozaiHokensha) {
        this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().setDdlKaijoShozaiHokensha(ddlKaijoShozaiHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoSochimotoHokensha() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().getDdlKaijoSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlKaijoSochimotoHokensha(DropDownList ddlKaijoSochimotoHokensha) {
        this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().setDdlKaijoSochimotoHokensha(ddlKaijoSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoKyuHokensha() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().getDdlKaijoKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlKaijoKyuHokensha(DropDownList ddlKaijoKyuHokensha) {
        this.getTabShisakuShosaiRireki().getTplJutoku().getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().setDdlKaijoKyuHokensha(ddlKaijoKyuHokensha);
    }

    @JsonIgnore
    public Button getButton3() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getButton3();
    }

    @JsonIgnore
    public void  setButton3(Button Button3) {
        this.getTabShisakuShosaiRireki().getTplJutoku().setButton3(Button3);
    }

    @JsonIgnore
    public tplHenkoDiv getTplHenko() {
        return this.getTabShisakuShosaiRireki().getTplHenko();
    }

    @JsonIgnore
    public void  setTplHenko(tplHenkoDiv tplHenko) {
        this.getTabShisakuShosaiRireki().setTplHenko(tplHenko);
    }

    @JsonIgnore
    public DataGrid<dgHenko_Row> getDgHenko() {
        return this.getTabShisakuShosaiRireki().getTplHenko().getDgHenko();
    }

    @JsonIgnore
    public void  setDgHenko(DataGrid<dgHenko_Row> dgHenko) {
        this.getTabShisakuShosaiRireki().getTplHenko().setDgHenko(dgHenko);
    }

    @JsonIgnore
    public HenkoInputDiv getHenkoInput() {
        return this.getTabShisakuShosaiRireki().getTplHenko().getHenkoInput();
    }

    @JsonIgnore
    public void  setHenkoInput(HenkoInputDiv HenkoInput) {
        this.getTabShisakuShosaiRireki().getTplHenko().setHenkoInput(HenkoInput);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHenkoDate() {
        return this.getTabShisakuShosaiRireki().getTplHenko().getHenkoInput().getTxtHenkoDate();
    }

    @JsonIgnore
    public void  setTxtHenkoDate(TextBoxFlexibleDate txtHenkoDate) {
        this.getTabShisakuShosaiRireki().getTplHenko().getHenkoInput().setTxtHenkoDate(txtHenkoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHenkoTodokedeDate() {
        return this.getTabShisakuShosaiRireki().getTplHenko().getHenkoInput().getTxtHenkoTodokedeDate();
    }

    @JsonIgnore
    public void  setTxtHenkoTodokedeDate(TextBoxFlexibleDate txtHenkoTodokedeDate) {
        this.getTabShisakuShosaiRireki().getTplHenko().getHenkoInput().setTxtHenkoTodokedeDate(txtHenkoTodokedeDate);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoJiyu() {
        return this.getTabShisakuShosaiRireki().getTplHenko().getHenkoInput().getDdlHenkoJiyu();
    }

    @JsonIgnore
    public void  setDdlHenkoJiyu(DropDownList ddlHenkoJiyu) {
        this.getTabShisakuShosaiRireki().getTplHenko().getHenkoInput().setDdlHenkoJiyu(ddlHenkoJiyu);
    }

    @JsonIgnore
    public HenkoHokenshaJohoDiv getHenkoHokenshaJoho() {
        return this.getTabShisakuShosaiRireki().getTplHenko().getHenkoInput().getHenkoHokenshaJoho();
    }

    @JsonIgnore
    public void  setHenkoHokenshaJoho(HenkoHokenshaJohoDiv HenkoHokenshaJoho) {
        this.getTabShisakuShosaiRireki().getTplHenko().getHenkoInput().setHenkoHokenshaJoho(HenkoHokenshaJoho);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoShozaiHokensha() {
        return this.getTabShisakuShosaiRireki().getTplHenko().getHenkoInput().getHenkoHokenshaJoho().getDdlHenkoShozaiHokensha();
    }

    @JsonIgnore
    public void  setDdlHenkoShozaiHokensha(DropDownList ddlHenkoShozaiHokensha) {
        this.getTabShisakuShosaiRireki().getTplHenko().getHenkoInput().getHenkoHokenshaJoho().setDdlHenkoShozaiHokensha(ddlHenkoShozaiHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoSochimotoHokensha() {
        return this.getTabShisakuShosaiRireki().getTplHenko().getHenkoInput().getHenkoHokenshaJoho().getDdlHenkoSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlHenkoSochimotoHokensha(DropDownList ddlHenkoSochimotoHokensha) {
        this.getTabShisakuShosaiRireki().getTplHenko().getHenkoInput().getHenkoHokenshaJoho().setDdlHenkoSochimotoHokensha(ddlHenkoSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoKyuHokensha() {
        return this.getTabShisakuShosaiRireki().getTplHenko().getHenkoInput().getHenkoHokenshaJoho().getDdlHenkoKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlHenkoKyuHokensha(DropDownList ddlHenkoKyuHokensha) {
        this.getTabShisakuShosaiRireki().getTplHenko().getHenkoInput().getHenkoHokenshaJoho().setDdlHenkoKyuHokensha(ddlHenkoKyuHokensha);
    }

    @JsonIgnore
    public Button getButton1() {
        return this.getTabShisakuShosaiRireki().getTplHenko().getButton1();
    }

    @JsonIgnore
    public void  setButton1(Button Button1) {
        this.getTabShisakuShosaiRireki().getTplHenko().setButton1(Button1);
    }

    @JsonIgnore
    public TabPanel1Div getTabPanel1() {
        return this.getTabShisakuShosaiRireki().getTabPanel1();
    }

    @JsonIgnore
    public void  setTabPanel1(TabPanel1Div TabPanel1) {
        this.getTabShisakuShosaiRireki().setTabPanel1(TabPanel1);
    }

    @JsonIgnore
    public IShisetsuNyutaishoRirekiKanriDiv getCommonChildDiv1() {
        return this.getTabShisakuShosaiRireki().getTabPanel1().getCommonChildDiv1();
    }

}
