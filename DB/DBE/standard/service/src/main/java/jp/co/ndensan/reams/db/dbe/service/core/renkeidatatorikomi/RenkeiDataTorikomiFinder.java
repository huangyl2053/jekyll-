/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.renkeidatatorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7202KaigoNinteiHokaiseiKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7202KaigoNinteiHokaiseiKanriDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定申請連携データ取込を管理クラスです。
 *
 * @reamsid_L DBE-1490-010 xuyannan
 */
public class RenkeiDataTorikomiFinder {

    private final DbT7202KaigoNinteiHokaiseiKanriDac dbT7202dac;

    /**
     * コンストラクタです。
     */
    RenkeiDataTorikomiFinder() {
        this.dbT7202dac = InstanceProvider.create(DbT7202KaigoNinteiHokaiseiKanriDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dbT7202dac 介護認定法改正管理dac
     */
    RenkeiDataTorikomiFinder(DbT7202KaigoNinteiHokaiseiKanriDac dbT7202dac) {
        this.dbT7202dac = dbT7202dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link RenkeiDataTorikomiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link RenkeiDataTorikomiFinder}のインスタンス
     */
    public static RenkeiDataTorikomiFinder createInstance() {
        return InstanceProvider.create(RenkeiDataTorikomiFinder.class);
    }

    /**
     * 法改正管理情報をを取得します。
     *
     * @param システム日付 システム日付
     * @return SearchResult<KaigoNinteiHokaiseiKanri>
     */
    @Transaction
    public boolean get法改正前Flag(FlexibleDate システム日付) {
        List<DbT7202KaigoNinteiHokaiseiKanriEntity> entityList = dbT7202dac.selectListByKey(システム日付);
        return entityList != null;
    }
}
