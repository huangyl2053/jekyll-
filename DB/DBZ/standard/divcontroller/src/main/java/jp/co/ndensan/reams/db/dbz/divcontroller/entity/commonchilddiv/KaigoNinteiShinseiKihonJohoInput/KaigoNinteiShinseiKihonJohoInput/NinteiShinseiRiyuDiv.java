package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput;
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
 * @reamsid_L DBZ-1300-070 wangxiaodong
 */
public class NinteiShinseiRiyuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
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
    /*
     * getbtnNinteiShinseiRiyuTeikeibun
     * @return btnNinteiShinseiRiyuTeikeibun
     */
    @JsonProperty("btnNinteiShinseiRiyuTeikeibun")
    public ButtonDialog getBtnNinteiShinseiRiyuTeikeibun() {
        return btnNinteiShinseiRiyuTeikeibun;
    }

    /*
     * setbtnNinteiShinseiRiyuTeikeibun
     * @param btnNinteiShinseiRiyuTeikeibun btnNinteiShinseiRiyuTeikeibun
     */
    @JsonProperty("btnNinteiShinseiRiyuTeikeibun")
    public void setBtnNinteiShinseiRiyuTeikeibun(ButtonDialog btnNinteiShinseiRiyuTeikeibun) {
        this.btnNinteiShinseiRiyuTeikeibun = btnNinteiShinseiRiyuTeikeibun;
    }

    /*
     * gettxtNinteiShinseRiyu
     * @return txtNinteiShinseRiyu
     */
    @JsonProperty("txtNinteiShinseRiyu")
    public TextBoxMultiLine getTxtNinteiShinseRiyu() {
        return txtNinteiShinseRiyu;
    }

    /*
     * settxtNinteiShinseRiyu
     * @param txtNinteiShinseRiyu txtNinteiShinseRiyu
     */
    @JsonProperty("txtNinteiShinseRiyu")
    public void setTxtNinteiShinseRiyu(TextBoxMultiLine txtNinteiShinseRiyu) {
        this.txtNinteiShinseRiyu = txtNinteiShinseRiyu;
    }

    // </editor-fold>
}
