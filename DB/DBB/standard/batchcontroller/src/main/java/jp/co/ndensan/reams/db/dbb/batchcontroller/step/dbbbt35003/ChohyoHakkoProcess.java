/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt35003;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35003.ChohyoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.dbbbt35003.ChohyoHakkoEntity;
import jp.co.ndensan.reams.db.dbb.entity.dbbbt35003.OutputChohyoIchiranEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 帳票の発行クラスです。
 */
public class ChohyoHakkoProcess extends SimpleBatchProcessBase {

    ChohyoHakkoProcessParameter parameter;


    @Override
    protected void process() {
        
        ChohyoHakkoEntity chohyoHakkoEntity;
        List<OutputChohyoIchiranEntity> chohyoIchiranList = (List<OutputChohyoIchiranEntity>) parameter.get出力帳票一覧List();
        for (OutputChohyoIchiranEntity entity : chohyoIchiranList) {
            chohyoHakkoEntity = new ChohyoHakkoEntity(); 
            // TODO 画面に帳票IDがない　また　ビジネスに必要な「帳票分類ID」をセットするべき（また、ビジネスの入力に「出力対象区分」がない）
            // 一覧のデータより、繰り返しでビジネスを呼び出す？
            chohyoHakkoEntity.set調定年度(parameter.get調定年度());
            chohyoHakkoEntity.set出力対象区分(parameter.get出力対象区分());
            chohyoHakkoEntity.set発行日(parameter.get発行日());
            chohyoHakkoEntity.set帳票作成日時(parameter.get帳票作成日時());
            chohyoHakkoEntity.set出力順ID(entity.getShutsuryokujun());
            chohyoHakkoEntity.set帳票ID(entity.getChohyoName());
            // TODO DBBBZ35003_特徴平準化（特徴6月分）通知書一括発行.xlsxの「通知書の発行」メソッドを呼び出す。
        }
    }

}
