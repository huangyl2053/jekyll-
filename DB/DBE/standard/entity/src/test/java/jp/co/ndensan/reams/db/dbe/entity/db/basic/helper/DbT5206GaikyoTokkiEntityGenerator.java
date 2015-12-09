/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5206GaikyoTokkiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査票（概況特記）エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5206GaikyoTokkiEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("1");
    public static final int DEFAULT_認定調査依頼履歴番号 = 1;
    public static final RString DEFAULT_住宅改修_改修箇所 = new RString("住宅改修箇所");
    public static final RDateTime DEFAULT_住宅改修_改修箇所_イメージ共有ファイルID = RDateTime.of(2014, 04, 02, 10, 00, 00);
    public static final RDateTime DEFAULT_住宅改修_改修箇所_マスキングイメージ共有ファイルID = RDateTime.of(2014, 04, 02, 10, 00, 00);
    public static final RString DEFAULT_市町村特別給付サービス種類名 = new RString("市町村特別給付サービス種類名");
    public static final RDateTime DEFAULT_市町村特別給付サービス種類名イメージ共有ファイルID = RDateTime.of(2014, 04, 02, 10, 00, 00);
    public static final RDateTime DEFAULT_市町村特別給付サービス種類名マスキングイメージ共有ファイルID = RDateTime.of(2014, 04, 02, 10, 00, 00);
    public static final RString DEFAULT_概況特記事項_主訴 = new RString("概況特記事項の主訴");
    public static final RDateTime DEFAULT_概況特記_主訴_イメージ共有ファイルID = RDateTime.of(2014, 04, 02, 10, 00, 00);
    public static final RDateTime DEFAULT_概況特記_主訴_マスキングイメージ共有ファイルID = RDateTime.of(2014, 04, 02, 10, 00, 00);
    public static final RString DEFAULT_概況特記事項_家族状況 = new RString("概況特記事項の家族状況");
    public static final RDateTime DEFAULT_概況特記_家族状況_イメージ共有ファイルID = RDateTime.of(2014, 04, 02, 10, 00, 00);
    public static final RDateTime DEFAULT_概況特記_家族状況_マスキングイメージ共有ファイルID = RDateTime.of(2014, 04, 02, 10, 00, 00);
    public static final RString DEFAULT_概況特記事項_居住環境 = new RString("概況特記事項の居住環境");
    public static final RDateTime DEFAULT_概況特記_居住環境_イメージ共有ファイルID = RDateTime.of(2014, 04, 02, 10, 00, 00);
    public static final RDateTime DEFAULT_概況特記_居住環境_マスキングイメージ共有ファイルID = RDateTime.of(2014, 04, 02, 10, 00, 00);
    public static final RString DEFAULT_概況特記事項_機器_器械 = new RString("概況特記事項の機器・器械");
    public static final RDateTime DEFAULT_概況特記_機器_器械_イメージ共有ファイルID = RDateTime.of(2014, 04, 02, 10, 00, 00);
    public static final RDateTime DEFAULT_概況特記_機器_器械_マスキングイメージ共有ファイルID = RDateTime.of(2014, 04, 02, 10, 00, 00);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5206GaikyoTokkiEntityGenerator() {
    }

    public static DbT5206GaikyoTokkiEntity createDbT5206GaikyoTokkiEntity() {
        DbT5206GaikyoTokkiEntity entity = new DbT5206GaikyoTokkiEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setNinteichosaRirekiNo(DEFAULT_認定調査依頼履歴番号);
        entity.setShuso(DEFAULT_概況特記事項_主訴);
        entity.setShusoImageSharedFileId(DEFAULT_概況特記_主訴_イメージ共有ファイルID);
        entity.setShusoMaskingImageSharedFileId(DEFAULT_概況特記_主訴_マスキングイメージ共有ファイルID);
        entity.setKazokuJokyo(DEFAULT_概況特記事項_家族状況);
        entity.setKazokuJokyoImageSharedFileId(DEFAULT_概況特記_家族状況_イメージ共有ファイルID);
        entity.setKazokuJokyoMaskingImageSharedFileId(DEFAULT_概況特記_家族状況_マスキングイメージ共有ファイルID);
        entity.setKyojuKankyo(DEFAULT_概況特記事項_居住環境);
        entity.setKyojuKankyoImageSharedFileId(DEFAULT_概況特記_居住環境_イメージ共有ファイルID);
        entity.setKyojuKankyoMaskingImageSharedFileId(DEFAULT_概況特記_居住環境_マスキングイメージ共有ファイルID);
        entity.setKikaiKiki(DEFAULT_概況特記事項_機器_器械);
        entity.setKikaiKikiImageSharedFileId(DEFAULT_概況特記_機器_器械_イメージ共有ファイルID);
        entity.setKikaiKikiMaskingImageSharedFileId(DEFAULT_概況特記_機器_器械_マスキングイメージ共有ファイルID);
        return entity;
    }
}
