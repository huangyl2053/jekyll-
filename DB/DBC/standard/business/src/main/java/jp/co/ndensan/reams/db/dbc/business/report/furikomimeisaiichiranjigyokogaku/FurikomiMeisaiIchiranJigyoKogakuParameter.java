/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaiichiranjigyokogaku;

import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.DbWT0510FurikomiMeisaiTempEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 振込明細一覧表（事業高額）Parameterクラスです。
 *
 * @reamsid_L DBC-4870-070 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FurikomiMeisaiIchiranJigyoKogakuParameter {

    private int 連番;
    private YMDHMS システム日付;
    private DbWT0510FurikomiMeisaiTempEntity 振込明細一時;
    private RString 帳票タイトル;
    private RString 並び順１;
    private RString 並び順２;
    private RString 並び順３;
    private RString 並び順４;
    private RString 並び順５;
    private Decimal ninzu_shokei;
    private Decimal shikyu_shokei;
    private Decimal yoshien_ninzu_gokei;
    private Decimal yoshien_kingaku_gokei;
    private Decimal jigyotaisho_ninzu_gokei;
    private Decimal jigyotaisho_kingaku_gokei;
    private Decimal fumei_ninzu_gokei;
    private Decimal fumei_kingaku_gokei;
    private Decimal ninzu_gokei;
    private Decimal shikyu_gokei;

}
