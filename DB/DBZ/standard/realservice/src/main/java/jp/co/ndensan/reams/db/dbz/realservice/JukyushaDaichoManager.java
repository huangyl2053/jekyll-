/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbz.business.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者台帳を管理するクラスです。
 *
 * @author n8235 船山洋介
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
     * 単体テスト用のコンストラクタです。
     */
    JukyushaDaichoManager(DbT4001JukyushaDaichoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する受給者台帳を返します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param 枝番 枝番
     * @param 受給申請事由 受給申請事由
     * @return JukyushaDaicho
     */
    @Transaction
    public Optional<JukyushaDaicho> get受給者台帳(
            LasdecCode 市町村コード,
            HihokenshaNo 被保険者番号,
            RString 履歴番号,
            RString 枝番,
            Code 受給申請事由) {

        return Optional.ofNullable(new JukyushaDaicho(dac.selectByKey(市町村コード, 被保険者番号, 履歴番号, 枝番, 受給申請事由)));
    }

    /**
     * 受給者台帳の一覧を返します。
     *
     * @return List<JukyushaDaicho>
     */
    @Transaction
    public ItemList<JukyushaDaicho> get受給者台帳一覧() {
        ArrayList<JukyushaDaicho> jukyushaDaichoList = new ArrayList<>();
        for (DbT4001JukyushaDaichoEntity entity : dac.selectAll()) {
            jukyushaDaichoList.add(new JukyushaDaicho(entity));
        }

        return ItemList.of(jukyushaDaichoList);
    }

    /**
     * 被保険者番号に合致する受給者台帳の一覧を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<JukyushaDaicho>
     */
    @Transaction
    public IItemList<JukyushaDaicho> get受給者台帳履歴(HihokenshaNo 被保険者番号) {

        ArrayList<JukyushaDaicho> jukyushaDaichoList = new ArrayList<>();
        for (DbT4001JukyushaDaichoEntity entity : dac.select受給者台帳履歴By被保険者番号(被保険者番号)) {
            jukyushaDaichoList.add(new JukyushaDaicho(entity));
        }
        return ItemList.of(jukyushaDaichoList);
    }

    /**
     * 申請書管理番号に合致する受給者台帳の一覧を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return Optional<JukyushaDaicho>
     */
    @Transaction
    public Optional<JukyushaDaicho> get直近受給者台帳(ShinseishoKanriNo 申請書管理番号) {

        return Optional.ofNullable(new JukyushaDaicho(dac.select受給者台帳履歴By申請書管理番号(申請書管理番号)));

    }

    /**
     * 受給者台帳を登録します。
     *
     * @param 受給者台帳 JukyushaDaicho
     * @return 登録件数
     */
    @Transaction
    public int save受給者台帳(JukyushaDaicho 受給者台帳) {

        if (受給者台帳.getState() == EntityDataState.Added) {
            return dac.insert(受給者台帳.getEntity());
        } else if (受給者台帳.getState() == EntityDataState.Modified) {
            return dac.update(受給者台帳.getEntity());
        } else if (受給者台帳.getState() == EntityDataState.Deleted) {
            return dac.delete(受給者台帳.getEntity());
        }

        throw new IllegalArgumentException(UrErrorMessages.更新対象のデータがない.getMessage().evaluate());
    }
}
