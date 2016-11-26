/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.nenreitoutatuyoteishachecklist;

import jp.co.ndensan.reams.db.dba.business.core.jukinentotoroku.DbT7022ShoriDateKanriBusiness;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7068ChohyoBunruiKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7068ChohyoBunruiKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 年齢到達予定者チェックリストDBManagerです。
 *
 * @reamsid_L DBA-0580-010 yaodongsheng
 */
public class NenreiToutatuYoteishaCheckListManager {

    private final DbT7022ShoriDateKanriDac dbt7022dac;
    private final DbT7068ChohyoBunruiKanriDac dbt7068dac;

    /**
     * コンストラクタです。
     */
    public NenreiToutatuYoteishaCheckListManager() {
        dbt7022dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        dbt7068dac = InstanceProvider.create(DbT7068ChohyoBunruiKanriDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dbt7022dac 処理日付管理マスタDac
     * @param dbt7068dac 帳票分類管理Dac
     */
    NenreiToutatuYoteishaCheckListManager(DbT7022ShoriDateKanriDac dbt7022dac,
            DbT7068ChohyoBunruiKanriDac dbt7068dac) {
        this.dbt7022dac = dbt7022dac;
        this.dbt7068dac = dbt7068dac;

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NenreiToutatuYoteishaCheckListManager}のインスタンスを戻します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NenreiToutatuYoteishaCheckListManager}のインスタンス
     */
    public static NenreiToutatuYoteishaCheckListManager createInstance() {
        return InstanceProvider.create(NenreiToutatuYoteishaCheckListManager.class);
    }

    /**
     * 適用年月日でデータを取得します。
     *
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    @Transaction
    public DbT7022ShoriDateKanriBusiness get開始終了日() {
        DbT7022ShoriDateKanriEntity entity = dbt7022dac.selectkaisyuYMD(ShoriName.年齢到達予定者チェックリスト.get名称());
        if (entity == null) {
            return null;
        }
        return new DbT7022ShoriDateKanriBusiness(entity);
    }

    /**
     * 帳票分類IDを取得します。
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票ID
     * @return 帳票分類管理Entity
     */
    @Transaction
    public ChohyoBunruiKanri get帳票分類ID(SubGyomuCode subGyomuCode, ReportId reportId) {
        DbT7068ChohyoBunruiKanriEntity entity = dbt7068dac.selectByKey(subGyomuCode, reportId);
        if (entity == null) {
            return null;
        }
        return new ChohyoBunruiKanri(entity);
    }

}
