/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7013ChosainJohoEntity;
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
 * 調査員情報　継承エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT7013ChosainJohoEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final RString DEFAULT_介護事業者番号 = new RString("123");
    public static final RString DEFAULT_介護調査員番号 = new RString("123");
    public static final RString DEFAULT_事業者番号 = new RString("123");
    public static final RString DEFAULT_介護調査員状況 = new RString("1");
    public static final AtenaMeisho DEFAULT_調査員氏名 = new AtenaMeisho("電算太郎");
    public static final AtenaKanaMeisho DEFAULT_調査員氏名カナ = new AtenaKanaMeisho("デンサンタロウ");
    public static final RString DEFAULT_性別 = new RString("1");
    public static final Code DEFAULT_調査員資格コード = new Code("3");
    public static final ChikuCode DEFAULT_地区コード = new ChikuCode(new RString("02"));
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo(new RString("0100201"));
    public static final AtenaJusho DEFAULT_住所 = new AtenaJusho("申請書記載住所");
    public static final TelNo DEFAULT_電話番号 = new TelNo("012-345-6789");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7013ChosainJohoEntityGenerator() {
    }

    public static DbT7013ChosainJohoEntity createDbT7013ChosainJohoEntity() {
        DbT7013ChosainJohoEntity entity = new DbT7013ChosainJohoEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setKaigoJigyoshaNo(DEFAULT_介護事業者番号);
        entity.setKaigoChosainNo(DEFAULT_介護調査員番号);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setKaigoChosainJokyo(DEFAULT_介護調査員状況);
        entity.setChosainShimei(DEFAULT_調査員氏名);
        entity.setChosainKanaShimei(DEFAULT_調査員氏名カナ);
        entity.setSeibetsu(DEFAULT_性別);
        entity.setChosainShikakuCode(DEFAULT_調査員資格コード);
        entity.setChikuCode(DEFAULT_地区コード);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setJusho(DEFAULT_住所);
        entity.setTelNo(DEFAULT_電話番号);
        return entity;
    }
}
