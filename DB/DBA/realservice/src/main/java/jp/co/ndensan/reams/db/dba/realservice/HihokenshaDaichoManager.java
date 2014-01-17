/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.Hihokensha;
import jp.co.ndensan.reams.db.dba.business.HihokenshaList;
import jp.co.ndensan.reams.db.dba.entity.T1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dba.entity.mapper.HihokenshaMapper;
import jp.co.ndensan.reams.db.dba.persistence.basic.IHihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.business.KaigoHihokenshaNumber;
import jp.co.ndensan.reams.db.dbz.business.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;

/**
 * 被保険者の取得、更新、削除を行うクラスです。
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaDaichoManager implements IHihokenshaDaichoManager {

    private final IHihokenshaDaichoDac dac;

    /**
     * コンストラクタです。
     */
    public HihokenshaDaichoManager() {
        dac = InstanceCreator.create(IHihokenshaDaichoDac.class);
    }

    /**
     * テスト用のコンストラクタです。
     *
     * @param dac テスト用被保険者台帳DAC
     */
    public HihokenshaDaichoManager(IHihokenshaDaichoDac dac) {
        this.dac = dac;
    }

    @Override
    public Hihokensha get被保険者台帳(ShichosonCode 市町村コード, KaigoHihokenshaNumber 被保険者番号) {
        T1001HihokenshaDaichoEntity entity = dac.select(市町村コード, 被保険者番号);
        return makeRetrunValueFrom(entity);
    }

    @Override
    public HihokenshaList get被保険者台帳(KaigoHihokenshaNumber 被保険者番号) {
        List<T1001HihokenshaDaichoEntity> entities = dac.select(被保険者番号);
        return makeReturnValueFrom(entities);
    }

    @Override
    public HihokenshaList get被保険者台帳(ShichosonCode 市町村コード, IShikibetsuCode 識別コード) {
        List<T1001HihokenshaDaichoEntity> entities = dac.select(市町村コード, 識別コード);
        return makeReturnValueFrom(entities);
    }

    @Override
    public HihokenshaList get被保険者台帳(IShikibetsuCode 識別コード) {
        List<T1001HihokenshaDaichoEntity> entities = dac.select(識別コード);
        return makeReturnValueFrom(entities);
    }

    private Hihokensha makeRetrunValueFrom(final T1001HihokenshaDaichoEntity entity) {
        if (entity == null) {
            return null;
        }
        return HihokenshaMapper.toHihokensha(entity);
    }

    private HihokenshaList makeReturnValueFrom(final List<T1001HihokenshaDaichoEntity> selected) {
        if (selected == Collections.EMPTY_LIST) {
            return null;
        }
        return HihokenshaMapper.toHihokenshaList(selected);
    }

    @Override
    public boolean save(Hihokensha 被保険者) {
        int result = dac.insertOrUpdate(new T1001HihokenshaDaichoEntity(被保険者));
        return (result != 0);
    }

    @Override
    public boolean remove(Hihokensha 被保険者) {
        int result = dac.delete(new T1001HihokenshaDaichoEntity(被保険者));
        return (result != 0);
    }
}
