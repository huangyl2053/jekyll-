/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaBunrui;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaKomoku;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ISentakushi;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査項目情報を扱うインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface INinteichosaKomoku {

    /**
     * 調査分類を返します。
     *
     * @return 調査分類
     */
    ChosaBunrui get調査分類();

    /**
     * 調査項目番号を返します。
     *
     * @return 調査項目番号
     */
    RString get調査項目番号();

    /**
     * 調査項目を返します。
     *
     * @return 調査項目
     */
    ChosaKomoku get調査項目();

    /**
     * 表示名称を返します。
     *
     * @return 表示名称
     */
    RString get表示名称();

    /**
     * 調査項目の選択肢リストを返します。
     *
     * @return 選択肢リスト
     */
    List<ISentakushi> get選択肢List();

    /**
     * 引数の調査結果コードに該当する選択肢を返します。
     *
     * @param 調査結果コード 調査結果コード
     * @return 選択肢
     */
    ISentakushi get選択肢(RString 調査結果コード);
}
