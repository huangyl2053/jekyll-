/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ichijipanteisyori;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;

/**
 * 画面設計_DBE3010001_一次判定処理クラスです。
 *
 * @reamsid_L DBE-1470-010 houtianpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IchijiHanteiKekkaJohoBusiness implements Serializable {

    private List<IchijiHanteiKekkaJoho> 要介護認定一次判定結果情報Lsit;
}
