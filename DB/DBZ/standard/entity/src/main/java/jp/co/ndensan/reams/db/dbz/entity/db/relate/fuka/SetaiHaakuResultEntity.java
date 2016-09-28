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

/**
 * 世帯員把握入力テーブルのSetaiHaakuResultEntityエンティティクラスです。
 *
 * @reamsid_L DBB-0640-020 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class SetaiHaakuResultEntity {

    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 世帯員識別コード;
    private FlexibleDate 世帯把握基準日;
    private FlexibleYear 所得年度;
    private RString 住所地特例該当;
    private SetaiCode 世帯コード;
    private RString 本人区分;

    /**
     * create世帯員所得情報
     *
     * @param entity SetaiHaakuResultEntity
     * @return 世帯員所得情報
     */
    public SetaiShotokuEntity to世帯員所得情報(SetaiHaakuResultEntity entity) {
        SetaiShotokuEntity 世帯員所得情報 = new SetaiShotokuEntity();
        世帯員所得情報.setHihokenshaNo(entity.get被保険者番号());
        世帯員所得情報.setShikibetsuCode(entity.get世帯員識別コード());
        世帯員所得情報.setShotokuNendo(entity.get所得年度());
        世帯員所得情報.setKijunYMD(entity.get世帯把握基準日());
        世帯員所得情報.setJushochiTokureiFlag(entity.get住所地特例該当());
        世帯員所得情報.setSetaiCode(entity.get世帯コード());
        世帯員所得情報.setHonninKubun(本人区分);
        return 世帯員所得情報;
    }
}
