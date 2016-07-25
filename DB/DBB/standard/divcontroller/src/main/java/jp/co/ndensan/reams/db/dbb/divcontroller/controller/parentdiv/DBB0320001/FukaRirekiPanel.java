/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320001;

import jp.co.ndensan.reams.db.dbb.business.util.HokenryoDankaiUtil;
import jp.co.ndensan.reams.db.dbb.business.core.Kiwarigaku;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukaComparators;
import jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaMapper;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiDisplayMode;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.ViewStateKeyCreator;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320005.input.FukaHikakuInput;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.DBB0320001StateName.賦課根拠期割;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.FukaRirekiAllPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.FukaRirekiPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.DBB0320001KihonJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.dgFukaRirekiFukaRireki_Row;
import jp.co.ndensan.reams.db.dbb.service.core.basic.FukaManager;
import jp.co.ndensan.reams.db.dbb.service.core.relate.KiwarigakuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.util.function.ExceptionSuppliers;
import jp.co.ndensan.reams.db.dbz.definition.core.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 賦課照会の賦課履歴Divのコントローラです。
 *
 * @author n3317 塚田 萌
 */
public class FukaRirekiPanel {

    /**
     * コントロールdivが「生成」された際の処理です。
     *
     * @param rirekiDiv 履歴div
     * @param rirekiAllDiv 全履歴div
     * @param kihonDiv 基本情報div
     * @return レスポンスデータ
     */
    public ResponseData<FukaRirekiPanelDiv> onLoad(FukaRirekiPanelDiv rirekiDiv, FukaRirekiAllPanelDiv rirekiAllDiv, DBB0320001KihonJohoDiv kihonDiv) {
        return load(rirekiDiv, rirekiAllDiv, kihonDiv);
    }

    /**
     * コントロールdivが「非表示」→「表示」となった際の処理です。
     *
     * @param rirekiDiv 履歴div
     * @param rirekiAllDiv 全履歴div
     * @param kihonDiv 基本情報div
     * @return レスポンスデータ
     */
    public ResponseData<FukaRirekiPanelDiv> onActive(FukaRirekiPanelDiv rirekiDiv, FukaRirekiAllPanelDiv rirekiAllDiv, DBB0320001KihonJohoDiv kihonDiv) {
        return reload(rirekiDiv, rirekiAllDiv, kihonDiv);
    }

