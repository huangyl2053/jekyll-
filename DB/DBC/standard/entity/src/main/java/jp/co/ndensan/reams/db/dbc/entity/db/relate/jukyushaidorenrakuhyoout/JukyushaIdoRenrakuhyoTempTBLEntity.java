/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給者異動送付一時エンティティ。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaIdoRenrakuhyoTempTBLEntity extends DbTableEntityBase<JukyushaIdoRenrakuhyoTempTBLEntity> implements IDbAccessable {

    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleDate idoYMD;
    @PrimaryKey
    private int rirekiNo;
    private RString idoKubunCode;
    private RString jukyushaIdoJiyu;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private RString hiHokenshaNameKana;
    private FlexibleDate umareYMD;
    private RString seibetsuCode;
    private FlexibleDate shikakuShutokuYMD;
    private FlexibleDate shikakuSoshitsuYMD;
    private RString rojinHokenShichosonNo;
    private RString rojinHokenJukyushaNo;
    private RString kohiFutanshaNo;
    private ShoKisaiHokenshaNo koikiRengoHokenshaNo;
    private RString shinseiShubetsuCode;
    private RString henkoShinseichuKubunCode;
    private FlexibleDate shinseiYMD;
    private RString minashiYokaigoJotaiKubunCode;
    private RString yokaigoJotaiKubunCode;
    private FlexibleDate ninteiYukoKikankaishiYMD;
    private RString ninteiYukoKikanShuryoYMD;
    private RString kyotakuServiceSakuseiKubunCode;
    private RString kyotakuKaigoShienJigyoshoNo;
    private RString kyotakuServiceTekiyoKaishiYMD;
    private RString kyotakuServiceTekiyoShuryoYMD;
    private int homonTsushoServiceShikyuGendoKijungaku;
    private FlexibleDate homonTsushoServiceJogenKanriTekiyoKaishiYMD;
    private RString homonTsushoServiceJogenKanriTekiyoShuryoYMD;
    private int tankiNyushoServiceShikyuGendoKijungaku;
    private FlexibleDate tankinyushoServiceJogenKanriTekiyoKaishiYMD;
    private FlexibleDate tankinyushoServiceJogenKanriTekiyoShuryoYMD;
    private boolean kohiFutanJogenGengakuAriFlag;
    private RString shokanbaraikaKaishiYMD;
    private RString shokanbaraikaShuryoYMD;
    private RString kyufuritsuHikisageKaishiYMD;
    private RString kyufuritsuHikisageShuryoYMD;
    private RString gemmenShinseichuKubunCode;
    private RString riyoshaFutanKubunCode;
    private Decimal kyufuritsu;
    private RString tekiyoKaishiYMD;
    private RString tekiyoShuryoYMD;
    private RString hyojunFutanKubunCode;
    private Decimal futangaku;
    private RString futangakuTekiyoKaishiYMD;
    private RString futangakuTekiyoShuryoYMD;
    private RString tokuteiNyushoshaNinteiShinseichuKubunCode;
    private RString tokuteiNyushoshaKaigoServiceKubunCode;
    private RString kaizeisoTokureiGengakuSochiTaishoFlag;
    private RString shokuhiFutanGendogaku;
    private RString kyojuhiUnitGataKoshitsuFutanGendogaku;
    private RString kyojuhiUnitGataJunKoshitsuFutanGendogaku;
    private RString kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku;
    private RString kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku;
    private RString kyujuhiTashoshitsuFutanGendogaku;
    private RString futanGendogakuTekiyoKaishiYMD;
    private RString futanGendogakuTekiyoShuryoYMD;
    private RString keigenritsu;
    private RString keigenritsuTekiyoKaishiYMD;
    private RString keigenritsuTekiyoShuryoYMD;
    private boolean shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag;
    private RString kokiKoureiIryoHokenshaNo;
    private RString kokikoureiIryoHiHokenshaNo;
    private RString kokuhoHokenshaNo;
    private RString kokuhoHiHokenshaNo;
    private RString kokuhoKojinNo;
    private RString nijiyoboJigyoKubunCode;
    private FlexibleDate nijiyoboJigyoYukoKikanKaishiYMD;
    private FlexibleDate nijiyoboJigyoYukoKikanShuryoYMD;
    private boolean teiseiRenrakuhyoFlag;
    private FlexibleYearMonth sofuYM;
    private RString jushochiTokureiTaishoshaKubunCode;
    private RString shisetsuShozaiHokenjaNo;
    private RString jushochiTokureiTekiyoKaishiYMD;
    private RString jushochiTokureiTekiyoShuryoYMD;
    private RString kyotakuhiShin1FutanGendogaku;
    private RString kyotakuhiShin2FutanGendogaku;
    private RString kyotakuhiShin3FutanGendogaku;
    private RString riyosyaFutanWariaiYukoKaishiYMD;
    private RString riyosyaFutanWariaiYukoShuryoYMD;
    private RString teiseiKubunCode;
    private FlexibleDate teiseiYMD;
    private boolean logicalDeletedFlag;
}
