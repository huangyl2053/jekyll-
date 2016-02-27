package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020061;
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
 * DaiichigohiHokenshazogenUchiWake のクラスファイル 
 * 
 * @author 自動生成
 */
public class DaiichigohiHokenshazogenUchiWakeDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblSetaiSu")
    private tblSetaiSuDiv tblSetaiSu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblSetaiSu
     * @return tblSetaiSu
     */
    @JsonProperty("tblSetaiSu")
    public tblSetaiSuDiv getTblSetaiSu() {
        return tblSetaiSu;
    }

    /*
     * settblSetaiSu
     * @param tblSetaiSu tblSetaiSu
     */
    @JsonProperty("tblSetaiSu")
    public void setTblSetaiSu(tblSetaiSuDiv tblSetaiSu) {
        this.tblSetaiSu = tblSetaiSu;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblTonenZoTennyu() {
        return this.getTblSetaiSu().getLblTonenZoTennyu();
    }

    @JsonIgnore
    public Label getLblTonenZoShokkenfukkatsu() {
        return this.getTblSetaiSu().getLblTonenZoShokkenfukkatsu();
    }

    @JsonIgnore
    public Label getLblTonenZorokugosaitotatsu() {
        return this.getTblSetaiSu().getLblTonenZorokugosaitotatsu();
    }

    @JsonIgnore
    public Label getLblTonenZoTekiyojogaihi() {
        return this.getTblSetaiSu().getLblTonenZoTekiyojogaihi();
    }

    @JsonIgnore
    public Label getLblKei() {
        return this.getTblSetaiSu().getLblKei();
    }

    @JsonIgnore
    public TextBoxNum getTxtTonenZoTennyu() {
        return this.getTblSetaiSu().getTxtTonenZoTennyu();
    }

    @JsonIgnore
    public TextBoxNum getTxtTonenZoShokkenfukkatsu() {
        return this.getTblSetaiSu().getTxtTonenZoShokkenfukkatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtTonenZorokugosaitotatsu() {
        return this.getTblSetaiSu().getTxtTonenZorokugosaitotatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtTonenZoTekiyojogaihi() {
        return this.getTblSetaiSu().getTxtTonenZoTekiyojogaihi();
    }

    // </editor-fold>
}
