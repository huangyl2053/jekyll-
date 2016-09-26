/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.DBD205010;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定結果連携データ取込MyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RendingJieguoLianxieMybatisParameter implements IMyBatisParameter {

    private List<RString> データリスト;
    private boolean is一時デーブル_日次進捗 = false;
    private boolean is一時デーブル_認定結果 = false;
    private static final RString 一時デーブル_日次進捗 = new RString("1");
    private static final RString 一時デーブル_認定結果 = new RString("2");

    /**
     * コンストラクタです。
     *
     * @param データリストList データリスト
     * @param 一時デーブル決意 一時デーブル決意
     */
    public RendingJieguoLianxieMybatisParameter(
            List<RString> データリストList,
            RString 一時デーブル決意) {
        this.データリスト = データリストList;
        一時デーブル(一時デーブル決意);
    }

    private void 一時デーブル(RString 一時デーブル決意) {
        if (一時デーブル_日次進捗.equals(一時デーブル決意)) {
            is一時デーブル_日次進捗 = true;
        } else if (一時デーブル_認定結果.equals(一時デーブル決意)) {
            is一時デーブル_認定結果 = true;
        }
    }
}
