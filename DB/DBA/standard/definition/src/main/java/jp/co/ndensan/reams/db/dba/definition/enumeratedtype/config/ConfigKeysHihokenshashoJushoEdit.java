/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.enumeratedtype.config;

/**
 * 被保険者表示方法に定義されている中の、被保険者証独自の住所編集方法に関連する業務コンフィグです。
 *
 * @author n8178 城間篤人
 */
public enum ConfigKeysHihokenshashoJushoEdit {

    /**
     * 住所編集の際、介護業務全体の編集方法と独自の編集方法のどちらを使用するかについての情報を持つ業務コンフィグです。
     */
    被保険者証表示方法_管内住所編集_帳票独自区分,
    /**
     * 都道府県名付与有無についての情報を持つ業務コンフィグです。
     */
    被保険者証表示方法_管内住所編集_都道府県名付与有無,
    /**
     * 群名付与有無についての情報を持つ業務コンフィグです。
     */
    被保険者証表示方法_管内住所編集_郡名付与有無,
    /**
     * 市町村名付与有無についての情報を持つ業務コンフィグです。
     */
    被保険者証表示方法_管内住所編集_市町村名付与有無,
    /**
     * 住所の編集方法についての情報を持つ業務コンフィグです。
     */
    被保険者証表示方法_管内住所編集_編集方法,
    /**
     * 方書表示有無についての情報を持つ業務コンフィグです。
     */
    被保険者証表示方法_住所編集_方書表示有無;

}
