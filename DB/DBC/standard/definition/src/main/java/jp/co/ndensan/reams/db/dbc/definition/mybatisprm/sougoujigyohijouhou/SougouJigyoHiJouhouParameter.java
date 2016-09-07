/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.sougoujigyohijouhou;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(総合事業費情報)のParameterです。
 *
 * @reamsid_L DBC-3107-010 wanghuafeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SougouJigyoHiJouhouParameter {

    private RString jigyoManejiKeika;
    private RString jigyoManeji;

    /**
     * コンストラクタです。
     *
     * @param jigyoManejiKeika jigyoManejiKeika
     * @param jigyoManeji jigyoManeji
     */
    protected SougouJigyoHiJouhouParameter(RString jigyoManejiKeika, RString jigyoManeji) {
        this.jigyoManejiKeika = jigyoManejiKeika;
        this.jigyoManeji = jigyoManeji;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param jigyoManejiKeika jigyoManejiKeika
     * @param jigyoManeji jigyoManeji
     * @return SoufuJouhouParameter
     */
    public static SougouJigyoHiJouhouParameter creatParameter(RString jigyoManejiKeika, RString jigyoManeji) {
        return new SougouJigyoHiJouhouParameter(jigyoManejiKeika, jigyoManeji);
    }
}
