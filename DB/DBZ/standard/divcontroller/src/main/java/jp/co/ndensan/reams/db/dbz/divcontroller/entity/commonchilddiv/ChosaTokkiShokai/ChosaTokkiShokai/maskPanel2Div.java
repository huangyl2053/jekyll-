package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaTokkiShokai.ChosaTokkiShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * maskPanel2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class maskPanel2Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-15_05-21-09">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("imgMasking2")
    private DynamicImage imgMasking2;
    @JsonProperty("LabelNoImage2")
    private Label LabelNoImage2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getimgMasking2
     * @return imgMasking2
     */
    @JsonProperty("imgMasking2")
    public DynamicImage getImgMasking2() {
        return imgMasking2;
    }

    /*
     * setimgMasking2
     * @param imgMasking2 imgMasking2
     */
    @JsonProperty("imgMasking2")
    public void setImgMasking2(DynamicImage imgMasking2) {
        this.imgMasking2 = imgMasking2;
    }

    /*
     * getLabelNoImage2
     * @return LabelNoImage2
     */
    @JsonProperty("LabelNoImage2")
    public Label getLabelNoImage2() {
        return LabelNoImage2;
    }

    /*
     * setLabelNoImage2
     * @param LabelNoImage2 LabelNoImage2
     */
    @JsonProperty("LabelNoImage2")
    public void setLabelNoImage2(Label LabelNoImage2) {
        this.LabelNoImage2 = LabelNoImage2;
    }

    // </editor-fold>
}
