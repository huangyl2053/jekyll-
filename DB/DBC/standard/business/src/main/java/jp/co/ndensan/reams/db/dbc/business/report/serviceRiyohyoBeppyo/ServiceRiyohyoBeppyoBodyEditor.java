/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.serviceRiyohyoBeppyo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KyufuJikoSakuseiEntityResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.ServiceTypeTotal;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.TankiRiyoNissuResult;
import jp.co.ndensan.reams.db.dbc.entity.report.source.serviceRiyohyoBeppyo.ServiceRiyohyoBeppyoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC0150011_1_サービス提供票別表Editorのインターフェースクラスです。
 *
 * @reamsid_L DBC-5100-030 tianshuai
 */
public class ServiceRiyohyoBeppyoBodyEditor implements IServiceRiyohyoBeppyoBodyEditor {

    private final List<KyufuJikoSakuseiEntityResult> サービス提供票別表リスト;
    private final List<ServiceTypeTotal> 種類別支給限度情報リスト;
    private final KyufuJikoSakuseiEntityResult 合計情報;
    private final List<TankiRiyoNissuResult> 短期入所情報;
    private final Decimal 種類超過単位数合計;
    private final boolean isサービス提供票最後ページ出力;
    private final boolean is種類別支給限度管理出力;
    private final boolean is種類別支給限度管理最後ページ出力;
    private final boolean is短期入所利用日数出力;
    private static final Class CLS = ServiceRiyohyoBeppyoSource.class;
    private static final int INT_0 = 0;
    private static final int INT_2 = 2;
    private static final int 事業者名上段長さ = 18;
    private static final int サービス上段長さ = 8;
    private static final RString JIGYOMEI11 = new RString("setJigyomei11");
    private static final RString JIGYOMEI12 = new RString("setJigyomei12");
    private static final RString JIGYOSHOCD1 = new RString("setJigyoshoCd1");
    private static final RString SNAME11 = new RString("setSname11");
    private static final RString SNAME12 = new RString("setSname12");
    private static final RString SCODE1 = new RString("setScode1");
    private static final RString TEN1 = new RString("setTen1");
    private static final RString WARIRITSU1 = new RString("setWariritsu1");
    private static final RString WARITEN1 = new RString("setWariten1");
    private static final RString KAI1 = new RString("setKai1");
    private static final RString STENSU1 = new RString("setStensu1");
    private static final RString SOVER1 = new RString("setSover1");
    private static final RString SIN1 = new RString("setSin1");
    private static final RString KOVER1 = new RString("setKover1");
    private static final RString KIN1 = new RString("setKin1");
    private static final RString TANKA1 = new RString("setTanka1");
    private static final RString HIYOU1 = new RString("setHiyou1");
    private static final RString RITU1 = new RString("setRitu1");
    private static final RString KYUFU1 = new RString("setKyufu1");
    private static final RString HOKEN1 = new RString("setHoken1");
    private static final RString ZENGAKU1 = new RString("setZengaku1");
    private static final RString SGNAME = new RString("setSgname");
    private static final RString SGSIN = new RString("setSgsin");
    private static final RString SGTEN = new RString("setSgten");
    private static final RString SGSOVER = new RString("setSgsover");

    /**
     * インスタンスを生成します。
     *
     * @param サービス提供票別表リスト サービス提供票別表リスト
     * @param 種類別支給限度情報リスト 種類別支給限度情報リスト
     * @param 合計情報 合計情報
     * @param 短期入所情報 短期入所情報
     * @param isサービス提供票最後ページ出力 isサービス提供票最後ページ出力
     * @param is種類別支給限度管理出力 is種類別支給限度管理出力
     * @param is種類別支給限度管理最後ページ出力 is種類別支給限度管理最後ページ出力
     * @param is短期入所利用日数出力 is短期入所利用日数出力
     * @param 種類超過単位数合計 種類超過単位数合計
     */
    protected ServiceRiyohyoBeppyoBodyEditor(List<KyufuJikoSakuseiEntityResult> サービス提供票別表リスト,
            List<ServiceTypeTotal> 種類別支給限度情報リスト,
            KyufuJikoSakuseiEntityResult 合計情報,
            List<TankiRiyoNissuResult> 短期入所情報,
            boolean isサービス提供票最後ページ出力,
            boolean is種類別支給限度管理出力,
            boolean is種類別支給限度管理最後ページ出力,
            boolean is短期入所利用日数出力,
            Decimal 種類超過単位数合計) {
        this.サービス提供票別表リスト = サービス提供票別表リスト;
        this.種類別支給限度情報リスト = 種類別支給限度情報リスト;
        this.合計情報 = 合計情報;
        this.短期入所情報 = 短期入所情報;
        this.isサービス提供票最後ページ出力 = isサービス提供票最後ページ出力;
        this.is種類別支給限度管理出力 = is種類別支給限度管理出力;
        this.is種類別支給限度管理最後ページ出力 = is種類別支給限度管理最後ページ出力;
        this.is短期入所利用日数出力 = is短期入所利用日数出力;
        this.種類超過単位数合計 = 種類超過単位数合計;
    }

