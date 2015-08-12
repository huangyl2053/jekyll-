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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
     * @param 送信元市町村コード 送信元市町村コード
     * @param 送信先市町村コード 送信先市町村コード
     * @param 種別 種別
     * @param 有効開始年月日 有効開始年月日
     * @param 有効終了年月日 有効終了年月日
     * @return RendoPattern
     */
    @Transaction
    public RendoPattern get連動パターン(
            LasdecCode 送信元市町村コード,
            LasdecCode 送信先市町村コード,
            RString 種別,
            FlexibleDate 有効開始年月日,
            FlexibleDate 有効終了年月日) {
        requireNonNull(送信元市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("送信元市町村コード"));
        requireNonNull(送信先市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("送信先市町村コード"));
        requireNonNull(種別, UrSystemErrorMessages.値がnull.getReplacedMessage("種別"));
        requireNonNull(有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月日"));
        requireNonNull(有効終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効終了年月日"));

        DbT7035RendoPatternEntity entity = dac.selectByKey(
                送信元市町村コード,
                送信先市町村コード,
                種別,
                有効開始年月日,
                有効終了年月日);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new RendoPattern(entity);
    }

    /**
     * 連動パターンを全件返します。
     *
     * @return RendoPatternの{@code list}
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
