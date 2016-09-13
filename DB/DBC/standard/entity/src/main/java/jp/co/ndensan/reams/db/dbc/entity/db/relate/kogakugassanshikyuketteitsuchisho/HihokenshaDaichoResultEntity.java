/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanshikyuketteitsuchisho;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保検者情報クラスです
 *
 * @reamsid_L DBC-2300-030 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaDaichoResultEntity {

    private LasdecCode 市町村コード;
    private ShikibetsuCode 識別コード;
    private AtenaKanaMeisho kanaMeisho;
    private AtenaMeisho meisho;
    private FlexibleDate seinengappiYMD;
    private RString seibetsuCode;
    private YubinNo yubinNo;
    private ZenkokuJushoCode zenkokuJushoCode;
    private GyoseikuCode gyoseikuCode;
    private RString juminShubetsuCode;
    private AtenaJusho jusho;
}
