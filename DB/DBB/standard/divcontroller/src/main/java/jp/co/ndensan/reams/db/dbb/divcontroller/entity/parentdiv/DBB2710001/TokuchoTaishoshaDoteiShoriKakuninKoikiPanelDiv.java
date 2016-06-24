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
 * TokuchoTaishoshaDoteiShoriKakuninKoikiPanel のクラスファイル
 *
 * @reamsid_L DBB-1850-010 zhangrui
 */
public class TokuchoTaishoshaDoteiShoriKakuninKoikiPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTokuchoTaishoshaDoteiShoriKakuninKoiki")
    private DataGrid<dgTokuchoTaishoshaDoteiShoriKakuninKoiki_Row> dgTokuchoTaishoshaDoteiShoriKakuninKoiki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgTokuchoTaishoshaDoteiShoriKakuninKoiki
     * @return dgTokuchoTaishoshaDoteiShoriKakuninKoiki
     */
    @JsonProperty("dgTokuchoTaishoshaDoteiShoriKakuninKoiki")
    public DataGrid<dgTokuchoTaishoshaDoteiShoriKakuninKoiki_Row> getDgTokuchoTaishoshaDoteiShoriKakuninKoiki() {
        return dgTokuchoTaishoshaDoteiShoriKakuninKoiki;
    }

    /*
     * setdgTokuchoTaishoshaDoteiShoriKakuninKoiki
     * @param dgTokuchoTaishoshaDoteiShoriKakuninKoiki dgTokuchoTaishoshaDoteiShoriKakuninKoiki
     */
    @JsonProperty("dgTokuchoTaishoshaDoteiShoriKakuninKoiki")
    public void setDgTokuchoTaishoshaDoteiShoriKakuninKoiki(DataGrid<dgTokuchoTaishoshaDoteiShoriKakuninKoiki_Row> dgTokuchoTaishoshaDoteiShoriKakuninKoiki) {
        this.dgTokuchoTaishoshaDoteiShoriKakuninKoiki = dgTokuchoTaishoshaDoteiShoriKakuninKoiki;
    }

    // </editor-fold>
}
