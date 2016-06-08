/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5032ShujiiIkenshoHoshuTankaEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 意見書作成報酬単価エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5032ShujiiIkenshoHoshuTankaEntityGenerator {

    public static final Code DEFAULT_在宅施設区分 = new Code("01");
    public static final Code DEFAULT_意見書作成回数区分 = new Code("01");
    public static final FlexibleYearMonth DEFAULT_開始年月 = new FlexibleYearMonth("201508");
    public static final FlexibleYearMonth DEFAULT_終了年月 = new FlexibleYearMonth("201508");
    public static final Decimal DEFAULT_単価 = new Decimal(1);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5032ShujiiIkenshoHoshuTankaEntityGenerator() {
    }

    public static DbT5032ShujiiIkenshoHoshuTankaEntity createDbT5032ShujiiIkenshoHoshuTankaEntity() {
        DbT5032ShujiiIkenshoHoshuTankaEntity entity = new DbT5032ShujiiIkenshoHoshuTankaEntity();
        entity.setZaitakuShisetsuKubun(DEFAULT_在宅施設区分);
        entity.setIkenshoSakuseiKaisuKubun(DEFAULT_意見書作成回数区分);
        entity.setKaishiYM(DEFAULT_開始年月);
        entity.setShuryoYM(DEFAULT_終了年月);
        entity.setTanka(DEFAULT_単価);
        return entity;
    }
}
