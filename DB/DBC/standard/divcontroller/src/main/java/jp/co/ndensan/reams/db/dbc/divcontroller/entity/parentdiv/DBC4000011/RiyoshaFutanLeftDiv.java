package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4000011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RiyoshaFutanLeft のクラスファイル 
 * 
 * @author 自動生成
 */
public class RiyoshaFutanLeftDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("segTeiritsuOrTeigaku")
    private SegmentedControl segTeiritsuOrTeigaku;
    @JsonProperty("txtKyufuritsu")
    private TextBoxNum txtKyufuritsu;
    @JsonProperty("txtRiyoshaFutangaku")
    private TextBoxNum txtRiyoshaFutangaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getsegTeiritsuOrTeigaku
     * @return segTeiritsuOrTeigaku
     */
    @JsonProperty("segTeiritsuOrTeigaku")
    public SegmentedControl getSegTeiritsuOrTeigaku() {
        return segTeiritsuOrTeigaku;
    }

    /*
     * setsegTeiritsuOrTeigaku
     * @param segTeiritsuOrTeigaku segTeiritsuOrTeigaku
     */
    @JsonProperty("segTeiritsuOrTeigaku")
    public void setSegTeiritsuOrTeigaku(SegmentedControl segTeiritsuOrTeigaku) {
        this.segTeiritsuOrTeigaku = segTeiritsuOrTeigaku;
    }

    /*
     * gettxtKyufuritsu
     * @return txtKyufuritsu
     */
    @JsonProperty("txtKyufuritsu")
    public TextBoxNum getTxtKyufuritsu() {
        return txtKyufuritsu;
    }

    /*
     * settxtKyufuritsu
     * @param txtKyufuritsu txtKyufuritsu
     */
    @JsonProperty("txtKyufuritsu")
    public void setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.txtKyufuritsu = txtKyufuritsu;
    }

    /*
     * gettxtRiyoshaFutangaku
     * @return txtRiyoshaFutangaku
     */
    @JsonProperty("txtRiyoshaFutangaku")
    public TextBoxNum getTxtRiyoshaFutangaku() {
        return txtRiyoshaFutangaku;
    }

    /*
     * settxtRiyoshaFutangaku
     * @param txtRiyoshaFutangaku txtRiyoshaFutangaku
     */
    @JsonProperty("txtRiyoshaFutangaku")
    public void setTxtRiyoshaFutangaku(TextBoxNum txtRiyoshaFutangaku) {
        this.txtRiyoshaFutangaku = txtRiyoshaFutangaku;
    }

    // </editor-fold>
}
