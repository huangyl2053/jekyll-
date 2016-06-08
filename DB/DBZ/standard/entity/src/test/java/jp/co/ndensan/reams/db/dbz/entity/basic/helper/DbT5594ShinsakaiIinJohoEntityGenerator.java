/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5594ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5594ShinsakaiIinJohoEntityGenerator {

    public static final RString DEFAULT_介護認定審査会委員コード = new RString("1");
    public static final FlexibleDate DEFAULT_介護認定審査会委員開始年月日 = new FlexibleDate("20150402");
    public static final FlexibleDate DEFAULT_介護認定審査会委員終了年月日 = new FlexibleDate("20150402");
    public static final AtenaMeisho DEFAULT_介護認定審査会委員氏名 = new AtenaMeisho("宛名太郎");
    public static final AtenaKanaMeisho DEFAULT_介護認定審査会委員氏名カナ = new AtenaKanaMeisho("アテナカナ");
    public static final RString DEFAULT_性別 = new RString("1");
    public static final Code DEFAULT_介護認定審査員資格コード = new Code("1");
    public static final RString DEFAULT_審査員郵送区分 = new RString("1");
    public static final ChikuCode DEFAULT_担当地区コード = new ChikuCode("1");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("3801111");
    public static final AtenaJusho DEFAULT_住所 = new AtenaJusho("長野市県町");
    public static final TelNo DEFAULT_電話番号 = new TelNo("1234567890");
    public static final TelNo DEFAULT_FAX番号 = new TelNo("1234567890");
    public static final FlexibleDate DEFAULT_生年月日 = new FlexibleDate("20150402");
    public static final RString DEFAULT_備考 = new RString("1");
    public static final boolean DEFAULT_廃止フラグ = false;
    public static final FlexibleDate DEFAULT_廃止年月日 = new FlexibleDate("20150402");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5594ShinsakaiIinJohoEntityGenerator() {
    }

    public static DbT5594ShinsakaiIinJohoEntity createDbT5594ShinsakaiIinJohoEntity() {
        DbT5594ShinsakaiIinJohoEntity entity = new DbT5594ShinsakaiIinJohoEntity();
        entity.setShinsakaiIinCode(DEFAULT_介護認定審査会委員コード);
        entity.setShinsakaiIinKaishiYMD(DEFAULT_介護認定審査会委員開始年月日);
        entity.setShinsakaiIinShuryoYMD(DEFAULT_介護認定審査会委員終了年月日);
        entity.setShinsakaiIinShimei(DEFAULT_介護認定審査会委員氏名);
        entity.setShinsakaiIinKanaShimei(DEFAULT_介護認定審査会委員氏名カナ);
        entity.setSeibetsu(DEFAULT_性別);
        entity.setShinsakaiIinShikakuCode(DEFAULT_介護認定審査員資格コード);
        entity.setShinsainYusoKubun(DEFAULT_審査員郵送区分);
        entity.setTantoChikuCode(DEFAULT_担当地区コード);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setJusho(DEFAULT_住所);
        entity.setTelNo(DEFAULT_電話番号);
        entity.setFaxNo(DEFAULT_FAX番号);
        entity.setSeinengappiYMD(DEFAULT_生年月日);
        entity.setBiko(DEFAULT_備考);
        entity.setHaishiFlag(DEFAULT_廃止フラグ);
        entity.setHaishiYMD(DEFAULT_廃止年月日);
        return entity;
    }
}
