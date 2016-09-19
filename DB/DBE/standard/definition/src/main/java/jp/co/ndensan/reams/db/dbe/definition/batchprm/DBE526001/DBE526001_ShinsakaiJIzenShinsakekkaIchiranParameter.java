/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE526001;

import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事前審査結果一覧表_バッチフロークラスパラメータクラスです。
 *
 * @reamsid_L DBE-1640-020 zhaoyao
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBE526001_ShinsakaiJIzenShinsakekkaIchiranParameter extends BatchParameterBase {

    private static final String SHINSAKAI_KAISAI_NO = "shinsakaiKaisaiNo";

    @BatchParameter(key = SHINSAKAI_KAISAI_NO, name = "介護認定審査会開催番号")
    private RString shinsakaiKaisaiNo;

    /**
     * コンストラクタです。
     */
    public DBE526001_ShinsakaiJIzenShinsakekkaIchiranParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     */
    public DBE526001_ShinsakaiJIzenShinsakekkaIchiranParameter(RString shinsakaiKaisaiNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }

    /**
     * 事前審査結果一覧表のProcessParameterを作成します
     *
     * @return 事前審査結果一覧表のProcessParameter
     */
    public ShinsakaiJizenshinsakekkaIchiranProcessParameter toProcessParamter() {
        return new ShinsakaiJizenshinsakekkaIchiranProcessParameter(shinsakaiKaisaiNo);
    }
}
