/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.sogojigyohisaishinsaketteihokenshain;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業費再審査決定通知書情報取込（保険者分）の一覧表作成パラメータです。
 *
 * @reamsid_L DBC-4680-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiSaishinsaDoIchiranhyoSakuseiMyBatisParameter implements IMyBatisParameter {

    private RString 出力順;

    /**
     * コンストラクタ
     *
     * @param 出力順
     */
    public SogojigyohiSaishinsaDoIchiranhyoSakuseiMyBatisParameter(RString 出力順) {
        this.出力順 = 出力順;
    }

}
