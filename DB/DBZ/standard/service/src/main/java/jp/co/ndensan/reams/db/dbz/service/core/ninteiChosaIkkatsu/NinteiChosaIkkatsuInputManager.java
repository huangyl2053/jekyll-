/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.ninteiChosaIkkatsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaSchedule;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaScheduleBuilder;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5221NinteichosaScheduleDac;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 認定調査スケジュール登録11を管理するクラスです。
 */
public class NinteiChosaIkkatsuInputManager {

    private final DbT5221NinteichosaScheduleDac dac;

    /**
     * コンストラクタです。
     *
     */
    public NinteiChosaIkkatsuInputManager() {
        this.dac = InstanceProvider.create(DbT5221NinteichosaScheduleDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     */
    NinteiChosaIkkatsuInputManager(DbT5221NinteichosaScheduleDac dac) {
        this.dac = dac;
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
     * 認定調査スケジュール情報取得します。
     *
     * @param chkUpdate chkUpdate
     * @param 曜日
     * @param 認定調査スケジュール情報
     */
    public void get認定調査スケジュール情報(boolean chkUpdate, List<RString> 曜日, List<NinteichosaSchedule> 認定調査スケジュール情報) {
        FlexibleDate 認定調査予定年月日;
        List<NinteichosaSchedule> 情報list = new ArrayList<>();
        int count;
        for (int i = 1; i <= 認定調査スケジュール情報.get(0).get認定調査予定年月日().getYearMonth().getLastDay(); i++) {
            if (i < 10) {
                StringBuilder a = new StringBuilder("");
                a.append(認定調査スケジュール情報.get(0).get認定調査予定年月日().toString());
                a.append("0");
                a.append(String.valueOf(i));
                認定調査予定年月日 = new FlexibleDate(new RString(a.toString()));
                for (RString week : 曜日) {
                    if (new RString(認定調査予定年月日.getDayOfWeek().getShortTerm()).equals(week)) {
                        count = dac.getcount(認定調査予定年月日, 認定調査スケジュール情報.get(0).get調査地区コード(), 認定調査スケジュール情報.get(0).get認定調査委託先コード(), 認定調査スケジュール情報.get(0).get認定調査員コード(), 認定調査スケジュール情報.get(0).get市町村コード());
                        for (NinteichosaSchedule ninteichosaSchedule : 認定調査スケジュール情報) {
                            ninteichosaSchedule = getEntity(認定調査予定年月日, ninteichosaSchedule);
                            情報list.add(ninteichosaSchedule);
                        }
                        do認定調査予定情報更新処理(認定調査予定年月日, 情報list, chkUpdate, count);
                    }
                }
            } else {
                StringBuilder b = new StringBuilder("");
                b.append(認定調査スケジュール情報.get(0).get認定調査予定年月日().toString());
                b.append(String.valueOf(i));
                認定調査予定年月日 = new FlexibleDate(new RString(b.toString()));
                for (RString week : 曜日) {
                    if (new RString(認定調査予定年月日.getDayOfWeek().getShortTerm()).equals(week)) {
                        count = dac.getcount(認定調査予定年月日, 認定調査スケジュール情報.get(0).get調査地区コード(), 認定調査スケジュール情報.get(0).get認定調査委託先コード(), 認定調査スケジュール情報.get(0).get認定調査員コード(), 認定調査スケジュール情報.get(0).get市町村コード());
                        for (NinteichosaSchedule ninteichosaSchedule : 認定調査スケジュール情報) {
                            ninteichosaSchedule = getEntity(認定調査予定年月日, ninteichosaSchedule);
                            情報list.add(ninteichosaSchedule);
                        }
                        do認定調査予定情報更新処理(認定調査予定年月日, 情報list, chkUpdate, count);
                    }
                }
            }
        }
    }

    private NinteichosaSchedule getEntity(FlexibleDate 認定調査予定年月日, NinteichosaSchedule ninteichosaSchedule) {
        NinteichosaScheduleBuilder builder = ninteichosaSchedule.createBuilderForEdit();
        builder.set認定調査予定年月日(認定調査予定年月日);
        builder.set予約状況(new Code("0"));
        builder.set予約可能フラグ(true);
        ninteichosaSchedule = builder.build();
        return ninteichosaSchedule;
    }

    private void do認定調査予定情報更新処理(FlexibleDate 認定調査予定年月日, List<NinteichosaSchedule> 認定調査スケジュール情報, boolean chkUpdate, int count) {
        if (!(count > 0 && !chkUpdate)) {
            if (count > 0) {
                List<DbT5221NinteichosaScheduleEntity> 認定調査スケジュール情報List = dac.selectByYoteiYMD(認定調査予定年月日, 認定調査スケジュール情報.get(0).get調査地区コード(), 認定調査スケジュール情報.get(0).get認定調査委託先コード(), 認定調査スケジュール情報.get(0).get認定調査員コード(), 認定調査スケジュール情報.get(0).get市町村コード());
                for (DbT5221NinteichosaScheduleEntity entity : 認定調査スケジュール情報List) {
                    entity.setState(EntityDataState.Deleted);
                    dac.saveOrDelete(entity);
                }
            }
            for (NinteichosaSchedule ninteichosaSchedule : 認定調査スケジュール情報) {
                ninteichosaSchedule.toEntity().setState(EntityDataState.Added);
                dac.save(ninteichosaSchedule.toEntity());
            }
        }
    }
}
