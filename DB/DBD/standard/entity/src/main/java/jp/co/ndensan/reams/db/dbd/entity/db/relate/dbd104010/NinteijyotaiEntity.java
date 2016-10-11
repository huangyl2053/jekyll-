/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd104010;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定状況のentityです。
 *
 * @reamsid_L DBD-3770-060 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteijyotaiEntity {

    private LasdecCode 市町村コード;

    private RString 市町村名称;

    private RString タイトル;

    private RString 印字区分;

    private Decimal sigatukensu;

    private Decimal sigatusotishakensu;

    private Decimal gogatukensu;

    private Decimal gogatusotishakensu;

    private Decimal lokugatukensu;

    private Decimal lokugatusotishakensu;

    private Decimal shichigatukensu;

    private Decimal shichigatusotishakensu;

    private Decimal hachigatukensu;

    private Decimal hachigatusotishakensu;

    private Decimal kugatukensu;

    private Decimal kugatusotishakensu;

    private Decimal jyugatukensu;

    private Decimal jyugatusotishakensu;

    private Decimal jyuichigatukensu;

    private Decimal jyuichigatusotishakensu;

    private Decimal jyunigatukensu;

    private Decimal jyunigatusotishakensu;

    private Decimal ichigatukensu;

    private Decimal ichigatusotishakensu;

    private Decimal nigatukensu;

    private Decimal nigatusotishakensu;

    private Decimal sangatukensu;

    private Decimal sangatusotishakensu;

    private Decimal 合計件数;

    private Decimal 合計措置者件数;

    private Decimal flag;
    private Decimal tableFlag;
}
