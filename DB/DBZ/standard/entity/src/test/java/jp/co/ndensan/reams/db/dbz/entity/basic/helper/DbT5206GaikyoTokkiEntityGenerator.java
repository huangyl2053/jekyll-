/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5206GaikyoTokkiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査票_概況特記エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5206GaikyoTokkiEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("900001");
    public static final int DEFAULT_認定調査依頼履歴番号 = 1;
    public static final RString DEFAULT_概況特記テキストイメージ区分 = new RString("概況特記テキストイメージ区分");
    public static final RString DEFAULT_住宅改修 = new RString("住宅改修");
    public static final RString DEFAULT_市町村特別給付サービス種類名 = new RString("市町村特別給付サービス種類");
    public static final RString DEFAULT_介護保険給付以外の在宅サービス種類名 = new RString("介護保険給付以外の在宅サービス種類名");
    public static final RString DEFAULT_概況特記事項_主訴 = new RString("名称");
//    public static final RDateTime DEFAULT_概況特記_主訴_イメージ共有ファイルID = RDateTime.of(2014, 9, 1, 10, 20, 30, 123);
//    public static final RDateTime DEFAULT_概況特記_主訴_マスキングイメージ共有ファイルID = RDateTime.of(2014, 9, 1, 10, 20, 30, 123);
    public static final RString DEFAULT_概況特記事項_家族状況 = new RString("名称");
//    public static final RDateTime DEFAULT_概況特記_家族状況_イメージ共有ファイルID = RDateTime.of(2014, 9, 1, 10, 20, 30, 123);
//    public static final RDateTime DEFAULT_概況特記_家族状況_マスキングイメージ共有ファイルID = RDateTime.of(2014, 9, 1, 10, 20, 30, 123);
    public static final RString DEFAULT_概況特記事項_居住環境 = new RString("名称");
//    public static final RDateTime DEFAULT_概況特記_居住環境_イメージ共有ファイルID = RDateTime.of(2014, 9, 1, 10, 20, 30, 123);
//    public static final RDateTime DEFAULT_概況特記_居住環境_マスキングイメージ共有ファイルID = RDateTime.of(2014, 9, 1, 10, 20, 30, 123);
    public static final RString DEFAULT_概況特記事項_機器_器械 = new RString("名称");
//    public static final RDateTime DEFAULT_概況特記_機器_器械_イメージ共有ファイルID = RDateTime.of(2014, 9, 1, 10, 20, 30, 123);
//    public static final RDateTime DEFAULT_概況特記_機器_器械_マスキングイメージ共有ファイルID = RDateTime.of(2014, 9, 1, 10, 20, 30, 123);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5206GaikyoTokkiEntityGenerator() {
    }

    public static DbT5206GaikyoTokkiEntity createDbT5206GaikyoTokkiEntity() {
        DbT5206GaikyoTokkiEntity entity = new DbT5206GaikyoTokkiEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setNinteichosaRirekiNo(DEFAULT_認定調査依頼履歴番号);
        entity.setGaikyoTokkiTextImageKubun(DEFAULT_概況特記テキストイメージ区分);
        entity.setJutakuKaishu(DEFAULT_住宅改修);
        entity.setTokubetsuKyufuService(DEFAULT_市町村特別給付サービス種類名);
        entity.setZaitakuService(DEFAULT_介護保険給付以外の在宅サービス種類名);
        entity.setShuso(DEFAULT_概況特記事項_主訴);
//        entity.setShusoImageSharedFileId(DEFAULT_概況特記_主訴_イメージ共有ファイルID);
//        entity.setShusoMaskingImageSharedFileId(DEFAULT_概況特記_主訴_マスキングイメージ共有ファイルID);
        entity.setKazokuJokyo(DEFAULT_概況特記事項_家族状況);
//        entity.setKazokuJokyoImageSharedFileId(DEFAULT_概況特記_家族状況_イメージ共有ファイルID);
//        entity.setKazokuJokyoMaskingImageSharedFileId(DEFAULT_概況特記_家族状況_マスキングイメージ共有ファイルID);
        entity.setKyojuKankyo(DEFAULT_概況特記事項_居住環境);
//        entity.setKyojuKankyoImageSharedFileId(DEFAULT_概況特記_居住環境_イメージ共有ファイルID);
//        entity.setKyojuKankyoMaskingImageSharedFileId(DEFAULT_概況特記_居住環境_マスキングイメージ共有ファイルID);
        entity.setKikaiKiki(DEFAULT_概況特記事項_機器_器械);
//        entity.setKikaiKikiImageSharedFileId(DEFAULT_概況特記_機器_器械_イメージ共有ファイルID);
//        entity.setKikaiKikiMaskingImageSharedFileId(DEFAULT_概況特記_機器_器械_マスキングイメージ共有ファイルID);
        return entity;
    }
}
