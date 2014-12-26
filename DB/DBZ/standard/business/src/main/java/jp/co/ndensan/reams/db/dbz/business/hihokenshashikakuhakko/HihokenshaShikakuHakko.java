/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hihokenshashikakuhakko;

import jp.co.ndensan.reams.db.dbz.business.config.HihokenshashoItakudaikoHyojiConfig;
import jp.co.ndensan.reams.db.dbz.business.config.ShikakushashoItakudaikoHyojiConfig;
import jp.co.ndensan.reams.db.dbz.business.config.ShikakushashoKigenConfig;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.ur.urz.business.IKaigoService;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 被保険者証発行、資格者証発行で使用するロジックをまとめたクラスです。
 *
 * @author N8187 久保田 英男
 */
public final class HihokenshaShikakuHakko {

    private static final RString GYOMUCONFIG_1 = new RString("1");
    private static final RString GYOMUCONFIG_2 = new RString("2");
    private static final RString GYOMUCONFIG_3 = new RString("3");
    // TODO N8187 久保田 申請区分(申請時)コード。将来的にenum取得のビジネスクラスが(dbe:認定)に作成される予定なので、それを使用する。
    private static final Code SHINSEIKUBUN_KOSHIN = new Code(new RString("2"));
    private static final Code SHINSEIKUBUN_KUBUNHENKO = new Code(new RString("3"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private HihokenshaShikakuHakko() {
    }

    /**
     * 有効期限の初期値を取得します。
     *
     * @param 申請区分コード 申請区分コード
     * @param 申請日 申請日
     * @param 有効データ認定終了日 有効データ認定終了日
     * @return 有効期限の初期値
     */
    public static FlexibleDate get有効期限初期値(Code 申請区分コード, FlexibleDate 申請日, FlexibleDate 有効データ認定終了日) {

        FlexibleDate 有効期限;
        ShikakushashoKigenConfig config = new ShikakushashoKigenConfig();
        Decimal 有効期限加算値 = new Decimal(config.get資格者証期限_有効期限加算値().toString());
        if (config.get資格者証期限_有効期限初期表示().equals(GYOMUCONFIG_1)) {
            有効期限 = FlexibleDate.getNowDate().plusDay(有効期限加算値.intValue());
        } else {
            if (config.get資格者証期限_有効期限初期表示().equals(GYOMUCONFIG_2)
                    && 申請区分コード.equals(SHINSEIKUBUN_KOSHIN)
                    && 申請日.plusDay(有効期限加算値.intValue()).isBefore(有効データ認定終了日)) {
                有効期限 = 有効データ認定終了日;
            } else if (config.get資格者証期限_有効期限初期表示().equals(GYOMUCONFIG_3)
                    && (申請区分コード.equals(SHINSEIKUBUN_KOSHIN) || 申請区分コード.equals(SHINSEIKUBUN_KUBUNHENKO))
                    && 申請日.plusDay(有効期限加算値.intValue()).isBefore(有効データ認定終了日)) {
                有効期限 = 有効データ認定終了日;
            } else {
                有効期限 = 申請日.plusDay(有効期限加算値.intValue());
            }
        }

        return 有効期限;
    }

    /**
     * 被保険者証の支援事業者名称を返します。<br />
     * 業務コンフィグの設定を元に編集した名称を返します。
     *
     * @param 計画事業者名称 計画事業者名称
     * @param 委託先事業者名称 委託先事業者名称
     * @return 支援事業者名称
     */
    public static RString get被保険者証支援事業者名称(RString 計画事業者名称, RString 委託先事業者名称) {

        RString 支援事業者名称;

        HihokenshashoItakudaikoHyojiConfig config = new HihokenshashoItakudaikoHyojiConfig();
        if (config.get被保険者証表示方法_委託代行業者_表示有無().equals(GYOMUCONFIG_1)) {
            RString 表示開始文言 = config.get被保険者証表示方法_委託代行業者_表示開始文言();
            RString 表示終了文言 = config.get被保険者証表示方法_委託代行業者_表示終了文言();
            支援事業者名称 = new RStringBuilder(計画事業者名称).append(表示開始文言).append(委託先事業者名称).append(表示終了文言).toRString();
        } else {
            支援事業者名称 = 計画事業者名称;
        }

        return 支援事業者名称;
    }

    /**
     * 資格者証の支援事業者名称を返します。<br />
     * 業務コンフィグの設定を元に編集した名称を返します。
     *
     * @param 計画事業者名称 計画事業者名称
     * @param 委託先事業者名称 委託先事業者名称
     * @return 支援事業者名称
     */
    public static RString get資格者証支援事業者名称(RString 計画事業者名称, RString 委託先事業者名称) {

        RString 支援事業者名称;

        ShikakushashoItakudaikoHyojiConfig config = new ShikakushashoItakudaikoHyojiConfig();
        if (config.get資格者証表示方法_委託代行業者の表示有無().equals(GYOMUCONFIG_1)) {
            RString 表示開始文言 = config.get資格者証表示方法_委託代行業者表示開始文言();
            RString 表示終了文言 = config.get資格者証表示方法_委託代行業者表示終了文言();
            支援事業者名称 = new RStringBuilder(計画事業者名称).append(表示開始文言).append(委託先事業者名称).append(表示終了文言).toRString();
        } else {
            支援事業者名称 = 計画事業者名称;
        }

        return 支援事業者名称;
    }

    /**
     * 審査会意見を作成します。<br />
     * 審査会意見が最大長に入るよう調整します。<br />
     * 引数の審査会意見＋「介護サービス種類01~30の名称」が最大長を超える場合、介護サービスは略称を使用します。<br />
     * 略称を使用しても最大長を超えた場合は、最大長までの文言を返します。
     *
     * @param 審査会意見 審査会意見
     * @param 介護サービスリスト 介護サービスリスト(サービス種類の名称と略称を持つ型に変更する)。
     * @param 基準日 基準日
     * @param 最大長 最大長
     * @return 審査会意見
     */
    public static RString compose審査会意見(RString 審査会意見, IItemList<IKaigoService> 介護サービスリスト, FlexibleDate 基準日, int 最大長) {

        RString 編集審査会意見 = 審査会意見;
        int 編集審査会意見長 = 編集審査会意見.length();
        if (!介護サービスリスト.isEmpty()) {
            int 介護サービス長 = 0;
            for (IKaigoService kaigoService : 介護サービスリスト) {
                if (kaigoService != null) {
                    介護サービス長 = 介護サービス長 + kaigoService.get介護サービス種類().getサービス種類名称().length();
                }
            }
            if (最大長 < (編集審査会意見長 + 介護サービス長)) {
                for (IKaigoService kaigoService : 介護サービスリスト) {
                    編集審査会意見 = new RStringBuilder(編集審査会意見)
                            .append(kaigoService.get介護サービス種類().getサービス種類名称略称())
                            .toRString();
                }
            } else {
                for (IKaigoService kaigoService : 介護サービスリスト) {
                    編集審査会意見 = new RStringBuilder(編集審査会意見)
                            .append(kaigoService.get介護サービス種類().getサービス種類名称())
                            .toRString();
                }
            }
        }
        if (最大長 <= 編集審査会意見.length()) {
            編集審査会意見 = 編集審査会意見.substring(0, 最大長);
        }
        return 編集審査会意見;
    }
}
