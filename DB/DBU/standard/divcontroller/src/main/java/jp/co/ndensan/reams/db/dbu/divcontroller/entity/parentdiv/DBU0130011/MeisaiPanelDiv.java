package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0130011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MeisaiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class MeisaiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRokenJukyushaNo")
    private TextBoxCode txtRokenJukyushaNo;
    @JsonProperty("txtRoukenShichosonNo")
    private TextBox txtRoukenShichosonNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtRokenJukyushaNo
     * @return txtRokenJukyushaNo
     */
    @JsonProperty("txtRokenJukyushaNo")
    public TextBoxCode getTxtRokenJukyushaNo() {
        return txtRokenJukyushaNo;
    }

    /*
     * settxtRokenJukyushaNo
     * @param txtRokenJukyushaNo txtRokenJukyushaNo
     */
    @JsonProperty("txtRokenJukyushaNo")
    public void setTxtRokenJukyushaNo(TextBoxCode txtRokenJukyushaNo) {
        this.txtRokenJukyushaNo = txtRokenJukyushaNo;
    }

    /*
     * gettxtRoukenShichosonNo
     * @return txtRoukenShichosonNo
     */
    @JsonProperty("txtRoukenShichosonNo")
    public TextBox getTxtRoukenShichosonNo() {
        return txtRoukenShichosonNo;
    }

    /*
     * settxtRoukenShichosonNo
     * @param txtRoukenShichosonNo txtRoukenShichosonNo
     */
    @JsonProperty("txtRoukenShichosonNo")
    public void setTxtRoukenShichosonNo(TextBox txtRoukenShichosonNo) {
        this.txtRoukenShichosonNo = txtRoukenShichosonNo;
    }

    // </editor-fold>
}
