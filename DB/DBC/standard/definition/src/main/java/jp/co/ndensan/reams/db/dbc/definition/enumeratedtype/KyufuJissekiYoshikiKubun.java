/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

/**
 * 給付実績の様式区分を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum KyufuJissekiYoshikiKubun {

    /**
     * 様式区分が「不明」であることを表します。 <br />
     */
    不明(true, true, true, true, true, true, true, true, true, true, true, true, true, true),
    /**
     * 様式区分が「様式第二」であることを表します。 <br />
     */
    様式第二(true, true, false, false, false, false, false, false, false, false, true, false, true, false),
    /**
     * 様式区分が「様式第三」であることを表します。 <br />
     */
    様式第三(true, true, false, false, false, false, false, false, false, false, true, true, true, false),
    /**
     * 様式区分が「様式第四」であることを表します。 <br />
     */
    様式第四(true, true, true, false, true, false, false, false, false, false, true, true, false, false),
    /**
     * 様式区分が「様式第五」であることを表します。 <br />
     */
    様式第五(true, true, false, false, true, false, false, false, false, false, true, true, false, false),
    /**
     * 様式区分が「様式第六」であることを表します。 <br />
     */
    様式第六(true, true, false, false, false, false, false, false, false, false, true, false, false, false),
    /**
     * 様式区分が「様式第七」であることを表します。 <br />
     */
    様式第七(true, false, false, false, false, false, true, false, false, false, false, false, false, false),
    /**
     * 様式区分が「様式第八」であることを表します。 <br />
     */
    様式第八(true, true, false, false, false, true, false, false, false, false, true, true, true, false),
    /**
     * 様式区分が「様式第九」であることを表します。 <br />
     */
    様式第九(true, true, true, true, true, true, false, false, false, false, true, true, false, false),
    /**
     * 様式区分が「様式第十」であることを表します。 <br />
     */
    様式第十(true, true, false, false, true, true, false, false, false, false, true, true, false, false),
    /**
     * 様式区分が「様式第十三」であることを表します。 <br />
     */
    様式第十三(true, false, false, false, false, false, false, true, false, false, true, false, false, false),
    /**
     * 様式区分が「様式第十四」であることを表します。 <br />
     */
    様式第十四(true, false, false, false, false, false, false, false, true, false, true, false, false, false),
    /**
     * 様式区分が「様式第十五」であることを表します。 <br />
     */
    様式第十五(false, false, false, false, false, false, false, false, false, true, false, false, false, false),
    /**
     * 様式区分が「様式(預)」であることを表します。 <br />
     */
    様式_預(true, true, false, false, false, false, false, false, false, false, true, false, false, false),
    /**
     * 様式区分が「様式(ケ)」であることを表します。 <br />
     */
    様式_ケ(true, false, false, false, false, false, false, false, false, false, false, false, false, true);

    private final boolean 基本;
    private final boolean 明細;
    private final boolean 緊急時施設療養;
    private final boolean 所定疾患施設療養費;
    private final boolean 特定診療費_特別療養費;
    private final boolean 食事費用;
    private final boolean 居宅サービス計画費;
    private final boolean 福祉用具販売費;
    private final boolean 住宅改修費;
    private final boolean 高額介護サービス費;
    private final boolean 集計;
    private final boolean 特定入所者介護サービス費用;
    private final boolean 社会福祉法人軽減額;
    private final boolean ケアマネジメント費;

    private KyufuJissekiYoshikiKubun(
            boolean 基本, boolean 明細, boolean 緊急時施設療養, boolean 所定疾患施設療養費, boolean 特定診療費_特別療養費,
            boolean 食事費用, boolean 居宅サービス計画費, boolean 福祉用具販売費, boolean 住宅改修費, boolean 高額介護サービス費,
            boolean 集計, boolean 特定入所者介護サービス費用, boolean 社会福祉法人軽減額, boolean ケアマネジメント費) {

        this.基本 = 基本;
        this.明細 = 明細;
        this.緊急時施設療養 = 緊急時施設療養;
        this.所定疾患施設療養費 = 所定疾患施設療養費;
        this.特定診療費_特別療養費 = 特定診療費_特別療養費;
        this.食事費用 = 食事費用;
        this.居宅サービス計画費 = 居宅サービス計画費;
        this.福祉用具販売費 = 福祉用具販売費;
        this.住宅改修費 = 住宅改修費;
        this.高額介護サービス費 = 高額介護サービス費;
        this.集計 = 集計;
        this.特定入所者介護サービス費用 = 特定入所者介護サービス費用;
        this.社会福祉法人軽減額 = 社会福祉法人軽減額;
        this.ケアマネジメント費 = ケアマネジメント費;
    }

    /**
     * 基本レコードが対象かどうか判定する。
     *
     * @return 対象の場合はtrueを返す
     */
    public boolean is基本() {
        return 基本;
    }

    /**
     * 明細レコードが対象かどうか判定する。
     *
     * @return 対象の場合はtrueを返す
     */
    public boolean is明細() {
        return 明細;
    }

    /**
     * 緊急時施設療養レコードが対象かどうか判定する。
     *
     * @return 対象の場合はtrueを返す
     */
    public boolean is緊急時施設療養() {
        return 緊急時施設療養;
    }

    /**
     * 所定疾患施設療養費レコードが対象かどうか判定する。
     *
     * @return 対象の場合はtrueを返す
     */
    public boolean is所定疾患施設療養費() {
        return 所定疾患施設療養費;
    }

    /**
     * 特定診療費・特別療養費レコードが対象かどうか判定する。
     *
     * @return 対象の場合はtrueを返す
     */
    public boolean is特定診療費_特別療養費() {
        return 特定診療費_特別療養費;
    }

    /**
     * 食事費用レコードが対象かどうか判定する。
     *
     * @return 対象の場合はtrueを返す
     */
    public boolean is食事費用() {
        return 食事費用;
    }

    /**
     * 居宅サービス計画費レコードが対象かどうか判定する。
     *
     * @return 対象の場合はtrueを返す
     */
    public boolean is居宅サービス計画費() {
        return 居宅サービス計画費;
    }

    /**
     * 福祉用具販売費レコードが対象かどうか判定する。
     *
     * @return 対象の場合はtrueを返す
     */
    public boolean is福祉用具販売費() {
        return 福祉用具販売費;
    }

    /**
     * 住宅改修費レコードが対象かどうか判定する。
     *
     * @return 対象の場合はtrueを返す
     */
    public boolean is住宅改修費() {
        return 住宅改修費;
    }

    /**
     * 高額介護サービス費レコードが対象かどうか判定する。
     *
     * @return 対象の場合はtrueを返す
     */
    public boolean is高額介護サービス費() {
        return 高額介護サービス費;
    }

    /**
     * 集計レコードが対象かどうか判定する。
     *
     * @return 対象の場合はtrueを返す
     */
    public boolean is集計() {
        return 集計;
    }

    /**
     * 特定入所者介護サービス費用レコードが対象かどうか判定する。
     *
     * @return 対象の場合はtrueを返す
     */
    public boolean is特定入所者介護サービス費用() {
        return 特定入所者介護サービス費用;
    }

    /**
     * 社会福祉法人軽減額レコードが対象かどうか判定する。
     *
     * @return 対象の場合はtrueを返す
     */
    public boolean is社会福祉法人軽減額() {
        return 社会福祉法人軽減額;
    }

    /**
     * ケアマネジメント費レコードが対象かどうか判定する。
     *
     * @return 対象の場合はtrueを返す
     */
    public boolean isケアマネジメント費() {
        return ケアマネジメント費;
    }
}
