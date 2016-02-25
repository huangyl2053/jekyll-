/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka;

import jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbb.business.viewstate.MaeRirekiKey;
import jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.DbbViewStateKey;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.service.core.basic.ChoshuHohoManager;
import jp.co.ndensan.reams.db.dbb.service.core.basic.FukaManager;
import jp.co.ndensan.reams.db.dbb.service.core.basic.HokenryoDankaiManager;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShoriName;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.fuka.SanteiState;
import jp.co.ndensan.reams.db.dbz.definition.core.util.function.ExceptionSuppliers;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.DankaiIndex;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.RankKubun;
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

        FukaTaishoshaKey key = ViewStateHolder.get(ViewStateKey.賦課対象者, FukaTaishoshaKey.class);
        return key;
    }

    /**
     * 賦課照会キーを取得します。
     *
     * @return 賦課照会キー
     */
    public static FukaShokaiKey getFukaShokaiKeyInViewState() {

        FukaShokaiKey key = ViewStateHolder.get(DbbViewStateKey.FukaShokaiKey, FukaShokaiKey.class);
        return key;
    }

    /**
     * 履歴比較を行うときの前履歴のキーを取得します。<br/>
     * 前履歴キーがないときは前年度の直近データのキーをセットし、返します。
     *
     * @return 前履歴キー
     */
    public static MaeRirekiKey getMaeRirekiKeyInViewState() {

        MaeRirekiKey maeRirekiKey = ViewStateHolder.get(DbbViewStateKey.MaeRirekiKey, MaeRirekiKey.class);
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
        ViewStateHolder.put(DbbViewStateKey.MaeRirekiKey, maeKey);

        return maeKey;
    }

    /**
     * viewStateに保持されている賦課照会キーを使って賦課モデルを取得します。
     *
     * @return 賦課モデル
     */
    public static Fuka getFukaModelByFukaShokaiKey() {

        FukaShokaiKey key = getFukaShokaiKeyInViewState();

        Optional<Fuka> modeloid = Optional.of(new FukaManager().get介護賦課(
                key.get調定年度(), key.get賦課年度(), key.get通知書番号(), key.get履歴番号()));

        if (!modeloid.isPresent()) {
            throw new SystemException(UrErrorMessages.対象データなし.getMessage().evaluate());
        }

        return modeloid.get();
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

        Optional<Fuka> modeloid = Optional.of(new FukaManager().get介護賦課(前年度, fuka.get賦課年度(), fuka.get通知書番号(), fuka.get履歴番号()));
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
     * 調定日時と処理日時管理マスタの対象終了日時を比較して算定状態を判定します。<br/>
     * 調定日時 ＞　対象終了日時　ならば本算定、それ以外は仮算定です。（対象終了日時が入ってないときも仮算定）<br/>
     * 処理名が本算定賦課の場合は連番・枝番が１つだけです。
     *
     * @param fuka 介護賦課
     * @return 算定状態
     */
    public static SanteiState judgeSanteiState(Fuka fuka) {
        final RString SERIAL_NUMBER = new RString("0001");

        Optional<ShoriDateKanri> modeloid = Optional.ofNullable(new ShoriDateKanriManager().get処理日付管理マスタ(
                SubGyomuCode.DBB介護賦課, fuka.get賦課市町村コード(), ShoriName.本算定賦課.toRString(),
                SERIAL_NUMBER, fuka.get賦課年度(), SERIAL_NUMBER));

        if (!modeloid.isPresent()) {
            throw new SystemException(UrErrorMessages.対象データなし.getMessage().evaluate());
        }
        RDateTime 対象終了日時 = modeloid.get().get対象終了日時().getRDateTime();
        RDateTime 調定日時 = fuka.get調定日時().getRDateTime();

        if (調定日時.isAfter(対象終了日時)) {
            return SanteiState.本算定;
        }

        return SanteiState.仮算定;
    }
}
