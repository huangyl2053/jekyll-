package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshafinder.HihokenshaFinder;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoFinderDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoFinderDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHihokenshaJotai")
    private Label lblHihokenshaJotai;
    @JsonProperty("chkHihokenshaDaicho")
    private CheckBoxList chkHihokenshaDaicho;
    @JsonProperty("chkJukyushaDaicho")
    private CheckBoxList chkJukyushaDaicho;
    @JsonProperty("chkJushochiTokureisha")
    private CheckBoxList chkJushochiTokureisha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblHihokenshaJotai
     * @return lblHihokenshaJotai
     */
    @JsonProperty("lblHihokenshaJotai")
    public Label getLblHihokenshaJotai() {
        return lblHihokenshaJotai;
    }

    /*
     * setlblHihokenshaJotai
     * @param lblHihokenshaJotai lblHihokenshaJotai
     */
    @JsonProperty("lblHihokenshaJotai")
    public void setLblHihokenshaJotai(Label lblHihokenshaJotai) {
        this.lblHihokenshaJotai = lblHihokenshaJotai;
    }

    /*
     * getchkHihokenshaDaicho
     * @return chkHihokenshaDaicho
     */
    @JsonProperty("chkHihokenshaDaicho")
    public CheckBoxList getChkHihokenshaDaicho() {
        return chkHihokenshaDaicho;
    }

    /*
     * setchkHihokenshaDaicho
     * @param chkHihokenshaDaicho chkHihokenshaDaicho
     */
    @JsonProperty("chkHihokenshaDaicho")
    public void setChkHihokenshaDaicho(CheckBoxList chkHihokenshaDaicho) {
        this.chkHihokenshaDaicho = chkHihokenshaDaicho;
    }

    /*
     * getchkJukyushaDaicho
     * @return chkJukyushaDaicho
     */
    @JsonProperty("chkJukyushaDaicho")
    public CheckBoxList getChkJukyushaDaicho() {
        return chkJukyushaDaicho;
    }

    /*
     * setchkJukyushaDaicho
     * @param chkJukyushaDaicho chkJukyushaDaicho
     */
    @JsonProperty("chkJukyushaDaicho")
    public void setChkJukyushaDaicho(CheckBoxList chkJukyushaDaicho) {
        this.chkJukyushaDaicho = chkJukyushaDaicho;
    }

    /*
     * getchkJushochiTokureisha
     * @return chkJushochiTokureisha
     */
    @JsonProperty("chkJushochiTokureisha")
    public CheckBoxList getChkJushochiTokureisha() {
        return chkJushochiTokureisha;
    }

    /*
     * setchkJushochiTokureisha
     * @param chkJushochiTokureisha chkJushochiTokureisha
     */
    @JsonProperty("chkJushochiTokureisha")
    public void setChkJushochiTokureisha(CheckBoxList chkJushochiTokureisha) {
        this.chkJushochiTokureisha = chkJushochiTokureisha;
    }

    // </editor-fold>
}
