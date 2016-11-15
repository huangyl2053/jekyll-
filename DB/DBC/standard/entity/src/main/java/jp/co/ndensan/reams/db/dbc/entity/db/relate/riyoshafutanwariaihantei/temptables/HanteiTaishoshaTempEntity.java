/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 判定対象者Tempエンティティのクラスです。
 *
 * @reamsid_L DBC-4950-032 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanteiTaishoshaTempEntity
        extends DbTableEntityBase<HanteiTaishoshaTempEntity> implements IDbAccessable {

    @PrimaryKey
    private FlexibleYear taishoNendo;
    @PrimaryKey
    private RString taishoTsuki;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    private RString taishoKubun;
    private ShikibetsuCode shikibetsuCode;
    private SetaiCode setaiCode;
    private RString idoShubetsu;
    private FlexibleDate atenaIdobi;
    private RString atenaIdoJiyu;
    private FlexibleDate idobi;
    private RString idoJiyuCode;
    private FlexibleDate shikakuShiyutokiDate;
    private FlexibleDate shikakuSoshitsuDate;
    private FlexibleDate firstShikakuShiyutokiDate;
    private RString hihokenshaKubunCode;
    private RString cityCode;
    private RString rirekiNo;
    private RString edaNo;
    private RString jukyuShinseiJiyu;
    private FlexibleDate ninteiYukoKaishiDate;
    private FlexibleDate ninteiYukoShuryoDate;
    private FlexibleDate ninteiDate;
    private RString yoKaigoninteiJoutaiKubunCode;
    private boolean kyuSochishaFlag;
    private FlexibleYear shotokuNendo;
    private RString shotokuRirekiNo;
    private RString kazeiKubun;
    private RString kazeiKubunGemmenGo;
    private Decimal gokeiShotokuGaku;
    private Decimal nenkiniShunyuGaku;
    private Decimal nenkiniShotokuGaku;
    private Decimal kazeiShotokuGaku;
    private RString gekihenKanwaKubun;
    private FlexibleDate hanteiKijunYMD;
    private RString dataKubun;

    /**
     * HanteiTaishoshaTempEntityのコンストラクタです。
     */
    public HanteiTaishoshaTempEntity() {
        this.taishoTsuki = RString.EMPTY;
        this.taishoNendo = FlexibleYear.EMPTY;
    }

}
