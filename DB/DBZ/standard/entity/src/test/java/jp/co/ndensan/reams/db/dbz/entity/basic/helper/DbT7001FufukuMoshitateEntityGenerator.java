/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 不服審査申立情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7001FufukuMoshitateEntityGenerator {

    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo("209007");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("012340123400001");
    public static final HihokenshaNo DEFAULT_原処分被保険者番号 = new HihokenshaNo("010101");
    public static final FlexibleDate DEFAULT_審査請求届出日 = new FlexibleDate("19900101");
    public static final YubinNo DEFAULT_原処分被保険者郵便番号 = new YubinNo("0010001");
    public static final AtenaJusho DEFAULT_原処分被保険者住所 = new AtenaJusho("");
    public static final AtenaMeisho DEFAULT_原処分被保険者氏名 = new AtenaMeisho("");
    public static final TelNo DEFAULT_原処分被保険者電話番号 = new TelNo("08011112222");
    public static final FlexibleDate DEFAULT_原処分被保険者生年月日 = new FlexibleDate("19900101");
    public static final YubinNo DEFAULT_審査請求人郵便番号 = new YubinNo("0010001");
    public static final AtenaJusho DEFAULT_審査請求人住所 = new AtenaJusho("");
    public static final AtenaMeisho DEFAULT_審査請求人氏名 = new AtenaMeisho("");
    public static final TelNo DEFAULT_審査請求人電話番号 = new TelNo("08011112222");
    public static final RString DEFAULT_被保険者との関係コード = new RString("");
    public static final YubinNo DEFAULT_代理人郵便番号 = new YubinNo("0010001");
    public static final AtenaJusho DEFAULT_代理人住所 = new AtenaJusho("");
    public static final AtenaMeisho DEFAULT_代理人氏名 = new AtenaMeisho("");
    public static final TelNo DEFAULT_代理人電話番号 = new TelNo("08011112222");
    public static final RString DEFAULT_処分庁 = new RString("Data");
    public static final FlexibleDate DEFAULT_処分日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_処分種類コード = new RString("");
    public static final FlexibleDate DEFAULT_処分があったことを知った日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_審査請求の理由 = new RString("Data");
    public static final RString DEFAULT_処分庁教示の有無及び教示の内容 = new RString("Data");
    public static final boolean DEFAULT_添付書類等 = false;
    public static final FlexibleDate DEFAULT_審査請求取下日 = new FlexibleDate("19900101");
    public static final boolean DEFAULT_弁明書登録フラグ = false;
    public static final FlexibleDate DEFAULT_弁明書作成日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_裁決日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_裁決結果 = new RString("Data");
    public static final RString DEFAULT_裁決理由 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7001FufukuMoshitateEntityGenerator() {
    }

    public static DbT7001FufukuMoshitateEntity createDbT7001FufukuMoshitateEntity() {
        DbT7001FufukuMoshitateEntity entity = new DbT7001FufukuMoshitateEntity();
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setGenshobunsHihokennshaNo(DEFAULT_原処分被保険者番号);
        entity.setShinsaSeikyuTodokedeYMD(DEFAULT_審査請求届出日);
        entity.setShinsaSeikyuninYubinNo(DEFAULT_審査請求人郵便番号);
        entity.setShinsaSeikyuninJusho(DEFAULT_審査請求人住所);
        entity.setShinsaSeikyuninShimei(DEFAULT_審査請求人氏名);
        entity.setShinsaSeikyuninTelNo(DEFAULT_審査請求人電話番号);
        entity.setHihokenshaTonoKankeiCode(DEFAULT_被保険者との関係コード);
        entity.setDairininYubinNo(DEFAULT_代理人郵便番号);
        entity.setDairininJusho(DEFAULT_代理人住所);
        entity.setDairininShimei(DEFAULT_代理人氏名);
        entity.setDairininTelNo(DEFAULT_代理人電話番号);
        entity.setShobunCho(DEFAULT_処分庁);
        entity.setShobunYMD(DEFAULT_処分日);
        entity.setShobunShuruiCode(DEFAULT_処分種類コード);
        entity.setShobunKakuninYMD(DEFAULT_処分があったことを知った日);
        entity.setShinsaSeikyuRiyu(DEFAULT_審査請求の理由);
        entity.setShobunChoKyojiNaiyo(DEFAULT_処分庁教示の有無及び教示の内容);
        entity.setTempuShoruiTo(DEFAULT_添付書類等);
        entity.setShinsaSeikyuTorisageYMD(DEFAULT_審査請求取下日);
        entity.setBemmeishoTorokuFlag(DEFAULT_弁明書登録フラグ);
        entity.setBemmeishoSakuseiYMD(DEFAULT_弁明書作成日);
        entity.setSaiketsuYMD(DEFAULT_裁決日);
        entity.setSaiketsuKekka(DEFAULT_裁決結果);
        entity.setSaiketsuRiyu(DEFAULT_裁決理由);
        return entity;
    }
}
