/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.basic.T1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNumber;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.persistence.basic.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.basic.IReplaceable;
//TODO n3327 三浦凌 IShikibetsuCodeがdefinitionへ移動するまでは、ur.businessへの依存性を残す。( pom.xmlも修正の必要あり )
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;

/**
 * T1001HihokenshaDaichoのデータアクセス用インタフェースです。
 *
 * @author N3327 三浦 凌
 */
public interface IHihokenshaDaichoDac
        extends IReplaceable<T1001HihokenshaDaichoEntity>, IDeletable<T1001HihokenshaDaichoEntity> {

    /**
     * 市町村コードと被保険者番号から、被保険者を検索します。<br />
     * 検索結果があるときは、必ず1件です。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @return T1001HihokenshaDaichoEntity
     */
    T1001HihokenshaDaichoEntity select(ShichosonCode 市町村コード, KaigoHihokenshaNumber 被保険者番号);

    /**
     * 被保険者番号から、被保険者を検索します。
     *
     * @param 被保険者番号 被保険者番号
     * @return T1001HihokenshaDaichoEntityのリスト
     */
    List<T1001HihokenshaDaichoEntity> select(KaigoHihokenshaNumber 被保険者番号);

    /**
     * 市町村コードと識別コードから、被保険者を検索します。
     *
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     * @return T1001HihokenshaDaichoEntityのリスト
     */
    List<T1001HihokenshaDaichoEntity> select(ShichosonCode 市町村コード, IShikibetsuCode 識別コード);

    /**
     * 識別コードから、被保険者を検索します。
     *
     * @param 識別コード 識別コード
     * @return T1001HihokenshaDaichoEntityのリスト
     */
    List<T1001HihokenshaDaichoEntity> select(IShikibetsuCode 識別コード);
}
