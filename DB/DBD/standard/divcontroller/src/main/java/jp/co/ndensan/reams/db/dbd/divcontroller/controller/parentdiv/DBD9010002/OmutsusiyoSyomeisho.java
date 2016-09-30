/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD9010002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.IryohiKojoEntityResult;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdQuestionMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010002.DBD9010002StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010002.OmutsusiyoSyomeishoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD9010002.OmutsusiyoSyomeishoHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * おむつ使用証明書画面のDivControllerです。
 *
 * @reamsid_L DBD-5780-010 tz_chengpeng
 */
public class OmutsusiyoSyomeisho {

    private static final RString 医療費控除証明書 = new RString("IryohiKojyoSyomeisho");
    private static final RString DB = new RString("DB");
    private static final RString 完了メッセージメイン = new RString("おむつ使用証明書の作成を完了しました。");

    /**
     * 画面初期化
     *
     * @param div OmutsusiyoSyomeishoDiv
     * @return ResponseData<OmutsusiyoSyomeishoDiv>
     */
    public ResponseData<OmutsusiyoSyomeishoDiv> onLoad(OmutsusiyoSyomeishoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            TaishoshaKey 引き継ぎEntity = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            if (引き継ぎEntity.get被保険者番号() == null || 引き継ぎEntity.get被保険者番号().isEmpty()) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("reportPublishi"), true);
                return ResponseData.of(div).addMessage(DbdInformationMessages.被保険者でないデータ.getMessage()).respond();
            }
            List<IryohiKojoEntityResult> 医療費控除リスト = getHandler(div).onLoad(引き継ぎEntity);
            ViewStateHolder.put(ViewStateKeys.医療費控除情報, new ArrayList(医療費控除リスト));
        }
        return ResponseData.of(div).setState(DBD9010002StateName.初期状態);
    }

    /**
     * 対象年DDLonChange
     *
     * @param div OmutsusiyoSyomeishoDiv
     * @return ResponseData<OmutsusiyoSyomeishoDiv>
     */
    public ResponseData<OmutsusiyoSyomeishoDiv> onChange_ddlTaishonen(OmutsusiyoSyomeishoDiv div) {
        List<IryohiKojoEntityResult> 医療費控除リスト = ViewStateHolder.get(ViewStateKeys.医療費控除情報, ArrayList.class);
        getHandler(div).onChange対象年(医療費控除リスト);
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行」ボタン実行前、確認メッセージの表示
     *
     * @param div OmutsusiyoSyomeishoDiv
     * @return ResponseData<OmutsusiyoSyomeishoDiv>
     */
    public ResponseData<OmutsusiyoSyomeishoDiv> onClick_validate(OmutsusiyoSyomeishoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            RDate 前回発行日 = div.getPanelShosaiEria().getTxtZenkaiHakkouBi().getValue();
            if (前回発行日 == null) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.確認_汎用.getMessage()
                        .replace("「おむつ使用証明書」を発行します。")).respond();
            } else {
                return ResponseData.of(div).addMessage(DbdQuestionMessages.再発行確認.getMessage()
                        .replace("「おむつ使用証明書」")).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).cancelPublish().respond();
    }

    /**
     * 発行処理
     *
     * @param div OmutsusiyoSyomeishoDiv
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(OmutsusiyoSyomeishoDiv div) {
        ResponseData<SourceDataCollection> response = new ResponseData<>();
        List<IryohiKojoEntityResult> 医療費控除リスト = ViewStateHolder.get(ViewStateKeys.医療費控除情報, ArrayList.class);
        response.data = getHandler(div).publishReport(ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class), 医療費控除リスト);
        return response;
    }

    /**
     * 発行完了
     *
     * @param div OmutsusiyoSyomeishoDiv
     * @return ResponseData<OmutsusiyoSyomeishoDiv>
     */
    public ResponseData<OmutsusiyoSyomeishoDiv> onClick_completePublish(OmutsusiyoSyomeishoDiv div) {
        div.getCcdKaigoKanryoMessage().setMessage(完了メッセージメイン,
                ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号().value(),
                div.getPanelKakuninsho().getCcdKaigoAtenaInfo().get氏名漢字(), true);
        return ResponseData.of(div).setState(DBD9010002StateName.完了状態);
    }

    /**
     * 「再検索する」ボタンonClick
     *
     * @param div OmutsusiyoSyomeishoDiv
     * @return ResponseData<OmutsusiyoSyomeishoDiv>
     */
    public ResponseData<OmutsusiyoSyomeishoDiv> onClick_btnReSearch(OmutsusiyoSyomeishoDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        RealInitialLocker.release(new LockingKey(DB.concat(被保険者番号.value()).concat(医療費控除証明書)));
        return ResponseData.of(div).respond();
    }

    private OmutsusiyoSyomeishoHandler getHandler(OmutsusiyoSyomeishoDiv div) {
        return new OmutsusiyoSyomeishoHandler(div);
    }
}
