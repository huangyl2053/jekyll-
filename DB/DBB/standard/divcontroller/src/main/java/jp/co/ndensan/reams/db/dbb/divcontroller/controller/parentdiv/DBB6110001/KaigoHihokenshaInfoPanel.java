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
import jp.co.ndensan.reams.db.dbb.service.core.kaigohihokenshainfo.KaigoHihokenshaInfoPanelManger;
import jp.co.ndensan.reams.db.dbb.service.core.rentainofugimusha.RentaiNofuGimusha;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
    private static final RString ONE = new RString("1");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div KaigoHihokenshaInfoDiv
     * @return ResponseData
     */
    public ResponseData<KaigoHihokenshaInfoPanelDiv> onLoad(KaigoHihokenshaInfoPanelDiv div) {
        //FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
        //if (taishoshaKey != null) {
        RString 被保険者番号 = new RString("0000000002");
        ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("000000001004001"));
        SetaiCode 世帯コード = new SetaiCode(new RString("000000002011009"));
        KaigoHihokenshaInfoPanelHandler handler = getHandler(div);
        //handler.initializeDisplay(taishoshaKey);
        // handler.printLog識別コード照会(taishoshaKey.get識別コード(), taishoshaKey.get被保険者番号().getColumnValue());
        handler.printLog識別コード照会(識別コード, 被保険者番号);
        //RString 前排他キー = DBBHIHOKENSHANO.concat(taishoshaKey.get被保険者番号().getColumnValue());
        RString 前排他キー = DBBHIHOKENSHANO.concat(被保険者番号);
        LockingKey key = new LockingKey(前排他キー);
        if (!RealInitialLocker.tryGetLock(key)) {
            throw new PessimisticLockingException();
        }
        RentaiNofuGimusha rentaiNofuGimusha = RentaiNofuGimusha.createInstance();
        // List<RentaiGimusha> list = rentaiNofuGimusha.getRentaiNofuGimushaInfo(taishoshaKey.get被保険者番号());
        List<RentaiGimusha> list = rentaiNofuGimusha.getRentaiNofuGimushaInfo(new HihokenshaNo(被保険者番号));
        ViewStateHolder.put(ViewStateKeys.連帯納付義務者情報, new RentaiGimushaHolder(list));
        if (list.isEmpty()) {
            //List<AtenaJouhou> atenaList = rentaiNofuGimusha.getLastSetaiIchiran(taishoshaKey.get世帯コード());
            List<AtenaJouhou> atenaList = rentaiNofuGimusha.getLastSetaiIchiran(世帯コード);
            handler.setDgSetaiIchiran(atenaList, new HihokenshaNo(被保険者番号));
            return ResponseData.of(div).setState(DBB6110001StateName.連帯納付義務者新規);
        } else {
            List<RentaiGimushaAtenaJouhou> rentaiList = rentaiNofuGimusha.getRentaiNofuGimushaAtenaInfo(list);
            handler.setDgRentaiNofuGimushaIchiran(rentaiList, new HihokenshaNo(被保険者番号));
            return ResponseData.of(div).setState(DBB6110001StateName.連帯納付義務者情報一覧);
        }
        //}
        //return ResponseData.of(div).respond();
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
        FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
        KaigoHihokenshaInfoPanelHandler handler = getHandler(div);
        handler.initializeDisplay(taishoshaKey);
        RentaiNofuGimusha rentaiNofuGimusha = RentaiNofuGimusha.createInstance();
        List<RentaiGimusha> list = rentaiNofuGimusha.getRentaiNofuGimushaInfo(taishoshaKey.get被保険者番号());
        List<RentaiGimushaAtenaJouhou> rentaiList = rentaiNofuGimusha.getRentaiNofuGimushaAtenaInfo(list);
        handler.setDgRentaiNofuGimushaIchiran(rentaiList, taishoshaKey.get被保険者番号());
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
        //FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
        //HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        RString 被保険者番号 = new RString("0000000001");
        RDate 開始年月日 = div.getRentaiNofuGimushaInfo().getTxtKaishiYMD().getValue();
        RDate 終了年月日 = div.getRentaiNofuGimushaInfo().getTxtShuryoYMD().getValue();
        ShikibetsuCode 識別コード = div.getRentaiNofuGimushaInfo().getTxtShikibetsuCode().getDomain();
        RString 履歴番号 = div.getRentaiNofuGimushaInfo().getTxtRirekiNo().getValue();
        RentaiGimushaHolder holder = ViewStateHolder.get(ViewStateKeys.連帯納付義務者情報, RentaiGimushaHolder.class);
        RentaiGimushaIdentifier identifier = new RentaiGimushaIdentifier(
                new HihokenshaNo(被保険者番号), new Decimal(履歴番号.toString()));
        RentaiGimusha result = holder.getKogakuGassanJikoFutanGaku(identifier);
        if (result == null) {
            result = new RentaiGimusha(
                    new HihokenshaNo(被保険者番号), new Decimal(ONE.toString()));
            result = result.createBuilderForEdit()
                    .set開始年月日(new FlexibleDate(開始年月日.toString()))
                    .set終了年月日(new FlexibleDate(終了年月日.toString()))
                    .set識別コード(識別コード).build();
            result.added();
            holder.getRentaiGimushaList().add(result);
        } else {
            if (DBB6110001StateName.連帯納付義務者削除.getName().equals(ResponseHolder.getState())) {
                result = result.deleted();
            } else {
                result = result.createBuilderForEdit()
                        .set開始年月日(new FlexibleDate(開始年月日.toString()))
                        .set終了年月日(new FlexibleDate(終了年月日.toString()))
                        .set識別コード(識別コード).build();
                result.modified();
            }
        }
        RentaiNofuGimusha rentaiNofuGimusha = RentaiNofuGimusha.createInstance();
        List<RentaiGimusha> list = holder.getRentaiGimushaList();
        List<RentaiGimushaAtenaJouhou> rentaiList = rentaiNofuGimusha.getRentaiNofuGimushaAtenaInfo(list);
        handler.setDgRentaiNofuGimushaIchiran(rentaiList, new HihokenshaNo(被保険者番号));
        ViewStateHolder.put(ViewStateKeys.連帯納付義務者情報, holder);
        return ResponseData.of(div).setState(DBB6110001StateName.連帯納付義務者情報一覧);
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
        FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
        if (taishoshaKey.get識別コード() == taishoshaKey.get識別コード()) {
            ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                    KensakuYusenKubun.住登外優先)
                    .set世帯コード(SetaiCode.EMPTY)
                    .set識別コード(ShikibetsuCode.EMPTY);
            IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
            HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
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
        //FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
        KaigoHihokenshaInfoPanelHandler handler = getHandler(div);
        RentaiNofuGimusha rentaiNofuGimusha = RentaiNofuGimusha.createInstance();
        //List<AtenaJouhou> list = rentaiNofuGimusha.getLastSetaiIchiran(taishoshaKey.get世帯コード());
        SetaiCode 世帯コード = new SetaiCode(new RString("000000002011009"));
        List<AtenaJouhou> list = rentaiNofuGimusha.getLastSetaiIchiran(世帯コード);
        handler.set直近世帯情報取得(list);
        dgRentaiNofuGimushaIchiran_Row row = div.getDgRentaiNofuGimushaIchiran().getClickedItem();
        handler.setRentaiNofuGimushaInfo(row);
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
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
        RentaiNofuGimusha rentaiNofuGimusha = RentaiNofuGimusha.createInstance();
        List<RentaiGimusha> list = rentaiNofuGimusha.getRentaiNofuGimushaInfo(taishoshaKey.get被保険者番号());
        RentaiGimushaHolder holder = ViewStateHolder.get(ViewStateKeys.連帯納付義務者情報, RentaiGimushaHolder.class);
        KaigoHihokenshaInfoPanelManger manager = InstanceProvider.create(KaigoHihokenshaInfoPanelManger.class);
        for (RentaiGimusha entity : holder.getRentaiGimushaList()) {
            if (entity.hasChanged()) {
                manager.save(entity);
            }
        }
        return ResponseData.of(div).forwardWithEventName(DBB6110001TransitionEventName.完了状態).respond();
    }

    /**
     * 「再検索する」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KaigoHihokenshaInfoPanelDiv> onClick_ReSearch(
            KaigoHihokenshaInfoPanelDiv div) {
        FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        LockingKey 前排他キー = new LockingKey(DBBHIHOKENSHANO.concat(被保険者番号.getColumnValue()));
        RealInitialLocker.release(前排他キー);
        return ResponseData.of(div).forwardWithEventName(DBB6110001TransitionEventName.完了状態).respond();
    }

    private KaigoHihokenshaInfoPanelHandler getHandler(KaigoHihokenshaInfoPanelDiv div) {
        return new KaigoHihokenshaInfoPanelHandler(div);
    }

    private KaigoHihokenshaInfoValidationHandler getValidationHandler(KaigoHihokenshaInfoPanelDiv div) {
        return new KaigoHihokenshaInfoValidationHandler(div);
    }
}
