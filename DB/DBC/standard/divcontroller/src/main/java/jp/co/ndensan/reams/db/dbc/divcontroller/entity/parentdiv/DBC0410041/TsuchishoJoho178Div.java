package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410041;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KaigoKyufuKokuhorenJohoTorikomi.IKaigoKyufuKokuhorenJohoTorikomiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KaigoKyufuKokuhorenJohoTorikomi.KaigoKyufuKokuhorenJohoTorikomiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * TsuchishoJoho178 のクラスファイル 
 * 
 * @author 自動生成
 */
public class TsuchishoJoho178Div extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKokurenJohoTorikomi")
    private KaigoKyufuKokuhorenJohoTorikomiDiv ccdKokurenJohoTorikomi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdKokurenJohoTorikomi
     * @return ccdKokurenJohoTorikomi
     */
    @JsonProperty("ccdKokurenJohoTorikomi")
    public IKaigoKyufuKokuhorenJohoTorikomiDiv getCcdKokurenJohoTorikomi() {
        return ccdKokurenJohoTorikomi;
    }

    // </editor-fold>
}
