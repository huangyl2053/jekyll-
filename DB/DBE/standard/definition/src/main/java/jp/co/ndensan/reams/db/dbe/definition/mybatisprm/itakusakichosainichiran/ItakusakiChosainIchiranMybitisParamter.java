/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.itakusakichosainichiran;

import java.util.HashMap;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.JyoukyouType;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NarabiJunType;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 調査委託先・調査員一覧表のMybatisパラメータクラスです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ItakusakiChosainIchiranMybitisParamter implements IMyBatisParameter {

    private final RString shichosonCode;
    private final RString shichosonMeisho;
    private final RString itakusakiCodeFrom;
    private final RString itakusakiCodeTo;
    private final RString chosainNoFrom;
    private final RString chosainNoTo;
    private final RString jyoukyou;
    private final RString narabiJun;
    private final RString nextPage;
    private final boolean itakusakiCodeFromFlag;
    private final boolean itakusakiCodeToFlag;
    private final boolean chosainNoFromFlag;
    private final boolean chosainNoToFlag;
    private final boolean 状況_有効のみ;
    private final boolean 状況_無効のみ;
    private final boolean 状況_全て;
    private final boolean 並び順_委託先コード_調査員コード;
    private final boolean 並び順_委託先コード_調査員氏名;
    private final boolean 並び順_委託先コード_調査員カナ氏名;
    private final boolean 並び順_委託先名称_調査員コード;
    private final boolean 並び順_委託先名称_調査員氏名;
    private final boolean 並び順_委託先名称_調査員カナ氏名;

    private ItakusakiChosainIchiranMybitisParamter(RString shichosonCode,
            RString shichosonMeisho,
            RString itakusakiCodeFrom,
            RString itakusakiCodeTo,
            RString chosainNoFrom,
            RString chosainNoTo,
            RString jyoukyou,
            RString narabiJun,
            RString nextPage,
            boolean itakusakiCodeFromFlag,
            boolean itakusakiCodeToFlag,
            boolean chosainNoFromFlag,
            boolean chosainNoToFlag,
            boolean 状況_有効のみ,
            boolean 状況_無効のみ,
            boolean 状況_全て,
            boolean 並び順_委託先コード_調査員コード,
            boolean 並び順_委託先コード_調査員氏名,
            boolean 並び順_委託先コード_調査員カナ氏名,
            boolean 並び順_委託先名称_調査員コード,
            boolean 並び順_委託先名称_調査員氏名,
            boolean 並び順_委託先名称_調査員カナ氏名) {
        this.shichosonCode = shichosonCode;
        this.shichosonMeisho = shichosonMeisho;
        this.itakusakiCodeFrom = itakusakiCodeFrom;
        this.itakusakiCodeTo = itakusakiCodeTo;
        this.chosainNoFrom = chosainNoFrom;
        this.chosainNoTo = chosainNoTo;
        this.jyoukyou = jyoukyou;
        this.narabiJun = narabiJun;
        this.nextPage = nextPage;
        this.itakusakiCodeFromFlag = itakusakiCodeFromFlag;
        this.itakusakiCodeToFlag = itakusakiCodeToFlag;
        this.chosainNoFromFlag = chosainNoFromFlag;
        this.chosainNoToFlag = chosainNoToFlag;
        this.状況_有効のみ = 状況_有効のみ;
        this.状況_無効のみ = 状況_無効のみ;
        this.状況_全て = 状況_全て;
        this.並び順_委託先コード_調査員コード = 並び順_委託先コード_調査員コード;
        this.並び順_委託先コード_調査員氏名 = 並び順_委託先コード_調査員氏名;
        this.並び順_委託先コード_調査員カナ氏名 = 並び順_委託先コード_調査員カナ氏名;
        this.並び順_委託先名称_調査員コード = 並び順_委託先名称_調査員コード;
        this.並び順_委託先名称_調査員氏名 = 並び順_委託先名称_調査員氏名;
        this.並び順_委託先名称_調査員カナ氏名 = 並び順_委託先名称_調査員カナ氏名;

    }

    /**
     * Mybatisパラメータクラスです。
     *
     * @param shichosonCode 市町村コード
     * @param shichosonMeisho 市町村名
     * @param itakusakiCodeFrom 認定調査委託先コードFrom
     * @param itakusakiCodeTo 認定調査委託先コードTo
     * @param chosainNoFrom 調査員コードFrom
     * @param chosainNoTo 調査員コードTo
     * @param jyoukyou 状況
     * @param narabiJun 並び順
     * @param nextPage 改頁
     * @return ItakusakiChosainIchiranMybitisParamter 調査委託先・調査員一覧表のMybatisパラメータクラス
     */
    public static ItakusakiChosainIchiranMybitisParamter createParam(RString shichosonCode,
            RString shichosonMeisho,
            RString itakusakiCodeFrom,
            RString itakusakiCodeTo,
            RString chosainNoFrom,
            RString chosainNoTo,
            RString jyoukyou,
            RString narabiJun,
            RString nextPage) {
        boolean itakusakiCodeFromFlag = false;
        boolean itakusakiCodeToFlag = false;
        if (!itakusakiCodeFrom.isEmpty()) {
            itakusakiCodeFromFlag = true;
        }
        if (!itakusakiCodeTo.isEmpty()) {
            itakusakiCodeToFlag = true;
        }
        boolean chosainNoFromFlag = false;
        boolean chosainNoToFlag = false;
        if (!chosainNoFrom.isEmpty()) {
            chosainNoFromFlag = true;
        }
        if (!chosainNoTo.isEmpty()) {
            chosainNoToFlag = true;
        }
        boolean 状況_有効のみ = false;
        boolean 状況_無効のみ = false;
        boolean 状況_全て = false;
        if (JyoukyouType.有効のみ.code().equals(jyoukyou)) {
            状況_有効のみ = true;
        } else if (JyoukyouType.無効のみ.code().equals(jyoukyou)) {
            状況_無効のみ = true;
        } else {
            状況_全て = true;
        }
        boolean 並び順_委託先コード_調査員コード = false;
        boolean 並び順_委託先コード_調査員氏名 = false;
        boolean 並び順_委託先コード_調査員カナ氏名 = false;
        boolean 並び順_委託先名称_調査員コード = false;
        boolean 並び順_委託先名称_調査員氏名 = false;
        boolean 並び順_委託先名称_調査員カナ氏名 = false;
        if (NarabiJunType.委託先コード_調査員コード.code().equals(narabiJun)) {
            並び順_委託先コード_調査員コード = true;
        } else if (NarabiJunType.委託先コード_調査員氏名.code().equals(narabiJun)) {
            並び順_委託先コード_調査員氏名 = true;
        } else if (NarabiJunType.委託先コード_調査員カナ氏名.code().equals(narabiJun)) {
            並び順_委託先コード_調査員カナ氏名 = true;
        } else if (NarabiJunType.委託先名称_調査員コード.code().equals(narabiJun)) {
            並び順_委託先名称_調査員コード = true;
        } else if (NarabiJunType.委託先名称_調査員氏名.code().equals(narabiJun)) {
            並び順_委託先名称_調査員氏名 = true;
        } else {
            並び順_委託先名称_調査員カナ氏名 = true;
        }

        return new ItakusakiChosainIchiranMybitisParamter(shichosonCode,
                shichosonMeisho,
                itakusakiCodeFrom,
                itakusakiCodeTo,
                chosainNoFrom,
                chosainNoTo,
                jyoukyou,
                narabiJun,
                nextPage,
                itakusakiCodeFromFlag,
                itakusakiCodeToFlag,
                chosainNoFromFlag,
                chosainNoToFlag,
                状況_有効のみ,
                状況_無効のみ,
                状況_全て,
                並び順_委託先コード_調査員コード,
                並び順_委託先コード_調査員氏名,
                並び順_委託先コード_調査員カナ氏名,
                並び順_委託先名称_調査員コード,
                並び順_委託先名称_調査員氏名,
                並び順_委託先名称_調査員カナ氏名);
    }

    /**
     * パラメータをHashMapに変換して返します。
     *
     * @return MyBatis引き渡し用HashMap
     */
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> parameter = new HashMap<>();
        parameter.put("shichosonCode", this.shichosonCode);
        parameter.put("shichosonMeisho", this.shichosonMeisho);
        parameter.put("itakusakiCodeFrom", this.itakusakiCodeFrom);
        parameter.put("itakusakiCodeTo", this.itakusakiCodeTo);
        parameter.put("chosainNoFrom", this.chosainNoFrom);
        parameter.put("chosainNoTo", this.chosainNoTo);
        parameter.put("jyoukyou", this.jyoukyou);
        parameter.put("narabiJun", this.narabiJun);
        parameter.put("nextPage", this.nextPage);
        parameter.put("itakusakiCodeFromFlag", this.itakusakiCodeFromFlag);
        parameter.put("itakusakiCodeToFlag", this.itakusakiCodeToFlag);
        parameter.put("chosainNoFromFlag", this.chosainNoFromFlag);
        parameter.put("chosainNoToFlag", this.chosainNoToFlag);
        parameter.put("状況_有効のみ", this.状況_有効のみ);
        parameter.put("状況_無効のみ", this.状況_無効のみ);
        parameter.put("状況_全て", this.状況_全て);
        parameter.put("並び順_委託先コード_調査員コード", this.並び順_委託先コード_調査員コード);
        parameter.put("並び順_委託先コード_調査員氏名", this.並び順_委託先コード_調査員氏名);
        parameter.put("並び順_委託先コード_調査員カナ氏名", this.並び順_委託先コード_調査員カナ氏名);
        parameter.put("並び順_委託先名称_調査員コード", this.並び順_委託先名称_調査員コード);
        parameter.put("並び順_委託先名称_調査員氏名", this.並び順_委託先名称_調査員氏名);
        parameter.put("並び順_委託先名称_調査員カナ氏名", this.並び順_委託先名称_調査員カナ氏名);

        return parameter;
    }
}
