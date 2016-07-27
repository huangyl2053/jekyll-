/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka;

import jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbb.business.core.viewstate.MaeRirekiKey;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.service.core.basic.ChoshuHohoManager;
import jp.co.ndensan.reams.db.dbb.service.core.basic.FukaManager;
import jp.co.ndensan.reams.db.dbb.service.core.basic.HokenryoDankaiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.fuka.SanteiState;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.definition.core.util.function.ExceptionSuppliers;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 賦課照会の各コントローラで共通的に使われる機能をまとめたクラスです。<br/>
 * 主にviewStateからのキーの取得やモデルの取得をします。
 *
 * @author N3317 塚田 萌
 */
public final class FukaShokaiController {

    private static final RString SERIAL_NUMBER1 = new RString("0001");

    /**
     * プライベートコンストラクタです。
     */
    private FukaShokaiController() {

    }

    /**
     * viewStateに保持している賦課対象者キーを取得します。
     *
     * @return 賦課対象者キー
     */
    public static FukaTaishoshaKey getFukaTaishoshaKeyInViewState() {
        return ViewStateHolder.get(ViewStateKey.賦課対象者, FukaTaishoshaKey.class);
    }

    /**
     * 賦課照会キーを取得します。
     *
     * @return 賦課照会キー
     */
    public static FukaShokaiKey getFukaShokaiKeyInViewState() {
        return ViewStateHolder.get(ViewStateKeys.賦課照会キー, FukaShokaiKey.class);
    }

    public static void clearFukaTaishoshaKeyAndFukaShokaiKey() {
        ViewStateHolder.remove(ViewStateKey.賦課対象者.toString());
        ViewStateHolder.remove(ViewStateKeys.賦課照会キー.toString());
    }

    /**
     * 履歴比較を行うときの前履歴のキーを取得します。<br/>
     * 前履歴キーがないときは前年度の直近データのキーをセットし、返します。
     *
     * @return 前履歴キー
     */
    public static MaeRirekiKey getMaeRirekiKeyInViewState() {

        MaeRirekiKey maeRirekiKey = ViewStateHolder.get(ViewStateKeys.前履歴キー, MaeRirekiKey.class);
        if (maeRirekiKey != null) {
            return maeRirekiKey;
        }

        FukaShokaiKey fukaKey = getFukaShokaiKeyInViewState();
        FlexibleYear 前年度 = fukaKey.get賦課年度().minusYear(1);

        Optional<Fuka> modeloid = Optional.of(new FukaManager().get介護賦課(fukaKey.get調定年度(), 前年度, fukaKey.get通知書番号(), fukaKey.get履歴番号()));
        if (!modeloid.isPresent()) {
            throw new SystemException(DbbErrorMessages.比較対象データなし.getMessage().evaluate());
        }

        Fuka 前年度賦課モデル = modeloid.get();
        MaeRirekiKey maeKey = ViewStateKeyCreator.createMaeRirekiKey(前年度賦課モデル, fukaKey.get氏名());
        ViewStateHolder.put(ViewStateKeys.前履歴キー, maeKey);

        return maeKey;
    }

    /**
     * viewStateに保持されている賦課照会キーを使って賦課モデルを取得します。
     *
     * @return 賦課モデル
     */
    public static Fuka getFukaModelByFukaShokaiKey() {

        // UIデザイナの読み込み順を直すまでの暫定対応
        FlexibleYear 調定年度;
        FlexibleYear 賦課年度;
        TsuchishoNo 通知書番号;
        int 履歴番号;

        FukaShokaiKey key = getFukaShokaiKeyInViewState();

        if (key == null
            || key.get賦課年度() == null || key.get賦課年度().isEmpty()
            || key.get調定年度() == null || key.get調定年度().isEmpty()
            || key.get通知書番号() == null || key.get通知書番号().isEmpty()) {
            FukaTaishoshaKey taishoshaKey = getFukaTaishoshaKeyInViewState();
            調定年度 = taishoshaKey.get調定年度();
            賦課年度 = taishoshaKey.get賦課年度();
            通知書番号 = taishoshaKey.get通知書番号();
            履歴番号 = 1;
        } else {
            調定年度 = key.get調定年度();
            賦課年度 = key.get賦課年度();
            通知書番号 = key.get通知書番号();
            履歴番号 = key.get履歴番号();
        }

        Optional<Fuka> modeloid = Optional.ofNullable(new FukaManager().get介護賦課(
                調定年度, 賦課年度, 通知書番号, 履歴番号));

//        Optional<Fuka> modeloid = Optional.of(new FukaManager().get介護賦課(
//                key.get調定年度(), key.get賦課年度(), key.get通知書番号(), key.get履歴番号()));
//        if (!modeloid.isPresent()) {
//            throw new SystemException(UrErrorMessages.対象データなし.getMessage().evaluate());
//        }
//        return modeloid.get();
        return modeloid.orElseThrow(ExceptionSuppliers
                .applicationException(UrErrorMessages.対象データなし.getMessage().evaluate())
        );
    }

    /**
     * viewStateに保持されている前履歴キーを使って前履歴の賦課モデルを取得します。
     *
     * @return 前履歴の賦課モデル
     */
    public static Fuka getFukaModelByMaeRirekiKey() {

        MaeRirekiKey key = getMaeRirekiKeyInViewState();

        Optional<Fuka> modeloid = Optional.of(new FukaManager().get介護賦課(
                key.get調定年度(), key.get賦課年度(), key.get通知書番号(), key.get履歴番号()));

        if (!modeloid.isPresent()) {
            throw new SystemException(UrErrorMessages.対象データなし.getMessage().evaluate());
        }

        return modeloid.get();
    }

