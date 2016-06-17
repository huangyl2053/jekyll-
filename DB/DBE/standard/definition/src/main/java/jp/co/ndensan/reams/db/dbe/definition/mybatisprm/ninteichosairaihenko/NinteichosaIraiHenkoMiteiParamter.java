/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosairaihenko;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査依頼先変更者一覧表のデータ取得パラメータクラスです。
 *
 * @reamsid_L DBE-1390-080 dongyabin
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosaIraiHenkoMiteiParamter implements IMyBatisParameter {

    private final RString 認定調査依頼先変更者一覧表申請日From;
    private final RString 認定調査依頼先変更者一覧表申請日To;
    private final RString 通常;
    private final RString 延期;

    /**
     * コンストラクタです。
     *
     * @param 認定調査依頼先変更者一覧表申請日From 認定調査依頼先変更者一覧表申請日From
     * @param 認定調査依頼先変更者一覧表申請日To 認定調査依頼先変更者一覧表申請日To
     * @param 通常 処理状態区分 :通常（0）
     * @param 延期 処理状態区分 :延期（3）
     */
    protected NinteichosaIraiHenkoMiteiParamter(RString 認定調査依頼先変更者一覧表申請日From,
            RString 認定調査依頼先変更者一覧表申請日To,
            RString 通常,
            RString 延期) {
        this.認定調査依頼先変更者一覧表申請日From = 認定調査依頼先変更者一覧表申請日From;
        this.認定調査依頼先変更者一覧表申請日To = 認定調査依頼先変更者一覧表申請日To;
        this.通常 = 通常;
        this.延期 = 延期;
    }

    /**
     * 認定調査依頼先変更者一覧表Mybatisパラメータークラス作成します。
     *
     * @param 予定未定者一覧申請日From 予定未定者一覧申請日From
     * @param 予定未定者一覧申請日To 予定未定者一覧申請日To
     * @return NinteichosaYoteiMiteiParamter
     */
    public static NinteichosaIraiHenkoMiteiParamter createParamter(RString 予定未定者一覧申請日From,
            RString 予定未定者一覧申請日To) {
        return new NinteichosaIraiHenkoMiteiParamter(予定未定者一覧申請日From,
                予定未定者一覧申請日To,
                ShoriJotaiKubun.通常.getコード(),
                ShoriJotaiKubun.延期.getコード());
    }
}
