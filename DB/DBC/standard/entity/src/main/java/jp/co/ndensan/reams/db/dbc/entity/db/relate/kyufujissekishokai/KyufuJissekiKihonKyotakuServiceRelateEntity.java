/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3025KyufujissekiKyotakuServiceEntity;

/**
 * 給付実績基本居宅サービス計画費Entityクラスです。
 *
 * @reamsid_L DBC-2970-170 dingyi
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiKihonKyotakuServiceRelateEntity implements Serializable {

    private static final long serialVersionUID = 8607111137120236592L;

    private DbT3025KyufujissekiKyotakuServiceEntity 給付実績基本居宅サービス計画費データ;
    private DbT3017KyufujissekiKihonEntity 給付実績基本データ;
}
