/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320005.input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.service.core.basic.FukaManager;
import jp.co.ndensan.reams.db.dbz.definition.core.fuka.SanteiState;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;

/**
 * 賦課比較の対象を扱います。
 */
public class FukaHikakuTargets {

    private final List<Fuka> fukaElements;
    private final FukaHikakuSituation situation;

    /**
     * {@link FukaHikakuInput}から比較対象を取得する{@link FukaHikakuTargets}を生成します。
     *
     * @param fukaHikakuInput {@link FukaHikakuInput}
     */
    public FukaHikakuTargets(FukaHikakuInput fukaHikakuInput) {
        this.fukaElements = find比較対象s(fukaHikakuInput);
        this.situation = judgeSituation(this.fukaElements);
    }

    private static Optional<Fuka> findFukaBy(FukaManager manager, FukaShokaiKey key) {
        return Optional.of(manager.get介護賦課(key.get調定年度(), key.get賦課年度(), key.get通知書番号(), key.get履歴番号()));
    }

 //   private static Optional<Fuka> findFukaBy任意比較(FukaManager manager, FukaShokaiKey key) {
//        return manager.get介護賦課For任意対象比較(key.get調定年度(), key.get賦課年度(), key.get被保険者番号(), key.get更正日時().getRDateTime());
//        return manager.get介護賦課For任意対象比較(key.get調定年度(), key.get賦課年度(), key.get通知書番号(), key.get履歴番号());
//    }
    private static List<Fuka> find比較対象s(FukaHikakuInput fukaHikakuInput) {
        FukaManager manager = new FukaManager();

        Optional<Fuka> fuka1;
//        switch (fukaHikakuInput.getMode()) {
//            case 対象指定:
//                fuka1 = findFukaBy任意比較(manager, fukaHikakuInput.getFukaShokaiKey(0));
//                break;
//            default:
        fuka1 = findFukaBy(manager, fukaHikakuInput.getFukaShokaiKey(0));
//                break;
//        }

        if (!fuka1.isPresent()) {
            return Collections.emptyList();
        }
        List<Fuka> list = new ArrayList<>();
        list.add(fuka1.get());
//        switch (fukaHikakuInput.getMode()) {
//            case 前年度最終:
//                Optional<Fuka> before = manager
//                        .find前年度賦課履歴(fuka1.get().get賦課年度(), fuka1.get().get被保険者番号())
//                        .getグループ化賦課履歴()
//                        .findFirst();
//                if (before.isPresent()) {
//                    list.add(before.get());
//                }
//                break;
//            case 対象指定:
//                Optional<Fuka> fuka2 = findFukaBy任意比較(manager, fukaHikakuInput.getFukaShokaiKey(1));
//                if (fuka2.isPresent()) {
//                    list.add(fuka2.get());
//                }
//                break;
//            default:
        Optional<Fuka> fuka3 = findFukaBy(manager, fukaHikakuInput.getFukaShokaiKey(1));
        if (fuka3.isPresent()) {
            list.add(fuka3.get());
        }
//        }
        return list;
    }

    /**
     * 比較対象の{@link Fuka}を返します。<br />
     * 引数に0～{@link #size() size()}-1 の範囲で数値を指定することで、そのインデックスの{@link Fuka}を返します。
     *
     * @param index index
     * @return 介護賦課を管理するクラス
     */
    public Fuka get(int index) {
        return this.fukaElements.get(index);
    }

    /**
     * 比較対象の個数を返します。
     *
     * @return 比較対象の個数
     */
    public int size() {
        return this.fukaElements.size();
    }

    private static FukaHikakuSituation judgeSituation(List<Fuka> list) {
        if (list.size() <= 1) {
            return FukaHikakuSituation.比較不可;
        }
        if (list.size() == 2) {
            SanteiState state1 = FukaShokaiController.judgeSanteiState(list.get(0));
            SanteiState state2 = FukaShokaiController.judgeSanteiState(list.get(1));
            if (state1 == SanteiState.仮算定) {
                return state2 == SanteiState.仮算定 ? FukaHikakuSituation.仮算定And仮算定 : FukaHikakuSituation.仮算定And本算定;
            } else {
                return state2 == SanteiState.仮算定 ? FukaHikakuSituation.本算定And仮算定 : FukaHikakuSituation.本算定And本算定;
            }
        }
        throw new ApplicationException("");
    }

    /**
     * 賦課比較の種類を返します。
     *
     * @return 賦課比較の種類です。
     */
    public FukaHikakuSituation getSituation() {
        return this.situation;
    }

    /**
     * canCompareを返します。
     *
     * @return canCompare
     */
    public boolean canCompare() {
        return this.situation != FukaHikakuSituation.比較不可;
    }
}
