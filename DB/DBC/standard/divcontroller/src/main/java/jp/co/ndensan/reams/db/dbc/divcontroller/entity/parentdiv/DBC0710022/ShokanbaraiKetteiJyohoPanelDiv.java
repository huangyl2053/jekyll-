package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710022;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.IShokanbaraiketteiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShokanbaraiKetteiJyohoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanbaraiKetteiJyohoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdShokanbaraiketteiJoho")
    private ShokanbaraiketteiJohoDiv ccdShokanbaraiketteiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdShokanbaraiketteiJoho
     * @return ccdShokanbaraiketteiJoho
     */
    @JsonProperty("ccdShokanbaraiketteiJoho")
    public IShokanbaraiketteiJohoDiv getCcdShokanbaraiketteiJoho() {
        return ccdShokanbaraiketteiJoho;
    }

    // </editor-fold>
}
