/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.Hihokensha;
import jp.co.ndensan.reams.db.dba.business.HihokenshaFactory;
import jp.co.ndensan.reams.db.dba.definition.valueobject.HihokenshaKubun;
import jp.co.ndensan.reams.db.dba.business.HihokenshaList;
import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.ShikakuIdoKubun;
import jp.co.ndensan.reams.db.dba.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dba.entity.mapper.HihokenshaMapper;
import jp.co.ndensan.reams.db.dba.persistence.basic.IHihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.ur.urz.business.IShikakuShutokuJiyu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
    HihokenshaDaichoManager(IHihokenshaDaichoDac dac) {
        this.dac = dac;
    }

    @Override
    public Hihokensha get被保険者台帳(ShichosonCode 市町村コード, KaigoHihokenshaNo 被保険者番号) {
        DbT1001HihokenshaDaichoEntity entity = dac.select(市町村コード, 被保険者番号);
        return HihokenshaMapper.toHihokensha(entity);
    }

    @Override
    public HihokenshaList get被保険者台帳(KaigoHihokenshaNo 被保険者番号) {
        List<DbT1001HihokenshaDaichoEntity> entities = dac.select(被保険者番号);
        return HihokenshaMapper.toHihokenshaList(entities);
    }

    @Override
    public HihokenshaList get被保険者台帳(ShichosonCode 市町村コード, ShikibetsuCode 識別コード) {
        List<DbT1001HihokenshaDaichoEntity> entities = dac.select(市町村コード, 識別コード);
        return HihokenshaMapper.toHihokenshaList(entities);
    }

    @Override
    public HihokenshaList get被保険者台帳(ShikibetsuCode 識別コード) {
        List<DbT1001HihokenshaDaichoEntity> entities = dac.select(識別コード);
        return HihokenshaMapper.toHihokenshaList(entities);
    }

    //TODO n3327 三浦凌　資格被保険者区分、住所地特例者区分 について見直す。
    @Override
    public boolean save(ShichosonCode 市町村コード, ShikibetsuCode 識別コード, HihokenshaKubun 被保険者区分,
            RDate 資格取得届出年月日, RDate 資格取得年月日, IShikakuShutokuJiyu 資格取得事由, RDate 一号年齢到達日) {

        KaigoHihokenshaNo 被保険者番号 = new HihokenshaNumberSaibanService().createNewNumber();

        return save(被保険者番号, 市町村コード, 識別コード, 被保険者区分, 資格取得届出年月日, 資格取得年月日, 資格取得事由, 一号年齢到達日);
    }

    @Override
    public boolean save(KaigoHihokenshaNo 被保険者番号, ShichosonCode 市町村コード, ShikibetsuCode 識別コード, HihokenshaKubun 被保険者区分,
            RDate 資格取得届出年月日, RDate 資格取得年月日, IShikakuShutokuJiyu 資格取得事由, RDate 一号年齢到達日) {

        Hihokensha 登録対象 = HihokenshaFactory.createInstance(
                被保険者番号, 市町村コード, 識別コード, ShikakuIdoKubun.資格取得, 被保険者区分, 資格取得届出年月日, 資格取得年月日, 資格取得事由, 一号年齢到達日);

        return save(登録対象);
    }

    @Override
    public boolean save(Hihokensha 被保険者) {
        int result = dac.insertOrUpdate(new DbT1001HihokenshaDaichoEntity(被保険者));
        return (result != 0);
    }

    @Override
    public boolean remove(Hihokensha 被保険者) {
        int result = dac.delete(new DbT1001HihokenshaDaichoEntity(被保険者));
        return (result != 0);
    }
}
