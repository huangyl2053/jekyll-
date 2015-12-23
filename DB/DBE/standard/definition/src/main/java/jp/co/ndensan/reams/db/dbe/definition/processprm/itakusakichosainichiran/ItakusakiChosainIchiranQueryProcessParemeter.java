/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.itakusakichosainichiran;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.itakusakichosainichiran.ItakusakiChosainIchiranMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 調査委託先・調査員一覧表_バッチ処理クラスパラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ItakusakiChosainIchiranQueryProcessParemeter implements IBatchProcessParameter {

    private final RString shichosonCode;
    private final RString shichosonMeisho;
    private final RString itakusakiCodeFrom;
    private final RString itakusakiCodeTo;
    private final RString chosainNoFrom;
    private final RString chosainNoTo;
    private final RString jyoukyou;
    private final RString narabiJun;
    private final RString nextPage;

    /**
     * コンストラクタ作成です。
     *
     * @param shichosonCode 市町村コード
     * @param shichosonMeisho 市町村名
     * @param itakusakiCodeFrom 認定調査委託先コードFrom
     * @param itakusakiCodeTo 認定調査委託先コードTo
     * @param chosainNoFrom 調査員コードFrom
     * @param chosainNoTo 調査員コードTo
     * @param jyoukyou 調査員の状況判定
     * @param narabiJun 並び順
     * @param nextPage 改頁
     */
    public ItakusakiChosainIchiranQueryProcessParemeter(RString shichosonCode,
            RString shichosonMeisho,
            RString itakusakiCodeFrom,
            RString itakusakiCodeTo,
            RString chosainNoFrom,
            RString chosainNoTo,
            RString jyoukyou,
            RString narabiJun,
            RString nextPage) {
        this.chosainNoFrom = chosainNoFrom;
        this.chosainNoTo = chosainNoTo;
        this.itakusakiCodeFrom = itakusakiCodeFrom;
        this.itakusakiCodeTo = itakusakiCodeTo;
        this.jyoukyou = jyoukyou;
        this.narabiJun = narabiJun;
        this.nextPage = nextPage;
        this.shichosonCode = shichosonCode;
        this.shichosonMeisho = shichosonMeisho;

    }

    /**
     * 調査委託先・調査員一覧表のMybatisパラメータークラス作成
     *
     * @return ItakusakiChosainIchiranMybitisParamter
     */
    public ItakusakiChosainIchiranMybitisParamter toMybitisParameter() {
        return ItakusakiChosainIchiranMybitisParamter.createParam(shichosonCode,
                shichosonMeisho,
                itakusakiCodeFrom,
                itakusakiCodeTo,
                chosainNoFrom,
                chosainNoTo, jyoukyou,
                narabiJun,
                nextPage);
    }
}
