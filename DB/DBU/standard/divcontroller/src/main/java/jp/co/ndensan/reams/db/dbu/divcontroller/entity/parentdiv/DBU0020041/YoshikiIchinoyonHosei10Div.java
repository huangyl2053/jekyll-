package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020041;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * YoshikiIchinoyonHosei10 のクラスファイル
 *
 * @reamsid_L DBU-1100-040 yebangqiang
 */
public class YoshikiIchinoyonHosei10Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblYoshikiIchinoyonHosei10")
    private tblYoshikiIchinoyonHosei10Div tblYoshikiIchinoyonHosei10;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblYoshikiIchinoyonHosei10
     * @return tblYoshikiIchinoyonHosei10
     */
    @JsonProperty("tblYoshikiIchinoyonHosei10")
    public tblYoshikiIchinoyonHosei10Div getTblYoshikiIchinoyonHosei10() {
        return tblYoshikiIchinoyonHosei10;
    }

    /*
     * settblYoshikiIchinoyonHosei10
     * @param tblYoshikiIchinoyonHosei10 tblYoshikiIchinoyonHosei10
     */
    @JsonProperty("tblYoshikiIchinoyonHosei10")
    public void setTblYoshikiIchinoyonHosei10(tblYoshikiIchinoyonHosei10Div tblYoshikiIchinoyonHosei10) {
        this.tblYoshikiIchinoyonHosei10 = tblYoshikiIchinoyonHosei10;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblDanichigouHihokensha() {
        return this.getTblYoshikiIchinoyonHosei10().getLblDanichigouHihokensha();
    }

    @JsonIgnore
    public Label getLblDannigouHihokensha() {
        return this.getTblYoshikiIchinoyonHosei10().getLblDannigouHihokensha();
    }

    @JsonIgnore
    public Label getLblGokei() {
        return this.getTblYoshikiIchinoyonHosei10().getLblGokei();
    }

    @JsonIgnore
    public Label getLblDaiyonDankaiShinseiSu() {
        return this.getTblYoshikiIchinoyonHosei10().getLblDaiyonDankaiShinseiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtDanichigouShinseiSu() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtDanichigouShinseiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtDannigouShinseiSu() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtDannigouShinseiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiShinseiSu() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtGokeiShinseiSu();
    }

    @JsonIgnore
    public Label getLblShokujihiGengakuNinteiSu() {
        return this.getTblYoshikiIchinoyonHosei10().getLblShokujihiGengakuNinteiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtDanichigouShokujihiGengakuNinteiSu() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtDanichigouShokujihiGengakuNinteiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtDannigouShokujihiGengakuNinteiSu() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtDannigouShokujihiGengakuNinteiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiShokujihiGengakuNinteiSu() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtGokeiShokujihiGengakuNinteiSu();
    }

    @JsonIgnore
    public Label getLblShokujiGengakuNinteiKei() {
        return this.getTblYoshikiIchinoyonHosei10().getLblShokujiGengakuNinteiKei();
    }

    @JsonIgnore
    public TextBoxNum getTxtDanichigouShokujiGengakuNinteiKei() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtDanichigouShokujiGengakuNinteiKei();
    }

    @JsonIgnore
    public TextBoxNum getTxtDannigouShokujiGengakuNinteiKei() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtDannigouShokujiGengakuNinteiKei();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiShokujiGengakuNinteiKei() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtGokeiShokujiGengakuNinteiKei();
    }

    @JsonIgnore
    public Label getLblKyojuhiGengakuNinteiSu() {
        return this.getTblYoshikiIchinoyonHosei10().getLblKyojuhiGengakuNinteiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtDanichigouKyojuhiGengakuNinteiSu() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtDanichigouKyojuhiGengakuNinteiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtDannigouKyojuhiGengakuNinteiSu() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtDannigouKyojuhiGengakuNinteiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKyojuhiGengakuNinteiSu() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtGokeiKyojuhiGengakuNinteiSu();
    }

    @JsonIgnore
    public Label getLblKyojuhiGengakuNinteiKei() {
        return this.getTblYoshikiIchinoyonHosei10().getLblKyojuhiGengakuNinteiKei();
    }

    @JsonIgnore
    public TextBoxNum getTxtDanichigouKyojuhiGengakuNinteiKei() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtDanichigouKyojuhiGengakuNinteiKei();
    }

    @JsonIgnore
    public TextBoxNum getTxtDannigouKyojuhiGengakuNinteiKei() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtDannigouKyojuhiGengakuNinteiKei();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKyojuhiGengakuNinteiKei() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtGokeiKyojuhiGengakuNinteiKei();
    }

    @JsonIgnore
    public Label getLblSJGengakuNinteiSu() {
        return this.getTblYoshikiIchinoyonHosei10().getLblSJGengakuNinteiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtDanichigouSJGengakuNinteiSu() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtDanichigouSJGengakuNinteiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtDannigouSJGengakuNinteiSu() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtDannigouSJGengakuNinteiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiSJGengakuNinteiSu() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtGokeiSJGengakuNinteiSu();
    }

    @JsonIgnore
    public Label getLblSJGengakuNinteiKei() {
        return this.getTblYoshikiIchinoyonHosei10().getLblSJGengakuNinteiKei();
    }

    @JsonIgnore
    public TextBoxNum getTxtDanichigouSJGengakuNinteiKei() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtDanichigouSJGengakuNinteiKei();
    }

    @JsonIgnore
    public TextBoxNum getTxtDannigouSJGengakuNinteiKei() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtDannigouSJGengakuNinteiKei();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiSJGengakuNinteiKei() {
        return this.getTblYoshikiIchinoyonHosei10().getTxtGokeiSJGengakuNinteiKei();
    }

    // </editor-fold>
}
