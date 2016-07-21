package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShutsuryokuTaishoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShutsuryokuTaishoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkShutsuryokuTaisho")
    private CheckBoxList chkShutsuryokuTaisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkShutsuryokuTaisho
     * @return chkShutsuryokuTaisho
     */
    @JsonProperty("chkShutsuryokuTaisho")
    public CheckBoxList getChkShutsuryokuTaisho() {
        return chkShutsuryokuTaisho;
    }

    /*
     * setchkShutsuryokuTaisho
     * @param chkShutsuryokuTaisho chkShutsuryokuTaisho
     */
    @JsonProperty("chkShutsuryokuTaisho")
    public void setChkShutsuryokuTaisho(CheckBoxList chkShutsuryokuTaisho) {
        this.chkShutsuryokuTaisho = chkShutsuryokuTaisho;
    }

    // </editor-fold>
}
