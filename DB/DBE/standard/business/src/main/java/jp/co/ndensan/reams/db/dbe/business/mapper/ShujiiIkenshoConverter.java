/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ShujiiIkensho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ShujiiIkenshoItemForResult;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.IShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ShujiiIkenshoItem;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 主治医意見書の結果を変換するConverterクラスです。
 *
 * @author N8156 宮本 康
 */
class ShujiiIkenshoConverter {

    private final ShujiiIkensho 意見書;

    /**
     * インスタンスを生成します。
     *
     * @param 意見書 意見書
     */
    ShujiiIkenshoConverter(ShujiiIkensho 意見書) {
        this.意見書 = requireNonNull(意見書, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書"));
    }

    /**
     * 引数の意見書項目区分に該当する意見書項目と意見書結果（RString型）から意見書結果（ShujiiIkenshoItemForResult型）を生成して返します。
     *
     * @param 意見書項目区分 意見書項目区分
     * @param 意見書結果 意見書結果（RString型）
     * @return 意見書結果
     */
    ShujiiIkenshoItemForResult create意見書結果(IShujiiIkenshoItemKubun 意見書項目区分, RString 意見書結果) {
        ShujiiIkenshoItem item = (ShujiiIkenshoItem) 意見書.get意見書項目(意見書項目区分);
        return item == null ? null : new ShujiiIkenshoItemForResult(item, 意見書結果);
    }

    /**
     * 引数の意見書項目区分に該当する意見書項目と意見書結果（int型）から意見書結果（ShujiiIkenshoItemForResult型）を生成して返します。
     *
     * @param 意見書項目区分 意見書項目区分
     * @param 意見書結果 意見書結果（int型）
     * @return 意見書結果
     */
    ShujiiIkenshoItemForResult create意見書結果(IShujiiIkenshoItemKubun 意見書項目区分, int 意見書結果) {
        return create意見書結果(意見書項目区分, new RString(String.valueOf(意見書結果)));
    }

    /**
     * 引数の意見書項目区分に該当する意見書項目と意見書結果（boolean型）から意見書結果（ShujiiIkenshoItemForResult型）を生成して返します。
     *
     * @param 意見書項目区分 意見書項目区分
     * @param 意見書結果 意見書結果（boolean型）
     * @return 意見書結果
     */
    ShujiiIkenshoItemForResult create意見書結果(IShujiiIkenshoItemKubun 意見書項目区分, boolean 意見書結果) {
        return create意見書結果(意見書項目区分, new RString(意見書結果 ? "1" : "0"));
    }

    /**
     * 引数の意見書項目区分に該当する意見書結果をRString型で返します。
     *
     * @param 意見書項目区分 意見書項目区分
     * @return 意見書結果
     */
    RString get意見書結果ByStringValue(IShujiiIkenshoItemKubun 意見書項目区分) {
        ShujiiIkenshoItemForResult result = (ShujiiIkenshoItemForResult) 意見書.get意見書項目(意見書項目区分);
        return result == null ? null : result.get意見書結果();
    }

    /**
     * 引数の意見書項目区分に該当する意見書結果をint型で返します。
     *
     * @param 意見書項目区分 意見書項目区分
     * @return 意見書結果
     */
    int get意見書結果ByIntValue(IShujiiIkenshoItemKubun 意見書項目区分) {
        RString result = get意見書結果ByStringValue(意見書項目区分);
        return result == null ? 0 : Integer.parseInt(result.toString());
    }

    /**
     * 引数の意見書項目区分に該当する意見書結果をCode型で返します。
     *
     * @param 意見書項目区分 意見書項目区分
     * @return 意見書結果
     */
    Code get意見書結果ByCodeValue(IShujiiIkenshoItemKubun 意見書項目区分) {
        RString result = get意見書結果ByStringValue(意見書項目区分);
        return result == null ? null : new Code(result);
    }

    /**
     * 引数の意見書項目区分に該当する意見書結果をboolean型で返します。
     *
     * @param 意見書項目区分 意見書項目区分
     * @return 意見書結果
     */
    boolean is意見書結果(IShujiiIkenshoItemKubun 意見書項目区分) {
        RString result = get意見書結果ByStringValue(意見書項目区分);
        return result == null ? false : !result.equals(new RString("0"));
    }
}
