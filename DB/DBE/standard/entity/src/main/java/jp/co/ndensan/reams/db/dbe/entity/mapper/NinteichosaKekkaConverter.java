/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.ninteichosa.Ninteichosahyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaItemForResult;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.NinteichosaItem;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査結果を変換するConverterクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaKekkaConverter {

    private final Ninteichosahyo 調査票;

    /**
     * インスタンスを生成します。
     *
     * @param 調査票 調査票
     */
    public NinteichosaKekkaConverter(Ninteichosahyo 調査票) {
        this.調査票 = requireNonNull(調査票, Messages.E00001.replace("調査票").getMessage());
    }

    /**
     * 引数の調査項目区分に該当する調査項目と調査結果（RString型）から調査結果（NinteichosaItemForResult型）を生成して返します。
     *
     * @param 調査項目区分 調査項目区分
     * @param 調査結果 調査結果（RString型）
     * @return 調査結果
     */
    public NinteichosaItemForResult create調査結果(INinteichosaItemKubun 調査項目区分, RString 調査結果) {
        NinteichosaItem item = (NinteichosaItem) 調査票.get調査項目(調査項目区分);
        return item == null ? null : new NinteichosaItemForResult(item, 調査結果);
    }

    /**
     * 引数の調査項目区分に該当する調査項目と調査結果（int型）から調査結果（NinteichosaItemForResult型）を生成して返します。
     *
     * @param 調査項目区分 調査項目区分
     * @param 調査結果 調査結果（int型）
     * @return 調査結果
     */
    public NinteichosaItemForResult create調査結果(INinteichosaItemKubun 調査項目区分, int 調査結果) {
        return create調査結果(調査項目区分, new RString(String.valueOf(調査結果)));
    }

    /**
     * 引数の調査項目区分に該当する調査結果をRString型で返します。
     *
     * @param 調査項目区分 調査項目区分
     * @return 調査結果
     */
    public RString get調査結果ByStringValue(INinteichosaItemKubun 調査項目区分) {
        NinteichosaItemForResult result = (NinteichosaItemForResult) 調査票.get調査項目(調査項目区分);
        return result == null ? null : result.get調査結果();
    }

    /**
     * 引数の調査項目区分に該当する調査結果をint型で返します。
     *
     * @param 調査項目区分 調査項目区分
     * @return 調査結果
     */
    public int get調査結果ByIntValue(INinteichosaItemKubun 調査項目区分) {
        RString result = get調査結果ByStringValue(調査項目区分);
        return result == null ? 0 : Integer.parseInt(result.toString());
    }

    /**
     * 引数の調査項目区分に該当する調査結果をCode型で返します。
     *
     * @param 調査項目区分 調査項目区分
     * @return 調査結果
     */
    public Code get調査結果ByCodeValue(INinteichosaItemKubun 調査項目区分) {
        RString result = get調査結果ByStringValue(調査項目区分);
        return result == null ? null : new Code(result);
    }
}