    /**
     * viewStateに保持されている賦課照会キーを使って徴収方法モデルを取得します。
     *
     * @return 徴収方法モデル
     */
    public static ChoshuHoho getChoshuHohoModelByFukaShokaiKey() {

        FukaShokaiKey key = getFukaShokaiKeyInViewState();

        Optional<ChoshuHoho> modeloid = Optional.of(new ChoshuHohoManager().get介護徴収方法(key.get賦課年度(), key.get被保険者番号(), key.get履歴番号()));

        if (!modeloid.isPresent()) {
            throw new SystemException(UrErrorMessages.対象データなし.getMessage().evaluate());
        }

        return modeloid.get();
    }

    /**
     * viewStateに保持されている賦課照会キーを使って徴収方法モデルを取得します。
     *
     * @return 徴収方法モデル
     */
    public static ChoshuHoho getChoshuHohoModelByFukaShokaiKeyWithoutRirekiNo() {

        FukaShokaiKey key = getFukaShokaiKeyInViewState();

        Optional<ChoshuHoho> modeloid = Optional.of(new ChoshuHohoManager().get介護徴収方法(key.get賦課年度(), key.get被保険者番号()));

        if (!modeloid.isPresent()) {
            throw new SystemException(UrErrorMessages.対象データなし.getMessage().evaluate());
        }

        return modeloid.get();
    }

    /**
     * 保険料段階クラスを取得します。
     *
     * @param 賦課年度 賦課年度
     * @param 段階インデックス 段階インデックス
     * @param ランク区分 ランク区分
     * @return 保険料段階クラス
     */
    public static HokenryoDankai findHokenryoDankai(FlexibleYear 賦課年度, RString 段階インデックス, RString ランク区分) {
        Optional<HokenryoDankai> rankoid = new HokenryoDankaiManager().get保険料段階(賦課年度,
                段階インデックス,
                ランク区分);

        return rankoid.orElseThrow(
                ExceptionSuppliers.systemException(UrErrorMessages.対象データなし.getMessage().evaluate()));
    }

    /**
     * 保険料段階クラスを取得します。
     *
     * @param 賦課年度 賦課年度
     * @param 段階区分 段階区分
     * @return 保険料段階クラス
     */
    public static HokenryoDankai findHokenryoDankai(FlexibleYear 賦課年度, RString 段階区分) {
        Optional<HokenryoDankai> rankoid = new HokenryoDankaiManager().get保険料段階(賦課年度,
                段階区分);

        if (rankoid.isPresent()) {
            return rankoid.get();

        }
        return null;
    }

    /**
     * 前年度の保険料段階クラスを取得します。
     *
     * @param fuka 賦課モデル
     * @return 前年度の保険料段階クラス
     */
    public static Optional<HokenryoDankai> findZennendoHokenryoDankai(Fuka fuka) {
        FlexibleYear 前年度 = fuka.get賦課年度().minusYear(1);

        Optional<Fuka> modeloid = Optional.ofNullable(new FukaManager().get介護賦課_賦課年度最新(前年度, fuka.get通知書番号()));
        if (!modeloid.isPresent()) {
            return Optional.empty();
        }

        Fuka 前年度賦課 = modeloid.get();
        Optional<HokenryoDankai> rankoid = new HokenryoDankaiManager().get保険料段階(
                前年度賦課.get賦課年度(), 前年度賦課.get保険料段階());

        if (rankoid.isPresent()) {
            return rankoid;
        }
        return Optional.empty();
    }

    /**
     * 前年度の保険料段階クラスを取得します。
     *
     * @param fuka 賦課モデル
     * @return 前年度の保険料段階クラス
     */
    public static Optional<Fuka> findZennendoFukaModel(Fuka fuka) {
        FlexibleYear 前年度 = fuka.get賦課年度().minusYear(1);

        Optional<Fuka> modeloid = Optional.ofNullable(new FukaManager().get介護賦課_賦課年度最新(前年度, fuka.get通知書番号()));
        if (!modeloid.isPresent()) {
            return Optional.empty();
        }

        return modeloid;
    }

    /**
     * 調定日時と処理日時管理マスタの対象終了日時を比較して算定状態を判定します。<br/>
     * 調定日時 ＞　対象終了日時　ならば本算定、それ以外は仮算定です。（対象終了日時が入ってないときも仮算定）<br/>
     * 処理名が本算定賦課の場合は連番・枝番が１つだけです。
     *
     * @param fuka 介護賦課
     * @return 算定状態
     */
    public static SanteiState judgeSanteiState(Fuka fuka) {
        Optional<ShoriDateKanri> modeloid = Optional.ofNullable(new ShoriDateKanriManager().get処理日付管理マスタ(
                SubGyomuCode.DBB介護賦課, ShoriName.本算定賦課.get名称(),
                SERIAL_NUMBER1, fuka.get賦課年度(), SERIAL_NUMBER1));

        if (!modeloid.isPresent()) {
//            throw new SystemException(UrErrorMessages.対象データなし.getMessage().evaluate());
            return SanteiState.仮算定;
        }

        RDateTime 基準日時;
        if (modeloid.get().get基準日時() == null || modeloid.get().get基準日時().isEmpty()) {
            基準日時 = RDateTime.MAX;
        } else {
            基準日時 = modeloid.get().get基準日時().getRDateTime();
        }

        RDateTime 調定日時;
        if (fuka.get調定日時() == null || fuka.get調定日時().isEmpty()) {
            調定日時 = RDateTime.MAX;
        } else {
            調定日時 = fuka.get調定日時().getRDateTime();
        }

        if (調定日時.isAfter(基準日時) || 調定日時.isEqual(基準日時)) {
            return SanteiState.本算定;
        }

        return SanteiState.仮算定;
    }
}
