/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB6110001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.RentaiGimusha;
import jp.co.ndensan.reams.db.dbb.business.core.basic.RentaiGimushaHolder;
import jp.co.ndensan.reams.db.dbb.business.core.basic.RentaiGimushaIdentifier;
import jp.co.ndensan.reams.db.dbb.business.core.rentainofugimusha.AtenaJouhou;
import jp.co.ndensan.reams.db.dbb.business.core.rentainofugimusha.RentaiGimushaAtenaJouhou;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB6110001.DBB6110001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB6110001.DBB6110001TransitionEventName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB6110001.KaigoHihokenshaInfoPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB6110001.dgRentaiNofuGimushaIchiran_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB6110001.dgSetaiIchiran_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB6110001.KaigoHihokenshaInfoPanelHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB6110001.KaigoHihokenshaInfoValidationHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB6110001.QuestionMessage;
import jp.co.ndensan.reams.db.dbb.service.core.kaigohihokenshainfo.KaigoHihokenshaInfoPanelManger;
import jp.co.ndensan.reams.db.dbb.service.core.rentainofugimusha.RentaiNofuGimusha;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 連帯納付義務者登録です。
 *
 * @reamsid_L DBB-1640-010 jiangzongyue
 */
public class KaigoHihokenshaInfoPanel {

