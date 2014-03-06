/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 主治医意見書作成依頼対象者のリストを扱うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class ShujiiIkenshoIraiTaishoshaList implements Iterable {

    private final List<ShujiiIkenshoIraiTaishosha> taishoshaList;

    /**
     * コンストラクタです。
     *
     * @param 主治医意見書作成依頼処理対象者List 主治医意見書作成依頼処理対象者のリスト
     */
    public ShujiiIkenshoIraiTaishoshaList(List<ShujiiIkenshoIraiTaishosha> 主治医意見書作成依頼処理対象者List) {
        this.taishoshaList = 主治医意見書作成依頼処理対象者List;
    }

    /**
     * 申請書管理番号に一致する主治医意見書作成依頼処理対象者を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 主治医意見書作成依頼処理対象者
     * @throws IllegalArgumentException 存在しない対象の申請書管理番号を指定したとき
     * @throws NullPointerException 引数がNULLのとき
     */
    public ShujiiIkenshoIraiTaishosha get主治医意見書作成依頼処理対象者(ShinseishoKanriNo 申請書管理番号)
            throws IllegalArgumentException, NullPointerException {
        requireNonNull(申請書管理番号, Messages.E00001.replace("申請書管理番号").getMessage());
        for (ShujiiIkenshoIraiTaishosha taishosha : taishoshaList) {
            if (taishosha.get申請書管理番号().value().equals(申請書管理番号.value())) {
                return taishosha;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("対応する主治医意見書作成依頼処理対象者").getMessage());
    }

    /**
     * 市町村コードに一致する主治医意見書作成依頼処理対象者のリストを返します。<br />
     * 一致する対象者がいない場合Collections.EMPTY_LISTを返します。
     *
     * @param 市町村コード 市町村コード
     * @return 主治医意見書作成依頼対象者のリスト
     * @throws NullPointerException 引数がNULLのとき
     */
    public ShujiiIkenshoIraiTaishoshaList sub主治医意見書作成依頼処理対象者List(ShichosonCode 市町村コード)
            throws NullPointerException {
        requireNonNull(市町村コード, Messages.E00001.replace("市町村コード").getMessage());
        List<ShujiiIkenshoIraiTaishosha> list = new ArrayList<>();
        for (ShujiiIkenshoIraiTaishosha taishosha : taishoshaList) {
            if (taishosha.get市町村コード().equals(市町村コード)) {
                list.add(taishosha);
            }
        }
        if (list.isEmpty()) {
            list = Collections.EMPTY_LIST;
        }
        return new ShujiiIkenshoIraiTaishoshaList(list);
    }

    /**
     * 主治医意見書作成依頼処理対象者リストのサイズを返します。
     *
     * @return 認定申請取下げ対称者リストのサイズ
     */
    public int size() {
        return taishoshaList.size();
    }

    @Override
    public Iterator iterator() {
        return taishoshaList.iterator();
    }
}
