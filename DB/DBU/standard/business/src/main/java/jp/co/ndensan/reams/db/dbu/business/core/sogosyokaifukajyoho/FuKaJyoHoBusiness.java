/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.sogosyokaifukajyoho;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 画面設計_DBU0600041_総合照会_賦課情報Business。
 *
 * @reamsid_L DBU-4100-050 houtianpeng
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FuKaJyoHoBusiness implements Serializable {

    private List<Fuka> 賦課Newest;
    private List<Fuka> 前年の賦課Newest;
    private YMDHMS 基準日時;
    private ChoshuHoho 介護徴収方法;
}
