/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KaigoHihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * IHihokenshaForSearchResultGridの単純実装です。
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaForSearchResult implements IHihokenshaForSearchResult {

    private final RString theHihokenshaNo;
    private final RString theShikibetsuCode;
    private final RString theHihokenshaKubun;
    private final RString theShimei;
    private final RString theKanaShimei;
    private final RString theGender;
    private final RDate theBirthDay;
    private final RString theJusho;
    private final YubinNo theYubinNo;
    private final RString theKojinNo;
    private final RString theJuminShubetsu;
    private final RString theSetaiCode;

    /**
     * 新しいインスタンスを生成します。
     *
     * @param hihokenshaNo 被保番号
     * @param shikibetsuCode 識別コード
     * @param hihokenshaKubun 被保険者区分
     * @param shimei 氏名
     * @param kanaShimei カナ氏名
     * @param gender 性別
     * @param birthDay 生年月日
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @param kojinNo 個人番号
     * @param juminShubetsu 住民種別
     * @param setaiCode 世帯コード
     */
    public HihokenshaForSearchResult(KaigoHihokenshaNo hihokenshaNo, ShikibetsuCode shikibetsuCode, RString hihokenshaKubun,
            RString shimei, RString kanaShimei, Gender gender, RDate birthDay, YubinNo yubinNo, AtenaJusho jusho,
            RString kojinNo, JuminShubetsu juminShubetsu, SetaiCode setaiCode) {

        this.theHihokenshaNo = hihokenshaNo.value();
        this.theShikibetsuCode = shikibetsuCode.value();
        this.theHihokenshaKubun = hihokenshaKubun;
        this.theShimei = shimei;
        this.theKanaShimei = kanaShimei;
        this.theGender = toRString(gender);
        this.theBirthDay = birthDay;
        this.theJusho = jusho.value();
        this.theYubinNo = yubinNo;
        this.theKojinNo = kojinNo;
        this.theJuminShubetsu = new RString(juminShubetsu.name());
        this.theSetaiCode = setaiCode.value();
    }

    private RString toRString(Gender gender) {
        switch (gender) {
            case MALE:
                return new RString("男");
            case FEMALE:
                return new RString("女");
            default:
                return new RString("その他");
        }
    }

    @Override
    public RString hihokenshaNo() {
        return this.theHihokenshaNo;
    }

    @Override
    public RString shikibetsuCode() {
        return this.theShikibetsuCode;
    }

    @Override
    public RString hihokenshaKubun() {
        return this.theHihokenshaKubun;
    }

    @Override
    public RString shimei() {
        return this.theShimei;
    }

    @Override
    public RString kanaShimei() {
        return this.theKanaShimei;
    }

    @Override
    public RString gender() {
        return this.theGender;
    }

    @Override
    public RDate birthDay() {
        return this.theBirthDay;
    }

    @Override
    public YubinNo yubinNo() {
        return this.theYubinNo;
    }

    @Override
    public RString jusho() {
        return this.theJusho;
    }

    @Override
    public RString kojinNo() {
        return this.theKojinNo;
    }

    @Override
    public RString juminShubetsu() {
        return this.theJuminShubetsu;
    }

    @Override
    public RString setaiCode() {
        return this.theSetaiCode;
    }
}
