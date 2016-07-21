/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2003KibetsuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護期別を管理するクラスです。
 */
public class KibetsuManager {

    private final DbT2003KibetsuDac dac;

    /**
     * コンストラクタです。
     */
    public KibetsuManager() {
        dac = InstanceProvider.create(DbT2003KibetsuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT2003KibetsuDac}
     */
    KibetsuManager(DbT2003KibetsuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護期別を返します。
     *
     * @param 調定年度 ChoteiNendo
     * @param 賦課年度 FukaNendo
     * @param 通知書番号 TsuchishoNo
     * @param 履歴番号 RirekiNo
     * @param 徴収方法 ChoshuHouhou
     * @param 期 Ki
     * @return Kibetsu
     */
    @Transaction
    public Kibetsu get介護期別(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号,
            RString 徴収方法,
            int 期) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(徴収方法, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法"));
        requireNonNull(期, UrSystemErrorMessages.値がnull.getReplacedMessage("期"));

        DbT2003KibetsuEntity entity = dac.selectByKey(
                調定年度,
                賦課年度,
                通知書番号,
                履歴番号,
                徴収方法,
                期);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new Kibetsu(entity);
    }

    /**
     * 介護期別を全件返します。
     *
     * @return List<Kibetsu>
     */
    @Transaction
    public List<Kibetsu> get介護期別一覧() {
        List<Kibetsu> businessList = new ArrayList<>();

        for (DbT2003KibetsuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new Kibetsu(entity));
        }

        return businessList;
    }

    /**
     * 介護期別{@link Kibetsu}を保存します。
     *
     * @param 介護期別 {@link Kibetsu}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護期別(Kibetsu 介護期別) {
        requireNonNull(介護期別, UrSystemErrorMessages.値がnull.getReplacedMessage("介護期別"));
        if (!介護期別.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護期別.toEntity());
    }
}
