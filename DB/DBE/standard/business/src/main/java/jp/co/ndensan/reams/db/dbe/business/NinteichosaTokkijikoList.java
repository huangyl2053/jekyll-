/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査特記事項のコレクションを扱うクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteichosaTokkijikoList implements Iterable<NinteichosaTokkijiko> {

    private final List<NinteichosaTokkijiko> 認定調査特記事項List;

    /**
     * 引数から、メンバとなるリストを受け取るコンストラクタです。
     *
     * @param 認定調査特記事項List 認定調査特記事項List
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public NinteichosaTokkijikoList(List<NinteichosaTokkijiko> 認定調査特記事項List) throws NullPointerException {
        requireNonNull(認定調査特記事項List, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("認定調査特記事項のリスト", getClass().getName()));
        this.認定調査特記事項List = 認定調査特記事項List;
    }

    /**
     * List内から、指定した認定調査依頼履歴番号に該当する認定調査特記事項を取得します。
     *
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return 認定調査特記事項List
     */
    public NinteichosaTokkijikoList get認定調査特記事項(NinteichosaIraiRirekiNo 認定調査依頼履歴番号) {
        List<NinteichosaTokkijiko> retList = new ArrayList<>();
        for (NinteichosaTokkijiko 認定調査特記事項 : 認定調査特記事項List) {
            if (is依頼履歴番号が一致(認定調査特記事項, 認定調査依頼履歴番号)) {
                retList.add(認定調査特記事項);
            }
        }
        return new NinteichosaTokkijikoList(retList);
    }

    private boolean is依頼履歴番号が一致(NinteichosaTokkijiko 認定調査特記事項, NinteichosaIraiRirekiNo 依頼履歴番号) {
        return 認定調査特記事項.get認定調査依頼履歴番号().equals(依頼履歴番号);
    }

    /**
     * List内から、指定した認定調査特記事項番号に該当する認定調査特記事項を取得します。
     *
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 認定調査特記事項List
     */
    public NinteichosaTokkijikoList get認定調査特記事項(RString 認定調査特記事項番号) {
        List<NinteichosaTokkijiko> retList = new ArrayList<>();
        for (NinteichosaTokkijiko 認定調査特記事項 : 認定調査特記事項List) {
            if (is特記事項番号が一致(認定調査特記事項, 認定調査特記事項番号)) {
                retList.add(認定調査特記事項);
            }
        }
        return new NinteichosaTokkijikoList(retList);
    }

    private boolean is特記事項番号が一致(NinteichosaTokkijiko 認定調査特記事項, RString 特記事項番号) {
        return 認定調査特記事項.get認定調査特記事項番号().equals(特記事項番号);
    }

    /**
     * 認定調査依頼履歴番号と認定調査特記事項番号を指定し、List内から認定調査特記事項を1件取得します。
     *
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 認定調査特記事項
     * @throws IllegalArgumentException 対応する認定調査特記事項が存在しないとき
     */
    public NinteichosaTokkijiko get認定調査特記事項(NinteichosaIraiRirekiNo 認定調査依頼履歴番号, RString 認定調査特記事項番号)
            throws IllegalArgumentException {
        for (NinteichosaTokkijiko 認定調査特記事項 : 認定調査特記事項List) {
            if (is特記事項番号と依頼履歴番号が一致(認定調査特記事項, 認定調査依頼履歴番号, 認定調査特記事項番号)) {
                return 認定調査特記事項;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する認定調査特記事項").evaluate());
    }

    private boolean is特記事項番号と依頼履歴番号が一致(NinteichosaTokkijiko 認定調査特記事項, NinteichosaIraiRirekiNo 依頼履歴番号,
            RString 特記事項番号) {
        return is特記事項番号が一致(認定調査特記事項, 特記事項番号) && is依頼履歴番号が一致(認定調査特記事項, 依頼履歴番号);
    }

    /**
     * コレクションが空であるか否かを返します。
     *
     * @return 空ならtrue
     */
    public boolean isEmpty() {
        return 認定調査特記事項List.isEmpty();
    }

    /**
     * コレクションのサイズを返します。
     *
     * @return サイズ
     */
    public int size() {
        return 認定調査特記事項List.size();
    }

    @Override
    public Iterator iterator() {
        return 認定調査特記事項List.iterator();
    }
}
