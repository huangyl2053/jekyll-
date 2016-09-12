package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2010002;
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
 * HenkoTsuchisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class HenkoTsuchishoDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHenkoTsuchishoHakkoDate")
    private TextBoxDate txtHenkoTsuchishoHakkoDate;
    @JsonProperty("ccdHenkoTsuchishoBunshoNo")
    private BunshoBangoInputDiv ccdHenkoTsuchishoBunshoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHenkoTsuchishoHakkoDate
     * @return txtHenkoTsuchishoHakkoDate
     */
    @JsonProperty("txtHenkoTsuchishoHakkoDate")
    public TextBoxDate getTxtHenkoTsuchishoHakkoDate() {
        return txtHenkoTsuchishoHakkoDate;
    }

    /*
     * settxtHenkoTsuchishoHakkoDate
     * @param txtHenkoTsuchishoHakkoDate txtHenkoTsuchishoHakkoDate
     */
    @JsonProperty("txtHenkoTsuchishoHakkoDate")
    public void setTxtHenkoTsuchishoHakkoDate(TextBoxDate txtHenkoTsuchishoHakkoDate) {
        this.txtHenkoTsuchishoHakkoDate = txtHenkoTsuchishoHakkoDate;
    }

    /*
     * getccdHenkoTsuchishoBunshoNo
     * @return ccdHenkoTsuchishoBunshoNo
     */
    @JsonProperty("ccdHenkoTsuchishoBunshoNo")
    public IBunshoBangoInputDiv getCcdHenkoTsuchishoBunshoNo() {
        return ccdHenkoTsuchishoBunshoNo;
    }

    // </editor-fold>
}
