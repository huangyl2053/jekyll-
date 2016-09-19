/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka;

import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaTorokuKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.YokinShubetsuPatternCodeValue;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 口座の情報Tempのクラスです。
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuteiKozaTempEntity implements IDbAccessable {

    private long uaT0310_kozaId;
    private ShikibetsuCode uaT0310_shikibetsuCode;
    private RString uaT0310_gyomubetsuPrimaryKey;
    private RString uaT0310_gyomuKoyuKey;
    private KozaYotoKubunCodeValue uaT0310_yotoKubun;
    private int uaT0310_torokuRenban;
    private FlexibleDate uaT0310_kaishiYMD;
    private FlexibleDate uaT0310_shuryoYMD;
    private KinyuKikanCode uaT0310_kinyuKikanCode;
    private KinyuKikanShitenCode uaT0310_kinyuKikanShitenCode;
    private RString uaT0310_yokinShubetsu;
    private RString uaT0310_kozaNo;
    private RString uaT0310_tsuchoKigo;
    private RString uaT0310_tsuchoNo;
    private ShikibetsuCode uaT0310_kozaMeigininShikibetsuCode;
    private AtenaKanaMeisho uaT0310_kozaMeiginin;
    private AtenaMeisho uaT0310_kozaMeigininKanji;
    private AtenaKanaMeisho uaT0310_kensakuyoMeiginin;
    private RString uaT0310_kozaHyojiKubun;
    private boolean uaT0310_nayoseKubun;
    private boolean uaT0310_zumitsuHakkoYohi;
    private boolean uaT0310_kozaFurikaeKaishiTsuchiHakkozumi;
    private RString uaT0310_kozaTorokuNo;
    private KozaTorokuKubunCodeValue uaT0310_kozaTorokuKubunCode;
    private FlexibleDate uaT0310_kozaKaishiUketsukeYMD;
    private FlexibleDate uaT0310_kozaShuryoUketsukeYMD;
    private FlexibleDate uaT0310_kozaTorokuYMD;
    private RString uaT0310_temban;
    private KinyuKikanCode uaT0302_kinyuKikanCode;
    private FlexibleDate uaT0302_kaishiYMD;
    private FlexibleDate uaT0302_shuryoYMD;
    private RString uaT0302_name;
    private RString uaT0302_kanaName;
    private YokinShubetsuPatternCodeValue uaT0302_yokinShubetsuPatternCode;
    private int uaT0302_hyojijun;
    private YokinShubetsuPatternCodeValue uaT0301_yokinShubetsuPatternCode;
    private RString uaT0301_yokinShubetsuCode;
    private RString uaT0301_yokinShubetsuMeisho;
    private RString uaT0301_yokinShubetsuRyakusho;
    private KinyuKikanCode uaT0303_kinyuKikanCode;
    private KinyuKikanShitenCode uaT0303_kinyuKikanShitenCode;
    private FlexibleDate uaT0303_kaishiYMD;
    private FlexibleDate uaT0303_shuryoYMD;
    private RString uaT0303_name;
    private RString uaT0303_kanaName;
    private int uaT0303_hyojijun;
}
