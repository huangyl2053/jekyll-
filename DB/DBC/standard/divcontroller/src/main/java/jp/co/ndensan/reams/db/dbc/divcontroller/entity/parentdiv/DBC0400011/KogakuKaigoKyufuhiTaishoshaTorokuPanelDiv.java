package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0400011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * KogakuKaigoKyufuhiTaishoshaTorokuPanel のクラスファイル
 *
 * @reamsid_L DBC-2010-030 huzongcheng
 */
public class KogakuKaigoKyufuhiTaishoshaTorokuPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsaYM")
    private TextBoxDateRange txtShinsaYM;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinsaYM
     * @return txtShinsaYM
     */
    @JsonProperty("txtShinsaYM")
    public TextBoxDateRange getTxtShinsaYM() {
        return txtShinsaYM;
    }

    /*
     * settxtShinsaYM
     * @param txtShinsaYM txtShinsaYM
     */
    @JsonProperty("txtShinsaYM")
    public void setTxtShinsaYM(TextBoxDateRange txtShinsaYM) {
        this.txtShinsaYM = txtShinsaYM;
    }

    // </editor-fold>
}
