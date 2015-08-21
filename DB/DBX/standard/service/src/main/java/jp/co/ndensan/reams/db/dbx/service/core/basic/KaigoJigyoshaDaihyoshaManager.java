/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoJigyoshaDaihyosha;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7062KaigoJigyoshaDaihyoshaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護事業者代表者を管理するクラスです。
 */
public class KaigoJigyoshaDaihyoshaManager {

    private final DbT7062KaigoJigyoshaDaihyoshaDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoJigyoshaDaihyoshaManager() {
        dac = InstanceProvider.create(DbT7062KaigoJigyoshaDaihyoshaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7062KaigoJigyoshaDaihyoshaDac}
     */
    KaigoJigyoshaDaihyoshaManager(DbT7062KaigoJigyoshaDaihyoshaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護事業者代表者を返します。
     *
     * @param 事業者番号 JigyoshaNo
     * @param 有効開始日 YukoKaishiYMD
     * @return KaigoJigyoshaDaihyosha
     */
    @Transaction
    public KaigoJigyoshaDaihyosha get介護事業者代表者(
            KaigoJigyoshaNo 事業者番号,
            FlexibleDate 有効開始日) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(有効開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始日"));

        DbT7062KaigoJigyoshaDaihyoshaEntity entity = dac.selectByKey(
                事業者番号,
                有効開始日);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KaigoJigyoshaDaihyosha(entity);
    }

    /**
     * 介護事業者代表者を全件返します。
     *
     * @return List<KaigoJigyoshaDaihyosha>
     */
    @Transaction
    public List<KaigoJigyoshaDaihyosha> get介護事業者代表者一覧() {
        List<KaigoJigyoshaDaihyosha> businessList = new ArrayList<>();

        for (DbT7062KaigoJigyoshaDaihyoshaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KaigoJigyoshaDaihyosha(entity));
        }

        return businessList;
    }

    /**
     * 介護事業者代表者{@link KaigoJigyoshaDaihyosha}を保存します。
     *
     * @param 介護事業者代表者 {@link KaigoJigyoshaDaihyosha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護事業者代表者(KaigoJigyoshaDaihyosha 介護事業者代表者) {
        requireNonNull(介護事業者代表者, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者代表者"));
        if (!介護事業者代表者.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護事業者代表者.toEntity());
    }
}
