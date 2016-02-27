package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * DaiiniJohoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class DaiiniJohoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtDairiYubinNo")
    private TextBoxYubinNo txtDairiYubinNo;
    @JsonProperty("txtDairiJusho")
    private TextBoxJusho txtDairiJusho;
    @JsonProperty("txtDairiJinJohoShimei")
    private TextBoxAtenaMeisho txtDairiJinJohoShimei;
    @JsonProperty("txtDairiTelNo")
    private TextBoxTelNo txtDairiTelNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtDairiYubinNo
     * @return txtDairiYubinNo
     */
    @JsonProperty("txtDairiYubinNo")
    public TextBoxYubinNo getTxtDairiYubinNo() {
        return txtDairiYubinNo;
    }

    /*
     * settxtDairiYubinNo
     * @param txtDairiYubinNo txtDairiYubinNo
     */
    @JsonProperty("txtDairiYubinNo")
    public void setTxtDairiYubinNo(TextBoxYubinNo txtDairiYubinNo) {
        this.txtDairiYubinNo = txtDairiYubinNo;
    }

    /*
     * gettxtDairiJusho
     * @return txtDairiJusho
     */
    @JsonProperty("txtDairiJusho")
    public TextBoxJusho getTxtDairiJusho() {
        return txtDairiJusho;
    }

    /*
     * settxtDairiJusho
     * @param txtDairiJusho txtDairiJusho
     */
    @JsonProperty("txtDairiJusho")
    public void setTxtDairiJusho(TextBoxJusho txtDairiJusho) {
        this.txtDairiJusho = txtDairiJusho;
    }

    /*
     * gettxtDairiJinJohoShimei
     * @return txtDairiJinJohoShimei
     */
    @JsonProperty("txtDairiJinJohoShimei")
    public TextBoxAtenaMeisho getTxtDairiJinJohoShimei() {
        return txtDairiJinJohoShimei;
    }

    /*
     * settxtDairiJinJohoShimei
     * @param txtDairiJinJohoShimei txtDairiJinJohoShimei
     */
    @JsonProperty("txtDairiJinJohoShimei")
    public void setTxtDairiJinJohoShimei(TextBoxAtenaMeisho txtDairiJinJohoShimei) {
        this.txtDairiJinJohoShimei = txtDairiJinJohoShimei;
    }

    /*
     * gettxtDairiTelNo
     * @return txtDairiTelNo
     */
    @JsonProperty("txtDairiTelNo")
    public TextBoxTelNo getTxtDairiTelNo() {
        return txtDairiTelNo;
    }

    /*
     * settxtDairiTelNo
     * @param txtDairiTelNo txtDairiTelNo
     */
    @JsonProperty("txtDairiTelNo")
    public void setTxtDairiTelNo(TextBoxTelNo txtDairiTelNo) {
        this.txtDairiTelNo = txtDairiTelNo;
    }

    // </editor-fold>
}
