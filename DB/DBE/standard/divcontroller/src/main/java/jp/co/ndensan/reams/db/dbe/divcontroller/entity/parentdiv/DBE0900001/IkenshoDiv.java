package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Ikensho のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenshoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-24_17-05-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIkenshoIraibi")
    private TextBoxDate txtIkenshoIraibi;
    @JsonProperty("txtIkenshoJuryobi")
    private TextBoxDate txtIkenshoJuryobi;
    @JsonProperty("ccdShujiiIryoKikanAndShujiiInput")
    private ShujiiIryokikanAndShujiiInputDiv ccdShujiiIryoKikanAndShujiiInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtIkenshoIraibi
     * @return txtIkenshoIraibi
     */
    @JsonProperty("txtIkenshoIraibi")
    public TextBoxDate getTxtIkenshoIraibi() {
        return txtIkenshoIraibi;
    }

    /*
     * settxtIkenshoIraibi
     * @param txtIkenshoIraibi txtIkenshoIraibi
     */
    @JsonProperty("txtIkenshoIraibi")
    public void setTxtIkenshoIraibi(TextBoxDate txtIkenshoIraibi) {
        this.txtIkenshoIraibi = txtIkenshoIraibi;
    }

    /*
     * gettxtIkenshoJuryobi
     * @return txtIkenshoJuryobi
     */
    @JsonProperty("txtIkenshoJuryobi")
    public TextBoxDate getTxtIkenshoJuryobi() {
        return txtIkenshoJuryobi;
    }

    /*
     * settxtIkenshoJuryobi
     * @param txtIkenshoJuryobi txtIkenshoJuryobi
     */
    @JsonProperty("txtIkenshoJuryobi")
    public void setTxtIkenshoJuryobi(TextBoxDate txtIkenshoJuryobi) {
        this.txtIkenshoJuryobi = txtIkenshoJuryobi;
    }

    /*
     * getccdShujiiIryoKikanAndShujiiInput
     * @return ccdShujiiIryoKikanAndShujiiInput
     */
    @JsonProperty("ccdShujiiIryoKikanAndShujiiInput")
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryoKikanAndShujiiInput() {
        return ccdShujiiIryoKikanAndShujiiInput;
    }

    // </editor-fold>
}
