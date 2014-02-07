/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaGaikyo;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaGaikyoKihon;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaGaikyoService;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaKihon;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaKihon1;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaKihon2;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaKihon3;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaKihon4;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaKihon5;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaKihonIryo;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaKihonJiritsu;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaKekka;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun1;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun2;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun3;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun4;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun5;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubunIryo;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubunJiritsu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GenzaiJokyoKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ServiceKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiFuriwakeKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 * NinteichosaKekkaを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaKekkaMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private NinteichosaKekkaMock() {
    }

    /**
     * NinteichosaKekkaを生成して返します。
     *
     * @return NinteichosaKekka
     */
    public static NinteichosaKekka getSpiedNinteichosaKekkaInstance() {
        return spy(new NinteichosaKekka(new ShinseishoKanriNo(new RString("1234567890")), 0,
                getSpiedChosaKekkaGaikyoInstance(), getSpiedChosaKekkaKihonInstance()));
    }

    /**
     * ChosaKekkaGaikyoを生成して返します。
     *
     * @return ChosaKekkaGaikyo
     */
    public static ChosaKekkaGaikyo getSpiedChosaKekkaGaikyoInstance() {
        return spy(new ChosaKekkaGaikyo(getSpiedChosaKekkaGaikyoKihonInstance(), getSpiedChosaKekkaGaikyoServiceInstance()));
    }

    /**
     * ChosaKekkaGaikyoKihonを生成して返します。
     *
     * @return ChosaKekkaGaikyoKihon
     */
    public static ChosaKekkaGaikyoKihon getSpiedChosaKekkaGaikyoKihonInstance() {
        return spy(new ChosaKekkaGaikyoKihon(
                new FlexibleDate("20140101"),
                ChosaIraiKubun.初回,
                new RString("12345678"),
                new RString("認定調査実施場所名称"),
                ChosaKubun.新規調査,
                new RString("概況特記事項"),
                ShinsakaiFuriwakeKubun.希望無し));
    }

    /**
     * ChosaKekkaGaikyoServiceを生成して返します。
     *
     * @return ChosaKekkaGaikyoService
     */
    public static ChosaKekkaGaikyoService getSpiedChosaKekkaGaikyoServiceInstance() {
        return spy(new ChosaKekkaGaikyoService(
                ServiceKubun.介護給付サービス,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0,
                GenzaiJokyoKubun.指定介護療養型医療施設,
                new RString("市町村特別給付"),
                new RString("介護保険給付以外の在宅サービス")));
    }

    /**
     * ChosaKekkaKihonを生成して返します。
     *
     * @return ChosaKekkaKihon
     */
    public static ChosaKekkaKihon getSpiedChosaKekkaKihonInstance() {
        return spy(new ChosaKekkaKihon(
                getSpiedChosaKekkaKihon1Instance(),
                getSpiedChosaKekkaKihon2Instance(),
                getSpiedChosaKekkaKihon3Instance(),
                getSpiedChosaKekkaKihon4Instance(),
                getSpiedChosaKekkaKihon5Instance(),
                getSpiedChosaKekkaKihonIryoInstance(),
                getSpiedChosaKekkaKihonJiritsuInstance()));
    }

    /**
     * ChosaKekkaKihon1を生成して返します。
     *
     * @return ChosaKekkaKihon1
     */
    public static ChosaKekkaKihon1 getSpiedChosaKekkaKihon1Instance() {
        return spy(new ChosaKekkaKihon1(
                ChosaKekkaKubun1.MahiHidariJoshi.ない,
                ChosaKekkaKubun1.MahiMigiJoshi.ある,
                ChosaKekkaKubun1.MahiHidariKashi.ない,
                ChosaKekkaKubun1.MahiMigiKashi.ある,
                ChosaKekkaKubun1.MahiSonota.ない,
                ChosaKekkaKubun1.KoshukuKata.ある,
                ChosaKekkaKubun1.KoshukuMata.ない,
                ChosaKekkaKubun1.KoshukuHiza.ある,
                ChosaKekkaKubun1.KoshukuSonota.ない,
                ChosaKekkaKubun1.Negaeri.できる,
                ChosaKekkaKubun1.Okiagari.できない,
                ChosaKekkaKubun1.Zaihoji.できる,
                ChosaKekkaKubun1.RyoashiRitsui.できない,
                ChosaKekkaKubun1.Hoko.できる,
                ChosaKekkaKubun1.Tachiagari.できない,
                ChosaKekkaKubun1.KataashiRitsui.できる,
                ChosaKekkaKubun1.Senshin.自立,
                ChosaKekkaKubun1.Tsumekiri.全介助,
                ChosaKekkaKubun1.Shiryoku.普通,
                ChosaKekkaKubun1.Choryoku.判断不能));
    }

    /**
     * ChosaKekkaKihon2を生成して返します。
     *
     * @return ChosaKekkaKihon2
     */
    public static ChosaKekkaKihon2 getSpiedChosaKekkaKihon2Instance() {
        return spy(new ChosaKekkaKihon2(
                ChosaKekkaKubun2.Ijo.自立,
                ChosaKekkaKubun2.Ido.全介助,
                ChosaKekkaKubun2.Enge.できる,
                ChosaKekkaKubun2.ShokujiSesshu.自立,
                ChosaKekkaKubun2.Hainyo.一部介助,
                ChosaKekkaKubun2.Haiben.見守り等,
                ChosaKekkaKubun2.KokoSeiketsu.全介助,
                ChosaKekkaKubun2.Sengan.自立,
                ChosaKekkaKubun2.Seihatsu.一部介助,
                ChosaKekkaKubun2.JoiChakudatsu.見守り等,
                ChosaKekkaKubun2.ZubonChakudatsu.全介助,
                ChosaKekkaKubun2.GaishutsuHindo.週１回以上));
    }

    /**
     * ChosaKekkaKihon3を生成して返します。
     *
     * @return ChosaKekkaKihon3
     */
    public static ChosaKekkaKihon3 getSpiedChosaKekkaKihon3Instance() {
        return spy(new ChosaKekkaKihon3(
                ChosaKekkaKubun3.IshiDentatsu.できる,
                ChosaKekkaKubun3.Nikka.できない,
                ChosaKekkaKubun3.Seinengappi.できる,
                ChosaKekkaKubun3.TankiKioku.できない,
                ChosaKekkaKubun3.Namae.できる,
                ChosaKekkaKubun3.Kisetsu.できない,
                ChosaKekkaKubun3.Basho.できる,
                ChosaKekkaKubun3.Haikai.ない,
                ChosaKekkaKubun3.Gaishutsu.ある));
    }

    /**
     * ChosaKekkaKihon4を生成して返します。
     *
     * @return ChosaKekkaKihon4
     */
    public static ChosaKekkaKihon4 getSpiedChosaKekkaKihon4Instance() {
        return spy(new ChosaKekkaKihon4(
                ChosaKekkaKubun4.Higaiteki.ない,
                ChosaKekkaKubun4.Sakuwa.ある,
                ChosaKekkaKubun4.KanjoHuantei.ない,
                ChosaKekkaKubun4.ChuyaGyakuten.ある,
                ChosaKekkaKubun4.OnajiHanashi.ない,
                ChosaKekkaKubun4.Ogoe.ある,
                ChosaKekkaKubun4.KaigoNiTeiko.ない,
                ChosaKekkaKubun4.Ochitsuki.ある,
                ChosaKekkaKubun4.HitoriDeDetagaru.ない,
                ChosaKekkaKubun4.Shushuheki.ある,
                ChosaKekkaKubun4.MonoYaIruiWoKowasu.ない,
                ChosaKekkaKubun4.HidoiMonowasure.ある,
                ChosaKekkaKubun4.HitorigotoHitoriwarai.ない,
                ChosaKekkaKubun4.JibunKatte.ある,
                ChosaKekkaKubun4.HanashiGaMatomaranai.ない));
    }

    /**
     * ChosaKekkaKihon5を生成して返します。
     *
     * @return ChosaKekkaKihon5
     */
    public static ChosaKekkaKihon5 getSpiedChosaKekkaKihon5Instance() {
        return spy(new ChosaKekkaKihon5(
                ChosaKekkaKubun5.Kusuri.自立,
                ChosaKekkaKubun5.KinsenKanri.全介助,
                ChosaKekkaKubun5.IshiKettei.できる,
                ChosaKekkaKubun5.ShudanFutekio.ない,
                ChosaKekkaKubun5.Kaimono.自立,
                ChosaKekkaKubun5.Chori.全介助));
    }

    /**
     * ChosaKekkaKihonIryoを生成して返します。
     *
     * @return ChosaKekkaKihonIryo
     */
    public static ChosaKekkaKihonIryo getSpiedChosaKekkaKihonIryoInstance() {
        return spy(new ChosaKekkaKihonIryo(
                ChosaKekkaKubunIryo.Tenteki.ない,
                ChosaKekkaKubunIryo.ChushinJomyakuEiyo.ある,
                ChosaKekkaKubunIryo.Toseki.ない,
                ChosaKekkaKubunIryo.StomaShochi.ある,
                ChosaKekkaKubunIryo.SansoRyoho.ない,
                ChosaKekkaKubunIryo.Respirator.ある,
                ChosaKekkaKubunIryo.KikanSekkai.ない,
                ChosaKekkaKubunIryo.TotsuKango.ある,
                ChosaKekkaKubunIryo.KeikanEiyo.ない,
                ChosaKekkaKubunIryo.MonitorSokutei.ある,
                ChosaKekkaKubunIryo.JokusoShochi.ない,
                ChosaKekkaKubunIryo.Catheter.ある));
    }

    /**
     * ChosaKekkaKihonJiritsuを生成して返します。
     *
     * @return ChosaKekkaKihonJiritsu
     */
    public static ChosaKekkaKihonJiritsu getSpiedChosaKekkaKihonJiritsuInstance() {
        return spy(new ChosaKekkaKihonJiritsu(
                ChosaKekkaKubunJiritsu.NinchishoNichijoSeikatsu.自立,
                ChosaKekkaKubunJiritsu.ShogaiNichijoSeikatsu.自立));
    }
}
