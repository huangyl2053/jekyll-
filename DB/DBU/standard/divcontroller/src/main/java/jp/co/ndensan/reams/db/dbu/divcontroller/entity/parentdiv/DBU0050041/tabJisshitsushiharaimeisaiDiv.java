package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050041;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tabJisshitsushiharaimeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabJisshitsushiharaimeisaiDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplJisshitsushiharai")
    private tplJisshitsushiharaiDiv tplJisshitsushiharai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplJisshitsushiharai
     * @return tplJisshitsushiharai
     */
    @JsonProperty("tplJisshitsushiharai")
    public tplJisshitsushiharaiDiv getTplJisshitsushiharai() {
        return tplJisshitsushiharai;
    }

    /*
     * settplJisshitsushiharai
     * @param tplJisshitsushiharai tplJisshitsushiharai
     */
    @JsonProperty("tplJisshitsushiharai")
    public void setTplJisshitsushiharai(tplJisshitsushiharaiDiv tplJisshitsushiharai) {
        this.tplJisshitsushiharai = tplJisshitsushiharai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblshitsusainyugokei() {
        return this.getTplJisshitsushiharai().getLblshitsusainyugokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsusainyugokei() {
        return this.getTplJisshitsushiharai().getTxtshitsusainyugokei();
    }

    @JsonIgnore
    public Label getLblshitsusaishutsugokei() {
        return this.getTplJisshitsushiharai().getLblshitsusaishutsugokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsusaishutsugokei() {
        return this.getTplJisshitsushiharai().getTxtshitsusaishutsugokei();
    }

    @JsonIgnore
    public Label getLblshitsusainyusaishutsusa() {
        return this.getTplJisshitsushiharai().getLblshitsusainyusaishutsusa();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsusainyusaishutsusa() {
        return this.getTplJisshitsushiharai().getTxtshitsusainyusaishutsusa();
    }

    @JsonIgnore
    public Label getLblshitsuseisangozangaku() {
        return this.getTplJisshitsushiharai().getLblshitsuseisangozangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsuseisangozangaku() {
        return this.getTplJisshitsushiharai().getTxtshitsuseisangozangaku();
    }

    // </editor-fold>
}
