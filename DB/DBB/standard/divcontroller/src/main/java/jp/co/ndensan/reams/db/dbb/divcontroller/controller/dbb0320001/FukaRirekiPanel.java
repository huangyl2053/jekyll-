/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320001;

import java.util.Iterator;
import java.util.ListIterator;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaMapper;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiDisplayMode;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.ViewStateKeyCreator;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukaRirekiAllPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukaRirekiPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.KihonJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.dgFukaRirekiFukaRireki_Row;
import jp.co.ndensan.reams.db.dbz.business.Kiwarigaku;
import jp.co.ndensan.reams.db.dbz.business.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbz.business.viewstate.MaeRirekiKey;
import jp.co.ndensan.reams.db.dbz.definition.util.function.ExceptionSuppliers;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.IViewStateValue;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStates;
import jp.co.ndensan.reams.db.dbz.model.fuka.FukaModel;
import jp.co.ndensan.reams.db.dbz.realservice.KiwarigakuFinder;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 * 賦課照会の賦課履歴Divのコントローラです。
 *
 * @author n3317 塚田 萌
 */
public class FukaRirekiPanel {

    /**
     * 初回表示時の初期処理です。<br/>
     * 初回のみ、履歴一覧を表示せずに直近データの賦課根拠・期割を表示します。
     *
     * @param rirekiDiv 賦課履歴Div
     * @param rirekiAllDiv 全賦課履歴Div
     * @param kihonDiv 宛名・介護基本Div
     * @return レスポンスデータ
     */
    public ResponseData<FukaRirekiPanelDiv> load(FukaRirekiPanelDiv rirekiDiv, FukaRirekiAllPanelDiv rirekiAllDiv, KihonJohoDiv kihonDiv) {

        rirekiDiv.setDisplayNone(true);
        return createResponseData(rirekiDiv);
    }

    /**
     * ２回目以降の初期処理です。<br/>
     * ２回目以降は履歴一覧を表示します。初期表示は前回に選択した全賦課履歴の賦課履歴です。
     *
     * @param rirekiDiv 賦課履歴Div
     * @param rirekiAllDiv 全賦課履歴Div
     * @param kihonDiv 宛名・介護基本Div
     * @return レスポンスデータ
     */
    public ResponseData<FukaRirekiPanelDiv> reload(FukaRirekiPanelDiv rirekiDiv, FukaRirekiAllPanelDiv rirekiAllDiv, KihonJohoDiv kihonDiv) {

        rirekiDiv.setDisplayNone(false);

        FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();

        rirekiDiv.getTxtFukaNendoFukaRireki().setDomain(key.get賦課年度().value());
        setDgFukaRireki(rirekiDiv, rirekiAllDiv.getCcdFukaRirekiAll().get賦課履歴().get賦課履歴(
                key.get賦課年度(), key.get調定年度(), key.get通知書番号()));

        return createResponseData(rirekiDiv);
    }

    /**
     * 全賦課履歴の選択ボタンクリック、またはダブルクリック時の処理です。<br/>
     * 初回は根拠・期割Divに遷移します。<br/>
     * 2回目以降は選択内容を履歴一覧に表示します。
     *
     * @param rirekiDiv 賦課履歴Div
     * @param rirekiAllDiv 全賦課履歴Div
     * @param kihonDiv 宛名・介護基本Div
     * @return レスポンスデータ
     */
    public ResponseData<FukaRirekiPanelDiv> onSelect_dgFukaRirekiAll(
            FukaRirekiPanelDiv rirekiDiv, FukaRirekiAllPanelDiv rirekiAllDiv, KihonJohoDiv kihonDiv) {

        IItemList<FukaModel> descList = rirekiAllDiv.getCcdFukaRirekiAll().get賦課履歴().get賦課履歴All().reversed();

        if (rirekiAllDiv.getLblMode().getText().equals(FukaShokaiDisplayMode.二回目以降.getCode())) {
            setDgFukaRireki(rirekiDiv, descList);
        } else {
            FukaModel model = descList.findFirst().get();
            FukaShokaiKey key = ViewStateKeyCreator.createFukaShokaiKey(model, kihonDiv.getCcdKaigoAtenaInfo().getName());
            ViewStates.access().valueAssignedToA(FukaShokaiKey.class).put(key);
        }

        return createResponseData(rirekiDiv);
    }

    private void setDgFukaRireki(FukaRirekiPanelDiv fukaRirekiDiv, IItemList rireki) {
        fukaRirekiDiv.getDgFukaRirekiFukaRireki().setDataSource(rireki.map(to_dgFukaRireki_Row()).toList());
    }

