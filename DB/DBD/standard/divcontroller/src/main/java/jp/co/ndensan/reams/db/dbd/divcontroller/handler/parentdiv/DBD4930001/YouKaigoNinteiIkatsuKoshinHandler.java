/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4930001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD560001.DBD560001Parameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4930001.YouKaigoNinteiIkatsuKoshinDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定一括更新のHandlerです。
 *
 * @reamsid_L DBD-2120-010 x_liuwei
 */
public class YouKaigoNinteiIkatsuKoshinHandler {

    private final YouKaigoNinteiIkatsuKoshinDiv div;

    /**
     * コンストラクターです。
     *
     * @param div YouKaigoNinteiIkatsuKoshinDiv
     */
    public YouKaigoNinteiIkatsuKoshinHandler(YouKaigoNinteiIkatsuKoshinDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化。
     */
    public void initialize() {
        div.getTxtNinteibi().setValue(RDate.getNowDate());
        div.getTxtNinteibi().setDisabled(false);
        div.getTxtNinteibi().setPlaceHolder(RString.EMPTY);

    }

    /**
     * ラジオボタンを選択する時。
     */
    public void changeTxtNinTeiBi() {
        RString key = div.getRadSetteiHoushiki().getSelectedKey();
        if ("0".equals(key.toString())) {
            div.getTxtNinteibi().setDisabled(false);
            div.getTxtNinteibi().setValue(RDate.getNowDate());
        } else {
            div.getTxtNinteibi().setDisabled(true);
            div.getTxtNinteibi().clearValue();
        }
    }

    /**
     * 認定日パラメータを設定する。
     *
     * @return DBD560001Parameter
     */
    public DBD560001Parameter setBatchParameter() {
        DBD560001Parameter parameter = new DBD560001Parameter();
        if (div.getTxtNinteibi().isDisabled()) {
            parameter.set認定日(FlexibleDate.EMPTY);
        } else {
            parameter.set認定日(new FlexibleDate(div.getTxtNinteibi().getValue().toDateString()));
        }
        return parameter;
    }

}
