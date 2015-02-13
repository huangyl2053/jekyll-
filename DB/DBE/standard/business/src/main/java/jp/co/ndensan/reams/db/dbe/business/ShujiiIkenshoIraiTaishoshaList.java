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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;

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
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        for (ShujiiIkenshoIraiTaishosha taishosha : taishoshaList) {
            if (taishosha.get申請書管理番号().value().equals(申請書管理番号.value())) {
                return taishosha;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する主治医意見書作成依頼処理対象者").evaluate());
    }

    /**
     * 証記載保険者番号に一致する主治医意見書作成依頼処理対象者のリストを返します。<br />
     * 一致する対象者がいない場合Collections.EMPTY_LISTを返します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return 主治医意見書作成依頼対象者のリスト
     * @throws NullPointerException 引数がNULLのとき
     */
    public ShujiiIkenshoIraiTaishoshaList sub主治医意見書作成依頼処理対象者List(ShoKisaiHokenshaNo 証記載保険者番号)
            throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        List<ShujiiIkenshoIraiTaishosha> list = new ArrayList<>();
        for (ShujiiIkenshoIraiTaishosha taishosha : taishoshaList) {
            if (taishosha.get証記載保険者番号().equals(証記載保険者番号)) {
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