    private IFunction<FukaModel, dgFukaRirekiFukaRireki_Row> to_dgFukaRireki_Row() {

        return new IFunction<FukaModel, dgFukaRirekiFukaRireki_Row>() {
            @Override
            public dgFukaRirekiFukaRireki_Row apply(FukaModel model) {

                RString hokernyoDankai = FukaShokaiController.findHokenryoDankai(
                        model.get賦課年度(), model.get賦課市町村コード(), model.get保険料段階()).edit表示用保険料段階();

                Kiwarigaku kiwarigaku = findKiwarigaku(model);

                return new dgFukaRirekiFukaRireki_Row(
                        new Button(),
                        model.get通知書番号().value(),
                        model.get調定年度().value().wareki().toDateString(),
                        FukaMapper.toDisplayForm(model.get調定日時()),
                        model.get更正月(),
                        hokernyoDankai,
                        FukaMapper.addComma(model.get確定介護保険料_年額()),
                        FukaMapper.addComma(kiwarigaku.get特徴期別額合計()),
                        FukaMapper.addComma(kiwarigaku.get普徴期別額合計()),
                        new RString(model.get処理日時().toString()));
            }
        };
    }

    private Kiwarigaku findKiwarigaku(FukaModel model) {
        Optional<Kiwarigaku> amountoid = new KiwarigakuFinder().load期割額(model.get調定年度(), model.get賦課年度(), model.get通知書番号(), model.get処理日時());

        return amountoid.orElseThrow(
                ExceptionSuppliers.systemException(UrErrorMessages.対象データなし.getMessage().evaluate()));
    }

    /**
     * 履歴一覧の選択ボタンクリック、またはダブルクリック時にキー情報をviewStateに渡します。
     *
     * @param rirekiDiv 賦課履歴Div
     * @param rirekiAllDiv 全賦課履歴Div
     * @param kihonDiv 宛名・介護基本Div
     * @return レスポンスデータ
     */
    public ResponseData<FukaRirekiPanelDiv> onSelect_FukaRireki(
            FukaRirekiPanelDiv rirekiDiv, FukaRirekiAllPanelDiv rirekiAllDiv, KihonJohoDiv kihonDiv) {

        FukaModel model = findTargetModel(
                rirekiAllDiv.getCcdFukaRirekiAll().get賦課履歴().get賦課履歴All(),
                rirekiDiv.getDgFukaRirekiFukaRireki().getClickedItem());

        FukaShokaiKey key = ViewStateKeyCreator.createFukaShokaiKey(model, kihonDiv.getCcdKaigoAtenaInfo().getName());
        ViewStates.access().valueAssignedToA(FukaShokaiKey.class).put(key);

        return createResponseData(rirekiDiv);
    }

    /**
     * 前履歴と比較するボタンクリック時の処理です。
     *
     * @param rirekiDiv 賦課履歴Div
     * @param rirekiAllDiv 全賦課履歴Div
     * @param kihonDiv 宛名・介護基本Div
     * @return レスポンスデータ
     */
    public ResponseData<FukaRirekiPanelDiv> onClick_MaeHikaku(
            FukaRirekiPanelDiv rirekiDiv, FukaRirekiAllPanelDiv rirekiAllDiv, KihonJohoDiv kihonDiv) {

        IItemList list = rirekiAllDiv.getCcdFukaRirekiAll().get賦課履歴().get賦課履歴All();
        dgFukaRirekiFukaRireki_Row row = rirekiDiv.getDgFukaRirekiFukaRireki().getClickedItem();
        FukaModel targetModel;

        IViewStateValue<FukaShokaiKey> value = ViewStates.access().valueAssignedToA(FukaShokaiKey.class);
        IViewStateValue<MaeRirekiKey> maeRirekiValue = ViewStates.access().valueAssignedToA(MaeRirekiKey.class);

        for (ListIterator<FukaModel> listIterator = list.toList().listIterator(); listIterator.hasNext();) {
            targetModel = listIterator.next();
            if (targetModel.get処理日時().toString().equals(row.getShoriTimestamp().toString())) {
                FukaShokaiKey key = ViewStateKeyCreator.createFukaShokaiKey(targetModel, kihonDiv.getCcdKaigoAtenaInfo().getName());
                value.put(key);

                if (listIterator.hasPrevious()) {
                    MaeRirekiKey maeKey = ViewStateKeyCreator.createMaeRirekiKey(listIterator.previous(), kihonDiv.getCcdKaigoAtenaInfo().getName());
                    maeRirekiValue.put(maeKey);
                } else {
                    maeRirekiValue.remove();
                }
            }
        }

        return createResponseData(rirekiDiv);
    }

    private FukaModel findTargetModel(IItemList list, dgFukaRirekiFukaRireki_Row row) {
        for (Iterator<FukaModel> iterator = list.iterator(); iterator.hasNext();) {
            FukaModel target = iterator.next();
            if (target.get処理日時().toString().equals(row.getShoriTimestamp().toString())) {
                return target;
            }
        }
        throw new SystemException(UrErrorMessages.対象データなし.getMessage().evaluate());
    }

    private ResponseData<FukaRirekiPanelDiv> createResponseData(FukaRirekiPanelDiv rirekiDiv) {
        ResponseData<FukaRirekiPanelDiv> response = new ResponseData<>();
        response.data = rirekiDiv;
        return response;
    }
}