    @Override
    public ServiceRiyohyoBeppyoSource edit(ServiceRiyohyoBeppyoSource source) {
        return editSource(source);
    }

    private ServiceRiyohyoBeppyoSource editSource(ServiceRiyohyoBeppyoSource source) {
        setサービス提供票(source);
        setサービス提供票総計(source);
        set種類別支給限度管理(source);
        set種類超過単位数合計(source);
        set短期入所利用日数(source);
        return source;
    }

    private void setサービス提供票(ServiceRiyohyoBeppyoSource source) {
        if (this.サービス提供票別表リスト.isEmpty()) {
            return;
        }
        Method method;
        for (int i = 1; i <= this.サービス提供票別表リスト.size(); i++) {
            try {
                KyufuJikoSakuseiEntityResult サービス提供票別表 = サービス提供票別表リスト.get(i - 1);
                RString 事業者名 = サービス提供票別表.get事業者();
                if (RString.isNullOrEmpty(事業者名) || 事業者名.length() <= 事業者名上段長さ) {
                    method = CLS.getMethod(JIGYOMEI11.concat(new RString(i)).toString(), RString.class);
                    method.invoke(source, 事業者名);
                    method = CLS.getMethod(JIGYOMEI12.concat(new RString(i)).toString(), RString.class);
                    method.invoke(source, RString.EMPTY);
                }
                if (事業者名.length() > 事業者名上段長さ) {
                    method = CLS.getMethod(JIGYOMEI11.concat(new RString(i)).toString(), RString.class);
                    method.invoke(source, 事業者名.substring(0, 事業者名上段長さ));
                    method = CLS.getMethod(JIGYOMEI12.concat(new RString(i)).toString(), RString.class);
                    method.invoke(source, 事業者名.substring(事業者名上段長さ));
                }
                method = CLS.getMethod(JIGYOSHOCD1.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, サービス提供票別表.get事業者コード().getColumnValue());
                RString サービス = サービス提供票別表.getサービス();
                if (RString.isNullOrEmpty(サービス) || サービス.length() <= サービス上段長さ) {
                    method = CLS.getMethod(SNAME11.concat(new RString(i)).toString(), RString.class);
                    method.invoke(source, サービス);
                    method = CLS.getMethod(SNAME12.concat(new RString(i)).toString(), RString.class);
                    method.invoke(source, RString.EMPTY);
                }
                if (サービス.length() > サービス上段長さ) {
                    method = CLS.getMethod(SNAME11.concat(new RString(i)).toString(), RString.class);
                    method.invoke(source, サービス.substring(0, サービス上段長さ));
                    method = CLS.getMethod(SNAME12.concat(new RString(i)).toString(), RString.class);
                    method.invoke(source, サービス.substring(サービス上段長さ));
                }
                method = CLS.getMethod(SCODE1.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, サービス提供票別表.getサービス種類コード().getColumnValue().
                        concat(サービス提供票別表.getサービス項目コード().getColumnValue()));
                method = CLS.getMethod(TEN1.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, get金額のカンマ編集(サービス提供票別表.get単位()));
                method = CLS.getMethod(WARIRITSU1.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, get金額のカンマ編集(サービス提供票別表.get割引適用後率().getColumnValue()));
                method = CLS.getMethod(WARITEN1.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, get金額のカンマ編集(サービス提供票別表.get割引適用後単位()));
                method = CLS.getMethod(KAI1.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, get金額のカンマ編集(サービス提供票別表.get回数()));
                method = CLS.getMethod(STENSU1.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, get金額のカンマ編集(サービス提供票別表.getサービス単位()));
                method = CLS.getMethod(SOVER1.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, get金額のカンマ編集(サービス提供票別表.get種類限度超過単位()));
                method = CLS.getMethod(SIN1.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, get金額のカンマ編集(サービス提供票別表.get種類限度内単位()));
                method = CLS.getMethod(KOVER1.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, get金額のカンマ編集(サービス提供票別表.get区分限度超過単位()));
                method = CLS.getMethod(KIN1.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, get金額のカンマ編集(サービス提供票別表.get区分限度内単位()));
                method = CLS.getMethod(TANKA1.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, get金額のカンマ編集小数点後２桁(サービス提供票別表.get単位数単価()));
                method = CLS.getMethod(HIYOU1.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, get金額のカンマ編集(サービス提供票別表.get費用総額()));
                method = CLS.getMethod(RITU1.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, get金額のカンマ編集(サービス提供票別表.get給付率().getColumnValue()));
                method = CLS.getMethod(KYUFU1.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, get金額のカンマ編集(サービス提供票別表.get保険給付額()));
                method = CLS.getMethod(HOKEN1.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, get金額のカンマ編集(サービス提供票別表.get保険対象利用者負担額()));
                method = CLS.getMethod(ZENGAKU1.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, get金額のカンマ編集(サービス提供票別表.get保険対象利用者負担額()));
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(ServiceRiyohyoBeppyoSource.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void setサービス提供票総計(ServiceRiyohyoBeppyoSource source) {
        if (this.合計情報 == null || !isサービス提供票最後ページ出力) {
            return;
        }
        source.gokeiTen = get金額のカンマ編集(this.合計情報.get単位());
        source.gokeiStensu = get金額のカンマ編集(this.合計情報.getサービス単位());
        source.gokeiSover = get金額のカンマ編集(this.合計情報.get種類限度超過単位());
        source.gokeiSin = get金額のカンマ編集(this.合計情報.get種類限度内単位());
        source.gokeiKover = get金額のカンマ編集(this.合計情報.get区分限度超過単位());
        source.gokeiKin = get金額のカンマ編集(this.合計情報.get区分限度内単位());
        source.gokeiHiyou = get金額のカンマ編集(this.合計情報.get費用総額());
        source.gokeiKyufu = get金額のカンマ編集(this.合計情報.get保険給付額());
        source.gokeiHoken = get金額のカンマ編集(this.合計情報.get保険対象利用者負担額());
        source.gokeiZengaku = get金額のカンマ編集(this.合計情報.get全額利用者負担額());
    }

    private void set種類別支給限度管理(ServiceRiyohyoBeppyoSource source) {
        if (種類別支給限度情報リスト.isEmpty() || !is種類別支給限度管理出力) {
            return;
        }
        Method method;
        for (int i = 1; i <= 種類別支給限度情報リスト.size(); i++) {
            try {
                ServiceTypeTotal 種類別支給限度情報 = 種類別支給限度情報リスト.get(i - 1);
                method = CLS.getMethod(SGNAME.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, 種類別支給限度情報.getサービス種類());
                method = CLS.getMethod(SGSIN.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, get金額のカンマ編集(種類別支給限度情報.get限度額()));
                method = CLS.getMethod(SGTEN.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, get金額のカンマ編集(種類別支給限度情報.get合計単位数()));
                method = CLS.getMethod(SGSOVER.concat(new RString(i)).toString(), RString.class);
                method.invoke(source, get金額のカンマ編集(種類別支給限度情報.get限度超過単位数()));
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(ServiceRiyohyoBeppyoSource.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void set種類超過単位数合計(ServiceRiyohyoBeppyoSource source) {
        if (is種類別支給限度管理最後ページ出力) {
            source.gokeiSgten = get金額のカンマ編集(this.種類超過単位数合計);
        }
    }

    private void set短期入所利用日数(ServiceRiyohyoBeppyoSource source) {
        if (is短期入所利用日数出力) {
            source.zengetsu = get前月までの利用日数();
            source.tougetsu = get当月の計画利用日数();
            source.ruiseki = get累積利用日数();
        }
    }

    private RString get前月までの利用日数() {
        if (this.短期入所情報 == null || this.短期入所情報.isEmpty()) {
            return RString.EMPTY;
        }
        Decimal 前回迄利用日数 = Decimal.ZERO;
        for (TankiRiyoNissuResult tankiRiyoNissuResult : 短期入所情報) {
            前回迄利用日数 = 前回迄利用日数.add(tankiRiyoNissuResult.get前回迄利用日数());
        }
        return new RString(前回迄利用日数.toString());
    }

    private RString get当月の計画利用日数() {
        if (this.短期入所情報 == null || this.短期入所情報.isEmpty()) {
            return RString.EMPTY;
        }
        Decimal 今回計画利用日数 = Decimal.ZERO;
        for (TankiRiyoNissuResult tankiRiyoNissuResult : 短期入所情報) {
            今回計画利用日数 = 今回計画利用日数.add(tankiRiyoNissuResult.get今回計画利用日数());
        }
        return new RString(今回計画利用日数.toString());
    }

    private RString get累積利用日数() {
        if (this.短期入所情報 == null || this.短期入所情報.isEmpty()) {
            return RString.EMPTY;
        }
        Decimal 累積利用日数 = Decimal.ZERO;
        for (TankiRiyoNissuResult tankiRiyoNissuResult : 短期入所情報) {
            累積利用日数 = 累積利用日数.add(tankiRiyoNissuResult.get前回迄利用日数())
                    .add(tankiRiyoNissuResult.get今回計画利用日数());
        }
        return new RString(累積利用日数.toString());
    }

    private RString get金額のカンマ編集(Decimal 金額) {
        return DecimalFormatter.toRString(金額, INT_0);
    }

    private RString get金額のカンマ編集小数点後２桁(Decimal 金額) {
        return DecimalFormatter.toRString(金額, INT_2);
    }
}
