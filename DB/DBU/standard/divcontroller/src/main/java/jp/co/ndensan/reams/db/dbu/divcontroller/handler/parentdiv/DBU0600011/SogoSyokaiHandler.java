/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0600011;

import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.SogoSyokaiDiv;
import jp.co.ndensan.reams.db.dbu.service.core.sogosyokai.SoyoSyokaiService;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.KaigoJogaiTokureiTaishoShisetsu;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.jigyoshashubetsu.JigyosyaType;
import jp.co.ndensan.reams.db.dbz.definition.core.jogaiidojiyu.JogaiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.jogaiidojiyu.JogaiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.core.tatokureiidojiyu.TatokureiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.tatokureiidojiyu.TatokureiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 総合照会_資格得喪情報のHandlerです。
 *
 * @reamsid_L DBU-4100-010 wanghuafeng
 */
public class SogoSyokaiHandler {

    private static final RString 施設種類_11 = new RString("11");
    private static final RString 事業者種別_01 = new RString("01");
    private static final RString 事業者種別_02 = new RString("02");
    private final SogoSyokaiDiv div;

    /**
     * インスタンスです。
     *
     * @param div SogoSyokaiDiv
     */
    public SogoSyokaiHandler(SogoSyokaiDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化
     *
     * @param key TaishoshaKey
     */
    public void onLoad(TaishoshaKey key) {
        div.getKaigoAtenaInfoChildDiv().initialize(key.get識別コード());
        div.getKaigoShikakuKihonChildDiv().initialize(key.get被保険者番号());
        div.getSikakuJohoButton().setDisabled(true);
        set被保険者(SoyoSyokaiService.createInstance().get被保険者台帳(key.get被保険者番号()));
        set施設入退所(SoyoSyokaiService.createInstance().get施設入退所(key.get識別コード()));
        set他市町村住所地特例情報(SoyoSyokaiService.createInstance().get他市町村住所地特例情報(key.get識別コード()), key.get識別コード());
        set適用除外者情報(SoyoSyokaiService.createInstance().get適用除外者情報(key.get識別コード()), key.get識別コード());
        AccessLogger.log(AccessLogType.照会, toPersonalData(key));
    }

    /**
     * 被保険者のセート
     *
     * @param hihokenshadaicho HihokenshaDaicho
     */
    public void set被保険者(HihokenshaDaicho hihokenshadaicho) {
        if (hihokenshadaicho != null) {
            if (hihokenshadaicho.get資格取得年月日() != null) {
                div.getSyutokuYYMMDD().setValue(new RDate(hihokenshadaicho.get資格取得年月日().toString()));
            }
            if (hihokenshadaicho.get資格取得事由コード() != null) {
                div.getSyutokuJiyu().setValue(ShikakuShutokuJiyu.toValue(hihokenshadaicho.get資格取得事由コード()).get名称());
            }
            if (hihokenshadaicho.get被保険者区分コード() != null) {
                div.getHihokensyaKubun().setValue(ShikakuKubun.toValue(hihokenshadaicho.get被保険者区分コード()).get名称());
            }
            if (hihokenshadaicho.get市町村コード() != null) {
                div.getSyozaiHokensya().setValue(hihokenshadaicho.get市町村コード().value());
            }
            if (hihokenshadaicho.get資格喪失年月日() != null) {
                div.getSosituYYMMDD().setValue(new RDate(hihokenshadaicho.get資格喪失年月日().toString()));
            }
            if (hihokenshadaicho.get資格喪失事由コード() != null) {
                div.getSosituJiyu().setValue(ShikakuSoshitsuJiyu.toValue(hihokenshadaicho.get資格喪失事由コード()).get名称());
            }
            if (hihokenshadaicho.get適用年月日() != null) {
                div.getJyusyoTokureiTekiyouYYMMDD().setValue(new RDate(hihokenshadaicho.get適用年月日().toString()));
            }
            if (hihokenshadaicho.get住所地特例適用事由コード() != null) {
                div.getJyusyoTokureiTekiyouJiyu().setValue(ShikakuJutokuTekiyoJiyu.toValue(
                        hihokenshadaicho.get住所地特例適用事由コード()).get名称());
            }
            if (hihokenshadaicho.get旧市町村コード() != null) {
                div.getKyuHokensya().setValue(hihokenshadaicho.get旧市町村コード().value());
            }
            if (hihokenshadaicho.get資格変更年月日() != null) {
                div.getHenkoYYMMDD().setValue(new RDate(hihokenshadaicho.get資格変更年月日().toString()));
            }
            if (hihokenshadaicho.get資格変更事由コード() != null) {
                div.getHenkoJiyu().setValue(ShikakuHenkoJiyu.toValue(hihokenshadaicho.get資格変更事由コード()).get名称());
            }
            if (hihokenshadaicho.get解除年月日() != null) {
                div.getJyusyoTokureiKaijoYYMMDD().setValue(new RDate(hihokenshadaicho.get解除年月日().toString()));
            }
            if (hihokenshadaicho.get住所地特例解除事由コード() != null) {
                div.getJyusyoTokureiKaijoJiyu().setValue(ShikakuJutokuKaijoJiyu.toValue(hihokenshadaicho.get住所地特例解除事由コード()).get名称());
            }
            if (hihokenshadaicho.get広住特措置元市町村コード() != null) {
                div.getHiroSotiMotoHokensya().setValue(hihokenshadaicho.get広住特措置元市町村コード().value());
            }
        }
    }

    /**
     * 施設入退所の取得
     *
     * @param shisetsunyutaisho ShisetsuNyutaisho
     */
    public void set施設入退所(ShisetsuNyutaisho shisetsunyutaisho) {
        if (shisetsunyutaisho != null) {
            if (shisetsunyutaisho.get入所年月日() != null) {
                div.getNyusyoYYMMDD().setValue(new RDate(shisetsunyutaisho.get入所年月日().toString()));
            }
            if (shisetsunyutaisho.get台帳種別() != null) {
                div.getDaityoSyubetu().setValue(DaichoType.toValue(shisetsunyutaisho.get台帳種別()).get名称());
            }
            if (shisetsunyutaisho.get入所施設種類() != null) {
                div.getSisetuSyubetu().setValue(ShisetsuType.toValue(shisetsunyutaisho.get入所施設種類()).get名称());
            }
            if (shisetsunyutaisho.get退所年月日() != null) {
                div.getTaisyoYYMMDD().setValue(new RDate(shisetsunyutaisho.get退所年月日().toString()));
            }
            if (shisetsunyutaisho.get入所施設コード() != null) {
                div.getNyusyoSisetuCode().setValue(shisetsunyutaisho.get入所施設コード().value());
            }
            if (shisetsunyutaisho.get入所施設コード() != null) {
                div.getHokaSityosonSisetuMesyo().setValue(set事業者名称(shisetsunyutaisho.get入所施設コード().value()));
            }
        }
    }

    /**
     * 他市町村住所地特例情報の取得
     *
     * @param tashichosonjushochitokurei TashichosonJushochiTokurei
     * @param 識別コード ShikibetsuCode
     */
    public void set他市町村住所地特例情報(TashichosonJushochiTokurei tashichosonjushochitokurei, ShikibetsuCode 識別コード) {
        if (tashichosonjushochitokurei != null) {
            if (tashichosonjushochitokurei.get適用年月日() != null) {
                div.getHokaSityosonTekiyoYYMMDD().setValue(new RDate(tashichosonjushochitokurei.get適用年月日().toString()));
            }
            if (tashichosonjushochitokurei.get他市町村住所地特例適用事由コード() != null) {
                div.getHokaSityosonTekiyouJiyu().setValue(TatokureiTekiyoJiyu.toValue(tashichosonjushochitokurei.
                        get他市町村住所地特例適用事由コード()).get名称());
            }
            if (tashichosonjushochitokurei.get措置保険者番号() != null) {
                div.getSotiMotoHokensya().setValue(tashichosonjushochitokurei.get措置保険者番号().value());
            }
            if (tashichosonjushochitokurei.get措置被保険者番号() != null) {
                div.getSotiMotoHihokensya().setValue(tashichosonjushochitokurei.get措置被保険者番号().value());
            }
            if (tashichosonjushochitokurei.get解除年月日() != null) {
                div.getHokaSityosonKaijoYYMMDD().setValue(new RDate(tashichosonjushochitokurei.get解除年月日().toString()));
            }
            if (tashichosonjushochitokurei.get他市町村住所地特例解除事由コード() != null) {
                div.getHokaSityosonKaijoJiyu().setValue(TatokureiKaijoJiyu.toValue(tashichosonjushochitokurei.
                        get他市町村住所地特例解除事由コード()).get名称());
            }
        }
        ShisetsuNyutaisho shisetsunyutaisho = SoyoSyokaiService.createInstance().get施設入退所Order(識別コード,
                DaichoType.他市町村住所地特例者.getコード());
        if (shisetsunyutaisho != null) {
            if (shisetsunyutaisho.get入所施設種類() != null) {
                div.getHokaSityosonSisetuSyubetu().setValue(ShisetsuType.toValue(shisetsunyutaisho.get入所施設種類()).get名称());
            }
            if (shisetsunyutaisho.get入所施設コード() != null) {
                div.getHokaSityosonSisetuCode().setValue(shisetsunyutaisho.get入所施設コード().value());
            }
            if (shisetsunyutaisho.get入所施設コード() != null) {
                div.getNyusyoSisetuMesyo().setValue(set事業者名称(shisetsunyutaisho.get入所施設コード().value()));
            }
        }
    }

    /**
     * 適用除外者情報の取得
     *
     * @param tekiyojogaisha TekiyoJogaisha
     * @param 識別コード ShikibetsuCode
     */
    public void set適用除外者情報(TekiyoJogaisha tekiyojogaisha, ShikibetsuCode 識別コード) {
        if (tekiyojogaisha != null) {
            if (tekiyojogaisha.get適用年月日() != null) {
                div.getTekiyoJyogaisyaTekiyoYYMMDD().setValue(new RDate(tekiyojogaisha.get適用年月日().toString()));
            }
            if (tekiyojogaisha.get適用除外適用事由コード() != null) {
                div.getTekiyoJyogaisyaTekiyouJiyu().setValue(JogaiTekiyoJiyu.toValue(tekiyojogaisha.get適用除外適用事由コード()).get名称());
            }
            if (tekiyojogaisha.get解除年月日() != null) {
                div.getTekiyoJyogaisyaKaijoYYMMDD().setValue(new RDate(tekiyojogaisha.get解除年月日().toString()));
            }
            if (tekiyojogaisha.get適用除外解除事由コード() != null) {
                div.getTekiyoJyogaisyaKaijoJiyu().setValue(JogaiKaijoJiyu.toValue(tekiyojogaisha.get適用除外解除事由コード()).get名称());
            }
        }
        ShisetsuNyutaisho shisetsunyutaisho = SoyoSyokaiService.createInstance().get施設入退所Order(識別コード, DaichoType.適用除外者.getコード());
        if (shisetsunyutaisho != null) {
            if (shisetsunyutaisho.get入所施設種類() != null) {
                div.getTekiyoJyogaisyaSisetuSyubetu().setValue(ShisetsuType.toValue(shisetsunyutaisho.get入所施設種類()).get名称());
            }
            if (shisetsunyutaisho.get入所施設コード() != null) {
                div.getTekiyoJyogaisyaSisetuCode().setValue(shisetsunyutaisho.get入所施設コード().value());
            }
            if (shisetsunyutaisho.get入所施設コード() != null) {
                div.getTekiyoJyogaisyaSisetuMesyo().setValue(set事業者名称(shisetsunyutaisho.get入所施設コード().value()));
            }
        }
    }

    private RString set事業者名称(RString 入所施設コード) {
        if (施設種類_11.equals(ShisetsuType.介護保険施設.getコード())) {
            KaigoJigyosha kaigoJigyosha = SoyoSyokaiService.createInstance().get事業者名称_入所施設コード(入所施設コード);
            if (kaigoJigyosha != null && kaigoJigyosha.get事業者名称() != null) {
                return new RString(kaigoJigyosha.get事業者名称().toString());
            }
            return RString.EMPTY;
        } else if (事業者種別_01.equals(JigyosyaType.住所地特例対象施設.getコード())) {
            KaigoJogaiTokureiTaishoShisetsu tokureitaishoshisetsu = SoyoSyokaiService.createInstance().
                    get事業者名称_住所地特例対象施設(入所施設コード, JigyosyaType.住所地特例対象施設.getコード());
            if (tokureitaishoshisetsu != null && tokureitaishoshisetsu.get事業者名称() != null) {
                return new RString(tokureitaishoshisetsu.get事業者名称().toString());
            }
            return RString.EMPTY;
        } else if (事業者種別_02.equals(JigyosyaType.適用除外施設.getコード())) {
            KaigoJogaiTokureiTaishoShisetsu tokureitaishoshisetsu = SoyoSyokaiService.createInstance()
                    .get事業者名称_住所地特例対象施設(入所施設コード, JigyosyaType.適用除外施設.getコード());
            if (tokureitaishoshisetsu != null && tokureitaishoshisetsu.get事業者名称() != null) {
                return new RString(tokureitaishoshisetsu.get事業者名称().toString());
            }
            return RString.EMPTY;
        } else {
            return RString.EMPTY;
        }
    }

    private PersonalData toPersonalData(TaishoshaKey key) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), key.get被保険者番号().value());
        return PersonalData.of(key.get識別コード(), expandedInfo);
    }
}
