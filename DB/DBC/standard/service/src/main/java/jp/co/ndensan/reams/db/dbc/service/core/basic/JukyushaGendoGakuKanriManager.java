/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaGendoGakuKanri;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7116JukyushaGendoGakuKanriEntity;
import jp.co.ndensan.reams.db.dbc.persistence.basic.DbT7116JukyushaGendoGakuKanriDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者限度額管理を管理するクラスです。
 */
public class JukyushaGendoGakuKanriManager {

    private final DbT7116JukyushaGendoGakuKanriDac dac;

    /**
     * コンストラクタです。
     */
    public JukyushaGendoGakuKanriManager() {
        dac = InstanceProvider.create(DbT7116JukyushaGendoGakuKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7116JukyushaGendoGakuKanriDac}
     */
    JukyushaGendoGakuKanriManager(DbT7116JukyushaGendoGakuKanriDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する受給者限度額管理を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別区分 ShikibetsuKubun
     * @param 有効開始年月 YukoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return JukyushaGendoGakuKanri
     */
    @Transaction
    public JukyushaGendoGakuKanri get受給者限度額管理(
            HihokenshaNo 被保険者番号,
            RString 識別区分,
            FlexibleYearMonth 有効開始年月,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(識別区分, UrSystemErrorMessages.値がnull.getReplacedMessage("識別区分"));
        requireNonNull(有効開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT7116JukyushaGendoGakuKanriEntity entity = dac.selectByKey(
                被保険者番号,
                識別区分,
                有効開始年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JukyushaGendoGakuKanri(entity);
    }

    /**
     * 受給者限度額管理を全件返します。
     *
     * @return List<JukyushaGendoGakuKanri>
     */
    @Transaction
    public List<JukyushaGendoGakuKanri> get受給者限度額管理一覧() {
        List<JukyushaGendoGakuKanri> businessList = new ArrayList<>();

        for (DbT7116JukyushaGendoGakuKanriEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new JukyushaGendoGakuKanri(entity));
        }

        return businessList;
    }

    /**
     * 受給者限度額管理{@link JukyushaGendoGakuKanri}を保存します。
     *
     * @param 受給者限度額管理 {@link JukyushaGendoGakuKanri}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save受給者限度額管理(JukyushaGendoGakuKanri 受給者限度額管理) {
        requireNonNull(受給者限度額管理, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者限度額管理"));
        if (!受給者限度額管理.hasChanged()) {
            return false;
        }
        return 1 == dac.save(受給者限度額管理.toEntity());
    }
}
