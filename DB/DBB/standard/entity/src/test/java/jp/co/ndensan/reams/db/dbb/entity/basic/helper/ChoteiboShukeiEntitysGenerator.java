/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.basic.helper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DankaiShokei;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.Kibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.KibetsuShokei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護賦課エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 */
public final class ChoteiboShukeiEntitysGenerator {

    public static final FlexibleYear DEFAULT_調定年度 = new FlexibleYear("1990");
    public static final FlexibleYear DEFAULT_賦課年度 = new FlexibleYear("1990");
    public static final TsuchishoNo DEFAULT_通知書番号 = new TsuchishoNo("1");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("00001");
    public static final RString DEFAULT_特殊徴収方法 = new RString("1");
    public static final RString DEFAULT_普通徴収方法 = new RString("2");
    public static final int DEFAULT_1期 = 1;
    public static final int DEFAULT_2期 = 2;
    public static final Decimal DEFAULT_調定額 = new Decimal(10.05);
    public static final RString DEFAULT_段階 = new RString("Dat");
    public static final int DEFAULT_当月末フラグ = 1;
    public static final int DEFAULT_前月末フラグ = 0;
    public static final Decimal DEFAULT_前月末件数 = new Decimal("10");
    public static final Decimal DEFAULT_前月末調定額小計 = new Decimal("20");
    public static final Decimal DEFAULT_増件数 = new Decimal("10");
    public static final Decimal DEFAULT_増調定額小計 = new Decimal("20");
    public static final Decimal DEFAULT_減件数 = new Decimal("10");
    public static final Decimal DEFAULT_減調定額小計 = new Decimal("20");
    public static final Decimal DEFAULT_当月末件数 = new Decimal("15");
    public static final Decimal DEFAULT_当月末調定額小計 = new Decimal("25");
    public static final Decimal DEFAULT_特徴者数の件数 = new Decimal("11");
    public static final Decimal DEFAULT_普徴者数の件数 = new Decimal("11");
    public static final Decimal DEFAULT_内併徴者数の件数 = new Decimal("11");
    public static final Decimal DEFAULT_第1期の調定額の小計 = new Decimal("10");
    public static final Decimal DEFAULT_第2期の調定額の小計 = new Decimal("10");
    public static final Decimal DEFAULT_第3期の調定額の小計 = new Decimal("10");
    public static final Decimal DEFAULT_第4期の調定額の小計 = new Decimal("10");
    public static final Decimal DEFAULT_第5期の調定額の小計 = new Decimal("10");
    public static final Decimal DEFAULT_第6期の調定額の小計 = new Decimal("10");
    public static final Decimal DEFAULT_第7期の調定額の小計 = new Decimal("10");
    public static final Decimal DEFAULT_第8期の調定額の小計 = new Decimal("10");
    public static final Decimal DEFAULT_第9期の調定額の小計 = new Decimal("10");
    public static final Decimal DEFAULT_第10期の調定額の小計 = new Decimal("10");
    public static final Decimal DEFAULT_第11期の調定額の小計 = new Decimal("10");
    public static final Decimal DEFAULT_第12期の調定額の小計 = new Decimal("10");
    public static final Decimal DEFAULT_第13期の調定額の小計 = new Decimal("10");
    public static final Decimal DEFAULT_第14期の調定額の小計 = new Decimal("10");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private ChoteiboShukeiEntitysGenerator() {
    }

    public static List<Kibetsu> createKibetsuTokusyoOokiEntity() {
        List<Kibetsu> kibetsuList = new ArrayList<>();

        kibetsuList.add(Kibetsu.createParam(DEFAULT_調定年度, DEFAULT_賦課年度, DEFAULT_通知書番号, DEFAULT_履歴番号,
                DEFAULT_被保険者番号, DEFAULT_特殊徴収方法, DEFAULT_1期, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額,
                DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額,
                DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額));

        kibetsuList.add(Kibetsu.createParam(DEFAULT_調定年度, DEFAULT_賦課年度, DEFAULT_通知書番号, DEFAULT_履歴番号,
                DEFAULT_被保険者番号, DEFAULT_特殊徴収方法, DEFAULT_1期, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額,
                DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額,
                DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額));
        return kibetsuList;
    }

    public static Kibetsu createKibetsuTokusyo1kiEntity() {
        return Kibetsu.createParam(DEFAULT_調定年度, DEFAULT_賦課年度, DEFAULT_通知書番号, DEFAULT_履歴番号,
                DEFAULT_被保険者番号, DEFAULT_特殊徴収方法, DEFAULT_1期, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額,
                DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額,
                DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額);
    }

    public static Kibetsu createKibetsuFutsu2kiEntity() {
        return Kibetsu.createParam(DEFAULT_調定年度, DEFAULT_賦課年度, DEFAULT_通知書番号, DEFAULT_履歴番号,
                DEFAULT_被保険者番号, DEFAULT_普通徴収方法, DEFAULT_2期, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額,
                DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額,
                DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額, DEFAULT_調定額);
    }

