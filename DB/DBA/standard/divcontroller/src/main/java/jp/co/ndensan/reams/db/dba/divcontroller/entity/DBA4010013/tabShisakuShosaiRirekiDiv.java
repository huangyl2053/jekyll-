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
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.tplHenkoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.tplJutokuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.IShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tabShisakuShosaiRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabShisakuShosaiRirekiDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplJutoku")
    private tplJutokuDiv tplJutoku;
    @JsonProperty("tplHenko")
    private tplHenkoDiv tplHenko;
    @JsonProperty("TabPanel1")
    private TabPanel1Div TabPanel1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplJutoku")
    public tplJutokuDiv getTplJutoku() {
        return tplJutoku;
    }

    @JsonProperty("tplJutoku")
    public void setTplJutoku(tplJutokuDiv tplJutoku) {
        this.tplJutoku=tplJutoku;
    }

    @JsonProperty("tplHenko")
    public tplHenkoDiv getTplHenko() {
        return tplHenko;
    }

    @JsonProperty("tplHenko")
    public void setTplHenko(tplHenkoDiv tplHenko) {
        this.tplHenko=tplHenko;
    }

    @JsonProperty("TabPanel1")
    public TabPanel1Div getTabPanel1() {
        return TabPanel1;
    }

    @JsonProperty("TabPanel1")
    public void setTabPanel1(TabPanel1Div TabPanel1) {
        this.TabPanel1=TabPanel1;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgJutoku_Row> getDgJutoku() {
        return this.getTplJutoku().getDgJutoku();
    }

    @JsonIgnore
    public void  setDgJutoku(DataGrid<dgJutoku_Row> dgJutoku) {
        this.getTplJutoku().setDgJutoku(dgJutoku);
    }

    @JsonIgnore
    public JutokuInputDiv getJutokuInput() {
        return this.getTplJutoku().getJutokuInput();
    }

    @JsonIgnore
    public void  setJutokuInput(JutokuInputDiv JutokuInput) {
        this.getTplJutoku().setJutokuInput(JutokuInput);
    }

    @JsonIgnore
    public JutokuTekiyoInputDiv getJutokuTekiyoInput() {
        return this.getTplJutoku().getJutokuInput().getJutokuTekiyoInput();
    }

    @JsonIgnore
    public void  setJutokuTekiyoInput(JutokuTekiyoInputDiv JutokuTekiyoInput) {
        this.getTplJutoku().getJutokuInput().setJutokuTekiyoInput(JutokuTekiyoInput);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoDate() {
        return this.getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getTxtTekiyoDate();
    }

    @JsonIgnore
    public void  setTxtTekiyoDate(TextBoxFlexibleDate txtTekiyoDate) {
        this.getTplJutoku().getJutokuInput().getJutokuTekiyoInput().setTxtTekiyoDate(txtTekiyoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekyoTodokedeDate() {
        return this.getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getTxtTekyoTodokedeDate();
    }

    @JsonIgnore
    public void  setTxtTekyoTodokedeDate(TextBoxFlexibleDate txtTekyoTodokedeDate) {
        this.getTplJutoku().getJutokuInput().getJutokuTekiyoInput().setTxtTekyoTodokedeDate(txtTekyoTodokedeDate);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoJiyu() {
        return this.getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getDdlTekiyoJiyu();
    }

    @JsonIgnore
    public void  setDdlTekiyoJiyu(DropDownList ddlTekiyoJiyu) {
        this.getTplJutoku().getJutokuInput().getJutokuTekiyoInput().setDdlTekiyoJiyu(ddlTekiyoJiyu);
    }

    @JsonIgnore
    public JutokuTekiyoHokenshaJohoDiv getJutokuTekiyoHokenshaJoho() {
        return this.getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho();
    }

    @JsonIgnore
    public void  setJutokuTekiyoHokenshaJoho(JutokuTekiyoHokenshaJohoDiv JutokuTekiyoHokenshaJoho) {
        this.getTplJutoku().getJutokuInput().getJutokuTekiyoInput().setJutokuTekiyoHokenshaJoho(JutokuTekiyoHokenshaJoho);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoShozaiHokensha() {
        return this.getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().getDdlTekiyoShozaiHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyoShozaiHokensha(DropDownList ddlTekiyoShozaiHokensha) {
        this.getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().setDdlTekiyoShozaiHokensha(ddlTekiyoShozaiHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoSochimotoHokensha() {
        return this.getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().getDdlTekiyoSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyoSochimotoHokensha(DropDownList ddlTekiyoSochimotoHokensha) {
        this.getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().setDdlTekiyoSochimotoHokensha(ddlTekiyoSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoKyuHokensha() {
        return this.getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().getDdlTekiyoKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyoKyuHokensha(DropDownList ddlTekiyoKyuHokensha) {
        this.getTplJutoku().getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().setDdlTekiyoKyuHokensha(ddlTekiyoKyuHokensha);
    }

    @JsonIgnore
    public JutokuKaijoInputDiv getJutokuKaijoInput() {
        return this.getTplJutoku().getJutokuInput().getJutokuKaijoInput();
    }

    @JsonIgnore
    public void  setJutokuKaijoInput(JutokuKaijoInputDiv JutokuKaijoInput) {
        this.getTplJutoku().getJutokuInput().setJutokuKaijoInput(JutokuKaijoInput);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaijoDate() {
        return this.getTplJutoku().getJutokuInput().getJutokuKaijoInput().getTxtKaijoDate();
    }

    @JsonIgnore
    public void  setTxtKaijoDate(TextBoxFlexibleDate txtKaijoDate) {
        this.getTplJutoku().getJutokuInput().getJutokuKaijoInput().setTxtKaijoDate(txtKaijoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaijoTodokedeDate() {
        return this.getTplJutoku().getJutokuInput().getJutokuKaijoInput().getTxtKaijoTodokedeDate();
    }

    @JsonIgnore
    public void  setTxtKaijoTodokedeDate(TextBoxFlexibleDate txtKaijoTodokedeDate) {
        this.getTplJutoku().getJutokuInput().getJutokuKaijoInput().setTxtKaijoTodokedeDate(txtKaijoTodokedeDate);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoJIyu() {
        return this.getTplJutoku().getJutokuInput().getJutokuKaijoInput().getDdlKaijoJIyu();
    }

    @JsonIgnore
    public void  setDdlKaijoJIyu(DropDownList ddlKaijoJIyu) {
        this.getTplJutoku().getJutokuInput().getJutokuKaijoInput().setDdlKaijoJIyu(ddlKaijoJIyu);
    }

    @JsonIgnore
    public JutokuKaijoHokenshaJohoDiv getJutokuKaijoHokenshaJoho() {
        return this.getTplJutoku().getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho();
    }

    @JsonIgnore
    public void  setJutokuKaijoHokenshaJoho(JutokuKaijoHokenshaJohoDiv JutokuKaijoHokenshaJoho) {
        this.getTplJutoku().getJutokuInput().getJutokuKaijoInput().setJutokuKaijoHokenshaJoho(JutokuKaijoHokenshaJoho);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoShozaiHokensha() {
        return this.getTplJutoku().getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().getDdlKaijoShozaiHokensha();
    }

    @JsonIgnore
    public void  setDdlKaijoShozaiHokensha(DropDownList ddlKaijoShozaiHokensha) {
        this.getTplJutoku().getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().setDdlKaijoShozaiHokensha(ddlKaijoShozaiHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoSochimotoHokensha() {
        return this.getTplJutoku().getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().getDdlKaijoSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlKaijoSochimotoHokensha(DropDownList ddlKaijoSochimotoHokensha) {
        this.getTplJutoku().getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().setDdlKaijoSochimotoHokensha(ddlKaijoSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoKyuHokensha() {
        return this.getTplJutoku().getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().getDdlKaijoKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlKaijoKyuHokensha(DropDownList ddlKaijoKyuHokensha) {
        this.getTplJutoku().getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().setDdlKaijoKyuHokensha(ddlKaijoKyuHokensha);
    }

    @JsonIgnore
    public Button getButton3() {
        return this.getTplJutoku().getButton3();
    }

    @JsonIgnore
    public void  setButton3(Button Button3) {
        this.getTplJutoku().setButton3(Button3);
    }

    @JsonIgnore
    public DataGrid<dgHenko_Row> getDgHenko() {
        return this.getTplHenko().getDgHenko();
    }

    @JsonIgnore
    public void  setDgHenko(DataGrid<dgHenko_Row> dgHenko) {
        this.getTplHenko().setDgHenko(dgHenko);
    }

    @JsonIgnore
    public HenkoInputDiv getHenkoInput() {
        return this.getTplHenko().getHenkoInput();
    }

    @JsonIgnore
    public void  setHenkoInput(HenkoInputDiv HenkoInput) {
        this.getTplHenko().setHenkoInput(HenkoInput);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHenkoDate() {
        return this.getTplHenko().getHenkoInput().getTxtHenkoDate();
    }

    @JsonIgnore
    public void  setTxtHenkoDate(TextBoxFlexibleDate txtHenkoDate) {
        this.getTplHenko().getHenkoInput().setTxtHenkoDate(txtHenkoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHenkoTodokedeDate() {
        return this.getTplHenko().getHenkoInput().getTxtHenkoTodokedeDate();
    }

    @JsonIgnore
    public void  setTxtHenkoTodokedeDate(TextBoxFlexibleDate txtHenkoTodokedeDate) {
        this.getTplHenko().getHenkoInput().setTxtHenkoTodokedeDate(txtHenkoTodokedeDate);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoJiyu() {
        return this.getTplHenko().getHenkoInput().getDdlHenkoJiyu();
    }

    @JsonIgnore
    public void  setDdlHenkoJiyu(DropDownList ddlHenkoJiyu) {
        this.getTplHenko().getHenkoInput().setDdlHenkoJiyu(ddlHenkoJiyu);
    }

    @JsonIgnore
    public HenkoHokenshaJohoDiv getHenkoHokenshaJoho() {
        return this.getTplHenko().getHenkoInput().getHenkoHokenshaJoho();
    }

    @JsonIgnore
    public void  setHenkoHokenshaJoho(HenkoHokenshaJohoDiv HenkoHokenshaJoho) {
        this.getTplHenko().getHenkoInput().setHenkoHokenshaJoho(HenkoHokenshaJoho);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoShozaiHokensha() {
        return this.getTplHenko().getHenkoInput().getHenkoHokenshaJoho().getDdlHenkoShozaiHokensha();
    }

    @JsonIgnore
    public void  setDdlHenkoShozaiHokensha(DropDownList ddlHenkoShozaiHokensha) {
        this.getTplHenko().getHenkoInput().getHenkoHokenshaJoho().setDdlHenkoShozaiHokensha(ddlHenkoShozaiHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoSochimotoHokensha() {
        return this.getTplHenko().getHenkoInput().getHenkoHokenshaJoho().getDdlHenkoSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlHenkoSochimotoHokensha(DropDownList ddlHenkoSochimotoHokensha) {
        this.getTplHenko().getHenkoInput().getHenkoHokenshaJoho().setDdlHenkoSochimotoHokensha(ddlHenkoSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoKyuHokensha() {
        return this.getTplHenko().getHenkoInput().getHenkoHokenshaJoho().getDdlHenkoKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlHenkoKyuHokensha(DropDownList ddlHenkoKyuHokensha) {
        this.getTplHenko().getHenkoInput().getHenkoHokenshaJoho().setDdlHenkoKyuHokensha(ddlHenkoKyuHokensha);
    }

    @JsonIgnore
    public Button getButton1() {
        return this.getTplHenko().getButton1();
    }

    @JsonIgnore
    public void  setButton1(Button Button1) {
        this.getTplHenko().setButton1(Button1);
    }

    @JsonIgnore
    public IShisetsuNyutaishoRirekiKanriDiv getCommonChildDiv1() {
        return this.getTabPanel1().getCommonChildDiv1();
    }

}
