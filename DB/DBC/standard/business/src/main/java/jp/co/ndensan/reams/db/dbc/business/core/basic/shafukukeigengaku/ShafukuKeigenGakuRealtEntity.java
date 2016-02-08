/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic.shafukukeigengaku;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3051ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author ZHANGGP
 */
public class ShafukuKeigenGakuRealtEntity {

    private final DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity
     */
    public ShafukuKeigenGakuRealtEntity(DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity) {
        this.entity = entity;
    }

    /**
     * サービス種類コードを取得します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCode();
    }

    /**
     * 軽減率を取得します。
     *
     * @return 軽減率
     */
    public Decimal get軽減率() {
        return entity.getKeigenritsu();
    }

    /**
     * 受領すべき利用者負担の総額を取得します。
     *
     * @return 受領すべき利用者負担の総額
     */
    public int get受領すべき利用者負担の総額() {
        return entity.getRiyoshaFutangakuTotal();
    }

    /**
     * 軽減額を取得します。
     *
     * @return 軽減額
     */
    public int get軽減額() {
        return entity.getKeigengaku();
    }

    /**
     * 軽減後利用者負担額します。
     *
     * @return 軽減後利用者負担額
     */
    public int get軽減後利用者負担額() {
        return entity.getKeigengoRiyoshaFutangaku();
    }

    /**
     * 備考します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity.getBiko();
    }
}
