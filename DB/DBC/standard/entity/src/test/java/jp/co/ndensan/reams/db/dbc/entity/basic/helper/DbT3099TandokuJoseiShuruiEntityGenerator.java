/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3099TandokuJoseiShuruiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 市町村単独助成種類エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3099TandokuJoseiShuruiEntityGenerator {

    public static final RString DEFAULT_市町村単独助成種類 = new RString("Data");
    public static final ServiceShuruiCode DEFAULT_助成サービス種類コード = new ServiceShuruiCode("1");
    public static final FlexibleYearMonth DEFAULT_適用開始年月 = new FlexibleYearMonth("199001");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleYearMonth DEFAULT_適用終了年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_助成サービス種類名称 = new RString("Data");
    public static final Decimal DEFAULT_市町村単独助成単位 = new Decimal(0);
    public static final RString DEFAULT_市町村単独助成内容 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3099TandokuJoseiShuruiEntityGenerator() {
    }

    public static DbT3099TandokuJoseiShuruiEntity createDbT3099TandokuJoseiShuruiEntity() {
        DbT3099TandokuJoseiShuruiEntity entity = new DbT3099TandokuJoseiShuruiEntity();
        entity.setTandokuJoseiShuruiCode(DEFAULT_市町村単独助成種類);
        entity.setJoseiServiceShuruiCode(DEFAULT_助成サービス種類コード);
        entity.setTekiyoKaishiYM(DEFAULT_適用開始年月);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setTekiyoShuryoYM(DEFAULT_適用終了年月);
        entity.setJoseiServiceShuriMeisho(DEFAULT_助成サービス種類名称);
        entity.setJoseiTani(DEFAULT_市町村単独助成単位);
        entity.setJoseiNaiyo(DEFAULT_市町村単独助成内容);
        return entity;
    }
}
