/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.dba2030011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.HihokenshaHakkoDiv;
import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoPrintConfig;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.HihokenshashoPrintType;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.ResponseDatas;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 住所地特例画面における、被保険者証発行Divのイベントを定義したDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaHakko {

    /**
     * 画面が読み込まれた際に実行します。<br/>
     * 業務コンフィグの証表示タイプの情報を元に、印字位置の表示非表示を設定します。
     *
     * @param hakkoDiv {@link ShikakuShosaiDiv 被保険者証発行Div}
     * @return 被保険者証発行Divを持つResponseData
     */
    public ResponseData<HihokenshaHakkoDiv> onload(HihokenshaHakkoDiv hakkoDiv) {
        HihokenshashoPrintConfig config = new HihokenshashoPrintConfig();
        if (config.get証表示タイプ() == HihokenshashoPrintType.A4横) {
            hakkoDiv.getRadPrintPosition().setDisplayNone(true);
        }

        return ResponseDatas.createSettingDataTo(hakkoDiv);
    }

    /**
     * 被保険者証を発行するために必要なソースデータを生成します。
     *
     * @param hakkoDiv {@link ShikakuShosaiDiv 被保険者証発行Div}
     * @return 被保険者証発行Divを持つResponseData
     */
    public ResponseData<HihokenshaHakkoDiv> createSource_btnReportPublish(HihokenshaHakkoDiv hakkoDiv) {
        //TODO n8178 被保険者証発行Businessのブランチをマージ後に修正する。
        return ResponseDatas.createSettingDataTo(hakkoDiv);
    }

    /**
     * 被保険者証を発行した際に行う後処理です。
     *
     * @param hakkoDiv {@link ShikakuShosaiDiv 被保険者証発行Div}
     * @return 被保険者証発行Divを持つResponseData
     */
    public ResponseData<HihokenshaHakkoDiv> afterPrint_btnReportPublish(HihokenshaHakkoDiv hakkoDiv) {
        //TODO n8178 被保険者証発行Businessのブランチをマージ後に修正する。
        //発行した帳票の情報を、交付証回収テーブルに書きこむ処理を行う（証発行テーブルも書きこむ必要があるはずだが、ここはFW側で書き込まれるはずだから実装は不要）
        return ResponseDatas.createSettingDataTo(hakkoDiv);
    }
}
