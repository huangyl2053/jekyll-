package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2230001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HakkoJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class HakkoJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radChohyoSentaku")
    private RadioButton radChohyoSentaku;
    @JsonProperty("txtKijunDay")
    private TextBoxFlexibleDate txtKijunDay;
    @JsonProperty("ccdHokensha")
    private HokenshaListDiv ccdHokensha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradChohyoSentaku
     * @return radChohyoSentaku
     */
    @JsonProperty("radChohyoSentaku")
    public RadioButton getRadChohyoSentaku() {
        return radChohyoSentaku;
    }

    /*
     * setradChohyoSentaku
     * @param radChohyoSentaku radChohyoSentaku
     */
    @JsonProperty("radChohyoSentaku")
    public void setRadChohyoSentaku(RadioButton radChohyoSentaku) {
        this.radChohyoSentaku = radChohyoSentaku;
    }

    /*
     * gettxtKijunDay
     * @return txtKijunDay
     */
    @JsonProperty("txtKijunDay")
    public TextBoxFlexibleDate getTxtKijunDay() {
        return txtKijunDay;
    }

    /*
     * settxtKijunDay
     * @param txtKijunDay txtKijunDay
     */
    @JsonProperty("txtKijunDay")
    public void setTxtKijunDay(TextBoxFlexibleDate txtKijunDay) {
        this.txtKijunDay = txtKijunDay;
    }

    /*
     * getccdHokensha
     * @return ccdHokensha
     */
    @JsonProperty("ccdHokensha")
    public IHokenshaListDiv getCcdHokensha() {
        return ccdHokensha;
    }

    // </editor-fold>
}
