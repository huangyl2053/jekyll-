package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuGaikyoChosa のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuGaikyoChosaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radJutakuKaishu")
    private RadioButton radJutakuKaishu;
    @JsonProperty("dgRiyoSerViceFirstHalf")
    private DataGrid<dgRiyoSerViceFirstHalf_Row> dgRiyoSerViceFirstHalf;
    @JsonProperty("dgRiyoSerViceSecondHalf")
    private DataGrid<dgRiyoSerViceSecondHalf_Row> dgRiyoSerViceSecondHalf;
    @JsonProperty("txtShichosonTokubetsuKyufu")
    private TextBox txtShichosonTokubetsuKyufu;
    @JsonProperty("txtKyufuIgaiJutakuService")
    private TextBox txtKyufuIgaiJutakuService;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradJutakuKaishu
     * @return radJutakuKaishu
     */
    @JsonProperty("radJutakuKaishu")
    public RadioButton getRadJutakuKaishu() {
        return radJutakuKaishu;
    }

    /*
     * setradJutakuKaishu
     * @param radJutakuKaishu radJutakuKaishu
     */
    @JsonProperty("radJutakuKaishu")
    public void setRadJutakuKaishu(RadioButton radJutakuKaishu) {
        this.radJutakuKaishu = radJutakuKaishu;
    }

    /*
     * getdgRiyoSerViceFirstHalf
     * @return dgRiyoSerViceFirstHalf
     */
    @JsonProperty("dgRiyoSerViceFirstHalf")
    public DataGrid<dgRiyoSerViceFirstHalf_Row> getDgRiyoSerViceFirstHalf() {
        return dgRiyoSerViceFirstHalf;
    }

    /*
     * setdgRiyoSerViceFirstHalf
     * @param dgRiyoSerViceFirstHalf dgRiyoSerViceFirstHalf
     */
    @JsonProperty("dgRiyoSerViceFirstHalf")
    public void setDgRiyoSerViceFirstHalf(DataGrid<dgRiyoSerViceFirstHalf_Row> dgRiyoSerViceFirstHalf) {
        this.dgRiyoSerViceFirstHalf = dgRiyoSerViceFirstHalf;
    }

    /*
     * getdgRiyoSerViceSecondHalf
     * @return dgRiyoSerViceSecondHalf
     */
    @JsonProperty("dgRiyoSerViceSecondHalf")
    public DataGrid<dgRiyoSerViceSecondHalf_Row> getDgRiyoSerViceSecondHalf() {
        return dgRiyoSerViceSecondHalf;
    }

    /*
     * setdgRiyoSerViceSecondHalf
     * @param dgRiyoSerViceSecondHalf dgRiyoSerViceSecondHalf
     */
    @JsonProperty("dgRiyoSerViceSecondHalf")
    public void setDgRiyoSerViceSecondHalf(DataGrid<dgRiyoSerViceSecondHalf_Row> dgRiyoSerViceSecondHalf) {
        this.dgRiyoSerViceSecondHalf = dgRiyoSerViceSecondHalf;
    }

    /*
     * gettxtShichosonTokubetsuKyufu
     * @return txtShichosonTokubetsuKyufu
     */
    @JsonProperty("txtShichosonTokubetsuKyufu")
    public TextBox getTxtShichosonTokubetsuKyufu() {
        return txtShichosonTokubetsuKyufu;
    }

    /*
     * settxtShichosonTokubetsuKyufu
     * @param txtShichosonTokubetsuKyufu txtShichosonTokubetsuKyufu
     */
    @JsonProperty("txtShichosonTokubetsuKyufu")
    public void setTxtShichosonTokubetsuKyufu(TextBox txtShichosonTokubetsuKyufu) {
        this.txtShichosonTokubetsuKyufu = txtShichosonTokubetsuKyufu;
    }

    /*
     * gettxtKyufuIgaiJutakuService
     * @return txtKyufuIgaiJutakuService
     */
    @JsonProperty("txtKyufuIgaiJutakuService")
    public TextBox getTxtKyufuIgaiJutakuService() {
        return txtKyufuIgaiJutakuService;
    }

    /*
     * settxtKyufuIgaiJutakuService
     * @param txtKyufuIgaiJutakuService txtKyufuIgaiJutakuService
     */
    @JsonProperty("txtKyufuIgaiJutakuService")
    public void setTxtKyufuIgaiJutakuService(TextBox txtKyufuIgaiJutakuService) {
        this.txtKyufuIgaiJutakuService = txtKyufuIgaiJutakuService;
    }

    // </editor-fold>
}
