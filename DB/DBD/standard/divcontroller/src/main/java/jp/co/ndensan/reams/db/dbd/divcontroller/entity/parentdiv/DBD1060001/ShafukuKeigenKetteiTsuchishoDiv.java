package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1060001;
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
 * ShafukuKeigenKetteiTsuchisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShafukuKeigenKetteiTsuchishoDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShafukuKeigenKetteiTsuchishoHakkoYmd")
    private TextBoxFlexibleDate txtShafukuKeigenKetteiTsuchishoHakkoYmd;
    @JsonProperty("ccdShafukuKeigenKetteiTsuchishoBunshoNo")
    private BunshoBangoInputDiv ccdShafukuKeigenKetteiTsuchishoBunshoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShafukuKeigenKetteiTsuchishoHakkoYmd
     * @return txtShafukuKeigenKetteiTsuchishoHakkoYmd
     */
    @JsonProperty("txtShafukuKeigenKetteiTsuchishoHakkoYmd")
    public TextBoxFlexibleDate getTxtShafukuKeigenKetteiTsuchishoHakkoYmd() {
        return txtShafukuKeigenKetteiTsuchishoHakkoYmd;
    }

    /*
     * settxtShafukuKeigenKetteiTsuchishoHakkoYmd
     * @param txtShafukuKeigenKetteiTsuchishoHakkoYmd txtShafukuKeigenKetteiTsuchishoHakkoYmd
     */
    @JsonProperty("txtShafukuKeigenKetteiTsuchishoHakkoYmd")
    public void setTxtShafukuKeigenKetteiTsuchishoHakkoYmd(TextBoxFlexibleDate txtShafukuKeigenKetteiTsuchishoHakkoYmd) {
        this.txtShafukuKeigenKetteiTsuchishoHakkoYmd = txtShafukuKeigenKetteiTsuchishoHakkoYmd;
    }

    /*
     * getccdShafukuKeigenKetteiTsuchishoBunshoNo
     * @return ccdShafukuKeigenKetteiTsuchishoBunshoNo
     */
    @JsonProperty("ccdShafukuKeigenKetteiTsuchishoBunshoNo")
    public IBunshoBangoInputDiv getCcdShafukuKeigenKetteiTsuchishoBunshoNo() {
        return ccdShafukuKeigenKetteiTsuchishoBunshoNo;
    }

    // </editor-fold>
}
