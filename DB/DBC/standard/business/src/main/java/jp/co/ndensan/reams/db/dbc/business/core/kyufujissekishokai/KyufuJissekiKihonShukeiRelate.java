/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufuJissekiKihonShukeiRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績基本集計データのbusinessクラスです。
 *
 * @reamsid_L DBC-2970-170 wangjie2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiKihonShukeiRelate implements Serializable {

    private AtenaMeisho 事業者名称;
    private ShikibetsuNoKanri 識別番号管理;
    private KyufujissekiKihon 給付実績基本データ;

    /**
     * コンストラクタです。
     *
     * @param 事業者名称 事業者名称
     * @param 識別番号管理 識別番号管理
     * @param 給付実績基本データ 給付実績基本データ
     */
    public KyufuJissekiKihonShukeiRelate(AtenaMeisho 事業者名称, ShikibetsuNoKanri 識別番号管理, KyufujissekiKihon 給付実績基本データ) {
        this.事業者名称 = 事業者名称;
        this.識別番号管理 = 識別番号管理;
        this.給付実績基本データ = 給付実績基本データ;
    }

    /**
     * コンストラクタです。
     *
     * @param entity KyufuJissekiKihonShukeiRelateEntity
     */
    public KyufuJissekiKihonShukeiRelate(KyufuJissekiKihonShukeiRelateEntity entity) {
        this.事業者名称 = entity.get事業者名称();
        if (entity.get識別番号管理() != null) {
            this.識別番号管理 = new ShikibetsuNoKanri(entity.get識別番号管理());
        }
        this.給付実績基本データ = new KyufujissekiKihon(entity.get給付実績基本データ());
    }

}
