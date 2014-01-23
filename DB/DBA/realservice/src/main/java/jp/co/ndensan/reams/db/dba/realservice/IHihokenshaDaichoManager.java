/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice;

import jp.co.ndensan.reams.db.dba.business.Hihokensha;
import jp.co.ndensan.reams.db.dba.definition.valueobject.HihokenshaKubun;
import jp.co.ndensan.reams.db.dba.business.HihokenshaList;
import jp.co.ndensan.reams.db.dba.definition.valueobject.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNumber;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 被保険者の取得、登録、更新、削除を行うインタフェースです。
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
     * 引数から被保険者情報を生成し、新しく登録します。<br />
     * 登録の際、被保険者番号の採番を行います。
     *
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     * @param 被保険者区分 被保険者区分
     * @param 資格取得届出年月日 資格取得届出年月日
     * @param 資格取得年月日 資格取得年月日
     * @param 資格取得事由 資格取得事由
     * @param 一号年齢到達日 一号年齢到達日
     * @return 登録が成功したかどうか
     */
    boolean save(ShichosonCode 市町村コード, IShikibetsuCode 識別コード, HihokenshaKubun 被保険者区分,
            RDate 資格取得届出年月日, RDate 資格取得年月日, ShikakuShutokuJiyu 資格取得事由, RDate 一号年齢到達日);

    /**
     * 引数から被保険者情報を生成し、新しく登録します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     * @param 被保険者区分 被保険者区分
     * @param 資格取得届出年月日 資格取得届出年月日
     * @param 資格取得年月日 資格取得年月日
     * @param 資格取得事由 資格取得事由
     * @param 一号年齢到達日 一号年齢到達日
     * @return 登録が成功したかどうか
     */
    boolean save(KaigoHihokenshaNumber 被保険者番号, ShichosonCode 市町村コード, IShikibetsuCode 識別コード, HihokenshaKubun 被保険者区分,
            RDate 資格取得届出年月日, RDate 資格取得年月日, ShikakuShutokuJiyu 資格取得事由, RDate 一号年齢到達日);

    /**
     * 被保険者の情報の登録・更新をします。
     *
     * @param 被保険者 登録・更新したい被保険者
     * @return 登録・更新が成功したかどうか
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
