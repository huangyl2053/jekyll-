/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.lib.util.IRStringConvertable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請届出者続柄コードの列挙型です。
 *
 * @author n8223　朴義一
 */
public enum ShinseiTodokedeshaTsuzukigaraCode implements IRStringConvertable {

    /**
     * 未定義：（△）を表す列挙体です。
     * <p>
     * コードには空白（nullでない）が定義されます。</p>
     */
    未定義("", ""),
    /**
     * 本人：00を表す列挙体です。
     */
    本人("00", "本人"),
    /**
     * 世帯主：01を表す列挙体です。
     */
    世帯主("01", "世帯主"),
    /**
     * 妻：02を表す列挙体です。
     */
    妻("02", "妻"),
    /**
     * 夫：03を表す列挙体です。
     */
    夫("03", "夫"),
    /**
     * 妻_未届：04を表す列挙体です。
     */
    妻_未届("04", "妻（未届）"),
    /**
     * 夫_未届：05を表す列挙体です。
     */
    夫_未届("05", "夫（未届）"),
    /**
     * 子_男：10を表す列挙体です。
     */
    子_男("10", "子"),
    /**
     * 長男：11を表す列挙体です。
     */
    長男("11", "長男"),
    /**
     * 二男：12を表す列挙体です。
     */
    二男("12", "二男"),
    /**
     * 三男：13を表す列挙体です。
     */
    三男("13", "三男"),
    /**
     * 四男：14を表す列挙体です。
     */
    四男("14", "四男"),
    /**
     * 五男：15を表す列挙体です。
     */
    五男("15", "五男"),
    /**
     * 六男：16を表す列挙体です。
     */
    六男("16", "六男"),
    /**
     * 七男：17を表す列挙体です。
     */
    七男("17", "七男"),
    /**
     * 八男：18を表す列挙体です。
     */
    八男("18", "八男"),
    /**
     * 九男：19を表す列挙体です。
     */
    九男("19", "九男"),
    /**
     * 子_女：20を表す列挙体です。
     */
    子_女("20", "子"),
    /**
     * 長女：21を表す列挙体です。
     */
    長女("21", "長女"),
    /**
     * 二女：22を表す列挙体です。
     */
    二女("22", "二女"),
    /**
     * 三女：23を表す列挙体です。
     */
    三女("23", "三女"),
    /**
     * 四女：24を表す列挙体です。
     */
    四女("24", "四女"),
    /**
     * 五女：25を表す列挙体です。
     */
    五女("25", "五女"),
    /**
     * 六女：26を表す列挙体です。
     */
    六女("26", "六女"),
    /**
     * 七女：27を表す列挙体です。
     */
    七女("27", "七女"),
    /**
     * 八女：28を表す列挙体です。
     */
    八女("28", "八女"),
    /**
     * 九女：29を表す列挙体です。
     */
    九女("29", "九女"),
    /**
     * 父：30を表す列挙体です。
     */
    父("30", "父"),
    /**
     * 母：31を表す列挙体です。
     */
    母("31", "母"),
    /**
     * 兄：32を表す列挙体です。
     */
    兄("32", "兄"),
    /**
     * 弟：33を表す列挙体です。
     */
    弟("33", "弟"),
    /**
     * 姉：34を表す列挙体です。
     */
    姉("34", "姉"),
    /**
     * 妹：35を表す列挙体です。
     */
    妹("35", "妹"),
    /**
     * 養父：40を表す列挙体です。
     */
    養父("40", "養父"),
    /**
     * 養母：41を表す列挙体です。
     */
    養母("41", "養母"),
    /**
     * 養子：42を表す列挙体です。
     */
    養子("42", "養子"),
    /**
     * 養女：43を表す列挙体です。
     */
    養女("43", "養女"),
    /**
     * 養子_未届：44を表す列挙体です。
     */
    養子_未届("44", "養子（未届）"),
    /**
     * 養女_未届：45を表す列挙体です。
     */
    養女_未届("45", "養女（未届）"),
    /**
     * 縁故者：50を表す列挙体です。
     */
    縁故者("50", "縁故者"),
    /**
     * 同居人：60を表す列挙体です。
     */
    同居人("60", "同居人"),
    /**
     * 使用人：70を表す列挙体です。
     */
    使用人("70", "使用人"),
    /**
     * その他：99を表す列挙体です。
     */
    その他("99", "その他");
    private final RString code;
    private final RString name;

    private ShinseiTodokedeshaTsuzukigaraCode(String code, String name) {
        this.code = new RString(code);
        this.name = new RString(name);
    }

    /**
     * 列挙体に対応するコードを取得します。
     *
     * @return コード
     */
    public RString getCode() {
        return this.code;
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }

    /**
     * 列挙体に対応する表示用名称を返します。
     *
     * @return 表示用名称
     */
    public RString displayName() {
        return name;
    }

    /**
     * 引数のコードに対応する列挙体を返します。
     * <p/>
     * nullを渡された場合はnullを返します。
     *
     * @param code 検索対象のコード
     * @return コードに該当する列挙体
     * @throws IllegalArgumentException 該当する列挙体がない場合
     */
    public static ShinseiTodokedeshaTsuzukigaraCode toValue(RString code) throws IllegalArgumentException {
        if (code == null) {
            return null;
        }
        for (ShinseiTodokedeshaTsuzukigaraCode target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない
                .getMessage().replace("コードに対応する申請届出者続柄コード").evaluate());
    }

}
