/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKogakuKaigoServicehi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufujissekiKogakuKaigoServicehiRelateEntity;
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
public class KyufujissekiKogakuKaigoServicehiRelate implements Serializable {

    private ShikibetsuNoKanri 識別番号管理;
    private KyufujissekiKogakuKaigoServicehi 給付実績高額介護サービス費;

    /**
     * コンストラクタです。
     *
     * @param 給付実績高額介護サービス費 給付実績高額介護サービス費
     * @param 識別番号管理 識別番号管理
     */
    public KyufujissekiKogakuKaigoServicehiRelate(ShikibetsuNoKanri 識別番号管理, KyufujissekiKogakuKaigoServicehi 給付実績高額介護サービス費) {
        this.識別番号管理 = 識別番号管理;
        this.給付実績高額介護サービス費 = 給付実績高額介護サービス費;
    }

    /**
     * コンストラクタです。
     *
     * @param entity 給付実績高額介護サービス費データEntity
     */
    public KyufujissekiKogakuKaigoServicehiRelate(KyufujissekiKogakuKaigoServicehiRelateEntity entity) {
        this.給付実績高額介護サービス費 = new KyufujissekiKogakuKaigoServicehi(entity.get給付実績高額介護サービス費Entity());
        if (entity.get識別番号管理Entity() != null) {
            this.識別番号管理 = new ShikibetsuNoKanri(entity.get識別番号管理Entity());
        }
    }

}
