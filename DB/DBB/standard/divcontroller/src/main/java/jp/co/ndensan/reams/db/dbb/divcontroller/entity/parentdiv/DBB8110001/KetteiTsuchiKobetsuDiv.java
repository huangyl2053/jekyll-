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
 * KetteiTsuchiKobetsu のクラスファイル
 *
 * @reamsid_L DBB-0740-010 wangkanglei
 */
public class KetteiTsuchiKobetsuDiv extends PanelPublish {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKetteiTsuchiHakkoYMD")
    private TextBoxFlexibleDate txtKetteiTsuchiHakkoYMD;
    @JsonProperty("ccdKetteiTsuchiBunshoNo")
    private BunshoBangoInputDiv ccdKetteiTsuchiBunshoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKetteiTsuchiHakkoYMD
     * @return txtKetteiTsuchiHakkoYMD
     */
    @JsonProperty("txtKetteiTsuchiHakkoYMD")
    public TextBoxFlexibleDate getTxtKetteiTsuchiHakkoYMD() {
        return txtKetteiTsuchiHakkoYMD;
    }

    /*
     * settxtKetteiTsuchiHakkoYMD
     * @param txtKetteiTsuchiHakkoYMD txtKetteiTsuchiHakkoYMD
     */
    @JsonProperty("txtKetteiTsuchiHakkoYMD")
    public void setTxtKetteiTsuchiHakkoYMD(TextBoxFlexibleDate txtKetteiTsuchiHakkoYMD) {
        this.txtKetteiTsuchiHakkoYMD = txtKetteiTsuchiHakkoYMD;
    }

    /*
     * getccdKetteiTsuchiBunshoNo
     * @return ccdKetteiTsuchiBunshoNo
     */
    @JsonProperty("ccdKetteiTsuchiBunshoNo")
    public IBunshoBangoInputDiv getCcdKetteiTsuchiBunshoNo() {
        return ccdKetteiTsuchiBunshoNo;
    }

    // </editor-fold>
}
