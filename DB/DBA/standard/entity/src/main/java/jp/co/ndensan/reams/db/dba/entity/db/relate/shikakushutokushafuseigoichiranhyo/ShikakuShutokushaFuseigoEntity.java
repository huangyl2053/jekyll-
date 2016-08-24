/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.shikakushutokushafuseigoichiranhyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格取得者不整合リストEntityクラスです。
 *
 * @reamsid_L DBU-4020-030 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuShutokushaFuseigoEntity {

    private HihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private LasdecCode shichosonCode;
    private RString hihokennshaKubunCode;
    private RString jushochiTokureiFlag;
    private AtenaKanaMeisho kanaMeisho;
    private AtenaMeisho meisho;
    private FlexibleDate seinengappiYMD;
    private AtenaJusho tennyumaeJusho;
    private AtenaBanchi tennyumaeBanchi;
    private Katagaki tennyumaeKatagaki;
    private AtenaJusho jusho;
    private AtenaBanchi banchi;
    private Katagaki katagaki;
    private RString 不整合情報;

}
