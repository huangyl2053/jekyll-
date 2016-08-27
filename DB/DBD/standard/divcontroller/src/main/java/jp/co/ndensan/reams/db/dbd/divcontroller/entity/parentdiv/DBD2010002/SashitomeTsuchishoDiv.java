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
 * SashitomeTsuchisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class SashitomeTsuchishoDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSashitomeTsuchishoHakkoDate")
    private TextBoxDate txtSashitomeTsuchishoHakkoDate;
    @JsonProperty("ccdSashitomeTsuchishoBunshoNo")
    private BunshoBangoInputDiv ccdSashitomeTsuchishoBunshoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSashitomeTsuchishoHakkoDate
     * @return txtSashitomeTsuchishoHakkoDate
     */
    @JsonProperty("txtSashitomeTsuchishoHakkoDate")
    public TextBoxDate getTxtSashitomeTsuchishoHakkoDate() {
        return txtSashitomeTsuchishoHakkoDate;
    }

    /*
     * settxtSashitomeTsuchishoHakkoDate
     * @param txtSashitomeTsuchishoHakkoDate txtSashitomeTsuchishoHakkoDate
     */
    @JsonProperty("txtSashitomeTsuchishoHakkoDate")
    public void setTxtSashitomeTsuchishoHakkoDate(TextBoxDate txtSashitomeTsuchishoHakkoDate) {
        this.txtSashitomeTsuchishoHakkoDate = txtSashitomeTsuchishoHakkoDate;
    }

    /*
     * getccdSashitomeTsuchishoBunshoNo
     * @return ccdSashitomeTsuchishoBunshoNo
     */
    @JsonProperty("ccdSashitomeTsuchishoBunshoNo")
    public IBunshoBangoInputDiv getCcdSashitomeTsuchishoBunshoNo() {
        return ccdSashitomeTsuchishoBunshoNo;
    }

    // </editor-fold>
}
