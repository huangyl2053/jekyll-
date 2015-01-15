/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.IHihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 被保険者台帳情報を検索できることを示すインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IHihokenshaDaichoFinder {

    /**
     * 被保険者台帳のキー項目を指定して、該当する被保険者台帳を1件取得します。<br/>
     * 戻り値は、処理日時の降順で取得されます。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 処理日時 処理日時
     * @return 被保険者台帳
     */
    IOptional<IHihokenshaDaicho> find被保険者台帳(LasdecCode 市町村コード, HihokenshaNo 被保険者番号, YMDHMS 処理日時);

    /**
     * 被保険者番号と市町村コードを指定して、特定の被保険者の台帳情報をListで取得します。<br/>
     * 戻り値は、処理日時の降順で取得されます。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @return 被保険者台帳List
     */
    IItemList<IHihokenshaDaicho> find被保険者台帳List(LasdecCode 市町村コード, HihokenshaNo 被保険者番号);

    /**
     * 識別コードと市町村コードを指定して、特定の被保険者の台帳情報をListで取得します。<br/>
     * 被保険者番号が取得できなかった場合などに利用します。<br/>
     * 戻り値は、処理日時の降順で取得されます。
     *
     * @param 市町村コード 市町村コード
     * @param 識別コード 被保険者番号
     * @return 被保険者台帳List
     */
    IItemList<IHihokenshaDaicho> find被保険者台帳List(LasdecCode 市町村コード, ShikibetsuCode 識別コード);

    /**
     * 市町村コード・被保険者番号・資格取得日を指定して、ある資格取得期間中の被保険者台帳情報をListで取得します。<br/>
     * 戻り値は、処理日時の降順で取得されます。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 資格取得日 資格取得日
     * @return ある資格取得期間中の被保険者台帳List
     */
    IItemList<IHihokenshaDaicho> find被保険者台帳List(LasdecCode 市町村コード, HihokenshaNo 被保険者番号, FlexibleDate 資格取得日);

}
