/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.idoufunriyoushyafutankanendo;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動分利用者負担割合判定（過年度）のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBC-4940-010 wangrenze
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdoufunRiyoushyafutanKanendoMybatisParameter implements IMyBatisParameter {

    private RString 処理名;
    private RString 年次判定年度;

    /**
     * コンストラクタです
     *
     * @param 処理名 RString
     * @param 年次判定年度 RString
     */
    public IdoufunRiyoushyafutanKanendoMybatisParameter(RString 処理名, RString 年次判定年度) {

        this.処理名 = 処理名;
        this.年次判定年度 = 年次判定年度;
    }
}
