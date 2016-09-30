/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 世帯員把握テーブルのエンティティクラスです。
 *
 * @reamsid_L DBB-0640-020 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class SetaiHakuEntity implements IDbAccessable {

    private static final RString 本人区分 = new RString("1");

    private HihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate kijunYMD;
    private FlexibleYear shotokuNendo;
    private RString jushochiTokureiFlag;
    private SetaiCode setaiCode;

    /**
     * create世帯員所得情報
     *
     * @param entity SetaiHaakuEntity
     * @return 世帯員所得情報
     */
    public SetaiShotokuEntity to世帯員所得情報(SetaiHakuEntity entity) {
        SetaiShotokuEntity 世帯員所得情報 = new SetaiShotokuEntity();
        世帯員所得情報.setHihokenshaNo(entity.getHihokenshaNo());
        世帯員所得情報.setShikibetsuCode(entity.getShikibetsuCode());
        世帯員所得情報.setShotokuNendo(entity.getShotokuNendo());
        世帯員所得情報.setKijunYMD(entity.getKijunYMD());
        世帯員所得情報.setJushochiTokureiFlag(entity.getJushochiTokureiFlag());
        世帯員所得情報.setSetaiCode(entity.getSetaiCode());
        世帯員所得情報.setHonninKubun(本人区分);
        return 世帯員所得情報;
    }

}
