/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0500011;

import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.dgKoufuKaishu_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0500011.DBU0500011StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0500011.ShoKaishuKirokuKanriJohoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0500011.ShoKaishuKirokuKanriJohoHandler;
import jp.co.ndensan.reams.db.dbu.service.core.shokaishukirokukanrijoho.ShoKaishuKirokuKanriJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishuBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishuIdentifier;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 証回収記録管理DivControllerです。
 *
 * @reamsid_L DBU-0160-020 yaodongsheng
 */
public class ShoKaishuKirokuKanriJoho {

    private static final QuestionMessage HOZONMESSAGE = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
            UrQuestionMessages.保存の確認.getMessage().evaluate());
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString POINT = new RString(".");
    private static final LockingKey LOCKINGKEY = new LockingKey(new RString("ShoKaishuKirokuKanri"));
    private final ShoKaishuKirokuKanriJohoManager shoKaishuManager;

    /**
     * コンストラクタです。
     */
    public ShoKaishuKirokuKanriJoho() {
        this.shoKaishuManager = InstanceProvider.create(ShoKaishuKirokuKanriJohoManager.class);
    }

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShoKaishuKirokuKanriJohoDiv>
     */
    public ResponseData<ShoKaishuKirokuKanriJohoDiv> onLoad(ShoKaishuKirokuKanriJohoDiv div) {
        TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        getHandler(div).onLoad(key.get識別コード(), key.get被保険者番号());
        アクセスログ(key.get識別コード());
        if (!RealInitialLocker.tryGetLock(LOCKINGKEY)) {
            div.setReadOnly(true);
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(new ValidationMessageControlPair(TekiyoJogaiTotalErrorMessage.排他_他のユーザが使用中));
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンを押下する。
     *
     * @param div 画面情報
     * @return ResponseData<ShoKaishuKirokuKanriJohoDiv>
     */
    public ResponseData<ShoKaishuKirokuKanriJohoDiv> onClick_Hozon(ShoKaishuKirokuKanriJohoDiv div) {
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            setHozon(div);
            RealInitialLocker.release(LOCKINGKEY);
            div.getKanryoMessage().getCcdKaigoKanryoMessage().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
            アクセスログ(ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード());
            return ResponseData.of(div).setState(DBU0500011StateName.完了状態);
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(HOZONMESSAGE).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンを押下する。
     *
     * @param div 画面情報
     * @return ResponseData<ShoKaishuKirokuKanriJohoDiv>
     */
    public ResponseData<ShoKaishuKirokuKanriJohoDiv> onClick_btnReturn(ShoKaishuKirokuKanriJohoDiv div) {
        RealInitialLocker.release(LOCKINGKEY);
        return ResponseData.of(div).respond();
    }

    /**
     * 「再検索する」ボタンを押下する。
     *
     * @param div 画面情報
     * @return ResponseData<ShoKaishuKirokuKanriJohoDiv>
     */
    public ResponseData<ShoKaishuKirokuKanriJohoDiv> onClick_btnSearch(ShoKaishuKirokuKanriJohoDiv div) {
        RealInitialLocker.release(LOCKINGKEY);
        return ResponseData.of(div).respond();
    }

    /**
     * 「完了する」ボタンを押下する。
     *
     * @param div 画面情報
     * @return ResponseData<ShoKaishuKirokuKanriJohoDiv>
     */
    public ResponseData<ShoKaishuKirokuKanriJohoDiv> onClick_btnComplete(ShoKaishuKirokuKanriJohoDiv div) {
        RealInitialLocker.release(LOCKINGKEY);
        return ResponseData.of(div).respond();
    }

    private void setHozon(ShoKaishuKirokuKanriJohoDiv div) {
        Models<ShoKofuKaishuIdentifier, ShoKofuKaishu> models
                = ViewStateHolder.get(ViewStateKeys.証交付回収情報, Models.class);
        List<dgKoufuKaishu_Row> dgkoufuKaishuList = div.getShoKaishuList().getCcdShokaishuKirokuKanri().get証交付回収情報一覧();
        for (dgKoufuKaishu_Row dgKoufuKaishu : dgkoufuKaishuList) {
            ShoKofuKaishuIdentifier key = new ShoKofuKaishuIdentifier(
                    ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号(),
                    dgKoufuKaishu.getKoufuTypeNo(), Integer.valueOf(dgKoufuKaishu.getRirekiNo().toString()));
            ShoKofuKaishu shoKofuKaishu = models.get(key);
            ShoKofuKaishuBuilder builder = shoKofuKaishu.createBuilderForEdit();
            if (状態_修正.equals(dgKoufuKaishu.getStatus())) {
                builder.set交付年月日(getDate(dgKoufuKaishu.getKoufuDate().getText()));
                builder.set有効期限(getDate(dgKoufuKaishu.getYukoKigen().getText()));
                builder.set交付事由(dgKoufuKaishu.getKoufuJiyuNo());
                builder.set交付理由(dgKoufuKaishu.getKofuRiyu());
                builder.set回収年月日(getDate(dgKoufuKaishu.getKaishuDate().getText()));
                builder.set回収事由(dgKoufuKaishu.getKaishuJiyuNo());
                builder.set回収理由(dgKoufuKaishu.getKaishuRiyu());
                builder.set発行処理日時(YMDHMS.now());
                shoKofuKaishu.toEntity().setState(EntityDataState.Modified);
            } else if (状態_削除.equals(dgKoufuKaishu.getStatus())) {
                builder.set論理削除フラグ(true);
                shoKofuKaishu.toEntity().setState(EntityDataState.Deleted);
            }
            if (状態_修正.equals(dgKoufuKaishu.getStatus()) || 状態_削除.equals(dgKoufuKaishu.getStatus())) {
                shoKaishuManager.updateOrdelete(builder.build());
            }
        }
    }

    private ShoKaishuKirokuKanriJohoHandler getHandler(ShoKaishuKirokuKanriJohoDiv requestDiv) {
        return new ShoKaishuKirokuKanriJohoHandler(requestDiv);
    }

    private void アクセスログ(ShikibetsuCode 識別コード) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード));
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("01"), new RString("有り"), new RString("無し"));
        return PersonalData.of(識別コード, expandedInfo);
    }

    private FlexibleDate getDate(RString date) {
        return new FlexibleDate(new FlexibleDate(date.replace(POINT, RString.EMPTY)).seireki().toDateString().replace(POINT, RString.EMPTY));
    }

    private enum TekiyoJogaiTotalErrorMessage implements IValidationMessage {

        排他_他のユーザが使用中(UrErrorMessages.排他_他のユーザが使用中);
        private final Message message;

        private TekiyoJogaiTotalErrorMessage(IMessageGettable message) {
            this.message = message.getMessage();
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