    private static final RString DBBHIHOKENSHANO = new RString("DBBHihokenshaNo");
    private static final RString CODE_003 = new RString("003");
    private static final RString 名称_被保険者番号 = new RString("被保険者番号");
    private static final RString ONE = new RString("1");
    private static final RString MESSAGETAISHO = new RString("更新は正常に終了しました。");
    private static final RString 終了年月日NULL = new RString("99991231");
    private static final RString 外国人 = new RString("外国人");
    private static final RString 住登外日本人 = new RString("住登外（日本人）");
    private static final RString 住登外外国人 = new RString("住登外（外国人）");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div KaigoHihokenshaInfoDiv
     * @return ResponseData
     */
    public ResponseData<KaigoHihokenshaInfoPanelDiv> onLoad(KaigoHihokenshaInfoPanelDiv div) {
        FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
        if (taishoshaKey != null) {
            KaigoHihokenshaInfoPanelHandler handler = getHandler(div);
            handler.initializeDisplay(taishoshaKey);
            handler.initialDisable(true);
            handler.printLog識別コード照会(taishoshaKey.get識別コード(), taishoshaKey.get被保険者番号().getColumnValue());
            RString 前排他キー = DBBHIHOKENSHANO.concat(taishoshaKey.get被保険者番号().getColumnValue());
            LockingKey key = new LockingKey(前排他キー);
            if (!RealInitialLocker.tryGetLock(key)) {
                throw new PessimisticLockingException();
            }
            handler.initialDisable(false);
            RentaiNofuGimusha rentaiNofuGimusha = RentaiNofuGimusha.createInstance();
            List<RentaiGimusha> list = rentaiNofuGimusha.getRentaiNofuGimushaInfo(taishoshaKey.get被保険者番号());
            ViewStateHolder.put(ViewStateKeys.連帯納付義務者情報, new RentaiGimushaHolder(list));
            ViewStateHolder.put(ViewStateKeys.連帯納付義務者情報初期, new RentaiGimushaHolder(list));
            if (list.isEmpty()) {
                List<AtenaJouhou> atenaList = rentaiNofuGimusha.getLastSetaiIchiran(taishoshaKey.get世帯コード());
                handler.setDgSetaiIchiran(atenaList, taishoshaKey.get被保険者番号());
                div.setHdnFlag(ONE);
                return ResponseData.of(div).setState(DBB6110001StateName.連帯納付義務者新規);
            } else {
                List<RentaiGimushaAtenaJouhou> rentaiList = rentaiNofuGimusha.getRentaiNofuGimushaAtenaInfo(list);
                handler.setDgRentaiNofuGimushaIchiran(rentaiList, taishoshaKey.get被保険者番号());
                return ResponseData.of(div).setState(DBB6110001StateName.連帯納付義務者情報一覧);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * Dgdの直近世帯一覧行選択ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KaigoHihokenshaInfoPanelDiv> onSelect_Select(
            KaigoHihokenshaInfoPanelDiv div) {
        KaigoHihokenshaInfoPanelHandler handler = getHandler(div);
        dgSetaiIchiran_Row row = div.getDgSetaiIchiran().getClickedItem();
        handler.setRentaiNofuGimushaInfo(row);
        return ResponseData.of(div).setState(DBB6110001StateName.連帯納付義務者修正);
    }

    /**
     * 「登録情報を取消する」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KaigoHihokenshaInfoPanelDiv> onClick_Cancelled(
            KaigoHihokenshaInfoPanelDiv div) {
        div.setHdnFlag(RString.EMPTY);
        return ResponseData.of(div).setState(DBB6110001StateName.連帯納付義務者情報一覧);
    }

    /**
     * 「連帯納付義務者を確定する」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KaigoHihokenshaInfoPanelDiv> onClick_Certained(
            KaigoHihokenshaInfoPanelDiv div) {
        KaigoHihokenshaInfoPanelHandler handler = getHandler(div);
        KaigoHihokenshaInfoValidationHandler validationHander = getValidationHandler(div);
        ValidationMessageControlPairs pairs = validationHander.validate();
        if (pairs.iterator().hasNext() && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
        RString 住民種別 = div.getRentaiNofuGimushaInfo().getTxtJuminShu().getValue();
        if (!taishoshaKey.get世帯コード().equals(div.getRentaiNofuGimushaInfo().getTxtSetaiCode().getDomain())
                && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(QuestionMessage.同一世帯コード.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No
                && new RString(QuestionMessage.同一世帯コード.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        if ((住民種別.isNull() || 住民種別.isEmpty()
                || 住民種別.equals(外国人) || 住民種別.equals(住登外日本人)
                || 住民種別.equals(住登外外国人)) && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(QuestionMessage.連帯納付義務者の住民種別.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No
                && new RString(QuestionMessage.連帯納付義務者の住民種別.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        KaigoHihokenshaInfoPanelManger manager = InstanceProvider.create(KaigoHihokenshaInfoPanelManger.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        RDate 開始年月日 = div.getRentaiNofuGimushaInfo().getTxtKaishiYMD().getValue();
        RDate 終了年月日 = div.getRentaiNofuGimushaInfo().getTxtShuryoYMD().getValue();
        ShikibetsuCode 識別コード = div.getRentaiNofuGimushaInfo().getTxtShikibetsuCode().getDomain();
        RString 履歴番号 = div.getRentaiNofuGimushaInfo().getTxtRirekiNo().getValue();
        RentaiGimushaHolder 初期holder = ViewStateHolder.get(ViewStateKeys.連帯納付義務者情報初期, RentaiGimushaHolder.class);
        RentaiGimushaHolder holder = ViewStateHolder.get(ViewStateKeys.連帯納付義務者情報, RentaiGimushaHolder.class);
        最新履歴番号(div, 被保険者番号, holder);
        RentaiGimushaIdentifier identifier = new RentaiGimushaIdentifier(
                被保険者番号, new Decimal(履歴番号.toString()));
        RentaiGimusha result = holder.getKogakuGassanJikoFutanGaku(identifier);
        RentaiGimusha 初期result = 初期holder.getKogakuGassanJikoFutanGaku(identifier);
        if (result == null) {
            result = new RentaiGimusha(
                    被保険者番号, new Decimal(履歴番号.toString()));
            result = result.createBuilderForEdit()
                    .set開始年月日(new FlexibleDate(開始年月日.toString()))
                    .set終了年月日(終了年月日 == null ? new FlexibleDate(終了年月日NULL)
                            : new FlexibleDate(終了年月日.toString()))
                    .set識別コード(識別コード).build();
            result = result.added();
        } else {
            if (DBB6110001StateName.連帯納付義務者削除.getName().equals(ResponseHolder.getState())) {
                if (初期result == null) {
                    List<dgRentaiNofuGimushaIchiran_Row> dataSource = div.getDgRentaiNofuGimushaIchiran().getDataSource();
                    dataSource.remove(div.getDgRentaiNofuGimushaIchiran().getClickedItem());
                    div.getDgRentaiNofuGimushaIchiran().setDataSource(dataSource);
                    return ResponseData.of(div).setState(DBB6110001StateName.連帯納付義務者情報一覧);
                } else {
                    result = result.deleted();
                }
            } else {
                result = result.createBuilderForEdit()
                        .set開始年月日(new FlexibleDate(開始年月日.toString()))
                        .set終了年月日(終了年月日 == null ? new FlexibleDate(終了年月日NULL)
                                : new FlexibleDate(終了年月日.toString()))
                        .build();
                if (初期result == null) {
                    result = result.added();
                } else {
                    result = result.modified();
                }
            }
        }
        holder.addKogakuGassanJikoFutanGaku(result);
        RentaiNofuGimusha rentaiNofuGimusha = RentaiNofuGimusha.createInstance();
        List<RentaiGimusha> list = holder.getRentaiGimushaList();
        List<RentaiGimushaAtenaJouhou> rentaiList = rentaiNofuGimusha.getRentaiNofuGimushaAtenaInfo(list);
        handler.setDgRentaiNofuGimushaIchiran(rentaiList, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.連帯納付義務者情報, holder);
        return ResponseData.of(div).setState(DBB6110001StateName.連帯納付義務者情報一覧);
    }

    private RString 新履歴番号(RentaiGimusha result, RString 履歴番号, Decimal 最新履歴番号, KaigoHihokenshaInfoPanelDiv div) {
        if (result == null || ONE.equals(div.getHdnFlag())) {
            履歴番号 = new RString(最新履歴番号.intValue() + 1);
            div.setHdnFlag(RString.EMPTY);
        } else {
            履歴番号 = new RString(最新履歴番号.intValue());
        }
        return 履歴番号;
    }

    private void 最新履歴番号(KaigoHihokenshaInfoPanelDiv div, HihokenshaNo 被保険者番号, RentaiGimushaHolder holder) {
        RString 履歴番号 = div.getRentaiNofuGimushaInfo().getTxtRirekiNo().getValue();
        KaigoHihokenshaInfoPanelManger manager = InstanceProvider.create(KaigoHihokenshaInfoPanelManger.class);
        if (DBB6110001StateName.連帯納付義務者修正.getName().equals(ResponseHolder.getState()) || 履歴番号.isEmpty()) {
            Decimal 最新履歴番号 = manager.getNoIsDeleted最新履歴番号(被保険者番号);
            if (最新履歴番号 == null) {
                履歴番号 = ONE;
            } else {
                RentaiGimushaIdentifier identifier = new RentaiGimushaIdentifier(
                        被保険者番号, new Decimal(最新履歴番号.toString()));
                RentaiGimusha result = holder.getKogakuGassanJikoFutanGaku(identifier);
                履歴番号 = 新履歴番号(result, 履歴番号, 最新履歴番号, div);
            }
        }
    }

    /**
     * 「連帯納付義務者を追加する」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KaigoHihokenshaInfoPanelDiv> onClick_Add(
            KaigoHihokenshaInfoPanelDiv div) {
        FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
        KaigoHihokenshaInfoPanelHandler handler = getHandler(div);
        RentaiNofuGimusha rentaiNofuGimusha = RentaiNofuGimusha.createInstance();
        List<AtenaJouhou> list = rentaiNofuGimusha.getLastSetaiIchiran(taishoshaKey.get世帯コード());
        handler.set直近世帯情報取得(list);
        div.getRentaiNofuGimushaInfo().getTxtKaishiYMD().setDisabled(false);
        div.getRentaiNofuGimushaInfo().getTxtShuryoYMD().setDisabled(false);
        div.setHdnFlag(ONE);
        return ResponseData.of(div).setState(DBB6110001StateName.連帯納付義務者新規);
    }

    /**
     * 「連帯納付義務者を検索する」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KaigoHihokenshaInfoPanelDiv> onClick_Search(
            KaigoHihokenshaInfoPanelDiv div) {
        KaigoHihokenshaInfoPanelHandler handler = getHandler(div);
        FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
        if (taishoshaKey.get識別コード() == taishoshaKey.get識別コード()) {
            ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                    KensakuYusenKubun.住登外優先)
                    .set世帯コード(new SetaiCode(div.getTxtOutSetaiCode()))
                    .set識別コード(new ShikibetsuCode(div.getTxtOutShikibetsuCode()));
            IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
            KaigoHihokenshaInfoPanelManger manager = InstanceProvider.create(KaigoHihokenshaInfoPanelManger.class);
            IShikibetsuTaisho 宛名情報 = manager.get宛名情報(searchKey);
            handler.setRentaiNofuGimushaInfo(宛名情報);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「連帯納付義務者一覧修正」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KaigoHihokenshaInfoPanelDiv> onClick_Modify(
            KaigoHihokenshaInfoPanelDiv div) {
        FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
        KaigoHihokenshaInfoPanelHandler handler = getHandler(div);
        RentaiNofuGimusha rentaiNofuGimusha = RentaiNofuGimusha.createInstance();
        List<AtenaJouhou> list = rentaiNofuGimusha.getLastSetaiIchiran(taishoshaKey.get世帯コード());
        handler.set直近世帯情報取得(list);
        dgRentaiNofuGimushaIchiran_Row row = div.getDgRentaiNofuGimushaIchiran().getClickedItem();
        handler.setRentaiNofuGimushaInfo(row);
        div.getRentaiNofuGimushaInfo().getTxtKaishiYMD().setDisabled(false);
        div.getRentaiNofuGimushaInfo().getTxtShuryoYMD().setDisabled(false);
        return ResponseData.of(div).setState(DBB6110001StateName.連帯納付義務者修正);
    }

    /**
     * 「連帯納付義務者一覧削除」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KaigoHihokenshaInfoPanelDiv> onClick_Delete(
            KaigoHihokenshaInfoPanelDiv div) {
        KaigoHihokenshaInfoPanelHandler handler = getHandler(div);
        dgRentaiNofuGimushaIchiran_Row row = div.getDgRentaiNofuGimushaIchiran().getClickedItem();
        handler.setRentaiNofuGimushaInfo(row);
        div.getRentaiNofuGimushaInfo().getTxtKaishiYMD().setDisabled(true);
        div.getRentaiNofuGimushaInfo().getTxtShuryoYMD().setDisabled(true);
        return ResponseData.of(div).setState(DBB6110001StateName.連帯納付義務者削除);
    }

    /**
     * 「保存する」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KaigoHihokenshaInfoPanelDiv> onClick_Save(
            KaigoHihokenshaInfoPanelDiv div) {
        RentaiGimushaHolder holder = ViewStateHolder.get(ViewStateKeys.連帯納付義務者情報, RentaiGimushaHolder.class);
        for (RentaiGimusha entity : holder.getRentaiGimushaList()) {
            if (!entity.hasChanged() && !ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && new RString(DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No
                && new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
        RentaiNofuGimusha rentaiNofuGimusha = RentaiNofuGimusha.createInstance();
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        List<RentaiGimusha> list = rentaiNofuGimusha.getRentaiNofuGimushaInfo(被保険者番号);
        RentaiGimushaHolder 初期holder = ViewStateHolder.get(ViewStateKeys.連帯納付義務者情報初期, RentaiGimushaHolder.class);
        for (RentaiGimusha entity1 : list) {
            for (RentaiGimusha entity2 : 初期holder.getRentaiGimushaList()) {
                if (entity1.get履歴番号() == entity2.get履歴番号()) {
                    if (!entity1.get識別コード().equals(entity2.get識別コード())
                            || !entity1.get開始年月日().equals(entity2.get開始年月日())
                            || !entity1.get終了年月日().equals(entity2.get終了年月日())) {
                        return ResponseData.of(div).addMessage(UrErrorMessages.排他_他のユーザが更新済で更新処理を中止.getMessage()).respond();
                    }
                    break;
                }
            }
        }
        List<RentaiGimushaAtenaJouhou> rentaiList = rentaiNofuGimusha.getRentaiNofuGimushaAtenaInfo(list);
        if (初期holder.getRentaiGimushaList().size() != rentaiList.size()) {
            return ResponseData.of(div).addMessage(UrErrorMessages.排他_他のユーザが更新済で更新処理を中止.getMessage()).respond();
        }
        KaigoHihokenshaInfoPanelManger manager = InstanceProvider.create(KaigoHihokenshaInfoPanelManger.class);
        for (RentaiGimusha entity : holder.getRentaiGimushaList()) {
            if (entity.hasChanged() && entity.isModified()) {
                manager.saveModify(entity);
            } else {
                manager.save(entity);
            }
        }
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE_003),
                名称_被保険者番号, 被保険者番号.getColumnValue());
        PersonalData personalData = PersonalData.of(taishoshaKey.get識別コード(), expandedInfo);
        AccessLogger.log(AccessLogType.更新, personalData);
        LockingKey 前排他キー = new LockingKey(DBBHIHOKENSHANO.concat(被保険者番号.getColumnValue()));
        RealInitialLocker.release(前排他キー);
        div.getCcdKiagoKanryoMessage().setSuccessMessage(MESSAGETAISHO);
        return ResponseData.of(div).setState(DBB6110001StateName.連帯納付義務者更新結果確認);
    }

    /**
     * 「再検索する」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KaigoHihokenshaInfoPanelDiv> onClick_ReSearch(
            KaigoHihokenshaInfoPanelDiv div) {
        RentaiGimushaHolder holder = ViewStateHolder.get(ViewStateKeys.連帯納付義務者情報, RentaiGimushaHolder.class);
        ViewStateHolder.put(ViewStateKeys.連帯納付義務者情報初期, holder);
        if (DBB6110001StateName.連帯納付義務者更新結果確認.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).forwardWithEventName(DBB6110001TransitionEventName.一覧へ戻る).respond();
        }
        for (RentaiGimusha entity : holder.getRentaiGimushaList()) {
            if (entity.hasChanged() && !ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.検索画面遷移の確認.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        } else {
            FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
            HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
            LockingKey 前排他キー = new LockingKey(DBBHIHOKENSHANO.concat(被保険者番号.getColumnValue()));
            RealInitialLocker.release(前排他キー);
        }
        return ResponseData.of(div).forwardWithEventName(DBB6110001TransitionEventName.一覧へ戻る).respond();
    }

    private KaigoHihokenshaInfoPanelHandler getHandler(KaigoHihokenshaInfoPanelDiv div) {
        return new KaigoHihokenshaInfoPanelHandler(div);
    }

    private KaigoHihokenshaInfoValidationHandler getValidationHandler(KaigoHihokenshaInfoPanelDiv div) {
        return new KaigoHihokenshaInfoValidationHandler(div);
    }
}
