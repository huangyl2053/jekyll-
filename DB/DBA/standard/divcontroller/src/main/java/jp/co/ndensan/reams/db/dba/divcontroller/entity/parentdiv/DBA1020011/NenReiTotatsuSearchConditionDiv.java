package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.neiReiTotatsuSrchConInfo.INenReiTotatsuSrchConInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.neiReiTotatsuSrchConInfo.NenReiTotatsuSrchConInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NenReiTotatsuSearchCondition のクラスファイル 
 * 
 * @reamsid_L DBA-0330-050 wangkun
 */
public class NenReiTotatsuSearchConditionDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdNenReiTotatsuSearchCondition")
    private NenReiTotatsuSrchConInfoDiv ccdNenReiTotatsuSearchCondition;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdNenReiTotatsuSearchCondition
     * @return ccdNenReiTotatsuSearchCondition
     */
    @JsonProperty("ccdNenReiTotatsuSearchCondition")
    public INenReiTotatsuSrchConInfoDiv getCcdNenReiTotatsuSearchCondition() {
        return ccdNenReiTotatsuSearchCondition;
    }

    // </editor-fold>
}
