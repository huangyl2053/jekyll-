package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1080002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * GenmenShinseiHaakuShinseisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class GenmenShinseiHaakuShinseishoDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHakkoYMD")
    private TextBoxFlexibleDate txtHakkoYMD;
    @JsonProperty("txtTeishutsuKigen")
    private TextBoxFlexibleDate txtTeishutsuKigen;
    @JsonProperty("chkShinkiKoshin")
    private CheckBoxList chkShinkiKoshin;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHakkoYMD
     * @return txtHakkoYMD
     */
    @JsonProperty("txtHakkoYMD")
    public TextBoxFlexibleDate getTxtHakkoYMD() {
        return txtHakkoYMD;
    }

    /*
     * settxtHakkoYMD
     * @param txtHakkoYMD txtHakkoYMD
     */
    @JsonProperty("txtHakkoYMD")
    public void setTxtHakkoYMD(TextBoxFlexibleDate txtHakkoYMD) {
        this.txtHakkoYMD = txtHakkoYMD;
    }

    /*
     * gettxtTeishutsuKigen
     * @return txtTeishutsuKigen
     */
    @JsonProperty("txtTeishutsuKigen")
    public TextBoxFlexibleDate getTxtTeishutsuKigen() {
        return txtTeishutsuKigen;
    }

    /*
     * settxtTeishutsuKigen
     * @param txtTeishutsuKigen txtTeishutsuKigen
     */
    @JsonProperty("txtTeishutsuKigen")
    public void setTxtTeishutsuKigen(TextBoxFlexibleDate txtTeishutsuKigen) {
        this.txtTeishutsuKigen = txtTeishutsuKigen;
    }

    /*
     * getchkShinkiKoshin
     * @return chkShinkiKoshin
     */
    @JsonProperty("chkShinkiKoshin")
    public CheckBoxList getChkShinkiKoshin() {
        return chkShinkiKoshin;
    }

    /*
     * setchkShinkiKoshin
     * @param chkShinkiKoshin chkShinkiKoshin
     */
    @JsonProperty("chkShinkiKoshin")
    public void setChkShinkiKoshin(CheckBoxList chkShinkiKoshin) {
        this.chkShinkiKoshin = chkShinkiKoshin;
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
