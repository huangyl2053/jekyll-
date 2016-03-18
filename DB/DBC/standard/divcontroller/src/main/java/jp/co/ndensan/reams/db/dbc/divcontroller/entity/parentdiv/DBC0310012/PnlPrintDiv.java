package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlPrint のクラスファイル 
 * 
 * @author 自動生成
 */
public class PnlPrintDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChitibi")
    private TextBoxDate txtChitibi;
    @JsonProperty("txtBonsyoNo")
    private TextBoxCode txtBonsyoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChitibi
     * @return txtChitibi
     */
    @JsonProperty("txtChitibi")
    public TextBoxDate getTxtChitibi() {
        return txtChitibi;
    }

    /*
     * settxtChitibi
     * @param txtChitibi txtChitibi
     */
    @JsonProperty("txtChitibi")
    public void setTxtChitibi(TextBoxDate txtChitibi) {
        this.txtChitibi = txtChitibi;
    }

    /*
     * gettxtBonsyoNo
     * @return txtBonsyoNo
     */
    @JsonProperty("txtBonsyoNo")
    public TextBoxCode getTxtBonsyoNo() {
        return txtBonsyoNo;
    }

    /*
     * settxtBonsyoNo
     * @param txtBonsyoNo txtBonsyoNo
     */
    @JsonProperty("txtBonsyoNo")
    public void setTxtBonsyoNo(TextBoxCode txtBonsyoNo) {
        this.txtBonsyoNo = txtBonsyoNo;
    }

    // </editor-fold>
}
