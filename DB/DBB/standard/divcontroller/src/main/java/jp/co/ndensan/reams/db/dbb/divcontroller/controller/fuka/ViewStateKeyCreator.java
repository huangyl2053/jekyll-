/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka;

import jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuYuyo;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbb.business.core.viewstate.MaeRirekiKey;
import jp.co.ndensan.reams.db.dbb.definition.core.gemmenchoshuyuyo.GemmenChoshuYuyoStateKubun;
import jp.co.ndensan.reams.db.dbb.service.core.basic.ChoshuYuyoManager;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * viewStateに保持するキーを作成するクラスです。
 *
 * @author N3317 塚田 萌
 */
public final class ViewStateKeyCreator {

    /**
     * プライベートコンストラクタです。
     */
    private ViewStateKeyCreator() {

    }

    /**
     * 引数のモデルから賦課照会キーを作成します。
     *
     * @param model 賦課モデル
     * @param name 対象者氏名
     * @return 賦課照会キー
     */
    public static FukaShokaiKey createFukaShokaiKey(Fuka model, AtenaMeisho name) {
        //TODO 賦課期日は今回対象外の世帯員所得取得時に必要
        FlexibleDate 賦課期日 = FlexibleDate.MAX;

        FukaShokaiKey key = new FukaShokaiKey(
                model.get調定年度(),
                model.get賦課年度(),
                model.get通知書番号(),
                model.get履歴番号(),
                model.get被保険者番号(),
                賦課期日,
                model.get更正月(),
                model.get調定日時(),
                FukaShokaiController.judgeSanteiState(model),
                is減免あり(model),
                is徴収猶予あり(model),
                name);

        return key;
    }

    /**
     * 引数のモデルから前履歴キーを作成します。
     *
     * @param model 前履歴の賦課モデル
     * @param name 対象者氏名
     * @return 前履歴キー
     */
    public static MaeRirekiKey createMaeRirekiKey(Fuka model, AtenaMeisho name) {

        MaeRirekiKey key = new MaeRirekiKey(
                model.get調定年度(),
                model.get賦課年度(),
                model.get通知書番号(),
                model.get履歴番号(),
                FukaShokaiController.judgeSanteiState(model),
                name);
        return key;
    }

    private static boolean is減免あり(Fuka model) {
        return model.get減免額() != null && model.get減免額().compareTo(Decimal.ZERO) > 0;
    }

    private static boolean is徴収猶予あり(Fuka fuka) {
        Optional<ChoshuYuyo> modeloid = Optional.ofNullable(new ChoshuYuyoManager().get介護賦課徴収猶予(
                fuka.get調定年度(), fuka.get賦課年度(),
                fuka.get通知書番号(), fuka.get履歴番号()));

        if (!modeloid.isPresent()) {
            return false;
        }
        return modeloid.get().get徴収猶予状態区分().equals(GemmenChoshuYuyoStateKubun.決定_承認.getコード());
    }
}
