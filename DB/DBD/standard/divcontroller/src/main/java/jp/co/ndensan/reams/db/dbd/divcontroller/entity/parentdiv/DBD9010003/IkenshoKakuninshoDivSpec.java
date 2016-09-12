/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010003;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
/**
 * 主治医意見書確認書バリデーションクラスです。
 * 
 * @reamsid_L DBD-5790-010 x_zhaowen
 */
public enum IkenshoKakuninshoDivSpec implements IPredicate<IkenshoKakuninshoDiv> {
    
    発行確認チェック {
        @Override
        public boolean apply(IkenshoKakuninshoDiv div) {
            return !div.getPanelShosaiEria().getTxtDateIkensyoSakuseiBi().getText().isNullOrEmpty() ||
                    div.getPanelShosaiEria().getTxtNinteiKikan().getFromValue() != null ||
                    !div.getPanelShosaiEria().getTxtNinteiKikan().getFromValue().isBefore(
                            div.getPanelShosaiEria().getTxtNinteiKikan().getToValue()) ||
                    div.getPanelShosaiEria().getTxtNinteiKikan().getToValue() != null ||
                    !div.getPanelShosaiEria().getTxtZiritudo().getValue().isEmpty() ||
                    !div.getPanelShosaiEria().getTxtNyoushikkin().getValue().isEmpty();
        }
    }
}
