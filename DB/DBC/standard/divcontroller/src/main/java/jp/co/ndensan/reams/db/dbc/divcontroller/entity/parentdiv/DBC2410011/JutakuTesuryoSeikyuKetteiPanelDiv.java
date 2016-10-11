package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011;
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
 * JutakuTesuryoSeikyuKetteiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuTesuryoSeikyuKetteiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblSeikyuKettei")
    private tblSeikyuKetteiDiv tblSeikyuKettei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblSeikyuKettei
     * @return tblSeikyuKettei
     */
    @JsonProperty("tblSeikyuKettei")
    public tblSeikyuKetteiDiv getTblSeikyuKettei() {
        return tblSeikyuKettei;
    }

    /*
     * settblSeikyuKettei
     * @param tblSeikyuKettei tblSeikyuKettei
     */
    @JsonProperty("tblSeikyuKettei")
    public void setTblSeikyuKettei(tblSeikyuKetteiDiv tblSeikyuKettei) {
        this.tblSeikyuKettei = tblSeikyuKettei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtKetteiYMD() {
        return this.getTblSeikyuKettei().getTxtKetteiYMD();
    }

    @JsonIgnore
    public RadioButton getRadShikyuFushikyuKubun() {
        return this.getTblSeikyuKettei().getRadShikyuFushikyuKubun();
    }

    @JsonIgnore
    public TextBoxDate getTxtTesuryoShiharaiYoteiYMD() {
        return this.getTblSeikyuKettei().getTxtTesuryoShiharaiYoteiYMD();
    }

    @JsonIgnore
    public Space getSpaSeikyuKettei() {
        return this.getTblSeikyuKettei().getSpaSeikyuKettei();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFushikyuRiyu() {
        return this.getTblSeikyuKettei().getTxtFushikyuRiyu();
    }

    // </editor-fold>
}
