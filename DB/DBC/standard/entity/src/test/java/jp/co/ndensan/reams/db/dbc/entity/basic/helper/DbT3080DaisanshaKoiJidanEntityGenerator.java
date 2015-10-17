/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3080DaisanshaKoiJidanEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護第三者行為示談エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3080DaisanshaKoiJidanEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final RString DEFAULT_第三者行為届出管理番号 = new RString("Data");
    public static final FlexibleDate DEFAULT_示談報告書受付年月日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final RString DEFAULT_第三者行為求償協議区分 = new RString("Data");
    public static final FlexibleDate DEFAULT_示談報告書提出年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_示談成立年月日 = new FlexibleDate("19900101");
    public static final FlexibleYearMonth DEFAULT_給付期間開始年月 = new FlexibleYearMonth("199001");
    public static final FlexibleYearMonth DEFAULT_給付期間終了年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_過失割合_加害者 = new RString("Data");
    public static final RString DEFAULT_過失割合_被害者 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3080DaisanshaKoiJidanEntityGenerator() {
    }

    public static DbT3080DaisanshaKoiJidanEntity createDbT3080DaisanshaKoiJidanEntity() {
        DbT3080DaisanshaKoiJidanEntity entity = new DbT3080DaisanshaKoiJidanEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTodokedeKanriNo(DEFAULT_第三者行為届出管理番号);
        entity.setJidanHokokushoUketukeYMD(DEFAULT_示談報告書受付年月日);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setKyushoKyogiKubun(DEFAULT_第三者行為求償協議区分);
        entity.setJidanHokokushoTeishutsuYMD(DEFAULT_示談報告書提出年月日);
        entity.setJidanSeiritsuYMD(DEFAULT_示談成立年月日);
        entity.setKyufuKaishiYMD(DEFAULT_給付期間開始年月);
        entity.setKyufuShuryoYMD(DEFAULT_給付期間終了年月);
        entity.setKashitsuWariai_Kagaisha(DEFAULT_過失割合_加害者);
        entity.setKashitsuWariai_Higaisha(DEFAULT_過失割合_被害者);
        return entity;
    }
}
