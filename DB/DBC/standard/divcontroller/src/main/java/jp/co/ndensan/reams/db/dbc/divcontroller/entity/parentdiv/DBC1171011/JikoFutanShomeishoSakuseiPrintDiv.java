package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1171011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * JikoFutanShomeishoSakuseiPrint のクラスファイル
 *
 * @reamsid_L DBC-2380-010 yuqingzhang
 */
public class JikoFutanShomeishoSakuseiPrintDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHakkoDate")
    private TextBoxFlexibleDate txtHakkoDate;
    @JsonProperty("ccdBunshoBango")
    private BunshoBangoInputDiv ccdBunshoBango;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHakkoDate
     * @return txtHakkoDate
     */
    @JsonProperty("txtHakkoDate")
    public TextBoxFlexibleDate getTxtHakkoDate() {
        return txtHakkoDate;
    }

    /*
     * settxtHakkoDate
     * @param txtHakkoDate txtHakkoDate
     */
    @JsonProperty("txtHakkoDate")
    public void setTxtHakkoDate(TextBoxFlexibleDate txtHakkoDate) {
        this.txtHakkoDate = txtHakkoDate;
    }

    /*
     * getccdBunshoBango
     * @return ccdBunshoBango
     */
    @JsonProperty("ccdBunshoBango")
    public IBunshoBangoInputDiv getCcdBunshoBango() {
        return ccdBunshoBango;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    // </editor-fold>
}
