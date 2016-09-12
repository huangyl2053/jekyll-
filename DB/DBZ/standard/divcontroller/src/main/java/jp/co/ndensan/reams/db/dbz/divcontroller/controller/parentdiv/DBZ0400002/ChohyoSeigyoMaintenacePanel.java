/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv.DBZ0400002;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyoIdentifier;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0400002.ChohyoSeigyoMaintenaceDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0400002.ChohyoSeigyoMaintenacePanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0400002.DBZ0400002StateName;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0400002.dgCyohyoSeigyo_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZ0400002.ChohyoSeigyoMaintenaceHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZ0400002.ChohyoSeigyoMaintenaceValidationHandler;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 帳票制御メンテナンスです。
 *
 * @reamsid_L DBA-1201-030 yaodongsheng
 */
public class ChohyoSeigyoMaintenacePanel {

    private static final RString バリデーション有り = new RString("1");
    private static final QuestionMessage SYORIMESSAGE = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
            UrQuestionMessages.処理実行の確認.getMessage().evaluate());
    private final ChohyoSeigyoHanyoManager chohyoSeigyoHanyoManager;

    /**
     * コンストラクタです。
     */
    public ChohyoSeigyoMaintenacePanel() {
        this.chohyoSeigyoHanyoManager = InstanceProvider.create(ChohyoSeigyoHanyoManager.class);
    }

    /**
     * 帳票制御メンテナンスの初期化です。
     *
     * @param div ChohyoSeigyoMaintenaceDiv
     * @return ResponseData<ChohyoSeigyoMaintenaceDiv>
     */
    public ResponseData<ChohyoSeigyoMaintenacePanelDiv> onLoad(ChohyoSeigyoMaintenacePanelDiv div) {
        RStringBuilder lockKey = new RStringBuilder();
        RString 帳票分類ID = ViewStateHolder.get(ViewStateKeys.帳票分類ID, RString.class);
        lockKey.append(UrControlDataFactory.createInstance().getMenuID())
                .append(帳票分類ID);
        LockingKey 前排他ロックキー = new LockingKey(lockKey.toString());
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            throw new PessimisticLockingException();
        }
        div.getChohyoSeigyoMaintenace().setDisabled(false);
        RString 帳票名称 = ViewStateHolder.get(ViewStateKeys.帳票分類名称, RString.class);
        div.getLblChohyoName().setText(ViewStateHolder.get(ViewStateKeys.帳票分類名称, RString.class));
        SubGyomuCode subgyomuCode = ControlDataHolder.getExecutionSubGyomuCode();
        div.getCcdKaigoChohyoSeigyoKyotsu().initialize(subgyomuCode, new ReportId(帳票分類ID));
        List<ChohyoSeigyoHanyo> businessList = chohyoSeigyoHanyoManager.get帳票制御汎用(subgyomuCode, new ReportId(帳票分類ID)).records();
        Models<ChohyoSeigyoHanyoIdentifier, ChohyoSeigyoHanyo> chohyoSeigyoHanyo = Models.create(businessList);
        ViewStateHolder.put(ViewStateKeys.帳票制御汎用メンテナンスGrid, chohyoSeigyoHanyo);
        getHandler(div).load(businessList, 帳票名称);
        return ResponseData.of(div).respond();
    }

    /**
     * 「戻る」ボタンを押下。
     *
     * @param div ChohyoSeigyoMaintenaceDiv
     * @return ResponseData<ChohyoSeigyoMaintenaceDiv>
     */
    public ResponseData<ChohyoSeigyoMaintenacePanelDiv> onClick_Modoru(ChohyoSeigyoMaintenacePanelDiv div) {
        RStringBuilder lockKey = new RStringBuilder();
        RString 帳票分類ID = ViewStateHolder.get(ViewStateKeys.帳票分類ID, RString.class);
        lockKey.append(UrControlDataFactory.createInstance().getMenuID())
                .append(帳票分類ID);
        LockingKey 前排他ロックキー = new LockingKey(lockKey.toString());
        RealInitialLocker.release(前排他ロックキー);
        return ResponseData.of(div).respond();
    }

    /**
     * 帳票制御メンテナンスの保存です。
     *
     * @param div ChohyoSeigyoMaintenaceDiv
     * @return ResponseData<ChohyoSeigyoMaintenaceDiv>
     */
    public ResponseData<ChohyoSeigyoMaintenacePanelDiv> onClick_Hozon(ChohyoSeigyoMaintenacePanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(SYORIMESSAGE).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            RString 帳票分類ID = ViewStateHolder.get(ViewStateKeys.帳票分類ID, RString.class);
            SubGyomuCode subgyomuCode = ControlDataHolder.getExecutionSubGyomuCode();
            RString 帳票名 = ViewStateHolder.get(ViewStateKeys.帳票分類名称, RString.class);
            List<dgCyohyoSeigyo_Row> rowList = div.getDgCyohyoSeigyo().getDataSource();
            for (dgCyohyoSeigyo_Row row : rowList) {
                ValidationMessageControlPairs valimessage = validationCheck(row, div);
                if (valimessage.iterator().hasNext()) {
                    return ResponseData.of(div).addValidationMessages(valimessage).respond();
                }
            }
            div.getCcdKaigoChohyoSeigyoKyotsu().save(ControlDataHolder.getExecutionSubGyomuCode(), new ReportId(帳票分類ID));
            Models<ChohyoSeigyoHanyoIdentifier, ChohyoSeigyoHanyo> models
                    = ViewStateHolder.get(ViewStateKeys.帳票制御汎用メンテナンスGrid, Models.class);
            for (dgCyohyoSeigyo_Row row : rowList) {
                ChohyoSeigyoHanyoIdentifier key = new ChohyoSeigyoHanyoIdentifier(subgyomuCode,
                        new ReportId(帳票分類ID), row.getStrKomoku(), new FlexibleYear(row.getStrKanriNendo()));
                ChohyoSeigyoHanyo yoteiJoho = models.get(key);
                ChohyoSeigyoHanyoBuilder builder = yoteiJoho.createBuilderForEdit();
                builder.set設定値(row.getTxtSetteichi().getValue());
                yoteiJoho.toEntity().setState(EntityDataState.Modified);
                chohyoSeigyoHanyoManager.save帳票制御汎用(builder.build());
            }
            RStringBuilder 帳票message = new RStringBuilder();
            帳票message.append("帳票：").append(帳票名);
            div.getKanryoMessage().getCcdKanryoMessage().setSuccessMessage(
                    new RString("帳票制御メンテナンス_保存処理は正常に行われました。"), 帳票message.toRString(), RString.EMPTY);
            return ResponseData.of(div).setState(DBZ0400002StateName.完了メッセージ表示);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 帳票制御メンテナンスの保存です。
     *
     * @param div ChohyoSeigyoMaintenaceDiv
     * @return ResponseData<ChohyoSeigyoMaintenaceDiv>
     */
    public ResponseData<ChohyoSeigyoMaintenaceDiv> onClick_Kanryo(ChohyoSeigyoMaintenaceDiv div) {
        RStringBuilder lockKey = new RStringBuilder();
        RString 帳票分類ID = ViewStateHolder.get(ViewStateKeys.帳票分類ID, RString.class);
        lockKey.append(UrControlDataFactory.createInstance().getMenuID())
                .append(帳票分類ID);
        LockingKey 前排他ロックキー = new LockingKey(lockKey.toString());
        RealInitialLocker.release(前排他ロックキー);
        return ResponseData.of(div).respond();
    }

    private ValidationMessageControlPairs validationCheck(dgCyohyoSeigyo_Row row, ChohyoSeigyoMaintenacePanelDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (バリデーション有り.equals(row.getValidationUmu())) {
            validationMessages = getValidationHandler(div).保存可否Check(row);
        }
        return validationMessages;
    }

    private ChohyoSeigyoMaintenaceHandler getHandler(ChohyoSeigyoMaintenacePanelDiv div) {
        return new ChohyoSeigyoMaintenaceHandler(div);
    }

    private ChohyoSeigyoMaintenaceValidationHandler getValidationHandler(ChohyoSeigyoMaintenacePanelDiv div) {
        return new ChohyoSeigyoMaintenaceValidationHandler(div);
    }
}
