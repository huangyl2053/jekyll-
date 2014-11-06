/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosainJokyo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7013ChosainJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定調査員のテストヘルパーです。
 *
 * @author N8187 久保田 英男
 */
public class KaigoNinteichosainTestHelper {

    public static final LasdecCode 市町村コード = new LasdecCode(new RString("123456"));
    public static final KaigoJigyoshaNo 介護事業者番号 = new KaigoJigyoshaNo(new RString("0002"));
    public static final RString 介護調査員番号 = new RString("0003");
    public static final JigyoshaNo 事業者番号 = new JigyoshaNo(new RString("2020300001"));
    public static final ChosainJokyo 調査員状況 = ChosainJokyo.有効;
    public static final AtenaMeisho 調査員氏名 = new AtenaMeisho(new RString("長野"));
    public static final AtenaKanaMeisho 調査員氏名カナ = new AtenaKanaMeisho(new RString("ながの"));
    public static final Gender 性別 = Gender.FEMALE;
    public static final Code 調査員資格コード = new Code(new RString("0005"));
    public static final ChikuCode 地区コード = new ChikuCode(new RString("0006"));
    public static final YubinNo 郵便番号 = new YubinNo(new RString("321"));
    public static final AtenaJusho 住所 = new AtenaJusho(new RString("長野市BBB"));
    public static final TelNo 電話番号 = new TelNo(new RString("007"));

    public static DbT7013ChosainJohoEntity create認定調査員Entity() {
        DbT7013ChosainJohoEntity entity = new DbT7013ChosainJohoEntity();
        entity.setShichosonCode(市町村コード);
        entity.setKaigoJigyoshaNo(介護事業者番号.value());
        entity.setKaigoChosainNo(介護調査員番号);
        entity.setJigyoshaNo(事業者番号.value());
        entity.setKaigoChosainJokyo(調査員状況.getCode());
        entity.setChosainShimei(調査員氏名);
        entity.setChosainKanaShimei(調査員氏名カナ);
        entity.setSeibetsu(性別.getCode());
        entity.setChosainShikakuCode(調査員資格コード);
        entity.setChikuCode(地区コード);
        entity.setYubinNo(郵便番号);
        entity.setJusho(住所);
        entity.setTelNo(電話番号);

        return entity;
    }

}