    /**
     * 初回表示時の初期処理です。<br/>
     * 初回のみ、履歴一覧を表示せずに直近データの賦課根拠・期割を表示します。
     *
     * @param rirekiDiv 賦課履歴Div
     * @param rirekiAllDiv 全賦課履歴Div
     * @param kihonDiv 宛名・介護基本Div
     * @return レスポンスデータ
     */
    public ResponseData<FukaRirekiPanelDiv> load(FukaRirekiPanelDiv rirekiDiv, FukaRirekiAllPanelDiv rirekiAllDiv, DBB0320001KihonJohoDiv kihonDiv) {

//        rirekiDiv.setDisplayNone(true);
        return ResponseData.of(rirekiDiv).setState(賦課根拠期割);
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
    public ResponseData<FukaRirekiPanelDiv> reload(FukaRirekiPanelDiv rirekiDiv, FukaRirekiAllPanelDiv rirekiAllDiv, DBB0320001KihonJohoDiv kihonDiv) {

//        rirekiDiv.setDisplayNone(false);
//        FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();
//
//        rirekiDiv.getTxtFukaNendoFukaRireki().setDomain(key.get賦課年度().value());
//        setDgFukaRireki(rirekiDiv, rirekiAllDiv.getCcdFukaRirekiAll().get賦課履歴().get賦課履歴(
//                key.get賦課年度(), key.get調定年度(), key.get通知書番号()));
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
            FukaRirekiPanelDiv rirekiDiv, FukaRirekiAllPanelDiv rirekiAllDiv, DBB0320001KihonJohoDiv kihonDiv) {

        IItemList<Fuka> selectItemList = rirekiAllDiv.getCcdFukaRirekiAll().get賦課履歴().get賦課履歴All().reversed();
        Fuka selectRow = selectItemList.findFirst().get();

        final FukaManager manager = new FukaManager();
//        IItemList<Fuka> descList = ItemList.of(manager.get介護賦課一覧(selectRow.get調定年度(), selectRow.get賦課年度(), selectRow.get通知書番号()));
        IItemList<Fuka> descList = ItemList.of(manager.get介護賦課(selectRow.get調定年度(), selectRow.get賦課年度(), selectRow.get通知書番号()));
        if (rirekiAllDiv.getLblMode().getText().equals(FukaShokaiDisplayMode.二回目以降.getCode())) {
            setDgFukaRireki(rirekiDiv, descList, selectRow.get賦課年度());
        } else {
            Fuka model = descList.findFirst().get();
            FukaShokaiKey key = ViewStateKeyCreator.createFukaShokaiKey(model, new AtenaMeisho(kihonDiv.getCcdKaigoAtenaInfo().get氏名漢字()));
            ViewStateHolder.put(ViewStateKeys.賦課照会キー, key);
        }

        return createResponseData(rirekiDiv);
    }

    private void setDgFukaRireki(FukaRirekiPanelDiv fukaRirekiDiv, IItemList rireki, FlexibleYear 賦課年度) {
        fukaRirekiDiv.getTxtFukaNendoFukaRireki().setDomain(賦課年度);
        fukaRirekiDiv.getDgFukaRirekiFukaRireki().setDataSource(rireki.sorted(FukaComparators.orderBy履歴番号.desc()).map(to_dgFukaRireki_Row()).toList());
    }

    private IFunction<Fuka, dgFukaRirekiFukaRireki_Row> to_dgFukaRireki_Row() {

        return new IFunction<Fuka, dgFukaRirekiFukaRireki_Row>() {
            @Override
            public dgFukaRirekiFukaRireki_Row apply(Fuka fuka) {

                RString hokernyoDankai;
                if (fuka.get保険料段階().isEmpty()) {
                    hokernyoDankai = new RString("-");
                } else {
                    hokernyoDankai = HokenryoDankaiUtil.edit表示用保険料段階(FukaShokaiController.findHokenryoDankai(
                            fuka.get賦課年度(), fuka.get保険料段階()));
                }

                Kiwarigaku kiwarigaku = findKiwarigaku(fuka);

                return new dgFukaRirekiFukaRireki_Row(
                        new Button(),
                        fuka.get通知書番号().value(),
                        fuka.get調定年度().wareki().toDateString(),
                        fuka.get調定年度().seireki().getYear(),
                        FukaMapper.toDisplayForm(fuka.get調定日時().getRDateTime()),
                        fuka.get更正月(),
                        hokernyoDankai,
                        FukaMapper.addComma(fuka.get確定介護保険料_年額()),
                        FukaMapper.addComma(kiwarigaku.get特徴期別額合計()),
                        FukaMapper.addComma(kiwarigaku.get普徴期別額合計()),
                        new RString(Integer.toString(fuka.get履歴番号())));
            }
        };
    }

    private Kiwarigaku findKiwarigaku(Fuka model) {
        Optional<Kiwarigaku> amountoid = new KiwarigakuManager().load期割額(model.get調定年度(), model.get賦課年度(), model.get通知書番号(), model.get履歴番号());

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
            FukaRirekiPanelDiv rirekiDiv, FukaRirekiAllPanelDiv rirekiAllDiv, DBB0320001KihonJohoDiv kihonDiv) {

//        Fuka model = findTargetModel(
//                rirekiAllDiv.getCcdFukaRirekiAll().get賦課履歴().get賦課履歴All(),
//                rirekiDiv.getDgFukaRirekiFukaRireki().getClickedItem());
        // TODO FukaManagerを１つにしたい
        final FukaManager manager = new FukaManager();

        dgFukaRirekiFukaRireki_Row selectRow = rirekiDiv.getDgFukaRirekiFukaRireki().getClickedItem();
        FlexibleYear choteiNendo = new FlexibleYear(selectRow.getTxtChoteiNendoHidden().toString());

        Fuka fuka = manager.get介護賦課(
                choteiNendo,
                rirekiDiv.getTxtFukaNendoFukaRireki().getDomain(),
                new TsuchishoNo(selectRow.getTxtTsuchishoNo()),
                Integer.valueOf(selectRow.getRirekiNo().toString()));
        FukaShokaiKey key = ViewStateKeyCreator.createFukaShokaiKey(fuka, new AtenaMeisho(kihonDiv.getCcdKaigoAtenaInfo().get氏名漢字()));
        ViewStateHolder.put(ViewStateKeys.賦課照会キー, key);

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
            FukaRirekiPanelDiv rirekiDiv, FukaRirekiAllPanelDiv rirekiAllDiv, DBB0320001KihonJohoDiv kihonDiv) {

        // TODO FukaManagerを１つにしたい
        final FukaManager manager = new FukaManager();

        dgFukaRirekiFukaRireki_Row selectRow = rirekiDiv.getDgFukaRirekiFukaRireki().getClickedItem();
        FlexibleYear choteiNendo = new FlexibleYear(selectRow.getTxtChoteiNendoHidden().toString());
        int 履歴番号 = Integer.valueOf(selectRow.getRirekiNo().toString());

        Fuka atoFuka = manager.get介護賦課(
                choteiNendo,
                rirekiDiv.getTxtFukaNendoFukaRireki().getDomain(),
                new TsuchishoNo(selectRow.getTxtTsuchishoNo()),
                履歴番号);

        FukaShokaiKey atoRireki = ViewStateKeyCreator.createFukaShokaiKey(atoFuka, new AtenaMeisho(kihonDiv.getCcdKaigoAtenaInfo().get氏名漢字()));
        ViewStateHolder.put(ViewStateKeys.賦課照会キー, atoRireki);

        FukaShokaiKey maeRireki = ViewStateKeyCreator.createFukaShokaiKey(
                manager.get介護賦課For任意対象比較(atoFuka.get調定年度(), atoFuka.get賦課年度(), atoFuka.get通知書番号(), atoFuka.get履歴番号()).get(),
                new AtenaMeisho(kihonDiv.getCcdKaigoAtenaInfo().get氏名漢字()));
        ViewStateHolder.put(ViewStateKeys.賦課比較キー, FukaHikakuInput.createFor前履歴との比較(atoRireki, maeRireki));

//        ViewStateHolder.put(ViewStateKeys.賦課比較キー, maeRireki);
//        if (履歴番号 == 1) {
//            ViewStateHolder.put(ViewStateKeys.賦課比較キー, FukaHikakuInput.createFor前年度最終との比較(atoRireki));
//        } else {
//            Fuka maeFuka = manager.get介護賦課(
//                    choteiNendo,
//                    rirekiDiv.getTxtFukaNendoFukaRireki().getDomain(),
//                    new TsuchishoNo(selectRow.getTxtTsuchishoNo()),
//                    履歴番号 - 1);
//            FukaShokaiKey maeRireki = ViewStateKeyCreator.createFukaShokaiKey(maeFuka, new AtenaMeisho(kihonDiv.getCcdKaigoAtenaInfo().get氏名漢字()));
//            ViewStateHolder.put(ViewStateKeys.賦課比較キー, FukaHikakuInput.createFor前履歴との比較(atoRireki, maeRireki));
//        }
//        Optional<Fuka> value = fukaFinder.find賦課直近(
//                new TsuchishoNo(selectRow.getTxtTsuchishoNo()),
//                RDateTime.parse(selectRow.getShoriTimestamp().toString()));
//
//        IViewStateValue<MaeRirekiKey> maeRireki = ViewStates.access().valueAssignedToA(MaeRirekiKey.class);
//        if (value.isPresent()) {
//            Fuka maeModel = value.get();
//            maeRireki.put(ViewStateKeyCreator.createMaeRirekiKey(maeModel, kihonDiv.getCcdKaigoAtenaInfo().getName()));
//        } else {
//            maeRireki.remove();
//        }
//        for (ListIterator<Fuka> listIterator = list.toList().listIterator(); listIterator.hasNext();) {
//            targetModel = listIterator.next();
//            if (targetModel.get処理日時().toString().equals(row.getShoriTimestamp().toString())) {
//                FukaShokaiKey key = ViewStateKeyCreator.createFukaShokaiKey(targetModel, kihonDiv.getCcdKaigoAtenaInfo().getName());
//                value.put(key);
//
//                if (listIterator.hasPrevious()) {
//                    MaeRirekiKey maeKey = ViewStateKeyCreator.createMaeRirekiKey(listIterator.previous(), kihonDiv.getCcdKaigoAtenaInfo().getName());
//                    maeRirekiValue.put(maeKey);
//                } else {
//                    maeRirekiValue.remove();
//                }
//            }
//        }
        return createResponseData(rirekiDiv);
    }

//    private Fuka findTargetModel(IItemList<Fuka> list, dgFukaRirekiFukaRireki_Row row) {
//        for (Iterator<Fuka> iterator = list.iterator(); iterator.hasNext();) {
//            Fuka target = iterator.next();
//            if (String.valueOf(target.get履歴番号()).equals(row.getRirekiNo().toString())) {
//                return target;
//            }
//        }
//        throw new SystemException(UrErrorMessages.対象データなし.getMessage().evaluate());
//    }
    private ResponseData<FukaRirekiPanelDiv> createResponseData(FukaRirekiPanelDiv rirekiDiv) {
        return ResponseData.of(rirekiDiv).respond();
    }
}
