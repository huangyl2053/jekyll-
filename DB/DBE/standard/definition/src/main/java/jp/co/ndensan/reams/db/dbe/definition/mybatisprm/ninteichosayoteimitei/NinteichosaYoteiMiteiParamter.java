/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosayoteimitei;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査予定未定者一覧表のデータ取得パラメータクラスです。
 *
 * @reamsid_L DBE-1390-080 dongyabin
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosaYoteiMiteiParamter implements IMyBatisParameter {

    private final RString 認定調査予定未定者一覧申請日From;
    private final RString 認定調査予定未定者一覧申請日To;
    private final RString 通常;
    private final RString 延期;
    private final boolean 認定調査予定未定者一覧作成条件Flag;

    /**
     * コンストラクタです。
     *
     * @param 認定調査予定未定者一覧申請日From 認定調査予定未定者一覧申請日From
     * @param 認定調査予定未定者一覧申請日To 認定調査予定未定者一覧申請日To
     * @param 通常 処理状態区分 :通常（0）
     * @param 延期 処理状態区分 :延期（3）
     * @param 認定調査予定未定者一覧作成条件Flag 認定調査予定未定者一覧作成条件Flag
     */
    protected NinteichosaYoteiMiteiParamter(RString 認定調査予定未定者一覧申請日From,
            RString 認定調査予定未定者一覧申請日To,
            RString 通常,
            RString 延期,
            boolean 認定調査予定未定者一覧作成条件Flag) {
        this.認定調査予定未定者一覧申請日From = 認定調査予定未定者一覧申請日From;
        this.認定調査予定未定者一覧申請日To = 認定調査予定未定者一覧申請日To;
        this.通常 = 通常;
        this.延期 = 延期;
        this.認定調査予定未定者一覧作成条件Flag = 認定調査予定未定者一覧作成条件Flag;
    }

    /**
     * 認定調査予定未定者一覧表Mybatisパラメータークラス作成します。
     *
     * @param 予定未定者一覧申請日From 予定未定者一覧申請日From
     * @param 予定未定者一覧申請日To 予定未定者一覧申請日To
     * @param 認定調査予定未定者一覧作成条件 認定調査予定未定者一覧作成条件
     * @return NinteichosaYoteiMiteiParamter
     */
    public static NinteichosaYoteiMiteiParamter createParamter(RString 予定未定者一覧申請日From,
            RString 予定未定者一覧申請日To,
            RString 認定調査予定未定者一覧作成条件) {
        return new NinteichosaYoteiMiteiParamter(予定未定者一覧申請日From,
                予定未定者一覧申請日To,
                ShoriJotaiKubun.通常.getコード(),
                ShoriJotaiKubun.延期.getコード(),
                new RString("2").equals(認定調査予定未定者一覧作成条件));
    }
}
