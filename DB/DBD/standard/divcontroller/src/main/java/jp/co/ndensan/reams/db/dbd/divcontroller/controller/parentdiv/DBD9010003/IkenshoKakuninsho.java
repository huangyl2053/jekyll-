/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD9010003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.IryohiKojo;
import jp.co.ndensan.reams.db.dbd.business.core.basic.IryohiKojoBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.IryohiKojoEntityResult;
import jp.co.ndensan.reams.db.dbd.definition.core.iryohikojo.IryoHiKojoNaiyo;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdQuestionMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010003.DBD9010003StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010003.DBD9010003TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010003.IkenshoKakuninshoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD9010003.IkenshoKakuninshoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD9010003.IkenshoKakuninshoValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.core.basic.IryohiKojoManager;
import jp.co.ndensan.reams.db.dbd.service.core.iryohikojokakuninsinsei.IryoHiKojoKakuninSinsei;
import jp.co.ndensan.reams.db.dbd.service.report.dbd100030.ShujiiIkenshoKakuninshoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 主治医意見書確認書
 *
 * @reamsid_L DBD-5790-010 x_zhaowen
 */
public class IkenshoKakuninsho {

    private static final RString 完了メッセージメイン = new RString("主治医意見書確認書の作成を完了しました。");

    /**
     * 画面初期化処理です。
     *
     * @param div IkenshoKakuninshoDiv
     * @return ResponseData<IkenshoKakuninshoDiv>
     */
    public ResponseData<IkenshoKakuninshoDiv> onLoad(IkenshoKakuninshoDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (!ResponseHolder.isReRequest() && taishoshaKey.get被保険者番号().isEmpty()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("reportPublishi"), true);
            return ResponseData.of(div).addMessage(DbdInformationMessages.被保険者でないデータ.getMessage()).respond();
        }
        if (new RString(DbdInformationMessages.被保険者でないデータ.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        RString 被保険者番号 = taishoshaKey.get被保険者番号().value();
        RString メニューID = ResponseHolder.getMenuID();
        ViewStateHolder.put(ViewStateKeys.メニューID, メニューID);
        IryoHiKojoKakuninSinsei iryoHiKojoKakuninSinsei = IryoHiKojoKakuninSinsei.createIntance();
        if (!iryoHiKojoKakuninSinsei.checkuJukyusha(taishoshaKey.get被保険者番号())) {
            throw new ApplicationException(DbdErrorMessages.受給共通_受給者登録なし.getMessage());
        }
        List<IryohiKojo> 医療費控除情報リスト = iryoHiKojoKakuninSinsei.getIryohikojyo_Chohyo(new HihokenshaNo(被保険者番号),
                IryoHiKojoNaiyo.主治医意見書確認書.getコード());
        if (医療費控除情報リスト.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace("主治医意見書確認書"));
        }
        ViewStateHolder.put(ViewStateKeys.医療費控除情報, new ArrayList<>(医療費控除情報リスト));
        List<KeyValueDataSource> 年度DDLデータ = new ArrayList<>();
        for (IryohiKojo 医療費控除 : 医療費控除情報リスト) {
            KeyValueDataSource data = new KeyValueDataSource();
            RYear 控除対象年 = new RYear(医療費控除.get控除対象年().toDateString());
            data.setKey(控除対象年.toDateString());
            data.setValue(控除対象年.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).toDateString());
            年度DDLデータ.add(data);
        }
        div.getPanelShosaiEria().getDdlTaishonen().setDataSource(年度DDLデータ);
        getHandler(div).initialize(taishoshaKey, 医療費控除情報リスト);
        LockingKey 排他キー = new LockingKey(GyomuCode.DB介護保険.getColumnValue()
                .concat(被保険者番号).concat(new RString("IryohiKojyoSyomeisho")));
//        if (!RealInitialLocker.tryGetLock(排他キー)) {
//            throw new PessimisticLockingException();
//        }
        RealInitialLocker.lock(排他キー);
        AccessLogger.log(AccessLogType.照会, createpersonalData(taishoshaKey));
        return ResponseData.of(div).respond();
    }

    /**
     * 対象年DDLonChange
     *
     * @param div IkenshoKakuninshoDiv
     * @return ResponseData<IkenshoKakuninshoDiv>
     */
    public ResponseData<IkenshoKakuninshoDiv> onChange_ddlTaishonen(IkenshoKakuninshoDiv div) {
        List<IryohiKojoEntityResult> 医療費控除情報リスト = ViewStateHolder.get(ViewStateKeys.医療費控除情報, ArrayList.class);
        getHandler(div).onChange対象年(医療費控除情報リスト);
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医意見書確認書画面にて「再検索する」ボタン押下時(onClick)のイベントハンドラです。
     *
     * @param div IkenshoKakuninshoDiv
     * @return ResponseData<IkenshoKakuninshoDiv>
     */
    public ResponseData<IkenshoKakuninshoDiv> onClick_btnResearch(IkenshoKakuninshoDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        RealInitialLocker.release(create排他キー(taishoshaKey));
        return ResponseData.of(div).forwardWithEventName(DBD9010003TransitionEventName.再検索).respond();
    }

    /**
     * 主治医意見書確認書画面にて「終了するボタン押下時(onClick)のイベントハンドラです。
     *
     * @param div IkenshoKakuninshoDiv
     * @return ResponseData<IkenshoKakuninshoDiv>
     */
    public ResponseData<IkenshoKakuninshoDiv> onClick_btnshuryo(IkenshoKakuninshoDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        RealInitialLocker.release(create排他キー(taishoshaKey));
        return ResponseData.of(div).forwardWithEventName(DBD9010003TransitionEventName.終了).respond();
    }

    /**
     * 主治医意見書確認書画面にて発行するボタン押下時(onClick)のチェックです。
     *
     * @param div IkenshoKakuninshoDiv
     * @return ResponseData<IkenshoKakuninshoDiv>
     */
    public ResponseData<IkenshoKakuninshoDiv> onCheck_btnReportPublish(IkenshoKakuninshoDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidateHandler(div).発行確認チェック(pairs);
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

    /**
     * 主治医意見書確認書画面にて発行するボタン押下時(onClick)のイベントハンドラです。
     *
     * @param div IkenshoKakuninshoDiv
     * @return ResponseData<IkenshoKakuninshoDiv>
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(IkenshoKakuninshoDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShujiiIkenshoKakuninshoPrintService service = new ShujiiIkenshoKakuninshoPrintService();
        SourceDataCollection source = service.printSingle(getHandler(div).create主治医意見書確認書Entity(taishoshaKey));
        AccessLogger.log(AccessLogType.照会, createpersonalData(taishoshaKey));
        List<IryohiKojo> 医療費控除情報リスト = ViewStateHolder.get(ViewStateKeys.医療費控除情報, ArrayList.class);
        for (IryohiKojo result : 医療費控除情報リスト) {
            if (div.getPanelShosaiEria().getDdlTaishonen().getSelectedKey().equals(result.get控除対象年().toDateString())) {
                IryohiKojoManager manager = new IryohiKojoManager();
                IryohiKojoBuilder builder = result.createBuilderForEdit();
                builder.set発行年月日(new FlexibleDate(div.getPanelShosaiEria().getTxtSakuseiBi().getValue().toDateString()));
                builder.set主治医意見書受領年月日(result.toEntity().getShujiiIkenshoJuryoYMD());
                builder.set尿失禁の発生(result.toEntity().getNyoshikkinHassei());
                builder.set日常生活自立度(result.toEntity().getNichijoSeikatsuJiritsudo());
                builder.set申請年月日(result.get申請年月日());
                builder.set登録年月日(result.toEntity().getTorokuYMD());
                builder.set認定有効期間終了年月日(result.get認定有効期間終了年月日());
                builder.set認定有効期間開始年月日(result.get認定有効期間開始年月日());
                manager.save医療費控除(builder.build().unChanged().modifiedModel());
            }
        }
        return ResponseData.of(source).respond();
    }

    /**
     * 発行完了
     *
     * @param div IkenshoKakuninshoDiv
     * @return ResponseData<IkenshoKakuninshoDiv>
     */
    public ResponseData<IkenshoKakuninshoDiv> onClick_completePublish(IkenshoKakuninshoDiv div) {
        div.getCcdKaigoKanryoMessage().setMessage(完了メッセージメイン,
                ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号().value(),
                div.getPanelKakuninsho().getCcdKaigoAtenaInfo().get氏名漢字(), true);
        return ResponseData.of(div).setState(DBD9010003StateName.完了状態);
    }

    private LockingKey create排他キー(TaishoshaKey taishoshaKey) {
        LockingKey 排他キー = new LockingKey(GyomuCode.DB介護保険.getColumnValue()
                .concat(taishoshaKey.get被保険者番号().getColumnValue()).concat(new RString("IryohiKojyoSyomeisho")));
        return 排他キー;
    }

    private IkenshoKakuninshoValidationHandler getValidateHandler(IkenshoKakuninshoDiv div) {
        return new IkenshoKakuninshoValidationHandler(div);
    }

    private IkenshoKakuninshoHandler getHandler(IkenshoKakuninshoDiv div) {
        return new IkenshoKakuninshoHandler(div);
    }

    private PersonalData createpersonalData(TaishoshaKey taishoshaKey) {
        PersonalData personalData = PersonalData.of(taishoshaKey.get識別コード(),
                new ExpandedInformation(new Code("003"), new RString("被保険者番号"), taishoshaKey.get被保険者番号().value()));
        return personalData;
    }
}
