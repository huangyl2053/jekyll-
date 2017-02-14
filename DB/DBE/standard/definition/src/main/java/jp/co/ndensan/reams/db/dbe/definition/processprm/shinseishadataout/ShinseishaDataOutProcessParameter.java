/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.shinseishadataout;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinseishadataout.ShinseishaDataOutMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請データ出力のプロセスパラメータクラスです。
 *
 * @author N3212 竹内 和紀
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class ShinseishaDataOutProcessParameter implements IBatchProcessParameter {

    private final List<RString> 申請書管理番号リスト;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号リスト 申請書管理番号リスト
     */
    public ShinseishaDataOutProcessParameter(List<RString> 申請書管理番号リスト) {
        this.申請書管理番号リスト = 申請書管理番号リスト;
    }

    /**
     * Mybatisパラメータを生成します。
     *
     * @return ShinseishaDataOutMybatisParameter
     */
    public ShinseishaDataOutMybatisParameter toMybatisParameter() {
        return new ShinseishaDataOutMybatisParameter(申請書管理番号リスト);
    }
}
