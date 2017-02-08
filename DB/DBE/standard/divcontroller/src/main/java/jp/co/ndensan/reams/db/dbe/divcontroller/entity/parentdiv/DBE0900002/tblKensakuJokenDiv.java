package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

/**
 * tblKensakuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKensakuJokenDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-01-10_09-26-16">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cel1")
    private cel1AttblKensakuJoken cel1;
    @JsonProperty("cel2")
    private cel2AttblKensakuJoken cel2;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public RadioButton getRadKensakuKomoku() {
        return this.cel1.getRadKensakuKomoku();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNijiHanteibi() {
        return this.cel2.getTxtNijiHanteibi();
    }

    @JsonIgnore
    public TextBoxCode getTxtHihokenshaNo() {
        return this.cel2.getTxtHihokenshaNo();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcel1
     * @return cel1
     */
    @JsonProperty("cel1")
    private cel1AttblKensakuJoken getCel1() {
        return cel1;
    }

    /*
     * setcel1
     * @param cel1 cel1
     */
    @JsonProperty("cel1")
    private void setCel1(cel1AttblKensakuJoken cel1) {
        this.cel1 = cel1;
    }

    /*
     * getcel2
     * @return cel2
     */
    @JsonProperty("cel2")
    private cel2AttblKensakuJoken getCel2() {
        return cel2;
    }

    /*
     * setcel2
     * @param cel2 cel2
     */
    @JsonProperty("cel2")
    private void setCel2(cel2AttblKensakuJoken cel2) {
        this.cel2 = cel2;
    }

    // </editor-fold>
}
/**
 * cel1 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel1AttblKensakuJoken extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-01-10_09-26-16">
    @JsonProperty("radKensakuKomoku")
    private RadioButton radKensakuKomoku;

    /*
     * getradKensakuKomoku
     * @return radKensakuKomoku
     */
    @JsonProperty("radKensakuKomoku")
    public RadioButton getRadKensakuKomoku() {
        return radKensakuKomoku;
    }

    /*
     * setradKensakuKomoku
     * @param radKensakuKomoku radKensakuKomoku
     */
    @JsonProperty("radKensakuKomoku")
    public void setRadKensakuKomoku(RadioButton radKensakuKomoku) {
        this.radKensakuKomoku = radKensakuKomoku;
    }

    // </editor-fold>
}
/**
 * cel2 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel2AttblKensakuJoken extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-01-10_09-26-16">
    @JsonProperty("txtNijiHanteibi")
    private TextBoxDateRange txtNijiHanteibi;
    @JsonProperty("txtHihokenshaNo")
    private TextBoxCode txtHihokenshaNo;

    /*
     * gettxtNijiHanteibi
     * @return txtNijiHanteibi
     */
    @JsonProperty("txtNijiHanteibi")
    public TextBoxDateRange getTxtNijiHanteibi() {
        return txtNijiHanteibi;
    }

    /*
     * settxtNijiHanteibi
     * @param txtNijiHanteibi txtNijiHanteibi
     */
    @JsonProperty("txtNijiHanteibi")
    public void setTxtNijiHanteibi(TextBoxDateRange txtNijiHanteibi) {
        this.txtNijiHanteibi = txtNijiHanteibi;
    }

    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBoxCode getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    // </editor-fold>
}
