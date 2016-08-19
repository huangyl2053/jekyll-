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
 * YokokuTsuchisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class YokokuTsuchishoDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtYokokuTsuchishoHakkoDate")
    private TextBoxDate txtYokokuTsuchishoHakkoDate;
    @JsonProperty("ccdYokokuTsuchishoBunshoNo")
    private BunshoBangoInputDiv ccdYokokuTsuchishoBunshoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtYokokuTsuchishoHakkoDate
     * @return txtYokokuTsuchishoHakkoDate
     */
    @JsonProperty("txtYokokuTsuchishoHakkoDate")
    public TextBoxDate getTxtYokokuTsuchishoHakkoDate() {
        return txtYokokuTsuchishoHakkoDate;
    }

    /*
     * settxtYokokuTsuchishoHakkoDate
     * @param txtYokokuTsuchishoHakkoDate txtYokokuTsuchishoHakkoDate
     */
    @JsonProperty("txtYokokuTsuchishoHakkoDate")
    public void setTxtYokokuTsuchishoHakkoDate(TextBoxDate txtYokokuTsuchishoHakkoDate) {
        this.txtYokokuTsuchishoHakkoDate = txtYokokuTsuchishoHakkoDate;
    }

    /*
     * getccdYokokuTsuchishoBunshoNo
     * @return ccdYokokuTsuchishoBunshoNo
     */
    @JsonProperty("ccdYokokuTsuchishoBunshoNo")
    public IBunshoBangoInputDiv getCcdYokokuTsuchishoBunshoNo() {
        return ccdYokokuTsuchishoBunshoNo;
    }

    // </editor-fold>
}
