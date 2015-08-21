/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護事業者を管理するクラスです。
 */
public class KaigoJigyoshaManager {

    private final DbT7060KaigoJigyoshaDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoJigyoshaManager() {
        dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7060KaigoJigyoshaDac}
     */
    KaigoJigyoshaManager(DbT7060KaigoJigyoshaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護事業者を返します。
     *
     * @param 事業者番号 JigyoshaNo
     * @param 有効開始日 YukoKaishiYMD
     * @return KaigoJigyosha
     */
    @Transaction
    public KaigoJigyosha get介護事業者(
            KaigoJigyoshaNo 事業者番号,
            FlexibleDate 有効開始日) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(有効開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始日"));

        DbT7060KaigoJigyoshaEntity entity = dac.selectByKey(
                事業者番号,
                有効開始日);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KaigoJigyosha(entity);
    }

    /**
     * 介護事業者を全件返します。
     *
     * @return List<KaigoJigyosha>
     */
    @Transaction
    public List<KaigoJigyosha> get介護事業者一覧() {
        List<KaigoJigyosha> businessList = new ArrayList<>();

        for (DbT7060KaigoJigyoshaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KaigoJigyosha(entity));
        }

        return businessList;
    }

    /**
     * 介護事業者{@link KaigoJigyosha}を保存します。
     *
     * @param 介護事業者 {@link KaigoJigyosha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護事業者(KaigoJigyosha 介護事業者) {
        requireNonNull(介護事業者, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者"));
        if (!介護事業者.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護事業者.toEntity());
    }
}
