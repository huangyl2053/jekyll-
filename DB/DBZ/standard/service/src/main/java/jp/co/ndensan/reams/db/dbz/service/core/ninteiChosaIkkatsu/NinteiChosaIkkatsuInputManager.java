/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.ninteiChosaIkkatsu;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteiChosaIkkatsu.INinteiChosaIkkatsuInputMapper;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 認定調査スケジュール登録11を管理するクラスです。
 */
public class NinteiChosaIkkatsuInputManager {

    private final INinteiChosaIkkatsuInputMapper mapper;

    /**
     * コンストラクタです。
     */
    public NinteiChosaIkkatsuInputManager() {
        mapper = InstanceProvider.create(INinteiChosaIkkatsuInputMapper.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JushotiTokureiFinder}のインスタンスを返します。
     *
     * @return JushotiTokureiFinder
     */
    public static NinteiChosaIkkatsuInputManager createInstance() {
        return InstanceProvider.create(NinteiChosaIkkatsuInputManager.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5221NinteichosaScheduleDac}
     */
    NinteiChosaIkkatsuInputManager(INinteiChosaIkkatsuInputMapper mapper) {
        this.mapper = mapper;
    }

    /**
     *
     * @param 認定調査予定年月日
     * @param 認定調査予定開始時間
     * @param 認定調査予定終了時間
     * @param 認定調査時間枠
     * @param 調査地区コード
     * @param 認定調査委託先コード
     * @param 認定調査員コード
     * @param 市町村コード
     * @param 設定年月
     * @param checked
     * @return
     */
    public RString do認定調査予定情報更新処理(FlexibleDate 認定調査予定年月日, RString 認定調査予定開始時間, RString 認定調査予定終了時間,
            Code 認定調査時間枠, Code 調査地区コード, RString 認定調査委託先コード, RString 認定調査員コード, LasdecCode 市町村コード,
            FlexibleDate 設定年月, boolean checked) {

        requireNonNull(認定調査予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定年月日"));
        requireNonNull(認定調査予定開始時間, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定開始時間"));
        requireNonNull(認定調査予定終了時間, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定終了時間"));
        requireNonNull(認定調査時間枠, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査時間枠"));
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(設定年月, UrSystemErrorMessages.値がnull.getReplacedMessage("設定年月"));

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        FlexibleDate 月開始日 = (設定年月);
        FlexibleDate 月終了日 = (設定年月);
        for (int i = 0; 認定調査予定年月日.isAfter(月開始日) && 認定調査予定年月日.isBefore(月終了日); i++) {
            int count = mapper.getCount(認定調査予定年月日, 調査地区コード, 認定調査委託先コード, 認定調査員コード, 市町村コード);
            if (count > 0 && checked) {
                mapper.getDelete(認定調査予定年月日, 調査地区コード, 認定調査委託先コード, 認定調査員コード, 市町村コード);
                mapper.getInsert(認定調査予定年月日, 認定調査予定開始時間, 認定調査予定終了時間, 認定調査時間枠, 調査地区コード,
                        認定調査委託先コード, 認定調査員コード, 市町村コード);
            }
        }
//
//        /**
//         * 月開始日
//         *
//         * @param date
//         * @return
//         * @throws ParseException
//         */
//        FlexibleDate getMinMonthDate(FlexibleDate date){
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(dateFormat.parse(date));
//            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
//            return dateFormat.format(calendar.getTime());
//        }
//
//        /**
//         * 月終了日
//         *
//         * @param date
//         * @return
//         * @throws ParseException
//         */
//        String getMaxMonthDate (String date) throws ParseException {
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(dateFormat.parse(date));
//            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//            return dateFormat.format(calendar.getTime());
//        }

        return null;
    }

}
