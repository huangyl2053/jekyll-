/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichousasukejuru;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査スケジュール登録1を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public final class NinteiChousaSukejuruParameter {

    private final RString ninteiChosaYotei;
    private final RString chosaChikuCode;
    private final RString tukihajimeDAY;
    private final RString getumatuDAY;

    /**
     * コンストラクタです。
     *
     * @param 年月 年月
     * @param 対象地区 対象地区
     * @param 年月の月初日付 年月の月初日付
     * @param 年月の月末日付 年月の月末日付
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private NinteiChousaSukejuruParameter(
            RString ninteiChosaYotei,
            RString chosaChikuCode,
            RString tukihajimeDAY,
            RString getumatuDAY) {
        this.ninteiChosaYotei = ninteiChosaYotei;
        this.chosaChikuCode = chosaChikuCode;
        this.tukihajimeDAY = tukihajimeDAY;
        this.getumatuDAY = getumatuDAY;
    }

    /**
     * 画面で入力した設定のパラメータを生成します。
     *
     * @param ninteiChosaYotei 年月
     * @param chosaChikuCode 対象地区
     * @param tukihajimeDAY 年月の月初日付
     * @param getumatuDAY 年月の月末日付
     * @return 画面で入力した設定パラメータ
     */
    public static NinteiChousaSukejuruParameter createGamenParam(
            RString ninteiChosaYotei,
            RString chosaChikuCode,
            RString tukihajimeDAY,
            RString getumatuDAY) {
        return new NinteiChousaSukejuruParameter(ninteiChosaYotei, chosaChikuCode, tukihajimeDAY, getumatuDAY);
    }
}
