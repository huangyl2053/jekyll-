/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaiiinjoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会スケジュール表一覧表示のMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShinsakaiIinJohoKaisaiMapperParameter {

    private final RString KaisaiYoteiKikanFrom;
    private final RString KaisaiYoteiKikanTo;
    private final boolean usesFrom;
    private final boolean usesTo;

    /**
     * コンストラクタです。
     *
     * @param KaisaiYoteiKikanFrom 開催期間FROM
     * @param KaisaiYoteiKikanTo 開催期間TO
     */
    private ShinsakaiIinJohoKaisaiMapperParameter(RString KaisaiYoteiKikanFrom, RString KaisaiYoteiKikanTo, boolean usesFrom, boolean usesTo) {
        this.KaisaiYoteiKikanFrom = KaisaiYoteiKikanFrom;
        this.KaisaiYoteiKikanTo = KaisaiYoteiKikanTo;
        this.usesFrom = usesFrom;
        this.usesTo = usesTo;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param KaisaiYoteiKikanFrom 開催予定期間FROM
     * @param KaisaiYoteiKikanTo 開催予定期間TO
     * @return 介護認定審査会スケジュール表一覧表示パラメータ
     */
    public static ShinsakaiIinJohoKaisaiMapperParameter createParamByKaisaiYoteiKikan(
            RString KaisaiYoteiKikanFrom, RString KaisaiYoteiKikanTo) {
        return new ShinsakaiIinJohoKaisaiMapperParameter(KaisaiYoteiKikanFrom,
                KaisaiYoteiKikanTo,
                !(RString.isNullOrEmpty(KaisaiYoteiKikanFrom)),
                !(RString.isNullOrEmpty(KaisaiYoteiKikanTo)));
    }
}
