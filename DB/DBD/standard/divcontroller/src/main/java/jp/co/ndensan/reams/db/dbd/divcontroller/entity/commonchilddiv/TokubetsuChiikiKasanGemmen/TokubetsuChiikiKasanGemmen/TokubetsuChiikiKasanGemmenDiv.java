package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.TokubetsuChiikiKasanGemmen.TokubetsuChiikiKasanGemmen;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * TokubetsuChiikiKasanGemmen のクラスファイル
 *
 * @reamsid_L DBD-3560-070 wangjie2
 */
public class TokubetsuChiikiKasanGemmenDiv extends Panel implements ITokubetsuChiikiKasanGemmenDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTokubetsuChiikiKasanGemmenList")
    private DataGrid<dgTokubetsuChiikiKasanGemmenList_Row> dgTokubetsuChiikiKasanGemmenList;
    @JsonProperty("TokubetsuChiikiKasanGemmenDetail")
    private TokubetsuChiikiKasanGemmenDetailDiv TokubetsuChiikiKasanGemmenDetail;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgTokubetsuChiikiKasanGemmenList
     * @return dgTokubetsuChiikiKasanGemmenList
     */
    @JsonProperty("dgTokubetsuChiikiKasanGemmenList")
    public DataGrid<dgTokubetsuChiikiKasanGemmenList_Row> getDgTokubetsuChiikiKasanGemmenList() {
        return dgTokubetsuChiikiKasanGemmenList;
    }

    /*
     * setdgTokubetsuChiikiKasanGemmenList
     * @param dgTokubetsuChiikiKasanGemmenList dgTokubetsuChiikiKasanGemmenList
     */
    @JsonProperty("dgTokubetsuChiikiKasanGemmenList")
    public void setDgTokubetsuChiikiKasanGemmenList(DataGrid<dgTokubetsuChiikiKasanGemmenList_Row> dgTokubetsuChiikiKasanGemmenList) {
        this.dgTokubetsuChiikiKasanGemmenList = dgTokubetsuChiikiKasanGemmenList;
    }

    /*
     * getTokubetsuChiikiKasanGemmenDetail
     * @return TokubetsuChiikiKasanGemmenDetail
     */
    @JsonProperty("TokubetsuChiikiKasanGemmenDetail")
    public TokubetsuChiikiKasanGemmenDetailDiv getTokubetsuChiikiKasanGemmenDetail() {
        return TokubetsuChiikiKasanGemmenDetail;
    }

    /*
     * setTokubetsuChiikiKasanGemmenDetail
     * @param TokubetsuChiikiKasanGemmenDetail TokubetsuChiikiKasanGemmenDetail
     */
    @JsonProperty("TokubetsuChiikiKasanGemmenDetail")
    public void setTokubetsuChiikiKasanGemmenDetail(TokubetsuChiikiKasanGemmenDetailDiv TokubetsuChiikiKasanGemmenDetail) {
        this.TokubetsuChiikiKasanGemmenDetail = TokubetsuChiikiKasanGemmenDetail;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    /*
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public List<TokubetsuchiikiKasanGemmen> initializa(HihokenshaNo 被保険者番号) {
        return getHandler(this).onLoad(被保険者番号);
    }

    private TokubetsuChiikiKasanGemmenHandler getHandler(TokubetsuChiikiKasanGemmenDiv div) {
        return new TokubetsuChiikiKasanGemmenHandler(div);
    }

}
