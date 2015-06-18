package jp.co.ndensan.reams.db.dbd.divcontroller.entity.KaigoNinteiShinseiKihonJohoInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiShinseiRiyu のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiShinseiRiyuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnNinteiShinseiRiyuTeikeibun")
    private ButtonDialog btnNinteiShinseiRiyuTeikeibun;
    @JsonProperty("txtNinteiShinseRiyu")
    private TextBoxMultiLine txtNinteiShinseRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnNinteiShinseiRiyuTeikeibun")
    public ButtonDialog getBtnNinteiShinseiRiyuTeikeibun() {
        return btnNinteiShinseiRiyuTeikeibun;
    }

    @JsonProperty("btnNinteiShinseiRiyuTeikeibun")
    public void setBtnNinteiShinseiRiyuTeikeibun(ButtonDialog btnNinteiShinseiRiyuTeikeibun) {
        this.btnNinteiShinseiRiyuTeikeibun=btnNinteiShinseiRiyuTeikeibun;
    }

    @JsonProperty("txtNinteiShinseRiyu")
    public TextBoxMultiLine getTxtNinteiShinseRiyu() {
        return txtNinteiShinseRiyu;
    }

    @JsonProperty("txtNinteiShinseRiyu")
    public void setTxtNinteiShinseRiyu(TextBoxMultiLine txtNinteiShinseRiyu) {
        this.txtNinteiShinseRiyu=txtNinteiShinseRiyu;
    }

    // </editor-fold>
}
