package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.ChoshuYuyoKikanDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ChoshuYuyoTbl のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChoshuYuyoTblDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celChoshuYuyo1")
    private celChoshuYuyo1AtChoshuYuyoTbl celChoshuYuyo1;
    @JsonProperty("celChoshuYuyo2")
    private celChoshuYuyo2AtChoshuYuyoTbl celChoshuYuyo2;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBoxDate getTxtChoshuYuyoShinseiYMD() {
        return this.celChoshuYuyo1.getTxtChoshuYuyoShinseiYMD();
    }

    @JsonIgnore
    public TextBox getTxtChoshuYuyoShinseiRiyu() {
        return this.celChoshuYuyo1.getTxtChoshuYuyoShinseiRiyu();
    }

    @JsonIgnore
    public TextBoxDate getTxtChoshuYuyoKeitteiYMD() {
        return this.celChoshuYuyo1.getTxtChoshuYuyoKeitteiYMD();
    }

    @JsonIgnore
    public TextBox getTxtChoshuYuyoShurui() {
        return this.celChoshuYuyo1.getTxtChoshuYuyoShurui();
    }

    @JsonIgnore
    public TextBox getTxtChoshuYuyoShouninRiyu() {
        return this.celChoshuYuyo1.getTxtChoshuYuyoShouninRiyu();
    }

    @JsonIgnore
    public ChoshuYuyoKikanDiv getChoshuYuyoKikan() {
        return this.celChoshuYuyo2.getChoshuYuyoKikan();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celChoshuYuyo1")
    private celChoshuYuyo1AtChoshuYuyoTbl getCelChoshuYuyo1() {
        return celChoshuYuyo1;
    }

    @JsonProperty("celChoshuYuyo1")
    private void setCelChoshuYuyo1(celChoshuYuyo1AtChoshuYuyoTbl celChoshuYuyo1) {
        this.celChoshuYuyo1=celChoshuYuyo1;
    }

    @JsonProperty("celChoshuYuyo2")
    private celChoshuYuyo2AtChoshuYuyoTbl getCelChoshuYuyo2() {
        return celChoshuYuyo2;
    }

    @JsonProperty("celChoshuYuyo2")
    private void setCelChoshuYuyo2(celChoshuYuyo2AtChoshuYuyoTbl celChoshuYuyo2) {
        this.celChoshuYuyo2=celChoshuYuyo2;
    }

}
/**
 * celChoshuYuyo1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoshuYuyo1AtChoshuYuyoTbl extends TableCell {
    @JsonProperty("txtChoshuYuyoShinseiYMD")
    private TextBoxDate txtChoshuYuyoShinseiYMD;
    @JsonProperty("txtChoshuYuyoShinseiRiyu")
    private TextBox txtChoshuYuyoShinseiRiyu;
    @JsonProperty("txtChoshuYuyoKeitteiYMD")
    private TextBoxDate txtChoshuYuyoKeitteiYMD;
    @JsonProperty("txtChoshuYuyoShurui")
    private TextBox txtChoshuYuyoShurui;
    @JsonProperty("txtChoshuYuyoShouninRiyu")
    private TextBox txtChoshuYuyoShouninRiyu;

    @JsonProperty("txtChoshuYuyoShinseiYMD")
    public TextBoxDate getTxtChoshuYuyoShinseiYMD() {
        return txtChoshuYuyoShinseiYMD;
    }

    @JsonProperty("txtChoshuYuyoShinseiYMD")
    public void setTxtChoshuYuyoShinseiYMD(TextBoxDate txtChoshuYuyoShinseiYMD) {
        this.txtChoshuYuyoShinseiYMD=txtChoshuYuyoShinseiYMD;
    }

    @JsonProperty("txtChoshuYuyoShinseiRiyu")
    public TextBox getTxtChoshuYuyoShinseiRiyu() {
        return txtChoshuYuyoShinseiRiyu;
    }

    @JsonProperty("txtChoshuYuyoShinseiRiyu")
    public void setTxtChoshuYuyoShinseiRiyu(TextBox txtChoshuYuyoShinseiRiyu) {
        this.txtChoshuYuyoShinseiRiyu=txtChoshuYuyoShinseiRiyu;
    }

    @JsonProperty("txtChoshuYuyoKeitteiYMD")
    public TextBoxDate getTxtChoshuYuyoKeitteiYMD() {
        return txtChoshuYuyoKeitteiYMD;
    }

    @JsonProperty("txtChoshuYuyoKeitteiYMD")
    public void setTxtChoshuYuyoKeitteiYMD(TextBoxDate txtChoshuYuyoKeitteiYMD) {
        this.txtChoshuYuyoKeitteiYMD=txtChoshuYuyoKeitteiYMD;
    }

    @JsonProperty("txtChoshuYuyoShurui")
    public TextBox getTxtChoshuYuyoShurui() {
        return txtChoshuYuyoShurui;
    }

    @JsonProperty("txtChoshuYuyoShurui")
    public void setTxtChoshuYuyoShurui(TextBox txtChoshuYuyoShurui) {
        this.txtChoshuYuyoShurui=txtChoshuYuyoShurui;
    }

    @JsonProperty("txtChoshuYuyoShouninRiyu")
    public TextBox getTxtChoshuYuyoShouninRiyu() {
        return txtChoshuYuyoShouninRiyu;
    }

    @JsonProperty("txtChoshuYuyoShouninRiyu")
    public void setTxtChoshuYuyoShouninRiyu(TextBox txtChoshuYuyoShouninRiyu) {
        this.txtChoshuYuyoShouninRiyu=txtChoshuYuyoShouninRiyu;
    }

}
/**
 * celChoshuYuyo2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoshuYuyo2AtChoshuYuyoTbl extends TableCell {
    @JsonProperty("ChoshuYuyoKikan")
    private ChoshuYuyoKikanDiv ChoshuYuyoKikan;

    @JsonProperty("ChoshuYuyoKikan")
    public ChoshuYuyoKikanDiv getChoshuYuyoKikan() {
        return ChoshuYuyoKikan;
    }

    @JsonProperty("ChoshuYuyoKikan")
    public void setChoshuYuyoKikan(ChoshuYuyoKikanDiv ChoshuYuyoKikan) {
        this.ChoshuYuyoKikan=ChoshuYuyoKikan;
    }

}
