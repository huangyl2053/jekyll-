/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.business.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者台帳を管理するクラスです。
 */
public class JukyushaDaichoManager {

    private final DbT4001JukyushaDaichoDac dac;

    /**
     * コンストラクタです。
     */
    public JukyushaDaichoManager() {
        dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT4001JukyushaDaichoDac}
     */
    JukyushaDaichoManager(DbT4001JukyushaDaichoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する受給者台帳を返します。
     *
     * @param 市町村コード ShichosonCode
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @param 枝番 Edaban
     * @param 受給申請事由 JukyuShinseiJiyu
     * @return JukyushaDaicho
     */
    @Transaction
    public JukyushaDaicho get受給者台帳(
            LasdecCode 市町村コード,
            HihokenshaNo 被保険者番号,
            RString 履歴番号,
            RString 枝番,
            Code 受給申請事由) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        requireNonNull(受給申請事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給申請事由"));

        DbT4001JukyushaDaichoEntity entity = dac.selectByKey(
                市町村コード,
                被保険者番号,
                履歴番号,
                枝番,
                受給申請事由);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JukyushaDaicho(entity);
    }

    /**
     * 受給者台帳を全件返します。
     *
     * @return List<JukyushaDaicho>
     */
    @Transaction
    public List<JukyushaDaicho> get受給者台帳一覧() {
        List<JukyushaDaicho> businessList = new ArrayList<>();

        for (DbT4001JukyushaDaichoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new JukyushaDaicho(entity));
        }

        return businessList;
    }

    /**
     * 受給者台帳{@link JukyushaDaicho}を保存します。
     *
     * @param 受給者台帳 {@link JukyushaDaicho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save受給者台帳(JukyushaDaicho 受給者台帳) {
        requireNonNull(受給者台帳, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳"));
        if (!受給者台帳.hasChanged()) {
            return false;
        }
        return 1 == dac.save(受給者台帳.toEntity());
    }
}
