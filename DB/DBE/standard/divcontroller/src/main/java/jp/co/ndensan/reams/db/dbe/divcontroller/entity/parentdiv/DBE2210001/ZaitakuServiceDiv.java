package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ZaitakuService のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZaitakuServiceDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblZaitakuService")
    private Label lblZaitakuService;
    @JsonProperty("imgZaitakuService")
    private DynamicImage imgZaitakuService;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblZaitakuService
     * @return lblZaitakuService
     */
    @JsonProperty("lblZaitakuService")
    public Label getLblZaitakuService() {
        return lblZaitakuService;
    }

    /*
     * setlblZaitakuService
     * @param lblZaitakuService lblZaitakuService
     */
    @JsonProperty("lblZaitakuService")
    public void setLblZaitakuService(Label lblZaitakuService) {
        this.lblZaitakuService = lblZaitakuService;
    }

    /*
     * getimgZaitakuService
     * @return imgZaitakuService
     */
    @JsonProperty("imgZaitakuService")
    public DynamicImage getImgZaitakuService() {
        return imgZaitakuService;
    }

    /*
     * setimgZaitakuService
     * @param imgZaitakuService imgZaitakuService
     */
    @JsonProperty("imgZaitakuService")
    public void setImgZaitakuService(DynamicImage imgZaitakuService) {
        this.imgZaitakuService = imgZaitakuService;
    }

    // </editor-fold>
}
