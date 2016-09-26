/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.riyojokyoichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用状況統計表（明細リスト）作成のEntityクラスです。
 *
 * @reamsid_L DBC-3500-040 lizhuoxuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT1513RiyoJokyoTokeihyoEntity {

    private RString shoriShichosonCode;
    private RString shoriShichosonName;
    private RString dataKubun;
    private RString hihokenshaNo;
    private RString serviceTeikyoYM;
    private RString shinsaYM;
    private RString shoKisaiHokenshaNo;
    private RString shikibetsuCode;
    private RString shimeiKana;
    private RString shimei;
    private RString shimei50onKana;
    private RString seibetsuCode;
    private RString seinenYMD;
    private RString choikiCode;
    private RString gyoseikuCode;
    private RString gyoseikuMei;
    private RString yubinNo;
    private RString jusho;
    private RString chikuCode1;
    private RString chikuMei1;
    private RString chikuCode2;
    private RString chikuMei2;
    private RString chikuCode3;
    private RString chikuMei3;
    private RString setaiCode;
    private RString yoKaigoJotaiKubunCode;
    private RString ninteiYukoKaishiYMD;
    private RString ninteiYukoShuryoYMD;
    private RString kyotakuServiceSakuseiKubunCode;
    private RString kyotakuServiceShuruiCode;
    private RString kyotakuServiceJigyoshoNo;
    private RString kyotakuServiceJigyoshoName;
    private RString kyuSochishaFlag;
    private RString shichosonCode;
    private RString koikinaiJushochiTokureiFlag;
    private RString koikinaiTokureiSochimotoShichosonCode;
    private RString kyuShichosonCode;
    private RString riyoJissekiFlag;
    private RString kohi1FutanshaNo;
    private RString kohi1JukyushaNo;
    private RString kohi2FutanshaNo;
    private RString kohi2JukyushaNo;
    private RString kohi3FutanshaNo;
    private RString kohi3JukyushaNo;
    private RString rojinHokenShichosonNo;
    private RString rojinhokenJukyushaNo;
    private RString kokiHokenshaNo;
    private RString kokiHihokenshaNo;
    private RString kokuhoHokenshaNo;
    private RString kokuhoHihokenshashoNo;
    private RString kokuhoKojinNo;
    private RString hokenKyufuritsu;
    private RString kyufuJissekiKubunCode;
    private RString serviceKubun;
    private RString jigyoshoNo;
    private RString jigyoshoName;
    private RString serviceShuruiCode;
    private RString serviceShuruiMei;
    private RString nissuKaisu;
    private RString tankiNyushoJitsunissu;
    private RString hokenTanisu;
    private RString hokenTanisuTanka;
    private RString hokenSeikyugaku;
    private RString hokenRiyoshaFutangaku;
    private RString kohi1Tanisu;
    private RString kohi1Seikyugaku;
    private RString kohi1HonninFutangaku;
    private RString kohi2Tanisu;
    private RString kohi2Seikyugaku;
    private RString kohi2HonninFutangaku;
    private RString kohi3Tanisu;
    private RString kohi3Seikyugaku;
    private RString kohi3HonninFutangaku;
    private RString hokenDekidakaTanisu;
    private RString hokenDekidakaSeikyugaku;
    private RString hokenDekidakaRiyoshaFutangaku;
    private RString kohi1DekidakaTanisu;
    private RString kohi1DekidakaSeikyugaku;
    private RString kohi1DekidakaHonninFutangaku;
    private RString kohi2DekidakaTanisu;
    private RString kohi2DekidakaSeikyugaku;
    private RString kohi2DekidakaHonninFutangaku;
    private RString kohi3DekidakaTanisu;
    private RString kohi3DekidakaSeikyugaku;
    private RString kohi3DekidakaHonninFutangaku;
    private RString shokujiKihonNissu;
    private RString shokujiKihonTanka;
    private RString shokujiTokubetsuNissu;
    private RString shokujiTokubetsuTanka;
    private RString shokujiTeikyohiGokei;
    private RString nichigakuHyojunFutangaku;
    private RString shokujiTeikyohiSeikyugaku;
    private RString gendogakuKanriTaishoTanisu;
    private RString gendogakuKanritaishogaiTanisu;
    private RString saishinsaKaisu;
    private RString kagoKaisu;
    private RString homonYokaigoJotaiKubunCode;
    private RString homonShikyuGendogaku;
    private RString homonTekiyoKaishiYMD;
    private RString homonTekiyoShuryoYMD;
    private RString homonRiyoServiceTanisu;
    private RString tankiShikyuGendogaku;
    private RString tankiTekiyoKaishiYMD;
    private RString tankiTekiyoShuryoYMD;
    private RString tankiRiyoServiceTanisu;
    private RString zaitakuRiyoritsu;
    private RString homonRiyoritsu;
    private RString tankiRiyoritsu;
    private RString gaihakuNissu;
    private RString taishogoJotaiCode;
    private RString tokuteiNyushoShokuhiNissu;
    private RString tokuteiNyushoShokuhiHiyogaku;
    private RString tokuteiNyushoShokuhiSeikyugaku;
    private RString tokuteiNyushoShokuhiRiyoshaFutangaku;
    private RString tokuteiNyushoKyojuNissu;
    private RString tokuteiNyushoKyojuHiyogaku;
    private RString tokuteiNyushoKyojuSeikyugaku;
    private RString tokuteiNyushoKyojuRiyoshaFutangaku;
    private RString shafukuKeigenritsu;
    private RString shafukuRiyoshaFutangaku;
    private RString shafukuKeigengaku;
    private RString shafukuKeigengoRiyoshaFutangaku;
    private RString meisaiOutFlag;

}
