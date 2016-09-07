package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShutsuryokuJyoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShutsuryokuJyokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJissekiDateRange")
    private TextBoxDateRange txtJissekiDateRange;
    @JsonProperty("txtFurikomiShiteiDay")
    private TextBoxFlexibleDate txtFurikomiShiteiDay;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtJissekiDateRange
     * @return txtJissekiDateRange
     */
    @JsonProperty("txtJissekiDateRange")
    public TextBoxDateRange getTxtJissekiDateRange() {
        return txtJissekiDateRange;
    }

    /*
     * settxtJissekiDateRange
     * @param txtJissekiDateRange txtJissekiDateRange
     */
    @JsonProperty("txtJissekiDateRange")
    public void setTxtJissekiDateRange(TextBoxDateRange txtJissekiDateRange) {
        this.txtJissekiDateRange = txtJissekiDateRange;
    }

    /*
     * gettxtFurikomiShiteiDay
     * @return txtFurikomiShiteiDay
     */
    @JsonProperty("txtFurikomiShiteiDay")
    public TextBoxFlexibleDate getTxtFurikomiShiteiDay() {
        return txtFurikomiShiteiDay;
    }

    /*
     * settxtFurikomiShiteiDay
     * @param txtFurikomiShiteiDay txtFurikomiShiteiDay
     */
    @JsonProperty("txtFurikomiShiteiDay")
    public void setTxtFurikomiShiteiDay(TextBoxFlexibleDate txtFurikomiShiteiDay) {
        this.txtFurikomiShiteiDay = txtFurikomiShiteiDay;
    }

    // </editor-fold>
}
