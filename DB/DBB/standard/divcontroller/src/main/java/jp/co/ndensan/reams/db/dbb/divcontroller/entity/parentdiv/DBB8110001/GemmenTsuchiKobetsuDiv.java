package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * GemmenTsuchiKobetsu のクラスファイル
 *
 * @reamsid_L DBB-0740-010 wangkanglei
 */
public class GemmenTsuchiKobetsuDiv extends PanelPublish {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtGemmenHakkoYMD")
    private TextBoxFlexibleDate txtGemmenHakkoYMD;
    @JsonProperty("ccdGemmenTsuchiBunshoNo")
    private BunshoBangoInputDiv ccdGemmenTsuchiBunshoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtGemmenHakkoYMD
     * @return txtGemmenHakkoYMD
     */
    @JsonProperty("txtGemmenHakkoYMD")
    public TextBoxFlexibleDate getTxtGemmenHakkoYMD() {
        return txtGemmenHakkoYMD;
    }

    /*
     * settxtGemmenHakkoYMD
     * @param txtGemmenHakkoYMD txtGemmenHakkoYMD
     */
    @JsonProperty("txtGemmenHakkoYMD")
    public void setTxtGemmenHakkoYMD(TextBoxFlexibleDate txtGemmenHakkoYMD) {
        this.txtGemmenHakkoYMD = txtGemmenHakkoYMD;
    }

    /*
     * getccdGemmenTsuchiBunshoNo
     * @return ccdGemmenTsuchiBunshoNo
     */
    @JsonProperty("ccdGemmenTsuchiBunshoNo")
    public IBunshoBangoInputDiv getCcdGemmenTsuchiBunshoNo() {
        return ccdGemmenTsuchiBunshoNo;
    }

    // </editor-fold>
}
