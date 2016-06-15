/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.kaigotoiawasesaki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesaki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesakiIdentifier;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7069KaigoToiawasesakiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7069KaigoToiawasesakiDac;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護問合せ先の管理クラスです。
 *
 * @reamsid_L DBA-1201-040 xuyannan
 */
public class KaigoToiawasesakiFinder {

    private final DbT7069KaigoToiawasesakiDac dbT7069dac;

    /**
     * コンストラクタです。
     */
    public KaigoToiawasesakiFinder() {
        this.dbT7069dac = InstanceProvider.create(DbT7069KaigoToiawasesakiDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dbT7069dac 介護問合せ先のデータアクセス
     */
    public KaigoToiawasesakiFinder(
            DbT7069KaigoToiawasesakiDac dbT7069dac) {
        this.dbT7069dac = dbT7069dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoToiawasesakiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaigoToiawasesakiFinder}のインスタンス
     */
    public static KaigoToiawasesakiFinder createInstance() {
        return InstanceProvider.create(KaigoToiawasesakiFinder.class);
    }

    /**
     * 介護問合せ先情報を取得します。
     *
     * @return SearchResult<KaigoToiawasesaki>
     */
    @Transaction
    public SearchResult<KaigoToiawasesaki> get介護問合せ先情報() {
        List<KaigoToiawasesaki> resultList = new ArrayList<>();
        List<DbT7069KaigoToiawasesakiEntity> kaigoToiawasesakiList = dbT7069dac.selectAll();
        if (kaigoToiawasesakiList == null || kaigoToiawasesakiList.isEmpty()) {
            return SearchResult.of(Collections.<KaigoToiawasesaki>emptyList(), 0, false);
        }
        for (DbT7069KaigoToiawasesakiEntity entity : kaigoToiawasesakiList) {
            entity.initializeMd5();
            resultList.add(new KaigoToiawasesaki(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 介護問合せ先を取得します。
     *
     * @param サブ業務コード サブ業務コード
     * @param 帳票分類ID 帳票分類ID
     * @return KaigoToiawasesaki 検索情報
     */
    @Transaction
    public KaigoToiawasesaki getResult(SubGyomuCode サブ業務コード, ReportId 帳票分類ID) {
        DbT7069KaigoToiawasesakiEntity entity = dbT7069dac.selectByKey(サブ業務コード, 帳票分類ID);
        if (entity != null) {
            return new KaigoToiawasesaki(entity);
        }
        return null;
    }

    /**
     * 介護問合せ先情報{@link KaigoToiawasesaki}を登録/更新/削除します。
     *
     * @param 介護問合せ先情報 {@link KaigoToiawasesaki}
     * @return 登録/登録件数 更新/更新件数 削除/削除件数の件数を返します。
     */
    @Transaction
    public int insertOrUpdate(KaigoToiawasesaki 介護問合せ先情報) {
        if (!介護問合せ先情報.hasChanged()) {
            return 0;
        }
        return dbT7069dac.save(介護問合せ先情報.toEntity());
    }

    /**
     * 介護問合せ先情報{@link KaigoToiawasesaki}を物理削除します。
     *
     * @param models 介護問合せ先情報
     * @param twoKey 介護問合せ先の識別子
     * @return 物理削除件数 物理削除結果の件数を返します。
     */
    @Transaction
    public boolean delete(Models<KaigoToiawasesakiIdentifier, KaigoToiawasesaki> models, KaigoToiawasesakiIdentifier twoKey) {
        KaigoToiawasesaki 介護問合せ先 = models.get(twoKey);
        if (介護問合せ先 != null) {
            return 1 == dbT7069dac.delete(介護問合せ先.toEntity());
        }
        return false;
    }
}
