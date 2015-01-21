/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka;

import jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbz.business.HokenryoDankai;
import jp.co.ndensan.reams.db.dbz.business.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbz.business.viewstate.MaeRirekiKey;
import jp.co.ndensan.reams.db.dbz.definition.util.function.ExceptionSuppliers;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.IViewStateValue;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStates;
import jp.co.ndensan.reams.db.dbz.model.fuka.FukaModel;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.model.FukaTaishoshaKey;
import jp.co.ndensan.reams.db.dbz.model.fuka.ChoshuHohoModel;
import jp.co.ndensan.reams.db.dbz.realservice.ChoshuHohoFinder;
import jp.co.ndensan.reams.db.dbz.realservice.FukaManager;
import jp.co.ndensan.reams.db.dbz.realservice.HokenryoDankaiManager;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
    public static FukaTaishoshaKey getFukaTaishoshaKeyInViewState() {

        IViewStateValue<FukaTaishoshaKey> value = ViewStates.access().valueAssignedTo(ViewStateKey.賦課対象者, FukaTaishoshaKey.class);
        IOptional<FukaTaishoshaKey> keyoid = value.tryToGet();

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
        IOptional<FukaShokaiKey> keyoid = value.tryToGet();

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
        IOptional<MaeRirekiKey> keyoid = value.tryToGet();

        if (keyoid.isPresent()) {
            return keyoid.get();
        }

        FukaShokaiKey fukaKey = getFukaShokaiKeyInViewState();
        FukaNendo 前年度 = new FukaNendo(fukaKey.get賦課年度().value().minusYear(1));

        IOptional<FukaModel> modeloid = new FukaManager().find賦課直近(前年度, fukaKey.get被保険者番号(), fukaKey.get処理日時());
        if (!modeloid.isPresent()) {
            throw new SystemException(DbbErrorMessages.比較対象データなし.getMessage().evaluate());
        }

        FukaModel 前年度賦課モデル = modeloid.get();
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
    public static FukaModel getFukaModelByFukaShokaiKey() {

        FukaShokaiKey key = getFukaShokaiKeyInViewState();

        IOptional<FukaModel> modeloid = new FukaManager().find賦課(
                key.get調定年度(), key.get賦課年度(), key.get通知書番号(), key.get処理日時());

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
    public static FukaModel getFukaModelByMaeRirekiKey() {

        MaeRirekiKey key = getMaeRirekiKeyInViewState();

        IOptional<FukaModel> modeloid = new FukaManager().find賦課(
                key.get調定年度(), key.get賦課年度(), key.get通知書番号(), key.get処理日時());

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
    public static ChoshuHohoModel getChoshuHohoModelByFukaShokaiKey() {

        FukaShokaiKey key = getFukaShokaiKeyInViewState();

        IOptional<ChoshuHohoModel> modeloid = new ChoshuHohoFinder().find徴収方法(key.get賦課年度(), key.get被保険者番号());

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
    public static HokenryoDankai findHokenryoDankai(FukaNendo fukaNendo, LasdecCode lasdecCode, RString hokenryoDankai) {
        IOptional<HokenryoDankai> rankoid = new HokenryoDankaiManager().get保険料段階(fukaNendo, lasdecCode, hokenryoDankai);

        return rankoid.orElseThrow(
                ExceptionSuppliers.systemException(UrErrorMessages.対象データなし.getMessage().evaluate()));
    }

    /**
     * 前年度の保険料段階クラスを取得します。
     *
     * @param model 賦課モデル
     * @return 前年度の保険料段階クラス
     */
    public static IOptional<HokenryoDankai> findZennendoHokenryoDankai(FukaModel model) {
        FukaNendo 前年度 = new FukaNendo(model.get賦課年度().value().minusYear(1));

        IOptional<FukaModel> modeloid = new FukaManager().find賦課直近(前年度, model.get被保険者番号(), model.get処理日時());
        if (!modeloid.isPresent()) {
            return DbOptional.empty();
        }

        FukaModel 前年度賦課モデル = modeloid.get();
        IOptional<HokenryoDankai> rankoid = new HokenryoDankaiManager().get保険料段階(
                前年度賦課モデル.get賦課年度(), 前年度賦課モデル.get賦課市町村コード(), 前年度賦課モデル.get保険料段階());

        if (rankoid.isPresent()) {
            return rankoid;
        }
        return DbOptional.empty();
    }
}
