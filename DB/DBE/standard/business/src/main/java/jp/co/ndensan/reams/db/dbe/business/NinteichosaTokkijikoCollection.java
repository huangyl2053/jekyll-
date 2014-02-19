/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 認定調査特記事項のコレクションを扱うクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteichosaTokkijikoCollection implements Iterable {

    private final List<NinteichosaTokkijiko> 認定調査特記事項List;

    /**
     * 引数から、メンバとなるリストを受け取るコンストラクタです。
     *
     * @param 認定調査特記事項List 認定調査特記事項List
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public NinteichosaTokkijikoCollection(List<NinteichosaTokkijiko> 認定調査特記事項List) throws NullPointerException {
        requireNonNull(認定調査特記事項List, Messages.E00003.replace("認定調査特記事項のリスト", getClass().getName()).getMessage());
        this.認定調査特記事項List = 認定調査特記事項List;
    }

    /**
     * 申請書管理番号と認定調査依頼履歴番号を指定し、対応した認定調査特記事項をCollection内から取得します。<br/>
     * 指定した引数に対応する認定調査特記事項が存在しない場合、IllegalArgumentExceptionが発生します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return 認定調査特記事項
     * @throws IllegalArgumentException 対応する認定調査特記事項が存在しないとき
     */
    public NinteichosaTokkijiko get認定調査特記事項(ShinseishoKanriNo 申請書管理番号, NinteichosaIraiRirekiNo 認定調査依頼履歴番号)
            throws IllegalArgumentException {
        for (NinteichosaTokkijiko 認定調査特記事項 : 認定調査特記事項List) {
            if (is申請書管理番号と認定調査依頼履歴番号が一致(認定調査特記事項, 申請書管理番号, 認定調査依頼履歴番号)) {
                return 認定調査特記事項;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("対応する認定調査特記事項").getMessage());
    }

    private boolean is申請書管理番号と認定調査依頼履歴番号が一致(NinteichosaTokkijiko 認定調査特記事項, ShinseishoKanriNo 申請書管理番号, NinteichosaIraiRirekiNo 認定調査依頼履歴番号) {
        return is申請書管理番号が一致(認定調査特記事項, 申請書管理番号) && is認定調査依頼履歴番号が一致(認定調査特記事項, 認定調査依頼履歴番号);
    }

    private boolean is申請書管理番号が一致(NinteichosaTokkijiko 認定調査特記事項, ShinseishoKanriNo 申請書管理番号) {
        return 認定調査特記事項.get申請書管理番号().equals(申請書管理番号);
    }

    private boolean is認定調査依頼履歴番号が一致(NinteichosaTokkijiko 認定調査特記事項, NinteichosaIraiRirekiNo 認定調査依頼履歴番号) {
        return 認定調査特記事項.get認定調査依頼履歴番号().equals(認定調査依頼履歴番号);
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
