package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1810000;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.printcontentssetting.IPrintContentsSettingDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.printcontentssetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * KashitsukeHenkanTsuchisho のクラスファイル
 *
 * @author 自動生成
 */
public class KashitsukeHenkanTsuchishoDiv extends PanelPublish {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNofuKigen")
    private TextBoxDate txtNofuKigen;
    @JsonProperty("txtShiharaiKigen")
    private TextBoxDate txtShiharaiKigen;
    @JsonProperty("KashitsukeHenkanTsuchishoPrintSetting")
    private PrintContentsSettingDiv KashitsukeHenkanTsuchishoPrintSetting;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtNofuKigen")
    public TextBoxDate getTxtNofuKigen() {
        return txtNofuKigen;
    }

    @JsonProperty("txtNofuKigen")
    public void setTxtNofuKigen(TextBoxDate txtNofuKigen) {
        this.txtNofuKigen = txtNofuKigen;
    }

    @JsonProperty("txtShiharaiKigen")
    public TextBoxDate getTxtShiharaiKigen() {
        return txtShiharaiKigen;
    }

    @JsonProperty("txtShiharaiKigen")
    public void setTxtShiharaiKigen(TextBoxDate txtShiharaiKigen) {
        this.txtShiharaiKigen = txtShiharaiKigen;
    }

    @JsonProperty("KashitsukeHenkanTsuchishoPrintSetting")
    public IPrintContentsSettingDiv getKashitsukeHenkanTsuchishoPrintSetting() {
        return KashitsukeHenkanTsuchishoPrintSetting;
    }

    // </editor-fold>
}
