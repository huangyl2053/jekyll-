/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.Shotoku;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT2008ShotokuKanriDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護所得を管理するクラスです。
 */
public class ShotokuManager {

    private final DbT2008ShotokuKanriDac dac;

    /**
     * コンストラクタです。
     */
    public ShotokuManager() {
        dac = InstanceProvider.create(DbT2008ShotokuKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT2008ShotokuDac}
     */
    ShotokuManager(DbT2008ShotokuKanriDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護所得を返します。
     *
     * @param 所得年度 ShotokuNendo
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 RirekiNo
     * @return Shotoku
     */
    @Transaction
    public Shotoku get介護所得(
            FlexibleYear 所得年度,
            ShikibetsuCode 識別コード,
            int 履歴番号) {
        requireNonNull(所得年度, UrSystemErrorMessages.値がnull.getReplacedMessage("所得年度"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT2008ShotokuKanriEntity entity = dac.selectByKey(
                所得年度,
                識別コード,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new Shotoku(entity);
    }

    /**
     * 介護所得を全件返します。
     *
     * @return List<Shotoku>
     */
    @Transaction
    public List<Shotoku> get介護所得一覧() {
        List<Shotoku> businessList = new ArrayList<>();

        for (DbT2008ShotokuKanriEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new Shotoku(entity));
        }

        return businessList;
    }

    /**
     * 介護所得{@link Shotoku}を保存します。
     *
     * @param 介護所得 {@link Shotoku}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護所得(Shotoku 介護所得) {
        requireNonNull(介護所得, UrSystemErrorMessages.値がnull.getReplacedMessage("介護所得"));
        if (!介護所得.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護所得.toEntity());
    }

    /**
     * 介護所得{@link Shotoku}を插入します。
     *
     * @param 介護所得 {@link Shotoku}
     * @return 插入することが成功しますか　true:成功　false:失敗
     */
    @Transaction
    public boolean insert介護所得(Shotoku 介護所得) {
        requireNonNull(介護所得, UrSystemErrorMessages.値がnull.getReplacedMessage("介護所得"));
        return 1 == dac.save(介護所得.toEntity());
    }

    /**
     * 所得年度と識別コードを利用して、次の履歴番号を取ります。
     *
     * @param 所得年度 FlexibleYear
     * @param 識別コード ShikibetsuCode
     * @return 最新履歴番号
     */
    @Transaction
    public int get最新履歴番号(FlexibleYear 所得年度,
            ShikibetsuCode 識別コード) {
        int 履歴番号 = 1;
        DbT2008ShotokuKanriEntity 最新所得 = dac.selectBySomeKey(所得年度, 識別コード);
        if (null != 最新所得) {
            履歴番号 = 最新所得.getRirekiNo() + 1;
        }
        return 履歴番号;
    }
}
