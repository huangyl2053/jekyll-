package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績レコード種別を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum KyufuJissekiRecordShubetsu {

    /**
     * コード:H1 名称:基本情報レコード 略称:定義なし
     */
    基本情報レコード("H1", "基本情報レコード"),
    /**
     * コード:D1 名称:明細情報レコード 略称:定義なし
     */
    明細情報レコード("D1", "明細情報レコード"),
    /**
     * コード:DD 名称:明細情報_住所地特例レコード 略称:定義なし
     */
    明細情報_住所地特例レコード("DD", "明細情報_住所地特例レコード"),
    /**
     * コード:D2 名称:緊急時施設療養情報レコード 略称:定義なし
     */
    緊急時施設療養情報レコード("D2", "緊急時施設療養情報レコード"),
    /**
     * コード:DC 名称:所定疾患施設療養費等情報レコード 略称:定義なし
     */
    所定疾患施設療養費等情報レコード("DC", "所定疾患施設療養費等情報レコード"),
    /**
     * コード:D3 名称:特定診療費_特別療養費情報レコード 略称:定義なし
     */
    特定診療費_特別療養費情報レコード("D3", "特定診療費_特別療養費情報レコード"),
    /**
     * コード:D4 名称:食事費用情報レコード 略称:定義なし
     */
    食事費用情報レコード("D4", "食事費用情報レコード"),
    /**
     * コード:D5 名称:居宅サービス計画費情報レコード 略称:定義なし
     */
    居宅サービス計画費情報レコード("D5", "居宅サービス計画費情報レコード"),
    /**
     * コード:D6 名称:福祉用具販売費情報レコード 略称:定義なし
     */
    福祉用具販売費情報レコード("D6", "福祉用具販売費情報レコード"),
    /**
     * コード:D7 名称:住宅改修費情報レコード 略称:定義なし
     */
    住宅改修費情報レコード("D7", "住宅改修費情報レコード"),
    /**
     * コード:D8 名称:介護給付費_高額介護サービス費情報レコード 略称:定義なし
     */
    介護給付費_高額介護サービス費情報レコード("D8", "介護給付費_高額介護サービス費情報レコード"),
    /**
     * コード:DE 名称:総合事業費_高額介護サービス費情報レコード 略称:定義なし
     */
    総合事業費_高額介護サービス費情報レコード("DE", "総合事業費_高額介護サービス費情報レコード"),
    /**
     * コード:T1 名称:集計情報レコード 略称:定義なし
     */
    集計情報レコード("T1", "集計情報レコード"),
    /**
     * コード:D9 名称:特定入所者介護サービス費用情報レコード 略称:定義なし
     */
    特定入所者介護サービス費用情報レコード("D9", "特定入所者介護サービス費用情報レコード"),
    /**
     * コード:DA 名称:社会福祉法人軽減額情報レコード 略称:定義なし
     */
    社会福祉法人軽減額情報レコード("DA", "社会福祉法人軽減額情報レコード"),
    /**
     * コード:DB 名称:ケアマネジメント費情報レコード 略称:定義なし
     */
    ケアマネジメント費情報レコード("DB", "ケアマネジメント費情報レコード");

    private final RString code;
    private final RString fullName;

    private KyufuJissekiRecordShubetsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 給付実績レコード種別のコードを返します。
     *
     * @return 給付実績レコード種別のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 給付実績レコード種別の名称を返します。
     *
     * @return 給付実績レコード種別の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 給付実績レコード種別のコードと一致する内容を探します。
     *
     * @param code 給付実績レコード種別のコード
     * @return {@code code} に対応する給付実績レコード種別
     */
    public static KyufuJissekiRecordShubetsu toValue(RString code) {
        for (KyufuJissekiRecordShubetsu kyufuJissekiRecordShubetsu : KyufuJissekiRecordShubetsu.values()) {
            if (kyufuJissekiRecordShubetsu.code.equals(code)) {
                return kyufuJissekiRecordShubetsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("給付実績レコード種別"));
    }
}
