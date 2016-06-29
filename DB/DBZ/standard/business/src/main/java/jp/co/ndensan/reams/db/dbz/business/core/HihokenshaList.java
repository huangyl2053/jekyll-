/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.comparator.HihokenshaComparators.ShichosonCodeComparator;
import jp.co.ndensan.reams.db.dbz.business.core.comparator.HihokenshaComparators.RegisterDateTimeComparator;
import jp.co.ndensan.reams.db.dbz.business.util.MultiComparator;
import jp.co.ndensan.reams.db.dbz.business.core.comparator.ShikibetsuCodeComparator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * {@link Hihokensha Hihokensha}のリストを扱います。
 *
 * @author N3327 三浦 凌
 */
@Deprecated
public class HihokenshaList implements Iterable<Hihokensha> {

    private final List<Hihokensha> list;

    /**
     * {@code List<Hihokensha>}から、HihokenshaListを生成します。<br />
     * 地方公共団体コードの昇順、識別コードの昇順、被保険者台帳登録日時の降順の優先順でソートされます。
     *
     * @param hihokenshaList {@link Hihokensha 被保険者}の{@link List リスト}
     * @throws NullPointerException 引数がnullのとき。
     */
    public HihokenshaList(List<Hihokensha> hihokenshaList) throws NullPointerException {
        this.list = requireNonNull(hihokenshaList, errorMessageForConstructor(nameWithClassName("Hihokenshaのリスト", "List<Hihokensha>")));
        Collections.sort(list, new MultiComparator<>(
                ShichosonCodeComparator.ASC, ShikibetsuCodeComparator.ASC, RegisterDateTimeComparator.DESC));
    }

    /**
     * {@link LasdecCode 市町村コード}を指定して、新しいHihokenshaListを返します。
     *
     * @param 市町村コード {@link LasdecCode 市町村コード}
     * @return
     * 指定の保険者（市町村）に属する{@link Hihokensha Hihokensha}だけを集めた、新しいHihokenshaList
     */
    public HihokenshaList subHihokenshaList(LasdecCode 市町村コード) {
        List<Hihokensha> subList = new ArrayList<>();
        for (Hihokensha hihokensha : list) {
            if (isHihokenshaWhoLivesIn(市町村コード, hihokensha)) {
                subList.add(hihokensha);
            }
        }
        return new HihokenshaList(optimiseList(subList));
    }

    /**
     * {@link HihokenshaNo 被保険者番号}が一致する、{@link Hihokensha hihokensha}を返します。
     * 複数のHihokenshaが該当する可能性もありますが、 その場合、
     * 地方公共団体コードの昇順、識別コードの昇順、被保険者台帳登録日時の降順に優先され、1件を返します。
     *
     * 特定の市町村に属することが判明している場合は、
     * {@link #subHihokenshaList(jp.co.ndensan.reams.uz.uza.biz.LasdecCode) subHihokenshaList()}により、
     * 市町村を指定することで、希望のHihokenshaを得ることができます。
     *
     * @param 被保険者番号 {@link HihokenshaNo 被保険者番号}
     * @return 指定の被保険者番号に該当するHihokensha
     * @throws IllegalArgumentException 指定の被保険者番号に該当するHihokenshaがいないとき。
     */
    public Hihokensha getHihokensha(HihokenshaNo 被保険者番号) throws IllegalArgumentException {
        for (Hihokensha hihokensha : list) {
            if (isHihokenshawhoseHihokenshaNoIs(被保険者番号, hihokensha)) {
                return hihokensha;
            }
        }
        throw new IllegalArgumentException(errorMessageForMethod("指定の"
                + nameWithClassName("被保険者番号", simpleNameOf(HihokenshaNo.class))));
    }

    /**
     * {@link ShikibetsuCode 識別コード}が一致する、{@link Hihokensha hihokensha}を返します。
     * 複数のHihokenshaが該当する可能性もありますが、 その場合、
     * 地方公共団体の昇順、識別コードの昇順、被保険者台帳登録日時の降順に優先され、1件を返します。
     *
     * 特定の市町村に属することが判明している場合は、
     * {@link #subHihokenshaList(jp.co.ndensan.reams.uz.uza.biz.LasdecCode) subHihokenshaList()}により、
     * 市町村を指定することで、希望のHihokenshaを得ることができます。
     *
     * @param 識別コード {@link ShikibetsuCode 識別コード}
     * @return 指定の識別コードに該当するHihokensha
     * @throws IllegalArgumentException 指定の識別コードに該当するHihokenshaがいないとき。
     */
    public Hihokensha getHihokensha(ShikibetsuCode 識別コード) throws IllegalArgumentException {
        for (Hihokensha hihokensha : list) {
            if (isHihokenshawhoseShikibetsuCodeIs(識別コード, hihokensha)) {
                return hihokensha;
            }
        }
        throw new IllegalArgumentException(errorMessageForMethod("指定の"
                + nameWithClassName("識別コード", simpleNameOf(ShikibetsuCode.class))));
    }

    /**
     * コレクション中のHihokenshaの数を返します。
     *
     * @return コレクション中のHihokenshaの数
     */
    public int size() {
        return this.list.size();
    }

    /**
     * このコレクションが空かどうかを返します。
     *
     * @return 空ならture。
     */
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Iterator<Hihokensha> iterator() {
        return this.list.iterator();
    }

    private boolean isHihokenshaWhoLivesIn(LasdecCode lasdecCode, Hihokensha hihokensha) {
        return lasdecCode.equals(hihokensha.get市町村コード());
    }

    private boolean isHihokenshawhoseHihokenshaNoIs(HihokenshaNo hihokenshaNo, Hihokensha hihokensha) {
        return hihokenshaNo.equals(hihokensha.get被保険者番号());
    }

    private boolean isHihokenshawhoseShikibetsuCodeIs(ShikibetsuCode shikibetsuCode, Hihokensha hihokensha) {
        return shikibetsuCode.equals(hihokensha.get識別コード());
    }

    private List<Hihokensha> optimiseList(List<Hihokensha> list) {
        return list.isEmpty() ? Collections.EMPTY_LIST : list;
    }

    private String simpleNameOf(Class clazz) {
        return clazz.getSimpleName();
    }

    private static String nameWithClassName(String name, String className) {
        return name + "(" + className + ")";
    }

    private String errorMessageForConstructor(String str) {
        return UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage(str, simpleNameOf(HihokenshaList.class));
    }

    private String errorMessageForMethod(String str) {
        return UrErrorMessages.存在しない.getMessage().replace(str + "に一致する" + simpleNameOf(Hihokensha.class)).getMessage();
    }
}
