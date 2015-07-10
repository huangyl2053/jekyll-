/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3085DaisanshaKoiTodokedeMeisaiEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護第三者行為届出詳細エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3085DaisanshaKoiTodokedeMeisaiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final RString DEFAULT_第三者行為届出管理番号 = new RString("123");
    public static final JigyoshaNo DEFAULT_サービス提供事業者番号 = new JigyoshaNo(new RString("02"));
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode(new RString("02"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleDate DEFAULT_サービス利用開始年月日 = new FlexibleDate("20140402");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3085DaisanshaKoiTodokedeMeisaiEntityGenerator() {
    }

    public static DbT3085DaisanshaKoiTodokedeMeisaiEntity createDbT3085DaisanshaKoiTodokedeMeisaiEntity() {
        DbT3085DaisanshaKoiTodokedeMeisaiEntity entity = new DbT3085DaisanshaKoiTodokedeMeisaiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTodokedeKanriNo(DEFAULT_第三者行為届出管理番号);
        entity.setServiceTeikyoJigyoshaNo(DEFAULT_サービス提供事業者番号);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setServiceRiyoKaishiYMD(DEFAULT_サービス利用開始年月日);
        return entity;
    }
}