    public static List<KibetsuShokei> createKibetsuShokeiTokusyoOokiEntity() {
        List<KibetsuShokei> kibetsuShokeiList = new ArrayList<>();
        kibetsuShokeiList.add(KibetsuShokei.createParam(DEFAULT_調定年度, DEFAULT_賦課年度, DEFAULT_特殊徴収方法,
                DEFAULT_第1期の調定額の小計, DEFAULT_第2期の調定額の小計, DEFAULT_第3期の調定額の小計,
                DEFAULT_第4期の調定額の小計, DEFAULT_第5期の調定額の小計, DEFAULT_第6期の調定額の小計,
                DEFAULT_第7期の調定額の小計, DEFAULT_第8期の調定額の小計, DEFAULT_第9期の調定額の小計,
                DEFAULT_第10期の調定額の小計, DEFAULT_第11期の調定額の小計, DEFAULT_第12期の調定額の小計,
                DEFAULT_第13期の調定額の小計, DEFAULT_第14期の調定額の小計));
        kibetsuShokeiList.add(KibetsuShokei.createParam(DEFAULT_調定年度, DEFAULT_賦課年度, DEFAULT_普通徴収方法,
                DEFAULT_第1期の調定額の小計, DEFAULT_第2期の調定額の小計, DEFAULT_第3期の調定額の小計,
                DEFAULT_第4期の調定額の小計, DEFAULT_第5期の調定額の小計, DEFAULT_第6期の調定額の小計,
                DEFAULT_第7期の調定額の小計, DEFAULT_第8期の調定額の小計, DEFAULT_第9期の調定額の小計,
                DEFAULT_第10期の調定額の小計, DEFAULT_第11期の調定額の小計, DEFAULT_第12期の調定額の小計,
                DEFAULT_第13期の調定額の小計, DEFAULT_第14期の調定額の小計));
        return kibetsuShokeiList;
    }

    public static List<DankaiShokei> createDankaiShokeiTokusyoOokiEntity() {
        List<DankaiShokei> dankaiShokeiList = new ArrayList<>();
        dankaiShokeiList.add(DankaiShokei.createParam(DEFAULT_調定年度, DEFAULT_賦課年度, DEFAULT_特殊徴収方法,
                DEFAULT_段階, DEFAULT_当月末フラグ, DEFAULT_前月末件数, DEFAULT_前月末調定額小計, DEFAULT_増件数,
                DEFAULT_増調定額小計, DEFAULT_減件数, DEFAULT_減調定額小計, DEFAULT_当月末件数, DEFAULT_当月末調定額小計,
                DEFAULT_特徴者数の件数, DEFAULT_普徴者数の件数, DEFAULT_内併徴者数の件数));
        dankaiShokeiList.add(DankaiShokei.createParam(DEFAULT_調定年度, DEFAULT_賦課年度, DEFAULT_特殊徴収方法,
                DEFAULT_段階, DEFAULT_前月末フラグ, DEFAULT_前月末件数, DEFAULT_前月末調定額小計, DEFAULT_増件数,
                DEFAULT_増調定額小計, DEFAULT_減件数, DEFAULT_減調定額小計, DEFAULT_当月末件数, DEFAULT_当月末調定額小計,
                DEFAULT_特徴者数の件数, DEFAULT_普徴者数の件数, DEFAULT_内併徴者数の件数));
        dankaiShokeiList.add(DankaiShokei.createParam(DEFAULT_調定年度, DEFAULT_賦課年度, DEFAULT_普通徴収方法,
                DEFAULT_段階, DEFAULT_当月末フラグ, DEFAULT_前月末件数, DEFAULT_前月末調定額小計, DEFAULT_増件数,
                DEFAULT_増調定額小計, DEFAULT_減件数, DEFAULT_減調定額小計, DEFAULT_当月末件数, DEFAULT_当月末調定額小計,
                DEFAULT_特徴者数の件数, DEFAULT_普徴者数の件数, DEFAULT_内併徴者数の件数));
        dankaiShokeiList.add(DankaiShokei.createParam(DEFAULT_調定年度, DEFAULT_賦課年度, DEFAULT_普通徴収方法,
                DEFAULT_段階, DEFAULT_前月末フラグ, DEFAULT_前月末件数, DEFAULT_前月末調定額小計, DEFAULT_増件数,
                DEFAULT_増調定額小計, DEFAULT_減件数, DEFAULT_減調定額小計, DEFAULT_当月末件数, DEFAULT_当月末調定額小計,
                DEFAULT_特徴者数の件数, DEFAULT_普徴者数の件数, DEFAULT_内併徴者数の件数));
        return dankaiShokeiList;
    }
}
