/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd492001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd492001.RendingJieguoLianxieMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定結果連携データ取込_process処理のパラメタークラスです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RendingJieguoLianxieProcessParameter implements IBatchProcessParameter {

    private RString 取込みデータ区分;
    private RString 外部媒体格納パス;
    private List<RString> データリスト;
    private RString 保険者;

    /**
     * コンストラクタです。
     *
     * @param 取込みデータ区分 取込みデータ区分
     * @param 外部媒体格納パス 外部媒体格納パス
     * @param データリスト データリスト
     * @param 保険者 保険者
     */
    public RendingJieguoLianxieProcessParameter(RString 取込みデータ区分,
            RString 外部媒体格納パス,
            List<RString> データリスト,
            RString 保険者) {
        this.取込みデータ区分 = 取込みデータ区分;
        this.外部媒体格納パス = 外部媒体格納パス;
        this.データリスト = データリスト;
        this.保険者 = 保険者;
    }

    /**
     * ＳＱＬ使用された情報を作成します．
     *
     * @param 一時デーブル 一時デーブル
     * @return ＳＱＬ使用された情報を作成します．
     */
    public RendingJieguoLianxieMybatisParameter toRendingJieguoLianxieMybatisParameter(RString 一時デーブル) {
        return new RendingJieguoLianxieMybatisParameter(
                データリスト,
                一時デーブル);
    }

}
