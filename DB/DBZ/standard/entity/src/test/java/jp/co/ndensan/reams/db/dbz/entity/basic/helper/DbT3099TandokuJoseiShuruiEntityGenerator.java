/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3099TandokuJoseiShuruiEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 市町村単独助成種類エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3099TandokuJoseiShuruiEntityGenerator {

    public static final RString DEFAULT_市町村単独助成種類 = new RString("12");
    public static final ServiceShuruiCode DEFAULT_助成サービス種類コード = new ServiceShuruiCode(new RString("02"));
    public static final FlexibleYearMonth DEFAULT_適用開始年月 = new FlexibleYearMonth(new RString("201402"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleYearMonth DEFAULT_適用終了年月 = new FlexibleYearMonth(new RString("201405"));
    public static final RString DEFAULT_助成サービス種類名称 = new RString("3");
    public static final Decimal DEFAULT_市町村単独助成単位 = new Decimal(1013);
    public static final RString DEFAULT_市町村単独助成内容 = new RString("内容");

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
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setTekiyoShuryoYM(DEFAULT_適用終了年月);
        entity.setJoseiServiceShuriMeisho(DEFAULT_助成サービス種類名称);
        entity.setJoseiTani(DEFAULT_市町村単独助成単位);
        entity.setJoseiNaiyo(DEFAULT_市町村単独助成内容);
        return entity;
    }
}
