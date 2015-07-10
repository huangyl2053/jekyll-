/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3083DaisanshaKoiKyushoMeisaiEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護第三者行為求償明細エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("01234567"));
    public static final RString DEFAULT_第三者行為届出管理番号 = new RString("123");
    public static final RString DEFAULT_第三者行為求償請求番号 = new RString("123");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201402"));
    public static final JigyoshaNo DEFAULT_サービス提供事業者番号 = new JigyoshaNo(new RString("12"));
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode(new RString("12"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final Decimal DEFAULT_給付額 = new Decimal(100);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator() {
    }

    public static DbT3083DaisanshaKoiKyushoMeisaiEntity createDbT3083DaisanshaKoiKyushoMeisaiEntity() {
        DbT3083DaisanshaKoiKyushoMeisaiEntity entity = new DbT3083DaisanshaKoiKyushoMeisaiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTodokedeKanriNo(DEFAULT_第三者行為届出管理番号);
        entity.setKyushoSeikyuNo(DEFAULT_第三者行為求償請求番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setServiceTeikyoJigyoshaNo(DEFAULT_サービス提供事業者番号);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setKyufuGaku(DEFAULT_給付額);
        return entity;
    }
}
