/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinseishadataout;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請データ出力のMybatisパラメータクラスです。
 *
 * @author N3212 竹内 和紀
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class ShinseishaDataOutMybatisParameter implements IMyBatisParameter {

    private final List<RString> 申請書管理番号リスト;
    private final RString 申請書管理番号;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号リスト 申請書管理番号リスト
     */
    public ShinseishaDataOutMybatisParameter(List<RString> 申請書管理番号リスト) {
        this.申請書管理番号リスト = 申請書管理番号リスト;
        this.申請書管理番号 = RString.EMPTY;
    }

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public ShinseishaDataOutMybatisParameter(RString 申請書管理番号) {
        this.申請書管理番号リスト = new ArrayList<>();
        this.申請書管理番号 = 申請書管理番号;
    }
}
