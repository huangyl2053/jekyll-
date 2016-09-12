package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ShakaiFukushiHojinKeigen.ShakaiFukushiHojinKeigen;
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
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * ShakaiFukushiHojinKeigen のクラスファイル
 *
 * @reamsid_L DBD-3560-050 wangjie2
 */
public class ShakaiFukushiHojinKeigenDiv extends Panel implements IShakaiFukushiHojinKeigenDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShakaiFukushiHojinKeigenList")
    private DataGrid<dgShakaiFukushiHojinKeigenList_Row> dgShakaiFukushiHojinKeigenList;
    @JsonProperty("ShakaiFukushiHojinKeigenDetail")
    private ShakaiFukushiHojinKeigenDetailDiv ShakaiFukushiHojinKeigenDetail;
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
     * getdgShakaiFukushiHojinKeigenList
     * @return dgShakaiFukushiHojinKeigenList
     */
    @JsonProperty("dgShakaiFukushiHojinKeigenList")
    public DataGrid<dgShakaiFukushiHojinKeigenList_Row> getDgShakaiFukushiHojinKeigenList() {
        return dgShakaiFukushiHojinKeigenList;
    }

    /*
     * setdgShakaiFukushiHojinKeigenList
     * @param dgShakaiFukushiHojinKeigenList dgShakaiFukushiHojinKeigenList
     */
    @JsonProperty("dgShakaiFukushiHojinKeigenList")
    public void setDgShakaiFukushiHojinKeigenList(DataGrid<dgShakaiFukushiHojinKeigenList_Row> dgShakaiFukushiHojinKeigenList) {
        this.dgShakaiFukushiHojinKeigenList = dgShakaiFukushiHojinKeigenList;
    }

    /*
     * getShakaiFukushiHojinKeigenDetail
     * @return ShakaiFukushiHojinKeigenDetail
     */
    @JsonProperty("ShakaiFukushiHojinKeigenDetail")
    public ShakaiFukushiHojinKeigenDetailDiv getShakaiFukushiHojinKeigenDetail() {
        return ShakaiFukushiHojinKeigenDetail;
    }

    /*
     * setShakaiFukushiHojinKeigenDetail
     * @param ShakaiFukushiHojinKeigenDetail ShakaiFukushiHojinKeigenDetail
     */
    @JsonProperty("ShakaiFukushiHojinKeigenDetail")
    public void setShakaiFukushiHojinKeigenDetail(ShakaiFukushiHojinKeigenDetailDiv ShakaiFukushiHojinKeigenDetail) {
        this.ShakaiFukushiHojinKeigenDetail = ShakaiFukushiHojinKeigenDetail;
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
    public List<ShakaifukuRiyoshaFutanKeigen> initializa(HihokenshaNo 被保険者番号) {
        return getHandler(this).onLoad(被保険者番号);
    }

    private ShakaiFukushiHojinKeigenHandler getHandler(ShakaiFukushiHojinKeigenDiv div) {
        return new ShakaiFukushiHojinKeigenHandler(div);
    }

}
