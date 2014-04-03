/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会開始時間を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiKaishiTime extends TimeString {

    /**
     * 引数から時間を表す文字列を受け取り、インスタンスを生成します。
     *
     * @param 時間 時間を表す4桁の文字列
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException 引数が4桁の文字でないとき、引数が数字以外で構成されているとき
     */
    public ShinsakaiKaishiTime(RString 時間) throws NullPointerException, IllegalArgumentException {
        super(時間);
    }

    /**
     * 引数から時間を表す文字列を受け取り、インスタンスを生成します。
     *
     * @param 時間 時間を表す4桁の文字列
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException 引数が4桁の文字でないとき、引数が数字以外で構成されているとき
     */
    public ShinsakaiKaishiTime(String 時間) throws NullPointerException, IllegalArgumentException {
        super(時間);
    }
}
