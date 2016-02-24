/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kanri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbx.definition.core.TsukiShorkiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 期月のリストを保持します。
 */
public class KitsukiList {

    private final List<Kitsuki> kitsukiのList;

    /**
     * コンストラクタです。
     *
     * @param kitsukiList 期月のリスト
     */
    public KitsukiList(List<Kitsuki> kitsukiList) {
        this.kitsukiのList = kitsukiList;
    }

    /**
     * パラメータの月に該当する期月を返します。
     *
     * @param 月 月
     * @return 期月
     */
    public Kitsuki get月の期(Tsuki 月) {
        for (Kitsuki kitsuki : kitsukiのList) {
            if (月.getコード().equals(kitsuki.get月().getコード())) {
                return kitsuki;
            }
        }
        return new Kitsuki(月, RString.EMPTY, TsukiShorkiKubun.デフォルト, false, KitsukiHyoki.EMPTY);
    }

    /**
     * パラメータの期に該当する期月を返します。
     *
     * @param 期 期
     * @return 期月リスト
     */
    public List<Kitsuki> get期の月(int 期) {
        List<Kitsuki> list = new ArrayList<>();
        for (Kitsuki kitsuki : kitsukiのList) {
            if (期 == kitsuki.get期AsInt()) {
                list.add(kitsuki);
            }
        }
        return list;
    }

    /**
     * パラメータの期に該当する期月を返します。
     *
     * @param 期 期
     * @return 最初の月
     */
    public Kitsuki get期の最初月(int 期) {
        List<Kitsuki> list = get期の月(期);
        if (list.isEmpty()) {
            return new Kitsuki(Tsuki._4月, new RString(String.valueOf(期)), TsukiShorkiKubun.デフォルト, false, KitsukiHyoki.EMPTY);
        }

        Map<Tsuki, Integer> tsukiMap = new HashMap();
        for (int i = 0; i < Tsuki.values().length; i++) {
            tsukiMap.put(Tsuki.values()[i], i);
        }
        Kitsuki kitsuki = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (tsukiMap.get(list.get(i).get月()) < tsukiMap.get(kitsuki.get月())) {
                kitsuki = list.get(i);
            }
        }
        return kitsuki;
    }

    /**
     * 普徴現年度で取得した期月の中で、最終法定納期の期月を返します。
     *
     * @return 期月
     */
//    public Kitsuki get最終法定納期() {
// TODO 南京で確認する
//    }
    /**
     * 保持する最後の期月を返します。
     *
     * @return 最後の期月
     */
    public Kitsuki getLast() {
        // TODO 作成方法検討要
        Kitsuki kitsuki = kitsukiのList.get(0);
        for (int i = 1; i < kitsukiのList.size(); i++) {
            if (kitsuki.get期AsInt() < kitsukiのList.get(i).get期AsInt()) {
                kitsuki = kitsukiのList.get(i);
            }
        }
        return new Kitsuki(Tsuki.翌年度5月, RString.EMPTY, TsukiShorkiKubun.デフォルト, false, KitsukiHyoki.EMPTY);
    }

    /**
     * 仮算定期間の期月だけを抽出した新しい期月リストを返します。
     *
     * @return 期月リスト
     */
    public KitsukiList filtered仮算定期間() {
        List<Kitsuki> list = new ArrayList<>();
        for (Kitsuki kitsuki : kitsukiのList) {
            if (kitsuki.get月処理区分().is仮算定期()) {
                list.add(kitsuki);
            }
        }
        return new KitsukiList(list);
    }

    /**
     * 本算定期間の期月（法定納期分）を抽出した新しい期月リストを返します。
     *
     * @return 期月リスト
     */
    public KitsukiList filtered本算定期間() {
        List<Kitsuki> list = new ArrayList<>();
        for (Kitsuki kitsuki : kitsukiのList) {
            if (kitsuki.get月処理区分().is本算定期()) {
                list.add(kitsuki);
            }
        }
        return new KitsukiList(list);
    }

    /**
     * 指定の月以降の期月のみを保持した、期月リストを返します。
     *
     * @param 期 期
     * @return 期月リスト
     */
    public KitsukiList filteredLater期(int 期) {
        List<Kitsuki> list = new ArrayList<>();
        for (Kitsuki kitsuki : kitsukiのList) {
            if (期 <= kitsuki.get期AsInt()) {
                list.add(kitsuki);
            }
        }

        return new KitsukiList(list);
    }

    /**
     * 指定の期以降の期月のみを保持した、期月リストを返します。
     *
     * @param 月 月
     * @return 期月リスト
     */
    public KitsukiList filteredLater月(Tsuki 月) {
        List<Kitsuki> list = new ArrayList<>();
        Map<Tsuki, Integer> tsukiMap = new HashMap();
        for (int i = 0; i < Tsuki.values().length; i++) {
            tsukiMap.put(Tsuki.values()[i], i);
        }
        for (Kitsuki kitsuki : kitsukiのList) {
            if (tsukiMap.get(月) <= tsukiMap.get(kitsuki.get月())) {
                list.add(kitsuki);
            }
        }
        return new KitsukiList(list);
    }

    /**
     * 指定の月(第1引数)から月(第2引数)の範囲で構成される新しい期月リストを返します。
     *
     * @param from月 月
     * @param to月 月
     * @return 期月リスト
     * @throws IllegalArgumentException From月＞To月の場合
     */
    public KitsukiList subListBy月(Tsuki from月, Tsuki to月) {

        Map<Tsuki, Integer> tsukiMap = new HashMap();
        for (int i = 0; i < Tsuki.values().length; i++) {
            tsukiMap.put(Tsuki.values()[i], i);
        }
        if (tsukiMap.get(to月) < tsukiMap.get(from月)) {
            throw new IllegalArgumentException();
        }
        List<Kitsuki> list = new ArrayList<>();

        for (Kitsuki kitsuki : kitsukiのList) {
            int 月 = tsukiMap.get(kitsuki.get月());
            if (tsukiMap.get(from月) < 月 && 月 < tsukiMap.get(to月)) {
                list.add(kitsuki);
            }
        }
        return new KitsukiList(list);
    }

    /**
     * 指定の期(第1引数)から期(第2引数)の範囲で構成される新しい期月リストを返します。同じ期の月が複数ある場合、すべてを含みます。
     *
     * @param from期 期
     * @param to期 期
     * @return 期月リスト
     * @throws IllegalArgumentException From期＞To期の場合
     */
    public KitsukiList subListBy期(int from期, int to期) {
        if (to期 < from期) {
            throw new IllegalArgumentException();
        }
        List<Kitsuki> list = new ArrayList<>();

        for (Kitsuki kitsuki : kitsukiのList) {
            if (from期 < kitsuki.get期AsInt() && kitsuki.get期AsInt() < to期) {
                list.add(kitsuki);
            }
        }
        return new KitsukiList(list);
    }

    /**
     * 保持する期月をList型で返します。
     *
     * @return 期月リスト
     */
    public List<Kitsuki> toList() {
        return kitsukiのList;
    }
}
