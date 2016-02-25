/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 帳票制御汎用を管理するクラスです。
 */
public class ChohyoSeigyoHanyoManager {

    private final DbT7067ChohyoSeigyoHanyoDac dac;

    /**
     * コンストラクタです。
     */
    public ChohyoSeigyoHanyoManager() {
        dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7067ChohyoSeigyoHanyoDac}
     */
    ChohyoSeigyoHanyoManager(DbT7067ChohyoSeigyoHanyoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する帳票制御汎用を返します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票分類ID ChohyoBunruiID
     * @param 管理年度 kanriNendo
     * @param 項目名 KomokuName
     * @return ChohyoSeigyoHanyo
     */
    @Transaction
    public ChohyoSeigyoHanyo get帳票制御汎用(
            SubGyomuCode サブ業務コード,
            ReportId 帳票分類ID,
            FlexibleYear 管理年度,
            RString 項目名) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));
        requireNonNull(管理年度, UrSystemErrorMessages.値がnull.getReplacedMessage("管理年度"));
        requireNonNull(項目名, UrSystemErrorMessages.値がnull.getReplacedMessage("項目名"));

        DbT7067ChohyoSeigyoHanyoEntity entity = dac.selectByKey(
                サブ業務コード,
                帳票分類ID,
                管理年度,
                項目名);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ChohyoSeigyoHanyo(entity);
    }

    /**
     * 帳票制御汎用を全件返します。
     *
     * @return List<ChohyoSeigyoHanyo>
     */
    @Transaction
    public List<ChohyoSeigyoHanyo> get帳票制御汎用一覧() {
        List<ChohyoSeigyoHanyo> businessList = new ArrayList<>();

        for (DbT7067ChohyoSeigyoHanyoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ChohyoSeigyoHanyo(entity));
        }

        return businessList;
    }

    /**
     * 帳票制御汎用{@link ChohyoSeigyoHanyo}を保存します。
     *
     * @param 帳票制御汎用 {@link ChohyoSeigyoHanyo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save帳票制御汎用(ChohyoSeigyoHanyo 帳票制御汎用) {
        requireNonNull(帳票制御汎用, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御汎用"));
        if (!帳票制御汎用.hasChanged()) {
            return false;
        }
        return 1 == dac.save(帳票制御汎用.toEntity());
    }
}
