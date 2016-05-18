/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.shikakufuseigo;

import java.io.Serializable;
import java.util.List;

/**
 * 資格不整合修正画面のBusinessクラスです。
 *
 * @reamsid_L DBB-0630-010 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuFuseigoShusei implements Serializable {

    private List<ShikakuFuseigoBusiness> businessList;

}
