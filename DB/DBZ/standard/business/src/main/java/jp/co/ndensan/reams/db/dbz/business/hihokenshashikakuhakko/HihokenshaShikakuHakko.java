/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hihokenshashikakuhakko;

import jp.co.ndensan.reams.db.dbz.business.config.HihokenshashoItakudaikoHyojiConfig;
import jp.co.ndensan.reams.db.dbz.business.config.jukyu.ShikakushashoItakudaikoHyojiConfig;
import jp.co.ndensan.reams.db.dbz.business.config.jukyu.ShikakushashoKigenConfig;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.HihokenshashoItakudaikoHyoji;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.ShikakushashoItakudaikoHyoji;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.YukoKigenShokiHyoji;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbx.business.IKaigoService;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 被保険者証発行、資格者証発行で使用するロジックをまとめたクラスです。
 *
 * @author N8187 久保田 英男
 */
public class HihokenshaShikakuHakko {

    // TODO N8187 久保田 申請区分(申請時)コード。将来的にenum取得のビジネスクラスが(dbe:認定)に作成される予定なので、それを使用する。
    private static final Code SHINSEIKUBUN_KOSHIN = new Code(new RString("2"));
    private static final Code SHINSEIKUBUN_KUBUNHENKO = new Code(new RString("3"));

    private final ShikakushashoKigenConfig 資格者証期限config;
    private final HihokenshashoItakudaikoHyojiConfig 被保険者証委託代行業者config;
    private final ShikakushashoItakudaikoHyojiConfig 資格者証委託代行業者config;

    /**
     * コンストラクタです。
     */
    public HihokenshaShikakuHakko() {
        資格者証期限config = new ShikakushashoKigenConfig();
        被保険者証委託代行業者config = new HihokenshashoItakudaikoHyojiConfig();
        資格者証委託代行業者config = new ShikakushashoItakudaikoHyojiConfig();
    }

    /**
     * テスト用のコンストラクタです。
     *
     * @param 資格者証期限config ShikakushashoKigenConfig
     * @param 被保険者証委託代行業者Config HihokenshashoItakudaikoHyojiConfig
     * @param 資格者証委託代行業者config ShikakushashoItakudaikoHyojiConfig
     *
     */
    HihokenshaShikakuHakko(ShikakushashoKigenConfig 資格者証期限config,
            HihokenshashoItakudaikoHyojiConfig 被保険者証委託代行業者Config,
            ShikakushashoItakudaikoHyojiConfig 資格者証委託代行業者config) {
        this.資格者証期限config = 資格者証期限config;
        this.被保険者証委託代行業者config = 被保険者証委託代行業者Config;
        this.資格者証委託代行業者config = 資格者証委託代行業者config;
    }

    /**
     * 有効期限の初期値を取得します。
     *
     * @param 申請区分コード 申請区分コード
     * @param 申請日 申請日
     * @param 有効データ認定終了日 有効データ認定終了日
     * @return 有効期限の初期値
     */
    public FlexibleDate get有効期限初期値(Code 申請区分コード, FlexibleDate 申請日, FlexibleDate 有効データ認定終了日) {

        FlexibleDate 有効期限;
        int 有効期限加算値 = 資格者証期限config.get資格者証期限_有効期限加算値();
        if (資格者証期限config.get資格者証期限_有効期限初期表示() == YukoKigenShokiHyoji.システム日付plus有効期限加算値) {
            有効期限 = FlexibleDate.getNowDate().plusDay(有効期限加算値);
        } else {
            if (資格者証期限config.get資格者証期限_有効期限初期表示() == YukoKigenShokiHyoji.更新申請時_従前認定終値比較
                    && 申請区分コード.equals(SHINSEIKUBUN_KOSHIN)
                    && 申請日.plusDay(有効期限加算値).isBefore(有効データ認定終了日)) {
                有効期限 = 有効データ認定終了日;
            } else if (資格者証期限config.get資格者証期限_有効期限初期表示() == YukoKigenShokiHyoji.更新区分申請時_従前認定終値比較
                    && (申請区分コード.equals(SHINSEIKUBUN_KOSHIN) || 申請区分コード.equals(SHINSEIKUBUN_KUBUNHENKO))
                    && 申請日.plusDay(有効期限加算値).isBefore(有効データ認定終了日)) {
                有効期限 = 有効データ認定終了日;
            } else {
                有効期限 = 申請日.plusDay(有効期限加算値);
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
    public RString compose被保険者証支援事業者名称(RString 計画事業者名称, RString 委託先事業者名称) {

        RString 支援事業者名称;

        if (被保険者証委託代行業者config.get被保険者証表示方法_委託代行業者_表示有無() == HihokenshashoItakudaikoHyoji.表示) {
            RString 表示開始文言 = 被保険者証委託代行業者config.get被保険者証表示方法_委託代行業者_表示開始文言();
            RString 表示終了文言 = 被保険者証委託代行業者config.get被保険者証表示方法_委託代行業者_表示終了文言();
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
    public RString compose資格者証支援事業者名称(RString 計画事業者名称, RString 委託先事業者名称) {

        RString 支援事業者名称;

        if (資格者証委託代行業者config.get資格者証表示方法_委託代行業者の表示有無() == ShikakushashoItakudaikoHyoji.表示) {
            RString 表示開始文言 = 資格者証委託代行業者config.get資格者証表示方法_委託代行業者表示開始文言();
            RString 表示終了文言 = 資格者証委託代行業者config.get資格者証表示方法_委託代行業者表示終了文言();
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
     * @param 審査会意見 RString
     * @param 介護サービスリスト IItemList<IKaigoService>
     * @param 最大長 int
     * @return 審査会意見
     */
    public RString compose審査会意見(RString 審査会意見, IItemList<IKaigoService> 介護サービスリスト, int 最大長) {
        RStringBuilder 編集審査会意見 = new RStringBuilder(審査会意見);
        if (!介護サービスリスト.isEmpty()) {
            boolean hasToUse略称 = 最大長 < (審査会意見.length() + countLengthOfサービス種類名称(介護サービスリスト));
            編集審査会意見.append(composeサービス名称(介護サービスリスト, hasToUse略称));
        }
        return 最大長 <= 編集審査会意見.length() ? 編集審査会意見.substring(0, 最大長) : 編集審査会意見.toRString();
    }

    private int countLengthOfサービス種類名称(IItemList<IKaigoService> services) {
        int count = 0;
        for (IKaigoService service : services) {
            if (service != null) {
                count += service.get介護サービス種類().getサービス種類名称().length();
            }
        }
        return count;
    }

    private RString composeサービス名称(IItemList<IKaigoService> services, boolean hasToUse略称) {
        RStringBuilder サービス名称 = new RStringBuilder();
        for (IKaigoService service : services) {
            サービス名称.append(hasToUse略称
                    ? service.get介護サービス種類().getサービス種類名称略称()
                    : service.get介護サービス種類().getサービス種類名称());
        }
        return サービス名称.toRString();
    }
}
