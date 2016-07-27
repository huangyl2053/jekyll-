/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320001;

import jp.co.ndensan.reams.db.dbb.business.core.Kiwarigaku;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukaComparators;
import jp.co.ndensan.reams.db.dbb.business.util.HokenryoDankaiUtil;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaMapper;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.FukaRirekiPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.dgFukaRirekiFukaRireki_Row;
import jp.co.ndensan.reams.db.dbb.service.core.relate.KiwarigakuManager;
import jp.co.ndensan.reams.db.dbz.definition.core.util.function.ExceptionSuppliers;
import jp.co.ndensan.reams.db.dbz.definition.core.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 * {@link FukaRirekiPanelDiv}へのデータの表示を行います。
 */
public class FukaRirekiPanelPresenter {

    private final FukaRirekiPanelDiv div;

    /**
     * 指定の{@link FukaRirekiPanelDiv}に対して、データを表示するインスタンスを生成します。
     *
     * @param div {@link FukaRirekiPanelDiv}
     */
    public FukaRirekiPanelPresenter(FukaRirekiPanelDiv div) {
        this.div = div;
    }

    /**
     * 指定の賦課履歴を画面へ表示します。
     *
     * @param rireki 賦課履歴
     */
    public void set賦課履歴(IItemList<Fuka> rireki) {
        Fuka first = rireki.findFirst().orElse(null);
        this.div.getTxtFukaNendoFukaRireki().setDomain(first == null ? FlexibleYear.EMPTY : first.get賦課年度());
        this.div.getDgFukaRirekiFukaRireki().setDataSource(rireki.sorted(FukaComparators.orderBy履歴番号.desc())
                .map(to_dgFukaRireki_Row()).toList());
    }

    private static IFunction<Fuka, dgFukaRirekiFukaRireki_Row> to_dgFukaRireki_Row() {

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

    private static Kiwarigaku findKiwarigaku(Fuka model) {
        Optional<Kiwarigaku> amountoid = new KiwarigakuManager().load期割額(model.get調定年度(), model.get賦課年度(), model.get通知書番号(), model.get履歴番号());

        return amountoid.orElseThrow(
                ExceptionSuppliers.systemException(UrErrorMessages.対象データなし.getMessage().evaluate()));
    }
}
