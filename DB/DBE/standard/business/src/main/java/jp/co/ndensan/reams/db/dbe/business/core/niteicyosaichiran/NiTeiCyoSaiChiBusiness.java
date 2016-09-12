/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.niteicyosaichiran;

import java.io.Serializable;
import java.util.List;

/**
 *
 * 認定調査一覧Businessです。
 *
 * @reamsid_L DBE-1870-010 houtianpeng
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NiTeiCyoSaiChiBusiness implements Serializable {

    private List<NiTeiCyoSaiChiRanBusiness> 認定調査一覧Lsit;
}
