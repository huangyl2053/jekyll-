/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RendoPattern;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7035RendoPatternEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7035RendoPatternDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 連動パターンを管理するクラスです。
 */
public class RendoPatternManager {

    private final DbT7035RendoPatternDac dac;

    /**
     * コンストラクタです。
     */
    public RendoPatternManager() {
        dac = InstanceProvider.create(DbT7035RendoPatternDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7035RendoPatternDac}
     */
    RendoPatternManager(DbT7035RendoPatternDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する連動パターンを返します。
     *
     * @param 処理番号 ShoriNo
     * @param 連番 RenNo
     * @return RendoPattern
     */
    @Transaction
    public RendoPattern get連動パターン(
            LasdecCode 処理番号,
            LasdecCode 連番) {
        requireNonNull(処理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("処理番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbT7035RendoPatternEntity entity = dac.selectByKey(
                処理番号,
                連番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new RendoPattern(entity);
    }

    /**
     * 連動パターンを全件返します。
     *
     * @return List<RendoPattern>
     */
    @Transaction
    public List<RendoPattern> get連動パターン一覧() {
        List<RendoPattern> businessList = new ArrayList<>();

        for (DbT7035RendoPatternEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new RendoPattern(entity));
        }

        return businessList;
    }

    /**
     * 連動パターン{@link RendoPattern}を保存します。
     *
     * @param 連動パターン {@link RendoPattern}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save連動パターン(RendoPattern 連動パターン) {
        requireNonNull(連動パターン, UrSystemErrorMessages.値がnull.getReplacedMessage("連動パターン"));
        if (!連動パターン.hasChanged()) {
            return false;
        }
        return 1 == dac.save(連動パターン.toEntity());
    }
}
