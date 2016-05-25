package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.chosaitakusakiandchosaininput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosa のクラスファイル 
 * 
 * @reamsid_L DBE-0230-010 zhangzhiming
 */
public class NinteiChosaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNinteiChosaIraibi")
    private TextBoxDate txtNinteiChosaIraibi;
    @JsonProperty("txtNinteiChosaJisshibi")
    private TextBoxDate txtNinteiChosaJisshibi;
    @JsonProperty("txtNinteiChosaJuryobi")
    private TextBoxDate txtNinteiChosaJuryobi;
    @JsonProperty("ccdChosaItakusakiAndChosainInput")
    private ChosaItakusakiAndChosainInputDiv ccdChosaItakusakiAndChosainInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNinteiChosaIraibi
     * @return txtNinteiChosaIraibi
     */
    @JsonProperty("txtNinteiChosaIraibi")
    public TextBoxDate getTxtNinteiChosaIraibi() {
        return txtNinteiChosaIraibi;
    }

    /*
     * settxtNinteiChosaIraibi
     * @param txtNinteiChosaIraibi txtNinteiChosaIraibi
     */
    @JsonProperty("txtNinteiChosaIraibi")
    public void setTxtNinteiChosaIraibi(TextBoxDate txtNinteiChosaIraibi) {
        this.txtNinteiChosaIraibi = txtNinteiChosaIraibi;
    }

    /*
     * gettxtNinteiChosaJisshibi
     * @return txtNinteiChosaJisshibi
     */
    @JsonProperty("txtNinteiChosaJisshibi")
    public TextBoxDate getTxtNinteiChosaJisshibi() {
        return txtNinteiChosaJisshibi;
    }

    /*
     * settxtNinteiChosaJisshibi
     * @param txtNinteiChosaJisshibi txtNinteiChosaJisshibi
     */
    @JsonProperty("txtNinteiChosaJisshibi")
    public void setTxtNinteiChosaJisshibi(TextBoxDate txtNinteiChosaJisshibi) {
        this.txtNinteiChosaJisshibi = txtNinteiChosaJisshibi;
    }

    /*
     * gettxtNinteiChosaJuryobi
     * @return txtNinteiChosaJuryobi
     */
    @JsonProperty("txtNinteiChosaJuryobi")
    public TextBoxDate getTxtNinteiChosaJuryobi() {
        return txtNinteiChosaJuryobi;
    }

    /*
     * settxtNinteiChosaJuryobi
     * @param txtNinteiChosaJuryobi txtNinteiChosaJuryobi
     */
    @JsonProperty("txtNinteiChosaJuryobi")
    public void setTxtNinteiChosaJuryobi(TextBoxDate txtNinteiChosaJuryobi) {
        this.txtNinteiChosaJuryobi = txtNinteiChosaJuryobi;
    }

    /*
     * getccdChosaItakusakiAndChosainInput
     * @return ccdChosaItakusakiAndChosainInput
     */
    @JsonProperty("ccdChosaItakusakiAndChosainInput")
    public IChosaItakusakiAndChosainInputDiv getCcdChosaItakusakiAndChosainInput() {
        return ccdChosaItakusakiAndChosainInput;
    }

    // </editor-fold>
}
