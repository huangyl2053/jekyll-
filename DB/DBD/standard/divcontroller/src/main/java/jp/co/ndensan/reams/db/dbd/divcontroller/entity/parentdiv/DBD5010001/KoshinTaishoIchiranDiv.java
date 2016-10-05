package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.IYokaigoNinteiTaskListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.YokaigoNinteiTaskListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KoshinTaishoIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class KoshinTaishoIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKoshinTaisho")
    private YokaigoNinteiTaskListDiv ccdKoshinTaisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdKoshinTaisho
     * @return ccdKoshinTaisho
     */
    @JsonProperty("ccdKoshinTaisho")
    public IYokaigoNinteiTaskListDiv getCcdKoshinTaisho() {
        return ccdKoshinTaisho;
    }

    // </editor-fold>
}
