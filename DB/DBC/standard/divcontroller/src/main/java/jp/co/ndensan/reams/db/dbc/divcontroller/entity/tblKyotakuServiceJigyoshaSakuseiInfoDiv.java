package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tblKyotakuServiceJigyoshaSakuseiInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKyotakuServiceJigyoshaSakuseiInfoDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblKyotakuServiceJigyoshaSakuseiInfo1")
    private tblKyotakuServiceJigyoshaSakuseiInfo1AttblKyotakuServiceJigyoshaSakuseiInfo tblKyotakuServiceJigyoshaSakuseiInfo1;
    @JsonProperty("tblKyotakuServiceJigyoshaSakuseiInfo2")
    private tblKyotakuServiceJigyoshaSakuseiInfo2AttblKyotakuServiceJigyoshaSakuseiInfo tblKyotakuServiceJigyoshaSakuseiInfo2;
    @JsonProperty("tblKyotakuServiceJigyoshaSakuseiInfo3")
    private tblKyotakuServiceJigyoshaSakuseiInfo3AttblKyotakuServiceJigyoshaSakuseiInfo tblKyotakuServiceJigyoshaSakuseiInfo3;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBox getTxtJigyoshaSakuseiTodokedeKubun() {
        return this.tblKyotakuServiceJigyoshaSakuseiInfo1.getTxtJigyoshaSakuseiTodokedeKubun();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJigyoshaSakuseiTodokedeYMD() {
        return this.tblKyotakuServiceJigyoshaSakuseiInfo1.getTxtJigyoshaSakuseiTodokedeYMD();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJigyoshaSakuseiStartYMD() {
        return this.tblKyotakuServiceJigyoshaSakuseiInfo1.getTxtJigyoshaSakuseiStartYMD();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJigyoshaSakuseiEndYMD() {
        return this.tblKyotakuServiceJigyoshaSakuseiInfo1.getTxtJigyoshaSakuseiEndYMD();
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaSakuseiKubun() {
        return this.tblKyotakuServiceJigyoshaSakuseiInfo1.getTxtJigyoshaSakuseiKubun();
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaSakuseiJigyoshaNo() {
        return this.tblKyotakuServiceJigyoshaSakuseiInfo2.getTxtJigyoshaSakuseiJigyoshaNo();
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaSakuseiJigyoshaName() {
        return this.tblKyotakuServiceJigyoshaSakuseiInfo2.getTxtJigyoshaSakuseiJigyoshaName();
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaSakuseiCategory1() {
        return this.tblKyotakuServiceJigyoshaSakuseiInfo2.getTxtJigyoshaSakuseiCategory1();
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaSakuseiCategory2() {
        return this.tblKyotakuServiceJigyoshaSakuseiInfo2.getTxtJigyoshaSakuseiCategory2();
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaSakuseiCategory3() {
        return this.tblKyotakuServiceJigyoshaSakuseiInfo2.getTxtJigyoshaSakuseiCategory3();
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaSakuseiCategory4() {
        return this.tblKyotakuServiceJigyoshaSakuseiInfo2.getTxtJigyoshaSakuseiCategory4();
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtJigyoshaSakuseiYubinNo() {
        return this.tblKyotakuServiceJigyoshaSakuseiInfo2.getTxtJigyoshaSakuseiYubinNo();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtJigyoshaSakuseiJusho() {
        return this.tblKyotakuServiceJigyoshaSakuseiInfo2.getTxtJigyoshaSakuseiJusho();
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaSakuseiKanrisha() {
        return this.tblKyotakuServiceJigyoshaSakuseiInfo2.getTxtJigyoshaSakuseiKanrisha();
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaSakuseiTelNo() {
        return this.tblKyotakuServiceJigyoshaSakuseiInfo2.getTxtJigyoshaSakuseiTelNo();
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaSakuseiItakusakiNo() {
        return this.tblKyotakuServiceJigyoshaSakuseiInfo3.getTxtJigyoshaSakuseiItakusakiNo();
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaSakuseiItakusakiName() {
        return this.tblKyotakuServiceJigyoshaSakuseiInfo3.getTxtJigyoshaSakuseiItakusakiName();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJigyoshaSakuseiModifyYMD() {
        return this.tblKyotakuServiceJigyoshaSakuseiInfo3.getTxtJigyoshaSakuseiModifyYMD();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtJigyoshaSakuseiModifyRiyu() {
        return this.tblKyotakuServiceJigyoshaSakuseiInfo3.getTxtJigyoshaSakuseiModifyRiyu();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblKyotakuServiceJigyoshaSakuseiInfo1")
    private tblKyotakuServiceJigyoshaSakuseiInfo1AttblKyotakuServiceJigyoshaSakuseiInfo getTblKyotakuServiceJigyoshaSakuseiInfo1() {
        return tblKyotakuServiceJigyoshaSakuseiInfo1;
    }

    @JsonProperty("tblKyotakuServiceJigyoshaSakuseiInfo1")
    private void setTblKyotakuServiceJigyoshaSakuseiInfo1(tblKyotakuServiceJigyoshaSakuseiInfo1AttblKyotakuServiceJigyoshaSakuseiInfo tblKyotakuServiceJigyoshaSakuseiInfo1) {
        this.tblKyotakuServiceJigyoshaSakuseiInfo1=tblKyotakuServiceJigyoshaSakuseiInfo1;
    }

    @JsonProperty("tblKyotakuServiceJigyoshaSakuseiInfo2")
    private tblKyotakuServiceJigyoshaSakuseiInfo2AttblKyotakuServiceJigyoshaSakuseiInfo getTblKyotakuServiceJigyoshaSakuseiInfo2() {
        return tblKyotakuServiceJigyoshaSakuseiInfo2;
    }

    @JsonProperty("tblKyotakuServiceJigyoshaSakuseiInfo2")
    private void setTblKyotakuServiceJigyoshaSakuseiInfo2(tblKyotakuServiceJigyoshaSakuseiInfo2AttblKyotakuServiceJigyoshaSakuseiInfo tblKyotakuServiceJigyoshaSakuseiInfo2) {
        this.tblKyotakuServiceJigyoshaSakuseiInfo2=tblKyotakuServiceJigyoshaSakuseiInfo2;
    }

    @JsonProperty("tblKyotakuServiceJigyoshaSakuseiInfo3")
    private tblKyotakuServiceJigyoshaSakuseiInfo3AttblKyotakuServiceJigyoshaSakuseiInfo getTblKyotakuServiceJigyoshaSakuseiInfo3() {
        return tblKyotakuServiceJigyoshaSakuseiInfo3;
    }

    @JsonProperty("tblKyotakuServiceJigyoshaSakuseiInfo3")
    private void setTblKyotakuServiceJigyoshaSakuseiInfo3(tblKyotakuServiceJigyoshaSakuseiInfo3AttblKyotakuServiceJigyoshaSakuseiInfo tblKyotakuServiceJigyoshaSakuseiInfo3) {
        this.tblKyotakuServiceJigyoshaSakuseiInfo3=tblKyotakuServiceJigyoshaSakuseiInfo3;
    }

}
/**
 * tblKyotakuServiceJigyoshaSakuseiInfo1 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblKyotakuServiceJigyoshaSakuseiInfo1AttblKyotakuServiceJigyoshaSakuseiInfo extends TableCell {
    @JsonProperty("txtJigyoshaSakuseiTodokedeKubun")
    private TextBox txtJigyoshaSakuseiTodokedeKubun;
    @JsonProperty("txtJigyoshaSakuseiTodokedeYMD")
    private TextBoxFlexibleDate txtJigyoshaSakuseiTodokedeYMD;
    @JsonProperty("txtJigyoshaSakuseiStartYMD")
    private TextBoxFlexibleDate txtJigyoshaSakuseiStartYMD;
    @JsonProperty("txtJigyoshaSakuseiEndYMD")
    private TextBoxFlexibleDate txtJigyoshaSakuseiEndYMD;
    @JsonProperty("txtJigyoshaSakuseiKubun")
    private TextBox txtJigyoshaSakuseiKubun;

    @JsonProperty("txtJigyoshaSakuseiTodokedeKubun")
    public TextBox getTxtJigyoshaSakuseiTodokedeKubun() {
        return txtJigyoshaSakuseiTodokedeKubun;
    }

    @JsonProperty("txtJigyoshaSakuseiTodokedeKubun")
    public void setTxtJigyoshaSakuseiTodokedeKubun(TextBox txtJigyoshaSakuseiTodokedeKubun) {
        this.txtJigyoshaSakuseiTodokedeKubun=txtJigyoshaSakuseiTodokedeKubun;
    }

    @JsonProperty("txtJigyoshaSakuseiTodokedeYMD")
    public TextBoxFlexibleDate getTxtJigyoshaSakuseiTodokedeYMD() {
        return txtJigyoshaSakuseiTodokedeYMD;
    }

    @JsonProperty("txtJigyoshaSakuseiTodokedeYMD")
    public void setTxtJigyoshaSakuseiTodokedeYMD(TextBoxFlexibleDate txtJigyoshaSakuseiTodokedeYMD) {
        this.txtJigyoshaSakuseiTodokedeYMD=txtJigyoshaSakuseiTodokedeYMD;
    }

    @JsonProperty("txtJigyoshaSakuseiStartYMD")
    public TextBoxFlexibleDate getTxtJigyoshaSakuseiStartYMD() {
        return txtJigyoshaSakuseiStartYMD;
    }

    @JsonProperty("txtJigyoshaSakuseiStartYMD")
    public void setTxtJigyoshaSakuseiStartYMD(TextBoxFlexibleDate txtJigyoshaSakuseiStartYMD) {
        this.txtJigyoshaSakuseiStartYMD=txtJigyoshaSakuseiStartYMD;
    }

    @JsonProperty("txtJigyoshaSakuseiEndYMD")
    public TextBoxFlexibleDate getTxtJigyoshaSakuseiEndYMD() {
        return txtJigyoshaSakuseiEndYMD;
    }

    @JsonProperty("txtJigyoshaSakuseiEndYMD")
    public void setTxtJigyoshaSakuseiEndYMD(TextBoxFlexibleDate txtJigyoshaSakuseiEndYMD) {
        this.txtJigyoshaSakuseiEndYMD=txtJigyoshaSakuseiEndYMD;
    }

    @JsonProperty("txtJigyoshaSakuseiKubun")
    public TextBox getTxtJigyoshaSakuseiKubun() {
        return txtJigyoshaSakuseiKubun;
    }

    @JsonProperty("txtJigyoshaSakuseiKubun")
    public void setTxtJigyoshaSakuseiKubun(TextBox txtJigyoshaSakuseiKubun) {
        this.txtJigyoshaSakuseiKubun=txtJigyoshaSakuseiKubun;
    }

}
/**
 * tblKyotakuServiceJigyoshaSakuseiInfo2 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblKyotakuServiceJigyoshaSakuseiInfo2AttblKyotakuServiceJigyoshaSakuseiInfo extends TableCell {
    @JsonProperty("txtJigyoshaSakuseiJigyoshaNo")
    private TextBox txtJigyoshaSakuseiJigyoshaNo;
    @JsonProperty("txtJigyoshaSakuseiJigyoshaName")
    private TextBox txtJigyoshaSakuseiJigyoshaName;
    @JsonProperty("txtJigyoshaSakuseiCategory1")
    private TextBox txtJigyoshaSakuseiCategory1;
    @JsonProperty("txtJigyoshaSakuseiCategory2")
    private TextBox txtJigyoshaSakuseiCategory2;
    @JsonProperty("txtJigyoshaSakuseiCategory3")
    private TextBox txtJigyoshaSakuseiCategory3;
    @JsonProperty("txtJigyoshaSakuseiCategory4")
    private TextBox txtJigyoshaSakuseiCategory4;
    @JsonProperty("txtJigyoshaSakuseiYubinNo")
    private TextBoxYubinNo txtJigyoshaSakuseiYubinNo;
    @JsonProperty("txtJigyoshaSakuseiJusho")
    private TextBoxMultiLine txtJigyoshaSakuseiJusho;
    @JsonProperty("txtJigyoshaSakuseiKanrisha")
    private TextBox txtJigyoshaSakuseiKanrisha;
    @JsonProperty("txtJigyoshaSakuseiTelNo")
    private TextBox txtJigyoshaSakuseiTelNo;

    @JsonProperty("txtJigyoshaSakuseiJigyoshaNo")
    public TextBox getTxtJigyoshaSakuseiJigyoshaNo() {
        return txtJigyoshaSakuseiJigyoshaNo;
    }

    @JsonProperty("txtJigyoshaSakuseiJigyoshaNo")
    public void setTxtJigyoshaSakuseiJigyoshaNo(TextBox txtJigyoshaSakuseiJigyoshaNo) {
        this.txtJigyoshaSakuseiJigyoshaNo=txtJigyoshaSakuseiJigyoshaNo;
    }

    @JsonProperty("txtJigyoshaSakuseiJigyoshaName")
    public TextBox getTxtJigyoshaSakuseiJigyoshaName() {
        return txtJigyoshaSakuseiJigyoshaName;
    }

    @JsonProperty("txtJigyoshaSakuseiJigyoshaName")
    public void setTxtJigyoshaSakuseiJigyoshaName(TextBox txtJigyoshaSakuseiJigyoshaName) {
        this.txtJigyoshaSakuseiJigyoshaName=txtJigyoshaSakuseiJigyoshaName;
    }

    @JsonProperty("txtJigyoshaSakuseiCategory1")
    public TextBox getTxtJigyoshaSakuseiCategory1() {
        return txtJigyoshaSakuseiCategory1;
    }

    @JsonProperty("txtJigyoshaSakuseiCategory1")
    public void setTxtJigyoshaSakuseiCategory1(TextBox txtJigyoshaSakuseiCategory1) {
        this.txtJigyoshaSakuseiCategory1=txtJigyoshaSakuseiCategory1;
    }

    @JsonProperty("txtJigyoshaSakuseiCategory2")
    public TextBox getTxtJigyoshaSakuseiCategory2() {
        return txtJigyoshaSakuseiCategory2;
    }

    @JsonProperty("txtJigyoshaSakuseiCategory2")
    public void setTxtJigyoshaSakuseiCategory2(TextBox txtJigyoshaSakuseiCategory2) {
        this.txtJigyoshaSakuseiCategory2=txtJigyoshaSakuseiCategory2;
    }

    @JsonProperty("txtJigyoshaSakuseiCategory3")
    public TextBox getTxtJigyoshaSakuseiCategory3() {
        return txtJigyoshaSakuseiCategory3;
    }

    @JsonProperty("txtJigyoshaSakuseiCategory3")
    public void setTxtJigyoshaSakuseiCategory3(TextBox txtJigyoshaSakuseiCategory3) {
        this.txtJigyoshaSakuseiCategory3=txtJigyoshaSakuseiCategory3;
    }

    @JsonProperty("txtJigyoshaSakuseiCategory4")
    public TextBox getTxtJigyoshaSakuseiCategory4() {
        return txtJigyoshaSakuseiCategory4;
    }

    @JsonProperty("txtJigyoshaSakuseiCategory4")
    public void setTxtJigyoshaSakuseiCategory4(TextBox txtJigyoshaSakuseiCategory4) {
        this.txtJigyoshaSakuseiCategory4=txtJigyoshaSakuseiCategory4;
    }

    @JsonProperty("txtJigyoshaSakuseiYubinNo")
    public TextBoxYubinNo getTxtJigyoshaSakuseiYubinNo() {
        return txtJigyoshaSakuseiYubinNo;
    }

    @JsonProperty("txtJigyoshaSakuseiYubinNo")
    public void setTxtJigyoshaSakuseiYubinNo(TextBoxYubinNo txtJigyoshaSakuseiYubinNo) {
        this.txtJigyoshaSakuseiYubinNo=txtJigyoshaSakuseiYubinNo;
    }

    @JsonProperty("txtJigyoshaSakuseiJusho")
    public TextBoxMultiLine getTxtJigyoshaSakuseiJusho() {
        return txtJigyoshaSakuseiJusho;
    }

    @JsonProperty("txtJigyoshaSakuseiJusho")
    public void setTxtJigyoshaSakuseiJusho(TextBoxMultiLine txtJigyoshaSakuseiJusho) {
        this.txtJigyoshaSakuseiJusho=txtJigyoshaSakuseiJusho;
    }

    @JsonProperty("txtJigyoshaSakuseiKanrisha")
    public TextBox getTxtJigyoshaSakuseiKanrisha() {
        return txtJigyoshaSakuseiKanrisha;
    }

    @JsonProperty("txtJigyoshaSakuseiKanrisha")
    public void setTxtJigyoshaSakuseiKanrisha(TextBox txtJigyoshaSakuseiKanrisha) {
        this.txtJigyoshaSakuseiKanrisha=txtJigyoshaSakuseiKanrisha;
    }

    @JsonProperty("txtJigyoshaSakuseiTelNo")
    public TextBox getTxtJigyoshaSakuseiTelNo() {
        return txtJigyoshaSakuseiTelNo;
    }

    @JsonProperty("txtJigyoshaSakuseiTelNo")
    public void setTxtJigyoshaSakuseiTelNo(TextBox txtJigyoshaSakuseiTelNo) {
        this.txtJigyoshaSakuseiTelNo=txtJigyoshaSakuseiTelNo;
    }

}
/**
 * tblKyotakuServiceJigyoshaSakuseiInfo3 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblKyotakuServiceJigyoshaSakuseiInfo3AttblKyotakuServiceJigyoshaSakuseiInfo extends TableCell {
    @JsonProperty("txtJigyoshaSakuseiItakusakiNo")
    private TextBox txtJigyoshaSakuseiItakusakiNo;
    @JsonProperty("txtJigyoshaSakuseiItakusakiName")
    private TextBox txtJigyoshaSakuseiItakusakiName;
    @JsonProperty("txtJigyoshaSakuseiModifyYMD")
    private TextBoxFlexibleDate txtJigyoshaSakuseiModifyYMD;
    @JsonProperty("txtJigyoshaSakuseiModifyRiyu")
    private TextBoxMultiLine txtJigyoshaSakuseiModifyRiyu;

    @JsonProperty("txtJigyoshaSakuseiItakusakiNo")
    public TextBox getTxtJigyoshaSakuseiItakusakiNo() {
        return txtJigyoshaSakuseiItakusakiNo;
    }

    @JsonProperty("txtJigyoshaSakuseiItakusakiNo")
    public void setTxtJigyoshaSakuseiItakusakiNo(TextBox txtJigyoshaSakuseiItakusakiNo) {
        this.txtJigyoshaSakuseiItakusakiNo=txtJigyoshaSakuseiItakusakiNo;
    }

    @JsonProperty("txtJigyoshaSakuseiItakusakiName")
    public TextBox getTxtJigyoshaSakuseiItakusakiName() {
        return txtJigyoshaSakuseiItakusakiName;
    }

    @JsonProperty("txtJigyoshaSakuseiItakusakiName")
    public void setTxtJigyoshaSakuseiItakusakiName(TextBox txtJigyoshaSakuseiItakusakiName) {
        this.txtJigyoshaSakuseiItakusakiName=txtJigyoshaSakuseiItakusakiName;
    }

    @JsonProperty("txtJigyoshaSakuseiModifyYMD")
    public TextBoxFlexibleDate getTxtJigyoshaSakuseiModifyYMD() {
        return txtJigyoshaSakuseiModifyYMD;
    }

    @JsonProperty("txtJigyoshaSakuseiModifyYMD")
    public void setTxtJigyoshaSakuseiModifyYMD(TextBoxFlexibleDate txtJigyoshaSakuseiModifyYMD) {
        this.txtJigyoshaSakuseiModifyYMD=txtJigyoshaSakuseiModifyYMD;
    }

    @JsonProperty("txtJigyoshaSakuseiModifyRiyu")
    public TextBoxMultiLine getTxtJigyoshaSakuseiModifyRiyu() {
        return txtJigyoshaSakuseiModifyRiyu;
    }

    @JsonProperty("txtJigyoshaSakuseiModifyRiyu")
    public void setTxtJigyoshaSakuseiModifyRiyu(TextBoxMultiLine txtJigyoshaSakuseiModifyRiyu) {
        this.txtJigyoshaSakuseiModifyRiyu=txtJigyoshaSakuseiModifyRiyu;
    }

}
