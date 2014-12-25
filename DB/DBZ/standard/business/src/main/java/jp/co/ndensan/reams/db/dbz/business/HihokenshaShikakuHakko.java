/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.business.config.HihokenshashoItakudaikoHyojiConfig;
import jp.co.ndensan.reams.db.dbz.business.config.ShikakushashoItakudaikoHyojiConfig;
import jp.co.ndensan.reams.db.dbz.business.config.ShikakushashoKigenConfig;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.ItemList;
import jp.co.ndensan.reams.ur.urz.business.IKaigoServiceShurui;
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

    private static final RString SHIKAKUSHAHO_YUKOKIGEN_1 = new RString("1");
    private static final RString SHIKAKUSHAHO_YUKOKIGEN_2 = new RString("2");
    private static final RString SHIKAKUSHAHO_YUKOKIGEN_3 = new RString("3");

    // 申請区分(申請時)コード。
    // 将来的にenum(dbe:認定)に作成される予定なので、それを使用する。
    private static final RString SHINSEIKUBUN_SHINKI = new RString("1");
    private static final RString SHINSEIKUBUN_KOSHIN = new RString("2");
    private static final RString SHINSEIKUBUN_KUBUNHENKO = new RString("3");
    private static final RString SHINSEIKUBUN_SHOKKEN = new RString("4");
    private static final RString SHINSEIKUBUN_TENNYU = new RString("5");
    private static final RString SHINSEIKUBUN_SHOSHITSU = new RString("6");

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
    public static FlexibleDate get有効期限初期値(RString 申請区分コード, FlexibleDate 申請日, FlexibleDate 有効データ認定終了日) {
        FlexibleDate 有効期限;

        ShikakushashoKigenConfig config = new ShikakushashoKigenConfig();
        Decimal 有効期限加算値 = new Decimal(config.get資格者証期限_有効期限加算値().toString());
        if (config.get資格者証期限_有効期限初期表示().equals(SHIKAKUSHAHO_YUKOKIGEN_1)) {
            有効期限 = FlexibleDate.getNowDate().plusDay(有効期限加算値.intValue());
        } else {
            if (config.get資格者証期限_有効期限初期表示().equals(SHIKAKUSHAHO_YUKOKIGEN_2)
                    && (申請区分コード.equals(SHINSEIKUBUN_KOSHIN))
                    && 申請日.plusDay(有効期限加算値.intValue()).isBefore(有効データ認定終了日)) {
                有効期限 = 有効データ認定終了日;
            } else if (config.get資格者証期限_有効期限初期表示().equals(SHIKAKUSHAHO_YUKOKIGEN_3)
                    && (申請区分コード.equals(SHINSEIKUBUN_KOSHIN) || 申請区分コード.equals(SHINSEIKUBUN_KUBUNHENKO))
                    && 申請日.plusDay(有効期限加算値.intValue()).isBefore(有効データ認定終了日)) {
                有効期限 = 有効データ認定終了日;
            } else {
                有効期限 = 申請日.plusDay(有効期限加算値.intValue());
            }
        }

        // 1 業務コンフィグ(DBD：資格者証期限_有効期限初期表示)を取得する。
        // 2 業務コンフィグ(DBD：資格者証期限_有効期限加算値)を取得する。
        // 3 1-1の業務コンフィグによって分岐する。
        //    3-1 1-1の業務コンフィグが1(常にシステム日付 + 有効期限加算値)の場合、
        //        初期値＝システム日付＋資格者証期限_有効期限加算値
        //    3-2 1-1の業務コンフィグが1ではない場合
        //      ① 1-1の業務コンフィグが2(更新申請時、従前認定終値比較)の場合で、
        //        申請区分コード == 2(更新申請) &&
        //        有効データ認定終了日 > 申請日 + 資格者証期限_有効期限加算値 の場合 初期値＝有効データ認定終了日。
        //      ② 1-1の業務コンフィグが3(更新申請時、従前認定終値比較)の場合で、
        //        申請区分コード == (2(更新申請) または 3(区分申請)) &&
        //        有効データ認定終了日 > 申請日 + 資格者証期限_有効期限加算値 の場合 初期値＝有効データ認定終了日。
        //      ①・②のどちらにも当てはまらない場合 初期値＝申請日＋資格者証期限_有効期限加算値。
        return 有効期限;
    }

    /**
     * 被保険者証の支援事業者名称を取得します。
     *
     * @param 計画事業者番号 計画事業者番号
     * @param 委託先事業者番号 委託先事業者番号
     * @return 被保険者証支援事業者
     */
    public RString get被保険者証支援事業者名称(JigyoshaNo 計画事業者番号, JigyoshaNo 委託先事業者番号) {

        RString 事業者名称;
        // TODO 計画事業者名称を、URのIKaigoJigyoshaDaichoManager(未実装)のgetJigyoshaCurrent(引数＝計画事業者番号)を使用して取得する。
        RString 計画事業者名称 = RString.EMPTY;
        RString 委託先事業者名称;

        事業者名称 = 計画事業者名称;

        HihokenshashoItakudaikoHyojiConfig config = new HihokenshashoItakudaikoHyojiConfig();
        if (config.get被保険者証表示方法_委託代行業者_表示有無().equals(new RString("1"))) {
//        業務コンフィグ(DBA：被保険者証表示方法_委託代行業者_表示有無)が1(表示)の場合、
//        計画事業者番号の後ろに、居宅給付計画事業者作成.委託先事業者番号を元に取得した事業者名称を表示する。
//        その際、業務コンフィグに、委託先事業者名称に付与する文言が設定されているので、
//        それを付与して表示する(DBA：被保険者証表示方法_委託代行業者_表示開始文言、被保険者証表示方法_委託代行業者_表示終了文言)。
            // TODO 委託先事業者名称を、URのIKaigoJigyoshaDaichoManager(未実装)のgetJigyoshaCurrent(引数＝委託先事業者番号)を使用して取得する。
            委託先事業者名称 = RString.EMPTY;
            事業者名称 = new RStringBuilder(計画事業者名称)
                    .append(config.get被保険者証表示方法_委託代行業者_表示開始文言())
                    .append(委託先事業者名称)
                    .append(config.get被保険者証表示方法_委託代行業者_表示終了文言())
                    .toRString();
        }
        return 事業者名称;
    }

    /**
     * 資格者証の支援事業者名称を取得します。
     *
     * @param 計画事業者番号 計画事業者番号
     * @param 委託先事業者番号 委託先事業者番号
     * @return 資格者証支援事業者
     */
    public RString get資格者証支援事業者名称(JigyoshaNo 計画事業者番号, JigyoshaNo 委託先事業者番号) {
        RString 事業者名称;
        // TODO 計画事業者名称を、URのIKaigoJigyoshaDaichoManager(未実装)のgetJigyoshaCurrent(引数＝計画事業者番号)を使用して取得する。
        RString 計画事業者名称 = RString.EMPTY;
        RString 委託先事業者名称;

        事業者名称 = 計画事業者名称;

        ShikakushashoItakudaikoHyojiConfig config = new ShikakushashoItakudaikoHyojiConfig();
        if (config.get資格者証表示方法_委託代行業者の表示有無().equals(new RString("1"))) {
//        業務コンフィグ(DBD：資格者証表示方法_委託代行業者の表示有無)が1(表示)の場合、
//        計画事業者番号の後ろに、居宅給付計画事業者作成.委託先事業者番号を元に取得した事業者名称を表示する。
//        その際、業務コンフィグに、委託先事業者名称に付与する文言が設定されているので、
//        それを付与して表示する(DBD：資格者証表示方法_委託代行業者表示開始文言、資格者証表示方法_委託代行業者表示終了文言)。
            // TODO 委託先事業者名称を、URのIKaigoJigyoshaDaichoManager(未実装)のgetJigyoshaCurrent(引数＝委託先事業者番号)を使用して取得する。
            委託先事業者名称 = RString.EMPTY;
            事業者名称 = new RStringBuilder(計画事業者名称)
                    .append(config.get資格者証表示方法_委託代行業者表示開始文言())
                    .append(委託先事業者名称)
                    .append(config.get資格者証表示方法_委託代行業者表示終了文言())
                    .toRString();
        }
        return 事業者名称;
    }

    /**
     * 審査会意見を作成します。
     *
     * @param 審査会意見 審査会意見
     * @param 介護サービス種類リスト 介護サービス種類リスト
     * @param 基準日 基準日
     * @param 最大長 最大長
     * @return 審査会意見
     */
    public RString create審査会意見(RString 審査会意見, IItemList<RString> 介護サービス種類リスト, FlexibleDate 基準日, int 最大長) {

//    1 文言を作成する。
//    文言が最大長に入るよう調整する。
//    文言 ＝ 「介護認定審査会意見」+「介護サービス種類01~30の名称」
//    ※サービス種類の名称について 名称は、IKaigoServisManager.get介護サービス (基準日、サービス種類)を使用して取得する。
//     文言が最大長をオーバーする場合、サービス名称は略称を使用する。
        RString 編集審査会意見 = 審査会意見;
        int 編集審査会意見長 = 編集審査会意見.length();
        if (!介護サービス種類リスト.isEmpty()) {
            IItemList<IKaigoServiceShurui> 介護サービス = ItemList.empty();
            for (RString 介護サービス種類 : 介護サービス種類リスト) {
                // TODO IKaigoServisManager(未実装)を使用して、介護サービス種類リストと基準日を元にIKaigoServiceShuruiを取得。
                IKaigoServiceShurui serviceShurui = null;
                介護サービス.added(serviceShurui);
            }
            int 介護サービス長 = 0;
            for (IKaigoServiceShurui kaigoServiceShurui : 介護サービス) {
                介護サービス長 = 介護サービス長 + kaigoServiceShurui.getサービス種類名称().length() + (new RString(",").length());
            }
            if ((編集審査会意見長 + 介護サービス長) > 最大長) {
                for (IKaigoServiceShurui kaigoServiceShurui : 介護サービス) {
                    編集審査会意見 = new RStringBuilder(編集審査会意見)
                            .append(kaigoServiceShurui.getサービス種類名称略称())
                            .append(new RString(","))
                            .toRString();
                }
            } else {
                for (IKaigoServiceShurui kaigoServiceShurui : 介護サービス) {
                    編集審査会意見 = new RStringBuilder(編集審査会意見)
                            .append(kaigoServiceShurui.getサービス種類名称())
                            .append(new RString(","))
                            .toRString();
                }
            }
        }
        if (編集審査会意見長 >= 最大長) {
            編集審査会意見 = 編集審査会意見.substring(0, 最大長);
        }
        return 編集審査会意見;
    }
}
