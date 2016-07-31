package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA9010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.BanchiInput.BanchiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.BanchiInput.IBanchiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.ChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.IChoikiInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ShichosonInput.IShichosonInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ShichosonInput.ShichosonInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TennyuHoryuTokuteiJusho のクラスファイル 
 * 
 * @author 自動生成
 */
public class TennyuHoryuTokuteiJushoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTennyuHoryuTokuteiJushoHozon")
    private Button btnTennyuHoryuTokuteiJushoHozon;
    @JsonProperty("ddlTennyuHoryuTokuteiJushoIchiran")
    private DataGrid<ddlTennyuHoryuTokuteiJushoIchiran_Row> ddlTennyuHoryuTokuteiJushoIchiran;
    @JsonProperty("TennyuHoryuTokuteiJushoNyuryoku")
    private TennyuHoryuTokuteiJushoNyuryokuDiv TennyuHoryuTokuteiJushoNyuryoku;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTennyuHoryuTokuteiJushoHozon
     * @return btnTennyuHoryuTokuteiJushoHozon
     */
    @JsonProperty("btnTennyuHoryuTokuteiJushoHozon")
    public Button getBtnTennyuHoryuTokuteiJushoHozon() {
        return btnTennyuHoryuTokuteiJushoHozon;
    }

    /*
     * setbtnTennyuHoryuTokuteiJushoHozon
     * @param btnTennyuHoryuTokuteiJushoHozon btnTennyuHoryuTokuteiJushoHozon
     */
    @JsonProperty("btnTennyuHoryuTokuteiJushoHozon")
    public void setBtnTennyuHoryuTokuteiJushoHozon(Button btnTennyuHoryuTokuteiJushoHozon) {
        this.btnTennyuHoryuTokuteiJushoHozon = btnTennyuHoryuTokuteiJushoHozon;
    }

    /*
     * getddlTennyuHoryuTokuteiJushoIchiran
     * @return ddlTennyuHoryuTokuteiJushoIchiran
     */
    @JsonProperty("ddlTennyuHoryuTokuteiJushoIchiran")
    public DataGrid<ddlTennyuHoryuTokuteiJushoIchiran_Row> getDdlTennyuHoryuTokuteiJushoIchiran() {
        return ddlTennyuHoryuTokuteiJushoIchiran;
    }

    /*
     * setddlTennyuHoryuTokuteiJushoIchiran
     * @param ddlTennyuHoryuTokuteiJushoIchiran ddlTennyuHoryuTokuteiJushoIchiran
     */
    @JsonProperty("ddlTennyuHoryuTokuteiJushoIchiran")
    public void setDdlTennyuHoryuTokuteiJushoIchiran(DataGrid<ddlTennyuHoryuTokuteiJushoIchiran_Row> ddlTennyuHoryuTokuteiJushoIchiran) {
        this.ddlTennyuHoryuTokuteiJushoIchiran = ddlTennyuHoryuTokuteiJushoIchiran;
    }

    /*
     * getTennyuHoryuTokuteiJushoNyuryoku
     * @return TennyuHoryuTokuteiJushoNyuryoku
     */
    @JsonProperty("TennyuHoryuTokuteiJushoNyuryoku")
    public TennyuHoryuTokuteiJushoNyuryokuDiv getTennyuHoryuTokuteiJushoNyuryoku() {
        return TennyuHoryuTokuteiJushoNyuryoku;
    }

    /*
     * setTennyuHoryuTokuteiJushoNyuryoku
     * @param TennyuHoryuTokuteiJushoNyuryoku TennyuHoryuTokuteiJushoNyuryoku
     */
    @JsonProperty("TennyuHoryuTokuteiJushoNyuryoku")
    public void setTennyuHoryuTokuteiJushoNyuryoku(TennyuHoryuTokuteiJushoNyuryokuDiv TennyuHoryuTokuteiJushoNyuryoku) {
        this.TennyuHoryuTokuteiJushoNyuryoku = TennyuHoryuTokuteiJushoNyuryoku;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdSisetuInputGuide() {
        return this.getTennyuHoryuTokuteiJushoNyuryoku().getCcdSisetuInputGuide();
    }

    @JsonIgnore
    public IChoikiInputDiv getCcdJushoInputGuide() {
        return this.getTennyuHoryuTokuteiJushoNyuryoku().getCcdJushoInputGuide();
    }

    @JsonIgnore
    public IBanchiInputDiv getCcdBunchiInput() {
        return this.getTennyuHoryuTokuteiJushoNyuryoku().getCcdBunchiInput();
    }

    @JsonIgnore
    public IShichosonInputDiv getCcdShichousonInputGuide() {
        return this.getTennyuHoryuTokuteiJushoNyuryoku().getCcdShichousonInputGuide();
    }

    // </editor-fold>
}
