/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.basic.JuryoIninKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7061JuryoIninJigyoshaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受領委任契約事業者を管理するクラスです。
 */
public class JuryoIninKeiyakuJigyoshaManager {

    private final DbT7061JuryoIninJigyoshaDac dac;

    /**
     * コンストラクタです。
     */
    public JuryoIninKeiyakuJigyoshaManager() {
        dac = InstanceProvider.create(DbT7061JuryoIninJigyoshaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7061JuryoIninJigyoshaDac}
     */
    JuryoIninKeiyakuJigyoshaManager(DbT7061JuryoIninJigyoshaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する受領委任契約事業者を返します。
     *
     * @param 受領委任契約事業者番号 JigyoshaNo
     * @param 受領委任契約開始日 KeiyakuKaishiYMD
     * @param 契約サービス種別 ServiceShubetsuCode
     * @return JuryoIninKeiyakuJigyosha
     */
    @Transaction
    public JuryoIninKeiyakuJigyosha get受領委任契約事業者(
            KaigoJigyoshaNo 受領委任契約事業者番号,
            FlexibleDate 受領委任契約開始日,
            RString 契約サービス種別) {
        requireNonNull(受領委任契約事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約事業者番号"));
        requireNonNull(受領委任契約開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約開始日"));
        requireNonNull(契約サービス種別, UrSystemErrorMessages.値がnull.getReplacedMessage("契約サービス種別"));

        DbT7061JuryoIninJigyoshaEntity entity = dac.selectByKey(
                受領委任契約事業者番号,
                受領委任契約開始日,
                契約サービス種別);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JuryoIninKeiyakuJigyosha(entity);
    }

    /**
     * 受領委任契約事業者を全件返します。
     *
     * @return List<JuryoIninKeiyakuJigyosha>
     */
    @Transaction
    public List<JuryoIninKeiyakuJigyosha> get受領委任契約事業者一覧() {
        List<JuryoIninKeiyakuJigyosha> businessList = new ArrayList<>();

        for (DbT7061JuryoIninJigyoshaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new JuryoIninKeiyakuJigyosha(entity));
        }

        return businessList;
    }

    /**
     * 受領委任契約事業者{@link JuryoIninKeiyakuJigyosha}を保存します。
     *
     * @param 受領委任契約事業者 {@link JuryoIninKeiyakuJigyosha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save受領委任契約事業者(JuryoIninKeiyakuJigyosha 受領委任契約事業者) {
        requireNonNull(受領委任契約事業者, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約事業者"));
        if (!受領委任契約事業者.hasChanged()) {
            return false;
        }
        return 1 == dac.save(受領委任契約事業者.toEntity());
    }
}
