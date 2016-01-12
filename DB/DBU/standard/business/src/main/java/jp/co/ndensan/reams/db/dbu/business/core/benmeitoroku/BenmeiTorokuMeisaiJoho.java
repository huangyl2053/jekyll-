/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.benmeitoroku;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.benmeitoroku.BenmeiTorokuMeisaiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 弁明登録明細情報エンティティを作成します。
 *
 */
public class BenmeiTorokuMeisaiJoho implements Serializable {

    private final BenmeiTorokuMeisaiJohoEntity benmeiTorokuMeisaiJohoEntity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link BenmeiTorokuMeisaiJohoEntity}より{@link BenmeiTorokuMeisaiJoho}を生成します。
     *
     * @param benmeiTorokuMeisaiJohoEntity
     * DBより取得した{@link BenmeiTorokuMeisaiJohoEntity}
     */
    public BenmeiTorokuMeisaiJoho(BenmeiTorokuMeisaiJohoEntity benmeiTorokuMeisaiJohoEntity) {
        this.benmeiTorokuMeisaiJohoEntity
                = requireNonNull(benmeiTorokuMeisaiJohoEntity, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明登録明細情報エンティティ"));
    }

    /**
     * 弁明書作成日を返します。
     *
     * @return 弁明書作成日
     */
    public FlexibleDate getBemmeishoSakuseiYMD() {
        return benmeiTorokuMeisaiJohoEntity.getBemmeishoSakuseiYMD();
    }

    /**
     * 審査請求に係る処分内容を返します。
     *
     * @return 審査請求に係る処分内容
     */
    public RString getShinsaseikyuKankeiShobunNaiyo() {
        return benmeiTorokuMeisaiJohoEntity.getShinsaseikyuKankeiShobunNaiyo();
    }

    /**
     * 弁明内容を返します。
     *
     * @return 弁明内容
     */
    public RString getBemmeiNaiyo() {
        return benmeiTorokuMeisaiJohoEntity.getBemmeiNaiyo();
    }

    /**
     * 弁明書提出日を返します。
     *
     * @return 弁明書提出日
     */
    public FlexibleDate getBemmeishoTeishutsuYMD() {
        return benmeiTorokuMeisaiJohoEntity.getBemmeishoSakuseiTeishutsuYMD();
    }

    /**
     * 弁明者を返します。
     *
     * @return 弁明者
     */
    public RString getBemmeisha() {
        return benmeiTorokuMeisaiJohoEntity.getBemmeishaShimei();
    }
}
