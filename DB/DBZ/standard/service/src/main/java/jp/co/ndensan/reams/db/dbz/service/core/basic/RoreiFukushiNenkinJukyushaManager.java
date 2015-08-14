/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7006RoreiFukushiNenkinJukyushaDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 老齢福祉年金受給者を管理するクラスです。
 */
public class RoreiFukushiNenkinJukyushaManager {

    private final DbT7006RoreiFukushiNenkinJukyushaDac dac;

    /**
     * コンストラクタです。
     */
    public RoreiFukushiNenkinJukyushaManager() {
        dac = InstanceProvider.create(DbT7006RoreiFukushiNenkinJukyushaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7006RoreiFukushiNenkinJukyushaDac}
     */
    RoreiFukushiNenkinJukyushaManager(DbT7006RoreiFukushiNenkinJukyushaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する老齢福祉年金受給者を返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 受給開始年月日 JukyuKaishiYMD
     * @return RoreiFukushiNenkinJukyusha
     */
    @Transaction
    public RoreiFukushiNenkinJukyusha get老齢福祉年金受給者(
            ShikibetsuCode 識別コード,
            FlexibleDate 受給開始年月日) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(受給開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給開始年月日"));

        DbT7006RoreiFukushiNenkinJukyushaEntity entity = dac.selectByKey(
                識別コード,
                受給開始年月日);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new RoreiFukushiNenkinJukyusha(entity);
    }

    /**
     * 老齢福祉年金受給者を全件返します。
     *
     * @return List<RoreiFukushiNenkinJukyusha>
     */
    @Transaction
    public List<RoreiFukushiNenkinJukyusha> get老齢福祉年金受給者一覧() {
        List<RoreiFukushiNenkinJukyusha> businessList = new ArrayList<>();

        for (DbT7006RoreiFukushiNenkinJukyushaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new RoreiFukushiNenkinJukyusha(entity));
        }

        return businessList;
    }

    /**
     * 老齢福祉年金受給者{@link RoreiFukushiNenkinJukyusha}を保存します。
     *
     * @param 老齢福祉年金受給者 {@link RoreiFukushiNenkinJukyusha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save老齢福祉年金受給者(RoreiFukushiNenkinJukyusha 老齢福祉年金受給者) {
        requireNonNull(老齢福祉年金受給者, UrSystemErrorMessages.値がnull.getReplacedMessage("老齢福祉年金受給者"));
        if (!老齢福祉年金受給者.hasChanged()) {
            return false;
        }
        return 1 == dac.save(老齢福祉年金受給者.toEntity());
    }
}
