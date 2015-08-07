/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3085DaisanshaKoiTodokedeMeisaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護第三者行為届出詳細エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3085DaisanshaKoiTodokedeMeisaiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final RString DEFAULT_第三者行為届出管理番号 = new RString("Data");
    public static final JigyoshaNo DEFAULT_サービス提供事業者番号 = new JigyoshaNo();
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode();
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleDate DEFAULT_サービス利用開始年月日 = new FlexibleDate("19900101");

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
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setServiceRiyoKaishiYMD(DEFAULT_サービス利用開始年月日);
        return entity;
    }
}
