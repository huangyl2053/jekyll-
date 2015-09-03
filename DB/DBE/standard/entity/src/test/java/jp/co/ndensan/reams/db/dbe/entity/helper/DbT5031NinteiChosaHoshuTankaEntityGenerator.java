/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5031NinteiChosaHoshuTankaEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 認定調査報酬単価エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5031NinteiChosaHoshuTankaEntityGenerator {

    public static final Code DEFAULT_調査区分 = new Code("01");
    public static final Code DEFAULT_訪問種別 = new Code("01");
    public static final Code DEFAULT_意見書入手パターン = new Code("01");
    public static final FlexibleYearMonth DEFAULT_開始年月 = new FlexibleYearMonth("201508");
    public static final FlexibleYearMonth DEFAULT_終了年月 = new FlexibleYearMonth("201508");
    public static final Decimal DEFAULT_単価 = new Decimal(1);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5031NinteiChosaHoshuTankaEntityGenerator() {
    }

    public static DbT5031NinteiChosaHoshuTankaEntity createDbT5031NinteiChosaHoshuTankaEntity() {
        DbT5031NinteiChosaHoshuTankaEntity entity = new DbT5031NinteiChosaHoshuTankaEntity();
        entity.setChosaKubun(DEFAULT_調査区分);
        entity.setHomonShubetsu(DEFAULT_訪問種別);
        entity.setIkenshoNyushuPatern(DEFAULT_意見書入手パターン);
        entity.setKaishiYM(DEFAULT_開始年月);
        entity.setShuryoYM(DEFAULT_終了年月);
        entity.setTanka(DEFAULT_単価);
        return entity;
    }
}
