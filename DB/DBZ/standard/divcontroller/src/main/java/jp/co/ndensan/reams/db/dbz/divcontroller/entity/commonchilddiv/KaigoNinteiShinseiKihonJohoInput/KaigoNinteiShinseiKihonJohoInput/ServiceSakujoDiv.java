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
 * ServiceSakujo のクラスファイル
 *
 * @reamsid_L DBZ-1300-070 wangxiaodong
 */
public class ServiceSakujoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnServiceSakujoTeikeibun")
    private ButtonDialog btnServiceSakujoTeikeibun;
    @JsonProperty("txtServiceSakujo")
    private TextBoxMultiLine txtServiceSakujo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnServiceSakujoTeikeibun
     * @return btnServiceSakujoTeikeibun
     */
    @JsonProperty("btnServiceSakujoTeikeibun")
    public ButtonDialog getBtnServiceSakujoTeikeibun() {
        return btnServiceSakujoTeikeibun;
    }

    /*
     * setbtnServiceSakujoTeikeibun
     * @param btnServiceSakujoTeikeibun btnServiceSakujoTeikeibun
     */
    @JsonProperty("btnServiceSakujoTeikeibun")
    public void setBtnServiceSakujoTeikeibun(ButtonDialog btnServiceSakujoTeikeibun) {
        this.btnServiceSakujoTeikeibun = btnServiceSakujoTeikeibun;
    }

    /*
     * gettxtServiceSakujo
     * @return txtServiceSakujo
     */
    @JsonProperty("txtServiceSakujo")
    public TextBoxMultiLine getTxtServiceSakujo() {
        return txtServiceSakujo;
    }

    /*
     * settxtServiceSakujo
     * @param txtServiceSakujo txtServiceSakujo
     */
    @JsonProperty("txtServiceSakujo")
    public void setTxtServiceSakujo(TextBoxMultiLine txtServiceSakujo) {
        this.txtServiceSakujo = txtServiceSakujo;
    }

    // </editor-fold>
}
