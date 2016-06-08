/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績の基本情報（居宅サービス計画）を保持するクラスです。
 *
 * @author N8223 朴 義一
 */
public class KyufuJissekiKihonKyotakuService {

    private final RString 居宅サービス計画作成区分;
    private final JigyoshaNo 事業所番号;
    private final RString 事業所名;

    /**
     * インスタンスを生成します。
     *
     * @param 居宅サービス計画作成区分 居宅サービス計画作成区分
     * @param 事業所番号 事業所番号
     * @param 事業所名 事業所名
     */
    public KyufuJissekiKihonKyotakuService(
            RString 居宅サービス計画作成区分,
            JigyoshaNo 事業所番号,
            RString 事業所名) {
        this.居宅サービス計画作成区分 = 居宅サービス計画作成区分;
        this.事業所番号 = 事業所番号;
        this.事業所名 = 事業所名;
    }

    /**
     * 居宅サービス計画作成区分を返します。
     *
     * @return 居宅サービス計画作成区分
     */
    public RString get居宅サービス計画作成区分() {
        return 居宅サービス計画作成区分;
    }

    /**
     * 事業所番号を返します。
     *
     * @return 事業所番号
     */
    public JigyoshaNo get事業所番号() {
        return 事業所番号;
    }

    /**
     * 事業所名を返します。
     *
     * @return 事業所名
     */
    public RString get事業所名() {
        return 事業所名;
    }
}
