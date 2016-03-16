package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IkenshoMemo のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenshoMemoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnMemoTeikeibunGuide")
    private ButtonDialog btnMemoTeikeibunGuide;
    @JsonProperty("txtShujiiMemo")
    private TextBoxMultiLine txtShujiiMemo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnMemoTeikeibunGuide
     * @return btnMemoTeikeibunGuide
     */
    @JsonProperty("btnMemoTeikeibunGuide")
    public ButtonDialog getBtnMemoTeikeibunGuide() {
        return btnMemoTeikeibunGuide;
    }

    /*
     * setbtnMemoTeikeibunGuide
     * @param btnMemoTeikeibunGuide btnMemoTeikeibunGuide
     */
    @JsonProperty("btnMemoTeikeibunGuide")
    public void setBtnMemoTeikeibunGuide(ButtonDialog btnMemoTeikeibunGuide) {
        this.btnMemoTeikeibunGuide = btnMemoTeikeibunGuide;
    }

    /*
     * gettxtShujiiMemo
     * @return txtShujiiMemo
     */
    @JsonProperty("txtShujiiMemo")
    public TextBoxMultiLine getTxtShujiiMemo() {
        return txtShujiiMemo;
    }

    /*
     * settxtShujiiMemo
     * @param txtShujiiMemo txtShujiiMemo
     */
    @JsonProperty("txtShujiiMemo")
    public void setTxtShujiiMemo(TextBoxMultiLine txtShujiiMemo) {
        this.txtShujiiMemo = txtShujiiMemo;
    }

    // </editor-fold>
}
