package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.SeikatsuHogoJohoCommonDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelDairiNoufu のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelDairiNoufuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-27_09-11-55">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKubun")
    private RadioButton radKubun;
    @JsonProperty("txtNoufuKubunYMD")
    private TextBoxDate txtNoufuKubunYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradKubun
     * @return radKubun
     */
    @JsonProperty("radKubun")
    public RadioButton getRadKubun() {
        return radKubun;
    }

    /*
     * setradKubun
     * @param radKubun radKubun
     */
    @JsonProperty("radKubun")
    public void setRadKubun(RadioButton radKubun) {
        this.radKubun = radKubun;
    }

    /*
     * gettxtNoufuKubunYMD
     * @return txtNoufuKubunYMD
     */
    @JsonProperty("txtNoufuKubunYMD")
    public TextBoxDate getTxtNoufuKubunYMD() {
        return txtNoufuKubunYMD;
    }

    /*
     * settxtNoufuKubunYMD
     * @param txtNoufuKubunYMD txtNoufuKubunYMD
     */
    @JsonProperty("txtNoufuKubunYMD")
    public void setTxtNoufuKubunYMD(TextBoxDate txtNoufuKubunYMD) {
        this.txtNoufuKubunYMD = txtNoufuKubunYMD;
    }

    // </editor-fold>
}
