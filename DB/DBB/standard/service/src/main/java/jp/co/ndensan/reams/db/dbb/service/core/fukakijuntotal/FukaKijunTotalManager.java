/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fukakijuntotal;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2013HokenryoDankaiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * システム管理（賦課基準）のクラスです。
 *
 * @reamsid_L DBB-1770-010 wangkanglei
 */
public class FukaKijunTotalManager {

    private final DbT2013HokenryoDankaiDac 保険料段階を管理Dac;
    private static final RString 保険料段階KEY = new RString("保険料段階");

    /**
     * コンストラクタです。
     */
    public FukaKijunTotalManager() {
        保険料段階を管理Dac = InstanceProvider.create(DbT2013HokenryoDankaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param 保険料段階を管理Dac {@link DbT2013HokenryoDankaiDac}
     */
    FukaKijunTotalManager(DbT2013HokenryoDankaiDac 保険料段階を管理Dac) {
        this.保険料段階を管理Dac = 保険料段階を管理Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FukaKijunTotalManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link FukaKijunTotalManager}のインスタンス
     */
    public static FukaKijunTotalManager createInstance() {
        return InstanceProvider.create(FukaKijunTotalManager.class);
    }

    /**
     * 保険料段階{@link HokenryoDankai}を保存します。
     *
     * @param 保険料段階List {@link List<HokenryoDankai>}
     */
    @Transaction
    public void save保険料段階(List<HokenryoDankai> 保険料段階List) {
        requireNonNull(保険料段階List, UrSystemErrorMessages.値がnull.getReplacedMessage(保険料段階KEY.toString()));
        for (HokenryoDankai 保険料段階 : 保険料段階List) {
            DbT2013HokenryoDankaiEntity 段階Entity = 保険料段階.toEntity();
            段階Entity.setState(EntityDataState.Modified);
            保険料段階を管理Dac.save(段階Entity);
        }
    }
}
