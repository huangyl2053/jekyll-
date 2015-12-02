/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteischedule.ninteichosaschedulememo;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.ninteichosaschedulememo.NinteiChosaScheduleMemo;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5222NinteiChosaScheduleMemoDac;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査スケジュールメモ情報を管理するクラスです。
 */
public class NinteiChosaScheduleMemoManager {

    private final DbT5222NinteiChosaScheduleMemoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteiChosaScheduleMemoManager() {
        dac = InstanceProvider.create(DbT5222NinteiChosaScheduleMemoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5222NinteiChosaScheduleMemoDac}
     */
    NinteiChosaScheduleMemoManager(DbT5222NinteiChosaScheduleMemoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する認定調査スケジュールメモ情報を返します。
     *
     * @param メモ年月日 メモ年月日
     * @param 調査地区コード 調査地区コード
     * @param メモ区分 メモ区分
     * @param 連番 連番
     * @return NinteiChosaScheduleMemo
     */
    @Transaction
    public NinteiChosaScheduleMemo get認定調査スケジュールメモ情報(
             FlexibleDate メモ年月日,
            Code 調査地区コード,
            Code メモ区分,
            int 連番) {
        requireNonNull(メモ年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("メモ年月日"));
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        requireNonNull(メモ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("メモ区分"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbT5222NinteiChosaScheduleMemoEntity entity = dac.selectByKey(
                メモ年月日,
                調査地区コード,
                メモ区分,
                連番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteiChosaScheduleMemo(entity);
    }

    /**
     * 認定調査スケジュールメモ情報を全件返します。
     *
     * @return NinteiChosaScheduleMemoの{@code list}
     */
    @Transaction
    public List<NinteiChosaScheduleMemo> get認定調査スケジュールメモ情報一覧() {
        List<NinteiChosaScheduleMemo> businessList = new ArrayList<>();

        for (DbT5222NinteiChosaScheduleMemoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteiChosaScheduleMemo(entity));
        }

        return businessList;
    }

    /**
     * 認定調査スケジュールメモ情報{@link NinteiChosaScheduleMemo}を保存します。
     *
     * @param 認定調査スケジュールメモ情報 {@link NinteiChosaScheduleMemo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査スケジュールメモ情報(NinteiChosaScheduleMemo 認定調査スケジュールメモ情報) {
        requireNonNull(認定調査スケジュールメモ情報, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査スケジュールメモ情報"));
        if (!認定調査スケジュールメモ情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査スケジュールメモ情報.toEntity());
    }
}
