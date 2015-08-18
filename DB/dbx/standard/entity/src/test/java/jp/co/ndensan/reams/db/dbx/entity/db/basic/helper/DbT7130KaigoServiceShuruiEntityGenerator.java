/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoServiceBunruiCode;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
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
 * 介護サービス種類エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7130KaigoServiceShuruiEntityGenerator {

    public static final KaigoServiceShuruiCode DEFAULT_サービス種類コード = new KaigoServiceShuruiCode("01");
    public static final FlexibleYearMonth DEFAULT_提供開始年月 = new FlexibleYearMonth("199012");
    public static final FlexibleYearMonth DEFAULT_提供終了年月 = new FlexibleYearMonth("199012");
    public static final RString DEFAULT_サービス種類名称 = new RString("Data");
    public static final RString DEFAULT_サービス種類略称 = new RString("Data");
    public static final KaigoServiceBunruiCode DEFAULT_サービス分類コード = new KaigoServiceBunruiCode(new Code("01"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7130KaigoServiceShuruiEntityGenerator() {
    }

    public static DbT7130KaigoServiceShuruiEntity createDbT7130KaigoServiceShuruiEntity() {
        DbT7130KaigoServiceShuruiEntity entity = new DbT7130KaigoServiceShuruiEntity();
        entity.setServiceShuruiCd(DEFAULT_サービス種類コード);
        entity.setTeikyoKaishiYM(DEFAULT_提供開始年月);
        entity.setTeikyoshuryoYM(DEFAULT_提供終了年月);
        entity.setServiceShuruiMeisho(DEFAULT_サービス種類名称);
        entity.setServiceShuruiRyakusho(DEFAULT_サービス種類略称);
        entity.setServiceBunrruicode(DEFAULT_サービス分類コード);
        return entity;
    }
}
