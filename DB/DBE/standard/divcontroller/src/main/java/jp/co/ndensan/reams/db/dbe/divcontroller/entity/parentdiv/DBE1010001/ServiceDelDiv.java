package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ServiceDel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceDelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnServiceDelTeikeibunGuide")
    private ButtonDialog btnServiceDelTeikeibunGuide;
    @JsonProperty("txtServiceDeleteRiyu")
    private TextBoxMultiLine txtServiceDeleteRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnServiceDelTeikeibunGuide
     * @return btnServiceDelTeikeibunGuide
     */
    @JsonProperty("btnServiceDelTeikeibunGuide")
    public ButtonDialog getBtnServiceDelTeikeibunGuide() {
        return btnServiceDelTeikeibunGuide;
    }

    /*
     * setbtnServiceDelTeikeibunGuide
     * @param btnServiceDelTeikeibunGuide btnServiceDelTeikeibunGuide
     */
    @JsonProperty("btnServiceDelTeikeibunGuide")
    public void setBtnServiceDelTeikeibunGuide(ButtonDialog btnServiceDelTeikeibunGuide) {
        this.btnServiceDelTeikeibunGuide = btnServiceDelTeikeibunGuide;
    }

    /*
     * gettxtServiceDeleteRiyu
     * @return txtServiceDeleteRiyu
     */
    @JsonProperty("txtServiceDeleteRiyu")
    public TextBoxMultiLine getTxtServiceDeleteRiyu() {
        return txtServiceDeleteRiyu;
    }

    /*
     * settxtServiceDeleteRiyu
     * @param txtServiceDeleteRiyu txtServiceDeleteRiyu
     */
    @JsonProperty("txtServiceDeleteRiyu")
    public void setTxtServiceDeleteRiyu(TextBoxMultiLine txtServiceDeleteRiyu) {
        this.txtServiceDeleteRiyu = txtServiceDeleteRiyu;
    }

    // </editor-fold>
}
