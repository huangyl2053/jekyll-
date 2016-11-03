/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050021;

import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.DbWT0510FurikomiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 振込明細・振込みデータ作成の事業高額データEntityです。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaToAtenaResultEntity {

    private DbT1001HihokenshaDaichoEntity 被保険者台帳;
    private DbWT0510FurikomiMeisaiTempEntity 振込明細一時Entity;
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
}
