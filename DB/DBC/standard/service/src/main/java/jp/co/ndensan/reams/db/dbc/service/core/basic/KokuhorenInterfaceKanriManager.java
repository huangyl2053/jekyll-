/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3104KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 国保連インターフェース管理を管理するクラスです。
 */
public class KokuhorenInterfaceKanriManager {

    private final DbT3104KokuhorenInterfaceKanriDac dac;

    /**
     * コンストラクタです。
     */
    public KokuhorenInterfaceKanriManager() {
        dac = InstanceProvider.create(DbT3104KokuhorenInterfaceKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3104KokuhorenInterfaceKanriDac}
     */
    KokuhorenInterfaceKanriManager(DbT3104KokuhorenInterfaceKanriDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する国保連インターフェース管理を返します。
     *
     * @param 処理年月 ShoriYM
     * @param 交換情報識別番号 KokanShikibetsuNo
     * @return KokuhorenInterfaceKanri
     */
    @Transaction
    public KokuhorenInterfaceKanri get国保連インターフェース管理(
            FlexibleYearMonth 処理年月,
            RString 交換情報識別番号) {
        requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年月"));
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));

        DbT3104KokuhorenInterfaceKanriEntity entity = dac.selectByKey(
                処理年月,
                交換情報識別番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KokuhorenInterfaceKanri(entity);
    }

    /**
     * 国保連インターフェース管理を全件返します。
     *
     * @return List<KokuhorenInterfaceKanri>
     */
    @Transaction
    public List<KokuhorenInterfaceKanri> get国保連インターフェース管理一覧() {
        List<KokuhorenInterfaceKanri> businessList = new ArrayList<>();

        for (DbT3104KokuhorenInterfaceKanriEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KokuhorenInterfaceKanri(entity));
        }

        return businessList;
    }

    /**
     * 国保連インターフェース管理{@link KokuhorenInterfaceKanri}を保存します。
     *
     * @param 国保連インターフェース管理 {@link KokuhorenInterfaceKanri}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save国保連インターフェース管理(KokuhorenInterfaceKanri 国保連インターフェース管理) {
        requireNonNull(国保連インターフェース管理, UrSystemErrorMessages.値がnull.getReplacedMessage("国保連インターフェース管理"));
        if (!国保連インターフェース管理.hasChanged()) {
            return false;
        }
        return 1 == dac.save(国保連インターフェース管理.toEntity());
    }
}
