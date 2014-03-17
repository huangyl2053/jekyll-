/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiYukoKikanKaishiYMD;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 合議体のリストを扱うクラスです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiList implements Iterable<Gogitai> {

    private final List<Gogitai> 合議体List;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 合議体List 合議体List
     * @throws NullPointerException 引数にNullが渡されたとき
     */
    public GogitaiList(List<Gogitai> 合議体List) throws NullPointerException {
        this.合議体List = requireNonNull(合議体List, Messages.E00003.replace("合議体List", getClass().getName()).getMessage());
    }

    /**
     * 合議体情報を指定して、該当する合議体をリスト内から取得します。
     *
     * @param 合議体番号 合議体番号
     * @param 合議体有効期間開始年月日 合議体有効期間開始年月日
     * @return 合議体
     * @throws IllegalArgumentException 合致する合議体が存在しないとき
     */
    public Gogitai get合議体(GogitaiNo 合議体番号, GogitaiYukoKikanKaishiYMD 合議体有効期間開始年月日)
            throws IllegalArgumentException {
        for (Gogitai 合議体 : 合議体List) {
            if (isキー項目が一致(合議体, 合議体番号, 合議体有効期間開始年月日)) {
                return 合議体;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("合致する合議体").getMessage());
    }

    private boolean isキー項目が一致(Gogitai 合議体, GogitaiNo 合議体番号, GogitaiYukoKikanKaishiYMD 合議体有効期間開始年月日) {

        if (!合議体番号.equals(合議体.get合議体情報().get合議体番号())) {
            return false;
        }
        if (!合議体有効期間開始年月日.equals(合議体.get合議体情報().get有効期間開始年月日())) {
            return false;
        }
        return true;
    }

    /**
     * 合議体Listが空であるかどうかを返します。
     *
     * @return 空ならtrue
     */
    public boolean isEmpty() {
        return 合議体List.isEmpty();
    }

    /**
     * リストのサイズを返します。
     *
     * @return サイズ
     */
    public int size() {
        return 合議体List.size();
    }

    @Override
    public Iterator<Gogitai> iterator() {
        return 合議体List.iterator();
    }
}
