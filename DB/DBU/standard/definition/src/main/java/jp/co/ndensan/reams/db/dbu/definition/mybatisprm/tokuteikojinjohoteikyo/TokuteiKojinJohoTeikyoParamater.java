/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo;

import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShokaiTeikyoKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定個人情報提供のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBU-4880-110 dingyi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TokuteiKojinJohoTeikyoParamater {

    private final RString 特定個人情報名コード;
    private final RString データセット番号;
    private final FlexibleDate 基準日;
    private final RString 版番号;
    private final RString 初回提供済み;
    private final RString 中間DBのテーブル名;
    private final RString 新規異動区分;

    private TokuteiKojinJohoTeikyoParamater(RString 特定個人情報名コード, RString データセット番号, FlexibleDate 基準日,
            RString 版番号, RString 初回提供済み, RString 中間DBのテーブル名, RString 新規異動区分) {
        this.特定個人情報名コード = 特定個人情報名コード;
        this.データセット番号 = データセット番号;
        this.基準日 = 基準日;
        this.版番号 = 版番号;
        this.初回提供済み = 初回提供済み;
        this.中間DBのテーブル名 = 中間DBのテーブル名;
        this.新規異動区分 = 新規異動区分;
    }

    /**
     * 版番号取得パラメータを生成します。
     *
     * @param 特定個人情報名コード 特定個人情報名コード
     * @param データセット番号 データセット番号
     * @param 基準日 基準日
     *
     * @return 版番号取得のParamter
     */
    public static TokuteiKojinJohoTeikyoParamater createParamter版番号取得(RString 特定個人情報名コード,
            RString データセット番号, FlexibleDate 基準日) {
        return new TokuteiKojinJohoTeikyoParamater(特定個人情報名コード, データセット番号, 基準日, RString.EMPTY,
                ShokaiTeikyoKubun.初回提供済み.getコード(), RString.EMPTY, RString.EMPTY);
    }

    /**
     * 項目バージョン取得パラメータを生成します。
     *
     * @param 特定個人情報名コード 特定個人情報名コード
     * @param データセット番号 データセット番号
     * @param 版番号 版番号
     * @param 基準日 基準日
     *
     * @return 項目バージョン取得のParamter
     */
    public static TokuteiKojinJohoTeikyoParamater createParamter項目バージョン取得(RString 特定個人情報名コード,
            RString データセット番号, RString 版番号, FlexibleDate 基準日) {
        return new TokuteiKojinJohoTeikyoParamater(特定個人情報名コード, データセット番号, 基準日, 版番号,
                RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

}
