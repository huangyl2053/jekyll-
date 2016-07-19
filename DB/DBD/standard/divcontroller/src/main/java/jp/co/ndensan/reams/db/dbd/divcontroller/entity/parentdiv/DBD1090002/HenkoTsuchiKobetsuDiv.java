package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * HenkoTsuchiKobetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class HenkoTsuchiKobetsuDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHenkoTsuchiHakkoYMD")
    private TextBoxFlexibleDate txtHenkoTsuchiHakkoYMD;
    @JsonProperty("ccdBunshoNo")
    private BunshoBangoInputDiv ccdBunshoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHenkoTsuchiHakkoYMD
     * @return txtHenkoTsuchiHakkoYMD
     */
    @JsonProperty("txtHenkoTsuchiHakkoYMD")
    public TextBoxFlexibleDate getTxtHenkoTsuchiHakkoYMD() {
        return txtHenkoTsuchiHakkoYMD;
    }

    /*
     * settxtHenkoTsuchiHakkoYMD
     * @param txtHenkoTsuchiHakkoYMD txtHenkoTsuchiHakkoYMD
     */
    @JsonProperty("txtHenkoTsuchiHakkoYMD")
    public void setTxtHenkoTsuchiHakkoYMD(TextBoxFlexibleDate txtHenkoTsuchiHakkoYMD) {
        this.txtHenkoTsuchiHakkoYMD = txtHenkoTsuchiHakkoYMD;
    }

    /*
     * getccdBunshoNo
     * @return ccdBunshoNo
     */
    @JsonProperty("ccdBunshoNo")
    public IBunshoBangoInputDiv getCcdBunshoNo() {
        return ccdBunshoNo;
    }

    // </editor-fold>
}
