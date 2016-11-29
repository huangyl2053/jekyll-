/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.kakushutsuchishosakusei;

import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kakushutsuchishosakusei.KakushuTsuchishoEntityParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kakushutsuchishosakusei.ChoshuYuyoInfoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kakushutsuchishosakusei.GenmenInfoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kakushutsuchishosakusei.KakushuTsuchishoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kakushutsuchishosakusei.KakushuTsuchishoFindEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kakushutsuchishosakusei.LastYearFukaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 各種通知書作成（個別）クラスです。
 *
 * @reamsid_L DBB-0740-020 xicongwang
 */
public interface IKakushuTsuchishoSakuseiMapper {

    /**
     * 更正後賦課の情報を取得メソッドです。
     *
     * @param parameter parameter
     * @return KakushuTsuchishoEntity
     */
    KakushuTsuchishoEntity get更正前後賦課の情報(KakushuTsuchishoEntityParameter parameter);

    /**
     * 更正後賦課の情報を取得メソッドです。
     *
     * @param parameter parameter
     * @return KakushuTsuchishoEntity
     */
    KakushuTsuchishoEntity get更正前後賦課の情報With還付額(KakushuTsuchishoEntityParameter parameter);

    /**
     * 宛名、納組、納期、宛先、口座情報を取得メソッドです。
     *
     * @param parameter parameter
     * @return KakushuTsuchishoFindEntity
     */
    KakushuTsuchishoFindEntity get宛名納組宛先口座(KakushuTsuchishoEntityParameter parameter);

    /**
     * 減免の情報（更正後）の取得メソッドです。
     *
     * @param parameter parameter
     * @return KakushuTsuchishoFindEntity
     */
    GenmenInfoEntity get減免の情報更正後(KakushuTsuchishoEntityParameter parameter);

    /**
     * 減免の情報（更正後）の取得メソッドです。
     *
     * @param parameter parameter
     * @return KakushuTsuchishoFindEntity
     */
    GenmenInfoEntity get減免の情報更正後_取消(KakushuTsuchishoEntityParameter parameter);

    /**
     * 徴収猶予の情報（更正後）の取得メソッドです。
     *
     * @param parameter parameter
     * @return KakushuTsuchishoFindEntity
     */
    ChoshuYuyoInfoEntity get徴収猶予の情報更正後(KakushuTsuchishoEntityParameter parameter);

    /**
     * 徴収猶予の情報（更正後）の取得メソッドです。
     *
     * @param parameter parameter
     * @return KakushuTsuchishoFindEntity
     */
    ChoshuYuyoInfoEntity get徴収猶予の情報更正後_取消(KakushuTsuchishoEntityParameter parameter);

    /**
     * 前年度賦課の情報取得メソッドです。
     *
     * @param parameter parameter
     * @return LastYearFukaEntity
     */
    LastYearFukaEntity get前年度賦課の情報(Map<String, Object> parameter);

    /**
     * 代納人の宛名情報取得メソッドです。
     *
     * @param parameter parameter
     * @return UaFt200FindShikibetsuTaishoEntity
     */
    UaFt200FindShikibetsuTaishoEntity get代納人の宛名情報(Map<String, Object> parameter);

}
