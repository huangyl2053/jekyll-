/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9020001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001.FukaKijunTotalDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001.dgHokenryoDankai_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * システム管理（賦課基準）のバリデーションハンドラークラス。
 *
 * @reamsid_L DBB-1770-010 wangkanglei
 */
public class FukaKijunTotalValidationHandler {

    private final FukaKijunTotalDiv div;
    private static final RString メッセージKEY = new RString("保険料段階xxの基準所得金額");
    private static final RString 保険料段階マスタが不正 = new RString("賦課年度xx年の保険料段階マスタ");
    private static final RString 引数_XX = new RString("xx");
    private static final RString 保険料率KEY = new RString("保険料率");

    /**
     * コンストラクタです。
     *
     * @param div 仮算定異動賦課Div
     */
    public FukaKijunTotalValidationHandler(FukaKijunTotalDiv div) {
        this.div = div;
    }

    /**
     * グリッド内の基準所得金額の必須チェックのバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 基準所得金額の必須チェックValidate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<dgHokenryoDankai_Row> rowList = div.getShotokuDankai().getHokenryoDankaiFrom2015().getDgHokenryoDankai()
                .getDataSource();
        Decimal 保険料率;
        for (dgHokenryoDankai_Row row : rowList) {
            保険料率 = row.getTxtHokenryoRitsu().getValue();
            Decimal 基準所得金額 = row.getTxtKijunShotokuKingaku().getValue();
            boolean 状態 = row.getTxtKijunShotokuKingaku().isDisabled();
            RString 段階区分 = row.getDdlHokenryoDankai().getSelectedValue();
            if (保険料率 != null && !状態 && (基準所得金額 == null || 基準所得金額.equals(Decimal.ZERO))) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                        UrErrorMessages.入力値が不正_追加メッセージあり, メッセージKEY.toString().replace(引数_XX, 段階区分))));
            }
        }
        return validPairs;
    }

    /**
     * 保険料段階マスタが不正チェックのバリデーションチェックです。
     *
     * @param 賦課年度 FlexibleYear
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 保険料段階マスタが不正チェックValidate(FlexibleYear 賦課年度) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                UrErrorMessages.不正, 保険料段階マスタが不正.toString().replace(引数_XX, 賦課年度.toDateString()))));
        return validPairs;
    }

    /**
     * 保険料率が不正チェックのバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 保険料率が不正チェックValidate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                UrErrorMessages.入力値が不正_追加メッセージあり, 保険料率KEY.toString())));
        return validPairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
