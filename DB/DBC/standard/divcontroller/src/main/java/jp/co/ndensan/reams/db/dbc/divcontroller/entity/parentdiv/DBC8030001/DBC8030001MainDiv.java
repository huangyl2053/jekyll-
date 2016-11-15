package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ux.uxx.divcontroller.entity.commonchilddiv.FurikomiBaitaiSakusei.FurikomiBaitaiSakuseiDiv;
import jp.co.ndensan.reams.ux.uxx.divcontroller.entity.commonchilddiv.FurikomiBaitaiSakusei.IFurikomiBaitaiSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DBC8030001Main のクラスファイル 
 * 
 * @author 自動生成
 */
public class DBC8030001MainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShoriTaisho")
    private TextBox txtShoriTaisho;
    @JsonProperty("ccdFurikomiBaitaiSakusei")
    private FurikomiBaitaiSakuseiDiv ccdFurikomiBaitaiSakusei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShoriTaisho
     * @return txtShoriTaisho
     */
    @JsonProperty("txtShoriTaisho")
    public TextBox getTxtShoriTaisho() {
        return txtShoriTaisho;
    }

    /*
     * settxtShoriTaisho
     * @param txtShoriTaisho txtShoriTaisho
     */
    @JsonProperty("txtShoriTaisho")
    public void setTxtShoriTaisho(TextBox txtShoriTaisho) {
        this.txtShoriTaisho = txtShoriTaisho;
    }

    /*
     * getccdFurikomiBaitaiSakusei
     * @return ccdFurikomiBaitaiSakusei
     */
    @JsonProperty("ccdFurikomiBaitaiSakusei")
    public IFurikomiBaitaiSakuseiDiv getCcdFurikomiBaitaiSakusei() {
        return ccdFurikomiBaitaiSakusei;
    }

    // </editor-fold>
}
