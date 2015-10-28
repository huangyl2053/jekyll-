/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.fuka;

//import jp.co.ndensan.reams.db.dbz.business.viewstate.FukaShokaiKey;
//import jp.co.ndensan.reams.db.dbz.business.viewstate.MaeRirekiKey;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.business.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbb.business.viewstate.MaeRirekiKey;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.fuka.SanteiState;
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
                checkSanteiState(model),
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
                checkSanteiState(model),
                name);
        return key;
    }

    /**
     * 処理日時と処理日時管理マスタの対象終了日時を比較して算定状態を判定します。<br/>
     * 処理日時 ＞　対象終了日時　ならば本算定、それ以外は仮算定です。（対象終了日時が入ってないときも仮算定）<br/>
     * 処理名が本算定賦課の場合は連番・枝番が１つだけです。
     *
     * @param fukaModel 賦課モデル
     * @return 算定状態
     */
    private static SanteiState checkSanteiState(Fuka fukaModel) {
//        final RString SERIAL_NUMBER = new RString("0001");

//        Optional<ShoriDateModel> modeloid = new ShoriDateFinder().find処理日付(
//                SubGyomuCode.DBB介護賦課, fukaModel.get賦課市町村コード(), ShoriName.本算定賦課,
//                SERIAL_NUMBER, fukaModel.get賦課年度().value(), SERIAL_NUMBER);
//
//        if (!modeloid.isPresent()) {
//            throw new SystemException(UrErrorMessages.対象データなし.getMessage().evaluate());
//        }
//        RDateTime 対象終了日時 = modeloid.get().get対象終了日時().getRDateTime();
//        RDateTime 処理日時 = fukaModel.get処理日時();
//
//        if (処理日時.isAfter(対象終了日時)) {
//            return SanteiState.本算定;
//        }
//
        return SanteiState.仮算定;
    }

    private static boolean is減免あり(Fuka model) {
        return model.get減免額().compareTo(Decimal.ZERO) > 0;
    }

    private static boolean is徴収猶予あり(Fuka fukaModel) {
//        Optional<ChoshuYuyoRelateModel> modeloid = new ChoshuYuyoFinder().find徴収猶予(
//                fukaModel.get調定年度(), fukaModel.get賦課年度(),
//                fukaModel.get通知書番号(), fukaModel.get処理日時(), GemmenChoshuYuyoStateKubun.決定_承認);
//
//        return modeloid.isPresent();
        return true;
    }
}
