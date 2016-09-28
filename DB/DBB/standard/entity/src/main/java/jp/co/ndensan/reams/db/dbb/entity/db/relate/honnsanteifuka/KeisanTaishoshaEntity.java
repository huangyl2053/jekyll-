/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 計算対象者抽出・通知書番号発番のEntityのクラスです。
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KeisanTaishoshaEntity {

    private DbT2002FukaEntity 賦課の情報;
    private DbT1001HihokenshaDaichoEntity 資格の情報;
}
