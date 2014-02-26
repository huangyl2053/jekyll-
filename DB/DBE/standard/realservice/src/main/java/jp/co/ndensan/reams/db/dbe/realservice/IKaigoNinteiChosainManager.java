/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.KaigoNinteiChosain;
import jp.co.ndensan.reams.db.dbe.business.KaigoNinteiChosainCollection;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosainJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoChosainNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;

/**
 * 介護認定調査員情報を扱うクラスのインターフェースです。
 *
 * @author N8187 久保田 英男
 */
public interface IKaigoNinteiChosainManager {

    /**
     * 引数の条件に該当する介護認定調査員情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @param 介護調査員番号 介護調査員番号
     * @return 介護認定調査員
     */
    KaigoNinteiChosain get介護認定調査員(ShichosonCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, KaigoChosainNo 介護調査員番号);

    /**
     * 引数の条件に該当する介護認定調査員情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @param 介護調査員番号 介護調査員番号
     * @param 調査員の状況 調査員の状況
     * @return 介護認定調査員
     */
    KaigoNinteiChosain get介護認定調査員(ShichosonCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, KaigoChosainNo 介護調査員番号, ChosainJokyo 調査員の状況);

    /**
     * 引数の条件に該当する介護認定調査員情報のコレクションクラスを取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @return 介護認定調査員のコレクションクラス
     */
    KaigoNinteiChosainCollection get介護認定調査員List(ShichosonCode 市町村コード, KaigoJigyoshaNo 介護事業者番号);

    /**
     * 引数の条件に該当する介護認定調査員情報のコレクションクラスを取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @param 調査員の状況 調査員の状況
     * @return 介護認定調査員のコレクションクラス
     */
    KaigoNinteiChosainCollection get介護認定調査員List(ShichosonCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, ChosainJokyo 調査員の状況);

    /**
     * 引数の条件に該当する介護認定調査員情報のコレクションクラスを取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 調査員の状況 調査員の状況
     * @return 介護認定調査員のコレクションクラス
     */
    KaigoNinteiChosainCollection get介護認定調査員List(ShichosonCode 市町村コード, ChosainJokyo 調査員の状況);

    /**
     * 引数の条件に該当する介護認定調査員情報のコレクションクラスを取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 介護認定調査員のコレクションクラス
     */
    KaigoNinteiChosainCollection get介護認定調査員List(ShichosonCode 市町村コード);

    /**
     * 引数の介護認定調査員情報を新規登録、または更新します。
     *
     * @param 介護認定調査員情報 介護認定調査員情報
     * @return 新規登録、または更新が成功した場合はtrueを返します。
     */
    boolean save(KaigoNinteiChosain 介護認定調査員情報);

    /**
     * 引数の介護認定調査員情報を削除します。
     *
     * @param 介護認定調査員情報 介護認定調査員情報
     * @return 削除が成功した場合はtrueを返します。
     */
    boolean remove(KaigoNinteiChosain 介護認定調査員情報);
}
