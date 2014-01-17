/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice;

import jp.co.ndensan.reams.db.dba.business.Hihokensha;
import jp.co.ndensan.reams.db.dba.business.HihokenshaList;
import jp.co.ndensan.reams.db.dbz.business.KaigoHihokenshaNumber;
import jp.co.ndensan.reams.db.dbz.business.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;

/**
 * 被保険者の取得、更新、削除を行うインタフェースです。
 *
 * @author N3327 三浦 凌
 */
public interface IHihokenshaDaichoManager {

    /**
     * 市町村コードと被保険者番号から、被保険者を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @return 条件に該当する被保険者
     */
    Hihokensha get被保険者台帳(ShichosonCode 市町村コード, KaigoHihokenshaNumber 被保険者番号);

    /**
     * 被保険者番号から、被保険者を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 条件に該当する被保険者
     */
    HihokenshaList get被保険者台帳(KaigoHihokenshaNumber 被保険者番号);

    /**
     * 市町村コードと識別コードから、被保険者を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     * @return 条件に該当する被保険者
     */
    HihokenshaList get被保険者台帳(ShichosonCode 市町村コード, IShikibetsuCode 識別コード);

    /**
     * 識別コードから、被保険者を取得します。
     *
     * @param 識別コード 識別コード
     * @return 条件に該当する被保険者
     */
    HihokenshaList get被保険者台帳(IShikibetsuCode 識別コード);

    /**
     * 被保険者の情報を追加・更新します。
     *
     * @param 被保険者 追加・更新したい被保険者
     * @return 追加・更新が成功したかどうか
     */
    boolean save(Hihokensha 被保険者);

    /**
     * 被保険者の情報を削除します。
     *
     * @param 被保険者 削除したい被保険者
     * @return 削除が成功したかどうか
     */
    boolean remove(Hihokensha 被保険者);
}
