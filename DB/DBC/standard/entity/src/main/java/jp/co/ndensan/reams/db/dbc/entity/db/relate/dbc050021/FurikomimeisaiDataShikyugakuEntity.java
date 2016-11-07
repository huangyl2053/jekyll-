/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050021;

import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.DbWT0510FurikomiMeisaiTempEntity;

/**
 * 出力対象データ取得のentityです。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FurikomimeisaiDataShikyugakuEntity {

    private int 名寄せ件数;
    private DbWT0510FurikomiMeisaiTempEntity 振込明細一時Entity;
}
