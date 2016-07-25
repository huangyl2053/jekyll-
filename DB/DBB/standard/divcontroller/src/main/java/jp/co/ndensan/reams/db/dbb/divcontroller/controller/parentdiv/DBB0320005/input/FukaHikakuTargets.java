/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320005.input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey;
import static jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey.Items.調定年度;
import static jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey.Items.賦課年度;
import static jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey.Items.通知書番号;
import static jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey.Items.履歴番号;
import static jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey.Items.被保険者番号;
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
        if (key.hasAll(調定年度, 賦課年度, 通知書番号, 履歴番号)) {
            return Optional.ofNullable(manager.get介護賦課(key.get調定年度(), key.get賦課年度(), key.get通知書番号(), key.get履歴番号()));
        }
        if (key.hasAll(賦課年度, 被保険者番号)) {
            return Optional.ofNullable(manager.get賦課年度最新賦課From被保険者番号(key.get賦課年度(), key.get被保険者番号()));
        }
        return Optional.empty();
    }

    private static List<Fuka> find比較対象s(FukaHikakuInput fukaHikakuInput) {
        FukaManager manager = new FukaManager();

        Optional<Fuka> fuka1 = findFukaBy(manager, fukaHikakuInput.getFukaShokaiKey(0));
        if (!fuka1.isPresent()) {
            return Collections.emptyList();
        }

        List<Fuka> list = new ArrayList<>();
        list.add(fuka1.get());

        Optional<Fuka> fuka2 = findFukaBy(manager, fukaHikakuInput.getFukaShokaiKey(1));
        if (fuka2.isPresent()) {
            list.add(fuka2.get());
        }
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
