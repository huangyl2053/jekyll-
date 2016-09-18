/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200061;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecodeichiran.ServicecodeIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicecodeichiran.ServiceBunruiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicecodeichiran.ServicecodeIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicecodeichiran.TaniSuShikibetsuEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 一覧表帳票のパラメータです。
 *
 * @reamsid_L DBC-3310-040 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceCodeIchiranParameter {

    private Association 導入団体;
    private List<TaniSuShikibetsuEntity> 単位数識別;
    private ServicecodeIchiranEntity サービスコード一覧表;
    private ServicecodeIchiranProcessParameter バッチパラメータ;
    private RDateTime 作成日時;
    private List<ServiceBunruiEntity> サービス分類略称;

}
