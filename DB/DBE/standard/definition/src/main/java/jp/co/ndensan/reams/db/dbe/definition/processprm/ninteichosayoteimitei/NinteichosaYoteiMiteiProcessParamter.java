/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosayoteimitei;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosayoteimitei.NinteichosaYoteiMiteiParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査予定未定者一覧表のバッチ処理クラスパラメータクラスです。
 *
 * @reamsid_L DBE-1390-080 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosaYoteiMiteiProcessParamter implements IBatchProcessParameter {

    private final RString 認定調査予定未定者一覧申請日From;
    private final RString 認定調査予定未定者一覧申請日To;
    private final RString 認定調査予定未定者一覧作成条件;

    /**
     * コンストラクタです。
     *
     * @param 認定調査予定未定者一覧申請日From 認定調査予定未定者一覧申請日From
     * @param 認定調査予定未定者一覧申請日To 認定調査予定未定者一覧申請日To
     * @param 認定調査予定未定者一覧作成条件 認定調査予定未定者一覧作成条件
     */
    public NinteichosaYoteiMiteiProcessParamter(RString 認定調査予定未定者一覧申請日From,
            RString 認定調査予定未定者一覧申請日To,
            RString 認定調査予定未定者一覧作成条件) {
        this.認定調査予定未定者一覧申請日From = 認定調査予定未定者一覧申請日From;
        this.認定調査予定未定者一覧申請日To = 認定調査予定未定者一覧申請日To;
        this.認定調査予定未定者一覧作成条件 = 認定調査予定未定者一覧作成条件;
    }

    /**
     * 認定調査予定未定者一覧表のMybatisパラメータークラス作成
     *
     * @return 認定調査予定未定者一覧表のMybatisパラメーターク
     */
    public NinteichosaYoteiMiteiParamter toMybitisParamter() {
        return NinteichosaYoteiMiteiParamter.createParamter(認定調査予定未定者一覧申請日From,
                認定調査予定未定者一覧申請日To,
                認定調査予定未定者一覧作成条件);
    }

}
