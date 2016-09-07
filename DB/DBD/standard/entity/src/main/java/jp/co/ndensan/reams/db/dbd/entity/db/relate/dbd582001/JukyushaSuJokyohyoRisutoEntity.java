/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd582001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijisshijokyohyo.YokaigoNinteiJisshiJokyohyoReportEntity;

/**
 * 受給状況Entityリストクラスです。
 *
 * @reamsid_L DBD-1771-020 chenxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaSuJokyohyoRisutoEntity {

    private List<YokaigoNinteiJisshiJokyohyoReportEntity> 受給状況リスト;
}
