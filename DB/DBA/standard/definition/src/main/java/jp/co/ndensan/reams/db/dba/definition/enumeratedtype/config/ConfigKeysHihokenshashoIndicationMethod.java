/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.enumeratedtype.config;

/**
 * 被保険者表示方法に関連する業務コンフィグです。
 *
 * @author n8178 城間篤人
 */
public enum ConfigKeysHihokenshashoIndicationMethod {

    /**
     * 氏名カナ表示有無を示すコンフィグです。
     */
    被保険者証表示方法_氏名カナ表示有無,
    /**
     * 被保険者証の表示タイプ（A4、B4)を示すコンフィグです。
     */
    被保険者証表示方法_証表示タイプ,
    /**
     * 被保険者番号の表示形式を示すコンフィグです。
     */
    被保険者証表示方法_被保険者番号表示書式,
    /**
     * 郵便番号の表示有無を示すコンフィグです。
     */
    被保険者証表示方法_郵便番号表示有無,
    /**
     * 認定期限切れに関する情報の表示有無を示すコンフィグです。
     */
    被保険者証表示方法_要介護認定期限切れ_表示有無,
    /**
     * 居宅支援事業者適用切れについて示すコンフィグです。
     */
    被保険者証表示方法_居宅支援事業者適用切れ_表示有無,
    /**
     * 居宅支援事業者履歴の表示方法について示すコンフィグです。
     */
    被保険者証表示方法_居宅支援事業者履歴_表示方法,
    /**
     * 合併前の被保険者証を印刷する際の、有効期限の表示方法について示すコンフィグです。
     */
    被保険者証表示方法_合併前印刷時_有効期限,
    /**
     * 委託代行業者の表示有無を示すコンフィグです。
     */
    被保険者証表示方法_委託代行業者_表示有無,
    /**
     * 委託代行事業者を印字する際の、表示開始文言を示すコンフィグです。
     */
    被保険者証表示方法_委託代行業者_表示開始文言,
    /**
     * 委託代行事業者を印字する際の、表示終了文言を示すコンフィグです。
     */
    被保険者証表示方法_委託代行業者_表示終了文言,
    /**
     * 居宅支援事業者届出日と適用開始日のうち、どちらを印字するかを示すコンフィグです。
     */
    被保険者証表示方法_居宅支援事業者届出日_適用開始日切替表示区分;

}
