/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashisaku;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 *
 * 被保険者資格詳細異動用の宛名情報のエンティティクラスです。
 *
 * @reamsid_L DBA-0521-020 lijia
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class HihokenshaShisakuRelateEntity {

    private LasdecCode genLasdecCode;
    private LasdecCode kyuLasdecCode;

}
