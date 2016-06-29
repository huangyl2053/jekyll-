/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.fuka;

import jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbb.business.core.viewstate.MaeRirekiKey;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.service.core.basic.FukaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.HokenryoDankai;
import jp.co.ndensan.reams.db.dbz.definition.core.util.function.ExceptionSuppliers;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.IViewStateValue;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStates;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

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
    public static FukaShokaiKey getFukaTaishoshaKeyInViewState() {

        IViewStateValue<FukaShokaiKey> value = ViewStates.access().valueAssignedTo(ViewStateKey.賦課対象者, FukaShokaiKey.class);
        Optional<FukaShokaiKey> keyoid = value.tryToGet();

        if (!keyoid.isPresent()) {
            throw new SystemException(UrErrorMessages.存在しない.getMessage().replace("賦課対象者キーが").evaluate());
        }

        return keyoid.get();
    }

    /**
     * 賦課照会キーを取得します。
     *
     * @return 賦課照会キー
     */
    public static FukaShokaiKey getFukaShokaiKeyInViewState() {

        IViewStateValue<FukaShokaiKey> value = ViewStates.access().valueAssignedToA(FukaShokaiKey.class);
        Optional<FukaShokaiKey> keyoid = value.tryToGet();

        if (!keyoid.isPresent()) {
            throw new SystemException(UrErrorMessages.存在しない.getMessage().replace("ViewStateのキーが").evaluate());
        }

        return keyoid.get();
    }

    /**
     * 履歴比較を行うときの前履歴のキーを取得します。<br/>
     * 前履歴キーがないときは前年度の直近データのキーをセットし、返します。
     *
     * @return 前履歴キー
     */
    public static MaeRirekiKey getMaeRirekiKeyInViewState() {

        IViewStateValue<MaeRirekiKey> value = ViewStates.access().valueAssignedToA(MaeRirekiKey.class);
        Optional<MaeRirekiKey> keyoid = value.tryToGet();

        if (keyoid.isPresent()) {
            return keyoid.get();
        }

        FukaShokaiKey fukaKey = getFukaShokaiKeyInViewState();
        FukaNendo 前年度 = new FukaNendo(fukaKey.get賦課年度().minusYear(1));

//        Optional<Fuka> modeloid = Optional.of(new FukaManager().get介護賦課(前年度, fukaKey.get被保険者番号(), fukaKey.get履歴番号()));
        Optional<Fuka> modeloid = Optional.of(new FukaManager().get介護賦課(前年度.value(), FlexibleYear.EMPTY, TsuchishoNo.EMPTY, fukaKey.get履歴番号()));
        if (!modeloid.isPresent()) {
            throw new SystemException(DbbErrorMessages.比較対象データなし.getMessage().evaluate());
        }

        Fuka 前年度賦課モデル = modeloid.get();
        IViewStateValue<MaeRirekiKey> maeRirekiValue = ViewStates.access().valueAssignedToA(MaeRirekiKey.class);
        MaeRirekiKey maeKey = ViewStateKeyCreator.createMaeRirekiKey(前年度賦課モデル, fukaKey.get氏名());
        maeRirekiValue.put(maeKey);

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

//        FukaShokaiKey key = getFukaShokaiKeyInViewState();
//        Optional<ChoshuHoho> modeloid = new ChoshuHohoFinder().find徴収方法(key.get賦課年度(), key.get被保険者番号());
        Optional<ChoshuHoho> modeloid = Optional.ofNullable(null);

        if (!modeloid.isPresent()) {
            throw new SystemException(UrErrorMessages.対象データなし.getMessage().evaluate());
        }

        return modeloid.get();
    }

    /**
     * 保険料段階クラスを取得します。
     *
     * @param fukaNendo 賦課年度
     * @param lasdecCode 市町村コード
     * @param hokenryoDankai 保険料段階
     * @return 保険料段階クラス
     */
    public static HokenryoDankai findHokenryoDankai(FlexibleYear fukaNendo, LasdecCode lasdecCode, RString hokenryoDankai) {
//        Optional<HokenryoDankai> rankoid = new HokenryoDankaiManager().get保険料段階(fukaNendo, lasdecCode, hokenryoDankai);
        Optional<HokenryoDankai> rankoid = Optional.ofNullable(null);

        return rankoid.orElseThrow(
                ExceptionSuppliers.systemException(UrErrorMessages.対象データなし.getMessage().evaluate()));
    }

    /**
     * 前年度の保険料段階クラスを取得します。
     *
     * @param model 賦課モデル
     * @return 前年度の保険料段階クラス
     */
    public static Optional<HokenryoDankai> findZennendoHokenryoDankai(Fuka model) {
        FukaNendo 前年度 = new FukaNendo(model.get賦課年度().minusYear(1));

//        Optional<Fuka> modeloid = new FukaManager().get介護賦課(前年度, model.get被保険者番号(), model.get履歴番号());
        Optional<Fuka> modeloid = Optional.of(new FukaManager().get介護賦課(前年度.value(), FlexibleYear.EMPTY, TsuchishoNo.EMPTY, model.get履歴番号()));
        if (!modeloid.isPresent()) {
            return Optional.empty();
        }

//        Fuka 前年度賦課モデル = modeloid.get();
        Optional<HokenryoDankai> rankoid = Optional.ofNullable(null);
//        Optional<HokenryoDankai> rankoid = new HokenryoDankaiManager().get保険料段階(
//                前年度賦課モデル.get賦課年度(), 前年度賦課モデル.get賦課市町村コード(), 前年度賦課モデル.get保険料段階());

        if (rankoid.isPresent()) {
            return rankoid;
        }
        return Optional.empty();
    }
}
