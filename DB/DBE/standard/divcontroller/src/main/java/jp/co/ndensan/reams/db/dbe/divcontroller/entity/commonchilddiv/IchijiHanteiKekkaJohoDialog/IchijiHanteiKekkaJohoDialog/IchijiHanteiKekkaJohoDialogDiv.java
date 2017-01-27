package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaJohoDialog.IchijiHanteiKekkaJohoDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho.IIchijiHanteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IchijiHanteiKekkaJohoDialog のクラスファイル
 *
 * @author 自動生成
 */
public class IchijiHanteiKekkaJohoDialogDiv extends Panel implements IIchijiHanteiKekkaJohoDialogDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-01-10_09-26-16">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdIchijiHanteiKekkaJoho")
    private IchijiHanteiKekkaJohoDiv ccdIchijiHanteiKekkaJoho;
    @JsonProperty("btnBack")
    private Button btnBack;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdIchijiHanteiKekkaJoho
     * @return ccdIchijiHanteiKekkaJoho
     */
    @JsonProperty("ccdIchijiHanteiKekkaJoho")
    public IIchijiHanteiKekkaJohoDiv getCcdIchijiHanteiKekkaJoho() {
        return ccdIchijiHanteiKekkaJoho;
    }

    /*
     * getbtnBack
     * @return btnBack
     */
    @JsonProperty("btnBack")
    public Button getBtnBack() {
        return btnBack;
    }

    /*
     * setbtnBack
     * @param btnBack btnBack
     */
    @JsonProperty("btnBack")
    public void setBtnBack(Button btnBack) {
        this.btnBack = btnBack;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 一次判定結果情報共有子Divを取得します。インターフェースを介しません。
     *
     * @return 一次判定結果情報共有子Div
     */
    public IchijiHanteiKekkaJohoDiv get一次判定結果情報Div() {
        return ccdIchijiHanteiKekkaJoho;
    }
}
