package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2030001;
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
 * TainoKeikoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class TainoKeikokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblTainoKeikoku")
    private tblTainoKeikokuDiv tblTainoKeikoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblTainoKeikoku
     * @return tblTainoKeikoku
     */
    @JsonProperty("tblTainoKeikoku")
    public tblTainoKeikokuDiv getTblTainoKeikoku() {
        return tblTainoKeikoku;
    }

    /*
     * settblTainoKeikoku
     * @param tblTainoKeikoku tblTainoKeikoku
     */
    @JsonProperty("tblTainoKeikoku")
    public void setTblTainoKeikoku(tblTainoKeikokuDiv tblTainoKeikoku) {
        this.tblTainoKeikoku = tblTainoKeikoku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblTitle() {
        return this.getTblTainoKeikoku().getLblTitle();
    }

    @JsonIgnore
    public Label getLblKeikokuSetsumei() {
        return this.getTblTainoKeikoku().getLblKeikokuSetsumei();
    }

    @JsonIgnore
    public tblShiharaiHohoDiv getTblShiharaiHoho() {
        return this.getTblTainoKeikoku().getTblShiharaiHoho();
    }

    @JsonIgnore
    public Label getLblShiharaiHohoHenko() {
        return this.getTblTainoKeikoku().getTblShiharaiHoho().getLblShiharaiHohoHenko();
    }

    @JsonIgnore
    public Label getLblShiharaiHohoTainohanteiJoken() {
        return this.getTblTainoKeikoku().getTblShiharaiHoho().getLblShiharaiHohoTainohanteiJoken();
    }

    @JsonIgnore
    public Label getLblShiharaiHohoTainohanteiKekka() {
        return this.getTblTainoKeikoku().getTblShiharaiHoho().getLblShiharaiHohoTainohanteiKekka();
    }

    @JsonIgnore
    public Label getLblShiharaiHohoTainohanteiKijunbiLabel() {
        return this.getTblTainoKeikoku().getTblShiharaiHoho().getLblShiharaiHohoTainohanteiKijunbiLabel();
    }

    @JsonIgnore
    public Label getLblShiharaiHohoTainohanteiKijunbi() {
        return this.getTblTainoKeikoku().getTblShiharaiHoho().getLblShiharaiHohoTainohanteiKijunbi();
    }

    @JsonIgnore
    public Label getLblShiharaiHohoSaikonoTainoNokigenLabel() {
        return this.getTblTainoKeikoku().getTblShiharaiHoho().getLblShiharaiHohoSaikonoTainoNokigenLabel();
    }

    @JsonIgnore
    public Label getLblShiharaiHohoSaikonoTainoNokigen() {
        return this.getTblTainoKeikoku().getTblShiharaiHoho().getLblShiharaiHohoSaikonoTainoNokigen();
    }

    @JsonIgnore
    public Label getLblShiharaiHohoTainohanteiKikanLabel() {
        return this.getTblTainoKeikoku().getTblShiharaiHoho().getLblShiharaiHohoTainohanteiKikanLabel();
    }

    @JsonIgnore
    public Label getLblShiharaiHohoTainohanteiKikan() {
        return this.getTblTainoKeikoku().getTblShiharaiHoho().getLblShiharaiHohoTainohanteiKikan();
    }

    @JsonIgnore
    public Label getLblShiharaiHohoTainoKikanLabel() {
        return this.getTblTainoKeikoku().getTblShiharaiHoho().getLblShiharaiHohoTainoKikanLabel();
    }

    @JsonIgnore
    public Label getLblShiharaiHohoTainoKikan() {
        return this.getTblTainoKeikoku().getTblShiharaiHoho().getLblShiharaiHohoTainoKikan();
    }

    @JsonIgnore
    public Label getLblShiharaiHohoTainoKikanSetsumei() {
        return this.getTblTainoKeikoku().getLblShiharaiHohoTainoKikanSetsumei();
    }

    @JsonIgnore
    public tblKyufugakuGengakuDiv getTblKyufugakuGengaku() {
        return this.getTblTainoKeikoku().getTblKyufugakuGengaku();
    }

    @JsonIgnore
    public Label getLblGengaku() {
        return this.getTblTainoKeikoku().getTblKyufugakuGengaku().getLblGengaku();
    }

    @JsonIgnore
    public Label getLblGengakuTainoHanteiJoken() {
        return this.getTblTainoKeikoku().getTblKyufugakuGengaku().getLblGengakuTainoHanteiJoken();
    }

    @JsonIgnore
    public Label getLblGengakuTainohanteiKijunbiLabel() {
        return this.getTblTainoKeikoku().getTblKyufugakuGengaku().getLblGengakuTainohanteiKijunbiLabel();
    }

    @JsonIgnore
    public Label getLblGengakuTainohanteiKijunbi() {
        return this.getTblTainoKeikoku().getTblKyufugakuGengaku().getLblGengakuTainohanteiKijunbi();
    }

    @JsonIgnore
    public Label getLblGengakuTainoHanteiKekka() {
        return this.getTblTainoKeikoku().getTblKyufugakuGengaku().getLblGengakuTainoHanteiKekka();
    }

    @JsonIgnore
    public tblKyufugakuGengaku2Div getTblKyufugakuGengaku2() {
        return this.getTblTainoKeikoku().getTblKyufugakuGengaku2();
    }

    @JsonIgnore
    public Label getLblGengakuChosukenShometsuLabel() {
        return this.getTblTainoKeikoku().getTblKyufugakuGengaku2().getLblGengakuChosukenShometsuLabel();
    }

    @JsonIgnore
    public Label getLblGengakuChosukenShometsu() {
        return this.getTblTainoKeikoku().getTblKyufugakuGengaku2().getLblGengakuChosukenShometsu();
    }

    @JsonIgnore
    public Label getLblGengakuNofuzumiLabel() {
        return this.getTblTainoKeikoku().getTblKyufugakuGengaku2().getLblGengakuNofuzumiLabel();
    }

    @JsonIgnore
    public Label getLblGengakuNofuzumi() {
        return this.getTblTainoKeikoku().getTblKyufugakuGengaku2().getLblGengakuNofuzumi();
    }

    @JsonIgnore
    public Label getLblGengakuKyufukgakuGengakuLabel() {
        return this.getTblTainoKeikoku().getTblKyufugakuGengaku2().getLblGengakuKyufukgakuGengakuLabel();
    }

    @JsonIgnore
    public Label getLblGengakuNofukgakuGengaku() {
        return this.getTblTainoKeikoku().getTblKyufugakuGengaku2().getLblGengakuNofukgakuGengaku();
    }

    // </editor-fold>
}
