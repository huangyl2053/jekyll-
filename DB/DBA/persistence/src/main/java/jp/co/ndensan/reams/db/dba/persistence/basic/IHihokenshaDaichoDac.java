/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.T1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.business.KaigoHihokenshaNumber;
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
public interface IHihokenshaDaichoDac extends
        IInsertable<T1001HihokenshaDaichoEntity>, IDeletable<T1001HihokenshaDaichoEntity>, IUpdatable<T1001HihokenshaDaichoEntity> {

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

    /**
     * 同一被保険者に対するデータが存在するかどうかをチェックし、存在する場合はupdate、存在しない場合はinsertを行います。
     *
     * @param entity 永続化したい被保険者情報
     * @return 処理を委譲したメソッドの返り値。updateのときはupdate。insertのときはinsert。
     */
    int insertOrUpdate(T1001HihokenshaDaichoEntity entity);
}
