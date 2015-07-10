/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.shikaku;

/**
 * 被保険者証の送付先情報を印字する際に参照される業務コンフィグです。
 *
 * @author n8178 城間篤人
 */
public enum ConfigKeysHihokenshashoSofusakiInfo {

    /**
     * 送付先情報に世帯主の情報を表示するか否かを示すコンフィグです。
     */
    被保険者証_送付先情報_世帯主表示有無,
    /**
     * 送付先情報の氏名欄に、敬称として様を表示するか否かを示すコンフィグです。
     */
    被保険者証_送付先情報_敬称表示方法,
    /**
     * 被保険者証を印刷する際、文字切れしている情報についてどのように処理するかを判定するコンフィグです。
     */
    被保険者証_外部帳票文字切れ制御方法;

}
