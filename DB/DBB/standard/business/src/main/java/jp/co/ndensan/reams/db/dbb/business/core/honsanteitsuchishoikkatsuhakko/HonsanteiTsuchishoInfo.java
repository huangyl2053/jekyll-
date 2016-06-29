/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;

/**
 * 通知書共通情報クラスです。
 *
 * @reamsid_L DBB-0780-060 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonsanteiTsuchishoInfo {

    private List<NokiJoho> 普徴納期情報リスト;
    private List<NokiJoho> 特徴納期情報リスト;
}
