/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.tennyuhoryutokuteijushoichiran;

import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 転入保留特定住所登録のエンティティクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TennyuHoryuTokuteiJushoIchiranEntity {

    private RString kanriNo;
    private LasdecCode shichosonCode;
    private RString shichosonMeisho;
    private ChoikiCode jushoCode;
    private AtenaJusho jusho;
    private BanchiCode banchiCode1;
    private BanchiCode banchiCode2;
    private BanchiCode banchiCode3;
    private AtenaBanchi banchi;
    private RString shisetsuShurui;
    private RString shisetsuCode;
    private AtenaMeisho jigyoshaName;
}
