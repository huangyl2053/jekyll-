package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ButtonArea のクラスファイル 
 * 
 * @author 自動生成
 */
public class ButtonAreaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnSearchTaishosha")
    private Button btnSearchTaishosha;
    @JsonProperty("btnDisplayLatestInformation")
    private Button btnDisplayLatestInformation;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnSearchTaishosha
     * @return btnSearchTaishosha
     */
    @JsonProperty("btnSearchTaishosha")
    public Button getBtnSearchTaishosha() {
        return btnSearchTaishosha;
    }

    /*
     * setbtnSearchTaishosha
     * @param btnSearchTaishosha btnSearchTaishosha
     */
    @JsonProperty("btnSearchTaishosha")
    public void setBtnSearchTaishosha(Button btnSearchTaishosha) {
        this.btnSearchTaishosha = btnSearchTaishosha;
    }

    /*
     * getbtnDisplayLatestInformation
     * @return btnDisplayLatestInformation
     */
    @JsonProperty("btnDisplayLatestInformation")
    public Button getBtnDisplayLatestInformation() {
        return btnDisplayLatestInformation;
    }

    /*
     * setbtnDisplayLatestInformation
     * @param btnDisplayLatestInformation btnDisplayLatestInformation
     */
    @JsonProperty("btnDisplayLatestInformation")
    public void setBtnDisplayLatestInformation(Button btnDisplayLatestInformation) {
        this.btnDisplayLatestInformation = btnDisplayLatestInformation;
    }

    // </editor-fold>
}
