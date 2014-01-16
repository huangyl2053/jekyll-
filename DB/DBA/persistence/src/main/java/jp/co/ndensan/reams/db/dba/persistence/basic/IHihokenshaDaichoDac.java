/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.T1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.business.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.ur.urz.persistence.basic.IInsertable;
import jp.co.ndensan.reams.ur.urz.persistence.basic.IDeletable;
import jp.co.ndensan.reams.ur.urz.persistence.basic.IUpdatable;

/**
 * T1001HihokenshaDaichoのデータアクセス用インタフェースです。
 *
 * @author N3327 三浦 凌
 */
public interface IHihokenshaDaichoDac extends IInsertable<T1001HihokenshaDaichoEntity>, IDeletable<T1001HihokenshaDaichoEntity>, IUpdatable<T1001HihokenshaDaichoEntity> {

    T1001HihokenshaDaichoEntity select(ShichosonCode 市町村コード, KaigoHihokenshaNo 介護保険被保険者番号);

    List<T1001HihokenshaDaichoEntity> select(KaigoHihokenshaNo 介護保険被保険者番号);

    List<T1001HihokenshaDaichoEntity> select(ShichosonCode 市町村コード, IShikibetsuCode 識別コード);

    List<T1001HihokenshaDaichoEntity> select(IShikibetsuCode 識別コード);
}
