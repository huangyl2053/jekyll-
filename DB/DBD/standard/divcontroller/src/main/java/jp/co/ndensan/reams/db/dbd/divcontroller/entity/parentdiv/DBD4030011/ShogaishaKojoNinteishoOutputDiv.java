package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4030011;
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
 * ShogaishaKojoNinteishoOutput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShogaishaKojoNinteishoOutputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKofuDay")
    private TextBoxDate txtKofuDay;
    @JsonProperty("CommonChildDiv1")
    private ChohyoShutsuryokujunDiv CommonChildDiv1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKofuDay
     * @return txtKofuDay
     */
    @JsonProperty("txtKofuDay")
    public TextBoxDate getTxtKofuDay() {
        return txtKofuDay;
    }

    /*
     * settxtKofuDay
     * @param txtKofuDay txtKofuDay
     */
    @JsonProperty("txtKofuDay")
    public void setTxtKofuDay(TextBoxDate txtKofuDay) {
        this.txtKofuDay = txtKofuDay;
    }

    /*
     * getCommonChildDiv1
     * @return CommonChildDiv1
     */
    @JsonProperty("CommonChildDiv1")
    public IChohyoShutsuryokujunDiv getCommonChildDiv1() {
        return CommonChildDiv1;
    }

    // </editor-fold>
}
