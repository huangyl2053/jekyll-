/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * サービス種類ごとの給付実績集計額を保持するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyufuJissekiService {

    private final JigyoshaNo 事業者番号;
    private final Decimal 利用者負担額合計;
    private final Decimal 単位数合計;
    private final Decimal 保険請求分請求額合計;
    private final Decimal サービス単位数合計;
    private final KyufuJissekiKeyInfo 給付実績キー情報;

    /**
     * インスタンスを生成します。
     *
     * @param 事業者番号 事業者番号
     * @param 利用者負担額合計 利用者負担額合計
     * @param 単位数合計 単位数合計
     * @param 保険請求分請求額合計 保険請求分請求額合計
     * @param サービス単位数合計 サービス単位数合計
     * @param 給付実績キー情報 給付実績キー情報
     */
    public KyufuJissekiService(JigyoshaNo 事業者番号,
            Decimal 利用者負担額合計,
            Decimal 単位数合計,
            Decimal 保険請求分請求額合計,
            Decimal サービス単位数合計,
            KyufuJissekiKeyInfo 給付実績キー情報) {
        this.事業者番号 = requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        this.利用者負担額合計 = 利用者負担額合計;
        this.単位数合計 = 単位数合計;
        this.保険請求分請求額合計 = 保険請求分請求額合計;
        this.サービス単位数合計 = サービス単位数合計;
        this.給付実績キー情報 = requireNonNull(給付実績キー情報, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績キー情報"));
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return 事業者番号;
    }

    /**
     * 利用者負担額合計を返します。
     *
     * @return 利用者負担額合計
     */
    public Decimal get利用者負担額合計() {
        return 利用者負担額合計;
    }

    /**
     * 単位数合計を返します。
     *
     * @return 単位数合計
     */
    public Decimal get単位数合計() {
        return 単位数合計;
    }

    /**
     * 保険請求分請求額合計を返します。
     *
     * @return 保険請求分請求額合計
     */
    public Decimal get保険請求分請求額合計() {
        return 保険請求分請求額合計;
    }

    /**
     * サービス単位数合計を返します。
     *
     * @return サービス単位数合計
     */
    public Decimal getサービス単位数合計() {
        return サービス単位数合計;
    }

    /**
     * 給付実績キー情報を返します。
     *
     * @return 給付実績キー情報
     */
    public KyufuJissekiKeyInfo get給付実績キー情報() {
        return 給付実績キー情報;
    }

}
