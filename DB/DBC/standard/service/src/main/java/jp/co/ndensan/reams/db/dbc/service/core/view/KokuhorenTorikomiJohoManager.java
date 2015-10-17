/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.view;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.view.KokuhorenTorikomiJoho;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbV3104KokuhorenTorikomiJohoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.basic.DbV3104KokuhorenTorikomiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 国保連取り込み情報を管理するクラスです。
 */
public class KokuhorenTorikomiJohoManager {

    private final DbV3104KokuhorenTorikomiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public KokuhorenTorikomiJohoManager() {
        dac = InstanceProvider.create(DbV3104KokuhorenTorikomiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbV3104KokuhorenTorikomiJohoDac}
     */
    KokuhorenTorikomiJohoManager(DbV3104KokuhorenTorikomiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する国保連取り込み情報を返します。
     *
     * @param 処理年月 処理年月
     * @param 交換情報識別番号 交換情報識別番号
     * @return KokuhorenTorikomiJoho
     */
    @Transaction
    public KokuhorenTorikomiJoho get国保連取り込み情報(
            FlexibleYearMonth 処理年月,
            RString 交換情報識別番号) {
        requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年月"));
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));

        DbV3104KokuhorenTorikomiJohoEntity entity = dac.selectByKey(
                処理年月,
                交換情報識別番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KokuhorenTorikomiJoho(entity);
    }

    /**
     * 国保連取り込み情報を全件返します。
     *
     * @return KokuhorenTorikomiJohoの{@code list}
     */
    @Transaction
    public List<KokuhorenTorikomiJoho> get国保連取り込み情報一覧() {
        List<KokuhorenTorikomiJoho> businessList = new ArrayList<>();

        for (DbV3104KokuhorenTorikomiJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KokuhorenTorikomiJoho(entity));
        }

        return businessList;
    }

    /**
     * 国保連取り込み情報{@link KokuhorenTorikomiJoho}を保存します。
     *
     * @param 国保連取り込み情報 {@link KokuhorenTorikomiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save国保連取り込み情報(KokuhorenTorikomiJoho 国保連取り込み情報) {
        requireNonNull(国保連取り込み情報, UrSystemErrorMessages.値がnull.getReplacedMessage("国保連取り込み情報"));
        if (!国保連取り込み情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(国保連取り込み情報.toEntity());
    }
}
