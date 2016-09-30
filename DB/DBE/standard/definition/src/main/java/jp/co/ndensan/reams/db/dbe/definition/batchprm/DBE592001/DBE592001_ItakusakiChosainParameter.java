/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE592001;

import jp.co.ndensan.reams.db.dbe.definition.processprm.itakusakichosainichiran.ItakusakiChosainIchiranQueryProcessParemeter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 調査委託先・調査員一覧表のバッチパラメータクラスです。
 * @reamsid_L DBE-0290-030 dongyabin
 */
@Getter
@Setter
public class DBE592001_ItakusakiChosainParameter extends BatchParameterBase {

    private static final String SHICHOSON_CODE = "shichosonCode";
    private static final String SHICHOSON_MEISHO = "shichosonMeisho";
    private static final String ITAKUSAKI_CODE_FROM = "ItakusakiCodeFrom";
    private static final String ITAKUSAKI_CODE_TO = "ItakusakiCodeTo";
    private static final String CHOSAIN_NO_FROM = "chosainNoFrom";
    private static final String CHOSAIN_NO_TO = "chosainNoTo";
    private static final String JYOUKYOU = "jyoukyou";
    private static final String NARABI_JUN = "narabiJun";
    private static final String NEXT_PAGE = "nextPage";

    @BatchParameter(key = SHICHOSON_CODE, name = "市町村コード")
    private RString shichosonCode;
    @BatchParameter(key = SHICHOSON_MEISHO, name = "市町村名")
    private RString shichosonMeisho;
    @BatchParameter(key = ITAKUSAKI_CODE_FROM, name = "認定調査委託先コードFrom")
    private RString itakusakiCodeFrom;
    @BatchParameter(key = ITAKUSAKI_CODE_TO, name = "認定調査委託先コードTo")
    private RString itakusakiCodeTo;
    @BatchParameter(key = CHOSAIN_NO_FROM, name = "調査員コードFrom")
    private RString chosainNoFrom;
    @BatchParameter(key = CHOSAIN_NO_TO, name = "調査員コードTo")
    private RString chosainNoTo;
    @BatchParameter(key = JYOUKYOU, name = "状況")
    private RString jyoukyou;
    @BatchParameter(key = NARABI_JUN, name = "並び順")
    private RString narabiJun;
    @BatchParameter(key = NEXT_PAGE, name = "改頁")
    private RString nextPage;

    /**
     * 調査委託先・調査員一覧表のMybatisパラメータークラス作成
     *
     * @return ItakusakiChosainIchiranMybitisParamter
     */
    public ItakusakiChosainIchiranQueryProcessParemeter toProcessParameter() {
        return new ItakusakiChosainIchiranQueryProcessParemeter(shichosonCode,
                shichosonMeisho,
                itakusakiCodeFrom,
                itakusakiCodeTo,
                chosainNoFrom,
                chosainNoTo,
                jyoukyou,
                narabiJun,
                nextPage);
    }
}
