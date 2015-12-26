/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査票（概況調査）（子）エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5202NinteichosahyoGaikyoChosaEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("900001");
    public static final int DEFAULT_認定調査依頼履歴番号 = 1;
    public static final Code DEFAULT_厚労省IF識別コード = new Code("01");
    public static final Code DEFAULT_認定調査依頼区分コード = new Code("01");
    public static final int DEFAULT_認定調査回数 = 1;
    public static final FlexibleDate DEFAULT_認定調査実施年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_認定調査受領年月日 = new FlexibleDate("20141030");
    public static final Code DEFAULT_調査委託区分コード = new Code("01");
    public static final Code DEFAULT_認定調査区分コード = new Code("01");
    public static final JigyoshaNo DEFAULT_認定調査委託先コード = new JigyoshaNo("111111");
    public static final RString DEFAULT_認定調査員コード = new RString("名称");
    public static final Code DEFAULT_認定調査実施場所コード = new Code("01");
    public static final RString DEFAULT_認定調査実施場所名称 = new RString("名称");
    public static final RDateTime DEFAULT_実施場所イメージ共有ファイルID = RDateTime.of(2014, 9, 1, 10, 20, 30, 123);
    public static final Code DEFAULT_認定調査_現在の状況コード = new Code("01");
    public static final Code DEFAULT_認定調査_サービス区分コード = new Code("01");
    public static final RString DEFAULT_利用施設名 = new RString("名称");
    public static final AtenaJusho DEFAULT_利用施設住所 = new AtenaJusho("電算市リームス町");
    public static final TelNo DEFAULT_利用施設電話番号 = new TelNo("0123456789");
    public static final YubinNo DEFAULT_利用施設郵便番号 = new YubinNo("1234567");
    public static final RDateTime DEFAULT_利用施設名イメージ共有ファイルID = RDateTime.of(2014, 9, 1, 10, 20, 30, 123);
    public static final RDateTime DEFAULT_利用施設住所イメージ共有ファイルID = RDateTime.of(2014, 9, 1, 10, 20, 30, 123);
    public static final RDateTime DEFAULT_利用施設電話番号イメージ共有ファイルID = RDateTime.of(2014, 9, 1, 10, 20, 30, 123);
    public static final RString DEFAULT_特記 = new RString("名称");
    public static final RDateTime DEFAULT_特記イメージ共有ファイルID = RDateTime.of(2014, 9, 1, 10, 20, 30, 123);
    public static final FlexibleDate DEFAULT_認定調査特記事項受付年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_認定調査特記事項受領年月日 = new FlexibleDate("20141030");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5202NinteichosahyoGaikyoChosaEntityGenerator() {
    }

    public static DbT5202NinteichosahyoGaikyoChosaEntity createDbT5202NinteichosahyoGaikyoChosaEntity() {
        DbT5202NinteichosahyoGaikyoChosaEntity entity = new DbT5202NinteichosahyoGaikyoChosaEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setNinteichosaRirekiNo(DEFAULT_認定調査依頼履歴番号);
        entity.setKoroshoIfShikibetsuCode(DEFAULT_厚労省IF識別コード);
        entity.setNinteichousaIraiKubunCode(DEFAULT_認定調査依頼区分コード);
        entity.setNinteichosaIraiKaisu(DEFAULT_認定調査回数);
        entity.setNinteichosaJisshiYMD(DEFAULT_認定調査実施年月日);
        entity.setNinteichosaJuryoYMD(DEFAULT_認定調査受領年月日);
        entity.setChosaItakuKubunCode(DEFAULT_調査委託区分コード);
        entity.setNinteiChosaKubunCode(DEFAULT_認定調査区分コード);
        entity.setChosaItakusakiCode(DEFAULT_認定調査委託先コード);
        entity.setChosainCode(DEFAULT_認定調査員コード);
        entity.setChosaJisshiBashoCode(DEFAULT_認定調査実施場所コード);
        entity.setChosaJisshiBashoMeisho(DEFAULT_認定調査実施場所名称);
        entity.setJisshiBashoImageSharedFileId(DEFAULT_実施場所イメージ共有ファイルID);
        entity.setServiceKubunCode(DEFAULT_認定調査_サービス区分コード);
        entity.setRiyoShisetsuShimei(DEFAULT_利用施設名);
        entity.setRiyoShisetsuJusho(DEFAULT_利用施設住所);
        entity.setRiyoShisetsuTelNo(DEFAULT_利用施設電話番号);
        entity.setRiyoShisetsuYubinNo(DEFAULT_利用施設郵便番号);
        entity.setRiyoShisetsuNameImageSharedFileId(DEFAULT_利用施設名イメージ共有ファイルID);
        entity.setRiyoShisetsuJushoImageSharedFileId(DEFAULT_利用施設住所イメージ共有ファイルID);
        entity.setRiyoShisetsuTelNoImageSharedFileId(DEFAULT_利用施設電話番号イメージ共有ファイルID);
        entity.setTokki(DEFAULT_特記);
        entity.setTokkiImageSharedFileId(DEFAULT_特記イメージ共有ファイルID);
        entity.setTokkijikoUketsukeYMD(DEFAULT_認定調査特記事項受付年月日);
        entity.setTokkijikoJuryoYMD(DEFAULT_認定調査特記事項受領年月日);
        return entity;
    }
}
