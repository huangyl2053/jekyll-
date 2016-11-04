/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050021;

import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.DbWT0510FurikomiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給取得状況データ取得_Process処理のentityです。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FurikomimeisaiDataJukyushaEntity {

    private DbT4001JukyushaDaichoEntity 受給者台帳entity;
    private DbT5101NinteiShinseiJohoEntity 要介護認定申請情報entity;
    private DbWT0510FurikomiMeisaiTempEntity 振込明細一時Entity;
}
