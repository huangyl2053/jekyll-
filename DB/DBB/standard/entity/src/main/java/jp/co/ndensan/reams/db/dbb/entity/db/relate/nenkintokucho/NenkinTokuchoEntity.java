/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.nenkintokucho;

import jp.co.ndensan.reams.ue.uex.entity.db.relate.uext00010.TorikomiFileKaifuJohoTempEntity;
import jp.co.ndensan.reams.ue.uex.entity.db.relate.uext00010.TorikomiFileTrailRecordTempEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * バッチ設計_DBB241001_特徴配信データ取り込みのEntityクラスです。
 *
 * @reamsid_L DBB-4270-020 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenkinTokuchoEntity {

    private RString recordKubun;
    private RString shichosoCode;
    private RString tokuchoGimuCode;
    private RString tsuchiNaiyoCode;
    private RString yobi1;
    private RString tokuchoSeidoCode;
    private FlexibleDate sakuseiYMD;
    private RString kisoNenkinNo;
    private RString nenkinCode;
    private RString yobi2;
    private FlexibleDate seiNengappi;
    private RString seibetsu;
    private RString shimeiKana;
    private RString shimeiKanji;
    private RString jushoYubinNo;
    private RString jushoKana;
    private RString jushoKanji;
    private RString kakushuKubun;
    private RString shoriKeikka;
    private RString gokoIkanCode;
    private FlexibleDate kakushuYMD;
    private Decimal kakushuKingaku1;
    private Decimal kakushuKingaku2;
    private Decimal kakushuKingaku3;
    private RString yobi3;
    private RString kyosaiNenkinShoshoKigoBango;
    private TorikomiFileKaifuJohoTempEntity データレコードEntity;
    private TorikomiFileTrailRecordTempEntity トレイラレコードEntity;
}
