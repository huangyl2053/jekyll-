package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ZaitakuServicePanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZaitakuServicePanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZaitakuService")
    private TextBoxMultiLine txtZaitakuService;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtZaitakuService
     * @return txtZaitakuService
     */
    @JsonProperty("txtZaitakuService")
    public TextBoxMultiLine getTxtZaitakuService() {
        return txtZaitakuService;
    }

    /*
     * settxtZaitakuService
     * @param txtZaitakuService txtZaitakuService
     */
    @JsonProperty("txtZaitakuService")
    public void setTxtZaitakuService(TextBoxMultiLine txtZaitakuService) {
        this.txtZaitakuService = txtZaitakuService;
    }

    // </editor-fold>
}
