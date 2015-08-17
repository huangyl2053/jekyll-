/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.fukarirekiall;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.FukaRireki;
import jp.co.ndensan.reams.db.dbz.business.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.Kiwarigaku;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbb.model.fuka.FukaModel;
import jp.co.ndensan.reams.db.dbz.realservice.FukaManager;
import jp.co.ndensan.reams.db.dbz.realservice.HokenryoDankaiManager;
import jp.co.ndensan.reams.db.dbb.realservice.KiwarigakuFinder;
import jp.co.ndensan.reams.ur.urz.divcontroller.helper.PanelSessionAccessor;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 全賦課履歴Divの操作を行うクラスです。
 *
 * @author N8156 宮本 康
 */
public class FukaRirekiAllHandler {

    private final FukaRirekiAllDiv div;
    private final FukaManager fukaFinder;
    private final HokenryoDankaiManager dankaiManager;
    private final KiwarigakuFinder kiwariFinder;

    private static final RString SESSION_NAME = new RString("FukaRirekiAll");

    /**
     * コンストラクタです。
     *
     * @param div 全賦課履歴Div
     */
    public FukaRirekiAllHandler(FukaRirekiAllDiv div) {
        this.div = div;
        this.fukaFinder = new FukaManager();
        this.dankaiManager = new HokenryoDankaiManager();
        this.kiwariFinder = new KiwarigakuFinder();
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param div 全賦課履歴Div
     * @param fukaFinder 賦課照会Finder
     * @param dankaiManager 保険料段階Manager
     * @param kiwariFinder 期割額Finder
     */
    FukaRirekiAllHandler(
            FukaRirekiAllDiv div, FukaManager fukaShokaiFinder, HokenryoDankaiManager dankaiManager, KiwarigakuFinder kiwariFinder) {
        this.div = div;
        this.fukaFinder = fukaShokaiFinder;
        this.dankaiManager = dankaiManager;
        this.kiwariFinder = kiwariFinder;
    }

    /**
     * 引数に該当するデータをDivに設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 表示件数
     */
    public int load(HihokenshaNo 被保険者番号) {
        // TODO n8187久保田 画面遷移の確認のために空行を表示するよう一時的に修正
        // ここから
        List<FukaModel> list = new ArrayList<>();
        IItemList<FukaModel> modelList = ItemList.of(list);
//        IItemList<FukaModel> modelList = fukaFinder.load全賦課履歴(被保険者番号);
//        PanelSessionAccessor.put(div, SESSION_NAME, ItemList.newItemList(modelList));
        // ここまで
        return set全賦課履歴(modelList);
    }

    /**
     * 引数に該当するデータをDivに設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 賦課年度 賦課年度
     * @return 表示件数
     */
    public int load(HihokenshaNo 被保険者番号, FukaNendo 賦課年度) {
        // TODO n8187久保田 画面遷移の確認のために空行を表示するよう一時的に修正
        // ここから
        List<FukaModel> list = new ArrayList<>();
        IItemList<FukaModel> modelList = ItemList.of(list);
//        IItemList<FukaModel> modelList = fukaFinder.load全賦課履歴(被保険者番号, 賦課年度);
//        PanelSessionAccessor.put(div, SESSION_NAME, ItemList.newItemList(modelList));
        // ここまで
        return set全賦課履歴(modelList);
    }

    /**
     * 調定年度、賦課年度、通知書番号に該当する処理日時の直近データをDivに設定します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @return 表示件数
     */
    public int load(ChoteiNendo 調定年度, FukaNendo 賦課年度, TsuchishoNo 通知書番号) {
        // TODO n8187久保田 画面遷移の確認のために空行を表示するよう一時的に修正
        // ここから
        List<FukaModel> list = new ArrayList<>();
        IItemList<FukaModel> modelList = ItemList.of(list);
//        IItemList<FukaModel> modelList = fukaFinder.find賦課直近(調定年度, 賦課年度, 通知書番号);
//        PanelSessionAccessor.put(div, SESSION_NAME, ItemList.newItemList(modelList));
        // ここまで
        return set全賦課履歴(modelList);
    }

    /**
     * 通知書番号に該当する処理日時の直近データをDivに設定します。
     *
     * @param 通知書番号 通知書番号
     * @return 表示件数
     */
    public int reload(TsuchishoNo 通知書番号) {
        // TODO n8187久保田 画面遷移の確認のために空行を表示するよう一時的に修正
        // ここから
        List<FukaModel> list = new ArrayList<>();
        IItemList<FukaModel> modelList = ItemList.of(list);
//        IItemList<FukaModel> modelList = fukaFinder.get直近介護賦課一覧(通知書番号);
//        PanelSessionAccessor.put(div, SESSION_NAME, ItemList.newItemList(modelList));
        // ここまで
        return set全賦課履歴(modelList);
    }

    /**
     * 引数の被保険者番号に該当するデータをDivに設定し、調定年度、賦課年度、通知書番号に該当する行を選択状態にします。
     *
     * @param 被保険者番号 被保険者番号
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @return 表示件数
     */
    public int reload(HihokenshaNo 被保険者番号, ChoteiNendo 調定年度, FukaNendo 賦課年度, TsuchishoNo 通知書番号) {
        load(被保険者番号);
        return setSelectedRow(調定年度, 賦課年度, 通知書番号);
    }

    /**
     * 選択されている行の賦課履歴を返します。行が選択されていない場合は全賦課履歴を返します。
     *
     * @return 賦課履歴
     */
    public FukaRireki get賦課履歴() {
        FukaRireki 賦課履歴 = new FukaRireki(PanelSessionAccessor.get(div, SESSION_NAME, ItemList.class).toList());
        List<dgFukaRirekiAll_Row> rowList = div.getDgFukaRirekiAll().getSelectedItems();
        if (rowList.isEmpty()) {
            return 賦課履歴;
        } else {
            dgFukaRirekiAll_Row row = rowList.get(0);
            FukaNendo 賦課年度 = new FukaNendo(row.getFukaNendo().toString());
            ChoteiNendo 調定年度 = new ChoteiNendo(row.getChoteiNendo().toString());
            TsuchishoNo 通知書番号 = new TsuchishoNo(row.getTsuchishoNo());
            return new FukaRireki(賦課履歴.get賦課履歴(賦課年度, 調定年度, 通知書番号).toList());
        }
    }

    private int set全賦課履歴(IItemList<FukaModel> modelList) {

        List<dgFukaRirekiAll_Row> rowList = new ArrayList<>();
        // TODO n8187久保田 画面遷移の確認のために空行を表示するよう一時的に修正
        // ここから
        rowList.add(new dgFukaRirekiAll_Row());
//        for (FukaModel model : new FukaRireki(modelList.toList()).getグループ化賦課履歴()) {
//
//            Optional<HokenryoDankai> 保険料段階 = dankaiManager.get保険料段階(model.get賦課年度(), model.get賦課市町村コード(), model.get保険料段階());
//            Optional<Kiwarigaku> 期割額 = kiwariFinder.load期割額(model.get調定年度(), model.get賦課年度(), model.get通知書番号(), model.get処理日時());
//
//            if (!期割額.isPresent()) {
//                continue;
//            }
//
//            rowList.add(new dgFukaRirekiAll_Row(
//                    model.get調定年度().value().toDateString(),
//                    model.get賦課年度().value().toDateString(),
//                    model.get通知書番号().value(),
//                    保険料段階.get().edit表示用保険料段階(),
//                    new RString(model.get減免前介護保険料_年額().toString()),
//                    new RString(model.get減免額().toString()),
//                    new RString(model.get確定介護保険料_年額().toString()),
//                    new RString(期割額.get().get特徴期別額合計().toString()),
//                    new RString(期割額.get().get普徴期別額合計().toString())
//            ));
//        }
        // ここまで
        div.getDgFukaRirekiAll().setDataSource(rowList);

        return div.getDgFukaRirekiAll().getDataSource().size();
    }

    private int setSelectedRow(ChoteiNendo 調定年度, FukaNendo 賦課年度, TsuchishoNo 通知書番号) {
        List<dgFukaRirekiAll_Row> selectedItem = new ArrayList<>();
        for (dgFukaRirekiAll_Row row : div.getDgFukaRirekiAll().getDataSource()) {
            if (row.getChoteiNendo().equals(調定年度.value().toDateString())
                    && row.getFukaNendo().equals(賦課年度.value().toDateString())
                    && row.getTsuchishoNo().equals(通知書番号.value())) {
                selectedItem.add(row);
            }
        }
        div.getDgFukaRirekiAll().setSelectedItems(selectedItem);

        return div.getDgFukaRirekiAll().getDataSource().size();
    }
}
