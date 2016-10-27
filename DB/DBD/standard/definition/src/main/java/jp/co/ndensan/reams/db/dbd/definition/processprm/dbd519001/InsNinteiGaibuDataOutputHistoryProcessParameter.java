/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519001;

import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.Datakubun;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd519001.InsNinteiGaibuDataOutputHistoryMybitsParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護認定外部データ出力履歴登録_バッチ処理パラメータクラスです。
 *
 * @reamsid_L DBD-1480-020 liuyl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsNinteiGaibuDataOutputHistoryProcessParameter implements IBatchProcessParameter {

    private YMDHMS 開始日時;
    private YMDHMS 終了日時;

    /**
     * Mybatisのパラメータを作成します。
     *
     * @return InsNinteiGaibuDataOutputHistoryMybitsParameter
     */
    public InsNinteiGaibuDataOutputHistoryMybitsParameter toMybitsParameter() {
        return new InsNinteiGaibuDataOutputHistoryMybitsParameter(Datakubun.申請情報.getコード());
    }
}
