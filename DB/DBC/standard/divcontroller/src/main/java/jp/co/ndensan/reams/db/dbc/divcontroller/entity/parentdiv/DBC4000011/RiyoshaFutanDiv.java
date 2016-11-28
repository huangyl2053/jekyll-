package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4000011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RiyoshaFutan のクラスファイル 
 * 
 * @author 自動生成
 */
public class RiyoshaFutanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RiyoshaFutanLeft")
    private RiyoshaFutanLeftDiv RiyoshaFutanLeft;
    @JsonProperty("RiyoshaFutanRight")
    private RiyoshaFutanRightDiv RiyoshaFutanRight;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getRiyoshaFutanLeft
     * @return RiyoshaFutanLeft
     */
    @JsonProperty("RiyoshaFutanLeft")
    public RiyoshaFutanLeftDiv getRiyoshaFutanLeft() {
        return RiyoshaFutanLeft;
    }

    /*
     * setRiyoshaFutanLeft
     * @param RiyoshaFutanLeft RiyoshaFutanLeft
     */
    @JsonProperty("RiyoshaFutanLeft")
    public void setRiyoshaFutanLeft(RiyoshaFutanLeftDiv RiyoshaFutanLeft) {
        this.RiyoshaFutanLeft = RiyoshaFutanLeft;
    }

    /*
     * getRiyoshaFutanRight
     * @return RiyoshaFutanRight
     */
    @JsonProperty("RiyoshaFutanRight")
    public RiyoshaFutanRightDiv getRiyoshaFutanRight() {
        return RiyoshaFutanRight;
    }

    /*
     * setRiyoshaFutanRight
     * @param RiyoshaFutanRight RiyoshaFutanRight
     */
    @JsonProperty("RiyoshaFutanRight")
    public void setRiyoshaFutanRight(RiyoshaFutanRightDiv RiyoshaFutanRight) {
        this.RiyoshaFutanRight = RiyoshaFutanRight;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public SegmentedControl getSegTeiritsuOrTeigaku() {
        return this.getRiyoshaFutanLeft().getSegTeiritsuOrTeigaku();
    }

    @JsonIgnore
    public void  setSegTeiritsuOrTeigaku(SegmentedControl segTeiritsuOrTeigaku) {
        this.getRiyoshaFutanLeft().setSegTeiritsuOrTeigaku(segTeiritsuOrTeigaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufuritsu() {
        return this.getRiyoshaFutanLeft().getTxtKyufuritsu();
    }

    @JsonIgnore
    public void  setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.getRiyoshaFutanLeft().setTxtKyufuritsu(txtKyufuritsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutangaku() {
        return this.getRiyoshaFutanLeft().getTxtRiyoshaFutangaku();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutangaku(TextBoxNum txtRiyoshaFutangaku) {
        this.getRiyoshaFutanLeft().setTxtRiyoshaFutangaku(txtRiyoshaFutangaku);
    }

    @JsonIgnore
    public DropDownList getDdlTanisuSanteiTaniCode() {
        return this.getRiyoshaFutanRight().getDdlTanisuSanteiTaniCode();
    }

    @JsonIgnore
    public void  setDdlTanisuSanteiTaniCode(DropDownList ddlTanisuSanteiTaniCode) {
        this.getRiyoshaFutanRight().setDdlTanisuSanteiTaniCode(ddlTanisuSanteiTaniCode);
    }

    @JsonIgnore
    public TextBoxNum getTxtSeigenNissuKaisu() {
        return this.getRiyoshaFutanRight().getTxtSeigenNissuKaisu();
    }

    @JsonIgnore
    public void  setTxtSeigenNissuKaisu(TextBoxNum txtSeigenNissuKaisu) {
        this.getRiyoshaFutanRight().setTxtSeigenNissuKaisu(txtSeigenNissuKaisu);
    }

    @JsonIgnore
    public DropDownList getDdlSanteiKaisuSeigenKikanKubun() {
        return this.getRiyoshaFutanRight().getDdlSanteiKaisuSeigenKikanKubun();
    }

    @JsonIgnore
    public void  setDdlSanteiKaisuSeigenKikanKubun(DropDownList ddlSanteiKaisuSeigenKikanKubun) {
        this.getRiyoshaFutanRight().setDdlSanteiKaisuSeigenKikanKubun(ddlSanteiKaisuSeigenKikanKubun);
    }

    // </editor-fold>
}
