/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.taishouwaritsuke;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護認定審査会対象者申請者オブザーバーチェックパラメータクラス。
 *
 * @reamsid_L DBE-0140-010 liangbc
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class CountShinsakaiWariateIinJohoMapperParameter {

    private final boolean isKikannMade;
    private final RString kaisaiNo;
    private final RString shujiiIryokikanCode;
    private final RString ninteiChosaItakusakiCode;
    private final RString nyushoShisetsuCode;
    private final RString shujiiCode;
    private final RString ninteiChosainNo;

    /**
     * コンストラクタです。
     */
    private CountShinsakaiWariateIinJohoMapperParameter(boolean isKikannMade, RString kaisaiNo, RString shujiiIryokikanCode,
            RString ninteiChosaItakusakiCode, RString nyushoShisetsuCode, RString shujiiCode, RString ninteiChosainNo) {
        this.isKikannMade = isKikannMade;
        this.kaisaiNo = kaisaiNo;
        this.shujiiIryokikanCode = shujiiIryokikanCode;
        this.ninteiChosaItakusakiCode = ninteiChosaItakusakiCode;
        this.nyushoShisetsuCode = nyushoShisetsuCode;
        this.shujiiCode = shujiiCode;
        this.ninteiChosainNo = ninteiChosainNo;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param isKikannMade boolean
     * @param kaisaiNo RString
     * @param shujiiIryokikanCode RString
     * @param ninteiChosaItakusakiCode RString
     * @param nyushoShisetsuCode RString
     * @param shujiiCode RString
     * @param ninteiChosainNo RString
     * @return 介護認定審査会対象者候補者一覧エリア内容検索パラメータ
     */
    public static CountShinsakaiWariateIinJohoMapperParameter createCountKohoshaIchiranMapperParameter(boolean isKikannMade, RString kaisaiNo,
            RString shujiiIryokikanCode, RString ninteiChosaItakusakiCode, RString nyushoShisetsuCode, RString shujiiCode, RString ninteiChosainNo) {
        return new CountShinsakaiWariateIinJohoMapperParameter(
                isKikannMade, kaisaiNo, shujiiIryokikanCode, ninteiChosaItakusakiCode, nyushoShisetsuCode, shujiiCode, ninteiChosainNo);
    }
}
