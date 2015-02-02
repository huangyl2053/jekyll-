/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 *
 * @author N2810 久保 里史
 */
public enum ConfigKeysKokuhorenTorikomi {

    給付実績情報("111"),
    給付管理票情報("112"),
    給付実績更新結果情報("114"),
    資格照合表情報("121"),
    総合事業費資格照合表情報("122"),
    介護給付費等請求額通知書情報("151"),
    総合事業費請求額通知書情報("152"),
    介護給付費等審査決定請求明細表情報("161"),
    総合事業費審査決定請求明細表情報("162"),
    介護給付費過誤決定通知書情報("171"),
    介護給付費再審査決定通知書情報("172"),
    総合事業費過誤決定通知書情報("175"),
    償還払支給決定者一覧情報("221"),
    償還払不支給決定者一覧情報("222"),
    高額介護サービス費給付対象者一覧表情報("331"),
    高額介護サービス費支給不支給決定者一覧表情報("351"),
    高額合算自己負担額証明書情報("37H"),
    高額合算自己負担額確認情報("37J"),
    高額合算支給額計算結果連絡票情報("386"),
    高額合算支給不支給決定通知書情報("38B"),
    高額合算給付実績情報("38P"),
    受給者情報更新結果情報("533"),
    受給者台帳情報一覧("534"),
    受給者台帳突合結果情報随時("537"),
    共同処理用受給者情報更新結果("5C3"),
    共同処理用受給者情報一覧("5C4"),
    介護給付費等請求額通知書公費情報("631"),
    介護給付費公費受給者別一覧表情報("641"),
    介護給付費過誤決定通知書公費情報("651"),
    介護給付費再審査決定通知書公費情報("652"),
    請求明細給付管理票返戻保留一覧表情報("741");

    private final RString kokanShikibetsuNo;

    private ConfigKeysKokuhorenTorikomi(String kokanShikibetsuNo) {
        this.kokanShikibetsuNo = new RString(kokanShikibetsuNo);
    }

    public RString getCode() {
        return kokanShikibetsuNo;
    }

    /**
     *
     * RString型の交換識別番号をもらい、コードに対応するConfigKeysKokuhorenTorikomi型のenumを返します。
     *
     * @param kokanShikibetsuNo 交換識別番号
     * @return 引数のコードに対応するConfigKeysKokuhorenTorikomi型のenum
     */
    public static ConfigKeysKokuhorenTorikomi toValue(RString kokanShikibetsuNo) {
        for (ConfigKeysKokuhorenTorikomi data : values()) {
            if (data.getCode().equals(kokanShikibetsuNo)) {
                return data;
            }
        }
        return null;
    }
}
