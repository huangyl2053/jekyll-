/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.shisetsunyushoinfo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shisetsunyushoinfo.ShisetSunyushoInfoRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設入所情報マスタを取得クラスです。
 *
 */
public class ShisetSunyushoInfoBusiness {

    private final ShisetSunyushoInfoRelateEntity relateEntity;

    /**
     * コンストラクタです.
     *
     * @param relateEntity ShisetSunyushoInfoRelateEntity
     */
    public ShisetSunyushoInfoBusiness(ShisetSunyushoInfoRelateEntity relateEntity) {
        this.relateEntity = relateEntity;
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return relateEntity.getShikibetsuCode();
    }

    /**
     * 履歴番号を取得します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return relateEntity.getRirekiNo();
    }

    /**
     * 台帳種別を取得します。
     *
     * @return 台帳種別
     */
    public RString get台帳種別() {
        return relateEntity.getDaichoShubetsu();
    }

    /**
     * 入所施設コードを取得します。
     *
     * @return 入所施設コード
     */
    public JigyoshaNo get入所施設コード() {
        return relateEntity.getNyushoShisetsuCode();
    }

    /**
     * 入所年月日を取得します。
     *
     * @return 入所年月日
     */
    public FlexibleDate get入所年月日() {
        return relateEntity.getNyushoYMD();
    }

    /**
     * 退所年月日を取得します。
     *
     * @return 退所年月日
     */
    public FlexibleDate get退所年月日() {
        return relateEntity.getTaishoYMD();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public AtenaMeisho get事業者名称() {
        return relateEntity.getJigyoshaName();
    }

    /**
     * 有効開始日を取得します。
     *
     * @return 有効開始日ド
     */
    public FlexibleDate get有効開始日() {
        return relateEntity.getYukoKaishiYMD();
    }

}
