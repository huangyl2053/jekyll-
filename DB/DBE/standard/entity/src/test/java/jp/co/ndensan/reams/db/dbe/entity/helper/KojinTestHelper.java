/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.ur.urz.business.IChiku;
import jp.co.ndensan.reams.ur.urz.business.IDateOfBirth;
import jp.co.ndensan.reams.ur.urz.business.IJusho;
import jp.co.ndensan.reams.ur.urz.business.ILocalGovernmentCode;
import jp.co.ndensan.reams.ur.urz.business._Chiku;
import jp.co.ndensan.reams.ur.urz.business._DonyuDantai;
import jp.co.ndensan.reams.ur.urz.business._Jusho;
import jp.co.ndensan.reams.ur.urz.business._LocalGovernmentCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IIdoRiyu;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.ITsuzukigaraList;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._IdoJiyu;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._IdoRiyu;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._Kojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._Name;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._ShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.ChikuShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.IIdoJiyu;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static org.mockito.Mockito.spy;

/**
 * 個人のテストヘルパーです。
 *
 * @author N8187 久保田 英男
 */
public final class KojinTestHelper {

    public static IKojin create個人() {
        IShikibetsuTaisho 識別対象 = create識別対象();
        RString 旧姓 = new RString("旧姓");
        IDateOfBirth 生年月日 = null;
        Gender 性別 = null;
        ITsuzukigaraList 続柄 = null;
        JuminJotai 住民状態 = null;
        FlexibleDate 異動年月日 = new FlexibleDate("20140127");
        FlexibleDate 届出年月日 = new FlexibleDate("20140128");
        RString 異動事由コード = new RString("異動事由コード");
        JuminShubetsu 住民種別 = JuminShubetsu.日本人;
        RString 家族番号 = new RString("家族番号");
        int 住民票表示順 = 5;

        return new _Kojin(識別対象, 旧姓, 生年月日, 性別,
                続柄, 住民状態, 異動年月日, 届出年月日,
                異動事由コード, 住民種別, 家族番号, 住民票表示順);
    }

    private static IShikibetsuTaisho create識別対象() {
        ShikibetsuCode shikibetsuCode = new ShikibetsuCode(new RString("10000"));
        RDateTime insertTimestamp = null;
        int rirekiNo = 22;
        IJusho jusho = new _Jusho(new RString("00000000010"), new YubinNo(new RString("382-0034")), new RString("町域"));
        IIdoJiyu idoJiyu = new _IdoJiyu(new RString("10"), new RString("転入"), new RString("転入"));
        IIdoRiyu idoRiyu = new _IdoRiyu(new RString("異動理由"));
        FlexibleDate todokedeYMD = new FlexibleDate("20140128");
        SetaiCode setaiCode = new SetaiCode("500");
        JuminShubetsu juminShubetsu = JuminShubetsu.日本人;
        IName name = new _Name(new AtenaMeisho(new RString("電算太郎")), new AtenaKanaMeisho(new RString("デンサンタロウ")));
        IChiku chiku1 = new _Chiku(ChikuShubetsu.地区1, new ChikuCode("20"),
                new _DonyuDantai(new ReamsDonyuDantaiCode(new RString("001001")), 0),
                new Range(new RDate("20100101"), new RDate("22000101")), new RString("地区１"),
                new RString("チクイチ"), new RString("チクイチ"), 0);
        IChiku chiku2 = new _Chiku(ChikuShubetsu.地区2, new ChikuCode("30"),
                new _DonyuDantai(new ReamsDonyuDantaiCode(new RString("001001")), 0),
                new Range(new RDate("20100101"), new RDate("22000101")), new RString("地区２"),
                new RString("チクニ"), new RString("チクニ"), 0);
        IChiku chiku3 = new _Chiku(ChikuShubetsu.地区3, new ChikuCode("40"),
                new _DonyuDantai(new ReamsDonyuDantaiCode(new RString("001001")), 0),
                new Range(new RDate("20100101"), new RDate("22000101")), new RString("地区３"),
                new RString("チクサン"), new RString("チクサン"), 0);
        ILocalGovernmentCode genLasdecCode = new _LocalGovernmentCode(new RString("201006"));
        ILocalGovernmentCode kyuLasdecCode = new _LocalGovernmentCode(new RString("201006"));
        int kyuLasdecCodeRenban = 100000;

        return spy(new _ShikibetsuTaisho(shikibetsuCode, insertTimestamp, rirekiNo,
                jusho, idoJiyu, idoRiyu, todokedeYMD, setaiCode, juminShubetsu, name,
                chiku1, chiku2, chiku3, genLasdecCode,
                kyuLasdecCode, kyuLasdecCodeRenban));
    }
}
