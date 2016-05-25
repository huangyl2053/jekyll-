/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5170001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.publicationshiryoshinsakai.PublicationShiryoShinsakaiBatchParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5170001.PublicationShiryoShinsakaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5170001.PublicationShiryoShinsakaiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5170001.PublicationShiryoShinsakaiValidationHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 介護認定審査会資料作成のコントローラです。
 *
 * @reamsid_L DBE-0150-010 linghuhang
 */
public class PublicationShiryoShinsakai {

    /**
     * 画面初期化処理です。
     *
     * @param div PublicationShiryoShinsakaiDiv
     * @return ResponseData<PublicationShiryoShinsakaiDiv>
     */
    public ResponseData<PublicationShiryoShinsakaiDiv> onLoad(PublicationShiryoShinsakaiDiv div) {
        RString 審査会一覧_開催番号 = ViewStateHolder.get(ViewStateKeys.審査会一覧_開催番号, RString.class);
        FlexibleDate 開催予定日 = ViewStateHolder.get(ViewStateKeys.介護認定審査会資料作成_開催予定日, FlexibleDate.class);
        RString 審査会会場 = ViewStateHolder.get(ViewStateKeys.介護認定審査会資料作成_審査会会場, RString.class);
        RString 開始予定時間 = ViewStateHolder.get(ViewStateKeys.介護認定審査会資料作成_開始予定時間, RString.class);
        RString 資料作成 = ViewStateHolder.get(ViewStateKeys.介護認定審査会資料作成_資料作成, RString.class);
        RString 合議体番号 = ViewStateHolder.get(ViewStateKeys.介護認定審査会資料作成_合議体番号, RString.class);
        RString 合議体名称 = ViewStateHolder.get(ViewStateKeys.介護認定審査会資料作成_合議体名称, RString.class);
        RString 予定定員 = ViewStateHolder.get(ViewStateKeys.介護認定審査会資料作成_予定定員, RString.class);
        RString 割付人数 = ViewStateHolder.get(ViewStateKeys.介護認定審査会資料作成_割付人数, RString.class);
        FlexibleDate 処理日 = ViewStateHolder.get(ViewStateKeys.介護認定審査会資料作成_処理日, FlexibleDate.class);
        div.getTxtShinsakaiKaisaiNo().setValue(審査会一覧_開催番号);
        div.getTxtShinsakaiYoteiDate().setValue(開催予定日);
        div.getTxtShinsakaiKaijo().setValue(審査会会場);
        div.getTxtShinsakaiKaishiYoteiTime().setValue(RTime.of(開始予定時間));
        div.getTxtShiryoSakusei().setValue(資料作成);
        div.getTxtGogitaiNo().setValue(合議体番号);
        div.getTxtGogitaiName().setValue(合議体名称);
        div.getTxtYoteiTeiin().setValue(new Decimal(予定定員.toString()));
        div.getTxtWariateNinzu().setValue(new Decimal(割付人数.toString()));
        div.getTxtOperationDate().setValue(処理日);
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 作成条件ラジオボタンを変更する場合、表示項目を変更する。
     *
     * @param div PublicationShiryoShinsakaiDiv
     * @return ResponseData<PublicationShiryoShinsakaiDiv>
     */
    public ResponseData<PublicationShiryoShinsakaiDiv> onClick_radSakuseiJoken(PublicationShiryoShinsakaiDiv div) {
        getHandler(div).活性と非活性設定();
        return ResponseData.of(div).respond();
    }

    /**
     * 事務局用印刷帳票チェックボックスを変更する場合、表示項目を変更する。
     *
     * @param div PublicationShiryoShinsakaiDiv
     * @return ResponseData<PublicationShiryoShinsakaiDiv>
     */
    public ResponseData<PublicationShiryoShinsakaiDiv> onClick_chkPrintChoyoJimu(PublicationShiryoShinsakaiDiv div) {
        getHandler(div).onClick_chkPrintChoyoJimu();
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会委員用印刷帳票チェックボックスを変更する場合、表示項目を変更する。
     *
     * @param div PublicationShiryoShinsakaiDiv
     * @return ResponseData<PublicationShiryoShinsakaiDiv>
     */
    public ResponseData<PublicationShiryoShinsakaiDiv> onClick_chkPrintChohyoIin(PublicationShiryoShinsakaiDiv div) {
        getHandler(div).onClick_chkPrintChohyoIin();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」を押下場合、入力チェックを実行します。
     *
     * @param div PublicationShiryoShinsakaiDiv
     * @return ResponseData<PublicationShiryoShinsakaiDiv>
     */
    public ResponseData<PublicationShiryoShinsakaiDiv> onClick_btnCheck(PublicationShiryoShinsakaiDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).発行チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンを押下する場合、バッチ起動する。
     *
     * @param div PublicationShiryoShinsakaiDiv
     * @return ResponseData<PublicationShiryoShinsakaiBatchParameter>
     */
    public ResponseData<PublicationShiryoShinsakaiBatchParameter> onClick_btnExecute(PublicationShiryoShinsakaiDiv div) {
        // TODO QA1221回答まち、
        // DB更新処理を実施する
        // 処理完了のメッセージを表示する
        // 排他制御の解除を行う
        // 画面を再表示する

        return ResponseData.of(getHandler(div).onClick_btnKogakuParamSave()).respond();
    }

    private PublicationShiryoShinsakaiHandler getHandler(PublicationShiryoShinsakaiDiv div) {
        return new PublicationShiryoShinsakaiHandler(div);
    }

    private PublicationShiryoShinsakaiValidationHandler getValidationHandler(PublicationShiryoShinsakaiDiv div) {
        return new PublicationShiryoShinsakaiValidationHandler(div);
    }
}
