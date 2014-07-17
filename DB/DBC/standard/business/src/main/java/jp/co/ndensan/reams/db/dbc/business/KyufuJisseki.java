/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 給付実績の情報を保持するクラス
 *
 * @author n8223 朴義一
 */
public class KyufuJisseki {

    private final KyufuJissekiKihon 基本;
    private final KyufuJissekiMeisaiCollection 明細リスト;
    private final KyufuJissekiShukeiCollection 集計リスト;
    private final KyufuJissekiShafukuKeigenCollection 社会福祉法人軽減額リスト;

    /**
     * 引数から値を受け取るコンストラクタです。
     *
     * @param 基本 基本
     * @param 明細リスト 明細リスト
     * @param 集計リスト 集計リスト
     * @param 社会福祉法人軽減額リスト 社会福祉法人軽減額リスト
     * @throws NullPointerException 基本情報にnullが渡されたとき
     */
    public KyufuJisseki(KyufuJissekiKihon 基本, KyufuJissekiMeisaiCollection 明細リスト, KyufuJissekiShukeiCollection 集計リスト,
            KyufuJissekiShafukuKeigenCollection 社会福祉法人軽減額リスト) throws NullPointerException {

        this.基本 = 基本;
        this.明細リスト = 明細リスト;
        this.集計リスト = 集計リスト;
        this.社会福祉法人軽減額リスト = 社会福祉法人軽減額リスト;

    }

    /**
     * 基本情報を返します。
     *
     * @return 基本情報
     */
    public KyufuJissekiKihon get基本() {
        return 基本;
    }

    /**
     * 明細リストの情報を返します。
     *
     * @return 明細情報
     */
    public KyufuJissekiMeisaiCollection get明細リスト() {
        return 明細リスト;
    }

    /**
     * 集計リストの情報を返します。
     *
     * @return 集計情報
     */
    public KyufuJissekiShukeiCollection get集計リスト() {
        return 集計リスト;
    }

    /**
     * 社会福祉法人軽減額リストの情報を返します。
     *
     * @return 基本情報
     */
    public KyufuJissekiShafukuKeigenCollection get社会福祉法人軽減額リスト() {
        return 社会福祉法人軽減額リスト;
    }
}
