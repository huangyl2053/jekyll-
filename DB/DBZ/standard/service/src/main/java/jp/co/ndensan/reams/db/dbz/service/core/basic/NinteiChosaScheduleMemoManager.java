/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiChosaScheduleMemo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemo.chosachikucode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemo.memoPriority;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemo.memoYMD;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5222NinteiChosaScheduleMemoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
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
     * {@link InstanceProvider#create}にて生成した{@link NinteiChosaScheduleMemoManager}のインスタンスを返します。
     *
     *
     * @return NinteiChosaScheduleMemoManager
     */
    public static NinteiChosaScheduleMemoManager createInstance() {
        return InstanceProvider.create(NinteiChosaScheduleMemoManager.class);
    }

    /**
     * 主キーに合致する認定調査スケジュールメモ情報を返します。
     *
     * @param メモ年月日 メモ年月日
     * @param メモ区分 メモ区分
     * @param 連番 連番
     * @return NinteiChosaScheduleMemo
     */
    @Transaction
    public NinteiChosaScheduleMemo get認定調査スケジュールメモ情報(
            FlexibleDate メモ年月日,
            Code メモ区分,
            int 連番) {
        requireNonNull(メモ年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("メモ年月日"));
        requireNonNull(メモ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("メモ区分"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbT5222NinteiChosaScheduleMemoEntity entity = dac.selectByKey(
                メモ年月日,
                メモ区分,
                連番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteiChosaScheduleMemo(entity);
    }

    /**
     * MAX(連番)を返します。
     *
     * @return MAX(連番)
     */
    @Transaction
    public int getMax連番() {

        DbT5222NinteiChosaScheduleMemoEntity entity = dac.getMaxNo();
        if (entity == null) {

            return 0;
        }
        return entity.getRemban();
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
        return 1 == dac.save(認定調査スケジュールメモ情報.toEntity());
    }

    /**
     * 認定調査スケジュールメモ情報{@link NinteiChosaScheduleMemo}を削除します。
     *
     * @param 認定調査スケジュールメモ情報 {@link NinteiChosaScheduleMemo}
     * @return 削除件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean delete認定調査スケジュールメモ情報(NinteiChosaScheduleMemo 認定調査スケジュールメモ情報) {
        requireNonNull(認定調査スケジュールメモ情報, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査スケジュールメモ情報"));
        return 1 == dac.saveOrDeletePhysicalBy(認定調査スケジュールメモ情報.toEntity());
    }

    /**
     * 認定調査スケジュールメモ情報を返します。
     *
     * @param メモ年月日 メモ年月日
     * @param 地区コード 地区コード
     * @return NinteiChosaScheduleMemo
     */
    @Transaction
    public SearchResult<NinteiChosaScheduleMemo> get認定調査スケジュールメモ文本情報(
            FlexibleDate メモ年月日,
            Code 地区コード) {
        requireNonNull(メモ年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("メモ年月日"));
        requireNonNull(地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("地区コード"));

        List<NinteiChosaScheduleMemo> ninteiChosaScheduleMemoList = new ArrayList<>();
        List<DbT5222NinteiChosaScheduleMemoEntity> chosaScheduleMemoEntity = dac.get認定調査スケジュールメモ情報(
                メモ年月日,
                地区コード);
        if (chosaScheduleMemoEntity.isEmpty()) {
            return SearchResult.of(Collections.<NinteiChosaScheduleMemo>emptyList(), 0, false);
        }
        for (DbT5222NinteiChosaScheduleMemoEntity entity : chosaScheduleMemoEntity) {
            entity.initializeMd5();
            ninteiChosaScheduleMemoList.add(new NinteiChosaScheduleMemo(entity));
        }
        return SearchResult.of(ninteiChosaScheduleMemoList, 0, false);
    }

    /**
     * メモ情報件数を取得します。
     *
     * @param メモ年月日 メモ年月日
     * @param 地区コード 地区コード
     * @param 通常または重要フラグ 通常または重要フラグ
     * @return NinteiChosaScheduleMemo
     */
    @Transaction
    public int getメモ情報件数(FlexibleDate メモ年月日, Code 地区コード, RString 通常または重要フラグ) {
        requireNonNull(メモ年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("メモ年月日"));
        requireNonNull(地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("地区コード"));

        ITrueFalseCriteria makeShuruiConditions = null;
        if (通常または重要フラグ.equals(new RString("通常"))) {

            makeShuruiConditions = and(
                    eq(memoYMD, メモ年月日),
                    eq(chosachikucode, 地区コード),
                    eq(memoPriority, new Code("1")));
        }

        if (通常または重要フラグ.equals(new RString("重要"))) {

            makeShuruiConditions = and(
                    eq(memoYMD, メモ年月日),
                    eq(chosachikucode, 地区コード),
                    eq(memoPriority, new Code("2")));
        }
        return dac.getCount(makeShuruiConditions);
    }
}
