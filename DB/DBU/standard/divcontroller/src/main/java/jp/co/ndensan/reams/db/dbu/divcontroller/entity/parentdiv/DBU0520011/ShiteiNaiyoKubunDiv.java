package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0520011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShiteiNaiyoKubun のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShiteiNaiyoKubunDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShiteiNaiyoKubun")
    private Label lblShiteiNaiyoKubun;
    @JsonProperty("chkShiteiNaiyoKubun")
    private CheckBoxList chkShiteiNaiyoKubun;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblShiteiNaiyoKubun
     * @return lblShiteiNaiyoKubun
     */
    @JsonProperty("lblShiteiNaiyoKubun")
    public Label getLblShiteiNaiyoKubun() {
        return lblShiteiNaiyoKubun;
    }

    /*
     * setlblShiteiNaiyoKubun
     * @param lblShiteiNaiyoKubun lblShiteiNaiyoKubun
     */
    @JsonProperty("lblShiteiNaiyoKubun")
    public void setLblShiteiNaiyoKubun(Label lblShiteiNaiyoKubun) {
        this.lblShiteiNaiyoKubun = lblShiteiNaiyoKubun;
    }

    /*
     * getchkShiteiNaiyoKubun
     * @return chkShiteiNaiyoKubun
     */
    @JsonProperty("chkShiteiNaiyoKubun")
    public CheckBoxList getChkShiteiNaiyoKubun() {
        return chkShiteiNaiyoKubun;
    }

    /*
     * setchkShiteiNaiyoKubun
     * @param chkShiteiNaiyoKubun chkShiteiNaiyoKubun
     */
    @JsonProperty("chkShiteiNaiyoKubun")
    public void setChkShiteiNaiyoKubun(CheckBoxList chkShiteiNaiyoKubun) {
        this.chkShiteiNaiyoKubun = chkShiteiNaiyoKubun;
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
