/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinhoshunyuryoku;

import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 審査会委員報酬入力のEntityです。
 *
 * @reamsid_L DBE-9999-011 zhengsongling
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")

public class ShinsakaiIinHoshuNyuryokuEntity {

    private FlexibleDate shinsakaiIinKaishiYMD;
    private FlexibleDate shinsakaiIinShuryoYMD;
    private RString shinsakaiIinCode;
    private AtenaMeisho shinsakaiIinShimei;
    private AtenaKanaMeisho shinsakaiIinKanaShimei;
    private Code shinsakaiIinShikakuCode;
    private boolean haishiFlag;
    private int gogitaiNo;
    private RString shinsakaiKaisaiNo;
    private int remban;
    private FlexibleDate shinsakaiKaisaiYMD;
    private Code shinsakaiIinHoshuKubun;
    private int shinsakaiHoshu;
    private int shinsakaiSonotaHoshu;
    private int shinsakaiHoshuGokei;
    private int shinsakaiHoshuZeiritsu;
    private int shinsakaiKotsuhi;
    private int shinsakaiKojoZeigaku;
    private RString hoshuShiharaiMemo;
    private boolean ginkoFurikomiShutsuryokuFlag;
    private boolean shussekiFlag;
    private RString shussekiTime;
    private RString taisekiTime;
    private Code gogitaichoKubunCode;
    private RString tanka;
}
