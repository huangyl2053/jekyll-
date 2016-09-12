package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1060001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShafukuKeigen のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShafukuKeigenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShafukuKeigenChushutsuJoken")
    private ShafukuKeigenChushutsuJokenDiv ShafukuKeigenChushutsuJoken;
    @JsonProperty("ShafukuKeigenKakuninSho")
    private ShafukuKeigenKakuninShoDiv ShafukuKeigenKakuninSho;
    @JsonProperty("ShafukuKeigenKetteiTsuchisho")
    private ShafukuKeigenKetteiTsuchishoDiv ShafukuKeigenKetteiTsuchisho;
    @JsonProperty("ShafukuKeigenAtenaSeal")
    private ShafukuKeigenAtenaSealDiv ShafukuKeigenAtenaSeal;
    @JsonProperty("ccdShafukuKeigenShutsuryokuJun")
    private ChohyoShutsuryokujunDiv ccdShafukuKeigenShutsuryokuJun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShafukuKeigenChushutsuJoken
     * @return ShafukuKeigenChushutsuJoken
     */
    @JsonProperty("ShafukuKeigenChushutsuJoken")
    public ShafukuKeigenChushutsuJokenDiv getShafukuKeigenChushutsuJoken() {
        return ShafukuKeigenChushutsuJoken;
    }

    /*
     * setShafukuKeigenChushutsuJoken
     * @param ShafukuKeigenChushutsuJoken ShafukuKeigenChushutsuJoken
     */
    @JsonProperty("ShafukuKeigenChushutsuJoken")
    public void setShafukuKeigenChushutsuJoken(ShafukuKeigenChushutsuJokenDiv ShafukuKeigenChushutsuJoken) {
        this.ShafukuKeigenChushutsuJoken = ShafukuKeigenChushutsuJoken;
    }

    /*
     * getShafukuKeigenKakuninSho
     * @return ShafukuKeigenKakuninSho
     */
    @JsonProperty("ShafukuKeigenKakuninSho")
    public ShafukuKeigenKakuninShoDiv getShafukuKeigenKakuninSho() {
        return ShafukuKeigenKakuninSho;
    }

    /*
     * setShafukuKeigenKakuninSho
     * @param ShafukuKeigenKakuninSho ShafukuKeigenKakuninSho
     */
    @JsonProperty("ShafukuKeigenKakuninSho")
    public void setShafukuKeigenKakuninSho(ShafukuKeigenKakuninShoDiv ShafukuKeigenKakuninSho) {
        this.ShafukuKeigenKakuninSho = ShafukuKeigenKakuninSho;
    }

    /*
     * getShafukuKeigenKetteiTsuchisho
     * @return ShafukuKeigenKetteiTsuchisho
     */
    @JsonProperty("ShafukuKeigenKetteiTsuchisho")
    public ShafukuKeigenKetteiTsuchishoDiv getShafukuKeigenKetteiTsuchisho() {
        return ShafukuKeigenKetteiTsuchisho;
    }

    /*
     * setShafukuKeigenKetteiTsuchisho
     * @param ShafukuKeigenKetteiTsuchisho ShafukuKeigenKetteiTsuchisho
     */
    @JsonProperty("ShafukuKeigenKetteiTsuchisho")
    public void setShafukuKeigenKetteiTsuchisho(ShafukuKeigenKetteiTsuchishoDiv ShafukuKeigenKetteiTsuchisho) {
        this.ShafukuKeigenKetteiTsuchisho = ShafukuKeigenKetteiTsuchisho;
    }

    /*
     * getShafukuKeigenAtenaSeal
     * @return ShafukuKeigenAtenaSeal
     */
    @JsonProperty("ShafukuKeigenAtenaSeal")
    public ShafukuKeigenAtenaSealDiv getShafukuKeigenAtenaSeal() {
        return ShafukuKeigenAtenaSeal;
    }

    /*
     * setShafukuKeigenAtenaSeal
     * @param ShafukuKeigenAtenaSeal ShafukuKeigenAtenaSeal
     */
    @JsonProperty("ShafukuKeigenAtenaSeal")
    public void setShafukuKeigenAtenaSeal(ShafukuKeigenAtenaSealDiv ShafukuKeigenAtenaSeal) {
        this.ShafukuKeigenAtenaSeal = ShafukuKeigenAtenaSeal;
    }

    /*
     * getccdShafukuKeigenShutsuryokuJun
     * @return ccdShafukuKeigenShutsuryokuJun
     */
    @JsonProperty("ccdShafukuKeigenShutsuryokuJun")
    public IChohyoShutsuryokujunDiv getCcdShafukuKeigenShutsuryokuJun() {
        return ccdShafukuKeigenShutsuryokuJun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtShafukuKeigenKakuninShoKofuYmd() {
        return this.getShafukuKeigenKakuninSho().getTxtShafukuKeigenKakuninShoKofuYmd();
    }

    @JsonIgnore
    public void  setTxtShafukuKeigenKakuninShoKofuYmd(TextBoxFlexibleDate txtShafukuKeigenKakuninShoKofuYmd) {
        this.getShafukuKeigenKakuninSho().setTxtShafukuKeigenKakuninShoKofuYmd(txtShafukuKeigenKakuninShoKofuYmd);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdShafukuKeigenKakuninShoBunshoNo() {
        return this.getShafukuKeigenKakuninSho().getCcdShafukuKeigenKakuninShoBunshoNo();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShafukuKeigenKetteiTsuchishoHakkoYmd() {
        return this.getShafukuKeigenKetteiTsuchisho().getTxtShafukuKeigenKetteiTsuchishoHakkoYmd();
    }

    @JsonIgnore
    public void  setTxtShafukuKeigenKetteiTsuchishoHakkoYmd(TextBoxFlexibleDate txtShafukuKeigenKetteiTsuchishoHakkoYmd) {
        this.getShafukuKeigenKetteiTsuchisho().setTxtShafukuKeigenKetteiTsuchishoHakkoYmd(txtShafukuKeigenKetteiTsuchishoHakkoYmd);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdShafukuKeigenKetteiTsuchishoBunshoNo() {
        return this.getShafukuKeigenKetteiTsuchisho().getCcdShafukuKeigenKetteiTsuchishoBunshoNo();
    }

    // </editor-fold>
}
