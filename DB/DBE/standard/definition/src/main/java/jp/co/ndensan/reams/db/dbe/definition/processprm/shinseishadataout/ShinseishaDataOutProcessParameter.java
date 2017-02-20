/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.shinseishadataout;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinseikensaku.ShinseiKensakuMapperParameter;
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

    private final boolean 検索実行;
    private final ShinseiKensakuMapperParameter 検索条件;
    private final List<RString> 申請書管理番号リスト;

    /**
     * コンストラクタです。
     *
     * @param 検索実行 検索実行
     * @param 検索条件 検索条件
     * @param 申請書管理番号リスト 申請書管理番号リスト
     */
    public ShinseishaDataOutProcessParameter(boolean 検索実行,
            ShinseiKensakuMapperParameter 検索条件,
            List<RString> 申請書管理番号リスト) {
        this.検索実行 = 検索実行;
        this.検索条件 = 検索条件;
        this.申請書管理番号リスト = 申請書管理番号リスト;
    }

    /**
     * Mybatisパラメータを生成します。
     *
     * @return ShinseishaDataOutMybatisParameter
     */
    public ShinseishaDataOutMybatisParameter toMybatisParameter() {
        return new ShinseishaDataOutMybatisParameter(検索実行, 申請書管理番号リスト);
    }
}
