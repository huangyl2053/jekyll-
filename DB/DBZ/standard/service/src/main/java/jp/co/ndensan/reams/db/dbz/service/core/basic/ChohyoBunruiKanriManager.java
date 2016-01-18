/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7068ChohyoBunruiKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7068ChohyoBunruiKanriDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 帳票分類管理を管理するクラスです。
 */
public class ChohyoBunruiKanriManager {

    private final DbT7068ChohyoBunruiKanriDac dac;

    /**
     * コンストラクタです。
     */
    public ChohyoBunruiKanriManager() {
        dac = InstanceProvider.create(DbT7068ChohyoBunruiKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7068ChohyoBunruiKanriDac}
     */
    ChohyoBunruiKanriManager(DbT7068ChohyoBunruiKanriDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ChohyoBunruiKanriManager}のインスタンスを返します。
     *
     *
     * @return ChohyoBunruiKanriManager
     */
    public static ChohyoBunruiKanriManager createInstance() {
        return InstanceProvider.create(ChohyoBunruiKanriManager.class);
    }

    /**
     * 主キーに合致する帳票分類管理を返します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票ID ReportID
     * @return ChohyoBunruiKanri
     */
    @Transaction
    public ChohyoBunruiKanri get帳票分類管理(
            SubGyomuCode サブ業務コード,
            ReportId 帳票ID) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(帳票ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票ID"));

        DbT7068ChohyoBunruiKanriEntity entity = dac.selectByKey(
                サブ業務コード,
                帳票ID);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ChohyoBunruiKanri(entity);
    }

    /**
     * 帳票分類管理を全件返します。
     *
     * @return List<ChohyoBunruiKanri>
     */
    @Transaction
    public List<ChohyoBunruiKanri> get帳票分類管理一覧() {
        List<ChohyoBunruiKanri> businessList = new ArrayList<>();

        for (DbT7068ChohyoBunruiKanriEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ChohyoBunruiKanri(entity));
        }

        return businessList;
    }

    /**
     * 帳票分類管理{@link ChohyoBunruiKanri}を保存します。
     *
     * @param 帳票分類管理 {@link ChohyoBunruiKanri}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save帳票分類管理(ChohyoBunruiKanri 帳票分類管理) {
        requireNonNull(帳票分類管理, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類管理"));
        if (!帳票分類管理.hasChanged()) {
            return false;
        }
        return 1 == dac.save(帳票分類管理.toEntity());
    }
}
