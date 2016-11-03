/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050021;

import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.DbWT0510FurikomiMeisaiTempEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 口座払の口座情報取得SQL検索結果クラスです。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FurikomimeisaiDataKozaJohoEntity {

    private DbWT0510FurikomiMeisaiTempEntity 振込明細一時Entity;
    private TokuteiKozaRelateEntity 口座;
}
