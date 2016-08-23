/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.jizenshinsakekka;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 事前審査結果登録データ作成Mybatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1630-020 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class JizenShinsakekkaMybatisParameter implements IMyBatisParameter {

    private final RString shinsakaiKaisaiNo;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     */
    protected JizenShinsakekkaMybatisParameter(RString shinsakaiKaisaiNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }

    /**
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @return JIzenShinsakekkaMybatisParameter
     */
    public static JizenShinsakekkaMybatisParameter createParam(RString shinsakaiKaisaiNo) {
        return new JizenShinsakekkaMybatisParameter(shinsakaiKaisaiNo);
    }

}
