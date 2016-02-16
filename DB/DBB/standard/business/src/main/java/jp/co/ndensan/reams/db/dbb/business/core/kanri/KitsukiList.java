/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kanri;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 期月のリストを保持します。
 */
public class KitsukiList {

    private final List<Kitsuki> kitsukiList;

    /**
     * コンストラクタです。
     *
     * @param kitsukiList 期月のリスト
     */
    public KitsukiList(List<Kitsuki> kitsukiList) {
        this.kitsukiList = kitsukiList;
    }

    /**
     * パラメータの月に該当する期月を返します。
     *
     * @param 月 月
     * @return 期月
     */
    public Kitsuki get月の期(Tsuki 月) {
        for (Kitsuki kitsuki : kitsukiList) {
            if (月.getコード().equals(kitsuki.get月().getコード())) {
                return kitsuki;
            }
        }
        return new Kitsuki(月, RString.EMPTY, null, false, KitsukiHyoki.EMPTY);
    }
}
