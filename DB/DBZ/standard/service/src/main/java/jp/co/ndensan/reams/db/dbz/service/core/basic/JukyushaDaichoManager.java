/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者台帳を管理するクラスです。
 *
 * @reamsid_L DBC-4800-010 huzongcheng
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
     * 受給者台帳情報を取得する。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<JukyushaDaicho>
     */
    @Transaction
    public List<JukyushaDaicho> get受給者台帳被保険者番号(HihokenshaNo 被保険者番号) {
        List<JukyushaDaicho> businessList = new ArrayList<>();

        for (DbT4001JukyushaDaichoEntity entity : dac.select受給者台帳情報(被保険者番号)) {
            entity.initializeMd5();
            businessList.add(new JukyushaDaicho(entity));
        }

        return businessList;
    }

    /**
     * 受給者台帳情報を取得する。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード 識別コード
     * @return List<JukyushaDaicho>
     */
    @Transaction
    public List<JukyushaDaicho> get受給者台帳(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        List<JukyushaDaicho> businessList = new ArrayList<>();

        for (DbT4001JukyushaDaichoEntity entity : dac.select受給者台帳情報(被保険者番号, 識別コード)) {
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

    /**
     * 受給者台帳を全件返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<JukyushaDaicho>
     */
    @Transaction
    public List<JukyushaDaicho> get受給者台帳情報(HihokenshaNo 被保険者番号) {
        List<JukyushaDaicho> businessList = new ArrayList<>();
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        for (DbT4001JukyushaDaichoEntity entity : dac.get受給者台帳(被保険者番号)) {
            entity.initializeMd5();
            businessList.add(new JukyushaDaicho(entity));
        }

        return businessList;
    }

    /**
     * 受給申請事由を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return JukyushaDaicho
     */
    @Transaction
    public JukyushaDaicho get受給申請事由認定完了(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        DbT4001JukyushaDaichoEntity entity = dac.get認定完了状況(被保険者番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JukyushaDaicho(entity);
    }

    /**
     * 受給申請事由を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 計画適用開始日 計画適用開始日
     * @return List<JukyushaDaicho>
     */
    @Transaction
    public List<JukyushaDaicho> select受給者台帳情報(HihokenshaNo 被保険者番号, FlexibleDate 計画適用開始日) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(計画適用開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("計画適用開始日"));
        List<DbT4001JukyushaDaichoEntity> entityList = dac.select受給者台帳情報By適用日(被保険者番号, 計画適用開始日);
        List<JukyushaDaicho> businessList = new ArrayList<>();
        if (entityList == null || entityList.isEmpty()) {
            return businessList;
        }
        for (DbT4001JukyushaDaichoEntity entity : entityList) {
            entity.initializeMd5();
            businessList.add(new JukyushaDaicho(entity));
        }
        return businessList;
    }

    /**
     * 受給申請事由を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return JukyushaDaicho
     */
    @Transaction
    public JukyushaDaicho get受給申請事由(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        DbT4001JukyushaDaichoEntity entity = dac.get認定申請中状況(被保険者番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JukyushaDaicho(entity);
    }
}
