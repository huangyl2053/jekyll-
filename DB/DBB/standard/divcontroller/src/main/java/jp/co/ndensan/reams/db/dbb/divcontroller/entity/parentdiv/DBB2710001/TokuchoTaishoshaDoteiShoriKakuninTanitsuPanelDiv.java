package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokuchoTaishoshaDoteiShoriKakuninTanitsuPanel のクラスファイル
 *
 * @reamsid_L DBB-1850-010 zhangrui
 */
public class TokuchoTaishoshaDoteiShoriKakuninTanitsuPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTokuchoTaishoshaDoteiShoriKakuninTanitsu")
    private DataGrid<dgTokuchoTaishoshaDoteiShoriKakuninTanitsu_Row> dgTokuchoTaishoshaDoteiShoriKakuninTanitsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgTokuchoTaishoshaDoteiShoriKakuninTanitsu
     * @return dgTokuchoTaishoshaDoteiShoriKakuninTanitsu
     */
    @JsonProperty("dgTokuchoTaishoshaDoteiShoriKakuninTanitsu")
    public DataGrid<dgTokuchoTaishoshaDoteiShoriKakuninTanitsu_Row> getDgTokuchoTaishoshaDoteiShoriKakuninTanitsu() {
        return dgTokuchoTaishoshaDoteiShoriKakuninTanitsu;
    }

    /*
     * setdgTokuchoTaishoshaDoteiShoriKakuninTanitsu
     * @param dgTokuchoTaishoshaDoteiShoriKakuninTanitsu dgTokuchoTaishoshaDoteiShoriKakuninTanitsu
     */
    @JsonProperty("dgTokuchoTaishoshaDoteiShoriKakuninTanitsu")
    public void setDgTokuchoTaishoshaDoteiShoriKakuninTanitsu(DataGrid<dgTokuchoTaishoshaDoteiShoriKakuninTanitsu_Row> dgTokuchoTaishoshaDoteiShoriKakuninTanitsu) {
        this.dgTokuchoTaishoshaDoteiShoriKakuninTanitsu = dgTokuchoTaishoshaDoteiShoriKakuninTanitsu;
    }

    // </editor-fold>
}
