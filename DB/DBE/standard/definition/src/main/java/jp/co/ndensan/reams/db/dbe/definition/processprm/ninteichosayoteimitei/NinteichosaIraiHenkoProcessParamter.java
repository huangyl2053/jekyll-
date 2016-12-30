/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosayoteimitei;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosairaihenko.NinteichosaIraiHenkoMiteiParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査依頼先変更者一覧表のバッチ処理クラスパラメータクラスです。
 *
 * @reamsid_L DBE-1390-080 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosaIraiHenkoProcessParamter implements IBatchProcessParameter {

    private final RString 認定調査依頼先変更者一覧表申請日From;
    private final RString 認定調査依頼先変更者一覧表申請日To;
    private final LasdecCode 市町村コード;
    private final RString 市町村名;

    /**
     * コンストラクタです。
     *
     * @param 認定調査依頼先変更者一覧表申請日From 認定調査依頼先変更者一覧表申請日From
     * @param 認定調査依頼先変更者一覧表申請日To 認定調査依頼先変更者一覧表申請日To
     * @param 市町村コード 市町村コード
     * @param 市町村名 市町村名
     */
    public NinteichosaIraiHenkoProcessParamter(RString 認定調査依頼先変更者一覧表申請日From,
            RString 認定調査依頼先変更者一覧表申請日To,
            LasdecCode 市町村コード,
            RString 市町村名
    ) {
        this.認定調査依頼先変更者一覧表申請日From = 認定調査依頼先変更者一覧表申請日From;
        this.認定調査依頼先変更者一覧表申請日To = 認定調査依頼先変更者一覧表申請日To;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
    }

    /**
     * 認定調査予定未定者一覧表のMybatisパラメータークラス作成
     *
     * @return 認定調査予定未定者一覧表のMybatisパラメーターク
     */
    public NinteichosaIraiHenkoMiteiParamter toMybitisParamter() {
        return NinteichosaIraiHenkoMiteiParamter.createParamter(認定調査依頼先変更者一覧表申請日From,
                認定調査依頼先変更者一覧表申請日To,
                市町村コード);
    }

}
