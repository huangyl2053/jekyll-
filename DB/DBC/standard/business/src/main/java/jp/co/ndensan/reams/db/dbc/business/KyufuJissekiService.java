/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * サービス種類ごとの給付実績集計額を保持するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyufuJissekiService {

    private final ServiceShurui サービス種類;
    private final Decimal 利用者負担額合計;
    private final Decimal 単位数合計;
    private final Decimal 保険請求分請求額合計;
    private final KyufuJissekiKeyInfo 給付実績キー情報;

    /**
     * インスタンスを生成します。
     *
     * @param サービス種類 サービス種類
     * @param 利用者負担額合計 利用者負担額合計
     * @param 単位数合計 単位数合計
     * @param 保険請求分請求額合計 保険請求分請求額合計
     * @param 給付実績キー情報 給付実績キー情報
     */
    public KyufuJissekiService(ServiceShurui サービス種類,
            Decimal 利用者負担額合計,
            Decimal 単位数合計,
            Decimal 保険請求分請求額合計,
            KyufuJissekiKeyInfo 給付実績キー情報) {
        this.サービス種類 = requireNonNull(サービス種類, Messages.E00001.replace("サービス種類コード").getMessage());
        this.利用者負担額合計 = requireNonNull(利用者負担額合計, Messages.E00001.replace("利用者負担額合計").getMessage());
        this.単位数合計 = requireNonNull(単位数合計, Messages.E00001.replace("単位数合計").getMessage());
        this.保険請求分請求額合計 = requireNonNull(保険請求分請求額合計,
                Messages.E00001.replace("保険請求分請求額合計").getMessage());
        this.給付実績キー情報 = requireNonNull(給付実績キー情報, Messages.E00001.replace("給付実績キー情報").getMessage());
    }

    /**
     * サービス種類を返します。
     *
     * @return サービス種類
     */
    public ServiceShurui getサービス種類() {
        return サービス種類;
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
     * 利用者負担額合計と単位数合計と保険請求分請求額合計の合計金額を返します。
     *
     * @return 合計金額
     */
    public Decimal get合計金額() {
        return 利用者負担額合計.add(単位数合計).add(保険請求分請求額合計);
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
