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
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 帳票制御汎用を管理するクラスです。
 *
 * @reamsid_L DBC-4470-010 wangkanglei
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
     * {@link InstanceProvider#create}にて生成した{@link ChohyoSeigyoHanyoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ChohyoSeigyoHanyoManager}のインスタンス
     */
    public static ChohyoSeigyoHanyoManager createInstance() {
        return InstanceProvider.create(ChohyoSeigyoHanyoManager.class);
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

    /**
     * 主キーに合致する表示制御に必要な情報を返します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票分類IDList ChohyoBunruiIDList
     * @param 管理年度 kanriNendo
     * @param 項目名 KomokuName
     * @return List<ChohyoSeigyoHanyo>
     */
    @Transaction
    public List<ChohyoSeigyoHanyo> get表示制御に必要な情報(
            SubGyomuCode サブ業務コード,
            List<ReportId> 帳票分類IDList,
            FlexibleYear 管理年度,
            RString 項目名) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(帳票分類IDList, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類IDList"));
        requireNonNull(管理年度, UrSystemErrorMessages.値がnull.getReplacedMessage("管理年度"));
        requireNonNull(項目名, UrSystemErrorMessages.値がnull.getReplacedMessage("項目名"));

        List<DbT7067ChohyoSeigyoHanyoEntity> entityList = dac.get表示制御に必要な情報(
                サブ業務コード,
                帳票分類IDList,
                管理年度,
                項目名);
        List<ChohyoSeigyoHanyo> businessList = new ArrayList<>();

        for (DbT7067ChohyoSeigyoHanyoEntity entity : entityList) {
            entity.initializeMd5();
            businessList.add(new ChohyoSeigyoHanyo(entity));
        }
        return businessList;
    }

    /**
     * 帳票制御汎用リスト{@link ChohyoSeigyoHanyo}を取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 管理年度 FlexibleYear
     * @return businessList
     */
    @Transaction
    public List<ChohyoSeigyoHanyo> get帳票制御汎用(
           SubGyomuCode サブ業務コード, FlexibleYear 管理年度) {
        requireNonNull(管理年度, UrSystemErrorMessages.値がnull.getReplacedMessage("管理年度"));
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        List<DbT7067ChohyoSeigyoHanyoEntity> entityList = dac.get帳票制御汎用(サブ業務コード,
                管理年度);
        List<ChohyoSeigyoHanyo> businessList = new ArrayList<>();

        for (DbT7067ChohyoSeigyoHanyoEntity entity : entityList) {
            entity.initializeMd5();
            businessList.add(new ChohyoSeigyoHanyo(entity));
        }
        return businessList;
    }

    /**
     * 帳票制御汎用リスト{@link ChohyoSeigyoHanyo}を更新します。
     *
     * @param 帳票制御汎用リスト 帳票制御汎用リスト
     */
    @Transaction
    public void update帳票制御汎用(List<ChohyoSeigyoHanyo> 帳票制御汎用リスト) {
        requireNonNull(帳票制御汎用リスト, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御汎用"));
        for (ChohyoSeigyoHanyo 帳票制御汎用 : 帳票制御汎用リスト) {
            DbT7067ChohyoSeigyoHanyoEntity entity = 帳票制御汎用.toEntity();
            entity.setState(EntityDataState.Modified);
            dac.save(entity);
        }
    }

    /**
     * 帳票制御汎用リスト{@link ChohyoSeigyoHanyo}を取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票分類ID ChohyoBunruiID
     * @return SearchResult<ChohyoSeigyoHanyo>
     */
    @Transaction
    public SearchResult<ChohyoSeigyoHanyo> get帳票制御汎用(SubGyomuCode サブ業務コード,
            ReportId 帳票分類ID) {
        List<ChohyoSeigyoHanyo> businessList = new ArrayList<>();
        for (DbT7067ChohyoSeigyoHanyoEntity entity : dac.get帳票制御汎用(サブ業務コード, 帳票分類ID)) {
            entity.initializeMd5();
            businessList.add(new ChohyoSeigyoHanyo(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }
}
