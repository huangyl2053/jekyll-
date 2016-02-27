/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.ninteiChosaIkkatsu;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaSchedule;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaScheduleBuilder;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5221NinteichosaScheduleDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteiChosaIkkatsu.INinteiChosaIkkatsuInputMapper;
import jp.co.ndensan.reams.db.dbz.service.core.jushotitokurei.JushotiTokureiFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 認定調査スケジュール登録11を管理するクラスです。
 */
public class NinteiChosaIkkatsuInputManager {

    private static final RString 日付_0 = new RString("0");
    private final DbT5221NinteichosaScheduleDac dac;
    private final INinteiChosaIkkatsuInputMapper mapper;

    /**
     * コンストラクタです。
     */
    public NinteiChosaIkkatsuInputManager() {
        mapper = InstanceProvider.create(INinteiChosaIkkatsuInputMapper.class);
        this.dac = InstanceProvider.create(DbT5221NinteichosaScheduleDac.class);
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
    NinteiChosaIkkatsuInputManager(INinteiChosaIkkatsuInputMapper mapper, DbT5221NinteichosaScheduleDac dac) {
        this.mapper = mapper;
        this.dac = dac;
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
        return null;
    }

    /**
     * @param chkUpdate chkUpdate
     * @param 曜日 曜日
     * @param 認定調査スケジュール情報 認定調査スケジュール情報
     */
    public void get認定調査スケジュール情報(boolean chkUpdate, List<RString> 曜日, List<NinteichosaSchedule> 認定調査スケジュール情報) {
        FlexibleDate 認定調査予定年月日;
        for (int i = 1; i <= 認定調査スケジュール情報.get(0).get認定調査予定年月日().getYearMonth().getLastDay(); i++) {
            if (i < 10) {
                StringBuilder a = new StringBuilder("");
                a.append(認定調査スケジュール情報.get(0).get認定調査予定年月日().toString());
                a.append(日付_0.toString());
                a.append(String.valueOf(i));
                認定調査予定年月日 = new FlexibleDate(new RString(a.toString()));
                this.doSelect(曜日, 認定調査予定年月日, 認定調査スケジュール情報, chkUpdate);
            } else {
                StringBuilder b = new StringBuilder("");
                b.append(認定調査スケジュール情報.get(0).get認定調査予定年月日().toString());
                b.append(String.valueOf(i));
                認定調査予定年月日 = new FlexibleDate(new RString(b.toString()));
                this.doSelect(曜日, 認定調査予定年月日, 認定調査スケジュール情報, chkUpdate);
            }
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

    private void doSelect(List<RString> 曜日, FlexibleDate 認定調査予定年月日, List<NinteichosaSchedule> 認定調査スケジュール情報,
            boolean chkUpdate) {
        int count;
        for (RString week : 曜日) {
            if (new RString(認定調査予定年月日.getDayOfWeek().getShortTerm()).equals(week)) {
                count = dac.getcount(認定調査予定年月日,
                        認定調査スケジュール情報.get(0).get調査地区コード(),
                        認定調査スケジュール情報.get(0).get認定調査委託先コード(),
                        認定調査スケジュール情報.get(0).get認定調査員コード(),
                        認定調査スケジュール情報.get(0).get市町村コード());
                if (count > 0 && !chkUpdate) {
                    do認定調査予定情報更新処理(認定調査予定年月日, 認定調査スケジュール情報, count);
                }
            }
        }
    }

    private void do認定調査予定情報更新処理(FlexibleDate 認定調査予定年月日, List<NinteichosaSchedule> 認定調査スケジュール情報, int count) {
        if (count > 0) {
            List<DbT5221NinteichosaScheduleEntity> 認定調査スケジュール情報List = dac.selectByYoteiYMD(認定調査予定年月日,
                    認定調査スケジュール情報.get(0).get調査地区コード(),
                    認定調査スケジュール情報.get(0).get認定調査委託先コード(),
                    認定調査スケジュール情報.get(0).get認定調査員コード(),
                    認定調査スケジュール情報.get(0).get市町村コード());
            for (DbT5221NinteichosaScheduleEntity entity : 認定調査スケジュール情報List) {
                entity.setState(EntityDataState.Deleted);
                dac.saveOrDelete(entity);
            }
        }
        for (NinteichosaSchedule ninteichosaSchedule : 認定調査スケジュール情報) {
            NinteichosaScheduleBuilder builder = ninteichosaSchedule.createBuilderForEdit();
            builder.set認定調査予定年月日(認定調査予定年月日);
            ninteichosaSchedule = builder.build();
            dac.save(ninteichosaSchedule.toEntity());
        }
    }
}
