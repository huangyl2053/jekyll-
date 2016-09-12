/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD9010003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdQuestionMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010003.DBD9010003TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010003.IkenshoKakuninshoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD9010003.IkenshoKakuninshoValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.core.iryohikojokakuninsinsei.IryoHiKojoKakuninSinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 主治医意見書確認書
 * @reamsid_L DBD-5790-010 x_zhaowen
 */
public class IkenshoKakuninsho {

    /**
     * 画面初期化処理です。
     *
     * @param div IkenshoKakuninshoDiv
     * @return ResponseData<IkenshoKakuninshoDiv>
     */
    public ResponseData<IkenshoKakuninshoDiv> onLoad(IkenshoKakuninshoDiv div) {
//        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        // TODO テストデータ
        TaishoshaKey taishoshaKey = new TaishoshaKey(
                new HihokenshaNo(new RString("0000000001")),
                new ShikibetsuCode(new RString("000000000000010")),
                new SetaiCode(new RString("000000000000100")));
        if (taishoshaKey.get被保険者番号().isEmpty()) {
            InformationMessage message = new InformationMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode(),
                    DbzInformationMessages.内容変更なしで保存不可.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        RString 被保険者番号 = taishoshaKey.get被保険者番号().value();
        RString メニューID = ResponseHolder.getMenuID();
        ViewStateHolder.put(ViewStateKeys.メニューID, メニューID);
        IryoHiKojoKakuninSinsei iryoHiKojoKakuninSinsei = IryoHiKojoKakuninSinsei.createIntance();
        if (!iryoHiKojoKakuninSinsei.checkuJukyusha(被保険者番号)) {
            throw new ApplicationException(DbdErrorMessages.受給共通_受給者登録なし.getMessage());
        }
        // TODO　「ビジネス設計_DBDBZｘｘｘｘｘｘ_医療費控除確認申請」の「単票用医療費控除取得」未実装より、TODOです。
        List<RString> 医療費控除情報 = new ArrayList<>();
        if (医療費控除情報.size() == 0) {
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace("主治医意見書確認書"));
        }
        ViewStateHolder.put(ViewStateKeys.医療費控除情報, new ArrayList<>(医療費控除情報));
        LockingKey 排他キー = create排他キー();
        if (RealInitialLocker.tryGetLock(排他キー)) {
            throw new PessimisticLockingException();
        }
        RealInitialLocker.lock(排他キー);
        PersonalData personalData = PersonalData.of(taishoshaKey.get識別コード(),
                new ExpandedInformation(new Code("003"), new RString("被保険者番号"), 被保険者番号));
        AccessLogger.log(AccessLogType.照会, personalData);
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医意見書確認書画面にて「再検索する」ボタン押下時(onClick)のイベントハンドラです。
     *
     * @param div IkenshoKakuninshoDiv
     * @return ResponseData<IkenshoKakuninshoDiv>
     */
    public ResponseData<IkenshoKakuninshoDiv> onClick_btnResearch(IkenshoKakuninshoDiv div) {
        RealInitialLocker.release(create排他キー());
        return ResponseData.of(div).forwardWithEventName(DBD9010003TransitionEventName.再検索).respond();
    }

    /**
     * 主治医意見書確認書画面にて発行するボタン押下時(onClick)のチェックです。
     * @param div IkenshoKakuninshoDiv
     * @return ResponseData<IkenshoKakuninshoDiv>
     */
    public ResponseData<IkenshoKakuninshoDiv> onCheck_btnReportPublishi(IkenshoKakuninshoDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidateHandler(div).発行確認チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            if (div.getPanelShosaiEria().getTxtZenkaiHakkouBi().getText().isEmpty()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.確認_汎用.getMessage().
                        replace("「主治医意見書確認書」を発行します。")).respond();       
            } else {
                return ResponseData.of(div).addMessage(DbdQuestionMessages.再発行確認.getMessage().
                        replace("「主治医意見書確認書」")).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).cancelPublish().respond();
        }
        return ResponseData.of(div).respond();
    }

    private LockingKey create排他キー() {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        LockingKey 排他キー = new LockingKey(GyomuCode.DB介護保険.getColumnValue()
                .concat(taishoshaKey.get被保険者番号().getColumnValue()).concat(new RString("IryohiKojyoSyomeisho")));
        return 排他キー;
    }

    private IkenshoKakuninshoValidationHandler getValidateHandler(IkenshoKakuninshoDiv div) {
        return new IkenshoKakuninshoValidationHandler();
    }
}
