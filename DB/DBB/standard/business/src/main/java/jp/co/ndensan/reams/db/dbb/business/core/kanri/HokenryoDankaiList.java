/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kanri;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 保険料段階リストクラスです。
 *
 * @reamsid_L DBB-9020-120 sunhaidi
 */
public class HokenryoDankaiList {

    private final List<HokenryoDankai> dankaiList;

    /**
     * コンストラクタです。
     *
     * @param hokenryoDankaiList 保険料段階リスト
     */
    public HokenryoDankaiList(List<HokenryoDankai> hokenryoDankaiList) {
        this.dankaiList = hokenryoDankaiList;
    }

    /**
     * パラメータの保険料段階区分に該当する保険料段階のインスタンスを返します。
     *
     * @param 段階区分 段階区分
     * @return 保険料段階
     * @throws IllegalArgumentException 保険料段階を取得しないときIllegalArgumetExceptionを投げる
     */
    public HokenryoDankai getBy段階区分(RString 段階区分) {

        for (HokenryoDankai hokenryoDankai : dankaiList) {
            if (段階区分.equals(hokenryoDankai.get段階区分())) {
                return hokenryoDankai;
            }
        }
        throw new IllegalArgumentException(new RStringBuilder()
                .append("段階区分:")
                .append(段階区分 == null ? "null" : 段階区分.isEmpty() ? "''" : 段階区分)
                .append(" に該当する保険料段階は存在しません。")
                .toString());
    }

    /**
     * パラメータのランク区分に該当する保険料段階のインスタンスを返します。
     *
     * @param ランク区分 ランク区分
     * @return 保険料段階
     * @throws IllegalArgumentException 保険料段階を取得しないときIllegalArgumetExceptionを投げる
     */
    public HokenryoDankai getByランク区分(RString ランク区分) {

        for (HokenryoDankai hokenryoDankai : dankaiList) {
            if (ランク区分.equals(hokenryoDankai.getランク区分())) {
                return hokenryoDankai;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * パラメータの段階インデックスに該当する保険料段階のインスタンスを返します。
     *
     * @param 段階Index 段階Index
     * @return 保険料段階
     * @throws IllegalArgumentException 保険料段階を取得しないときIllegalArgumetExceptionを投げる
     */
    public HokenryoDankai getBy段階Index(RString 段階Index) {

        for (HokenryoDankai hokenryoDankai : dankaiList) {
            if (段階Index.equals(hokenryoDankai.get段階Index())) {
                return hokenryoDankai;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * すべての要素を表記の文字列へ変換したListを生成し返します。
     *
     * @return 表記List
     */
    public List<RString> to表記List() {
        List<RString> 表記List = new ArrayList<>();
        for (HokenryoDankai hokenryoDankai : dankaiList) {
            表記List.add(hokenryoDankai.get表記());
        }
        return 表記List;
    }

    /**
     * 保険料段階リストを取得します。
     *
     * @return 保険料段階リスト
     */
    public List<HokenryoDankai> asList() {
        return this.dankaiList;
    }
}
