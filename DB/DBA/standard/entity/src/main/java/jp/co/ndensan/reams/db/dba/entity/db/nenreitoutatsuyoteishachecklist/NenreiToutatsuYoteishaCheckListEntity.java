/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.nenreitoutatsuyoteishachecklist;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 年齢到達予定者チェックリスト（List<年齢到達予定者チェックリストEntity>）。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenreiToutatsuYoteishaCheckListEntity {

    /**
     * 被保険者番号。
     */
    private HihokenshaNo hihokenshaNo;

    /**
     * 識別コード。
     */
    private ShikibetsuCode shikibetsuCode;

    /**
     * カナ氏名。
     */
    private RString kanaMeisho;

    /**
     * 氏名。
     */
    private RString meisho;

    /**
     * 性別。
     */
    private RString seibetsuCode;

    /**
     * 生年月日。
     */
    private FlexibleDate seinengappiYMD;

    /**
     * 年齢到達日。
     */
    private FlexibleDate nenreiyotainichi;

    /**
     * 資格区分。
     */
    private RString shigekubun;

    /**
     * 住特者区分。
     */
    private RString jutosyakubun;

    /**
     * 住所コード。
     */
    private RString zenkokuJushoCode;

    /**
     * 住所。
     */
    private RString jusho;

    /**
     * 行政区コード。
     */
    private RString gyoseikuCode;

    /**
     * 行政区。
     */
    private RString gyoseikuName;

    /**
     * 住民種別。
     */
    private RString juminShubetsuCode;

    /**
     * 住所地特例フラグ。
     */
    private RString jushochiTokureiFlag;

    /**
     * 市町村コード。
     */
    private RString shichosonCode;

    /**
     * 生活。
     */
    private RString seikatsu;

    /**
     * 状態。
     */
    private RString jyotei;

    /**
     * 被保険者区分コード。
     */
    private RString hihokennshaKubunCode;

}
