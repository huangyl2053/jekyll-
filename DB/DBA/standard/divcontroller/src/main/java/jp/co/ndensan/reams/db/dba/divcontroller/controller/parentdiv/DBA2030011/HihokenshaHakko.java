/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2030011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2030011.HihokenshaHakkoDiv;
import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoPrintConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configvalues.HihokenshashoPrintType;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.ResponseDatas;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.report.IReportPublishable;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

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
    public ResponseData<HihokenshaHakkoDiv> onActive_HihokenshaHakko(HihokenshaHakkoDiv hakkoDiv) {
        HihokenshashoPrintConfig config = new HihokenshashoPrintConfig();
        if (config.get証表示タイプ() == HihokenshashoPrintType.A4横) {
            hakkoDiv.getRadPrintPosition().setDisplayNone(true);
        }

//        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class);
        //TODO n8187 久保田 画面遷移のためデータ取得処理を一時的にコメントアウト
//        hakkoDiv.getCcdHihokenshaShikakuHakko().load(taishoshaKey.get被保険者番号(), taishoshaKey.get識別コード(), false);
        return ResponseData.of(hakkoDiv).respond();
    }

    /**
     * 被保険者証を発行するために必要なソースデータを生成します。
     *
     * @param hakkoDiv {@link ShikakuShosaiDiv 被保険者証発行Div}
     * @return 被保険者証発行Divを持つResponseData
     */
    public ResponseData<SourceDataCollection> createSource_btnReportPublish(HihokenshaHakkoDiv hakkoDiv) {
        return new HihokenshaShoPublish().publish(hakkoDiv);
    }

    private static final class HihokenshaShoPublish implements IReportPublishable<HihokenshaHakkoDiv> {

        @Override
        public ResponseData<SourceDataCollection> publish(HihokenshaHakkoDiv div) {

//            TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class);
//            HihokenshashoPrintPosition position;
//            if (div.getRadPrintPosition().getSelectedValue().equals(new RString("上段"))) {
//                position = HihokenshashoPrintPosition.上部;
//            } else if (div.getRadPrintPosition().getSelectedValue().equals(new RString("下段"))) {
//                position = HihokenshashoPrintPosition.下部;
//            } else {
//                position = HihokenshashoPrintPosition.指定無し;
//            }

            //TODO n8187 久保田 画面遷移の確認のために対象者キーにダミーデータを設定
//            taishoshaKey = new TaishoshaKey(new HihokenshaNo("1234567890"), ShikibetsuCode.EMPTY, SetaiCode.EMPTY);
            //TODO n8178 城間篤人 帳票に必要なクラスをrealServiceからserviceに移行後にコメントアウト解除
//            HihokenshashoPrinter printer = new HihokenshashoPrinter();
//            SourceDataCollection sdc = printer.print(
//                    taishoshaKey.get被保険者番号(),
//                    div.getCcdHihokenshaShikakuHakko().create証発行情報(),
//                    position);
            return ResponseDatas.newResponseData(null);
        }
    }

    /**
     * 被保険者証を発行した際に行う後処理です。<br/>
     * 証交付・送達テーブルの情報を元に証交付回収テーブルの情報を作成して登録します。
     *
     * @param hakkoDiv {@link ShikakuShosaiDiv 被保険者証発行Div}
     * @return 被保険者証発行Divを持つResponseData
     */
    public ResponseData<HihokenshaHakkoDiv> afterPrint_btnReportPublish(HihokenshaHakkoDiv hakkoDiv) {

        //TODO n8178 城間篤人 生産性評価において対象外であることと、UR側のIShoKofuKaishuDacで、カラム名が不一致のDBをjoinするのに失敗して例外を投げるため、ここでの対応を行わない。
        //joinの修正は朴さんが実装済みだが、開発で使用するrelease-densanにまだ取り込まれていないようである。
//
//        //TODO n8178 被保険者証発行Businessのブランチをマージ後に修正する。
//        //発行した帳票の情報を、交付証回収テーブルに書きこむ処理を行う（証発行テーブルも書きこむ必要があるはずだが、ここはFW側で書き込まれるらしいので実装は不要か？）
//        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class);
//        IShoKofuKaishuManager kofuKaishuManager = ShoKofuKaishuManagerFactory.createInstance();
//        //TODO n8178 城間篤人 URのコードマスタに対応した介護交付証種類のEnumを作成したら、RStringをnewしている箇所を書き換える。
//        IShoKofuKaishuKiroku kofuKaishu = kofuKaishuManager.get直近証交付回収記録(
//                taishoshaKey.get識別コード(), SubGyomuCode.DBA介護資格, new RString("001"));
//        ShoKofuKaishuModel model = new ShoKofuKaishuModel(new UrT0505ShoKofuKaishuEntity());
//
//        //modelに必要な値を詰める作業。。。
//        //
//        kofuKaishuManager.save(model);
        return ResponseData.of(hakkoDiv).respond();
    }
}
