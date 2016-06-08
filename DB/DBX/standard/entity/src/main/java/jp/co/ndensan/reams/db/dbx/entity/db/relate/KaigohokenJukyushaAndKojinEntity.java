/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.relate;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.KaigohokenJukyushaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 介護受給者エンティティと個人エンティティの複合エンティティクラスです。
 *
 * @author N2806 太田 智之
 * @jpName 介護保険受給者・個人エンティティ
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public class KaigohokenJukyushaAndKojinEntity {

    private KaigohokenJukyushaEntity 介護保険受給者Entity;
    //TODO N2901 夘之原和慶 KojinEntityの代わりに利用するEntityを決める必要あり。2014/03末まで。
    private UaFt200FindShikibetsuTaishoEntity jutogaiYusenCurrentEntity;

    /**
     * コンストラクタです。
     */
    public KaigohokenJukyushaAndKojinEntity() {
    }

    /**
     * コンストラクタです。
     *
     * @param 介護保険受給者Entity 介護保険受給者エンティティ
     * @param jutogaiYusenCurrentEntity 住登外優先直近エンティティ
     */
    public KaigohokenJukyushaAndKojinEntity(KaigohokenJukyushaEntity 介護保険受給者Entity,
            UaFt200FindShikibetsuTaishoEntity jutogaiYusenCurrentEntity) {
        this.介護保険受給者Entity = 介護保険受給者Entity;
        this.jutogaiYusenCurrentEntity = jutogaiYusenCurrentEntity;
    }

    /**
     * 介護保険受給者Entityを返します。
     *
     * @return 介護保険受給者Entity
     */
    public KaigohokenJukyushaEntity getKaigohokenJukyushaEntity() {
        return 介護保険受給者Entity;
    }

    /**
     * 住登外優先直近エンティティを返します。
     *
     * @return 住登外優先直近エンティティ
     */
    public UaFt200FindShikibetsuTaishoEntity getKojinEntity() {
        return jutogaiYusenCurrentEntity;
    }

    /**
     * 介護保険受給者Entityをセットします。
     *
     * @param kaigoJukyushaEntity 介護保険受給者Entity
     */
    public void setKaigohokenJukyushaEntity(KaigohokenJukyushaEntity kaigoJukyushaEntity) {
        this.介護保険受給者Entity = kaigoJukyushaEntity;
    }

    /**
     * 住登外優先エンティティをセットします。
     *
     * @param jutogaiYusenCurrentEntity 住登外優先直近エンティティ
     */
    public void setKojinEntity(UaFt200FindShikibetsuTaishoEntity jutogaiYusenCurrentEntity) {
        this.jutogaiYusenCurrentEntity = jutogaiYusenCurrentEntity;
    }
}
