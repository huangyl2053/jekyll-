/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.karisanteiidotsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;

/**
 * 納期情報Entityクラスです。
 *
 * @reamsid_L DBB-0890-040 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsuchishoKyotsuEntity {

    private List<NokiJoho> 普徴納期情報リスト;
    private List<NokiJoho> 特徴納期情報リスト;
}
